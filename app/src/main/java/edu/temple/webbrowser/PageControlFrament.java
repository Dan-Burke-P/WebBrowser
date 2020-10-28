package edu.temple.webbrowser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageControlFrament#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageControlFrament extends Fragment {


    public PageControlFrament() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PageControlFrament newInstance() {
        PageControlFrament fragment = new PageControlFrament();
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
        return inflater.inflate(R.layout.fragment_page_control_frament, container, false);
    }
}