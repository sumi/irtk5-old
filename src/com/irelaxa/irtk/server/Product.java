package com.irelaxa.irtk.server;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Product {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  @Persistent
  private User user;
  @Persistent
  private String bizName;
  @Persistent
  private String price;
@Persistent
  private Date createDate;
@Persistent
private String productType;

 
  public Product() {
    this.createDate = new Date();
  }

  public Product(User user, String bizName, String productType, String price) {
    this();
    this.user = user;
    this.bizName = bizName;
    this.productType = productType;
    this.price = price; 
  }

  public Long getId() {
    return this.id;
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