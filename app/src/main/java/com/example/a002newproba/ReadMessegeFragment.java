package com.example.a002newproba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadMessegeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadMessegeFragment extends Fragment {
    public static String ARG_CITY = "messege";
    private Messege messege;


    public static ReadMessegeFragment newInstance(Messege messege) {
        ReadMessegeFragment fragment = new ReadMessegeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_CITY, messege);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.messege = getArguments().getParcelable(ARG_CITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_read_messege, container, false);
        TextView textView = rootView.findViewById(R.id.read_messege_textview);
        textView.setText(this.messege.getText());
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initList(view);
    }


}