package edu.temple.webbrowser;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import edu.temple.webbrowser.ActivityFragments.BrowserControlFragment;
import edu.temple.webbrowser.ActivityFragments.PageViewerFragment;
import edu.temple.webbrowser.FragmentInterfaces.BrowserControlFragmentInterface;
import edu.temple.webbrowser.FragmentInterfaces.PagerFragmentInterface;

public class BookmarkViewAdapter extends BaseAdapter {

    ArrayList<String> contents;
    LayoutInflater layoutInflater;
    BrowserControlFragment browserControlFragment;
    Context context;

    public BookmarkViewAdapter(Context context,
                               ArrayList<String> contents,
                               BrowserControlFragment browserControlFragment){
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.contents = contents;
        this.browserControlFragment = browserControlFragment;
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
                browserControlFragment.openBookmark(urlStr);
                browserControlFragment.showRender();
            }
        });

        Button deleteButton = convertView.findViewById(R.id.delete_bookmark);

        final BookmarkViewAdapter bookmarkViewAdapter = this;
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Title")
                        .setMessage("Do you really want to whatever?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                contents.remove(position);
                                bookmarkViewAdapter.notifyDataSetChanged();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });

        label.setText(urlStr);
        return convertView;
    }

}
