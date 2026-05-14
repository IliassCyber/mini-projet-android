package b.i.n;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f880a;

    static {
        f880a = Build.VERSION.SDK_INT >= 27;
    }
}
