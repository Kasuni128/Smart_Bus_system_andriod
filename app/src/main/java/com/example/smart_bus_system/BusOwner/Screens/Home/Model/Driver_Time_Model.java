package com.example.smart_bus_system.BusOwner.Screens.Home.Model;

public class Driver_Time_Model {


    public  Driver_Time_Model(){}


    private  String tb_id;
    private  String bus_name;
    private  String bus_no;
    private  String bus_condtions;
    private  String bus_contact_number;
    private  String bus_avb_seats;
    private  String bus_img_path;
    private  String isCompleteRoute;
    private  String start_time;
    private  String end_point;
    private  String end_time;

    public String getEnd_time() {
        return end_time;
    }

    public String getTb_id() {
        return tb_id;
    }

    public String getBus_name() {
        return bus_name;
    }

    public String getBus_no() {
        return bus_no;
    }

    public String getBus_condtions() {
        return bus_condtions;
    }

    public String getBus_contact_number() {
        return bus_contact_number;
    }

    public String getBus_avb_seats() {
        return bus_avb_seats;
    }

    public String getBus_img_path() {
        return bus_img_path;
    }

    public String getIsCompleteRoute() {
        return isCompleteRoute;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_point() {
        return end_point;
    }
}
