package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f137c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public String i;

    public IconCompat() {
        this.f135a = -1;
        this.f137c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = j;
        this.i = null;
    }

    public IconCompat(int i) {
        this.f135a = -1;
        this.f137c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = j;
        this.i = null;
        this.f135a = i;
    }

    public static Bitmap a(Bitmap bitmap, boolean z) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f = iMin;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2, (-(bitmap.getHeight() - iMin)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(Resources resources, String str, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.e = i;
        iconCompat.f136b = str;
        return iconCompat;
    }

    public int c() {
        int i;
        if (this.f135a != -1 || (i = Build.VERSION.SDK_INT) < 23) {
            if (this.f135a == 2) {
                return this.e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        Icon icon = (Icon) this.f136b;
        if (i >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        }
    }

    public String d() {
        int i;
        if (this.f135a != -1 || (i = Build.VERSION.SDK_INT) < 23) {
            if (this.f135a == 2) {
                return ((String) this.f136b).split(":", -1)[0];
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        Icon icon = (Icon) this.f136b;
        if (i >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        }
    }

    public Uri e() {
        int i;
        if (this.f135a == -1 && (i = Build.VERSION.SDK_INT) >= 23) {
            Icon icon = (Icon) this.f136b;
            if (i >= 28) {
                return icon.getUri();
            }
            try {
                return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                Log.e("IconCompat", "Unable to get icon uri", e);
                return null;
            }
        }
        int i2 = this.f135a;
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f136b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.drawable.Icon f() {
        /*
            r3 = this;
            int r0 = r3.f135a
            r1 = 0
            r2 = 26
            switch(r0) {
                case -1: goto L77;
                case 0: goto L8;
                case 1: goto L5e;
                case 2: goto L53;
                case 3: goto L46;
                case 4: goto L3d;
                case 5: goto L27;
                case 6: goto L10;
                default: goto L8;
            }
        L8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unknown type"
            r0.<init>(r1)
            throw r0
        L10:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
            java.lang.StringBuilder r1 = c.a.a.a.a.e(r1)
            android.net.Uri r2 = r3.e()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L27:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L34
            java.lang.Object r0 = r3.f136b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithAdaptiveBitmap(r0)
            goto L66
        L34:
            java.lang.Object r0 = r3.f136b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            android.graphics.Bitmap r0 = a(r0, r1)
            goto L62
        L3d:
            java.lang.Object r0 = r3.f136b
            java.lang.String r0 = (java.lang.String) r0
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithContentUri(r0)
            goto L66
        L46:
            java.lang.Object r0 = r3.f136b
            byte[] r0 = (byte[]) r0
            int r1 = r3.e
            int r2 = r3.f
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithData(r0, r1, r2)
            goto L66
        L53:
            java.lang.String r0 = r3.d()
            int r1 = r3.e
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithResource(r0, r1)
            goto L66
        L5e:
            java.lang.Object r0 = r3.f136b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
        L62:
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithBitmap(r0)
        L66:
            android.content.res.ColorStateList r1 = r3.g
            if (r1 == 0) goto L6d
            r0.setTintList(r1)
        L6d:
            android.graphics.PorterDuff$Mode r1 = r3.h
            android.graphics.PorterDuff$Mode r2 = androidx.core.graphics.drawable.IconCompat.j
            if (r1 == r2) goto L7b
            r0.setTintMode(r1)
            goto L7b
        L77:
            java.lang.Object r0 = r3.f136b
            android.graphics.drawable.Icon r0 = (android.graphics.drawable.Icon) r0
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.f():android.graphics.drawable.Icon");
    }

    public String toString() {
        String str;
        int height;
        if (this.f135a == -1) {
            return String.valueOf(this.f136b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f135a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f135a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f136b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f136b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(d());
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    height = this.f;
                    sb.append(height);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f136b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != j) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }
}
