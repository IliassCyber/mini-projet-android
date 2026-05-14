package b.b.k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import b.b.o.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b.b.k.a$a, reason: collision with other inner class name */
    public static class C0006a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f241a;

        public C0006a(int i, int i2) {
            super(i, i2);
            this.f241a = 0;
            this.f241a = 8388627;
        }

        public C0006a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f241a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.j.ActionBarLayout);
            this.f241a = typedArrayObtainStyledAttributes.getInt(b.b.j.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0006a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f241a = 0;
        }

        public C0006a(C0006a c0006a) {
            super((ViewGroup.MarginLayoutParams) c0006a);
            this.f241a = 0;
            this.f241a = c0006a.f241a;
        }
    }

    public interface b {
        void a(boolean z);
    }

    @Deprecated
    public static abstract class c {
        public abstract void a();
    }

    public abstract boolean a();

    public abstract void b(boolean z);

    public abstract int c();

    public abstract Context d();

    public abstract void e(Configuration configuration);

    public abstract boolean f(int i, KeyEvent keyEvent);

    public abstract void g(boolean z);

    public abstract void h(boolean z);

    public abstract void i(CharSequence charSequence);

    public abstract b.b.o.a j(a.InterfaceC0011a interfaceC0011a);
}
