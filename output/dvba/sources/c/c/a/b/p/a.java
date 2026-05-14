package c.c.a.b.p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import c.c.a.a.c.l.q;
import c.c.a.b.b;
import c.c.a.b.d0.g;
import c.c.a.b.d0.j;
import c.c.a.b.d0.n;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f1670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f1671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1672c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;

    public a(MaterialButton materialButton, j jVar) {
        this.f1670a = materialButton;
        this.f1671b = jVar;
    }

    public n a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.r.getNumberOfLayers() > 2 ? this.r.getDrawable(2) : this.r.getDrawable(1));
    }

    public g b() {
        return c(false);
    }

    public final g c(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final g d() {
        return c(true);
    }

    public void e(j jVar) {
        this.f1671b = jVar;
        if (b() != null) {
            g gVarB = b();
            gVarB.f1555b.f1558a = jVar;
            gVarB.invalidateSelf();
        }
        if (d() != null) {
            g gVarD = d();
            gVarD.f1555b.f1558a = jVar;
            gVarD.invalidateSelf();
        }
        if (a() != null) {
            a().setShapeAppearanceModel(jVar);
        }
    }

    public final void f() {
        g gVarB = b();
        g gVarD = d();
        if (gVarB != null) {
            gVarB.t(this.h, this.k);
            if (gVarD != null) {
                gVarD.s(this.h, this.n ? q.y(this.f1670a, b.colorSurface) : 0);
            }
        }
    }
}
