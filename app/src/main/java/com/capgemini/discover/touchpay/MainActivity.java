package com.capgemini.discover.touchpay;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String GREEN = "green";
    public static final String PURPLE = "purple";
    public static final String SILVER = "silver";

    public static final String INTENT_EXTENDED_DATA = "MainActivity.cardType";

    //    Button getCardButton;
//    private TextView cardTexttView;
    ImageView greenCard;
    ImageView purpleCard;
    ImageView silverCard;

    CardDetails cardDetails;
    CardDetails updatedCardDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenCard = (ImageView)findViewById(R.id.cardGreen);
        purpleCard = (ImageView)findViewById(R.id.cardPurple);
        silverCard = (ImageView)findViewById(R.id.cardSilver);

        greenCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                updatedCardDetails = getCardDetails(GREEN);

                Intent intent = new Intent(MainActivity.this,WebViewActivity.class).putExtra(INTENT_EXTENDED_DATA, updatedCardDetails);
                startActivity(intent);
            }
        });

        purpleCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                updatedCardDetails = getCardDetails(PURPLE);

                Intent intent = new Intent(MainActivity.this,WebViewActivity.class).putExtra(INTENT_EXTENDED_DATA, updatedCardDetails);
                startActivity(intent);
            }
        });

        silverCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                updatedCardDetails = getCardDetails(SILVER);

                Intent intent = new Intent(MainActivity.this,WebViewActivity.class).putExtra(INTENT_EXTENDED_DATA, updatedCardDetails);
                startActivity(intent);
            }
        });






//        getCardButton = (Button) findViewById(R.id.button);
//        cardTexttView = (TextView) findViewById(R.id.textView);
//
//        getCardButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                cardTexttView.setText(getCardDetails().toString());
//               cardTexttView.setTextColor(Color.BLACK);
//                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private CardDetails getCardDetails(String card){

        cardDetails = new CardDetails();

        if(GREEN.equals(card)){
            cardDetails.setCardNumber("6011 7854 2654 1111");
            cardDetails.setExpiryDate("06/21");
            cardDetails.setNameOnCard("Shailesh Bhave");
        }
        else if(PURPLE.equals(card)){
            cardDetails.setCardNumber("6011 7854 2654 2222");
            cardDetails.setExpiryDate("07/21");
            cardDetails.setNameOnCard("Akshay Jain");
        }
        else if(SILVER.equals(card)){
            cardDetails.setCardNumber("6011 7854 2654 3333");
            cardDetails.setExpiryDate("08/21");
            cardDetails.setNameOnCard("Tom Cruise");
        }

        return cardDetails;
    }
}
