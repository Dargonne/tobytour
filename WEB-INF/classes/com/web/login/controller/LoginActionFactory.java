package com.web.login.controller;

import com.web.login.controller.action.LoginAction;
import com.web.login.controller.action.LoginFormAction;
import com.web.login.controller.action.LoginSubmitAction;
import com.web.login.controller.action.LogoutAction;
import com.web.login.controller.action.SearchFormAction;
import com.web.login.controller.action.SearchIdAction;
import com.web.login.controller.action.SearchPassAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class LoginActionFactory {
	private static LoginActionFactory instance = new LoginActionFactory();
	
	private LoginActionFactory(){
		super(); 
	}
	
	public static LoginActionFactory getInstance(){
		return instance; 
	}
	
	public LoginAction getAction(String command) {
		LoginAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("login_form")){
			action = new LoginFormAction();
		}else if(command.equals("login_submit")){
			action = new LoginSubmitAction();
		}else if(command.equals("searchForm")){
			action = new SearchFormAction();
		}else if(command.equals("search_id")){
			action = new SearchIdAction();
		}else if(command.equals("search_pass")){
			action = new SearchPassAction();
		}else if(command.equals("logout")){
			action = new LogoutAction();
		}
		return action;
	}
}
