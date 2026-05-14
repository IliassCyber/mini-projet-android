package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import b.v.a;
import b.v.b;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        iconCompat.f135a = aVar.i(iconCompat.f135a, 1);
        byte[] bArr = iconCompat.f137c;
        if (aVar.h(2)) {
            b bVar = (b) aVar;
            int i = bVar.e.readInt();
            if (i < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i];
                bVar.e.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f137c = bArr;
        iconCompat.d = aVar.j(iconCompat.d, 3);
        iconCompat.e = aVar.i(iconCompat.e, 4);
        iconCompat.f = aVar.i(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.j(iconCompat.g, 6);
        String string = iconCompat.i;
        if (aVar.h(7)) {
            string = ((b) aVar).e.readString();
        }
        iconCompat.i = string;
        iconCompat.h = PorterDuff.Mode.valueOf(string);
        switch (iconCompat.f135a) {
            case -1:
                parcelable = iconCompat.d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f136b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                parcelable = iconCompat.d;
                if (parcelable != null) {
                    iconCompat.f136b = parcelable;
                } else {
                    byte[] bArr3 = iconCompat.f137c;
                    iconCompat.f136b = bArr3;
                    iconCompat.f135a = 3;
                    iconCompat.e = 0;
                    iconCompat.f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                iconCompat.f136b = new String(iconCompat.f137c, Charset.forName("UTF-16"));
                return iconCompat;
            case 3:
                iconCompat.f136b = iconCompat.f137c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        if (aVar == null) {
            throw null;
        }
        iconCompat.i = iconCompat.h.name();
        switch (iconCompat.f135a) {
            case -1:
            case 1:
            case 5:
                iconCompat.d = (Parcelable) iconCompat.f136b;
                break;
            case 2:
                iconCompat.f137c = ((String) iconCompat.f136b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f137c = (byte[]) iconCompat.f136b;
                break;
            case 4:
            case 6:
                iconCompat.f137c = iconCompat.f136b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f135a;
        if (-1 != i) {
            aVar.m(i, 1);
        }
        byte[] bArr = iconCompat.f137c;
        if (bArr != null) {
            aVar.l(2);
            b bVar = (b) aVar;
            if (bArr != null) {
                bVar.e.writeInt(bArr.length);
                bVar.e.writeByteArray(bArr);
            } else {
                bVar.e.writeInt(-1);
            }
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            aVar.n(parcelable, 3);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            aVar.m(i2, 4);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            aVar.m(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            aVar.n(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            aVar.l(7);
            ((b) aVar).e.writeString(str);
        }
    }
}
