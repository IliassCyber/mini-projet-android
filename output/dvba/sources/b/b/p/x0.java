package b.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f508c;

    public x0(Context context, TypedArray typedArray) {
        this.f506a = context;
        this.f507b = typedArray;
    }

    public static x0 p(Context context, AttributeSet attributeSet, int[] iArr) {
        return new x0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static x0 q(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new x0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f507b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f507b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f507b.hasValue(i) || (resourceId = this.f507b.getResourceId(i, 0)) == 0 || (colorStateListA = b.b.l.a.a.a(this.f506a, resourceId)) == null) ? this.f507b.getColorStateList(i) : colorStateListA;
    }

    public float d(int i, float f) {
        return this.f507b.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.f507b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.f507b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.f507b.hasValue(i) || (resourceId = this.f507b.getResourceId(i, 0)) == 0) ? this.f507b.getDrawable(i) : b.b.l.a.a.b(this.f506a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        Drawable drawableG;
        if (!this.f507b.hasValue(i) || (resourceId = this.f507b.getResourceId(i, 0)) == 0) {
            return null;
        }
        j jVarA = j.a();
        Context context = this.f506a;
        synchronized (jVarA) {
            drawableG = jVarA.f442a.g(context, resourceId, true);
        }
        return drawableG;
    }

    public Typeface i(int i, int i2, b.i.e.b.g gVar) {
        int resourceId = this.f507b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f508c == null) {
            this.f508c = new TypedValue();
        }
        Context context = this.f506a;
        TypedValue typedValue = this.f508c;
        if (context.isRestricted()) {
            return null;
        }
        return a.a.a.a.a.V(context, resourceId, typedValue, i2, gVar, null, true);
    }

    public int j(int i, int i2) {
        return this.f507b.getInt(i, i2);
    }

    public int k(int i, int i2) {
        return this.f507b.getLayoutDimension(i, i2);
    }

    public int l(int i, int i2) {
        return this.f507b.getResourceId(i, i2);
    }

    public String m(int i) {
        return this.f507b.getString(i);
    }

    public CharSequence n(int i) {
        return this.f507b.getText(i);
    }

    public boolean o(int i) {
        return this.f507b.hasValue(i);
    }
}
