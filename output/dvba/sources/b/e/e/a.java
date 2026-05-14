package b.e.e;

import androidx.cardview.widget.CardView;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {
    public final d a(b bVar) {
        return (d) ((CardView.a) bVar).f113a;
    }

    public float b(b bVar) {
        return a(bVar).e;
    }

    public float c(b bVar) {
        return a(bVar).f567a;
    }

    public void d(b bVar, float f) {
        d dVarA = a(bVar);
        CardView.a aVar = (CardView.a) bVar;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean zA = aVar.a();
        if (f != dVarA.e || dVarA.f != useCompatPadding || dVarA.g != zA) {
            dVarA.e = f;
            dVarA.f = useCompatPadding;
            dVarA.g = zA;
            dVarA.c(null);
            dVarA.invalidateSelf();
        }
        if (!CardView.this.getUseCompatPadding()) {
            aVar.b(0, 0, 0, 0);
            return;
        }
        float f2 = a(bVar).e;
        float f3 = a(bVar).f567a;
        int iCeil = (int) Math.ceil(e.a(f2, f3, aVar.a()));
        int iCeil2 = (int) Math.ceil(e.b(f2, f3, aVar.a()));
        aVar.b(iCeil, iCeil2, iCeil, iCeil2);
    }
}
