package b.i.j;

import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f769c;
    public final List<List<byte[]>> d;
    public final int e;
    public final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f767a = str;
        this.f768b = str2;
        this.f769c = str3;
        if (list == null) {
            throw null;
        }
        this.d = list;
        this.e = 0;
        this.f = str + "-" + this.f768b + "-" + this.f769c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbE = c.a.a.a.a.e("FontRequest {mProviderAuthority: ");
        sbE.append(this.f767a);
        sbE.append(", mProviderPackage: ");
        sbE.append(this.f768b);
        sbE.append(", mQuery: ");
        sbE.append(this.f769c);
        sbE.append(", mCertificates:");
        sb.append(sbE.toString());
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
