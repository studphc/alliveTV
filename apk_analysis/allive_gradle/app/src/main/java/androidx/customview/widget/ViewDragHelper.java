package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p000.f92;
import p000.sn1;

/* loaded from: classes.dex */
public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: w */
    public static final f92 f4112w = new f92(1);

    /* renamed from: a */
    public int f4113a;

    /* renamed from: b */
    public int f4114b;

    /* renamed from: d */
    public float[] f4116d;

    /* renamed from: e */
    public float[] f4117e;

    /* renamed from: f */
    public float[] f4118f;

    /* renamed from: g */
    public float[] f4119g;

    /* renamed from: h */
    public int[] f4120h;

    /* renamed from: i */
    public int[] f4121i;

    /* renamed from: j */
    public int[] f4122j;

    /* renamed from: k */
    public int f4123k;

    /* renamed from: l */
    public VelocityTracker f4124l;

    /* renamed from: m */
    public final float f4125m;

    /* renamed from: n */
    public float f4126n;

    /* renamed from: o */
    public final int f4127o;

    /* renamed from: p */
    public int f4128p;

    /* renamed from: q */
    public final OverScroller f4129q;

    /* renamed from: r */
    public final Callback f4130r;

    /* renamed from: s */
    public View f4131s;

    /* renamed from: t */
    public boolean f4132t;

    /* renamed from: u */
    public final ViewGroup f4133u;

    /* renamed from: c */
    public int f4115c = -1;

    /* renamed from: v */
    public final sn1 f4134v = new sn1(14, this);

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(@NonNull View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(@NonNull View view, int i, int i2, @Px int i3, @Px int i4) {
        }

        public void onViewReleased(@NonNull View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i);
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup != null) {
            if (callback != null) {
                this.f4133u = viewGroup;
                this.f4130r = callback;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.f4127o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f4114b = viewConfiguration.getScaledTouchSlop();
                this.f4125m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f4126n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f4129q = new OverScroller(context, f4112w);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    /* renamed from: a */
    public final boolean m1034a(float f, int i, float f2, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f4120h[i] & i2) != i2 || (this.f4128p & i2) == 0 || (this.f4122j[i] & i2) == i2 || (this.f4121i[i] & i2) == i2) {
            return false;
        }
        float f3 = this.f4114b;
        if (abs <= f3 && abs2 <= f3) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f4130r.onEdgeLock(i2)) {
            int[] iArr = this.f4122j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        if ((this.f4121i[i] & i2) != 0 || abs <= this.f4114b) {
            return false;
        }
        return true;
    }

    public void abort() {
        cancel();
        if (this.f4113a == 2) {
            OverScroller overScroller = this.f4129q;
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            overScroller.abortAnimation();
            int currX2 = overScroller.getCurrX();
            int currY2 = overScroller.getCurrY();
            this.f4130r.onViewPositionChanged(this.f4131s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        m1044k(0);
    }

    /* renamed from: b */
    public final boolean m1035b(View view, float f, float f2) {
        boolean z;
        boolean z2;
        if (view == null) {
            return false;
        }
        Callback callback = this.f4130r;
        if (callback.getViewHorizontalDragRange(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (callback.getViewVerticalDragRange(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            float f3 = (f2 * f2) + (f * f);
            int i = this.f4114b;
            if (f3 <= i * i) {
                return false;
            }
            return true;
        }
        if (z) {
            if (Math.abs(f) <= this.f4114b) {
                return false;
            }
            return true;
        }
        if (!z2 || Math.abs(f2) <= this.f4114b) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final void m1036c(int i) {
        if (this.f4116d != null && isPointerDown(i)) {
            this.f4116d[i] = 0.0f;
            this.f4117e[i] = 0.0f;
            this.f4118f[i] = 0.0f;
            this.f4119g[i] = 0.0f;
            this.f4120h[i] = 0;
            this.f4121i[i] = 0;
            this.f4122j[i] = 0;
            this.f4123k = (~(1 << i)) & this.f4123k;
        }
    }

    public boolean canScroll(@NonNull View view, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z && (view.canScrollHorizontally(-i) || view.canScrollVertically(-i2))) {
            return true;
        }
        return false;
    }

    public void cancel() {
        this.f4115c = -1;
        float[] fArr = this.f4116d;
        if (fArr != null) {
            Arrays.fill(fArr, RecyclerView.f7068F0);
            Arrays.fill(this.f4117e, RecyclerView.f7068F0);
            Arrays.fill(this.f4118f, RecyclerView.f7068F0);
            Arrays.fill(this.f4119g, RecyclerView.f7068F0);
            Arrays.fill(this.f4120h, 0);
            Arrays.fill(this.f4121i, 0);
            Arrays.fill(this.f4122j, 0);
            this.f4123k = 0;
        }
        VelocityTracker velocityTracker = this.f4124l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4124l = null;
        }
    }

    public void captureChildView(@NonNull View view, int i) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f4133u;
        if (parent == viewGroup) {
            this.f4131s = view;
            this.f4115c = i;
            this.f4130r.onViewCaptured(view, i);
            m1044k(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f4116d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        if (this.f4113a == 2) {
            OverScroller overScroller = this.f4129q;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f4131s.getLeft();
            int top = currY - this.f4131s.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.f4131s, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.f4131s, top);
            }
            if (left != 0 || top != 0) {
                this.f4130r.onViewPositionChanged(this.f4131s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f4133u.post(this.f4134v);
                } else {
                    m1044k(0);
                }
            }
        }
        if (this.f4113a != 2) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public final int m1037d(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        float width = this.f4133u.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(sin / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m1038e(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.f4131s.getLeft();
        int top = this.f4131s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        OverScroller overScroller = this.f4129q;
        int i7 = 0;
        if (i5 == 0 && i6 == 0) {
            overScroller.abortAnimation();
            m1044k(0);
            return false;
        }
        View view = this.f4131s;
        int i8 = (int) this.f4126n;
        int i9 = (int) this.f4125m;
        int abs = Math.abs(i3);
        if (abs < i8) {
            i3 = 0;
        } else if (abs > i9) {
            if (i3 > 0) {
                i3 = i9;
            } else {
                i3 = -i9;
            }
        }
        int i10 = (int) this.f4126n;
        int abs2 = Math.abs(i4);
        if (abs2 >= i10) {
            if (abs2 > i9) {
                if (i4 > 0) {
                    i4 = i9;
                } else {
                    i7 = -i9;
                }
            }
            int abs3 = Math.abs(i5);
            int abs4 = Math.abs(i6);
            int abs5 = Math.abs(i3);
            int abs6 = Math.abs(i4);
            int i11 = abs5 + abs6;
            int i12 = abs3 + abs4;
            if (i3 == 0) {
                f = abs5;
                f2 = i11;
            } else {
                f = abs3;
                f2 = i12;
            }
            float f5 = f / f2;
            if (i4 == 0) {
                f3 = abs6;
                f4 = i11;
            } else {
                f3 = abs4;
                f4 = i12;
            }
            float f6 = f3 / f4;
            Callback callback = this.f4130r;
            overScroller.startScroll(left, top, i5, i6, (int) ((m1037d(i6, i4, callback.getViewVerticalDragRange(view)) * f6) + (m1037d(i5, i3, callback.getViewHorizontalDragRange(view)) * f5)));
            m1044k(2);
            return true;
        }
        i4 = i7;
        int abs32 = Math.abs(i5);
        int abs42 = Math.abs(i6);
        int abs52 = Math.abs(i3);
        int abs62 = Math.abs(i4);
        int i112 = abs52 + abs62;
        int i122 = abs32 + abs42;
        if (i3 == 0) {
        }
        float f52 = f / f2;
        if (i4 == 0) {
        }
        float f62 = f3 / f4;
        Callback callback2 = this.f4130r;
        overScroller.startScroll(left, top, i5, i6, (int) ((m1037d(i6, i4, callback2.getViewVerticalDragRange(view)) * f62) + (m1037d(i5, i3, callback2.getViewHorizontalDragRange(view)) * f52)));
        m1044k(2);
        return true;
    }

    /* renamed from: f */
    public final boolean m1039f(int i) {
        if (!isPointerDown(i)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }

    @Nullable
    public View findTopChildUnder(int i, int i2) {
        ViewGroup viewGroup = this.f4133u;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(this.f4130r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.f4132t) {
            this.f4129q.fling(this.f4131s.getLeft(), this.f4131s.getTop(), (int) this.f4124l.getXVelocity(this.f4115c), (int) this.f4124l.getYVelocity(this.f4115c), i, i3, i2, i4);
            m1044k(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    /* renamed from: g */
    public final void m1040g() {
        VelocityTracker velocityTracker = this.f4124l;
        float f = this.f4125m;
        velocityTracker.computeCurrentVelocity(1000, f);
        float xVelocity = this.f4124l.getXVelocity(this.f4115c);
        float f2 = this.f4126n;
        float abs = Math.abs(xVelocity);
        float f3 = RecyclerView.f7068F0;
        if (abs < f2) {
            xVelocity = 0.0f;
        } else if (abs > f) {
            if (xVelocity > RecyclerView.f7068F0) {
                xVelocity = f;
            } else {
                xVelocity = -f;
            }
        }
        float yVelocity = this.f4124l.getYVelocity(this.f4115c);
        float f4 = this.f4126n;
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f4) {
            if (abs2 > f) {
                if (yVelocity <= RecyclerView.f7068F0) {
                    f = -f;
                }
                f3 = f;
            } else {
                f3 = yVelocity;
            }
        }
        this.f4132t = true;
        this.f4130r.onViewReleased(this.f4131s, xVelocity, f3);
        this.f4132t = false;
        if (this.f4113a == 1) {
            m1044k(0);
        }
    }

    public int getActivePointerId() {
        return this.f4115c;
    }

    @Nullable
    public View getCapturedView() {
        return this.f4131s;
    }

    @Px
    public int getEdgeSize() {
        return this.f4127o;
    }

    public float getMinVelocity() {
        return this.f4126n;
    }

    @Px
    public int getTouchSlop() {
        return this.f4114b;
    }

    public int getViewDragState() {
        return this.f4113a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    /* renamed from: h */
    public final void m1041h(int i, float f, float f2) {
        boolean m1034a = m1034a(f, i, f2, 1);
        boolean z = m1034a;
        if (m1034a(f2, i, f, 4)) {
            z = (m1034a ? 1 : 0) | 4;
        }
        boolean z2 = z;
        if (m1034a(f, i, f2, 2)) {
            z2 = (z ? 1 : 0) | 2;
        }
        ?? r0 = z2;
        if (m1034a(f2, i, f, 8)) {
            r0 = (z2 ? 1 : 0) | 8;
        }
        if (r0 != 0) {
            int[] iArr = this.f4121i;
            iArr[i] = iArr[i] | r0;
            this.f4130r.onEdgeDragStarted(r0, i);
        }
    }

    /* renamed from: i */
    public final void m1042i(int i, float f, float f2) {
        float[] fArr = this.f4116d;
        int i2 = 0;
        if (fArr == null || fArr.length <= i) {
            int i3 = i + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f4117e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f4118f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f4119g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f4120h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f4121i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f4122j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f4116d = fArr2;
            this.f4117e = fArr3;
            this.f4118f = fArr4;
            this.f4119g = fArr5;
            this.f4120h = iArr;
            this.f4121i = iArr2;
            this.f4122j = iArr3;
        }
        float[] fArr9 = this.f4116d;
        this.f4118f[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.f4117e;
        this.f4119g[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.f4120h;
        int i4 = (int) f;
        int i5 = (int) f2;
        ViewGroup viewGroup = this.f4133u;
        int left = viewGroup.getLeft();
        int i6 = this.f4127o;
        if (i4 < left + i6) {
            i2 = 1;
        }
        if (i5 < viewGroup.getTop() + i6) {
            i2 |= 4;
        }
        if (i4 > viewGroup.getRight() - i6) {
            i2 |= 2;
        }
        if (i5 > viewGroup.getBottom() - i6) {
            i2 |= 8;
        }
        iArr7[i] = i2;
        this.f4123k = (1 << i) | this.f4123k;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.f4131s, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.f4120h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i) {
        if (((1 << i) & this.f4123k) != 0) {
            return true;
        }
        return false;
    }

    public boolean isViewUnder(@Nullable View view, int i, int i2) {
        if (view == null || i < view.getLeft() || i >= view.getRight() || i2 < view.getTop() || i2 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public final void m1043j(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m1039f(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f4118f[pointerId] = x;
                this.f4119g[pointerId] = y;
            }
        }
    }

    /* renamed from: k */
    public final void m1044k(int i) {
        this.f4133u.removeCallbacks(this.f4134v);
        if (this.f4113a != i) {
            this.f4113a = i;
            this.f4130r.onViewDragStateChanged(i);
            if (this.f4113a == 0) {
                this.f4131s = null;
            }
        }
    }

    /* renamed from: l */
    public final boolean m1045l(int i, View view) {
        if (view == this.f4131s && this.f4115c == i) {
            return true;
        }
        if (view != null && this.f4130r.tryCaptureView(view, i)) {
            this.f4115c = i;
            captureChildView(view, i);
            return true;
        }
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f4124l == null) {
            this.f4124l = VelocityTracker.obtain();
        }
        this.f4124l.addMovement(motionEvent);
        int i2 = 0;
        Callback callback = this.f4130r;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (this.f4113a == 1 && pointerId == this.f4115c) {
                                    int pointerCount = motionEvent.getPointerCount();
                                    while (true) {
                                        if (i2 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i2);
                                            if (pointerId2 != this.f4115c) {
                                                View findTopChildUnder = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                                                View view = this.f4131s;
                                                if (findTopChildUnder == view && m1045l(pointerId2, view)) {
                                                    i = this.f4115c;
                                                    break;
                                                }
                                            }
                                            i2++;
                                        } else {
                                            i = -1;
                                            break;
                                        }
                                    }
                                    if (i == -1) {
                                        m1040g();
                                    }
                                }
                                m1036c(pointerId);
                                return;
                            }
                            return;
                        }
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        float x = motionEvent.getX(actionIndex);
                        float y = motionEvent.getY(actionIndex);
                        m1042i(pointerId3, x, y);
                        if (this.f4113a == 0) {
                            m1045l(pointerId3, findTopChildUnder((int) x, (int) y));
                            int i3 = this.f4120h[pointerId3] & this.f4128p;
                            if (i3 != 0) {
                                callback.onEdgeTouched(i3, pointerId3);
                                return;
                            }
                            return;
                        }
                        if (isCapturedViewUnder((int) x, (int) y)) {
                            m1045l(pointerId3, this.f4131s);
                            return;
                        }
                        return;
                    }
                    if (this.f4113a == 1) {
                        this.f4132t = true;
                        callback.onViewReleased(this.f4131s, RecyclerView.f7068F0, RecyclerView.f7068F0);
                        this.f4132t = false;
                        if (this.f4113a == 1) {
                            m1044k(0);
                        }
                    }
                    cancel();
                    return;
                }
                if (this.f4113a == 1) {
                    if (m1039f(this.f4115c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f4115c);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f4118f;
                        int i4 = this.f4115c;
                        int i5 = (int) (x2 - fArr[i4]);
                        int i6 = (int) (y2 - this.f4119g[i4]);
                        int left = this.f4131s.getLeft() + i5;
                        int top = this.f4131s.getTop() + i6;
                        int left2 = this.f4131s.getLeft();
                        int top2 = this.f4131s.getTop();
                        if (i5 != 0) {
                            left = callback.clampViewPositionHorizontal(this.f4131s, left, i5);
                            ViewCompat.offsetLeftAndRight(this.f4131s, left - left2);
                        }
                        int i7 = left;
                        if (i6 != 0) {
                            top = callback.clampViewPositionVertical(this.f4131s, top, i6);
                            ViewCompat.offsetTopAndBottom(this.f4131s, top - top2);
                        }
                        int i8 = top;
                        if (i5 != 0 || i6 != 0) {
                            this.f4130r.onViewPositionChanged(this.f4131s, i7, i8, i7 - left2, i8 - top2);
                        }
                        m1043j(motionEvent);
                        return;
                    }
                    return;
                }
                int pointerCount2 = motionEvent.getPointerCount();
                while (i2 < pointerCount2) {
                    int pointerId4 = motionEvent.getPointerId(i2);
                    if (m1039f(pointerId4)) {
                        float x3 = motionEvent.getX(i2);
                        float y3 = motionEvent.getY(i2);
                        float f = x3 - this.f4116d[pointerId4];
                        float f2 = y3 - this.f4117e[pointerId4];
                        m1041h(pointerId4, f, f2);
                        if (this.f4113a != 1) {
                            View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                            if (m1035b(findTopChildUnder2, f, f2) && m1045l(pointerId4, findTopChildUnder2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i2++;
                }
                m1043j(motionEvent);
                return;
            }
            if (this.f4113a == 1) {
                m1040g();
            }
            cancel();
            return;
        }
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View findTopChildUnder3 = findTopChildUnder((int) x4, (int) y4);
        m1042i(pointerId5, x4, y4);
        m1045l(pointerId5, findTopChildUnder3);
        int i9 = this.f4120h[pointerId5] & this.f4128p;
        if (i9 != 0) {
            callback.onEdgeTouched(i9, pointerId5);
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.f4128p = i;
    }

    public void setMinVelocity(float f) {
        this.f4126n = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.f4132t) {
            return m1038e(i, i2, (int) this.f4124l.getXVelocity(this.f4115c), (int) this.f4124l.getYVelocity(this.f4115c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d2, code lost:
    
        if (r13 != r12) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f4124l == null) {
            this.f4124l = VelocityTracker.obtain();
        }
        this.f4124l.addMovement(motionEvent);
        Callback callback = this.f4130r;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                m1036c(motionEvent.getPointerId(actionIndex));
                            }
                        } else {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            m1042i(pointerId, x, y);
                            int i = this.f4113a;
                            if (i == 0) {
                                int i2 = this.f4120h[pointerId] & this.f4128p;
                                if (i2 != 0) {
                                    callback.onEdgeTouched(i2, pointerId);
                                }
                            } else if (i == 2 && (findTopChildUnder = findTopChildUnder((int) x, (int) y)) == this.f4131s) {
                                m1045l(pointerId, findTopChildUnder);
                            }
                        }
                    }
                } else if (this.f4116d != null && this.f4117e != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i3 = 0; i3 < pointerCount; i3++) {
                        int pointerId2 = motionEvent.getPointerId(i3);
                        if (m1039f(pointerId2)) {
                            float x2 = motionEvent.getX(i3);
                            float y2 = motionEvent.getY(i3);
                            float f = x2 - this.f4116d[pointerId2];
                            float f2 = y2 - this.f4117e[pointerId2];
                            View findTopChildUnder2 = findTopChildUnder((int) x2, (int) y2);
                            if (findTopChildUnder2 != null && m1035b(findTopChildUnder2, f, f2)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                int left = findTopChildUnder2.getLeft();
                                int i4 = (int) f;
                                int clampViewPositionHorizontal = callback.clampViewPositionHorizontal(findTopChildUnder2, left + i4, i4);
                                int top = findTopChildUnder2.getTop();
                                int i5 = (int) f2;
                                int clampViewPositionVertical = callback.clampViewPositionVertical(findTopChildUnder2, top + i5, i5);
                                int viewHorizontalDragRange = callback.getViewHorizontalDragRange(findTopChildUnder2);
                                int viewVerticalDragRange = callback.getViewVerticalDragRange(findTopChildUnder2);
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange == 0) {
                                    break;
                                }
                                if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                    break;
                                }
                            }
                            m1041h(pointerId2, f, f2);
                            if (this.f4113a == 1) {
                                break;
                            }
                            if (z2 && m1045l(pointerId2, findTopChildUnder2)) {
                                break;
                            }
                        }
                    }
                    m1043j(motionEvent);
                }
                z = false;
            }
            cancel();
            z = false;
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            z = false;
            int pointerId3 = motionEvent.getPointerId(0);
            m1042i(pointerId3, x3, y3);
            View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.f4131s && this.f4113a == 2) {
                m1045l(pointerId3, findTopChildUnder3);
            }
            int i6 = this.f4120h[pointerId3] & this.f4128p;
            if (i6 != 0) {
                callback.onEdgeTouched(i6, pointerId3);
            }
        }
        if (this.f4113a == 1) {
            return true;
        }
        return z;
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i, int i2) {
        this.f4131s = view;
        this.f4115c = -1;
        boolean m1038e = m1038e(i, i2, 0, 0);
        if (!m1038e && this.f4113a == 0 && this.f4131s != null) {
            this.f4131s = null;
        }
        return m1038e;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f4114b = (int) ((1.0f / f) * create.f4114b);
        return create;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f4118f[i2] - this.f4116d[i2];
        float f2 = this.f4119g[i2] - this.f4117e[i2];
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f4114b) : z2 && Math.abs(f2) > ((float) this.f4114b);
        }
        float f3 = (f2 * f2) + (f * f);
        int i3 = this.f4114b;
        return f3 > ((float) (i3 * i3));
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.f4120h[i2]) != 0;
    }
}
