package edu.temple.webbrowser.ActivityFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.MalformedURLException;

import edu.temple.webbrowser.BrowserActivity;
import edu.temple.webbrowser.FragmentInterfaces.BrowserControlFragmentInterface;
import edu.temple.webbrowser.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageViewerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageViewerFragment extends Fragment {


    private View view;
    private WebView webView;
    private String url = "New Page";
    public boolean isActive = false;
    BrowserControlFragment browserControlFragment;
    public PageViewerFragment() {
        // Required empty public constructor
    }

    public static PageViewerFragment newInstance(BrowserControlFragment browserControlFragment)
    {
        PageViewerFragment fragment = new PageViewerFragment();
        fragment.setBrowserControlFragment(browserControlFragment);
        return fragment;
    }

    public void setBrowserControlFragment(BrowserControlFragment browserControlFragment){
        this.browserControlFragment = browserControlFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_page_viewer, container, false);
        webView = view.findViewById(R.id.WebView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                Toast.makeText(getContext(),"Page Loading Finish." + webView.getUrl(),Toast.LENGTH_SHORT).show();
                browserControlFragment.updateLink(webView.getUrl());
                setUrl(webView.getUrl());
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        return view;
    }

    public void loadPage(String s) throws MalformedURLException {

        if(s.length() < 8){
            s = "https://" + s;
        }

        String t = s.substring(0, 8);
        if(!t.equals("https://")){
            s = "https://" + s;
        }

        Log.println(Log.ASSERT, "PageViewerFragment",t);
        webView.loadUrl(s);
        url = s;
    }
    public void goBack(){
        webView.goBack();
    }
    public void goForward(){
        webView.goForward();
    }

    public String getUrl(){
        return this.url;
    }

    private void setUrl(String s){
        url = s;
    }
}