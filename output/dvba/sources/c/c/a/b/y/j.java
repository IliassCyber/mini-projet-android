package c.c.a.b.y;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class j extends ImageButton {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1761b;

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f1761b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f1761b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f1761b = i;
    }
}
