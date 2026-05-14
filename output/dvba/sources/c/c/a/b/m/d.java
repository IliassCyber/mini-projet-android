package c.c.a.b.m;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.i.m.l;
import b.i.m.u;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends e<View> {
    public final Rect d;
    public final Rect e;
    public int f;
    public int g;

    public d() {
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    @Override // c.c.a.b.m.e
    public void C(CoordinatorLayout coordinatorLayout, View view, int i) {
        int bottom;
        AppBarLayout appBarLayoutF = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.d(view));
        if (appBarLayoutF != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, appBarLayoutF.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((appBarLayoutF.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            u lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && l.o(coordinatorLayout) && !view.getFitsSystemWindows()) {
                rect.left = lastWindowInsets.b() + rect.left;
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.e;
            int i2 = fVar.f130c;
            Gravity.apply(i2 == 0 ? 8388659 : i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int iE = E(appBarLayoutF);
            view.layout(rect2.left, rect2.top - iE, rect2.right, rect2.bottom - iE);
            bottom = rect2.top - appBarLayoutF.getBottom();
        } else {
            coordinatorLayout.q(view, i);
            bottom = 0;
        }
        this.f = bottom;
    }

    public final int E(View view) {
        int i;
        if (this.g == 0) {
            return 0;
        }
        float f = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f128a;
            int iF = cVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) cVar).F() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + iF > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                f = 1.0f + (iF / i);
            }
        }
        int i2 = this.g;
        return a.a.a.a.a.j((int) (f * i2), 0, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        u lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if (i5 != -1 && i5 != -2) {
            return false;
        }
        AppBarLayout appBarLayoutF = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.d(view));
        if (appBarLayoutF == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (l.o(appBarLayoutF) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.a() + lastWindowInsets.d();
        }
        coordinatorLayout.r(view, i, i2, View.MeasureSpec.makeMeasureSpec((size + appBarLayoutF.getTotalScrollRange()) - appBarLayoutF.getMeasuredHeight(), i5 == -1 ? 1073741824 : RecyclerView.UNDEFINED_DURATION), i4);
        return true;
    }
}
