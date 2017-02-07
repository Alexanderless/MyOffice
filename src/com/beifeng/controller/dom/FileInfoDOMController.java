package com.beifeng.controller.dom;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.dom.IFileInfoBiz;
import com.beifeng.model.AccessoryFile;
import com.beifeng.model.FileInfo;
import com.beifeng.model.FileTreeNode;
import com.beifeng.model.FileTypeInfo;
import com.beifeng.model.PageUtil;
@Controller
public class FileInfoDOMController {
	@Autowired
	private IFileInfoBiz iFileInfoBiz;
	//��ѯ�ļ���Ϣ
	
	
	/*
	 * ����WEB-INF��FileTree.jspҳ��
	 */
	@RequestMapping("dom/fileTree")
	public ModelAndView fileTree(){
		ModelAndView mv=new ModelAndView("dom/FileTree");
		return mv;
	}
	
	@RequestMapping("dom/query")
	public ModelAndView query(){
		List<FileInfo> list=iFileInfoBiz.query();
		ModelAndView mv=new ModelAndView("dom/FileManage");
		mv.addObject("list", list);
		return mv;
	}
	/*
	 * ���εݹ�
	 */
	
	@RequestMapping("dom/tree.do")
	@ResponseBody
	public List<FileTreeNode> tree(HttpServletRequest request,HttpServletResponse response){
		List<FileTreeNode> list=iFileInfoBiz.generateTreeNode();
		return list;		
	}
	
	
	/*
	 * ��ѯĳһ�ļ����µ��������ļ�
	 */
	@RequestMapping("queryBypid.do")
	@ResponseBody
	public ModelAndView queryBypid(HttpServletRequest request,HttpServletResponse response){
		String parseInt=request.getParameter("id");	
		if(parseInt.startsWith("t")){
			parseInt=parseInt.substring(9);		
		}
		int pid=Integer.parseInt(parseInt);
		//��ѯfileIdΪpid���ļ�
		FileInfo file=iFileInfoBiz.queryByfileId(pid);		
		ModelAndView mv=new ModelAndView("dom/FileMain");
		List<FileInfo> list= iFileInfoBiz.queryBypid(pid);
		if(list.size()==0){
			list=null;
		}
		mv.addObject("pid", pid);
		mv.addObject("file", file);
		mv.addObject("list", list);
		return mv;
	}
	
	/*
	 * �鿴����վ�е������ļ�
	 */
	@RequestMapping("queryRecycle.do")
	public ModelAndView queryRecycle(HttpServletRequest request,HttpServletResponse response) {
		List<FileInfo> list=iFileInfoBiz.queryRecycle();
		if(list.size()==0){
			list=null;
		}
		request.setAttribute("list", list);
		ModelAndView mv=new ModelAndView("dom/recycle");
		return mv;
		
	}
	
	
	
	/*
	 * �޸��ļ���״̬��ɾ��
	 */
	@RequestMapping("update")
	public String update(Integer ifDelete,Integer fileId,Integer id){
		iFileInfoBiz.update(ifDelete, fileId);
		return "forward:queryBypid.do?id="+id;
	}
	
	/*
	 * �޸��ļ���״̬:��ԭ
	 */
	@RequestMapping("restore")
	public String restore(Integer ifDelete,Integer fileId){
		iFileInfoBiz.update(ifDelete, fileId);
		return "redirect:queryRecycle.do";
	}	
	
	/*
	 * �����ļ�
	 */
	@RequestMapping("search")
	public ModelAndView search(FileInfo fileInfo, PageUtil pageUtil){
		if (pageUtil == null){
			pageUtil = new PageUtil();
		}
		
		if(fileInfo.getFileName()==""){
			fileInfo.setFileName(null);
		}
		if(fileInfo.getFileOwner()==""){
			fileInfo.setFileOwner(null);
		}
		List<FileInfo> list=iFileInfoBiz.search(fileInfo,pageUtil);
		if(list.size()==0){
			list=null;
		}
		ModelAndView mv=new ModelAndView("dom/GridView");
		mv.addObject("list", list);
		mv.addObject("pageSize", pageUtil.getPageSize());
		int total=iFileInfoBiz.count();
		int count=total/pageUtil.getPageCount()+1;//��ҳ��
		mv.addObject("count",count);
		return mv;
	}
	
