package com.beifeng.controller.sm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.sm.ILoginlogBiz;
import com.beifeng.model.Loginlog;
import com.beifeng.model.Time;

@Controller
@RequestMapping("sm/")
public class LoginlogController {
	@Autowired
	private ILoginlogBiz iLoginlogBiz;
	
	@RequestMapping("search")
	public ModelAndView search(Time time) {
		List<Loginlog> list=iLoginlogBiz.query(time);
		ModelAndView mv=new ModelAndView("sm/GridView");
		if(list.size()==0){
			String msg="нч";
			mv.addObject("msg", msg);
		}
		else{
		mv.addObject("list", list);
		}
		return mv;
		
	}
	
	@RequestMapping("dele")
	public String dele(String ids) {
		String[] id=ids.split(",");
		int i=id.length;
		int[] a=new int[i];
		System.out.println(id);
		for (int j = 0; j < id.length; j++) {
			a[j]=Integer.parseInt(id[j]);
		}
		iLoginlogBiz.delete(a);	
		return "redirect:../sm/GridView.jsp";
	}

}
