package com.gwtfb.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtfb.client.examples.Example;
import com.gwtfb.client.examples.FriendsExample;
import com.gwtfb.client.examples.StreamPublishExample;
import com.gwtfb.sdk.FBCore;
import com.gwtfb.sdk.FBEvent;
import com.gwtfb.sdk.FBXfbml;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * @author ola
 * 
 */
public class GwtFB implements EntryPoint, ValueChangeHandler<String>  {

    
   

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
	    History.addValueChangeHandler ( this );
	
		
		
		//
	   
		}
	
		
	 public void onValueChange(ValueChangeEvent<String> event) {
	       
	    }
	
}