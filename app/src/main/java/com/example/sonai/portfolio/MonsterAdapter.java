package com.example.sonai.portfolio;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import com.example.sonai.portfolio.models.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sonai on 8/4/17.
 * This class is useful for getting a custom view for each cell in the list view.
 */

public class MonsterAdapter extends ArrayAdapter {
    private Context m_cCurrentContext;
    private List<Monster> m_cMonsterList;

    public MonsterAdapter(@NonNull Context context, @LayoutRes int resource,
                          @IdRes int textViewResourceId, @NonNull List<Monster> objects){
        super(context,resource,textViewResourceId,objects);
        m_cMonsterList=objects;
        m_cCurrentContext=context;
    }




    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Check if view already exists. If not inflate it
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) m_cCurrentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// Create a list item based off layout definition
            view = inflater.inflate(R.layout.list_item, null);
        }
// Assign values to the TextViews using Person Object
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView speciesView = (TextView) view.findViewById(R.id.species);
        nameView.setText(m_cMonsterList.get(i).getM_sName());
        speciesView.setText(m_cMonsterList.get(i).getM_sSpecies());
        return view;
    }


}