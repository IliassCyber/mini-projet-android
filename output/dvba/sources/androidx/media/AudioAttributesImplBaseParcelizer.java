package androidx.media;

import b.q.c;
import b.v.a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static c read(a aVar) {
        c cVar = new c();
        cVar.f1011a = aVar.i(cVar.f1011a, 1);
        cVar.f1012b = aVar.i(cVar.f1012b, 2);
        cVar.f1013c = aVar.i(cVar.f1013c, 3);
        cVar.d = aVar.i(cVar.d, 4);
        return cVar;
    }

    public static void write(c cVar, a aVar) {
        if (aVar == null) {
            throw null;
        }
        aVar.m(cVar.f1011a, 1);
        aVar.m(cVar.f1012b, 2);
        aVar.m(cVar.f1013c, 3);
        aVar.m(cVar.d, 4);
    }
}
