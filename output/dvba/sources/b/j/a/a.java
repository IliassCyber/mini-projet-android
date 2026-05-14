package b.j.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import b.j.a.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f885c;
    public Cursor d;
    public Context e;
    public int f;
    public C0036a g;
    public DataSetObserver h;
    public b.j.a.b i;

    /* JADX INFO: renamed from: b.j.a.a$a, reason: collision with other inner class name */
    public class C0036a extends ContentObserver {
        public C0036a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (!aVar.f885c || (cursor = aVar.d) == null || cursor.isClosed()) {
                return;
            }
            aVar.f884b = aVar.d.requery();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f884b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f884b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        b bVar;
        int i = z ? 1 : 2;
        if ((i & 1) == 1) {
            i |= 2;
            this.f885c = true;
        } else {
            this.f885c = false;
        }
        boolean z2 = cursor != null;
        this.d = cursor;
        this.f884b = z2;
        this.e = context;
        this.f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.g = new C0036a();
            bVar = new b();
        } else {
            bVar = null;
            this.g = null;
        }
        this.h = bVar;
        if (z2) {
            C0036a c0036a = this.g;
            if (c0036a != null) {
                cursor.registerContentObserver(c0036a);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0036a c0036a = this.g;
                if (c0036a != null) {
                    cursor2.unregisterContentObserver(c0036a);
                }
                DataSetObserver dataSetObserver = this.h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.d = cursor;
            if (cursor != null) {
                C0036a c0036a2 = this.g;
                if (c0036a2 != null) {
                    cursor.registerContentObserver(c0036a2);
                }
                DataSetObserver dataSetObserver2 = this.h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f = cursor.getColumnIndexOrThrow("_id");
                this.f884b = true;
                notifyDataSetChanged();
            } else {
                this.f = -1;
                this.f884b = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract View d(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f884b || (cursor = this.d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f884b) {
            return null;
        }
        this.d.moveToPosition(i);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.l.inflate(cVar.k, viewGroup, false);
        }
        a(view, this.e, this.d);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i == null) {
            this.i = new b.j.a.b(this);
        }
        return this.i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f884b || (cursor = this.d) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f884b && (cursor = this.d) != null && cursor.moveToPosition(i)) {
            return this.d.getLong(this.f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f884b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.d.moveToPosition(i)) {
            if (view == null) {
                view = d(this.e, this.d, viewGroup);
            }
            a(view, this.e, this.d);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }
}
