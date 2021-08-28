package com.example.smart_bus_system.BusOwner.Screens.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_bus_system.BusOwner.Screens.Home.Model.Driver_Time_Model;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Adapter.BusInfoAdpater;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Model.Bus_info_model;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BusDriverAdapter extends RecyclerView.Adapter<BusDriverAdapter.MyViewHolder>{


    private Context context;
    private List<Driver_Time_Model> time_modelList;

    public BusDriverAdapter(Context context, List<Driver_Time_Model> time_modelList) {
        this.context = context;
        this.time_modelList = time_modelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate( R.layout.bus_time_row,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;





        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.bus_name.setText(time_modelList.get(position).getBus_name()+"");


        holder.start_time.setText("Start Time:"+time_modelList.get(position).getStart_time()+"");
        holder.end_time.setText("End Time:"+time_modelList.get(position).getEnd_time()+"");

        try {

            Picasso.get().load( time_modelList.get(position).getBus_img_path())
                    .networkPolicy( NetworkPolicy.NO_CACHE)
                    .memoryPolicy( MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                    .into( holder.bus_image );


        }catch (Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return time_modelList.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder {


        TextView bus_name;
        TextView start_time;
        TextView end_time;
        ImageView bus_image;





        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bus_image=itemView.findViewById(R.id.bus_image);
            bus_name=itemView.findViewById(R.id.bus_name);
            start_time=itemView.findViewById(R.id.start_time);
            end_time=itemView.findViewById(R.id.end_time);


        }
    }
}
