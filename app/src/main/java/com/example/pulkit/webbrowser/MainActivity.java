package com.example.pulkit.webbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webv;
    EditText et;
    Button go,fwd,clr,bck,rld;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String urld = "http://www.hackstories.com";


        webv = (WebView) findViewById(R.id.webv);
        webv.loadUrl(urld);

        et = (EditText) findViewById(R.id.et);
        go = (Button) findViewById(R.id.go);
        fwd = (Button) findViewById(R.id.fwd);
        clr = (Button) findViewById(R.id.clr);
        bck = (Button) findViewById(R.id.bck);
        rld = (Button) findViewById(R.id.rld);

        webv.setWebViewClient(new ViewClient());//enables us to open the link in the same broswer rather then opening it in aother browser

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = et.getText().toString();
                if(!url.startsWith("http://"))
                    url = "http://"+url;
                webv.loadUrl(url);
            }
        });

    }
}
