package com.example.volumecalcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Shape> {
    private ArrayList<Shape> shapeArrayList;
    Context context;

    public CustomAdapter(ArrayList<Shape> shapesArrayList, Context context) {
        super(context, R.layout.grid_item_layout, shapesArrayList);
        this.shapeArrayList = shapesArrayList;
        this.context = context;
    }
    private static class ViewHolder {
        TextView textView;
        ImageView shapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shapes = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.grid_item_layout, parent, false);
            viewHolder.textView = convertView.findViewById(R.id.textView);
            viewHolder.shapeImage = convertView.findViewById(R.id.imageItem);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(shapes != null){
            viewHolder.textView.setText(shapes.getShapeName());
            viewHolder.shapeImage.setImageResource(shapes.getShapeImage());

        }else {

        }
        return super.getView(position, convertView, parent);
    }
}

