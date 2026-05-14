package c.c.a.b.u;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class e extends BaseAdapter {
    public static final int e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Calendar f1690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1691c;
    public final int d;

    static {
        e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar calendarF = c.c.a.a.c.l.q.F();
        this.f1690b = calendarF;
        this.f1691c = calendarF.getMaximum(7);
        this.d = this.f1690b.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1691c;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int i2 = this.f1691c;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.d;
        if (i3 > i2) {
            i3 -= i2;
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(c.c.a.b.h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f1690b;
        int i2 = i + this.d;
        int i3 = this.f1691c;
        if (i2 > i3) {
            i2 -= i3;
        }
        calendar.set(7, i2);
        textView.setText(this.f1690b.getDisplayName(7, e, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(c.c.a.b.i.mtrl_picker_day_of_week_column_header), this.f1690b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
