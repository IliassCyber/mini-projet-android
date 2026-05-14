package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzlh;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzOw;
    private String zzRA;
    private String zzRC;
    private String zzRE;
    private JSONObject zzRJ;
    private int zzSq;
    private int zzSr;

    public static class Builder {
        private final MediaTrack zzSs;

        public Builder(long j, int i) throws IllegalArgumentException {
            this.zzSs = new MediaTrack(j, i);
        }

        public MediaTrack build() {
            return this.zzSs;
        }

        public Builder setContentId(String str) {
            this.zzSs.setContentId(str);
            return this;
        }

        public Builder setContentType(String str) {
            this.zzSs.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzSs.setCustomData(jSONObject);
            return this;
        }

        public Builder setLanguage(String str) {
            this.zzSs.setLanguage(str);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzSs.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setName(String str) {
            this.zzSs.setName(str);
            return this;
        }

        public Builder setSubtype(int i) throws IllegalArgumentException {
            this.zzSs.zzaG(i);
            return this;
        }
    }

    MediaTrack(long j, int i) throws IllegalArgumentException {
        clear();
        this.zzOw = j;
        if (i > 0 && i <= 3) {
            this.zzSq = i;
            return;
        }
        throw new IllegalArgumentException("invalid type " + i);
    }

    MediaTrack(JSONObject jSONObject) throws JSONException {
        zzf(jSONObject);
    }

    private void clear() {
        this.zzOw = 0L;
        this.zzSq = 0;
        this.zzRC = null;
        this.mName = null;
        this.zzRA = null;
        this.zzSr = -1;
        this.zzRJ = null;
    }

    private void zzf(JSONObject jSONObject) throws JSONException {
        int i;
        clear();
        this.zzOw = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzSq = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzSq = 2;
        } else {
            if (!"VIDEO".equals(string)) {
                throw new JSONException("invalid type: " + string);
            }
            this.zzSq = 3;
        }
        this.zzRC = jSONObject.optString("trackContentId", null);
        this.zzRE = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzRA = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.zzSr = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.zzSr = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.zzSr = 3;
            } else if ("CHAPTERS".equals(string2)) {
                i = 4;
            } else {
                if (!"METADATA".equals(string2)) {
                    throw new JSONException("invalid subtype: " + string2);
                }
                i = 5;
            }
            this.zzRJ = jSONObject.optJSONObject("customData");
        }
        i = 0;
        this.zzSr = i;
        this.zzRJ = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        JSONObject jSONObject;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        if ((this.zzRJ == null) != (mediaTrack.zzRJ == null)) {
            return false;
        }
        JSONObject jSONObject2 = this.zzRJ;
        return (jSONObject2 == null || (jSONObject = mediaTrack.zzRJ) == null || zzlh.zzd(jSONObject2, jSONObject)) && this.zzOw == mediaTrack.zzOw && this.zzSq == mediaTrack.zzSq && zzf.zza(this.zzRC, mediaTrack.zzRC) && zzf.zza(this.zzRE, mediaTrack.zzRE) && zzf.zza(this.mName, mediaTrack.mName) && zzf.zza(this.zzRA, mediaTrack.zzRA) && this.zzSr == mediaTrack.zzSr;
    }

    public String getContentId() {
        return this.zzRC;
    }

    public String getContentType() {
        return this.zzRE;
    }

    public JSONObject getCustomData() {
        return this.zzRJ;
    }

    public long getId() {
        return this.zzOw;
    }

    public String getLanguage() {
        return this.zzRA;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzSr;
    }

    public int getType() {
        return this.zzSq;
    }

    public int hashCode() {
        return zzt.hashCode(Long.valueOf(this.zzOw), Integer.valueOf(this.zzSq), this.zzRC, this.zzRE, this.mName, this.zzRA, Integer.valueOf(this.zzSr), this.zzRJ);
    }

    public void setContentId(String str) {
        this.zzRC = str;
    }

    public void setContentType(String str) {
        this.zzRE = str;
    }

    void setCustomData(JSONObject jSONObject) {
        this.zzRJ = jSONObject;
    }

    void setLanguage(String str) {
        this.zzRA = str;
    }

    void setName(String str) {
        this.mName = str;
    }

    public JSONObject toJson() {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzOw);
            switch (this.zzSq) {
                case 1:
                    str = "type";
                    str2 = "TEXT";
                    jSONObject.put(str, str2);
                    break;
                case 2:
                    str = "type";
                    str2 = "AUDIO";
                    jSONObject.put(str, str2);
                    break;
                case 3:
                    str = "type";
                    str2 = "VIDEO";
                    jSONObject.put(str, str2);
                    break;
            }
            if (this.zzRC != null) {
                jSONObject.put("trackContentId", this.zzRC);
            }
            if (this.zzRE != null) {
                jSONObject.put("trackContentType", this.zzRE);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzRA)) {
                jSONObject.put("language", this.zzRA);
            }
            switch (this.zzSr) {
                case 1:
                    str3 = "subtype";
                    str4 = "SUBTITLES";
                    jSONObject.put(str3, str4);
                    break;
                case 2:
                    str3 = "subtype";
                    str4 = "CAPTIONS";
                    jSONObject.put(str3, str4);
                    break;
                case 3:
                    str3 = "subtype";
                    str4 = "DESCRIPTIONS";
                    jSONObject.put(str3, str4);
                    break;
                case 4:
                    str3 = "subtype";
                    str4 = "CHAPTERS";
                    jSONObject.put(str3, str4);
                    break;
                case 5:
                    str3 = "subtype";
                    str4 = "METADATA";
                    jSONObject.put(str3, str4);
                    break;
            }
            if (this.zzRJ != null) {
                jSONObject.put("customData", this.zzRJ);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzaG(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        }
        if (i != 0 && this.zzSq != 1) {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
        this.zzSr = i;
    }
}
