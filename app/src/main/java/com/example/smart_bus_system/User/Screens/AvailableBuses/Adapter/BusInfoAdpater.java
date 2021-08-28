package com.example.smart_bus_system.User.Screens.AvailableBuses.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_bus_system.R;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Model.Bus_info_model;
import com.example.smart_bus_system.User.Screens.Home.Adapters.RoutesAdapter;
import com.example.smart_bus_system.User.Screens.Home.Model.Routes_Model;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BusInfoAdpater extends RecyclerView.Adapter<BusInfoAdpater.MyViewHolder>{


    private Context context;
    private List<Bus_info_model> busInfoModelList;

    public BusInfoAdpater(Context context, List<Bus_info_model> busInfoModelList) {
        this.context = context;
        this.busInfoModelList = busInfoModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate( R.layout.compontes_avb_bus_card,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.bus_name.setText(busInfoModelList.get(position).getBus_name()+"");
        holder.bus_no.setText(busInfoModelList.get(position).getBus_no()+"");
        holder.bus_condtions.setText(busInfoModelList.get(position).getBus_condtions()+"");
        holder.start_time.setText("Start Time:"+busInfoModelList.get(position).getStart_time()+"");

        holder.bus_contact_number.setText(busInfoModelList.get(position).getBus_contact_number()+"");
        holder.bus_avb_seats.setText(busInfoModelList.get(position).getBus_avb_seats()+"");

        holder.end_time.setText("End Time:"+busInfoModelList.get(position).getEnd_time()+"");


        try {

            Picasso.get().load( busInfoModelList.get(position).getBus_img_path())
                    .networkPolicy( NetworkPolicy.NO_CACHE)
                    .memoryPolicy( MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                    .into( holder.post_image );


        }catch (Exception e){

        }


    }

    @Override
    public int getItemCount() {
        return busInfoModelList.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder {


        TextView bus_name;
        TextView bus_no;
        TextView bus_condtions;
        TextView start_time;
        TextView bus_contact_number;
        TextView bus_avb_seats;
        TextView end_time;
        ImageView post_image;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bus_name=itemView.findViewById(R.id.bus_name);
            bus_no=itemView.findViewById(R.id.bus_no);
            bus_condtions=itemView.findViewById(R.id.bus_condtions);
            start_time=itemView.findViewById(R.id.start_time);
            bus_contact_number=itemView.findViewById(R.id.bus_contact_number);
            bus_avb_seats=itemView.findViewById(R.id.bus_avb_seats);
            end_time=itemView.findViewById(R.id.end_time);
            post_image=itemView.findViewById(R.id.post_image);


        }
    }

}
