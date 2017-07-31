package com.admin.faq.controller;

import com.admin.faq.controller.action.NoticeAction;
import com.admin.faq.controller.action.NoticeDeleteAction;
import com.admin.faq.controller.action.NoticeListAction;
import com.admin.faq.controller.action.NoticeUpdateAction;
import com.admin.faq.controller.action.NoticeUpdateFormAction;
import com.admin.faq.controller.action.NoticeViewAction;
import com.admin.faq.controller.action.NoticeWriteAction;
import com.admin.faq.controller.action.NoticeWriteFormAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class NoticeActionFactory {
	private static NoticeActionFactory instance = new NoticeActionFactory();
	
	private NoticeActionFactory(){
		super(); 
	}
	
	public static NoticeActionFactory getInstance(){
		return instance; 
	}
	
	public NoticeAction getAction(String command) {
		NoticeAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("notice_list")){
			action = new NoticeListAction(); 
		} else if(command.equals("notice_write_form")){
			action = new NoticeWriteFormAction(); 
		} else if(command.equals("notice_write")){
			action = new NoticeWriteAction(); 
		} else if(command.equals("notice_view")){
			action = new NoticeViewAction(); 
		} else if(command.equals("notice_update_form")){
			action = new NoticeUpdateFormAction();
		} else if(command.equals("notice_update")){
			action = new NoticeUpdateAction();
		} else if(command.equals("notice_delete")){
			action = new NoticeDeleteAction();
		}
		
		return action;
	}
}
