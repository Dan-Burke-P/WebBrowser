package edu.temple.webbrowser.FragmentInterfaces;

import edu.temple.webbrowser.ActivityFragments.BrowserControlFragment;

public class BrowserControlFragmentInterface {
    BrowserControlFragment browserControlFragment;

    public void setBrowserControlFragment(BrowserControlFragment browserControlFragment){
        this.browserControlFragment = browserControlFragment;
    }

    public void notifyDataSetUpdate(){
        browserControlFragment.notifyDataSetUpdate();
    }
}
