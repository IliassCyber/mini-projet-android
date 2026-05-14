package b.i.d;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k[] f711c;
    public final k[] d;
    public boolean e;
    public boolean f;
    public final int g;
    public final boolean h;

    @Deprecated
    public int i;
    public CharSequence j;
    public PendingIntent k;

    public e(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        int i2;
        StringBuilder sb;
        IconCompat iconCompatB = i == 0 ? null : IconCompat.b(null, "", i);
        Bundle bundle = new Bundle();
        this.f = true;
        this.f710b = iconCompatB;
        if (iconCompatB != null) {
            int iIntValue = -1;
            if (iconCompatB.f135a != -1 || (i2 = Build.VERSION.SDK_INT) < 23) {
                iIntValue = iconCompatB.f135a;
            } else {
                Icon icon = (Icon) iconCompatB.f136b;
                if (i2 >= 28) {
                    iIntValue = icon.getType();
                } else {
                    try {
                        iIntValue = ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
                    } catch (IllegalAccessException e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append("Unable to get icon type ");
                        sb.append(icon);
                        Log.e("IconCompat", sb.toString(), e);
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("Unable to get icon type ");
                        sb.append(icon);
                        Log.e("IconCompat", sb.toString(), e);
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("Unable to get icon type ");
                        sb.append(icon);
                        Log.e("IconCompat", sb.toString(), e);
                    }
                }
            }
            if (iIntValue == 2) {
                this.i = iconCompatB.c();
            }
        }
        this.j = g.a(charSequence);
        this.k = pendingIntent;
        this.f709a = bundle;
        this.f711c = null;
        this.d = null;
        this.e = true;
        this.g = 0;
        this.f = true;
        this.h = false;
    }

    public IconCompat a() {
        int i;
        if (this.f710b == null && (i = this.i) != 0) {
            this.f710b = IconCompat.b(null, "", i);
        }
        return this.f710b;
    }
}
