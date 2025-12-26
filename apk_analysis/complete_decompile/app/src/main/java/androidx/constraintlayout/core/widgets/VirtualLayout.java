package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* loaded from: classes.dex */
public class VirtualLayout extends HelperWidget {

    /* renamed from: J */
    public int f2550J = 0;

    /* renamed from: K */
    public int f2551K = 0;

    /* renamed from: L */
    public int f2552L = 0;

    /* renamed from: M */
    public int f2553M = 0;

    /* renamed from: N */
    public int f2554N = 0;

    /* renamed from: O */
    public int f2555O = 0;

    /* renamed from: P */
    public boolean f2556P = false;

    /* renamed from: Q */
    public int f2557Q = 0;

    /* renamed from: R */
    public int f2558R = 0;
    protected BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();

    /* renamed from: S */
    public BasicMeasure.Measurer f2559S = null;

    public void applyRtl(boolean z) {
        int i = this.f2552L;
        if (i > 0 || this.f2553M > 0) {
            if (z) {
                this.f2554N = this.f2553M;
                this.f2555O = i;
            } else {
                this.f2554N = i;
                this.f2555O = this.f2553M;
            }
        }
    }

    public void captureWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public boolean contains(HashSet<ConstraintWidget> hashSet) {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            if (hashSet.contains(this.mWidgets[i])) {
                return true;
            }
        }
        return false;
    }

    public int getMeasuredHeight() {
        return this.f2558R;
    }

    public int getMeasuredWidth() {
        return this.f2557Q;
    }

    public int getPaddingBottom() {
        return this.f2551K;
    }

    public int getPaddingLeft() {
        return this.f2554N;
    }

    public int getPaddingRight() {
        return this.f2555O;
    }

    public int getPaddingTop() {
        return this.f2550J;
    }

    public void measure(int i, int i2, int i3, int i4) {
    }

    public boolean measureChildren() {
        BasicMeasure.Measurer measurer;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null) {
            measurer = ((ConstraintWidgetContainer) constraintWidget).getMeasurer();
        } else {
            measurer = null;
        }
        if (measurer == null) {
            return false;
        }
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.mMeasure;
                    measure.horizontalBehavior = dimensionBehaviour;
                    measure.verticalBehavior = dimensionBehaviour2;
                    measure.horizontalDimension = constraintWidget2.getWidth();
                    this.mMeasure.verticalDimension = constraintWidget2.getHeight();
                    measurer.measure(constraintWidget2, this.mMeasure);
                    constraintWidget2.setWidth(this.mMeasure.measuredWidth);
                    constraintWidget2.setHeight(this.mMeasure.measuredHeight);
                    constraintWidget2.setBaselineDistance(this.mMeasure.measuredBaseline);
                }
            }
        }
        return true;
    }

    public boolean needSolverPass() {
        return this.f2556P;
    }

    public void needsCallbackFromSolver(boolean z) {
        this.f2556P = z;
    }

    public void setMeasure(int i, int i2) {
        this.f2557Q = i;
        this.f2558R = i2;
    }

    public void setPadding(int i) {
        this.f2550J = i;
        this.f2551K = i;
        this.f2552L = i;
        this.f2553M = i;
    }

    public void setPaddingBottom(int i) {
        this.f2551K = i;
    }

    public void setPaddingEnd(int i) {
        this.f2553M = i;
    }

    public void setPaddingLeft(int i) {
        this.f2554N = i;
    }

    public void setPaddingRight(int i) {
        this.f2555O = i;
    }

    public void setPaddingStart(int i) {
        this.f2552L = i;
        this.f2554N = i;
        this.f2555O = i;
    }

    public void setPaddingTop(int i) {
        this.f2550J = i;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }

    public void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.f2559S == null && getParent() != null) {
            this.f2559S = ((ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.f2559S.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }
}
