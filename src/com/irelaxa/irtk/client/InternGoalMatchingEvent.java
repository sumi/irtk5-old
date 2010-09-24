package com.irelaxa.irtk.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.datepicker.client.DateBox;

public class InternGoalMatchingEvent extends Composite {
	private FlexTable vendorTable = new FlexTable();
	FlexCellFormatter cellFormatter = vendorTable.getFlexCellFormatter();
	private DockPanel internEvent = new DockPanel();
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
    private Button submitCompany = new Button("Submit Company");
    private Button submitIntern = new Button("Submit Intern");
  
    InternGoalMatchingEvent(){
		initWidget(vendorTable);
		/*internEvent.add(new Label("Intern Goal Match Event"), internEvent.NORTH);
		internEvent.add(new Label("April 25, 2010"), internEvent.SOUTH);
		internEvent.add(new Label("Companies"), internEvent.SOUTH);
		
		internEvent.add(new Label("Interns"), internEvent.WEST);
		internEvent.add(new Label("Step 1: Access to Software Students"), internEvent.SOUTH);
		internEvent.add(new Label("Step 1: Get Real Life Experince while still at School"), internEvent.WEST);
		internEvent.add(new Label("Step 2: Build Your Products"), internEvent.SOUTH);
		internEvent.add(new Label("Step 2: Learn your Passions while at School"), internEvent.WEST);
		internEvent.add(new Label("Step 3: $100/Student/Month"), internEvent.SOUTH);
		internEvent.add(new Label("Step 3: Earn While still at School"), internEvent.WEST);*/
		
		vendorTable.setWidth("48em");
		vendorTable.setCellSpacing(5);
		vendorTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		//vendorTable.getFlexCellFormatter().setColSpan(0, 0, 3);
		//vendorTable.setWidget(0, 0, new HTML("<p align ='center'><b><font color='#0000ff' size='12'>Intern Goal Match Event</font></b></p>"));
		//vendorTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		//vendorTable.setWidget(1, 1, new HTML("<p align ='left'><font color='green' size='5'><b></b></font></p>"));
		vendorTable.setWidget(1, 3, new HTML("<p align ='left'><font color='green' size='5'><b>COMPANIES</b></font></p>"));
		//vendorTable.getFlexCellFormatter().setColSpan(1, 2, 2);
		vendorTable.setWidget(1, 5, new HTML("<p align ='left'><font color='green' size='5'><b>INTERNS</b></font></p>"));
		
		vendorTable.setWidget(2, 3, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 1</font> </br><font color='green' size='5'> Access Skilled Software<br>University Students</font></b></p>"));
		//vendorTable.getFlexCellFormatter().setColSpan(1, 2, 2);
		vendorTable.setWidget(2, 5, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 1 </font></br> <font color='green' size='5'>Get Work Experince <br>while still at School</font></b></p>"));
		
		vendorTable.setWidget(3, 3, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 2</font> </br><font color='green' size='5'> Get Your Products Build</font></b></p>"));
		//vendorTable.getFlexCellFormatter().setColSpan(1, 2, 2);
		vendorTable.setWidget(3, 5, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 2 </font></br><font color='green' size='5'> Get Mentorship from Hi Tech Companies</font></b></p>"));
		
		vendorTable.setWidget(4, 3, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 3 </font></br> <font color='green' size='5'>All for $100/student/month</font></b></p>"));
		//vendorTable.getFlexCellFormatter().setColSpan(1, 2, 2);
		vendorTable.setWidget(4, 5, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 3 </font></br><font color='green' size='5'> Get paid while learning.</font></b></p>"));
		vendorTable.setWidget(4, 3, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 3 </font></br> <font color='green' size='5'>All for $100/student/month</font></b></p>"));
		//vendorTable.getFlexCellFormatter().setColSpan(1, 2, 2);
		vendorTable.setWidget(4, 5, new HTML("<p align ='left'><b><font color='red' size='5'>STEP 3 </font></br><font color='green' size='5'> Get paid while learning.</font></b></p>"));
		vendorTable.setWidget(5, 3, submitCompany);
		//vendorTable.getFlexCellFormatter().setColSpan(1, 2, 2);
		vendorTable.setWidget(5, 5, submitIntern);
		
	}
	 
	 public Button getSubmitCareerManagerButton(){
		 return careerSendButton;
	 }
	 
	 public TextBox getPrice() {
			return price;
		}
		public void setPrice(TextBox price) {
			this.price = price;
		}
		public TextBox getTime() {
			return time;
		}
		public void setTime(TextBox time) {
			this.time = time;
		}
		public DateBox getSdateBox() {
			return sdateBox;
		}
		public void setSdateBox(DateBox sdateBox) {
			this.sdateBox = sdateBox;
		}
		public DateBox getEdateBox() {
			return edateBox;
		}
		public void setEdateBox(DateBox edateBox) {
			this.edateBox = edateBox;
		}
		public TextArea getLongTermArea() {
			return longTermArea;
		}
		public void setLongTermArea(TextArea longTermArea) {
			this.longTermArea = longTermArea;
		}
		public TextArea getShortTermArea() {
			return shortTermArea;
		}
		public void setShortTermArea(TextArea shortTermArea) {
			this.shortTermArea = shortTermArea;
		}
		public TextBox getFirstName() {
			return firstName;
		}
		public void setFirstName(TextBox firstName) {
			this.firstName = firstName;
		}
		public TextBox getLastName() {
			return lastName;
		}
		public void setLastName(TextBox lastName) {
			this.lastName = lastName;
		}
		public TextBox getUniversityName() {
			return universityName;
		}
		public void setUniversityName(TextBox universityName) {
			this.universityName = universityName;
		}
		public TextBox getDegreePursuing() {
			return degreePursuing;
		}
		public void setDegreePursuing(TextBox degreePursuing) {
			this.degreePursuing = degreePursuing;
		}

		public Button getSubmitCompanyButton(){
			return submitCompany;
		}
		public Button getSubmitInternButton(){
			return submitIntern;
		}
}
