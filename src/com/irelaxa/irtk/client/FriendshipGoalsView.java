package com.irelaxa.irtk.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.irelaxa.irtk.client.TopBarViewListener;

public class FriendshipGoalsView extends Composite {
	private TopBarViewListener topBarViewListener;
	private FlexTable vendorTable = new FlexTable();
	FlexCellFormatter cellFormatter = vendorTable.getFlexCellFormatter();
	private Button registerButton = new Button("Save Your Friendship Goals");
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
    final SuggestBox income = new SuggestBox(createCountriesOracle());
    final SuggestBox expense = new SuggestBox(createCountriesOracle());
    final SuggestBox savings = new SuggestBox(createCountriesOracle());
	FriendshipGoalsView(){
		//this.topBarViewListener = topBarViewListener;
		initWidget(vendorTable);
		vendorTable.setWidth("32em");
		vendorTable.setCellSpacing(5);
		vendorTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		vendorTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		vendorTable.setWidget(1, 0, new HTML("<b>Set Your Friendship Goals</b>"));
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
	    vendorTable.setWidget(2, 0, new HTML("Do you have a Best Friend?"));
	    vendorTable.setWidget(2, 1, businessName);
	    vendorTable.setWidget(3, 0, new HTML("Do you have atleast 2 same sex friends?"));
		 vendorTable.setWidget(3, 1, product);
		 vendorTable.setWidget(4, 0, new HTML("Do you have atleast 2 opposite sex friends?"));
		 vendorTable.setWidget(4, 1, income);
		 vendorTable.setWidget(4, 0, new HTML("Do you have atleast one friend that you have spiritual bonding? "));
		 vendorTable.setWidget(4, 1, expense);
		 vendorTable.setWidget(4, 0, new HTML("Do you have atleast one friend with whom you can have non-sexual fun?"));
		 vendorTable.setWidget(4, 1, savings);
		 vendorTable.setWidget(5, 1, registerButton);
	   // vendorTable.setWidget(2, 1, vdropBox);
	   // RootPanel.get("flexTable").add(vendorTable);
	 //   topBarViewListener.onGoalWordsSelect(vdropBox);
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

	     oracle.add("Afghanistan");
	     oracle.add("Albania");
	     oracle.add("Algeria");
	     oracle.add("American Samoa");
	     oracle.add("Andorra");
	     oracle.add("Angola");
	     oracle.add("Anguilla");
	     oracle.add("Antarctica");
	     oracle.add("Antigua And Barbuda");
	     oracle.add("Argentina");
	     oracle.add("Armenia");
	     oracle.add("Aruba");
	     oracle.add("Australia");
	     oracle.add("Austria");
	     oracle.add("Azerbaijan");
	     oracle.add("Bahamas");
	     oracle.add("Bahrain");
	     oracle.add("Bangladesh");
	     oracle.add("Barbados");
	     oracle.add("Belarus");
	     oracle.add("Belgium");
	     oracle.add("Belize");
	     oracle.add("Benin");
	     oracle.add("Bermuda");
	     oracle.add("Bhutan");
	     oracle.add("Bolivia");
	     oracle.add("Bosnia And Herzegovina");
	     oracle.add("Botswana");
	     oracle.add("Bouvet Island");
	     oracle.add("Brazil");
	     oracle.add("British Indian Ocean Territory");
	     oracle.add("Brunei Darussalam");
	     oracle.add("Bulgaria");
	     oracle.add("Burkina Faso");
	     oracle.add("Burundi");
	     oracle.add("Cambodia");
	     oracle.add("Cameroon");
	     oracle.add("Canada");
	     oracle.add("Cape Verde");
	     oracle.add("Cayman Islands");
	     oracle.add("Central African Republic");
	     oracle.add("Chad");
	     oracle.add("Chile");
	     oracle.add("China");
	     oracle.add("Christmas Island");
	     oracle.add("Cocos (Keeling) Islands");
	     oracle.add("Colombia");
	     oracle.add("Comoros");
	     oracle.add("Congo, The Democratic Republic Of The");
	     oracle.add("Congo");
	     oracle.add("Cook Islands");
	     oracle.add("Costa Rica");
	     oracle.add("Cote D''ivoire");
	     oracle.add("Croatia");
	     oracle.add("Cuba");
	     oracle.add("Cyprus");
	     oracle.add("Czech Republic");
	     oracle.add("Denmark");
	     oracle.add("Djibouti");
	     oracle.add("Dominica");
	     oracle.add("Dominican Republic");
	     oracle.add("East Timor");
	     oracle.add("Ecuador");
	     oracle.add("Egypt");
	     oracle.add("El Salvador");
	     oracle.add("Equatorial Guinea");
	     oracle.add("Eritrea");
	     oracle.add("Estonia");
	     oracle.add("Ethiopia");
	     oracle.add("Falkland Islands (Malvinas)");
	     oracle.add("Faroe Islands");
	     oracle.add("Fiji");
	     oracle.add("Finland");
	     oracle.add("France");
	     oracle.add("French Guiana");
	     oracle.add("French Polynesia");
	     oracle.add("French Southern Territories");
	     oracle.add("Gabon");
	     oracle.add("Gambia");
	     oracle.add("Georgia");
	     oracle.add("Germany");
	     oracle.add("Ghana");
	     oracle.add("Gibraltar");
	     oracle.add("Greece");
	     oracle.add("Greenland");
	     oracle.add("Grenada");
	     oracle.add("Guadeloupe");
	     oracle.add("Guam");
	     oracle.add("Guatemala");
	     oracle.add("Guinea-Bissau");
	     oracle.add("Guinea");
	     oracle.add("Guyana");
	     oracle.add("Haiti");
	     oracle.add("Heard Island And Mcdonald Islands");
	     oracle.add("Holy See (Vatican City State)");
	     oracle.add("Honduras");
	     oracle.add("Hong Kong");
	     oracle.add("Hungary");
	     oracle.add("Iceland");
	     oracle.add("India");
	     oracle.add("Indonesia");
	     oracle.add("Iran, Islamic Republic Of");
	     oracle.add("Iraq");
	     oracle.add("Ireland");
	     oracle.add("Israel");
	     oracle.add("Italy");
	     oracle.add("Jamaica");
	     oracle.add("Japan");
	     oracle.add("Jordan");
	     oracle.add("Kazakstan");
	     oracle.add("Kenya");
	     oracle.add("Kiribati");
	     oracle.add("Korea, Democratic People''s Republic Of");
	     oracle.add("Korea, Republic Of");
	     oracle.add("Kuwait");
	     oracle.add("Kyrgyzstan");
	     oracle.add("Lao People''s Democratic Republic");
	     oracle.add("Latvia");
	     oracle.add("Lebanon");
	     oracle.add("Lesotho");
	     oracle.add("Liberia");
	     oracle.add("Libyan Arab Jamahiriya");
	     oracle.add("Liechtenstein");
	     oracle.add("Lithuania");
	     oracle.add("Luxembourg");
	     oracle.add("Macau");
	     oracle.add("Macedonia, The Former Yugoslav Republic Of");
	     oracle.add("Madagascar");
	     oracle.add("Malawi");
	     oracle.add("Malaysia");
	     oracle.add("Maldives");
	     oracle.add("Mali");
	     oracle.add("Malta");
	     oracle.add("Marshall Islands");
	     oracle.add("Martinique");
	     oracle.add("Mauritania");
	     oracle.add("Mauritius");
	     oracle.add("Mayotte");
	     oracle.add("Mexico");
	     oracle.add("Micronesia, Federated States Of");
	     oracle.add("Moldova, Republic Of");
	     oracle.add("Monaco");
	     oracle.add("Mongolia");
	     oracle.add("Montserrat");
	     oracle.add("Morocco");
	     oracle.add("Mozambique");
	     oracle.add("Myanmar");
	     oracle.add("Namibia");
	     oracle.add("Nauru");
	     oracle.add("Nepal");
	     oracle.add("Netherlands Antilles");
	     oracle.add("Netherlands");
	     oracle.add("New Caledonia");
	     oracle.add("New Zealand");
	     oracle.add("Nicaragua");
	     oracle.add("Niger");
	     oracle.add("Nigeria");
	     oracle.add("Niue");
	     oracle.add("Norfolk Island");
	     oracle.add("Northern Mariana Islands");
	     oracle.add("Norway");
	     oracle.add("Oman");
	     oracle.add("Pakistan");
	     oracle.add("Palau");
	     oracle.add("Palestinian Territory, Occupied");
	     oracle.add("Panama");
	     oracle.add("Papua New Guinea");
	     oracle.add("Paraguay");
	     oracle.add("Peru");
	     oracle.add("Philippines");
	     oracle.add("Pitcairn");
	     oracle.add("Poland");
	     oracle.add("Portugal");
	     oracle.add("Puerto Rico");
	     oracle.add("Qatar");
	     oracle.add("Reunion");
	     oracle.add("Romania");
	     oracle.add("Russian Federation");
	     oracle.add("Rwanda");
	     oracle.add("Saint Helena");
	     oracle.add("Saint Kitts And Nevis");
	     oracle.add("Saint Lucia");
	     oracle.add("Saint Pierre And Miquelon");
	     oracle.add("Saint Vincent And The Grenadines");
	     oracle.add("Samoa");
	     oracle.add("San Marino");
	     oracle.add("Sao Tome And Principe");
	     oracle.add("Saudi Arabia");
	     oracle.add("Senegal");
	     oracle.add("Seychelles");
	     oracle.add("Sierra Leone");
	     oracle.add("Singapore");
	     oracle.add("Slovakia");
	     oracle.add("Slovenia");
	     oracle.add("Solomon Islands");
	     oracle.add("Somalia");
	     oracle.add("South Africa");
	     oracle.add("South Georgia And The South Sandwich Islands");
	     oracle.add("Spain");
	     oracle.add("Sri Lanka");
	     oracle.add("Sudan");
	     oracle.add("Suriname");
	     oracle.add("Svalbard And Jan Mayen");
	     oracle.add("Swaziland");
	     oracle.add("Sweden");
	     oracle.add("Switzerland");
	     oracle.add("Syrian Arab Republic");
	     oracle.add("Taiwan, Province Of China");
	     oracle.add("Tajikistan");
	     oracle.add("Tanzania, United Republic Of");
	     oracle.add("Thailand");
	     oracle.add("Togo");
	     oracle.add("Tokelau");
	     oracle.add("Tonga");
	     oracle.add("Trinidad And Tobago");
	     oracle.add("Tunisia");
	     oracle.add("Turkey");
	     oracle.add("Turkmenistan");
	     oracle.add("Turks And Caicos Islands");
	     oracle.add("Tuvalu");
	     oracle.add("Uganda");
	     oracle.add("Ukraine");
	     oracle.add("United Arab Emirates");
	     oracle.add("United Kingdom");
	     oracle.add("United States Minor Outlying Islands");
	     oracle.add("United States");
	     oracle.add("Uruguay");
	     oracle.add("Uzbekistan");
	     oracle.add("Vanuatu");
	     oracle.add("Venezuela");
	     oracle.add("Viet Nam");
	     oracle.add("Virgin Islands, British");
	     oracle.add("Virgin Islands, U.S.");
	     oracle.add("Wallis And Futuna");
	     oracle.add("Western Sahara");
	     oracle.add("Yemen");
	     oracle.add("Yugoslavia");
	     oracle.add("Zambia");
	     oracle.add("Zimbabwe");
	     return oracle;
	 }

}
