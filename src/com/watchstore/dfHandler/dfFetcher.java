package com.watchstore.dfHandler;

import java.sql.*;

import com.watchstore.model.*;

public class dfFetcher {


	public static String fetchPassword(String email) {

		String sql = "SELECT pass from Customers WHERE mail=?";
		String Password = "";
		
		try {
			
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Password = rs.getString(1);
			conn.close();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return Password;
		}

	}

	public static User fetchUserInfo() throws SQLException {
		User user=null;
		String sql = "select * from users";
		try {
			Connection conn = dbConnection.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			user.setId(Integer.parseInt(rs.getString(1)));
			user.setUname(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPassword(rs.getString("gender"));
			user.setType(rs.getString("type"));
			user.setPhoto(rs.getString("photo"));
			user.setPhone(rs.getString("phone"));
			user.setType(rs.getString("type"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			return user;
		}
	}

	public static Product fetchProductsInfo() {
		List<String> plist = new ArrayList<>();
		String sql = "SELECT * FROM PRODUCTS";
		String temp;
		try {
			Connection conn = dbConnection.getdbConnection();

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				 temp = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getInt(4) + ";"
						+ rs.getString(5) + ";" + rs.getInt(6);
				plist.add(temp);
			}
			conn.close();


		} catch (Exception e) {
			System.out.println("Problem in fetching the products");
			e.printStackTrace();
		} 
		
			return plist;
		

	}

	public static User userdetails(String email, String pass) {
		String sql = "SELECT * FROM customers where mail=? and pass=?";
		User user = new User();
		try {
			Connection conn = dbConnection.getdbConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			rs.next();
			
				
					user.setId(rs.getInt("id"));
					user.setUname(rs.getString("uname"));
					user.setEmail(rs.getString("mail"));
					user.setGender(rs.getString("gender"));
					user.setAddress(rs.getString("address"));
					conn.close();
		
					


		} catch (Exception e) {
			System.out.println("Cannot get user details");
			e.printStackTrace();
		} finally {
			return user;
		}

	}

	public static List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		 List<Cart> products = new ArrayList<Cart >();
		try {
			Connection conn  = dbConnection.getdbConnection();
			String sql = "select * from products where pid=?";
			PreparedStatement st = conn.prepareStatement(sql);
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					
					st.setInt(1, item.getId());
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						Cart cart = new Cart(); 
						cart.setId(rs.getInt("pid"));
						cart.setName(rs.getString("pname"));
						cart.setDesc(rs.getString("pdesc"));
						cart.setPrice(rs.getInt("pprice"));
						cart.setImg(rs.getString("pimg"));
						cart.setQuantity(item.getQuantity());
						products.add(cart);
					}
					
				}
				conn.close();

			}
			else {
				System.out.print("no products in session");
			}
			

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			

		}
		return products;

	}

}
