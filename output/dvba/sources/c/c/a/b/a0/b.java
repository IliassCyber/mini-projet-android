package c.c.a.b.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import b.i.e.b.g;
import c.c.a.a.c.l.q;
import c.c.a.b.k;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f1538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1539c;
    public final int d;
    public final String e;
    public final ColorStateList f;
    public final float g;
    public final float h;
    public final float i;
    public final int j;
    public boolean k = false;
    public Typeface l;

    public class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f1540a;

        public a(d dVar) {
            this.f1540a = dVar;
        }

        @Override // b.i.e.b.g
        public void c(int i) {
            b.this.k = true;
            this.f1540a.a(i);
        }

        @Override // b.i.e.b.g
        public void d(Typeface typeface) {
            b bVar = b.this;
            bVar.l = Typeface.create(typeface, bVar.f1539c);
            b bVar2 = b.this;
            bVar2.k = true;
            this.f1540a.b(bVar2.l, false);
        }
    }

    public b(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, k.TextAppearance);
        this.f1537a = typedArrayObtainStyledAttributes.getDimension(k.TextAppearance_android_textSize, 0.0f);
        this.f1538b = q.z(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColor);
        q.z(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColorHint);
        q.z(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColorLink);
        this.f1539c = typedArrayObtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, 0);
        this.d = typedArrayObtainStyledAttributes.getInt(k.TextAppearance_android_typeface, 1);
        int i2 = k.TextAppearance_fontFamily;
        i2 = typedArrayObtainStyledAttributes.hasValue(i2) ? i2 : k.TextAppearance_android_fontFamily;
        this.j = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        this.e = typedArrayObtainStyledAttributes.getString(i2);
        typedArrayObtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false);
        this.f = q.z(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_shadowColor);
        this.g = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDx, 0.0f);
        this.h = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDy, 0.0f);
        this.i = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a() {
        String str;
        if (this.l == null && (str = this.e) != null) {
            this.l = Typeface.create(str, this.f1539c);
        }
        if (this.l == null) {
            int i = this.d;
            this.l = i != 1 ? i != 2 ? i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.l = Typeface.create(this.l, this.f1539c);
        }
    }

    public void b(Context context, d dVar) {
        a();
        if (this.j == 0) {
            this.k = true;
        }
        if (this.k) {
            dVar.b(this.l, true);
            return;
        }
        try {
            int i = this.j;
            a aVar = new a(dVar);
            if (context.isRestricted()) {
                aVar.a(-4, null);
            } else {
                a.a.a.a.a.V(context, i, new TypedValue(), 0, aVar, null, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.k = true;
            dVar.a(1);
        } catch (Exception e) {
            StringBuilder sbE = c.a.a.a.a.e("Error loading font ");
            sbE.append(this.e);
            Log.d("TextAppearance", sbE.toString(), e);
            this.k = true;
            dVar.a(-3);
        }
    }

    public void c(Context context, TextPaint textPaint, d dVar) {
        a();
        d(textPaint, this.l);
        b(context, new c(this, textPaint, dVar));
        ColorStateList colorStateList = this.f1538b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.i;
        float f2 = this.g;
        float f3 = this.h;
        ColorStateList colorStateList2 = this.f;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void d(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f1539c;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f1537a);
    }
}
