package edu.temple.webbrowser.FragmentInterfaces;

import android.view.View;

import edu.temple.webbrowser.ActivityFragments.PagerFragment;
import edu.temple.webbrowser.R;

public class PagerFragmentInterface {

    PagerFragment pagerFragment;

    public void setPagerFragment(PagerFragment pagerFragment) {
        this.pagerFragment = pagerFragment;
    }

    public void setActivePage(int i){
        pagerFragment.setActivePage(i);
    }

    public void show_bookmark(){
        pagerFragment.show_bookmark();
    }

}
