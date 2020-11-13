package edu.temple.webbrowser.FragmentInterfaces;

import edu.temple.webbrowser.ActivityFragments.PagerFragment;

public class PagerFragmentInterface {

    PagerFragment pagerFragment;

    public void setPagerFragment(PagerFragment pagerFragment) {
        this.pagerFragment = pagerFragment;
    }

    public void setActivePage(int i){
        pagerFragment.setActivePage(i);
    }

}
