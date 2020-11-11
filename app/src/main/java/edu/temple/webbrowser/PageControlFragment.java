package edu.temple.webbrowser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.net.MalformedURLException;

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

    public PageControlFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PageControlFragment newInstance(PagerFragmentInterface pagerFragmentInterface) {
        PageControlFragment fragment = new PageControlFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        fragment.setPagerFragmentInterface(pagerFragmentInterface);

        return fragment;
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
                pagerFragmentInterface.navigate(url_bar.getText().toString());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagerFragmentInterface.goBack();
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagerFragmentInterface.goForward();
            }
        });

        return view;
    }
}