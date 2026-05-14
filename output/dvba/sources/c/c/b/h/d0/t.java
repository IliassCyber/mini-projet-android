package c.c.b.h.d0;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f1860a;

    static {
        HashMap map = new HashMap();
        f1860a = map;
        map.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        f1860a.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        f1860a.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        f1860a.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        f1860a.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static void a(Intent intent, Status status) {
        Parcel parcelObtain = Parcel.obtain();
        status.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        intent.putExtra("com.google.firebase.auth.internal.STATUS", bArrMarshall);
    }

    public static boolean b(Intent intent) {
        c.c.a.a.c.l.q.f(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }
}
