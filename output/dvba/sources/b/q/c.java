package b.q;

import androidx.media.AudioAttributesCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1011a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1012b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1013c = 0;
    public int d = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f1012b != cVar.f1012b) {
            return false;
        }
        int i = this.f1013c;
        int i2 = cVar.f1013c;
        int iA = cVar.d;
        if (iA == -1) {
            iA = AudioAttributesCompat.a(false, i2, cVar.f1011a);
        }
        if (iA == 6) {
            i2 |= 4;
        } else if (iA == 7) {
            i2 |= 1;
        }
        return i == (i2 & 273) && this.f1011a == cVar.f1011a && this.d == cVar.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1012b), Integer.valueOf(this.f1013c), Integer.valueOf(this.f1011a), Integer.valueOf(this.d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f1011a));
        sb.append(" content=");
        sb.append(this.f1012b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1013c).toUpperCase());
        return sb.toString();
    }
}
