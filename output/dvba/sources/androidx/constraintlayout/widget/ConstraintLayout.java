package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import b.g.b.i.e;
import b.g.b.i.f;
import b.g.b.i.g;
import b.g.b.i.l.b;
import b.g.c.c;
import b.g.c.d;
import b.g.c.e;
import b.g.c.h;
import b.g.c.i;
import b.g.c.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SparseArray<View> f115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<c> f116c;
    public e d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public b.g.c.e k;
    public d l;
    public int m;
    public HashMap<String, Integer> n;
    public int o;
    public int p;
    public SparseArray<b.g.b.i.d> q;
    public b r;

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        public int C;
        public float D;
        public float E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public float N;
        public float O;
        public int P;
        public int Q;
        public int R;
        public boolean S;
        public boolean T;
        public String U;
        public boolean V;
        public boolean W;
        public boolean X;
        public boolean Y;
        public boolean Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f117a;
        public boolean a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f118b;
        public boolean b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f119c;
        public int c0;
        public int d;
        public int d0;
        public int e;
        public int e0;
        public int f;
        public int f0;
        public int g;
        public int g0;
        public int h;
        public int h0;
        public int i;
        public float i0;
        public int j;
        public int j0;
        public int k;
        public int k0;
        public int l;
        public float l0;
        public int m;
        public b.g.b.i.d m0;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        public static class C0004a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f120a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f120a = sparseIntArray;
                sparseIntArray.append(k.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f120a.append(k.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f120a.append(k.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f120a.append(k.ConstraintLayout_Layout_android_orientation, 1);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f120a.append(k.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f120a.append(k.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f120a.append(k.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f120a.append(k.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f120a.append(k.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f120a.append(k.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f120a.append(k.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f120a.append(k.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                f120a.append(k.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public a(int i, int i2) {
            super(i, i2);
            this.f117a = -1;
            this.f118b = -1;
            this.f119c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = null;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = 0.5f;
            this.m0 = new b.g.b.i.d();
        }

        public a(Context context, AttributeSet attributeSet) {
            String str;
            int i;
            super(context, attributeSet);
            this.f117a = -1;
            this.f118b = -1;
            this.f119c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = null;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = 0.5f;
            this.m0 = new b.g.b.i.d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                int i3 = C0004a.f120a.get(index);
                switch (i3) {
                    case 1:
                        this.R = typedArrayObtainStyledAttributes.getInt(index, this.R);
                        continue;
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 3:
                        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        continue;
                        break;
                    case 4:
                        float f = typedArrayObtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f;
                        if (f < 0.0f) {
                            this.o = (360.0f - f) % 360.0f;
                        } else {
                            continue;
                        }
                        break;
                    case 5:
                        this.f117a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f117a);
                        continue;
                        break;
                    case 6:
                        this.f118b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f118b);
                        continue;
                        break;
                    case 7:
                        this.f119c = typedArrayObtainStyledAttributes.getFloat(index, this.f119c);
                        continue;
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.d);
                        this.d = resourceId2;
                        if (resourceId2 == -1) {
                            this.d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                        this.e = resourceId3;
                        if (resourceId3 == -1) {
                            this.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f);
                        this.f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId6;
                        if (resourceId6 == -1) {
                            this.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.i);
                        this.i = resourceId7;
                        if (resourceId7 == -1) {
                            this.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                        break;
                    case 21:
                        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        continue;
                        break;
                    case 22:
                        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        continue;
                        break;
                    case 23:
                        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        continue;
                        break;
                    case 24:
                        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        continue;
                        break;
                    case 25:
                        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        continue;
                        break;
                    case 26:
                        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        continue;
                        break;
                    case 27:
                        this.S = typedArrayObtainStyledAttributes.getBoolean(index, this.S);
                        continue;
                        break;
                    case 28:
                        this.T = typedArrayObtainStyledAttributes.getBoolean(index, this.T);
                        continue;
                        break;
                    case 29:
                        this.z = typedArrayObtainStyledAttributes.getFloat(index, this.z);
                        continue;
                        break;
                    case 30:
                        this.A = typedArrayObtainStyledAttributes.getFloat(index, this.A);
                        continue;
                        break;
                    case 31:
                        int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.H = i4;
                        if (i4 == 1) {
                            str = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                        }
                        break;
                    case 32:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.I = i5;
                        if (i5 == 1) {
                            str = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                        }
                        break;
                    case 33:
                        try {
                            this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                        break;
                    case 35:
                        this.N = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.N));
                        this.H = 2;
                        continue;
                        break;
                    case 36:
                        try {
                            this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                        break;
                    case 38:
                        this.O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        continue;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String strSubstring = this.B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.C = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.C = 1;
                                        }
                                        i = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.B.substring(i);
                                        if (strSubstring2.length() > 0) {
                                            Float.parseFloat(strSubstring2);
                                        }
                                    } else {
                                        String strSubstring3 = this.B.substring(i, iIndexOf2);
                                        String strSubstring4 = this.B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                            try {
                                                float f2 = Float.parseFloat(strSubstring3);
                                                float f3 = Float.parseFloat(strSubstring4);
                                                if (f2 > 0.0f && f3 > 0.0f) {
                                                    if (this.C == 1) {
                                                        Math.abs(f3 / f2);
                                                    } else {
                                                        Math.abs(f2 / f3);
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.D = typedArrayObtainStyledAttributes.getFloat(index, this.D);
                                break;
                            case 46:
                                this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 47:
                                this.F = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.P = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                                break;
                            case 50:
                                this.Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 51:
                                this.U = typedArrayObtainStyledAttributes.getString(index);
                                continue;
                        }
                        break;
                }
                Log.e("ConstraintLayout", str);
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f117a = -1;
            this.f118b = -1;
            this.f119c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = null;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = 0.5f;
            this.m0 = new b.g.b.i.d();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.S) {
                this.V = false;
                if (this.H == 0) {
                    this.H = 1;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == 0 || i == -1) {
                this.V = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == 0 || i2 == -1) {
                this.W = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.f119c == -1.0f && this.f117a == -1 && this.f118b == -1) {
                return;
            }
            this.Y = true;
            this.V = true;
            this.W = true;
            if (!(this.m0 instanceof f)) {
                this.m0 = new f();
            }
            ((f) this.m0).E(this.R);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00d8  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instruction units count: 261
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }
    }

    public class b implements b.InterfaceC0023b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintLayout f121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f123c;
        public int d;
        public int e;
        public int f;
        public int g;

        public b(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
            this.f121a = constraintLayout2;
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0170 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0179  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0181  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x018c  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0197 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01ac  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x01da  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01e6  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x01fd  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0207  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0214  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x0219  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x022c  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0240  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x0244  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x024a  */
        /* JADX WARN: Removed duplicated region for block: B:172:0x0261  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0263  */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0268  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x026f  */
        /* JADX WARN: Removed duplicated region for block: B:183:0x0276  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x0278  */
        /* JADX WARN: Removed duplicated region for block: B:186:0x027b  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0168 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x016d  */
        @android.annotation.SuppressLint({"WrongCall"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(b.g.b.i.d r19, b.g.b.i.l.b.a r20) {
            /*
                Method dump skipped, instruction units count: 654
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.a(b.g.b.i.d, b.g.b.i.l.b$a):void");
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f115b = new SparseArray<>();
        this.f116c = new ArrayList<>(4);
        this.d = new e();
        this.e = 0;
        this.f = 0;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.j = 263;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = new HashMap<>();
        this.o = -1;
        this.p = -1;
        this.q = new SparseArray<>();
        b bVar = new b(this, this);
        this.r = bVar;
        e eVar = this.d;
        eVar.W = this;
        eVar.i0 = bVar;
        eVar.h0.f = bVar;
        this.f115b.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.ConstraintLayout_Layout, 0, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == k.ConstraintLayout_Layout_android_minWidth) {
                    this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == k.ConstraintLayout_Layout_android_minHeight) {
                    this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == k.ConstraintLayout_Layout_android_maxWidth) {
                    this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == k.ConstraintLayout_Layout_android_maxHeight) {
                    this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == k.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.j = typedArrayObtainStyledAttributes.getInt(index, this.j);
                } else if (index == k.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.l = new d(getContext(), this, resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.l = null;
                        }
                    }
                } else if (index == k.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        b.g.c.e eVar2 = new b.g.c.e();
                        this.k = eVar2;
                        eVar2.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.k = null;
                    }
                    this.m = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.d.J(this.j);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
    
        if (r15 == 6) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        if (r15 == 6) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0202  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x0333 -> B:170:0x0334). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r24, android.view.View r25, b.g.b.i.d r26, androidx.constraintlayout.widget.ConstraintLayout.a r27, android.util.SparseArray<b.g.b.i.d> r28) {
        /*
            Method dump skipped, instruction units count: 930
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a(boolean, android.view.View, b.g.b.i.d, androidx.constraintlayout.widget.ConstraintLayout$a, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public Object c(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.n;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.n.get(str);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public View d(int i) {
        return this.f115b.get(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<c> arrayList = this.f116c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.f116c.get(i).h();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public final b.g.b.i.d e(View view) {
        if (view == this) {
            return this.d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).m0;
    }

    public boolean f() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    @Override // android.view.View
    public void forceLayout() {
        this.i = true;
        this.o = -1;
        this.p = -1;
        super.forceLayout();
    }

    public void g(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.n == null) {
                this.n = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.n.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int getMaxHeight() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.g;
    }

    public int getMinHeight() {
        return this.f;
    }

    public int getMinWidth() {
        return this.e;
    }

    public int getOptimizationLevel() {
        return this.d.r0;
    }

    public final boolean h() {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        String str;
        int iD;
        int i3;
        boolean z4;
        boolean z5;
        int i4;
        int i5;
        String resourceEntryName;
        String resourceName;
        int id;
        b.g.b.i.d dVar;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            i = 1;
            if (i6 >= childCount) {
                z = false;
                break;
            }
            if (getChildAt(i6).isLayoutRequested()) {
                z = true;
                break;
            }
            i6++;
        }
        if (!z) {
            return z;
        }
        boolean zIsInEditMode = isInEditMode();
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            b.g.b.i.d dVarE = e(getChildAt(i7));
            if (dVarE != null) {
                dVarE.u();
            }
        }
        int i8 = -1;
        if (zIsInEditMode) {
            for (int i9 = 0; i9 < childCount2; i9++) {
                View childAt = getChildAt(i9);
                try {
                    resourceName = getResources().getResourceName(childAt.getId());
                    g(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    id = childAt.getId();
                } catch (Resources.NotFoundException unused) {
                }
                if (id != 0) {
                    View viewFindViewById = this.f115b.get(id);
                    if (viewFindViewById == null && (viewFindViewById = findViewById(id)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
                        onViewAdded(viewFindViewById);
                    }
                    if (viewFindViewById != this) {
                        dVar = viewFindViewById == null ? null : ((a) viewFindViewById.getLayoutParams()).m0;
                    }
                    dVar.Y = resourceName;
                }
                dVar = this.d;
                dVar.Y = resourceName;
            }
        }
        if (this.m != -1) {
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt2 = getChildAt(i10);
                if (childAt2.getId() == this.m && (childAt2 instanceof b.g.c.f)) {
                    this.k = ((b.g.c.f) childAt2).getConstraintSet();
                }
            }
        }
        b.g.c.e eVar = this.k;
        if (eVar != null) {
            int childCount3 = getChildCount();
            HashSet<Integer> hashSet = new HashSet(eVar.f673c.keySet());
            int i11 = 0;
            while (i11 < childCount3) {
                View childAt3 = getChildAt(i11);
                int id2 = childAt3.getId();
                if (!eVar.f673c.containsKey(Integer.valueOf(id2))) {
                    StringBuilder sbE = c.a.a.a.a.e("id unknown ");
                    try {
                        resourceEntryName = childAt3.getContext().getResources().getResourceEntryName(childAt3.getId());
                    } catch (Exception unused2) {
                        resourceEntryName = "UNKNOWN";
                    }
                    sbE.append(resourceEntryName);
                    Log.w("ConstraintSet", sbE.toString());
                } else {
                    if (eVar.f672b && id2 == i8) {
                        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                    }
                    if (id2 != i8) {
                        if (eVar.f673c.containsKey(Integer.valueOf(id2))) {
                            hashSet.remove(Integer.valueOf(id2));
                            e.a aVar = eVar.f673c.get(Integer.valueOf(id2));
                            if (childAt3 instanceof b.g.c.a) {
                                aVar.d.d0 = i;
                            }
                            int i12 = aVar.d.d0;
                            if (i12 != i8 && i12 == i) {
                                b.g.c.a aVar2 = (b.g.c.a) childAt3;
                                aVar2.setId(id2);
                                aVar2.setType(aVar.d.b0);
                                aVar2.setMargin(aVar.d.c0);
                                aVar2.setAllowsGoneWidget(aVar.d.j0);
                                e.b bVar = aVar.d;
                                int[] iArr = bVar.e0;
                                if (iArr != null) {
                                    aVar2.setReferencedIds(iArr);
                                } else {
                                    String str2 = bVar.f0;
                                    if (str2 != null) {
                                        bVar.e0 = eVar.c(aVar2, str2);
                                        aVar2.setReferencedIds(aVar.d.e0);
                                    }
                                }
                            }
                            a aVar3 = (a) childAt3.getLayoutParams();
                            aVar3.a();
                            aVar.a(aVar3);
                            HashMap<String, b.g.c.b> map = aVar.f;
                            i3 = childCount3;
                            Class<?> cls = childAt3.getClass();
                            for (String str3 : map.keySet()) {
                                boolean z6 = z;
                                b.g.c.b bVar2 = map.get(str3);
                                HashMap<String, b.g.c.b> map2 = map;
                                String strC = c.a.a.a.a.c("set", str3);
                                boolean z7 = zIsInEditMode;
                                try {
                                    switch (bVar2.f657b.ordinal()) {
                                        case 0:
                                            i5 = childCount2;
                                            cls.getMethod(strC, Integer.TYPE).invoke(childAt3, Integer.valueOf(bVar2.f658c));
                                            break;
                                        case 1:
                                            i5 = childCount2;
                                            cls.getMethod(strC, Float.TYPE).invoke(childAt3, Float.valueOf(bVar2.d));
                                            break;
                                        case 2:
                                            i5 = childCount2;
                                            cls.getMethod(strC, Integer.TYPE).invoke(childAt3, Integer.valueOf(bVar2.g));
                                            break;
                                        case 3:
                                            i5 = childCount2;
                                            Method method = cls.getMethod(strC, Drawable.class);
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(bVar2.g);
                                            method.invoke(childAt3, colorDrawable);
                                            break;
                                        case 4:
                                            i5 = childCount2;
                                            cls.getMethod(strC, CharSequence.class).invoke(childAt3, bVar2.e);
                                            break;
                                        case 5:
                                            i5 = childCount2;
                                            cls.getMethod(strC, Boolean.TYPE).invoke(childAt3, Boolean.valueOf(bVar2.f));
                                            break;
                                        case 6:
                                            i5 = childCount2;
                                            try {
                                                cls.getMethod(strC, Float.TYPE).invoke(childAt3, Float.valueOf(bVar2.d));
                                            } catch (IllegalAccessException e) {
                                                e = e;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str3 + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                            } catch (NoSuchMethodException e2) {
                                                e = e2;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str3 + "\" not found on " + cls.getName());
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(cls.getName());
                                                sb.append(" must have a method ");
                                                sb.append(strC);
                                                Log.e("TransitionLayout", sb.toString());
                                            } catch (InvocationTargetException e3) {
                                                e = e3;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str3 + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                            }
                                            break;
                                        default:
                                            i5 = childCount2;
                                            break;
                                    }
                                } catch (IllegalAccessException e4) {
                                    e = e4;
                                    i5 = childCount2;
                                } catch (NoSuchMethodException e5) {
                                    e = e5;
                                    i5 = childCount2;
                                } catch (InvocationTargetException e6) {
                                    e = e6;
                                    i5 = childCount2;
                                }
                                z = z6;
                                map = map2;
                                zIsInEditMode = z7;
                                childCount2 = i5;
                            }
                            z4 = z;
                            z5 = zIsInEditMode;
                            i4 = childCount2;
                            childAt3.setLayoutParams(aVar3);
                            e.d dVar2 = aVar.f675b;
                            if (dVar2.f685c == 0) {
                                childAt3.setVisibility(dVar2.f684b);
                            }
                            childAt3.setAlpha(aVar.f675b.d);
                            childAt3.setRotation(aVar.e.f687b);
                            childAt3.setRotationX(aVar.e.f688c);
                            childAt3.setRotationY(aVar.e.d);
                            childAt3.setScaleX(aVar.e.e);
                            childAt3.setScaleY(aVar.e.f);
                            if (!Float.isNaN(aVar.e.g)) {
                                childAt3.setPivotX(aVar.e.g);
                            }
                            if (!Float.isNaN(aVar.e.h)) {
                                childAt3.setPivotY(aVar.e.h);
                            }
                            childAt3.setTranslationX(aVar.e.i);
                            childAt3.setTranslationY(aVar.e.j);
                            childAt3.setTranslationZ(aVar.e.k);
                            e.C0024e c0024e = aVar.e;
                            if (c0024e.l) {
                                childAt3.setElevation(c0024e.m);
                            }
                        } else {
                            i3 = childCount3;
                            z4 = z;
                            z5 = zIsInEditMode;
                            i4 = childCount2;
                            Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                        }
                    }
                    i11++;
                    i8 = -1;
                    i = 1;
                    childCount3 = i3;
                    z = z4;
                    zIsInEditMode = z5;
                    childCount2 = i4;
                }
                i3 = childCount3;
                z4 = z;
                z5 = zIsInEditMode;
                i4 = childCount2;
                i11++;
                i8 = -1;
                i = 1;
                childCount3 = i3;
                z = z4;
                zIsInEditMode = z5;
                childCount2 = i4;
            }
            z2 = z;
            z3 = zIsInEditMode;
            i2 = childCount2;
            for (Integer num : hashSet) {
                e.a aVar4 = eVar.f673c.get(num);
                int i13 = aVar4.d.d0;
                if (i13 != -1 && i13 == 1) {
                    b.g.c.a aVar5 = new b.g.c.a(getContext());
                    aVar5.setId(num.intValue());
                    e.b bVar3 = aVar4.d;
                    int[] iArr2 = bVar3.e0;
                    if (iArr2 != null) {
                        aVar5.setReferencedIds(iArr2);
                    } else {
                        String str4 = bVar3.f0;
                        if (str4 != null) {
                            bVar3.e0 = eVar.c(aVar5, str4);
                            aVar5.setReferencedIds(aVar4.d.e0);
                        }
                    }
                    aVar5.setType(aVar4.d.b0);
                    aVar5.setMargin(aVar4.d.c0);
                    a aVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
                    aVar5.i();
                    aVar4.a(aVarGenerateDefaultLayoutParams);
                    addView(aVar5, aVarGenerateDefaultLayoutParams);
                }
                if (aVar4.d.f677a) {
                    View hVar = new h(getContext());
                    hVar.setId(num.intValue());
                    a aVarGenerateDefaultLayoutParams2 = generateDefaultLayoutParams();
                    aVar4.a(aVarGenerateDefaultLayoutParams2);
                    addView(hVar, aVarGenerateDefaultLayoutParams2);
                }
            }
        } else {
            z2 = z;
            z3 = zIsInEditMode;
            i2 = childCount2;
        }
        this.d.f0.clear();
        int size = this.f116c.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                c cVar = this.f116c.get(i14);
                if (cVar.isInEditMode()) {
                    cVar.setIds(cVar.g);
                }
                g gVar = cVar.e;
                if (gVar != null) {
                    b.g.b.i.h hVar2 = (b.g.b.i.h) gVar;
                    hVar2.g0 = 0;
                    Arrays.fill(hVar2.f0, (Object) null);
                    for (int i15 = 0; i15 < cVar.f662c; i15++) {
                        int i16 = cVar.f661b[i15];
                        View viewD = d(i16);
                        if (viewD == null && (iD = cVar.d(this, (str = cVar.h.get(Integer.valueOf(i16))))) != 0) {
                            cVar.f661b[i15] = iD;
                            cVar.h.put(Integer.valueOf(iD), str);
                            viewD = d(iD);
                        }
                        if (viewD != null) {
                            g gVar2 = cVar.e;
                            b.g.b.i.d dVarE2 = e(viewD);
                            b.g.b.i.h hVar3 = (b.g.b.i.h) gVar2;
                            if (hVar3 == null) {
                                throw null;
                            }
                            if (dVarE2 != hVar3 && dVarE2 != null) {
                                int i17 = hVar3.g0 + 1;
                                b.g.b.i.d[] dVarArr = hVar3.f0;
                                if (i17 > dVarArr.length) {
                                    hVar3.f0 = (b.g.b.i.d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
                                }
                                b.g.b.i.d[] dVarArr2 = hVar3.f0;
                                int i18 = hVar3.g0;
                                dVarArr2[i18] = dVarE2;
                                hVar3.g0 = i18 + 1;
                            }
                        }
                    }
                    cVar.e.a(this.d);
                }
            }
        }
        int i19 = i2;
        for (int i20 = 0; i20 < i19; i20++) {
            View childAt4 = getChildAt(i20);
            if (childAt4 instanceof i) {
                i iVar = (i) childAt4;
                if (iVar.f690b == -1 && !iVar.isInEditMode()) {
                    iVar.setVisibility(iVar.d);
                }
                View viewFindViewById2 = findViewById(iVar.f690b);
                iVar.f691c = viewFindViewById2;
                if (viewFindViewById2 != null) {
                    ((a) viewFindViewById2.getLayoutParams()).a0 = true;
                    iVar.f691c.setVisibility(0);
                    iVar.setVisibility(0);
                }
            }
        }
        this.q.clear();
        this.q.put(0, this.d);
        this.q.put(getId(), this.d);
        for (int i21 = 0; i21 < i19; i21++) {
            View childAt5 = getChildAt(i21);
            this.q.put(childAt5.getId(), e(childAt5));
        }
        for (int i22 = 0; i22 < i19; i22++) {
            View childAt6 = getChildAt(i22);
            b.g.b.i.d dVarE3 = e(childAt6);
            if (dVarE3 != null) {
                a aVar6 = (a) childAt6.getLayoutParams();
                b.g.b.i.e eVar2 = this.d;
                eVar2.f0.add(dVarE3);
                b.g.b.i.d dVar3 = dVarE3.K;
                if (dVar3 != null) {
                    ((b.g.b.i.k) dVar3).f0.remove(dVarE3);
                    dVarE3.K = null;
                }
                dVarE3.K = eVar2;
                a(z3, childAt6, dVarE3, aVar6, this.q);
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            b.g.b.i.d dVar = aVar.m0;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || aVar.b0 || zIsInEditMode) && !aVar.a0) {
                int iP = dVar.p();
                int iQ = dVar.q();
                int iO = dVar.o() + iP;
                int i6 = dVar.i() + iQ;
                childAt.layout(iP, iQ, iO, i6);
                if ((childAt instanceof i) && (content = ((i) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iP, iQ, iO, i6);
                }
            }
        }
        int size = this.f116c.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f116c.get(i7).f();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0187  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 1943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        b.g.b.i.d dVarE = e(view);
        if ((view instanceof h) && !(dVarE instanceof f)) {
            a aVar = (a) view.getLayoutParams();
            f fVar = new f();
            aVar.m0 = fVar;
            aVar.Y = true;
            fVar.E(aVar.R);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.i();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.f116c.contains(cVar)) {
                this.f116c.add(cVar);
            }
        }
        this.f115b.put(view.getId(), view);
        this.i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f115b.remove(view.getId());
        b.g.b.i.d dVarE = e(view);
        this.d.f0.remove(dVarE);
        dVarE.K = null;
        this.f116c.remove(view);
        this.i = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.i = true;
        this.o = -1;
        this.p = -1;
        super.requestLayout();
    }

    public void setConstraintSet(b.g.c.e eVar) {
        this.k = eVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f115b.remove(getId());
        super.setId(i);
        this.f115b.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.e) {
            return;
        }
        this.e = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(b.g.c.g gVar) {
        d dVar = this.l;
        if (dVar != null && dVar == null) {
            throw null;
        }
    }

    public void setOptimizationLevel(int i) {
        this.j = i;
        this.d.r0 = i;
        b.g.b.d.r = b.g.b.i.i.a(i, 256);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
