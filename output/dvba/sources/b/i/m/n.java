package b.i.m;

import android.text.TextUtils;
import android.view.View;
import b.i.m.l;

/* JADX INFO: loaded from: classes.dex */
public class n extends l.b<CharSequence> {
    public n(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    @Override // b.i.m.l.b
    public CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    @Override // b.i.m.l.b
    public void c(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    @Override // b.i.m.l.b
    public boolean e(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
