package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final com.google.android.gms.common.server.response.zza CREATOR = new com.google.android.gms.common.server.response.zza();
        private final int zzCY;
        protected final int zzabG;
        protected final boolean zzabH;
        protected final int zzabI;
        protected final boolean zzabJ;
        protected final String zzabK;
        protected final int zzabL;
        protected final Class<? extends FastJsonResponse> zzabM;
        protected final String zzabN;
        private FieldMappingDictionary zzabO;
        private zza<I, O> zzabP;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.zzCY = i;
            this.zzabG = i2;
            this.zzabH = z;
            this.zzabI = i3;
            this.zzabJ = z2;
            this.zzabK = str;
            this.zzabL = i4;
            zza<I, O> zzaVar = null;
            if (str2 == null) {
                this.zzabM = null;
                this.zzabN = null;
            } else {
                this.zzabM = SafeParcelResponse.class;
                this.zzabN = str2;
            }
            this.zzabP = converterWrapper != null ? (zza<I, O>) converterWrapper.zzoi() : zzaVar;
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zzaVar) {
            this.zzCY = 1;
            this.zzabG = i;
            this.zzabH = z;
            this.zzabI = i2;
            this.zzabJ = z2;
            this.zzabK = str;
            this.zzabL = i3;
            this.zzabM = cls;
            this.zzabN = cls == null ? null : cls.getCanonicalName();
            this.zzabP = zzaVar;
        }

        public static Field zza(String str, int i, zza<?, ?> zzaVar, boolean z) {
            return new Field(zzaVar.zzok(), z, zzaVar.zzol(), false, str, i, null, zzaVar);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzi(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field<Double, Double> zzj(String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzk(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzl(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> zzm(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        public I convertBack(O o) {
            return this.zzabP.convertBack(o);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.zzCY;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=");
            sb.append(this.zzCY);
            sb.append('\n');
            sb.append("                 typeIn=");
            sb.append(this.zzabG);
            sb.append('\n');
            sb.append("            typeInArray=");
            sb.append(this.zzabH);
            sb.append('\n');
            sb.append("                typeOut=");
            sb.append(this.zzabI);
            sb.append('\n');
            sb.append("           typeOutArray=");
            sb.append(this.zzabJ);
            sb.append('\n');
            sb.append("        outputFieldName=");
            sb.append(this.zzabK);
            sb.append('\n');
            sb.append("      safeParcelFieldId=");
            sb.append(this.zzabL);
            sb.append('\n');
            sb.append("       concreteTypeName=");
            sb.append(zzov());
            sb.append('\n');
            if (zzou() != null) {
                sb.append("     concreteType.class=");
                sb.append(zzou().getCanonicalName());
                sb.append('\n');
            }
            sb.append("          converterName=");
            zza<I, O> zzaVar = this.zzabP;
            sb.append(zzaVar == null ? "null" : zzaVar.getClass().getCanonicalName());
            sb.append('\n');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            com.google.android.gms.common.server.response.zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzabO = fieldMappingDictionary;
        }

        public int zzok() {
            return this.zzabG;
        }

        public int zzol() {
            return this.zzabI;
        }

        public Field<I, O> zzop() {
            return new Field<>(this.zzCY, this.zzabG, this.zzabH, this.zzabI, this.zzabJ, this.zzabK, this.zzabL, this.zzabN, zzox());
        }

        public boolean zzoq() {
            return this.zzabH;
        }

        public boolean zzor() {
            return this.zzabJ;
        }

        public String zzos() {
            return this.zzabK;
        }

        public int zzot() {
            return this.zzabL;
        }

        public Class<? extends FastJsonResponse> zzou() {
            return this.zzabM;
        }

        String zzov() {
            String str = this.zzabN;
            if (str == null) {
                return null;
            }
            return str;
        }

        public boolean zzow() {
            return this.zzabP != null;
        }

        ConverterWrapper zzox() {
            zza<I, O> zzaVar = this.zzabP;
            if (zzaVar == null) {
                return null;
            }
            return ConverterWrapper.zza(zzaVar);
        }

        public Map<String, Field<?, ?>> zzoy() {
            zzu.zzu(this.zzabN);
            zzu.zzu(this.zzabO);
            return this.zzabO.zzco(this.zzabN);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzok();

        int zzol();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        String string;
        if (field.zzok() == 11) {
            string = field.zzou().cast(obj).toString();
        } else if (field.zzok() != 7) {
            sb.append(obj);
            return;
        } else {
            sb.append("\"");
            sb.append(zzlh.zzcr((String) obj));
            string = "\"";
        }
        sb.append(string);
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        String str;
        String strZzi;
        Map<String, Field<?, ?>> mapZzom = zzom();
        StringBuilder sb = new StringBuilder(100);
        for (String str2 : mapZzom.keySet()) {
            Field<?, ?> field = mapZzom.get(str2);
            if (zza(field)) {
                Object objZza = zza(field, zzb(field));
                sb.append(sb.length() == 0 ? "{" : ",");
                sb.append("\"");
                sb.append(str2);
                sb.append("\":");
                if (objZza == null) {
                    str = "null";
                } else {
                    switch (field.zzol()) {
                        case 8:
                            sb.append("\"");
                            strZzi = zzky.zzi((byte[]) objZza);
                            break;
                        case 9:
                            sb.append("\"");
                            strZzi = zzky.zzj((byte[]) objZza);
                            break;
                        case 10:
                            zzli.zza(sb, (HashMap) objZza);
                            continue;
                        default:
                            if (field.zzoq()) {
                                zza(sb, (Field) field, (ArrayList<Object>) objZza);
                            } else {
                                zza(sb, field, objZza);
                                continue;
                            }
                            break;
                    }
                    sb.append(strZzi);
                    str = "\"";
                }
                sb.append(str);
            }
        }
        sb.append(sb.length() > 0 ? "}" : "{}");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <O, I> I zza(Field<I, O> field, Object obj) {
        return ((Field) field).zzabP != null ? field.convertBack(obj) : obj;
    }

    protected boolean zza(Field field) {
        return field.zzol() == 11 ? field.zzor() ? zzcn(field.zzos()) : zzcm(field.zzos()) : zzcl(field.zzos());
    }

    protected Object zzb(Field field) {
        String strZzos = field.zzos();
        if (field.zzou() == null) {
            return zzck(field.zzos());
        }
        zzu.zza(zzck(field.zzos()) == null, "Concrete field shouldn't be value object: %s", field.zzos());
        HashMap<String, Object> mapZzoo = field.zzor() ? zzoo() : zzon();
        if (mapZzoo != null) {
            return mapZzoo.get(strZzos);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(strZzos.charAt(0)) + strZzos.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object zzck(String str);

    protected abstract boolean zzcl(String str);

    protected boolean zzcm(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzcn(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, Field<?, ?>> zzom();

    public HashMap<String, Object> zzon() {
        return null;
    }

    public HashMap<String, Object> zzoo() {
        return null;
    }
}
