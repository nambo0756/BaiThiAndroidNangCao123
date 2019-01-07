package com.example.asus.baithiandroidnangcao;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

public class Adapter_List_Map extends BaseAdapter {

    List<Map> mapList;
    public Activity context;
    public LayoutInflater inflater;
    public Map_DAO mapDao;

    public Adapter_List_Map(Activity context, List<Map> arrayMap) {
        super();
        this.context = context;
        this.mapList = arrayMap;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mapDao = new Map_DAO(new SqliteHelper(context));
    }

    @Override
    public int getCount() {
        return mapList.size();
    }

    @Override
    public Object getItem(int position) {
        return mapList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list, null);
            holder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            holder.tvLongtitude = (TextView) convertView.findViewById(R.id.tv_longtitude);
            holder.tvLatitude = (TextView) convertView.findViewById(R.id.tv_latitude);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.img_delete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mapDao.deleteMap(mapList.get(position).getId());
                    mapList.remove(position);
                    notifyDataSetChanged();
                }
            });

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        Map _entry = mapList.get(position);
        holder.tvId.setText(_entry.getId() + "");
        holder.tvLatitude.setText("Latitude: " + String.valueOf(_entry.getLatitude()));
        holder.tvLongtitude.setText("Longtitude: " + String.valueOf(_entry.getLongtitude()));
        return convertView;
    }

    public static class ViewHolder {
        private TextView tvId;
        private TextView tvLongtitude;
        private TextView tvLatitude;
        private ImageView imgDelete;



    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Map> items) {
        this.mapList = items;
        notifyDataSetChanged();
    }
}
