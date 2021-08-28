package com.example.smart_bus_system.User.Screens.Home.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import com.example.smart_bus_system.R;
import com.example.smart_bus_system.User.Screens.AvailableBuses.AvailablelBusFragment;
import com.example.smart_bus_system.User.Screens.Home.Model.Routes_Model;

import java.util.List;

public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.MyViewHolder>{


    private Context context;
    private List<Routes_Model> routes_modelList;

    public RoutesAdapter(Context context, List<Routes_Model> routes_modelList) {
        this.context = context;
        this.routes_modelList = routes_modelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate( R.layout.compontes_chosse_route_card,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;


        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentTransaction fragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container,new AvailablelBusFragment(
                        routes_modelList.get(viewHolder.getAdapterPosition()).getRoute_id()

                ))
                        .addToBackStack(null)
                        .commit();
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.start_point.setText("From : "+ routes_modelList.get(position).getStart_point()+"");
        holder.end_point.setText("To : "+ routes_modelList.get(position).getEnd_point()+"");

    }

    @Override
    public int getItemCount() {
        return routes_modelList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
CardView container;
TextView start_point;
TextView end_point;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            start_point=itemView.findViewById(R.id.start_point);
            end_point=itemView.findViewById(R.id.end_point);
            container=itemView.findViewById(R.id.container);
        }
    }
}


