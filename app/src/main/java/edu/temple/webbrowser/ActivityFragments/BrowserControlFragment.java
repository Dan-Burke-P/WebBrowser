package edu.temple.webbrowser.ActivityFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import edu.temple.webbrowser.FragmentInterfaces.PagerFragmentInterface;
import edu.temple.webbrowser.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrowserControlFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowserControlFragment extends Fragment {

    PagerFragmentInterface pagerFragmentInterface;
    View view;
    ImageButton newPageButton;

    public BrowserControlFragment() {
        // Required empty public constructor
    }

    public static BrowserControlFragment newInstance(PagerFragmentInterface pagerFragmentInterface) {
        BrowserControlFragment fragment = new BrowserControlFragment();
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
        view =  inflater.inflate(R.layout.fragment_browser_control, container, false);
        newPageButton = view.findViewById(R.id.new_page_button);
        newPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagerFragmentInterface.addPage();
            }
        });
        return view;
    }

}