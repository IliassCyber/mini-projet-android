package b.q;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f1009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1010b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f1009a.equals(((b) obj).f1009a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1009a.hashCode();
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("AudioAttributesCompat: audioattributes=");
        sbE.append(this.f1009a);
        return sbE.toString();
    }
}
