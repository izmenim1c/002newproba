package com.example.a002newproba;

import android.content.res.Configuration;
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
    Messege currentmassege;
    boolean isLandScape;

    public static ListMessegesFragment newInstance() {
        return new ListMessegesFragment();
    }

     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         isLandScape = getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_messeges, container, false);


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
        int i=0;
        for (String message : messages) {
            TextView tv = new TextView(getContext());
            tv.setText(message);
            tv.setTextSize(30);
            layoutView.addView(tv);
            int finalI = i++;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListOnClick(finalI);
                }
            });
        }
    }

    private void ListOnClick(int index) {
        currentmassege = new Messege(index,"заглушка "+index);
        if (isLandScape) {
            showReadMessegeLand();
        }else{ // port
            showReadMessegePort();
        }

    }

    private void showReadMessegePort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,ReadMessegeFragment.newInstance(currentmassege))
                .addToBackStack("")
                .commit();

    }

    private void showReadMessegeLand() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_right,ReadMessegeFragment.newInstance(currentmassege))
                .commit();

    }


}