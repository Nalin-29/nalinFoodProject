package client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;




import com.ntl.pos.bean.CredentialsBean;
import com.ntl.pos.bean.FoodBean;
import com.ntl.pos.bean.OrderBean;
import com.ntl.pos.bean.ProfileBean;
import com.ntl.pos.bean.StoreBean;
import com.ntl.pos.dao.impl.AdministratorDaoImpl;
import com.ntl.pos.service.impl.AdministratorImpl;
import com.ntl.pos.service.impl.UserImpl;
import com.ntl.pos.service.impl.ValidateDataImpl;
import com.ntl.pos.utilImpl.UserUtilImpl;

public class Pizza {
	
	
	static Logger log=Logger.getLogger(Pizza.class);
	ValidateDataImpl vd = new ValidateDataImpl();
	
	
	 Scanner scanner=new Scanner(System.in);
	 AdministratorImpl administrator = new AdministratorImpl(); 
	 StoreBean storeBean = new StoreBean();
	  static String result=" ";
	  static CredentialsBean loginUserData = new CredentialsBean();
	  ValidateDataImpl validate = new ValidateDataImpl();
	  
	  AdministratorDaoImpl adminDao = new AdministratorDaoImpl();
	  UserImpl userImpl  = new UserImpl();
	  UserUtilImpl user  = new UserUtilImpl();
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pizza m = new Pizza();
		m.getData();
	}

//method to Ask the choice from the user
	
	public  void getData() {
		
		System.out.println("  -------------                         -------------\n"
				           + "-------------                         -------------\n"
				           + "------------- Welcome to Pizza Service-------------\n"
				           + "-------------                         -------------\n"
				           + "-------------                         -------------\n"
				           + "-------------                         -------------\n\n");
		
		log.info("Welcome to my Project inside Main");
		int run = 0;
		while(run==0) {
			if(result.equals("admin")) {
				System.out.println("       Enter\n"
						           + " 1 for View ALL Store\n"
						           + " 2 for View Store \n"
						           + " 3 for add store \n"
						           + " 4 for add food\n"
						           + " 5 for viewFood\n"
						           + " 6 for ViewAll Food\n"
						           + " 7 for modify store\n"
						           + " 8 for modify food\n"
						           + " 20 for log out");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					viewAllStore();
					break;
					
				case 2:
					viewStore();
					break;
					
				case 3:
					addStore();
					break;
					
				case 4:
					addFood();
					break;
				case 5:
					viewFood();
					break;
				case 6:
					viewAllFood();
					break;
				
				case 7:
					modifyStore();
					break;
					
				case 8:
					modifyFood();
					break;	
				case 20:
					logout();
					break;
					
				default :
					System.out.println("Invalid");
					
				}   
				
				
			}
	// method to ask from user		
			else if(result.equals("User")) {
			
				System.out.println("Enter\n"
						         + " 1 for View ALL Store\n"
						         + " 2 for View Store \n"
						         + " 3 for viewAllFood store\n"
						         + " 4 for view food\n"
						         + " 5 for order food\n"
						         + " 6 for view order\n"
						         + " 20 for log out");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					viewAllStore();
					break;
					
				case 2:
					viewStore();
					break;
					
				case 3:
					viewAllFood();
					break;
					
				case 4:
					viewFood();
					break;
				case 5:
					orderFood();
					break;
				case 6:
					viewOrder();
					break;	
				case 20:
					logout();
					break;
				default :
					System.out.println("Invalid");
				}
			}
			else {
				System.out.println("Enter 1 for login And 2 for signup");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					logIn();
					break;
					
				case 2:
					signup();
					break;
				}
			}
			
		}
	
	}
	
// method for order food	
	
