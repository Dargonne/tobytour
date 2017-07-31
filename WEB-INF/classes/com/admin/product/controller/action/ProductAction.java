package com.admin.product.controller.action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}


