package c.c.a.b.a0;

import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextPaint f1542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f1544c;

    public c(b bVar, TextPaint textPaint, d dVar) {
        this.f1544c = bVar;
        this.f1542a = textPaint;
        this.f1543b = dVar;
    }

    @Override // c.c.a.b.a0.d
    public void a(int i) {
        this.f1543b.a(i);
    }

    @Override // c.c.a.b.a0.d
    public void b(Typeface typeface, boolean z) {
        this.f1544c.d(this.f1542a, typeface);
        this.f1543b.b(typeface, z);
    }
}
