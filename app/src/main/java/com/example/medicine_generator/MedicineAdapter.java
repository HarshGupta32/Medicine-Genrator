package com.example.medicine_generator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    ArrayList<Medicine> mList;
    Context context;

    public MedicineAdapter(ArrayList<Medicine> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);

        return new MedicineAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicine vacancy1 = mList.get(position);
        holder.txtbname.setText("Name -"+vacancy1.getName());
        holder.txtaddress.setText("Number -"+vacancy1.getNumber());
        holder.txttype.setText("Address -"+vacancy1.getAddress());
        holder.txtadd.setText("Soecification -"+vacancy1.getMedicine());
        holder.txtarea.setText("Date -"+vacancy1.getTime());

        //Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+vacancy1.getNumber()));
                if(ActivityCompat.checkSelfPermission(view.getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    return;
                }
                view.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView img1,call;
        TextView txtbname,txtaddress,txttype,txtadd,txtarea;


        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 =itemView.findViewById(R.id.img1);
            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);
            txtadd = itemView.findViewById(R.id.address);
            call = itemView.findViewById(R.id.imgcall);
            txtarea = itemView.findViewById(R.id.area);

            relativeLayout=itemView.findViewById(R.id.relative);

        }



    }
}
