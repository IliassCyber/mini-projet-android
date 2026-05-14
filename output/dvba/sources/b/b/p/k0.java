package b.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class k0 implements b.b.o.i.p {
    public static Method D;
    public static Method E;
    public static Method F;
    public Rect A;
    public boolean B;
    public PopupWindow C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ListAdapter f450c;
    public f0 d;
    public int g;
    public int h;
    public boolean j;
    public boolean k;
    public boolean l;
    public DataSetObserver r;
    public View s;
    public AdapterView.OnItemClickListener t;
    public final Handler y;
    public int e = -2;
    public int f = -2;
    public int i = 1002;
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public int p = Integer.MAX_VALUE;
    public int q = 0;
    public final e u = new e();
    public final d v = new d();
    public final c w = new c();
    public final a x = new a();
    public final Rect z = new Rect();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = k0.this.d;
            if (f0Var != null) {
                f0Var.setListSelectionHidden(true);
                f0Var.requestLayout();
            }
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (k0.this.a()) {
                k0.this.i();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            k0.this.dismiss();
        }
    }

    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if ((k0.this.C.getInputMethodMode() == 2) || k0.this.C.getContentView() == null) {
                    return;
                }
                k0 k0Var = k0.this;
                k0Var.y.removeCallbacks(k0Var.u);
                k0.this.u.run();
            }
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = k0.this.C) != null && popupWindow.isShowing() && x >= 0 && x < k0.this.C.getWidth() && y >= 0 && y < k0.this.C.getHeight()) {
                k0 k0Var = k0.this;
                k0Var.y.postDelayed(k0Var.u, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            k0 k0Var2 = k0.this;
            k0Var2.y.removeCallbacks(k0Var2.u);
            return false;
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = k0.this.d;
            if (f0Var == null || !b.i.m.l.D(f0Var) || k0.this.d.getCount() <= k0.this.d.getChildCount()) {
                return;
            }
            int childCount = k0.this.d.getChildCount();
            k0 k0Var = k0.this;
            if (childCount <= k0Var.p) {
                k0Var.C.setInputMethodMode(2);
                k0.this.i();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                D = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                F = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                E = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public k0(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f449b = context;
        this.y = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.j.ListPopupWindow, i, i2);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(b.b.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(b.b.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.j = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        p pVar = new p(context, attributeSet, i, i2);
        this.C = pVar;
        pVar.setInputMethodMode(1);
    }

    @Override // b.b.o.i.p
    public boolean a() {
        return this.C.isShowing();
    }

    public void c(int i) {
        this.g = i;
    }

    public int d() {
        return this.g;
    }

    @Override // b.b.o.i.p
    public void dismiss() {
        this.C.dismiss();
        this.C.setContentView(null);
        this.d = null;
        this.y.removeCallbacks(this.u);
    }

    @Override // b.b.o.i.p
    public ListView e() {
        return this.d;
    }

    @Override // b.b.o.i.p
    public void i() {
        int i;
        int maxAvailableHeight;
        int paddingBottom;
        f0 f0Var;
        int i2;
        if (this.d == null) {
            f0 f0VarQ = q(this.f449b, !this.B);
            this.d = f0VarQ;
            f0VarQ.setAdapter(this.f450c);
            this.d.setOnItemClickListener(this.t);
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            this.d.setOnItemSelectedListener(new j0(this));
            this.d.setOnScrollListener(this.w);
            this.C.setContentView(this.d);
        }
        Drawable background = this.C.getBackground();
        if (background != null) {
            background.getPadding(this.z);
            Rect rect = this.z;
            int i3 = rect.top;
            i = rect.bottom + i3;
            if (!this.j) {
                this.h = -i3;
            }
        } else {
            this.z.setEmpty();
            i = 0;
        }
        boolean z = this.C.getInputMethodMode() == 2;
        View view = this.s;
        int i4 = this.h;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = E;
            if (method != null) {
                try {
                    maxAvailableHeight = ((Integer) method.invoke(this.C, view, Integer.valueOf(i4), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                    maxAvailableHeight = this.C.getMaxAvailableHeight(view, i4);
                }
            } else {
                maxAvailableHeight = this.C.getMaxAvailableHeight(view, i4);
            }
        } else {
            maxAvailableHeight = this.C.getMaxAvailableHeight(view, i4, z);
        }
        if (this.n || this.e == -1) {
            paddingBottom = maxAvailableHeight + i;
        } else {
            int i5 = this.f;
            if (i5 != -2) {
                i2 = 1073741824;
                if (i5 == -1) {
                    int i6 = this.f449b.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.z;
                    i5 = i6 - (rect2.left + rect2.right);
                }
            } else {
                int i7 = this.f449b.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.z;
                i5 = i7 - (rect3.left + rect3.right);
                i2 = RecyclerView.UNDEFINED_DURATION;
            }
            int iA = this.d.a(View.MeasureSpec.makeMeasureSpec(i5, i2), maxAvailableHeight - 0, -1);
            paddingBottom = iA + (iA > 0 ? this.d.getPaddingBottom() + this.d.getPaddingTop() + i + 0 : 0);
        }
        boolean z2 = this.C.getInputMethodMode() == 2;
        a.a.a.a.a.x0(this.C, this.i);
        if (this.C.isShowing()) {
            if (b.i.m.l.D(this.s)) {
                int width = this.f;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.s.getWidth();
                }
                int i8 = this.e;
                if (i8 == -1) {
                    if (!z2) {
                        paddingBottom = -1;
                    }
                    if (z2) {
                        this.C.setWidth(this.f == -1 ? -1 : 0);
                        this.C.setHeight(0);
                    } else {
                        this.C.setWidth(this.f == -1 ? -1 : 0);
                        this.C.setHeight(-1);
                    }
                } else if (i8 != -2) {
                    paddingBottom = i8;
                }
                this.C.setOutsideTouchable((this.o || this.n) ? false : true);
                this.C.update(this.s, this.g, this.h, width < 0 ? -1 : width, paddingBottom < 0 ? -1 : paddingBottom);
                return;
            }
            return;
        }
        int width2 = this.f;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.s.getWidth();
        }
        int i9 = this.e;
        if (i9 == -1) {
            paddingBottom = -1;
        } else if (i9 != -2) {
            paddingBottom = i9;
        }
        this.C.setWidth(width2);
        this.C.setHeight(paddingBottom);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = D;
            if (method2 != null) {
                try {
                    method2.invoke(this.C, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.C.setIsClippedToScreen(true);
        }
        this.C.setOutsideTouchable((this.o || this.n) ? false : true);
        this.C.setTouchInterceptor(this.v);
        if (this.l) {
            a.a.a.a.a.q0(this.C, this.k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = F;
            if (method3 != null) {
                try {
                    method3.invoke(this.C, this.A);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.C.setEpicenterBounds(this.A);
        }
        this.C.showAsDropDown(this.s, this.g, this.h, this.m);
        this.d.setSelection(-1);
        if ((!this.B || this.d.isInTouchMode()) && (f0Var = this.d) != null) {
            f0Var.setListSelectionHidden(true);
            f0Var.requestLayout();
        }
        if (this.B) {
            return;
        }
        this.y.post(this.x);
    }

    public int j() {
        if (this.j) {
            return this.h;
        }
        return 0;
    }

    public void l(Drawable drawable) {
        this.C.setBackgroundDrawable(drawable);
    }

    public void m(int i) {
        this.h = i;
        this.j = true;
    }

    public Drawable n() {
        return this.C.getBackground();
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.r;
        if (dataSetObserver == null) {
            this.r = new b();
        } else {
            ListAdapter listAdapter2 = this.f450c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f450c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.r);
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.setAdapter(this.f450c);
        }
    }

    public f0 q(Context context, boolean z) {
        return new f0(context, z);
    }

    public void r(int i) {
        Drawable background = this.C.getBackground();
        if (background == null) {
            this.f = i;
            return;
        }
        background.getPadding(this.z);
        Rect rect = this.z;
        this.f = rect.left + rect.right + i;
    }

    public void s(boolean z) {
        this.B = z;
        this.C.setFocusable(z);
    }
}
