package com.capgemini.discover.touchpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {

    public static final String INTENT_EXTENDED_DATA = "MainActivity.cardType";

    public static final String url = "http://sites.simbla.com/35ef1b11-33e3-a875-7887-509b61c410c4/paymentgateway";

    CardDetails cardDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cardDetails = (CardDetails)getIntent().getSerializableExtra(INTENT_EXTENDED_DATA);

        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.getSettings().setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url) {
                final String js = "javascript:" +
                        "document.getElementById('P129').value = '" + cardDetails.getCardNumber() + "';"  +
                        "document.getElementById('P132').value = '" + cardDetails.getExpiryDate() + "';" +
                        "document.getElementById('P135').value = '" + cardDetails.getNameOnCard() + "';";

                if (Build.VERSION.SDK_INT >= 19) {
                    view.evaluateJavascript(js, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {

                        }
                    });
                }else {
                    view.loadUrl(js);
                }

            }
        });
    }
}
