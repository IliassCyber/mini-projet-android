package com.app.damnvulnerablebank;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import b.b.k.h;
import c.b.a.x;

/* JADX INFO: loaded from: classes.dex */
public class CurrencyRates extends h {
    public String p;

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        WebView webView;
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_currencyrates);
        if (getIntent().getExtras() == null) {
            webView = (WebView) findViewById(R.id.loads);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setWebViewClient(new x(this));
            str = "https://www.xe.com/";
        } else {
            this.p = getIntent().getData().getQueryParameter("url");
            webView = (WebView) findViewById(R.id.loads);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setWebViewClient(new x(this));
            str = this.p;
        }
        webView.loadUrl(str);
    }
}
