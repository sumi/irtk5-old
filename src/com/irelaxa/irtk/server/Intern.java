package com.irelaxa.irtk.server;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Intern {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  @Persistent
  private User user;
  @Persistent
  private String longTermGoal;
  @Persistent
  private String shortTermGoal;
  @Persistent
  private String availableTimes;
  @Persistent
  private String stipend;
  @Persistent
  private Date startDate;
  @Persistent
  private Date endDate;
  @Persistent
  private String firstName;
  @Persistent
  private String lastName;
  @Persistent
  private String university;
  @Persistent
  private String degree;
@Persistent
  private Date createDate;


 
  public Intern() {
    this.createDate = new Date();
  }

  public Intern(User user, String longTermGoal, String shortTermGoal, String availableTimes, String stipend,
		  Date sDate, Date eDate, String fName, String lName, String university, String degree) {
    this();
    this.user = user;
    this.longTermGoal = longTermGoal;
    this.shortTermGoal = shortTermGoal;
    this.availableTimes = availableTimes; 
    this.stipend = stipend;
    this.startDate = sDate;
    this.endDate = eDate;
    this.firstName = fName;
    this.lastName = lName;
    this.university = university;
    this.degree = degree;
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

  public void setlongTermGoal(String longTermGoal) {
		this.longTermGoal = longTermGoal;
	}
  public String getlongTermGoal() {
		return longTermGoal;
	}
	public String getshortTermGoal() {
		return shortTermGoal;
	}

	public void setshortTermGoal(String shortTermGoal) {
		this.shortTermGoal = shortTermGoal;
	}

	public String getavailableTimes() {
		return availableTimes;
	}

	public void setavailableTimes(String availableTimes) {
		this.availableTimes = availableTimes;
	}
	public String getStipend() {
		return stipend;
	}

	public void setStipend(String stipend) {
		this.stipend = stipend;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	 
}