package com.ntl.pos.bean;

public class StoreBean {

	private int StoreId;
	private String name;
	private String street;
	private String mobileno;
	private String city;
	private String state;
	private String pinCode;
	/**
	 * 
	 */
	public StoreBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param storeId
	 * @param name
	 * @param street
	 * @param mobileno
	 * @param city
	 * @param state
	 * @param pinCode
	 */
	public StoreBean(int storeId, String name, String street, String mobileno, String city, String state,
			String pinCode) {
		super();
		this.StoreId = storeId;
		this.name = name;
		this.street = street;
		this.mobileno = mobileno;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	/**
	 * @return the storeId
	 */
	public int getStoreId() {
		return StoreId;
	}
	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}
	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StoreBean [StoreId=" + StoreId + ", name=" + name + ", street=" + street + ", mobileno=" + mobileno
				+ ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	
	
}
