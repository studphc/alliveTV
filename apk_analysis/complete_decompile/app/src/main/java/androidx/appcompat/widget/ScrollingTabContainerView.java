package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.ue2;
import p000.ve2;
import p000.we2;
import p000.xy1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j */
    public static final DecelerateInterpolator f1346j = new DecelerateInterpolator();

    /* renamed from: a */
    public xy1 f1347a;

    /* renamed from: b */
    public ve2 f1348b;

    /* renamed from: c */
    public final LinearLayoutCompat f1349c;

    /* renamed from: d */
    public AppCompatSpinner f1350d;

    /* renamed from: e */
    public boolean f1351e;

    /* renamed from: f */
    public int f1352f;

    /* renamed from: g */
    public int f1353g;

    /* renamed from: h */
    public int f1354h;

    /* renamed from: i */
    public int f1355i;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimator mVisibilityAnim;

    /* loaded from: classes.dex */
    public class VisibilityAnimListener extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f1356a = false;

        /* renamed from: b */
        public int f1357b;

        public VisibilityAnimListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1356a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1356a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.mVisibilityAnim = null;
            scrollingTabContainerView.setVisibility(this.f1357b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1356a = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.f1357b = i;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimator;
            return this;
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        this.mVisAnimListener = new VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f1353g = actionBarPolicy.getStackedTabMaxWidth();
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        this.f1349c = linearLayoutCompat;
        addView(linearLayoutCompat, new ViewGroup.LayoutParams(-2, -1));
    }

    /* renamed from: a */
    public final we2 m260a(ActionBar.Tab tab, boolean z) {
        we2 we2Var = new we2(this, getContext(), tab, z);
        if (z) {
            we2Var.setBackgroundDrawable(null);
            we2Var.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1354h));
        } else {
            we2Var.setFocusable(true);
            if (this.f1348b == null) {
                this.f1348b = new ve2(this);
            }
            we2Var.setOnClickListener(this.f1348b);
        }
        return we2Var;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        we2 m260a = m260a(tab, false);
        this.f1349c.addView(m260a, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        AppCompatSpinner appCompatSpinner = this.f1350d;
        if (appCompatSpinner != null) {
            ((ue2) appCompatSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            m260a.setSelected(true);
        }
        if (this.f1351e) {
            requestLayout();
        }
    }

    public void animateToTab(int i) {
        View childAt = this.f1349c.getChildAt(i);
        Runnable runnable = this.f1347a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        xy1 xy1Var = new xy1(14, this, childAt);
        this.f1347a = xy1Var;
        post(xy1Var);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        DecelerateInterpolator decelerateInterpolator = f1346j;
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(RecyclerView.f7068F0);
            }
            ViewPropertyAnimator alpha = animate().alpha(1.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(decelerateInterpolator);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i));
            alpha.start();
            return;
        }
        ViewPropertyAnimator alpha2 = animate().alpha(RecyclerView.f7068F0);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(decelerateInterpolator);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i));
        alpha2.start();
    }

    /* renamed from: b */
    public final void m261b() {
        boolean z;
        AppCompatSpinner appCompatSpinner = this.f1350d;
        if (appCompatSpinner != null && appCompatSpinner.getParent() == this) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return;
        }
        removeView(this.f1350d);
        addView(this.f1349c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1350d.getSelectedItemPosition());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xy1 xy1Var = this.f1347a;
        if (xy1Var != null) {
            post(xy1Var);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f1353g = actionBarPolicy.getStackedTabMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xy1 xy1Var = this.f1347a;
        if (xy1Var != null) {
            removeCallbacks(xy1Var);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((we2) view).f28160a.select();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int mode = View.MeasureSpec.getMode(i);
        if (mode == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        setFillViewport(z);
        LinearLayoutCompat linearLayoutCompat = this.f1349c;
        int childCount = linearLayoutCompat.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f1352f = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f1352f = View.MeasureSpec.getSize(i) / 2;
            }
            this.f1352f = Math.min(this.f1352f, this.f1353g);
        } else {
            this.f1352f = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1354h, 1073741824);
        if (!z && this.f1351e) {
            linearLayoutCompat.measure(0, makeMeasureSpec);
            if (linearLayoutCompat.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                AppCompatSpinner appCompatSpinner = this.f1350d;
                if (appCompatSpinner == null || appCompatSpinner.getParent() != this) {
                    if (this.f1350d == null) {
                        AppCompatSpinner appCompatSpinner2 = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
                        appCompatSpinner2.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                        appCompatSpinner2.setOnItemSelectedListener(this);
                        this.f1350d = appCompatSpinner2;
                    }
                    removeView(linearLayoutCompat);
                    addView(this.f1350d, new ViewGroup.LayoutParams(-2, -1));
                    if (this.f1350d.getAdapter() == null) {
                        this.f1350d.setAdapter((SpinnerAdapter) new ue2(this));
                    }
                    Runnable runnable = this.f1347a;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                        this.f1347a = null;
                    }
                    this.f1350d.setSelection(this.f1355i);
                }
            } else {
                m261b();
            }
        } else {
            m261b();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1355i);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f1349c.removeAllViews();
        AppCompatSpinner appCompatSpinner = this.f1350d;
        if (appCompatSpinner != null) {
            ((ue2) appCompatSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1351e) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.f1349c.removeViewAt(i);
        AppCompatSpinner appCompatSpinner = this.f1350d;
        if (appCompatSpinner != null) {
            ((ue2) appCompatSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1351e) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.f1351e = z;
    }

    public void setContentHeight(int i) {
        this.f1354h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        boolean z;
        this.f1355i = i;
        LinearLayoutCompat linearLayoutCompat = this.f1349c;
        int childCount = linearLayoutCompat.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayoutCompat.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
        }
        AppCompatSpinner appCompatSpinner = this.f1350d;
        if (appCompatSpinner != null && i >= 0) {
            appCompatSpinner.setSelection(i);
        }
    }

    public void updateTab(int i) {
        ((we2) this.f1349c.getChildAt(i)).m8056a();
        AppCompatSpinner appCompatSpinner = this.f1350d;
        if (appCompatSpinner != null) {
            ((ue2) appCompatSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1351e) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        we2 m260a = m260a(tab, false);
        this.f1349c.addView(m260a, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        AppCompatSpinner appCompatSpinner = this.f1350d;
        if (appCompatSpinner != null) {
            ((ue2) appCompatSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            m260a.setSelected(true);
        }
        if (this.f1351e) {
            requestLayout();
        }
    }
}
