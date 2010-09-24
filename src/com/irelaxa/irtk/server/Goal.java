package com.irelaxa.irtk.server;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Goal {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  @Persistent
  private User user;
  @Persistent
  private String goalType;
  @Persistent
  private String goal;
  @Persistent
  private String budget;
  
  @Persistent
  private Date createDate;
  @Persistent
  private Date startDate;
  @Persistent
  private Date endDate;

  public Goal() {
    this.createDate = new Date();
  }

  public Goal(User user,String goalType, String goal,String budget, Date startDate, Date endDate) {
    this();
    this.user = user;
    this.goalType = goalType;
    this.goal = goal;
    this.budget = budget;
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
 

  public Long getId() {
    return this.id;
  }

  public User getUser() {
    return this.user;
  }

  public String getgoalType() {
	    return this.goalType;
	  }
  public String getGoal() {
    return this.goal;
  }
  
  public String getbudget() {
	    return this.budget;
	  }

  public Date getCreateDate() {
    return this.createDate;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setGoalType(String goalType) {
	    this.goalType = goalType;
	  }
  public void setgoal(String goal) {
    this.goal = goal;
  }
  
  public Date getStartDate() {
	    return this.startDate;
	  }
  
  public Date getEndDate() {
	    return this.endDate;
	  }
  
  public void setbudget(String budget) {
	    this.budget = budget;
	  }
  public void setStartDate(Date startDate) {
	    this.startDate = startDate;

	  }
  public void setEndDate(Date endDate) {
	    this.endDate = endDate;

	  }
}
