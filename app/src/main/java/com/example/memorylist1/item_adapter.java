package com.example.memorylist1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class item_adapter<ItemAdapter> extends BaseAdapter {

    LayoutInflater mInflater;
    String[] Title;
    String[] Date;
    String[] Text;

    public item_adapter(Context c, String[]title,String[]date,String[]text){
        Title = title;
        Date = date;
        Text = text;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return Title.length;
    }

    @Override
    public Object getItem(int position) {
        return Title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.memorylist_details, null);
        TextView Titletextview = (TextView) v.findViewById(R.id.Titletextview);
        TextView Datetextview = (TextView) v.findViewById(R.id.Datetextview);
        TextView Texttextview = (TextView) v.findViewById(R.id.Texttextview);

        String name = Title[position];
        String date = Date[position];
        String text = Text[position];

        Titletextview.setText(name);
        Datetextview.setText(date);
        Texttextview.setText(text);

        return v ;
    }
}
