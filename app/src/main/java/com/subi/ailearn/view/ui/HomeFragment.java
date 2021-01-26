package com.subi.ailearn.view.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.subi.ailearn.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat thu = new SimpleDateFormat("E", Locale.getDefault());
        String thuFull = thu.format(c);
        switch (thuFull) {
            case "T.2": thuFull = "Thứ Hai";
                break;
            case "T.3":thuFull = "Thứ Ba";
                break;
            case "T.4":thuFull = "Thứ Tư";
                break;
            case "T.5":thuFull = "Thứ Năm";
                break;
            case "T.6":thuFull = "Thứ Sáu";
                break;
            case "T.7":thuFull = "Thứ Bảy";
                break;
            case "C.N":thuFull = "Chủ Nhật";
                break;
        }
        String title =thuFull+", ngày ";
        title += df.format(c);
        getActivity().setTitle(title);
        return view;
    }
}