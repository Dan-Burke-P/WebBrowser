package edu.temple.webbrowser.ActivityFragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

import edu.temple.webbrowser.BrowserActivity;
import edu.temple.webbrowser.BrowserViewListAdapter;
import edu.temple.webbrowser.BrowserViewPagerAdapter;
import edu.temple.webbrowser.FragmentInterfaces.PageControlFragmentInterface;
import edu.temple.webbrowser.FragmentInterfaces.PagerFragmentInterface;
import edu.temple.webbrowser.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrowserControlFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowserControlFragment extends Fragment {

    PagerFragmentInterface pagerFragmentInterface;
    PageControlFragmentInterface pageControlFragmentInterface;

    BrowserViewPagerAdapter browserViewPagerAdapter;
    BrowserViewListAdapter browserViewListAdapter;

    public PagerFragment pagerFragment;

    FragmentManager fragmentManager;

    View view;
    BrowserActivity parent;
    ImageButton newPageButton;
    ImageButton showBookmarks;
    ImageButton addBookmark;

    ArrayList<PageViewerFragment> openPages = new ArrayList<PageViewerFragment>();

    ArrayList<String> bookmarks = new ArrayList<>();

    public BrowserControlFragment() {
        // Required empty public constructor
    }

    public static BrowserControlFragment newInstance(PagerFragmentInterface pagerFragmentInterface,
                                                     PageControlFragmentInterface pageControlFragmentInterface,
                                                     BrowserViewPagerAdapter browserViewPagerAdapter,
                                                     BrowserViewListAdapter browserViewListAdapter,
                                                     FragmentManager fragmentManager,
                                                     BrowserActivity parent) {
        BrowserControlFragment fragment = new BrowserControlFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        fragment.setBrowserViewPagerAdapter(browserViewPagerAdapter);
        fragment.setPagerFragmentInterface(pagerFragmentInterface);
        fragment.setPageControlFragmentInterface(pageControlFragmentInterface);
        fragment.setBrowserViewListAdapter(browserViewListAdapter);
        fragment.setFragmentManager(fragmentManager);
        fragment.parent = parent;

        return fragment;
    }

    public void setFragmentManager(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
    }

    public void setBrowserViewListAdapter(BrowserViewListAdapter browserViewListAdapter){
        this.browserViewListAdapter = browserViewListAdapter;
        this.browserViewListAdapter.setData(openPages);
    }

    public void setBrowserViewPagerAdapter(BrowserViewPagerAdapter browserViewPagerAdapter){
        this.browserViewPagerAdapter = browserViewPagerAdapter;
        this.browserViewPagerAdapter.setData(openPages);
    }

    public void setPagerFragmentInterface(PagerFragmentInterface pagerFragmentInterface){
        this.pagerFragmentInterface = pagerFragmentInterface;
    }

    public void setPageControlFragmentInterface(PageControlFragmentInterface pageControlFragmentInterface){
        this.pageControlFragmentInterface = pageControlFragmentInterface;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.println(Log.ASSERT, this.toString(), "Creating browser control fragment");

        view =  inflater.inflate(R.layout.fragment_browser_control, container, false);
        newPageButton = view.findViewById(R.id.new_page_button);
        final BrowserControlFragment bcf = this;
        newPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add a new page
                PageViewerFragment pvf = PageViewerFragment.newInstance(bcf);
                pvf.setRetainInstance(true);
                openPages.add(pvf);
                browserViewPagerAdapter.notifyDataSetChanged();
                browserViewListAdapter.notifyDataSetChanged();

                pagerFragmentInterface.setActivePage(openPages.size()-1);


                pageControlFragmentInterface.setActivePage(pvf);

            }
        });

        showBookmarks = view.findViewById(R.id.show_bookmark_button);
        showBookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookMarkDisplayFragment bmdf = bookMarkDisplayFragment.newInstance(
                        fragmentManager, parent, bookmarks
                );
                bmdf.pagerFragment = pagerFragment;
                fragmentManager.beginTransaction().replace(R.id.bookmark_view, bmdf).commit();
                parent.hideAll();
                Log.println(Log.ASSERT, "open bookmarks", "Opening bookmarks");
            }
        });

        addBookmark = view.findViewById(R.id.save_page_button);
        addBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = pagerFragmentInterface.getCurrentURL();
                Log.println(Log.ASSERT, "--", url);
                bookmarks.add(url);
            }
        });

        return view;
    }

    public void notifyDataSetUpdate(){
        browserViewPagerAdapter.notifyDataSetChanged();
        browserViewListAdapter.notifyDataSetChanged();
    }

    public void updateLink(String s){
        notifyDataSetUpdate();
        pageControlFragmentInterface.updateLink();
    }

}