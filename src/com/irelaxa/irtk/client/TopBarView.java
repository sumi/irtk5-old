package com.irelaxa.irtk.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TopBarView extends Composite {
	private TopBarViewListener topBarViewListener;
	private HorizontalPanel hTopPanel = new HorizontalPanel();
	private DecoratedTabPanel consumerPanel = new DecoratedTabPanel();
	private Label space1 = new Label("                                            ");
	private DecoratedTabPanel bizPanel = new DecoratedTabPanel();
	private Label space2 = new Label("                      ");
	private DecoratedTabPanel funPanel = new DecoratedTabPanel();
	private VerticalPanel personal = new VerticalPanel();
	private Anchor personalGoals = new Anchor("My Goals");
	private Anchor setGoals = new Anchor("Set Goals");
	private Anchor datingGoals = new Anchor("Dating Goals");
	private Anchor financialGoals = new Anchor("Financial Goals");
	private Anchor friendships = new Anchor("Friendship Goals");
	private Anchor family = new Anchor("Family Goals");
	private Anchor wlb = new Anchor("Work Life Balance");
	private Anchor ctk = new Anchor("Creativity Tool Kit");
	private Anchor mentorship = new Anchor("Mentorship");
	private VerticalPanel businesses = new VerticalPanel();
	private Anchor vendor = new Anchor("Product Solutions");
	private Anchor products = new Anchor("Show My Products");
	private Anchor interns = new Anchor("Internships");
	private Anchor mentors = new Anchor("Mentoring");
	private Anchor teamBuilding = new Anchor("Team Building");
	private Anchor personalityTypes = new Anchor("Personality Types");
	private VerticalPanel professional = new VerticalPanel();
	private Anchor salaryGoals = new Anchor("Salary Goals");
	private Anchor careerManager = new Anchor("Career Goals");
	private Anchor strengthsManager = new Anchor("Strengths Manager");
	private Anchor weaknessManager = new Anchor("Weakness Manager");
	private VerticalPanel travel = new VerticalPanel();
	private Anchor travelGoals = new Anchor("Travel Goals");
	private Anchor travelAttractions = new Anchor("Travel Attractions");
	private VerticalPanel workPlace = new VerticalPanel();
	private VerticalPanel events = new VerticalPanel();
	private Anchor organizeEvents = new Anchor("Organize Events");
	private Anchor careerEvents = new Anchor("Career Events");
	private Anchor familyEvents = new Anchor("Family Events");
	private Anchor socialEvents = new Anchor("Social Events");
	private VerticalPanel fun = new VerticalPanel();
	private Anchor sports = new Anchor("Sports Goals");
	private Anchor music = new Anchor("Music Manager");
	private Anchor books = new Anchor("Books Manager");
	private Anchor movies = new Anchor("Movie Manager");
	private Anchor tvShows = new Anchor("TV Shows");
	private Anchor creativityCenter = new Anchor("My Creativity Center");
	private DatingView datingView = new DatingView();
	private FinancialGoalsView financialGoalsView = new FinancialGoalsView();
	private FriendshipGoalsView friendshipGoalsView = new FriendshipGoalsView();
	private FamilyGoalsView familyGoalsView = new FamilyGoalsView();
	private ProfessionalGoalsView professionalView = new ProfessionalGoalsView();
	private SalaryGoalsView salaryGoalsView = new SalaryGoalsView();
	private CareerManagerView careerManagerView = new CareerManagerView();
	private StrengthsManagerView strengthsManagerView = new StrengthsManagerView();
	private VendorFormView vendorFormView = new VendorFormView(topBarViewListener);
	private WorkLifeBalanceView wlbView = new WorkLifeBalanceView();
	private CreativityToolKitView ctkView = new CreativityToolKitView();
	private MentorView mentorView = new MentorView();
	private InternshipBizView internshipBizView = new InternshipBizView();
	private InsuranceView insuranceView = new InsuranceView();
	private EventsView eventsView = new EventsView();
	private TravelView travelView = new TravelView();
	private InternGoalMatchingEvent internGoalMatchingEvent;
    public TopBarView(TopBarViewListener topBarViewListener){
    	internGoalMatchingEvent = new InternGoalMatchingEvent();
		this.topBarViewListener = topBarViewListener;
		initWidget(hTopPanel);	
		hTopPanel.add(consumerPanel);
		consumerPanel.setWidth("0px");
		consumerPanel.setAnimationEnabled(true);
		personal.add(personalGoals);
		personal.add(setGoals);
		personal.add(datingGoals);
		personal.add(financialGoals);
		personal.add(friendships);
		personal.add(family);
		consumerPanel.add(personal, "Personal Goals");
		professional.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		professional.add(salaryGoals);
		professional.add(careerManager);
		professional.add(strengthsManager);
		professional.add(weaknessManager);
		consumerPanel.add(professional, "Professional Goals");
		hTopPanel.add(space1);
		hTopPanel.add(bizPanel);
		bizPanel.setWidth("100px");
		bizPanel.setAnimationEnabled(true);
		businesses.add(vendor);
		businesses.add(products);
		businesses.add(interns);
		businesses.add(mentors);
		bizPanel.add(businesses, "Businesses");
		workPlace.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		workPlace.add(mentorship);
		workPlace.add(ctk);
		workPlace.add(wlb);
		workPlace.add(teamBuilding);
		workPlace.add(personalityTypes);
		
		
		bizPanel.add(workPlace, "Work Places Goals");
		//bizPanel.add(insurance, "Health Companies");
		hTopPanel.add(space2);
		hTopPanel.add(funPanel);
		funPanel.setWidth("100px");
		funPanel.setAnimationEnabled(true);
		travel.add(travelGoals);
		travel.add(travelAttractions);
		funPanel.add(travel, "Travel Goals");
		events.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		events.add(organizeEvents);
		events.add(careerEvents);
		events.add(familyEvents);
		events.add(socialEvents);
		funPanel.add(events, "Events Goals");
		fun.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		fun.add(sports);
		fun.add(music);
		fun.add(books);
		fun.add(movies);
		fun.add(tvShows);
		fun.add(creativityCenter);
		funPanel.add(fun, "Fun Goals");
		
		personalGoals.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onPersonalGoalsSelect();
		      }
		    });
		setGoals.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onAllGoalsSelect();
		      }
		    });
		datingGoals.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onGoalWordsSelect(datingView);
		      }
		    });
		friendships.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onGoalWordsSelect(friendshipGoalsView);
		      }
		    });
		family.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onGoalWordsSelect(familyGoalsView);
		      }
		    });
		financialGoals.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onGoalWordsSelect(financialGoalsView);
		      }
		    });
		salaryGoals.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  professional.setText("click handle test");
		        onGoalWordsSelect(salaryGoalsView);
		      }
		    });
		careerManager.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onCareerManagerViewSelect(careerManagerView);
		      }
		    });
		strengthsManager.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        onGoalWordsSelect(strengthsManagerView);
		      }
		    });
		weaknessManager.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  professional.setText("click handle test");
		        onGoalWordsSelect(professionalView);
		      }
		    });
		wlb.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        //vendor.setText("click handle test");
		        onGoalWordsSelect(wlbView);
		      }
		    });
		ctk.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        //vendor.setText("click handle test");
		        onGoalWordsSelect(ctkView);
		      }
		    });
		mentorship.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        //vendor.setText("click handle test");
		        onGoalWordsSelect(mentorView);
		      }
		    });
		mentors.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        //vendor.setText("click handle test");
		        onGoalWordsSelect(mentorView);
		      }
		    });
		interns.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        //vendor.setText("click handle test");
		        onGoalWordsSelect(internshipBizView);
		      }
		    });
		vendor.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		       // vendor.setText("click handle test");
		        onGoalWordsSelect(vendorFormView);
		      }
		    });
		products.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		       // vendor.setText("click handle test");
		    	  onShowAllMyProductsSelect();
		      }
		    });
		organizeEvents.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		     //   insurance.setText("click handle test");
		        onGoalWordsSelect(insuranceView);
		      }
		    });
		careerEvents.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  events.setText("click handle test");
		        onGoalWordsSelect(eventsView);
		      }
		    });
		familyEvents.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		     //   insurance.setText("click handle test");
		        onGoalWordsSelect(insuranceView);
		      }
		    });
		socialEvents.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  events.setText("click handle test");
		        onGoalWordsSelect(eventsView);
		      }
		    });
		travelGoals.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		  //  	  travel.setText("click handle test");
		        onGoalWordsSelect(travelView);
		      }
		    });
		travelAttractions.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		  //  	  travel.setText("click handle test");
		        onGoalWordsSelect(travelView);
		      }
		    });
		music.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onPersonalGoalsSelect();
		      }
		    });
		sports.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  onAllGoalsSelect();
		      }
		    });
		movies.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  professional.setText("click handle test");
		        onGoalWordsSelect(professionalView);
		      }
		    });
		tvShows.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  professional.setText("click handle test");
		        onGoalWordsSelect(professionalView);
		      }
		    });
		creativityCenter.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  professional.setText("click handle test");
		        onGoalWordsSelect(professionalView);
		      }
		    });
		books.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    //	  professional.setText("click handle test");
		        onGoalWordsSelect(professionalView);
		      }
		    });
	}
	
private void onGoalWordsSelect(Widget w){
	topBarViewListener.onGoalWordsSelect(w);
}

private void onPersonalGoalsSelect(){
	topBarViewListener.onPersonalGoalsSelect();
}

private void onAllGoalsSelect(){
	topBarViewListener.onAllGoalsSelect();
}
private void onShowAllMyProductsSelect(){
	topBarViewListener.onShowAllMyProductsSelect();
}
private void onCareerManagerViewSelect(Widget w){
	topBarViewListener.onCareerManagerViewSelect(w);
}

public void addSearchResultsView(VendorFormView view ){
	//mainView.add( view );
	}

 public MentorView getMentorView(){
	 return mentorView;
 }
 
 public VendorFormView getVendorFormView(){
	 return vendorFormView;
 }
 public DatingView getDatingView(){
	 return datingView;
 }
 public CareerManagerView getCareerManagerView(){
	 return careerManagerView;
 }
 public InternshipBizView getInternshipBizView(){
	 return internshipBizView;
 }
 public InternGoalMatchingEvent getInternGoalMatchingEvent(){
	 return internGoalMatchingEvent;
 }
}