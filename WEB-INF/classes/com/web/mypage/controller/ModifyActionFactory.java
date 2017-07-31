package com.web.mypage.controller;

import com.web.mypage.controller.action.ModifyCheckAction;
import com.web.mypage.controller.action.ModifyMainAction;
import com.web.mypage.controller.action.ModifyUpdateAction;
import com.web.mypage.controller.action.ModifyUpdatePassAction;
import com.web.mypage.controller.action.MypageAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class ModifyActionFactory {
	private static ModifyActionFactory instance = new ModifyActionFactory();
	
	private ModifyActionFactory(){
		super(); 
	}
	
	public static ModifyActionFactory getInstance(){
		return instance; 
	}
	
	public MypageAction getAction(String command) {
		MypageAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("modify_main")){
			action = new ModifyMainAction();
		}else if(command.equals("modify_check")){
			action = new ModifyCheckAction();
		}else if(command.equals("modify_update")){
			action = new ModifyUpdateAction();
		}else if(command.equals("modify_update_pass")){
			action = new ModifyUpdatePassAction();
		}
		return action;
	}
}
