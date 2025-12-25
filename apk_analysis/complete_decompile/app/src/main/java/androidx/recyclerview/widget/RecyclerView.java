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
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p000.AbstractC1726qj;
import p000.C1540m9;
import p000.C1935w6;
import p000.C1972x6;
import p000.f92;
import p000.sn1;
import p000.ye0;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {

    /* renamed from: C0 */
    public static boolean f7065C0 = false;

    /* renamed from: D0 */
    public static boolean f7066D0 = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_TYPE = -1;

    /* renamed from: J0 */
    public static final Class[] f7072J0;

    /* renamed from: K0 */
    public static final f92 f7073K0;

    /* renamed from: L0 */
    public static final C0458a1 f7074L0;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;

    /* renamed from: A */
    public int f7075A;

    /* renamed from: A0 */
    public int f7076A0;

    /* renamed from: B */
    public boolean f7077B;

    /* renamed from: B0 */
    public final C0499p0 f7078B0;

    /* renamed from: C */
    public final AccessibilityManager f7079C;

    /* renamed from: D */
    public ArrayList f7080D;

    /* renamed from: E */
    public boolean f7081E;

    /* renamed from: F */
    public boolean f7082F;

    /* renamed from: G */
    public int f7083G;

    /* renamed from: H */
    public int f7084H;

    /* renamed from: I */
    public EdgeEffectFactory f7085I;

    /* renamed from: J */
    public EdgeEffect f7086J;

    /* renamed from: K */
    public EdgeEffect f7087K;

    /* renamed from: L */
    public EdgeEffect f7088L;

    /* renamed from: M */
    public EdgeEffect f7089M;

    /* renamed from: N */
    public ItemAnimator f7090N;

    /* renamed from: O */
    public int f7091O;

    /* renamed from: P */
    public int f7092P;

    /* renamed from: Q */
    public VelocityTracker f7093Q;

    /* renamed from: R */
    public int f7094R;

    /* renamed from: S */
    public int f7095S;

    /* renamed from: T */
    public int f7096T;

    /* renamed from: U */
    public int f7097U;

    /* renamed from: V */
    public int f7098V;

    /* renamed from: W */
    public OnFlingListener f7099W;

    /* renamed from: a */
    public final float f7100a;

    /* renamed from: a0 */
    public final int f7101a0;

    /* renamed from: b */
    public final C0517y0 f7102b;

    /* renamed from: b0 */
    public final int f7103b0;

    /* renamed from: c */
    public final Recycler f7104c;

    /* renamed from: c0 */
    public final float f7105c0;

    /* renamed from: d */
    public SavedState f7106d;

    /* renamed from: d0 */
    public final float f7107d0;

    /* renamed from: e */
    public final C0456a f7108e;

    /* renamed from: e0 */
    public boolean f7109e0;

    /* renamed from: f */
    public final C0474g f7110f;

    /* renamed from: f0 */
    public final RunnableC0461b1 f7111f0;

    /* renamed from: g */
    public final C0488k1 f7112g;

    /* renamed from: g0 */
    public RunnableC0508u f7113g0;

    /* renamed from: h */
    public boolean f7114h;

    /* renamed from: h0 */
    public final C0506t f7115h0;

    /* renamed from: i */
    public final sn1 f7116i;

    /* renamed from: i0 */
    public final State f7117i0;

    /* renamed from: j */
    public final Rect f7118j;

    /* renamed from: j0 */
    public OnScrollListener f7119j0;

    /* renamed from: k */
    public final Rect f7120k;

    /* renamed from: k0 */
    public ArrayList f7121k0;

    /* renamed from: l */
    public final RectF f7122l;

    /* renamed from: l0 */
    public boolean f7123l0;

    /* renamed from: m */
    public Adapter f7124m;

    /* renamed from: m0 */
    public boolean f7125m0;

    /* renamed from: n */
    public LayoutManager f7126n;

    /* renamed from: n0 */
    public final C0509u0 f7127n0;

    /* renamed from: o */
    public RecyclerListener f7128o;

    /* renamed from: o0 */
    public boolean f7129o0;

    /* renamed from: p */
    public final ArrayList f7130p;

    /* renamed from: p0 */
    public RecyclerViewAccessibilityDelegate f7131p0;

    /* renamed from: q */
    public final ArrayList f7132q;

    /* renamed from: q0 */
    public ChildDrawingOrderCallback f7133q0;

    /* renamed from: r */
    public final ArrayList f7134r;

    /* renamed from: r0 */
    public final int[] f7135r0;

    /* renamed from: s */
    public OnItemTouchListener f7136s;

    /* renamed from: s0 */
    public NestedScrollingChildHelper f7137s0;

    /* renamed from: t */
    public boolean f7138t;

    /* renamed from: t0 */
    public final int[] f7139t0;

    /* renamed from: u */
    public boolean f7140u;

    /* renamed from: u0 */
    public final int[] f7141u0;

    /* renamed from: v */
    public boolean f7142v;

    /* renamed from: v0 */
    public final int[] f7143v0;

    /* renamed from: w */
    public int f7144w;

    /* renamed from: w0 */
    public final ArrayList f7145w0;

    /* renamed from: x */
    public boolean f7146x;

    /* renamed from: x0 */
    public final RunnableC0497o0 f7147x0;

    /* renamed from: y */
    public boolean f7148y;

    /* renamed from: y0 */
    public boolean f7149y0;

    /* renamed from: z */
    public boolean f7150z;

    /* renamed from: z0 */
    public int f7151z0;

    /* renamed from: E0 */
    public static final int[] f7067E0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: F0 */
    public static final float f7068F0 = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: G0 */
    public static final boolean f7069G0 = true;

    /* renamed from: H0 */
    public static final boolean f7070H0 = true;

    /* renamed from: I0 */
    public static final boolean f7071I0 = true;

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {

        /* renamed from: a */
        public final C0507t0 f7152a = new Observable();

        /* renamed from: b */
        public boolean f7153b = false;

        /* renamed from: c */
        public StateRestorationPolicy f7154c = StateRestorationPolicy.ALLOW;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* loaded from: classes.dex */
        public static final class StateRestorationPolicy {
            public static final StateRestorationPolicy ALLOW;
            public static final StateRestorationPolicy PREVENT;
            public static final StateRestorationPolicy PREVENT_WHEN_EMPTY;

            /* renamed from: a */
            public static final /* synthetic */ StateRestorationPolicy[] f7155a;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v0, types: [androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy, java.lang.Enum] */
            /* JADX WARN: Type inference failed for: r4v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy, java.lang.Enum] */
            /* JADX WARN: Type inference failed for: r5v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy, java.lang.Enum] */
            static {
                ?? r3 = new Enum("ALLOW", 0);
                ALLOW = r3;
                ?? r4 = new Enum("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r4;
                ?? r5 = new Enum("PREVENT", 2);
                PREVENT = r5;
                f7155a = new StateRestorationPolicy[]{r3, r4, r5};
            }

            public static StateRestorationPolicy valueOf(String str) {
                return (StateRestorationPolicy) Enum.valueOf(StateRestorationPolicy.class, str);
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) f7155a.clone();
            }
        }

        public final void bindViewHolder(@NonNull VH vh, int i) {
            boolean z;
            if (vh.f7245r == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                vh.f7229b = i;
                if (hasStableIds()) {
                    vh.f7231d = getItemId(i);
                }
                vh.f7236i = (vh.f7236i & (-520)) | 1;
                TraceCompat.beginSection("RV OnBindView");
            }
            vh.f7245r = this;
            if (RecyclerView.f7065C0) {
                if (vh.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh.itemView) != vh.m1764i()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + vh.m1764i() + ", attached to window: " + ViewCompat.isAttachedToWindow(vh.itemView) + ", holder: " + vh);
                }
                if (vh.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh.itemView)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + vh);
                }
            }
            onBindViewHolder(vh, i, vh.m1757b());
            if (z) {
                ArrayList arrayList = vh.f7237j;
                if (arrayList != null) {
                    arrayList.clear();
                }
                vh.f7236i &= -1025;
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f7180c = true;
                }
                TraceCompat.endSection();
            }
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.f7232e = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
        }

        public int findRelativeAdapterPositionIn(@NonNull Adapter<? extends ViewHolder> adapter, @NonNull ViewHolder viewHolder, int i) {
            if (adapter == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.f7154c;
        }

        public final boolean hasObservers() {
            return this.f7152a.m1890a();
        }

        public final boolean hasStableIds() {
            return this.f7153b;
        }

        public final void notifyDataSetChanged() {
            this.f7152a.m1891b();
        }

        public final void notifyItemChanged(int i, @Nullable Object obj) {
            this.f7152a.m1893d(i, 1, obj);
        }

        public final void notifyItemInserted(int i) {
            this.f7152a.m1894e(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.f7152a.m1892c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            this.f7152a.m1893d(i, i2, obj);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.f7152a.m1894e(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.f7152a.m1895f(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.f7152a.m1895f(i, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
            onBindViewHolder(vh, i);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f7152a.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.f7153b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(@NonNull StateRestorationPolicy stateRestorationPolicy) {
            this.f7154c = stateRestorationPolicy;
            this.f7152a.m1896g();
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f7152a.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i) {
            this.f7152a.m1893d(i, 1, null);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.f7152a.m1893d(i, i2, null);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface EdgeDirection {
        }

        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;

        /* renamed from: a */
        public C0509u0 f7156a = null;

        /* renamed from: b */
        public final ArrayList f7157b = new ArrayList();

        /* renamed from: c */
        public long f7158c = 120;

        /* renamed from: d */
        public long f7159d = 120;

        /* renamed from: e */
        public long f7160e = 250;

        /* renamed from: f */
        public long f7161f = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface AdapterChanges {
        }

        /* loaded from: classes.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        /* renamed from: a */
        public static int m1728a(ViewHolder viewHolder) {
            int i = viewHolder.f7236i;
            int i2 = i & 14;
            if (viewHolder.m1761f()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                if (oldPosition != -1 && absoluteAdapterPosition != -1 && oldPosition != absoluteAdapterPosition) {
                    return i2 | 2048;
                }
                return i2;
            }
            return i2;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            C0509u0 c0509u0 = this.f7156a;
            if (c0509u0 != null) {
                boolean z = true;
                viewHolder.setIsRecyclable(true);
                if (viewHolder.f7234g != null && viewHolder.f7235h == null) {
                    viewHolder.f7234g = null;
                }
                viewHolder.f7235h = null;
                if ((viewHolder.f7236i & 16) == 0) {
                    View view = viewHolder.itemView;
                    RecyclerView recyclerView = c0509u0.f7510a;
                    recyclerView.m1708d0();
                    C0474g c0474g = recyclerView.f7110f;
                    C1972x6 c1972x6 = c0474g.f7376b;
                    C0501q0 c0501q0 = c0474g.f7375a;
                    int i = c0474g.f7378d;
                    if (i == 1) {
                        if (c0474g.f7379e != view) {
                            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
                        }
                    } else {
                        if (i != 2) {
                            try {
                                c0474g.f7378d = 2;
                                int indexOfChild = c0501q0.f7466a.indexOfChild(view);
                                if (indexOfChild == -1) {
                                    c0474g.m1842l(view);
                                } else if (c1972x6.m8140d(indexOfChild)) {
                                    c1972x6.m8142f(indexOfChild);
                                    c0474g.m1842l(view);
                                    c0501q0.m1878a(indexOfChild);
                                }
                                if (z) {
                                    ViewHolder m1672F = RecyclerView.m1672F(view);
                                    Recycler recycler = recyclerView.f7104c;
                                    recycler.m1751k(m1672F);
                                    recycler.m1747g(m1672F);
                                    if (RecyclerView.f7066D0) {
                                        Log.d("RecyclerView", "after removing animated view: " + view + ", " + recyclerView);
                                    }
                                }
                                recyclerView.m1709e0(!z);
                                if (z && viewHolder.m1764i()) {
                                    recyclerView.removeDetachedView(viewHolder.itemView, false);
                                    return;
                                }
                            } finally {
                                c0474g.f7378d = 0;
                            }
                        }
                        throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
                    }
                    z = false;
                    if (z) {
                    }
                    recyclerView.m1709e0(!z);
                    if (z) {
                    }
                }
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            ArrayList arrayList = this.f7157b;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ItemAnimatorFinishedListener) arrayList.get(i)).onAnimationsFinished();
            }
            arrayList.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.f7158c;
        }

        public long getChangeDuration() {
            return this.f7161f;
        }

        public long getMoveDuration() {
            return this.f7160e;
        }

        public long getRemoveDuration() {
            return this.f7159d;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.f7157b.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.f7158c = j;
        }

        public void setChangeDuration(long j) {
            this.f7161f = j;
        }

        public void setMoveDuration(long j) {
            this.f7160e = j;
        }

        public void setRemoveDuration(long j) {
            this.f7159d = j;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {

        /* renamed from: a */
        public C0474g f7162a;

        /* renamed from: b */
        public RecyclerView f7163b;

        /* renamed from: c */
        public final C1540m9 f7164c;

        /* renamed from: d */
        public final C1540m9 f7165d;

        /* renamed from: e */
        public SmoothScroller f7166e;

        /* renamed from: f */
        public boolean f7167f;

        /* renamed from: g */
        public boolean f7168g;

        /* renamed from: h */
        public boolean f7169h;

        /* renamed from: i */
        public boolean f7170i;

        /* renamed from: j */
        public boolean f7171j;

        /* renamed from: k */
        public int f7172k;

        /* renamed from: l */
        public boolean f7173l;

        /* renamed from: m */
        public int f7174m;

        /* renamed from: n */
        public int f7175n;

        /* renamed from: o */
        public int f7176o;

        /* renamed from: p */
        public int f7177p;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public LayoutManager() {
            C0511v0 c0511v0 = new C0511v0(this);
            C0513w0 c0513w0 = new C0513w0(this);
            this.f7164c = new C1540m9(c0511v0);
            this.f7165d = new C1540m9(c0513w0);
            this.f7167f = false;
            this.f7168g = false;
            this.f7169h = false;
            this.f7170i = true;
            this.f7171j = true;
        }

        /* renamed from: b */
        public static boolean m1729b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode != 1073741824 || size != i) {
                    return false;
                }
                return true;
            }
            if (size < i) {
                return false;
            }
            return true;
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    return Math.max(i2, i3);
                }
                return size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            if (r3 >= 0) goto L5;
         */
        @Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = i - i2;
            int i5 = 0;
            int max = Math.max(0, i4);
            if (!z) {
                if (i3 < 0) {
                    if (i3 == -1) {
                        i3 = max;
                    } else {
                        if (i3 == -2) {
                            i5 = Integer.MIN_VALUE;
                            i3 = max;
                        }
                        i3 = 0;
                    }
                }
                i5 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i5);
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        /* renamed from: a */
        public final void m1730a(int i, View view, boolean z) {
            ViewHolder m1672F = RecyclerView.m1672F(view);
            if (!z && !m1672F.m1762g()) {
                this.f7163b.f7112g.m1876c(m1672F);
            } else {
                SimpleArrayMap simpleArrayMap = this.f7163b.f7112g.f7428a;
                C0485j1 c0485j1 = (C0485j1) simpleArrayMap.get(m1672F);
                if (c0485j1 == null) {
                    c0485j1 = C0485j1.m1873a();
                    simpleArrayMap.put(m1672F, c0485j1);
                }
                c0485j1.f7415a |= 1;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!m1672F.m1769n() && !m1672F.m1763h()) {
                if (view.getParent() == this.f7163b) {
                    int m1840j = this.f7162a.m1840j(view);
                    if (i == -1) {
                        i = this.f7162a.m1835e();
                    }
                    if (m1840j != -1) {
                        if (m1840j != i) {
                            this.f7163b.f7126n.moveView(m1840j, i);
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        sb.append(this.f7163b.indexOfChild(view));
                        throw new IllegalStateException(AbstractC1726qj.m7056l(this.f7163b, sb));
                    }
                } else {
                    this.f7162a.m1831a(i, view, false);
                    layoutParams.f7180c = true;
                    SmoothScroller smoothScroller = this.f7166e;
                    if (smoothScroller != null && smoothScroller.isRunning()) {
                        this.f7166e.onChildAttachedToWindow(view);
                    }
                }
            } else {
                if (m1672F.m1763h()) {
                    m1672F.f7240m.m1751k(m1672F);
                } else {
                    m1672F.f7236i &= -33;
                }
                this.f7162a.m1832b(view, i, view.getLayoutParams(), false);
            }
            if (layoutParams.f7181d) {
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "consuming pending invalidate on child " + layoutParams.f7178a);
                }
                m1672F.itemView.invalidate();
                layoutParams.f7181d = false;
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null && !recyclerView.isComputingLayout()) {
                if (str == null) {
                    throw new IllegalStateException(AbstractC1726qj.m7056l(recyclerView, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
                }
                throw new IllegalStateException(AbstractC1726qj.m7056l(recyclerView, AbstractC1726qj.m7064t(str)));
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                recyclerView.m1711h(str);
            }
        }

        public void attachView(@NonNull View view, int i, LayoutParams layoutParams) {
            ViewHolder m1672F = RecyclerView.m1672F(view);
            if (m1672F.m1762g()) {
                SimpleArrayMap simpleArrayMap = this.f7163b.f7112g.f7428a;
                C0485j1 c0485j1 = (C0485j1) simpleArrayMap.get(m1672F);
                if (c0485j1 == null) {
                    c0485j1 = C0485j1.m1873a();
                    simpleArrayMap.put(m1672F, c0485j1);
                }
                c0485j1.f7415a |= 1;
            } else {
                this.f7163b.f7112g.m1876c(m1672F);
            }
            this.f7162a.m1832b(view, i, layoutParams, m1672F.m1762g());
        }

        /* renamed from: c */
        public final void m1731c(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder m1672F = RecyclerView.m1672F(view);
            if (m1672F != null && !m1672F.m1762g()) {
                C0474g c0474g = this.f7162a;
                if (!c0474g.f7377c.contains(m1672F.itemView)) {
                    RecyclerView recyclerView = this.f7163b;
                    onInitializeAccessibilityNodeInfoForItem(recyclerView.f7104c, recyclerView.f7117i0, view, accessibilityNodeInfoCompat);
                }
            }
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.m1686H(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        /* renamed from: d */
        public final void m1732d(Recycler recycler) {
            ArrayList arrayList;
            int size = recycler.f7185a.size();
            int i = size - 1;
            while (true) {
                arrayList = recycler.f7185a;
                if (i < 0) {
                    break;
                }
                View view = ((ViewHolder) arrayList.get(i)).itemView;
                ViewHolder m1672F = RecyclerView.m1672F(view);
                if (!m1672F.m1768m()) {
                    m1672F.setIsRecyclable(false);
                    if (m1672F.m1764i()) {
                        this.f7163b.removeDetachedView(view, false);
                    }
                    ItemAnimator itemAnimator = this.f7163b.f7090N;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(m1672F);
                    }
                    m1672F.setIsRecyclable(true);
                    ViewHolder m1672F2 = RecyclerView.m1672F(view);
                    m1672F2.f7240m = null;
                    m1672F2.f7241n = false;
                    m1672F2.f7236i &= -33;
                    recycler.m1747g(m1672F2);
                }
                i--;
            }
            arrayList.clear();
            ArrayList arrayList2 = recycler.f7186b;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.f7163b.invalidate();
            }
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                m1733e(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            m1733e(recycler, this.f7162a.m1840j(view), view);
        }

        public void detachAndScrapViewAt(int i, @NonNull Recycler recycler) {
            m1733e(recycler, i, getChildAt(i));
        }

        public void detachView(@NonNull View view) {
            int m1840j = this.f7162a.m1840j(view);
            if (m1840j >= 0) {
                this.f7162a.m1833c(m1840j);
            }
        }

        public void detachViewAt(int i) {
            getChildAt(i);
            this.f7162a.m1833c(i);
        }

        /* renamed from: e */
        public final void m1733e(Recycler recycler, int i, View view) {
            ViewHolder m1672F = RecyclerView.m1672F(view);
            if (m1672F.m1768m()) {
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "ignoring view " + m1672F);
                    return;
                }
                return;
            }
            if (m1672F.m1761f() && !m1672F.m1762g() && !this.f7163b.f7124m.hasStableIds()) {
                removeViewAt(i);
                recycler.m1747g(m1672F);
            } else {
                detachViewAt(i);
                recycler.m1748h(view);
                this.f7163b.f7112g.m1876c(m1672F);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.f7163b.f7090N;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.m1672F(view));
            }
        }

        /* renamed from: f */
        public final void m1734f(RecyclerView recyclerView) {
            m1735g(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f7162a.f7377c.contains(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        @Nullable
        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder m1672F = RecyclerView.m1672F(childAt);
                if (m1672F != null && m1672F.getLayoutPosition() == i && !m1672F.m1768m() && (this.f7163b.f7117i0.isPreLayout() || !m1672F.m1762g())) {
                    return childAt;
                }
            }
            return null;
        }

        /* renamed from: g */
        public final void m1735g(int i, int i2) {
            this.f7176o = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.f7174m = mode;
            if (mode == 0 && !RecyclerView.f7069G0) {
                this.f7176o = 0;
            }
            this.f7177p = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f7175n = mode2;
            if (mode2 == 0 && !RecyclerView.f7069G0) {
                this.f7177p = 0;
            }
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7179b.bottom;
        }

        @Nullable
        public View getChildAt(int i) {
            C0474g c0474g = this.f7162a;
            if (c0474g != null) {
                return c0474g.m1834d(i);
            }
            return null;
        }

        public int getChildCount() {
            C0474g c0474g = this.f7162a;
            if (c0474g != null) {
                return c0474g.m1835e();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null && recyclerView.f7114h) {
                return true;
            }
            return false;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        public int getDecoratedBottom(@NonNull View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.m1673G(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f7179b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f7179b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f7162a.f7377c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @Px
        public int getHeight() {
            return this.f7177p;
        }

        public int getHeightMode() {
            return this.f7175n;
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.m1672F(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.f7163b);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7179b.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.f7163b);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.f7163b);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7179b.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7179b.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f7179b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f7163b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f7163b.f7122l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        @Px
        public int getWidth() {
            return this.f7176o;
        }

        public int getWidthMode() {
            return this.f7174m;
        }

        /* renamed from: h */
        public final void m1736h(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.f7163b.m1715n(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.f7163b.f7118j;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i6) {
                    i6 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.f7163b.f7118j.set(i6, i4, i3, i5);
            setMeasuredDimension(this.f7163b.f7118j, i, i2);
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null && recyclerView.hasFocus()) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void m1737i(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f7163b = null;
                this.f7162a = null;
                this.f7176o = 0;
                this.f7177p = 0;
            } else {
                this.f7163b = recyclerView;
                this.f7162a = recyclerView.f7110f;
                this.f7176o = recyclerView.getWidth();
                this.f7177p = recyclerView.getHeight();
            }
            this.f7174m = 1073741824;
            this.f7175n = 1073741824;
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.f7163b;
            if (parent == recyclerView && recyclerView.indexOfChild(view) != -1) {
                ViewHolder m1672F = RecyclerView.m1672F(view);
                m1672F.m1756a(128);
                this.f7163b.f7112g.m1877d(m1672F);
                return;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7056l(this.f7163b, new StringBuilder("View should be fully attached to be ignored")));
        }

        public boolean isAttachedToWindow() {
            return this.f7168g;
        }

        public boolean isAutoMeasureEnabled() {
            return this.f7169h;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null && recyclerView.isFocused()) {
                return true;
            }
            return false;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.f7171j;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.f7170i;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.f7166e;
            if (smoothScroller != null && smoothScroller.isRunning()) {
                return true;
            }
            return false;
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z, boolean z2) {
            boolean z3;
            if (this.f7164c.m6098h(view) && this.f7165d.m6098h(view)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z) {
                return z3;
            }
            return !z3;
        }

        /* renamed from: j */
        public final boolean m1738j(View view, int i, int i2, LayoutParams layoutParams) {
            if (!view.isLayoutRequested() && this.f7170i && m1729b(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && m1729b(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        /* renamed from: k */
        public boolean mo1650k() {
            return false;
        }

        /* renamed from: l */
        public final boolean m1739l(View view, int i, int i2, LayoutParams layoutParams) {
            if (this.f7170i && m1729b(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && m1729b(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        public void layoutDecorated(@NonNull View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f7179b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f7179b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect m1686H = this.f7163b.m1686H(view);
            int i3 = m1686H.left + m1686H.right + i;
            int i4 = m1686H.top + m1686H.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (m1738j(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect m1686H = this.f7163b.m1686H(view);
            int i3 = m1686H.left + m1686H.right + i;
            int i4 = m1686H.top + m1686H.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (m1738j(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f7163b.toString());
            }
        }

        public void offsetChildrenHorizontal(@Px int i) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(@Px int i) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f7163b;
            onInitializeAccessibilityEvent(recyclerView.f7104c, recyclerView.f7117i0, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f7163b.canScrollVertically(-1) || this.f7163b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.f7163b.canScrollVertically(1) || this.f7163b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i, int i2) {
            this.f7163b.m1715n(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityAction(@NonNull Recycler recycler, @NonNull State state, int i, @Nullable Bundle bundle) {
            int i2;
            int paddingLeft;
            int i3;
            int i4;
            if (this.f7163b == null) {
                return false;
            }
            int height = getHeight();
            int width = getWidth();
            Rect rect = new Rect();
            if (this.f7163b.getMatrix().isIdentity() && this.f7163b.getGlobalVisibleRect(rect)) {
                height = rect.height();
                width = rect.width();
            }
            if (i != 4096) {
                if (i != 8192) {
                    i4 = 0;
                    i3 = 0;
                } else {
                    if (this.f7163b.canScrollVertically(-1)) {
                        i2 = -((height - getPaddingTop()) - getPaddingBottom());
                    } else {
                        i2 = 0;
                    }
                    if (this.f7163b.canScrollHorizontally(-1)) {
                        paddingLeft = -((width - getPaddingLeft()) - getPaddingRight());
                        i3 = i2;
                        i4 = paddingLeft;
                    }
                    i3 = i2;
                    i4 = 0;
                }
            } else {
                if (this.f7163b.canScrollVertically(1)) {
                    i2 = (height - getPaddingTop()) - getPaddingBottom();
                } else {
                    i2 = 0;
                }
                if (this.f7163b.canScrollHorizontally(1)) {
                    paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
                    i3 = i2;
                    i4 = paddingLeft;
                }
                i3 = i2;
                i4 = 0;
            }
            if (i3 == 0 && i4 == 0) {
                return false;
            }
            this.f7163b.m1707c0(i4, i3, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.f7162a.m1841k(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.m1672F(getChildAt(childCount)).m1768m()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, @NonNull Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.f7163b.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            C0474g c0474g = this.f7162a;
            C0501q0 c0501q0 = c0474g.f7375a;
            int i = c0474g.f7378d;
            if (i != 1) {
                if (i != 2) {
                    try {
                        c0474g.f7378d = 1;
                        c0474g.f7379e = view;
                        int indexOfChild = c0501q0.f7466a.indexOfChild(view);
                        if (indexOfChild >= 0) {
                            if (c0474g.f7376b.m8142f(indexOfChild)) {
                                c0474g.m1842l(view);
                            }
                            c0501q0.m1878a(indexOfChild);
                        }
                        c0474g.f7378d = 0;
                        c0474g.f7379e = null;
                        return;
                    } catch (Throwable th) {
                        c0474g.f7378d = 0;
                        c0474g.f7379e = null;
                        throw th;
                    }
                }
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.f7162a.m1841k(i);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x00b3, code lost:
        
            if ((r5.bottom - r10) > r2) goto L28;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            int[] iArr = {max, min2};
            int i4 = iArr[0];
            int i5 = iArr[1];
            if (z2) {
                View focusedChild = recyclerView.getFocusedChild();
                if (focusedChild != null) {
                    int paddingLeft2 = getPaddingLeft();
                    int paddingTop2 = getPaddingTop();
                    int width3 = getWidth() - getPaddingRight();
                    int height3 = getHeight() - getPaddingBottom();
                    Rect rect2 = this.f7163b.f7118j;
                    getDecoratedBoundsWithMargins(focusedChild, rect2);
                    if (rect2.left - i4 < width3) {
                        if (rect2.right - i4 > paddingLeft2) {
                            if (rect2.top - i5 < height3) {
                            }
                        }
                    }
                }
                return false;
            }
            if (i4 != 0 || i5 != 0) {
                if (z) {
                    recyclerView.scrollBy(i4, i5);
                } else {
                    recyclerView.smoothScrollBy(i4, i5);
                }
                return true;
            }
            return false;
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.f7167f = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
            if (RecyclerView.f7066D0) {
                Log.e("RecyclerView", "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.f7169h = z;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.f7171j) {
                this.f7171j = z;
                this.f7172k = 0;
                RecyclerView recyclerView = this.f7163b;
                if (recyclerView != null) {
                    recyclerView.f7104c.m1752l();
                }
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.f7170i = z;
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.f7166e;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.f7166e.stop();
            }
            this.f7166e = smoothScroller;
            RecyclerView recyclerView = this.f7163b;
            smoothScroller.getClass();
            RunnableC0461b1 runnableC0461b1 = recyclerView.f7111f0;
            runnableC0461b1.f7328g.removeCallbacks(runnableC0461b1);
            runnableC0461b1.f7324c.abortAnimation();
            if (smoothScroller.f7202h) {
                Log.w("RecyclerView", "An instance of " + smoothScroller.getClass().getSimpleName() + " was started more than once. Each instance of" + smoothScroller.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            smoothScroller.f7196b = recyclerView;
            smoothScroller.f7197c = this;
            int i = smoothScroller.f7195a;
            if (i != -1) {
                recyclerView.f7117i0.f7210a = i;
                smoothScroller.f7199e = true;
                smoothScroller.f7198d = true;
                smoothScroller.f7200f = smoothScroller.findViewByPosition(smoothScroller.getTargetPosition());
                smoothScroller.onStart();
                smoothScroller.f7196b.f7111f0.m1821b();
                smoothScroller.f7202h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void stopIgnoringView(@NonNull View view) {
            ViewHolder m1672F = RecyclerView.m1672F(view);
            m1672F.f7236i &= -129;
            m1672F.m1767l();
            m1672F.m1756a(4);
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i) {
            m1730a(i, view, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i) {
            m1730a(i, view, false);
        }

        @SuppressLint({"UnknownNullness"})
        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f7163b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f7163b.canScrollVertically(-1) && !this.f7163b.canScrollHorizontally(-1) && !this.f7163b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            Adapter adapter = this.f7163b.f7124m;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 != Integer.MIN_VALUE) {
                            if (i2 != 0) {
                            }
                        }
                        i4 = max;
                    }
                    i2 = 0;
                    i4 = 0;
                }
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 != -1) {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i4 = max;
                                i2 = Integer.MIN_VALUE;
                            } else {
                                i4 = max;
                                i2 = 0;
                            }
                        }
                        i2 = 0;
                        i4 = 0;
                    }
                    i4 = max;
                }
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.f7163b.setMeasuredDimension(i, i2);
        }

        public void attachView(@NonNull View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {

        /* renamed from: a */
        public final SparseArray f7182a = new SparseArray();

        /* renamed from: b */
        public int f7183b = 0;

        /* renamed from: c */
        public final Set f7184c = Collections.newSetFromMap(new IdentityHashMap());

        /* renamed from: a */
        public final C0515x0 m1740a(int i) {
            SparseArray sparseArray = this.f7182a;
            C0515x0 c0515x0 = (C0515x0) sparseArray.get(i);
            if (c0515x0 == null) {
                C0515x0 c0515x02 = new C0515x0();
                sparseArray.put(i, c0515x02);
                return c0515x02;
            }
            return c0515x0;
        }

        public void clear() {
            int i = 0;
            while (true) {
                SparseArray sparseArray = this.f7182a;
                if (i < sparseArray.size()) {
                    C0515x0 c0515x0 = (C0515x0) sparseArray.valueAt(i);
                    Iterator it = c0515x0.f7518a.iterator();
                    while (it.hasNext()) {
                        PoolingContainer.callPoolingContainerOnRelease(((ViewHolder) it.next()).itemView);
                    }
                    c0515x0.f7518a.clear();
                    i++;
                } else {
                    return;
                }
            }
        }

        @Nullable
        public ViewHolder getRecycledView(int i) {
            C0515x0 c0515x0 = (C0515x0) this.f7182a.get(i);
            if (c0515x0 != null) {
                ArrayList arrayList = c0515x0.f7518a;
                if (!arrayList.isEmpty()) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if (!((ViewHolder) arrayList.get(size)).m1759d()) {
                            return (ViewHolder) arrayList.remove(size);
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }

        public int getRecycledViewCount(int i) {
            return m1740a(i).f7518a.size();
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList arrayList = m1740a(itemViewType).f7518a;
            if (((C0515x0) this.f7182a.get(itemViewType)).f7519b <= arrayList.size()) {
                PoolingContainer.callPoolingContainerOnRelease(viewHolder.itemView);
            } else {
                if (RecyclerView.f7065C0 && arrayList.contains(viewHolder)) {
                    throw new IllegalArgumentException("this scrap item already exists");
                }
                viewHolder.m1767l();
                arrayList.add(viewHolder);
            }
        }

        public void setMaxRecycledViews(int i, int i2) {
            C0515x0 m1740a = m1740a(i);
            m1740a.f7519b = i2;
            ArrayList arrayList = m1740a.f7518a;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {

        /* renamed from: a */
        public final ArrayList f7185a;

        /* renamed from: b */
        public ArrayList f7186b;

        /* renamed from: c */
        public final ArrayList f7187c;

        /* renamed from: d */
        public final List f7188d;

        /* renamed from: e */
        public int f7189e;

        /* renamed from: f */
        public int f7190f;

        /* renamed from: g */
        public RecycledViewPool f7191g;

        /* renamed from: h */
        public ViewCacheExtension f7192h;

        public Recycler() {
            ArrayList arrayList = new ArrayList();
            this.f7185a = arrayList;
            this.f7186b = null;
            this.f7187c = new ArrayList();
            this.f7188d = Collections.unmodifiableList(arrayList);
            this.f7189e = 2;
            this.f7190f = 2;
        }

        /* renamed from: a */
        public final void m1741a(ViewHolder viewHolder, boolean z) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.m1680i(viewHolder);
            View view = viewHolder.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = recyclerView.f7131p0;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = (AccessibilityDelegateCompat) ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).f7249e.remove(view);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            }
            if (z) {
                RecyclerListener recyclerListener = recyclerView.f7128o;
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled(viewHolder);
                }
                ArrayList arrayList = recyclerView.f7130p;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((RecyclerListener) arrayList.get(i)).onViewRecycled(viewHolder);
                }
                Adapter adapter = recyclerView.f7124m;
                if (adapter != null) {
                    adapter.onViewRecycled(viewHolder);
                }
                if (recyclerView.f7117i0 != null) {
                    recyclerView.f7112g.m1877d(viewHolder);
                }
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "dispatchViewRecycled: " + viewHolder);
                }
            }
            viewHolder.f7245r = null;
            viewHolder.f7244q = null;
            m1742b().putRecycledView(viewHolder);
        }

        /* renamed from: b */
        public final RecycledViewPool m1742b() {
            if (this.f7191g == null) {
                this.f7191g = new RecycledViewPool();
                m1743c();
            }
            return this.f7191g;
        }

        public void bindViewToPosition(@NonNull View view, int i) {
            LayoutParams layoutParams;
            ViewHolder m1672F = RecyclerView.m1672F(view);
            RecyclerView recyclerView = RecyclerView.this;
            if (m1672F != null) {
                boolean z = false;
                int m1813f = recyclerView.f7108e.m1813f(i, 0);
                if (m1813f >= 0 && m1813f < recyclerView.f7124m.getItemCount()) {
                    m1749i(m1672F, m1813f, i, Long.MAX_VALUE);
                    ViewGroup.LayoutParams layoutParams2 = m1672F.itemView.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams = (LayoutParams) recyclerView.generateDefaultLayoutParams();
                        m1672F.itemView.setLayoutParams(layoutParams);
                    } else if (!recyclerView.checkLayoutParams(layoutParams2)) {
                        layoutParams = (LayoutParams) recyclerView.generateLayoutParams(layoutParams2);
                        m1672F.itemView.setLayoutParams(layoutParams);
                    } else {
                        layoutParams = (LayoutParams) layoutParams2;
                    }
                    layoutParams.f7180c = true;
                    layoutParams.f7178a = m1672F;
                    if (m1672F.itemView.getParent() == null) {
                        z = true;
                    }
                    layoutParams.f7181d = z;
                    return;
                }
                StringBuilder m8302v = ye0.m8302v("Inconsistency detected. Invalid item position ", i, "(offset:", m1813f, ").state:");
                m8302v.append(recyclerView.f7117i0.getItemCount());
                m8302v.append(recyclerView.m1725x());
                throw new IndexOutOfBoundsException(m8302v.toString());
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, new StringBuilder("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter")));
        }

        /* renamed from: c */
        public final void m1743c() {
            if (this.f7191g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f7124m != null && recyclerView.isAttachedToWindow()) {
                    RecycledViewPool recycledViewPool = this.f7191g;
                    recycledViewPool.f7184c.add(recyclerView.f7124m);
                }
            }
        }

        public void clear() {
            this.f7185a.clear();
            m1745e();
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i >= 0 && i < recyclerView.f7117i0.getItemCount()) {
                if (!recyclerView.f7117i0.isPreLayout()) {
                    return i;
                }
                return recyclerView.f7108e.m1813f(i, 0);
            }
            StringBuilder m8299s = ye0.m8299s(i, "invalid position ", ". State item count is ");
            m8299s.append(recyclerView.f7117i0.getItemCount());
            m8299s.append(recyclerView.m1725x());
            throw new IndexOutOfBoundsException(m8299s.toString());
        }

        /* renamed from: d */
        public final void m1744d(Adapter adapter, boolean z) {
            RecycledViewPool recycledViewPool = this.f7191g;
            if (recycledViewPool != null) {
                Set set = recycledViewPool.f7184c;
                set.remove(adapter);
                if (set.size() == 0 && !z) {
                    int i = 0;
                    while (true) {
                        SparseArray sparseArray = recycledViewPool.f7182a;
                        if (i < sparseArray.size()) {
                            ArrayList arrayList = ((C0515x0) sparseArray.get(sparseArray.keyAt(i))).f7518a;
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                PoolingContainer.callPoolingContainerOnRelease(((ViewHolder) arrayList.get(i2)).itemView);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        /* renamed from: e */
        public final void m1745e() {
            ArrayList arrayList = this.f7187c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                m1746f(size);
            }
            arrayList.clear();
            if (RecyclerView.f7071I0) {
                C0506t c0506t = RecyclerView.this.f7115h0;
                int[] iArr = c0506t.f7502c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                c0506t.f7503d = 0;
            }
        }

        /* renamed from: f */
        public final void m1746f(int i) {
            if (RecyclerView.f7066D0) {
                Log.d("RecyclerView", "Recycling cached view at index " + i);
            }
            ArrayList arrayList = this.f7187c;
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i);
            if (RecyclerView.f7066D0) {
                Log.d("RecyclerView", "CachedViewHolder to be recycled: " + viewHolder);
            }
            m1741a(viewHolder, true);
            arrayList.remove(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:73:0x00e1, code lost:
        
            r4 = r4 - 1;
         */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void m1747g(ViewHolder viewHolder) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean m1763h = viewHolder.m1763h();
            boolean z4 = false;
            boolean z5 = true;
            RecyclerView recyclerView = RecyclerView.this;
            if (!m1763h && viewHolder.itemView.getParent() == null) {
                if (!viewHolder.m1764i()) {
                    if (!viewHolder.m1768m()) {
                        if ((viewHolder.f7236i & 16) == 0 && ViewCompat.hasTransientState(viewHolder.itemView)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Adapter adapter = recyclerView.f7124m;
                        if (adapter != null && z && adapter.onFailedToRecycleView(viewHolder)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        boolean z6 = RecyclerView.f7065C0;
                        ArrayList arrayList = this.f7187c;
                        if (z6 && arrayList.contains(viewHolder)) {
                            StringBuilder sb = new StringBuilder("cached view received recycle internal? ");
                            sb.append(viewHolder);
                            throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, sb));
                        }
                        if (!z2 && !viewHolder.isRecyclable()) {
                            if (RecyclerView.f7066D0) {
                                Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + recyclerView.m1725x());
                            }
                            z5 = false;
                        } else {
                            if (this.f7190f > 0 && !viewHolder.m1758c(526)) {
                                int size = arrayList.size();
                                if (size >= this.f7190f && size > 0) {
                                    m1746f(0);
                                    size--;
                                }
                                if (RecyclerView.f7071I0 && size > 0) {
                                    C0506t c0506t = recyclerView.f7115h0;
                                    int i = viewHolder.f7229b;
                                    if (c0506t.f7502c != null) {
                                        int i2 = c0506t.f7503d * 2;
                                        for (int i3 = 0; i3 < i2; i3 += 2) {
                                            if (c0506t.f7502c[i3] == i) {
                                                break;
                                            }
                                        }
                                    }
                                    int i4 = size - 1;
                                    loop1: while (i4 >= 0) {
                                        int i5 = ((ViewHolder) arrayList.get(i4)).f7229b;
                                        C0506t c0506t2 = recyclerView.f7115h0;
                                        if (c0506t2.f7502c == null) {
                                            break;
                                        }
                                        int i6 = c0506t2.f7503d * 2;
                                        for (int i7 = 0; i7 < i6; i7 += 2) {
                                            if (c0506t2.f7502c[i7] == i5) {
                                                break;
                                            }
                                        }
                                        break loop1;
                                    }
                                    size = i4 + 1;
                                }
                                arrayList.add(size, viewHolder);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                m1741a(viewHolder, true);
                            } else {
                                z5 = false;
                            }
                            z4 = z3;
                        }
                        recyclerView.f7112g.m1877d(viewHolder);
                        if (!z4 && !z5 && z) {
                            PoolingContainer.callPoolingContainerOnRelease(viewHolder.itemView);
                            viewHolder.f7245r = null;
                            viewHolder.f7244q = null;
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
                }
                StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(viewHolder);
                throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, sb2));
            }
            StringBuilder sb3 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb3.append(viewHolder.m1763h());
            sb3.append(" isAttached:");
            if (viewHolder.itemView.getParent() != null) {
                z4 = true;
            }
            sb3.append(z4);
            sb3.append(recyclerView.m1725x());
            throw new IllegalArgumentException(sb3.toString());
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.f7188d;
        }

        @NonNull
        public View getViewForPosition(int i) {
            return m1750j(i, Long.MAX_VALUE).itemView;
        }

        /* renamed from: h */
        public final void m1748h(View view) {
            ItemAnimator itemAnimator;
            ViewHolder m1672F = RecyclerView.m1672F(view);
            boolean m1758c = m1672F.m1758c(12);
            RecyclerView recyclerView = RecyclerView.this;
            if (!m1758c && m1672F.m1765j() && (itemAnimator = recyclerView.f7090N) != null && !itemAnimator.canReuseUpdatedViewHolder(m1672F, m1672F.m1757b())) {
                if (this.f7186b == null) {
                    this.f7186b = new ArrayList();
                }
                m1672F.f7240m = this;
                m1672F.f7241n = true;
                this.f7186b.add(m1672F);
                return;
            }
            if (m1672F.m1761f() && !m1672F.m1762g() && !recyclerView.f7124m.hasStableIds()) {
                throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
            m1672F.f7240m = this;
            m1672F.f7241n = false;
            this.f7185a.add(m1672F);
        }

        /* renamed from: i */
        public final boolean m1749i(ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.f7245r = null;
            RecyclerView recyclerView = RecyclerView.this;
            viewHolder.f7244q = recyclerView;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = recyclerView.getNanoTime();
            boolean z = false;
            if (j != Long.MAX_VALUE) {
                long j2 = this.f7191g.m1740a(itemViewType).f7521d;
                if (j2 != 0 && j2 + nanoTime >= j) {
                    return false;
                }
            }
            if (viewHolder.m1764i()) {
                recyclerView.attachViewToParent(viewHolder.itemView, recyclerView.getChildCount(), viewHolder.itemView.getLayoutParams());
                z = true;
            }
            recyclerView.f7124m.bindViewHolder(viewHolder, i);
            if (z) {
                recyclerView.detachViewFromParent(viewHolder.itemView);
            }
            long nanoTime2 = recyclerView.getNanoTime() - nanoTime;
            C0515x0 m1740a = this.f7191g.m1740a(viewHolder.getItemViewType());
            long j3 = m1740a.f7521d;
            if (j3 != 0) {
                nanoTime2 = (nanoTime2 / 4) + ((j3 / 4) * 3);
            }
            m1740a.f7521d = nanoTime2;
            AccessibilityManager accessibilityManager = recyclerView.f7079C;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = recyclerView.f7131p0;
                if (recyclerViewAccessibilityDelegate != null) {
                    AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                    if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                        RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate2 = (RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate;
                        itemDelegate2.getClass();
                        AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view);
                        if (accessibilityDelegate != null && accessibilityDelegate != itemDelegate2) {
                            itemDelegate2.f7249e.put(view, accessibilityDelegate);
                        }
                    }
                    ViewCompat.setAccessibilityDelegate(view, itemDelegate);
                }
            }
            if (recyclerView.f7117i0.isPreLayout()) {
                viewHolder.f7233f = i2;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:233:0x0457, code lost:
        
            if (r10.m1761f() == false) goto L244;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:215:0x0496  */
        /* JADX WARN: Removed duplicated region for block: B:222:0x04a2  */
        /* JADX WARN: Removed duplicated region for block: B:266:0x0089  */
        /* renamed from: j */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ViewHolder m1750j(int i, long j) {
            boolean z;
            ViewHolder viewHolder;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean m1749i;
            boolean z5;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            RecyclerView m1671B;
            boolean z6;
            ViewCacheExtension viewCacheExtension;
            View viewForPositionAndType;
            View view;
            boolean z7;
            int size;
            int m1813f;
            RecyclerView recyclerView = RecyclerView.this;
            if (i >= 0 && i < recyclerView.f7117i0.getItemCount()) {
                State state = recyclerView.f7117i0;
                int i2 = 32;
                if (state.isPreLayout()) {
                    ArrayList arrayList = this.f7186b;
                    if (arrayList != null && (size = arrayList.size()) != 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                viewHolder = (ViewHolder) this.f7186b.get(i3);
                                if (!viewHolder.m1769n() && viewHolder.getLayoutPosition() == i) {
                                    viewHolder.m1756a(32);
                                    break;
                                }
                                i3++;
                            } else if (recyclerView.f7124m.hasStableIds() && (m1813f = recyclerView.f7108e.m1813f(i, 0)) > 0 && m1813f < recyclerView.f7124m.getItemCount()) {
                                long itemId = recyclerView.f7124m.getItemId(m1813f);
                                for (int i4 = 0; i4 < size; i4++) {
                                    ViewHolder viewHolder2 = (ViewHolder) this.f7186b.get(i4);
                                    if (!viewHolder2.m1769n() && viewHolder2.getItemId() == itemId) {
                                        viewHolder2.m1756a(32);
                                        viewHolder = viewHolder2;
                                        break;
                                    }
                                }
                            }
                        }
                        if (viewHolder == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    viewHolder = null;
                    if (viewHolder == null) {
                    }
                } else {
                    z = false;
                    viewHolder = null;
                }
                ArrayList arrayList2 = this.f7187c;
                ArrayList arrayList3 = this.f7185a;
                if (viewHolder == null) {
                    int size2 = arrayList3.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        ViewHolder viewHolder3 = (ViewHolder) arrayList3.get(i5);
                        if (!viewHolder3.m1769n() && viewHolder3.getLayoutPosition() == i && !viewHolder3.m1761f() && (state.f7217h || !viewHolder3.m1762g())) {
                            viewHolder3.m1756a(32);
                            viewHolder = viewHolder3;
                            break;
                        }
                    }
                    ArrayList arrayList4 = recyclerView.f7110f.f7377c;
                    int size3 = arrayList4.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 < size3) {
                            view = (View) arrayList4.get(i6);
                            ViewHolder m1672F = RecyclerView.m1672F(view);
                            if (m1672F.getLayoutPosition() == i && !m1672F.m1761f() && !m1672F.m1762g()) {
                                break;
                            }
                            i6++;
                        } else {
                            view = null;
                            break;
                        }
                    }
                    if (view != null) {
                        ViewHolder m1672F2 = RecyclerView.m1672F(view);
                        C0474g c0474g = recyclerView.f7110f;
                        int indexOfChild = c0474g.f7375a.f7466a.indexOfChild(view);
                        if (indexOfChild >= 0) {
                            C1972x6 c1972x6 = c0474g.f7376b;
                            if (c1972x6.m8140d(indexOfChild)) {
                                c1972x6.m8137a(indexOfChild);
                                c0474g.m1842l(view);
                                int m1840j = recyclerView.f7110f.m1840j(view);
                                if (m1840j != -1) {
                                    recyclerView.f7110f.m1833c(m1840j);
                                    m1748h(view);
                                    m1672F2.m1756a(8224);
                                    viewHolder = m1672F2;
                                } else {
                                    StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                                    sb.append(m1672F2);
                                    throw new IllegalStateException(AbstractC1726qj.m7056l(recyclerView, sb));
                                }
                            } else {
                                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                            }
                        } else {
                            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                        }
                    } else {
                        int size4 = arrayList2.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 < size4) {
                                ViewHolder viewHolder4 = (ViewHolder) arrayList2.get(i7);
                                if (!viewHolder4.m1761f() && viewHolder4.getLayoutPosition() == i && !viewHolder4.m1759d()) {
                                    arrayList2.remove(i7);
                                    if (RecyclerView.f7066D0) {
                                        Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i + ") found match in cache: " + viewHolder4);
                                    }
                                    viewHolder = viewHolder4;
                                } else {
                                    i7++;
                                }
                            } else {
                                viewHolder = null;
                                break;
                            }
                        }
                    }
                    if (viewHolder != null) {
                        if (viewHolder.m1762g()) {
                            if (RecyclerView.f7065C0 && !state.isPreLayout()) {
                                throw new IllegalStateException(AbstractC1726qj.m7056l(recyclerView, new StringBuilder("should not receive a removed view unless it is pre layout")));
                            }
                            z7 = state.isPreLayout();
                        } else {
                            int i8 = viewHolder.f7229b;
                            if (i8 >= 0 && i8 < recyclerView.f7124m.getItemCount()) {
                                if ((!state.isPreLayout() && recyclerView.f7124m.getItemViewType(viewHolder.f7229b) != viewHolder.getItemViewType()) || (recyclerView.f7124m.hasStableIds() && viewHolder.getItemId() != recyclerView.f7124m.getItemId(viewHolder.f7229b))) {
                                    z7 = false;
                                } else {
                                    z7 = true;
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
                                sb2.append(viewHolder);
                                throw new IndexOutOfBoundsException(AbstractC1726qj.m7056l(recyclerView, sb2));
                            }
                        }
                        if (!z7) {
                            viewHolder.m1756a(4);
                            if (viewHolder.m1763h()) {
                                recyclerView.removeDetachedView(viewHolder.itemView, false);
                                viewHolder.f7240m.m1751k(viewHolder);
                            } else if (viewHolder.m1769n()) {
                                viewHolder.f7236i &= -33;
                            }
                            m1747g(viewHolder);
                            viewHolder = null;
                        } else {
                            z = true;
                        }
                    }
                }
                if (viewHolder == null) {
                    int m1813f2 = recyclerView.f7108e.m1813f(i, 0);
                    if (m1813f2 >= 0 && m1813f2 < recyclerView.f7124m.getItemCount()) {
                        int itemViewType = recyclerView.f7124m.getItemViewType(m1813f2);
                        if (recyclerView.f7124m.hasStableIds()) {
                            long itemId2 = recyclerView.f7124m.getItemId(m1813f2);
                            int size5 = arrayList3.size() - 1;
                            while (true) {
                                if (size5 >= 0) {
                                    ViewHolder viewHolder5 = (ViewHolder) arrayList3.get(size5);
                                    if (viewHolder5.getItemId() == itemId2 && !viewHolder5.m1769n()) {
                                        if (itemViewType == viewHolder5.getItemViewType()) {
                                            viewHolder5.m1756a(i2);
                                            if (viewHolder5.m1762g() && !state.isPreLayout()) {
                                                viewHolder5.f7236i = (viewHolder5.f7236i & (-15)) | 2;
                                            }
                                            viewHolder = viewHolder5;
                                            z2 = true;
                                        } else {
                                            arrayList3.remove(size5);
                                            recyclerView.removeDetachedView(viewHolder5.itemView, false);
                                            ViewHolder m1672F3 = RecyclerView.m1672F(viewHolder5.itemView);
                                            m1672F3.f7240m = null;
                                            m1672F3.f7241n = false;
                                            m1672F3.f7236i &= -33;
                                            m1747g(m1672F3);
                                        }
                                    }
                                    size5--;
                                    i2 = 32;
                                } else {
                                    z2 = true;
                                    int size6 = arrayList2.size() - 1;
                                    while (true) {
                                        if (size6 < 0) {
                                            break;
                                        }
                                        ViewHolder viewHolder6 = (ViewHolder) arrayList2.get(size6);
                                        if (viewHolder6.getItemId() != itemId2 || viewHolder6.m1759d()) {
                                            size6--;
                                        } else if (itemViewType == viewHolder6.getItemViewType()) {
                                            arrayList2.remove(size6);
                                            viewHolder = viewHolder6;
                                        } else {
                                            m1746f(size6);
                                        }
                                    }
                                    viewHolder = null;
                                }
                            }
                            if (viewHolder != null) {
                                viewHolder.f7229b = m1813f2;
                                z = z2;
                            }
                        } else {
                            z2 = true;
                        }
                        if (viewHolder == null && (viewCacheExtension = this.f7192h) != null && (viewForPositionAndType = viewCacheExtension.getViewForPositionAndType(this, i, itemViewType)) != null) {
                            viewHolder = recyclerView.getChildViewHolder(viewForPositionAndType);
                            if (viewHolder != null) {
                                if (viewHolder.m1768m()) {
                                    throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, new StringBuilder("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.")));
                                }
                            } else {
                                throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, new StringBuilder("getViewForPositionAndType returned a view which does not have a ViewHolder")));
                            }
                        }
                        if (viewHolder == null) {
                            if (RecyclerView.f7066D0) {
                                Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + i + ") fetching from shared pool");
                            }
                            ViewHolder recycledView = m1742b().getRecycledView(itemViewType);
                            if (recycledView != null) {
                                recycledView.m1767l();
                            }
                            viewHolder = recycledView;
                        }
                        if (viewHolder == null) {
                            long nanoTime = recyclerView.getNanoTime();
                            if (j != Long.MAX_VALUE) {
                                long j2 = this.f7191g.m1740a(itemViewType).f7520c;
                                if (j2 != 0 && j2 + nanoTime >= j) {
                                    z6 = false;
                                } else {
                                    z6 = z2;
                                }
                                if (!z6) {
                                    return null;
                                }
                            }
                            ViewHolder createViewHolder = recyclerView.f7124m.createViewHolder(recyclerView, itemViewType);
                            if (RecyclerView.f7071I0 && (m1671B = RecyclerView.m1671B(createViewHolder.itemView)) != null) {
                                createViewHolder.f7228a = new WeakReference(m1671B);
                            }
                            long nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                            C0515x0 m1740a = this.f7191g.m1740a(itemViewType);
                            boolean z8 = z;
                            long j3 = m1740a.f7520c;
                            if (j3 != 0) {
                                nanoTime2 = (nanoTime2 / 4) + ((j3 / 4) * 3);
                            }
                            m1740a.f7520c = nanoTime2;
                            if (RecyclerView.f7066D0) {
                                Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                            }
                            z3 = z8;
                            viewHolder = createViewHolder;
                        } else {
                            z3 = z;
                        }
                    } else {
                        StringBuilder m8302v = ye0.m8302v("Inconsistency detected. Invalid item position ", i, "(offset:", m1813f2, ").state:");
                        m8302v.append(state.getItemCount());
                        m8302v.append(recyclerView.m1725x());
                        throw new IndexOutOfBoundsException(m8302v.toString());
                    }
                } else {
                    z2 = true;
                    z3 = z;
                }
                if (z3 && !state.isPreLayout() && viewHolder.m1758c(8192)) {
                    viewHolder.f7236i &= -8193;
                    if (state.f7220k) {
                        recyclerView.m1698T(viewHolder, recyclerView.f7090N.recordPreLayoutInformation(state, viewHolder, ItemAnimator.m1728a(viewHolder) | 4096, viewHolder.m1757b()));
                    }
                }
                if (state.isPreLayout() && viewHolder.m1760e()) {
                    viewHolder.f7233f = i;
                } else {
                    if (viewHolder.m1760e()) {
                        if ((viewHolder.f7236i & 2) != 0) {
                            z5 = z2;
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                        }
                    }
                    if (RecyclerView.f7065C0 && viewHolder.m1762g()) {
                        StringBuilder sb3 = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
                        sb3.append(viewHolder);
                        throw new IllegalStateException(AbstractC1726qj.m7056l(recyclerView, sb3));
                    }
                    z4 = false;
                    m1749i = m1749i(viewHolder, recyclerView.f7108e.m1813f(i, 0), i, j);
                    layoutParams = viewHolder.itemView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams2 = (LayoutParams) recyclerView.generateDefaultLayoutParams();
                        viewHolder.itemView.setLayoutParams(layoutParams2);
                    } else if (!recyclerView.checkLayoutParams(layoutParams)) {
                        layoutParams2 = (LayoutParams) recyclerView.generateLayoutParams(layoutParams);
                        viewHolder.itemView.setLayoutParams(layoutParams2);
                    } else {
                        layoutParams2 = (LayoutParams) layoutParams;
                    }
                    layoutParams2.f7178a = viewHolder;
                    if (z3 || !m1749i) {
                        z2 = z4;
                    }
                    layoutParams2.f7181d = z2;
                    return viewHolder;
                }
                m1749i = false;
                z4 = false;
                layoutParams = viewHolder.itemView.getLayoutParams();
                if (layoutParams != null) {
                }
                layoutParams2.f7178a = viewHolder;
                if (z3) {
                }
                z2 = z4;
                layoutParams2.f7181d = z2;
                return viewHolder;
            }
            StringBuilder m8302v2 = ye0.m8302v("Invalid item position ", i, "(", i, "). Item count:");
            m8302v2.append(recyclerView.f7117i0.getItemCount());
            m8302v2.append(recyclerView.m1725x());
            throw new IndexOutOfBoundsException(m8302v2.toString());
        }

        /* renamed from: k */
        public final void m1751k(ViewHolder viewHolder) {
            if (viewHolder.f7241n) {
                this.f7186b.remove(viewHolder);
            } else {
                this.f7185a.remove(viewHolder);
            }
            viewHolder.f7240m = null;
            viewHolder.f7241n = false;
            viewHolder.f7236i &= -33;
        }

        /* renamed from: l */
        public final void m1752l() {
            int i;
            LayoutManager layoutManager = RecyclerView.this.f7126n;
            if (layoutManager != null) {
                i = layoutManager.f7172k;
            } else {
                i = 0;
            }
            this.f7190f = this.f7189e + i;
            ArrayList arrayList = this.f7187c;
            for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f7190f; size--) {
                m1746f(size);
            }
        }

        public void recycleView(@NonNull View view) {
            ViewHolder m1672F = RecyclerView.m1672F(view);
            boolean m1764i = m1672F.m1764i();
            RecyclerView recyclerView = RecyclerView.this;
            if (m1764i) {
                recyclerView.removeDetachedView(view, false);
            }
            if (m1672F.m1763h()) {
                m1672F.f7240m.m1751k(m1672F);
            } else if (m1672F.m1769n()) {
                m1672F.f7236i &= -33;
            }
            m1747g(m1672F);
            if (recyclerView.f7090N != null && !m1672F.isRecyclable()) {
                recyclerView.f7090N.endAnimation(m1672F);
            }
        }

        public void setViewCacheSize(int i) {
            this.f7189e = i;
            m1752l();
        }
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: b */
        public Parcelable f7194b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7194b = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f7194b, 0);
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {

        /* renamed from: b */
        public RecyclerView f7196b;

        /* renamed from: c */
        public LayoutManager f7197c;

        /* renamed from: d */
        public boolean f7198d;

        /* renamed from: e */
        public boolean f7199e;

        /* renamed from: f */
        public View f7200f;

        /* renamed from: h */
        public boolean f7202h;

        /* renamed from: a */
        public int f7195a = -1;

        /* renamed from: g */
        public final Action f7201g = new Action(0, 0);

        /* loaded from: classes.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;

            /* renamed from: a */
            public int f7203a;

            /* renamed from: b */
            public int f7204b;

            /* renamed from: c */
            public int f7205c;

            /* renamed from: d */
            public int f7206d;

            /* renamed from: e */
            public Interpolator f7207e;

            /* renamed from: f */
            public boolean f7208f;

            /* renamed from: g */
            public int f7209g;

            public Action(@Px int i, @Px int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            /* renamed from: a */
            public final void m1754a(RecyclerView recyclerView) {
                int i = this.f7206d;
                if (i >= 0) {
                    this.f7206d = -1;
                    recyclerView.m1688J(i);
                    this.f7208f = false;
                    return;
                }
                if (this.f7208f) {
                    Interpolator interpolator = this.f7207e;
                    if (interpolator != null && this.f7205c < 1) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    int i2 = this.f7205c;
                    if (i2 >= 1) {
                        recyclerView.f7111f0.m1822c(this.f7203a, this.f7204b, i2, interpolator);
                        int i3 = this.f7209g + 1;
                        this.f7209g = i3;
                        if (i3 > 10) {
                            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f7208f = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                this.f7209g = 0;
            }

            public int getDuration() {
                return this.f7205c;
            }

            @Px
            public int getDx() {
                return this.f7203a;
            }

            @Px
            public int getDy() {
                return this.f7204b;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.f7207e;
            }

            public void jumpTo(int i) {
                this.f7206d = i;
            }

            public void setDuration(int i) {
                this.f7208f = true;
                this.f7205c = i;
            }

            public void setDx(@Px int i) {
                this.f7208f = true;
                this.f7203a = i;
            }

            public void setDy(@Px int i) {
                this.f7208f = true;
                this.f7204b = i;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.f7208f = true;
                this.f7207e = interpolator;
            }

            public void update(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.f7203a = i;
                this.f7204b = i2;
                this.f7205c = i3;
                this.f7207e = interpolator;
                this.f7208f = true;
            }

            public Action(@Px int i, @Px int i2, int i3) {
                this(i, i2, i3, null);
            }

            public Action(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.f7206d = -1;
                this.f7208f = false;
                this.f7209g = 0;
                this.f7203a = i;
                this.f7204b = i2;
                this.f7205c = i3;
                this.f7207e = interpolator;
            }
        }

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i);
        }

        /* renamed from: a */
        public final void m1753a(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.f7196b;
            if (this.f7195a == -1 || recyclerView == null) {
                stop();
            }
            if (this.f7198d && this.f7200f == null && this.f7197c != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.f7195a)) != null) {
                float f = computeScrollVectorForPosition.x;
                if (f != RecyclerView.f7068F0 || computeScrollVectorForPosition.y != RecyclerView.f7068F0) {
                    recyclerView.m1704Z((int) Math.signum(f), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
            }
            boolean z = false;
            this.f7198d = false;
            View view = this.f7200f;
            Action action = this.f7201g;
            if (view != null) {
                if (getChildPosition(view) == this.f7195a) {
                    onTargetFound(this.f7200f, recyclerView.f7117i0, action);
                    action.m1754a(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f7200f = null;
                }
            }
            if (this.f7199e) {
                onSeekTargetStep(i, i2, recyclerView.f7117i0, action);
                if (action.f7206d >= 0) {
                    z = true;
                }
                action.m1754a(recyclerView);
                if (z && this.f7199e) {
                    this.f7198d = true;
                    recyclerView.f7111f0.m1821b();
                }
            }
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.f7196b.f7126n.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.f7196b.f7126n.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.f7196b.getChildLayoutPosition(view);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.f7197c;
        }

        public int getTargetPosition() {
            return this.f7195a;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.f7196b.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.f7198d;
        }

        public boolean isRunning() {
            return this.f7199e;
        }

        public void normalize(@NonNull PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.f7200f = view;
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "smooth scroll target view has been attached");
                }
            }
        }

        public abstract void onSeekTargetStep(@Px int i, @Px int i2, @NonNull State state, @NonNull Action action);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void setTargetPosition(int i) {
            this.f7195a = i;
        }

        public final void stop() {
            if (!this.f7199e) {
                return;
            }
            this.f7199e = false;
            onStop();
            this.f7196b.f7117i0.f7210a = -1;
            this.f7200f = null;
            this.f7195a = -1;
            this.f7198d = false;
            LayoutManager layoutManager = this.f7197c;
            if (layoutManager.f7166e == this) {
                layoutManager.f7166e = null;
            }
            this.f7197c = null;
            this.f7196b = null;
        }
    }

    /* loaded from: classes.dex */
    public static class State {

        /* renamed from: b */
        public SparseArray f7211b;

        /* renamed from: m */
        public int f7222m;

        /* renamed from: n */
        public long f7223n;

        /* renamed from: o */
        public int f7224o;

        /* renamed from: p */
        public int f7225p;

        /* renamed from: q */
        public int f7226q;

        /* renamed from: a */
        public int f7210a = -1;

        /* renamed from: c */
        public int f7212c = 0;

        /* renamed from: d */
        public int f7213d = 0;

        /* renamed from: e */
        public int f7214e = 1;

        /* renamed from: f */
        public int f7215f = 0;

        /* renamed from: g */
        public boolean f7216g = false;

        /* renamed from: h */
        public boolean f7217h = false;

        /* renamed from: i */
        public boolean f7218i = false;

        /* renamed from: j */
        public boolean f7219j = false;

        /* renamed from: k */
        public boolean f7220k = false;

        /* renamed from: l */
        public boolean f7221l = false;

        /* renamed from: a */
        public final void m1755a(int i) {
            if ((this.f7214e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f7214e));
        }

        public boolean didStructureChange() {
            return this.f7216g;
        }

        public <T> T get(int i) {
            SparseArray sparseArray = this.f7211b;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i);
        }

        public int getItemCount() {
            if (this.f7217h) {
                return this.f7212c - this.f7213d;
            }
            return this.f7215f;
        }

        public int getRemainingScrollHorizontal() {
            return this.f7225p;
        }

        public int getRemainingScrollVertical() {
            return this.f7226q;
        }

        public int getTargetScrollPosition() {
            return this.f7210a;
        }

        public boolean hasTargetScrollPosition() {
            if (this.f7210a != -1) {
                return true;
            }
            return false;
        }

        public boolean isMeasuring() {
            return this.f7219j;
        }

        public boolean isPreLayout() {
            return this.f7217h;
        }

        public void put(int i, Object obj) {
            if (this.f7211b == null) {
                this.f7211b = new SparseArray();
            }
            this.f7211b.put(i, obj);
        }

        public void remove(int i) {
            SparseArray sparseArray = this.f7211b;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i);
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f7210a + ", mData=" + this.f7211b + ", mItemCount=" + this.f7215f + ", mIsMeasuring=" + this.f7219j + ", mPreviousLayoutItemCount=" + this.f7212c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f7213d + ", mStructureChanged=" + this.f7216g + ", mInPreLayout=" + this.f7217h + ", mRunSimpleAnimations=" + this.f7220k + ", mRunPredictiveAnimations=" + this.f7221l + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.f7221l;
        }

        public boolean willRunSimpleAnimations() {
            return this.f7220k;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i, int i2);
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {

        /* renamed from: s */
        public static final List f7227s = Collections.emptyList();

        /* renamed from: a */
        public WeakReference f7228a;

        /* renamed from: i */
        public int f7236i;

        @NonNull
        public final View itemView;

        /* renamed from: q */
        public RecyclerView f7244q;

        /* renamed from: r */
        public Adapter f7245r;

        /* renamed from: b */
        public int f7229b = -1;

        /* renamed from: c */
        public int f7230c = -1;

        /* renamed from: d */
        public long f7231d = -1;

        /* renamed from: e */
        public int f7232e = -1;

        /* renamed from: f */
        public int f7233f = -1;

        /* renamed from: g */
        public ViewHolder f7234g = null;

        /* renamed from: h */
        public ViewHolder f7235h = null;

        /* renamed from: j */
        public ArrayList f7237j = null;

        /* renamed from: k */
        public List f7238k = null;

        /* renamed from: l */
        public int f7239l = 0;

        /* renamed from: m */
        public Recycler f7240m = null;

        /* renamed from: n */
        public boolean f7241n = false;

        /* renamed from: o */
        public int f7242o = 0;

        /* renamed from: p */
        public int f7243p = -1;

        public ViewHolder(@NonNull View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* renamed from: a */
        public final void m1756a(int i) {
            this.f7236i = i | this.f7236i;
        }

        /* renamed from: b */
        public final List m1757b() {
            ArrayList arrayList;
            int i = this.f7236i & 1024;
            List list = f7227s;
            if (i == 0 && (arrayList = this.f7237j) != null && arrayList.size() != 0) {
                return this.f7238k;
            }
            return list;
        }

        /* renamed from: c */
        public final boolean m1758c(int i) {
            if ((i & this.f7236i) != 0) {
                return true;
            }
            return false;
        }

        /* renamed from: d */
        public final boolean m1759d() {
            if (this.itemView.getParent() != null && this.itemView.getParent() != this.f7244q) {
                return true;
            }
            return false;
        }

        /* renamed from: e */
        public final boolean m1760e() {
            if ((this.f7236i & 1) != 0) {
                return true;
            }
            return false;
        }

        /* renamed from: f */
        public final boolean m1761f() {
            if ((this.f7236i & 4) != 0) {
                return true;
            }
            return false;
        }

        /* renamed from: g */
        public final boolean m1762g() {
            if ((this.f7236i & 8) != 0) {
                return true;
            }
            return false;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.f7244q;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.m1684D(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.f7245r;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int m1684D;
            if (this.f7245r == null || (recyclerView = this.f7244q) == null || (adapter = recyclerView.getAdapter()) == null || (m1684D = this.f7244q.m1684D(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.f7245r, this, m1684D);
        }

        public final long getItemId() {
            return this.f7231d;
        }

        public final int getItemViewType() {
            return this.f7232e;
        }

        public final int getLayoutPosition() {
            int i = this.f7233f;
            if (i == -1) {
                return this.f7229b;
            }
            return i;
        }

        public final int getOldPosition() {
            return this.f7230c;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.f7233f;
            if (i == -1) {
                return this.f7229b;
            }
            return i;
        }

        /* renamed from: h */
        public final boolean m1763h() {
            if (this.f7240m != null) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final boolean m1764i() {
            if ((this.f7236i & 256) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.f7236i & 16) == 0 && !ViewCompat.hasTransientState(this.itemView)) {
                return true;
            }
            return false;
        }

        /* renamed from: j */
        public final boolean m1765j() {
            if ((this.f7236i & 2) != 0) {
                return true;
            }
            return false;
        }

        /* renamed from: k */
        public final void m1766k(int i, boolean z) {
            if (this.f7230c == -1) {
                this.f7230c = this.f7229b;
            }
            if (this.f7233f == -1) {
                this.f7233f = this.f7229b;
            }
            if (z) {
                this.f7233f += i;
            }
            this.f7229b += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f7180c = true;
            }
        }

        /* renamed from: l */
        public final void m1767l() {
            if (RecyclerView.f7065C0 && m1764i()) {
                throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
            }
            this.f7236i = 0;
            this.f7229b = -1;
            this.f7230c = -1;
            this.f7231d = -1L;
            this.f7233f = -1;
            this.f7239l = 0;
            this.f7234g = null;
            this.f7235h = null;
            ArrayList arrayList = this.f7237j;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.f7236i &= -1025;
            this.f7242o = 0;
            this.f7243p = -1;
            RecyclerView.m1680i(this);
        }

        /* renamed from: m */
        public final boolean m1768m() {
            if ((this.f7236i & 128) != 0) {
                return true;
            }
            return false;
        }

        /* renamed from: n */
        public final boolean m1769n() {
            if ((this.f7236i & 32) != 0) {
                return true;
            }
            return false;
        }

        public final void setIsRecyclable(boolean z) {
            int i;
            int i2 = this.f7239l;
            if (z) {
                i = i2 - 1;
            } else {
                i = i2 + 1;
            }
            this.f7239l = i;
            if (i < 0) {
                this.f7239l = 0;
                if (!RecyclerView.f7065C0) {
                    Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                } else {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
            } else if (!z && i == 1) {
                this.f7236i |= 16;
            } else if (z && i == 0) {
                this.f7236i &= -17;
            }
            if (RecyclerView.f7066D0) {
                Log.d("RecyclerView", "setIsRecyclable val:" + z + ":" + this);
            }
        }

        public String toString() {
            String simpleName;
            String str;
            if (getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            } else {
                simpleName = getClass().getSimpleName();
            }
            StringBuilder m8303w = ye0.m8303w(simpleName, "{");
            m8303w.append(Integer.toHexString(hashCode()));
            m8303w.append(" position=");
            m8303w.append(this.f7229b);
            m8303w.append(" id=");
            m8303w.append(this.f7231d);
            m8303w.append(", oldPos=");
            m8303w.append(this.f7230c);
            m8303w.append(", pLpos:");
            m8303w.append(this.f7233f);
            StringBuilder sb = new StringBuilder(m8303w.toString());
            if (m1763h()) {
                sb.append(" scrap ");
                if (this.f7241n) {
                    str = "[changeScrap]";
                } else {
                    str = "[attachedScrap]";
                }
                sb.append(str);
            }
            if (m1761f()) {
                sb.append(" invalid");
            }
            if (!m1760e()) {
                sb.append(" unbound");
            }
            if ((this.f7236i & 2) != 0) {
                sb.append(" update");
            }
            if (m1762g()) {
                sb.append(" removed");
            }
            if (m1768m()) {
                sb.append(" ignored");
            }
            if (m1764i()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.f7239l + ")");
            }
            if ((this.f7236i & 512) != 0 || m1761f()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.RecyclerView$EdgeEffectFactory, androidx.recyclerview.widget.a1] */
    static {
        Class cls = Integer.TYPE;
        f7072J0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f7073K0 = new f92(0);
        f7074L0 = new EdgeEffectFactory();
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: B */
    public static RecyclerView m1671B(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView m1671B = m1671B(viewGroup.getChildAt(i));
            if (m1671B != null) {
                return m1671B;
            }
        }
        return null;
    }

    /* renamed from: F */
    public static ViewHolder m1672F(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f7178a;
    }

    /* renamed from: G */
    public static void m1673G(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f7179b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f7137s0 == null) {
            this.f7137s0 = new NestedScrollingChildHelper(this);
        }
        return this.f7137s0;
    }

    /* renamed from: i */
    public static void m1680i(ViewHolder viewHolder) {
        WeakReference weakReference = viewHolder.f7228a;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == viewHolder.itemView) {
                    return;
                }
                Object parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                } else {
                    view = null;
                }
            }
            viewHolder.f7228a = null;
        }
    }

    /* renamed from: l */
    public static int m1681l(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && EdgeEffectCompat.getDistance(edgeEffect) != f7068F0) {
            int round = Math.round(EdgeEffectCompat.onPullDistance(edgeEffect, ((-i) * 4.0f) / i2, 0.5f) * ((-i2) / 4.0f));
            if (round != i) {
                edgeEffect.finish();
            }
            return i - round;
        }
        if (i < 0 && edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != f7068F0) {
            float f = i2;
            int round2 = Math.round(EdgeEffectCompat.onPullDistance(edgeEffect2, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
            if (round2 != i) {
                edgeEffect2.finish();
            }
            return i - round2;
        }
        return i;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        f7065C0 = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        f7066D0 = z;
    }

    /* renamed from: A */
    public final void m1682A(int[] iArr) {
        int m1835e = this.f7110f.m1835e();
        if (m1835e == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < m1835e; i3++) {
            ViewHolder m1672F = m1672F(this.f7110f.m1834d(i3));
            if (!m1672F.m1768m()) {
                int layoutPosition = m1672F.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[SYNTHETIC] */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ViewHolder m1683C(int i, boolean z) {
        C0474g c0474g;
        int m1838h = this.f7110f.m1838h();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < m1838h; i2++) {
            ViewHolder m1672F = m1672F(this.f7110f.m1837g(i2));
            if (m1672F != null && !m1672F.m1762g()) {
                if (z) {
                    if (m1672F.f7229b != i) {
                        continue;
                    }
                    c0474g = this.f7110f;
                    if (!c0474g.f7377c.contains(m1672F.itemView)) {
                        viewHolder = m1672F;
                    } else {
                        return m1672F;
                    }
                } else {
                    if (m1672F.getLayoutPosition() != i) {
                        continue;
                    }
                    c0474g = this.f7110f;
                    if (!c0474g.f7377c.contains(m1672F.itemView)) {
                    }
                }
            }
        }
        return viewHolder;
    }

    /* renamed from: D */
    public final int m1684D(ViewHolder viewHolder) {
        if (viewHolder.m1758c(524) || !viewHolder.m1760e()) {
            return -1;
        }
        C0456a c0456a = this.f7108e;
        int i = viewHolder.f7229b;
        ArrayList arrayList = c0456a.f7314b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1935w6 c1935w6 = (C1935w6) arrayList.get(i2);
            int i3 = c1935w6.f28079a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        int i4 = c1935w6.f28080b;
                        if (i4 == i) {
                            i = c1935w6.f28082d;
                        } else {
                            if (i4 < i) {
                                i--;
                            }
                            if (c1935w6.f28082d <= i) {
                                i++;
                            }
                        }
                    }
                } else {
                    int i5 = c1935w6.f28080b;
                    if (i5 <= i) {
                        int i6 = c1935w6.f28082d;
                        if (i5 + i6 > i) {
                            return -1;
                        }
                        i -= i6;
                    } else {
                        continue;
                    }
                }
            } else if (c1935w6.f28080b <= i) {
                i += c1935w6.f28082d;
            }
        }
        return i;
    }

    /* renamed from: E */
    public final long m1685E(ViewHolder viewHolder) {
        if (this.f7124m.hasStableIds()) {
            return viewHolder.getItemId();
        }
        return viewHolder.f7229b;
    }

    /* renamed from: H */
    public final Rect m1686H(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z = layoutParams.f7180c;
        Rect rect = layoutParams.f7179b;
        if (!z) {
            return rect;
        }
        State state = this.f7117i0;
        if (state.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f7132q;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = this.f7118j;
            rect2.set(0, 0, 0, 0);
            ((ItemDecoration) arrayList.get(i)).getItemOffsets(rect2, view, this, state);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f7180c = false;
        return rect;
    }

    /* renamed from: I */
    public boolean m1687I() {
        return isChildrenDrawingOrderEnabled();
    }

    /* renamed from: J */
    public final void m1688J(int i) {
        if (this.f7126n == null) {
            return;
        }
        setScrollState(2);
        this.f7126n.scrollToPosition(i);
        awakenScrollBars();
    }

    /* renamed from: K */
    public final void m1689K() {
        int m1838h = this.f7110f.m1838h();
        for (int i = 0; i < m1838h; i++) {
            ((LayoutParams) this.f7110f.m1837g(i).getLayoutParams()).f7180c = true;
        }
        ArrayList arrayList = this.f7104c.f7187c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutParams layoutParams = (LayoutParams) ((ViewHolder) arrayList.get(i2)).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f7180c = true;
            }
        }
    }

    /* renamed from: L */
    public final void m1690L(MotionEvent motionEvent, int i, int i2) {
        int i3;
        float y;
        float x;
        int i4;
        int i5;
        int i6;
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f7148y) {
            return;
        }
        int[] iArr = this.f7143v0;
        int i7 = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.f7126n.canScrollVertically();
        if (canScrollVertically) {
            i3 = (canScrollHorizontally ? 1 : 0) | 2;
        } else {
            i3 = canScrollHorizontally ? 1 : 0;
        }
        if (motionEvent == null) {
            y = getHeight() / 2.0f;
        } else {
            y = motionEvent.getY();
        }
        if (motionEvent == null) {
            x = getWidth() / 2.0f;
        } else {
            x = motionEvent.getX();
        }
        int m1699U = i - m1699U(y, i);
        int m1700V = i2 - m1700V(x, i2);
        startNestedScroll(i3, 1);
        if (canScrollHorizontally) {
            i4 = m1699U;
        } else {
            i4 = 0;
        }
        if (canScrollVertically) {
            i5 = m1700V;
        } else {
            i5 = 0;
        }
        if (dispatchNestedPreScroll(i4, i5, this.f7143v0, this.f7139t0, 1)) {
            m1699U -= iArr[0];
            m1700V -= iArr[1];
        }
        if (canScrollHorizontally) {
            i6 = m1699U;
        } else {
            i6 = 0;
        }
        if (canScrollVertically) {
            i7 = m1700V;
        }
        m1703Y(i6, i7, motionEvent, 1);
        RunnableC0508u runnableC0508u = this.f7113g0;
        if (runnableC0508u != null && (m1699U != 0 || m1700V != 0)) {
            runnableC0508u.m1898a(this, m1699U, m1700V);
        }
        stopNestedScroll(1);
    }

    /* renamed from: M */
    public final void m1691M(int i, int i2, boolean z) {
        int i3 = i + i2;
        int m1838h = this.f7110f.m1838h();
        for (int i4 = 0; i4 < m1838h; i4++) {
            ViewHolder m1672F = m1672F(this.f7110f.m1837g(i4));
            if (m1672F != null && !m1672F.m1768m()) {
                int i5 = m1672F.f7229b;
                State state = this.f7117i0;
                if (i5 >= i3) {
                    if (f7066D0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i4 + " holder " + m1672F + " now at position " + (m1672F.f7229b - i2));
                    }
                    m1672F.m1766k(-i2, z);
                    state.f7216g = true;
                } else if (i5 >= i) {
                    if (f7066D0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i4 + " holder " + m1672F + " now REMOVED");
                    }
                    m1672F.m1756a(8);
                    m1672F.m1766k(-i2, z);
                    m1672F.f7229b = i - 1;
                    state.f7216g = true;
                }
            }
        }
        Recycler recycler = this.f7104c;
        ArrayList arrayList = recycler.f7187c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
            if (viewHolder != null) {
                int i6 = viewHolder.f7229b;
                if (i6 >= i3) {
                    if (f7066D0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.f7229b - i2));
                    }
                    viewHolder.m1766k(-i2, z);
                } else if (i6 >= i) {
                    viewHolder.m1756a(8);
                    recycler.m1746f(size);
                }
            }
        }
        requestLayout();
    }

    /* renamed from: N */
    public final void m1692N() {
        this.f7083G++;
    }

    /* renamed from: O */
    public final void m1693O(boolean z) {
        int i;
        AccessibilityManager accessibilityManager;
        int i2 = this.f7083G - 1;
        this.f7083G = i2;
        if (i2 < 1) {
            if (f7065C0 && i2 < 0) {
                throw new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.f7083G = 0;
            if (z) {
                int i3 = this.f7075A;
                this.f7075A = 0;
                if (i3 != 0 && (accessibilityManager = this.f7079C) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    AccessibilityEventCompat.setContentChangeTypes(obtain, i3);
                    sendAccessibilityEventUnchecked(obtain);
                }
                ArrayList arrayList = this.f7145w0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
                    if (viewHolder.itemView.getParent() == this && !viewHolder.m1768m() && (i = viewHolder.f7243p) != -1) {
                        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                        viewHolder.f7243p = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    /* renamed from: P */
    public final void m1694P(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f7092P) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f7092P = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.f7096T = x;
            this.f7094R = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f7097U = y;
            this.f7095S = y;
        }
    }

    /* renamed from: Q */
    public final void m1695Q() {
        if (!this.f7129o0 && this.f7138t) {
            ViewCompat.postOnAnimation(this, this.f7147x0);
            this.f7129o0 = true;
        }
    }

    /* renamed from: R */
    public final void m1696R() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.f7081E) {
            C0456a c0456a = this.f7108e;
            c0456a.m1818k(c0456a.f7314b);
            c0456a.m1818k(c0456a.f7315c);
            c0456a.f7318f = 0;
            if (this.f7082F) {
                this.f7126n.onItemsChanged(this);
            }
        }
        if (this.f7090N != null && this.f7126n.supportsPredictiveItemAnimations()) {
            this.f7108e.m1817j();
        } else {
            this.f7108e.m1810c();
        }
        if (!this.f7123l0 && !this.f7125m0) {
            z = false;
        } else {
            z = true;
        }
        if (this.f7142v && this.f7090N != null && (((z3 = this.f7081E) || z || this.f7126n.f7167f) && (!z3 || this.f7124m.hasStableIds()))) {
            z2 = true;
        } else {
            z2 = false;
        }
        State state = this.f7117i0;
        state.f7220k = z2;
        if (z2 && z && !this.f7081E && this.f7090N != null && this.f7126n.supportsPredictiveItemAnimations()) {
            z4 = true;
        }
        state.f7221l = z4;
    }

    /* renamed from: S */
    public final void m1697S(boolean z) {
        this.f7082F = z | this.f7082F;
        this.f7081E = true;
        int m1838h = this.f7110f.m1838h();
        for (int i = 0; i < m1838h; i++) {
            ViewHolder m1672F = m1672F(this.f7110f.m1837g(i));
            if (m1672F != null && !m1672F.m1768m()) {
                m1672F.m1756a(6);
            }
        }
        m1689K();
        Recycler recycler = this.f7104c;
        ArrayList arrayList = recycler.f7187c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i2);
            if (viewHolder != null) {
                viewHolder.m1756a(6);
                viewHolder.m1756a(1024);
            }
        }
        Adapter adapter = RecyclerView.this.f7124m;
        if (adapter == null || !adapter.hasStableIds()) {
            recycler.m1745e();
        }
    }

    /* renamed from: T */
    public final void m1698T(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.f7236i &= -8193;
        boolean z = this.f7117i0.f7218i;
        C0488k1 c0488k1 = this.f7112g;
        if (z && viewHolder.m1765j() && !viewHolder.m1762g() && !viewHolder.m1768m()) {
            c0488k1.f7429b.put(m1685E(viewHolder), viewHolder);
        }
        SimpleArrayMap simpleArrayMap = c0488k1.f7428a;
        C0485j1 c0485j1 = (C0485j1) simpleArrayMap.get(viewHolder);
        if (c0485j1 == null) {
            c0485j1 = C0485j1.m1873a();
            simpleArrayMap.put(viewHolder, c0485j1);
        }
        c0485j1.f7416b = itemHolderInfo;
        c0485j1.f7415a |= 4;
    }

    /* renamed from: U */
    public final int m1699U(float f, int i) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.f7086J;
        float f2 = f7068F0;
        if (edgeEffect != null && EdgeEffectCompat.getDistance(edgeEffect) != f7068F0) {
            if (canScrollHorizontally(-1)) {
                this.f7086J.onRelease();
            } else {
                float f3 = -EdgeEffectCompat.onPullDistance(this.f7086J, -width, 1.0f - height);
                if (EdgeEffectCompat.getDistance(this.f7086J) == f7068F0) {
                    this.f7086J.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        } else {
            EdgeEffect edgeEffect2 = this.f7088L;
            if (edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != f7068F0) {
                if (canScrollHorizontally(1)) {
                    this.f7088L.onRelease();
                } else {
                    float onPullDistance = EdgeEffectCompat.onPullDistance(this.f7088L, width, height);
                    if (EdgeEffectCompat.getDistance(this.f7088L) == f7068F0) {
                        this.f7088L.onRelease();
                    }
                    f2 = onPullDistance;
                }
                invalidate();
            }
        }
        return Math.round(f2 * getWidth());
    }

    /* renamed from: V */
    public final int m1700V(float f, int i) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.f7087K;
        float f2 = f7068F0;
        if (edgeEffect != null && EdgeEffectCompat.getDistance(edgeEffect) != f7068F0) {
            if (canScrollVertically(-1)) {
                this.f7087K.onRelease();
            } else {
                float f3 = -EdgeEffectCompat.onPullDistance(this.f7087K, -height, width);
                if (EdgeEffectCompat.getDistance(this.f7087K) == f7068F0) {
                    this.f7087K.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        } else {
            EdgeEffect edgeEffect2 = this.f7089M;
            if (edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != f7068F0) {
                if (canScrollVertically(1)) {
                    this.f7089M.onRelease();
                } else {
                    float onPullDistance = EdgeEffectCompat.onPullDistance(this.f7089M, height, 1.0f - width);
                    if (EdgeEffectCompat.getDistance(this.f7089M) == f7068F0) {
                        this.f7089M.onRelease();
                    }
                    f2 = onPullDistance;
                }
                invalidate();
            }
        }
        return Math.round(f2 * getHeight());
    }

    /* renamed from: W */
    public final void m1701W(View view, View view2) {
        View view3;
        boolean z;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f7118j;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f7180c) {
                int i = rect.left;
                Rect rect2 = layoutParams2.f7179b;
                rect.left = i - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        LayoutManager layoutManager = this.f7126n;
        boolean z2 = !this.f7142v;
        if (view2 == null) {
            z = true;
        } else {
            z = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view, this.f7118j, z2, z);
    }

    /* renamed from: X */
    public final void m1702X() {
        VelocityTracker velocityTracker = this.f7093Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.f7086J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.f7086J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f7087K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.f7087K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f7088L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.f7088L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f7089M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.f7089M.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ed  */
    /* renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m1703Y(int i, int i2, MotionEvent motionEvent, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        m1714m();
        Adapter adapter = this.f7124m;
        int[] iArr = this.f7143v0;
        if (adapter != null) {
            iArr[0] = 0;
            iArr[1] = 0;
            m1704Z(i, i2, iArr);
            int i8 = iArr[0];
            int i9 = iArr[1];
            i5 = i8;
            i4 = i9;
            i6 = i - i8;
            i7 = i2 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.f7132q.isEmpty()) {
            invalidate();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        int i10 = i4;
        dispatchNestedScroll(i5, i4, i6, i7, this.f7139t0, i3, iArr);
        int i11 = iArr[0];
        int i12 = i6 - i11;
        int i13 = iArr[1];
        int i14 = i7 - i13;
        if (i11 == 0 && i13 == 0) {
            z = false;
        } else {
            z = true;
        }
        int i15 = this.f7096T;
        int[] iArr2 = this.f7139t0;
        int i16 = iArr2[0];
        this.f7096T = i15 - i16;
        int i17 = this.f7097U;
        int i18 = iArr2[1];
        this.f7097U = i17 - i18;
        int[] iArr3 = this.f7141u0;
        iArr3[0] = iArr3[0] + i16;
        iArr3[1] = iArr3[1] + i18;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                float x = motionEvent.getX();
                float f = i12;
                float y = motionEvent.getY();
                float f2 = i14;
                if (f < f7068F0) {
                    m1722u();
                    EdgeEffectCompat.onPullDistance(this.f7086J, (-f) / getWidth(), 1.0f - (y / getHeight()));
                } else if (f > f7068F0) {
                    m1723v();
                    EdgeEffectCompat.onPullDistance(this.f7088L, f / getWidth(), y / getHeight());
                } else {
                    z2 = false;
                    if (f2 >= f7068F0) {
                        m1724w();
                        EdgeEffectCompat.onPullDistance(this.f7087K, (-f2) / getHeight(), x / getWidth());
                    } else {
                        if (f2 > f7068F0) {
                            m1721t();
                            EdgeEffectCompat.onPullDistance(this.f7089M, f2 / getHeight(), 1.0f - (x / getWidth()));
                        }
                        if (!z2 || f != f7068F0 || f2 != f7068F0) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                z2 = true;
                if (f2 >= f7068F0) {
                }
                z2 = true;
                if (!z2) {
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
            m1713k(i, i2);
        }
        if (i5 != 0 || i10 != 0) {
            m1720s(i5, i10);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (z || i5 != 0 || i10 != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: Z */
    public final void m1704Z(int i, int i2, int[] iArr) {
        int i3;
        int i4;
        ViewHolder viewHolder;
        m1708d0();
        m1692N();
        TraceCompat.beginSection("RV Scroll");
        State state = this.f7117i0;
        m1726y(state);
        Recycler recycler = this.f7104c;
        if (i != 0) {
            i3 = this.f7126n.scrollHorizontallyBy(i, recycler, state);
        } else {
            i3 = 0;
        }
        if (i2 != 0) {
            i4 = this.f7126n.scrollVerticallyBy(i2, recycler, state);
        } else {
            i4 = 0;
        }
        TraceCompat.endSection();
        int m1835e = this.f7110f.m1835e();
        for (int i5 = 0; i5 < m1835e; i5++) {
            View m1834d = this.f7110f.m1834d(i5);
            ViewHolder childViewHolder = getChildViewHolder(m1834d);
            if (childViewHolder != null && (viewHolder = childViewHolder.f7235h) != null) {
                View view = viewHolder.itemView;
                int left = m1834d.getLeft();
                int top = m1834d.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        m1693O(true);
        m1709e0(false);
        if (iArr != null) {
            iArr[0] = i3;
            iArr[1] = i4;
        }
    }

    /* renamed from: a0 */
    public final void m1705a0(Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.f7124m;
        C0517y0 c0517y0 = this.f7102b;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(c0517y0);
            this.f7124m.onDetachedFromRecyclerView(this);
        }
        Recycler recycler = this.f7104c;
        if (!z || z2) {
            ItemAnimator itemAnimator = this.f7090N;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            LayoutManager layoutManager = this.f7126n;
            if (layoutManager != null) {
                layoutManager.removeAndRecycleAllViews(recycler);
                this.f7126n.m1732d(recycler);
            }
            recycler.clear();
        }
        C0456a c0456a = this.f7108e;
        c0456a.m1818k(c0456a.f7314b);
        c0456a.m1818k(c0456a.f7315c);
        c0456a.f7318f = 0;
        Adapter adapter3 = this.f7124m;
        this.f7124m = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(c0517y0);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager2 = this.f7126n;
        if (layoutManager2 != null) {
            layoutManager2.onAdapterChanged(adapter3, this.f7124m);
        }
        Adapter adapter4 = this.f7124m;
        recycler.clear();
        recycler.m1744d(adapter3, true);
        RecycledViewPool m1742b = recycler.m1742b();
        if (adapter3 != null) {
            m1742b.f7183b--;
        }
        if (!z && m1742b.f7183b == 0) {
            m1742b.clear();
        }
        if (adapter4 != null) {
            m1742b.f7183b++;
        } else {
            m1742b.getClass();
        }
        recycler.m1743c();
        this.f7117i0.f7216g = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f7132q;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            arrayList.add(itemDecoration);
        } else {
            arrayList.add(i, itemDecoration);
        }
        m1689K();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.f7080D == null) {
            this.f7080D = new ArrayList();
        }
        this.f7080D.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.f7134r.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.f7121k0 == null) {
            this.f7121k0 = new ArrayList();
        }
        this.f7121k0.add(onScrollListener);
    }

    public void addRecyclerListener(@NonNull RecyclerListener recyclerListener) {
        boolean z;
        if (recyclerListener != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "'listener' arg cannot be null.");
        this.f7130p.add(recyclerListener);
    }

    /* renamed from: b0 */
    public final boolean m1706b0(EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        float distance = EdgeEffectCompat.getDistance(edgeEffect) * i2;
        float abs = Math.abs(-i) * 0.35f;
        float f = this.f7100a * 0.015f;
        double log = Math.log(abs / f);
        double d = f7068F0;
        if (((float) (Math.exp((d / (d - 1.0d)) * log) * f)) < distance) {
            return true;
        }
        return false;
    }

    /* renamed from: c0 */
    public final void m1707c0(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f7148y) {
            return;
        }
        int i4 = 0;
        if (!layoutManager.canScrollHorizontally()) {
            i = 0;
        }
        if (!this.f7126n.canScrollVertically()) {
            i2 = 0;
        }
        if (i != 0 || i2 != 0) {
            if (i3 != Integer.MIN_VALUE && i3 <= 0) {
                scrollBy(i, i2);
                return;
            }
            if (z) {
                if (i != 0) {
                    i4 = 1;
                }
                if (i2 != 0) {
                    i4 |= 2;
                }
                startNestedScroll(i4, 1);
            }
            this.f7111f0.m1822c(i, i2, i3, interpolator);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && this.f7126n.checkLayoutParams((LayoutParams) layoutParams)) {
            return true;
        }
        return false;
    }

    public void clearOnChildAttachStateChangeListeners() {
        ArrayList arrayList = this.f7080D;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void clearOnScrollListeners() {
        ArrayList arrayList = this.f7121k0;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.f7126n.computeHorizontalScrollExtent(this.f7117i0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.f7126n.computeHorizontalScrollOffset(this.f7117i0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.f7126n.computeHorizontalScrollRange(this.f7117i0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.f7126n.computeVerticalScrollExtent(this.f7117i0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.f7126n.computeVerticalScrollOffset(this.f7117i0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.f7126n.computeVerticalScrollRange(this.f7117i0);
    }

    /* renamed from: d0 */
    public final void m1708d0() {
        int i = this.f7144w + 1;
        this.f7144w = i;
        if (i == 1 && !this.f7148y) {
            this.f7146x = false;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
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
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        int i2;
        super.draw(canvas);
        ArrayList arrayList = this.f7132q;
        int size = arrayList.size();
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ((ItemDecoration) arrayList.get(i3)).onDrawOver(canvas, this, this.f7117i0);
        }
        EdgeEffect edgeEffect = this.f7086J;
        boolean z5 = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.f7114h) {
                i2 = getPaddingBottom();
            } else {
                i2 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i2, f7068F0);
            EdgeEffect edgeEffect2 = this.f7086J;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z = true;
            } else {
                z = false;
            }
            canvas.restoreToCount(save);
        } else {
            z = false;
        }
        EdgeEffect edgeEffect3 = this.f7087K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f7114h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f7087K;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z3 = true;
            } else {
                z3 = false;
            }
            z |= z3;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f7088L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.f7114h) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(i, -width);
            EdgeEffect edgeEffect6 = this.f7088L;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z2 = true;
            } else {
                z2 = false;
            }
            z |= z2;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f7089M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f7114h) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f7089M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z |= z4;
            canvas.restoreToCount(save4);
        }
        if (z || this.f7090N == null || arrayList.size() <= 0 || !this.f7090N.isRunning()) {
            z5 = z;
        }
        if (z5) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* renamed from: e0 */
    public final void m1709e0(boolean z) {
        if (this.f7144w < 1) {
            if (!f7065C0) {
                this.f7144w = 1;
            } else {
                throw new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
        }
        if (!z && !this.f7148y) {
            this.f7146x = false;
        }
        if (this.f7144w == 1) {
            if (z && this.f7146x && !this.f7148y && this.f7126n != null && this.f7124m != null) {
                m1717p();
            }
            if (!this.f7148y) {
                this.f7146x = false;
            }
        }
        this.f7144w--;
    }

    @Nullable
    public View findChildViewUnder(float f, float f2) {
        for (int m1835e = this.f7110f.m1835e() - 1; m1835e >= 0; m1835e--) {
            View m1834d = this.f7110f.m1834d(m1835e);
            float translationX = m1834d.getTranslationX();
            float translationY = m1834d.getTranslationY();
            if (f >= m1834d.getLeft() + translationX && f <= m1834d.getRight() + translationX && f2 >= m1834d.getTop() + translationY && f2 <= m1834d.getBottom() + translationY) {
                return m1834d;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.f7081E) {
            return null;
        }
        int m1838h = this.f7110f.m1838h();
        for (int i2 = 0; i2 < m1838h; i2++) {
            ViewHolder m1672F = m1672F(this.f7110f.m1837g(i2));
            if (m1672F != null && !m1672F.m1762g() && m1684D(m1672F) == i) {
                C0474g c0474g = this.f7110f;
                if (c0474g.f7377c.contains(m1672F.itemView)) {
                    viewHolder = m1672F;
                } else {
                    return m1672F;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.f7124m;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int m1838h = this.f7110f.m1838h();
            for (int i = 0; i < m1838h; i++) {
                ViewHolder m1672F = m1672F(this.f7110f.m1837g(i));
                if (m1672F != null && !m1672F.m1762g() && m1672F.getItemId() == j) {
                    C0474g c0474g = this.f7110f;
                    if (c0474g.f7377c.contains(m1672F.itemView)) {
                        viewHolder = m1672F;
                    } else {
                        return m1672F;
                    }
                }
            }
        }
        return viewHolder;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return m1683C(i, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return m1683C(i, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00eb  */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean fling(int i, int i2) {
        int i3;
        int i4;
        RunnableC0461b1 runnableC0461b1;
        int i5;
        float f;
        float f2;
        boolean z;
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f7148y) {
            return false;
        }
        int canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.f7126n.canScrollVertically();
        int i6 = this.f7101a0;
        if (canScrollHorizontally == 0 || Math.abs(i) < i6) {
            i = 0;
        }
        if (!canScrollVertically || Math.abs(i2) < i6) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        if (i != 0) {
            EdgeEffect edgeEffect = this.f7086J;
            if (edgeEffect != null && EdgeEffectCompat.getDistance(edgeEffect) != f7068F0) {
                int i7 = -i;
                if (m1706b0(this.f7086J, i7, getWidth())) {
                    this.f7086J.onAbsorb(i7);
                    i = 0;
                }
                i3 = i;
                i = 0;
            } else {
                EdgeEffect edgeEffect2 = this.f7088L;
                if (edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != f7068F0) {
                    if (m1706b0(this.f7088L, i, getWidth())) {
                        this.f7088L.onAbsorb(i);
                        i = 0;
                    }
                    i3 = i;
                    i = 0;
                }
            }
            if (i2 != 0) {
                EdgeEffect edgeEffect3 = this.f7087K;
                if (edgeEffect3 != null && EdgeEffectCompat.getDistance(edgeEffect3) != f7068F0) {
                    int i8 = -i2;
                    if (m1706b0(this.f7087K, i8, getHeight())) {
                        this.f7087K.onAbsorb(i8);
                        i2 = 0;
                    }
                    i4 = 0;
                } else {
                    EdgeEffect edgeEffect4 = this.f7089M;
                    if (edgeEffect4 != null && EdgeEffectCompat.getDistance(edgeEffect4) != f7068F0) {
                        if (m1706b0(this.f7089M, i2, getHeight())) {
                            this.f7089M.onAbsorb(i2);
                            i2 = 0;
                        }
                        i4 = 0;
                    }
                }
                runnableC0461b1 = this.f7111f0;
                i5 = this.f7103b0;
                if (i3 == 0 || i2 != 0) {
                    int i9 = -i5;
                    i3 = Math.max(i9, Math.min(i3, i5));
                    i2 = Math.max(i9, Math.min(i2, i5));
                    runnableC0461b1.m1820a(i3, i2);
                }
                if (i != 0 && i4 == 0) {
                    if (i3 == 0 && i2 == 0) {
                        return false;
                    }
                    return true;
                }
                f = i;
                f2 = i4;
                if (!dispatchNestedPreFling(f, f2)) {
                    if (canScrollHorizontally == 0 && !canScrollVertically) {
                        z = false;
                    } else {
                        z = true;
                    }
                    dispatchNestedFling(f, f2, z);
                    OnFlingListener onFlingListener = this.f7099W;
                    if (onFlingListener != null && onFlingListener.onFling(i, i4)) {
                        return true;
                    }
                    if (z) {
                        if (canScrollVertically) {
                            canScrollHorizontally = (canScrollHorizontally == true ? 1 : 0) | 2;
                        }
                        startNestedScroll(canScrollHorizontally, 1);
                        int i10 = -i5;
                        runnableC0461b1.m1820a(Math.max(i10, Math.min(i, i5)), Math.max(i10, Math.min(i4, i5)));
                        return true;
                    }
                }
                return false;
            }
            i4 = i2;
            i2 = 0;
            runnableC0461b1 = this.f7111f0;
            i5 = this.f7103b0;
            if (i3 == 0) {
            }
            int i92 = -i5;
            i3 = Math.max(i92, Math.min(i3, i5));
            i2 = Math.max(i92, Math.min(i2, i5));
            runnableC0461b1.m1820a(i3, i2);
            if (i != 0) {
            }
            f = i;
            f2 = i4;
            if (!dispatchNestedPreFling(f, f2)) {
            }
            return false;
        }
        i3 = 0;
        if (i2 != 0) {
        }
        i4 = i2;
        i2 = 0;
        runnableC0461b1 = this.f7111f0;
        i5 = this.f7103b0;
        if (i3 == 0) {
        }
        int i922 = -i5;
        i3 = Math.max(i922, Math.min(i3, i5));
        i2 = Math.max(i922, Math.min(i2, i5));
        runnableC0461b1.m1820a(i3, i2);
        if (i != 0) {
        }
        f = i;
        f2 = i4;
        if (!dispatchNestedPreFling(f, f2)) {
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x017b, code lost:
    
        if (r5 > 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x017e, code lost:
    
        if (r7 < 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0181, code lost:
    
        if (r5 < 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0189, code lost:
    
        if ((r5 * r6) <= 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0191, code lost:
    
        if ((r5 * r6) >= 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0164, code lost:
    
        if (r7 > 0) goto L140;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View focusSearch(View view, int i) {
        boolean z;
        View view2;
        int i2;
        int i3;
        char c;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        View onInterceptFocusSearch = this.f7126n.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z5 = true;
        if (this.f7124m != null && this.f7126n != null && !isComputingLayout() && !this.f7148y) {
            z = true;
        } else {
            z = false;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        State state = this.f7117i0;
        Recycler recycler = this.f7104c;
        if (z && (i == 2 || i == 1)) {
            if (this.f7126n.canScrollVertically()) {
                if (i == 2) {
                    i5 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
                } else {
                    i5 = 33;
                }
                if (focusFinder.findNextFocus(this, view, i5) == null) {
                    z2 = true;
                    if (!z2 && this.f7126n.canScrollHorizontally()) {
                        if (this.f7126n.getLayoutDirection() != 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (i != 2) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!(z3 ^ z4)) {
                            i4 = 66;
                        } else {
                            i4 = 17;
                        }
                        if (focusFinder.findNextFocus(this, view, i4) != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        m1714m();
                        if (findContainingItemView(view) == null) {
                            return null;
                        }
                        m1708d0();
                        this.f7126n.onFocusSearchFailed(view, i, recycler, state);
                        m1709e0(false);
                    }
                    view2 = focusFinder.findNextFocus(this, view, i);
                }
            }
            z2 = false;
            if (!z2) {
                if (this.f7126n.getLayoutDirection() != 1) {
                }
                if (i != 2) {
                }
                if (!(z3 ^ z4)) {
                }
                if (focusFinder.findNextFocus(this, view, i4) != null) {
                }
            }
            if (z2) {
            }
            view2 = focusFinder.findNextFocus(this, view, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i);
            if (findNextFocus == null && z) {
                m1714m();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                m1708d0();
                view2 = this.f7126n.onFocusSearchFailed(view, i, recycler, state);
                m1709e0(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 != null && !view2.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i);
            }
            m1701W(view2, null);
            return view;
        }
        if (view2 != null && view2 != this && view2 != view) {
            if (findContainingItemView(view2) == null) {
                z5 = false;
            } else if (view != null && findContainingItemView(view) != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                Rect rect = this.f7118j;
                rect.set(0, 0, width, height);
                int width2 = view2.getWidth();
                int height2 = view2.getHeight();
                Rect rect2 = this.f7120k;
                rect2.set(0, 0, width2, height2);
                offsetDescendantRectToMyCoords(view, rect);
                offsetDescendantRectToMyCoords(view2, rect2);
                if (this.f7126n.getLayoutDirection() == 1) {
                    i2 = -1;
                } else {
                    i2 = 1;
                }
                int i6 = rect.left;
                int i7 = rect2.left;
                if ((i6 < i7 || rect.right <= i7) && rect.right < rect2.right) {
                    i3 = 1;
                } else {
                    int i8 = rect.right;
                    int i9 = rect2.right;
                    if ((i8 > i9 || i6 >= i9) && i6 > i7) {
                        i3 = -1;
                    } else {
                        i3 = 0;
                    }
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                if ((i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom) {
                    c = 1;
                } else {
                    int i12 = rect.bottom;
                    int i13 = rect2.bottom;
                    if ((i12 > i13 || i10 >= i13) && i10 > i11) {
                        c = 65535;
                    } else {
                        c = 0;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 17) {
                            if (i != 33) {
                                if (i != 66) {
                                    if (i != 130) {
                                        StringBuilder sb = new StringBuilder("Invalid direction: ");
                                        sb.append(i);
                                        throw new IllegalArgumentException(AbstractC1726qj.m7056l(this, sb));
                                    }
                                }
                            }
                        }
                    } else if (c <= 0) {
                        if (c == 0) {
                        }
                    }
                } else if (c >= 0) {
                    if (c == 0) {
                    }
                }
            }
            if (z5) {
                return super.focusSearch(view, i);
            }
            return view2;
        }
        z5 = false;
        if (z5) {
        }
    }

    /* renamed from: g */
    public final void m1710g(ViewHolder viewHolder) {
        boolean z;
        View view = viewHolder.itemView;
        if (view.getParent() == this) {
            z = true;
        } else {
            z = false;
        }
        this.f7104c.m1751k(getChildViewHolder(view));
        if (viewHolder.m1764i()) {
            this.f7110f.m1832b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.f7110f.m1831a(-1, view, true);
            return;
        }
        C0474g c0474g = this.f7110f;
        int indexOfChild = c0474g.f7375a.f7466a.indexOfChild(view);
        if (indexOfChild >= 0) {
            c0474g.f7376b.m8144h(indexOfChild);
            c0474g.m1839i(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.f7124m;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public int getChildAdapterPosition(@NonNull View view) {
        ViewHolder m1672F = m1672F(view);
        if (m1672F != null) {
            return m1672F.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.f7133q0;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
    }

    public long getChildItemId(@NonNull View view) {
        ViewHolder m1672F;
        Adapter adapter = this.f7124m;
        if (adapter == null || !adapter.hasStableIds() || (m1672F = m1672F(view)) == null) {
            return -1L;
        }
        return m1672F.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ViewHolder m1672F = m1672F(view);
        if (m1672F != null) {
            return m1672F.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return m1672F(view);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f7114h;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f7131p0;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        m1673G(view, rect);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.f7085I;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.f7090N;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return (ItemDecoration) this.f7132q.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.f7132q.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.f7126n;
    }

    public int getMaxFlingVelocity() {
        return this.f7103b0;
    }

    public int getMinFlingVelocity() {
        return this.f7101a0;
    }

    public long getNanoTime() {
        if (f7071I0) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.f7099W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f7109e0;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.f7104c.m1742b();
    }

    public int getScrollState() {
        return this.f7091O;
    }

    /* renamed from: h */
    public final void m1711h(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        }
        if (this.f7084H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder(""))));
        }
    }

    public boolean hasFixedSize() {
        return this.f7140u;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.f7142v && !this.f7081E && !this.f7108e.m1814g()) {
            return false;
        }
        return true;
    }

    public void invalidateItemDecorations() {
        if (this.f7132q.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        m1689K();
        requestLayout();
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.f7090N;
        if (itemAnimator != null && itemAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f7138t;
    }

    public boolean isComputingLayout() {
        if (this.f7083G > 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f7148y;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    /* renamed from: j */
    public final void m1712j() {
        int m1838h = this.f7110f.m1838h();
        for (int i = 0; i < m1838h; i++) {
            ViewHolder m1672F = m1672F(this.f7110f.m1837g(i));
            if (!m1672F.m1768m()) {
                m1672F.f7230c = -1;
                m1672F.f7233f = -1;
            }
        }
        Recycler recycler = this.f7104c;
        ArrayList arrayList = recycler.f7187c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i2);
            viewHolder.f7230c = -1;
            viewHolder.f7233f = -1;
        }
        ArrayList arrayList2 = recycler.f7185a;
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ViewHolder viewHolder2 = (ViewHolder) arrayList2.get(i3);
            viewHolder2.f7230c = -1;
            viewHolder2.f7233f = -1;
        }
        ArrayList arrayList3 = recycler.f7186b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ViewHolder viewHolder3 = (ViewHolder) recycler.f7186b.get(i4);
                viewHolder3.f7230c = -1;
                viewHolder3.f7233f = -1;
            }
        }
    }

    /* renamed from: k */
    public final void m1713k(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.f7086J;
        if (edgeEffect != null && !edgeEffect.isFinished() && i > 0) {
            this.f7086J.onRelease();
            z = this.f7086J.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f7088L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f7088L.onRelease();
            z |= this.f7088L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f7087K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.f7087K.onRelease();
            z |= this.f7087K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f7089M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.f7089M.onRelease();
            z |= this.f7089M.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: m */
    public final void m1714m() {
        if (this.f7142v && !this.f7081E) {
            if (!this.f7108e.m1814g()) {
                return;
            }
            C0456a c0456a = this.f7108e;
            int i = c0456a.f7318f;
            if ((i & 4) != 0 && (i & 11) == 0) {
                TraceCompat.beginSection("RV PartialInvalidate");
                m1708d0();
                m1692N();
                this.f7108e.m1817j();
                if (!this.f7146x) {
                    int m1835e = this.f7110f.m1835e();
                    int i2 = 0;
                    while (true) {
                        if (i2 < m1835e) {
                            ViewHolder m1672F = m1672F(this.f7110f.m1834d(i2));
                            if (m1672F != null && !m1672F.m1768m() && m1672F.m1765j()) {
                                m1717p();
                                break;
                            }
                            i2++;
                        } else {
                            this.f7108e.m1809b();
                            break;
                        }
                    }
                }
                m1709e0(true);
                m1693O(true);
                TraceCompat.endSection();
                return;
            }
            if (c0456a.m1814g()) {
                TraceCompat.beginSection("RV FullInvalidate");
                m1717p();
                TraceCompat.endSection();
                return;
            }
            return;
        }
        TraceCompat.beginSection("RV FullInvalidate");
        m1717p();
        TraceCompat.endSection();
    }

    /* renamed from: n */
    public final void m1715n(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingRight() + getPaddingLeft(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingBottom() + getPaddingTop(), ViewCompat.getMinimumHeight(this)));
    }

    public void nestedScrollBy(int i, int i2) {
        m1690L(null, i, i2);
    }

    /* renamed from: o */
    public final void m1716o(View view) {
        ViewHolder m1672F = m1672F(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.f7124m;
        if (adapter != null && m1672F != null) {
            adapter.onViewDetachedFromWindow(m1672F);
        }
        ArrayList arrayList = this.f7080D;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.f7080D.get(size)).onChildViewDetachedFromWindow(view);
            }
        }
    }

    public void offsetChildrenHorizontal(@Px int i) {
        int m1835e = this.f7110f.m1835e();
        for (int i2 = 0; i2 < m1835e; i2++) {
            this.f7110f.m1834d(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(@Px int i) {
        int m1835e = this.f7110f.m1835e();
        for (int i2 = 0; i2 < m1835e; i2++) {
            this.f7110f.m1834d(i2).offsetTopAndBottom(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.recyclerview.widget.u, java.lang.Object] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        boolean z;
        float f;
        super.onAttachedToWindow();
        this.f7083G = 0;
        this.f7138t = true;
        if (this.f7142v && !isLayoutRequested()) {
            z = true;
        } else {
            z = false;
        }
        this.f7142v = z;
        this.f7104c.m1743c();
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            layoutManager.f7168g = true;
            layoutManager.onAttachedToWindow(this);
        }
        this.f7129o0 = false;
        if (f7071I0) {
            ThreadLocal threadLocal = RunnableC0508u.f7504e;
            RunnableC0508u runnableC0508u = (RunnableC0508u) threadLocal.get();
            this.f7113g0 = runnableC0508u;
            if (runnableC0508u == null) {
                ?? obj = new Object();
                obj.f7506a = new ArrayList();
                obj.f7509d = new ArrayList();
                this.f7113g0 = obj;
                Display display = ViewCompat.getDisplay(this);
                if (!isInEditMode() && display != null) {
                    f = display.getRefreshRate();
                }
                f = 60.0f;
                RunnableC0508u runnableC0508u2 = this.f7113g0;
                runnableC0508u2.f7508c = 1.0E9f / f;
                threadLocal.set(runnableC0508u2);
            }
            RunnableC0508u runnableC0508u3 = this.f7113g0;
            runnableC0508u3.getClass();
            boolean z2 = f7065C0;
            ArrayList arrayList = runnableC0508u3.f7506a;
            if (z2 && arrayList.contains(this)) {
                throw new IllegalStateException("RecyclerView already present in worker list!");
            }
            arrayList.add(this);
        }
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        RunnableC0508u runnableC0508u;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.f7090N;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.f7138t = false;
        LayoutManager layoutManager = this.f7126n;
        Recycler recycler = this.f7104c;
        if (layoutManager != null) {
            layoutManager.f7168g = false;
            layoutManager.onDetachedFromWindow(this, recycler);
        }
        this.f7145w0.clear();
        removeCallbacks(this.f7147x0);
        this.f7112g.getClass();
        do {
        } while (C0485j1.f7414d.acquire() != 0);
        int i = 0;
        while (true) {
            ArrayList arrayList = recycler.f7187c;
            if (i >= arrayList.size()) {
                break;
            }
            PoolingContainer.callPoolingContainerOnRelease(((ViewHolder) arrayList.get(i)).itemView);
            i++;
        }
        recycler.m1744d(RecyclerView.this.f7124m, false);
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (f7071I0 && (runnableC0508u = this.f7113g0) != null) {
            boolean remove = runnableC0508u.f7506a.remove(this);
            if (f7065C0 && !remove) {
                throw new IllegalStateException("RecyclerView removal failed!");
            }
            this.f7113g0 = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f7132q;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((ItemDecoration) arrayList.get(i)).onDraw(canvas, this, this.f7117i0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.f7126n != null && !this.f7148y && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.f7126n.canScrollVertically()) {
                    f = -motionEvent.getAxisValue(9);
                } else {
                    f = 0.0f;
                }
                if (this.f7126n.canScrollHorizontally()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (f == f7068F0 || f2 != f7068F0) {
                        m1690L(motionEvent, (int) (f2 * this.f7105c0), (int) (f * this.f7107d0));
                    }
                }
                f2 = 0.0f;
                if (f == f7068F0) {
                }
                m1690L(motionEvent, (int) (f2 * this.f7105c0), (int) (f * this.f7107d0));
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f7126n.canScrollVertically()) {
                        f = -axisValue;
                        f2 = 0.0f;
                        if (f == f7068F0) {
                        }
                        m1690L(motionEvent, (int) (f2 * this.f7105c0), (int) (f * this.f7107d0));
                    } else if (this.f7126n.canScrollHorizontally()) {
                        f2 = axisValue;
                        f = 0.0f;
                        if (f == f7068F0) {
                        }
                        m1690L(motionEvent, (int) (f2 * this.f7105c0), (int) (f * this.f7107d0));
                    }
                }
                f = 0.0f;
                f2 = 0.0f;
                if (f == f7068F0) {
                }
                m1690L(motionEvent, (int) (f2 * this.f7105c0), (int) (f * this.f7107d0));
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (this.f7148y) {
            return false;
        }
        this.f7136s = null;
        if (m1727z(motionEvent)) {
            m1702X();
            setScrollState(0);
            return true;
        }
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.f7126n.canScrollVertically();
        if (this.f7093Q == null) {
            this.f7093Q = VelocityTracker.obtain();
        }
        this.f7093Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                m1694P(motionEvent);
                            }
                        } else {
                            this.f7092P = motionEvent.getPointerId(actionIndex);
                            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.f7096T = x;
                            this.f7094R = x;
                            int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.f7097U = y;
                            this.f7095S = y;
                        }
                    } else {
                        m1702X();
                        setScrollState(0);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f7092P);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f7092P + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.f7091O != 1) {
                        int i = x2 - this.f7094R;
                        int i2 = y2 - this.f7095S;
                        if (canScrollHorizontally != 0 && Math.abs(i) > this.f7098V) {
                            this.f7096T = x2;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (canScrollVertically && Math.abs(i2) > this.f7098V) {
                            this.f7097U = y2;
                            z2 = true;
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                }
            } else {
                this.f7093Q.clear();
                stopNestedScroll(0);
            }
        } else {
            if (this.f7150z) {
                this.f7150z = false;
            }
            this.f7092P = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.f7096T = x3;
            this.f7094R = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.f7097U = y3;
            this.f7095S = y3;
            EdgeEffect edgeEffect = this.f7086J;
            if (edgeEffect != null && EdgeEffectCompat.getDistance(edgeEffect) != f7068F0 && !canScrollHorizontally(-1)) {
                EdgeEffectCompat.onPullDistance(this.f7086J, f7068F0, 1.0f - (motionEvent.getY() / getHeight()));
                z = true;
            } else {
                z = false;
            }
            EdgeEffect edgeEffect2 = this.f7088L;
            boolean z3 = z;
            if (edgeEffect2 != null) {
                z3 = z;
                if (EdgeEffectCompat.getDistance(edgeEffect2) != f7068F0) {
                    z3 = z;
                    if (!canScrollHorizontally(1)) {
                        EdgeEffectCompat.onPullDistance(this.f7088L, f7068F0, motionEvent.getY() / getHeight());
                        z3 = true;
                    }
                }
            }
            EdgeEffect edgeEffect3 = this.f7087K;
            boolean z4 = z3;
            if (edgeEffect3 != null) {
                z4 = z3;
                if (EdgeEffectCompat.getDistance(edgeEffect3) != f7068F0) {
                    z4 = z3;
                    if (!canScrollVertically(-1)) {
                        EdgeEffectCompat.onPullDistance(this.f7087K, f7068F0, motionEvent.getX() / getWidth());
                        z4 = true;
                    }
                }
            }
            EdgeEffect edgeEffect4 = this.f7089M;
            boolean z5 = z4;
            if (edgeEffect4 != null) {
                z5 = z4;
                if (EdgeEffectCompat.getDistance(edgeEffect4) != f7068F0) {
                    z5 = z4;
                    if (!canScrollVertically(1)) {
                        EdgeEffectCompat.onPullDistance(this.f7089M, f7068F0, 1.0f - (motionEvent.getX() / getWidth()));
                        z5 = true;
                    }
                }
            }
            if (z5 || this.f7091O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.f7141u0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i3 = canScrollHorizontally;
            if (canScrollVertically) {
                i3 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i3, 0);
        }
        if (this.f7091O != 1) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection("RV OnLayout");
        m1717p();
        TraceCompat.endSection();
        this.f7142v = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            m1715n(i, i2);
            return;
        }
        boolean isAutoMeasureEnabled = layoutManager.isAutoMeasureEnabled();
        Recycler recycler = this.f7104c;
        boolean z = false;
        State state = this.f7117i0;
        if (isAutoMeasureEnabled) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f7126n.onMeasure(recycler, state, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f7149y0 = z;
            if (!z && this.f7124m != null) {
                if (state.f7214e == 1) {
                    m1718q();
                }
                this.f7126n.m1735g(i, i2);
                state.f7219j = true;
                m1719r();
                this.f7126n.m1736h(i, i2);
                if (this.f7126n.mo1650k()) {
                    this.f7126n.m1735g(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    state.f7219j = true;
                    m1719r();
                    this.f7126n.m1736h(i, i2);
                }
                this.f7151z0 = getMeasuredWidth();
                this.f7076A0 = getMeasuredHeight();
                return;
            }
            return;
        }
        if (this.f7140u) {
            this.f7126n.onMeasure(recycler, state, i, i2);
            return;
        }
        if (this.f7077B) {
            m1708d0();
            m1692N();
            m1696R();
            m1693O(true);
            if (state.f7221l) {
                state.f7217h = true;
            } else {
                this.f7108e.m1810c();
                state.f7217h = false;
            }
            this.f7077B = false;
            m1709e0(false);
        } else if (state.f7221l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.f7124m;
        if (adapter != null) {
            state.f7215f = adapter.getItemCount();
        } else {
            state.f7215f = 0;
        }
        m1708d0();
        this.f7126n.onMeasure(recycler, state, i, i2);
        m1709e0(false);
        state.f7217h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f7106d = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.recyclerview.widget.RecyclerView$SavedState, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        SavedState savedState = this.f7106d;
        if (savedState != null) {
            absSavedState.f7194b = savedState.f7194b;
        } else {
            LayoutManager layoutManager = this.f7126n;
            if (layoutManager != null) {
                absSavedState.f7194b = layoutManager.onSaveInstanceState();
            } else {
                absSavedState.f7194b = null;
            }
        }
        return absSavedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(@Px int i, @Px int i2) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            this.f7089M = null;
            this.f7087K = null;
            this.f7088L = null;
            this.f7086J = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0115  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        if (this.f7148y || this.f7150z) {
            return false;
        }
        OnItemTouchListener onItemTouchListener = this.f7136s;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                z = false;
            } else {
                z = m1727z(motionEvent);
            }
        } else {
            onItemTouchListener.onTouchEvent(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f7136s = null;
            }
            z = true;
        }
        if (z) {
            m1702X();
            setScrollState(0);
            return true;
        }
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.f7126n.canScrollVertically();
        if (this.f7093Q == null) {
            this.f7093Q = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int[] iArr = this.f7141u0;
        if (actionMasked == 0) {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(iArr[0], iArr[1]);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                m1694P(motionEvent);
                            }
                        } else {
                            this.f7092P = motionEvent.getPointerId(actionIndex);
                            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.f7096T = x;
                            this.f7094R = x;
                            int y = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.f7097U = y;
                            this.f7095S = y;
                        }
                    } else {
                        m1702X();
                        setScrollState(0);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f7092P);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f7092P + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int i5 = this.f7096T - x2;
                    int i6 = this.f7097U - y2;
                    if (this.f7091O != 1) {
                        if (canScrollHorizontally != 0) {
                            if (i5 > 0) {
                                i5 = Math.max(0, i5 - this.f7098V);
                            } else {
                                i5 = Math.min(0, i5 + this.f7098V);
                            }
                            if (i5 != 0) {
                                z2 = true;
                                if (canScrollVertically) {
                                    if (i6 > 0) {
                                        i6 = Math.max(0, i6 - this.f7098V);
                                    } else {
                                        i6 = Math.min(0, i6 + this.f7098V);
                                    }
                                    if (i6 != 0) {
                                        z2 = true;
                                    }
                                }
                                if (z2) {
                                    setScrollState(1);
                                }
                            }
                        }
                        z2 = false;
                        if (canScrollVertically) {
                        }
                        if (z2) {
                        }
                    }
                    if (this.f7091O == 1) {
                        int[] iArr2 = this.f7143v0;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                        int m1699U = i5 - m1699U(motionEvent.getY(), i5);
                        int m1700V = i6 - m1700V(motionEvent.getX(), i6);
                        if (canScrollHorizontally != 0) {
                            i = m1699U;
                        } else {
                            i = 0;
                        }
                        if (canScrollVertically) {
                            i2 = m1700V;
                        } else {
                            i2 = 0;
                        }
                        boolean dispatchNestedPreScroll = dispatchNestedPreScroll(i, i2, this.f7143v0, this.f7139t0, 0);
                        int[] iArr3 = this.f7139t0;
                        if (dispatchNestedPreScroll) {
                            m1699U -= iArr2[0];
                            m1700V -= iArr2[1];
                            iArr[0] = iArr[0] + iArr3[0];
                            iArr[1] = iArr[1] + iArr3[1];
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        int i7 = m1699U;
                        int i8 = m1700V;
                        this.f7096T = x2 - iArr3[0];
                        this.f7097U = y2 - iArr3[1];
                        if (canScrollHorizontally != 0) {
                            i3 = i7;
                        } else {
                            i3 = 0;
                        }
                        if (canScrollVertically) {
                            i4 = i8;
                        } else {
                            i4 = 0;
                        }
                        if (m1703Y(i3, i4, motionEvent, 0)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        RunnableC0508u runnableC0508u = this.f7113g0;
                        if (runnableC0508u != null && (i7 != 0 || i8 != 0)) {
                            runnableC0508u.m1898a(this, i7, i8);
                        }
                    }
                }
            } else {
                this.f7093Q.addMovement(obtain);
                this.f7093Q.computeCurrentVelocity(1000, this.f7103b0);
                if (canScrollHorizontally != 0) {
                    f = -this.f7093Q.getXVelocity(this.f7092P);
                } else {
                    f = 0.0f;
                }
                if (canScrollVertically) {
                    f2 = -this.f7093Q.getYVelocity(this.f7092P);
                } else {
                    f2 = 0.0f;
                }
                if ((f == f7068F0 && f2 == f7068F0) || !fling((int) f, (int) f2)) {
                    setScrollState(0);
                }
                m1702X();
                obtain.recycle();
                return true;
            }
        } else {
            this.f7092P = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.f7096T = x3;
            this.f7094R = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.f7097U = y3;
            this.f7095S = y3;
            int i9 = canScrollHorizontally;
            if (canScrollVertically) {
                i9 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i9, 0);
        }
        this.f7093Q.addMovement(obtain);
        obtain.recycle();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x0341, code lost:
    
        if (r19.f7110f.f7377c.contains(getFocusedChild()) == false) goto L205;
     */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03be  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1717p() {
        boolean z;
        ViewHolder viewHolder;
        View view;
        View findViewById;
        int i;
        int i2;
        if (this.f7124m == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f7126n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        State state = this.f7117i0;
        int i3 = 0;
        state.f7219j = false;
        int i4 = 1;
        if (this.f7149y0 && (this.f7151z0 != getWidth() || this.f7076A0 != getHeight())) {
            z = true;
        } else {
            z = false;
        }
        this.f7151z0 = 0;
        this.f7076A0 = 0;
        this.f7149y0 = false;
        if (state.f7214e == 1) {
            m1718q();
            this.f7126n.m1734f(this);
            m1719r();
        } else {
            C0456a c0456a = this.f7108e;
            if ((c0456a.f7315c.isEmpty() || c0456a.f7314b.isEmpty()) && !z && this.f7126n.getWidth() == getWidth() && this.f7126n.getHeight() == getHeight()) {
                this.f7126n.m1734f(this);
            } else {
                this.f7126n.m1734f(this);
                m1719r();
            }
        }
        state.m1755a(4);
        m1708d0();
        m1692N();
        state.f7214e = 1;
        boolean z2 = state.f7220k;
        Recycler recycler = this.f7104c;
        C0488k1 c0488k1 = this.f7112g;
        if (z2) {
            int m1835e = this.f7110f.m1835e() - 1;
            while (m1835e >= 0) {
                ViewHolder m1672F = m1672F(this.f7110f.m1834d(m1835e));
                if (!m1672F.m1768m()) {
                    long m1685E = m1685E(m1672F);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.f7090N.recordPostLayoutInformation(state, m1672F);
                    ViewHolder viewHolder2 = (ViewHolder) c0488k1.f7429b.get(m1685E);
                    if (viewHolder2 != null && !viewHolder2.m1768m()) {
                        SimpleArrayMap simpleArrayMap = c0488k1.f7428a;
                        C0485j1 c0485j1 = (C0485j1) simpleArrayMap.get(viewHolder2);
                        if (c0485j1 != null && (c0485j1.f7415a & i4) != 0) {
                            i = i4;
                        } else {
                            i = 0;
                        }
                        C0485j1 c0485j12 = (C0485j1) simpleArrayMap.get(m1672F);
                        if (c0485j12 != null && (c0485j12.f7415a & i4) != 0) {
                            i2 = i4;
                        } else {
                            i2 = 0;
                        }
                        if (i != 0 && viewHolder2 == m1672F) {
                            c0488k1.m1874a(m1672F, recordPostLayoutInformation);
                        } else {
                            ItemAnimator.ItemHolderInfo m1875b = c0488k1.m1875b(viewHolder2, 4);
                            c0488k1.m1874a(m1672F, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo m1875b2 = c0488k1.m1875b(m1672F, 8);
                            if (m1875b == null) {
                                int m1835e2 = this.f7110f.m1835e();
                                for (int i5 = 0; i5 < m1835e2; i5++) {
                                    ViewHolder m1672F2 = m1672F(this.f7110f.m1834d(i5));
                                    if (m1672F2 != m1672F && m1685E(m1672F2) == m1685E) {
                                        Adapter adapter = this.f7124m;
                                        if (adapter != null && adapter.hasStableIds()) {
                                            StringBuilder sb = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                                            sb.append(m1672F2);
                                            sb.append(" \n View Holder 2:");
                                            sb.append(m1672F);
                                            throw new IllegalStateException(AbstractC1726qj.m7056l(this, sb));
                                        }
                                        StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                                        sb2.append(m1672F2);
                                        sb2.append(" \n View Holder 2:");
                                        sb2.append(m1672F);
                                        throw new IllegalStateException(AbstractC1726qj.m7056l(this, sb2));
                                    }
                                }
                                Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + m1672F + m1725x());
                            } else {
                                viewHolder2.setIsRecyclable(false);
                                if (i != 0) {
                                    m1710g(viewHolder2);
                                }
                                if (viewHolder2 != m1672F) {
                                    if (i2 != 0) {
                                        m1710g(m1672F);
                                    }
                                    viewHolder2.f7234g = m1672F;
                                    m1710g(viewHolder2);
                                    recycler.m1751k(viewHolder2);
                                    m1672F.setIsRecyclable(false);
                                    m1672F.f7235h = viewHolder2;
                                }
                                if (this.f7090N.animateChange(viewHolder2, m1672F, m1875b, m1875b2)) {
                                    m1695Q();
                                }
                            }
                        }
                    } else {
                        c0488k1.m1874a(m1672F, recordPostLayoutInformation);
                    }
                }
                m1835e--;
                i4 = 1;
            }
            SimpleArrayMap simpleArrayMap2 = c0488k1.f7428a;
            for (int f1755c = simpleArrayMap2.getF1755c() - 1; f1755c >= 0; f1755c--) {
                ViewHolder viewHolder3 = (ViewHolder) simpleArrayMap2.keyAt(f1755c);
                C0485j1 c0485j13 = (C0485j1) simpleArrayMap2.removeAt(f1755c);
                int i6 = c0485j13.f7415a;
                int i7 = i6 & 3;
                C0499p0 c0499p0 = this.f7078B0;
                if (i7 == 3) {
                    RecyclerView recyclerView = c0499p0.f7460a;
                    recyclerView.f7126n.removeAndRecycleView(viewHolder3.itemView, recyclerView.f7104c);
                } else if ((i6 & 1) != 0) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo = c0485j13.f7416b;
                    if (itemHolderInfo == null) {
                        RecyclerView recyclerView2 = c0499p0.f7460a;
                        recyclerView2.f7126n.removeAndRecycleView(viewHolder3.itemView, recyclerView2.f7104c);
                    } else {
                        ItemAnimator.ItemHolderInfo itemHolderInfo2 = c0485j13.f7417c;
                        RecyclerView recyclerView3 = c0499p0.f7460a;
                        recyclerView3.f7104c.m1751k(viewHolder3);
                        recyclerView3.m1710g(viewHolder3);
                        viewHolder3.setIsRecyclable(false);
                        if (recyclerView3.f7090N.animateDisappearance(viewHolder3, itemHolderInfo, itemHolderInfo2)) {
                            recyclerView3.m1695Q();
                        }
                    }
                } else if ((i6 & 14) == 14) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo3 = c0485j13.f7416b;
                    ItemAnimator.ItemHolderInfo itemHolderInfo4 = c0485j13.f7417c;
                    RecyclerView recyclerView4 = c0499p0.f7460a;
                    recyclerView4.getClass();
                    viewHolder3.setIsRecyclable(false);
                    if (recyclerView4.f7090N.animateAppearance(viewHolder3, itemHolderInfo3, itemHolderInfo4)) {
                        recyclerView4.m1695Q();
                    }
                } else if ((i6 & 12) == 12) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo5 = c0485j13.f7416b;
                    ItemAnimator.ItemHolderInfo itemHolderInfo6 = c0485j13.f7417c;
                    c0499p0.getClass();
                    viewHolder3.setIsRecyclable(false);
                    RecyclerView recyclerView5 = c0499p0.f7460a;
                    if (recyclerView5.f7081E) {
                        if (recyclerView5.f7090N.animateChange(viewHolder3, viewHolder3, itemHolderInfo5, itemHolderInfo6)) {
                            recyclerView5.m1695Q();
                        }
                    } else if (recyclerView5.f7090N.animatePersistence(viewHolder3, itemHolderInfo5, itemHolderInfo6)) {
                        recyclerView5.m1695Q();
                    }
                } else if ((i6 & 4) != 0) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo7 = c0485j13.f7416b;
                    RecyclerView recyclerView6 = c0499p0.f7460a;
                    recyclerView6.f7104c.m1751k(viewHolder3);
                    recyclerView6.m1710g(viewHolder3);
                    viewHolder3.setIsRecyclable(false);
                    if (recyclerView6.f7090N.animateDisappearance(viewHolder3, itemHolderInfo7, null)) {
                        recyclerView6.m1695Q();
                    }
                } else if ((i6 & 8) != 0) {
                    ItemAnimator.ItemHolderInfo itemHolderInfo8 = c0485j13.f7416b;
                    ItemAnimator.ItemHolderInfo itemHolderInfo9 = c0485j13.f7417c;
                    RecyclerView recyclerView7 = c0499p0.f7460a;
                    recyclerView7.getClass();
                    viewHolder3.setIsRecyclable(false);
                    if (recyclerView7.f7090N.animateAppearance(viewHolder3, itemHolderInfo8, itemHolderInfo9)) {
                        recyclerView7.m1695Q();
                    }
                }
                c0485j13.f7415a = 0;
                c0485j13.f7416b = null;
                c0485j13.f7417c = null;
                C0485j1.f7414d.release(c0485j13);
            }
        }
        this.f7126n.m1732d(recycler);
        state.f7212c = state.f7215f;
        this.f7081E = false;
        this.f7082F = false;
        state.f7220k = false;
        state.f7221l = false;
        this.f7126n.f7167f = false;
        ArrayList arrayList = recycler.f7186b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager.f7173l) {
            layoutManager.f7172k = 0;
            layoutManager.f7173l = false;
            recycler.m1752l();
        }
        this.f7126n.onLayoutCompleted(state);
        m1693O(true);
        m1709e0(false);
        c0488k1.f7428a.clear();
        c0488k1.f7429b.clear();
        int[] iArr = this.f7135r0;
        int i8 = iArr[0];
        int i9 = iArr[1];
        m1682A(iArr);
        if (iArr[0] != i8 || iArr[1] != i9) {
            m1720s(0, 0);
        }
        if (this.f7109e0 && this.f7124m != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (!isFocused()) {
            }
            if (state.f7223n != -1 && this.f7124m.hasStableIds()) {
                viewHolder = findViewHolderForItemId(state.f7223n);
            } else {
                viewHolder = null;
            }
            if (viewHolder != null) {
                if (!this.f7110f.f7377c.contains(viewHolder.itemView) && viewHolder.itemView.hasFocusable()) {
                    view = viewHolder.itemView;
                    if (view != null) {
                        int i10 = state.f7224o;
                        if (i10 != -1 && (findViewById = view.findViewById(i10)) != null && findViewById.isFocusable()) {
                            view = findViewById;
                        }
                        view.requestFocus();
                    }
                }
            }
            if (this.f7110f.m1835e() > 0) {
                int i11 = state.f7222m;
                if (i11 != -1) {
                    i3 = i11;
                }
                int itemCount = state.getItemCount();
                for (int i12 = i3; i12 < itemCount; i12++) {
                    ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i12);
                    if (findViewHolderForAdapterPosition == null) {
                        break;
                    }
                    if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                        view = findViewHolderForAdapterPosition.itemView;
                        break;
                    }
                }
                for (int min = Math.min(itemCount, i3) - 1; min >= 0; min--) {
                    ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(min);
                    if (findViewHolderForAdapterPosition2 == null) {
                        break;
                    }
                    if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                        view = findViewHolderForAdapterPosition2.itemView;
                        break;
                    }
                }
            }
            view = null;
            if (view != null) {
            }
        }
        state.f7223n = -1L;
        state.f7222m = -1;
        state.f7224o = -1;
    }

    /* renamed from: q */
    public final void m1718q() {
        View view;
        int absoluteAdapterPosition;
        boolean z;
        C0485j1 c0485j1;
        State state = this.f7117i0;
        state.m1755a(1);
        m1726y(state);
        state.f7219j = false;
        m1708d0();
        C0488k1 c0488k1 = this.f7112g;
        c0488k1.f7428a.clear();
        LongSparseArray longSparseArray = c0488k1.f7429b;
        longSparseArray.clear();
        m1692N();
        m1696R();
        ViewHolder viewHolder = null;
        if (this.f7109e0 && hasFocus() && this.f7124m != null) {
            view = getFocusedChild();
        } else {
            view = null;
        }
        if (view != null) {
            viewHolder = findContainingViewHolder(view);
        }
        long j = -1;
        if (viewHolder == null) {
            state.f7223n = -1L;
            state.f7222m = -1;
            state.f7224o = -1;
        } else {
            if (this.f7124m.hasStableIds()) {
                j = viewHolder.getItemId();
            }
            state.f7223n = j;
            if (this.f7081E) {
                absoluteAdapterPosition = -1;
            } else if (viewHolder.m1762g()) {
                absoluteAdapterPosition = viewHolder.f7230c;
            } else {
                absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            }
            state.f7222m = absoluteAdapterPosition;
            View view2 = viewHolder.itemView;
            int id = view2.getId();
            while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
                view2 = ((ViewGroup) view2).getFocusedChild();
                if (view2.getId() != -1) {
                    id = view2.getId();
                }
            }
            state.f7224o = id;
        }
        if (state.f7220k && this.f7125m0) {
            z = true;
        } else {
            z = false;
        }
        state.f7218i = z;
        this.f7125m0 = false;
        this.f7123l0 = false;
        state.f7217h = state.f7221l;
        state.f7215f = this.f7124m.getItemCount();
        m1682A(this.f7135r0);
        boolean z2 = state.f7220k;
        SimpleArrayMap simpleArrayMap = c0488k1.f7428a;
        if (z2) {
            int m1835e = this.f7110f.m1835e();
            for (int i = 0; i < m1835e; i++) {
                ViewHolder m1672F = m1672F(this.f7110f.m1834d(i));
                if (!m1672F.m1768m() && (!m1672F.m1761f() || this.f7124m.hasStableIds())) {
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.f7090N.recordPreLayoutInformation(state, m1672F, ItemAnimator.m1728a(m1672F), m1672F.m1757b());
                    C0485j1 c0485j12 = (C0485j1) simpleArrayMap.get(m1672F);
                    if (c0485j12 == null) {
                        c0485j12 = C0485j1.m1873a();
                        simpleArrayMap.put(m1672F, c0485j12);
                    }
                    c0485j12.f7416b = recordPreLayoutInformation;
                    c0485j12.f7415a |= 4;
                    if (state.f7218i && m1672F.m1765j() && !m1672F.m1762g() && !m1672F.m1768m() && !m1672F.m1761f()) {
                        longSparseArray.put(m1685E(m1672F), m1672F);
                    }
                }
            }
        }
        if (state.f7221l) {
            int m1838h = this.f7110f.m1838h();
            for (int i2 = 0; i2 < m1838h; i2++) {
                ViewHolder m1672F2 = m1672F(this.f7110f.m1837g(i2));
                if (f7065C0 && m1672F2.f7229b == -1 && !m1672F2.m1762g()) {
                    throw new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
                }
                if (!m1672F2.m1768m() && m1672F2.f7230c == -1) {
                    m1672F2.f7230c = m1672F2.f7229b;
                }
            }
            boolean z3 = state.f7216g;
            state.f7216g = false;
            this.f7126n.onLayoutChildren(this.f7104c, state);
            state.f7216g = z3;
            for (int i3 = 0; i3 < this.f7110f.m1835e(); i3++) {
                ViewHolder m1672F3 = m1672F(this.f7110f.m1834d(i3));
                if (!m1672F3.m1768m() && ((c0485j1 = (C0485j1) simpleArrayMap.get(m1672F3)) == null || (c0485j1.f7415a & 4) == 0)) {
                    int m1728a = ItemAnimator.m1728a(m1672F3);
                    boolean m1758c = m1672F3.m1758c(8192);
                    if (!m1758c) {
                        m1728a |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation2 = this.f7090N.recordPreLayoutInformation(state, m1672F3, m1728a, m1672F3.m1757b());
                    if (m1758c) {
                        m1698T(m1672F3, recordPreLayoutInformation2);
                    } else {
                        C0485j1 c0485j13 = (C0485j1) simpleArrayMap.get(m1672F3);
                        if (c0485j13 == null) {
                            c0485j13 = C0485j1.m1873a();
                            simpleArrayMap.put(m1672F3, c0485j13);
                        }
                        c0485j13.f7415a |= 2;
                        c0485j13.f7416b = recordPreLayoutInformation2;
                    }
                }
            }
            m1712j();
        } else {
            m1712j();
        }
        m1693O(true);
        m1709e0(false);
        state.f7214e = 2;
    }

    /* renamed from: r */
    public final void m1719r() {
        boolean z;
        m1708d0();
        m1692N();
        State state = this.f7117i0;
        state.m1755a(6);
        this.f7108e.m1810c();
        state.f7215f = this.f7124m.getItemCount();
        state.f7213d = 0;
        if (this.f7106d != null) {
            Adapter adapter = this.f7124m;
            adapter.getClass();
            int i = AbstractC0505s0.f7499a[adapter.f7154c.ordinal()];
            if (i != 1 && (i != 2 || adapter.getItemCount() > 0)) {
                Parcelable parcelable = this.f7106d.f7194b;
                if (parcelable != null) {
                    this.f7126n.onRestoreInstanceState(parcelable);
                }
                this.f7106d = null;
            }
        }
        state.f7217h = false;
        this.f7126n.onLayoutChildren(this.f7104c, state);
        state.f7216g = false;
        if (state.f7220k && this.f7090N != null) {
            z = true;
        } else {
            z = false;
        }
        state.f7220k = z;
        state.f7214e = 4;
        m1693O(true);
        m1709e0(false);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        ViewHolder m1672F = m1672F(view);
        if (m1672F != null) {
            if (m1672F.m1764i()) {
                m1672F.f7236i &= -257;
            } else if (!m1672F.m1768m()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(m1672F);
                throw new IllegalArgumentException(AbstractC1726qj.m7056l(this, sb));
            }
        } else if (f7065C0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(AbstractC1726qj.m7056l(this, sb2));
        }
        view.clearAnimation();
        m1716o(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        boolean z;
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f7132q;
        arrayList.remove(itemDecoration);
        if (arrayList.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z = true;
            } else {
                z = false;
            }
            setWillNotDraw(z);
        }
        m1689K();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        ArrayList arrayList = this.f7080D;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.f7134r.remove(onItemTouchListener);
        if (this.f7136s == onItemTouchListener) {
            this.f7136s = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        ArrayList arrayList = this.f7121k0;
        if (arrayList != null) {
            arrayList.remove(onScrollListener);
        }
    }

    public void removeRecyclerListener(@NonNull RecyclerListener recyclerListener) {
        this.f7130p.remove(recyclerListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f7126n.onRequestChildFocus(this, this.f7117i0, view, view2) && view2 != null) {
            m1701W(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f7126n.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.f7134r;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((OnItemTouchListener) arrayList.get(i)).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f7144w == 0 && !this.f7148y) {
            super.requestLayout();
        } else {
            this.f7146x = true;
        }
    }

    /* renamed from: s */
    public final void m1720s(int i, int i2) {
        this.f7084H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.f7119j0;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        ArrayList arrayList = this.f7121k0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.f7121k0.get(size)).onScrolled(this, i, i2);
            }
        }
        this.f7084H--;
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f7148y) {
            return;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.f7126n.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i = 0;
            }
            if (!canScrollVertically) {
                i2 = 0;
            }
            m1703Y(i, i2, null, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (this.f7148y) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i;
        if (isComputingLayout()) {
            int i2 = 0;
            if (accessibilityEvent != null) {
                i = AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent);
            } else {
                i = 0;
            }
            if (i != 0) {
                i2 = i;
            }
            this.f7075A |= i2;
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f7131p0 = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        m1705a0(adapter, false, true);
        m1697S(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        boolean z;
        if (childDrawingOrderCallback == this.f7133q0) {
            return;
        }
        this.f7133q0 = childDrawingOrderCallback;
        if (childDrawingOrderCallback != null) {
            z = true;
        } else {
            z = false;
        }
        setChildrenDrawingOrderEnabled(z);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f7114h) {
            this.f7089M = null;
            this.f7087K = null;
            this.f7088L = null;
            this.f7086J = null;
        }
        this.f7114h = z;
        super.setClipToPadding(z);
        if (this.f7142v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.f7085I = edgeEffectFactory;
        this.f7089M = null;
        this.f7087K = null;
        this.f7088L = null;
        this.f7086J = null;
    }

    public void setHasFixedSize(boolean z) {
        this.f7140u = z;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.f7090N;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.f7090N.f7156a = null;
        }
        this.f7090N = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.f7156a = this.f7127n0;
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f7104c.setViewCacheSize(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (layoutManager == this.f7126n) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager2 = this.f7126n;
        Recycler recycler = this.f7104c;
        if (layoutManager2 != null) {
            ItemAnimator itemAnimator = this.f7090N;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.f7126n.removeAndRecycleAllViews(recycler);
            this.f7126n.m1732d(recycler);
            recycler.clear();
            if (this.f7138t) {
                LayoutManager layoutManager3 = this.f7126n;
                layoutManager3.f7168g = false;
                layoutManager3.onDetachedFromWindow(this, recycler);
            }
            this.f7126n.m1737i(null);
            this.f7126n = null;
        } else {
            recycler.clear();
        }
        C0474g c0474g = this.f7110f;
        c0474g.f7376b.m8143g();
        ArrayList arrayList = c0474g.f7377c;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = c0474g.f7375a.f7466a;
            if (size < 0) {
                break;
            }
            ViewHolder m1672F = m1672F((View) arrayList.get(size));
            if (m1672F != null) {
                int i = m1672F.f7242o;
                if (recyclerView.isComputingLayout()) {
                    m1672F.f7243p = i;
                    recyclerView.f7145w0.add(m1672F);
                } else {
                    ViewCompat.setImportantForAccessibility(m1672F.itemView, i);
                }
                m1672F.f7242o = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.m1716o(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f7126n = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.f7163b == null) {
                layoutManager.m1737i(this);
                if (this.f7138t) {
                    LayoutManager layoutManager4 = this.f7126n;
                    layoutManager4.f7168g = true;
                    layoutManager4.onAttachedToWindow(this);
                }
            } else {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(layoutManager);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(AbstractC1726qj.m7056l(layoutManager.f7163b, sb));
            }
        }
        recycler.m1752l();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.f7099W = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.f7119j0 = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f7109e0 = z;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        Recycler recycler = this.f7104c;
        RecyclerView recyclerView = RecyclerView.this;
        recycler.m1744d(recyclerView.f7124m, false);
        if (recycler.f7191g != null) {
            r2.f7183b--;
        }
        recycler.f7191g = recycledViewPool;
        if (recycledViewPool != null && recyclerView.getAdapter() != null) {
            recycler.f7191g.f7183b++;
        }
        recycler.m1743c();
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.f7128o = recyclerListener;
    }

    public void setScrollState(int i) {
        SmoothScroller smoothScroller;
        if (i == this.f7091O) {
            return;
        }
        if (f7066D0) {
            StringBuilder m8299s = ye0.m8299s(i, "setting scroll state to ", " from ");
            m8299s.append(this.f7091O);
            Log.d("RecyclerView", m8299s.toString(), new Exception());
        }
        this.f7091O = i;
        if (i != 2) {
            RunnableC0461b1 runnableC0461b1 = this.f7111f0;
            runnableC0461b1.f7328g.removeCallbacks(runnableC0461b1);
            runnableC0461b1.f7324c.abortAnimation();
            LayoutManager layoutManager = this.f7126n;
            if (layoutManager != null && (smoothScroller = layoutManager.f7166e) != null) {
                smoothScroller.stop();
            }
        }
        LayoutManager layoutManager2 = this.f7126n;
        if (layoutManager2 != null) {
            layoutManager2.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.f7119j0;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        ArrayList arrayList = this.f7121k0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.f7121k0.get(size)).onScrollStateChanged(this, i);
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.f7098V = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f7098V = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.f7104c.f7192h = viewCacheExtension;
    }

    public void smoothScrollBy(@Px int i, @Px int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollToPosition(int i) {
        if (this.f7148y) {
            return;
        }
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.f7117i0, i);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        SmoothScroller smoothScroller;
        setScrollState(0);
        RunnableC0461b1 runnableC0461b1 = this.f7111f0;
        runnableC0461b1.f7328g.removeCallbacks(runnableC0461b1);
        runnableC0461b1.f7324c.abortAnimation();
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null && (smoothScroller = layoutManager.f7166e) != null) {
            smoothScroller.stop();
        }
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.f7148y) {
            m1711h("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.f7148y = false;
                if (this.f7146x && this.f7126n != null && this.f7124m != null) {
                    requestLayout();
                }
                this.f7146x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, f7068F0, f7068F0, 0));
            this.f7148y = true;
            this.f7150z = true;
            stopScroll();
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        m1705a0(adapter, true, z);
        m1697S(true);
        requestLayout();
    }

    /* renamed from: t */
    public final void m1721t() {
        if (this.f7089M != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.f7085I.createEdgeEffect(this, 3);
        this.f7089M = createEdgeEffect;
        if (this.f7114h) {
            createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* renamed from: u */
    public final void m1722u() {
        if (this.f7086J != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.f7085I.createEdgeEffect(this, 0);
        this.f7086J = createEdgeEffect;
        if (this.f7114h) {
            createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* renamed from: v */
    public final void m1723v() {
        if (this.f7088L != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.f7085I.createEdgeEffect(this, 2);
        this.f7088L = createEdgeEffect;
        if (this.f7114h) {
            createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* renamed from: w */
    public final void m1724w() {
        if (this.f7087K != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.f7085I.createEdgeEffect(this, 1);
        this.f7087K = createEdgeEffect;
        if (this.f7114h) {
            createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* renamed from: x */
    public final String m1725x() {
        return " " + super.toString() + ", adapter:" + this.f7124m + ", layout:" + this.f7126n + ", context:" + getContext();
    }

    /* renamed from: y */
    public final void m1726y(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f7111f0.f7324c;
            state.f7225p = overScroller.getFinalX() - overScroller.getCurrX();
            state.f7226q = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            state.f7225p = 0;
            state.f7226q = 0;
        }
    }

    /* renamed from: z */
    public final boolean m1727z(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.f7134r;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = (OnItemTouchListener) arrayList.get(i);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.f7136s = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        char c;
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        this.f7102b = new C0517y0(this);
        this.f7104c = new Recycler();
        this.f7112g = new C0488k1();
        this.f7116i = new sn1(5, this);
        this.f7118j = new Rect();
        this.f7120k = new Rect();
        this.f7122l = new RectF();
        this.f7130p = new ArrayList();
        this.f7132q = new ArrayList();
        this.f7134r = new ArrayList();
        this.f7144w = 0;
        this.f7081E = false;
        this.f7082F = false;
        this.f7083G = 0;
        this.f7084H = 0;
        this.f7085I = f7074L0;
        this.f7090N = new DefaultItemAnimator();
        this.f7091O = 0;
        this.f7092P = -1;
        this.f7105c0 = Float.MIN_VALUE;
        this.f7107d0 = Float.MIN_VALUE;
        this.f7109e0 = true;
        this.f7111f0 = new RunnableC0461b1(this);
        this.f7115h0 = f7071I0 ? new Object() : null;
        this.f7117i0 = new State();
        this.f7123l0 = false;
        this.f7125m0 = false;
        C0509u0 c0509u0 = new C0509u0(this);
        this.f7127n0 = c0509u0;
        this.f7129o0 = false;
        this.f7135r0 = new int[2];
        this.f7139t0 = new int[2];
        this.f7141u0 = new int[2];
        this.f7143v0 = new int[2];
        this.f7145w0 = new ArrayList();
        this.f7147x0 = new RunnableC0497o0(this);
        this.f7151z0 = 0;
        this.f7076A0 = 0;
        this.f7078B0 = new C0499p0(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7098V = viewConfiguration.getScaledTouchSlop();
        this.f7105c0 = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.f7107d0 = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.f7101a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7103b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7100a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.f7090N.f7156a = c0509u0;
        this.f7108e = new C0456a(new C0503r0(this));
        this.f7110f = new C0474g(new C0501q0(this));
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.f7079C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = androidx.recyclerview.R.styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        String string = obtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f7114h = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        if (obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
                Resources resources = getContext().getResources();
                c = 2;
                new C0504s(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
            } else {
                throw new IllegalArgumentException(AbstractC1726qj.m7056l(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
        } else {
            c = 2;
        }
        obtainStyledAttributes.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                String str = trim;
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(str, false, classLoader).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(f7072J0);
                        objArr = new Object[4];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[c] = Integer.valueOf(i);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = asSubclass.getConstructor(null);
                            objArr = null;
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                }
            }
        }
        int[] iArr2 = f7067E0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr2, attributeSet, obtainStyledAttributes2, i, 0);
        boolean z = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z);
        PoolingContainer.setPoolingContainer(this, true);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator, int i3) {
        m1707c0(i, i2, interpolator, i3, false);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public ViewHolder f7178a;

        /* renamed from: b */
        public final Rect f7179b;

        /* renamed from: c */
        public boolean f7180c;

        /* renamed from: d */
        public boolean f7181d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7179b = new Rect();
            this.f7180c = true;
            this.f7181d = false;
        }

        public int getAbsoluteAdapterPosition() {
            return this.f7178a.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.f7178a.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.f7178a.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.f7178a.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.f7178a.getPosition();
        }

        public boolean isItemChanged() {
            return this.f7178a.m1765j();
        }

        public boolean isItemRemoved() {
            return this.f7178a.m1762g();
        }

        public boolean isViewInvalid() {
            return this.f7178a.m1761f();
        }

        public boolean viewNeedsUpdate() {
            if ((this.f7178a.f7236i & 2) != 0) {
                return true;
            }
            return false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f7179b = new Rect();
            this.f7180c = true;
            this.f7181d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7179b = new Rect();
            this.f7180c = true;
            this.f7181d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7179b = new Rect();
            this.f7180c = true;
            this.f7181d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f7179b = new Rect();
            this.f7180c = true;
            this.f7181d = false;
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.f7126n;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(AbstractC1726qj.m7056l(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
