package android.support.v4.media;

import a.a.a.b.b;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$SearchResultReceiver extends b {
    @Override // a.a.a.b.b
    public void c(int i, Bundle bundle) {
        Parcelable[] parcelableArray;
        MediaSessionCompat.a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("search_results") || (parcelableArray = bundle.getParcelableArray("search_results")) == null) {
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : parcelableArray) {
            arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
        }
        throw null;
    }
}
