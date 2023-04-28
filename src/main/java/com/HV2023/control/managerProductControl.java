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

@WebServlet(urlPatterns = { "/managerProduct" })
public class managerProductControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAO dao = new DAO();
		List<Product> list1 = null;
		List<Product> list2 = null;
		List<Product> list3 = null;
		try {
			list1 = (List<Product>) dao.getProductCateId("1");
			list2 = (List<Product>) dao.getProductCateId("2");
			list3 = (List<Product>) dao.getProductCateId("3");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		RequestDispatcher dis = req.getRequestDispatcher("/views/managerProduct/managerProduct.jsp");
		dis.forward(req, resp);// TODO Auto-generated method stub
	}

}
