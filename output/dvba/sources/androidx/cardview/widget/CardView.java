package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import b.e.d;
import b.e.e.b;
import b.e.e.c;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] i = {R.attr.colorBackground};
    public static final c j = new b.e.e.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f112c;
    public int d;
    public int e;
    public final Rect f;
    public final Rect g;
    public final b h;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f113a;

        public a() {
        }

        public boolean a() {
            return CardView.this.getPreventCornerOverlap();
        }

        public void b(int i, int i2, int i3, int i4) {
            CardView.this.g.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CardView(Context context, AttributeSet attributeSet) {
        Resources resources;
        int i2;
        ColorStateList colorStateListValueOf;
        int i3 = b.e.a.cardViewStyle;
        super(context, attributeSet, i3);
        this.f = new Rect();
        this.g = new Rect();
        this.h = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i3, b.e.c.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(d.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(d.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(i);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i2 = b.e.b.cardview_light_background;
            } else {
                resources = getResources();
                i2 = b.e.b.cardview_dark_background;
            }
            colorStateListValueOf = ColorStateList.valueOf(resources.getColor(i2));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.f111b = typedArrayObtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.f112c = typedArrayObtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        this.f.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, dimensionPixelSize);
        this.f.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, dimensionPixelSize);
        this.f.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        c cVar = j;
        b bVar = this.h;
        b.e.e.d dVar = new b.e.e.d(colorStateListValueOf, dimension);
        a aVar = (a) bVar;
        aVar.f113a = dVar;
        CardView.this.setBackgroundDrawable(dVar);
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(dimension2);
        ((b.e.e.a) cVar).d(bVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((b.e.e.a) j).a(this.h).h;
    }

    public float getCardElevation() {
        return CardView.this.getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f.left;
    }

    public int getContentPaddingRight() {
        return this.f.right;
    }

    public int getContentPaddingTop() {
        return this.f.top;
    }

    public float getMaxCardElevation() {
        return ((b.e.e.a) j).b(this.h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f112c;
    }

    public float getRadius() {
        return ((b.e.e.a) j).c(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.f111b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        c cVar = j;
        b bVar = this.h;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
        b.e.e.d dVarA = ((b.e.e.a) cVar).a(bVar);
        dVarA.b(colorStateListValueOf);
        dVarA.invalidateSelf();
    }

    public void setCardElevation(float f) {
        CardView.this.setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        ((b.e.e.a) j).d(this.h, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.e = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.d = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f112c) {
            this.f112c = z;
            c cVar = j;
            b bVar = this.h;
            b.e.e.a aVar = (b.e.e.a) cVar;
            aVar.d(bVar, aVar.a(bVar).e);
        }
    }

    public void setRadius(float f) {
        b.e.e.d dVarA = ((b.e.e.a) j).a(this.h);
        if (f == dVarA.f567a) {
            return;
        }
        dVarA.f567a = f;
        dVarA.c(null);
        dVarA.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f111b != z) {
            this.f111b = z;
            c cVar = j;
            b bVar = this.h;
            b.e.e.a aVar = (b.e.e.a) cVar;
            aVar.d(bVar, aVar.a(bVar).e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        b.e.e.d dVarA = ((b.e.e.a) j).a(this.h);
        dVarA.b(colorStateList);
        dVarA.invalidateSelf();
    }
}
