package com.example.lbw.guaniu;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

/**
 * Created by lbw on 2017/8/12.
 */

public class DialogEditFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_dialog,container);
        Button commit = (Button)view.findViewById(R.id.commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),WriteNews.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
