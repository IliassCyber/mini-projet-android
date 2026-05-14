package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public final class zzdo implements zzdg {
    private final Map<zzid, Integer> zzwA = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzidVar, Map<String, String> map) {
        String string;
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        com.google.android.gms.ads.internal.overlay.zzh zzhVarZzeq;
        String str4 = map.get("action");
        if (str4 == null) {
            str3 = "Action missing from video GMSG.";
        } else {
            if (com.google.android.gms.ads.internal.util.client.zzb.zzL(3)) {
                JSONObject jSONObject = new JSONObject(map);
                jSONObject.remove("google.afma.Notify_dt");
                com.google.android.gms.ads.internal.util.client.zzb.zzay("Video GMSG: " + str4 + " " + jSONObject.toString());
            }
            if ("background".equals(str4)) {
                String str5 = map.get("color");
                if (!TextUtils.isEmpty(str5)) {
                    try {
                        int color = Color.parseColor(str5);
                        com.google.android.gms.ads.internal.overlay.zzc zzcVarZzgD = zzidVar.zzgD();
                        if (zzcVarZzgD == null || (zzhVarZzeq = zzcVarZzgD.zzeq()) == null) {
                            this.zzwA.put(zzidVar, Integer.valueOf(color));
                            return;
                        } else {
                            zzhVarZzeq.setBackgroundColor(color);
                            return;
                        }
                    } catch (IllegalArgumentException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Invalid color parameter in video GMSG.");
                        return;
                    }
                }
                str3 = "Color parameter missing from color video GMSG.";
            } else {
                com.google.android.gms.ads.internal.overlay.zzc zzcVarZzgD2 = zzidVar.zzgD();
                if (zzcVarZzgD2 != null) {
                    boolean zEquals = "new".equals(str4);
                    boolean zEquals2 = "position".equals(str4);
                    if (zEquals || zEquals2) {
                        Context context = zzidVar.getContext();
                        int iZza = zza(context, map, "x", 0);
                        int iZza2 = zza(context, map, "y", 0);
                        int iZza3 = zza(context, map, "w", -1);
                        int iZza4 = zza(context, map, "h", -1);
                        if (!zEquals || zzcVarZzgD2.zzeq() != null) {
                            zzcVarZzgD2.zzd(iZza, iZza2, iZza3, iZza4);
                            return;
                        }
                        zzcVarZzgD2.zze(iZza, iZza2, iZza3, iZza4);
                        if (this.zzwA.containsKey(zzidVar)) {
                            zzcVarZzgD2.zzeq().setBackgroundColor(this.zzwA.get(zzidVar).intValue());
                            return;
                        }
                        return;
                    }
                    com.google.android.gms.ads.internal.overlay.zzh zzhVarZzeq2 = zzcVarZzgD2.zzeq();
                    if (zzhVarZzeq2 == null) {
                        com.google.android.gms.ads.internal.overlay.zzh.zzd(zzidVar);
                        return;
                    }
                    if ("click".equals(str4)) {
                        Context context2 = zzidVar.getContext();
                        int iZza5 = zza(context2, map, "x", 0);
                        int iZza6 = zza(context2, map, "y", 0);
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZza5, iZza6, 0);
                        zzhVarZzeq2.zzc(motionEventObtain);
                        motionEventObtain.recycle();
                        return;
                    }
                    if ("currentTime".equals(str4)) {
                        str = map.get("time");
                        if (str != null) {
                            try {
                                zzhVarZzeq2.seekTo((int) (Float.parseFloat(str) * 1000.0f));
                                return;
                            } catch (NumberFormatException e2) {
                                sb = new StringBuilder();
                                str2 = "Could not parse time parameter from currentTime video GMSG: ";
                                sb.append(str2);
                                sb.append(str);
                                string = sb.toString();
                                com.google.android.gms.ads.internal.util.client.zzb.zzaC(string);
                                return;
                            }
                        }
                        str3 = "Time parameter missing from currentTime video GMSG.";
                    } else {
                        if ("hide".equals(str4)) {
                            zzhVarZzeq2.setVisibility(4);
                            return;
                        }
                        if ("load".equals(str4)) {
                            zzhVarZzeq2.zzeH();
                            return;
                        }
                        if ("muted".equals(str4)) {
                            if (Boolean.parseBoolean(map.get("muted"))) {
                                zzhVarZzeq2.zzeI();
                                return;
                            } else {
                                zzhVarZzeq2.zzeJ();
                                return;
                            }
                        }
                        if ("pause".equals(str4)) {
                            zzhVarZzeq2.pause();
                            return;
                        }
                        if ("play".equals(str4)) {
                            zzhVarZzeq2.play();
                            return;
                        }
                        if ("show".equals(str4)) {
                            zzhVarZzeq2.setVisibility(0);
                            return;
                        }
                        if ("src".equals(str4)) {
                            zzhVarZzeq2.zzah(map.get("src"));
                            return;
                        }
                        if (MediaRouteProviderProtocol.CLIENT_DATA_VOLUME.equals(str4)) {
                            str = map.get(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
                            if (str != null) {
                                try {
                                    zzhVarZzeq2.zza(Float.parseFloat(str));
                                    return;
                                } catch (NumberFormatException e3) {
                                    sb = new StringBuilder();
                                    str2 = "Could not parse volume parameter from volume video GMSG: ";
                                    sb.append(str2);
                                    sb.append(str);
                                    string = sb.toString();
                                    com.google.android.gms.ads.internal.util.client.zzb.zzaC(string);
                                    return;
                                }
                            }
                            str3 = "Level parameter missing from volume video GMSG.";
                        } else {
                            if ("watermark".equals(str4)) {
                                zzhVarZzeq2.zzeK();
                                return;
                            }
                            string = "Unknown video action: " + str4;
                        }
                    }
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC(string);
                    return;
                }
                str3 = "Could not get ad overlay for a video GMSG.";
            }
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(str3);
    }
}
