package com.beifeng.controller.sm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.sm.IOperateLogBiz;
import com.beifeng.model.OperateLog;
import com.beifeng.model.Time;

@Controller
@RequestMapping("sm/")
public class OperateLogController {
	@Autowired
	private IOperateLogBiz iOperateLogBiz;
	
	@RequestMapping("searchOpe")
	public ModelAndView searchOpe(Time time) {
		// TODO Auto-generated method stub
		List<OperateLog> list=iOperateLogBiz.searchOpe(time);
		System.out.println(list);
		ModelAndView mv=new ModelAndView("sm/operate");
		if(list.size()==0){
			String msg="нч";
			mv.addObject("msg", msg);
		}
		else{
		mv.addObject("list", list);
		}
		return mv;
	}
	@RequestMapping("delop")
	public String delop(String ids) {
		String[] id=ids.split(",");
		int i=id.length;
		int[] a=new int[i];
		for (int j = 0; j < id.length; j++) {
			a[j]=Integer.parseInt(id[j]);
		}
		iOperateLogBiz.delete(a);	
		return "redirect:../sm/operate.jsp";
	}

}
