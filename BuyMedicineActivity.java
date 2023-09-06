package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String [][] packages={
            {"Uprise-03 1000IU Capsule","","","","50"},
            {"Omeprazole","","","","305"},
            {"Metformin ","","","","400"},
            {"Cetirizine","","","","60"},
            {"Acetaminophen (paracetamol)","","","","440"},
            {"Albuterol (salbutamol) ","","","","550"},
            {"Sertraline","","","","560"},
            {"Atorvastatin  ","","","","750"},
            {"Hydrochlorothiazide ","","","","850"},
    };
    private String[]package_detials={
            "Building and keeping the bones and teeth strong\n",
            " A proton pump inhibitor (PPI) used to reduce stomach acid production and treat conditions like acid reflux and ulcers.\n",
            " An oral medication used to manage and control blood sugar levels in people with type 2 diabetes.\n",
            "  An antihistamine used to relieve allergy symptoms such as sneezing, itching, and runny nose.\n",
            "  Used for pain relief and reducing fever.\n",
            "  A bronchodilator used to relieve and prevent asthma symptoms by opening up the airways.\n",
            " An antidepressant medication used to treat depression, anxiety disorders, and certain other mental health conditions\n",
            "  A statin medication used to lower cholesterol levels and reduce the risk of heart disease. \n",
            "A diuretic used to treat high blood pressure and reduce fluid retention. \n",
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.listViewBMCart);
        btnBack=findViewById(R.id.butttonBMback);
        btnGoToCart=findViewById(R.id.butttonBMGoToCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        list= new ArrayList();
        for(int i=0;i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" + packages[i][4] + "/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_detials[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}