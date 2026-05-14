package c.c.a.b.g0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class j implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f1607b;

    public j(h hVar) {
        this.f1607b = hVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.f1607b.f1611a.setEndIconActivated(z);
        if (z) {
            return;
        }
        h.e(this.f1607b, false);
        this.f1607b.g = false;
    }
}
