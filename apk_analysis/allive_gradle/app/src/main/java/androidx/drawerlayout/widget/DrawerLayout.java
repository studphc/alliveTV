package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.q60;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: D */
    public static final int[] f4136D = {R.attr.colorPrimaryDark};

    /* renamed from: E */
    public static final int[] f4137E = {R.attr.layout_gravity};
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: A */
    public final ArrayList f4138A;

    /* renamed from: B */
    public Rect f4139B;

    /* renamed from: C */
    public Matrix f4140C;

    /* renamed from: a */
    public float f4141a;

    /* renamed from: b */
    public final int f4142b;

    /* renamed from: c */
    public int f4143c;

    /* renamed from: d */
    public float f4144d;

    /* renamed from: e */
    public final Paint f4145e;

    /* renamed from: f */
    public final ViewDragHelper f4146f;

    /* renamed from: g */
    public final ViewDragHelper f4147g;

    /* renamed from: h */
    public final C0232b f4148h;

    /* renamed from: i */
    public final C0232b f4149i;

    /* renamed from: j */
    public int f4150j;

    /* renamed from: k */
    public boolean f4151k;

    /* renamed from: l */
    public boolean f4152l;

    /* renamed from: m */
    public int f4153m;

    /* renamed from: n */
    public int f4154n;

    /* renamed from: o */
    public int f4155o;

    /* renamed from: p */
    public int f4156p;

    /* renamed from: q */
    public boolean f4157q;

    /* renamed from: r */
    public DrawerListener f4158r;

    /* renamed from: s */
    public ArrayList f4159s;

    /* renamed from: t */
    public float f4160t;

    /* renamed from: u */
    public float f4161u;

    /* renamed from: v */
    public Drawable f4162v;

    /* renamed from: w */
    public CharSequence f4163w;

    /* renamed from: x */
    public CharSequence f4164x;

    /* renamed from: y */
    public Object f4165y;

    /* renamed from: z */
    public boolean f4166z;

    /* loaded from: classes.dex */
    public interface DrawerListener {
        void onDrawerClosed(@NonNull View view);

        void onDrawerOpened(@NonNull View view);

        void onDrawerSlide(@NonNull View view, float f);

        void onDrawerStateChanged(int i);
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View view, float f) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i) {
        }
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: g */
    public static String m1046g(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    /* renamed from: h */
    public static boolean m1047h(View view) {
        if (((LayoutParams) view.getLayoutParams()).gravity == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m1048i(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        if ((absoluteGravity & 3) != 0 || (absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m1049a(int i, View view) {
        if ((m1054f(view) & i) == i) {
            return true;
        }
        return false;
    }

    public void addDrawerListener(@NonNull DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.f4159s == null) {
            this.f4159s = new ArrayList();
        }
        this.f4159s.add(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        boolean z = false;
        while (true) {
            arrayList2 = this.f4138A;
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (m1048i(childAt)) {
                if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            } else {
                arrayList2.add(childAt);
            }
            i3++;
        }
        if (!z) {
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) arrayList2.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m1052d() == null && !m1048i(view)) {
            ViewCompat.setImportantForAccessibility(view, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view, 4);
        }
    }

    /* renamed from: b */
    public final void m1050b(boolean z) {
        boolean smoothSlideViewTo;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m1048i(childAt) && (!z || layoutParams.f4168b)) {
                int width = childAt.getWidth();
                if (m1049a(3, childAt)) {
                    smoothSlideViewTo = this.f4146f.smoothSlideViewTo(childAt, -width, childAt.getTop());
                } else {
                    smoothSlideViewTo = this.f4147g.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                }
                z2 |= smoothSlideViewTo;
                layoutParams.f4168b = false;
            }
        }
        C0232b c0232b = this.f4148h;
        c0232b.f4178d.removeCallbacks(c0232b.f4177c);
        C0232b c0232b2 = this.f4149i;
        c0232b2.f4178d.removeCallbacks(c0232b2.f4177c);
        if (z2) {
            invalidate();
        }
    }

    /* renamed from: c */
    public final View m1051c(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m1054f(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public void closeDrawer(@NonNull View view) {
        closeDrawer(view, true);
    }

    public void closeDrawers() {
        m1050b(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = RecyclerView.f7068F0;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f4167a);
        }
        this.f4144d = f;
        boolean continueSettling = this.f4146f.continueSettling(true);
        boolean continueSettling2 = this.f4147g.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: d */
    public final View m1052d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f4169c & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean dispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.f4144d > RecyclerView.f7068F0) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                for (int i = childCount - 1; i >= 0; i--) {
                    View childAt = getChildAt(i);
                    if (this.f4139B == null) {
                        this.f4139B = new Rect();
                    }
                    childAt.getHitRect(this.f4139B);
                    if (this.f4139B.contains((int) x, (int) y) && !m1047h(childAt)) {
                        if (!childAt.getMatrix().isIdentity()) {
                            float scrollX = getScrollX() - childAt.getLeft();
                            float scrollY = getScrollY() - childAt.getTop();
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.offsetLocation(scrollX, scrollY);
                            Matrix matrix = childAt.getMatrix();
                            if (!matrix.isIdentity()) {
                                if (this.f4140C == null) {
                                    this.f4140C = new Matrix();
                                }
                                matrix.invert(this.f4140C);
                                obtain.transform(this.f4140C);
                            }
                            dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(obtain);
                            obtain.recycle();
                        } else {
                            float scrollX2 = getScrollX() - childAt.getLeft();
                            float scrollY2 = getScrollY() - childAt.getTop();
                            motionEvent.offsetLocation(scrollX2, scrollY2);
                            dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                            motionEvent.offsetLocation(-scrollX2, -scrollY2);
                        }
                        if (dispatchGenericMotionEvent) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        Drawable background;
        int height = getHeight();
        boolean m1047h = m1047h(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (m1047h) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && m1048i(childAt) && childAt.getHeight() >= height) {
                    if (m1049a(3, childAt)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.f4144d;
        if (f > RecyclerView.f7068F0 && m1047h) {
            int i4 = (((int) ((((-16777216) & r15) >>> 24) * f)) << 24) | (this.f4143c & ViewCompat.MEASURED_SIZE_MASK);
            Paint paint = this.f4145e;
            paint.setColor(i4);
            canvas.drawRect(i, RecyclerView.f7068F0, width, getHeight(), paint);
        }
        return drawChild;
    }

    /* renamed from: e */
    public final View m1053e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m1048i(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: f */
    public final int m1054f(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        return this.f4141a;
    }

    public int getDrawerLockMode(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i == 3) {
            int i2 = this.f4153m;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.f4155o : this.f4156p;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.f4154n;
            if (i4 != 3) {
                return i4;
            }
            int i5 = layoutDirection == 0 ? this.f4156p : this.f4155o;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.f4155o;
            if (i6 != 3) {
                return i6;
            }
            int i7 = layoutDirection == 0 ? this.f4153m : this.f4154n;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.f4156p;
        if (i8 != 3) {
            return i8;
        }
        int i9 = layoutDirection == 0 ? this.f4154n : this.f4153m;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    @Nullable
    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.f4163w;
        }
        if (absoluteGravity == 5) {
            return this.f4164x;
        }
        return null;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f4162v;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        if (m1048i(view)) {
            return (((LayoutParams) view.getLayoutParams()).f4169c & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(@NonNull View view) {
        if (m1048i(view)) {
            return ((LayoutParams) view.getLayoutParams()).f4167a > RecyclerView.f7068F0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: j */
    public final void m1055j(View view, float f) {
        float f2 = ((LayoutParams) view.getLayoutParams()).f4167a;
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (f2 * width));
        if (!m1049a(3, view)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        m1056k(view, f);
    }

    /* renamed from: k */
    public final void m1056k(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.f4167a) {
            return;
        }
        layoutParams.f4167a = f;
        ArrayList arrayList = this.f4159s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((DrawerListener) this.f4159s.get(size)).onDrawerSlide(view, f);
            }
        }
    }

    /* renamed from: l */
    public final void m1057l(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !m1048i(childAt)) || (z && childAt == view)) {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            }
        }
    }

    /* renamed from: m */
    public final void m1058m(int i, View view) {
        int i2;
        View rootView;
        int viewDragState = this.f4146f.getViewDragState();
        int viewDragState2 = this.f4147g.getViewDragState();
        if (viewDragState != 1 && viewDragState2 != 1) {
            i2 = 2;
            if (viewDragState != 2 && viewDragState2 != 2) {
                i2 = 0;
            }
        } else {
            i2 = 1;
        }
        if (view != null && i == 0) {
            float f = ((LayoutParams) view.getLayoutParams()).f4167a;
            if (f == RecyclerView.f7068F0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.f4169c & 1) == 1) {
                    layoutParams.f4169c = 0;
                    ArrayList arrayList = this.f4159s;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((DrawerListener) this.f4159s.get(size)).onDrawerClosed(view);
                        }
                    }
                    m1057l(view, false);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f == 1.0f) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                if ((layoutParams2.f4169c & 1) == 0) {
                    layoutParams2.f4169c = 1;
                    ArrayList arrayList2 = this.f4159s;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ((DrawerListener) this.f4159s.get(size2)).onDrawerOpened(view);
                        }
                    }
                    m1057l(view, true);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i2 != this.f4150j) {
            this.f4150j = i2;
            ArrayList arrayList3 = this.f4159s;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((DrawerListener) this.f4159s.get(size3)).onDrawerStateChanged(i2);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4152l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4152l = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.f4166z && this.f4162v != null) {
            Object obj = this.f4165y;
            if (obj != null) {
                i = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.f4162v.setBounds(0, 0, getWidth(), i);
                this.f4162v.draw(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        ViewDragHelper viewDragHelper = this.f4146f;
        boolean shouldInterceptTouchEvent = viewDragHelper.shouldInterceptTouchEvent(motionEvent) | this.f4147g.shouldInterceptTouchEvent(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (viewDragHelper.checkTouchSlop(3)) {
                        C0232b c0232b = this.f4148h;
                        c0232b.f4178d.removeCallbacks(c0232b.f4177c);
                        C0232b c0232b2 = this.f4149i;
                        c0232b2.f4178d.removeCallbacks(c0232b2.f4177c);
                    }
                }
                z = false;
            }
            m1050b(true);
            this.f4157q = false;
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f4160t = x;
            this.f4161u = y;
            if (this.f4144d > RecyclerView.f7068F0 && (findTopChildUnder = viewDragHelper.findTopChildUnder((int) x, (int) y)) != null && m1047h(findTopChildUnder)) {
                z = true;
            } else {
                z = false;
            }
            this.f4157q = false;
        }
        if (shouldInterceptTouchEvent || z) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f4168b) {
                return true;
            }
        }
        if (this.f4157q) {
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && m1053e() != null) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View m1053e = m1053e();
            if (m1053e != null && getDrawerLockMode(m1053e) == 0) {
                closeDrawers();
            }
            if (m1053e != null) {
                return true;
            }
            return false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        boolean z2;
        int i6;
        boolean z3 = true;
        this.f4151k = true;
        int i7 = i3 - i;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m1047h(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m1049a(3, childAt)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.f4167a * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i7 - r11) / f3;
                        i5 = i7 - ((int) (layoutParams.f4167a * f3));
                    }
                    if (f != layoutParams.f4167a) {
                        z2 = z3;
                    } else {
                        z2 = false;
                    }
                    int i10 = layoutParams.gravity & 112;
                    if (i10 != 16) {
                        if (i10 != 80) {
                            int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                        } else {
                            int i12 = i4 - i2;
                            childAt.layout(i5, (i12 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i12 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    } else {
                        int i13 = i4 - i2;
                        int i14 = (i13 - measuredHeight) / 2;
                        int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i14 < i15) {
                            i14 = i15;
                        } else {
                            int i16 = i14 + measuredHeight;
                            int i17 = i13 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i16 > i17) {
                                i14 = i17 - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i14, measuredWidth + i5, measuredHeight + i14);
                    }
                    if (z2) {
                        m1056k(childAt, f);
                    }
                    if (layoutParams.f4167a > RecyclerView.f7068F0) {
                        i6 = 0;
                    } else {
                        i6 = 4;
                    }
                    if (childAt.getVisibility() != i6) {
                        childAt.setVisibility(i6);
                    }
                }
            }
            i8++;
            z3 = true;
        }
        this.f4151k = false;
        this.f4152l = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        if (this.f4165y != null && ViewCompat.getFitsSystemWindows(this)) {
            z = true;
        } else {
            z = false;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        boolean z3 = false;
        boolean z4 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.f4165y;
                        if (absoluteGravity == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.f4165y;
                        if (absoluteGravity == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (m1047h(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else if (m1048i(childAt)) {
                    float elevation = ViewCompat.getElevation(childAt);
                    float f = this.f4141a;
                    if (elevation != f) {
                        ViewCompat.setElevation(childAt, f);
                    }
                    int m1054f = m1054f(childAt) & 7;
                    if (m1054f == 3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((z2 && z3) || (!z2 && z4)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + m1046g(m1054f) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z2) {
                        z3 = true;
                    } else {
                        z4 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.f4142b + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View m1051c;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f4170b;
        if (i != 0 && (m1051c = m1051c(i)) != null) {
            openDrawer(m1051c);
        }
        int i2 = savedState.f4171c;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = savedState.f4172d;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = savedState.f4173e;
        if (i4 != 3) {
            setDrawerLockMode(i4, GravityCompat.START);
        }
        int i5 = savedState.f4174f;
        if (i5 != 3) {
            setDrawerLockMode(i5, GravityCompat.END);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int i2 = layoutParams.f4169c;
            boolean z2 = true;
            if (i2 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (i2 != 2) {
                z2 = false;
            }
            if (z || z2) {
                savedState.f4170b = layoutParams.gravity;
                break;
            }
        }
        savedState.f4171c = this.f4153m;
        savedState.f4172d = this.f4154n;
        savedState.f4173e = this.f4155o;
        savedState.f4174f = this.f4156p;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        if (getDrawerLockMode(r7) != 2) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f4146f;
        viewDragHelper.processTouchEvent(motionEvent);
        this.f4147g.processTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    m1050b(true);
                    this.f4157q = false;
                }
            } else {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                View findTopChildUnder = viewDragHelper.findTopChildUnder((int) x, (int) y);
                if (findTopChildUnder != null && m1047h(findTopChildUnder)) {
                    float f = x - this.f4160t;
                    float f2 = y - this.f4161u;
                    int touchSlop = viewDragHelper.getTouchSlop();
                    if ((f2 * f2) + (f * f) < touchSlop * touchSlop) {
                        View m1052d = m1052d();
                        if (m1052d != null) {
                        }
                    }
                }
                z = true;
                m1050b(z);
            }
        } else {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.f4160t = x2;
            this.f4161u = y2;
            this.f4157q = false;
        }
        return true;
    }

    public void openDrawer(@NonNull View view) {
        openDrawer(view, true);
    }

    public void removeDrawerListener(@NonNull DrawerListener drawerListener) {
        ArrayList arrayList;
        if (drawerListener == null || (arrayList = this.f4159s) == null) {
            return;
        }
        arrayList.remove(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m1050b(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f4151k) {
            super.requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setChildInsets(Object obj, boolean z) {
        boolean z2;
        this.f4165y = obj;
        this.f4166z = z;
        if (!z && getBackground() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f4141a = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m1048i(childAt)) {
                ViewCompat.setElevation(childAt, this.f4141a);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.f4158r;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.f4158r = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
    }

    public void setDrawerTitle(int i, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.f4163w = charSequence;
        } else if (absoluteGravity == 5) {
            this.f4164x = charSequence;
        }
    }

    public void setScrimColor(@ColorInt int i) {
        this.f4143c = i;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.f4162v = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        this.f4162v = new ColorDrawable(i);
        invalidate();
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void closeDrawer(@NonNull View view, boolean z) {
        if (m1048i(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f4152l) {
                layoutParams.f4167a = RecyclerView.f7068F0;
                layoutParams.f4169c = 0;
            } else if (z) {
                layoutParams.f4169c |= 4;
                if (m1049a(3, view)) {
                    this.f4146f.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
                } else {
                    this.f4147g.smoothSlideViewTo(view, getWidth(), view.getTop());
                }
            } else {
                m1055j(view, RecyclerView.f7068F0);
                int i = layoutParams.gravity;
                m1058m(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void openDrawer(@NonNull View view, boolean z) {
        if (m1048i(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f4152l) {
                layoutParams.f4167a = 1.0f;
                layoutParams.f4169c = 1;
                m1057l(view, true);
            } else if (z) {
                layoutParams.f4169c |= 2;
                if (m1049a(3, view)) {
                    this.f4146f.smoothSlideViewTo(view, 0, view.getTop());
                } else {
                    this.f4147g.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                m1055j(view, 1.0f);
                int i = layoutParams.gravity;
                m1058m(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void setDrawerShadow(@DrawableRes int i, int i2) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object, android.view.View$OnApplyWindowInsetsListener] */
    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new AccessibilityDelegateCompat();
        this.f4143c = -1728053248;
        this.f4145e = new Paint();
        this.f4152l = true;
        this.f4153m = 3;
        this.f4154n = 3;
        this.f4155o = 3;
        this.f4156p = 3;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f4142b = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        C0232b c0232b = new C0232b(this, 3);
        this.f4148h = c0232b;
        C0232b c0232b2 = new C0232b(this, 5);
        this.f4149i = c0232b2;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, c0232b);
        this.f4146f = create;
        create.setEdgeTrackingEnabled(1);
        create.setMinVelocity(f2);
        c0232b.f4176b = create;
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, c0232b2);
        this.f4147g = create2;
        create2.setEdgeTrackingEnabled(2);
        create2.setMinVelocity(f2);
        c0232b2.f4176b = create2;
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new q60(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener(new Object());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f4136D);
            try {
                this.f4162v = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f4141a = f * 10.0f;
        this.f4138A = new ArrayList();
    }

    public void setDrawerLockMode(int i, int i2) {
        View m1051c;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (i2 == 3) {
            this.f4153m = i;
        } else if (i2 == 5) {
            this.f4154n = i;
        } else if (i2 == 8388611) {
            this.f4155o = i;
        } else if (i2 == 8388613) {
            this.f4156p = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f4146f : this.f4147g).cancel();
        }
        if (i != 1) {
            if (i == 2 && (m1051c = m1051c(absoluteGravity)) != null) {
                openDrawer(m1051c);
                return;
            }
            return;
        }
        View m1051c2 = m1051c(absoluteGravity);
        if (m1051c2 != null) {
            closeDrawer(m1051c2);
        }
    }

    public void setStatusBarBackground(int i) {
        this.f4162v = i != 0 ? ContextCompat.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i) {
        View m1051c = m1051c(i);
        if (m1051c != null) {
            return isDrawerVisible(m1051c);
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public float f4167a;

        /* renamed from: b */
        public boolean f4168b;

        /* renamed from: c */
        public int f4169c;
        public int gravity;

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f4137E);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }
    }

    public boolean isDrawerOpen(int i) {
        View m1051c = m1051c(i);
        if (m1051c != null) {
            return isDrawerOpen(m1051c);
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: b */
        public int f4170b;

        /* renamed from: c */
        public int f4171c;

        /* renamed from: d */
        public int f4172d;

        /* renamed from: e */
        public int f4173e;

        /* renamed from: f */
        public int f4174f;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4170b = 0;
            this.f4170b = parcel.readInt();
            this.f4171c = parcel.readInt();
            this.f4172d = parcel.readInt();
            this.f4173e = parcel.readInt();
            this.f4174f = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4170b);
            parcel.writeInt(this.f4171c);
            parcel.writeInt(this.f4172d);
            parcel.writeInt(this.f4173e);
            parcel.writeInt(this.f4174f);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
            this.f4170b = 0;
        }
    }

    public int getDrawerLockMode(@NonNull View view) {
        if (m1048i(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).gravity);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerLockMode(int i, @NonNull View view) {
        if (m1048i(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).gravity);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public void closeDrawer(int i, boolean z) {
        View m1051c = m1051c(i);
        if (m1051c != null) {
            closeDrawer(m1051c, z);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + m1046g(i));
        }
    }

    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void openDrawer(int i, boolean z) {
        View m1051c = m1051c(i);
        if (m1051c != null) {
            openDrawer(m1051c, z);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + m1046g(i));
        }
    }
}
