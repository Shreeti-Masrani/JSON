package com.example.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
//    ArrayList<String> name;
//    ArrayList<String> email;
//    ArrayList<String> mobile;
    ArrayList<Integer> id;
    ArrayList<String> title;
    ArrayList<String> image;
    Context context;

    public Adapter(ArrayList<Integer> id,ArrayList<String> title , ArrayList<String> image, Context context) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.context = context;
    }
//    ArrayList<ViewText> texts ;
//    Adapter(ArrayList<ViewText> texts){
//        this.texts = texts;
//    }
    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.list, parent,false );
        return new Viewholder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder , int position) {
        holder.textView1.setText ( id.get ( position ).toString () );
        holder.textView2.setText ( title.get ( position ) );
        //holder.Image.setText ( image.get ( position ) );
        Glide.with ( context ).load ( image.get ( position ));
    }

    @Override
    public int getItemCount() {
        return title.size ();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3;
        ImageView imageView;
        public Viewholder(@NonNull View itemView) {
            super ( itemView );

            textView1 = itemView.findViewById ( R.id.text1 );
            textView2= itemView.findViewById ( R.id.text2 );
            //textView3 = itemView.findViewById ( R.id.text3 );
            imageView = itemView.findViewById ( R.id.img );
        }
    }
}
