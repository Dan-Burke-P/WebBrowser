package edu.temple.webbrowser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageViewerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageViewerFragment extends Fragment {


    private View view;
    private WebView webView;

    public PageViewerFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PageViewerFragment newInstance() {
        PageViewerFragment fragment = new PageViewerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        view = inflater.inflate(R.layout.fragment_page_viewer, container, false);
        webView = view.findViewById(R.id.WebView);
        return view;
    }

    public void loadPage(String s){
        webView.loadUrl(s);
        Log.println(Log.ASSERT, "PageViewerFragment",s);
    }
    public void goBack(){
        webView.goBack();
    }
    public void goForward(){
        webView.goForward();
    }
}