package edu.temple.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PageControlFrament pageControlFrament = PageControlFrament.newInstance();
        PageViewerFragment pageViewerFragment = PageViewerFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.Page_control_container, pageControlFrament)
                .replace(R.id.Page_render_container, pageViewerFragment)
                .commit();
    }
}