package c.c.a.b.m;

import android.view.View;
import b.i.m.l;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f1655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1657c;
    public int d;
    public int e;
    public boolean f = true;
    public boolean g = true;

    public f(View view) {
        this.f1655a = view;
    }

    public void a() {
        View view = this.f1655a;
        l.K(view, this.d - (view.getTop() - this.f1656b));
        View view2 = this.f1655a;
        l.J(view2, this.e - (view2.getLeft() - this.f1657c));
    }
}
