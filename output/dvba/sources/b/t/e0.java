package b.t;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public class e0 implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f1128a;

    public e0(View view) {
        this.f1128a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof e0) && ((e0) obj).f1128a.equals(this.f1128a);
    }

    public int hashCode() {
        return this.f1128a.hashCode();
    }
}
