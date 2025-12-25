package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class Layer extends ConstraintHelper {

    /* renamed from: b */
    public float f2663b;

    /* renamed from: c */
    public float f2664c;

    /* renamed from: d */
    public float f2665d;

    /* renamed from: e */
    public ConstraintLayout f2666e;

    /* renamed from: f */
    public float f2667f;

    /* renamed from: g */
    public float f2668g;

    /* renamed from: h */
    public final boolean f2669h;

    /* renamed from: i */
    public View[] f2670i;

    /* renamed from: j */
    public float f2671j;

    /* renamed from: k */
    public float f2672k;

    /* renamed from: l */
    public boolean f2673l;

    /* renamed from: m */
    public boolean f2674m;
    protected float mComputedCenterX;
    protected float mComputedCenterY;
    protected float mComputedMaxX;
    protected float mComputedMaxY;
    protected float mComputedMinX;
    protected float mComputedMinY;

    public Layer(Context context) {
        super(context);
        this.f2663b = Float.NaN;
        this.f2664c = Float.NaN;
        this.f2665d = Float.NaN;
        this.f2667f = 1.0f;
        this.f2668g = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.f2669h = true;
        this.f2670i = null;
        this.f2671j = RecyclerView.f7068F0;
        this.f2672k = RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
        applyLayoutFeatures(constraintLayout);
    }

    public void calcCenters() {
        if (this.f2666e == null) {
            return;
        }
        if (!this.f2669h && !Float.isNaN(this.mComputedCenterX) && !Float.isNaN(this.mComputedCenterY)) {
            return;
        }
        if (!Float.isNaN(this.f2663b) && !Float.isNaN(this.f2664c)) {
            this.mComputedCenterY = this.f2664c;
            this.mComputedCenterX = this.f2663b;
            return;
        }
        View[] views = getViews(this.f2666e);
        int left = views[0].getLeft();
        int top = views[0].getTop();
        int right = views[0].getRight();
        int bottom = views[0].getBottom();
        for (int i = 0; i < this.mCount; i++) {
            View view = views[i];
            left = Math.min(left, view.getLeft());
            top = Math.min(top, view.getTop());
            right = Math.max(right, view.getRight());
            bottom = Math.max(bottom, view.getBottom());
        }
        this.mComputedMaxX = right;
        this.mComputedMaxY = bottom;
        this.mComputedMinX = left;
        this.mComputedMinY = top;
        if (Float.isNaN(this.f2663b)) {
            this.mComputedCenterX = (left + right) / 2;
        } else {
            this.mComputedCenterX = this.f2663b;
        }
        if (Float.isNaN(this.f2664c)) {
            this.mComputedCenterY = (top + bottom) / 2;
        } else {
            this.mComputedCenterY = this.f2664c;
        }
    }

    /* renamed from: f */
    public final void m550f() {
        int i;
        if (this.f2666e == null || (i = this.mCount) == 0) {
            return;
        }
        View[] viewArr = this.f2670i;
        if (viewArr == null || viewArr.length != i) {
            this.f2670i = new View[i];
        }
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.f2670i[i2] = this.f2666e.getViewById(this.mIds[i2]);
        }
    }

    /* renamed from: g */
    public final void m551g() {
        double radians;
        if (this.f2666e == null) {
            return;
        }
        if (this.f2670i == null) {
            m550f();
        }
        calcCenters();
        if (Float.isNaN(this.f2665d)) {
            radians = 0.0d;
        } else {
            radians = Math.toRadians(this.f2665d);
        }
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f = this.f2667f;
        float f2 = f * cos;
        float f3 = this.f2668g;
        float f4 = (-f3) * sin;
        float f5 = f * sin;
        float f6 = f3 * cos;
        for (int i = 0; i < this.mCount; i++) {
            View view = this.f2670i[i];
            int right = (view.getRight() + view.getLeft()) / 2;
            int bottom = (view.getBottom() + view.getTop()) / 2;
            float f7 = right - this.mComputedCenterX;
            float f8 = bottom - this.mComputedCenterY;
            float f9 = (((f4 * f8) + (f2 * f7)) - f7) + this.f2671j;
            float f10 = (((f6 * f8) + (f7 * f5)) - f8) + this.f2672k;
            view.setTranslationX(f9);
            view.setTranslationY(f10);
            view.setScaleY(this.f2668g);
            view.setScaleX(this.f2667f);
            if (!Float.isNaN(this.f2665d)) {
                view.setRotation(this.f2665d);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f2673l = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f2674m = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2666e = (ConstraintLayout) getParent();
        if (this.f2673l || this.f2674m) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.mCount; i++) {
                View viewById = this.f2666e.getViewById(this.mIds[i]);
                if (viewById != null) {
                    if (this.f2673l) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f2674m && elevation > RecyclerView.f7068F0) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        this.f2663b = f;
        m551g();
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        this.f2664c = f;
        m551g();
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.f2665d = f;
        m551g();
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.f2667f = f;
        m551g();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        this.f2668g = f;
        m551g();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        this.f2671j = f;
        m551g();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        this.f2672k = f;
        m551g();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        m550f();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        constraintWidget.setWidth(0);
        constraintWidget.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), getPaddingRight() + ((int) this.mComputedMaxX), getPaddingBottom() + ((int) this.mComputedMaxY));
        m551g();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.f2666e = constraintLayout;
        float rotation = getRotation();
        if (rotation == RecyclerView.f7068F0) {
            if (!Float.isNaN(this.f2665d)) {
                this.f2665d = rotation;
                return;
            }
            return;
        }
        this.f2665d = rotation;
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2663b = Float.NaN;
        this.f2664c = Float.NaN;
        this.f2665d = Float.NaN;
        this.f2667f = 1.0f;
        this.f2668g = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.f2669h = true;
        this.f2670i = null;
        this.f2671j = RecyclerView.f7068F0;
        this.f2672k = RecyclerView.f7068F0;
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2663b = Float.NaN;
        this.f2664c = Float.NaN;
        this.f2665d = Float.NaN;
        this.f2667f = 1.0f;
        this.f2668g = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.f2669h = true;
        this.f2670i = null;
        this.f2671j = RecyclerView.f7068F0;
        this.f2672k = RecyclerView.f7068F0;
    }
}
