package com.example.finddoctorsinmirpurkhas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerContectAdapter extends RecyclerView.Adapter<RecyclerContectAdapter.ViewHolder> {
    @NonNull
    Context context;
    List<Contect_model> arrContacts;

    RecyclerContectAdapter(Context context, ArrayList<Contect_model> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }

    /*public void setFilteredList(ArrayList<Contect_model> filteredList){
        this.arrContacts = filteredList;
        notifyDataSetChanged();
    }*/

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.content_recycleview, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtname.setText(arrContacts.get(position).name);
        holder.Special.setText(arrContacts.get(position).Special);
        holder.txtcity.setText(arrContacts.get(position).city);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorProfile.class);
                intent.putExtra("Profile", arrContacts.get(position).getImg());
                intent.putExtra("Name", arrContacts.get(position).getName());
                intent.putExtra("Specialization", arrContacts.get(position).getSpecial());
                intent.putExtra("City", arrContacts.get(position).getCity());
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView txtname, txtcity, Special;
        ImageView imgContact;
        CardView cardView;
        public ViewHolder(View itmview){
            super(itmview );
            cardView = itemView.findViewById(R.id.card_view);

            txtname = itemView.findViewById(R.id.text1);
            Special = itemView.findViewById(R.id.text2);
            txtcity = itemView.findViewById(R.id.text3);

            imgContact = itemView.findViewById(R.id.contact_Image);

        }
    }
}
