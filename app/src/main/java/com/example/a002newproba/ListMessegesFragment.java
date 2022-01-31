package com.example.a002newproba;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListMessegesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMessegesFragment extends Fragment {


    public static ListMessegesFragment newInstance() {
           return new ListMessegesFragment();
    }

    /** @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_messeges, container, false);
       // TextView textView = rootView.findViewById(R.id.fragment_container);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] messages = getResources().getStringArray(R.array.messages);
        for (String message : messages) {
            TextView tv = new TextView(getContext());
            tv.setText(message);
            tv.setTextSize(30);
            layoutView.addView(tv);
        }
    }

}