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
import com.HV2023.entity.Product;

@WebServlet(urlPatterns = { "/editProduct" })
public class editProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id = req.getParameter("pid");
		DAO dao = new DAO();
		try {
			Product p = dao.getProductId(Id);
			req.setAttribute("product", p);
			RequestDispatcher dis = req.getRequestDispatcher("views/editProduct/editProduct.jsp");
			dis.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String image = req.getParameter("image");
		String price = req.getParameter("price");
		String title = req.getParameter("tittle");
		String description = req.getParameter("description");
		String cateID = req.getParameter("cateID");
		DAO dao = new DAO();
		try {
			dao.editProduct(id, name, image, price, title, description, cateID);
			resp.sendRedirect("managerProduct");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
