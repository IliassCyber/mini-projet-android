package b.i.e.b;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Shader f724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f726c;

    public a(Shader shader, ColorStateList colorStateList, int i) {
        this.f724a = shader;
        this.f725b = colorStateList;
        this.f726c = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x014f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.i.e.b.a a(android.content.res.Resources r26, int r27, android.content.res.Resources.Theme r28) {
        /*
            Method dump skipped, instruction units count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.e.b.a.a(android.content.res.Resources, int, android.content.res.Resources$Theme):b.i.e.b.a");
    }

    public boolean b() {
        return this.f724a != null;
    }

    public boolean c() {
        ColorStateList colorStateList;
        return this.f724a == null && (colorStateList = this.f725b) != null && colorStateList.isStateful();
    }

    public boolean d(int[] iArr) {
        if (c()) {
            ColorStateList colorStateList = this.f725b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f726c) {
                this.f726c = colorForState;
                return true;
            }
        }
        return false;
    }
}
