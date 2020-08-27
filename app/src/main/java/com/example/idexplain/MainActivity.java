package com.example.idexplain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edID;
    Button btnSubmit;
    TextView tvSubmition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edID = findViewById(R.id.edID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvSubmition = findViewById(R.id.tvSubmition);

        tvSubmition.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = edID.getText().toString();
                String dateOFBirth = idNumber.substring(0,6);
                boolean gender = Integer.parseInt(Character.toString(idNumber.charAt(6))) >=5 ;
                boolean citizenship = Integer.parseInt(Character.toString(idNumber.charAt(10))) ==0;
                String sGender;
                if(gender)
                {sGender= "MALE";}
                else
                {sGender = "FEMALE";}
                String nationality;

                if(citizenship)
                {nationality="Permanent resident";}
                else
                {nationality="SA citizen";}

                String rsText = "Date Of Birth: " + dateOFBirth.substring(4,6) + " "  + dateOFBirth.substring(2,4) + " " + dateOFBirth.substring(0,2) + "\n"
                        + "Gender : " + sGender + "\n"
                        + "Nationa;ity" + nationality;
                tvSubmition.setText(rsText);
                tvSubmition.setVisibility(View.VISIBLE);

            }
        });
    }
}