package c.c.a.b.u;

import android.view.View;
import c.c.a.b.u.f;

/* JADX INFO: loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f1703b;

    public j(f fVar) {
        this.f1703b = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar = this.f1703b;
        f.e eVar = f.e.DAY;
        f.e eVar2 = f.e.YEAR;
        f.e eVar3 = fVar.b0;
        if (eVar3 == eVar2) {
            fVar.d0(eVar);
        } else if (eVar3 == eVar) {
            fVar.d0(eVar2);
        }
    }
}
