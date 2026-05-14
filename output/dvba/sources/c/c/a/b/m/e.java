package c.c.a.b.m;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public class e<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1654c;

    public e() {
        this.f1653b = 0;
        this.f1654c = 0;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1653b = 0;
        this.f1654c = 0;
    }

    public int B() {
        f fVar = this.f1652a;
        if (fVar != null) {
            return fVar.d;
        }
        return 0;
    }

    public void C(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.q(v, i);
    }

    public boolean D(int i) {
        f fVar = this.f1652a;
        if (fVar == null) {
            this.f1653b = i;
            return false;
        }
        if (!fVar.f || fVar.d == i) {
            return false;
        }
        fVar.d = i;
        fVar.a();
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        C(coordinatorLayout, v, i);
        if (this.f1652a == null) {
            this.f1652a = new f(v);
        }
        f fVar = this.f1652a;
        fVar.f1656b = fVar.f1655a.getTop();
        fVar.f1657c = fVar.f1655a.getLeft();
        this.f1652a.a();
        int i2 = this.f1653b;
        if (i2 != 0) {
            f fVar2 = this.f1652a;
            if (fVar2.f && fVar2.d != i2) {
                fVar2.d = i2;
                fVar2.a();
            }
            this.f1653b = 0;
        }
        int i3 = this.f1654c;
        if (i3 == 0) {
            return true;
        }
        f fVar3 = this.f1652a;
        if (fVar3.g && fVar3.e != i3) {
            fVar3.e = i3;
            fVar3.a();
        }
        this.f1654c = 0;
        return true;
    }
}
