package com.c1ph3r.ui.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airbnb.lottie.L;
import com.c1ph3r.ui.R;
import com.c1ph3r.ui.model.ListOfActivityModel;

import java.util.ArrayList;
import java.util.List;

public class custom_list_adapter extends ArrayAdapter<ListOfActivityModel> {
    private ArrayList<ListOfActivityModel> ListOfActivities;
    private Activity context;
    public custom_list_adapter(@NonNull Activity context, @NonNull ArrayList<ListOfActivityModel> ListOfActivities) {
        super(context, R.layout.custom_list_item, ListOfActivities);
        this.ListOfActivities = ListOfActivities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    public static class ViewHolder{
        TextView Title;
        ImageView TitleImg;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ListOfActivityModel ActivityItem = ListOfActivities.get(position);

        custom_list_adapter.ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.custom_list_item,parent, false);
            viewHolder.Title = convertView.findViewById(R.id.TitleOfThePage);
            viewHolder.TitleImg = convertView.findViewById(R.id.TitleImg);
        }else{
            viewHolder = (custom_list_adapter.ViewHolder) convertView.getTag();
        }

        viewHolder.Title.setText(ActivityItem.getTitle());
        viewHolder.TitleImg.setImageDrawable(ActivityItem.getTitleImg());

        convertView.setOnClickListener(passIntent ->
                context.startActivity(ActivityItem.getIntent()));

        return convertView;
    }
}
