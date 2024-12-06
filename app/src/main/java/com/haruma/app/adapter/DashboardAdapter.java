package com.haruma.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.haruma.app.R;
import com.haruma.app.model.Diary;

import java.util.List;

public class DashboardAdapter extends ArrayAdapter<Diary> {
    private final Context context;
    private final int mResource;

    public DashboardAdapter(@NonNull Context context, int resource, @NonNull List<Diary> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mResource = resource;
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(mResource, parent, false);
        }
        Diary diary = getItem(position);
        TextView tenhd = convertView.findViewById(R.id.tvTenhd);
        TextView ngay = convertView.findViewById(R.id.tvNgay);
        TextView ngaybd = convertView.findViewById(R.id.tvNgaybd);
        TextView ngaykt = convertView.findViewById(R.id.tvNgaykt);
        if (diary != null) {
            tenhd.setText(diary.getName());
            ngay.setText(diary.getDay());
            ngaybd.setText(String.format("%sh", diary.getStartTime()));
            ngaykt.setText(String.format("%sh", diary.getEndTime()));
        }
        return convertView;
    }
}

