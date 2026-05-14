package b.i.m;

import android.view.View;
import b.i.m.l;

/* JADX INFO: loaded from: classes.dex */
public class m extends l.b<Boolean> {
    public m(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // b.i.m.l.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }

    @Override // b.i.m.l.b
    public void c(View view, Boolean bool) {
        view.setScreenReaderFocusable(bool.booleanValue());
    }

    @Override // b.i.m.l.b
    public boolean e(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
