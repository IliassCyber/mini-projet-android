package b.i.d;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f721a = new Object();

    public static Bundle a(e eVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatA = eVar.a();
        bundle.putInt("icon", iconCompatA != null ? iconCompatA.c() : 0);
        bundle.putCharSequence("title", eVar.j);
        bundle.putParcelable("actionIntent", eVar.k);
        Bundle bundle2 = eVar.f709a != null ? new Bundle(eVar.f709a) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", eVar.e);
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", b(eVar.f711c));
        bundle.putBoolean("showsUserInterface", eVar.f);
        bundle.putInt("semanticAction", eVar.g);
        return bundle;
    }

    public static Bundle[] b(k[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[kVarArr.length];
        if (kVarArr.length <= 0) {
            return bundleArr;
        }
        k kVar = kVarArr[0];
        new Bundle();
        throw null;
    }
}
