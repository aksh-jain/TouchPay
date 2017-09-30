package com.capgemini.discover.touchpay;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button getCardButton;
    private TextView cardTexttView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCardButton = (Button) findViewById(R.id.button);
        cardTexttView = (TextView) findViewById(R.id.textView);

        getCardButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                cardTexttView.setText(getCardDetails().toString());
//                cardTexttView.setTextColor(Color.BLACK);
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });
    }

//    private CardDetails getCardDetails(){
//        CardDetails cardDetails = new CardDetails();
//        cardDetails.setCardNumber("4587 7854 2654 8568");
//        cardDetails.setExpiryDate("06/22");
//        cardDetails.setNameOnCard("Akshay Jain");
//
//        return cardDetails;
//    }
}
