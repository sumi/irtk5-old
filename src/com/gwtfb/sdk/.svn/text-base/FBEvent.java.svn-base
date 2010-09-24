package com.gwtfb.sdk;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtfb.client.Callback;

/**
 * Class that wraps Facebook Event Handling methods
 * @see http://developers.facebook.com/docs/reference/javascript/#event-handling
 * @author ola
 */
public class FBEvent {
	
	/**
	 * Wrapper method
	 * http://developers.facebook.com/docs/reference/javascript/FB.Event.subscribe
	 */
	public native void subscribe(String event, Callback<JavaScriptObject> callback ) /*-{
		var app=this;
		$wnd.FB.Event.subscribe(event,function(response){
			app.@com.gwtfb.sdk.FBEvent::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	public native void unsubscribe(String event, Callback<JavaScriptObject> callback ) /*-{
	    var app=this;
        $wnd.FB.Event.unsubscribe(event,function(response){
            app.@com.gwtfb.sdk.FBEvent::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
        });
	}-*/;
	
	/*
     * Called when method succeeded.
     */
    protected void callbackSuccess(AsyncCallback<JavaScriptObject> callback, JavaScriptObject obj) {
        callback.onSuccess ( obj );
    }
}
