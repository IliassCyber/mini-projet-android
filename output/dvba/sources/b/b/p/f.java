package b.b.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class f extends Button implements b.i.n.b, b.i.n.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f420c;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.b.a.buttonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u0.a(context);
        s0.a(this, getContext());
        e eVar = new e(this);
        this.f419b = eVar;
        eVar.d(attributeSet, i);
        y yVar = new y(this);
        this.f420c = yVar;
        yVar.e(attributeSet, i);
        this.f420c.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f419b;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f420c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.i.n.b.f880a) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f420c;
        if (yVar != null) {
            return Math.round(yVar.i.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b.i.n.b.f880a) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f420c;
        if (yVar != null) {
            return Math.round(yVar.i.d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b.i.n.b.f880a) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f420c;
        if (yVar != null) {
            return Math.round(yVar.i.f397c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.i.n.b.f880a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f420c;
        return yVar != null ? yVar.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.i.n.b.f880a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f420c;
        if (yVar != null) {
            return yVar.i.f395a;
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f419b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f419b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        v0 v0Var = this.f420c.h;
        if (v0Var != null) {
            return v0Var.f489a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        v0 v0Var = this.f420c.h;
        if (v0Var != null) {
            return v0Var.f490b;
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        y yVar = this.f420c;
        if (yVar == null || b.i.n.b.f880a) {
            return;
        }
        yVar.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        y yVar = this.f420c;
        if (yVar == null || b.i.n.b.f880a || !yVar.d()) {
            return;
        }
        this.f420c.i.a();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.i.n.b.f880a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        y yVar = this.f420c;
        if (yVar != null) {
            yVar.g(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.i.n.b.f880a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        y yVar = this.f420c;
        if (yVar != null) {
            yVar.h(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.i.n.b.f880a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        y yVar = this.f420c;
        if (yVar != null) {
            yVar.i(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f419b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f419b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a.a.a.a.a.D0(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        y yVar = this.f420c;
        if (yVar != null) {
            yVar.f509a.setAllCaps(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f419b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f419b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // b.i.n.e
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f420c.j(colorStateList);
        this.f420c.b();
    }

    @Override // b.i.n.e
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f420c.k(mode);
        this.f420c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f420c;
        if (yVar != null) {
            yVar.f(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = b.i.n.b.f880a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        y yVar = this.f420c;
        if (yVar == null || z || yVar.d()) {
            return;
        }
        yVar.i.f(i, f);
    }
}
