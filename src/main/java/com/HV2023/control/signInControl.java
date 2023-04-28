package com.HV2023.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HV2023.dao.DAO;
import com.HV2023.entity.account;

@WebServlet(urlPatterns = { "/signIn" })
public class signInControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/views/signIn/signIn.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		DAO dao = new DAO();
		account acc = null;
		RequestDispatcher dis = null;
		try {
			acc = (account) dao.login(userName, passWord);
			if (acc == null) {
				dis = req.getRequestDispatcher("/views/signIn/signIn.jsp");
				dis.forward(req, resp);
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("account", acc);
				session.setMaxInactiveInterval(43200);
				resp.sendRedirect("home");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
