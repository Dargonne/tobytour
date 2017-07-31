package com.admin.order.controller;

import com.admin.order.controller.action.OrderAction;
//import com.admin.order.controller.action.OrderCancelAction;
//import com.admin.order.controller.action.OrderDeleteAction;
import com.admin.order.controller.action.OrderListAction;
import com.admin.order.controller.action.OrderPaymentChangeAction;
//import com.admin.order.controller.action.OrderPaymentChangeAction;
import com.admin.order.controller.action.OrderViewAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class OrderActionFactory {
	private static OrderActionFactory instance = new OrderActionFactory();
	
	private OrderActionFactory(){
		super(); 
	}
	
	public static OrderActionFactory getInstance(){
		return instance; 
	}
	
	public OrderAction getAction(String command) {
		OrderAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("order_list")){
			action = new OrderListAction(); 
		} else if(command.equals("order_view")){
			action = new OrderViewAction(); 
		} else if(command.equals("order_payment_change")){
			action = new OrderPaymentChangeAction();
		}
		
		return action;
	}

}
