package b.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.c.e;

/* JADX INFO: loaded from: classes.dex */
public class f extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f689b;

    public static class a extends ConstraintLayout.a {
        public float n0;
        public boolean o0;
        public float p0;
        public float q0;
        public float r0;
        public float s0;
        public float t0;
        public float u0;
        public float v0;
        public float w0;
        public float x0;
        public float y0;
        public float z0;

        public a(int i, int i2) {
            super(i, i2);
            this.n0 = 1.0f;
            this.o0 = false;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 0.0f;
            this.t0 = 1.0f;
            this.u0 = 1.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
            this.z0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n0 = 1.0f;
            this.o0 = false;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 0.0f;
            this.t0 = 1.0f;
            this.u0 = 1.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
            this.z0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == k.ConstraintSet_android_alpha) {
                    this.n0 = typedArrayObtainStyledAttributes.getFloat(index, this.n0);
                } else if (index == k.ConstraintSet_android_elevation) {
                    this.p0 = typedArrayObtainStyledAttributes.getFloat(index, this.p0);
                    this.o0 = true;
                } else if (index == k.ConstraintSet_android_rotationX) {
                    this.r0 = typedArrayObtainStyledAttributes.getFloat(index, this.r0);
                } else if (index == k.ConstraintSet_android_rotationY) {
                    this.s0 = typedArrayObtainStyledAttributes.getFloat(index, this.s0);
                } else if (index == k.ConstraintSet_android_rotation) {
                    this.q0 = typedArrayObtainStyledAttributes.getFloat(index, this.q0);
                } else if (index == k.ConstraintSet_android_scaleX) {
                    this.t0 = typedArrayObtainStyledAttributes.getFloat(index, this.t0);
                } else if (index == k.ConstraintSet_android_scaleY) {
                    this.u0 = typedArrayObtainStyledAttributes.getFloat(index, this.u0);
                } else if (index == k.ConstraintSet_android_transformPivotX) {
                    this.v0 = typedArrayObtainStyledAttributes.getFloat(index, this.v0);
                } else if (index == k.ConstraintSet_android_transformPivotY) {
                    this.w0 = typedArrayObtainStyledAttributes.getFloat(index, this.w0);
                } else if (index == k.ConstraintSet_android_translationX) {
                    this.x0 = typedArrayObtainStyledAttributes.getFloat(index, this.x0);
                } else if (index == k.ConstraintSet_android_translationY) {
                    this.y0 = typedArrayObtainStyledAttributes.getFloat(index, this.y0);
                } else if (index == k.ConstraintSet_android_translationZ) {
                    this.z0 = typedArrayObtainStyledAttributes.getFloat(index, this.z0);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public e getConstraintSet() {
        if (this.f689b == null) {
            this.f689b = new e();
        }
        e eVar = this.f689b;
        if (eVar == null) {
            throw null;
        }
        int childCount = getChildCount();
        eVar.f673c.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            a aVar = (a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (eVar.f672b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!eVar.f673c.containsKey(Integer.valueOf(id))) {
                eVar.f673c.put(Integer.valueOf(id), new e.a());
            }
            e.a aVar2 = eVar.f673c.get(Integer.valueOf(id));
            if (childAt instanceof c) {
                c cVar = (c) childAt;
                aVar2.c(id, aVar);
                if (cVar instanceof b.g.c.a) {
                    e.b bVar = aVar2.d;
                    bVar.d0 = 1;
                    b.g.c.a aVar3 = (b.g.c.a) cVar;
                    bVar.b0 = aVar3.getType();
                    aVar2.d.e0 = aVar3.getReferencedIds();
                    aVar2.d.c0 = aVar3.getMargin();
                }
            }
            aVar2.c(id, aVar);
        }
        return this.f689b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
