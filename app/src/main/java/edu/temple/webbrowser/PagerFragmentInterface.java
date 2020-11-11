package edu.temple.webbrowser;

public class PagerFragmentInterface {

    PagerFragment pagerFragment;

    public void setPagerFragment(PagerFragment pagerFragment) {
        this.pagerFragment = pagerFragment;
    }

    public void addPage(){
        pagerFragment.addPage();
    }
}
