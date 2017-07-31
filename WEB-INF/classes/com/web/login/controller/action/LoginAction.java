package com.web.login.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
