package com.ntl.pos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.AdministratorDao;
import com.ntl.pos.utilImpl.DbUtilImpl;

import client.Pizza;

public class AdministratorDaoImpl implements AdministratorDao {
	
	static Logger log=Logger.getLogger(AdministratorDaoImpl.class);
	static Connection conn;
	static Statement stat;
	static ResultSet rs;
	static PreparedStatement pstmt;
	
	//@Override
	public String addStore(StoreBean storeBean) {
		// TODO Auto-generated method stub
		String sqql = "insert into pizzastore(StoreId,name,street,mobileno,city,state,pinCode) values(?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sqql);
			pstmt.setInt(1, storeBean.getStoreId());
			pstmt.setString(2, storeBean.getName());
			pstmt.setString(3, storeBean.getStreet());			
			pstmt.setString(4, storeBean.getMobileno());
			pstmt.setString(5, storeBean.getCity());
			pstmt.setString(6, storeBean.getState());
			pstmt.setString(7, storeBean.getPinCode());
		    int s1=pstmt.executeUpdate();
		    if(s1==1)
		    {
		    	return "success";
		    }
			//System.out.println(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stmt.execute("insert ");
		return "fail";
	}

	//@Override
	public boolean modifyStore(StoreBean sb) {
		
		if(!isStoreId(sb.getStoreId())) {
			return false;
			
		}
		String sql = "update pizzastore SET StoreId=?,name=?,street=?,mobileno=?,city=?,state=?,pinCode=? where StoreId="+sb.getStoreId(); 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sb.getStoreId());
			pstmt.setString(2, sb.getName());
			pstmt.setString(3, sb.getStreet());			
			pstmt.setString(4, sb.getMobileno());
			pstmt.setString(5, sb.getCity());
			pstmt.setString(6, sb.getState());
			pstmt.setString(7, sb.getPinCode());
			 int s=pstmt.executeUpdate();
			
				    if(s==1)
				    {
				    	return true;
				    }
					//System.out.println(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//stmt.execute("insert ");
				return false;
	
	}

	private boolean isStoreId(int storeId) {
		String sql = "select * from pizzastore where StoreId='"+storeId+"'"; 
		try {
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		}
	    catch (Exception e) {
	    	System.out.println("Exception " + e);
	    }
		return false;
	}



	//@Override
	public StoreBean viewStore(String storeId) {
		
		StoreBean sb= new StoreBean();
		
		String sql = "select * from pizzastore where StoreId='"+storeId+"'"; 
		try {
			rs = stat.executeQuery(sql);
			while(rs.next()){
				 
				 sb.setStoreId(rs.getInt("StoreId"));
				 sb.setName(rs.getString("Name"));
				 sb.setStreet(rs.getString("Street"));
				 sb.setMobileno(rs.getString("MobileNo"));
				 sb.setCity(rs.getString("City"));
				 sb.setState(rs.getString("State"));
				 sb.setPinCode(rs.getString("Pincode"));
				
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return sb ;
	}

	//@Override
	public ArrayList<StoreBean> viewAllStore() {
		
		
		ArrayList<StoreBean> pizzStores = new ArrayList<StoreBean>();
	
		String sql = "select * from pizzastore";
		try {
			rs = stat.executeQuery(sql);
			while(rs.next()){
				 StoreBean sbb = new StoreBean();
				 sbb.setStoreId(rs.getInt("StoreId"));
				 sbb.setName(rs.getString("Name"));
				 sbb.setStreet(rs.getString("Street"));
				 sbb.setMobileno(rs.getString("MobileNo"));
				 sbb.setCity(rs.getString("City"));
				 sbb.setState(rs.getString("State"));
				 sbb.setPinCode(rs.getString("Pincode"));
				 pizzStores.add(sbb);
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pizzStores;
	}

	/**
	 * 
	 */
	public AdministratorDaoImpl() {
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

	//@Override
	public String addFood(FoodBean fb,int storeId) {
		// TODO Auto-generated method stub
String sql = "insert into food_bean (food_Id,food_Size,name,price,quantity,type,storeId) values(?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fb.getFoodId());
			pstmt.setString(2, fb.getFoodSize());
			pstmt.setString(3, fb.getName());			
			pstmt.setInt(4, fb.getPrice());
			pstmt.setInt(5, fb.getQuantity());
			pstmt.setString(6, fb.getType());
			pstmt.setInt(7, fb.getStoreId());
		    int s=pstmt.executeUpdate();
		    if(s==1)
		    {
		    	return "success";
		    }
			//System.out.println(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stmt.execute("insert ");
		return "fail";
	}

	//@Override
	public boolean modifyFood(FoodBean foodBean) {
		// TODO Auto-generated method stub
				if(!isFoodId(foodBean.getFoodId())) {
				return false;
			}
			
			
		
      String sql = "update food_bean SET food_Id=?,food_Size=?,name=?,price=?,quantity=?,type=?,storeId=? where food_Id="+foodBean.getFoodId();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, foodBean.getFoodId());
			pstmt.setString(2, foodBean.getFoodSize());
			pstmt.setString(3, foodBean.getName());			
			pstmt.setInt(4, foodBean.getPrice());
			pstmt.setInt(5, foodBean.getQuantity());
			pstmt.setString(6, foodBean.getType());
			pstmt.setInt(7, foodBean.getStoreId());
		    int s=pstmt.executeUpdate();
		    if(s==1)
		    {
		    	return true;
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;

	}

	private boolean isFoodId(int foodId) {
		
		
		String sql = "select * from food_bean where food_id='"+foodId+"'"; 
		try {
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		}
	    catch (Exception e) {
	    	System.out.println("Exception " + e);
	    }
		return false;
	}

	

	//@Override
	public FoodBean viewFood(int foodId) {
		// TODO Auto-generated method stub
		FoodBean ffb= new FoodBean();
		
		String sql = "select * from food_bean where Food_id="+foodId;
	    
		try {
			rs = stat.executeQuery(sql);
			while(rs.next()){
				
				 ffb.setFoodId(rs.getInt("Food_Id"));
				 ffb.setName(rs.getString("Name"));
				 ffb.setType(rs.getString("Type"));
				 ffb.setFoodSize(rs.getString("Food_Size"));
				 ffb.setQuantity(rs.getInt("Quantity"));
				 ffb.setPrice(rs.getInt("Price"));
				 ffb.setStoreId(rs.getInt("StoreId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ffb ;
	}
	


	//@Override
	public ArrayList<FoodBean> viewAllFood(int storeId) {
	
		ArrayList<FoodBean> foodStores = new ArrayList<FoodBean>();
		
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


}
