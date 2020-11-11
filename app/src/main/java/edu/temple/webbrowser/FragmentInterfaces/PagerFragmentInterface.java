package edu.temple.webbrowser.FragmentInterfaces;

import edu.temple.webbrowser.ActivityFragments.PagerFragment;

public class PagerFragmentInterface {

    PagerFragment pagerFragment;

    public void setPagerFragment(PagerFragment pagerFragment) {
        this.pagerFragment = pagerFragment;
    }

    public void addPage(){
        pagerFragment.addPage();
    }

    public void navigate(String s){
        pagerFragment.navigate(s);
    }

    public void goBack(){
        pagerFragment.goBack();
    }

    public void goForward(){
        pagerFragment.goForward();
    }
}