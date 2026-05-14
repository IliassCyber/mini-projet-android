package b.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.t.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0 extends i {
    public static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    public int J = 3;

    public static class a extends AnimatorListenerAdapter implements i.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f1124c;
        public final boolean d;
        public boolean e;
        public boolean f = false;

        public a(View view, int i, boolean z) {
            this.f1122a = view;
            this.f1123b = i;
            this.f1124c = (ViewGroup) view.getParent();
            this.d = z;
            g(true);
        }

        @Override // b.t.i.d
        public void a(i iVar) {
        }

        @Override // b.t.i.d
        public void b(i iVar) {
        }

        @Override // b.t.i.d
        public void c(i iVar) {
            f();
            iVar.w(this);
        }

        @Override // b.t.i.d
        public void d(i iVar) {
            g(false);
        }

        @Override // b.t.i.d
        public void e(i iVar) {
            g(true);
        }

        public final void f() {
            if (!this.f) {
                v.f1155a.f(this.f1122a, this.f1123b);
                ViewGroup viewGroup = this.f1124c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.d || this.e == z || (viewGroup = this.f1124c) == null) {
                return;
            }
            this.e = z;
            s.a(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f) {
                return;
            }
            v.f1155a.f(this.f1122a, this.f1123b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f) {
                return;
            }
            v.f1155a.f(this.f1122a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1127c;
        public int d;
        public ViewGroup e;
        public ViewGroup f;
    }

    public final void I(q qVar) {
        qVar.f1147a.put("android:visibility:visibility", Integer.valueOf(qVar.f1148b.getVisibility()));
        qVar.f1147a.put("android:visibility:parent", qVar.f1148b.getParent());
        int[] iArr = new int[2];
        qVar.f1148b.getLocationOnScreen(iArr);
        qVar.f1147a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r9 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (r0.e == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r0.f1127c == 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b.t.d0.b J(b.t.q r8, b.t.q r9) {
        /*
            r7 = this;
            b.t.d0$b r0 = new b.t.d0$b
            r0.<init>()
            r1 = 0
            r0.f1125a = r1
            r0.f1126b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f1147a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f1147a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f1127c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f1147a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L37
        L33:
            r0.f1127c = r4
            r0.e = r3
        L37:
            if (r9 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f1147a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f1147a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f1147a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L5e
        L5a:
            r0.d = r4
            r0.f = r3
        L5e:
            r2 = 1
            if (r8 == 0) goto L86
            if (r9 == 0) goto L86
            int r8 = r0.f1127c
            int r9 = r0.d
            if (r8 != r9) goto L70
            android.view.ViewGroup r8 = r0.e
            android.view.ViewGroup r9 = r0.f
            if (r8 != r9) goto L70
            return r0
        L70:
            int r8 = r0.f1127c
            int r9 = r0.d
            if (r8 == r9) goto L7c
            if (r8 != 0) goto L79
            goto L97
        L79:
            if (r9 != 0) goto L9a
            goto L8c
        L7c:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L81
            goto L97
        L81:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L9a
            goto L8c
        L86:
            if (r8 != 0) goto L91
            int r8 = r0.d
            if (r8 != 0) goto L91
        L8c:
            r0.f1126b = r2
        L8e:
            r0.f1125a = r2
            goto L9a
        L91:
            if (r9 != 0) goto L9a
            int r8 = r0.f1127c
            if (r8 != 0) goto L9a
        L97:
            r0.f1126b = r1
            goto L8e
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.t.d0.J(b.t.q, b.t.q):b.t.d0$b");
    }

    public abstract Animator K(ViewGroup viewGroup, View view, q qVar, q qVar2);

    @Override // b.t.i
    public void e(q qVar) {
        I(qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e7 A[PHI: r6
  0x00e7: PHI (r6v3 android.view.View) = 
  (r6v2 android.view.View)
  (r6v2 android.view.View)
  (r6v2 android.view.View)
  (r6v2 android.view.View)
  (r6v2 android.view.View)
  (r6v2 android.view.View)
  (r6v6 android.view.View)
 binds: [B:54:0x00a0, B:59:0x00af, B:64:0x00d4, B:66:0x00d7, B:68:0x00dd, B:70:0x00e1, B:62:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.t.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator l(android.view.ViewGroup r13, b.t.q r14, b.t.q r15) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.t.d0.l(android.view.ViewGroup, b.t.q, b.t.q):android.animation.Animator");
    }

    @Override // b.t.i
    public String[] q() {
        return K;
    }

    @Override // b.t.i
    public boolean s(q qVar, q qVar2) {
        if (qVar == null && qVar2 == null) {
            return false;
        }
        if (qVar != null && qVar2 != null && qVar2.f1147a.containsKey("android:visibility:visibility") != qVar.f1147a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b bVarJ = J(qVar, qVar2);
        if (bVarJ.f1125a) {
            return bVarJ.f1127c == 0 || bVarJ.d == 0;
        }
        return false;
    }
}
