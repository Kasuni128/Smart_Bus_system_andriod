package com.example.smart_bus_system.TimeKeeper.Screens.Home.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_bus_system.Conection.RetroClient;
import com.example.smart_bus_system.Conection.ServerRespone;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Adapter.BusInfoAdpater;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Model.Bus_info_model;
import com.example.smart_bus_system.User.Screens.Home.Model.Routes_Model;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeKeeperAdapter  extends RecyclerView.Adapter<TimeKeeperAdapter.MyViewHolder>{


    private Context context;
    private List<Bus_info_model> busInfoModelList;

    public TimeKeeperAdapter(Context context, List<Bus_info_model> busInfoModelList) {
        this.context = context;
        this.busInfoModelList = busInfoModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate( R.layout.time_keeper_bus_row,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;

        viewHolder.activeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateState( busInfoModelList.get(viewHolder.getAdapterPosition()).getTb_id(),"Complete");
            }
        });
        viewHolder.inactiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateState( busInfoModelList.get(viewHolder.getAdapterPosition()).getTb_id(),"Not-Complete");
            }
        });

        return viewHolder;
    }

    private void UpdateState(String tb_id, String active) {


        HashMap<String, String> hashMap= new HashMap<>();

        hashMap.put("bus_tb_id",tb_id);
        hashMap.put("sate",active);


        Call<ServerRespone> isComplted= RetroClient.getInstance().getApi().isComplted(hashMap);


        isComplted.enqueue(new Callback<ServerRespone>() {
            @Override
            public void onResponse(Call<ServerRespone> call, Response<ServerRespone> response) {
                if(response.body().getSuccess().equals("true")){
                    //  Toast.makeText(context,"Delete Success !",Toast.LENGTH_SHORT).show();
                    AlertMessage("Task Success !");
                    //  pd.dismiss();
                    notifyDataSetChanged();

                }else{
                    //pd.dismiss();
                    AlertMessage("Task Failed  !");
                    // Toast.makeText(context,"Delete Failed  !",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServerRespone> call, Throwable t) {


                Log.e("error",t.getMessage());
            }
        });

    }


    private void AlertMessage(String message){

        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(context);
        dialog.setTitle( "Task Status" )
                .setIcon(R.drawable.ic_baseline_email_24)
                .setMessage(message)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                    }}).show();

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bus_name.setText(busInfoModelList.get(position).getBus_name()+"");
        holder.sate.setText(busInfoModelList.get(position).getIsCompleteRoute()+"");
        holder.route.setText(busInfoModelList.get(position).getStart_point()+" To "+busInfoModelList.get(position).getEnd_point());
        holder.time.setText(busInfoModelList.get(position).getStart_time()+" To "+busInfoModelList.get(position).getEnd_time());

        try {

            Picasso.get().load( busInfoModelList.get(position).getBus_img_path())
                    .networkPolicy( NetworkPolicy.NO_CACHE)
                    .memoryPolicy( MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                    .into( holder.bus_image );


        }catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        return busInfoModelList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {


        TextView bus_name;
        TextView route;
        TextView time;
        TextView sate;
        ImageView bus_image;


        Button activeBtn;
        Button inactiveBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bus_name=itemView.findViewById(R.id.bus_name);
            sate=itemView.findViewById(R.id.sate);
            route=itemView.findViewById(R.id.route);
            time=itemView.findViewById(R.id.time);
            bus_image=itemView.findViewById(R.id.bus_image);
            activeBtn=itemView.findViewById(R.id.activeBtn);
            inactiveBtn=itemView.findViewById(R.id.inactiveBtn);



        }
    }
}
