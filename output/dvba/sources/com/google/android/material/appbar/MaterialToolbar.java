package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import b.i.m.l;
import c.c.a.a.c.l.q;
import c.c.a.b.b;
import c.c.a.b.d0.g;
import c.c.a.b.j;
import c.c.a.b.v.a;
import c.c.a.b.y.i;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final int O = j.Widget_MaterialComponents_Toolbar;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        int i = b.toolbarStyle;
        super(i.d(context, attributeSet, i, O), attributeSet, i);
        Context context2 = getContext();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.q(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.f1555b.f1559b = new a(context2);
            gVar.x();
            gVar.p(l.m(this));
            setBackground(gVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            q.Y(this, (g) background);
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        q.X(this, f);
    }
}
