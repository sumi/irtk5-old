package com.irelaxa.irtk.server;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MentorBiz {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  @Persistent
  private User user;
  @Persistent
  private String skills;
  @Persistent
  private String time;
  @Persistent
  private String menteeDes;
  @Persistent
  private String mentorDes;
  @Persistent
  private Date startDate;
  @Persistent
  private Date endDate;
  @Persistent
  private String bizName;
  @Persistent
  private String contactName;
@Persistent
  private Date createDate;


 
  public MentorBiz() {
    this.createDate = new Date();
  }

  public MentorBiz(User user, String skills, String time, String menteeDes, String mentorDes,
		  Date sDate, Date eDate, String bizName, String contactName) {
    this();
    this.user = user;
    this.skills = skills;
    this.time = time;
    this.menteeDes = menteeDes; 
    this.mentorDes = mentorDes;
    this.startDate = sDate;
    this.endDate = eDate;
    this.bizName = bizName;
    this.contactName = contactName;
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
  
  public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
  
public String getSkills() {
	return skills;
}

public void setSkills(String skills) {
	this.skills = skills;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getMenteeDes() {
	return menteeDes;
}

public void setMenteeDes(String menteeDes) {
	this.menteeDes = menteeDes;
}

public String getMentorDes() {
	return mentorDes;
}

public void setMentorDes(String mentorDes) {
	this.mentorDes = mentorDes;
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

public String getBizName() {
	return bizName;
}

public void setBizName(String bizName) {
	this.bizName = bizName;
}

public String getContactName() {
	return contactName;
}

public void setContactName(String contactName) {
	this.contactName = contactName;
}

  }