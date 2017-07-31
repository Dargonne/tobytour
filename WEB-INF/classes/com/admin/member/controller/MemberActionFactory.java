package com.admin.member.controller;

import com.admin.member.controller.action.MemberAction;
import com.admin.member.controller.action.MemberAdminUpdateAction;
import com.admin.member.controller.action.MemberDeleteAction;
import com.admin.member.controller.action.MemberListAction;
import com.admin.member.controller.action.MemberViewAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class MemberActionFactory {
	private static MemberActionFactory instance = new MemberActionFactory();
	
	private MemberActionFactory(){
		super(); 
	}
	
	public static MemberActionFactory getInstance(){
		return instance; 
	}
	
	public MemberAction getAction(String command) {
		MemberAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("member_list")){
			action = new MemberListAction(); 
		}  else if(command.equals("member_view")){
			action = new MemberViewAction();
		} else if(command.equals("member_delete")){
			action = new MemberDeleteAction();
		} else if(command.equals("member_info_change")){
			action = new MemberAdminUpdateAction();
		} 
		
		return action;
	}

}
