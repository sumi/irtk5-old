package com.irelaxa.irtk.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
public class BizIrtk {
	private DecoratedTabPanel bizPanel = new DecoratedTabPanel();
    private StackPanel vendorPanel = new StackPanel();
    private Button revenueButton = new Button("Add Products");
    final DialogBox dialogBox = new DialogBox();
	public void loadTopHoriPanel(){
		final Irtk irtk = new Irtk();
		bizPanel.setWidth("100px");
		bizPanel.setAnimationEnabled(true);
		vendorPanel.add(revenueButton);	
		bizPanel.add(vendorPanel, "Revenue");
		irtk.topHoriPanel.add(bizPanel);
		RootPanel.get("topPanel").add(bizPanel);
		revenueButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	//  RootPanel.get("flexTable").remove(irtk.flexTable);
		    	 // irtk.flexTable.removeAllRows();
		    	//  RootPanel.get("flexTable").add(irtk.flexTable);
		    	  dialogBox.setText("Testing");
		      }
		    });
	}
	
	
}