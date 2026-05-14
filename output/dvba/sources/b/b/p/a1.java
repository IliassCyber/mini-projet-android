package b.b.p;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
public class a1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static a1 k;
    public static a1 l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f399c;
    public final int d;
    public final Runnable e = new a();
    public final Runnable f = new b();
    public int g;
    public int h;
    public b1 i;
    public boolean j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a1.this.d(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a1.this.b();
        }
    }

    public a1(View view, CharSequence charSequence) {
        this.f398b = view;
        this.f399c = charSequence;
        this.d = b.i.m.p.c(ViewConfiguration.get(view.getContext()));
        a();
        this.f398b.setOnLongClickListener(this);
        this.f398b.setOnHoverListener(this);
    }

    public static void c(a1 a1Var) {
        a1 a1Var2 = k;
        if (a1Var2 != null) {
            a1Var2.f398b.removeCallbacks(a1Var2.e);
        }
        k = a1Var;
        if (a1Var != null) {
            a1Var.f398b.postDelayed(a1Var.e, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
    }

    public void b() {
        if (l == this) {
            l = null;
            b1 b1Var = this.i;
            if (b1Var != null) {
                b1Var.a();
                this.i = null;
                a();
                this.f398b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (k == this) {
            c(null);
        }
        this.f398b.removeCallbacks(this.f);
    }

    public void d(boolean z) {
        int height;
        int i;
        long longPressTimeout;
        if (b.i.m.l.D(this.f398b)) {
            c(null);
            a1 a1Var = l;
            if (a1Var != null) {
                a1Var.b();
            }
            l = this;
            this.j = z;
            b1 b1Var = new b1(this.f398b.getContext());
            this.i = b1Var;
            View view = this.f398b;
            int width = this.g;
            int i2 = this.h;
            boolean z2 = this.j;
            CharSequence charSequence = this.f399c;
            if (b1Var.f405b.getParent() != null) {
                b1Var.a();
            }
            b1Var.f406c.setText(charSequence);
            WindowManager.LayoutParams layoutParams = b1Var.d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = b1Var.f404a.getResources().getDimensionPixelOffset(b.b.d.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = b1Var.f404a.getResources().getDimensionPixelOffset(b.b.d.tooltip_precise_anchor_extra_offset);
                height = i2 + dimensionPixelOffset2;
                i = i2 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = b1Var.f404a.getResources().getDimensionPixelOffset(z2 ? b.b.d.tooltip_y_offset_touch : b.b.d.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context = view.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    }
                    if (context instanceof Activity) {
                        rootView = ((Activity) context).getWindow().getDecorView();
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                rootView.getWindowVisibleDisplayFrame(b1Var.e);
                Rect rect = b1Var.e;
                if (rect.left < 0 && rect.top < 0) {
                    Resources resources = b1Var.f404a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    b1Var.e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(b1Var.g);
                view.getLocationOnScreen(b1Var.f);
                int[] iArr = b1Var.f;
                int i3 = iArr[0];
                int[] iArr2 = b1Var.g;
                iArr[0] = i3 - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (iArr[0] + width) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                b1Var.f405b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = b1Var.f405b.getMeasuredHeight();
                int[] iArr3 = b1Var.f;
                int i4 = ((iArr3[1] + i) - dimensionPixelOffset3) - measuredHeight;
                int i5 = iArr3[1] + height + dimensionPixelOffset3;
                if (!z2 ? measuredHeight + i5 <= b1Var.e.height() : i4 < 0) {
                    layoutParams.y = i4;
                } else {
                    layoutParams.y = i5;
                }
            }
            ((WindowManager) b1Var.f404a.getSystemService("window")).addView(b1Var.f405b, b1Var.d);
            this.f398b.addOnAttachStateChangeListener(this);
            if (this.j) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((this.f398b.getWindowSystemUiVisibility() & 1) == 1 ? 3000L : 15000L) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f398b.removeCallbacks(this.f);
            this.f398b.postDelayed(this.f, longPressTimeout);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.i != null && this.j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f398b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                a();
                b();
            }
        } else if (this.f398b.isEnabled() && this.i == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.g) > this.d || Math.abs(y - this.h) > this.d) {
                this.g = x;
                this.h = y;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c(this);
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.g = view.getWidth() / 2;
        this.h = view.getHeight() / 2;
        d(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
