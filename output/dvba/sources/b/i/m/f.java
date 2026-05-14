package b.i.m;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f830c;
    public boolean d;
    public int[] e;

    public f(View view) {
        this.f830c = view;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent viewParentF;
        if (!this.d || (viewParentF = f(0)) == null) {
            return false;
        }
        return a.a.a.a.a.d0(viewParentF, this.f830c, f, f2, z);
    }

    public boolean b(float f, float f2) {
        ViewParent viewParentF;
        if (!this.d || (viewParentF = f(0)) == null) {
            return false;
        }
        return a.a.a.a.a.e0(viewParentF, this.f830c, f, f2);
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentF;
        int i4;
        int i5;
        if (!this.d || (viewParentF = f(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f830c.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                if (this.e == null) {
                    this.e = new int[2];
                }
                iArr = this.e;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            a.a.a.a.a.f0(viewParentF, this.f830c, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f830c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            if (iArr[0] != 0 || iArr[1] != 0) {
                return true;
            }
        } else if (iArr2 != null) {
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        return false;
    }

    public boolean d(int i, int i2, int i3, int i4, int[] iArr) {
        return e(i, i2, i3, i4, iArr, 0, null);
    }

    public final boolean e(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParentF;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.d || (viewParentF = f(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f830c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            int[] iArr4 = this.e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        a.a.a.a.a.g0(viewParentF, this.f830c, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f830c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public final ViewParent f(int i) {
        if (i == 0) {
            return this.f828a;
        }
        if (i != 1) {
            return null;
        }
        return this.f829b;
    }

    public boolean g(int i) {
        return f(i) != null;
    }

    public boolean h(int i, int i2) {
        boolean zOnStartNestedScroll;
        if (f(i2) != null) {
            return true;
        }
        if (this.d) {
            View view = this.f830c;
            for (ViewParent parent = this.f830c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.f830c;
                boolean z = parent instanceof g;
                if (z) {
                    zOnStartNestedScroll = ((g) parent).o(view, view2, i, i2);
                } else if (i2 == 0) {
                    try {
                        zOnStartNestedScroll = parent.onStartNestedScroll(view, view2, i);
                    } catch (AbstractMethodError e) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                        zOnStartNestedScroll = false;
                    }
                } else {
                    zOnStartNestedScroll = false;
                }
                if (zOnStartNestedScroll) {
                    if (i2 == 0) {
                        this.f828a = parent;
                    } else if (i2 == 1) {
                        this.f829b = parent;
                    }
                    View view3 = this.f830c;
                    if (z) {
                        ((g) parent).i(view, view3, i, i2);
                    } else if (i2 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i);
                        } catch (AbstractMethodError e2) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void i(int i) {
        ViewParent viewParentF = f(i);
        if (viewParentF != null) {
            View view = this.f830c;
            if (viewParentF instanceof g) {
                ((g) viewParentF).m(view, i);
            } else if (i == 0) {
                try {
                    viewParentF.onStopNestedScroll(view);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentF + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                this.f828a = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.f829b = null;
            }
        }
    }
}
