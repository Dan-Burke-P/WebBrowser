package edu.temple.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BrowserActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView lsm = findViewById(R.id.landscape_mode);


        BrowserControlFragment browserControlFragment;
        PageControlFragment pageControlFragment;
        PageListFragment pageListFragment;
        PagerFragment pagerFragment;
        PageViewerFragment pageViewerFragment;

        PagerFragmentInterface pagerFragmentInterface = new PagerFragmentInterface();

        if(savedInstanceState == null){
            // If we have no saved instance Create new instances of all the fragments
            browserControlFragment = BrowserControlFragment.newInstance(pagerFragmentInterface);

            pageViewerFragment = PageViewerFragment.newInstance();
            pageControlFragment = PageControlFragment.newInstance(pageViewerFragment);

            pagerFragment = PagerFragment.newInstance(getSupportFragmentManager());
            pageListFragment = PageListFragment.newInstance();

            pagerFragmentInterface.setPagerFragment(pagerFragment);

            // Retain all the instances
            pageViewerFragment.setRetainInstance(true);
            pageControlFragment.setRetainInstance(true);
            pagerFragment.setRetainInstance(true);
            pageListFragment.setRetainInstance(true);
            browserControlFragment.setRetainInstance(true);

            // Add all the fragments to the fragment manager
            getSupportFragmentManager().beginTransaction().add(pageViewerFragment, "page_viewer_fragment")
                    .add(pageControlFragment, "page_control_fragment")
                    .add(pagerFragment, "pager_fragment")
                    .add(pageListFragment, "page_list_fragment")
                    .add(browserControlFragment, "browser_control_fragment")
                    .commit();


        }else{
            // We are loading a saved state
            pageViewerFragment = (PageViewerFragment) getSupportFragmentManager().
                    findFragmentByTag("page_viewer_fragment");

            pageControlFragment = (PageControlFragment) getSupportFragmentManager().
                    findFragmentByTag("page_control_fragment");

            pagerFragment = (PagerFragment) getSupportFragmentManager().
                    findFragmentByTag("pager_fragment");

            pageListFragment = (PageListFragment) getSupportFragmentManager().
                    findFragmentByTag("page_list_fragment");

            browserControlFragment = (BrowserControlFragment) getSupportFragmentManager().
                    findFragmentByTag("browser_control_fragment");

        }

        if (lsm == null){
            // If we don't find the lsm text view we are in portrait
            Log.println(Log.ASSERT, "PORT TEST", "Portrait Mode");

            // Null check
            assert pageControlFragment != null;
            assert pageViewerFragment != null;
            assert pagerFragment != null;
            assert browserControlFragment != null;

            // portrait load
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Page_control_container, pageControlFragment)
                    .replace(R.id.Page_render_container, pagerFragment)
                    .replace(R.id.Browser_control_container, browserControlFragment)
                    .commit();
        }else{
            // If we find the lsm we are in landscape
            Log.println(Log.ASSERT, "PORT TEST", "Landscape Mode");
            // Null check
            assert pageControlFragment != null;
            assert pageViewerFragment != null;
            assert pagerFragment != null;
            assert browserControlFragment != null;
            assert pageListFragment != null;

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Page_control_container, pageControlFragment)
                    .replace(R.id.Page_render_container, pageViewerFragment)
                    .replace(R.id.Browser_control_container, browserControlFragment)
                    .replace(R.id.page_list_container, pageListFragment)
                    .commit();
        }


    }
}