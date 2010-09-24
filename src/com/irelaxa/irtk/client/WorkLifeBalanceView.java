package com.irelaxa.irtk.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class WorkLifeBalanceView extends Composite {
	private FlexTable workplaceTable = new FlexTable();
	FlexCellFormatter cellFormatter = workplaceTable.getFlexCellFormatter();
	WorkLifeBalanceView(){
		initWidget(workplaceTable);
		workplaceTable.setWidth("32em");
		workplaceTable.setCellSpacing(5);
		workplaceTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		workplaceTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		workplaceTable.setWidget(2, 0, new HTML("Work Life Balance"));
	}
}