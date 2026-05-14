package b.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f658c;
    public float d;
    public String e;
    public boolean f;
    public int g;

    public enum a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public b(b bVar, Object obj) {
        this.f656a = bVar.f656a;
        this.f657b = bVar.f657b;
        b(obj);
    }

    public b(String str, a aVar, Object obj) {
        this.f656a = str;
        this.f657b = aVar;
        b(obj);
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, b> map) {
        a aVar;
        Object string;
        int integer;
        float dimension;
        a aVar2 = a.DIMENSION_TYPE;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), k.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string2 = null;
        Object objValueOf = null;
        a aVar3 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == k.CustomAttribute_attributeName) {
                string2 = typedArrayObtainStyledAttributes.getString(index);
                if (string2 != null && string2.length() > 0) {
                    string2 = Character.toUpperCase(string2.charAt(0)) + string2.substring(1);
                }
            } else if (index == k.CustomAttribute_customBoolean) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                aVar3 = a.BOOLEAN_TYPE;
            } else {
                if (index == k.CustomAttribute_customColorValue) {
                    aVar = a.COLOR_TYPE;
                } else if (index == k.CustomAttribute_customColorDrawableValue) {
                    aVar = a.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == k.CustomAttribute_customPixelDimension) {
                        dimension = TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == k.CustomAttribute_customDimension) {
                        dimension = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    } else {
                        if (index == k.CustomAttribute_customFloatValue) {
                            aVar = a.FLOAT_TYPE;
                            string = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                        } else if (index == k.CustomAttribute_customIntegerValue) {
                            aVar = a.INT_TYPE;
                            integer = typedArrayObtainStyledAttributes.getInteger(index, -1);
                            string = Integer.valueOf(integer);
                        } else if (index == k.CustomAttribute_customStringValue) {
                            aVar = a.STRING_TYPE;
                            string = typedArrayObtainStyledAttributes.getString(index);
                        }
                        Object obj = string;
                        aVar3 = aVar;
                        objValueOf = obj;
                    }
                    objValueOf = Float.valueOf(dimension);
                    aVar3 = aVar2;
                }
                integer = typedArrayObtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(integer);
                Object obj2 = string;
                aVar3 = aVar;
                objValueOf = obj2;
            }
        }
        if (string2 != null && objValueOf != null) {
            map.put(string2, new b(string2, aVar3, objValueOf));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void b(Object obj) {
        switch (this.f657b) {
            case INT_TYPE:
                this.f658c = ((Integer) obj).intValue();
                break;
            case FLOAT_TYPE:
            case DIMENSION_TYPE:
                this.d = ((Float) obj).floatValue();
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.g = ((Integer) obj).intValue();
                break;
            case STRING_TYPE:
                this.e = (String) obj;
                break;
            case BOOLEAN_TYPE:
                this.f = ((Boolean) obj).booleanValue();
                break;
        }
    }
}
