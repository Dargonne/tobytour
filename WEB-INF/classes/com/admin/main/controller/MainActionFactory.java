package com.admin.main.controller;

import com.admin.main.controller.action.*;

// Command로 요청받은 자료가 필요하여 작성함. 
public class MainActionFactory {
	private static MainActionFactory instance = new MainActionFactory();
	
	private MainActionFactory(){
		super(); 
	}
	
	public static MainActionFactory getInstance(){
		return instance; 
	}
	
	public MainAction getAction(String command) {
		MainAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("main_page")){
			action = new MainPageAction();
		}else if(command.equals("updateMemo")){
			action = new UpdateMemoAction();
		}else if(command.equals("todaySchedule")){
			action = new TodayScheduleAction();
		}else if(command.equals("addDaySchedule")){
			action = new AddDayScheduleAction();
		}else if(command.equals("viewSchedule")){
			action = new ViewScheduleAction();
		}else if(command.equals("schedule_delete")){
			action = new DeleteScheduleAction();
		}else if(command.equals("schedule_update_form")){
			action = new UpdateScheduleFormAction();
		}else if(command.equals("schedule_update")){
			action = new UpdateScheduleAction();
		}
		return action;
	}
}
