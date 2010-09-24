package com.irelaxa.irtk.client;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.users.User;


public class ProductPOJO implements Serializable {

  
  private User user;
 
  private String bizName;
  
  private String price;

  private Date createDate;

private String productType;

 
  public ProductPOJO() {
    this.createDate = new Date();
  }

  public ProductPOJO(User user, String bizName, String productType, String price) {
    this();
    this.user = user;
    this.bizName = bizName;
    this.productType = productType;
    this.price = price; 
  }

  public User getUser() {
    return this.user;
  }

  public Date getCreateDate() {
    return this.createDate;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setBizName(String bizName) {
		this.bizName = bizName;
	}
  public String getBizName() {
		return bizName;
	}
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	 
}