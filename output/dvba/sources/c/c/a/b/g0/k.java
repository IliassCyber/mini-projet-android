package c.c.a.b.g0;

import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class k implements AutoCompleteTextView.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1608a;

    public k(h hVar) {
        this.f1608a = hVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        h hVar = this.f1608a;
        hVar.g = true;
        hVar.i = System.currentTimeMillis();
        h.e(this.f1608a, false);
    }
}
