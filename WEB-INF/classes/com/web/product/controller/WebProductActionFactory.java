package com.web.product.controller;

import com.web.product.controller.action.BasketAddAction;
import com.web.product.controller.action.ProductAction;
import com.web.product.controller.action.ProductListAction;
import com.web.product.controller.action.ProductListViewAction;
import com.web.product.controller.action.ProductPurchaseAction;
import com.web.product.controller.action.ProductSuccessAction;
import com.web.product.controller.action.PurchaseConfirmAction;
import com.web.product.controller.action.PurchaseProcAction;

public class WebProductActionFactory {

	 private static WebProductActionFactory instance = new WebProductActionFactory();
	 
	 private WebProductActionFactory(){
		 super();
	 }
	 
	 public static WebProductActionFactory getInstance(){
		 return instance;
}
	 public ProductAction getAction(String command){
		 ProductAction action =null;
		 
		 if(command.equals("product_list")){
			 action = new ProductListAction();
		 }else if(command.equals("product_view")){
			 action = new ProductListViewAction();
		 }else if(command.equals("product_purchase")){
			 action = new ProductPurchaseAction();
		 }else if(command.equals("product_success")){
			 action = new ProductSuccessAction();
		 }else if(command.equals("add_basket")){
			 action = new BasketAddAction(); 
		 }else if(command.equals("purchase_confirm")){
			 action = new PurchaseConfirmAction(); 
		 }else if(command.equals("purchase_proc")){
			 action = new PurchaseProcAction(); 
		 }
		 
		return action;
	 }
		 
}