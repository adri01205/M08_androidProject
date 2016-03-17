package com.example.adri.m08_androidproject.model.business;

/**
 * Created by adri on 15/03/2016.
 */
public class Run {
    private int id;
    private String run_time;
    private String run_date;

    private int id_user;

    public Run() {
    }

    public Run(int id, String run_time, String run_date, int id_user) {
        this.id = id;
        this.run_time = run_time;
        this.run_date = run_date;
        this.id_user = id_user;
    }

    public Run(String run_time, String run_date, int id_user) {
        this.run_time = run_time;
        this.run_date = run_date;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRun_time() {
        return run_time;
    }

    public void setRun_time(String run_time) {
        this.run_time = run_time;
    }

    public String getRun_date() {
        return run_date;
    }

    public void setRun_date(String run_date) {
        this.run_date = run_date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
