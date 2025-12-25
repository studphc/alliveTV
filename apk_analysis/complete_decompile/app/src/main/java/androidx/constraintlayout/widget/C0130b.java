package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import p000.AbstractC1099cv;

/* renamed from: androidx.constraintlayout.widget.b */
/* loaded from: classes.dex */
public final class C0130b implements BasicMeasure.Measurer {

    /* renamed from: a */
    public final ConstraintLayout f3215a;

    /* renamed from: b */
    public int f3216b;

    /* renamed from: c */
    public int f3217c;

    /* renamed from: d */
    public int f3218d;

    /* renamed from: e */
    public int f3219e;

    /* renamed from: f */
    public int f3220f;

    /* renamed from: g */
    public int f3221g;

    /* renamed from: h */
    public final /* synthetic */ ConstraintLayout f3222h;

    public C0130b(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f3222h = constraintLayout;
        this.f3215a = constraintLayout2;
    }

    /* renamed from: a */
    public static boolean m662a(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824 && ((mode == Integer.MIN_VALUE || mode == 0) && i3 == size)) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public final void didMeasures() {
        ConstraintLayout constraintLayout = this.f3215a;
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(constraintLayout);
            }
        }
        int size = constraintLayout.f3140b.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                ((ConstraintHelper) constraintLayout.f3140b.get(i2)).updatePostMeasure(constraintLayout);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
        long j;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int baseline;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        int i8;
        if (constraintWidget == null) {
            return;
        }
        if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
            measure.measuredWidth = 0;
            measure.measuredHeight = 0;
            measure.measuredBaseline = 0;
            return;
        }
        if (constraintWidget.getParent() == null) {
            return;
        }
        ConstraintLayout constraintLayout = this.f3222h;
        Metrics metrics = constraintLayout.f3152n;
        if (metrics != null) {
            metrics.mNumberOfMeasures++;
            j = System.nanoTime();
        } else {
            j = 0;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.verticalBehavior;
        int i9 = measure.horizontalDimension;
        int i10 = measure.verticalDimension;
        int i11 = this.f3216b + this.f3217c;
        int i12 = this.f3218d;
        View view = (View) constraintWidget.getCompanionWidget();
        int[] iArr = AbstractC1099cv.f16119a;
        int i13 = iArr[dimensionBehaviour.ordinal()];
        if (i13 != 1) {
            if (i13 != 2) {
                if (i13 != 3) {
                    if (i13 != 4) {
                        makeMeasureSpec = 0;
                    } else {
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3220f, i12, -2);
                        if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int i14 = measure.measureStrategy;
                        if (i14 != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS && i14 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                            i8 = childMeasureSpec;
                        } else {
                            if (view.getMeasuredHeight() == constraintWidget.getHeight()) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            i8 = childMeasureSpec;
                            if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z11 || ((z11 && z12) || (view instanceof Placeholder) || constraintWidget.isResolvedHorizontally())) {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                            }
                        }
                        makeMeasureSpec = i8;
                    }
                } else {
                    makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3220f, constraintWidget.getHorizontalMargin() + i12, -1);
                }
            } else {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3220f, i12, -2);
            }
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        }
        int i15 = iArr[dimensionBehaviour2.ordinal()];
        if (i15 != 1) {
            if (i15 != 2) {
                if (i15 != 3) {
                    if (i15 != 4) {
                        makeMeasureSpec2 = 0;
                    } else {
                        makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3221g, i11, -2);
                        if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        int i16 = measure.measureStrategy;
                        if (i16 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i16 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                            if (view.getMeasuredWidth() == constraintWidget.getWidth()) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z9 || ((z9 && z10) || (view instanceof Placeholder) || constraintWidget.isResolvedVertically())) {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                            }
                        }
                    }
                } else {
                    makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3221g, constraintWidget.getVerticalMargin() + i11, -1);
                }
            } else {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3221g, i11, -2);
            }
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
        }
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        if (constraintWidgetContainer != null && Optimizer.enabled(constraintLayout.f3145g, 256) && view.getMeasuredWidth() == constraintWidget.getWidth() && view.getMeasuredWidth() < constraintWidgetContainer.getWidth() && view.getMeasuredHeight() == constraintWidget.getHeight() && view.getMeasuredHeight() < constraintWidgetContainer.getHeight() && view.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested() && m662a(constraintWidget.getLastHorizontalMeasureSpec(), makeMeasureSpec, constraintWidget.getWidth()) && m662a(constraintWidget.getLastVerticalMeasureSpec(), makeMeasureSpec2, constraintWidget.getHeight())) {
            measure.measuredWidth = constraintWidget.getWidth();
            measure.measuredHeight = constraintWidget.getHeight();
            measure.measuredBaseline = constraintWidget.getBaselineDistance();
            return;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour3) {
            z = true;
        } else {
            z = false;
        }
        if (dimensionBehaviour2 == dimensionBehaviour3) {
            z2 = true;
        } else {
            z2 = false;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (dimensionBehaviour2 != dimensionBehaviour4 && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.FIXED) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (dimensionBehaviour != dimensionBehaviour4 && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z && constraintWidget.mDimensionRatio > RecyclerView.f7068F0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z2 && constraintWidget.mDimensionRatio > RecyclerView.f7068F0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (view == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        int i17 = measure.measureStrategy;
        long j2 = j;
        if (i17 != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS && i17 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z && constraintWidget.mMatchConstraintDefaultWidth == 0 && z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
            i7 = -1;
            baseline = 0;
            i = 0;
            i3 = 0;
        } else {
            if ((view instanceof VirtualLayout) && (constraintWidget instanceof androidx.constraintlayout.core.widgets.VirtualLayout)) {
                ((VirtualLayout) view).onMeasure((androidx.constraintlayout.core.widgets.VirtualLayout) constraintWidget, makeMeasureSpec, makeMeasureSpec2);
            } else {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
            }
            constraintWidget.setLastMeasureSpec(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            baseline = view.getBaseline();
            int i18 = constraintWidget.mMatchConstraintMinWidth;
            if (i18 > 0) {
                i = Math.max(i18, measuredWidth);
            } else {
                i = measuredWidth;
            }
            int i19 = constraintWidget.mMatchConstraintMaxWidth;
            if (i19 > 0) {
                i = Math.min(i19, i);
            }
            int i20 = constraintWidget.mMatchConstraintMinHeight;
            if (i20 > 0) {
                i3 = Math.max(i20, measuredHeight);
                i2 = makeMeasureSpec;
            } else {
                i2 = makeMeasureSpec;
                i3 = measuredHeight;
            }
            int i21 = constraintWidget.mMatchConstraintMaxHeight;
            if (i21 > 0) {
                i3 = Math.min(i21, i3);
            }
            int i22 = makeMeasureSpec2;
            if (!Optimizer.enabled(constraintLayout.f3145g, 1)) {
                if (z5 && z3) {
                    i = (int) ((i3 * constraintWidget.mDimensionRatio) + 0.5f);
                } else if (z6 && z4) {
                    i3 = (int) ((i / constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
            if (measuredWidth != i || measuredHeight != i3) {
                if (measuredWidth != i) {
                    i4 = 1073741824;
                    i5 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                } else {
                    i4 = 1073741824;
                    i5 = i2;
                }
                if (measuredHeight != i3) {
                    i6 = View.MeasureSpec.makeMeasureSpec(i3, i4);
                } else {
                    i6 = i22;
                }
                view.measure(i5, i6);
                constraintWidget.setLastMeasureSpec(i5, i6);
                i = view.getMeasuredWidth();
                i3 = view.getMeasuredHeight();
                baseline = view.getBaseline();
            }
            i7 = -1;
        }
        if (baseline != i7) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i == measure.horizontalDimension && i3 == measure.verticalDimension) {
            z8 = false;
        } else {
            z8 = true;
        }
        measure.measuredNeedsSolverPass = z8;
        if (layoutParams.f3157c) {
            z7 = true;
        }
        if (z7 && baseline != -1 && constraintWidget.getBaselineDistance() != baseline) {
            measure.measuredNeedsSolverPass = true;
        }
        measure.measuredWidth = i;
        measure.measuredHeight = i3;
        measure.measuredHasBaseline = z7;
        measure.measuredBaseline = baseline;
        if (constraintLayout.f3152n != null) {
            long nanoTime = System.nanoTime();
            Metrics metrics2 = constraintLayout.f3152n;
            metrics2.measuresWidgetsDuration = (nanoTime - j2) + metrics2.measuresWidgetsDuration;
        }
    }
}
