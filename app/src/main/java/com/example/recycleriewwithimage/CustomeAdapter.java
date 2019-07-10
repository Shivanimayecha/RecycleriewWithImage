package com.example.recycleriewwithimage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<Integer> imageList =new ArrayList<>();


    Context context;

    public CustomAdapter(Context context,ArrayList arrayList,ArrayList imageList) {
        this.arrayList = arrayList;
        //this.imageList = imageList;
        this.context = context;
    }

    public void filterList(ArrayList<String> filterNames) {
        this.arrayList = filterNames;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
      //  ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.txt_PlaceName);
         //   imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.name.setText(arrayList.get(position));


       // holder.imageView.setImageResource(imageList.get(position));

      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(context, arrayList.get(position), Toast.LENGTH_SHORT).show();

               ////////////transfer image and text to Main2Activity

               *//* Intent intent =new Intent(context , Main2Activity.class);
                intent.putExtra("Place" , arrayList.get(position));

                intent.putExtra("Image",imageList.get(position));
                context.startActivity(intent);*//*

               /////////////////////////////////////////////////
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are You Want to remove item ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {

                      arrayList.remove(holder.getAdapterPosition());
                      notifyDataSetChanged();

                  }
              });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();



            }
        });*/




    }

    @Override
    public int getItemCount() {
        return arrayList.size() ;  }

}
