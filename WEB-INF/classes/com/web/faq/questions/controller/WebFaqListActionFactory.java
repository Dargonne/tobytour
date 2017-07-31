package com.web.faq.questions.controller;

import com.web.faq.questions.controller.action.WebFaqListAction;
import com.web.faq.questions.controller.action.WebQuestionListAction;

public class WebFaqListActionFactory {
	
	private static WebFaqListActionFactory instance = new WebFaqListActionFactory(); 
	
	private WebFaqListActionFactory(){
		super(); 
	}
	
	public static WebFaqListActionFactory getInstance(){
		return instance; 
	}
	
	public WebFaqListAction getAction(String command){
		WebFaqListAction action = null; 
		
		if(command.equals("faq_list")){
			action = new WebQuestionListAction(); 
		}
		
		return action;
	}
}
