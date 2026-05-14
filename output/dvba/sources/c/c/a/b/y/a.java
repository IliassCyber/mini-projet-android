package c.c.a.b.y;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
public class a extends b.i.m.a {
    public final /* synthetic */ CheckableImageButton d;

    public a(CheckableImageButton checkableImageButton) {
        this.d = checkableImageButton;
    }

    @Override // b.i.m.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f820a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.d.isChecked());
    }

    @Override // b.i.m.a
    public void d(View view, b.i.m.v.b bVar) {
        this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
        bVar.f864a.setCheckable(this.d.e);
        bVar.f864a.setChecked(this.d.isChecked());
    }
}
