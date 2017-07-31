package com.web.mypage.controller;

import com.web.mypage.controller.action.WebRequestAction;
import com.web.mypage.controller.action.WebRequestDeleteAction;
import com.web.mypage.controller.action.WebRequestListAction;
import com.web.mypage.controller.action.WebRequestViewAction;
import com.web.mypage.controller.action.WebRequestWriteAction;
import com.web.mypage.controller.action.WebRequestWriteFormAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class WebRequestActionFactory {
	private static WebRequestActionFactory instance = new WebRequestActionFactory();
	
	private WebRequestActionFactory(){
		super(); 
	}
	
	public static WebRequestActionFactory getInstance(){
		return instance; 
	}
	
	public WebRequestAction getAction(String command) {
		WebRequestAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("request_list")){
			action = new WebRequestListAction(); 
		} else if(command.equals("request_write_form")){
			action = new WebRequestWriteFormAction(); 
		} else if(command.equals("request_write_action")){
			action = new WebRequestWriteAction();
		} else if(command.equals("request_delete_action")){
			action = new WebRequestDeleteAction();
		} else if(command.equals("request_view")){
			action = new WebRequestViewAction();
		}
		
		return action;
	}
}
