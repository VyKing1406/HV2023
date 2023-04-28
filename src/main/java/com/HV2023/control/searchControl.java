package com.HV2023.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HV2023.dao.DAO;
import com.HV2023.entity.Product;

@WebServlet(urlPatterns = { "/search" })
public class searchControl extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Search = req.getParameter("search");
		DAO dao = new DAO();
		List<Product> list1 = null;
		List<Product> list2 = null;
		List<Product> list3 = null;
		try {
			list1 = (List<Product>) dao.getProductName(Search, 1);
			list2 = (List<Product>) dao.getProductName(Search, 2);
			list3 = (List<Product>) dao.getProductName(Search, 3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher dis = req.getRequestDispatcher("/views/home/home.jsp");
		dis.forward(req, resp);
	}
}
