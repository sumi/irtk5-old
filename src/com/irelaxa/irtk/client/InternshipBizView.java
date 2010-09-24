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

public class InternshipBizView extends Composite {
	private FlexTable vendorTable = new FlexTable();
	FlexCellFormatter cellFormatter = vendorTable.getFlexCellFormatter();
	private Button internshipBizSendButton = new Button("Save");
	private TextArea skills = new TextArea();
	private TextArea time = new TextArea();
	private TextArea project = new TextArea();
	private TextBox pay = new TextBox();
    private TextBox businessName = new TextBox();
    private TextBox contactName = new TextBox();
    DateTimeFormat dateFormat = DateTimeFormat.getLongDateFormat();
    private DateBox sdateBox = new DateBox();
    private DateBox edateBox = new DateBox();
    private Anchor internsLink = new Anchor("Available Interns");
    private Anchor myInternshipBizLink = new Anchor("My Internship Positions");
	InternshipBizView(){
		initWidget(vendorTable);
		vendorTable.setWidth("48em");
		vendorTable.setCellSpacing(5);
		vendorTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		vendorTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		vendorTable.setWidget(1, 0, new HTML("<b align ='center'><p><b>What are your Internship Requirements</b></p></b>"));
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
		project.setSize("100%", "14em");
		project.setSize("100%", "14em");
		project.setCharacterWidth(17);
		project.setVisibleLines(7);
		vendorTable.setWidget(0, 0, myInternshipBizLink);
		vendorTable.setWidget(1, 1, internsLink);
	    vendorTable.setWidget(2, 0, new HTML("<b>What are your internship Skill requirement?</b>"));
		 vendorTable.setWidget(2, 1, skills);
		 vendorTable.setWidget(2, 2, new HTML("<b>How many hours per week time committment is required?</b>"));
		 vendorTable.setWidget(2, 3, time);
		 vendorTable.setWidget(3, 0, new HTML("<b>Brief description about the product and company</b>"));
		 vendorTable.setWidget(3, 1, project);
		 vendorTable.setWidget(3, 2, new HTML("<b>How much in $ are you willing to pay as weekly Stipend?</b>"));
		 vendorTable.setWidget(3, 3, pay);
		 sdateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		 vendorTable.setWidget(4, 0, new HTML("<b>Start Date of Internship</b>"));
		 vendorTable.setWidget(4, 1, sdateBox);
		    edateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		    vendorTable.setWidget(4, 2, new HTML("<b>End Date of Internship</b>"));
		    vendorTable.setWidget(4, 3, edateBox);
		    vendorTable.setWidget(5, 0, new HTML("<b>Company Name</b>"));
		    vendorTable.setWidget(5, 1, businessName);
		    vendorTable.setWidget(5, 2, new HTML("<b>Contact Name</b>"));
		    vendorTable.setWidget(5, 3, contactName);
		    vendorTable.setWidget(9, 2,internshipBizSendButton);
	}
	public Button getSubmitInternshipBizButton(){
		 return internshipBizSendButton;
	 }
	public Anchor getInternsLink(){
		 return internsLink;
	 }
	public Anchor getMyInternshipBizLink(){
		 return myInternshipBizLink;
	 }
	public String getSkills() {
		return skills.getValue();
	}
	
	public String getTime() {
		return time.getValue();
	}
	
	public String getProject() {
		return project.getValue();
	}
	
	public String getPay() {
		return pay.getValue();
	}
	
	public String getBusinessName() {
		return businessName.getValue();
	}
	
	public String getContactName() {
		return contactName.getValue();
	}
	
	public DateBox getSdateBox() {
		return sdateBox;
	}
	
	public DateBox getEdateBox() {
		return edateBox;
	}
	public  void setSkillsNull() {
		this.skills.setValue("");
	}
	
	public void setTimeNull() {
		this.time.setValue("");
	}
	
	public void setProjectNull() {
		this.project.setValue("");
	}
	
	public void setPayNull() {
		this.pay.setValue("");
	}
	
	public void setBusinessNameNull() {
		this.businessName.setValue("");
	}
	
	public void setContactNameNull() {
		this.contactName.setValue("");
	}
	
	public void setSdateBoxNull() {
		this.sdateBox.setValue(null);
	}
	
	public void setEdateBoxNull() {
		this.edateBox.setValue(null);
	}

	 }
