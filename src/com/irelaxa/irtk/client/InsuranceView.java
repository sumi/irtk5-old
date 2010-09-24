package com.irelaxa.irtk.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class InsuranceView extends Composite {
	private FlexTable insuranceFormTable = new FlexTable();
	FlexCellFormatter cellFormatter = insuranceFormTable.getFlexCellFormatter();
	InsuranceView(){
		initWidget(insuranceFormTable);
		insuranceFormTable.setWidth("32em");
		insuranceFormTable.setCellSpacing(5);
		insuranceFormTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		insuranceFormTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		insuranceFormTable.setWidget(2, 0, new HTML("WellNess"));
	}
}