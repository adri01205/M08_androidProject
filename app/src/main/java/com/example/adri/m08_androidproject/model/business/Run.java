package com.example.adri.m08_androidproject.model.business;

/**
 * Created by adri on 15/03/2016.
 */
public class Run {
    private int id;
    private String time;
    private int id_user;

    public Run(int id, String temps, int id_user) {
        this.id = id;
        this.time = temps;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemps() {
        return time;
    }

    public void setTemps(String temps) {
        this.time = temps;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
