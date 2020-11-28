package edu.temple.webbrowser.ActivityFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;

import edu.temple.webbrowser.BrowserViewPagerAdapter;
import edu.temple.webbrowser.FragmentInterfaces.PageControlFragmentInterface;
import edu.temple.webbrowser.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagerFragment extends Fragment {

    FragmentManager fragmentManager;
    public View view;
    ViewPager vp;
    BrowserViewPagerAdapter browserViewPagerAdapter;
    PageControlFragmentInterface pageControlFragmentInterface;

    public PagerFragment() {
        // Required empty public constructor
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public static PagerFragment newInstance(FragmentManager fm,
                                            BrowserViewPagerAdapter browserViewPagerAdapter,
                                            PageControlFragmentInterface pageControlFragmentInterface) {
        PagerFragment fragment = new PagerFragment();
        fragment.setFragmentManager(fm);
        fragment.setBrowserViewPagerAdapter(browserViewPagerAdapter);
        fragment.setPageControlFragmentInterface(pageControlFragmentInterface);
        return fragment;
    }

    public void setPageControlFragmentInterface(PageControlFragmentInterface pageControlFragmentInterface){
        this.pageControlFragmentInterface = pageControlFragmentInterface;
    }
    public void setBrowserViewPagerAdapter(BrowserViewPagerAdapter browserViewPagerAdapter){
        this.browserViewPagerAdapter = browserViewPagerAdapter;
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
        vp.setAdapter(browserViewPagerAdapter);
        vp.setOffscreenPageLimit(25);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageControlFragmentInterface.setActivePage(
                        browserViewPagerAdapter.getItem(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

    public void show_bookmark(){
        view.findViewById(R.id.view_pager).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.bookmark_display).setVisibility(View.VISIBLE);
    }

    public void setActivePage(int i){
        vp.setCurrentItem(i);
    }
}