package b.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0013a f390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f391c;
    public ActionMenuView d;
    public c e;
    public int f;
    public b.i.m.q g;
    public boolean h;
    public boolean i;

    /* JADX INFO: renamed from: b.b.p.a$a, reason: collision with other inner class name */
    public class C0013a implements b.i.m.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f392a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f393b;

        public C0013a() {
        }

        @Override // b.i.m.r
        public void a(View view) {
            if (this.f392a) {
                return;
            }
            a aVar = a.this;
            aVar.g = null;
            a.super.setVisibility(this.f393b);
        }

        @Override // b.i.m.r
        public void b(View view) {
            a.super.setVisibility(0);
            this.f392a = false;
        }

        @Override // b.i.m.r
        public void c(View view) {
            this.f392a = true;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f390b = new C0013a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(b.b.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f391c = context;
        } else {
            this.f391c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, RecyclerView.UNDEFINED_DURATION), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public int d(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public b.i.m.q e(int i, long j) {
        b.i.m.q qVar = this.g;
        if (qVar != null) {
            qVar.b();
        }
        if (i != 0) {
            b.i.m.q qVarA = b.i.m.l.a(this);
            qVarA.a(0.0f);
            qVarA.c(j);
            C0013a c0013a = this.f390b;
            a.this.g = qVarA;
            c0013a.f393b = i;
            View view = qVarA.f846a.get();
            if (view != null) {
                qVarA.e(view, c0013a);
            }
            return qVarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        b.i.m.q qVarA2 = b.i.m.l.a(this);
        qVarA2.a(1.0f);
        qVarA2.c(j);
        C0013a c0013a2 = this.f390b;
        a.this.g = qVarA2;
        c0013a2.f393b = i;
        View view2 = qVarA2.f846a.get();
        if (view2 != null) {
            qVarA2.e(view2, c0013a2);
        }
        return qVarA2;
    }

    public int getAnimatedVisibility() {
        return this.g != null ? this.f390b.f393b : getVisibility();
    }

    public int getContentHeight() {
        return this.f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, b.b.j.ActionBar, b.b.a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(b.b.j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        c cVar = this.e;
        if (cVar != null) {
            Configuration configuration2 = cVar.f347c.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            cVar.q = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            b.b.o.i.g gVar = cVar.d;
            if (gVar != null) {
                gVar.q(true);
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            b.i.m.q qVar = this.g;
            if (qVar != null) {
                qVar.b();
            }
            super.setVisibility(i);
        }
    }
}
