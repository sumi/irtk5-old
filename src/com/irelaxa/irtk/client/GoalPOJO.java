package com.irelaxa.irtk.client;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;


public class GoalPOJO implements Serializable {


  private User user;
 
  private String symbol;

  private String goalType;
 
  private String budget;

  private Date startDate;
  
  private Date endDate;


  private Date createDate;

  public GoalPOJO() {
    this.createDate = new Date();
  }

  public GoalPOJO(User user, String symbol, String goalType, String budget , Date startDate, Date endDate) {
    this();
    this.user = user;
    this.symbol = symbol;
    this.goalType = goalType;
    this.budget = budget;
    this.startDate = startDate;
    this.endDate = endDate;
    
  }
  public User getUser() {
    return this.user;
  }

  public String getSymbol() {
    return this.symbol;
  }
  
  public String getGoalType() {
	    return this.goalType;
	  }
  public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}


  public Date getCreateDate() {
    return this.createDate;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }
  
  public void setGoalType(String goalType) {
	    this.goalType = goalType;
	  }

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getStartDate() {
	return startDate;
}

/**
 * @param endDate the endDate to set
 */
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

/**
 * @return the endDate
 */
public Date getEndDate() {
	return endDate;
}
}