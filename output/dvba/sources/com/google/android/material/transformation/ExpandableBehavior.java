package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.m.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2011a;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f2013c;
        public final /* synthetic */ c.c.a.b.w.a d;

        public a(View view, int i, c.c.a.b.w.a aVar) {
            this.f2012b = view;
            this.f2013c = i;
            this.d = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f2012b.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.f2011a == this.f2013c) {
                c.c.a.b.w.a aVar = this.d;
                expandableBehavior.C((View) aVar, this.f2012b, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f2011a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2011a = 0;
    }

    public final boolean B(boolean z) {
        if (!z) {
            return this.f2011a == 1;
        }
        int i = this.f2011a;
        return i == 0 || i == 2;
    }

    public abstract boolean C(View view, View view2, boolean z, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
        c.c.a.b.w.a aVar = (c.c.a.b.w.a) view2;
        if (!B(aVar.a())) {
            return false;
        }
        this.f2011a = aVar.a() ? 1 : 2;
        return C((View) aVar, view, aVar.a(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
        c.c.a.b.w.a aVar;
        if (!l.E(view)) {
            List<View> listD = coordinatorLayout.d(view);
            int size = listD.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = listD.get(i2);
                if (d(coordinatorLayout, view, view2)) {
                    aVar = (c.c.a.b.w.a) view2;
                    break;
                }
                i2++;
            }
            if (aVar != null && B(aVar.a())) {
                int i3 = aVar.a() ? 1 : 2;
                this.f2011a = i3;
                view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, aVar));
            }
        }
        return false;
    }
}
