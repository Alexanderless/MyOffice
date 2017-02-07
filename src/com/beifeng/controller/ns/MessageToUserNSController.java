package com.beifeng.controller.ns;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.ns.IMessageToUserBiz;
import com.beifeng.model.MessageToUser;

@Controller
public class MessageToUserNSController {
	
	@Autowired
	private IMessageToUserBiz iMessageToUserBiz;
	
	@RequestMapping("ifRead")
	public String ifRead(Integer id){
		iMessageToUserBiz.updateIfread(id);
		return "forward:InboxInfo.do";
	}
}
