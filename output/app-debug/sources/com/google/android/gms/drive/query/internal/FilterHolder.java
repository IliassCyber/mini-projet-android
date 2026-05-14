package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.query.Filter;

/* JADX INFO: loaded from: classes.dex */
public class FilterHolder implements SafeParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzd();
    final int zzCY;
    private final Filter zzadx;
    final ComparisonFilter<?> zzahU;
    final FieldOnlyFilter zzahV;
    final LogicalFilter zzahW;
    final NotFilter zzahX;
    final InFilter<?> zzahY;
    final MatchAllFilter zzahZ;
    final HasFilter zzaia;
    final FullTextSearchFilter zzaib;
    final OwnedByMeFilter zzaic;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FilterHolder(int i, ComparisonFilter<?> comparisonFilter, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> inFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter, OwnedByMeFilter ownedByMeFilter) {
        this.zzCY = i;
        this.zzahU = comparisonFilter;
        this.zzahV = fieldOnlyFilter;
        this.zzahW = logicalFilter;
        this.zzahX = notFilter;
        this.zzahY = inFilter;
        this.zzahZ = matchAllFilter;
        this.zzaia = hasFilter;
        this.zzaib = fullTextSearchFilter;
        this.zzaic = ownedByMeFilter;
        Filter filter = this.zzahU;
        if (filter == null && (filter = this.zzahV) == null && (filter = this.zzahW) == null && (filter = this.zzahX) == null && (filter = this.zzahY) == null && (filter = this.zzahZ) == null && (filter = this.zzaia) == null && (filter = this.zzaib) == null && (filter = this.zzaic) == null) {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
        this.zzadx = filter;
    }

    public FilterHolder(Filter filter) {
        zzu.zzb(filter, "Null filter.");
        this.zzCY = 2;
        this.zzahU = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.zzahV = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.zzahW = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.zzahX = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.zzahY = filter instanceof InFilter ? (InFilter) filter : null;
        this.zzahZ = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.zzaia = filter instanceof HasFilter ? (HasFilter) filter : null;
        this.zzaib = filter instanceof FullTextSearchFilter ? (FullTextSearchFilter) filter : null;
        this.zzaic = filter instanceof OwnedByMeFilter ? (OwnedByMeFilter) filter : null;
        if (this.zzahU == null && this.zzahV == null && this.zzahW == null && this.zzahX == null && this.zzahY == null && this.zzahZ == null && this.zzaia == null && this.zzaib == null && this.zzaic == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzadx = filter;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzadx;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", this.zzadx);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
