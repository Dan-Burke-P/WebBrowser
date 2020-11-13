package edu.temple.webbrowser.FragmentInterfaces;

import edu.temple.webbrowser.ActivityFragments.PageControlFragment;
import edu.temple.webbrowser.ActivityFragments.PageViewerFragment;
import edu.temple.webbrowser.ActivityFragments.PagerFragment;

public class PageControlFragmentInterface {
    PageControlFragment pageControlFragment;

    public void setPageControlFragment(PageControlFragment pageControlFragment) {
        this.pageControlFragment = pageControlFragment;
    }

    public void setActivePage(PageViewerFragment pageViewerFragment){
        pageControlFragment.setActivePage(pageViewerFragment);
    }

    public void updateLink(){
        pageControlFragment.updateLink();
    }

}
