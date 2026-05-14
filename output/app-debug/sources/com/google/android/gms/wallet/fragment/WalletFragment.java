package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* JADX INFO: loaded from: classes.dex */
public final class WalletFragment extends Fragment {
    private WalletFragmentOptions zzaRS;
    private WalletFragmentInitParams zzaRT;
    private MaskedWalletRequest zzaRU;
    private MaskedWallet zzaRV;
    private Boolean zzaRW;
    private zzb zzaSb;
    private boolean mCreated = false;
    private final com.google.android.gms.dynamic.zzb zzaSc = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzaSd = new zzc();
    private zza zzaSe = new zza(this);
    private final Fragment zzajt = this;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends zzqr.zza {
        private OnStateChangedListener zzaSf;
        private final WalletFragment zzaSg;

        zza(WalletFragment walletFragment) {
            this.zzaSg = walletFragment;
        }

        @Override // com.google.android.gms.internal.zzqr
        public void zza(int i, int i2, Bundle bundle) {
            OnStateChangedListener onStateChangedListener = this.zzaSf;
            if (onStateChangedListener != null) {
                onStateChangedListener.onStateChanged(this.zzaSg, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaSf = onStateChangedListener;
        }
    }

    private static class zzb implements LifecycleDelegate {
        private final zzqq zzaRZ;

        private zzb(zzqq zzqqVar) {
            this.zzaRZ = zzqqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getState() {
            try {
                return this.zzaRZ.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
            try {
                this.zzaRZ.initialize(walletFragmentInitParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onActivityResult(int i, int i2, Intent intent) {
            try {
                this.zzaRZ.onActivityResult(i, i2, intent);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnabled(boolean z) {
            try {
                this.zzaRZ.setEnabled(z);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaRZ.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            try {
                this.zzaRZ.updateMaskedWalletRequest(maskedWalletRequest);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.zzaRZ.onCreate(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzn(this.zzaRZ.onCreateView(zze.zzw(layoutInflater), zze.zzw(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.zzaRZ.zza(zze.zzw(activity), (WalletFragmentOptions) bundle.getParcelable("extraWalletFragmentOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzaRZ.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzaRZ.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaRZ.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.zzaRZ.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.zzaRZ.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements View.OnClickListener {
        private zzc() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = WalletFragment.this.zzajt.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            Button button = new Button(WalletFragment.this.zzajt.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int iZza = -1;
            int iZza2 = -2;
            if (WalletFragment.this.zzaRS != null && (fragmentStyle = WalletFragment.this.zzaRS.getFragmentStyle()) != null) {
                DisplayMetrics displayMetrics = WalletFragment.this.zzajt.getResources().getDisplayMetrics();
                iZza = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                iZza2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(iZza, iZza2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf<zzb> zzfVar) {
            Activity activity = WalletFragment.this.zzajt.getActivity();
            if (WalletFragment.this.zzaSb == null && WalletFragment.this.mCreated && activity != null) {
                try {
                    zzqq zzqqVarZza = zzqy.zza(activity, WalletFragment.this.zzaSc, WalletFragment.this.zzaRS, WalletFragment.this.zzaSe);
                    WalletFragment.this.zzaSb = new zzb(zzqqVarZza);
                    WalletFragment.this.zzaRS = null;
                    zzfVar.zza(WalletFragment.this.zzaSb);
                    if (WalletFragment.this.zzaRT != null) {
                        WalletFragment.this.zzaSb.initialize(WalletFragment.this.zzaRT);
                        WalletFragment.this.zzaRT = null;
                    }
                    if (WalletFragment.this.zzaRU != null) {
                        WalletFragment.this.zzaSb.updateMaskedWalletRequest(WalletFragment.this.zzaRU);
                        WalletFragment.this.zzaRU = null;
                    }
                    if (WalletFragment.this.zzaRV != null) {
                        WalletFragment.this.zzaSb.updateMaskedWallet(WalletFragment.this.zzaRV);
                        WalletFragment.this.zzaRV = null;
                    }
                    if (WalletFragment.this.zzaRW != null) {
                        WalletFragment.this.zzaSb.setEnabled(WalletFragment.this.zzaRW.booleanValue());
                        WalletFragment.this.zzaRW = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        walletFragment.zzajt.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        zzb zzbVar = this.zzaSb;
        if (zzbVar != null) {
            return zzbVar.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        String str;
        String str2;
        zzb zzbVar = this.zzaSb;
        if (zzbVar != null) {
            zzbVar.initialize(walletFragmentInitParams);
            this.zzaRT = null;
            return;
        }
        if (this.zzaRT == null) {
            this.zzaRT = walletFragmentInitParams;
            if (this.zzaRU != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaRV == null) {
                return;
            }
            str = "WalletFragment";
            str2 = "updateMaskedWallet() was called before initialize()";
        } else {
            str = "WalletFragment";
            str2 = "initialize(WalletFragmentInitParams) was called more than once. Ignoring.";
        }
        Log.w(str, str2);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        zzb zzbVar = this.zzaSb;
        if (zzbVar != null) {
            zzbVar.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaRT != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaRT = walletFragmentInitParams;
            }
            if (this.zzaRU == null) {
                this.zzaRU = (MaskedWalletRequest) bundle.getParcelable("maskedWalletRequest");
            }
            if (this.zzaRV == null) {
                this.zzaRV = (MaskedWallet) bundle.getParcelable("maskedWallet");
            }
            if (bundle.containsKey("walletFragmentOptions")) {
                this.zzaRS = (WalletFragmentOptions) bundle.getParcelable("walletFragmentOptions");
            }
            if (bundle.containsKey("enabled")) {
                this.zzaRW = Boolean.valueOf(bundle.getBoolean("enabled"));
            }
        } else if (this.zzajt.getArguments() != null && (walletFragmentOptions = (WalletFragmentOptions) this.zzajt.getArguments().getParcelable("extraWalletFragmentOptions")) != null) {
            walletFragmentOptions.zzaL(this.zzajt.getActivity());
            this.zzaRS = walletFragmentOptions;
        }
        this.mCreated = true;
        this.zzaSd.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzaSd.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    @Override // android.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        if (this.zzaRS == null) {
            this.zzaRS = WalletFragmentOptions.zza(activity, attributeSet);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("attrKeyWalletFragmentOptions", this.zzaRS);
        this.zzaSd.onInflate(activity, bundle2, bundle);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.zzaSd.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.zzaSd.onResume();
        FragmentManager fragmentManager = this.zzajt.getActivity().getFragmentManager();
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzajt.getActivity()), this.zzajt.getActivity(), -1);
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaSd.onSaveInstanceState(bundle);
        WalletFragmentInitParams walletFragmentInitParams = this.zzaRT;
        if (walletFragmentInitParams != null) {
            bundle.putParcelable("walletFragmentInitParams", walletFragmentInitParams);
            this.zzaRT = null;
        }
        MaskedWalletRequest maskedWalletRequest = this.zzaRU;
        if (maskedWalletRequest != null) {
            bundle.putParcelable("maskedWalletRequest", maskedWalletRequest);
            this.zzaRU = null;
        }
        MaskedWallet maskedWallet = this.zzaRV;
        if (maskedWallet != null) {
            bundle.putParcelable("maskedWallet", maskedWallet);
            this.zzaRV = null;
        }
        WalletFragmentOptions walletFragmentOptions = this.zzaRS;
        if (walletFragmentOptions != null) {
            bundle.putParcelable("walletFragmentOptions", walletFragmentOptions);
            this.zzaRS = null;
        }
        Boolean bool = this.zzaRW;
        if (bool != null) {
            bundle.putBoolean("enabled", bool.booleanValue());
            this.zzaRW = null;
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.zzaSd.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzaSd.onStop();
    }

    public void setEnabled(boolean z) {
        Boolean boolValueOf;
        zzb zzbVar = this.zzaSb;
        if (zzbVar != null) {
            zzbVar.setEnabled(z);
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(z);
        }
        this.zzaRW = boolValueOf;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.zzaSe.zza(onStateChangedListener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        zzb zzbVar = this.zzaSb;
        if (zzbVar == null) {
            this.zzaRV = maskedWallet;
        } else {
            zzbVar.updateMaskedWallet(maskedWallet);
            this.zzaRV = null;
        }
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        zzb zzbVar = this.zzaSb;
        if (zzbVar == null) {
            this.zzaRU = maskedWalletRequest;
        } else {
            zzbVar.updateMaskedWalletRequest(maskedWalletRequest);
            this.zzaRU = null;
        }
    }
}
