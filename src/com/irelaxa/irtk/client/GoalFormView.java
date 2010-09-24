package com.irelaxa.irtk.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.datepicker.client.DateBox;

public class GoalFormView extends Composite{
	private FlexTable goalFormTable = new FlexTable();
	FlexCellFormatter cellFormatter = goalFormTable.getFlexCellFormatter();
	private Button sendButton = new Button("Save & Match My Goal");
	private ListBox goalTypeDropBox = new ListBox(false);
	final private String[] goalTypes = {"Nutrition", "Fitness", "Dating", "Fashion", "Career", "College Admission"};
	private ListBox goalDropBox = new ListBox(false);
	final ListBox budgetDropBox = new ListBox(false);
	final String[] nutrition = {"Weight Loss", "Vegan", "Low Carb"};
    final String[] fitness = {"Toning", "Lower Body", "Upper Body"};
    final String[] dating = {"have fun", "committed relationship", "Marriage"};
    final String[] fashion = {"Business Casual", "Causal", "Sexy"};
    final String[] career = {"Doctor", "Engineer", "Lawyer"};
    final String[] admission = {"Graduate School", "UnderGraduate", "PhD"};

 // Create a DateBox
    DateTimeFormat dateFormat = DateTimeFormat.getLongDateFormat();
    DateBox sdateBox = new DateBox();
    DateBox edateBox = new DateBox();
    

	GoalFormView(){
		initWidget(goalFormTable);
		goalFormTable.setWidth("32em");
		goalFormTable.setCellSpacing(5);
		goalFormTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		goalFormTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		goalFormTable.setWidget(2, 0, new HTML("Select Goal Type"));
		for (int i = 0; i < goalTypes.length; i++) {
			goalTypeDropBox.addItem(goalTypes[i]);
	      }
		goalFormTable.setWidget(2, 1, goalTypeDropBox);
		goalDropBox.setWidth("11em");
		goalDropBox.setVisibleItemCount(3);
		goalTypeDropBox.addChangeHandler(new ChangeHandler() {
		      public void onChange(ChangeEvent event) {
		        showCategory(goalDropBox, goalTypeDropBox.getSelectedIndex());
		        showGoalDates();
		      }
		    });
		//showGoalDates();
		sendButton.addStyleName("sendButton");
		sendButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        //addStock();
		      }
		    });
		
	}
	
	private void showCategory(final ListBox listBox, final int category) {
		listBox.clear();
	  String[] listData = null;
	  
	  switch (category) {
	    case 0:
	      listData = nutrition;
	      break;
	    case 1:
	      listData = fitness;
	      break;
	    case 2:
	      listData = dating;
	      break;
	    case 3:
	        listData = fashion;
	        break;
	    case 4:
	        listData = career;
	        break;
	      case 5:
	          listData = admission;
	          break;
	  }
	  for (int i = 0; i < listData.length; i++) {
		  listBox.addItem(listData[i]);
	  }
	 // goalFormTable.clear();
	  goalFormTable.setWidget(3, 0, new HTML("Select Goal"));
	  goalFormTable.setWidget(3, 1, listBox);
	 
	
	listBox.addChangeHandler(new ChangeHandler() {
	  public void onChange(ChangeEvent event) {
	    showBudget(budgetDropBox, category, listBox.getSelectedIndex());
	    
	  }
	});
	}
	private void showBudget(ListBox budgetListBox, int goalType, int goal) {
		budgetListBox.clear();
		String[] listData = null;
		  String[] nutrition1 = {"<$250", "<500", "<750"};
		  String[] nutrition2 = {"<$255", "<501", "<752"};
		  String[] nutrition3 = {"<$258", "<509", "<751"};
		  String[] fitness1 = {"<101", "<251", "<551"};
		  String[] fitness2 = {"<102", "<252", "<552"};
		  String[] fitness3 = {"<103", "<253", "<553"};
		  String[] dating1 = {"<521", "<715", "<1031"};
		  String[] dating2 = {"<522", "<716", "<1032"};
		  String[] dating3 = {"<523", "<717", "<1033"};
		  String[] fashion1 = {"<501", "<101", "<151"};
		  String[] fashion2 = {"<502", "<102", "<152"};
		  String[] fashion3 = {"<503", "<103", "<153"};
		  String[] career1 = {"<50000", "<100000", "<150000"};
		  String[] career2 = {"<50001", "<100001", "<150001"};
		  String[] career3 = {"<50002", "<100002", "<150002"};
		  String[] admission1 = {"<500", "<1000", "<1500"};
		  String[] admission2 = {"<501", "<1001", "<1501"};
		  String[] admission3 = {"<502", "<1002", "<1502"};
		  switch (goalType) {
		    case 0:
			switch(goal){
		    	case 0:	
		      listData = nutrition1;
		      break;
		    	case 1:
		      listData = nutrition2;
		      break;
		    	case 2:
		  	  listData = nutrition3;
		  	  break;
		    	}
		      break;
		    case 1:
			switch(goal){
		    	case 0:	
		      listData = fitness1;
		      break;
		    	case 1:
		      listData = fitness2;
		      break;
		    	case 2:
		  	  listData = fitness3;
		  	  break;
		    	}
		      break;
		    case 2:
			switch(goal){
		    	case 0:	
		      listData = dating1;
		      break;
		    	case 1:
		      listData = dating2;
		      break;
		    	case 2:
		  	  listData = dating3;
		  	  break;
		    	}
		      break;
		    case 3:
			switch(goal){
		    	case 0:	
		      listData = fashion1;
		      break;
		    	case 1:
		      listData = fashion2;
		      break;
		    	case 2:
		  	  listData = fashion3;
		  	  break;
		    	}
		        break;
		    case 4:
			switch(goal){
		    	case 0:	
		      listData = career1;
		      break;
		    	case 1:
		      listData = career2;
		      break;
		    	case 2:
		  	  listData = career3;
		  	  break;
		    	}
			      break;
			case 5:
			switch(goal){
		    	case 0:	
		      listData = admission1;
		      break;
		    	case 1:
		      listData = admission2;
		      break;
		    	case 2:
		  	  listData = admission3;
		  	  break;
		    	}
			      break;
		  }
		  
		  
		  for (int i = 0; i < listData.length; i++) {
			  budgetListBox.addItem(listData[i]);
		  }
		  
		  goalFormTable.setWidget(4, 0, new HTML("Select Budget"));
		  goalFormTable.setWidget(4, 1, budgetListBox);
		  }
	
	private void showGoalDates(){
		sdateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		goalFormTable.setWidget(5, 0, new HTML("Goal Start Date"));
		goalFormTable.setWidget(5, 1, sdateBox);
		 
	    
	    
	    
	    edateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
	    
	    goalFormTable.setWidget(6, 0, new HTML("Goal End Date"));
	    goalFormTable.setWidget(6, 1, edateBox);
	    goalFormTable.setWidget(7, 1,sendButton);
		  
	}

	
}