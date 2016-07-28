package com.example.exceed.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by exceed on 7/28/16 AD.
 */
public class ItemArrayAdapter extends ArrayAdapter<String[]>{

    private List<String[]> scoreList = new ArrayList<>();

    static class ItemViewolder{
        TextView name;
        TextView score;
    }

    public ItemArrayAdapter(Context context, int resource){
        super(context, resource);


    }

    public void add(String[] object){
        scoreList.add(object);
        super.add(object);
    }

    public int getCount(){
        return this.scoreList.size();
    }

    public String[] getItem(int position){
        return this.scoreList.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ItemViewolder viewHolder;
        if(row==null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_list_item,parent,false);
            viewHolder = new ItemViewolder();
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.score = (TextView) row.findViewById(R.id.score);
            row.setTag(viewHolder);
        }
        else{
            viewHolder = (ItemViewolder) row.getTag();
        }
        String[] stat = getItem(position);
        viewHolder.name.setText(stat[0]);
        viewHolder.score.setText(stat[1]);
        return row;
    }

}
