package com.web.register.controller;

import com.web.register.controller.action.RegisterAction;
import com.web.register.controller.action.RegisterAddAction;
import com.web.register.controller.action.RegisterFormAction;

public class RegisterActionFactory {
	private static RegisterActionFactory instance = new RegisterActionFactory(); 
	
	private RegisterActionFactory(){
		super(); 
	}
	
	public static RegisterActionFactory getInstance(){
		return instance; 
	}
	
	public RegisterAction getAction(String command){
		RegisterAction action = null; 
		
		if(command.equals("register_form")){
			action = new RegisterFormAction(); 
		} else if(command.equals("register_insert")){
			action = new RegisterAddAction(); 
		} else if(command.equals("register_action")){
			action = new RegisterAddAction(); 
		} 
		
		return action; 
	}
	
	
}
