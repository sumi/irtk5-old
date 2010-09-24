package com.irelaxa.irtk.server;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Stock {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  @Persistent
  private User user;
  @Persistent
  private String symbol;
  @Persistent
  private String goalType;
  @Persistent
  private String budget;
  @Persistent
  private String spending = "0";
  @Persistent
  Boolean  isPublic = false;
  
  @Persistent
  private Date startDate;
  
  @Persistent
  private Date endDate;

@Persistent
  private Date createDate;

  public Stock() {
    this.createDate = new Date();
  }

  public Stock(User user, String symbol, String goalType, String budget , Date startDate, Date endDate) {
    this();
    this.user = user;
    this.symbol = symbol;
    this.goalType = goalType;
    this.budget = budget;
   // this.spending = spending;
    this.startDate = startDate;
    this.endDate = endDate;
    
  }

  public Long getId() {
    return this.id;
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
	public String getSpending() {
		return spending;
	}
	public void setSpending(String spending) {
		this.spending = spending;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Boolean getIsPublic() {
		return isPublic;
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