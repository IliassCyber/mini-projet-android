package com.app.damnvulnerablebank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.k.h;

/* JADX INFO: loaded from: classes.dex */
public class SplashScreen extends h {
    public ImageView p;
    public TextView q;
    public Animation r;
    public Animation s;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SplashScreen.this.startActivity(new Intent(SplashScreen.this.getApplicationContext(), (Class<?>) MainActivity.class));
            SplashScreen.this.finish();
        }
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.splash_screen);
        this.p = (ImageView) findViewById(R.id.background_image);
        this.q = (TextView) findViewById(R.id.powered);
        this.r = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        this.s = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        this.p.setAnimation(this.r);
        this.q.setAnimation(this.s);
        new Handler().postDelayed(new a(), 3000);
    }
}
