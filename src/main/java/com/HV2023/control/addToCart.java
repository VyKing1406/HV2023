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

@WebServlet(urlPatterns = { "/addToCart" })
public class addToCart extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		account acc = (account) (req.getSession()).getAttribute("account");
		int uID = acc.getuID();
		int pID = Integer.parseInt(req.getParameter("pID"));
		DAO dao = new DAO();
		try {
			int codeCart = dao.checkP(uID, pID);
			dao.addToCart(uID, pID, codeCart);
			resp.sendRedirect("home");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