private void orderFood() {
	// TODO Auto-generated method stub
	System.out.println("Please select store Id, from where you wants to order");
	viewAllStore();
	int storeId = scanner.nextInt();
	ArrayList<FoodBean> foodBean = new  ArrayList<FoodBean>();
	while(foodBean.size()==0) {
		System.out.println("Empty Store" + storeId);
		storeId = scanner.nextInt();
		foodBean  = adminDao.viewAllFood(storeId);
	}
	ArrayList<Integer> arr = new ArrayList<Integer>();
	System.out.println("Chhose Your Food");
	for(FoodBean f : foodBean) {
		arr.add(f.getFoodId());
		System.out.println(f);
	}
	int foodId = 0;
	while(!arr.contains(foodId)) {
		System.out.println("Enter Food ID from above mentioned food Id");
		foodId = scanner.nextInt();
	}
	System.out.println("Enter Your Quantity / Max you can choose 10");
	int qty = 0;
    while(qty<=0 || qty>10) {
    	System.out.println("Choose between 1 - 10");
    	qty = scanner.nextInt();
    }
    FoodBean orderFood = adminDao.viewFood(foodId);
    int totalPrice = qty * orderFood.getPrice();
    System.out.println("Your Total Price = " +totalPrice);
    System.out.println("Press 1 to process, Press 2 for cancel");
    int choice = scanner.nextInt();
    if(choice==1) {
    	OrderBean ob = new OrderBean();
    	ob.setStoreID(storeId);
    	ob.setUserId(Integer.parseInt(loginUserData.getUserId()));
    	ob.setTotalPrice(totalPrice);
    	ob.setFoodId(foodId);
    	ob.setQty(qty);
    	String message = userImpl.confirmOrder(ob);
    	System.out.println("Confirm Order Message - " + message);
    }

}

// method for logout

private void logout() {
	// TODO Auto-generated method stub
	System.out.println("Thankyou for visiting");
	loginUserData = new CredentialsBean();
	result = "";
	
}

//method for ViewAllFood

private void viewAllFood() {
	
	log.info("View all food Called ");
	// TODO Auto-generated method stub
	
	System.out.println("Enter Store ID from given stores!!");
	viewAllStore();
	int storeId = scanner.nextInt();
	ArrayList<FoodBean> foodBean = adminDao.viewAllFood(storeId);
	if(foodBean.size()>0)
	{
		for(FoodBean fb : foodBean) {
			System.out.println(fb);
		}
			
	}
	else {
		System.out.println("Empty store");
		viewAllFood();
	}
}

//method for viewOrder

private void viewOrder() {
	
	// TODO Auto-generated method stub
	log.info("view order called");

	int userId = Integer.parseInt(loginUserData.getUserId());
	ArrayList<OrderBean> ob = userImpl.viewOrder(userId);
	//System.out.println("ghjjh");
	//ArrayList<FoodBean> foodBean = adminDao.viewAllFood(storeId);
	if(ob.size()>0)
	{
		//System.out.println("hiii");
		for(OrderBean fb : ob) {
			System.out.println(fb);
		}
			
	}
	else {
		System.out.println(" Empty Store ");
		viewOrder();
	}
}

//method for viewStore

private void viewStore() {
	// TODO Auto-generated method stub
	log.info("inside view store");
	
	log.info("Inisde view Store ");
	String sb= scanner.nextLine();
	if(sb.length()<2) {
		System.out.println("Please enter the store id");
		sb= scanner.nextLine();
	}
	StoreBean ab = administrator.viewStore(sb);
	
	if(ab!=null)
	{
		System.out.println(ab);
	}
	else {
		System.out.println("No Data Available");
	}
	
}

// method for viewFood

private void viewFood() {
	log.info("Inside View Food" );
	// TODO Auto-generated method stub
	log.info("Inside view food");
	System.out.println("please select from the given stores");
	viewAllStore();
	
	int storeId = scanner.nextInt();
    FoodBean sb =new FoodBean();
    ArrayList<FoodBean> bb = new  ArrayList<FoodBean>();
    bb=administrator.viewAllFood(storeId);
	
    if(bb.size()>0)
	{
		//System.out.println("hiii");
		for(FoodBean fb : bb) {
			System.out.println(fb);
		}
			
	}
	else {
		System.out.println(" Empty Store ");
		viewFood();
	}
	
	
	
	
	
	
}

