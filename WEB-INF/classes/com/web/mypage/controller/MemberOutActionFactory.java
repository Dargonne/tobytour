package com.web.mypage.controller;

import com.web.mypage.controller.action.MemberOutAction;
import com.web.mypage.controller.action.MemberOutCheckFormAction;
import com.web.mypage.controller.action.MemberOutCompleteAction;
import com.web.mypage.controller.action.MemberOutProcAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class MemberOutActionFactory {
	private static MemberOutActionFactory instance = new MemberOutActionFactory();
	
	private MemberOutActionFactory(){
		super(); 
	}
	
	public static MemberOutActionFactory getInstance(){
		return instance; 
	}
	
	public MemberOutAction getAction(String command) {
		MemberOutAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("member_out_form")){
			action = new MemberOutCheckFormAction();
		} else if(command.equals("member_out_complete")){
			action = new MemberOutCompleteAction();
		} else if(command.equals("member_out_action")){
			action = new MemberOutProcAction(); 
		}
		
		return action;
	}
}
