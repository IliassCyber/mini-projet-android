package c.a.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1203b;

    public h(String str, String str2) {
        this.f1202a = str;
        this.f1203b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return TextUtils.equals(this.f1202a, hVar.f1202a) && TextUtils.equals(this.f1203b, hVar.f1203b);
    }

    public int hashCode() {
        return this.f1203b.hashCode() + (this.f1202a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("Header[name=");
        sbE.append(this.f1202a);
        sbE.append(",value=");
        sbE.append(this.f1203b);
        sbE.append("]");
        return sbE.toString();
    }
}