// Method  for Admin to View all the store
	
	private void viewAllStore() {
		// TODO Auto-generated method stub
		log.info("View all store called");
		ArrayList<StoreBean> storeBean = administrator.viewAllStore();
		if(storeBean.size()>0)
		{
			for(StoreBean sb : storeBean) {
				System.out.println(sb);
			}
				
		}
		else {
			System.out.println("No Data Available.");
		}
	}

	
// Method For logIn For both user and admin
	
	private void logIn() {
		log.info("logIn called");
		// TODO Auto-generated method stub
		
		System.out.println("Enter your userID");
		String id=scanner.next();
		System.out.println("Enter your password");
		String password=scanner.next();
		CredentialsBean cb = new CredentialsBean(id,password);
		result=user.logIn(cb);
		
		if(result.equals("admin")) {
			loginUserData.setUserId(cb.getUserId());
			loginUserData.setPassword(cb.getPassword());
			System.out.println("Welcome Admin");
			
		}
		
		else if(result.equals("User")) {
			loginUserData.setUserId(cb.getUserId());
			loginUserData.setPassword(cb.getPassword());
			System.out.println("Welcome customer");
		}
		
	}
	
  // method for SignUp for user	
	
	void signup() {
		
		log.info("Inside sign up");
		
		
		//Taking input from the user
		
		System.out.println("Enetr your userID");
		String id=scanner.next();
		
		String firstName = "";
		while(firstName.length()<2) {
			boolean a=false;
			while(!a) {
			System.out.println("Enter First Name.");
			firstName=scanner.next();
			a=vd.validateName(firstName);
			//System.out.println("name not valid");
			}
		}
		
		String lName = "";
		while(lName.length()<2) {
			boolean a=false;
			while(!a) {
			System.out.println("Enter last Name.");
			lName=scanner.next();
			a=vd.validateName(lName);
			//System.out.println("name not valid");
			}
		}
		
		System.out.println("Enter your Date Of Birth");
		String date=scanner.next();
		String[] dates=date.split("/",3);
		Date date1=Date.valueOf(LocalDate.of(Integer.parseInt(dates[2]), Integer.parseInt(dates[1]), Integer.parseInt(dates[0])));
		
		String gender = "";
		while(gender.length()<2) {
			boolean a=false;
			while(!a) {
			System.out.println("Enter your gender");
			gender=scanner.next();
			a=vd.validategender(gender);
			//System.out.println("name not valid");
			}
		}
		
		
		System.out.println("Enter your Street Name");
		
		String street=scanner.next();
		
		System.out.println("Enter your Location");
		String location="";
		while(location.length()<2) {
			System.out.println("Enter your Location");
			location=scanner.next();
		}
		System.out.println("Enter your City");
		String city=scanner.next();
		
		System.out.println("Enter your State");
		String state=scanner.next();
		
		System.out.println("Enter your pincode");
		String pinCode=scanner.next();
		
		System.out.println("Enter your mobileNo.");
		String number=scanner.next();
		
		
		String email = "";
		while(email.length()<2) {
			boolean a=false;
			while(!a) {
			System.out.println("Enter ur email");
			email=scanner.next();
			a=vd.validateEmail(email);
			//System.out.println("name not valid");
			}
		}
		
	//	System.out.println("Enter your emailId");
	//	String emailId=scanner.next();
		
		String password = "";
		while(password.length()<2) {
			boolean a=false;
			while(!a) {
			System.out.println("Enter ur email");
			password=scanner.next();
			a=vd.validatePassword(password);
			//System.out.println("name not valid");
			}
		}
		
		ProfileBean profileBean = new ProfileBean(id,firstName,lName,date1,gender,street,location,city,state,pinCode,number,email,password);
		String message = user.register(profileBean);
		System.out.println("Register Message - " +message);
		if(message.equals("Success")) {
			System.out.println("You can login...");
			logIn();
		}
		else {
			System.out.println("Try Again");
			signup();
		}
		
	}
	
	
// method for adding store
	
