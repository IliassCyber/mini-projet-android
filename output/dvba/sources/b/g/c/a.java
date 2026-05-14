package b.g.c;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    public int i;
    public int j;
    public b.g.b.i.a k;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // b.g.c.c
    public void e(AttributeSet attributeSet) {
        super.e(null);
        b.g.b.i.a aVar = new b.g.b.i.a();
        this.k = aVar;
        this.e = aVar;
        i();
    }

    public int getMargin() {
        return this.k.j0;
    }

    public int getType() {
        return this.i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.k.i0 = z;
    }

    public void setDpMargin(int i) {
        this.k.j0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.k.j0 = i;
    }

    public void setType(int i) {
        this.i = i;
    }
}
