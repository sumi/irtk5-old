package com.irelaxa.irtk.client;

import java.util.Stack;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.irelaxa.irtk.client.TopBarViewListener;

public class VendorFormView extends Composite {
	private Stack goalObject = new Stack();
	final private TopBarViewListener topBarViewListener;
	private FlexTable vendorTable = new FlexTable();
	FlexCellFormatter cellFormatter = vendorTable.getFlexCellFormatter();
	private Button registerProductButton = new Button("Register the Product");
	private ListBox listBox1 = new ListBox();
	final String[] vgoalTypes = {"Nutrition", "Fitness", "Dating", "Fashion", "Career", "College Admission"};
    final String[] nutrition = {"Weight Loss", "Vegan", "Low Carb"};
    final String[] fitness = {"Toning", "Lower Body", "Upper Body"};
    final String[] dating = {"have fun", "committed relationship", "Marriage"};
    final String[] fashion = {"Business Casual", "Causal", "Sexy"};
    final String[] career = {"Doctor", "Engineer", "Lawyer"};
    final String[] admission = {"Graduate School", "UnderGraduate", "PhD"};
    private ListBox vdropBox = new ListBox(false);
    private ListBox vmultiBox = new ListBox(true);
    private AbsolutePanel goalPanel = new AbsolutePanel();
    private Label goalLable = new Label("Select Your Goal");
    final ListBox budgetDropBox = new ListBox(false);
    private AbsolutePanel budgetPanel = new AbsolutePanel();
    private Label bugetLable = new Label("Budget");
    final SuggestBox businessName = new SuggestBox(createCountriesOracle());
    final SuggestBox product = new SuggestBox(createCountriesOracle());
    final SuggestBox price = new SuggestBox(createCountriesOracle());
	  private final LoginServiceAsync loginService = GWT.create(LoginService.class);

    LoginInfo loginInfo;
	VendorFormView(TopBarViewListener topBarViewListener){
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(LoginInfo result) {
		        loginInfo = result;
		      }
		    });
		this.topBarViewListener = topBarViewListener;
		//this.loginInfo = 
		initWidget(vendorTable);
		vendorTable.setWidth("32em");
		vendorTable.setCellSpacing(5);
		vendorTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		vendorTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		vendorTable.setWidget(1, 0, new HTML("<b>List your products and services</b>"));
		addGoalType();
		/*registerButton.addStyleName("registerButton");
		registerButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		      //  addStock();
		      }
		    });*/
	}
	public void addGoalType(){
		
	    for (int i = 0; i < vgoalTypes.length; i++) {
	        vdropBox.addItem(vgoalTypes[i]);
	      }
	    vdropBox.ensureDebugId("vcwListBox-dropBox");
	    vmultiBox.ensureDebugId("vcwListBox-multiBox");
	    vmultiBox.setWidth("11em");
	    vmultiBox.setVisibleItemCount(3);
	    //RootPanel.get("goalTypeDropBox").add(dropBox);
	    vendorTable.setWidget(2, 0, new HTML("Business Name"));
	    vendorTable.setWidget(2, 1, businessName);
	    vendorTable.setWidget(3, 0, new HTML("Product or Service Type"));
		 vendorTable.setWidget(3, 1, product);
		 vendorTable.setWidget(4, 0, new HTML("Price Range"));
		 vendorTable.setWidget(4, 1, price);
		 vendorTable.setWidget(5, 1, registerProductButton);
		
	 // Add a handler to handle drop box events
	    vdropBox.addChangeHandler(new ChangeHandler() {
	      public void onChange(ChangeEvent event) {
	        showCategory(vmultiBox, vdropBox.getSelectedIndex());
	        vmultiBox.ensureDebugId("vcwListBox-multiBox");
	      }
	    });
	}
	
	 private void showCategory(ListBox listBox, final int category) {
			listBox1 = listBox;
			listBox1.clear();
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
			  listBox1.addItem(listData[i]);
		  }
		 goalPanel.clear();
		 goalPanel.add(goalLable);
		 goalPanel.add(listBox1, vdropBox.getAbsoluteLeft(), goalLable.getAbsoluteTop());
		 vendorTable.setWidget(3, 0, new HTML("Product or Service Type"));
		 vendorTable.setWidget(3, 1, product);
		 
		
		listBox.addChangeHandler(new ChangeHandler() {
		  public void onChange(ChangeEvent event) {
		    showBudget(budgetDropBox, category, vmultiBox.getSelectedIndex());
		    budgetDropBox.ensureDebugId("vcwListBox-budgetDropBox");
		  }
		});
		}
	 
	 private void showBudget(ListBox budgetListBox, int goalType, int goal) {
			budgetListBox.clear();
			//goalTypeValue = goalTypes[goalType];
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
			    	//goalValue = nutrition[goal];
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
			    	//goalValue = fitness[goal];
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
			    	//goalValue = dating[goal];
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
			    	//goalValue = fashion[goal];
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
			    //	goalValue = career[goal];
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
					//goalValue = admission[goal];
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
			  budgetPanel.clear();
			  budgetPanel.add(bugetLable);
			  budgetPanel.add(budgetListBox, vdropBox.getAbsoluteLeft(), bugetLable.getAbsoluteTop());
			  vendorTable.setWidget(4, 0, new HTML("Select Price Range"));
			  vendorTable.setWidget(4, 1, budgetListBox);
			 
			 // RootPanel.get("flexTable").add(vendorTable);  
		   }
	 MultiWordSuggestOracle createCountriesOracle()
	 {
	     MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	     oracle.add("Nutrition");
	     oracle.add("Fitness");
	     oracle.add("Dating");
	     oracle.add("Fashion");
	     oracle.add("Career");
	     oracle.add("College Admission");
	     oracle.add("Weight Loss");
	     oracle.add("Vegan");
	     oracle.add("Low Carb");
	     oracle.add("Toning");
	     oracle.add("Lower Body");
	     oracle.add("Upper Body");
	     oracle.add("have fun");
	     oracle.add("committed relationship");
	     oracle.add("Business Casual");
	     oracle.add("Causal");
	     oracle.add("Sexy");
	     oracle.add("Doctor");
	     oracle.add("Engineer");
	     oracle.add("Lawyer");
	     oracle.add("Graduate School");
	     oracle.add("UnderGraduate");
	     oracle.add("PhD");
	     return oracle;
	 }
	 
	 public Button getregisterProductButton(){
		 return registerProductButton;
	 }
	 public String getBusinessName(){
		 return businessName.getValue();
	 }
	 public String getPrice(){
		 return price.getValue();
	 }
	 public String getProduct(){
		 return product.getValue();
	 }


}
