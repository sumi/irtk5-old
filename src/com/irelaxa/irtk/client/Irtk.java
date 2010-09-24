package com.irelaxa.irtk.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

import com.irelaxa.irtk.client.TopBarView;
import com.irelaxa.irtk.client.TopBarViewListener;
import com.irelaxa.irtk.server.Goal;
import com.irelaxa.irtk.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.datepicker.client.DateBox;

import com.gwtfb.client.Callback;
import com.gwtfb.client.FrontpageViewController;
import com.gwtfb.sdk.FBCore;
import com.gwtfb.sdk.FBEvent;
import com.gwtfb.sdk.FBXfbml;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Irtk extends TopBarViewListener implements EntryPoint, ValueChangeHandler<String> {
	 /* Api key defined in facebook.
     */
    public static String API_KEY = "500f12576f276dd7b9d6531676773905";

   private FBCore fbCore = GWT.create(FBCore.class);
   private FBEvent fbEvent = GWT.create(FBEvent.class);
   private FBXfbml fbXfbml = GWT.create(FBXfbml.class);
   private boolean status = true;
   private boolean xfbml = true;
   private boolean cookie = true;
   /* private Anchor fbLogOut = new Anchor();
	LogoutCallback logoutCallback = new LogoutCallback();
	private void fbLogOut(){
		fbLogOut.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				fbCore.logout(logoutCallback);
			}
					
		});
	}*/
    
	    public Stack goalObject = new Stack();
	    public final HorizontalPanel topHoriPanel = new HorizontalPanel();
	    private Label bugetLable = new Label("Budget");
		private Label goalLable = new Label("Select Your Goal");
		private AbsolutePanel budgetPanel = new AbsolutePanel();
		private AbsolutePanel goalPanel = new AbsolutePanel();
		private ListBox multiBox = new ListBox(true);
		private ListBox dropBox = new ListBox(false);
		final ListBox budgetDropBox = new ListBox(false);
		// Create a DateBox
	    DateTimeFormat dateFormat = DateTimeFormat.getLongDateFormat();
	    DateBox sdateBox = new DateBox();
	    DateBox edateBox = new DateBox();
		public final FlexTable flexTable = new FlexTable();
		private FlexTable stocksFlexTable = new FlexTable();
		private FlexTable productsFlexTable = new FlexTable();
		private FlexTable internsFlexTable = new FlexTable();
		private FlexTable internshipsFlexTable = new FlexTable();
		private FlexTable myInternshipsFlexTable = new FlexTable();
		private FlexTable myMentorshipsFlexTable = new FlexTable();
		private FlexTable myCareerManagerFlexTable = new FlexTable();
		private FlexTable mentorshipsFlexTable = new FlexTable();
		private FlexTable datingFlexTable = new FlexTable();
		FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
		private Button sendButton = new Button("Save & Match My Goal");
		private ListBox listBox1 = new ListBox();
		private ArrayList<String> stocks = new ArrayList<String>();
		public LoginInfo loginInfo = null;
		private Label loginLabel = new Label("Please sign in to your Google Account to access the iRelaxa application.");
		  private Anchor signInLink = new Anchor("Sign In");
		  private Anchor signOutLink = new Anchor("Sign Out");
		  private Anchor internEvent = new Anchor("Intern Goal Match Event");
		  private final StockServiceAsync stockService = GWT.create(StockService.class);
		  private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	    final String[] goalTypes = {"Nutrition", "Fitness", "Dating", "Fashion", "Career", "College Admission"};
	    final String[] nutrition = {"Weight Loss", "Vegan", "Low Carb"};
	    final String[] fitness = {"Toning", "Lower Body", "Upper Body"};
	    final String[] dating = {"have fun", "committed relationship", "Marriage"};
	    final String[] fashion = {"Business Casual", "Causal", "Sexy"};
	    final String[] career = {"Doctor", "Engineer", "Lawyer"};
	    final String[] admission = {"Graduate School", "UnderGraduate", "PhD"};
	  //  Panel panel = RootPanel.get("chart");
	  //  SimpleViz PIE = new SimpleViz(panel);
	    MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();  
	   
	      TopBarView topBar;
	  /**
	   * Entry point method.
	   */
	  public void onModuleLoad() {
		  History.addValueChangeHandler(this);
		  fbCore.init(API_KEY, status, cookie, xfbml);
		  /*notified when user session changes */
			SessionChangeCallback sessionChangeCallback = new SessionChangeCallback();
			fbEvent.subscribe("auth.sessionChange",sessionChangeCallback);
	//	RootPanel.get("fblogin").add(loginButton);
		 // final  TopBarView topBar = new TopBarView(this);
	    	topBar = new TopBarView(this);
			RootPanel.get("topView").add(topBar);
			RootPanel.get("event").add(internEvent);
			/*  To load the Goals List    */
		loadGoalTableHeading();
		/* Display stocks...*/
		loginService();
		loadStocks();
		loadProductTableHeading();
		loadProducts();
		loadDatingGoals();
		loadInternTableHeading();
		loadAllInterns();
		loadInternshipTableHeading();
		loadAllInternships();
		loadMentorshipTableHeading();
		loadAllMentorships();
		loadMyInternGoals();
		loadMyInternshipsBiz();
		loadMyMentorships();
			flexTable.addStyleName("cw-FlexTable");
			flexTable.setWidth("32em");
			flexTable.setCellSpacing(5);
		    flexTable.setCellPadding(3);
		 // Add some text
		    cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		   
		 // ...and set it's column span so that it takes up the whole row.
		    flexTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		     //add goal Type Drop Box widget
			addGoalType();
			showGoalDates();
			// We can add style names to widgets
			sendButton.addStyleName("sendButton");
			sendButton.addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			        	//addStock(symbol, goalType, budgetDropBox.getValue(budgetDropBox.getSelectedIndex()),sdateBox.getValue(),edateBox.getValue() );
			    	  goalObject.clear();
			    	  goalObject.push(edateBox.getValue());
			    	  goalObject.push(sdateBox.getValue());
			    	  goalObject.push(budgetDropBox.getValue(budgetDropBox.getSelectedIndex()));
			    	  goalObject.push(listBox1.getValue(listBox1.getSelectedIndex()));
			    	  goalObject.push(dropBox.getValue(dropBox.getSelectedIndex()));
			    	  
			    	  /*goalPOJO.setBudget(budgetDropBox.getValue(budgetDropBox.getSelectedIndex()));
			    	  goalPOJO.setGoalType(dropBox.getValue(dropBox.getSelectedIndex()));
			    	  goalPOJO.setSymbol(listBox1.getValue(listBox1.getSelectedIndex()));
			    	  goalPOJO.setStartDate(sdateBox.getValue());
			    	  goalPOJO.setEndDate(edateBox.getValue());*/
			    	  afterGoalSave();
			    	  addStock(goalObject, "goal");
			    	 // getMatchingProduct();   
			      }
			    });	
			topBar.getVendorFormView().getregisterProductButton().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			        	//addStock(symbol, goalType, budgetDropBox.getValue(budgetDropBox.getSelectedIndex()),sdateBox.getValue(),edateBox.getValue() );
			    	  goalObject.clear();
			    	 // Window.alert("The vendor add button is clicked");
			    	  goalObject.push(topBar.getVendorFormView().getPrice());
			    	  goalObject.push(topBar.getVendorFormView().getProduct());
			    	  goalObject.push(topBar.getVendorFormView().getBusinessName());
			    	  addStock(goalObject, "product");  
			    	  onShowAllMyProductsSelect();
			      }
			    }
			);
			topBar.getDatingView().getMyDatingGoalLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onShowMyDatingGoalsSelect();
			      }
			    });
			topBar.getCareerManagerView().getSubmitCareerManagerButton().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  goalObject.clear();
			    	  goalObject.push(topBar.getCareerManagerView().getDegreePursuing());
			    	  goalObject.push(topBar.getCareerManagerView().getUniversityName());
			    	  goalObject.push(topBar.getCareerManagerView().getLastName());
			    	  goalObject.push(topBar.getCareerManagerView().getFirstName());
			    	  goalObject.push(topBar.getCareerManagerView().getEdateBox().getValue());
			    	  goalObject.push(topBar.getCareerManagerView().getSdateBox().getValue());
			    	  goalObject.push(topBar.getCareerManagerView().getPrice());
			    	  goalObject.push(topBar.getCareerManagerView().getTime());
			    	  goalObject.push(topBar.getCareerManagerView().getShortTermArea());
			    	  goalObject.push(topBar.getCareerManagerView().getLongTermArea());
			    	  addStock(goalObject, "careermanager");
			    	  loadMyCareerManagerTableHeading();
			    	  String longTerm = topBar.getCareerManagerView().getLongTermArea();
			    	  String shortTerm = topBar.getCareerManagerView().getShortTermArea();
			    	  String time = topBar.getCareerManagerView().getTime();
			    	  String price = topBar.getCareerManagerView().getPrice();
			    	  String sDate = topBar.getCareerManagerView().getSdateBox().getValue().toString();
			    	  String eDate = topBar.getCareerManagerView().getEdateBox().getValue().toString();
			    	  String fName = topBar.getCareerManagerView().getFirstName();
			    	  String lName = topBar.getCareerManagerView().getLastName();
			    	  String univ = topBar.getCareerManagerView().getUniversityName();
			    	  String degree = topBar.getCareerManagerView().getDegreePursuing();
			    	  myCareerManagerFlexTable.setText(1, 0, longTerm);
			    	  myCareerManagerFlexTable.setText(1, 1, shortTerm);
			    	  myCareerManagerFlexTable.setText(1, 2, time);
			    	  myCareerManagerFlexTable.setText(1, 3, price);
			    	  myCareerManagerFlexTable.setText(1, 4, sDate);
			    	  myCareerManagerFlexTable.setText(1, 5, eDate);
			    	  myCareerManagerFlexTable.setText(1, 6, fName);
			    	  myCareerManagerFlexTable.setText(1, 7, lName);
			    	  myCareerManagerFlexTable.setText(1, 8, univ);
			    	  myCareerManagerFlexTable.setText(1, 9, degree); 
			    	  Button removeStockButton = new Button("x");
				      Button editStockButton = new Button("Edit");
				      Button interestedStockButton = new Button("Interested");
				      myCareerManagerFlexTable.setWidget(1, 10, interestedStockButton);
				      myCareerManagerFlexTable.setWidget(1, 11, editStockButton);
				      myCareerManagerFlexTable.setWidget(1, 12, removeStockButton);
			    	  onSaveMyCareerManager();
			    	  topBar.getCareerManagerView().setShortTermAreaNull();
			    	  topBar.getCareerManagerView().setLongTermAreaNull();
			    	  topBar.getCareerManagerView().setTimeNull();
			    	  topBar.getCareerManagerView().setPriceNull();
			    	  topBar.getCareerManagerView().setSdateBoxNull();
			    	  topBar.getCareerManagerView().setEdateBoxNull();
			    	  topBar.getCareerManagerView().setFirstNameNull();
			    	  topBar.getCareerManagerView().setLastNameNull();
			    	  topBar.getCareerManagerView().setUniversityNameNull();
			    	  topBar.getCareerManagerView().setDegreePursuingNull();
			      }
			    });
			topBar.getInternshipBizView().getSubmitInternshipBizButton().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  goalObject.clear();
			    	  goalObject.push(topBar.getInternshipBizView().getContactName());
			    	  goalObject.push(topBar.getInternshipBizView().getBusinessName());
			    	  goalObject.push(topBar.getInternshipBizView().getEdateBox().getValue());
			    	  goalObject.push(topBar.getInternshipBizView().getSdateBox().getValue());
			    	  goalObject.push(topBar.getInternshipBizView().getPay());
			    	  goalObject.push(topBar.getInternshipBizView().getProject());
			    	  goalObject.push(topBar.getInternshipBizView().getTime());
			    	  goalObject.push(topBar.getInternshipBizView().getSkills());
			    	  addStock(goalObject, "internbiz");
			    	  loadMyInternshipTableHeading();
			    	  String longTerm = topBar.getInternshipBizView().getSkills();
			    	  String shortTerm = topBar.getInternshipBizView().getTime();
			    	  String time = topBar.getInternshipBizView().getProject();
			    	  String price = topBar.getInternshipBizView().getPay();
			    	  String sDate = topBar.getInternshipBizView().getSdateBox().getValue().toString();
			    	  String eDate = topBar.getInternshipBizView().getEdateBox().getValue().toString();
			    	  String fName = topBar.getInternshipBizView().getBusinessName();
			    	  String lName = topBar.getInternshipBizView().getContactName();
			    	  myInternshipsFlexTable.setText(1, 0, longTerm);
			    	  myInternshipsFlexTable.setText(1, 1, shortTerm);
			    	  myInternshipsFlexTable.setText(1, 2, time);
			    	  myInternshipsFlexTable.setText(1, 3, price);
			    	  myInternshipsFlexTable.setText(1, 4, sDate);
			    	  myInternshipsFlexTable.setText(1, 5, eDate);
			    	  myInternshipsFlexTable.setText(1, 6, fName);
			    	  myInternshipsFlexTable.setText(1, 7, lName);
			    	  Button removeStockButton = new Button("x");
				      Button editStockButton = new Button("Edit");
				      Button interestedStockButton = new Button("Interested");
				      myInternshipsFlexTable.setWidget(1, 8, interestedStockButton);
				      myInternshipsFlexTable.setWidget(1, 9, editStockButton);
				      myInternshipsFlexTable.setWidget(1, 10, removeStockButton);
			    	  onSaveMyInternships();
			    	  topBar.getInternshipBizView().setSkillsNull();
			    	  topBar.getInternshipBizView().setTimeNull();
			    	  topBar.getInternshipBizView().setProjectNull();
			    	  topBar.getInternshipBizView().setPayNull();
			    	  topBar.getInternshipBizView().setSdateBoxNull();
			    	  topBar.getInternshipBizView().setEdateBoxNull();
			    	  topBar.getInternshipBizView().setBusinessNameNull();
			    	  topBar.getInternshipBizView().setContactNameNull();
			      }
			    });
			topBar.getMentorView().getMentorSaveButton().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  goalObject.clear();
			    	  goalObject.push(topBar.getMentorView().getContactName());
			    	  goalObject.push(topBar.getMentorView().getBusinessName());
			    	  goalObject.push(topBar.getMentorView().getEdateBox().getValue());
			    	  goalObject.push(topBar.getMentorView().getSdateBox().getValue());
			    	  goalObject.push(topBar.getMentorView().getMentorDescription());
			    	  goalObject.push(topBar.getMentorView().getMenteeDescription());
			    	  goalObject.push(topBar.getMentorView().getTime());
			    	  goalObject.push(topBar.getMentorView().getSkills());
			    	  addStock(goalObject, "mentorbiz");
			    	  loadMyMentorshipTableHeading();
			    	  String longTerm = topBar.getMentorView().getSkills();
			    	  String shortTerm = topBar.getMentorView().getTime();
			    	  String time = topBar.getMentorView().getMenteeDescription();
			    	  String price = topBar.getMentorView().getMentorDescription();
			    	  String sDate = topBar.getMentorView().getSdateBox().getValue().toString();
			    	  String eDate = topBar.getMentorView().getEdateBox().getValue().toString();
			    	  String fName = topBar.getMentorView().getBusinessName();
			    	  String lName = topBar.getMentorView().getContactName();
			    	  myMentorshipsFlexTable.setText(1, 0, longTerm);
			    	  myMentorshipsFlexTable.setText(1, 1, shortTerm);
			    	  myMentorshipsFlexTable.setText(1, 2, time);
			    	  myMentorshipsFlexTable.setText(1, 3, price);
			    	  myMentorshipsFlexTable.setText(1, 4, sDate);
			    	  myMentorshipsFlexTable.setText(1, 5, eDate);
			    	  myMentorshipsFlexTable.setText(1, 6, fName);
			    	  myMentorshipsFlexTable.setText(1, 7, lName);
			    	  Button removeStockButton = new Button("x");
				      Button editStockButton = new Button("Edit");
				      Button interestedStockButton = new Button("Interested");
				      myMentorshipsFlexTable.setWidget(1, 8, interestedStockButton);
				      myMentorshipsFlexTable.setWidget(1, 9, editStockButton);
				      myMentorshipsFlexTable.setWidget(1, 10, removeStockButton);
			    	  onSaveMyMentorships();
			    	  topBar.getMentorView().setSkillsNull();
			    	  topBar.getMentorView().setTimeNull();
			    	  topBar.getMentorView().setMenteeDescriptionNull();
			    	  topBar.getMentorView().setMentorDescriptionNull();
			    	  topBar.getMentorView().setSdateBoxNull();
			    	  topBar.getMentorView().setEdateBoxNull();
			    	  topBar.getMentorView().setBusinessNameNull();
			    	  topBar.getMentorView().setContactNameNull();
			    	
			      }
			    });
			topBar.getCareerManagerView().getInternshipsLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onShowAllInternships();
			      }
			    });
			topBar.getCareerManagerView().getMentorshipsLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onShowAllMentorships();
			      }
			    });
			topBar.getInternshipBizView().getInternsLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onShowAllInterns();
			      }
			    });
			topBar.getMentorView().getInternsLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onShowAllInterns();
			      }
			    });
			topBar.getCareerManagerView().getMyCareerGoalsLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onSaveMyCareerManager();
			      }
			    });
			topBar.getInternshipBizView().getMyInternshipBizLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onSaveMyInternships();
			      }
			    });
			topBar.getMentorView().getMyMentorshipsLink().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onSaveMyMentorships();
			      }
			    });
			
			internEvent.addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  loadInternEvent();
			      }
			    });
			topBar.getInternGoalMatchingEvent().getSubmitCompanyButton().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onGoalWordsSelect(topBar.getInternshipBizView());
			      }
			    });
			topBar.getInternGoalMatchingEvent().getSubmitInternButton().addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			    	  onGoalWordsSelect(topBar.getCareerManagerView());
			      }
			    });
	  }

	public void loginService() {
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(LoginInfo result) {
		        loginInfo = result;
		        if(loginInfo.isLoggedIn()) {
		        	signOutLink.setHref(loginInfo.getLogoutUrl());
		        	RootPanel.get("logout").add(signOutLink);
		        } else {
		          loadLogin();
		        }
		      }
		    });
	}

	private void loadGoalTableHeading() {
		// Create table for stock data.
		    stocksFlexTable.setHTML(0, 1, "<h3>Goal Type</h3>");
		    stocksFlexTable.setHTML(0, 2, "<h3>Goal</h3>");
		    stocksFlexTable.setHTML(0, 3, "<h3>Budget</h3>");
		    stocksFlexTable.setHTML(0, 4, "<h3>Start Date</h3>");
		    stocksFlexTable.setHTML(0, 5, "<h3>End Date</h3>");
		    //stocksFlexTable.setHTML(0, 7, "<h3>Remove Goal</h3>");
		    stocksFlexTable.setHTML(0, 9, "<h3>Time Left</h3>");
		    //stocksFlexTable.setHTML(0, 9, "<h3>Buget Remaining</h3>");
	}
	private void loadProductTableHeading() {
		// Create table for stock data.
		    productsFlexTable.setHTML(0, 0, "<h3>Business Name</h3>");
		    productsFlexTable.setHTML(0, 1, "<h3>Product Type</h3>");
		    productsFlexTable.setHTML(0, 2, "<h3>Price</h3>");
		    productsFlexTable.setHTML(0, 5, "<h3>Remove Product</h3>'");
	}
	private void loadInternTableHeading() {
		// Create table for stock data.
		internsFlexTable.setHTML(0, 0, "<h3>Long Term Goals</h3>");
		internsFlexTable.setHTML(0, 1, "<h3>Short Term Goals</h3>'");
		internsFlexTable.setHTML(0, 2, "<h3>Hours of work</h3>");
		internsFlexTable.setHTML(0, 3, "<h3>Stipend</h3>");
		    internsFlexTable.setHTML(0, 4, "<h3>Start Date</h3>");
			  internsFlexTable.setHTML(0, 5, "<h3>End Date</h3>");
			  internsFlexTable.setHTML(0, 6, "<h3>First Name</h3>");
			  internsFlexTable.setHTML(0, 7, "<h3>Last Name</h3>");
			  internsFlexTable.setHTML(0, 8, "<h3>University</h3>");
			  internsFlexTable.setHTML(0, 9, "<h3>Degree</h3>");
	}
	private void loadMyCareerManagerTableHeading() {
		// Create table for stock data.
		myCareerManagerFlexTable.setHTML(0, 0, "<h3>Long Term Goals</h3>");
		myCareerManagerFlexTable.setHTML(0, 1, "<h3>Short Term Goals</h3>");
		myCareerManagerFlexTable.setHTML(0, 2, "<h3>Hours of work</h3>");
		myCareerManagerFlexTable.setHTML(0, 3, "<h3>Stipend</h3>");
		myCareerManagerFlexTable.setHTML(0, 4, "<h3>Start Date</h3>");
		myCareerManagerFlexTable.setHTML(0, 5, "<h3>End Date</h3>");
		myCareerManagerFlexTable.setHTML(0, 6, "<h3>First Name</h3>");
		myCareerManagerFlexTable.setHTML(0, 7, "<h3>Last Name</h3>");
		myCareerManagerFlexTable.setHTML(0, 8, "<h3>University</h3>");
		myCareerManagerFlexTable.setHTML(0, 9, "<h3>Degree</h3>");
	}
	private void loadInternshipTableHeading() {
		// Create table for stock data.
		internshipsFlexTable.setHTML(0, 0, "<h3>Skills</h3>");
		internshipsFlexTable.setHTML(0, 1, "<h3>Hours</h3>");
		internshipsFlexTable.setHTML(0, 2, "<h3>Work Description</h3>");
		internshipsFlexTable.setHTML(0, 3, "<h3>Stipend</h3>");
		internshipsFlexTable.setHTML(0, 4, "<h3>Start Date</h3>");
		internshipsFlexTable.setHTML(0, 5, "<h3>End Date</h3>");
		internshipsFlexTable.setHTML(0, 6, "<h3>Company Name</h3>");
		internshipsFlexTable.setHTML(0, 7, "<h3>Contact</h3>");
	}
	private void loadMyInternshipTableHeading() {
		// Create table for stock data.
		myInternshipsFlexTable.setHTML(0, 0, "<h3>Skills</h3>");
		myInternshipsFlexTable.setHTML(0, 1, "<h3>Hours</h3>");
		myInternshipsFlexTable.setHTML(0, 2, "<h3>Work Description</h3>");
		myInternshipsFlexTable.setHTML(0, 3, "<h3>Stipend</h3>");
		myInternshipsFlexTable.setHTML(0, 4, "<h3>Start Date</h3>");
		myInternshipsFlexTable.setHTML(0, 5, "<h3>End Date</h3>");
		myInternshipsFlexTable.setHTML(0, 6, "<h3>Company Name</h3>");
		myInternshipsFlexTable.setHTML(0, 7, "<h3>Contact</h3>");
	}
	private void loadMentorshipTableHeading() {
		// Create table for stock data.
		mentorshipsFlexTable.setHTML(0, 0, "<h3>Skills</h3>");
		mentorshipsFlexTable.setHTML(0, 1, "<h3>Hours</h3>");
		mentorshipsFlexTable.setHTML(0, 2, "<h3>Mentee Description</h3>");
		mentorshipsFlexTable.setHTML(0, 3, "<h3>Mentor Description</h3>");
		mentorshipsFlexTable.setHTML(0, 4, "<h3>Start Date</h3>");
		mentorshipsFlexTable.setHTML(0, 5, "<h3>End Date</h3>");
		mentorshipsFlexTable.setHTML(0, 6, "<h3>Company Name</h3>");
		mentorshipsFlexTable.setHTML(0, 7, "<h3>Contact</h3>");
	}
	private void loadMyMentorshipTableHeading() {
		// Create table for stock data.
		myMentorshipsFlexTable.setHTML(0, 0, "<h3>Skills</h3>");
		myMentorshipsFlexTable.setHTML(0, 1, "<h3>Hours</h3>");
		myMentorshipsFlexTable.setHTML(0, 2, "<h3>Mentee Description</h3>");
		myMentorshipsFlexTable.setHTML(0, 3, "<h3>Mentor Description</h3>");
		myMentorshipsFlexTable.setHTML(0, 4, "<h3>Start Date</h3>");
		myMentorshipsFlexTable.setHTML(0, 5, "<h3>End Date</h3>");
		myMentorshipsFlexTable.setHTML(0, 6, "<h3>Company Name</h3>");
		myMentorshipsFlexTable.setHTML(0, 7, "<h3>Contact</h3>");
	}
	  private void loadStocks() {
		    stockService.getAllGoals(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] goals) {
		        displayStocks(goals);
		      }
		    });
		  }
	  private void loadProducts() {
		    stockService.getProducts(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] products) {
		        displayProducts(products);
		      }
		    });
		  }
	  private void loadAllInterns() {
		    stockService.getAllInterns(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] interns) {
		    	 
		        displayInterns(interns);
		      }
		    });
		  }
	  private void loadAllInternships() {
		    stockService.getAllInternships(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] internships) {
		        displayInternships(internships);
		      }
		    });
		  }
	  private void loadAllMentorships() {
		    stockService.getAllMentorships(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] mentorships) {
		        displayMentorships(mentorships);
		      }
		    });
		  }
	  private void loadMyInternGoals() {
		    stockService.getMyCareerGoals(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] mentorships) {
		        displayMyInternGoals(mentorships);
		      }
		    });
		  }
	  private void loadMyInternshipsBiz() {
		    stockService.getMyInternshipsBizGoals(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] mentorships) {
		        displayMyInternshipsBiz(mentorships);
		      }
		    });
		  }
	  private void loadMyMentorships() {
		    stockService.getMyMentorshipsBizGoals(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] mentorships) {
		        displayMyMentorships(mentorships);
		      }
		    });
		  }
	  private void loadDatingGoals() {
		    stockService.getDatingGoals(new AsyncCallback<String[][]>() {
		      public void onFailure(Throwable error) {
		      }
		      public void onSuccess(String[][] datingGoals) {
		        displayDatingGoals(datingGoals);
		      }
		    });
		  }
	  private void displayDatingGoals(String[][] datingGoals) {
		    for (String[] theDatingGoal : datingGoals) {
		      displayDatingGoal(theDatingGoal);
		    }
		  }
	  private void displayDatingGoal(final String[] thedatingGoal) {
		  int row = datingFlexTable.getRowCount();
	    //  stocks.add(symbol);
		  datingFlexTable.setText(row, 0, thedatingGoal[0]);
		  datingFlexTable.setText(row, 1, thedatingGoal[1]);
		  datingFlexTable.setText(row, 2, thedatingGoal[2]);
		  datingFlexTable.setText(row, 3, thedatingGoal[3]);
		  datingFlexTable.setText(row, 4, thedatingGoal[4]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      Button interestedStockButton = new Button("Interested");
	      datingFlexTable.setWidget(row, 5, interestedStockButton);
	      datingFlexTable.setWidget(row, 6, editStockButton);
	      datingFlexTable.setWidget(row, 7, removeStockButton);
	  }
	  private void displayProducts(String[][] products) {
		    for (String[] theProduct : products) {
		      displayProduct(theProduct);
		    }
		  }
	  private void displayInterns(String[][] interns) {
		    for (String[] theIntern : interns) {
		      displayIntern(theIntern);
		    }
		  }
	  private void displayInternships(String[][] internships) {
		    for (String[] theInternship : internships) {
		      displayInternship(theInternship);
		    }
		  }
	  private void displayMentorships(String[][] mentorships) {
		    for (String[] theMentorship : mentorships) {
		      displayMentorship(theMentorship);
		    }
		  }
	  private void displayMyInternGoals(String[][] mentorships) {
		    for (String[] theMentorship : mentorships) {
		      displayMyInternGoals(theMentorship);
		    }
		  }
	  private void displayMyInternshipsBiz(String[][] mentorships) {
		    for (String[] theMentorship : mentorships) {
		      displayMyInternshipsBiz(theMentorship);
		    }
		  }
	  private void displayMyMentorships(String[][] mentorships) {
		    for (String[] theMentorship : mentorships) {
		      displayMyMentorships(theMentorship);
		    }
		  }
	  
	  private void displayProduct(final String[] theProduct) {
		  int row = productsFlexTable.getRowCount();
		  productsFlexTable.setText(row, 0, theProduct[0]);
		  productsFlexTable.setText(row, 1, theProduct[1]);
		  productsFlexTable.setText(row, 2, theProduct[2]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      Button interestedStockButton = new Button("Interested");
	      productsFlexTable.setWidget(row, 3, interestedStockButton);
	      productsFlexTable.setWidget(row, 4, editStockButton);
	      productsFlexTable.setWidget(row, 5, removeStockButton);
	  }
	  
	  private void displayIntern(final String[] theIntern) {
		 
		  int row = internsFlexTable.getRowCount();
		  internsFlexTable.setText(row, 0, theIntern[0]);
		  internsFlexTable.setText(row, 1, theIntern[1]);
		  internsFlexTable.setText(row, 2, theIntern[2]);
		  internsFlexTable.setText(row, 3, theIntern[3]);
		  internsFlexTable.setText(row, 4, theIntern[4]);
		  internsFlexTable.setText(row, 5, theIntern[5]);
		  internsFlexTable.setText(row, 6, theIntern[6]);
		  internsFlexTable.setText(row, 7, theIntern[7]);
		  internsFlexTable.setText(row, 8, theIntern[8]);
		  internsFlexTable.setText(row, 9, theIntern[9]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      Button interestedStockButton = new Button("Interested");
	      internsFlexTable.setWidget(row, 10, interestedStockButton);
	      internsFlexTable.setWidget(row, 11, editStockButton);
	      internsFlexTable.setWidget(row, 12, removeStockButton);
		  
	  }
	  private void displayInternship(final String[] theInternship) {
		  int row = internshipsFlexTable.getRowCount();
		  internshipsFlexTable.setText(row, 0, theInternship[0]);
		  internshipsFlexTable.setText(row, 1, theInternship[1]);
		  internshipsFlexTable.setText(row, 2, theInternship[2]);
		  internshipsFlexTable.setText(row, 3, theInternship[3]);
		  internshipsFlexTable.setText(row, 4, theInternship[4]);
		  internshipsFlexTable.setText(row, 5, theInternship[5]);
		  internshipsFlexTable.setText(row, 6, theInternship[6]);
		  internshipsFlexTable.setText(row, 7, theInternship[7]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      Button interestedStockButton = new Button("Interested");
	      internshipsFlexTable.setWidget(row, 8, interestedStockButton);
	      internshipsFlexTable.setWidget(row, 9, editStockButton);
	      internshipsFlexTable.setWidget(row, 10, removeStockButton);
	
	  }
	  private void displayMentorship(final String[] theMentorship) {
		  int row = mentorshipsFlexTable.getRowCount();
		  mentorshipsFlexTable.setText(row, 0, theMentorship[0]);
		  mentorshipsFlexTable.setText(row, 1, theMentorship[1]);
		  mentorshipsFlexTable.setText(row, 2, theMentorship[2]);
		  mentorshipsFlexTable.setText(row, 3, theMentorship[3]);
		  mentorshipsFlexTable.setText(row, 4, theMentorship[4]);
		  mentorshipsFlexTable.setText(row, 5, theMentorship[5]);
		  mentorshipsFlexTable.setText(row, 6, theMentorship[6]);
		  mentorshipsFlexTable.setText(row, 7, theMentorship[7]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      Button interestedStockButton = new Button("Interested");
	      mentorshipsFlexTable.setWidget(row, 8, interestedStockButton);
	      mentorshipsFlexTable.setWidget(row, 9, editStockButton);
	      mentorshipsFlexTable.setWidget(row, 10, removeStockButton);
		  
	  }
	  private void displayMyInternGoals(final String[] theMentorship) {
		  int row = myCareerManagerFlexTable.getRowCount();
		  myCareerManagerFlexTable.setText(row, 0, theMentorship[0]);
		  myCareerManagerFlexTable.setText(row, 1, theMentorship[1]);
		  myCareerManagerFlexTable.setText(row, 2, theMentorship[2]);
		  myCareerManagerFlexTable.setText(row, 3, theMentorship[3]);
		  myCareerManagerFlexTable.setText(row, 4, theMentorship[4]);
		  myCareerManagerFlexTable.setText(row, 5, theMentorship[5]);
		  myCareerManagerFlexTable.setText(row, 6, theMentorship[6]);
		  myCareerManagerFlexTable.setText(row, 7, theMentorship[7]);
		  myCareerManagerFlexTable.setText(row, 8, theMentorship[6]);
		  myCareerManagerFlexTable.setText(row, 9, theMentorship[7]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      myCareerManagerFlexTable.setWidget(row, 10, editStockButton);
	      myCareerManagerFlexTable.setWidget(row, 11, removeStockButton);
		  
	  }
	  private void displayMyInternshipsBiz(final String[] theMentorship) {
		  int row = myInternshipsFlexTable.getRowCount();
		  myInternshipsFlexTable.setText(row, 0, theMentorship[0]);
		  myInternshipsFlexTable.setText(row, 1, theMentorship[1]);
		  myInternshipsFlexTable.setText(row, 2, theMentorship[2]);
		  myInternshipsFlexTable.setText(row, 3, theMentorship[3]);
		  myInternshipsFlexTable.setText(row, 4, theMentorship[4]);
		  myInternshipsFlexTable.setText(row, 5, theMentorship[5]);
		  myInternshipsFlexTable.setText(row, 6, theMentorship[6]);
		  myInternshipsFlexTable.setText(row, 7, theMentorship[7]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      myInternshipsFlexTable.setWidget(row, 8, editStockButton);
	      myInternshipsFlexTable.setWidget(row, 9, removeStockButton);
	  }
	  private void displayMyMentorships(final String[] theMentorship) {
		  int row = myMentorshipsFlexTable.getRowCount();
		  myMentorshipsFlexTable.setText(row, 0, theMentorship[0]);
		  myMentorshipsFlexTable.setText(row, 1, theMentorship[1]);
		  myMentorshipsFlexTable.setText(row, 2, theMentorship[2]);
		  myMentorshipsFlexTable.setText(row, 3, theMentorship[3]);
		  myMentorshipsFlexTable.setText(row, 4, theMentorship[4]);
		  myMentorshipsFlexTable.setText(row, 5, theMentorship[5]);
		  myMentorshipsFlexTable.setText(row, 6, theMentorship[6]);
		  myMentorshipsFlexTable.setText(row, 7, theMentorship[7]);
		  Button removeStockButton = new Button("x");
	      Button editStockButton = new Button("Edit");
	      myMentorshipsFlexTable.setWidget(row, 8, editStockButton);
	      myMentorshipsFlexTable.setWidget(row, 9, removeStockButton);
	  }
		  private void displayStocks(String[][] goals) {
		    for (String[] theGoal : goals) {
		      displayStock(theGoal);
		    }
		  }

		  public void addStock(Stack dataObject, String objectName) {
			  //Window.alert("inside addstock in itk");
			  final Stack dataObjectLocal = dataObject;
			  final String finalobjectName = objectName;
			        if(loginInfo.isLoggedIn()) {
			        	signOutLink.setHref(loginInfo.getLogoutUrl());
			        	// Window.alert("size of stack " +Integer.toString(dataObject.capacity()));
			        	 
			        	stockService.addStock(dataObjectLocal, objectName, new AsyncCallback<Void>() {
			        		String[] justAddedGoal = new String[10];
			   			  public void onFailure(Throwable error) {
			   			//	Window.alert("inside add stock  onfailure 2");
			   		      }
			   		      public void onSuccess(Void ignore) {
			   		    //	Window.alert("inside add stock onsuccess 2");
			   		    	  if(finalobjectName.equals("goal")){
			   		    	justAddedGoal[0] = dropBox.getValue(dropBox.getSelectedIndex());
					    	  justAddedGoal[1] = listBox1.getValue(listBox1.getSelectedIndex());
					    	  justAddedGoal[2] = budgetDropBox.getValue(budgetDropBox.getSelectedIndex());
					    	  justAddedGoal[3] = FieldVerifier.getMonth(sdateBox.getValue().getMonth())+" "+Integer.toString(sdateBox.getValue().getDate())+" " +Integer.toString((sdateBox.getValue().getYear()+1900));
					    	  justAddedGoal[4] = FieldVerifier.getMonth(edateBox.getValue().getMonth())+" "+Integer.toString(edateBox.getValue().getDate())+" " +Integer.toString((edateBox.getValue().getYear()+1900));
					       displayStock(justAddedGoal);
					       
			   		    	  }
			   		    	if(finalobjectName.equals("product")){
			   		    		Window.alert("the business name is" +topBar.getVendorFormView().getBusinessName());
				   		    	justAddedGoal[0] = topBar.getVendorFormView().getBusinessName();
						    	  justAddedGoal[1] = topBar.getVendorFormView().getProduct();
						    	  justAddedGoal[2] = topBar.getVendorFormView().getPrice();
						       displayProduct(justAddedGoal);
				   		    	  }
			   		      }
			   		    });
			        } else {
			          loadLogin();
			        }
			  }
	public void fbShare(String myGoal){
		 JSONObject data = new JSONObject (); 
         data.put( "method", new JSONString ( "stream.publish" ) ); 
         data.put( "message", new JSONString ( "Share your Personal Goals with your Friends and Realize them Faster") ); 
          
         JSONObject attachment = new JSONObject (); 
         attachment.put( "name", new JSONString ( "iRelaxa.com" ) ); 
         attachment.put("caption", new JSONString ( "iRelaxa the Goal Match Engine" ) ); 
         attachment.put( "description", new JSONString (myGoal) );  
         attachment.put("href",  new JSONString ( "http://www.irelaxa.com" ) ); 
         
          /* iRelaxa Logo */ 
         JSONObject logoLink = new JSONObject (); 
         logoLink.put ( "type", new JSONString ( "image" ) ); 
         //logoLink.put ( "src", new JSONString ( "http://www.irelaxa.com/images/leaf1.jpg" ) ); 
         logoLink.put ( "src", new JSONString ( "http://www.irelaxa.com/images/logo.png" ) ); 
         logoLink.put ( "href", new JSONString ( "http://www.irelaxa.com" ) ); 
  
         JSONArray logoLinks = new JSONArray (); 
         logoLinks.set(0, logoLink); 
         attachment.put( "media", logoLinks); 
         
         data.put( "attachment", attachment ); 
  
         JSONObject actionLink = new JSONObject (); 
         actionLink.put ( "text", new JSONString ( "track my goal" ) ); 
         actionLink.put ( "href", new JSONString ( "http://www.irelaxa.com" ) ); 
         
  
         JSONArray actionLinks = new JSONArray (); 
         actionLinks.set(0, actionLink); 
         data.put( "action_links", actionLinks); 
         
        
  
         data.put( "user_message_prompt", new JSONString ( "Share your thoughts abt this goal" ) ); 
  
         /* 
          * Execute facebook method 
          */ 
       /*  RootPanel.get("fblogout").clear();
         RootPanel.get("fblogout").add(fbLogOut);*/
         fbCore.ui(data.getJavaScriptObject(), new Callback () ); 
 
	}
	  private void displayStock(final String[] theGoal) {
	  int row = stocksFlexTable.getRowCount();
    //  stocks.add(symbol);
      stocksFlexTable.setText(row, 1, theGoal[1]);
      stocksFlexTable.setText(row, 2, theGoal[0]);
      stocksFlexTable.setText(row, 3, theGoal[2]);
      stocksFlexTable.setText(row, 4, theGoal[3]);
      stocksFlexTable.setText(row, 5, theGoal[4]);
    /*  afterGoalSave();*/
   // Add a button to remove this stock from the table.-not
      Button removeStockButton = new Button("x");
      Button editStockButton = new Button("Edit");
      Button interestedStockButton = new Button("Public");
      //Label spending = new Label("");
      stocksFlexTable.setWidget(row, 6, interestedStockButton);
      stocksFlexTable.setWidget(row, 7, editStockButton);
      stocksFlexTable.setText(row, 9, theGoal[5]+ " Days");
      ShareButton fbShare = new ShareButton();
      fbShare.addClickHandler( new ClickHandler () { 
          public void onClick(ClickEvent event) { 
        	  renderWhenNotLoggedIn();
              fbShare ("GOAL TYPE: "+ theGoal[1]+"\n"+ "GOAL: "+theGoal[0]+"\n"+"BUDGET: "+theGoal[2]+"\n"+"START DATE: "+theGoal[3]+"\n"+"END DATE: "+theGoal[4]);
              renderWhenLogged();
          } 
      }); 

    stocksFlexTable.setWidget(row, 0, fbShare);
     // Window.alert("Remaining days "+theGoal[5]);
      removeStockButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
        	removeStock(theGoal[1]);
        }
     
        private void removeStock(final String symbol) {
            stockService.removeStock(symbol, new AsyncCallback<Void>() {
              public void onFailure(Throwable error) {
              }
              public void onSuccess(Void ignore) {
                undisplayStock(symbol);
              }
            });
          }
        
        private void undisplayStock(String symbol) {
          int removedIndex = stocks.indexOf(symbol);
          stocks.remove(removedIndex);
          stocksFlexTable.removeRow(removedIndex + 1);
        }
      });
      if((theGoal[1].length()!= 0)){
      stocksFlexTable.setWidget(row, 7, removeStockButton);
      }
	  }
	  private void loadLogin() {
		    // Assemble login panel.
		    signInLink.setHref(loginInfo.getLoginUrl());
		    
		    RootPanel.get("login").add(loginLabel);
		    RootPanel.get("login").add(signInLink);
		    
		  }
	public void addGoalType(){
			// Add a drop box with the Goal types
		    
		    
		   // goalTypes = {"Nutrition", "Fitness", "Dating", "Fashion", "Career", "College Admission"};
		    for (int i = 0; i < goalTypes.length; i++) {
		        dropBox.addItem(goalTypes[i]);
		      }
		    dropBox.ensureDebugId("cwListBox-dropBox");
		    oracle.add("Nutrition");
		    oracle.add("Fitness");
		    oracle.add("Dating");
		    oracle.add("Career");
		    oracle.add("Fashion");
		    oracle.add("Internship");
		    oracle.add("College Admission");
		    
		    //final ListBox multiBox = new ListBox(true);
		    multiBox.ensureDebugId("cwListBox-multiBox");
		    multiBox.setWidth("11em");
		    multiBox.setVisibleItemCount(3);
		    //RootPanel.get("goalTypeDropBox").add(dropBox);
		    flexTable.setWidget(2, 0, new HTML("Select Goal Type"));
		    flexTable.setWidget(2, 1, dropBox);
		  //  flexTable.setWidget(2, 1, box);
		    RootPanel.get("flexTable").add(flexTable);
		 // Add a handler to handle drop box events
		    dropBox.addChangeHandler(new ChangeHandler() {
		    //	box.addChangeListener(new ChangeListener() {
		      public void onChange(ChangeEvent event) {
		        showCategory(multiBox, dropBox.getSelectedIndex());
		        multiBox.ensureDebugId("cwListBox-multiBox");
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
		 goalPanel.add(listBox1, dropBox.getAbsoluteLeft(), goalLable.getAbsoluteTop());
		 flexTable.setWidget(3, 0, new HTML("Select Goal"));
		 flexTable.setWidget(3, 1, listBox1);
		 
		
		listBox.addChangeHandler(new ChangeHandler() {
		  public void onChange(ChangeEvent event) {
		    showBudget(budgetDropBox, category, multiBox.getSelectedIndex());
		    budgetDropBox.ensureDebugId("cwListBox-budgetDropBox");
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
			  budgetPanel.add(budgetListBox, dropBox.getAbsoluteLeft(), bugetLable.getAbsoluteTop());
			  flexTable.setWidget(4, 0, new HTML("Select Budget"));
			  flexTable.setWidget(4, 1, budgetListBox);
			  RootPanel.get("flexTable").add(flexTable);  
		   }

		private void showGoalDates(){
			sdateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		    flexTable.setWidget(5, 0, new HTML("Goal Start Date"));
			flexTable.setWidget(5, 1, sdateBox);
		    edateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		    flexTable.setWidget(6, 0, new HTML("Goal End Date"));
			flexTable.setWidget(6, 1, edateBox);
			flexTable.setWidget(7, 1,sendButton);
			RootPanel.get("flexTable").add(flexTable);
		}
		public void onGoalWordsSelect(Widget w){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("goalList").clear();
			RootPanel.get("flexTable").add(w);		
			}
		public void onCareerManagerViewSelect(Widget w){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("goalList").clear();
			RootPanel.get("flexTable").add(w);		
			}
		public void onPersonalGoalsSelect(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(stocksFlexTable);		
			}
		public void onAllGoalsSelect(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(flexTable);		
			}
		public void onWorkLifeBalanceSelect(Widget w){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("goalList").clear();
			RootPanel.get("flexTable").add(w);		
			}
		public void onShowAllMyProductsSelect(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(productsFlexTable);	
		}
		public void onShowMyDatingGoalsSelect(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(datingFlexTable);	
		}
		public void onShowAllInternships(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(internshipsFlexTable);	
		}
		public void onShowAllMentorships(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(mentorshipsFlexTable);	
		}
		public void onShowAllInterns(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(internsFlexTable);	
		}
		public void loadInternEvent(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(topBar.getInternGoalMatchingEvent());
				
		}
		public void afterGoalSave(){
			onPersonalGoalsSelect();
		}
		public void onSaveMyCareerManager(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(myCareerManagerFlexTable);	
		}
		public void onSaveMyInternships(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(myInternshipsFlexTable);	
		}
		public void onSaveMyMentorships(){
			RootPanel.get("mainView").clear();
			RootPanel.get("flexTable").clear();
			RootPanel.get("flexTable").add(myMentorshipsFlexTable);	
		}
		
		/* Callback used when session status is changed*/
		class SessionChangeCallback extends Callback<JavaScriptObject>{
			public void onSuccess(JavaScriptObject response){
				//Make sure cookie is set so we can use the non async method
				renderHomeView();
			}
		}
		/* Render Home view  if user is logged in render welcome page otherwise render login page*/
		private void renderHomeView(){
			if(fbCore.getSession() == null){
				renderWhenNotLoggedIn();
			} else {
				renderWhenLogged();
			}
			
		}
		
		class LogoutCallback extends Callback<JavaScriptObject> {
			public void onSuccess(JavaScriptObject response){
				renderWhenLogged();
			}
		}
		private void renderWhenLogged(){
			//remove logout anchor
		//	RootPanel.get("fblogout").clear();
		//	RootPanel.get("fblogout").add(fbLogOut);
		}
		private void renderWhenNotLoggedIn(){
			//display logout anchor
		//	RootPanel.get("fblogout").clear();
			//RootPanel.get("fblogin").add(fbLogOut);
			//RootPanel.get("fblogin").add(new FrontpageViewController());
		//	FBXfbml.parse();
		}
		
		
		public void onValueChange(ValueChangeEvent<String> event){
			
		}
}
