package com.example.galleryitems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Itemsquantity extends AppCompatActivity {

    TextView cost,plus,minus,incordec,fnlamount;
    CheckBox mupavkg;
    int val,incr,cstrt,totalprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemsquantity);

        cost=findViewById(R.id.cost);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        incordec=findViewById(R.id.incordec);
        fnlamount=findViewById(R.id.price);
        mupavkg=findViewById(R.id.mupavkg);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=incordec.getText().toString();
                 val=Integer.parseInt(value);
                incr=val+1;
               String costrate=cost.getText().toString();
                cstrt=Integer.parseInt(costrate);
                totalprice=incr*cstrt;
                incordec.setText(Integer.toString(incr));
                fnlamount.setText(Integer.toString(totalprice));
            }
        });
    }
}
