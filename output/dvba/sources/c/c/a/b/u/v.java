package c.c.a.b.u;

import android.view.View;
import c.c.a.b.u.f;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1716c;

    public v(w wVar, int i) {
        this.f1716c = wVar;
        this.f1715b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = this.f1715b;
        int i2 = this.f1716c.f1717c.a0.d;
        Calendar calendarF = c.c.a.a.c.l.q.F();
        calendarF.set(1, i);
        calendarF.set(2, i2);
        this.f1716c.f1717c.c0(new o(calendarF));
        this.f1716c.f1717c.d0(f.e.DAY);
    }
}
