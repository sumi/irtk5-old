package com.irelaxa.irtk.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class TravelView extends Composite {
	private FlexTable travelTable = new FlexTable();
	FlexCellFormatter cellFormatter = travelTable.getFlexCellFormatter();
	TravelView(){
		initWidget(travelTable);
		travelTable.setWidth("32em");
		travelTable.setCellSpacing(5);
		travelTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		travelTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		travelTable.setWidget(2, 0, new HTML("Your Travel Details"));
	}
}