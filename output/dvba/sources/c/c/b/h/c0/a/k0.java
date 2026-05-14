package c.c.b.h.c0.a;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends c.c.a.a.c.l.g<p0> implements l0 {
    public static c.c.a.a.c.m.a z = new c.c.a.a.c.m.a("FirebaseAuth", "FirebaseAuth:");
    public final Context x;
    public final t0 y;

    public k0(Context context, Looper looper, c.c.a.a.c.l.c cVar, t0 t0Var, c.c.a.a.c.k.k.c cVar2, c.c.a.a.c.k.k.h hVar) {
        super(context, looper, 112, cVar, cVar2, hVar);
        c.c.a.a.c.l.q.f(context);
        this.x = context;
        this.y = t0Var;
    }

    @Override // c.c.b.h.c0.a.l0
    public final /* synthetic */ p0 a() {
        return (p0) super.s();
    }

    @Override // c.c.a.a.c.l.b, c.c.a.a.c.k.a.f
    public final boolean l() {
        return DynamiteModule.a(this.x, "com.google.firebase.auth") == 0;
    }

    @Override // c.c.a.a.c.l.g, c.c.a.a.c.k.a.f
    public final int o() {
        return 12451000;
    }

    @Override // c.c.a.a.c.l.b
    public final /* synthetic */ IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        return iInterfaceQueryLocalInterface instanceof p0 ? (p0) iInterfaceQueryLocalInterface : new q0(iBinder);
    }

    @Override // c.c.a.a.c.l.b
    public final c.c.a.a.c.c[] q() {
        return c.c.a.a.f.c.r0.d;
    }

    @Override // c.c.a.a.c.l.b
    public final Bundle r() {
        String str;
        Bundle bundle = new Bundle();
        t0 t0Var = this.y;
        if (t0Var != null) {
            bundle.putString("com.google.firebase.auth.API_KEY", t0Var.f1814c);
        }
        c.c.a.a.c.l.o oVar = c.c.a.a.c.l.o.f1395c;
        String property = null;
        if (oVar == null) {
            throw null;
        }
        c.c.a.a.c.l.q.e("firebase-auth", "Please provide a valid libraryName");
        if (oVar.f1396a.containsKey("firebase-auth")) {
            str = oVar.f1396a.get("firebase-auth");
        } else {
            Properties properties = new Properties();
            try {
                InputStream resourceAsStream = c.c.a.a.c.l.o.class.getResourceAsStream(String.format("/%s.properties", "firebase-auth"));
                if (resourceAsStream != null) {
                    properties.load(resourceAsStream);
                    property = properties.getProperty("version", null);
                    c.c.a.a.c.l.i iVar = c.c.a.a.c.l.o.f1394b;
                    StringBuilder sb = new StringBuilder(25 + String.valueOf(property).length());
                    sb.append("firebase-auth");
                    sb.append(" version is ");
                    sb.append(property);
                    String string = sb.toString();
                    if (iVar.a(2)) {
                        String str2 = iVar.f1387b;
                        if (str2 != null) {
                            string = str2.concat(string);
                        }
                        Log.v("LibraryVersion", string);
                    }
                } else {
                    c.c.a.a.c.l.i iVar2 = c.c.a.a.c.l.o.f1394b;
                    String strConcat = "Failed to get app version for libraryName: ".concat("firebase-auth");
                    if (iVar2.a(6)) {
                        String str3 = iVar2.f1387b;
                        if (str3 != null) {
                            strConcat = str3.concat(strConcat);
                        }
                        Log.e("LibraryVersion", strConcat);
                    }
                }
            } catch (IOException e) {
                c.c.a.a.c.l.i iVar3 = c.c.a.a.c.l.o.f1394b;
                String strConcat2 = "Failed to get app version for libraryName: ".concat("firebase-auth");
                if (iVar3.a(6)) {
                    String str4 = iVar3.f1387b;
                    if (str4 != null) {
                        strConcat2 = str4.concat(strConcat2);
                    }
                    Log.e("LibraryVersion", strConcat2, e);
                }
            }
            if (property == null) {
                c.c.a.a.c.l.i iVar4 = c.c.a.a.c.l.o.f1394b;
                if (iVar4.a(3)) {
                    String str5 = iVar4.f1387b;
                    Log.d("LibraryVersion", str5 != null ? str5.concat(".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used") : ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
                }
                property = "UNKNOWN";
            }
            oVar.f1396a.put("firebase-auth", property);
            str = property;
        }
        if (TextUtils.isEmpty(str) || str.equals("UNKNOWN")) {
            str = "-1";
        }
        bundle.putString("com.google.firebase.auth.LIBRARY_VERSION", str);
        return bundle;
    }

    @Override // c.c.a.a.c.l.b
    public final String t() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    @Override // c.c.a.a.c.l.b
    public final String u() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    @Override // c.c.a.a.c.l.b
    public final String v() {
        if (this.y.f1782b) {
            c.c.a.a.c.m.a aVar = z;
            Log.i(aVar.f1410a, aVar.a("Preparing to create service connection to fallback implementation", new Object[0]));
            return this.x.getPackageName();
        }
        c.c.a.a.c.m.a aVar2 = z;
        Log.i(aVar2.f1410a, aVar2.a("Preparing to create service connection to gms implementation", new Object[0]));
        return "com.google.android.gms";
    }
}
