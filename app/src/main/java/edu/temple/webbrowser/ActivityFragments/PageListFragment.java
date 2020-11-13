package edu.temple.webbrowser.ActivityFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.temple.webbrowser.BrowserViewListAdapter;
import edu.temple.webbrowser.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageListFragment extends Fragment {
    View view;
    ListView listView;
    BrowserViewListAdapter browserViewListAdapter;

    public PageListFragment() {
        // Required empty public constructor
    }

    public static PageListFragment newInstance(BrowserViewListAdapter browserViewListAdapter) {
        PageListFragment fragment = new PageListFragment();
        fragment.setBrowserViewListAdapter(browserViewListAdapter);
        return fragment;
    }

    public void setBrowserViewListAdapter(BrowserViewListAdapter browserViewListAdapter){
        this.browserViewListAdapter = browserViewListAdapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_page_list, container, false);
        listView = view.findViewById(R.id.ListView);
        listView.setAdapter(browserViewListAdapter);
        return view;
    }
}