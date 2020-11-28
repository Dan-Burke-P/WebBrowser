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

import edu.temple.webbrowser.ActivityFragments.PageViewerFragment;
import edu.temple.webbrowser.FragmentInterfaces.BrowserControlFragmentInterface;
import edu.temple.webbrowser.FragmentInterfaces.PagerFragmentInterface;

public class BookmarkViewAdapter extends BaseAdapter {

    ArrayList<String> contents;
    LayoutInflater layoutInflater;

    public BookmarkViewAdapter(Context context,
                               ArrayList<String> contents){
        layoutInflater = LayoutInflater.from(context);
        this.contents = contents;
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
        return contents.get(position).length();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.bookmark_view, null);
        TextView label = convertView.findViewById(R.id.bookmark_label);
        final String urlStr = contents.get(position);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.println(Log.ASSERT, "Display", "Displaying URL: " + urlStr);
            }
        });

        label.setText(urlStr);
        return convertView;
    }

}
