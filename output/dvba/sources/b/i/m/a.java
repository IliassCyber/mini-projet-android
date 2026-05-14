package b.i.m;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.i.m.v.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f819c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.AccessibilityDelegate f821b;

    /* JADX INFO: renamed from: b.i.m.a$a, reason: collision with other inner class name */
    public static final class C0033a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f822a;

        public C0033a(a aVar) {
            this.f822a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f822a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            b.i.m.v.c cVarB = this.f822a.b(view);
            if (cVarB != null) {
                return (AccessibilityNodeProvider) cVarB.f872a;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f822a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            int iKeyAt;
            b.i.m.v.b bVar = new b.i.m.v.b(accessibilityNodeInfo);
            boolean zH = l.H(view);
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.f864a.setScreenReaderFocusable(zH);
            } else {
                bVar.h(1, zH);
            }
            Boolean boolD = new o(b.i.b.tag_accessibility_heading, Boolean.class, 28).d(view);
            boolean zBooleanValue = boolD == null ? false : boolD.booleanValue();
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.f864a.setHeading(zBooleanValue);
            } else {
                bVar.h(2, zBooleanValue);
            }
            CharSequence charSequenceD = new n(b.i.b.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view);
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.f864a.setPaneTitle(charSequenceD);
            } else {
                bVar.f864a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequenceD);
            }
            this.f822a.d(view, bVar);
            CharSequence text = accessibilityNodeInfo.getText();
            if (Build.VERSION.SDK_INT < 26) {
                bVar.f864a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                bVar.f864a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                bVar.f864a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                bVar.f864a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view.getTag(b.i.b.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        if (((WeakReference) sparseArray.valueAt(i)).get() == null) {
                            arrayList.add(Integer.valueOf(i));
                        }
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        sparseArray.remove(((Integer) arrayList.get(i2)).intValue());
                    }
                }
                ClickableSpan[] clickableSpanArrD = b.i.m.v.b.d(text);
                if (clickableSpanArrD != null && clickableSpanArrD.length > 0) {
                    bVar.f().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", b.i.b.accessibility_action_clickable_span);
                    SparseArray sparseArray2 = (SparseArray) view.getTag(b.i.b.tag_accessibility_clickable_spans);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(b.i.b.tag_accessibility_clickable_spans, sparseArray2);
                    }
                    for (int i3 = 0; i3 < clickableSpanArrD.length; i3++) {
                        ClickableSpan clickableSpan = clickableSpanArrD[i3];
                        int i4 = 0;
                        while (true) {
                            if (i4 >= sparseArray2.size()) {
                                iKeyAt = b.i.m.v.b.d;
                                b.i.m.v.b.d = iKeyAt + 1;
                                break;
                            } else {
                                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i4)).get())) {
                                    iKeyAt = sparseArray2.keyAt(i4);
                                    break;
                                }
                                i4++;
                            }
                        }
                        sparseArray2.put(iKeyAt, new WeakReference(clickableSpanArrD[i3]));
                        ClickableSpan clickableSpan2 = clickableSpanArrD[i3];
                        Spanned spanned = (Spanned) text;
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(iKeyAt));
                    }
                }
            }
            List listEmptyList = (List) view.getTag(b.i.b.tag_accessibility_actions);
            if (listEmptyList == null) {
                listEmptyList = Collections.emptyList();
            }
            for (int i5 = 0; i5 < listEmptyList.size(); i5++) {
                bVar.a((b.a) listEmptyList.get(i5));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f822a.e(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f822a.f(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f822a.g(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f822a.h(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f822a.i(view, accessibilityEvent);
        }
    }

    public a() {
        this.f820a = f819c;
        this.f821b = new C0033a(this);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f820a = accessibilityDelegate;
        this.f821b = new C0033a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f820a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public b.i.m.v.c b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f820a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new b.i.m.v.c(accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f820a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, b.i.m.v.b bVar) {
        this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f820a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f820a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(android.view.View r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            int r0 = b.i.b.tag_accessibility_actions
            java.lang.Object r0 = r8.getTag(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto Le
            java.util.List r0 = java.util.Collections.emptyList()
        Le:
            r1 = 0
            r2 = 0
        L10:
            int r3 = r0.size()
            r4 = 1
            if (r2 >= r3) goto L70
            java.lang.Object r3 = r0.get(r2)
            b.i.m.v.b$a r3 = (b.i.m.v.b.a) r3
            int r5 = r3.a()
            if (r5 != r9) goto L6d
            b.i.m.v.d r0 = r3.d
            if (r0 == 0) goto L70
            java.lang.Class<? extends b.i.m.v.d$a> r0 = r3.f869c
            if (r0 == 0) goto L60
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L3e
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r2)     // Catch: java.lang.Exception -> L3e
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L3e
            java.lang.Object r0 = r0.newInstance(r2)     // Catch: java.lang.Exception -> L3e
            b.i.m.v.d$a r0 = (b.i.m.v.d.a) r0     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L3c
            goto L60
        L3c:
            r0 = 0
            throw r0     // Catch: java.lang.Exception -> L3e
        L3e:
            r0 = move-exception
            java.lang.Class<? extends b.i.m.v.d$a> r2 = r3.f869c
            if (r2 != 0) goto L46
            java.lang.String r2 = "null"
            goto L4a
        L46:
            java.lang.String r2 = r2.getName()
        L4a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to execute command with argument class ViewCommandArgument: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r5 = "A11yActionCompat"
            android.util.Log.e(r5, r2, r0)
        L60:
            b.i.m.v.d r0 = r3.d
            com.google.android.material.bottomsheet.BottomSheetBehavior$c r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior.c) r0
            com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
            int r0 = r0.f1984a
            r2.J(r0)
            r0 = 1
            goto L71
        L6d:
            int r2 = r2 + 1
            goto L10
        L70:
            r0 = 0
        L71:
            if (r0 != 0) goto L79
            android.view.View$AccessibilityDelegate r0 = r7.f820a
            boolean r0 = r0.performAccessibilityAction(r8, r9, r10)
        L79:
            if (r0 != 0) goto Lc7
            int r2 = b.i.b.accessibility_action_clickable_span
            if (r9 != r2) goto Lc7
            r9 = -1
            java.lang.String r0 = "ACCESSIBILITY_CLICKABLE_SPAN_ID"
            int r9 = r10.getInt(r0, r9)
            int r10 = b.i.b.tag_accessibility_clickable_spans
            java.lang.Object r10 = r8.getTag(r10)
            android.util.SparseArray r10 = (android.util.SparseArray) r10
            if (r10 == 0) goto Lc6
            java.lang.Object r9 = r10.get(r9)
            java.lang.ref.WeakReference r9 = (java.lang.ref.WeakReference) r9
            if (r9 == 0) goto Lc6
            java.lang.Object r9 = r9.get()
            android.text.style.ClickableSpan r9 = (android.text.style.ClickableSpan) r9
            if (r9 == 0) goto Lbf
            android.view.accessibility.AccessibilityNodeInfo r10 = r8.createAccessibilityNodeInfo()
            java.lang.CharSequence r10 = r10.getText()
            android.text.style.ClickableSpan[] r10 = b.i.m.v.b.d(r10)
            r0 = 0
        Lad:
            if (r10 == 0) goto Lbf
            int r2 = r10.length
            if (r0 >= r2) goto Lbf
            r2 = r10[r0]
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto Lbc
            r10 = 1
            goto Lc0
        Lbc:
            int r0 = r0 + 1
            goto Lad
        Lbf:
            r10 = 0
        Lc0:
            if (r10 == 0) goto Lc6
            r9.onClick(r8)
            r1 = 1
        Lc6:
            r0 = r1
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.m.a.g(android.view.View, int, android.os.Bundle):boolean");
    }

    public void h(View view, int i) {
        this.f820a.sendAccessibilityEvent(view, i);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f820a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
