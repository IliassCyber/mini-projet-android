package b.i.m.v;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f863c;
    public final int d;

    public a(int i, b bVar, int i2) {
        this.f862b = i;
        this.f863c = bVar;
        this.d = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f862b);
        b bVar = this.f863c;
        bVar.f864a.performAction(this.d, bundle);
    }
}
