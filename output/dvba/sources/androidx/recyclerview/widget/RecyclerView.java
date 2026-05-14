package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import b.i.m.v.b;
import b.r.d.a;
import b.r.d.b;
import b.r.d.k;
import b.r.d.m;
import b.r.d.u;
import b.r.d.y;
import b.r.d.z;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements b.i.m.e {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    public static final boolean ALLOW_THREAD_GAP_WORK;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    public static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    public static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    public static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    public static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    public static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    public static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    public static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    public static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    public static final Interpolator sQuinticInterpolator;
    public b.r.d.u mAccessibilityDelegate;
    public final AccessibilityManager mAccessibilityManager;
    public g mAdapter;
    public b.r.d.a mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    public EdgeEffect mBottomGlow;
    public j mChildDrawingOrderCallback;
    public b.r.d.b mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    public int mDispatchScrollCounter;
    public int mEatenAccessibilityChangeFlags;
    public k mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public b.r.d.m mGapWorker;
    public boolean mHasFixedSize;
    public boolean mIgnoreMotionEventTillDown;
    public int mInitialTouchX;
    public int mInitialTouchY;
    public int mInterceptRequestLayoutDepth;
    public s mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public l mItemAnimator;
    public l.b mItemAnimatorListener;
    public Runnable mItemAnimatorRunner;
    public final ArrayList<n> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    public int mLastTouchX;
    public int mLastTouchY;
    public o mLayout;
    public int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    public EdgeEffect mLeftGlow;
    public final int mMaxFlingVelocity;
    public final int mMinFlingVelocity;
    public final int[] mMinMaxLayoutPositions;
    public final int[] mNestedOffsets;
    public final x mObserver;
    public List<q> mOnChildAttachStateListeners;
    public r mOnFlingListener;
    public final ArrayList<s> mOnItemTouchListeners;
    public final List<d0> mPendingAccessibilityImportanceChange;
    public y mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public m.b mPrefetchRegistry;
    public boolean mPreserveFocusAfterLayout;
    public final v mRecycler;
    public w mRecyclerListener;
    public final int[] mReusableIntPair;
    public EdgeEffect mRightGlow;
    public float mScaledHorizontalScrollFactor;
    public float mScaledVerticalScrollFactor;
    public t mScrollListener;
    public List<t> mScrollListeners;
    public final int[] mScrollOffset;
    public int mScrollPointerId;
    public int mScrollState;
    public b.i.m.f mScrollingChildHelper;
    public final a0 mState;
    public final Rect mTempRect;
    public final Rect mTempRect2;
    public final RectF mTempRectF;
    public EdgeEffect mTopGlow;
    public int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    public VelocityTracker mVelocityTracker;
    public final c0 mViewFlinger;
    public final z.b mViewInfoProcessCallback;
    public final b.r.d.z mViewInfoStore;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.mIsAttached) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.mLayoutSuppressed) {
                recyclerView2.mLayoutWasDefered = true;
            } else {
                recyclerView2.consumePendingUpdateOperations();
            }
        }
    }

    public static class a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f177a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f178b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f179c = 0;
        public int d = 1;
        public int e = 0;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;
        public int o;

        public void a(int i) {
            if ((this.d & i) != 0) {
                return;
            }
            StringBuilder sbE = c.a.a.a.a.e("Layout state should be one of ");
            sbE.append(Integer.toBinaryString(i));
            sbE.append(" but it is ");
            sbE.append(Integer.toBinaryString(this.d));
            throw new IllegalStateException(sbE.toString());
        }

        public int b() {
            return this.g ? this.f178b - this.f179c : this.e;
        }

        public String toString() {
            StringBuilder sbE = c.a.a.a.a.e("State{mTargetPosition=");
            sbE.append(this.f177a);
            sbE.append(", mData=");
            sbE.append((Object) null);
            sbE.append(", mItemCount=");
            sbE.append(this.e);
            sbE.append(", mIsMeasuring=");
            sbE.append(this.i);
            sbE.append(", mPreviousLayoutItemCount=");
            sbE.append(this.f178b);
            sbE.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sbE.append(this.f179c);
            sbE.append(", mStructureChanged=");
            sbE.append(this.f);
            sbE.append(", mInPreLayout=");
            sbE.append(this.g);
            sbE.append(", mRunSimpleAnimations=");
            sbE.append(this.j);
            sbE.append(", mRunPredictiveAnimations=");
            sbE.append(this.k);
            sbE.append('}');
            return sbE.toString();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.mItemAnimator;
            if (lVar != null) {
                b.r.d.k kVar = (b.r.d.k) lVar;
                boolean z = !kVar.h.isEmpty();
                boolean z2 = !kVar.j.isEmpty();
                boolean z3 = !kVar.k.isEmpty();
                boolean z4 = !kVar.i.isEmpty();
                if (z || z2 || z4 || z3) {
                    for (d0 d0Var : kVar.h) {
                        View view = d0Var.f184a;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        kVar.q.add(d0Var);
                        viewPropertyAnimatorAnimate.setDuration(kVar.d).alpha(0.0f).setListener(new b.r.d.f(kVar, d0Var, viewPropertyAnimatorAnimate, view)).start();
                    }
                    kVar.h.clear();
                    if (z2) {
                        ArrayList<k.b> arrayList = new ArrayList<>();
                        arrayList.addAll(kVar.j);
                        kVar.m.add(arrayList);
                        kVar.j.clear();
                        b.r.d.c cVar = new b.r.d.c(kVar, arrayList);
                        if (z) {
                            b.i.m.l.Q(arrayList.get(0).f1049a.f184a, cVar, kVar.d);
                        } else {
                            cVar.run();
                        }
                    }
                    if (z3) {
                        ArrayList<k.a> arrayList2 = new ArrayList<>();
                        arrayList2.addAll(kVar.k);
                        kVar.n.add(arrayList2);
                        kVar.k.clear();
                        b.r.d.d dVar = new b.r.d.d(kVar, arrayList2);
                        if (z) {
                            b.i.m.l.Q(arrayList2.get(0).f1046a.f184a, dVar, kVar.d);
                        } else {
                            dVar.run();
                        }
                    }
                    if (z4) {
                        ArrayList<d0> arrayList3 = new ArrayList<>();
                        arrayList3.addAll(kVar.i);
                        kVar.l.add(arrayList3);
                        kVar.i.clear();
                        b.r.d.e eVar = new b.r.d.e(kVar, arrayList3);
                        if (z || z2 || z3) {
                            b.i.m.l.Q(arrayList3.get(0).f184a, eVar, Math.max(z2 ? kVar.e : 0L, z3 ? kVar.f : 0L) + (z ? kVar.d : 0L));
                        } else {
                            eVar.run();
                        }
                    }
                }
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    public static abstract class b0 {
    }

    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c0 implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f182c;
        public OverScroller d;
        public Interpolator e = RecyclerView.sQuinticInterpolator;
        public boolean f = false;
        public boolean g = false;

        public c0() {
            this.d = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void a() {
            if (this.f) {
                this.g = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                b.i.m.l.P(RecyclerView.this, this);
            }
        }

        public void b(int i, int i2, int i3, Interpolator interpolator) {
            int iRound;
            if (i3 == Integer.MIN_VALUE) {
                int iAbs = Math.abs(i);
                int iAbs2 = Math.abs(i2);
                boolean z = iAbs > iAbs2;
                int iSqrt = (int) Math.sqrt(0);
                int iSqrt2 = (int) Math.sqrt((i2 * i2) + (i * i));
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                int i4 = width / 2;
                float f = width;
                float f2 = i4;
                float fSin = (((float) Math.sin((Math.min(1.0f, (iSqrt2 * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                if (iSqrt > 0) {
                    iRound = Math.round(Math.abs(fSin / iSqrt) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        iAbs = iAbs2;
                    }
                    iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
                }
                i3 = Math.min(iRound, RecyclerView.MAX_SCROLL_DURATION);
            }
            int i5 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.e != interpolator) {
                this.e = interpolator;
                this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f182c = 0;
            this.f181b = 0;
            RecyclerView.this.setScrollState(2);
            this.d.startScroll(0, 0, i, i2, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.d.computeScrollOffset();
            }
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.d.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                c();
                return;
            }
            this.g = false;
            this.f = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f181b;
                int i4 = currY - this.f182c;
                this.f181b = currX;
                this.f182c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    z zVar = recyclerView4.mLayout.g;
                    if (zVar != null && !zVar.d && zVar.e) {
                        int iB = recyclerView4.mState.b();
                        if (iB == 0) {
                            zVar.d();
                        } else {
                            if (zVar.f217a >= iB) {
                                zVar.f217a = iB - 1;
                            }
                            zVar.b(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i, i3, i4, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.mReusableIntPair;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    RecyclerView.this.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                z zVar2 = RecyclerView.this.mLayout.g;
                if ((zVar2 != null && zVar2.d) || !z) {
                    a();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    b.r.d.m mVar = recyclerView6.mGapWorker;
                    if (mVar != null) {
                        mVar.a(recyclerView6, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        m.b bVar = RecyclerView.this.mPrefetchRegistry;
                        int[] iArr7 = bVar.f1064c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.d = 0;
                    }
                }
            }
            z zVar3 = RecyclerView.this.mLayout.g;
            if (zVar3 != null && zVar3.d) {
                zVar3.b(0, 0);
            }
            this.f = false;
            if (this.g) {
                RecyclerView.this.removeCallbacks(this);
                b.i.m.l.P(RecyclerView.this, this);
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }
    }

    public class d implements z.b {
        public d() {
        }
    }

    public static abstract class d0 {
        public static final List<Object> s = Collections.emptyList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<RecyclerView> f185b;
        public int j;
        public RecyclerView r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f186c = -1;
        public int d = -1;
        public long e = -1;
        public int f = -1;
        public int g = -1;
        public d0 h = null;
        public d0 i = null;
        public List<Object> k = null;
        public List<Object> l = null;
        public int m = 0;
        public v n = null;
        public boolean o = false;
        public int p = 0;
        public int q = -1;

        public d0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f184a = view;
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
                return;
            }
            if ((1024 & this.j) == 0) {
                if (this.k == null) {
                    ArrayList arrayList = new ArrayList();
                    this.k = arrayList;
                    this.l = Collections.unmodifiableList(arrayList);
                }
                this.k.add(obj);
            }
        }

        public void b(int i) {
            this.j = i | this.j;
        }

        public void c() {
            this.d = -1;
            this.g = -1;
        }

        public void d() {
            this.j &= -33;
        }

        public final int e() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final int f() {
            int i = this.g;
            return i == -1 ? this.f186c : i;
        }

        public List<Object> g() {
            if ((this.j & 1024) != 0) {
                return s;
            }
            List<Object> list = this.k;
            return (list == null || list.size() == 0) ? s : this.l;
        }

        public boolean h(int i) {
            return (i & this.j) != 0;
        }

        public boolean i() {
            return (this.f184a.getParent() == null || this.f184a.getParent() == this.r) ? false : true;
        }

        public boolean j() {
            return (this.j & 1) != 0;
        }

        public boolean k() {
            return (this.j & 4) != 0;
        }

        public final boolean l() {
            return (this.j & 16) == 0 && !b.i.m.l.C(this.f184a);
        }

        public boolean m() {
            return (this.j & 8) != 0;
        }

        public boolean n() {
            return this.n != null;
        }

        public boolean o() {
            return (this.j & 256) != 0;
        }

        public boolean p() {
            return (this.j & 2) != 0;
        }

        public void q(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.f186c;
            }
            if (this.g == -1) {
                this.g = this.f186c;
            }
            if (z) {
                this.g += i;
            }
            this.f186c += i;
            if (this.f184a.getLayoutParams() != null) {
                ((p) this.f184a.getLayoutParams()).f207c = true;
            }
        }

        public void r() {
            this.j = 0;
            this.f186c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.m = 0;
            this.h = null;
            this.i = null;
            List<Object> list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
            this.p = 0;
            this.q = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void s(int i, int i2) {
            this.j = (i & i2) | (this.j & (~i2));
        }

        public final void t(boolean z) {
            int i;
            int i2 = this.m;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.m = i3;
            if (i3 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                i = this.j | 16;
            } else if (!z || this.m != 0) {
                return;
            } else {
                i = this.j & (-17);
            }
            this.j = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f186c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (n()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (k()) {
                sb.append(" invalid");
            }
            if (!j()) {
                sb.append(" unbound");
            }
            if ((this.j & 2) != 0) {
                sb.append(" update");
            }
            if (m()) {
                sb.append(" removed");
            }
            if (u()) {
                sb.append(" ignored");
            }
            if (o()) {
                sb.append(" tmpDetached");
            }
            if (!l()) {
                StringBuilder sbE = c.a.a.a.a.e(" not recyclable(");
                sbE.append(this.m);
                sbE.append(")");
                sb.append(sbE.toString());
            }
            if ((this.j & 512) != 0 || k()) {
                sb.append(" undefined adapter position");
            }
            if (this.f184a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public boolean u() {
            return (this.j & 128) != 0;
        }

        public boolean v() {
            return (this.j & 32) != 0;
        }
    }

    public class e implements b.InterfaceC0043b {
        public e() {
        }

        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        public int b() {
            return RecyclerView.this.getChildCount();
        }

        public void c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }
    }

    public class f implements a.InterfaceC0042a {
        public f() {
        }

        public void a(a.b bVar) {
            int i = bVar.f1017a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.m0(recyclerView, bVar.f1018b, bVar.d);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.p0(recyclerView2, bVar.f1018b, bVar.d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.r0(recyclerView3, bVar.f1018b, bVar.d, bVar.f1019c);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.o0(recyclerView4, bVar.f1018b, bVar.d, 1);
            }
        }

        public d0 b(int i) {
            d0 d0VarFindViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
            if (d0VarFindViewHolderForPosition == null || RecyclerView.this.mChildHelper.k(d0VarFindViewHolderForPosition.f184a)) {
                return null;
            }
            return d0VarFindViewHolderForPosition;
        }

        public void c(int i, int i2, Object obj) {
            RecyclerView.this.viewRangeUpdate(i, i2, obj);
            RecyclerView.this.mItemsChanged = true;
        }
    }

    public static abstract class g<VH extends d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f189a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f190b = false;

        public abstract int a();

        public long b(int i) {
            return -1L;
        }

        public abstract void c(VH vh, int i);

        public abstract VH d(ViewGroup viewGroup, int i);
    }

    public static class h extends Observable<i> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                x xVar = (x) ((i) ((Observable) this).mObservers.get(size));
                RecyclerView.this.assertNotInLayoutOrScroll(null);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mState.f = true;
                recyclerView.processDataSetCompletelyChanged(true);
                if (!RecyclerView.this.mAdapterHelper.g()) {
                    RecyclerView.this.requestLayout();
                }
            }
        }
    }

    public static abstract class i {
    }

    public interface j {
        int a(int i, int i2);
    }

    public static class k {
        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f191a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a> f192b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f193c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        public interface a {
            void a();
        }

        public interface b {
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f194a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f195b;
        }

        public static int b(d0 d0Var) {
            int i = d0Var.j & 14;
            if (d0Var.k()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int i2 = d0Var.d;
            int iE = d0Var.e();
            return (i2 == -1 || iE == -1 || i2 == iE) ? i : i | 2048;
        }

        public abstract boolean a(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public boolean c(d0 d0Var, List<Object> list) {
            return !((b.r.d.v) this).g || d0Var.k();
        }

        public final void d(d0 d0Var) {
            b bVar = this.f191a;
            if (bVar != null) {
                m mVar = (m) bVar;
                if (mVar == null) {
                    throw null;
                }
                d0Var.t(true);
                if (d0Var.h != null && d0Var.i == null) {
                    d0Var.h = null;
                }
                d0Var.i = null;
                if (((d0Var.j & 16) != 0) || RecyclerView.this.removeAnimatingView(d0Var.f184a) || !d0Var.o()) {
                    return;
                }
                RecyclerView.this.removeDetachedView(d0Var.f184a, false);
            }
        }

        public final void e() {
            int size = this.f192b.size();
            for (int i = 0; i < size; i++) {
                this.f192b.get(i).a();
            }
            this.f192b.clear();
        }

        public abstract void f(d0 d0Var);

        public abstract void g();

        public abstract boolean h();

        public c i(d0 d0Var) {
            c cVar = new c();
            View view = d0Var.f184a;
            cVar.f194a = view.getLeft();
            cVar.f195b = view.getTop();
            view.getRight();
            view.getBottom();
            return cVar;
        }
    }

    public class m implements l.b {
        public m() {
        }
    }

    public static abstract class n {
        public void d(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
        }

        public void e(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
        }
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b.r.d.b f197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f198b;
        public z g;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y.b f199c = new a();
        public final y.b d = new b();
        public b.r.d.y e = new b.r.d.y(this.f199c);
        public b.r.d.y f = new b.r.d.y(this.d);
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = true;
        public boolean l = true;

        public class a implements y.b {
            public a() {
            }

            @Override // b.r.d.y.b
            public int a() {
                o oVar = o.this;
                return oVar.q - oVar.N();
            }

            @Override // b.r.d.y.b
            public int b() {
                return o.this.M();
            }

            @Override // b.r.d.y.b
            public int c(View view) {
                return o.this.F(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // b.r.d.y.b
            public int d(View view) {
                return o.this.C(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // b.r.d.y.b
            public View e(int i) {
                return o.this.x(i);
            }
        }

        public class b implements y.b {
            public b() {
            }

            @Override // b.r.d.y.b
            public int a() {
                o oVar = o.this;
                return oVar.r - oVar.L();
            }

            @Override // b.r.d.y.b
            public int b() {
                return o.this.O();
            }

            @Override // b.r.d.y.b
            public int c(View view) {
                return o.this.B(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // b.r.d.y.b
            public int d(View view) {
                return o.this.G(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // b.r.d.y.b
            public View e(int i) {
                return o.this.x(i);
            }
        }

        public interface c {
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f202a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f203b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f204c;
            public boolean d;
        }

        public static d Q(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.c.RecyclerView, i, i2);
            dVar.f202a = typedArrayObtainStyledAttributes.getInt(b.r.c.RecyclerView_android_orientation, 1);
            dVar.f203b = typedArrayObtainStyledAttributes.getInt(b.r.c.RecyclerView_spanCount, 1);
            dVar.f204c = typedArrayObtainStyledAttributes.getBoolean(b.r.c.RecyclerView_reverseLayout, false);
            dVar.d = typedArrayObtainStyledAttributes.getBoolean(b.r.c.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static boolean W(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public static int h(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        public static int z(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                        i2 = 0;
                        i4 = 0;
                    } else {
                        i4 = iMax;
                    }
                }
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 != -1) {
                        if (i4 == -2) {
                            i2 = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? RecyclerView.UNDEFINED_DURATION : 0;
                        }
                        i2 = 0;
                        i4 = 0;
                    }
                    i4 = iMax;
                }
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public int A(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView == null || recyclerView.mAdapter == null || !e()) {
                return 1;
            }
            return this.f198b.mAdapter.a();
        }

        public boolean A0(int i) {
            int iO;
            int iM;
            int i2;
            int i3;
            RecyclerView recyclerView = this.f198b;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                iO = recyclerView.canScrollVertically(1) ? (this.r - O()) - L() : 0;
                if (this.f198b.canScrollHorizontally(1)) {
                    iM = (this.q - M()) - N();
                    i3 = iM;
                    i2 = iO;
                }
                i2 = iO;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                iO = recyclerView.canScrollVertically(-1) ? -((this.r - O()) - L()) : 0;
                if (this.f198b.canScrollHorizontally(-1)) {
                    iM = -((this.q - M()) - N());
                    i3 = iM;
                    i2 = iO;
                }
                i2 = iO;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.f198b.smoothScrollBy(i3, i2, null, RecyclerView.UNDEFINED_DURATION, true);
            return true;
        }

        public int B(View view) {
            return view.getBottom() + ((p) view.getLayoutParams()).f206b.bottom;
        }

        public boolean B0() {
            return false;
        }

        public int C(View view) {
            return view.getLeft() - ((p) view.getLayoutParams()).f206b.left;
        }

        public void C0(v vVar) {
            for (int iY = y() - 1; iY >= 0; iY--) {
                if (!RecyclerView.getChildViewHolderInt(x(iY)).u()) {
                    F0(iY, vVar);
                }
            }
        }

        public int D(View view) {
            Rect rect = ((p) view.getLayoutParams()).f206b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void D0(v vVar) {
            int size = vVar.f213a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = vVar.f213a.get(i).f184a;
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.u()) {
                    childViewHolderInt.t(false);
                    if (childViewHolderInt.o()) {
                        this.f198b.removeDetachedView(view, false);
                    }
                    l lVar = this.f198b.mItemAnimator;
                    if (lVar != null) {
                        lVar.f(childViewHolderInt);
                    }
                    childViewHolderInt.t(true);
                    d0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.n = null;
                    childViewHolderInt2.o = false;
                    childViewHolderInt2.d();
                    vVar.i(childViewHolderInt2);
                }
            }
            vVar.f213a.clear();
            ArrayList<d0> arrayList = vVar.f214b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.f198b.invalidate();
            }
        }

        public int E(View view) {
            Rect rect = ((p) view.getLayoutParams()).f206b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void E0(View view, v vVar) {
            b.r.d.b bVar = this.f197a;
            int iIndexOfChild = RecyclerView.this.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (bVar.f1021b.f(iIndexOfChild)) {
                    bVar.l(view);
                }
                ((e) bVar.f1020a).c(iIndexOfChild);
            }
            vVar.h(view);
        }

        public int F(View view) {
            return view.getRight() + ((p) view.getLayoutParams()).f206b.right;
        }

        public void F0(int i, v vVar) {
            View viewX = x(i);
            G0(i);
            vVar.h(viewX);
        }

        public int G(View view) {
            return view.getTop() - ((p) view.getLayoutParams()).f206b.top;
        }

        public void G0(int i) {
            b.r.d.b bVar;
            int iF;
            View viewA;
            if (x(i) == null || (viewA = ((e) bVar.f1020a).a((iF = (bVar = this.f197a).f(i)))) == null) {
                return;
            }
            if (bVar.f1021b.f(iF)) {
                bVar.l(viewA);
            }
            ((e) bVar.f1020a).c(iF);
        }

        public View H() {
            View focusedChild;
            RecyclerView recyclerView = this.f198b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f197a.f1022c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean H0(androidx.recyclerview.widget.RecyclerView r10, android.view.View r11, android.graphics.Rect r12, boolean r13, boolean r14) {
            /*
                r9 = this;
                r0 = 2
                int[] r0 = new int[r0]
                int r1 = r9.M()
                int r2 = r9.O()
                int r3 = r9.q
                int r4 = r9.N()
                int r3 = r3 - r4
                int r4 = r9.r
                int r5 = r9.L()
                int r4 = r4 - r5
                int r5 = r11.getLeft()
                int r6 = r12.left
                int r5 = r5 + r6
                int r6 = r11.getScrollX()
                int r5 = r5 - r6
                int r6 = r11.getTop()
                int r7 = r12.top
                int r6 = r6 + r7
                int r11 = r11.getScrollY()
                int r6 = r6 - r11
                int r11 = r12.width()
                int r11 = r11 + r5
                int r12 = r12.height()
                int r12 = r12 + r6
                int r5 = r5 - r1
                r1 = 0
                int r7 = java.lang.Math.min(r1, r5)
                int r6 = r6 - r2
                int r2 = java.lang.Math.min(r1, r6)
                int r11 = r11 - r3
                int r3 = java.lang.Math.max(r1, r11)
                int r12 = r12 - r4
                int r12 = java.lang.Math.max(r1, r12)
                int r4 = r9.I()
                r8 = 1
                if (r4 != r8) goto L5f
                if (r3 == 0) goto L5a
                goto L67
            L5a:
                int r3 = java.lang.Math.max(r7, r11)
                goto L67
            L5f:
                if (r7 == 0) goto L62
                goto L66
            L62:
                int r7 = java.lang.Math.min(r5, r3)
            L66:
                r3 = r7
            L67:
                if (r2 == 0) goto L6a
                goto L6e
            L6a:
                int r2 = java.lang.Math.min(r6, r12)
            L6e:
                r0[r1] = r3
                r0[r8] = r2
                r11 = r0[r1]
                r12 = r0[r8]
                if (r14 == 0) goto Lb5
                android.view.View r14 = r10.getFocusedChild()
                if (r14 != 0) goto L80
            L7e:
                r14 = 0
                goto Lb3
            L80:
                int r0 = r9.M()
                int r2 = r9.O()
                int r3 = r9.q
                int r4 = r9.N()
                int r3 = r3 - r4
                int r4 = r9.r
                int r5 = r9.L()
                int r4 = r4 - r5
                androidx.recyclerview.widget.RecyclerView r5 = r9.f198b
                android.graphics.Rect r5 = r5.mTempRect
                androidx.recyclerview.widget.RecyclerView.getDecoratedBoundsWithMarginsInt(r14, r5)
                int r14 = r5.left
                int r14 = r14 - r11
                if (r14 >= r3) goto L7e
                int r14 = r5.right
                int r14 = r14 - r11
                if (r14 <= r0) goto L7e
                int r14 = r5.top
                int r14 = r14 - r12
                if (r14 >= r4) goto L7e
                int r14 = r5.bottom
                int r14 = r14 - r12
                if (r14 > r2) goto Lb2
                goto L7e
            Lb2:
                r14 = 1
            Lb3:
                if (r14 == 0) goto Lba
            Lb5:
                if (r11 != 0) goto Lbb
                if (r12 == 0) goto Lba
                goto Lbb
            Lba:
                return r1
            Lbb:
                if (r13 == 0) goto Lc1
                r10.scrollBy(r11, r12)
                goto Lc4
            Lc1:
                r10.smoothScrollBy(r11, r12)
            Lc4:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.H0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public int I() {
            return b.i.m.l.r(this.f198b);
        }

        public void I0() {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int J() {
            return b.i.m.l.s(this.f198b);
        }

        public int J0(int i, v vVar, a0 a0Var) {
            return 0;
        }

        public int K() {
            return b.i.m.l.t(this.f198b);
        }

        public void K0(int i) {
        }

        public int L() {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int L0(int i, v vVar, a0 a0Var) {
            return 0;
        }

        public int M() {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void M0(RecyclerView recyclerView) {
            N0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int N() {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void N0(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.o = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.p = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.r = 0;
        }

        public int O() {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void O0(Rect rect, int i, int i2) {
            int iN = N() + M() + rect.width();
            int iL = L() + O() + rect.height();
            this.f198b.setMeasuredDimension(h(i, iN, K()), h(i2, iL, J()));
        }

        public int P(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public void P0(int i, int i2) {
            int iY = y();
            if (iY == 0) {
                this.f198b.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = RecyclerView.UNDEFINED_DURATION;
            int i6 = RecyclerView.UNDEFINED_DURATION;
            for (int i7 = 0; i7 < iY; i7++) {
                View viewX = x(i7);
                Rect rect = this.f198b.mTempRect;
                RecyclerView.getDecoratedBoundsWithMarginsInt(viewX, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i5) {
                    i5 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.f198b.mTempRect.set(i3, i4, i5, i6);
            O0(this.f198b.mTempRect, i, i2);
        }

        public void Q0(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f198b = null;
                this.f197a = null;
                height = 0;
                this.q = 0;
            } else {
                this.f198b = recyclerView;
                this.f197a = recyclerView.mChildHelper;
                this.q = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.r = height;
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public int R(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView == null || recyclerView.mAdapter == null || !f()) {
                return 1;
            }
            return this.f198b.mAdapter.a();
        }

        public boolean R0(View view, int i, int i2, p pVar) {
            return (!view.isLayoutRequested() && this.k && W(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && W(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int S() {
            return 0;
        }

        public boolean S0() {
            return false;
        }

        public void T(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).f206b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f198b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f198b.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean T0(View view, int i, int i2, p pVar) {
            return (this.k && W(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && W(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public boolean U() {
            return this.j;
        }

        public void U0(RecyclerView recyclerView, a0 a0Var, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public boolean V() {
            return false;
        }

        public void V0(z zVar) {
            z zVar2 = this.g;
            if (zVar2 != null && zVar != zVar2 && zVar2.e) {
                zVar2.d();
            }
            this.g = zVar;
            RecyclerView recyclerView = this.f198b;
            if (zVar == null) {
                throw null;
            }
            recyclerView.mViewFlinger.c();
            if (zVar.h) {
                StringBuilder sbE = c.a.a.a.a.e("An instance of ");
                sbE.append(zVar.getClass().getSimpleName());
                sbE.append(" was started more than once. Each instance of");
                sbE.append(zVar.getClass().getSimpleName());
                sbE.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w(RecyclerView.TAG, sbE.toString());
            }
            zVar.f218b = recyclerView;
            zVar.f219c = this;
            int i = zVar.f217a;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f177a = i;
            zVar.e = true;
            zVar.d = true;
            zVar.f = recyclerView.mLayout.t(i);
            zVar.f218b.mViewFlinger.a();
            zVar.h = true;
        }

        public boolean W0() {
            return false;
        }

        public boolean X(View view, boolean z) {
            boolean z2 = this.e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z2 : !z2;
        }

        public void Y(View view, int i, int i2, int i3, int i4) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f206b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void Z(int i) {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void a0(int i) {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void b(View view) {
            c(view, -1, false);
        }

        public void b0() {
        }

        public final void c(View view, int i, boolean z) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.m()) {
                this.f198b.mViewInfoStore.a(childViewHolderInt);
            } else {
                this.f198b.mViewInfoStore.f(childViewHolderInt);
            }
            p pVar = (p) view.getLayoutParams();
            if (childViewHolderInt.v() || childViewHolderInt.n()) {
                if (childViewHolderInt.n()) {
                    childViewHolderInt.n.l(childViewHolderInt);
                } else {
                    childViewHolderInt.d();
                }
                this.f197a.b(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f198b) {
                int iJ = this.f197a.j(view);
                if (i == -1) {
                    i = this.f197a.e();
                }
                if (iJ == -1) {
                    StringBuilder sbE = c.a.a.a.a.e("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sbE.append(this.f198b.indexOfChild(view));
                    throw new IllegalStateException(c.a.a.a.a.a(this.f198b, sbE));
                }
                if (iJ != i) {
                    o oVar = this.f198b.mLayout;
                    View viewX = oVar.x(iJ);
                    if (viewX == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iJ + oVar.f198b.toString());
                    }
                    oVar.x(iJ);
                    oVar.r(iJ);
                    p pVar2 = (p) viewX.getLayoutParams();
                    d0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(viewX);
                    if (childViewHolderInt2.m()) {
                        oVar.f198b.mViewInfoStore.a(childViewHolderInt2);
                    } else {
                        oVar.f198b.mViewInfoStore.f(childViewHolderInt2);
                    }
                    oVar.f197a.b(viewX, i, pVar2, childViewHolderInt2.m());
                }
            } else {
                this.f197a.a(view, i, false);
                pVar.f207c = true;
                z zVar = this.g;
                if (zVar != null && zVar.e && zVar.f218b.getChildLayoutPosition(view) == zVar.f217a) {
                    zVar.f = view;
                }
            }
            if (pVar.d) {
                childViewHolderInt.f184a.invalidate();
                pVar.d = false;
            }
        }

        public boolean c0() {
            return false;
        }

        public void d(String str) {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void d0() {
        }

        public boolean e() {
            return false;
        }

        @Deprecated
        public void e0() {
        }

        public boolean f() {
            return false;
        }

        public void f0(RecyclerView recyclerView, v vVar) {
            e0();
        }

        public boolean g(p pVar) {
            return pVar != null;
        }

        public View g0(View view, int i, v vVar, a0 a0Var) {
            return null;
        }

        public void h0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f198b;
            v vVar = recyclerView.mRecycler;
            a0 a0Var = recyclerView.mState;
            i0(accessibilityEvent);
        }

        public void i(int i, int i2, a0 a0Var, c cVar) {
        }

        public void i0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f198b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f198b.canScrollVertically(-1) && !this.f198b.canScrollHorizontally(-1) && !this.f198b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            g gVar = this.f198b.mAdapter;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.a());
            }
        }

        public void j(int i, c cVar) {
        }

        public void j0(View view, b.i.m.v.b bVar) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.m() || this.f197a.k(childViewHolderInt.f184a)) {
                return;
            }
            RecyclerView recyclerView = this.f198b;
            k0(recyclerView.mRecycler, recyclerView.mState, view, bVar);
        }

        public int k(a0 a0Var) {
            return 0;
        }

        public void k0(v vVar, a0 a0Var, View view, b.i.m.v.b bVar) {
            bVar.j(b.c.a(f() ? P(view) : 0, 1, e() ? P(view) : 0, 1, false, false));
        }

        public int l(a0 a0Var) {
            return 0;
        }

        public View l0() {
            return null;
        }

        public int m(a0 a0Var) {
            return 0;
        }

        public void m0(RecyclerView recyclerView, int i, int i2) {
        }

        public int n(a0 a0Var) {
            return 0;
        }

        public void n0(RecyclerView recyclerView) {
        }

        public int o(a0 a0Var) {
            return 0;
        }

        public void o0(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int p(a0 a0Var) {
            return 0;
        }

        public void p0(RecyclerView recyclerView, int i, int i2) {
        }

        public void q(v vVar) {
            int iY = y();
            while (true) {
                iY--;
                if (iY < 0) {
                    return;
                }
                View viewX = x(iY);
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(viewX);
                if (!childViewHolderInt.u()) {
                    if (!childViewHolderInt.k() || childViewHolderInt.m() || this.f198b.mAdapter.f190b) {
                        x(iY);
                        r(iY);
                        vVar.j(viewX);
                        this.f198b.mViewInfoStore.f(childViewHolderInt);
                    } else {
                        G0(iY);
                        vVar.i(childViewHolderInt);
                    }
                }
            }
        }

        public void q0() {
        }

        public final void r(int i) {
            this.f197a.c(i);
        }

        public void r0(RecyclerView recyclerView, int i, int i2, Object obj) {
            q0();
        }

        public View s(View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.f198b;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f197a.f1022c.contains(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public void s0(v vVar, a0 a0Var) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public View t(int i) {
            int iY = y();
            for (int i2 = 0; i2 < iY; i2++) {
                View viewX = x(i2);
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(viewX);
                if (childViewHolderInt != null && childViewHolderInt.f() == i && !childViewHolderInt.u() && (this.f198b.mState.g || !childViewHolderInt.m())) {
                    return viewX;
                }
            }
            return null;
        }

        public void t0(a0 a0Var) {
        }

        public abstract p u();

        public void u0(int i, int i2) {
            this.f198b.defaultOnMeasure(i, i2);
        }

        public p v(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        @Deprecated
        public boolean v0(RecyclerView recyclerView) {
            z zVar = this.g;
            return (zVar != null && zVar.e) || recyclerView.isComputingLayout();
        }

        public p w(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean w0(RecyclerView recyclerView, View view, View view2) {
            return v0(recyclerView);
        }

        public View x(int i) {
            b.r.d.b bVar = this.f197a;
            if (bVar == null) {
                return null;
            }
            return ((e) bVar.f1020a).a(bVar.f(i));
        }

        public void x0(Parcelable parcelable) {
        }

        public int y() {
            b.r.d.b bVar = this.f197a;
            if (bVar != null) {
                return bVar.e();
            }
            return 0;
        }

        public Parcelable y0() {
            return null;
        }

        public void z0(int i) {
        }
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d0 f205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f207c;
        public boolean d;

        public p(int i, int i2) {
            super(i, i2);
            this.f206b = new Rect();
            this.f207c = true;
            this.d = false;
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f206b = new Rect();
            this.f207c = true;
            this.d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f206b = new Rect();
            this.f207c = true;
            this.d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f206b = new Rect();
            this.f207c = true;
            this.d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f206b = new Rect();
            this.f207c = true;
            this.d = false;
        }

        public int a() {
            return this.f205a.f();
        }

        public boolean b() {
            return this.f205a.p();
        }

        public boolean c() {
            return this.f205a.m();
        }
    }

    public interface q {
        void a(View view);

        void b(View view);
    }

    public static abstract class r {
    }

    public interface s {
        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray<a> f208a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f209b = 0;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList<d0> f210a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f211b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f212c = 0;
            public long d = 0;
        }

        public final a a(int i) {
            a aVar = this.f208a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f208a.put(i, aVar2);
            return aVar2;
        }

        public long b(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    public final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<d0> f213a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<d0> f214b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<d0> f215c = new ArrayList<>();
        public final List<d0> d = Collections.unmodifiableList(this.f213a);
        public int e = 2;
        public int f = 2;
        public u g;

        public v() {
        }

        public void a(d0 d0Var, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(d0Var);
            View view = d0Var.f184a;
            b.r.d.u uVar = RecyclerView.this.mAccessibilityDelegate;
            if (uVar != null) {
                u.a aVar = uVar.e;
                b.i.m.l.W(view, aVar instanceof u.a ? aVar.e.remove(view) : null);
            }
            if (z) {
                w wVar = RecyclerView.this.mRecyclerListener;
                if (wVar != null) {
                    wVar.a(d0Var);
                }
                g gVar = RecyclerView.this.mAdapter;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.g(d0Var);
                }
            }
            d0Var.r = null;
            u uVarD = d();
            if (uVarD == null) {
                throw null;
            }
            int i = d0Var.f;
            ArrayList<d0> arrayList = uVarD.a(i).f210a;
            if (uVarD.f208a.get(i).f211b <= arrayList.size()) {
                return;
            }
            d0Var.r();
            arrayList.add(d0Var);
        }

        public void b() {
            this.f213a.clear();
            f();
        }

        public int c(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.b()) {
                RecyclerView recyclerView = RecyclerView.this;
                return !recyclerView.mState.g ? i : recyclerView.mAdapterHelper.f(i, 0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("invalid position ");
            sb.append(i);
            sb.append(". State item count is ");
            sb.append(RecyclerView.this.mState.b());
            throw new IndexOutOfBoundsException(c.a.a.a.a.a(RecyclerView.this, sb));
        }

        public u d() {
            if (this.g == null) {
                this.g = new u();
            }
            return this.g;
        }

        public final void e(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    e((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void f() {
            for (int size = this.f215c.size() - 1; size >= 0; size--) {
                g(size);
            }
            this.f215c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                m.b bVar = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = bVar.f1064c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.d = 0;
            }
        }

        public void g(int i) {
            a(this.f215c.get(i), true);
            this.f215c.remove(i);
        }

        public void h(View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.o()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.n()) {
                childViewHolderInt.n.l(childViewHolderInt);
            } else if (childViewHolderInt.v()) {
                childViewHolderInt.d();
            }
            i(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.l()) {
                return;
            }
            RecyclerView.this.mItemAnimator.f(childViewHolderInt);
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x0098 A[PHI: r1
  0x0098: PHI (r1v5 boolean) = (r1v0 boolean), (r1v8 boolean) binds: [B:24:0x0040, B:45:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(androidx.recyclerview.widget.RecyclerView.d0 r7) {
            /*
                Method dump skipped, instruction units count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.i(androidx.recyclerview.widget.RecyclerView$d0):void");
        }

        public void j(View view) {
            ArrayList<d0> arrayList;
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.h(12) && childViewHolderInt.p() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f214b == null) {
                    this.f214b = new ArrayList<>();
                }
                childViewHolderInt.n = this;
                childViewHolderInt.o = true;
                arrayList = this.f214b;
            } else {
                if (childViewHolderInt.k() && !childViewHolderInt.m() && !RecyclerView.this.mAdapter.f190b) {
                    throw new IllegalArgumentException(c.a.a.a.a.a(RecyclerView.this, c.a.a.a.a.e("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
                }
                childViewHolderInt.n = this;
                childViewHolderInt.o = false;
                arrayList = this.f213a;
            }
            arrayList.add(childViewHolderInt);
        }

        /* JADX WARN: Code restructure failed: missing block: B:71:0x0102, code lost:
        
            if (r10 == null) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0104, code lost:
        
            r7 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r10);
            r8 = r16.h.mChildHelper;
            r9 = ((androidx.recyclerview.widget.RecyclerView.e) r8.f1020a).f187a.indexOfChild(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0116, code lost:
        
            if (r9 < 0) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x011e, code lost:
        
            if (r8.f1021b.d(r9) == false) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0120, code lost:
        
            r8.f1021b.a(r9);
            r8.l(r10);
            r8 = r16.h.mChildHelper.j(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0130, code lost:
        
            if (r8 == (-1)) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0132, code lost:
        
            r16.h.mChildHelper.c(r8);
            j(r10);
            r7.b(8224);
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0143, code lost:
        
            r2 = new java.lang.StringBuilder();
            r2.append("layout index should not be -1 after unhiding a view:");
            r2.append(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x015b, code lost:
        
            throw new java.lang.IllegalStateException(c.a.a.a.a.a(r16.h, r2));
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0172, code lost:
        
            throw new java.lang.RuntimeException("trying to unhide a view that was not hidden" + r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0189, code lost:
        
            throw new java.lang.IllegalArgumentException("view is not a child, cannot hide " + r10);
         */
        /* JADX WARN: Removed duplicated region for block: B:114:0x01e9  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x0248  */
        /* JADX WARN: Removed duplicated region for block: B:190:0x0336  */
        /* JADX WARN: Removed duplicated region for block: B:235:0x0417  */
        /* JADX WARN: Removed duplicated region for block: B:241:0x043b  */
        /* JADX WARN: Removed duplicated region for block: B:243:0x0441  */
        /* JADX WARN: Removed duplicated region for block: B:250:0x0451  */
        /* JADX WARN: Removed duplicated region for block: B:295:0x0529  */
        /* JADX WARN: Removed duplicated region for block: B:296:0x0530  */
        /* JADX WARN: Removed duplicated region for block: B:303:0x054c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01bc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.d0 k(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 1412
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.k(int, boolean, long):androidx.recyclerview.widget.RecyclerView$d0");
        }

        public void l(d0 d0Var) {
            (d0Var.o ? this.f214b : this.f213a).remove(d0Var);
            d0Var.n = null;
            d0Var.o = false;
            d0Var.d();
        }

        public void m() {
            o oVar = RecyclerView.this.mLayout;
            this.f = this.e + (oVar != null ? oVar.m : 0);
            for (int size = this.f215c.size() - 1; size >= 0 && this.f215c.size() > this.f; size--) {
                g(size);
            }
        }
    }

    public interface w {
        void a(d0 d0Var);
    }

    public class x extends i {
        public x() {
        }
    }

    public static class y extends b.k.a.a {
        public static final Parcelable.Creator<y> CREATOR = new a();
        public Parcelable d;

        public static class a implements Parcelable.ClassLoaderCreator<y> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new y[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }
        }

        public y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public y(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f890b, i);
            parcel.writeParcelable(this.d, 0);
        }
    }

    public static abstract class z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f219c;
        public boolean d;
        public boolean e;
        public View f;
        public boolean h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f217a = -1;
        public final a g = new a(0, 0);

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f221b;
            public int d = -1;
            public boolean f = false;
            public int g = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f222c = RecyclerView.UNDEFINED_DURATION;
            public Interpolator e = null;

            public a(int i, int i2) {
                this.f220a = i;
                this.f221b = i2;
            }

            public void a(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f = false;
                    return;
                }
                if (!this.f) {
                    this.g = 0;
                    return;
                }
                if (this.e != null && this.f222c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                int i2 = this.f222c;
                if (i2 < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                recyclerView.mViewFlinger.b(this.f220a, this.f221b, i2, this.e);
                int i3 = this.g + 1;
                this.g = i3;
                if (i3 > 10) {
                    Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f = false;
            }

            public void b(int i, int i2, int i3, Interpolator interpolator) {
                this.f220a = i;
                this.f221b = i2;
                this.f222c = i3;
                this.e = interpolator;
                this.f = true;
            }
        }

        public interface b {
            PointF a(int i);
        }

        public PointF a(int i) {
            Object obj = this.f219c;
            if (obj instanceof b) {
                return ((b) obj).a(i);
            }
            StringBuilder sbE = c.a.a.a.a.e("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sbE.append(b.class.getCanonicalName());
            Log.w(RecyclerView.TAG, sbE.toString());
            return null;
        }

        public void b(int i, int i2) {
            PointF pointFA;
            RecyclerView recyclerView = this.f218b;
            if (this.f217a == -1 || recyclerView == null) {
                d();
            }
            if (this.d && this.f == null && this.f219c != null && (pointFA = a(this.f217a)) != null && (pointFA.x != 0.0f || pointFA.y != 0.0f)) {
                recyclerView.scrollStep((int) Math.signum(pointFA.x), (int) Math.signum(pointFA.y), null);
            }
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (this.f218b.getChildLayoutPosition(view) == this.f217a) {
                    c(this.f, recyclerView.mState, this.g);
                    this.g.a(recyclerView);
                    d();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a0 a0Var = recyclerView.mState;
                a aVar = this.g;
                b.r.d.o oVar = (b.r.d.o) this;
                if (oVar.f218b.mLayout.y() == 0) {
                    oVar.d();
                } else {
                    int i3 = oVar.o;
                    int i4 = i3 - i;
                    if (i3 * i4 <= 0) {
                        i4 = 0;
                    }
                    oVar.o = i4;
                    int i5 = oVar.p;
                    int i6 = i5 - i2;
                    if (i5 * i6 <= 0) {
                        i6 = 0;
                    }
                    oVar.p = i6;
                    if (oVar.o == 0 && i6 == 0) {
                        PointF pointFA2 = oVar.a(oVar.f217a);
                        if (pointFA2 == null || (pointFA2.x == 0.0f && pointFA2.y == 0.0f)) {
                            aVar.d = oVar.f217a;
                            oVar.d();
                        } else {
                            float f = pointFA2.x;
                            float f2 = pointFA2.y;
                            float fSqrt = (float) Math.sqrt((f2 * f2) + (f * f));
                            float f3 = pointFA2.x / fSqrt;
                            pointFA2.x = f3;
                            float f4 = pointFA2.y / fSqrt;
                            pointFA2.y = f4;
                            oVar.k = pointFA2;
                            oVar.o = (int) (f3 * 10000.0f);
                            oVar.p = (int) (f4 * 10000.0f);
                            aVar.b((int) (oVar.o * 1.2f), (int) (oVar.p * 1.2f), (int) (oVar.g(10000) * 1.2f), oVar.i);
                        }
                    }
                }
                boolean z = this.g.d >= 0;
                this.g.a(recyclerView);
                if (z && this.e) {
                    this.d = true;
                    recyclerView.mViewFlinger.a();
                }
            }
        }

        public abstract void c(View view, a0 a0Var, a aVar);

        public final void d() {
            if (this.e) {
                this.e = false;
                b.r.d.o oVar = (b.r.d.o) this;
                oVar.p = 0;
                oVar.o = 0;
                oVar.k = null;
                this.f218b.mState.f177a = -1;
                this.f = null;
                this.f217a = -1;
                this.d = false;
                o oVar2 = this.f219c;
                if (oVar2.g == this) {
                    oVar2.g = null;
                }
                this.f219c = null;
                this.f218b = null;
            }
        }
    }

    static {
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.r.a.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mObserver = new x();
        this.mRecycler = new v();
        this.mViewInfoStore = new b.r.d.z();
        this.mUpdateChildViewsRunnable = new a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new k();
        this.mItemAnimator = new b.r.d.k();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new c0();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new m.b() : null;
        this.mState = new a0();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new m();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b();
        this.mViewInfoProcessCallback = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = b.i.m.p.b(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : b.i.m.p.a(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f191a = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (b.i.m.l.p(this) == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new b.r.d.u(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.c.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, b.r.c.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(b.r.c.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(b.r.c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(b.r.c.RecyclerView_android_clipToPadding, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(b.r.c.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(b.r.c.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
        }
        boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    private void addAnimatingView(d0 d0Var) {
        View view = d0Var.f184a;
        boolean z2 = view.getParent() == this;
        this.mRecycler.l(getChildViewHolder(view));
        if (d0Var.o()) {
            this.mChildHelper.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        b.r.d.b bVar = this.mChildHelper;
        if (!z2) {
            bVar.a(view, -1, true);
            return;
        }
        int iIndexOfChild = RecyclerView.this.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            bVar.f1021b.h(iIndexOfChild);
            bVar.i(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    private void animateChange(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        d0Var.t(false);
        if (z2) {
            addAnimatingView(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                addAnimatingView(d0Var2);
            }
            d0Var.h = d0Var2;
            addAnimatingView(d0Var);
            this.mRecycler.l(d0Var);
            d0Var2.t(false);
            d0Var2.i = d0Var;
        }
        if (this.mItemAnimator.a(d0Var, d0Var2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f185b;
        if (weakReference != null) {
            Object parent = weakReference.get();
            while (true) {
                for (View view = (View) parent; view != null; view = null) {
                    if (view == d0Var.f184a) {
                        return;
                    }
                    parent = view.getParent();
                    if (parent instanceof View) {
                        break;
                    }
                }
                d0Var.f185b = null;
                return;
            }
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        accessibilityEventObtain.setContentChangeTypes(i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i = false;
        startInterceptRequestLayout();
        b.r.d.z zVar = this.mViewInfoStore;
        zVar.f1085a.clear();
        zVar.f1086b.b();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        a0 a0Var = this.mState;
        a0Var.h = a0Var.j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        a0 a0Var2 = this.mState;
        a0Var2.g = a0Var2.k;
        a0Var2.e = this.mAdapter.a();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j) {
            int iE = this.mChildHelper.e();
            for (int i2 = 0; i2 < iE; i2++) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
                if (!childViewHolderInt.u() && (!childViewHolderInt.k() || this.mAdapter.f190b)) {
                    l lVar = this.mItemAnimator;
                    l.b(childViewHolderInt);
                    childViewHolderInt.g();
                    this.mViewInfoStore.c(childViewHolderInt, lVar.i(childViewHolderInt));
                    if (this.mState.h && childViewHolderInt.p() && !childViewHolderInt.m() && !childViewHolderInt.u() && !childViewHolderInt.k()) {
                        this.mViewInfoStore.f1086b.g(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.k) {
            saveOldPositions();
            a0 a0Var3 = this.mState;
            boolean z2 = a0Var3.f;
            a0Var3.f = false;
            this.mLayout.s0(this.mRecycler, a0Var3);
            this.mState.f = z2;
            for (int i3 = 0; i3 < this.mChildHelper.e(); i3++) {
                d0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.d(i3));
                if (!childViewHolderInt2.u()) {
                    z.a orDefault = this.mViewInfoStore.f1085a.getOrDefault(childViewHolderInt2, null);
                    if (!((orDefault == null || (orDefault.f1087a & 4) == 0) ? false : true)) {
                        l.b(childViewHolderInt2);
                        boolean zH = childViewHolderInt2.h(8192);
                        l lVar2 = this.mItemAnimator;
                        childViewHolderInt2.g();
                        l.c cVarI = lVar2.i(childViewHolderInt2);
                        if (zH) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, cVarI);
                        } else {
                            b.r.d.z zVar2 = this.mViewInfoStore;
                            z.a orDefault2 = zVar2.f1085a.getOrDefault(childViewHolderInt2, null);
                            if (orDefault2 == null) {
                                orDefault2 = z.a.a();
                                zVar2.f1085a.put(childViewHolderInt2, orDefault2);
                            }
                            orDefault2.f1087a |= 2;
                            orDefault2.f1088b = cVarI;
                        }
                    }
                }
            }
        }
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.c();
        this.mState.e = this.mAdapter.a();
        a0 a0Var = this.mState;
        a0Var.f179c = 0;
        a0Var.g = false;
        this.mLayout.s0(this.mRecycler, a0Var);
        a0 a0Var2 = this.mState;
        a0Var2.f = false;
        this.mPendingSavedState = null;
        a0Var2.j = a0Var2.j && this.mItemAnimator != null;
        this.mState.d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void dispatchLayoutStep3() {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.dispatchLayoutStep3():void");
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        s sVar = this.mInterceptingOnItemTouchListener;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        sVar.c(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.mOnItemTouchListeners.get(i2);
            if (sVar.b(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = sVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iE = this.mChildHelper.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = UNDEFINED_DURATION;
        for (int i4 = 0; i4 < iE; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (!childViewHolderInt.u()) {
                int iF = childViewHolderInt.f();
                if (iF < i2) {
                    i2 = iF;
                }
                if (iF > i3) {
                    i3 = iF;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        d0 d0VarFindViewHolderForAdapterPosition;
        int i2 = this.mState.l;
        if (i2 == -1) {
            i2 = 0;
        }
        int iB = this.mState.b();
        for (int i3 = i2; i3 < iB; i3++) {
            d0 d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (d0VarFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (d0VarFindViewHolderForAdapterPosition2.f184a.hasFocusable()) {
                return d0VarFindViewHolderForAdapterPosition2.f184a;
            }
        }
        int iMin = Math.min(iB, i2);
        do {
            iMin--;
            if (iMin < 0 || (d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!d0VarFindViewHolderForAdapterPosition.f184a.hasFocusable());
        return d0VarFindViewHolderForAdapterPosition.f184a;
    }

    public static d0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f205a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f206b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private b.i.m.f getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new b.i.m.f(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j2, d0 d0Var, d0 d0Var2) {
        int iE = this.mChildHelper.e();
        for (int i2 = 0; i2 < iE; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != d0Var && getChangedHolderKey(childViewHolderInt) == j2) {
                g gVar = this.mAdapter;
                if (gVar == null || !gVar.f190b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(d0Var);
                    throw new IllegalStateException(c.a.a.a.a.a(this, sb));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(d0Var);
                throw new IllegalStateException(c.a.a.a.a.a(this, sb2));
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int iE = this.mChildHelper.e();
        for (int i2 = 0; i2 < iE; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.u() && childViewHolderInt.p()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (b.i.m.l.q(this) != 0 || Build.VERSION.SDK_INT < 26) {
            return;
        }
        setImportantForAutofill(8);
    }

    private void initChildrenHelper() {
        this.mChildHelper = new b.r.d.b(new e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        byte b2 = -1;
        int i4 = this.mLayout.I() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i5 = rect.left;
        int i6 = this.mTempRect2.left;
        if ((i5 < i6 || rect.right <= i6) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.mTempRect;
            int i7 = rect2.right;
            int i8 = this.mTempRect2.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        Rect rect3 = this.mTempRect;
        int i9 = rect3.top;
        int i10 = this.mTempRect2.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            b2 = 1;
        } else {
            Rect rect4 = this.mTempRect;
            int i11 = rect4.bottom;
            int i12 = this.mTempRect2.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.mTempRect.top <= this.mTempRect2.top) {
                b2 = 0;
            }
        }
        if (i2 == 1) {
            return b2 < 0 || (b2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return b2 > 0 || (b2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return b2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return b2 > 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid direction: ");
        sb.append(i2);
        throw new IllegalArgumentException(c.a.a.a.a.a(this, sb));
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.W0();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z2 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            b.r.d.a aVar = this.mAdapterHelper;
            aVar.l(aVar.f1015b);
            aVar.l(aVar.f1016c);
            aVar.g = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.n0(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.j();
        } else {
            this.mAdapterHelper.c();
        }
        boolean z3 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z3 || this.mLayout.h) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.f190b);
        a0 a0Var = this.mState;
        if (a0Var.j && z3 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z2 = true;
        }
        a0Var.k = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L1c:
            r3.onPull(r4, r9)
            r9 = 1
            goto L39
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L38
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L53
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            r9.onPull(r0, r7)
            goto L6f
        L53:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L6e
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            r9.onPull(r3, r0)
            goto L6f
        L6e:
            r1 = r9
        L6f:
            if (r1 != 0) goto L79
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            b.i.m.l.O(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.k(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.e() == 0) {
                requestFocus();
                return;
            }
        }
        long j2 = this.mState.m;
        View viewFindNextViewToFocus = null;
        d0 d0VarFindViewHolderForItemId = (j2 == -1 || !this.mAdapter.f190b) ? null : findViewHolderForItemId(j2);
        if (d0VarFindViewHolderForItemId != null && !this.mChildHelper.k(d0VarFindViewHolderForItemId.f184a) && d0VarFindViewHolderForItemId.f184a.hasFocusable()) {
            viewFindNextViewToFocus = d0VarFindViewHolderForItemId.f184a;
        } else if (this.mChildHelper.e() > 0) {
            viewFindNextViewToFocus = findNextViewToFocus();
        }
        if (viewFindNextViewToFocus != null) {
            int i2 = this.mState.n;
            if (i2 != -1 && (viewFindViewById = viewFindNextViewToFocus.findViewById(i2)) != null && viewFindViewById.isFocusable()) {
                viewFindNextViewToFocus = viewFindViewById;
            }
            viewFindNextViewToFocus.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            b.i.m.l.O(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f207c) {
                Rect rect = pVar.f206b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.H0(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        a0 a0Var = this.mState;
        a0Var.m = -1L;
        a0Var.l = -1;
        a0Var.n = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        d0 d0VarFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (d0VarFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.m = this.mAdapter.f190b ? d0VarFindContainingViewHolder.e : -1L;
        this.mState.l = this.mDataSetHasChangedAfterLayout ? -1 : d0VarFindContainingViewHolder.m() ? d0VarFindContainingViewHolder.d : d0VarFindContainingViewHolder.e();
        this.mState.n = getDeepestFocusedViewWithId(d0VarFindContainingViewHolder.f184a);
    }

    private void setAdapterInternal(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.mAdapter;
        if (gVar2 != null) {
            gVar2.f189a.unregisterObserver(this.mObserver);
            if (this.mAdapter == null) {
                throw null;
            }
        }
        if (!z2 || z3) {
            removeAndRecycleViews();
        }
        b.r.d.a aVar = this.mAdapterHelper;
        aVar.l(aVar.f1015b);
        aVar.l(aVar.f1016c);
        aVar.g = 0;
        g gVar3 = this.mAdapter;
        this.mAdapter = gVar;
        if (gVar != null) {
            gVar.f189a.registerObserver(this.mObserver);
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.b0();
        }
        v vVar = this.mRecycler;
        g gVar4 = this.mAdapter;
        vVar.b();
        u uVarD = vVar.d();
        if (uVarD == null) {
            throw null;
        }
        if (gVar3 != null) {
            uVarD.f209b--;
        }
        if (!z2 && uVarD.f209b == 0) {
            for (int i2 = 0; i2 < uVarD.f208a.size(); i2++) {
                uVarD.f208a.valueAt(i2).f210a.clear();
            }
        }
        if (gVar4 != null) {
            uVarD.f209b++;
        }
        this.mState.f = true;
    }

    private void stopScrollersInternal() {
        z zVar;
        this.mViewFlinger.c();
        o oVar = this.mLayout;
        if (oVar == null || (zVar = oVar.g) == null) {
            return;
        }
        zVar.d();
    }

    public void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        b.i.m.l.O(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null || !oVar.c0()) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(n nVar) {
        addItemDecoration(nVar, -1);
    }

    public void addItemDecoration(n nVar, int i2) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.d("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(nVar);
        } else {
            this.mItemDecorations.add(i2, nVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(q qVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(qVar);
    }

    public void addOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.add(sVar);
    }

    public void addOnScrollListener(t tVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(tVar);
    }

    public void animateAppearance(d0 d0Var, l.c cVar, l.c cVar2) {
        boolean zJ;
        d0Var.t(false);
        b.r.d.v vVar = (b.r.d.v) this.mItemAnimator;
        if (vVar == null) {
            throw null;
        }
        if (cVar == null || (cVar.f194a == cVar2.f194a && cVar.f195b == cVar2.f195b)) {
            b.r.d.k kVar = (b.r.d.k) vVar;
            kVar.o(d0Var);
            d0Var.f184a.setAlpha(0.0f);
            kVar.i.add(d0Var);
            zJ = true;
        } else {
            zJ = vVar.j(d0Var, cVar.f194a, cVar.f195b, cVar2.f194a, cVar2.f195b);
        }
        if (zJ) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(d0 d0Var, l.c cVar, l.c cVar2) {
        boolean zJ;
        addAnimatingView(d0Var);
        d0Var.t(false);
        b.r.d.v vVar = (b.r.d.v) this.mItemAnimator;
        if (vVar == null) {
            throw null;
        }
        int i2 = cVar.f194a;
        int i3 = cVar.f195b;
        View view = d0Var.f184a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f194a;
        int top = cVar2 == null ? view.getTop() : cVar2.f195b;
        if (d0Var.m() || (i2 == left && i3 == top)) {
            b.r.d.k kVar = (b.r.d.k) vVar;
            kVar.o(d0Var);
            kVar.h.add(d0Var);
            zJ = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zJ = vVar.j(d0Var, i2, i3, left, top);
        }
        if (zJ) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str != null) {
            throw new IllegalStateException(c.a.a.a.a.a(this, c.a.a.a.a.e(str)));
        }
        throw new IllegalStateException(c.a.a.a.a.a(this, c.a.a.a.a.e("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(c.a.a.a.a.a(this, c.a.a.a.a.e("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(c.a.a.a.a.a(this, c.a.a.a.a.e(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(d0 d0Var) {
        l lVar = this.mItemAnimator;
        return lVar == null || lVar.c(d0Var, d0Var.g());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.mLayout.g((p) layoutParams);
    }

    public void clearOldPositions() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.u()) {
                childViewHolderInt.c();
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f215c.size();
        for (int i3 = 0; i3 < size; i3++) {
            vVar.f215c.get(i3).c();
        }
        int size2 = vVar.f213a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            vVar.f213a.get(i4).c();
        }
        ArrayList<d0> arrayList = vVar.f214b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                vVar.f214b.get(i5).c();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.e()) {
            return this.mLayout.k(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.e()) {
            return this.mLayout.l(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.e()) {
            return this.mLayout.m(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.f()) {
            return this.mLayout.n(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.f()) {
            return this.mLayout.o(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.f()) {
            return this.mLayout.p(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            b.i.m.l.O(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void consumePendingUpdateOperations() {
        /*
            r4 = this;
            boolean r0 = r4.mFirstLayoutComplete
            java.lang.String r1 = "RV FullInvalidate"
            if (r0 == 0) goto L6a
            boolean r0 = r4.mDataSetHasChangedAfterLayout
            if (r0 == 0) goto Lb
            goto L6a
        Lb:
            b.r.d.a r0 = r4.mAdapterHelper
            boolean r0 = r0.g()
            if (r0 != 0) goto L14
            return
        L14:
            b.r.d.a r0 = r4.mAdapterHelper
            int r0 = r0.g
            r0 = r0 & 4
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L20
            r0 = 1
            goto L21
        L20:
            r0 = 0
        L21:
            if (r0 == 0) goto L58
            b.r.d.a r0 = r4.mAdapterHelper
            int r0 = r0.g
            r0 = r0 & 11
            if (r0 == 0) goto L2c
            r2 = 1
        L2c:
            if (r2 != 0) goto L58
            java.lang.String r0 = "RV PartialInvalidate"
            b.i.i.b.a(r0)
            r4.startInterceptRequestLayout()
            r4.onEnterLayoutOrScroll()
            b.r.d.a r0 = r4.mAdapterHelper
            r0.j()
            boolean r0 = r4.mLayoutWasDefered
            if (r0 != 0) goto L51
            boolean r0 = r4.hasUpdatedView()
            if (r0 == 0) goto L4c
            r4.dispatchLayout()
            goto L51
        L4c:
            b.r.d.a r0 = r4.mAdapterHelper
            r0.b()
        L51:
            r4.stopInterceptRequestLayout(r3)
            r4.onExitLayoutOrScroll()
            goto L66
        L58:
            b.r.d.a r0 = r4.mAdapterHelper
            boolean r0 = r0.g()
            if (r0 == 0) goto L69
            b.i.i.b.a(r1)
            r4.dispatchLayout()
        L66:
            android.os.Trace.endSection()
        L69:
            return
        L6a:
            b.i.i.b.a(r1)
            r4.dispatchLayout()
            android.os.Trace.endSection()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.consumePendingUpdateOperations():void");
    }

    public void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(o.h(i2, getPaddingRight() + getPaddingLeft(), b.i.m.l.t(this)), o.h(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildAttached(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        g gVar = this.mAdapter;
        if (gVar != null && childViewHolderInt != null && gVar == null) {
            throw null;
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        g gVar = this.mAdapter;
        if (gVar != null && childViewHolderInt != null && gVar == null) {
            throw null;
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    public void dispatchLayout() {
        String str;
        if (this.mAdapter == null) {
            str = "No adapter attached; skipping layout";
        } else {
            if (this.mLayout != null) {
                a0 a0Var = this.mState;
                boolean z2 = false;
                a0Var.i = false;
                if (a0Var.d != 1) {
                    b.r.d.a aVar = this.mAdapterHelper;
                    if (!aVar.f1016c.isEmpty() && !aVar.f1015b.isEmpty()) {
                        z2 = true;
                    }
                    if (!z2 && this.mLayout.q == getWidth() && this.mLayout.r == getHeight()) {
                        this.mLayout.M0(this);
                    }
                    dispatchLayoutStep3();
                    return;
                }
                dispatchLayoutStep1();
                this.mLayout.M0(this);
                dispatchLayoutStep2();
                dispatchLayoutStep3();
                return;
            }
            str = "No layout manager attached; skipping layout";
        }
        Log.e(TAG, str);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, i4);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().d(i2, i3, i4, i5, iArr);
    }

    public void dispatchOnScrollStateChanged(int i2) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.z0(i2);
        }
        onScrollStateChanged(i2);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).a(this, i2);
            }
        }
    }

    public void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).b(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            d0 d0Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (d0Var.f184a.getParent() == this && !d0Var.u() && (i2 = d0Var.q) != -1) {
                b.i.m.l.d0(d0Var.f184a, i2);
                d0Var.q = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        float paddingRight;
        float paddingBottom;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).e(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom2 = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom2, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                paddingRight = getPaddingRight() + (-getWidth());
                paddingBottom = getPaddingBottom() + (-getHeight());
            } else {
                paddingRight = -getWidth();
                paddingBottom = -getHeight();
            }
            canvas.translate(paddingRight, paddingBottom);
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.h()) ? z2 : true) {
            b.i.m.l.O(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void ensureBottomGlow() {
        int measuredWidth;
        int measuredHeight;
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this);
        this.mBottomGlow = edgeEffectA;
        if (this.mClipToPadding) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffectA.setSize(measuredWidth, measuredHeight);
    }

    public void ensureLeftGlow() {
        int measuredHeight;
        int measuredWidth;
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this);
        this.mLeftGlow = edgeEffectA;
        if (this.mClipToPadding) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffectA.setSize(measuredHeight, measuredWidth);
    }

    public void ensureRightGlow() {
        int measuredHeight;
        int measuredWidth;
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this);
        this.mRightGlow = edgeEffectA;
        if (this.mClipToPadding) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffectA.setSize(measuredHeight, measuredWidth);
    }

    public void ensureTopGlow() {
        int measuredWidth;
        int measuredHeight;
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.mEdgeEffectFactory.a(this);
        this.mTopGlow = edgeEffectA;
        if (this.mClipToPadding) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffectA.setSize(measuredWidth, measuredHeight);
    }

    public String exceptionLabel() {
        StringBuilder sbE = c.a.a.a.a.e(" ");
        sbE.append(super.toString());
        sbE.append(", adapter:");
        sbE.append(this.mAdapter);
        sbE.append(", layout:");
        sbE.append(this.mLayout);
        sbE.append(", context:");
        sbE.append(getContext());
        return sbE.toString();
    }

    public final void fillRemainingScrollValues(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.o = 0;
            return;
        }
        OverScroller overScroller = this.mViewFlinger.d;
        a0Var.o = overScroller.getFinalX() - overScroller.getCurrX();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int iE = this.mChildHelper.e() - 1; iE >= 0; iE--) {
            View viewD = this.mChildHelper.d(iE);
            float translationX = viewD.getTranslationX();
            float translationY = viewD.getTranslationY();
            if (f2 >= viewD.getLeft() + translationX && f2 <= viewD.getRight() + translationX && f3 >= viewD.getTop() + translationY && f3 <= viewD.getBottom() + translationY) {
                return viewD;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public d0 findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public d0 findViewHolderForAdapterPosition(int i2) {
        d0 d0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iH = this.mChildHelper.h();
        for (int i3 = 0; i3 < iH; i3++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.m() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.k(childViewHolderInt.f184a)) {
                    return childViewHolderInt;
                }
                d0Var = childViewHolderInt;
            }
        }
        return d0Var;
    }

    public d0 findViewHolderForItemId(long j2) {
        g gVar = this.mAdapter;
        d0 d0Var = null;
        if (gVar != null && gVar.f190b) {
            int iH = this.mChildHelper.h();
            for (int i2 = 0; i2 < iH; i2++) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
                if (childViewHolderInt != null && !childViewHolderInt.m() && childViewHolderInt.e == j2) {
                    if (!this.mChildHelper.k(childViewHolderInt.f184a)) {
                        return childViewHolderInt;
                    }
                    d0Var = childViewHolderInt;
                }
            }
        }
        return d0Var;
    }

    public d0 findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    @Deprecated
    public d0 findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.d0 findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            b.r.d.b r0 = r5.mChildHelper
            int r0 = r0.h()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            b.r.d.b r3 = r5.mChildHelper
            android.view.View r3 = r3.g(r2)
            androidx.recyclerview.widget.RecyclerView$d0 r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.m()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f186c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.f()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            b.r.d.b r1 = r5.mChildHelper
            android.view.View r4 = r3.f184a
            boolean r1 = r1.k(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$d0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean fling(int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewG0;
        boolean z2;
        View viewL0 = this.mLayout.l0();
        if (viewL0 != null) {
            return viewL0;
        }
        boolean z3 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.f()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.e()) {
                int i4 = (this.mLayout.I() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.g0(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewG0 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewG0 = this.mLayout.g0(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewG0 = viewFindNextFocus;
            }
        }
        if (viewG0 == null || viewG0.hasFocusable()) {
            return isPreferredNextFocus(view, viewG0, i2) ? viewG0 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        requestChildOnScreen(viewG0, null);
        return view;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.u();
        }
        throw new IllegalStateException(c.a.a.a.a.a(this, c.a.a.a.a.e("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.v(getContext(), attributeSet);
        }
        throw new IllegalStateException(c.a.a.a.a.a(this, c.a.a.a.a.e("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.w(layoutParams);
        }
        throw new IllegalStateException(c.a.a.a.a.a(this, c.a.a.a.a.e("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionFor(d0 d0Var) {
        if (d0Var.h(524) || !d0Var.j()) {
            return -1;
        }
        b.r.d.a aVar = this.mAdapterHelper;
        int i2 = d0Var.f186c;
        int size = aVar.f1015b.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar.f1015b.get(i3);
            int i4 = bVar.f1017a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f1018b;
                    if (i5 <= i2) {
                        int i6 = bVar.d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f1018b;
                    if (i7 == i2) {
                        i2 = bVar.d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f1018b <= i2) {
                i2 += bVar.d;
            }
        }
        return i2;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.mLayout;
        if (oVar == null) {
            return super.getBaseline();
        }
        if (oVar != null) {
            return -1;
        }
        throw null;
    }

    public long getChangedHolderKey(d0 d0Var) {
        return this.mAdapter.f190b ? d0Var.e : d0Var.f186c;
    }

    public int getChildAdapterPosition(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.e();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.mChildDrawingOrderCallback;
        return jVar == null ? super.getChildDrawingOrder(i2, i3) : jVar.a(i2, i3);
    }

    public long getChildItemId(View view) {
        d0 childViewHolderInt;
        g gVar = this.mAdapter;
        if (gVar == null || !gVar.f190b || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.e;
    }

    public int getChildLayoutPosition(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.f();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public d0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public b.r.d.u getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public k getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public l getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f207c) {
            return pVar.f206b;
        }
        if (this.mState.g && (pVar.b() || pVar.f205a.k())) {
            return pVar.f206b;
        }
        Rect rect = pVar.f206b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            n nVar = this.mItemDecorations.get(i2);
            Rect rect2 = this.mTempRect;
            if (nVar == null) {
                throw null;
            }
            ((p) view.getLayoutParams()).a();
            rect2.set(0, 0, 0, 0);
            int i3 = rect.left;
            Rect rect3 = this.mTempRect;
            rect.left = i3 + rect3.left;
            rect.top += rect3.top;
            rect.right += rect3.right;
            rect.bottom += rect3.bottom;
        }
        pVar.f207c = false;
        return rect;
    }

    public n getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public o getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public u getRecycledViewPool() {
        return this.mRecycler.d();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().g(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.g();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new b.r.d.a(new f());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(c.a.a.a.a.a(this, c.a.a.a.a.e("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new b.r.d.l(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(b.r.b.fastscroll_default_thickness), resources.getDimensionPixelSize(b.r.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(b.r.b.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.d("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        l lVar = this.mItemAnimator;
        return lVar != null && lVar.h();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.K0(i2);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            ((p) this.mChildHelper.g(i2).getLayoutParams()).f207c = true;
        }
        v vVar = this.mRecycler;
        int size = vVar.f215c.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) vVar.f215c.get(i3).f184a.getLayoutParams();
            if (pVar != null) {
                pVar.f207c = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (childViewHolderInt != null && !childViewHolderInt.u()) {
                childViewHolderInt.b(6);
            }
        }
        markItemDecorInsetsDirty();
        v vVar = this.mRecycler;
        int size = vVar.f215c.size();
        for (int i3 = 0; i3 < size; i3++) {
            d0 d0Var = vVar.f215c.get(i3);
            if (d0Var != null) {
                d0Var.b(6);
                d0Var.a(null);
            }
        }
        g gVar = RecyclerView.this.mAdapter;
        if (gVar == null || !gVar.f190b) {
            vVar.f();
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int iE = this.mChildHelper.e();
        for (int i3 = 0; i3 < iE; i3++) {
            this.mChildHelper.d(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int iE = this.mChildHelper.e();
        for (int i3 = 0; i3 < iE; i3++) {
            this.mChildHelper.d(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetPositionRecordsForInsert(int i2, int i3) {
        int iH = this.mChildHelper.h();
        for (int i4 = 0; i4 < iH; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i4));
            if (childViewHolderInt != null && !childViewHolderInt.u() && childViewHolderInt.f186c >= i2) {
                childViewHolderInt.q(i3, false);
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f215c.size();
        for (int i5 = 0; i5 < size; i5++) {
            d0 d0Var = vVar.f215c.get(i5);
            if (d0Var != null && d0Var.f186c >= i2) {
                d0Var.q(i3, true);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iH = this.mChildHelper.h();
        int i11 = -1;
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i12 = 0; i12 < iH; i12++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i12));
            if (childViewHolderInt != null && (i10 = childViewHolderInt.f186c) >= i5 && i10 <= i4) {
                if (i10 == i2) {
                    childViewHolderInt.q(i3 - i2, false);
                } else {
                    childViewHolderInt.q(i6, false);
                }
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        if (i2 < i3) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i8 = i3;
            i11 = 1;
        }
        int size = vVar.f215c.size();
        for (int i13 = 0; i13 < size; i13++) {
            d0 d0Var = vVar.f215c.get(i13);
            if (d0Var != null && (i9 = d0Var.f186c) >= i8 && i9 <= i7) {
                if (i9 == i2) {
                    d0Var.q(i3 - i2, false);
                } else {
                    d0Var.q(i11, false);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iH = this.mChildHelper.h();
        for (int i5 = 0; i5 < iH; i5++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i5));
            if (childViewHolderInt != null && !childViewHolderInt.u()) {
                int i6 = childViewHolderInt.f186c;
                if (i6 >= i4) {
                    childViewHolderInt.q(-i3, z2);
                } else if (i6 >= i2) {
                    childViewHolderInt.b(8);
                    childViewHolderInt.q(-i3, z2);
                    childViewHolderInt.f186c = i2 - 1;
                }
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f215c.size();
        while (true) {
            size--;
            if (size < 0) {
                requestLayout();
                return;
            }
            d0 d0Var = vVar.f215c.get(size);
            if (d0Var != null) {
                int i7 = d0Var.f186c;
                if (i7 >= i4) {
                    d0Var.q(-i3, z2);
                } else if (i7 >= i2) {
                    d0Var.b(8);
                    vVar.g(size);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.i = true;
            oVar.d0();
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            b.r.d.m mVar = b.r.d.m.f.get();
            this.mGapWorker = mVar;
            if (mVar == null) {
                this.mGapWorker = new b.r.d.m();
                Display displayL = b.i.m.l.l(this);
                float f2 = 60.0f;
                if (!isInEditMode() && displayL != null) {
                    float refreshRate = displayL.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                b.r.d.m mVar2 = this.mGapWorker;
                mVar2.d = (long) (1.0E9f / f2);
                b.r.d.m.f.set(mVar2);
            }
            this.mGapWorker.f1060b.add(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        b.r.d.m mVar;
        super.onDetachedFromWindow();
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.g();
        }
        stopScroll();
        this.mIsAttached = false;
        o oVar = this.mLayout;
        if (oVar != null) {
            v vVar = this.mRecycler;
            oVar.i = false;
            oVar.f0(this, vVar);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        if (this.mViewInfoStore == null) {
            throw null;
        }
        while (z.a.d.a() != null) {
        }
        if (!ALLOW_THREAD_GAP_WORK || (mVar = this.mGapWorker) == null) {
            return;
        }
        mVar.f1060b.remove(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).d(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public void onExitLayoutOrScroll(boolean z2) {
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            boolean r0 = r0.f()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.e()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.f()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.e()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            return false;
        }
        boolean zE = oVar.e();
        boolean zF = this.mLayout.f();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zE ? 1 : 0;
            if (zF) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                StringBuilder sbE = c.a.a.a.a.e("Error processing scroll; pointer index for id ");
                sbE.append(this.mScrollPointerId);
                sbE.append(" not found. Did any MotionEvents get skipped?");
                Log.e(TAG, sbE.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x3 - this.mInitialTouchX;
                int i4 = y3 - this.mInitialTouchY;
                if (!zE || Math.abs(i3) <= this.mTouchSlop) {
                    z2 = false;
                } else {
                    this.mLastTouchX = x3;
                    z2 = true;
                }
                if (zF && Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        b.i.i.b.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.U()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.u0(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (z2 || this.mAdapter == null) {
                return;
            }
            if (this.mState.d == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.N0(i2, i3);
            this.mState.i = true;
            dispatchLayoutStep2();
            this.mLayout.P0(i2, i3);
            if (this.mLayout.S0()) {
                this.mLayout.N0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.i = true;
                dispatchLayoutStep2();
                this.mLayout.P0(i2, i3);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.u0(i2, i3);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            a0 a0Var = this.mState;
            if (a0Var.k) {
                a0Var.g = true;
            } else {
                this.mAdapterHelper.c();
                this.mState.g = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.mAdapter;
        if (gVar != null) {
            this.mState.e = gVar.a();
        } else {
            this.mState.e = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.u0(i2, i3);
        stopInterceptRequestLayout(false);
        this.mState.g = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.mPendingSavedState = yVar;
        super.onRestoreInstanceState(yVar.f890b);
        o oVar = this.mLayout;
        if (oVar == null || (parcelable2 = this.mPendingSavedState.d) == null) {
            return;
        }
        oVar.x0(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.mPendingSavedState;
        if (yVar2 != null) {
            yVar.d = yVar2.d;
        } else {
            o oVar = this.mLayout;
            yVar.d = oVar != null ? oVar.y0() : null;
        }
        return yVar;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9 A[PHI: r0
  0x00d9: PHI (r0v44 int) = (r0v31 int), (r0v48 int) binds: [B:41:0x00c4, B:46:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        b.i.m.l.P(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(d0 d0Var, l.c cVar) {
        d0Var.s(0, 8192);
        if (this.mState.h && d0Var.p() && !d0Var.m() && !d0Var.u()) {
            this.mViewInfoStore.f1086b.g(getChangedHolderKey(d0Var), d0Var);
        }
        this.mViewInfoStore.c(d0Var, cVar);
    }

    public void removeAndRecycleViews() {
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.g();
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.C0(this.mRecycler);
            this.mLayout.D0(this.mRecycler);
        }
        this.mRecycler.b();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        b.r.d.b bVar = this.mChildHelper;
        int iIndexOfChild = RecyclerView.this.indexOfChild(view);
        boolean z2 = true;
        if (iIndexOfChild == -1) {
            bVar.l(view);
        } else if (bVar.f1021b.d(iIndexOfChild)) {
            bVar.f1021b.f(iIndexOfChild);
            bVar.l(view);
            ((e) bVar.f1020a).c(iIndexOfChild);
        } else {
            z2 = false;
        }
        if (z2) {
            d0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.l(childViewHolderInt);
            this.mRecycler.i(childViewHolderInt);
        }
        stopInterceptRequestLayout(!z2);
        return z2;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.o()) {
                childViewHolderInt.j &= -257;
            } else if (!childViewHolderInt.u()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(c.a.a.a.a.a(this, sb));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(n nVar) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.d("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(nVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i2));
            return;
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(q qVar) {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    public void removeOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.remove(sVar);
        if (this.mInterceptingOnItemTouchListener == sVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(t tVar) {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public void repositionShadowingViews() {
        d0 d0Var;
        int iE = this.mChildHelper.e();
        for (int i2 = 0; i2 < iE; i2++) {
            View viewD = this.mChildHelper.d(i2);
            d0 childViewHolder = getChildViewHolder(viewD);
            if (childViewHolder != null && (d0Var = childViewHolder.i) != null) {
                View view = d0Var.f184a;
                int left = viewD.getLeft();
                int top = viewD.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.w0(this, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.H0(this, view, rect, z2, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.u() && childViewHolderInt.d == -1) {
                childViewHolderInt.d = childViewHolderInt.f186c;
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zE = oVar.e();
        boolean zF = this.mLayout.f();
        if (zE || zF) {
            if (!zE) {
                i2 = 0;
            }
            if (!zF) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null);
        }
    }

    public boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i5, i4, i6, i7, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i10 = i6 - iArr4[0];
        int i11 = i7 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i12 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    pullGlows(motionEvent.getX(), i10, motionEvent.getY(), i11);
                }
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            dispatchOnScrolled(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i5 == 0 && i4 == 0) ? false : true;
    }

    public void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        b.i.i.b.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iJ0 = i2 != 0 ? this.mLayout.J0(i2, this.mRecycler, this.mState) : 0;
        int iL0 = i3 != 0 ? this.mLayout.L0(i3, this.mRecycler, this.mState) : 0;
        Trace.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iJ0;
            iArr[1] = iL0;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.K0(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(b.r.d.u uVar) {
        this.mAccessibilityDelegate = uVar;
        b.i.m.l.W(this, uVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    public boolean setChildImportantForAccessibilityInternal(d0 d0Var, int i2) {
        if (!isComputingLayout()) {
            b.i.m.l.d0(d0Var.f184a, i2);
            return true;
        }
        d0Var.q = i2;
        this.mPendingAccessibilityImportanceChange.add(d0Var);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        if (kVar == null) {
            throw null;
        }
        this.mEdgeEffectFactory = kVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z2) {
        this.mHasFixedSize = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.mItemAnimator;
        if (lVar2 != null) {
            lVar2.g();
            this.mItemAnimator.f191a = null;
        }
        this.mItemAnimator = lVar;
        if (lVar != null) {
            lVar.f191a = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i2) {
        v vVar = this.mRecycler;
        vVar.e = i2;
        vVar.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            l lVar = this.mItemAnimator;
            if (lVar != null) {
                lVar.g();
            }
            this.mLayout.C0(this.mRecycler);
            this.mLayout.D0(this.mRecycler);
            this.mRecycler.b();
            if (this.mIsAttached) {
                o oVar2 = this.mLayout;
                v vVar = this.mRecycler;
                oVar2.i = false;
                oVar2.f0(this, vVar);
            }
            this.mLayout.Q0(null);
            this.mLayout = null;
        } else {
            this.mRecycler.b();
        }
        b.r.d.b bVar = this.mChildHelper;
        b.a aVar = bVar.f1021b;
        aVar.f1023a = 0L;
        b.a aVar2 = aVar.f1024b;
        if (aVar2 != null) {
            aVar2.g();
        }
        int size = bVar.f1022c.size();
        while (true) {
            size--;
            if (size < 0) {
                e eVar = (e) bVar.f1020a;
                int iB = eVar.b();
                for (int i2 = 0; i2 < iB; i2++) {
                    View viewA = eVar.a(i2);
                    RecyclerView.this.dispatchChildDetached(viewA);
                    viewA.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
                this.mLayout = oVar;
                if (oVar != null) {
                    if (oVar.f198b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("LayoutManager ");
                        sb.append(oVar);
                        sb.append(" is already attached to a RecyclerView:");
                        throw new IllegalArgumentException(c.a.a.a.a.a(oVar.f198b, sb));
                    }
                    oVar.Q0(this);
                    if (this.mIsAttached) {
                        o oVar3 = this.mLayout;
                        oVar3.i = true;
                        oVar3.d0();
                    }
                }
                this.mRecycler.m();
                requestLayout();
                return;
            }
            b.InterfaceC0043b interfaceC0043b = bVar.f1020a;
            View view = bVar.f1022c.get(size);
            e eVar2 = (e) interfaceC0043b;
            if (eVar2 == null) {
                throw null;
            }
            d0 childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                RecyclerView.this.setChildImportantForAccessibilityInternal(childViewHolderInt, childViewHolderInt.p);
                childViewHolderInt.p = 0;
            }
            bVar.f1022c.remove(size);
        }
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        b.i.m.f scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            b.i.m.l.i0(scrollingChildHelper.f830c);
        }
        scrollingChildHelper.d = z2;
    }

    public void setOnFlingListener(r rVar) {
        this.mOnFlingListener = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.mScrollListener = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.mPreserveFocusAfterLayout = z2;
    }

    public void setRecycledViewPool(u uVar) {
        v vVar = this.mRecycler;
        if (vVar.g != null) {
            r1.f209b--;
        }
        vVar.g = uVar;
        if (uVar == null || RecyclerView.this.getAdapter() == null) {
            return;
        }
        vVar.g.f209b++;
    }

    public void setRecyclerListener(w wVar) {
        this.mRecyclerListener = wVar;
    }

    public void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 == 0) {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else if (i2 != 1) {
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else {
            scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.mTouchSlop = scaledTouchSlop;
    }

    public void setViewCacheExtension(b0 b0Var) {
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
        this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        return true;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, UNDEFINED_DURATION);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!oVar.e()) {
            i2 = 0;
        }
        if (!this.mLayout.f()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (!(i4 == Integer.MIN_VALUE || i4 > 0)) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            startNestedScroll(i5, 1);
        }
        this.mViewFlinger.b(i2, i3, i4, interpolator);
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.U0(this, this.mState, i2);
        }
    }

    public void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().h(i2, 0);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().h(i2, i3);
    }

    public void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().i(0);
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().i(i2);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(g gVar, boolean z2) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, true, z2);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int i5;
        int iH = this.mChildHelper.h();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < iH; i7++) {
            View viewG = this.mChildHelper.g(i7);
            d0 childViewHolderInt = getChildViewHolderInt(viewG);
            if (childViewHolderInt != null && !childViewHolderInt.u() && (i5 = childViewHolderInt.f186c) >= i2 && i5 < i6) {
                childViewHolderInt.b(2);
                childViewHolderInt.a(obj);
                ((p) viewG.getLayoutParams()).f207c = true;
            }
        }
        v vVar = this.mRecycler;
        int size = vVar.f215c.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            d0 d0Var = vVar.f215c.get(size);
            if (d0Var != null && (i4 = d0Var.f186c) >= i2 && i4 < i6) {
                d0Var.b(2);
                vVar.g(size);
            }
        }
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, null);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().f(i2) != null;
    }
}
