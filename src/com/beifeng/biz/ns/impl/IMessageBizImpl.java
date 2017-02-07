package com.beifeng.biz.ns.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.ns.IMessageBiz;
import com.beifeng.dao.ns.IMessageDao;
import com.beifeng.dao.ns.IMessageToUserDao;
import com.beifeng.model.Email;
import com.beifeng.model.Message;
import com.beifeng.model.MessageAndUser;
import com.beifeng.model.MessageToUser;
import com.beifeng.model.PageMessage;
@Service
public class IMessageBizImpl implements IMessageBiz {
	@Autowired
	private IMessageDao iMessageDao;
	@Autowired
	private IMessageToUserDao iMessageToUserDao;
	
	/*
	 * 查询所有(non-Javadoc)
	 * @see com.beifeng.biz.ns.IMessageBiz#queryMessage()
	 */
	@Override
	public List<MessageAndUser> queryMessage(PageMessage pageMessage) {
		List<Message> list = iMessageDao.queryMessage(pageMessage);
		List<MessageAndUser> Malist = new ArrayList();
		int id = 0;
		for(int i=0;i<list.size();i++){
			MessageAndUser ma =  new MessageAndUser();
			Message message = list.get(i);
			String content = message.getContent();
			message.setAllContent(content);
			if(content.length()>7){
				content = content.substring(0, 6);
				message.setContent(content+"...");
			}
			ma.setMessage(message);
			id = message.getMessageId();
			MessageToUser mt = iMessageToUserDao.queryMessageToUser(id);
			String userName = mt.getUserInfo().getUserName();
			ma.setToUser(userName);
			Malist.add(ma);
		}
		return Malist;
	}
	
	/*
	 * 分页显示全部
	 */
	@Override
	public PageMessage queryPageMessage(PageMessage pageMessage) {
		List<Message> list = iMessageDao.queryPageMessage(pageMessage);
		List<MessageAndUser> Malist = new ArrayList();
		int id = 0;
		for(int i=0;i<list.size();i++){
			MessageAndUser ma =  new MessageAndUser();
			Message message = list.get(i);
			String content = message.getContent();
			message.setAllContent(content);
			if(content.length()>7){
				content = content.substring(0, 6);
				message.setContent(content+"...");
			}
			ma.setMessage(message);
			id = message.getMessageId();
			MessageToUser mt = iMessageToUserDao.queryMessageToUser(id);
			String userName = mt.getUserInfo().getUserName();
			ma.setToUser(userName);
			Malist.add(ma);
		}
		PageMessage pm = new PageMessage();
		pm.setList(Malist);
		pm.setCurrentPage(pageMessage.getCurrentPage());
		List<Message> msgList = iMessageDao.queryMessage(pageMessage);
		pm.setTotalRecords(msgList.size());
		return pm;
	}
	/*
	 * 检索查询
	 */
	@Override
	public PageMessage querySeaMessage(PageMessage pageMessage) {
		List<Message> list = iMessageDao.querySeaMessage(pageMessage);
		List<MessageAndUser> Malist = new ArrayList();
		int id = 0;
		for(int i=0;i<list.size();i++){
			MessageAndUser ma =  new MessageAndUser();
			Message message = list.get(i);
			String content = message.getContent();
			message.setAllContent(content);
			if(content.length()>7){
				content = content.substring(0, 6);
				message.setContent(content+"...");
			}
			ma.setMessage(message);
			id = message.getMessageId();
			MessageToUser mt = iMessageToUserDao.queryMessageToUser(id);
			String userName = mt.getUserInfo().getUserName();
			ma.setToUser(userName);
			Malist.add(ma);
		}
		PageMessage pm = new PageMessage();
		pm.setList(Malist);
		pm.setCurrentPage(pageMessage.getCurrentPage());
		pm.setBeginTime(pageMessage.getBeginTime());
		pm.setEndTime(pageMessage.getEndTime());
		List<Message> msgList = iMessageDao.queryMessage(pageMessage);
		pm.setTotalRecords(msgList.size());
		return pm;
	}
	/*
	 * 通过id找message
	 */
	@Override
	public Message queryMsgById(Integer id) {
		Message message = iMessageDao.queryMsgById(id);
		return message;
	}
	/*
	 *修改message
	 */
	@Override
	public void updataMsg(Message message) {
		iMessageDao.updataMsg(message);
	}
	
	/*
	 * 删除
	 */	
	@Override
	public void delMessage(Integer id) {
		iMessageDao.delMessage(id);		
	}
	
	/*
	 * 收件箱多少条
	 */	
	@Override
	public List<Message> queryInboxCount(Integer id) {
		List<Message> list = iMessageDao.queryInboxCount(id);
		return list;
	}

	/*
	 * 收件箱未读多少条
	 */	
	@Override
	public List<Message> queryUnread(Integer id) {
		List<Message> list = iMessageDao.queryUnread(id);
		return list;
	}

	/*
	 * 已发送
	 */	
	@Override
	public List<Message> send(Integer id) {
		List<Message> list = iMessageDao.send(id);
		return list;
	}
	
	/*
	 * 获取数据
	 */
	@Override
	public Email getEamil(Integer id) {
		List<Message> listIC = iMessageDao.queryInboxCount(id);
		List<Message> listUD = iMessageDao.queryUnread(id);
		List<Message> listSend = iMessageDao.send(id);
		Email email = new Email();
		email.setInboxCount(listIC.size());
		email.setUnread(listUD.size());
		email.setSend(listSend.size());
		return email;
	}
	
	/*
	 * 获取收件箱数据
	 */
	@Override
	public List<MessageAndUser> getInbox(Integer id) {
		List<MessageAndUser> listMa = new ArrayList();
		List<Message> list = iMessageDao.queryInboxCount(id);
		for (Message message : list) {
			Integer MsgId = message.getMessageId();
			MessageToUser messageToUser = iMessageToUserDao.queryMessageToUser(MsgId);
			String ifRead = messageToUser.getIfRead();
			MessageAndUser messageAndUser = new MessageAndUser();
			messageAndUser.setIfRead(ifRead);
			messageAndUser.setMessage(message);
			listMa.add(messageAndUser);
		}
		return listMa;
	}
	
	/*
	 * 获取发送信息
	 */
	@Override
	public List<MessageAndUser> getSend(Integer id) {
		List<MessageAndUser> listMa = new ArrayList();
		List<Message> list = iMessageDao.send(id);
		for (Message message : list) {
			Integer MsgId = message.getMessageId();
			MessageToUser mt = iMessageToUserDao.queryMessageToUser(MsgId);
			String name = mt.getUserInfo().getUserName();
			MessageAndUser ma = new MessageAndUser();
			ma.setToUser(name);
			ma.setMessage(message);
			listMa.add(ma);
		}
		return listMa;
	}
	/*
	 * 发布
	 */
	@Override
	public void ifPublish(Integer id) {
		iMessageDao.ifPublish(id);	
	}
	
	/*
	 * 假删除收件箱
	 */
	@Override
	public void del(List list) {
		iMessageDao.del(list);
	}
	
}
