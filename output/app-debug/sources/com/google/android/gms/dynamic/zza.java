package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza<T extends LifecycleDelegate> {
    private T zzajh;
    private Bundle zzaji;
    private LinkedList<InterfaceC0060zza> zzajj;
    private final zzf<T> zzajk = (zzf<T>) new zzf<T>() { // from class: com.google.android.gms.dynamic.zza.1
        @Override // com.google.android.gms.dynamic.zzf
        public void zza(T t) {
            zza.this.zzajh = t;
            Iterator it = zza.this.zzajj.iterator();
            while (it.hasNext()) {
                ((InterfaceC0060zza) it.next()).zzb(zza.this.zzajh);
            }
            zza.this.zzajj.clear();
            zza.this.zzaji = null;
        }
    };

    /* JADX INFO: renamed from: com.google.android.gms.dynamic.zza$zza, reason: collision with other inner class name */
    private interface InterfaceC0060zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, InterfaceC0060zza interfaceC0060zza) {
        T t = this.zzajh;
        if (t != null) {
            interfaceC0060zza.zzb(t);
            return;
        }
        if (this.zzajj == null) {
            this.zzajj = new LinkedList<>();
        }
        this.zzajj.add(interfaceC0060zza);
        if (bundle != null) {
            Bundle bundle2 = this.zzaji;
            if (bundle2 == null) {
                this.zzaji = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        zza(this.zzajk);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String strZzb = com.google.android.gms.common.internal.zzf.zzb(context, iIsGooglePlayServicesAvailable, GooglePlayServicesUtil.zzad(context));
        String strZzh = com.google.android.gms.common.internal.zzf.zzh(context, iIsGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strZzb);
        linearLayout.addView(textView);
        if (strZzh != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strZzh);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.dynamic.zza.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzaT(iIsGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzdY(int i) {
        while (!this.zzajj.isEmpty() && this.zzajj.getLast().getState() >= i) {
            this.zzajj.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, new InterfaceC0060zza() { // from class: com.google.android.gms.dynamic.zza.3
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public int getState() {
                return 1;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzajh.onCreate(bundle);
            }
        });
    }

    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zza(bundle, new InterfaceC0060zza() { // from class: com.google.android.gms.dynamic.zza.4
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public int getState() {
                return 2;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.zzajh.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.zzajh == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        T t = this.zzajh;
        if (t != null) {
            t.onDestroy();
        } else {
            zzdY(1);
        }
    }

    public void onDestroyView() {
        T t = this.zzajh;
        if (t != null) {
            t.onDestroyView();
        } else {
            zzdY(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, new InterfaceC0060zza() { // from class: com.google.android.gms.dynamic.zza.2
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public int getState() {
                return 0;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzajh.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        T t = this.zzajh;
        if (t != null) {
            t.onLowMemory();
        }
    }

    public void onPause() {
        T t = this.zzajh;
        if (t != null) {
            t.onPause();
        } else {
            zzdY(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, new InterfaceC0060zza() { // from class: com.google.android.gms.dynamic.zza.7
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public int getState() {
                return 5;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzajh.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t = this.zzajh;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.zzaji;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        zza((Bundle) null, new InterfaceC0060zza() { // from class: com.google.android.gms.dynamic.zza.6
            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public int getState() {
                return 4;
            }

            @Override // com.google.android.gms.dynamic.zza.InterfaceC0060zza
            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzajh.onStart();
            }
        });
    }

    public void onStop() {
        T t = this.zzajh;
        if (t != null) {
            t.onStop();
        } else {
            zzdY(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> zzfVar);

    public T zzqj() {
        return this.zzajh;
    }
}
