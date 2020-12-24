package com.example.myfundamentalsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Activity activity = getActivity();
        Button button_send = null;
        Button button_check = null;
        final TextView textView = view.findViewById(R.id.text_view_fragment);

        if (activity != null) {
            button_check = activity.findViewById(R.id.button_check_fragment);
            button_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = getArguments();
                    if(bundle != null) {
                        String val = bundle.getString("cheie");
                        textView.setText(val);
                    } else {
                        Toast.makeText(getActivity(),"Fragmentul nu a primit nici un bundle"
                                ,Toast.LENGTH_LONG).show();
                    }
                }
            });

            button_send = activity.findViewById(R.id.button_send_to_activity);

        }



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
