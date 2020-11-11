package edu.temple.webbrowser;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import edu.temple.webbrowser.ActivityFragments.PageViewerFragment;

public class BrowserViewPagerAdapter  extends FragmentStatePagerAdapter {
    public BrowserViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    ArrayList<PageViewerFragment> contents = new ArrayList<PageViewerFragment>();

    @NonNull
    @Override
    public PageViewerFragment getItem(int position) {
        return contents.get(position);
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    public void addPage(PageViewerFragment pageViewerFragment){
        contents.add(pageViewerFragment);

    }
}
