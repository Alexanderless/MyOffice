package com.beifeng.controller.dom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beifeng.biz.dom.IFileTypeInfoBiz;
import com.beifeng.model.FileTypeInfo;

@Controller
public class FileTypeInfoController {
	@Autowired
	private IFileTypeInfoBiz iFileTypeInfoBiz;
	
	/*
	 * 查询全部的文件类型
	 */
	@RequestMapping("queryFileTypeInfo")
	@ResponseBody
	public List<FileTypeInfo> queryFileTypeInfo() {
		List<FileTypeInfo> list1=new ArrayList<FileTypeInfo>();
		List<FileTypeInfo> list=iFileTypeInfoBiz.queryFileTypeInfo();
		for (FileTypeInfo fileTypeInfo : list) {
			if(fileTypeInfo.getFileTypeId()!=1){
				list1.add(fileTypeInfo);
			}
		}
		return list1;
	}

}
