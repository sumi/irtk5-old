package com.irelaxa.irtk.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("setgoal")
public interface GoalService extends RemoteService {
  public void addGoal(String goalType, String goal, String budget, Date startDate, Date endDate) throws NotLoggedInException;
  public void removeGoal(String symbol) throws NotLoggedInException;
  public String[] getGoal() throws NotLoggedInException;
}