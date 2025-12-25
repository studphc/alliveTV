package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import p000.C0580c4;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    public boolean f1018a;

    /* renamed from: b */
    public ScrollingTabContainerView f1019b;

    /* renamed from: c */
    public View f1020c;

    /* renamed from: d */
    public View f1021d;

    /* renamed from: e */
    public Drawable f1022e;

    /* renamed from: f */
    public Drawable f1023f;

    /* renamed from: g */
    public Drawable f1024g;

    /* renamed from: h */
    public final boolean f1025h;

    /* renamed from: i */
    public boolean f1026i;

    /* renamed from: j */
    public final int f1027j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static int m232a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1022e;
        if (drawable != null && drawable.isStateful()) {
            this.f1022e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1023f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1023f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1024g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1024g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1019b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1022e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1023f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1024g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1020c = findViewById(R.id.action_bar);
        this.f1021d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f1018a && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        ScrollingTabContainerView scrollingTabContainerView = this.f1019b;
        boolean z3 = true;
        boolean z4 = false;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) scrollingTabContainerView.getLayoutParams();
            int measuredHeight2 = measuredHeight - scrollingTabContainerView.getMeasuredHeight();
            int i5 = layoutParams.bottomMargin;
            scrollingTabContainerView.layout(i, measuredHeight2 - i5, i3, measuredHeight - i5);
        }
        if (this.f1025h) {
            Drawable drawable2 = this.f1024g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z3 = z4;
        } else {
            if (this.f1022e != null) {
                if (this.f1020c.getVisibility() == 0) {
                    this.f1022e.setBounds(this.f1020c.getLeft(), this.f1020c.getTop(), this.f1020c.getRight(), this.f1020c.getBottom());
                } else {
                    View view = this.f1021d;
                    if (view != null && view.getVisibility() == 0) {
                        this.f1022e.setBounds(this.f1021d.getLeft(), this.f1021d.getTop(), this.f1021d.getRight(), this.f1021d.getBottom());
                    } else {
                        this.f1022e.setBounds(0, 0, 0, 0);
                    }
                }
                z4 = true;
            }
            this.f1026i = z2;
            if (z2 && (drawable = this.f1023f) != null) {
                drawable.setBounds(scrollingTabContainerView.getLeft(), scrollingTabContainerView.getTop(), scrollingTabContainerView.getRight(), scrollingTabContainerView.getBottom());
            }
            z3 = z4;
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (this.f1020c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i5 = this.f1027j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1020c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        ScrollingTabContainerView scrollingTabContainerView = this.f1019b;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8 && mode != 1073741824) {
            View view = this.f1020c;
            if (view != null && view.getVisibility() != 8 && view.getMeasuredHeight() != 0) {
                i3 = m232a(this.f1020c);
            } else {
                View view2 = this.f1021d;
                if (view2 != null && view2.getVisibility() != 8 && view2.getMeasuredHeight() != 0) {
                    i3 = m232a(this.f1021d);
                } else {
                    i3 = 0;
                }
            }
            if (mode == Integer.MIN_VALUE) {
                i4 = View.MeasureSpec.getSize(i2);
            } else {
                i4 = Integer.MAX_VALUE;
            }
            setMeasuredDimension(getMeasuredWidth(), Math.min(m232a(this.f1019b) + i3, i4));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1022e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1022e);
        }
        this.f1022e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1020c;
            if (view != null) {
                this.f1022e.setBounds(view.getLeft(), this.f1020c.getTop(), this.f1020c.getRight(), this.f1020c.getBottom());
            }
        }
        boolean z = false;
        if (!this.f1025h ? !(this.f1022e != null || this.f1023f != null) : this.f1024g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1024g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1024g);
        }
        this.f1024g = drawable;
        boolean z = this.f1025h;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f1024g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.f1022e != null || this.f1023f != null) : this.f1024g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1023f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1023f);
        }
        this.f1023f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1026i && (drawable2 = this.f1023f) != null) {
                drawable2.setBounds(this.f1019b.getLeft(), this.f1019b.getTop(), this.f1019b.getRight(), this.f1019b.getBottom());
            }
        }
        boolean z = false;
        if (!this.f1025h ? !(this.f1022e != null || this.f1023f != null) : this.f1024g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.f1019b;
        if (scrollingTabContainerView2 != null) {
            removeView(scrollingTabContainerView2);
        }
        this.f1019b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        int i;
        this.f1018a = z;
        if (z) {
            i = 393216;
        } else {
            i = 262144;
        }
        setDescendantFocusability(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.f1022e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f1023f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f1024g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = this.f1022e;
        boolean z = this.f1025h;
        if ((drawable == drawable2 && !z) || ((drawable == this.f1023f && this.f1026i) || ((drawable == this.f1024g && z) || super.verifyDrawable(drawable)))) {
            return true;
        }
        return false;
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C0580c4(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f1022e = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f1023f = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f1027j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R.id.split_action_bar) {
            this.f1025h = true;
            this.f1024g = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1025h ? this.f1022e != null || this.f1023f != null : this.f1024g != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }
}
