package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.AnimationAnimationListenerC1795se;
import p000.C1832te;
import p000.RunnableC1104d;

/* loaded from: classes.dex */
public class BaseCardView extends FrameLayout {
    public static final int CARD_REGION_VISIBLE_ACTIVATED = 1;
    public static final int CARD_REGION_VISIBLE_ALWAYS = 0;
    public static final int CARD_REGION_VISIBLE_SELECTED = 2;
    public static final int CARD_TYPE_INFO_OVER = 1;
    public static final int CARD_TYPE_INFO_UNDER = 2;
    public static final int CARD_TYPE_INFO_UNDER_WITH_EXTRA = 3;
    public static final int CARD_TYPE_MAIN_ONLY = 0;

    /* renamed from: r */
    public static final int[] f5566r = {android.R.attr.state_pressed};

    /* renamed from: a */
    public int f5567a;

    /* renamed from: b */
    public int f5568b;

    /* renamed from: c */
    public int f5569c;

    /* renamed from: d */
    public final ArrayList f5570d;

    /* renamed from: e */
    public final ArrayList f5571e;

    /* renamed from: f */
    public final ArrayList f5572f;

    /* renamed from: g */
    public int f5573g;

    /* renamed from: h */
    public int f5574h;

    /* renamed from: i */
    public boolean f5575i;

    /* renamed from: j */
    public final int f5576j;

    /* renamed from: k */
    public final int f5577k;

    /* renamed from: l */
    public final int f5578l;

    /* renamed from: m */
    public float f5579m;

    /* renamed from: n */
    public float f5580n;

    /* renamed from: o */
    public float f5581o;

    /* renamed from: p */
    public C1832te f5582p;

    /* renamed from: q */
    public final RunnableC1104d f5583q;

    public BaseCardView(Context context) {
        this(context, null);
    }

