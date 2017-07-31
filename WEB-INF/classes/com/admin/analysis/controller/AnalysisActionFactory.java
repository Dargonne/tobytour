package com.admin.analysis.controller;

import com.admin.analysis.controller.action.AnalysisAction;
import com.admin.analysis.controller.action.NewMemberListAction;
import com.admin.analysis.controller.action.SalesListAction;
import com.admin.analysis.controller.action.VisitCounterAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class AnalysisActionFactory {
	private static AnalysisActionFactory instance = new AnalysisActionFactory();
	
	private AnalysisActionFactory(){
		super(); 
	}
	
	public static AnalysisActionFactory getInstance(){
		return instance; 
	}
	
	public AnalysisAction getAction(String command) {
		AnalysisAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("analysis_new_member")){
			action = new NewMemberListAction(); 
		} else if(command.equals("analysis_counter")){
			action = new VisitCounterAction(); 
		} else if(command.equals("analysis_sales")){
			action = new SalesListAction();
		} 
		
		return action;
	}
}
