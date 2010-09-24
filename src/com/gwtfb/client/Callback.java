package com.gwtfb.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Callback that by default logs the response.
 */
public class Callback<T> implements AsyncCallback<T> {

	//public Anchor fbLogOut = new Anchor();
    public Callback () {
    	
    }

    public void onFailure(Throwable caught) {
        throw new RuntimeException ( caught );
    }
    
   
    public void onSuccess(T result) {
        GWT.log ( result + "" , null );
       /* RootPanel.get("fblogout").clear();
        RootPanel.get("fblogout").add(fbLogOut);*/
    }
    
    

}