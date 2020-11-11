package edu.temple.webbrowser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagerFragment extends Fragment {

    FragmentManager fragmentManager;
    View view;
    ViewPager vp;
    BrowserViewPagerAdapter browserViewPagerAdapter;
    PageViewerFragment pageViewerFragment;
    public PagerFragment() {
        // Required empty public constructor
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    // TODO: Rename and change types and number of parameters
    public static PagerFragment newInstance(FragmentManager fm) {
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        fragment.setFragmentManager(fm);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pager, container, false);
        vp = view.findViewById(R.id.view_pager);
        browserViewPagerAdapter = new BrowserViewPagerAdapter(fragmentManager);

        vp.setAdapter(browserViewPagerAdapter);
        return view;
    }

    public void addPage(){
        Log.println(Log.ASSERT, "PagerFragment", "Adding page");
        PageViewerFragment pageViewerFragment = PageViewerFragment.newInstance();
        browserViewPagerAdapter.addPage(pageViewerFragment);
        browserViewPagerAdapter.notifyDataSetChanged();
    }

    public void navigate(String s){
        int item = vp.getCurrentItem();
        try {
            browserViewPagerAdapter.getItem(item).loadPage(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void goBack(){
        int item = vp.getCurrentItem();
        browserViewPagerAdapter.getItem(item).goBack();
    }

    public void goForward(){
        int item = vp.getCurrentItem();
        browserViewPagerAdapter.getItem(item).goForward();
    }
}