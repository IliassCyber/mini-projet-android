package b.i.f.k;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class e extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f759c;
    public PorterDuff.Mode d;

    public e(e eVar) {
        this.f759c = null;
        this.d = c.h;
        if (eVar != null) {
            this.f757a = eVar.f757a;
            this.f758b = eVar.f758b;
            this.f759c = eVar.f759c;
            this.d = eVar.d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f757a;
        Drawable.ConstantState constantState = this.f758b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new d(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new d(this, resources);
    }
}