void addStore() {
	
	log.info("Inside add store");
	
	
	
	System.out.println("Enter the store id");
	int id1 = scanner.nextInt();
	
	System.out.println("Enter store name");
	String namee=scanner.next();
	
	System.out.println("Enter street name");
	String streeet=scanner.next();
	
	System.out.println("Enter  mobileNo.");
	String mobileno=scanner.next();
	
	System.out.println("Enter your City");
	String cityy=scanner.next();
	
	System.out.println("Enter your State");
	String State=scanner.next();
	
	System.out.println("Enter your pincode");
	String pincode=scanner.next();
	
	
	StoreBean storeBean = new StoreBean(id1,namee,streeet,mobileno,cityy,State,pincode);
	String message = adminDao.addStore(storeBean);
	
	if(message.equals("success")) {
		System.out.println("store added");
		getData();
	}
	else {
		System.out.println("Try Again");
		addStore();
	}
	
}


//method for adding food

void addFood() {
	
	log.info("Inside view Food");
	
	
	System.out.println("Enter the food id");
	int foodid = scanner.nextInt();
	
	System.out.println("Enter foodname");
	String foodname=scanner.next();
	
	System.out.println("Enter the type");
	String foodtype=scanner.next();
	
	System.out.println("Enter the size");
	String foodsize=scanner.next();
	
	System.out.println("Enter food quantity");
	int foodquantity=scanner.nextInt();
	
	System.out.println("Enter the price");
	int foodprice=scanner.nextInt();
	
	System.out.println("Enter the storeId");
	int storeId=scanner.nextInt();
	
	
	
	FoodBean foodBean = new FoodBean(foodid,foodname,foodtype,foodsize,foodquantity,foodprice,storeId);
	String message = adminDao.addFood(foodBean,storeId);
	
	if(message.equals("success")) {
		System.out.println("food added");
		getData();
	}
	else {
		System.out.println("Try Again");
		addFood();
	}
	
}

//  method for modify store

private void modifyStore() {
	
	log.info("inside modify store");
	
	StoreBean sb= new StoreBean();
	

	System.out.println("Enter Store ID from given stores!!");
	viewAllStore();
	
	int storeId = scanner.nextInt();

	
	System.out.println("Enter your name");
	String storename=scanner.next();
	
	System.out.println("Enter your street.");
	String storestreet=scanner.next();
	
	System.out.println("Enter your mobileNo.");
	String storemobile=scanner.next();
	
	System.out.println("Enter your City");
	String storecity=scanner.next();
	
	System.out.println("Enter your State");
	String storestate=scanner.next();
	
	System.out.println("Enter your pincode");
	String PinCode=scanner.next();
	
	
	StoreBean storeBean = new StoreBean(storeId,storename,storestreet,storemobile,storecity,storestate,PinCode);
	Boolean message = adminDao.modifyStore(storeBean);
	
	if(message) {
		System.out.println("store modified");
		getData();
	}
	else {
		System.out.println("Wrong Store id | or something went wrong | Try again");
		modifyStore();
	}
	
	

}

// method for modify Food
private void modifyFood() {
	log.info("Inside modify food");
	
	System.out.println("Enter Store ID from given stores!!");
	viewAllStore();
	int sId = scanner.nextInt();
	
	
	System.out.println("Enter food ID !!");
	viewAllFood();
	

	
	System.out.println("Enter the food id");
	int fid = scanner.nextInt();
	
	System.out.println("Enter foodname");
	String fname=scanner.next();
	
	System.out.println("Enter the type");
	String ftype=scanner.next();
	
	System.out.println("Enter the size");
	String fsize=scanner.next();
	
	System.out.println("Enter food quantity");
	int fquantity=scanner.nextInt();
	
	System.out.println("Enter the price");
	int fprice=scanner.nextInt();
	
	System.out.println("Enter the storeId");
	int storeId=scanner.nextInt();
	
	
	
	FoodBean foodBean = new FoodBean(fid,fname,ftype,fsize,fquantity,fprice,storeId);
	Boolean message = adminDao.modifyFood(foodBean);
	
	if(message) {
		System.out.println("food updated");
		getData();
	}
	else {
		System.out.println("Try Again");
		modifyFood();
	}
	

}

}
