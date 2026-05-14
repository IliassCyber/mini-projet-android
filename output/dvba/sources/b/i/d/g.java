package b.i.d;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f713a;
    public CharSequence d;
    public CharSequence e;
    public PendingIntent f;
    public int g;
    public h i;
    public Bundle k;
    public RemoteViews n;
    public String o;
    public boolean r;
    public Notification s;

    @Deprecated
    public ArrayList<String> t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<e> f714b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<e> f715c = new ArrayList<>();
    public boolean h = true;
    public boolean j = false;
    public int l = 0;
    public int m = 0;
    public int p = 0;
    public int q = 0;

    @Deprecated
    public g(Context context) {
        Notification notification = new Notification();
        this.s = notification;
        this.f713a = context;
        this.o = null;
        notification.when = System.currentTimeMillis();
        this.s.audioStreamType = -1;
        this.g = 0;
        this.t = new ArrayList<>();
        this.r = true;
    }

    public static CharSequence a(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public g b(h hVar) {
        if (this.i != hVar) {
            this.i = hVar;
            if (hVar.f716a != this) {
                hVar.f716a = this;
                b(hVar);
            }
        }
        return this;
    }
}
