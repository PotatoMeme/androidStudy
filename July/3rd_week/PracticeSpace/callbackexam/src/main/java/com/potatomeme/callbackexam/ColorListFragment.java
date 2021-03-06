package com.potatomeme.callbackexam;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {

    private OnColorSelectedListener mListener;

    interface OnColorSelectedListener {
        void onColorSelected(int color);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (OnColorSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName() + "OnColorSelectedListener 를 구현해야합니다.");
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("Red", "Green", "Blue");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);// ListFragment에는 ListView가 내장되 있음
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;
        switch (colorString) {
            case "Red":
                color = Color.RED;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
        }
        if (mListener != null){
            mListener.onColorSelected(color);
        }

    }
}
