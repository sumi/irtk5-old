package com.irelaxa.irtk.client;

import java.util.Stack;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;


public abstract class TopBarViewListener {
	final LoginServiceAsync loginService = GWT.create(LoginService.class);
	final LoginInfo loginInfo = null;
	abstract void onGoalWordsSelect( Widget w );
	abstract void onCareerManagerViewSelect( Widget w );
	abstract void onPersonalGoalsSelect();
	abstract void onShowAllMyProductsSelect();
	abstract void onAllGoalsSelect();
	abstract void onWorkLifeBalanceSelect( Widget w );
	abstract void addStock( Stack dataStack, String objectName);
	
}