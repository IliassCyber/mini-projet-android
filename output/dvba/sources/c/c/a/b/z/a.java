package c.c.a.b.z;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.p.r;
import c.c.a.a.c.l.q;
import c.c.a.b.b;
import c.c.a.b.j;
import c.c.a.b.k;
import c.c.a.b.y.i;

/* JADX INFO: loaded from: classes.dex */
public class a extends r {
    public static final int g = j.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList e;
    public boolean f;

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet) {
        int i = b.radioButtonStyle;
        super(i.d(context, attributeSet, i, g), attributeSet, i);
        TypedArray typedArrayE = i.e(getContext(), attributeSet, k.MaterialRadioButton, i, g, new int[0]);
        this.f = typedArrayE.getBoolean(k.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayE.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int iY = q.y(this, b.colorControlActivated);
            int iY2 = q.y(this, b.colorOnSurface);
            int iY3 = q.y(this, b.colorSurface);
            int[] iArr = new int[h.length];
            iArr[0] = q.K(iY3, iY, 1.0f);
            iArr[1] = q.K(iY3, iY2, 0.54f);
            iArr[2] = q.K(iY3, iY2, 0.38f);
            iArr[3] = q.K(iY3, iY2, 0.38f);
            this.e = new ColorStateList(h, iArr);
        }
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f = z;
        setButtonTintList(z ? getMaterialThemeColorsTintList() : null);
    }
}
