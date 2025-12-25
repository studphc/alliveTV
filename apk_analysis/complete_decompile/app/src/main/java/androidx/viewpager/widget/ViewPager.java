package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import p000.AbstractC1726qj;
import p000.C1540m9;
import p000.f92;
import p000.o91;
import p000.q33;
import p000.r33;
import p000.sn1;
import p000.x30;
import p000.ye0;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    /* renamed from: g0 */
    public static final int[] f7616g0 = {R.attr.layout_gravity};

    /* renamed from: h0 */
    public static final x30 f7617h0 = new x30(5);

    /* renamed from: i0 */
    public static final f92 f7618i0 = new f92(2);

    /* renamed from: j0 */
    public static final C0526c f7619j0 = new Object();

    /* renamed from: A */
    public int f7620A;

    /* renamed from: B */
    public int f7621B;

    /* renamed from: C */
    public float f7622C;

    /* renamed from: D */
    public float f7623D;

    /* renamed from: E */
    public float f7624E;

    /* renamed from: F */
    public float f7625F;

    /* renamed from: G */
    public int f7626G;

    /* renamed from: H */
    public VelocityTracker f7627H;

    /* renamed from: I */
    public int f7628I;

    /* renamed from: J */
    public int f7629J;

    /* renamed from: K */
    public int f7630K;

    /* renamed from: L */
    public int f7631L;

    /* renamed from: M */
    public boolean f7632M;

    /* renamed from: N */
    public long f7633N;

    /* renamed from: O */
    public EdgeEffect f7634O;

    /* renamed from: P */
    public EdgeEffect f7635P;

    /* renamed from: Q */
    public boolean f7636Q;

    /* renamed from: R */
    public boolean f7637R;

    /* renamed from: S */
    public int f7638S;

    /* renamed from: T */
    public ArrayList f7639T;

    /* renamed from: U */
    public OnPageChangeListener f7640U;

    /* renamed from: V */
    public OnPageChangeListener f7641V;

    /* renamed from: W */
    public ArrayList f7642W;

    /* renamed from: a */
    public int f7643a;

    /* renamed from: a0 */
    public PageTransformer f7644a0;

    /* renamed from: b */
    public final ArrayList f7645b;

    /* renamed from: b0 */
    public int f7646b0;

    /* renamed from: c */
    public final q33 f7647c;

    /* renamed from: c0 */
    public int f7648c0;

    /* renamed from: d */
    public final Rect f7649d;

    /* renamed from: d0 */
    public ArrayList f7650d0;

    /* renamed from: e */
    public PagerAdapter f7651e;

    /* renamed from: e0 */
    public final sn1 f7652e0;

    /* renamed from: f */
    public int f7653f;

    /* renamed from: f0 */
    public int f7654f0;

    /* renamed from: g */
    public int f7655g;

    /* renamed from: h */
    public Parcelable f7656h;

    /* renamed from: i */
    public ClassLoader f7657i;

    /* renamed from: j */
    public Scroller f7658j;

    /* renamed from: k */
    public boolean f7659k;

    /* renamed from: l */
    public o91 f7660l;

    /* renamed from: m */
    public int f7661m;

    /* renamed from: n */
    public Drawable f7662n;

    /* renamed from: o */
    public int f7663o;

    /* renamed from: p */
    public int f7664p;

    /* renamed from: q */
    public float f7665q;

    /* renamed from: r */
    public float f7666r;

    /* renamed from: s */
    public int f7667s;

    /* renamed from: t */
    public boolean f7668t;

    /* renamed from: u */
    public boolean f7669u;

    /* renamed from: v */
    public boolean f7670v;

    /* renamed from: w */
    public int f7671w;

    /* renamed from: x */
    public boolean f7672x;

    /* renamed from: y */
    public boolean f7673y;

    /* renamed from: z */
    public int f7674z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface DecorView {
    }

    /* loaded from: classes.dex */
    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, @Px int i2);

        void onPageSelected(int i);
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
        void transformPage(@NonNull View view, float f);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: b */
        public int f7679b;

        /* renamed from: c */
        public Parcelable f7680c;

        /* renamed from: d */
        public final ClassLoader f7681d;

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            return ye0.m8298r(sb, "}", this.f7679b);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7679b);
            parcel.writeParcelable(this.f7680c, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f7679b = parcel.readInt();
            this.f7680c = parcel.readParcelable(classLoader);
            this.f7681d = classLoader;
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [q33, java.lang.Object] */
    public ViewPager(@NonNull Context context) {
        super(context);
        this.f7645b = new ArrayList();
        this.f7647c = new Object();
        this.f7649d = new Rect();
        this.f7655g = -1;
        this.f7656h = null;
        this.f7657i = null;
        this.f7665q = -3.4028235E38f;
        this.f7666r = Float.MAX_VALUE;
        this.f7671w = 1;
        this.f7626G = -1;
        this.f7636Q = true;
        this.f7652e0 = new sn1(15, this);
        this.f7654f0 = 0;
        m1940j();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f7669u != z) {
            this.f7669u = z;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [q33, java.lang.Object] */
    /* renamed from: a */
    public final q33 m1931a(int i, int i2) {
        ?? obj = new Object();
        obj.f25423b = i;
        obj.f25422a = this.f7651e.instantiateItem((ViewGroup) this, i);
        obj.f25425d = this.f7651e.getPageWidth(i);
        ArrayList arrayList = this.f7645b;
        if (i2 >= 0 && i2 < arrayList.size()) {
            arrayList.add(i2, obj);
        } else {
            arrayList.add(obj);
        }
        return obj;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        q33 m1937g;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (m1937g = m1937g(childAt)) != null && m1937g.f25423b == this.f7653f) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.f7642W == null) {
            this.f7642W = new ArrayList();
        }
        this.f7642W.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.f7639T == null) {
            this.f7639T = new ArrayList();
        }
        this.f7639T.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        q33 m1937g;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (m1937g = m1937g(childAt)) != null && m1937g.f25423b == this.f7653f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        boolean z;
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z2 = layoutParams2.isDecor;
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = z2 | z;
        layoutParams2.isDecor = z3;
        if (this.f7668t) {
            if (!z3) {
                layoutParams2.f7676b = true;
                addViewInLayout(view, i, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i) {
        View findNextFocus;
        boolean z;
        int i2;
        boolean requestFocus;
        View findFocus = findFocus();
        if (findFocus != this) {
            if (findFocus != null) {
                for (ViewParent parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(findFocus.getClass().getSimpleName());
                for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            z = false;
            if (findNextFocus == null && findNextFocus != findFocus) {
                Rect rect = this.f7649d;
                if (i == 17) {
                    int i3 = m1936f(findNextFocus, rect).left;
                    int i4 = m1936f(findFocus, rect).left;
                    if (findFocus != null && i3 >= i4) {
                        int i5 = this.f7653f;
                        if (i5 > 0) {
                            setCurrentItem(i5 - 1, true);
                            z = true;
                        }
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                        z = requestFocus;
                    }
                } else if (i == 66) {
                    int i6 = m1936f(findNextFocus, rect).left;
                    int i7 = m1936f(findFocus, rect).left;
                    if (findFocus != null && i6 <= i7) {
                        requestFocus = m1942l();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                    z = requestFocus;
                }
            } else if (i == 17 && i != 1) {
                if (i == 66 || i == 2) {
                    z = m1942l();
                }
            } else {
                i2 = this.f7653f;
                if (i2 > 0) {
                    setCurrentItem(i2 - 1, true);
                    z = true;
                }
            }
            if (z) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        z = false;
        if (findNextFocus == null) {
        }
        if (i == 17) {
        }
        i2 = this.f7653f;
        if (i2 > 0) {
        }
        if (z) {
        }
        return z;
    }

    /* renamed from: b */
    public final void m1932b(boolean z) {
        boolean z2;
        if (this.f7654f0 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f7658j.isFinished()) {
                this.f7658j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f7658j.getCurrX();
                int currY = this.f7658j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m1943m(currX);
                    }
                }
            }
        }
        this.f7670v = false;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f7645b;
            if (i >= arrayList.size()) {
                break;
            }
            q33 q33Var = (q33) arrayList.get(i);
            if (q33Var.f25424c) {
                q33Var.f25424c = false;
                z2 = true;
            }
            i++;
        }
        if (z2) {
            sn1 sn1Var = this.f7652e0;
            if (z) {
                ViewCompat.postOnAnimation(this, sn1Var);
            } else {
                sn1Var.run();
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.f7672x) {
            return false;
        }
        this.f7632M = true;
        setScrollState(1);
        this.f7622C = RecyclerView.f7068F0;
        this.f7624E = RecyclerView.f7068F0;
        VelocityTracker velocityTracker = this.f7627H;
        if (velocityTracker == null) {
            this.f7627H = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, RecyclerView.f7068F0, RecyclerView.f7068F0, 0);
        this.f7627H.addMovement(obtain);
        obtain.recycle();
        this.f7633N = uptimeMillis;
        return true;
    }

    /* renamed from: c */
    public final void m1933c() {
        boolean z;
        int count = this.f7651e.getCount();
        this.f7643a = count;
        ArrayList arrayList = this.f7645b;
        if (arrayList.size() < (this.f7671w * 2) + 1 && arrayList.size() < count) {
            z = true;
        } else {
            z = false;
        }
        int i = this.f7653f;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < arrayList.size()) {
            q33 q33Var = (q33) arrayList.get(i2);
            int itemPosition = this.f7651e.getItemPosition(q33Var.f25422a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    arrayList.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f7651e.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.f7651e.destroyItem((ViewGroup) this, q33Var.f25423b, q33Var.f25422a);
                    int i3 = this.f7653f;
                    if (i3 == q33Var.f25423b) {
                        i = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = q33Var.f25423b;
                    if (i4 != itemPosition) {
                        if (i4 == this.f7653f) {
                            i = itemPosition;
                        }
                        q33Var.f25423b = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f7651e.finishUpdate((ViewGroup) this);
        }
        Collections.sort(arrayList, f7617h0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.f7675a = RecyclerView.f7068F0;
                }
            }
            m1950t(i, 0, false, true);
            requestLayout();
        }
    }

    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z && view.canScrollHorizontally(-i)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f7651e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (clientWidth * this.f7665q))) {
                return false;
            }
            return true;
        }
        if (i <= 0 || scrollX >= ((int) (clientWidth * this.f7666r))) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public void clearOnPageChangeListeners() {
        ArrayList arrayList = this.f7639T;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f7659k = true;
        if (!this.f7658j.isFinished() && this.f7658j.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f7658j.getCurrX();
            int currY = this.f7658j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m1943m(currX)) {
                    this.f7658j.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        m1932b(true);
    }

    /* renamed from: d */
    public final int m1934d(int i, int i2, int i3, float f) {
        float f2;
        if (Math.abs(i3) > this.f7630K && Math.abs(i2) > this.f7628I) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            if (i >= this.f7653f) {
                f2 = 0.4f;
            } else {
                f2 = 0.6f;
            }
            i += (int) (f + f2);
        }
        ArrayList arrayList = this.f7645b;
        if (arrayList.size() > 0) {
            return Math.max(((q33) arrayList.get(0)).f25423b, Math.min(i, ((q33) AbstractC1726qj.m7053i(arrayList, 1)).f25423b));
        }
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        q33 m1937g;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (m1937g = m1937g(childAt)) != null && m1937g.f25423b == this.f7653f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f7651e) == null || pagerAdapter.getCount() <= 1)) {
            this.f7634O.finish();
            this.f7635P.finish();
        } else {
            if (!this.f7634O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.f7665q * width);
                this.f7634O.setSize(height, width);
                z = this.f7634O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f7635P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f7666r + 1.0f)) * width2);
                this.f7635P.setSize(height2, width2);
                z |= this.f7635P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f7662n;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* renamed from: e */
    public final void m1935e(int i) {
        OnPageChangeListener onPageChangeListener = this.f7640U;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
        ArrayList arrayList = this.f7639T;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.f7639T.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f7641V;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i);
        }
    }

    public void endFakeDrag() {
        if (this.f7632M) {
            if (this.f7651e != null) {
                VelocityTracker velocityTracker = this.f7627H;
                velocityTracker.computeCurrentVelocity(1000, this.f7629J);
                int xVelocity = (int) velocityTracker.getXVelocity(this.f7626G);
                this.f7670v = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                q33 m1938h = m1938h();
                m1950t(m1934d(m1938h.f25423b, xVelocity, (int) (this.f7622C - this.f7624E), ((scrollX / clientWidth) - m1938h.f25426e) / m1938h.f25425d), xVelocity, true, true);
            }
            this.f7672x = false;
            this.f7673y = false;
            VelocityTracker velocityTracker2 = this.f7627H;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f7627H = null;
            }
            this.f7632M = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 21) {
            if (keyCode != 22) {
                if (keyCode != 61) {
                    return false;
                }
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (!keyEvent.hasModifiers(1)) {
                    return false;
                }
                return arrowScroll(1);
            }
            if (keyEvent.hasModifiers(2)) {
                return m1942l();
            }
            return arrowScroll(66);
        }
        if (keyEvent.hasModifiers(2)) {
            int i = this.f7653f;
            if (i <= 0) {
                return false;
            }
            setCurrentItem(i - 1, true);
            return true;
        }
        return arrowScroll(17);
    }

    /* renamed from: f */
    public final Rect m1936f(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public void fakeDragBy(float f) {
        if (this.f7632M) {
            if (this.f7651e == null) {
                return;
            }
            this.f7622C += f;
            float scrollX = getScrollX() - f;
            float clientWidth = getClientWidth();
            float f2 = this.f7665q * clientWidth;
            float f3 = this.f7666r * clientWidth;
            ArrayList arrayList = this.f7645b;
            q33 q33Var = (q33) arrayList.get(0);
            q33 q33Var2 = (q33) AbstractC1726qj.m7053i(arrayList, 1);
            if (q33Var.f25423b != 0) {
                f2 = q33Var.f25426e * clientWidth;
            }
            if (q33Var2.f25423b != this.f7651e.getCount() - 1) {
                f3 = q33Var2.f25426e * clientWidth;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.f7622C = (scrollX - i) + this.f7622C;
            scrollTo(i, getScrollY());
            m1943m(i);
            MotionEvent obtain = MotionEvent.obtain(this.f7633N, SystemClock.uptimeMillis(), 2, this.f7622C, RecyclerView.f7068F0, 0);
            this.f7627H.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    /* renamed from: g */
    public final q33 m1937g(View view) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f7645b;
            if (i < arrayList.size()) {
                q33 q33Var = (q33) arrayList.get(i);
                if (this.f7651e.isViewFromObject(view, q33Var.f25422a)) {
                    return q33Var;
                }
                i++;
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.f7651e;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f7648c0 == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.f7650d0.get(i2)).getLayoutParams()).f7678d;
    }

    public int getCurrentItem() {
        return this.f7653f;
    }

    public int getOffscreenPageLimit() {
        return this.f7671w;
    }

    public int getPageMargin() {
        return this.f7661m;
    }

    /* renamed from: h */
    public final q33 m1938h() {
        float f;
        float f2;
        q33 q33Var;
        int i;
        int clientWidth = getClientWidth();
        float f3 = RecyclerView.f7068F0;
        if (clientWidth > 0) {
            f = getScrollX() / clientWidth;
        } else {
            f = 0.0f;
        }
        if (clientWidth > 0) {
            f2 = this.f7661m / clientWidth;
        } else {
            f2 = 0.0f;
        }
        int i2 = 0;
        boolean z = true;
        q33 q33Var2 = null;
        int i3 = -1;
        float f4 = 0.0f;
        while (true) {
            ArrayList arrayList = this.f7645b;
            if (i2 < arrayList.size()) {
                q33 q33Var3 = (q33) arrayList.get(i2);
                if (!z && q33Var3.f25423b != (i = i3 + 1)) {
                    float f5 = f3 + f4 + f2;
                    q33 q33Var4 = this.f7647c;
                    q33Var4.f25426e = f5;
                    q33Var4.f25423b = i;
                    q33Var4.f25425d = this.f7651e.getPageWidth(i);
                    i2--;
                    q33Var = q33Var4;
                } else {
                    q33Var = q33Var3;
                }
                f3 = q33Var.f25426e;
                float f6 = q33Var.f25425d + f3 + f2;
                if (!z && f < f3) {
                    return q33Var2;
                }
                if (f < f6 || i2 == arrayList.size() - 1) {
                    break;
                }
                int i4 = q33Var.f25423b;
                float f7 = q33Var.f25425d;
                i2++;
                z = false;
                q33 q33Var5 = q33Var;
                i3 = i4;
                f4 = f7;
                q33Var2 = q33Var5;
            } else {
                return q33Var2;
            }
        }
        return q33Var;
    }

    /* renamed from: i */
    public final q33 m1939i(int i) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7645b;
            if (i2 < arrayList.size()) {
                q33 q33Var = (q33) arrayList.get(i2);
                if (q33Var.f25423b == i) {
                    return q33Var;
                }
                i2++;
            } else {
                return null;
            }
        }
    }

    public boolean isFakeDragging() {
        return this.f7632M;
    }

    /* renamed from: j */
    public final void m1940j() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f7658j = new Scroller(context, f7618i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f7621B = viewConfiguration.getScaledPagingTouchSlop();
        this.f7628I = (int) (400.0f * f);
        this.f7629J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7634O = new EdgeEffect(context);
        this.f7635P = new EdgeEffect(context);
        this.f7630K = (int) (25.0f * f);
        this.f7631L = (int) (2.0f * f);
        this.f7674z = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new r33(this));
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new C1540m9(this));
    }

    /* renamed from: k */
    public final void m1941k(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f7626G) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f7622C = motionEvent.getX(i);
            this.f7626G = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f7627H;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: l */
    public final boolean m1942l() {
        PagerAdapter pagerAdapter = this.f7651e;
        if (pagerAdapter != null && this.f7653f < pagerAdapter.getCount() - 1) {
            setCurrentItem(this.f7653f + 1, true);
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public final boolean m1943m(int i) {
        if (this.f7645b.size() == 0) {
            if (this.f7636Q) {
                return false;
            }
            this.f7637R = false;
            onPageScrolled(0, RecyclerView.f7068F0, 0);
            if (this.f7637R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        q33 m1938h = m1938h();
        int clientWidth = getClientWidth();
        int i2 = this.f7661m;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = m1938h.f25423b;
        float f2 = ((i / f) - m1938h.f25426e) / (m1938h.f25425d + (i2 / f));
        this.f7637R = false;
        onPageScrolled(i4, f2, (int) (i3 * f2));
        if (this.f7637R) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* renamed from: n */
    public final boolean m1944n(float f) {
        boolean z;
        boolean z2;
        float f2 = this.f7622C - f;
        this.f7622C = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.f7665q * clientWidth;
        float f4 = this.f7666r * clientWidth;
        ArrayList arrayList = this.f7645b;
        boolean z3 = false;
        q33 q33Var = (q33) arrayList.get(0);
        q33 q33Var2 = (q33) AbstractC1726qj.m7053i(arrayList, 1);
        if (q33Var.f25423b != 0) {
            f3 = q33Var.f25426e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (q33Var2.f25423b != this.f7651e.getCount() - 1) {
            f4 = q33Var2.f25426e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.f7634O.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f7635P.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f7622C = (scrollX - i) + this.f7622C;
        scrollTo(i, getScrollY());
        m1943m(i);
        return z3;
    }

    /* renamed from: o */
    public final void m1945o() {
        m1946p(this.f7653f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7636Q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f7652e0);
        Scroller scroller = this.f7658j;
        if (scroller != null && !scroller.isFinished()) {
            this.f7658j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        float f;
        ArrayList arrayList;
        float f2;
        super.onDraw(canvas);
        if (this.f7661m > 0 && this.f7662n != null) {
            ArrayList arrayList2 = this.f7645b;
            if (arrayList2.size() > 0 && this.f7651e != null) {
                int scrollX = getScrollX();
                float width = getWidth();
                float f3 = this.f7661m / width;
                int i2 = 0;
                q33 q33Var = (q33) arrayList2.get(0);
                float f4 = q33Var.f25426e;
                int size = arrayList2.size();
                int i3 = q33Var.f25423b;
                int i4 = ((q33) arrayList2.get(size - 1)).f25423b;
                while (i3 < i4) {
                    while (true) {
                        i = q33Var.f25423b;
                        if (i3 <= i || i2 >= size) {
                            break;
                        }
                        i2++;
                        q33Var = (q33) arrayList2.get(i2);
                    }
                    if (i3 == i) {
                        float f5 = q33Var.f25426e;
                        float f6 = q33Var.f25425d;
                        f = (f5 + f6) * width;
                        f4 = f5 + f6 + f3;
                    } else {
                        float pageWidth = this.f7651e.getPageWidth(i3);
                        f = (f4 + pageWidth) * width;
                        f4 = pageWidth + f3 + f4;
                    }
                    if (this.f7661m + f > scrollX) {
                        arrayList = arrayList2;
                        f2 = f3;
                        this.f7662n.setBounds(Math.round(f), this.f7663o, Math.round(this.f7661m + f), this.f7664p);
                        this.f7662n.draw(canvas);
                    } else {
                        arrayList = arrayList2;
                        f2 = f3;
                    }
                    if (f <= scrollX + r3) {
                        i3++;
                        arrayList2 = arrayList;
                        f3 = f2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f7672x) {
                    return true;
                }
                if (this.f7673y) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        m1941k(motionEvent);
                    }
                } else {
                    int i = this.f7626G;
                    if (i != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i);
                        float x = motionEvent.getX(findPointerIndex);
                        float f2 = x - this.f7622C;
                        float abs = Math.abs(f2);
                        float y = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y - this.f7625F);
                        if (f2 != RecyclerView.f7068F0) {
                            float f3 = this.f7622C;
                            if ((f3 >= this.f7620A || f2 <= RecyclerView.f7068F0) && ((f3 <= getWidth() - this.f7620A || f2 >= RecyclerView.f7068F0) && canScroll(this, false, (int) f2, (int) x, (int) y))) {
                                this.f7622C = x;
                                this.f7623D = y;
                                this.f7673y = true;
                                return false;
                            }
                        }
                        float f4 = this.f7621B;
                        if (abs > f4 && abs * 0.5f > abs2) {
                            this.f7672x = true;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                            setScrollState(1);
                            float f5 = this.f7624E;
                            float f6 = this.f7621B;
                            if (f2 > RecyclerView.f7068F0) {
                                f = f5 + f6;
                            } else {
                                f = f5 - f6;
                            }
                            this.f7622C = f;
                            this.f7623D = y;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > f4) {
                            this.f7673y = true;
                        }
                        if (this.f7672x && m1944n(x)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    }
                }
            } else {
                float x2 = motionEvent.getX();
                this.f7624E = x2;
                this.f7622C = x2;
                float y2 = motionEvent.getY();
                this.f7625F = y2;
                this.f7623D = y2;
                this.f7626G = motionEvent.getPointerId(0);
                this.f7673y = false;
                this.f7659k = true;
                this.f7658j.computeScrollOffset();
                if (this.f7654f0 == 2 && Math.abs(this.f7658j.getFinalX() - this.f7658j.getCurrX()) > this.f7631L) {
                    this.f7658j.abortAnimation();
                    this.f7670v = false;
                    m1945o();
                    this.f7672x = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                } else {
                    m1932b(false);
                    this.f7672x = false;
                }
            }
            if (this.f7627H == null) {
                this.f7627H = VelocityTracker.obtain();
            }
            this.f7627H.addMovement(motionEvent);
            return this.f7672x;
        }
        m1948r();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        q33 m1937g;
        int max;
        int i5;
        int max2;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i11 = layoutParams.gravity;
                    int i12 = i11 & 7;
                    int i13 = i11 & 112;
                    if (i12 != 1) {
                        if (i12 != 3) {
                            if (i12 != 5) {
                                i5 = paddingLeft;
                            } else {
                                max = (i7 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i5 = childAt.getMeasuredWidth() + paddingLeft;
                        }
                        if (i13 == 16) {
                            if (i13 != 48) {
                                if (i13 != 80) {
                                    i6 = paddingTop;
                                } else {
                                    max2 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i6 = childAt.getMeasuredHeight() + paddingTop;
                            }
                            int i14 = paddingLeft + scrollX;
                            childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, childAt.getMeasuredHeight() + paddingTop);
                            i9++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        } else {
                            max2 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i15 = max2;
                        i6 = paddingTop;
                        paddingTop = i15;
                        int i142 = paddingLeft + scrollX;
                        childAt.layout(i142, paddingTop, childAt.getMeasuredWidth() + i142, childAt.getMeasuredHeight() + paddingTop);
                        i9++;
                        paddingTop = i6;
                        paddingLeft = i5;
                    } else {
                        max = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i16 = max;
                    i5 = paddingLeft;
                    paddingLeft = i16;
                    if (i13 == 16) {
                    }
                    int i152 = max2;
                    i6 = paddingTop;
                    paddingTop = i152;
                    int i1422 = paddingLeft + scrollX;
                    childAt.layout(i1422, paddingTop, childAt.getMeasuredWidth() + i1422, childAt.getMeasuredHeight() + paddingTop);
                    i9++;
                    paddingTop = i6;
                    paddingLeft = i5;
                }
            }
        }
        int i17 = (i7 - paddingLeft) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (m1937g = m1937g(childAt2)) != null) {
                    float f = i17;
                    int i19 = ((int) (m1937g.f25426e * f)) + paddingLeft;
                    if (layoutParams2.f7676b) {
                        layoutParams2.f7676b = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.f7675a), 1073741824), View.MeasureSpec.makeMeasureSpec((i8 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i19, paddingTop, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f7663o = paddingTop;
        this.f7664p = i8 - paddingBottom;
        this.f7638S = i9;
        if (this.f7636Q) {
            z2 = false;
            m1949s(this.f7653f, 0, false, false);
        } else {
            z2 = false;
        }
        this.f7636Q = z2;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z;
        int i3;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f7620A = Math.min(measuredWidth / 10, this.f7674z);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            boolean z2 = true;
            int i5 = 1073741824;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int i6 = layoutParams2.gravity;
                int i7 = i6 & 7;
                int i8 = i6 & 112;
                if (i8 != 48 && i8 != 80) {
                    z = false;
                } else {
                    z = true;
                }
                if (i7 != 3 && i7 != 5) {
                    z2 = false;
                }
                int i9 = Integer.MIN_VALUE;
                if (z) {
                    i3 = Integer.MIN_VALUE;
                    i9 = 1073741824;
                } else if (z2) {
                    i3 = 1073741824;
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                int i10 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i10 != -2) {
                    if (i10 == -1) {
                        i10 = paddingLeft;
                    }
                    i9 = 1073741824;
                } else {
                    i10 = paddingLeft;
                }
                int i11 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = measuredHeight;
                    }
                } else {
                    i11 = measuredHeight;
                    i5 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i10, i9), View.MeasureSpec.makeMeasureSpec(i11, i5));
                if (z) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i4++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f7667s = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f7668t = true;
        m1945o();
        this.f7668t = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f7675a), 1073741824), this.f7667s);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageScrolled(int i, float f, int i2) {
        int max;
        int i3;
        int left;
        if (this.f7638S > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i5 = layoutParams.gravity & 7;
                    if (i5 != 1) {
                        if (i5 != 3) {
                            if (i5 != 5) {
                                i3 = paddingLeft;
                            } else {
                                max = (width - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i3 = childAt.getWidth() + paddingLeft;
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i3;
                    } else {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i6 = max;
                    i3 = paddingLeft;
                    paddingLeft = i6;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i3;
                }
            }
        }
        OnPageChangeListener onPageChangeListener = this.f7640U;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        ArrayList arrayList = this.f7639T;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.f7639T.get(i7);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i, f, i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f7641V;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i, f, i2);
        }
        if (this.f7644a0 != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt2 = getChildAt(i8);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.f7644a0.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.f7637R = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        q33 m1937g;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (m1937g = m1937g(childAt)) != null && m1937g.f25423b == this.f7653f && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.f7651e;
        ClassLoader classLoader = savedState.f7681d;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f7680c, classLoader);
            m1950t(savedState.f7679b, 0, false, true);
        } else {
            this.f7655g = savedState.f7679b;
            this.f7656h = savedState.f7680c;
            this.f7657i = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7679b = this.f7653f;
        PagerAdapter pagerAdapter = this.f7651e;
        if (pagerAdapter != null) {
            savedState.f7680c = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.f7661m;
            m1947q(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float f;
        if (this.f7632M) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f7651e) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.f7627H == null) {
            this.f7627H = VelocityTracker.obtain();
        }
        this.f7627H.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                m1941k(motionEvent);
                                this.f7622C = motionEvent.getX(motionEvent.findPointerIndex(this.f7626G));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f7622C = motionEvent.getX(actionIndex);
                            this.f7626G = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (this.f7672x) {
                        m1949s(this.f7653f, 0, true, false);
                        z = m1948r();
                    }
                } else {
                    if (!this.f7672x) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f7626G);
                        if (findPointerIndex == -1) {
                            z = m1948r();
                        } else {
                            float x = motionEvent.getX(findPointerIndex);
                            float abs = Math.abs(x - this.f7622C);
                            float y = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y - this.f7623D);
                            if (abs > this.f7621B && abs > abs2) {
                                this.f7672x = true;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                float f2 = this.f7624E;
                                if (x - f2 > RecyclerView.f7068F0) {
                                    f = f2 + this.f7621B;
                                } else {
                                    f = f2 - this.f7621B;
                                }
                                this.f7622C = f;
                                this.f7623D = y;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent2 = getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (this.f7672x) {
                        z = m1944n(motionEvent.getX(motionEvent.findPointerIndex(this.f7626G)));
                    }
                }
            } else if (this.f7672x) {
                VelocityTracker velocityTracker = this.f7627H;
                velocityTracker.computeCurrentVelocity(1000, this.f7629J);
                int xVelocity = (int) velocityTracker.getXVelocity(this.f7626G);
                this.f7670v = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                q33 m1938h = m1938h();
                float f3 = clientWidth;
                m1950t(m1934d(m1938h.f25423b, xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f7626G)) - this.f7624E), ((scrollX / f3) - m1938h.f25426e) / (m1938h.f25425d + (this.f7661m / f3))), xVelocity, true, true);
                z = m1948r();
            }
        } else {
            this.f7658j.abortAnimation();
            this.f7670v = false;
            m1945o();
            float x2 = motionEvent.getX();
            this.f7624E = x2;
            this.f7622C = x2;
            float y2 = motionEvent.getY();
            this.f7625F = y2;
            this.f7623D = y2;
            this.f7626G = motionEvent.getPointerId(0);
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (r10 == r11) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        r9 = null;
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1946p(int i) {
        q33 q33Var;
        String hexString;
        ArrayList arrayList;
        q33 q33Var2;
        q33 q33Var3;
        q33 m1937g;
        q33 q33Var4;
        float paddingLeft;
        float f;
        float f2;
        float f3;
        int i2;
        int i3;
        q33 q33Var5;
        q33 q33Var6;
        q33 q33Var7;
        float paddingRight;
        q33 q33Var8;
        int i4 = this.f7653f;
        if (i4 != i) {
            q33Var = m1939i(i4);
            this.f7653f = i;
        } else {
            q33Var = null;
        }
        if (this.f7651e == null) {
            m1951u();
            return;
        }
        if (this.f7670v) {
            m1951u();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.f7651e.startUpdate((ViewGroup) this);
        int i5 = this.f7671w;
        int max = Math.max(0, this.f7653f - i5);
        int count = this.f7651e.getCount();
        int min = Math.min(count - 1, this.f7653f + i5);
        if (count == this.f7643a) {
            int i6 = 0;
            while (true) {
                arrayList = this.f7645b;
                if (i6 >= arrayList.size()) {
                    break;
                }
                q33Var2 = (q33) arrayList.get(i6);
                int i7 = q33Var2.f25423b;
                int i8 = this.f7653f;
                if (i7 < i8) {
                    i6++;
                }
            }
            if (q33Var2 == null && count > 0) {
                q33Var2 = m1931a(this.f7653f, i6);
            }
            if (q33Var2 != null) {
                int i9 = i6 - 1;
                if (i9 >= 0) {
                    q33Var4 = (q33) arrayList.get(i9);
                } else {
                    q33Var4 = null;
                }
                int clientWidth = getClientWidth();
                if (clientWidth <= 0) {
                    paddingLeft = RecyclerView.f7068F0;
                } else {
                    paddingLeft = (getPaddingLeft() / clientWidth) + (2.0f - q33Var2.f25425d);
                }
                float f4 = RecyclerView.f7068F0;
                for (int i10 = this.f7653f - 1; i10 >= 0; i10--) {
                    if (f4 >= paddingLeft && i10 < max) {
                        if (q33Var4 == null) {
                            break;
                        }
                        if (i10 == q33Var4.f25423b && !q33Var4.f25424c) {
                            arrayList.remove(i9);
                            this.f7651e.destroyItem((ViewGroup) this, i10, q33Var4.f25422a);
                            i9--;
                            i6--;
                            if (i9 >= 0) {
                                q33Var8 = (q33) arrayList.get(i9);
                                q33Var4 = q33Var8;
                            }
                            q33Var8 = null;
                            q33Var4 = q33Var8;
                        }
                    } else if (q33Var4 != null && i10 == q33Var4.f25423b) {
                        f4 += q33Var4.f25425d;
                        i9--;
                        if (i9 >= 0) {
                            q33Var8 = (q33) arrayList.get(i9);
                            q33Var4 = q33Var8;
                        }
                        q33Var8 = null;
                        q33Var4 = q33Var8;
                    } else {
                        f4 += m1931a(i10, i9 + 1).f25425d;
                        i6++;
                        if (i9 >= 0) {
                            q33Var8 = (q33) arrayList.get(i9);
                            q33Var4 = q33Var8;
                        }
                        q33Var8 = null;
                        q33Var4 = q33Var8;
                    }
                }
                float f5 = q33Var2.f25425d;
                int i11 = i6 + 1;
                if (f5 < 2.0f) {
                    if (i11 < arrayList.size()) {
                        q33Var7 = (q33) arrayList.get(i11);
                    } else {
                        q33Var7 = null;
                    }
                    if (clientWidth <= 0) {
                        paddingRight = RecyclerView.f7068F0;
                    } else {
                        paddingRight = (getPaddingRight() / clientWidth) + 2.0f;
                    }
                    int i12 = i11;
                    for (int i13 = this.f7653f + 1; i13 < count; i13++) {
                        if (f5 >= paddingRight && i13 > min) {
                            if (q33Var7 == null) {
                                break;
                            }
                            if (i13 == q33Var7.f25423b && !q33Var7.f25424c) {
                                arrayList.remove(i12);
                                this.f7651e.destroyItem((ViewGroup) this, i13, q33Var7.f25422a);
                                if (i12 < arrayList.size()) {
                                    q33Var7 = (q33) arrayList.get(i12);
                                }
                                q33Var7 = null;
                            }
                        } else if (q33Var7 != null && i13 == q33Var7.f25423b) {
                            f5 += q33Var7.f25425d;
                            i12++;
                            if (i12 < arrayList.size()) {
                                q33Var7 = (q33) arrayList.get(i12);
                            }
                            q33Var7 = null;
                        } else {
                            q33 m1931a = m1931a(i13, i12);
                            i12++;
                            f5 += m1931a.f25425d;
                            if (i12 < arrayList.size()) {
                                q33Var7 = (q33) arrayList.get(i12);
                            }
                            q33Var7 = null;
                        }
                    }
                }
                int count2 = this.f7651e.getCount();
                int clientWidth2 = getClientWidth();
                if (clientWidth2 > 0) {
                    f = this.f7661m / clientWidth2;
                } else {
                    f = RecyclerView.f7068F0;
                }
                if (q33Var != null) {
                    int i14 = q33Var.f25423b;
                    int i15 = q33Var2.f25423b;
                    if (i14 < i15) {
                        float f6 = q33Var.f25426e + q33Var.f25425d + f;
                        int i16 = i14 + 1;
                        int i17 = 0;
                        while (i16 <= q33Var2.f25423b && i17 < arrayList.size()) {
                            Object obj = arrayList.get(i17);
                            while (true) {
                                q33Var6 = (q33) obj;
                                if (i16 <= q33Var6.f25423b || i17 >= arrayList.size() - 1) {
                                    break;
                                }
                                i17++;
                                obj = arrayList.get(i17);
                            }
                            while (i16 < q33Var6.f25423b) {
                                f6 += this.f7651e.getPageWidth(i16) + f;
                                i16++;
                            }
                            q33Var6.f25426e = f6;
                            f6 += q33Var6.f25425d + f;
                            i16++;
                        }
                    } else if (i14 > i15) {
                        int size = arrayList.size() - 1;
                        float f7 = q33Var.f25426e;
                        while (true) {
                            i14--;
                            if (i14 < q33Var2.f25423b || size < 0) {
                                break;
                            }
                            Object obj2 = arrayList.get(size);
                            while (true) {
                                q33Var5 = (q33) obj2;
                                if (i14 >= q33Var5.f25423b || size <= 0) {
                                    break;
                                }
                                size--;
                                obj2 = arrayList.get(size);
                            }
                            while (i14 > q33Var5.f25423b) {
                                f7 -= this.f7651e.getPageWidth(i14) + f;
                                i14--;
                            }
                            f7 -= q33Var5.f25425d + f;
                            q33Var5.f25426e = f7;
                        }
                    }
                }
                int size2 = arrayList.size();
                float f8 = q33Var2.f25426e;
                int i18 = q33Var2.f25423b;
                int i19 = i18 - 1;
                if (i18 == 0) {
                    f2 = f8;
                } else {
                    f2 = -3.4028235E38f;
                }
                this.f7665q = f2;
                int i20 = count2 - 1;
                if (i18 == i20) {
                    f3 = (q33Var2.f25425d + f8) - 1.0f;
                } else {
                    f3 = Float.MAX_VALUE;
                }
                this.f7666r = f3;
                int i21 = i6 - 1;
                while (i21 >= 0) {
                    q33 q33Var9 = (q33) arrayList.get(i21);
                    while (true) {
                        i3 = q33Var9.f25423b;
                        if (i19 <= i3) {
                            break;
                        }
                        f8 -= this.f7651e.getPageWidth(i19) + f;
                        i19--;
                    }
                    f8 -= q33Var9.f25425d + f;
                    q33Var9.f25426e = f8;
                    if (i3 == 0) {
                        this.f7665q = f8;
                    }
                    i21--;
                    i19--;
                }
                float f9 = q33Var2.f25426e + q33Var2.f25425d + f;
                int i22 = q33Var2.f25423b;
                while (true) {
                    i22++;
                    if (i11 >= size2) {
                        break;
                    }
                    q33 q33Var10 = (q33) arrayList.get(i11);
                    while (true) {
                        i2 = q33Var10.f25423b;
                        if (i22 >= i2) {
                            break;
                        }
                        f9 += this.f7651e.getPageWidth(i22) + f;
                        i22++;
                    }
                    if (i2 == i20) {
                        this.f7666r = (q33Var10.f25425d + f9) - 1.0f;
                    }
                    q33Var10.f25426e = f9;
                    f9 += q33Var10.f25425d + f;
                    i11++;
                }
                this.f7651e.setPrimaryItem((ViewGroup) this, this.f7653f, q33Var2.f25422a);
            }
            this.f7651e.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt = getChildAt(i23);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f7678d = i23;
                if (!layoutParams.isDecor && layoutParams.f7675a == RecyclerView.f7068F0 && (m1937g = m1937g(childAt)) != null) {
                    layoutParams.f7675a = m1937g.f25425d;
                    layoutParams.f7677c = m1937g.f25423b;
                }
            }
            m1951u();
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    while (true) {
                        Object parent = findFocus.getParent();
                        if (parent != this) {
                            if (parent == null || !(parent instanceof View)) {
                                break;
                            } else {
                                findFocus = (View) parent;
                            }
                        } else {
                            q33Var3 = m1937g(findFocus);
                            break;
                        }
                    }
                }
                q33Var3 = null;
                if (q33Var3 == null || q33Var3.f25423b != this.f7653f) {
                    for (int i24 = 0; i24 < getChildCount(); i24++) {
                        View childAt2 = getChildAt(i24);
                        q33 m1937g2 = m1937g(childAt2);
                        if (m1937g2 != null && m1937g2.f25423b == this.f7653f && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        try {
            hexString = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException unused) {
            hexString = Integer.toHexString(getId());
        }
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f7643a + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f7651e.getClass());
    }

    /* renamed from: q */
    public final void m1947q(int i, int i2, int i3, int i4) {
        float f;
        if (i2 > 0 && !this.f7645b.isEmpty()) {
            if (!this.f7658j.isFinished()) {
                this.f7658j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
            return;
        }
        q33 m1939i = m1939i(this.f7653f);
        if (m1939i != null) {
            f = Math.min(m1939i.f25426e, this.f7666r);
        } else {
            f = RecyclerView.f7068F0;
        }
        int paddingLeft = (int) (f * ((i - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            m1932b(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    /* renamed from: r */
    public final boolean m1948r() {
        this.f7626G = -1;
        this.f7672x = false;
        this.f7673y = false;
        VelocityTracker velocityTracker = this.f7627H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7627H = null;
        }
        this.f7634O.onRelease();
        this.f7635P.onRelease();
        if (!this.f7634O.isFinished() && !this.f7635P.isFinished()) {
            return false;
        }
        return true;
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        ArrayList arrayList = this.f7642W;
        if (arrayList != null) {
            arrayList.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        ArrayList arrayList = this.f7639T;
        if (arrayList != null) {
            arrayList.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f7668t) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* renamed from: s */
    public final void m1949s(int i, int i2, boolean z, boolean z2) {
        int i3;
        int scrollX;
        int abs;
        q33 m1939i = m1939i(i);
        if (m1939i != null) {
            i3 = (int) (Math.max(this.f7665q, Math.min(m1939i.f25426e, this.f7666r)) * getClientWidth());
        } else {
            i3 = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                Scroller scroller = this.f7658j;
                if (scroller != null && !scroller.isFinished()) {
                    if (this.f7659k) {
                        scrollX = this.f7658j.getCurrX();
                    } else {
                        scrollX = this.f7658j.getStartX();
                    }
                    this.f7658j.abortAnimation();
                    setScrollingCacheEnabled(false);
                } else {
                    scrollX = getScrollX();
                }
                int i4 = scrollX;
                int scrollY = getScrollY();
                int i5 = i3 - i4;
                int i6 = 0 - scrollY;
                if (i5 == 0 && i6 == 0) {
                    m1932b(false);
                    m1945o();
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int clientWidth = getClientWidth();
                    int i7 = clientWidth / 2;
                    float f = clientWidth;
                    float f2 = i7;
                    float sin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i5) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                    int abs2 = Math.abs(i2);
                    if (abs2 > 0) {
                        abs = Math.round(Math.abs(sin / abs2) * 1000.0f) * 4;
                    } else {
                        abs = (int) (((Math.abs(i5) / ((this.f7651e.getPageWidth(this.f7653f) * f) + this.f7661m)) + 1.0f) * 100.0f);
                    }
                    int min = Math.min(abs, 600);
                    this.f7659k = false;
                    this.f7658j.startScroll(i4, scrollY, i5, i6, min);
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
            if (z2) {
                m1935e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1935e(i);
        }
        m1932b(false);
        scrollTo(i3, 0);
        m1943m(i3);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        ArrayList arrayList;
        PagerAdapter pagerAdapter2 = this.f7651e;
        if (pagerAdapter2 != null) {
            synchronized (pagerAdapter2) {
                pagerAdapter2.f7583b = null;
            }
            this.f7651e.startUpdate((ViewGroup) this);
            int i = 0;
            while (true) {
                arrayList = this.f7645b;
                if (i >= arrayList.size()) {
                    break;
                }
                q33 q33Var = (q33) arrayList.get(i);
                this.f7651e.destroyItem((ViewGroup) this, q33Var.f25423b, q33Var.f25422a);
                i++;
            }
            this.f7651e.finishUpdate((ViewGroup) this);
            arrayList.clear();
            int i2 = 0;
            while (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).isDecor) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
            this.f7653f = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f7651e;
        this.f7651e = pagerAdapter;
        this.f7643a = 0;
        if (pagerAdapter != null) {
            if (this.f7660l == null) {
                this.f7660l = new o91(1, this);
            }
            this.f7651e.m1927a(this.f7660l);
            this.f7670v = false;
            boolean z = this.f7636Q;
            this.f7636Q = true;
            this.f7643a = this.f7651e.getCount();
            if (this.f7655g >= 0) {
                this.f7651e.restoreState(this.f7656h, this.f7657i);
                m1950t(this.f7655g, 0, false, true);
                this.f7655g = -1;
                this.f7656h = null;
                this.f7657i = null;
            } else if (!z) {
                m1945o();
            } else {
                requestLayout();
            }
        }
        ArrayList arrayList2 = this.f7642W;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size = this.f7642W.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((OnAdapterChangeListener) this.f7642W.get(i3)).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f7670v = false;
        m1950t(i, 0, !this.f7636Q, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f7671w) {
            this.f7671w = i;
            m1945o();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f7640U = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.f7661m;
        this.f7661m = i;
        int width = getWidth();
        m1947q(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.f7662n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, @Nullable PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, 2);
    }

    public void setScrollState(int i) {
        boolean z;
        int i2;
        if (this.f7654f0 == i) {
            return;
        }
        this.f7654f0 = i;
        if (this.f7644a0 != null) {
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (z) {
                    i2 = this.f7646b0;
                } else {
                    i2 = 0;
                }
                getChildAt(i3).setLayerType(i2, null);
            }
        }
        OnPageChangeListener onPageChangeListener = this.f7640U;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
        ArrayList arrayList = this.f7639T;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.f7639T.get(i4);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f7641V;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: t */
    public final void m1950t(int i, int i2, boolean z, boolean z2) {
        PagerAdapter pagerAdapter = this.f7651e;
        boolean z3 = false;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            ArrayList arrayList = this.f7645b;
            if (!z2 && this.f7653f == i && arrayList.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.f7651e.getCount()) {
                i = this.f7651e.getCount() - 1;
            }
            int i3 = this.f7671w;
            int i4 = this.f7653f;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    ((q33) arrayList.get(i5)).f25424c = true;
                }
            }
            if (this.f7653f != i) {
                z3 = true;
            }
            if (this.f7636Q) {
                this.f7653f = i;
                if (z3) {
                    m1935e(i);
                }
                requestLayout();
                return;
            }
            m1946p(i);
            m1949s(i, i2, z, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    /* renamed from: u */
    public final void m1951u() {
        if (this.f7648c0 != 0) {
            ArrayList arrayList = this.f7650d0;
            if (arrayList == null) {
                this.f7650d0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f7650d0.add(getChildAt(i));
            }
            Collections.sort(this.f7650d0, f7619j0);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f7662n) {
            return false;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public float f7675a;

        /* renamed from: b */
        public boolean f7676b;

        /* renamed from: c */
        public int f7677c;

        /* renamed from: d */
        public int f7678d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
            this.f7675a = RecyclerView.f7068F0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7675a = RecyclerView.f7068F0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f7616g0);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z, @Nullable PageTransformer pageTransformer, int i) {
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.f7644a0 != null);
        this.f7644a0 = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.f7648c0 = z ? 2 : 1;
            this.f7646b0 = i;
        } else {
            this.f7648c0 = 0;
        }
        if (z3) {
            m1945o();
        }
    }

    public void setCurrentItem(int i, boolean z) {
        this.f7670v = false;
        m1950t(i, 0, z, false);
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [q33, java.lang.Object] */
    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7645b = new ArrayList();
        this.f7647c = new Object();
        this.f7649d = new Rect();
        this.f7655g = -1;
        this.f7656h = null;
        this.f7657i = null;
        this.f7665q = -3.4028235E38f;
        this.f7666r = Float.MAX_VALUE;
        this.f7671w = 1;
        this.f7626G = -1;
        this.f7636Q = true;
        this.f7652e0 = new sn1(15, this);
        this.f7654f0 = 0;
        m1940j();
    }
}
