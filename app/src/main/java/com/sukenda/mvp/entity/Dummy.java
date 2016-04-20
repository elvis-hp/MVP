package com.sukenda.mvp.entity;

import java.io.Serializable;

/**
 * Created by sukenda on 20/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class Dummy implements Serializable {

    private String nama;
    private String alamat;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }
}
