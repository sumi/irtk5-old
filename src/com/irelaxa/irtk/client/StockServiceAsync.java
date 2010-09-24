package com.irelaxa.irtk.client;

import java.util.Date;
import java.util.List;
import java.util.Stack;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.irelaxa.irtk.server.Stock;

public interface StockServiceAsync {
  public void addStock(Stack dataObject, String objectName, AsyncCallback<Void> async);
  public void removeStock(String symbol, AsyncCallback<Void> async);
  public void getAllGoals(AsyncCallback<String[][]> async);
  public void getDatingGoals(AsyncCallback<String[][]> async);
  public void getProducts(AsyncCallback<String[][]> async);
  public void getAllInterns(AsyncCallback<String[][]> async);
  public void getAllInternships(AsyncCallback<String[][]> async);
  public void getAllMentorships(AsyncCallback<String[][]> async);
  public void getMyCareerGoals(AsyncCallback<String[][]> async);
  public void getMyInternshipsBizGoals(AsyncCallback<String[][]> async);
  public void getMyMentorshipsBizGoals(AsyncCallback<String[][]> async);
  
}