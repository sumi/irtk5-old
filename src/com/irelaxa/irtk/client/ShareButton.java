package com.irelaxa.irtk.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Facebook "share" link or button. See <a
 * href="http://wiki.developers.facebook.com/index.php/Fb:share-button"
 * >http://wiki.developers.facebook.com/index.php/Fb:share-button</a>.
 * 
 * @author David Wolverton
 */
public class ShareButton extends Button {
	JavaScriptObject attachment = null;
	public enum Style {
		ICON_ONLY, LINK_ONLY, LINK_AND_ICON, BUTTON
	}

	public ShareButton() {
		this.url = Location.getHref();
		this.title = Window.getTitle();
		init();
	}

	/**
	 * @param url - See {@link #setURL(String)}
	 * @param title - See {@link #setTitle(String)}
	 */
	public ShareButton(String url, String title) {
		this.url = url;
		this.title = title;
		init();
	}

	/**
	 * @param url - See {@link #setURL(String)}
	 * @param title - See {@link #setTitle(String)}
	 * @param style - See {@link #setStyle(Style)}
	 */
	public ShareButton(String url, String title, Style style) {
		this.url = url;
		this.title = title;
		this.style = style;
		init();
	}

	/**
	 * @param url - See {@link #setURL(String)}
	 * @param title - See {@link #setTitle(String)}
	 * @param style - See {@link #setStyle(Style)}
	 * @param text - See {@link #setText(String)}
	 */
	public ShareButton(String url, String title, Style style, String text) {
		this.url = url;
		this.title = title;
		this.style = style;
		this.text = text;
		init();
	}

	private void init() {
		AnchorElement el = DOM.createAnchor().cast();
		setElement(el);
		el.setTarget("_blank");
		if (style == null)
			style = Style.BUTTON;
		addDomHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				event.preventDefault();
				//handleClick();
				//ui_streamPublish(attachment);
			}
		}, ClickEvent.getType());
		setURL(url);
		setStyle(style);
	}

	private Style style;
	private String text;
	private String url;
	private String title;

	public String getURL() {
		return url;
	}

	/**
	 * The URL to share. Default is the page that contains the button.
	 */
	public void setURL(String url) {
		this.url = url;
		AnchorElement.as(getElement()).setHref("http://www.facebook.com/share.php?u=" + URL.encodeComponent(url));
	}

	public String getTitle() {
		return title;
	}

	/**
	 * The title for the shared URL. Default is the HTML page title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public Style getStyle() {
		return style;
	}

	/**
	 * How to render the button: A Facebook ICON_ONLY, LINK_ONLY without any
	 * icon, LINK_AND_ICON with a Facebook icon and link text or BUTTON with a
	 * Facebook icon that says "Share". (The default is BUTTON.)
	 * 
	 * <p>
	 * See <a
	 * href="http://www.facebook.com/share_partners.php">http://www.facebook
	 * .com/share_partners.php</a>
	 * 
	 * @param style
	 */
	public void setStyle(Style style) {
		this.style = style;
		switch (style) {
		case BUTTON:
			setStyleName("fb_share_button");
			if (text == null)
				text = "Share";
			getElement().setInnerText(text);
			break;
		case ICON_ONLY:
			setStyleName("");
			getElement().setInnerHTML(
					"<img src=\"http://static.ak.fbcdn.net/images/share/facebook_share_icon.gif?8:26981\" alt=\"\" />");
			break;
		case LINK_AND_ICON:
			setStyleName("fb_share_link");
			if (text == null)
				text = "Share on Facebook";
			getElement().setInnerHTML(text);
			break;
		case LINK_ONLY:
			setStyleName("");
			if (text == null)
				text = "Share on Facebook";
			getElement().setInnerHTML(text);
			break;
		}
	}

	public String getText() {
		return text;
	}

	/**
	 * The text to display in the link or button. If none is specified, links
	 * will use "Share on Facebook" and buttons will use "Share".
	 */
	public void setText(String text) {
		this.text = text;
		setStyle(style); // apply the text change
	}

}
