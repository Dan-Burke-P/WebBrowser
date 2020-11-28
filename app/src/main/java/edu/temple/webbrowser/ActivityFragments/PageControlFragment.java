package edu.temple.webbrowser.ActivityFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.net.MalformedURLException;

import edu.temple.webbrowser.FragmentInterfaces.BrowserControlFragmentInterface;
import edu.temple.webbrowser.FragmentInterfaces.PagerFragmentInterface;
import edu.temple.webbrowser.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageControlFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageControlFragment extends Fragment {

    PagerFragmentInterface pagerFragmentInterface;
    private PageViewerFragment pageViewerFragment;
    private View view;
    private ImageButton goButton, backButton, forwardButton;
    private EditText url_bar;
    BrowserControlFragmentInterface browserControlFragmentInterface;
    public PageControlFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PageControlFragment newInstance(PagerFragmentInterface pagerFragmentInterface,
                                                  BrowserControlFragmentInterface browserControlFragmentInterface) {
        PageControlFragment fragment = new PageControlFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        fragment.setPagerFragmentInterface(pagerFragmentInterface);
        fragment.setBrowserControlFragmentInterface(browserControlFragmentInterface);

        return fragment;
    }

    public void setBrowserControlFragmentInterface(BrowserControlFragmentInterface browserControlFragmentInterface){
        this.browserControlFragmentInterface = browserControlFragmentInterface;
    }

    public void setPagerFragmentInterface(PagerFragmentInterface pagerFragmentInterface){
        this.pagerFragmentInterface = pagerFragmentInterface;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_page_control_frament, container, false);
        goButton = view.findViewById(R.id.Go_Button);
        backButton = view.findViewById(R.id.Back_Button);
        forwardButton = view.findViewById(R.id.Forward_Button);
        url_bar = view.findViewById(R.id.URL_BAR);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    pageViewerFragment.loadPage(url_bar.getText().toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                url_bar.setText(pageViewerFragment.getUrl());
                browserControlFragmentInterface.notifyDataSetUpdate();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageViewerFragment.goBack();
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageViewerFragment.goForward();
            }
        });

        return view;
    }

    public void setActivePage(PageViewerFragment pageViewerFragment){
        if(this.pageViewerFragment != null){
            this.pageViewerFragment.isActive = false;
        }
        this.pageViewerFragment = pageViewerFragment;
        url_bar.setText(pageViewerFragment.getUrl());
        pageViewerFragment.isActive = true;
    }

    public void openPage(String s){
        try {
            pageViewerFragment.loadPage(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        url_bar.setText(s);
        browserControlFragmentInterface.notifyDataSetUpdate();
    }

    public void updateLink(){
        url_bar.setText(pageViewerFragment.getUrl());
    }
}