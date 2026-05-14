package b.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray<a> f663a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SparseArray<e> f664b = new SparseArray<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<b> f666b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f667c;
        public e d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f667c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), k.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == k.State_android_id) {
                    this.f665a = typedArrayObtainStyledAttributes.getResourceId(index, this.f665a);
                } else if (index == k.State_constraints) {
                    this.f667c = typedArrayObtainStyledAttributes.getResourceId(index, this.f667c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f667c);
                    context.getResources().getResourceName(this.f667c);
                    if ("layout".equals(resourceTypeName)) {
                        e eVar = new e();
                        this.d = eVar;
                        eVar.b(context, this.f667c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f670c;
        public float d;
        public int e;
        public e f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f668a = Float.NaN;
            this.f669b = Float.NaN;
            this.f670c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), k.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == k.Variant_constraints) {
                    this.e = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        e eVar = new e();
                        this.f = eVar;
                        eVar.b(context, this.e);
                    }
                } else if (index == k.Variant_region_heightLessThan) {
                    this.d = typedArrayObtainStyledAttributes.getDimension(index, this.d);
                } else if (index == k.Variant_region_heightMoreThan) {
                    this.f669b = typedArrayObtainStyledAttributes.getDimension(index, this.f669b);
                } else if (index == k.Variant_region_widthLessThan) {
                    this.f670c = typedArrayObtainStyledAttributes.getDimension(index, this.f670c);
                } else if (index == k.Variant_region_widthMoreThan) {
                    this.f668a = typedArrayObtainStyledAttributes.getDimension(index, this.f668a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public d(Context context, ConstraintLayout constraintLayout, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    byte b2 = -1;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b2 = 4;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                b2 = 2;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b2 = 1;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                b2 = 0;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b2 = 3;
                            }
                            break;
                    }
                    if (b2 != 0 && b2 != 1) {
                        if (b2 == 2) {
                            aVar = new a(context, xml);
                            this.f663a.put(aVar.f665a, aVar);
                        } else if (b2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.f666b.add(bVar);
                            }
                        } else if (b2 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            a(context, xml);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d2, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r13, org.xmlpull.v1.XmlPullParser r14) {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.c.d.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
