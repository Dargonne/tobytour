package com.admin.faq.controller;

import com.admin.faq.controller.action.RequestAction;
import com.admin.faq.controller.action.RequestListAction;
import com.admin.faq.controller.action.RequestUpdateAction;
import com.admin.faq.controller.action.RequestUpdateFormAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class RequestActionFactory {
	private static RequestActionFactory instance = new RequestActionFactory();
	
	private RequestActionFactory(){
		super(); 
	}
	
	public static RequestActionFactory getInstance(){
		return instance; 
	}
	
	public RequestAction getAction(String command) {
		RequestAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("request_list")){
			action = new RequestListAction(); 
		} else if(command.equals("request_update_form")){
			action = new RequestUpdateFormAction();
		} else if(command.equals("request_update")){
			action = new RequestUpdateAction();
		} 
		
		return action;
	}
}
