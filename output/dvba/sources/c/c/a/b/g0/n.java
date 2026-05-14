package c.c.a.b.g0;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextInputLayout f1611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CheckableImageButton f1613c;

    public n(TextInputLayout textInputLayout) {
        this.f1611a = textInputLayout;
        this.f1612b = textInputLayout.getContext();
        this.f1613c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i) {
        return true;
    }

    public boolean c() {
        return false;
    }
}
