package c.c.a.a.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.c.a.a.c.l.q;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f1275c = new ReentrantLock();

    @GuardedBy("sLk")
    public static a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f1276a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("mLk")
    public final SharedPreferences f1277b;

    public a(Context context) {
        this.f1277b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        q.f(context);
        f1275c.lock();
        try {
            if (d == null) {
                d = new a(context.getApplicationContext());
            }
            return d;
        } finally {
            f1275c.unlock();
        }
    }

    @Nullable
    public GoogleSignInAccount b() {
        String strC = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 20);
        sb.append("googleSignInAccount");
        sb.append(":");
        sb.append(strC);
        String strC2 = c(sb.toString());
        if (strC2 == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.i(strC2);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    public final String c(String str) {
        this.f1276a.lock();
        try {
            return this.f1277b.getString(str, null);
        } finally {
            this.f1276a.unlock();
        }
    }
}
