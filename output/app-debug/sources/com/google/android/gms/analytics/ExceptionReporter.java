package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.internal.zzae;
import java.lang.Thread;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionReporter implements Thread.UncaughtExceptionHandler {
    private final Context mContext;
    private final Thread.UncaughtExceptionHandler zzIp;
    private final Tracker zzIq;
    private ExceptionParser zzIr;
    private GoogleAnalytics zzIs;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.zzIp = uncaughtExceptionHandler;
        this.zzIq = tracker;
        this.zzIr = new StandardExceptionParser(context, new ArrayList());
        this.mContext = context.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append("ExceptionReporter created, original handler is ");
        sb.append(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
        zzae.zzaB(sb.toString());
    }

    public ExceptionParser getExceptionParser() {
        return this.zzIr;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzIr = exceptionParser;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String description = "UncaughtException";
        if (this.zzIr != null) {
            description = this.zzIr.getDescription(thread != null ? thread.getName() : null, th);
        }
        zzae.zzaB("Reporting uncaught exception: " + description);
        this.zzIq.send(new HitBuilders.ExceptionBuilder().setDescription(description).setFatal(true).build());
        GoogleAnalytics googleAnalyticsZzhg = zzhg();
        googleAnalyticsZzhg.dispatchLocalHits();
        googleAnalyticsZzhg.zzhk();
        if (this.zzIp != null) {
            zzae.zzaB("Passing exception to the original handler");
            this.zzIp.uncaughtException(thread, th);
        }
    }

    GoogleAnalytics zzhg() {
        if (this.zzIs == null) {
            this.zzIs = GoogleAnalytics.getInstance(this.mContext);
        }
        return this.zzIs;
    }

    Thread.UncaughtExceptionHandler zzhh() {
        return this.zzIp;
    }
}
