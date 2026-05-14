package c.c.a.b.c0;

import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final int[] h = new int[3];
    public static final float[] i = {0.0f, 0.5f, 1.0f};
    public static final int[] j = new int[4];
    public static final float[] k = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f1548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f1549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f1550c;
    public int d;
    public int e;
    public int f;
    public final Path g = new Path();

    public a() {
        a(-16777216);
        Paint paint = new Paint(4);
        this.f1549b = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f1548a = paint2;
        paint2.setColor(this.d);
        this.f1550c = new Paint(this.f1549b);
    }

    public void a(int i2) {
        this.d = b.i.f.a.c(i2, 68);
        this.e = b.i.f.a.c(i2, 20);
        this.f = b.i.f.a.c(i2, 0);
    }
}
