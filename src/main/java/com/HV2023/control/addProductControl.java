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

@WebServlet(urlPatterns = {"/addProduct"})
public class addProductControl extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String image = req.getParameter("image");
		String price = req.getParameter("price");
		String title = req.getParameter("tittle");
		String description = req.getParameter("description");
		String cateID = req.getParameter("cateID");
		DAO dao = new DAO();
		try {
			dao.addProduct(name, image, price, title, description, cateID, "1");
			resp.sendRedirect("managerProduct");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
