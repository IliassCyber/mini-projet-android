package c.c.a.b.g0;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.d0.g;
import c.c.a.b.d0.j;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public class h extends n {
    public final TextWatcher d;
    public final TextInputLayout.e e;
    public final TextInputLayout.f f;
    public boolean g;
    public boolean h;
    public long i;
    public StateListDrawable j;
    public c.c.a.b.d0.g k;
    public AccessibilityManager l;
    public ValueAnimator m;
    public ValueAnimator n;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: c.c.a.b.g0.h$a$a, reason: collision with other inner class name */
        public class RunnableC0061a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f1601b;

            public RunnableC0061a(AutoCompleteTextView autoCompleteTextView) {
                this.f1601b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.f1601b.isPopupShowing();
                h.e(h.this, zIsPopupShowing);
                h.this.g = zIsPopupShowing;
            }
        }

        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            h hVar = h.this;
            AutoCompleteTextView autoCompleteTextViewD = h.d(hVar, hVar.f1611a.getEditText());
            autoCompleteTextViewD.post(new RunnableC0061a(autoCompleteTextViewD));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b extends TextInputLayout.e {
        public b(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, b.i.m.a
        public void d(View view, b.i.m.v.b bVar) {
            boolean zIsShowingHintText;
            super.d(view, bVar);
            bVar.f864a.setClassName(Spinner.class.getName());
            if (Build.VERSION.SDK_INT >= 26) {
                zIsShowingHintText = bVar.f864a.isShowingHintText();
            } else {
                Bundle bundleF = bVar.f();
                zIsShowingHintText = bundleF != null && (bundleF.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (zIsShowingHintText) {
                bVar.k(null);
            }
        }

        @Override // b.i.m.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            this.f820a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            h hVar = h.this;
            AutoCompleteTextView autoCompleteTextViewD = h.d(hVar, hVar.f1611a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.l.isTouchExplorationEnabled()) {
                h.f(h.this, autoCompleteTextViewD);
            }
        }
    }

    public class c implements TextInputLayout.f {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00ff  */
        @Override // com.google.android.material.textfield.TextInputLayout.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(com.google.android.material.textfield.TextInputLayout r13) {
            /*
                Method dump skipped, instruction units count: 256
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g0.h.c.a(com.google.android.material.textfield.TextInputLayout):void");
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.f(h.this, (AutoCompleteTextView) h.this.f1611a.getEditText());
        }
    }

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b(this.f1611a);
        this.f = new c();
        this.g = false;
        this.h = false;
        this.i = RecyclerView.FOREVER_NS;
    }

    public static AutoCompleteTextView d(h hVar, EditText editText) {
        if (hVar == null) {
            throw null;
        }
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static void e(h hVar, boolean z) {
        if (hVar.h != z) {
            hVar.h = z;
            hVar.n.cancel();
            hVar.m.start();
        }
    }

    public static void f(h hVar, AutoCompleteTextView autoCompleteTextView) {
        if (hVar == null) {
            throw null;
        }
        if (autoCompleteTextView == null) {
            return;
        }
        if (hVar.h()) {
            hVar.g = false;
        }
        if (hVar.g) {
            hVar.g = false;
            return;
        }
        boolean z = hVar.h;
        boolean z2 = !z;
        if (z != z2) {
            hVar.h = z2;
            hVar.n.cancel();
            hVar.m.start();
        }
        if (!hVar.h) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // c.c.a.b.g0.n
    public void a() {
        float dimensionPixelOffset = this.f1612b.getResources().getDimensionPixelOffset(c.c.a.b.d.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f1612b.getResources().getDimensionPixelOffset(c.c.a.b.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f1612b.getResources().getDimensionPixelOffset(c.c.a.b.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        c.c.a.b.d0.g gVarG = g(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        c.c.a.b.d0.g gVarG2 = g(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.k = gVarG;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.j = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, gVarG);
        this.j.addState(new int[0], gVarG2);
        this.f1611a.setEndIconDrawable(b.b.l.a.a.b(this.f1612b, c.c.a.b.e.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.f1611a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(c.c.a.b.i.exposed_dropdown_menu_content_description));
        this.f1611a.setEndIconOnClickListener(new d());
        this.f1611a.a(this.f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(c.c.a.b.l.a.f1627a);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new m(this));
        this.n = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(c.c.a.b.l.a.f1627a);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new m(this));
        this.m = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new l(this));
        b.i.m.l.d0(this.f1613c, 2);
        this.l = (AccessibilityManager) this.f1612b.getSystemService("accessibility");
    }

    @Override // c.c.a.b.g0.n
    public boolean b(int i) {
        return i != 0;
    }

    @Override // c.c.a.b.g0.n
    public boolean c() {
        return true;
    }

    public final c.c.a.b.d0.g g(float f, float f2, float f3, int i) {
        j.b bVar = new j.b();
        bVar.e = new c.c.a.b.d0.a(f);
        bVar.f = new c.c.a.b.d0.a(f);
        bVar.h = new c.c.a.b.d0.a(f2);
        bVar.g = new c.c.a.b.d0.a(f2);
        c.c.a.b.d0.j jVarA = bVar.a();
        c.c.a.b.d0.g gVarF = c.c.a.b.d0.g.f(this.f1612b, f3);
        gVarF.f1555b.f1558a = jVarA;
        gVarF.invalidateSelf();
        g.b bVar2 = gVarF.f1555b;
        if (bVar2.i == null) {
            bVar2.i = new Rect();
        }
        gVarF.f1555b.i.set(0, i, 0, i);
        gVarF.u = gVarF.f1555b.i;
        gVarF.invalidateSelf();
        return gVarF;
    }

    public final boolean h() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.i;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }
}
