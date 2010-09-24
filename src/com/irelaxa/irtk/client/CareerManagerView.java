package com.irelaxa.irtk.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.datepicker.client.DateBox;

public class CareerManagerView extends Composite {
	private FlexTable vendorTable = new FlexTable();
	FlexCellFormatter cellFormatter = vendorTable.getFlexCellFormatter();
	private Button careerSendButton = new Button("Save");
    	private TextBox price = new TextBox();
    private TextBox time = new TextBox();
    DateTimeFormat dateFormat = DateTimeFormat.getLongDateFormat();
    private DateBox sdateBox = new DateBox();
    private DateBox edateBox = new DateBox();
    private TextArea longTermArea = new TextArea();
    private TextArea shortTermArea = new TextArea();
    private TextBox firstName = new TextBox();
    private TextBox lastName = new TextBox();
    private TextBox universityName = new TextBox();
    private TextBox degreePursuing = new TextBox();
    private Anchor myCareerGoalsLink = new Anchor("My Career Goals");
    private Anchor internCompaniesLink = new Anchor("Internships");
    private Anchor mentorCompaniesLink = new Anchor("Mentorships");
  
	CareerManagerView(){
		initWidget(vendorTable);
		vendorTable.setWidth("48em");
		vendorTable.setCellSpacing(5);
		vendorTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		vendorTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		vendorTable.setWidget(1, 0, new HTML("<p align ='center' color='=#FFFF00'><b>Your Career Manager</b></p>"));
		addGoalType();
	}
	public void addGoalType(){
		shortTermArea.setSize("100%", "14em");
		longTermArea.setSize("100%", "14em");
	    shortTermArea.setCharacterWidth(17);
	    shortTermArea.setVisibleLines(7);
	    vendorTable.setWidget(0, 0, myCareerGoalsLink);
	    vendorTable.setWidget(1, 1, internCompaniesLink);
	    vendorTable.setWidget(1, 2, mentorCompaniesLink);
	    vendorTable.setWidget(2, 0, new HTML("<b>Long Term Goals</b>"));
	    vendorTable.setWidget(2, 1, shortTermArea);
	    longTermArea.setCharacterWidth(17);
	    longTermArea.setVisibleLines(7);
	    vendorTable.setWidget(2, 2, new HTML("<b>Short Term Goals</b>"));
		vendorTable.setWidget(2, 3, longTermArea);
		vendorTable.setWidget(3, 0, new HTML("<b>How many hours per week are you available for work Mentorship?</b>"));
		vendorTable.setWidget(3, 1, time);
		vendorTable.setWidget(3, 2, new HTML("<b>What are your per month Stipend requirements?</b>"));
		vendorTable.setWidget(3, 3, price);
		sdateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		vendorTable.setWidget(4, 0, new HTML("<b> From what Date are you available to strat the Mentorship Program</b>"));
		vendorTable.setWidget(4, 1, sdateBox);
		edateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		vendorTable.setWidget(4, 2, new HTML("<b>Until what Date are you available for the mentorship Program?</b>"));
		vendorTable.setWidget(4, 3, edateBox);
		vendorTable.setWidget(5, 0, new HTML("<b>First Name</b>"));
		vendorTable.setWidget(5, 1, firstName);
		vendorTable.setWidget(5, 2, new HTML("<b>Last Name</b>"));
		vendorTable.setWidget(5, 3, lastName);
		vendorTable.setWidget(6, 0, new HTML("<b>University Name</b>"));
		vendorTable.setWidget(6, 1, universityName);
		vendorTable.setWidget(6, 2, new HTML("<b>Degree Pursuing </b>"));
		vendorTable.setWidget(6, 3, degreePursuing);
		vendorTable.setWidget(7, 2, careerSendButton);	  
	}
	 
	 public Button getSubmitCareerManagerButton(){
		 return careerSendButton;
	 }
	 public Anchor getInternshipsLink(){
		 return internCompaniesLink;
	 }
	 public Anchor getMentorshipsLink(){
		 return mentorCompaniesLink;
	 }
	 public Anchor getMyCareerGoalsLink(){
		 return myCareerGoalsLink;
	 }
	 
	 public String getPrice() {
			return price.getValue();
		}
		
		public String getTime() {
			return time.getValue();
		}
		
		public DateBox getSdateBox() {
			return sdateBox;
		}
		
		public DateBox getEdateBox() {
			return edateBox;
		}
		
		public String getLongTermArea() {
			return longTermArea.getValue();
		}
		
		public String getShortTermArea() {
			return shortTermArea.getValue();
		}
		
		public String getFirstName() {
			return firstName.getValue();
		}
		
		public String getLastName() {
			return lastName.getValue();
		}
		
		public String getUniversityName() {
			return universityName.getValue();
		}
		
		public String getDegreePursuing() {
			return degreePursuing.getValue();
		}
		
		 public void setPriceNull() {
				this.price.setValue("");
			}
			
			public void setTimeNull() {
				this.time.setValue("");
			}
			
			public void setSdateBoxNull() {
				this.sdateBox.setValue(null);
			}
			
			public void setEdateBoxNull() {
				this.edateBox.setValue(null);
			}
			
			public void setLongTermAreaNull() {
				this.longTermArea.setValue("");
			}
			
			public void setShortTermAreaNull() {
				this.shortTermArea.setValue("");
			}
			
			public void setFirstNameNull() {
				this.firstName.setValue("");
			}
			
			public void setLastNameNull() {
				this.lastName.setValue("");
			}
			
			public void setUniversityNameNull() {
				this.universityName.setValue("");
			}
			
			public void setDegreePursuingNull() {
				this.degreePursuing.setValue("");
			}

}
