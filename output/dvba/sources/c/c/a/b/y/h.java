package c.c.a.b.y;

import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1756c;
    public WeakReference<b> e;
    public c.c.a.b.a0.b f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f1754a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.a.b.a0.d f1755b = new a();
    public boolean d = true;

    public class a extends c.c.a.b.a0.d {
        public a() {
        }

        @Override // c.c.a.b.a0.d
        public void a(int i) {
            h hVar = h.this;
            hVar.d = true;
            b bVar = hVar.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c.c.a.b.a0.d
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            h hVar = h.this;
            hVar.d = true;
            b bVar = hVar.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        this.e = new WeakReference<>(null);
        this.e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.d) {
            return this.f1756c;
        }
        float fMeasureText = str == null ? 0.0f : this.f1754a.measureText((CharSequence) str, 0, str.length());
        this.f1756c = fMeasureText;
        this.d = false;
        return fMeasureText;
    }
}
