package com.example.asus.baithiandroidnangcao;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private EditText edLongtitude;
    private EditText edLatitude;
    private EditText TieuDe;

    private Adapter_List_Map adapterListMap;
    public static List<Map> mapList = new ArrayList<>();
    private Map_DAO mapDao;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        edLongtitude = (EditText) findViewById(R.id.ed_longtitude);
        edLatitude = (EditText) findViewById(R.id.ed_latitude);
        TieuDe=findViewById(R.id.TieuDe);
        mapDao = new Map_DAO(new SqliteHelper(getApplicationContext()));
        mapList = mapDao.getAllMap();
        adapterListMap = new Adapter_List_Map(this, mapList);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void sua(View view) {

    }
    public int validateForm(){

        int check = 1;
        if (edLongtitude.getText().length()  <=7 || edLatitude.getText().length()<=7 ) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập số dưới 7 kí tự ", Toast.LENGTH_SHORT).show();
            check = -1;

        }
        return check;
    }

    public void them(View view) {
        String longtitude = edLongtitude.getText().toString();
        String latitude = edLatitude.getText().toString();
        String tieude=TieuDe.getText().toString();
        if (longtitude.isEmpty() || latitude.isEmpty()) {
            Toast.makeText(this, "Mời bạn nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
        }
        else {
            mapDao = new Map_DAO(new SqliteHelper(getApplicationContext()));
            Map map = new Map(1, Double.parseDouble(longtitude), Double.parseDouble(latitude), tieude);
            mapDao.insertMap(map);
            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            onResume();
        }
    }

    public void xoa(View view) {
       edLatitude.setText("");
       edLongtitude.setText("");
       TieuDe.setText("");
    }
}
