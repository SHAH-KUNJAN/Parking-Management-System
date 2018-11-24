package com.example.abc.project_management;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class adapterpark  extends BaseAdapter {

    Context c;

    HashMap<Integer,Boolean> images;
    String UserName;
    String Ownername;


    public adapterpark(Context c, HashMap<Integer,Boolean> images,String Username,String Ownername){

        this.c=c;
        this.images=images;
        this.UserName=Username;
        this.Ownername=Ownername;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ImageButton img=new ImageButton(c);
      //  Toast.makeText(c,UserName,Toast.LENGTH_SHORT).show();
       // Toast.makeText(c,images.get(position).toString(),Toast.LENGTH_LONG).show();
        if(images.containsKey(position) && images.get(position)) {
            img.setBackgroundResource(R.drawable.ic_parking);
        }
        else {
            img.setBackgroundResource(R.drawable.ic_noparking);
        }
        img.setLayoutParams(new GridView.LayoutParams(200,200));

       img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=position;
                pos++;
                if(!images.get(position)) {
                    img.setBackgroundResource(R.drawable.ic_parking);
                    Intent intent= new Intent(c,BookSlot.class);
                    intent.putExtra("UserName",UserName);
                    intent.putExtra("slotid",pos);
                    intent.putExtra("ownername",Ownername);
                    c.startActivity(intent);
                   // Toast.makeText(c, "Booked slot no  " + pos, Toast.LENGTH_SHORT).show();
                   // images.put(position,false);
                }


            }
        });


        return img;
    }
}
