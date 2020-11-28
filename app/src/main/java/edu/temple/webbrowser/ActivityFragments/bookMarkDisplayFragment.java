package edu.temple.webbrowser.ActivityFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import edu.temple.webbrowser.BookmarkViewAdapter;
import edu.temple.webbrowser.BrowserActivity;
import edu.temple.webbrowser.BrowserViewListAdapter;
import edu.temple.webbrowser.R;


public class bookMarkDisplayFragment extends Fragment {

    View view;
    Button closeButton;
    public FragmentManager fragmentManager;
    public PagerFragment pagerFragment;
    public BrowserActivity browserActivity;
    public ArrayList<String> bookmarks;

    ListView listView;
    BookmarkViewAdapter bookmarkViewAdapter;

    public View pagerView;

    public bookMarkDisplayFragment() {
        // Required empty public constructor
    }

    public static bookMarkDisplayFragment newInstance(FragmentManager fragmentManager,
                                                      BrowserActivity browserActivity,
                                                      ArrayList<String> bookmarks) {
        bookMarkDisplayFragment fragment = new bookMarkDisplayFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.fragmentManager = fragmentManager;
        fragment.browserActivity = browserActivity;
        fragment.bookmarks = bookmarks;
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
        view = inflater.inflate(R.layout.fragment_book_mark_display, container, false);
        closeButton = view.findViewById(R.id.close_bookmarks_button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browserActivity.showAll();
            }
        });
        bookmarkViewAdapter = new BookmarkViewAdapter(getContext(), bookmarks);
        listView = view.findViewById(R.id.bookmark_list);
        listView.setAdapter(bookmarkViewAdapter);

        return view;
    }
}