package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzlk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzRJ;
    private float zzTc;
    private int zzTd;
    private int zzTe;
    private int zzTf;
    private int zzTg;
    private int zzTh;
    private int zzTi;
    private String zzTj;
    private int zzTk;
    private int zzTl;
    private int zzvc;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzTc = 1.0f;
        this.zzTd = 0;
        this.zzvc = 0;
        this.zzTe = -1;
        this.zzTf = 0;
        this.zzTg = -1;
        this.zzTh = 0;
        this.zzTi = 0;
        this.zzTj = null;
        this.zzTk = -1;
        this.zzTl = -1;
        this.zzRJ = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzlk.zzoX()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (!Typeface.SANS_SERIF.equals(typeface) && Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean zIsBold = typeface.isBold();
            boolean zIsItalic = typeface.isItalic();
            if (zIsBold && zIsItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (zIsBold) {
                textTrackStyle.setFontStyle(1);
            } else if (zIsItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private String zzG(int i) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i)));
    }

    private int zzbz(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }

    public boolean equals(Object obj) {
        JSONObject jSONObject;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        if ((this.zzRJ == null) != (textTrackStyle.zzRJ == null)) {
            return false;
        }
        JSONObject jSONObject2 = this.zzRJ;
        return (jSONObject2 == null || (jSONObject = textTrackStyle.zzRJ) == null || zzlh.zzd(jSONObject2, jSONObject)) && this.zzTc == textTrackStyle.zzTc && this.zzTd == textTrackStyle.zzTd && this.zzvc == textTrackStyle.zzvc && this.zzTe == textTrackStyle.zzTe && this.zzTf == textTrackStyle.zzTf && this.zzTg == textTrackStyle.zzTg && this.zzTi == textTrackStyle.zzTi && zzf.zza(this.zzTj, textTrackStyle.zzTj) && this.zzTk == textTrackStyle.zzTk && this.zzTl == textTrackStyle.zzTl;
    }

    public int getBackgroundColor() {
        return this.zzvc;
    }

    public JSONObject getCustomData() {
        return this.zzRJ;
    }

    public int getEdgeColor() {
        return this.zzTf;
    }

    public int getEdgeType() {
        return this.zzTe;
    }

    public String getFontFamily() {
        return this.zzTj;
    }

    public int getFontGenericFamily() {
        return this.zzTk;
    }

    public float getFontScale() {
        return this.zzTc;
    }

    public int getFontStyle() {
        return this.zzTl;
    }

    public int getForegroundColor() {
        return this.zzTd;
    }

    public int getWindowColor() {
        return this.zzTh;
    }

    public int getWindowCornerRadius() {
        return this.zzTi;
    }

    public int getWindowType() {
        return this.zzTg;
    }

    public int hashCode() {
        return zzt.hashCode(Float.valueOf(this.zzTc), Integer.valueOf(this.zzTd), Integer.valueOf(this.zzvc), Integer.valueOf(this.zzTe), Integer.valueOf(this.zzTf), Integer.valueOf(this.zzTg), Integer.valueOf(this.zzTh), Integer.valueOf(this.zzTi), this.zzTj, Integer.valueOf(this.zzTk), Integer.valueOf(this.zzTl), this.zzRJ);
    }

    public void setBackgroundColor(int i) {
        this.zzvc = i;
    }

    public void setCustomData(JSONObject jSONObject) {
        this.zzRJ = jSONObject;
    }

    public void setEdgeColor(int i) {
        this.zzTf = i;
    }

    public void setEdgeType(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzTe = i;
    }

    public void setFontFamily(String str) {
        this.zzTj = str;
    }

    public void setFontGenericFamily(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzTk = i;
    }

    public void setFontScale(float f) {
        this.zzTc = f;
    }

    public void setFontStyle(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzTl = i;
    }

    public void setForegroundColor(int i) {
        this.zzTd = i;
    }

    public void setWindowColor(int i) {
        this.zzTh = i;
    }

    public void setWindowCornerRadius(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzTi = i;
    }

    public void setWindowType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzTg = i;
    }

    public JSONObject toJson() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.zzTc);
            if (this.zzTd != 0) {
                jSONObject.put("foregroundColor", zzG(this.zzTd));
            }
            if (this.zzvc != 0) {
                jSONObject.put("backgroundColor", zzG(this.zzvc));
            }
            switch (this.zzTe) {
                case 0:
                    str = "edgeType";
                    str2 = "NONE";
                    jSONObject.put(str, str2);
                    break;
                case 1:
                    str = "edgeType";
                    str2 = "OUTLINE";
                    jSONObject.put(str, str2);
                    break;
                case 2:
                    str = "edgeType";
                    str2 = "DROP_SHADOW";
                    jSONObject.put(str, str2);
                    break;
                case 3:
                    str = "edgeType";
                    str2 = "RAISED";
                    jSONObject.put(str, str2);
                    break;
                case 4:
                    str = "edgeType";
                    str2 = "DEPRESSED";
                    jSONObject.put(str, str2);
                    break;
            }
            if (this.zzTf != 0) {
                jSONObject.put("edgeColor", zzG(this.zzTf));
            }
            switch (this.zzTg) {
                case 0:
                    str3 = "windowType";
                    str4 = "NONE";
                    jSONObject.put(str3, str4);
                    break;
                case 1:
                    str3 = "windowType";
                    str4 = "NORMAL";
                    jSONObject.put(str3, str4);
                    break;
                case 2:
                    str3 = "windowType";
                    str4 = "ROUNDED_CORNERS";
                    jSONObject.put(str3, str4);
                    break;
            }
            if (this.zzTh != 0) {
                jSONObject.put("windowColor", zzG(this.zzTh));
            }
            if (this.zzTg == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzTi);
            }
            if (this.zzTj != null) {
                jSONObject.put("fontFamily", this.zzTj);
            }
            switch (this.zzTk) {
                case 0:
                    str5 = "fontGenericFamily";
                    str6 = "SANS_SERIF";
                    jSONObject.put(str5, str6);
                    break;
                case 1:
                    str5 = "fontGenericFamily";
                    str6 = "MONOSPACED_SANS_SERIF";
                    jSONObject.put(str5, str6);
                    break;
                case 2:
                    str5 = "fontGenericFamily";
                    str6 = "SERIF";
                    jSONObject.put(str5, str6);
                    break;
                case 3:
                    str5 = "fontGenericFamily";
                    str6 = "MONOSPACED_SERIF";
                    jSONObject.put(str5, str6);
                    break;
                case 4:
                    str5 = "fontGenericFamily";
                    str6 = "CASUAL";
                    jSONObject.put(str5, str6);
                    break;
                case 5:
                    str5 = "fontGenericFamily";
                    str6 = "CURSIVE";
                    jSONObject.put(str5, str6);
                    break;
                case 6:
                    str5 = "fontGenericFamily";
                    str6 = "SMALL_CAPITALS";
                    jSONObject.put(str5, str6);
                    break;
            }
            switch (this.zzTl) {
                case 0:
                    str7 = "fontStyle";
                    str8 = "NORMAL";
                    jSONObject.put(str7, str8);
                    break;
                case 1:
                    str7 = "fontStyle";
                    str8 = "BOLD";
                    jSONObject.put(str7, str8);
                    break;
                case 2:
                    str7 = "fontStyle";
                    str8 = "ITALIC";
                    jSONObject.put(str7, str8);
                    break;
                case 3:
                    str7 = "fontStyle";
                    str8 = "BOLD_ITALIC";
                    jSONObject.put(str7, str8);
                    break;
            }
            if (this.zzRJ != null) {
                jSONObject.put("customData", this.zzRJ);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void zzf(JSONObject jSONObject) throws JSONException {
        int i;
        clear();
        this.zzTc = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzTd = zzbz(jSONObject.optString("foregroundColor"));
        this.zzvc = zzbz(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzTe = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zzTe = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzTe = 2;
            } else if ("RAISED".equals(string)) {
                this.zzTe = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zzTe = 4;
            }
        }
        this.zzTf = zzbz(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzTg = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzTg = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzTg = 2;
            }
        }
        this.zzTh = zzbz(jSONObject.optString("windowColor"));
        if (this.zzTg == 2) {
            this.zzTi = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzTj = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzTk = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzTk = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzTk = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzTk = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzTk = 4;
            } else {
                if (!"CURSIVE".equals(string3)) {
                    i = "SMALL_CAPITALS".equals(string3) ? 6 : 5;
                }
                this.zzTk = i;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.zzTl = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzTl = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzTl = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzTl = 3;
            }
        }
        this.zzRJ = jSONObject.optJSONObject("customData");
    }
}
