package com.admin.login.controller;

import com.admin.login.controller.action.LoginAction;
import com.admin.login.controller.action.LoginFailAction;
import com.admin.login.controller.action.LoginFormAction;
import com.admin.login.controller.action.LoginSuccessAction;
import com.admin.login.controller.action.LoginTryAction;
import com.admin.login.controller.action.LogoutAction;
import com.admin.login.controller.action.LogoutSuccessAction;

public class LoginActionFactory {
	private static LoginActionFactory instance = new LoginActionFactory(); 
	
	private LoginActionFactory(){
		super(); 
	}
	
	public static LoginActionFactory getInstance(){
		return instance; 
	}
	
	public LoginAction getAction(String command){
		LoginAction action = null; 
		if(command.equals("login_form")){
			action = new LoginFormAction(); 
		} else if(command.equals("login_validate")){
			action = new LoginTryAction(); 
		} else if(command.equals("login_success")){
			action = new LoginSuccessAction(); 
		} else if(command.equals("login_fail")){
			action = new LoginFailAction();
		} else if(command.equals("logout_action")){
			action = new LogoutAction(); 
		} else if(command.equals("logout_success")){
			action = new LogoutSuccessAction();
		}
		
		return action; 
	}
	
	
}
