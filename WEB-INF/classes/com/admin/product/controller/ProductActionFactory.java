package com.admin.product.controller;

import com.admin.product.controller.action.ProductAction;
import com.admin.product.controller.action.ProductAddAction;
import com.admin.product.controller.action.ProductAddFinish;
import com.admin.product.controller.action.ProductListAction;
import com.admin.product.controller.action.ProductMainDeleteAction;
import com.admin.product.controller.action.ProductMainViewAction;
import com.admin.product.controller.action.ProductSubChangeAction;
import com.admin.product.controller.action.ProductSubDeleteAction;
import com.admin.product.controller.action.ProductSubViewFormAction;
import com.admin.product.controller.action.ProductSubWriteAction;
import com.admin.product.controller.action.ProductSubWriteFormAction;

// Command로 요청받은 자료가 필요하여 작성함. 
public class ProductActionFactory {
	private static ProductActionFactory instance = new ProductActionFactory();
	
	private ProductActionFactory(){
		super(); 
	}
	
	public static ProductActionFactory getInstance(){
		return instance; 
	}
	
	public ProductAction getAction(String command) {
	     ProductAction action = null; 
		
		//추가할 내용 - 처리할 action class들의 요청을 command로 받아 넘겨주는 작업을 수행한다. 
		if(command.equals("product_list")){
			action = new ProductListAction(); 
		} else if(command.equals("product_add")){
			action = new ProductAddAction();
		} else if(command.equals("finish_add")){
			action = new ProductAddFinish();
		} else if(command.equals("product_main_view")){
			action = new ProductMainViewAction(); 
		} else if(command.equals("product_main_delete")){
			action = new ProductMainDeleteAction();
		} else if(command.equals("product_sub_view")){
			action = new ProductSubViewFormAction(); 
		} else if(command.equals("product_sub_delete")){
			action = new ProductSubDeleteAction(); 
		} else if(command.equals("product_sub_change")){
			action = new ProductSubChangeAction(); 
		}  else if(command.equals("product_sub_write")){
			action = new ProductSubWriteFormAction(); 
		} else if(command.equals("product_sub_insert")){
			action = new ProductSubWriteAction(); 
		} 
		
		return action;
	}
}
