package b.i.l;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a extends Writer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StringBuilder f813c = new StringBuilder(128);

    public a(String str) {
        this.f812b = str;
    }

    public final void a() {
        if (this.f813c.length() > 0) {
            Log.d(this.f812b, this.f813c.toString());
            StringBuilder sb = this.f813c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                a();
            } else {
                this.f813c.append(c2);
            }
        }
    }
}
