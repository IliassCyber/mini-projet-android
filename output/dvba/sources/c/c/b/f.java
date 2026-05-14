package c.c.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import c.c.a.a.c.i;
import c.c.a.a.c.l.p;
import c.c.a.a.c.l.q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1771c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        q.i(!c.c.a.a.c.o.d.b(str), "ApplicationId must be set.");
        this.f1770b = str;
        this.f1769a = str2;
        this.f1771c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static f a(Context context) {
        q.f(context);
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(i.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        String string = identifier == 0 ? null : resources.getString(identifier);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        int identifier2 = resources.getIdentifier("google_api_key", "string", resourcePackageName);
        String string2 = identifier2 == 0 ? null : resources.getString(identifier2);
        int identifier3 = resources.getIdentifier("firebase_database_url", "string", resourcePackageName);
        String string3 = identifier3 == 0 ? null : resources.getString(identifier3);
        int identifier4 = resources.getIdentifier("ga_trackingId", "string", resourcePackageName);
        String string4 = identifier4 == 0 ? null : resources.getString(identifier4);
        int identifier5 = resources.getIdentifier("gcm_defaultSenderId", "string", resourcePackageName);
        String string5 = identifier5 == 0 ? null : resources.getString(identifier5);
        int identifier6 = resources.getIdentifier("google_storage_bucket", "string", resourcePackageName);
        String string6 = identifier6 == 0 ? null : resources.getString(identifier6);
        int identifier7 = resources.getIdentifier("project_id", "string", resourcePackageName);
        return new f(string, string2, string3, string4, string5, string6, identifier7 != 0 ? resources.getString(identifier7) : null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return a.a.a.a.a.y(this.f1770b, fVar.f1770b) && a.a.a.a.a.y(this.f1769a, fVar.f1769a) && a.a.a.a.a.y(this.f1771c, fVar.f1771c) && a.a.a.a.a.y(this.d, fVar.d) && a.a.a.a.a.y(this.e, fVar.e) && a.a.a.a.a.y(this.f, fVar.f) && a.a.a.a.a.y(this.g, fVar.g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1770b, this.f1769a, this.f1771c, this.d, this.e, this.f, this.g});
    }

    public String toString() {
        p pVarB0 = a.a.a.a.a.B0(this);
        pVarB0.a("applicationId", this.f1770b);
        pVarB0.a("apiKey", this.f1769a);
        pVarB0.a("databaseUrl", this.f1771c);
        pVarB0.a("gcmSenderId", this.e);
        pVarB0.a("storageBucket", this.f);
        pVarB0.a("projectId", this.g);
        return pVarB0.toString();
    }
}
