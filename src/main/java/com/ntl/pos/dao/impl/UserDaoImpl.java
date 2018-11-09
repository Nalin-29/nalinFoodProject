package com.ntl.pos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.UserDao;
import com.ntl.pos.utilImpl.DbUtilImpl;

public class UserDaoImpl implements UserDao {
	
	static Connection conn;
	static Statement stat;
	static ResultSet rs;
	static PreparedStatement pstmt;
	
	
	public UserDaoImpl() {
		DbUtilImpl db=new DbUtilImpl();
		conn=db.getDataBase("url");
		try {
			stat =conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public String confirmOrder(OrderBean ob) {
		

		
		
		String userId =""+ob.getUserId();
		
		// Available Quantity
		
		String foodSQL = "select quantity from food_bean where food_id ="+ob.getFoodId();
		int qty = 0;
		try {
			rs = stat.executeQuery(foodSQL);
			if(rs.next()) {
				qty = rs.getInt("quantity");
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if(ob.getQty()>qty) {
			return "Max - " + qty + "Available";
		}
		qty = qty - ob.getQty();
		
		//Balance check
		String sqll = "select balance from wallet where userId = '"+userId+"' ";
		int balance=0;
		try {
			rs = stat.executeQuery(sqll);
			if(rs.next())
			{
				balance = rs.getInt("balance");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ob.getTotalPrice()>balance)
		{
			return "insufficient balance";
		}
		balance = (int) (balance - ob.getTotalPrice());
		
		
		
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());	
		ob.setOrderStatus("pending");
		
		String sql = "Select * from user_profile where userId = '"+userId+"'";
		try {
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				ob.setStreet(rs.getString("street"));
				ob.setCity(rs.getString("city"));
				ob.setState(rs.getString("state"));
				ob.setPincode(rs.getString("pincode"));
				ob.setMobileNo(rs.getString("mobileno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "try again";
		}
			
String sqlll = "insert into orders(userId,OrderDate,StoreId,TotalPrice,OrderStatus,Street,City,State,Pincode,MobileNo,foodId,qty) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			pstmt = conn.prepareStatement(sqlll);
			pstmt.setInt(1, ob.getUserId());
			pstmt.setDate(2, sqlDate);
			pstmt.setInt(3, ob.getStoreID());			
			pstmt.setInt(4, ob.getTotalPrice());
			pstmt.setString(5, ob.getOrderStatus());
			pstmt.setString(6, ob.getStreet());
			pstmt.setString(7, ob.getCity());
			pstmt.setString(8, ob.getState());
			pstmt.setString(9, ob.getPincode());
			pstmt.setString(10, ob.getMobileNo());
			pstmt.setInt(11, ob.getFoodId());
			pstmt.setInt(12, ob.getQty());
			
		    int s=pstmt.executeUpdate();
		    if(s==1)
		    {
		    	// Update wallet, Update Quantity
		    	String updateSql = "UPDATE wallet set balance = "+balance +" where userId = '"+userId+"'";
		    	s = stat.executeUpdate(updateSql);
		    	updateSql = "UPDATE food_bean set quantity = " +qty+ " where food_id ="+ob.getFoodId();
		    	s = stat.executeUpdate(updateSql);
		    	return "order placed";
		    }
			//System.out.println(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stmt.execute("insert ");
		return "fail";
		
		
	}



	@Override
	public ArrayList<StoreBean> viewAllStore() {
		// TODO Auto-generated method stub
		ArrayList<StoreBean> pizzStores = new ArrayList<StoreBean>();
		//	System.out.println("View All Working");
			String sql = "select * from pizzastore";
			try {
				rs = stat.executeQuery(sql);
				while(rs.next()){
					 StoreBean sb = new StoreBean();
					 sb.setStoreId(rs.getInt("StoreId"));
					 sb.setName(rs.getString("Name"));
					 sb.setStreet(rs.getString("Street"));
					 sb.setMobileno(rs.getString("MobileNo"));
					 sb.setCity(rs.getString("City"));
					 sb.setState(rs.getString("State"));
					 sb.setPinCode(rs.getString("Pincode"));
					 pizzStores.add(sb);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pizzStores;

		
	}
	
	public StoreBean viewStore(String storeId) {
		// TODO Auto-generated method stub
		//ArrayList<StoreBean> pizzaStores = new ArrayList<StoreBean>();
		//StoreBean pizzStores = new StoreBean();
		StoreBean ssb= new StoreBean();
		//System.out.println("View All Working");
		String sql = "select * from pizzastore where StoreId='"+storeId+"'"; 
		try {
			rs = stat.executeQuery(sql);
			while(rs.next()){
				 
				 ssb.setStoreId(rs.getInt("StoreId"));
				 ssb.setName(rs.getString("Name"));
				 ssb.setStreet(rs.getString("Street"));
				 ssb.setMobileno(rs.getString("MobileNo"));
				 ssb.setCity(rs.getString("City"));
				 ssb.setState(rs.getString("State"));
				 ssb.setPinCode(rs.getString("Pincode"));
				
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ssb ;
	}
	
	public FoodBean viewFood(int foodId) {
		// TODO Auto-generated method stub
		FoodBean ffbb= new FoodBean();
		//System.out.println("View All Working");
		String sql = "select * from food_bean where Food_id="+foodId;
	    
		try {
			rs = stat.executeQuery(sql);
			while(rs.next()){
				
				 ffbb.setFoodId(rs.getInt("Food_Id"));
				 ffbb.setName(rs.getString("Name"));
				 ffbb.setType(rs.getString("Type"));
				 ffbb.setFoodSize(rs.getString("Food_Size"));
				 ffbb.setQuantity(rs.getInt("Quantity"));
				 ffbb.setPrice(rs.getInt("Price"));
				 ffbb.setStoreId(rs.getInt("StoreId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ffbb ;
	}
	
	public ArrayList<FoodBean> viewAllFood(int storeId) {
		// TODO Auto-generated method stub
		ArrayList<FoodBean> foodStores = new ArrayList<FoodBean>();
		//	System.out.println("View All Working");
			String sql = "select * from food_bean where storeId = "+storeId;
			try {
				rs = stat.executeQuery(sql);
				while(rs.next()){
					 FoodBean fb = new FoodBean();
					 fb.setFoodId(rs.getInt("Food_Id"));
					 fb.setName(rs.getString("Name"));
					 fb.setType(rs.getString("Type"));
					 fb.setFoodSize(rs.getString("Food_Size"));
					 fb.setQuantity(rs.getInt("Quantity"));
					 fb.setPrice(rs.getInt("Price"));
					 fb.setStoreId(rs.getInt("StoreId"));
					 foodStores.add(fb);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return foodStores;
	}




	@Override
	public ArrayList<OrderBean> viewOrder(int userid) {
		// TODO Auto-generated method stub
		ArrayList<OrderBean> orderBean = new ArrayList<OrderBean>();
		//System.out.println("View All Working");
		String sql = "select * from orders where userId="+userid;
	    
		try {
			rs = stat.executeQuery(sql);
			while(rs.next()){
				OrderBean ob= new OrderBean();
				ob.setOrderId(rs.getInt("OrderId"));
				ob.setUserId(rs.getInt("userId"));
				Date date = new Date();
				//String d = "" +rs.getDate("OrderDate");
				ob.setStoreID(rs.getInt("StoreId"));
				ob.setTotalPrice(rs.getInt("TotalPrice"));
				ob.setQty(rs.getInt("qty"));
				orderBean.add(ob);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderBean ;
	}

}
