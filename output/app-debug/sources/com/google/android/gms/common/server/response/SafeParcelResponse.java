package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String mClassName;
    private final int zzCY;
    private final FieldMappingDictionary zzabO;
    private final Parcel zzabV;
    private final int zzabW;
    private int zzabX;
    private int zzabY;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.zzCY = i;
        this.zzabV = (Parcel) zzu.zzu(parcel);
        this.zzabW = 2;
        this.zzabO = fieldMappingDictionary;
        FieldMappingDictionary fieldMappingDictionary2 = this.zzabO;
        this.mClassName = fieldMappingDictionary2 == null ? null : fieldMappingDictionary2.zzoC();
        this.zzabX = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        this.zzCY = 1;
        this.zzabV = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzabV, 0);
        this.zzabW = 1;
        this.zzabO = (FieldMappingDictionary) zzu.zzu(fieldMappingDictionary);
        this.mClassName = (String) zzu.zzu(str);
        this.zzabX = 2;
    }

    private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzC(Map<String, FastJsonResponse.Field<?, ?>> map) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> map2 = new HashMap<>();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            map2.put(Integer.valueOf(entry.getValue().zzot()), entry);
        }
        return map2;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse(t, zzb(t), canonicalName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (fieldMappingDictionary.zzb(cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> mapZzom = fastJsonResponse.zzom();
        fieldMappingDictionary.zza(cls, mapZzom);
        Iterator<String> it = mapZzom.keySet().iterator();
        while (it.hasNext()) {
            FastJsonResponse.Field<?, ?> field = mapZzom.get(it.next());
            Class<? extends FastJsonResponse> clsZzou = field.zzou();
            if (clsZzou != null) {
                try {
                    zza(fieldMappingDictionary, clsZzou.newInstance());
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Could not access object of type " + field.zzou().getCanonicalName(), e);
                } catch (InstantiationException e2) {
                    throw new IllegalStateException("Could not instantiate an object of type " + field.zzou().getCanonicalName(), e2);
                }
            }
        }
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        String strZzcr;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                strZzcr = zzlh.zzcr(obj.toString());
                break;
            case 8:
                sb.append("\"");
                strZzcr = zzky.zzi((byte[]) obj);
                break;
            case 9:
                sb.append("\"");
                strZzcr = zzky.zzj((byte[]) obj);
                break;
            case 10:
                zzli.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
        sb.append(strZzcr);
        sb.append("\"");
    }

    private void zza(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        Object objValueOf;
        switch (field.zzol()) {
            case 0:
                objValueOf = Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i));
                break;
            case 1:
                objValueOf = com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i);
                break;
            case 2:
                objValueOf = Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i));
                break;
            case 3:
                objValueOf = Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i));
                break;
            case 4:
                objValueOf = Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, i));
                break;
            case 5:
                objValueOf = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i);
                break;
            case 6:
                objValueOf = Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i));
                break;
            case 7:
                objValueOf = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i);
                break;
            case 8:
            case 9:
                objValueOf = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i);
                break;
            case 10:
                objValueOf = zzh(com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i));
                break;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.zzol());
        }
        zzb(sb, field, zza(field, objValueOf));
    }

    private void zza(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"");
        sb.append(str);
        sb.append("\":");
        if (field.zzow()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> mapZzC = zzC(map);
        sb.append('{');
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        boolean z = false;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            Map.Entry<String, FastJsonResponse.Field<?, ?>> entry = mapZzC.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, entry.getKey(), entry.getValue(), parcel, iZzaa);
                z = true;
            }
        }
        if (parcel.dataPosition() == iZzab) {
            sb.append('}');
            return;
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    private static FieldMappingDictionary zzb(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.zzoA();
        fieldMappingDictionary.zzoz();
        return fieldMappingDictionary;
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        Object objZzk;
        String strZzcr;
        String str;
        Object[] objArrZzw;
        if (field.zzor()) {
            sb.append("[");
            switch (field.zzol()) {
                case 0:
                    zzkx.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzu(parcel, i));
                    str = "]";
                    break;
                case 1:
                    objArrZzw = com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, i);
                    zzkx.zza(sb, objArrZzw);
                    str = "]";
                    break;
                case 2:
                    zzkx.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, i));
                    str = "]";
                    break;
                case 3:
                    zzkx.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzx(parcel, i));
                    str = "]";
                    break;
                case 4:
                    zzkx.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzy(parcel, i));
                    str = "]";
                    break;
                case 5:
                    objArrZzw = com.google.android.gms.common.internal.safeparcel.zza.zzz(parcel, i);
                    zzkx.zza(sb, objArrZzw);
                    str = "]";
                    break;
                case 6:
                    zzkx.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, i));
                    str = "]";
                    break;
                case 7:
                    zzkx.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, i));
                    str = "]";
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] parcelArrZzE = com.google.android.gms.common.internal.safeparcel.zza.zzE(parcel, i);
                    int length = parcelArrZzE.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        parcelArrZzE[i2].setDataPosition(0);
                        zza(sb, field.zzoy(), parcelArrZzE[i2]);
                    }
                    str = "]";
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
        } else {
            switch (field.zzol()) {
                case 0:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i));
                    return;
                case 1:
                    objZzk = com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i);
                    sb.append(objZzk);
                    return;
                case 2:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i));
                    return;
                case 3:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i));
                    return;
                case 4:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, i));
                    return;
                case 5:
                    objZzk = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i);
                    sb.append(objZzk);
                    return;
                case 6:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i));
                    return;
                case 7:
                    String strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i);
                    sb.append("\"");
                    strZzcr = zzlh.zzcr(strZzo);
                    sb.append(strZzcr);
                    str = "\"";
                    break;
                case 8:
                    byte[] bArrZzr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i);
                    sb.append("\"");
                    strZzcr = zzky.zzi(bArrZzr);
                    sb.append(strZzcr);
                    str = "\"";
                    break;
                case 9:
                    byte[] bArrZzr2 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i);
                    sb.append("\"");
                    strZzcr = zzky.zzj(bArrZzr2);
                    sb.append(strZzcr);
                    str = "\"";
                    break;
                case 10:
                    Bundle bundleZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i);
                    Set<String> setKeySet = bundleZzq.keySet();
                    setKeySet.size();
                    sb.append("{");
                    boolean z = true;
                    for (String str2 : setKeySet) {
                        if (!z) {
                            sb.append(",");
                        }
                        sb.append("\"");
                        sb.append(str2);
                        sb.append("\"");
                        sb.append(":");
                        sb.append("\"");
                        sb.append(zzlh.zzcr(bundleZzq.getString(str2)));
                        sb.append("\"");
                        z = false;
                    }
                    str = "}";
                    break;
                case 11:
                    Parcel parcelZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, i);
                    parcelZzD.setDataPosition(0);
                    zza(sb, field.zzoy(), parcelZzD);
                    return;
                default:
                    throw new IllegalStateException("Unknown field type out");
            }
        }
        sb.append(str);
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzoq()) {
            zzb(sb, field, (ArrayList<?>) obj);
        } else {
            zza(sb, field.zzok(), obj);
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzok(), arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzh(Bundle bundle) {
        HashMap<String, String> map = new HashMap<>();
        for (String str : bundle.keySet()) {
            map.put(str, bundle.getString(str));
        }
        return map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        zzu.zzb(this.zzabO, "Cannot convert to JSON on client side.");
        Parcel parcelZzoE = zzoE();
        parcelZzoE.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzabO.zzco(this.mClassName), parcelZzoE);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzck(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zzcl(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel zzoE() {
        switch (this.zzabX) {
            case 0:
                this.zzabY = com.google.android.gms.common.internal.safeparcel.zzb.zzac(this.zzabV);
            case 1:
                com.google.android.gms.common.internal.safeparcel.zzb.zzH(this.zzabV, this.zzabY);
                this.zzabX = 2;
                break;
        }
        return this.zzabV;
    }

    FieldMappingDictionary zzoF() {
        switch (this.zzabW) {
            case 0:
                return null;
            case 1:
                return this.zzabO;
            case 2:
                return this.zzabO;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzabW);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> zzom() {
        FieldMappingDictionary fieldMappingDictionary = this.zzabO;
        if (fieldMappingDictionary == null) {
            return null;
        }
        return fieldMappingDictionary.zzco(this.mClassName);
    }
}
