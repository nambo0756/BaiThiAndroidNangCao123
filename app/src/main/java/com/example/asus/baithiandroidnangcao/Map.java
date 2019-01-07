package com.example.asus.baithiandroidnangcao;

public class Map {
    int id;
    double longtitude, latitude;
    String tieuDe;

    public Map() {
    }

    public Map(int id, double longtitude, double latitude, String tieuDe) {
        this.id = id;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.tieuDe = tieuDe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

}
