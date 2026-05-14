package androidx.core.app;

import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import b.v.a;
import b.v.b;
import b.v.c;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarK = remoteActionCompat.f132a;
        if (aVar.h(1)) {
            cVarK = aVar.k();
        }
        remoteActionCompat.f132a = (IconCompat) cVarK;
        remoteActionCompat.f133b = aVar.g(remoteActionCompat.f133b, 2);
        remoteActionCompat.f134c = aVar.g(remoteActionCompat.f134c, 3);
        remoteActionCompat.d = (PendingIntent) aVar.j(remoteActionCompat.d, 4);
        remoteActionCompat.e = aVar.f(remoteActionCompat.e, 5);
        remoteActionCompat.f = aVar.f(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        if (aVar == null) {
            throw null;
        }
        IconCompat iconCompat = remoteActionCompat.f132a;
        aVar.l(1);
        aVar.o(iconCompat);
        CharSequence charSequence = remoteActionCompat.f133b;
        aVar.l(2);
        b bVar = (b) aVar;
        TextUtils.writeToParcel(charSequence, bVar.e, 0);
        CharSequence charSequence2 = remoteActionCompat.f134c;
        aVar.l(3);
        TextUtils.writeToParcel(charSequence2, bVar.e, 0);
        aVar.n(remoteActionCompat.d, 4);
        boolean z = remoteActionCompat.e;
        aVar.l(5);
        bVar.e.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f;
        aVar.l(6);
        bVar.e.writeInt(z2 ? 1 : 0);
    }
}
