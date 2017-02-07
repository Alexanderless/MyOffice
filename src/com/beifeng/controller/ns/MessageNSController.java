package com.beifeng.controller.ns;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.hr.IBranchInfoBiz;
import com.beifeng.biz.hr.IDepartInfoBiz;
import com.beifeng.biz.hr.IUserInfoBiz;
import com.beifeng.biz.ns.IMessageBiz;
import com.beifeng.biz.ns.IMessageToUserBiz;
import com.beifeng.model.BranchInfo;
import com.beifeng.model.DepartInfo;
import com.beifeng.model.Email;
import com.beifeng.model.Message;
import com.beifeng.model.MessageAndUser;
import com.beifeng.model.PageMessage;
import com.beifeng.model.UserInfo;

@Controller
public class MessageNSController {
	@Autowired
	private IMessageBiz iMessageBiz;
	@Autowired
	private IMessageToUserBiz iMessageToUserBiz;
	@Autowired
	private IBranchInfoBiz iBranchInfoBiz;
	@Autowired
	private IDepartInfoBiz iDepartInfoBiz;
	@Autowired
	private IUserInfoBiz iUserInfoBiz;
	/*
	 * 全部信息分页显示
	 */
	@RequestMapping("queryPageMessage")
	public ModelAndView queryPageMessage(PageMessage pageMessage){
		if(pageMessage.getCurrentPage()<1)
			pageMessage.setCurrentPage(1);
		PageMessage pm = iMessageBiz.queryPageMessage(pageMessage);
		ModelAndView ma = new ModelAndView("ns/Message");
		ma.addObject("pm", pm);
		return ma;
	}
	
	/*
	 * 检索查询
	 */
	@RequestMapping("querySeaMessage")
	public ModelAndView querySeaMessage(PageMessage pageMessage){
		if(pageMessage.getCurrentPage()<1)
			pageMessage.setCurrentPage(1);
		PageMessage pm = iMessageBiz.querySeaMessage(pageMessage);
		ModelAndView ma = new ModelAndView("ns/Message");
		ma.addObject("pm", pm);
		return ma;
	}
	/*
	 * 添加message跳转页面
	 */
	@RequestMapping("addMsgURL")
	public ModelAndView addMsgURL(){
		List<BranchInfo> list = iBranchInfoBiz.queryBranchInfo();
		ModelAndView ma = new ModelAndView("ns/addMessage");
		ma.addObject("list", list);
		return ma;		
	}
	
	/*
	 * 部门联动get Ajax
	 */
	@RequestMapping("queryDepartById")
	@ResponseBody
	public List<DepartInfo> queryDepartById(Integer branchId){
		List<DepartInfo> list = iDepartInfoBiz.queryDepartById(branchId);
		return list;
	}
	/*
	 * 
	 */
	@RequestMapping("queryUserInfoByDeparId")
	@ResponseBody
	public List<UserInfo> queryUserInfoByDeparId(Integer id){
		List<UserInfo> list = iUserInfoBiz.findUserByDepartId(id);
		return list;
	}
	/*
	 * 修改跳转页面
	 */
	@RequestMapping("updataMsgURL")
	public ModelAndView updataMsgURL(Integer id){
		Message message = iMessageBiz.queryMsgById(id);
		ModelAndView ma = new ModelAndView("ns/updataMsg");
		ma.addObject("message", message);
		return ma;
	}
	
	/*
	 * 修改message
	 */
	@RequestMapping("updataMsg")
	public String updataMsg(Message message){
		iMessageBiz.updataMsg(message);
		return "redirect:queryPageMessage.do";
	}
	
	/*
	 * 删除
	 */
	@RequestMapping("delMessage")
	public String delMessage(Integer id){
		iMessageToUserBiz.delMessagetouser(id);
		iMessageBiz.delMessage(id);
		return "forward:queryPageMessage.do";
	}
	
	/*
	 * 获取数据
	 */
	@RequestMapping("getAllCount")
	public ModelAndView getAllCount(){
		Integer id = 1001;
		Email email = iMessageBiz.getEamil(id);
		ModelAndView ma = new ModelAndView("ns/email");
		ma.addObject("email", email);
		return ma;
	}
	/*
	 * 收件箱信息
	 */
	@RequestMapping("InboxInfo")
	public ModelAndView InboxInfo(){
		Integer id = 1001;
		List<MessageAndUser> list = iMessageBiz.getInbox(id);
		ModelAndView ma = new ModelAndView("ns/InboxInfo");
		ma.addObject("list", list);
		return ma;
	}
	/*
	 *发件箱信息
	 */
	@RequestMapping("send")
	public ModelAndView send(){
		Integer id = 1001;
		List<MessageAndUser> list = iMessageBiz.getSend(id);
		ModelAndView ma = new ModelAndView("ns/send");
		ma.addObject("list", list);
		return ma;
	}
	/*
	 *发布
	 */
	@RequestMapping("ifPublish")
	public String ifPublish(Integer id){
		iMessageBiz.ifPublish(id);
		return "forward:queryPageMessage.do";
	}
	/*
	 *假删除
	 */
	@RequestMapping("del")
	public String del(String ids){
		String[] id = ids.split(",");
		List list = new ArrayList();
		for(int i=0;i<id.length;i++){
			list.add(id[i]);
		}
		iMessageBiz.del(list);
		return "forward:InboxInfo.do";
	}
	
	/*
	 *假删除发件箱
	 */
	@RequestMapping("delSend")
	public String delSend(String ids){
		System.out.println(ids);
		String[] id = ids.split(",");
		List list = new ArrayList();
		for(int i=0;i<id.length;i++){
			list.add(id[i]);
		}
		iMessageBiz.del(list);
		return "forward:send.do";
	}
}