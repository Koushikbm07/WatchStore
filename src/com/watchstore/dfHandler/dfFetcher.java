package com.watchstore.dfHandler;

import java.sql.*;
import java.util.*;

import com.watchstore.model.*;

public class dfFetcher {


	public static String fetchPassword(String email) throws SQLException  {

		String sql = "SELECT password from users WHERE email=?";
		String Password = "";
		Connection conn=null;
		try {
			
			 conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Password = rs.getString(1);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();

			return Password;
		}

	}

	public static List<User> fetchUserInfo() throws SQLException {
		
		List<User> allUsers=new ArrayList<>();
		String sql = "select * from users";
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				User user=new User();
				user.setId(Integer.parseInt(rs.getString(1)));
				user.setUname(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setType(rs.getString("type"));
				user.setPhoto(rs.getString("photo"));
				user.setPhone(rs.getString("phone"));
				user.setType(rs.getString("type"));
				allUsers.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
			return allUsers;
		}
	}

	public static List<Product> fetchProductsInfo() throws SQLException{
		List<Product> plist = new ArrayList<Product>();
		String sql = "SELECT * FROM PRODUCT";
		String brandQuery="	SELECT * FROM (SELECT bid,bname,photo FROM BRAND JOIN PRODUCT ON BRAND.bid=PRODUCT.brandid) WHERE bid=?";
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			PreparedStatement ps=conn.prepareStatement(brandQuery);
			while (rs.next()) {
				ps.setInt(1,rs.getInt(9));
				ResultSet brandResult=ps.executeQuery();
				brandResult.next();
				Brand brand = new Brand();
				brand.setBid(brandResult.getInt("bid"));
				brand.setName(brandResult.getString("bname"));
				brand.setPhoto(brandResult.getString("photo"));
				Product product=new Product(
						 Integer.parseInt(rs.getString(1)),
						 rs.getString(2),
						 rs.getString(3),
						 rs.getString(4),
						 Integer.parseInt(rs.getString(5)),
						 Integer.parseInt(rs.getString(6)),
						 rs.getString(7),
						 Integer.parseInt(rs.getString(8)),
						 brand
						 );
						
				plist.add(product);
			}


		} catch (Exception e) {
			System.out.println("Problem in fetching the products");
			e.printStackTrace();
		} 
		finally {
			conn.close();
			return plist;
		}
	
	}

	public static User fetchUser(String email, String pass) throws SQLException {
		String sql = "SELECT * FROM users where email=? and password=?";
		User user = new User();
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			rs.next();
			
					user.setId(rs.getInt("id"));
					user.setUname(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setGender(rs.getString("gender"));
					user.setType(rs.getString("type"));
					user.setPhone(rs.getString("phone"));
					user.setPhoto(rs.getString("photo"));

		} catch (Exception e) {
			System.out.println("Cannot get user details");
			e.printStackTrace();
		} finally {
			conn.close();
			return user;
		}
		

	}
	public static Brand getBrandByProduct(int  brandId) throws SQLException {
		String sql="SELECT * FROM brand where bid=?";
		Brand brand=new Brand();
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, brandId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			brand.setBid(rs.getInt("bid"));
			brand.setName(rs.getString("bname"));
			brand.setPhoto(rs.getString("photo"));
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to get Brand By Product");
		}
		finally {
			conn.close();
			return brand;
		}
	}
	public static Cart getProductbyId(int  pid) throws SQLException {
		String sql="SELECT * FROM product where pid=?";
		Cart product=new Cart();
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			product.setId(rs.getInt("pid"));
			product.setTitle(rs.getString("ptitle"));
			product.setDesc(rs.getString("pdesc"));
			product.setPhoto(rs.getString("pphoto"));
			product.setPrice(rs.getInt("pprice"));
			product.setDiscount((rs.getInt("pdiscount")));
			product.setType(rs.getString("ptype"));
			product.setStock(rs.getInt("pquantity"));
			product.setBrand(getBrandByProduct(rs.getInt("brandid")));
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed to get Cart Product By Id");
		}
		finally {
			conn.close();
			return product;
		}
	}
	public static List<Brand> fetchBrandInfo() throws SQLException{
		String sql="SELECT * FROM brand";
		List<Brand> blist=new ArrayList<>();
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Brand brand=new Brand();
				brand.setBid(rs.getInt("bid"));
				brand.setName(rs.getString("bname"));
				brand.setPhoto(rs.getString("photo"));
				blist.add(brand);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Not able to fetch All Brands Info");
		}
		finally {
			conn.close();
			return blist;
		}
	}
	public static List<Product> getProductsByBrandId(int brandId) throws SQLException {
		String sql="SELECT * FROM product where brandid=?";
		List<Product> products=new ArrayList<>();
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, brandId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("pid"));
				product.setTitle(rs.getString("ptitle"));
				product.setDesc(rs.getString("pdesc"));
				product.setPrice(rs.getInt("pprice"));
				product.setPhoto(rs.getString("pphoto"));
				product.setBrand(getBrandByProduct(brandId));
				product.setType(rs.getString("ptype"));		
				product.setStock(rs.getInt("pquantity"));
				products.add(product);
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Not able to fetch All Brands Info");
		}
		finally {
			conn.close();
			return products;
		}
	}
	
	public static Address fetchUserAddress(int uid) throws SQLException {
		
		String sql="select * from address where userid=?";
		Address address=null;
		Connection conn=null;
		try {
			 conn = dbConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			 address=new Address(
					rs.getString("street"),
					rs.getString("address"),
					rs.getInt("pincode"),
					rs.getString("city"),
					rs.getString("state"),
					rs.getInt("userid")
					);
	
			}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Address not available ");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Cannot fetch Address");
		}
		
		finally {
			conn.close();

			return address;
		}
		
	}

	

}
