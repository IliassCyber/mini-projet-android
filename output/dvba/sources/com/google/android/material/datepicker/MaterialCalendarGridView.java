package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import b.i.l.b;
import b.i.m.l;
import c.c.a.a.c.l.q;
import c.c.a.b.f;
import c.c.a.b.u.c;
import c.c.a.b.u.d;
import c.c.a.b.u.m;
import c.c.a.b.u.n;
import c.c.a.b.u.p;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Calendar f1992b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1992b = q.F();
        if (n.c0(getContext())) {
            setNextFocusLeftId(f.cancel_button);
            setNextFocusRightId(f.confirm_button);
        }
        l.W(this, new m(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public p getAdapter() {
        return (p) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iA;
        int width;
        int iA2;
        int width2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        p adapter = getAdapter();
        d<?> dVar = adapter.f1711c;
        c cVar = adapter.d;
        Long item = adapter.getItem(adapter.a());
        Long item2 = adapter.getItem(adapter.c());
        for (b<Long, Long> bVar : dVar.d()) {
            Long l = bVar.f814a;
            if (l != null) {
                if (bVar.f815b == null) {
                    continue;
                } else {
                    long jLongValue = l.longValue();
                    long jLongValue2 = bVar.f815b.longValue();
                    Long lValueOf = Long.valueOf(jLongValue);
                    Long lValueOf2 = Long.valueOf(jLongValue2);
                    int i = 1;
                    if (item == null || item2 == null || lValueOf == null || lValueOf2 == null || lValueOf.longValue() > item2.longValue() || lValueOf2.longValue() < item.longValue()) {
                        return;
                    }
                    if (jLongValue < item.longValue()) {
                        iA = adapter.a();
                        width = iA % adapter.f1710b.f == 0 ? 0 : materialCalendarGridView.getChildAt(iA - 1).getRight();
                    } else {
                        materialCalendarGridView.f1992b.setTimeInMillis(jLongValue);
                        iA = (materialCalendarGridView.f1992b.get(5) - 1) + adapter.a();
                        View childAt = materialCalendarGridView.getChildAt(iA);
                        width = (childAt.getWidth() / 2) + childAt.getLeft();
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iA2 = adapter.c();
                        width2 = (iA2 + 1) % adapter.f1710b.f == 0 ? getWidth() : materialCalendarGridView.getChildAt(iA2).getRight();
                    } else {
                        materialCalendarGridView.f1992b.setTimeInMillis(jLongValue2);
                        iA2 = (materialCalendarGridView.f1992b.get(5) - 1) + adapter.a();
                        View childAt2 = materialCalendarGridView.getChildAt(iA2);
                        width2 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int itemId2 = (int) adapter.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - i;
                        View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > iA ? 0 : width, childAt3.getTop() + cVar.f1687a.f1684a.top, iA2 > numColumns2 ? getWidth() : width2, childAt3.getBottom() - cVar.f1687a.f1684a.bottom, cVar.h);
                        itemId++;
                        i = 1;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        int iA;
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            iA = getAdapter().c();
        } else {
            if (i != 130) {
                super.onFocusChanged(true, i, rect);
                return;
            }
            iA = getAdapter().a();
        }
        setSelection(iA);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof p)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), p.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().a()) {
            i = getAdapter().a();
        }
        super.setSelection(i);
    }
}
