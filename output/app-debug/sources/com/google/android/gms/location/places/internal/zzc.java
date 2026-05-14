package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient googleApiClient, final AddPlaceRequest addPlaceRequest) {
        return googleApiClient.zzb(new zzm.zzc<zzd>(Places.zzazQ, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzc.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0032zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zza(new com.google.android.gms.location.places.zzm(this, zzdVar.getContext()), addPlaceRequest);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient googleApiClient, final String str, final LatLngBounds latLngBounds, final AutocompleteFilter autocompleteFilter) {
        return googleApiClient.zza(new zzm.zza<zzd>(Places.zzazQ, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzc.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0032zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zza(new com.google.android.gms.location.places.zzm(this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient googleApiClient, final String... strArr) {
        com.google.android.gms.common.internal.zzu.zzV(strArr != null && strArr.length >= 1);
        return googleApiClient.zza(new zzm.zzc<zzd>(Places.zzazQ, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzc.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0032zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zza(new com.google.android.gms.location.places.zzm(this, zzdVar.getContext()), Arrays.asList(strArr));
            }
        });
    }
}
