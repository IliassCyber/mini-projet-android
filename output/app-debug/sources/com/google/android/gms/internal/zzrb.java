package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzrb {

    public static class zza {
        public final zzrc zzaVj;
        public final List<Asset> zzaVk;

        public zza(zzrc zzrcVar, List<Asset> list) {
            this.zzaVj = zzrcVar;
            this.zzaVk = list;
        }
    }

    private static int zza(String str, zzrc.zza.C0163zza[] c0163zzaArr) {
        int i = 14;
        for (zzrc.zza.C0163zza c0163zza : c0163zzaArr) {
            if (i != 14) {
                if (c0163zza.type != i) {
                    throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c0163zza.type);
                }
            } else if (c0163zza.type == 9 || c0163zza.type == 2 || c0163zza.type == 6) {
                i = c0163zza.type;
            } else if (c0163zza.type != 14) {
                throw new IllegalArgumentException("Unexpected TypedValue type: " + c0163zza.type + " for key " + str);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzrc zzrcVar = new zzrc();
        ArrayList arrayList = new ArrayList();
        zzrcVar.zzaVl = zza(dataMap, arrayList);
        return new zza(zzrcVar, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzrc.zza.C0163zza zza(List<Asset> list, Object obj) {
        zzrc.zza.C0163zza c0163zza = new zzrc.zza.C0163zza();
        if (obj == null) {
            c0163zza.type = 14;
            return c0163zza;
        }
        c0163zza.zzaVp = new zzrc.zza.C0163zza.C0164zza();
        if (obj instanceof String) {
            c0163zza.type = 2;
            c0163zza.zzaVp.zzaVr = (String) obj;
        } else if (obj instanceof Integer) {
            c0163zza.type = 6;
            c0163zza.zzaVp.zzaVv = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c0163zza.type = 5;
            c0163zza.zzaVp.zzaVu = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c0163zza.type = 3;
            c0163zza.zzaVp.zzaVs = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c0163zza.type = 4;
            c0163zza.zzaVp.zzaVt = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c0163zza.type = 8;
            c0163zza.zzaVp.zzaVx = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c0163zza.type = 7;
            c0163zza.zzaVp.zzaVw = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c0163zza.type = 1;
            c0163zza.zzaVp.zzaVq = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c0163zza.type = 11;
            c0163zza.zzaVp.zzaVA = (String[]) obj;
        } else if (obj instanceof long[]) {
            c0163zza.type = 12;
            c0163zza.zzaVp.zzaVB = (long[]) obj;
        } else if (obj instanceof float[]) {
            c0163zza.type = 15;
            c0163zza.zzaVp.zzaVC = (float[]) obj;
        } else if (obj instanceof Asset) {
            c0163zza.type = 13;
            c0163zza.zzaVp.zzaVD = zza(list, (Asset) obj);
        } else {
            int i = 0;
            if (obj instanceof DataMap) {
                c0163zza.type = 9;
                DataMap dataMap = (DataMap) obj;
                Set<String> setKeySet = dataMap.keySet();
                zzrc.zza[] zzaVarArr = new zzrc.zza[setKeySet.size()];
                for (String str : setKeySet) {
                    zzaVarArr[i] = new zzrc.zza();
                    zzaVarArr[i].name = str;
                    zzaVarArr[i].zzaVn = zza(list, dataMap.get(str));
                    i++;
                }
                c0163zza.zzaVp.zzaVy = zzaVarArr;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
                }
                c0163zza.type = 10;
                ArrayList arrayList = (ArrayList) obj;
                zzrc.zza.C0163zza[] c0163zzaArr = new zzrc.zza.C0163zza[arrayList.size()];
                int size = arrayList.size();
                Object obj2 = null;
                int i2 = 14;
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    zzrc.zza.C0163zza c0163zzaZza = zza(list, obj3);
                    if (c0163zzaZza.type != 14 && c0163zzaZza.type != 2 && c0163zzaZza.type != 6 && c0163zzaZza.type != 9) {
                        throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                    }
                    if (i2 == 14 && c0163zzaZza.type != 14) {
                        i2 = c0163zzaZza.type;
                        obj2 = obj3;
                    } else if (c0163zzaZza.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    }
                    c0163zzaArr[i] = c0163zzaZza;
                    i++;
                }
                c0163zza.zzaVp.zzaVz = c0163zzaArr;
            }
        }
        return c0163zza;
    }

    public static DataMap zza(zza zzaVar) {
        DataMap dataMap = new DataMap();
        for (zzrc.zza zzaVar2 : zzaVar.zzaVj.zzaVl) {
            zza(zzaVar.zzaVk, dataMap, zzaVar2.name, zzaVar2.zzaVn);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, zzrc.zza.C0163zza.C0164zza c0164zza, int i) {
        Object objValueOf;
        ArrayList arrayList = new ArrayList(c0164zza.zzaVz.length);
        for (zzrc.zza.C0163zza c0163zza : c0164zza.zzaVz) {
            if (c0163zza.type == 14) {
                objValueOf = null;
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (zzrc.zza zzaVar : c0163zza.zzaVp.zzaVy) {
                    zza(list, dataMap, zzaVar.name, zzaVar.zzaVn);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                objValueOf = c0163zza.zzaVp.zzaVr;
            } else {
                if (i != 6) {
                    throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
                }
                objValueOf = Integer.valueOf(c0163zza.zzaVp.zzaVv);
            }
            arrayList.add(objValueOf);
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(List<Asset> list, DataMap dataMap, String str, zzrc.zza.C0163zza c0163zza) {
        int i = c0163zza.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        zzrc.zza.C0163zza.C0164zza c0164zza = c0163zza.zzaVp;
        if (i == 1) {
            dataMap.putByteArray(str, c0164zza.zzaVq);
            return;
        }
        if (i == 11) {
            dataMap.putStringArray(str, c0164zza.zzaVA);
            return;
        }
        if (i == 12) {
            dataMap.putLongArray(str, c0164zza.zzaVB);
            return;
        }
        if (i == 15) {
            dataMap.putFloatArray(str, c0164zza.zzaVC);
            return;
        }
        if (i == 2) {
            dataMap.putString(str, c0164zza.zzaVr);
            return;
        }
        if (i == 3) {
            dataMap.putDouble(str, c0164zza.zzaVs);
            return;
        }
        if (i == 4) {
            dataMap.putFloat(str, c0164zza.zzaVt);
            return;
        }
        if (i == 5) {
            dataMap.putLong(str, c0164zza.zzaVu);
            return;
        }
        if (i == 6) {
            dataMap.putInt(str, c0164zza.zzaVv);
            return;
        }
        if (i == 7) {
            dataMap.putByte(str, (byte) c0164zza.zzaVw);
            return;
        }
        if (i == 8) {
            dataMap.putBoolean(str, c0164zza.zzaVx);
            return;
        }
        if (i == 13) {
            if (list != null) {
                dataMap.putAsset(str, list.get((int) c0164zza.zzaVD));
                return;
            }
            throw new RuntimeException("populateBundle: unexpected type for: " + str);
        }
        if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzrc.zza zzaVar : c0164zza.zzaVy) {
                zza(list, dataMap2, zzaVar.name, zzaVar.zzaVn);
            }
            dataMap.putDataMap(str, dataMap2);
            return;
        }
        if (i != 10) {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
        int iZza = zza(str, c0164zza.zzaVz);
        ArrayList<Integer> arrayListZza = zza(list, c0164zza, iZza);
        if (iZza != 14) {
            if (iZza == 9) {
                dataMap.putDataMapArrayList(str, arrayListZza);
                return;
            }
            if (iZza != 2) {
                if (iZza == 6) {
                    dataMap.putIntegerArrayList(str, arrayListZza);
                    return;
                }
                throw new IllegalStateException("Unexpected typeOfArrayList: " + iZza);
            }
        }
        dataMap.putStringArrayList(str, arrayListZza);
    }

    private static zzrc.zza[] zza(DataMap dataMap, List<Asset> list) {
        Set<String> setKeySet = dataMap.keySet();
        zzrc.zza[] zzaVarArr = new zzrc.zza[setKeySet.size()];
        int i = 0;
        for (String str : setKeySet) {
            Object obj = dataMap.get(str);
            zzaVarArr[i] = new zzrc.zza();
            zzaVarArr[i].name = str;
            zzaVarArr[i].zzaVn = zza(list, obj);
            i++;
        }
        return zzaVarArr;
    }
}
