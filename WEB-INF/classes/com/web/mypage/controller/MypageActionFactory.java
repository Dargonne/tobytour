package com.web.mypage.controller;

import com.web.mypage.controller.action.CancelReservationAction;
import com.web.mypage.controller.action.DeleteBasketAction;
import com.web.mypage.controller.action.MypageAction;
import com.web.mypage.controller.action.MypageFormAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class MypageActionFactory {
	private static MypageActionFactory instance = new MypageActionFactory();
	
	private MypageActionFactory(){
		super(); 
	}
	
	public static MypageActionFactory getInstance(){
		return instance; 
	}
	
	public MypageAction getAction(String command) {
		MypageAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("mypage_form")){
			action = new MypageFormAction();
		}else if(command.equals("delete_basket")){
			action = new DeleteBasketAction();
		}else if(command.equals("cancel_reservation")){
			action = new CancelReservationAction();
		}
		return action;
	}
}
