package com.HV2023.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HV2023.dao.DAO;
import com.HV2023.entity.Product;

@WebServlet(urlPatterns = {"/productDetail"})
public class productDetailControll extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pid");
		DAO dao = new DAO();
		Product p = null;
		try {
			p = (Product) dao.getProductId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("product", p);
		req.getRequestDispatcher("/views/productDetail/productDetail.jsp").forward(req, resp);
	}

}
