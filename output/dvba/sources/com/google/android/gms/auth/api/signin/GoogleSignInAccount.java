package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.c.a.a.a.a.a.b;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.u.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    public static c.c.a.a.c.o.a o = c.c.a.a.c.o.b.f1415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1947c;
    public String d;
    public String e;
    public String f;
    public Uri g;
    public String h;
    public long i;
    public String j;
    public List<Scope> k;
    public String l;
    public String m;
    public Set<Scope> n = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f1946b = i;
        this.f1947c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = uri;
        this.h = str5;
        this.i = j;
        this.j = str6;
        this.k = list;
        this.l = str7;
        this.m = str8;
    }

    public static GoogleSignInAccount i(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl", null);
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.optString("tokenId", null);
        String strOptString4 = jSONObject.optString("email", null);
        String strOptString5 = jSONObject.optString("displayName", null);
        String strOptString6 = jSONObject.optString("givenName", null);
        String strOptString7 = jSONObject.optString("familyName", null);
        Long lValueOf = Long.valueOf(j);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (lValueOf == null) {
            lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        long jLongValue = lValueOf.longValue();
        q.d(string);
        q.f(hashSet);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, jLongValue, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.h = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccount;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.j.equals(this.j)) {
            if (((AbstractSet) googleSignInAccount.h()).equals(h())) {
                return true;
            }
        }
        return false;
    }

    public Set<Scope> h() {
        HashSet hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public int hashCode() {
        return ((AbstractSet) h()).hashCode() + ((this.j.hashCode() + 527) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1946b);
        q.h0(parcel, 2, this.f1947c, false);
        q.h0(parcel, 3, this.d, false);
        q.h0(parcel, 4, this.e, false);
        q.h0(parcel, 5, this.f, false);
        q.g0(parcel, 6, this.g, i, false);
        q.h0(parcel, 7, this.h, false);
        q.e0(parcel, 8, this.i);
        q.h0(parcel, 9, this.j, false);
        q.k0(parcel, 10, this.k, false);
        q.h0(parcel, 11, this.l, false);
        q.h0(parcel, 12, this.m, false);
        q.C0(parcel, iA);
    }
}
