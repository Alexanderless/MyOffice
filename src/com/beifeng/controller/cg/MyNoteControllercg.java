package com.beifeng.controller.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.cg.IMyNoteBizcg;
import com.beifeng.model.MyNote;

@Controller
@RequestMapping("/")
public class MyNoteControllercg {
	
	@Autowired
	private IMyNoteBizcg iMyNoteBiz;
	/**
	 * @Author candy
	 * @return ModeAndView
	 * 查询创建者的便签
	 * @param String createUser
	*/
	
	@RequestMapping("queryMyNoteList")
	public ModelAndView queryMyNoteList(String userId){
		System.out.println(userId);
		List<MyNote> list=iMyNoteBiz.queryMyNoteList(userId);
		ModelAndView mv=new ModelAndView("cg/mynote");
		mv.addObject("list", list);
		return mv;
		
	}
	
	/**
	 * @Author candy
	 * @return ModeAndView
	 * 跳转到添加页面
	 * @param String createUser 
	*/
	@RequestMapping("goAddMyNote")
	public ModelAndView goAddMyNote(String createUser){
		ModelAndView mv=new ModelAndView("cg/addmynote");
		mv.addObject("createUser", createUser);
		return mv;
	}
	
	
	/**
	 * @Author candy
	 * @return ModeAndView
	 * 添加创建者的便签
	 * @param String createUser 
	*/
	@RequestMapping("addMyNote")
	 public String addMyNote(MyNote myNote){
			System.out.println(myNote);
		 iMyNoteBiz.addMyNote(myNote);
		 return "redirect:queryMyNoteList.do?userId="+myNote.getUserInfo().getUserId(); 
	 }
		
		/**
		 * @Author candy
		 * @return ModeAndView
		 * 删除便签
		 * @param Integer noteId
		*/	
		@RequestMapping("delMyNote")
		public String delMyNote(Integer noteId, String userId){
			iMyNoteBiz.delMyNote(noteId);
		/*	ModelAndView mv=new ModelAndView("cg/index");*/
		  return "redirect:queryMyNoteList.do?userId="+userId; 
		}
}
