package com.gwtfb.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtfb.sdk.FBCore;
import com.gwtfb.sdk.FBXfbml;

public class UserInfoViewController extends Composite {
	
    private HTML welcomeHtml = new HTML ();
	private VerticalPanel outer = new VerticalPanel ();
	//private Anchor streamPublishLink = new Anchor ( "Test Stream Publish" );
	//private Anchor streamShareLink = new Anchor ( "Test Stream Share" );
	
	private FBCore fbCore;
	
	/**
	 * New View
	 */
	public UserInfoViewController ( final FBCore fbCore ) {
		
	    this.fbCore = fbCore;

	    outer.add ( welcomeHtml );
		outer.add ( new HTML ( "<p/>" ) );
        outer.add ( new HTML ( "<hr/><fb:comments xid='gwtfb' />" ) );
		/*
		 * Stream Publish 
		 */
		class PublishHandler implements ClickHandler {
            public void onClick(ClickEvent event) {
                testPublish ();
            }
		}
		//streamPublishLink.addClickHandler( new PublishHandler () );
		//outer.add ( streamPublishLink );
		
		/*
		 * Stream Share
		 */
		class ShareHandler implements ClickHandler {
		    public void onClick(ClickEvent event) {
		        testShare ();
		    }
		}
		//streamShareLink.addClickHandler( new ShareHandler () );
		//outer.add ( streamShareLink );
		
		/*
		 * Display User info
		 */
		class MeCallback extends Callback<JavaScriptObject> {
			public void onSuccess ( JavaScriptObject response ) {
				renderMe ( response );
			}
		}
		fbCore.api ( "/me" , new MeCallback () );
		

		/*
		 * Display number of posts
		 */
		class PostsCallback extends Callback<JavaScriptObject> {
			public void onSuccess ( JavaScriptObject response ) {
				JSOModel model = response.cast ();
				JsArray array = model.getArray("data");
				outer.add ( new HTML ( "Posts " + array.length() ) );
			}
		}
		fbCore.api ( "/f8/posts",  new PostsCallback () );
		initWidget ( outer );
	}

	/**
	 * Render information about logged in user
	 */
	private void renderMe ( JavaScriptObject response ) {
		JSOModel jso = response.cast();
		welcomeHtml.setHTML ( "<h3> Hi,  " + jso.get ( "name" ) + "</h3> GwtFB is a simple GWT Facebook Graph Client. "  );
		
		HTML json = new HTML ( new JSONObject ( response ).toString() );
		json.addStyleName("jsonOutput");
		outer.add ( json );
		
	}



	/**
	 * Render publish
	 */
	public void testPublish () {
	    JSONObject data = new JSONObject ();
	    data.put( "method", new JSONString ( "stream.publish" ) );
	    data.put( "message", new JSONString ( "Getting education about Facebook Connect and GwtFB" ) );
	    
	    JSONObject attachment = new JSONObject ();
	    attachment.put( "name", new JSONString ( "GwtFB" ) );
	    attachment.put("caption", new JSONString ( "The Facebook Connect Javascript SDK and GWT" ) );
	    attachment.put( "description", new JSONString ( "A small GWT library that allows you to interact with Facebook Javascript SDK in GWT ") ); 
	    attachment.put("href",  new JSONString ( "http://www.gwtfb.com" ) );
	    data.put( "attachment", attachment );

	    JSONObject actionLink = new JSONObject ();
	    actionLink.put ( "text", new JSONString ( "Code" ) );
	    actionLink.put ( "href", new JSONString ( "http://www.gwtfb.com" ) );

	    JSONArray actionLinks = new JSONArray ();
	    actionLinks.set(0, actionLink);
	    data.put( "action_links", actionLinks);

	    data.put( "user_message_prompt", new JSONString ( "Share your thoughts about Connect and GWT" ) );
	    
	    fbCore.ui(data.getJavaScriptObject(), new Callback () );
	    
	}
	
	/**
	 * Render share
	 */
	public void testShare () {
	    JSONObject data = new JSONObject ();
	    data.put( "method", new JSONString ( "stream.share" ) );
	    data.put( "u", new JSONString ( "http://www.gwtfb.com" ) );
	    fbCore.ui ( data.getJavaScriptObject(), new Callback () );
	}
}
