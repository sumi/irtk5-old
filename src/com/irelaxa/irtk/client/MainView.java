package com.irelaxa.irtk.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {
	private TopBarViewListener topbarViewListener;
	private TopBarView topBarView = new TopBarView(topbarViewListener);
	private GoalFormView goalFormView = new GoalFormView();
	private MatchResultsView matchResultsView = new MatchResultsView();
	private VerticalPanel vMainPanel = new VerticalPanel();
	
	
	public MainView(){
		initWidget(vMainPanel);	
		vMainPanel.add(topBarView);
		vMainPanel.add(new HTML("<h1 align='center'>Goal Match Engine</h1>" +
				" <table align='center'><tr>"+
        "<td colspan='2' style='font-weight:bold;'>Satisfy your SMART Goals:</td></tr>" +       
      "<tr><td>S-pecific, M-easurable, A-ttainable, R-ealistic, T-imely</td></tr></table>"));
		vMainPanel.setHorizontalAlignment( HasHorizontalAlignment.ALIGN_CENTER);
		vMainPanel.add(goalFormView);
		
	}
	public void addVendorForm(VendorFormView vendorFormView){
		vMainPanel.remove(goalFormView);
		vMainPanel.add(vendorFormView);
	}
	
	
}