package b.t;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f1137a = new b.t.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal<WeakReference<b.f.a<ViewGroup, ArrayList<i>>>> f1138b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList<ViewGroup> f1139c = new ArrayList<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f1140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ViewGroup f1141c;

        /* JADX INFO: renamed from: b.t.m$a$a, reason: collision with other inner class name */
        public class C0047a extends l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.f.a f1142a;

            public C0047a(b.f.a aVar) {
                this.f1142a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.t.i.d
            public void c(i iVar) {
                ((ArrayList) this.f1142a.get(a.this.f1141c)).remove(iVar);
                iVar.w(this);
            }
        }

        public a(i iVar, ViewGroup viewGroup) {
            this.f1140b = iVar;
            this.f1141c = viewGroup;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:140:0x02b5  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onPreDraw() {
            /*
                Method dump skipped, instruction units count: 695
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.t.m.a.onPreDraw():boolean");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f1141c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1141c.removeOnAttachStateChangeListener(this);
            m.f1139c.remove(this.f1141c);
            ArrayList<i> arrayList = m.a().get(this.f1141c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<i> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().y(this.f1141c);
                }
            }
            this.f1140b.j(true);
        }
    }

    public static b.f.a<ViewGroup, ArrayList<i>> a() {
        b.f.a<ViewGroup, ArrayList<i>> aVar;
        WeakReference<b.f.a<ViewGroup, ArrayList<i>>> weakReference = f1138b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        b.f.a<ViewGroup, ArrayList<i>> aVar2 = new b.f.a<>();
        f1138b.set(new WeakReference<>(aVar2));
        return aVar2;
    }
}
