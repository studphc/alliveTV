package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;
import java.util.List;
import p000.AbstractC1726qj;
import p000.m51;

/* loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;

    /* renamed from: UP */
    public static final int f7002UP = 1;

    /* renamed from: A */
    public Rect f7003A;

    /* renamed from: B */
    public long f7004B;

    /* renamed from: d */
    public float f7008d;

    /* renamed from: e */
    public float f7009e;

    /* renamed from: f */
    public float f7010f;

    /* renamed from: g */
    public float f7011g;

    /* renamed from: h */
    public float f7012h;

    /* renamed from: i */
    public float f7013i;

    /* renamed from: j */
    public float f7014j;

    /* renamed from: k */
    public float f7015k;

    /* renamed from: m */
    public final Callback f7017m;

    /* renamed from: o */
    public int f7019o;

    /* renamed from: q */
    public int f7021q;

    /* renamed from: r */
    public RecyclerView f7022r;

    /* renamed from: t */
    public VelocityTracker f7024t;

    /* renamed from: u */
    public ArrayList f7025u;

    /* renamed from: v */
    public ArrayList f7026v;

    /* renamed from: x */
    public GestureDetectorCompat f7028x;

    /* renamed from: y */
    public C0460b0 f7029y;

    /* renamed from: a */
    public final ArrayList f7005a = new ArrayList();

    /* renamed from: b */
    public final float[] f7006b = new float[2];

    /* renamed from: c */
    public RecyclerView.ViewHolder f7007c = null;

    /* renamed from: l */
    public int f7016l = -1;

    /* renamed from: n */
    public int f7018n = 0;

    /* renamed from: p */
    public final ArrayList f7020p = new ArrayList();

    /* renamed from: s */
    public final RunnableC0510v f7023s = new RunnableC0510v(this);

    /* renamed from: w */
    public View f7027w = null;

    /* renamed from: z */
    public final C0512w f7030z = new C0512w(this);

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        /* renamed from: b */
        public static final InterpolatorC0518z f7031b = new Object();

        /* renamed from: c */
        public static final InterpolatorC0457a0 f7032c = new Object();

        /* renamed from: a */
        public int f7033a = -1;

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return m51.f22805a;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag(0, i2 | i);
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i, int i2) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = viewHolder.itemView.getWidth() + i;
            int height = viewHolder.itemView.getHeight() + i2;
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i4);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i2) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs;
                }
            }
            return viewHolder2;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            int i = R.id.item_touch_helper_previous_elevation;
            Object tag = view.getTag(i);
            if (tag instanceof Float) {
                ViewCompat.setElevation(view, ((Float) tag).floatValue());
            }
            view.setTag(i, null);
            view.setTranslationX(RecyclerView.f7068F0);
            view.setTranslationY(RecyclerView.f7068F0);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                if (i == 8) {
                    return 200L;
                }
                return 250L;
            }
            if (i == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i, int i2, int i3, long j) {
            if (this.f7033a == -1) {
                this.f7033a = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            int i4 = this.f7033a;
            int abs = Math.abs(i2);
            int signum = (int) Math.signum(i2);
            float f = 1.0f;
            int interpolation = (int) (f7032c.getInterpolation(Math.min(1.0f, (abs * 1.0f) / i)) * signum * i4);
            if (j <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation2 = (int) (f7031b.getInterpolation(f) * interpolation);
            if (interpolation2 == 0) {
                if (i2 <= 0) {
                    return -1;
                }
                return 1;
            }
            return interpolation2;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            View view = viewHolder.itemView;
            if (z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
                int childCount = recyclerView.getChildCount();
                float f3 = RecyclerView.f7068F0;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt != view) {
                        float elevation = ViewCompat.getElevation(childAt);
                        if (elevation > f3) {
                            f3 = elevation;
                        }
                    }
                }
                ViewCompat.setElevation(view, f3 + 1.0f);
                view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
            }
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @SuppressLint({"UnknownNullness"}) RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            View view = viewHolder.itemView;
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i);
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleCallback extends Callback {

        /* renamed from: d */
        public int f7034d;

        /* renamed from: e */
        public int f7035e;

        public SimpleCallback(int i, int i2) {
            this.f7034d = i2;
            this.f7035e = i;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f7035e;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f7034d;
        }

        public void setDefaultDragDirs(int i) {
            this.f7035e = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.f7034d = i;
        }
    }

    /* loaded from: classes.dex */
    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.f7017m = callback;
    }

    /* renamed from: g */
    public static boolean m1630g(View view, float f, float f2, float f3, float f4) {
        if (f >= f3 && f <= f3 + view.getWidth() && f2 >= f4 && f2 <= f4 + view.getHeight()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final int m1631a(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        if ((i & 12) != 0) {
            int i3 = 4;
            if (this.f7012h > RecyclerView.f7068F0) {
                i2 = 8;
            } else {
                i2 = 4;
            }
            VelocityTracker velocityTracker = this.f7024t;
            Callback callback = this.f7017m;
            if (velocityTracker != null && this.f7016l > -1) {
                velocityTracker.computeCurrentVelocity(1000, callback.getSwipeVelocityThreshold(this.f7011g));
                float xVelocity = this.f7024t.getXVelocity(this.f7016l);
                float yVelocity = this.f7024t.getYVelocity(this.f7016l);
                if (xVelocity > RecyclerView.f7068F0) {
                    i3 = 8;
                }
                float abs = Math.abs(xVelocity);
                if ((i3 & i) != 0 && i2 == i3 && abs >= callback.getSwipeEscapeVelocity(this.f7010f) && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
            float swipeThreshold = callback.getSwipeThreshold(viewHolder) * this.f7022r.getWidth();
            if ((i & i2) != 0 && Math.abs(this.f7012h) > swipeThreshold) {
                return i2;
            }
            return 0;
        }
        return 0;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f7022r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        C0512w c0512w = this.f7030z;
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.f7022r.removeOnItemTouchListener(c0512w);
            this.f7022r.removeOnChildAttachStateChangeListener(this);
            ArrayList arrayList = this.f7020p;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                AbstractC0466d0 abstractC0466d0 = (AbstractC0466d0) arrayList.get(0);
                abstractC0466d0.f7343g.cancel();
                this.f7017m.clearView(this.f7022r, abstractC0466d0.f7341e);
            }
            arrayList.clear();
            this.f7027w = null;
            VelocityTracker velocityTracker = this.f7024t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f7024t = null;
            }
            C0460b0 c0460b0 = this.f7029y;
            if (c0460b0 != null) {
                c0460b0.f7320a = false;
                this.f7029y = null;
            }
            if (this.f7028x != null) {
                this.f7028x = null;
            }
        }
        this.f7022r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f7010f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.f7011g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            this.f7021q = ViewConfiguration.get(this.f7022r.getContext()).getScaledTouchSlop();
            this.f7022r.addItemDecoration(this);
            this.f7022r.addOnItemTouchListener(c0512w);
            this.f7022r.addOnChildAttachStateChangeListener(this);
            this.f7029y = new C0460b0(this);
            this.f7028x = new GestureDetectorCompat(this.f7022r.getContext(), this.f7029y);
        }
    }

    /* renamed from: b */
    public final void m1632b(MotionEvent motionEvent, int i, int i2) {
        View m1635e;
        if (this.f7007c == null && i == 2 && this.f7018n != 2) {
            Callback callback = this.f7017m;
            if (!callback.isItemViewSwipeEnabled() || this.f7022r.getScrollState() == 1) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = this.f7022r.getLayoutManager();
            int i3 = this.f7016l;
            RecyclerView.ViewHolder viewHolder = null;
            if (i3 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i3);
                float x = motionEvent.getX(findPointerIndex) - this.f7008d;
                float y = motionEvent.getY(findPointerIndex) - this.f7009e;
                float abs = Math.abs(x);
                float abs2 = Math.abs(y);
                float f = this.f7021q;
                if ((abs >= f || abs2 >= f) && ((abs <= abs2 || !layoutManager.canScrollHorizontally()) && ((abs2 <= abs || !layoutManager.canScrollVertically()) && (m1635e = m1635e(motionEvent)) != null))) {
                    viewHolder = this.f7022r.getChildViewHolder(m1635e);
                }
            }
            if (viewHolder == null) {
                return;
            }
            RecyclerView recyclerView = this.f7022r;
            int convertToAbsoluteDirection = (callback.convertToAbsoluteDirection(callback.getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            if (convertToAbsoluteDirection == 0) {
                return;
            }
            float x2 = motionEvent.getX(i2);
            float y2 = motionEvent.getY(i2);
            float f2 = x2 - this.f7008d;
            float f3 = y2 - this.f7009e;
            float abs3 = Math.abs(f2);
            float abs4 = Math.abs(f3);
            float f4 = this.f7021q;
            if (abs3 < f4 && abs4 < f4) {
                return;
            }
            if (abs3 > abs4) {
                if (f2 < RecyclerView.f7068F0 && (convertToAbsoluteDirection & 4) == 0) {
                    return;
                }
                if (f2 > RecyclerView.f7068F0 && (convertToAbsoluteDirection & 8) == 0) {
                    return;
                }
            } else {
                if (f3 < RecyclerView.f7068F0 && (convertToAbsoluteDirection & 1) == 0) {
                    return;
                }
                if (f3 > RecyclerView.f7068F0 && (convertToAbsoluteDirection & 2) == 0) {
                    return;
                }
            }
            this.f7013i = RecyclerView.f7068F0;
            this.f7012h = RecyclerView.f7068F0;
            this.f7016l = motionEvent.getPointerId(0);
            m1639j(viewHolder, 1);
        }
    }

    /* renamed from: c */
    public final int m1633c(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        if ((i & 3) != 0) {
            int i3 = 1;
            if (this.f7013i > RecyclerView.f7068F0) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            VelocityTracker velocityTracker = this.f7024t;
            Callback callback = this.f7017m;
            if (velocityTracker != null && this.f7016l > -1) {
                velocityTracker.computeCurrentVelocity(1000, callback.getSwipeVelocityThreshold(this.f7011g));
                float xVelocity = this.f7024t.getXVelocity(this.f7016l);
                float yVelocity = this.f7024t.getYVelocity(this.f7016l);
                if (yVelocity > RecyclerView.f7068F0) {
                    i3 = 2;
                }
                float abs = Math.abs(yVelocity);
                if ((i3 & i) != 0 && i3 == i2 && abs >= callback.getSwipeEscapeVelocity(this.f7010f) && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
            float swipeThreshold = callback.getSwipeThreshold(viewHolder) * this.f7022r.getHeight();
            if ((i & i2) != 0 && Math.abs(this.f7013i) > swipeThreshold) {
                return i2;
            }
            return 0;
        }
        return 0;
    }

    /* renamed from: d */
    public final void m1634d(RecyclerView.ViewHolder viewHolder, boolean z) {
        ArrayList arrayList = this.f7020p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractC0466d0 abstractC0466d0 = (AbstractC0466d0) arrayList.get(size);
            if (abstractC0466d0.f7341e == viewHolder) {
                abstractC0466d0.f7347k |= z;
                if (!abstractC0466d0.f7348l) {
                    abstractC0466d0.f7343g.cancel();
                }
                arrayList.remove(size);
                return;
            }
        }
    }

    /* renamed from: e */
    public final View m1635e(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f7007c;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (m1630g(view, x, y, this.f7014j + this.f7012h, this.f7015k + this.f7013i)) {
                return view;
            }
        }
        ArrayList arrayList = this.f7020p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractC0466d0 abstractC0466d0 = (AbstractC0466d0) arrayList.get(size);
            View view2 = abstractC0466d0.f7341e.itemView;
            if (m1630g(view2, x, y, abstractC0466d0.f7345i, abstractC0466d0.f7346j)) {
                return view2;
            }
        }
        return this.f7022r.findChildViewUnder(x, y);
    }

    /* renamed from: f */
    public final void m1636f(float[] fArr) {
        if ((this.f7019o & 12) != 0) {
            fArr[0] = (this.f7014j + this.f7012h) - this.f7007c.itemView.getLeft();
        } else {
            fArr[0] = this.f7007c.itemView.getTranslationX();
        }
        if ((this.f7019o & 3) != 0) {
            fArr[1] = (this.f7015k + this.f7013i) - this.f7007c.itemView.getTop();
        } else {
            fArr[1] = this.f7007c.itemView.getTranslationY();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    /* renamed from: h */
    public final void m1637h(RecyclerView.ViewHolder viewHolder) {
        int i;
        int i2;
        int i3;
        if (this.f7022r.isLayoutRequested() || this.f7018n != 2) {
            return;
        }
        Callback callback = this.f7017m;
        float moveThreshold = callback.getMoveThreshold(viewHolder);
        int i4 = (int) (this.f7014j + this.f7012h);
        int i5 = (int) (this.f7015k + this.f7013i);
        if (Math.abs(i5 - viewHolder.itemView.getTop()) < viewHolder.itemView.getHeight() * moveThreshold && Math.abs(i4 - viewHolder.itemView.getLeft()) < viewHolder.itemView.getWidth() * moveThreshold) {
            return;
        }
        ArrayList arrayList = this.f7025u;
        if (arrayList == null) {
            this.f7025u = new ArrayList();
            this.f7026v = new ArrayList();
        } else {
            arrayList.clear();
            this.f7026v.clear();
        }
        int boundingBoxMargin = callback.getBoundingBoxMargin();
        int round = Math.round(this.f7014j + this.f7012h) - boundingBoxMargin;
        int round2 = Math.round(this.f7015k + this.f7013i) - boundingBoxMargin;
        int i6 = boundingBoxMargin * 2;
        int width = viewHolder.itemView.getWidth() + round + i6;
        int height = viewHolder.itemView.getHeight() + round2 + i6;
        int i7 = (round + width) / 2;
        int i8 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f7022r.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = layoutManager.getChildAt(i9);
            if (childAt == viewHolder.itemView || childAt.getBottom() < round2 || childAt.getTop() > height || childAt.getRight() < round || childAt.getLeft() > width) {
                i3 = i7;
                i = round;
                i2 = round2;
            } else {
                RecyclerView.ViewHolder childViewHolder = this.f7022r.getChildViewHolder(childAt);
                i = round;
                i2 = round2;
                if (callback.canDropOver(this.f7022r, this.f7007c, childViewHolder)) {
                    int abs = Math.abs(i7 - ((childAt.getRight() + childAt.getLeft()) / 2));
                    int abs2 = Math.abs(i8 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int i10 = (abs2 * abs2) + (abs * abs);
                    int size = this.f7025u.size();
                    i3 = i7;
                    int i11 = 0;
                    int i12 = 0;
                    while (i12 < size) {
                        int i13 = size;
                        if (i10 <= ((Integer) this.f7026v.get(i12)).intValue()) {
                            break;
                        }
                        i11++;
                        i12++;
                        size = i13;
                    }
                    this.f7025u.add(i11, childViewHolder);
                    this.f7026v.add(i11, Integer.valueOf(i10));
                } else {
                    i3 = i7;
                }
            }
            i9++;
            round = i;
            round2 = i2;
            i7 = i3;
        }
        ArrayList arrayList2 = this.f7025u;
        if (arrayList2.size() == 0) {
            return;
        }
        RecyclerView.ViewHolder chooseDropTarget = callback.chooseDropTarget(viewHolder, arrayList2, i4, i5);
        if (chooseDropTarget == null) {
            this.f7025u.clear();
            this.f7026v.clear();
            return;
        }
        int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
        int absoluteAdapterPosition2 = viewHolder.getAbsoluteAdapterPosition();
        if (callback.onMove(this.f7022r, viewHolder, chooseDropTarget)) {
            this.f7017m.onMoved(this.f7022r, viewHolder, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, i4, i5);
        }
    }

    /* renamed from: i */
    public final void m1638i(View view) {
        if (view == this.f7027w) {
            this.f7027w = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0093, code lost:
    
        if (r2 > 0) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b0  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1639j(RecyclerView.ViewHolder viewHolder, int i) {
        Callback callback;
        boolean z;
        boolean z2;
        ViewParent parent;
        boolean z3;
        RecyclerView.ViewHolder viewHolder2;
        int m1633c;
        int i2;
        float f;
        float signum;
        int i3;
        if (viewHolder == this.f7007c && i == this.f7018n) {
            return;
        }
        this.f7004B = Long.MIN_VALUE;
        int i4 = this.f7018n;
        m1634d(viewHolder, true);
        this.f7018n = i;
        if (i == 2) {
            if (viewHolder != null) {
                this.f7027w = viewHolder.itemView;
            } else {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
        }
        int i5 = (1 << ((i * 8) + 8)) - 1;
        RecyclerView.ViewHolder viewHolder3 = this.f7007c;
        Callback callback2 = this.f7017m;
        if (viewHolder3 != null) {
            if (viewHolder3.itemView.getParent() != null) {
                if (i4 == 2) {
                    i2 = 0;
                } else {
                    if (this.f7018n != 2) {
                        int movementFlags = callback2.getMovementFlags(this.f7022r, viewHolder3);
                        int convertToAbsoluteDirection = (callback2.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.f7022r)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                        if (convertToAbsoluteDirection != 0) {
                            int i6 = (movementFlags & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (Math.abs(this.f7012h) > Math.abs(this.f7013i)) {
                                m1633c = m1631a(viewHolder3, convertToAbsoluteDirection);
                                if (m1633c > 0) {
                                    if ((i6 & m1633c) == 0) {
                                        m1633c = Callback.convertToRelativeDirection(m1633c, ViewCompat.getLayoutDirection(this.f7022r));
                                    }
                                } else {
                                    m1633c = m1633c(viewHolder3, convertToAbsoluteDirection);
                                }
                                i2 = m1633c;
                            } else {
                                m1633c = m1633c(viewHolder3, convertToAbsoluteDirection);
                                if (m1633c <= 0) {
                                    m1633c = m1631a(viewHolder3, convertToAbsoluteDirection);
                                    if (m1633c > 0) {
                                        if ((i6 & m1633c) == 0) {
                                            m1633c = Callback.convertToRelativeDirection(m1633c, ViewCompat.getLayoutDirection(this.f7022r));
                                        }
                                    }
                                }
                                i2 = m1633c;
                            }
                        }
                    }
                    m1633c = 0;
                    i2 = m1633c;
                }
                VelocityTracker velocityTracker = this.f7024t;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f7024t = null;
                }
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 4 && i2 != 8 && i2 != 16 && i2 != 32) {
                        f = 0.0f;
                        signum = 0.0f;
                    } else {
                        signum = 0.0f;
                        f = Math.signum(this.f7012h) * this.f7022r.getWidth();
                    }
                } else {
                    f = 0.0f;
                    signum = Math.signum(this.f7013i) * this.f7022r.getHeight();
                }
                if (i4 == 2) {
                    i3 = 8;
                } else if (i2 > 0) {
                    i3 = 2;
                } else {
                    i3 = 4;
                }
                float[] fArr = this.f7006b;
                m1636f(fArr);
                float f2 = fArr[0];
                float f3 = fArr[1];
                int i7 = i3;
                callback = callback2;
                C0514x c0514x = new C0514x(this, viewHolder3, i7, i4, f2, f3, f, signum, i2, viewHolder3);
                long animationDuration = callback.getAnimationDuration(this.f7022r, i7, f - f2, signum - f3);
                ValueAnimator valueAnimator = c0514x.f7343g;
                valueAnimator.setDuration(animationDuration);
                this.f7020p.add(c0514x);
                viewHolder3.setIsRecyclable(false);
                valueAnimator.start();
                viewHolder2 = null;
                z = true;
            } else {
                callback = callback2;
                m1638i(viewHolder3.itemView);
                callback.clearView(this.f7022r, viewHolder3);
                viewHolder2 = null;
                z = false;
            }
            this.f7007c = viewHolder2;
        } else {
            callback = callback2;
            z = false;
        }
        if (viewHolder != null) {
            RecyclerView recyclerView = this.f7022r;
            this.f7019o = (callback.convertToAbsoluteDirection(callback.getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView)) & i5) >> (this.f7018n * 8);
            this.f7014j = viewHolder.itemView.getLeft();
            this.f7015k = viewHolder.itemView.getTop();
            this.f7007c = viewHolder;
            if (i == 2) {
                z2 = false;
                viewHolder.itemView.performHapticFeedback(0);
                parent = this.f7022r.getParent();
                if (parent != null) {
                    if (this.f7007c != null) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    parent.requestDisallowInterceptTouchEvent(z3);
                }
                if (!z) {
                    this.f7022r.getLayoutManager().requestSimpleAnimationsInNextLayout();
                }
                callback.onSelectedChanged(this.f7007c, this.f7018n);
                this.f7022r.invalidate();
            }
        }
        z2 = false;
        parent = this.f7022r.getParent();
        if (parent != null) {
        }
        if (!z) {
        }
        callback.onSelectedChanged(this.f7007c, this.f7018n);
        this.f7022r.invalidate();
    }

    /* renamed from: k */
    public final void m1640k(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.f7008d;
        this.f7012h = f;
        this.f7013i = y - this.f7009e;
        if ((i & 4) == 0) {
            this.f7012h = Math.max(RecyclerView.f7068F0, f);
        }
        if ((i & 8) == 0) {
            this.f7012h = Math.min(RecyclerView.f7068F0, this.f7012h);
        }
        if ((i & 1) == 0) {
            this.f7013i = Math.max(RecyclerView.f7068F0, this.f7013i);
        }
        if ((i & 2) == 0) {
            this.f7013i = Math.min(RecyclerView.f7068F0, this.f7013i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        m1638i(view);
        RecyclerView.ViewHolder childViewHolder = this.f7022r.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.f7007c;
        if (viewHolder != null && childViewHolder == viewHolder) {
            m1639j(null, 0);
            return;
        }
        m1634d(childViewHolder, false);
        if (this.f7005a.remove(childViewHolder.itemView)) {
            this.f7017m.clearView(this.f7022r, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        if (this.f7007c != null) {
            float[] fArr = this.f7006b;
            m1636f(fArr);
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        RecyclerView.ViewHolder viewHolder = this.f7007c;
        ArrayList arrayList = this.f7020p;
        int i = this.f7018n;
        Callback callback = this.f7017m;
        callback.getClass();
        int i2 = 0;
        for (int size = arrayList.size(); i2 < size; size = size) {
            AbstractC0466d0 abstractC0466d0 = (AbstractC0466d0) arrayList.get(i2);
            float f4 = abstractC0466d0.f7337a;
            float f5 = abstractC0466d0.f7339c;
            RecyclerView.ViewHolder viewHolder2 = abstractC0466d0.f7341e;
            if (f4 == f5) {
                abstractC0466d0.f7345i = viewHolder2.itemView.getTranslationX();
            } else {
                abstractC0466d0.f7345i = AbstractC1726qj.m7051g(f5, f4, abstractC0466d0.f7349m, f4);
            }
            float f6 = abstractC0466d0.f7338b;
            float f7 = abstractC0466d0.f7340d;
            if (f6 == f7) {
                abstractC0466d0.f7346j = viewHolder2.itemView.getTranslationY();
            } else {
                abstractC0466d0.f7346j = AbstractC1726qj.m7051g(f7, f6, abstractC0466d0.f7349m, f6);
            }
            int save = canvas.save();
            callback.onChildDraw(canvas, recyclerView, abstractC0466d0.f7341e, abstractC0466d0.f7345i, abstractC0466d0.f7346j, abstractC0466d0.f7342f, false);
            canvas.restoreToCount(save);
            i2++;
        }
        if (viewHolder != null) {
            int save2 = canvas.save();
            callback.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
            canvas.restoreToCount(save2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        float f;
        float f2;
        if (this.f7007c != null) {
            float[] fArr = this.f7006b;
            m1636f(fArr);
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        RecyclerView.ViewHolder viewHolder = this.f7007c;
        ArrayList arrayList = this.f7020p;
        int i = this.f7018n;
        Callback callback = this.f7017m;
        callback.getClass();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            AbstractC0466d0 abstractC0466d0 = (AbstractC0466d0) arrayList.get(i2);
            int save = canvas.save();
            callback.onChildDrawOver(canvas, recyclerView, abstractC0466d0.f7341e, abstractC0466d0.f7345i, abstractC0466d0.f7346j, abstractC0466d0.f7342f, false);
            canvas.restoreToCount(save);
            i2++;
            callback = callback;
            i = i;
            size = size;
        }
        int i3 = size;
        Callback callback2 = callback;
        int i4 = i;
        if (viewHolder != null) {
            int save2 = canvas.save();
            callback2.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i4, true);
            canvas.restoreToCount(save2);
        }
        boolean z = false;
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            AbstractC0466d0 abstractC0466d02 = (AbstractC0466d0) arrayList.get(i5);
            boolean z2 = abstractC0466d02.f7348l;
            if (z2 && !abstractC0466d02.f7344h) {
                arrayList.remove(i5);
            } else if (!z2) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        boolean z;
        Callback callback = this.f7017m;
        RecyclerView recyclerView = this.f7022r;
        if ((callback.convertToAbsoluteDirection(callback.getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView)) & 16711680) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.f7022r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        VelocityTracker velocityTracker = this.f7024t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f7024t = VelocityTracker.obtain();
        this.f7013i = RecyclerView.f7068F0;
        this.f7012h = RecyclerView.f7068F0;
        m1639j(viewHolder, 2);
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        RecyclerView recyclerView = this.f7022r;
        Callback callback = this.f7017m;
        if ((callback.convertToAbsoluteDirection(callback.getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) != 0) {
            if (viewHolder.itemView.getParent() != this.f7022r) {
                Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
                return;
            }
            VelocityTracker velocityTracker = this.f7024t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.f7024t = VelocityTracker.obtain();
            this.f7013i = RecyclerView.f7068F0;
            this.f7012h = RecyclerView.f7068F0;
            m1639j(viewHolder, 1);
            return;
        }
        Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
    }
}
