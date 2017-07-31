package com.web.faq.notice.controller;

import com.web.faq.notice.controller.action.WebNoticeAction;
import com.web.faq.notice.controller.action.WebNoticeListAction;
import com.web.faq.notice.controller.action.WebNoticeViewAction;

public class WebNoticeActionFactory {
	
	private static WebNoticeActionFactory instance = new WebNoticeActionFactory();
	
	private WebNoticeActionFactory(){
		super(); 
	}
	
	public static WebNoticeActionFactory getInstance(){
		return instance; 
	}
	
	public WebNoticeAction getAction(String command){
		WebNoticeAction action = null; 
		
		if(command.equals("notice_list")){
			action = new WebNoticeListAction(); 
		} else if(command.equals("notice_view")){
			action = new WebNoticeViewAction();
		}
		
		return action; 
	}
}
