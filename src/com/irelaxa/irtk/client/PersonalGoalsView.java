package com.irelaxa.irtk.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class PersonalGoalsView extends Composite {
	private FlexTable personalGoalsTable = new FlexTable();
	FlexCellFormatter cellFormatter = personalGoalsTable.getFlexCellFormatter();
	PersonalGoalsView(){
		initWidget(personalGoalsTable);
		personalGoalsTable.setWidth("32em");
		personalGoalsTable.setCellSpacing(5);
		personalGoalsTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		personalGoalsTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		personalGoalsTable.setWidget(2, 0, new HTML("Your Personal Goals"));
	}
}