    private void setInfoViewVisibility(boolean z) {
        float f;
        int i;
        int i2 = this.f5567a;
        ArrayList arrayList = this.f5571e;
        float f2 = RecyclerView.f7068F0;
        int i3 = 0;
        if (i2 == 3) {
            if (z) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    ((View) arrayList.get(i4)).setVisibility(0);
                }
                return;
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ((View) arrayList.get(i5)).setVisibility(8);
            }
            while (true) {
                ArrayList arrayList2 = this.f5572f;
                if (i3 < arrayList2.size()) {
                    ((View) arrayList2.get(i3)).setVisibility(8);
                    i3++;
                } else {
                    this.f5579m = RecyclerView.f7068F0;
                    return;
                }
            }
        } else {
            if (i2 == 2) {
                if (this.f5568b == 2) {
                    m1383b();
                    if (z) {
                        for (int i6 = 0; i6 < arrayList.size(); i6++) {
                            ((View) arrayList.get(i6)).setVisibility(0);
                        }
                    }
                    if (z) {
                        f2 = 1.0f;
                    }
                    if (this.f5580n != f2) {
                        C1832te c1832te = new C1832te(this, this.f5580n, f2, 1);
                        this.f5582p = c1832te;
                        c1832te.setDuration(this.f5578l);
                        this.f5582p.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.f5582p.setAnimationListener(new AnimationAnimationListenerC1795se(this, 1));
                        startAnimation(this.f5582p);
                        return;
                    }
                    return;
                }
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    View view = (View) arrayList.get(i7);
                    if (z) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    view.setVisibility(i);
                }
                return;
            }
            if (i2 == 1) {
                m1383b();
                if (z) {
                    for (int i8 = 0; i8 < arrayList.size(); i8++) {
                        ((View) arrayList.get(i8)).setVisibility(0);
                    }
                }
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                if (f != this.f5581o) {
                    float f3 = this.f5581o;
                    if (z) {
                        f2 = 1.0f;
                    }
                    C1832te c1832te2 = new C1832te(this, f3, f2, 0);
                    this.f5582p = c1832te2;
                    c1832te2.setDuration(this.f5577k);
                    this.f5582p.setInterpolator(new DecelerateInterpolator());
                    this.f5582p.setAnimationListener(new AnimationAnimationListenerC1795se(this, 2));
                    startAnimation(this.f5582p);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m1382a(boolean z) {
        float f;
        m1383b();
        int i = 0;
        if (z) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f5573g, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                ArrayList arrayList = this.f5572f;
                if (i2 >= arrayList.size()) {
                    break;
                }
                View view = (View) arrayList.get(i2);
                view.setVisibility(0);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredHeight());
                i2++;
            }
            i = i3;
        }
        float f2 = this.f5579m;
        if (z) {
            f = i;
        } else {
            f = RecyclerView.f7068F0;
        }
        C1832te c1832te = new C1832te(this, f2, f, 2);
        this.f5582p = c1832te;
        c1832te.setDuration(this.f5578l);
        this.f5582p.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f5582p.setAnimationListener(new AnimationAnimationListenerC1795se(this, 0));
        startAnimation(this.f5582p);
    }

    /* renamed from: b */
    public final void m1383b() {
        C1832te c1832te = this.f5582p;
        if (c1832te != null) {
            c1832te.cancel();
            this.f5582p = null;
            clearAnimation();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getCardType() {
        return this.f5567a;
    }

    @Deprecated
    public int getExtraVisibility() {
        return this.f5569c;
    }

    public final float getFinalInfoAlpha() {
        if (this.f5567a == 1 && this.f5568b == 2 && !isSelected()) {
            return RecyclerView.f7068F0;
        }
        return 1.0f;
    }

    public final float getFinalInfoVisFraction() {
        if (this.f5567a == 2 && this.f5568b == 2 && !isSelected()) {
            return RecyclerView.f7068F0;
        }
        return 1.0f;
    }

    public int getInfoVisibility() {
        return this.f5568b;
    }

    public boolean isSelectedAnimationDelayed() {
        return this.f5575i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : super.onCreateDrawableState(i)) {
            if (i2 == 16842919) {
                z = true;
            }
            if (i2 == 16842910) {
                z2 = true;
            }
        }
        if (z && z2) {
            return View.PRESSED_ENABLED_STATE_SET;
        }
        if (z) {
            return f5566r;
        }
        if (z2) {
            return View.ENABLED_STATE_SET;
        }
        return View.EMPTY_STATE_SET;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f5583q);
        m1383b();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ArrayList arrayList;
        float paddingTop = getPaddingTop();
        int i5 = 0;
        while (true) {
            ArrayList arrayList2 = this.f5570d;
            if (i5 >= arrayList2.size()) {
                break;
            }
            View view = (View) arrayList2.get(i5);
            if (view.getVisibility() != 8) {
                view.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.f5573g, (int) (view.getMeasuredHeight() + paddingTop));
                paddingTop += view.getMeasuredHeight();
            }
            i5++;
        }
        if (this.f5567a != 0) {
            int i6 = 0;
            float f = 0.0f;
            while (true) {
                arrayList = this.f5571e;
                if (i6 >= arrayList.size()) {
                    break;
                }
                f += ((View) arrayList.get(i6)).getMeasuredHeight();
                i6++;
            }
            int i7 = this.f5567a;
            if (i7 == 1) {
                paddingTop -= f;
                if (paddingTop < RecyclerView.f7068F0) {
                    paddingTop = 0.0f;
                }
            } else if (i7 == 2) {
                if (this.f5568b == 2) {
                    f *= this.f5580n;
                }
            } else {
                paddingTop -= this.f5579m;
            }
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                View view2 = (View) arrayList.get(i8);
                if (view2.getVisibility() != 8) {
                    int measuredHeight = view2.getMeasuredHeight();
                    if (measuredHeight > f) {
                        measuredHeight = (int) f;
                    }
                    float f2 = measuredHeight;
                    paddingTop += f2;
                    view2.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.f5573g, (int) paddingTop);
                    f -= f2;
                    if (f <= RecyclerView.f7068F0) {
                        break;
                    }
                }
            }
            if (this.f5567a == 3) {
                int i9 = 0;
                while (true) {
                    ArrayList arrayList3 = this.f5572f;
                    if (i9 >= arrayList3.size()) {
                        break;
                    }
                    View view3 = (View) arrayList3.get(i9);
                    if (view3.getVisibility() != 8) {
                        view3.layout(getPaddingLeft(), (int) paddingTop, getPaddingLeft() + this.f5573g, (int) (view3.getMeasuredHeight() + paddingTop));
                        paddingTop += view3.getMeasuredHeight();
                    }
                    i9++;
                }
            }
        }
        onSizeChanged(0, 0, i3 - i, i4 - i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0036, code lost:
    
        if (r16.f5580n > androidx.recyclerview.widget.RecyclerView.f7068F0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096 A[EDGE_INSN: B:42:0x0096->B:43:0x0096 BREAK  A[LOOP:0: B:21:0x005d->B:32:0x0093], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0169  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        boolean z5;
        int i5;
        int i6;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        this.f5573g = 0;
        this.f5574h = 0;
        ArrayList arrayList = this.f5570d;
        arrayList.clear();
        ArrayList arrayList2 = this.f5571e;
        arrayList2.clear();
        ArrayList arrayList3 = this.f5572f;
        arrayList3.clear();
        int childCount = getChildCount();
        int i7 = this.f5567a;
        if (i7 != 0) {
            z = true;
        } else {
            z = false;
        }
        float f = RecyclerView.f7068F0;
        if (z) {
            int i8 = this.f5568b;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 == 2) {
                        if (i7 != 2) {
                            z9 = isSelected();
                        }
                    }
                    z9 = false;
                } else {
                    z9 = isActivated();
                }
                if (z9) {
                    z2 = true;
                    if (this.f5567a != 3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3 && this.f5579m > RecyclerView.f7068F0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i3 = 0;
                    while (true) {
                        int i9 = 8;
                        if (i3 < childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        if (childAt != null) {
                            int i10 = ((LayoutParams) childAt.getLayoutParams()).viewType;
                            if (i10 == 1) {
                                childAt.setAlpha(this.f5581o);
                                arrayList2.add(childAt);
                                if (z2) {
                                    i9 = 0;
                                }
                                childAt.setVisibility(i9);
                            } else if (i10 == 2) {
                                arrayList3.add(childAt);
                                if (z4) {
                                    i9 = 0;
                                }
                                childAt.setVisibility(i9);
                            } else {
                                arrayList.add(childAt);
                                childAt.setVisibility(0);
                            }
                        }
                        i3++;
                    }
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i11 = 0;
                    int i12 = 0;
                    for (i4 = 0; i4 < arrayList.size(); i4++) {
                        View view = (View) arrayList.get(i4);
                        if (view.getVisibility() != 8) {
                            measureChild(view, makeMeasureSpec, makeMeasureSpec);
                            this.f5573g = Math.max(this.f5573g, view.getMeasuredWidth());
                            i11 += view.getMeasuredHeight();
                            i12 = View.combineMeasuredStates(i12, view.getMeasuredState());
                        }
                    }
                    setPivotX(this.f5573g / 2);
                    setPivotY(i11 / 2);
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f5573g, 1073741824);
                    if (this.f5567a == 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        i6 = 0;
                        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                            View view2 = (View) arrayList2.get(i13);
                            if (view2.getVisibility() != 8) {
                                measureChild(view2, makeMeasureSpec2, makeMeasureSpec);
                                if (this.f5567a != 1) {
                                    i6 += view2.getMeasuredHeight();
                                }
                                i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
                            }
                        }
                        if (this.f5567a == 3) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            i5 = 0;
                            for (int i14 = 0; i14 < arrayList3.size(); i14++) {
                                View view3 = (View) arrayList3.get(i14);
                                if (view3.getVisibility() != 8) {
                                    measureChild(view3, makeMeasureSpec2, makeMeasureSpec);
                                    i5 += view3.getMeasuredHeight();
                                    i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
                                }
                            }
                        } else {
                            i5 = 0;
                        }
                    } else {
                        i5 = 0;
                        i6 = 0;
                    }
                    if (this.f5567a == 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (!z6 && this.f5568b == 2) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    float f2 = i11;
                    float f3 = i6;
                    if (z7) {
                        f3 *= this.f5580n;
                    }
                    float f4 = f2 + f3 + i5;
                    if (!z7) {
                        f = this.f5579m;
                    }
                    this.f5574h = (int) (f4 - f);
                    setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + this.f5573g, i, i12), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + this.f5574h, i2, i12 << 16));
                }
            }
            z9 = true;
            if (z9) {
            }
        }
        z2 = false;
        if (this.f5567a != 3) {
        }
        if (!z3) {
        }
        z4 = false;
        i3 = 0;
        while (true) {
            int i92 = 8;
            if (i3 < childCount) {
            }
            i3++;
        }
        int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int i112 = 0;
        int i122 = 0;
        while (i4 < arrayList.size()) {
        }
        setPivotX(this.f5573g / 2);
        setPivotY(i112 / 2);
        int makeMeasureSpec22 = View.MeasureSpec.makeMeasureSpec(this.f5573g, 1073741824);
        if (this.f5567a == 0) {
        }
        if (!z5) {
        }
        if (this.f5567a == 0) {
        }
        if (!z6) {
        }
        z7 = false;
        float f22 = i112;
        float f32 = i6;
        if (z7) {
        }
        float f42 = f22 + f32 + i5;
        if (!z7) {
        }
        this.f5574h = (int) (f42 - f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + this.f5573g, i, i122), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + this.f5574h, i2, i122 << 16));
    }

    @Override // android.view.View
    public void setActivated(boolean z) {
        if (z != isActivated()) {
            super.setActivated(z);
            if (this.f5567a != 0) {
                int i = this.f5568b;
                boolean z2 = true;
                if (i == 1) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                z2 = false;
                            } else {
                                z2 = isSelected();
                            }
                        } else {
                            z2 = isActivated();
                        }
                    }
                    setInfoViewVisibility(z2);
                }
            }
        }
    }

    public void setCardType(int i) {
        if (this.f5567a != i) {
            if (i >= 0 && i < 4) {
                this.f5567a = i;
            } else {
                Log.e("BaseCardView", "Invalid card type specified: " + i + ". Defaulting to type CARD_TYPE_MAIN_ONLY.");
                this.f5567a = 0;
            }
            requestLayout();
        }
    }

    @Deprecated
    public void setExtraVisibility(int i) {
        if (this.f5569c != i) {
            this.f5569c = i;
        }
    }

    public void setInfoVisibility(int i) {
        if (this.f5568b != i) {
            m1383b();
            this.f5568b = i;
            this.f5580n = getFinalInfoVisFraction();
            requestLayout();
            float finalInfoAlpha = getFinalInfoAlpha();
            if (finalInfoAlpha != this.f5581o) {
                this.f5581o = finalInfoAlpha;
                int i2 = 0;
                while (true) {
                    ArrayList arrayList = this.f5571e;
                    if (i2 < arrayList.size()) {
                        ((View) arrayList.get(i2)).setAlpha(this.f5581o);
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        if (z != isSelected()) {
            super.setSelected(z);
            boolean isSelected = isSelected();
            RunnableC1104d runnableC1104d = this.f5583q;
            removeCallbacks(runnableC1104d);
            if (this.f5567a == 3) {
                if (isSelected) {
                    if (!this.f5575i) {
                        post(runnableC1104d);
                        this.f5575i = true;
                        return;
                    } else {
                        postDelayed(runnableC1104d, this.f5576j);
                        return;
                    }
                }
                m1382a(false);
                return;
            }
            if (this.f5568b == 2) {
                setInfoViewVisibility(isSelected);
            }
        }
    }

    public void setSelectedAnimationDelayed(boolean z) {
        this.f5575i = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public String toString() {
        return super.toString();
    }

    public BaseCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.baseCardViewStyle);
    }

    @SuppressLint({"CustomViewStyleable"})
    public BaseCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5583q = new RunnableC1104d(7, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbBaseCardView, i, 0);
        try {
            this.f5567a = obtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_cardType, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbBaseCardView_cardForeground);
            if (drawable != null) {
                setForeground(drawable);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbBaseCardView_cardBackground);
            if (drawable2 != null) {
                setBackground(drawable2);
            }
            this.f5568b = obtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_infoVisibility, 1);
            int integer = obtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_extraVisibility, 2);
            this.f5569c = integer;
            int i2 = this.f5568b;
            if (integer < i2) {
                this.f5569c = i2;
            }
            this.f5576j = obtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_selectedAnimationDelay, getResources().getInteger(androidx.leanback.R.integer.lb_card_selected_animation_delay));
            this.f5578l = obtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_selectedAnimationDuration, getResources().getInteger(androidx.leanback.R.integer.lb_card_selected_animation_duration));
            this.f5577k = obtainStyledAttributes.getInteger(androidx.leanback.R.styleable.lbBaseCardView_activatedAnimationDuration, getResources().getInteger(androidx.leanback.R.integer.lb_card_activated_animation_duration));
            obtainStyledAttributes.recycle();
            this.f5575i = true;
            this.f5570d = new ArrayList();
            this.f5571e = new ArrayList();
            this.f5572f = new ArrayList();
            this.f5579m = RecyclerView.f7068F0;
            this.f5580n = getFinalInfoVisFraction();
            this.f5581o = getFinalInfoAlpha();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int VIEW_TYPE_EXTRA = 2;
        public static final int VIEW_TYPE_INFO = 1;
        public static final int VIEW_TYPE_MAIN = 0;

        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = 0, to = "MAIN"), @ViewDebug.IntToString(from = 1, to = "INFO"), @ViewDebug.IntToString(from = 2, to = "EXTRA")})
        public int viewType;

        @SuppressLint({"CustomViewStyleable"})
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.viewType = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbBaseCardView_Layout);
            this.viewType = obtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbBaseCardView_Layout_layout_viewType, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.viewType = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.viewType = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.viewType = 0;
            this.viewType = layoutParams.viewType;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
