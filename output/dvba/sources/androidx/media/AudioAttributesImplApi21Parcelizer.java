package androidx.media;

import android.media.AudioAttributes;
import b.q.b;
import b.v.a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static b read(a aVar) {
        b bVar = new b();
        bVar.f1009a = (AudioAttributes) aVar.j(bVar.f1009a, 1);
        bVar.f1010b = aVar.i(bVar.f1010b, 2);
        return bVar;
    }

    public static void write(b bVar, a aVar) {
        if (aVar == null) {
            throw null;
        }
        aVar.n(bVar.f1009a, 1);
        aVar.m(bVar.f1010b, 2);
    }
}
