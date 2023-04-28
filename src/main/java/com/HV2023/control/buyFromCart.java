package com.HV2023.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HV2023.dao.DAO;
import com.HV2023.entity.account;

@WebServlet(urlPatterns = { "/buyFromCart" })
public class buyFromCart extends HttpServlet {
	static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		account acc = (account) session.getAttribute("account");
		int uID = acc.getuID();
		DAO dao = new DAO();
		try {
			dao.buyFromCart(uID);
			resp.sendRedirect("cart");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
