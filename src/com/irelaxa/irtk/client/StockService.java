package com.irelaxa.irtk.client;

import java.util.Date;
import java.util.List;
import java.util.Stack;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.irelaxa.irtk.server.Stock;

@RemoteServiceRelativePath("stock")
public interface StockService extends RemoteService {
  public void addStock(Stack dataObject, String objectName) throws NotLoggedInException;
  public void removeStock(String symbol) throws NotLoggedInException;
  public String[][] getAllGoals() throws NotLoggedInException;
  public String[][] getDatingGoals() throws NotLoggedInException;
  public String[][] getProducts() throws NotLoggedInException;
  public String[][] getAllInterns() throws NotLoggedInException;
  public String[][] getAllInternships() throws NotLoggedInException;
  public String[][] getAllMentorships() throws NotLoggedInException;
  public String[][] getMyCareerGoals() throws NotLoggedInException;
  public String[][] getMyInternshipsBizGoals() throws NotLoggedInException;
  public String[][] getMyMentorshipsBizGoals() throws NotLoggedInException;
}