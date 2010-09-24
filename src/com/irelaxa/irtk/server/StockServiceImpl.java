package com.irelaxa.irtk.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.irelaxa.irtk.client.NotLoggedInException;
import com.irelaxa.irtk.client.StockService;
import com.irelaxa.irtk.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class StockServiceImpl extends RemoteServiceServlet implements
StockService {

  private static final Logger LOG = Logger.getLogger(StockServiceImpl.class.getName());
  private static final PersistenceManagerFactory PMF =
      JDOHelper.getPersistenceManagerFactory("transactions-optional");

  public void addStock(Stack dataObject, String objectName) throws NotLoggedInException {
    checkLoggedIn();
    PersistenceManager pm = getPersistenceManager();
    LOG.log(Level.WARNING, "career manager objectName "+objectName);
    try {
    	/*if(objectName.equals("vendor")){
    		 LOG.log(Level.WARNING, "inside server add stock the object name is "+objectName);
    		pm.makePersistent(new Product(getUser(), (String)dataObject.pop(), (String)dataObject.pop(), (String)dataObject.pop()));
    	}*/
    	if(objectName.matches("goal")){
    		 pm.makePersistent(new Stock(getUser(), (String)dataObject.pop(), (String)dataObject.pop(), (String)dataObject.pop(), (Date)dataObject.pop(), (Date)dataObject.pop()));
    	}
    	if(objectName.matches("product")){
    		LOG.log(Level.WARNING, "product objectName "+objectName);
    	      pm.makePersistent(new Product(getUser(), (String)dataObject.pop(), (String)dataObject.pop(), (String)dataObject.pop()));
    	    	}
    	if(objectName.matches("careermanager")){
    		
  	      pm.makePersistent(new Intern(getUser(), (String)dataObject.pop(), (String)dataObject.pop(), (String)dataObject.pop(), 
  	    		(String)dataObject.pop(), 
  	    		(Date)dataObject.pop(), (Date)dataObject.pop(), (String)dataObject.pop(), 
  	    		(String)dataObject.pop(), (String)dataObject.pop(), (String)dataObject.pop()));
  	    	}
    	if(objectName.matches("internbiz")){
  	      pm.makePersistent(new InternBiz(getUser(), (String)dataObject.pop(), 
  	    		  (String)dataObject.pop(), (String)dataObject.pop(), (String)dataObject.pop(), 
  	    		  (Date)dataObject.pop(), (Date)dataObject.pop(), (String)dataObject.pop(), 
  	    		  (String)dataObject.pop()));
  	    	}
    	if(objectName.matches("mentorbiz")){
  	      pm.makePersistent(new MentorBiz(getUser(), (String)dataObject.pop(), (String)dataObject.pop(), 
  	    		  (String)dataObject.pop(), (String)dataObject.pop(), (Date)dataObject.pop(), 
  	    		  (Date)dataObject.pop(), (String)dataObject.pop(), (String)dataObject.pop()));
  	    	}
    } finally {
      pm.close();
    }
  }
  
 

  public void removeStock(String symbol) throws NotLoggedInException {
    checkLoggedIn();
    PersistenceManager pm = getPersistenceManager();
    
    try {
      long deleteCount = 0;
      Query q = pm.newQuery(Stock.class, "user == u");
      q.declareParameters("com.google.appengine.api.users.User u");
      List<Stock> stocks = (List<Stock>) q.execute(getUser());
      for (Stock stock : stocks) {
    	  if(stock != null) {
        if (symbol.equals(stock.getSymbol())) {
          deleteCount++;
          pm.deletePersistent(stock);
        }
      }
      }
      if (deleteCount != 1) {
        LOG.log(Level.WARNING, "removeStock deleted "+deleteCount+" Stocks");
      }
    } finally {
      pm.close();
    }
  }

  public String[][] getDatingGoals() throws NotLoggedInException {
    checkLoggedIn();
    PersistenceManager pm = getPersistenceManager();
    String[][] goals;
    try {
      Query q = pm.newQuery(Stock.class, "user == u && symbol == 'Dating'");
      q.declareParameters("com.google.appengine.api.users.User u");
      //q.setFilter("goalType == 'Dating'");
      q.setOrdering("createDate");
      List<Stock> stocks = (List<Stock>) q.execute(getUser());
      goals = new String[stocks.size()][6];
      LOG.log(Level.WARNING, "the getDatingGoals Query "+ q);
      int i =0;
      for (Stock stock : stocks) {
    	  goals[i][0] = stock.getGoalType();
    	  goals[i][1] = stock.getSymbol();
    	  goals[i][2] = stock.getBudget();
    	  goals[i][3] = stock.getStartDate().toString();
    	  goals[i][4] = stock.getEndDate().toString();
    	  i++;
      }
    } finally {
      pm.close();
    }
    return  goals;
  }
  public String[][] getAllGoals() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] goals;
	    Date today = new Date();
	    try {
	      Query q = pm.newQuery(Stock.class, "user == u");
	      q.declareParameters("com.google.appengine.api.users.User u");
	      q.setOrdering("createDate");
	      List<Stock> stocks = (List<Stock>) q.execute(getUser());
	      goals = new String[stocks.size()][7];
	      int i =0;
	      for (Stock stock : stocks) {
	    	  goals[i][0] = stock.getGoalType();
	    	  goals[i][1] = stock.getSymbol();
	    	  goals[i][2] = stock.getBudget();
	    	 // goals[i][3] = stock.getStartDate().toString();
	    	  goals[i][3] = FieldVerifier.getMonth(stock.getStartDate().getMonth())+" "+Integer.toString(stock.getStartDate().getDate())+" " +Integer.toString((stock.getStartDate().getYear()+1900));
	    	  goals[i][4] = FieldVerifier.getMonth(stock.getEndDate().getMonth())+" "+Integer.toString(stock.getEndDate().getDate())+" " +Integer.toString((stock.getEndDate().getYear()+1900));
	    	  goals[i][5] = Integer.toString((int)(stock.getEndDate().getTime()-today.getTime())/86400000);
	    	  LOG.log(Level.WARNING, "Remaining Days "+goals[i][5]);
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  goals;
	  }
  
  public String[][] getProducts() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] products;
	    try {
	      Query q = pm.newQuery(Product.class, "user == u");
	      q.declareParameters("com.google.appengine.api.users.User u");
	      q.setOrdering("createDate");
	      List<Product> dsproducts = (List<Product>) q.execute(getUser());
	      products = new String[dsproducts.size()][6];
	      int i =0;
	      for (Product product : dsproducts) {
	    	  products[i][0] = product.getBizName();
	    	  products[i][1] = product.getProductType();
	    	  products[i][2] = product.getPrice();
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  products;
	  }
  
  public String[][] getAllInternships() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] internships;
	    try {
	      Query q = pm.newQuery(InternBiz.class);
	      q.setOrdering("createDate");
	      List<InternBiz> dsinternships = (List<InternBiz>) q.execute();
	      LOG.log(Level.WARNING, "Get all internships Query "+ q);
	      internships = new String[dsinternships.size()][8];
	      int i =0;
	      for (InternBiz internship : dsinternships) {
	    	  internships[i][0] = internship.getSkills();
	    	  internships[i][1] = internship.getTime();
	    	  internships[i][2] = internship.getproduct();
	    	  internships[i][3] = internship.getpay();
	    	  internships[i][4] = internship.getStartDate().toString();
	    	  internships[i][5] = internship.getEndDate().toString();
	    	  internships[i][6] = internship.getBizName();
	    	  internships[i][7] = internship.getContactName();
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  internships;
	  }
  
  public String[][] getAllInterns() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] interns;
	    try {
	      Query q = pm.newQuery(Intern.class);
	      q.setOrdering("createDate");
	      List<Intern> dsinterns = (List<Intern>) q.execute();
	      LOG.log(Level.WARNING, "Get all internships "+ q);
	      int i =0;
	      interns = new String[dsinterns.size()][10];
	      for (Intern intern : dsinterns) {
	    	  interns[i][0] = intern.getlongTermGoal();
	    	  interns[i][1] = intern.getshortTermGoal();
	    	  interns[i][2] = intern.getavailableTimes();
	    	  interns[i][3] = intern.getStipend();
	    	  interns[i][4] = intern.getStartDate().toString();
	    	  interns[i][5] = intern.getEndDate().toString();
	    	  interns[i][6] = intern.getFirstName();
	    	  interns[i][7] = intern.getLastName();
	    	  interns[i][8] = intern.getUniversity();
	    	  interns[i][9] = intern.getDegree();
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  interns;
	  }
  public String[][] getMyCareerGoals() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] interns;
	    try {
	      Query q = pm.newQuery(Intern.class, "user == u");
	      q.declareParameters("com.google.appengine.api.users.User u");
	      q.setOrdering("createDate");
	      List<Intern> dsinterns = (List<Intern>) q.execute(getUser());
	      interns = new String[dsinterns.size()][10];
	      LOG.log(Level.WARNING, "Get all internships "+ q);
	      int i =0;
	      for (Intern intern : dsinterns) {
	    	  interns[i][0] = intern.getlongTermGoal();
	    	  interns[i][1] = intern.getshortTermGoal();
	    	  interns[i][2] = intern.getavailableTimes();
	    	  interns[i][3] = intern.getStipend();
	    	  interns[i][4] = intern.getStartDate().toString();
	    	  interns[i][5] = intern.getEndDate().toString();
	    	  interns[i][6] = intern.getFirstName();
	    	  interns[i][7] = intern.getLastName();
	    	  interns[i][8] = intern.getUniversity();
	    	  interns[i][9] = intern.getDegree();
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  interns;
	  }
  public String[][] getMyInternshipsBizGoals() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] internsships;
	    try {
	      Query q = pm.newQuery(InternBiz.class, "user == u");
	      q.declareParameters("com.google.appengine.api.users.User u");
	      q.setOrdering("createDate");
	      List<InternBiz> dsinternsBiz = (List<InternBiz>) q.execute(getUser());
	      internsships = new String[dsinternsBiz.size()][10];
	      LOG.log(Level.WARNING, "Get My internshipsBiz "+ q);
	      int i =0;
	      for (InternBiz internBiz : dsinternsBiz) {
	    	  internsships[i][0] = internBiz.getSkills();
	    	  internsships[i][1] = internBiz.getTime();
	    	  internsships[i][2] = internBiz.getproduct();
	    	  internsships[i][3] = internBiz.getpay();
	    	  internsships[i][4] = internBiz.getStartDate().toString();
	    	  internsships[i][5] = internBiz.getEndDate().toString();
	    	  internsships[i][6] = internBiz.getBizName();
	    	  internsships[i][7] = internBiz.getContactName();
	    	 
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  internsships;
	  }  
  public String[][] getMyMentorshipsBizGoals() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] internsships;
	    try {
	      Query q = pm.newQuery(MentorBiz.class, "user == u");
	      q.declareParameters("com.google.appengine.api.users.User u");
	      q.setOrdering("createDate");
	      List<MentorBiz> dsinternsBiz = (List<MentorBiz>) q.execute(getUser());
	      internsships = new String[dsinternsBiz.size()][10];
	      LOG.log(Level.WARNING, "Get My internshipsBiz "+ q);
	      int i =0;
	      for (MentorBiz internBiz : dsinternsBiz) {
	    	  internsships[i][0] = internBiz.getSkills();
	    	  internsships[i][1] = internBiz.getTime();
	    	  internsships[i][2] = internBiz.getMenteeDes();
	    	  internsships[i][3] = internBiz.getMentorDes();
	    	  internsships[i][4] = internBiz.getStartDate().toString();
	    	  internsships[i][5] = internBiz.getEndDate().toString();
	    	  internsships[i][6] = internBiz.getBizName();
	    	  internsships[i][7] = internBiz.getContactName();
	    	 
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  internsships;
	  }  
public String[][] getAllMentorships() throws NotLoggedInException {
	    checkLoggedIn();
	    PersistenceManager pm = getPersistenceManager();
	    String[][] mentorships;
	    try {
	      Query q = pm.newQuery(MentorBiz.class);
	      q.setOrdering("createDate");
	      List<MentorBiz> dsmentorships = (List<MentorBiz>) q.execute();
	      mentorships = new String[dsmentorships.size()][8];
	      LOG.log(Level.WARNING, "Get all mentorships "+ q);
	      int i =0;
	      for (MentorBiz mentor : dsmentorships) {
	    	  mentorships[i][0] = mentor.getSkills();
	    	  mentorships[i][1] = mentor.getTime();
	    	  mentorships[i][2] = mentor.getMenteeDes();
	    	  mentorships[i][3] = mentor.getMentorDes();
	    	  mentorships[i][4] = mentor.getStartDate().toString();
	    	  mentorships[i][5] = mentor.getEndDate().toString();
	    	  mentorships[i][6] = mentor.getBizName();
	    	  mentorships[i][7] = mentor.getContactName();
	    	  i++;
	      }
	    } finally {
	      pm.close();
	    }
	    return  mentorships;
	  }

  private void checkLoggedIn() throws NotLoggedInException {
    if (getUser() == null) {
      throw new NotLoggedInException("Not logged in.");
    }
  }

  private User getUser() {
    UserService userService = UserServiceFactory.getUserService();
    return userService.getCurrentUser();
  }

  private PersistenceManager getPersistenceManager() {
    return PMF.getPersistenceManager();
	  
  }
}