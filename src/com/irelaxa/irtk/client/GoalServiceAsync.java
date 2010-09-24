package com.irelaxa.irtk.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GoalServiceAsync {
  public void addGoal(String goalType, String goal, String budget, Date startDate, Date endDate, AsyncCallback<Void> async);
  public void removeGoal(String symbol, AsyncCallback<Void> async);
  public void getGoal(AsyncCallback<String[]> async);
}