package c.a.a.a;

import android.util.Pair;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.a.c.l.q;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: outline */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String b(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String c(String str, String str2) {
        return str + str2;
    }

    public static String d(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder e(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static void f(int i, String str, int i2, boolean z) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        q.i(z, sb.toString());
    }

    public static void g(String str, String str2, SparseArray sparseArray, int i) {
        sparseArray.put(i, new Pair(str, str2));
    }
}
