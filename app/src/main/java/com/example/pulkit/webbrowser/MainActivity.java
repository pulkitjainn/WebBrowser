package com.example.pulkit.webbrowser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
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

        final WebSettings webSettings = webv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = et.getText().toString();
                if(!url.startsWith("http://"))
                    url = "http://"+url;
                webv.loadUrl(url);

                //hide the keybaoard

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);//captures the instance
                imm.hideSoftInputFromInputMethod(et.getWindowToken(),0); //hides the keyboard
            }
        });


        fwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webv.canGoForward())
                    webv.goForward();
            }
        });

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webv.canGoBack())
                    webv.canGoBack();
            }
        });


        rld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webv.reload();
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webv.clearHistory();
            }
        });
    }
}
