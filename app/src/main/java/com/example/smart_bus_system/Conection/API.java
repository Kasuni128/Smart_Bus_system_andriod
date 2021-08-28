package com.example.smart_bus_system.Conection;


import com.example.smart_bus_system.BusOwner.Screens.Home.Model.Driver_Time_Model;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Model.Bus_info_model;
import com.example.smart_bus_system.User.Screens.Home.Model.Routes_Model;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {


    @POST("User/getRoutes.php")
    Call<List<Routes_Model>> getRotues();


    @FormUrlEncoded
    @POST("User/getBusInfo.php")
    Call<List<Bus_info_model>> getBusInfo(@FieldMap Map<String,String> fields);




    //fot get each user to time table information
    @FormUrlEncoded
    @POST("BusOwner/getTimeTable.php")
    Call<List<Driver_Time_Model>> getTimeTable(@FieldMap Map<String,String> fields);

    //fot get each time keeper to allocated bus  information
    @FormUrlEncoded
    @POST("Timekeeper/getBusInfo.php")
    Call<List<Bus_info_model>> TimekeepergetBusInfo(@FieldMap Map<String,String> fields);



    //admin activated user
    @FormUrlEncoded
    @POST("Timekeeper/isComplted.php")
    Call<ServerRespone> isComplted(@FieldMap Map<String,String> fields);



//for user  authenticate

    @FormUrlEncoded
    @POST("auth.php")
    Call<UserCreditial> authenticateUser(@FieldMap Map<String,String> fields);
}
