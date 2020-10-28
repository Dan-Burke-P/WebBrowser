package edu.temple.webbrowser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageControlFrament#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageControlFrament extends Fragment {

    private PageViewerFragment pageViewerFragment;
    private View view;
    private ImageButton goButton, backButton, forwardButton;
    private EditText url_bar;

    public PageControlFrament(PageViewerFragment _pageViewerFragment) {
        // Required empty public constructor
        this.pageViewerFragment = _pageViewerFragment;
    }


    // TODO: Rename and change types and number of parameters
    public static PageControlFrament newInstance(PageViewerFragment _pageViewerFragment) {
        PageControlFrament fragment = new PageControlFrament(_pageViewerFragment);

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
        view =inflater.inflate(R.layout.fragment_page_control_frament, container, false);
        goButton = view.findViewById(R.id.Go_Button);
        backButton = view.findViewById(R.id.Back_Button);
        forwardButton = view.findViewById(R.id.Forward_Button);
        url_bar = view.findViewById(R.id.URL_BAR);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageViewerFragment.loadPage(url_bar.getText().toString());
            }
        });

        return view;
    }
}