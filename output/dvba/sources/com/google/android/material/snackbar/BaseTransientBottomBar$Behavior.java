package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.b.e0.a;
import c.c.a.b.e0.d;
import c.c.a.b.e0.e;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final a j = new a(this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public boolean B(View view) {
        if (this.j != null) {
            return view instanceof d;
        }
        throw null;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.j == null) {
            throw null;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (e.f1588c == null) {
                    e.f1588c = new e();
                }
                synchronized (e.f1588c.f1589a) {
                }
            }
        } else if (coordinatorLayout.j(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (e.f1588c == null) {
                e.f1588c = new e();
            }
            synchronized (e.f1588c.f1589a) {
            }
        }
        return super.j(coordinatorLayout, view, motionEvent);
    }
}
