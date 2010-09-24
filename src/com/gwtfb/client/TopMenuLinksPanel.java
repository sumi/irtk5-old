package com.gwtfb.client;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Topmenu links
 * @author ola
 */
public class TopMenuLinksPanel extends Composite {

    private DockPanel links = new DockPanel ();
    private HorizontalPanel leftSide = new HorizontalPanel ();
    
    Anchor sourceCodeLink = new Anchor ( "Source" );
    
    public TopMenuLinksPanel () {

        links.getElement().setId("TopMenuLinks");
        
        sourceCodeLink.setHref("http://code.google.com/p/gwtfb/source/browse/#svn/trunk/GwtFB/src/com/gwtfb/sdk");
        sourceCodeLink.setTarget("blank");
        
        leftSide.add ( new Hyperlink ( "Home" , "home" ) );
        leftSide.add ( new Hyperlink ( "Documentation", "wave" ) );
        leftSide.add( sourceCodeLink );
        
    
        links.add( leftSide, DockPanel.WEST );
        
        initWidget ( links );
    }
}
