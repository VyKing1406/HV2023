package com.HV2023.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HV2023.dao.DAO;
import com.HV2023.entity.account;

@WebServlet(urlPatterns = { "/signUp" })
public class signUpControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/views/signUp/signUp.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		String rePassWord = req.getParameter("rePassWord");
		DAO dao = new DAO();
		if(!passWord.equals(rePassWord)) {
			resp.sendRedirect("signUp");
		}
		else {
			try {
				if(dao.checkExist(userName)) {  //bằng 1 tức là đã có tk rồi
					resp.sendRedirect("signUp");
				}
				else {
					dao.signUp(userName, passWord);
					resp.sendRedirect("signIn");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
