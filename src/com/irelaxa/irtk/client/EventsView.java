package com.irelaxa.irtk.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class EventsView extends Composite {
	private FlexTable eventsFormTable = new FlexTable();
	FlexCellFormatter cellFormatter = eventsFormTable.getFlexCellFormatter();
	EventsView(){
		initWidget(eventsFormTable);
		eventsFormTable.setWidth("32em");
		eventsFormTable.setCellSpacing(5);
		eventsFormTable.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 1,
		        HasHorizontalAlignment.ALIGN_LEFT);
		eventsFormTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		eventsFormTable.setWidget(2, 0, new HTML("Events List"));
	}
}