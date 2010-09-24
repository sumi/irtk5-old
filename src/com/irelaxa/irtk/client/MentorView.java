package com.irelaxa.irtk.client;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.datepicker.client.DateBox;

public class MentorView extends Composite {
	private FlexTable vendorTable = new FlexTable();
	FlexCellFormatter cellFormatter = vendorTable.getFlexCellFormatter();
	private Button mentorSendButton = new Button("Save");
   	private TextBox businessName = new TextBox();
    private TextBox contactName = new TextBox();
    private TextArea time = new TextArea();
    private TextArea skills = new TextArea();
    private TextArea menteeDescription = new TextArea();
    private TextArea mentorDescription = new TextArea();
    DateTimeFormat dateFormat = DateTimeFormat.getLongDateFormat();
    DateBox sdateBox = new DateBox();
    DateBox edateBox = new DateBox();
    private Anchor internsLink = new Anchor("Available Interns");
    private Anchor myMentorshipsLink = new Anchor("My Mentorship Positions");
	MentorView(){
		initWidget(vendorTable);
		
		vendorTable.setWidth("48em");
		vendorTable.setCellSpacing(5);
		vendorTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		vendorTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		vendorTable.setWidget(1, 0, new HTML("<p align ='center'><b>What are your Mentee Requirements</b></p>"));
		addGoalType();
	}
	public void addGoalType(){
		skills.setSize("100%", "14em");
		skills.setSize("100%", "14em");
		skills.setCharacterWidth(17);
		skills.setVisibleLines(7);
		time.setSize("100%", "14em");
		time.setSize("100%", "14em");
		time.setCharacterWidth(17);
		time.setVisibleLines(7);
		menteeDescription.setSize("100%", "14em");
		menteeDescription.setSize("100%", "14em");
		menteeDescription.setCharacterWidth(17);
		menteeDescription.setVisibleLines(7);
		mentorDescription.setSize("100%", "14em");
		mentorDescription.setSize("100%", "14em");
		mentorDescription.setCharacterWidth(17);
		mentorDescription.setVisibleLines(7);
		vendorTable.setWidget(0, 0, myMentorshipsLink);
		vendorTable.setWidget(1, 1, internsLink);
	    vendorTable.setWidget(2, 0, new HTML("<b>In what skill sets are you offering mentoring?</b>"));
		 vendorTable.setWidget(2, 1, skills);
		 vendorTable.setWidget(2, 2, new HTML("<b>What days and times are you available for mentoring</b>"));
		 vendorTable.setWidget(2, 3, time);
		 vendorTable.setWidget(3, 0, new HTML("<b>What is the description of ideal Mentee for you?</b>"));
		 vendorTable.setWidget(3, 1, menteeDescription);
		 vendorTable.setWidget(3, 2, new HTML("<b>Brief description of Mentor?</b>"));
		 vendorTable.setWidget(3, 3, mentorDescription);
		 sdateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		 vendorTable.setWidget(4, 0, new HTML("<b>Mentorship Start Date</b>"));
		 vendorTable.setWidget(4, 1, sdateBox);
		    edateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		    vendorTable.setWidget(4, 2, new HTML("<b>Mentoring End Date</b>"));
		    vendorTable.setWidget(4, 3, edateBox);
		    vendorTable.setWidget(5, 0, new HTML("<b>Business Name</b>"));
		    vendorTable.setWidget(5, 1, businessName);
		    vendorTable.setWidget(5, 2, new HTML("<b>Contact Name</b>"));
		    vendorTable.setWidget(5, 3, contactName);
		    vendorTable.setWidget(6, 2, mentorSendButton);
	}
	
	public	 Button getMentorSaveButton(){
		 return mentorSendButton;
	 }
	public	 Anchor getInternsLink(){
		 return internsLink;
	 }
	public	 Anchor getMyMentorshipsLink(){
		 return myMentorshipsLink;
	 }
	 public String getBusinessName() {
			return businessName.getValue();
		}
		
		public String getContactName() {
			return contactName.getValue();
		}
		
		public String getTime() {
			return time.getValue();
		}
		
		public String getSkills() {
			return skills.getValue();
		}
		
		public String getMenteeDescription() {
			return menteeDescription.getValue();
		}
		
		public String getMentorDescription() {
			return mentorDescription.getValue();
		}
		
		public DateBox getSdateBox() {
			return sdateBox;
		}
		
		public DateBox getEdateBox() {
			return edateBox;
		}
		
		public void setBusinessNameNull() {
			this.businessName.setValue("");
		}
		
		public void setContactNameNull() {
			this.contactName.setValue("");
		}
		
		public void setTimeNull() {
			this.time.setValue("");
		}
		
		public void setSkillsNull() {
			this.skills.setValue("");
		}
		
		public void setMenteeDescriptionNull() {
			this.menteeDescription.setValue("");
		}
		
		public void setMentorDescriptionNull() {
			this.mentorDescription.setValue("");
		}
		
		public void setSdateBoxNull() {
			this.sdateBox.setValue(null);
		}
		
		public void setEdateBoxNull() {
			this.edateBox.setValue(null);
		}

}
