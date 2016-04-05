package com.hattrick.nrapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hattrick.nrapp.R;
import com.hattrick.nrapp.activities.DetailActivity;
import com.hattrick.nrapp.model.People;

import java.util.List;

/**
 * Created by gastonkosut on 4/5/16.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    // Store a member variable for the contacts
    public List<People> mPeople;

    // Pass in the contact array into the constructor
    public ItemsAdapter(List<People> people) {
        mPeople = people;
    }

    private Context mContext;

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        mContext = parent.getContext();

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        People person = mPeople.get(position);

        // Set item views based on the data model
        TextView textViewName = viewHolder.textViewName;

        textViewName.setText(person.getName());


    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView textViewName;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textview_name);

            itemView.setOnClickListener(this);

        }

        // Handles the row being being clicked
        @Override
        public void onClick(View view) {
            int position = getLayoutPosition(); // gets item position
            People person = mPeople.get(position);
            // We can access the data within the views
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("name", person.getName());
            detailIntent.putExtra("mass", person.getMass());
            detailIntent.putExtra("height", person.getHeight());
            mContext.startActivity(detailIntent);
        }

    }





    // Return the total count of items
    @Override
    public int getItemCount() {
        return mPeople.size();
    }
}