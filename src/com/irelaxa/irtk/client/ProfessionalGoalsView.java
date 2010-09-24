package com.irelaxa.irtk.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class ProfessionalGoalsView extends Composite {
	private FlexTable professionalGoalsTable = new FlexTable();
	FlexCellFormatter cellFormatter = professionalGoalsTable.getFlexCellFormatter();
	ProfessionalGoalsView(){
		initWidget(professionalGoalsTable);
		professionalGoalsTable.setWidth("32em");
		professionalGoalsTable.setCellSpacing(5);
		professionalGoalsTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		professionalGoalsTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		professionalGoalsTable.setWidget(2, 0, new HTML("Your Professional Goals"));
	}
}