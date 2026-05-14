package c.c.a.b.g0;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class i implements View.OnTouchListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f1605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f1606c;

    public i(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.f1606c = hVar;
        this.f1605b = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f1606c.h()) {
                this.f1606c.g = false;
            }
            h.f(this.f1606c, this.f1605b);
            view.performClick();
        }
        return false;
    }
}
