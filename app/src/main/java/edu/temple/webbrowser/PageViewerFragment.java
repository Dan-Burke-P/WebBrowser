package edu.temple.webbrowser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageViewerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageViewerFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_page_viewer, container, false);
    }
}