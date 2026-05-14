package androidx.media;

import b.v.a;
import b.v.c;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        c cVarK = audioAttributesCompat.f161a;
        if (aVar.h(1)) {
            cVarK = aVar.k();
        }
        audioAttributesCompat.f161a = (b.q.a) cVarK;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, a aVar) {
        if (aVar == null) {
            throw null;
        }
        b.q.a aVar2 = audioAttributesCompat.f161a;
        aVar.l(1);
        aVar.o(aVar2);
    }
}
