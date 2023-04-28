package com.HV2023.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.HV2023.context.DBConntext;
import com.HV2023.entity.Product;
import com.HV2023.entity.account;

public class DAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public List<Product> getAllProduct() throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "select * from elearning.product";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
						rs.getString("price"), rs.getString("title"), rs.getString("description"), rs.getInt("cateID"),
						rs.getString("sell_ID")));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<Product> getProductCateId(String id) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "select * from elearning.product where cateId = ?";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
						rs.getString("price"), rs.getString("title"), rs.getString("description"), rs.getInt("cateID"),
						rs.getString("sell_ID")));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<Product> getProductCartId(int uId, int cateID) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * from elearning.product JOIN elearning.cart ON elearning.cart.pID = elearning.product.id WHERE elearning.cart.uID = ?";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uId);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("cateID") == cateID) {
					list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
							rs.getString("price"), rs.getString("title"), rs.getString("description"),
							rs.getInt("cateID"), rs.getString("sell_ID")));
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	public int checkP(int uId, int pId) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * from elearning.cart where uID = ? and pID = ?";
		int codeCart = 0;
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uId);
			ps.setInt(2, pId);
			rs = ps.executeQuery();
			if(rs.next()) {
				codeCart = rs.getInt("codeCart");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return codeCart;
	}
	
	public void addToCart(int uId, int pId, int codeCart) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql;
		try {
			conn = new DBConntext().getConnection();
			
			if(codeCart == 0) {
				sql = "INSERT INTO elearning.cart (`uID`, `pID`, `quantity`) VALUES (?, ?, '1')";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, uId);
				ps.setInt(2, pId);
			}
			else {
				sql = "UPDATE elearning.cart SET quantity = quantity + 1 WHERE codeCart = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, codeCart);
			}
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;
	}
	public void buyFromCart(int uId) throws SQLException {
		try {
			conn = new DBConntext().getConnection();
			String sql = "delete from elearning.cart where uID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uId);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;
	}
	public Product getProductId(String Id) throws SQLException {
		String sql = "select * from elearning.product where id = ?";
		Product product = null;
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
						rs.getString("price"), rs.getString("title"), rs.getString("description"), rs.getInt("cateID"),
						rs.getString("sell_ID"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	public List<Product> getProductName(String search, int id) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "select * from elearning.product where name like ?";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + search + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("cateID") == id) {

					list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
							rs.getString("price"), rs.getString("title"), rs.getString("description"),
							rs.getInt("cateID"), rs.getString("sell_ID")));
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public account login(String userName, String passWord) throws SQLException {
		account acc = null;
		String sql = "select * from elearning.account where userName = ? and passWord = ?";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			rs = ps.executeQuery();
			while (rs.next()) {
				acc = new account(rs.getInt("uID"), rs.getString("userName"), rs.getString("passWord"),
						rs.getBoolean("isAdmin"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acc;
	}

	public void signUp(String userName, String passWord) throws SQLException {
		String sql = "insert into elearning.account (`userName`, `passWord`, `uID`, `isAdmin`) values (?, ?, 0, 0)";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public boolean checkExist(String userName) throws SQLException {
		String sql = "select * from elearning.account where userName = ?";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public void deleteProductId(String Id) throws SQLException {
		String sql = "delete from elearning.product where id = ?";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public void addProduct(String name, String image, String price, String title, String description, String cateID,
			String sellID) throws SQLException {
		String sql = "insert into elearning.product (`name`,`image`, `price`, `title`, `description`, `cateID`, `sell_ID` ) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, cateID);
			ps.setString(7, sellID);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public void editProduct(String id, String name, String image, String price, String title, String description,
			String cateID) throws SQLException {
		String sql = "update elearning.product set `name` = ?,`image`= ?, `price`= ?, `title`= ?, `description`= ?, `cateID`= ? where id = ?";
		try {
			conn = new DBConntext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, cateID);
			ps.setString(7, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
//	public static void main(String[] args) {
//		DAO dao = new DAO();
//		try {
//			boolean he = dao.checkExist("HaVy1");
//			System.out.println(he);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