	/*
	 * ΪfileId���ļ�������ļ�
	 */
	@RequestMapping("addFileIn")
	public String addFileIn(HttpServletRequest req,FileInfo fileInfo,Integer fileTypeId) throws FileNotFoundException{
		fileInfo.setCreateDate(new Date());
		iFileInfoBiz.addFileIn(fileInfo);
		
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		if (file != null) {
			AccessoryFile accessoryFile=new AccessoryFile();
			accessoryFile.setFileId(fileInfo.getFileId());
			accessoryFile.setAccessoryPath(fileInfo.getFilePath());
			accessoryFile.setCreateDate(new Date());
			String path = req.getSession().getServletContext().getRealPath("/");// ��ȡ��ʵ·��
			String filename = file.getOriginalFilename();// ��ȡ�ļ���
			accessoryFile.setAccessoryName(filename);
			//��ȡ�ļ���׺��
			String s = filename.substring(filename.lastIndexOf('.'),filename.length());
			//�����ļ������Ϣ��accessoryfile
			List<FileTypeInfo> list=iFileInfoBiz.queryFileTypeInfo();
			for (FileTypeInfo fileTypeInfo : list) {
				if(s.equals(fileTypeInfo.getFileTypeSuffix())){
					accessoryFile.setFileTypeInfo(fileTypeInfo);
				}
			}	
			File fi=new File(path +fileInfo.getFilePath());
			if(!fi.exists()){
				fi.mkdirs();
			}
			File f=new File(path +fileInfo.getFilePath()+"/"+filename);
			FileOutputStream os=new FileOutputStream(f);
			accessoryFile.setAccessorySize((int)f.length());
			iFileInfoBiz.addAcessory(accessoryFile);
			try {
				os.write(file.getBytes());
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	
		return "redirect:queryBypid.do?id="+fileInfo.getParentId();
	}
	/*
	 * ��ѯ�ļ�ΪfileId���ļ����丽����Ϣ
	 */
	@RequestMapping("queryByfileId")
	public ModelAndView queryByfileId(Integer fileId){
		
		FileInfo fileInfo=iFileInfoBiz.queryByfileId(fileId);
		List<AccessoryFile> list=iFileInfoBiz.queryByFiledid(fileId);
		if(fileInfo.getFileTypeInfo().getFileTypeId()!=1){
			ModelAndView mv=new ModelAndView("dom/FileInfo");
			mv.addObject("fileInfo", fileInfo);
			if(list.size()==0){
				list=null;
			}
			mv.addObject("list", list);
			return mv;
		}else{
			ModelAndView mv=new ModelAndView("dom/File");
			mv.addObject("fileInfo", fileInfo);
			return mv;
		}
		
	}
	
	
	/*
	 * ��ѯ�ļ�ΪfileId���ļ����丽����Ϣ
	 */
	@RequestMapping("document")
	public ModelAndView document(Integer fileId){
		
		FileInfo fileInfo=iFileInfoBiz.queryByfileId(fileId);
		ModelAndView mv=new ModelAndView("dom/document");
		mv.addObject("fileInfo", fileInfo);
		return mv;
	
	}
	
	/*
	 * �����ļ������Լ��ϴ�����
	 */
	@RequestMapping("updateFileIn")
	public String updateFileIn(HttpServletRequest req,FileInfo entity) throws FileNotFoundException{

		iFileInfoBiz.updateFileIn(entity);

		// �����ݱ���ɹ�֮�� ���渽��

		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		if (file != null) {
			AccessoryFile accessoryFile=new AccessoryFile();
			accessoryFile.setFileId(entity.getFileId());
			accessoryFile.setAccessoryPath(entity.getFilePath());
			accessoryFile.setCreateDate(new Date());
			String path = req.getSession().getServletContext().getRealPath("/");// ��ȡ��ʵ·��
			String filename = file.getOriginalFilename();// ��ȡ�ļ���
			accessoryFile.setAccessoryName(filename);
			//��ȡ�ļ���׺��
			String s = filename.substring(filename.lastIndexOf('.'),filename.length());
			//�����ļ������Ϣ��accessoryfile
			List<FileTypeInfo> list=iFileInfoBiz.queryFileTypeInfo();
			for (FileTypeInfo fileTypeInfo : list) {
				if(s.equals(fileTypeInfo.getFileTypeSuffix())){
					accessoryFile.setFileTypeInfo(fileTypeInfo);
				}
			}	
			File fi=new File(path +entity.getFilePath());
			if(!fi.exists()){
				fi.mkdirs();
			}
			File f=new File(path +entity.getFilePath()+"/"+filename);
			FileOutputStream os=new FileOutputStream(f);
			accessoryFile.setAccessorySize((int)f.length());
			iFileInfoBiz.addAcessory(accessoryFile);
			try {
				os.write(file.getBytes());
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
		return "redirect:queryByfileId.do?fileId="+entity.getFileId();
	}
	
	/**
	 * ɾ��������Ϣ
	 */
	@RequestMapping("deleteAccessoryFile")
	public String deleteAccessoryFile(Integer accessoryId,Integer fileId){
		iFileInfoBiz.deleteAccessoryFile(accessoryId);
		
		return "redirect:queryByfileId.do?fileId="+fileId;
	}
	
	/**
	 * ���ظ���
	 */
	@RequestMapping("uploadAccessoryFile")
	public void uploadAccessoryFile(HttpServletRequest request,HttpServletResponse response){
		String path = request.getParameter("path");
		String filename =request.getParameter("accessoryName");
		// ��ȡ��վ����·��(ͨ��ServletContext����)������ȷ�������ļ�λ�ã��Ӷ�ʵ������
		String realpath = request.getSession().getServletContext().getRealPath("/");
		// 1.�����ļ�ContentType���ͣ��������ã����Զ��ж������ļ�����
		response.setContentType("multipart/form-data");
		// 2.�����ļ�ͷ�����һ�����������������ļ���(�������ǽ�a.pdf)
		response.setHeader("Content-Disposition", "attachment;fileName="+ filename);

		OutputStream out;
		// ͨ���ļ�·�����File����(�����·������һ��download.pdf�ļ�)
		File file = new File(realpath + path);
		try {
			FileInputStream inputStream = new FileInputStream(file);

			// 3.ͨ��response��ȡServletOutputStream����(out)
			out = response.getOutputStream();

			int b = 0;
			byte[] buffer = new byte[512];
			while ((b = inputStream.read(buffer)) > 0)
				out.write(buffer, 0, b);
			// 4.д�������(out)��

			inputStream.close();

			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
