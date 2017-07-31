package com.web.main.controller;

import com.web.main.controller.action.WebMainAction;
import com.web.main.controller.action.WebMainViewAction;

public class WebMainActionFactory {
	private static WebMainActionFactory instance = new WebMainActionFactory(); 
	
	private WebMainActionFactory(){
		super(); 
	}
	
	public static WebMainActionFactory getInstance(){
		return instance; 
	}
	
	public WebMainAction getAction(String command){
		WebMainAction action = null; 
		
		if(command.equals("main_page")){
			action = new WebMainViewAction();
		}
		
		return action; 
	}
}
