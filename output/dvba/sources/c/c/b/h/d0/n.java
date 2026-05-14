package c.c.b.h.d0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.util.Base64;
import c.c.a.a.f.c.n1;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.c.a.a.f.c.n<String> f1849a = c.c.a.a.f.c.n.g("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f1850b = new n();

    public static void a(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.f1952c);
        editorEdit.putString("statusMessage", status.d);
        editorEdit.putLong("timestamp", System.currentTimeMillis());
        editorEdit.commit();
    }

    public static void b(Context context, n1 n1Var, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        Parcel parcelObtain = Parcel.obtain();
        n1Var.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        editorEdit.putString("verifyAssertionRequest", bArrMarshall == null ? null : Base64.encodeToString(bArrMarshall, 10));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong("timestamp", System.currentTimeMillis());
        editorEdit.commit();
    }

    public static void c(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        c.c.a.a.f.c.n<String> nVar = f1849a;
        int size = nVar.size();
        int i = 0;
        while (i < size) {
            String str = nVar.get(i);
            i++;
            editorEdit.remove(str);
        }
        editorEdit.commit();
    }
}
