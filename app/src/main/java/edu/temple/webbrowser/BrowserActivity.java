package edu.temple.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import edu.temple.webbrowser.ActivityFragments.BrowserControlFragment;
import edu.temple.webbrowser.ActivityFragments.PageControlFragment;
import edu.temple.webbrowser.ActivityFragments.PageListFragment;
import edu.temple.webbrowser.ActivityFragments.PageViewerFragment;
import edu.temple.webbrowser.ActivityFragments.PagerFragment;
import edu.temple.webbrowser.FragmentInterfaces.BrowserControlFragmentInterface;
import edu.temple.webbrowser.FragmentInterfaces.PageControlFragmentInterface;
import edu.temple.webbrowser.FragmentInterfaces.PagerFragmentInterface;

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

        PagerFragmentInterface pagerFragmentInterface = new PagerFragmentInterface();
        PageControlFragmentInterface pageControlFragmentInterface = new PageControlFragmentInterface();
        BrowserControlFragmentInterface browserControlFragmentInterface = new BrowserControlFragmentInterface();

        BrowserViewPagerAdapter browserViewPagerAdapter = new BrowserViewPagerAdapter(
                getSupportFragmentManager());
        BrowserViewListAdapter browserViewListAdapter = new BrowserViewListAdapter(this,
                pagerFragmentInterface,
                browserControlFragmentInterface);

        if(savedInstanceState == null){

            pagerFragment = PagerFragment.newInstance(getSupportFragmentManager(),
                    browserViewPagerAdapter,
                    pageControlFragmentInterface);

            // If we have no saved instance Create new instances of all the fragments
            browserControlFragment = BrowserControlFragment.newInstance(
                    pagerFragmentInterface,
                    pageControlFragmentInterface,
                    browserViewPagerAdapter,
                    browserViewListAdapter,
                    getSupportFragmentManager());

            browserControlFragment.pagerFragment = pagerFragment;

            pageControlFragment = PageControlFragment.newInstance(pagerFragmentInterface,
                    browserControlFragmentInterface);



            pageListFragment = PageListFragment.newInstance(browserViewListAdapter);

            // Set interface references
            pagerFragmentInterface.setPagerFragment(pagerFragment);
            pageControlFragmentInterface.setPageControlFragment(pageControlFragment);
            browserControlFragmentInterface.setBrowserControlFragment(browserControlFragment);

            // Retain all the instances
            pageControlFragment.setRetainInstance(true);
            pagerFragment.setRetainInstance(true);
            pageListFragment.setRetainInstance(true);
            browserControlFragment.setRetainInstance(true);

            // Add all the fragments to the fragment manager
            getSupportFragmentManager().beginTransaction()
                    .add(pageControlFragment, "page_control_fragment")
                    .add(pagerFragment, "pager_fragment")
                    .add(pageListFragment, "page_list_fragment")
                    .add(browserControlFragment, "browser_control_fragment")
                    .commit();


        }else{
            // We are loading a saved state

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
            assert pagerFragment != null;
            assert browserControlFragment != null;
            assert pageListFragment != null;

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Page_control_container, pageControlFragment)
                    .replace(R.id.page_list_container, pageListFragment)
                    .replace(R.id.Browser_control_container, browserControlFragment)
                    .replace(R.id.Page_render_container, pagerFragment)
                    .commit();
        }


    }
}