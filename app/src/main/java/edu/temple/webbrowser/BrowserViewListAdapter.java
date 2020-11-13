package edu.temple.webbrowser;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.temple.webbrowser.ActivityFragments.BrowserControlFragment;
import edu.temple.webbrowser.ActivityFragments.PageViewerFragment;
import edu.temple.webbrowser.FragmentInterfaces.BrowserControlFragmentInterface;
import edu.temple.webbrowser.FragmentInterfaces.PagerFragmentInterface;

public class BrowserViewListAdapter extends BaseAdapter {

    ArrayList<PageViewerFragment> contents;
    LayoutInflater layoutInflater;
    PagerFragmentInterface pagerFragmentInterface;
    BrowserControlFragmentInterface browserControlFragmentInterface;
    public BrowserViewListAdapter(Context context,
                                  PagerFragmentInterface pagerFragmentInterface,
                                  BrowserControlFragmentInterface browserControlFragmentInterface){
        layoutInflater = LayoutInflater.from(context);
        this.pagerFragmentInterface = pagerFragmentInterface;
        this.browserControlFragmentInterface = browserControlFragmentInterface;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contents.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_view_layout, null);
        TextView label = convertView.findViewById(R.id.ListViewURL);
        final PageViewerFragment pageViewerFragment = contents.get(position);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagerFragmentInterface.setActivePage(position);
                browserControlFragmentInterface.notifyDataSetUpdate();
            }
        });
        if(pageViewerFragment.isActive){
            convertView.setBackgroundColor(Color.LTGRAY);
        }
        label.setText(pageViewerFragment.getUrl());
        return convertView;
    }

    public void setData(ArrayList<PageViewerFragment> pageViewerFragments){
        Log.println(Log.ASSERT, "BrowserViewListAdapter", "Setting data in adapter");
        this.contents = pageViewerFragments;
    }
}
