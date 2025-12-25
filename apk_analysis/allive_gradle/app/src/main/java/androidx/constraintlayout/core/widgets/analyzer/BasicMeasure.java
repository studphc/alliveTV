package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a */
    public final ArrayList f2561a = new ArrayList();

    /* renamed from: b */
    public final Measure f2562b = new Measure();

    /* renamed from: c */
    public final ConstraintWidgetContainer f2563c;

    /* loaded from: classes.dex */
    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* loaded from: classes.dex */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f2563c = constraintWidgetContainer;
    }

    /* renamed from: a */
    public final boolean m502a(int i, ConstraintWidget constraintWidget, Measurer measurer) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        Measure measure = this.f2562b;
        measure.horizontalBehavior = horizontalDimensionBehaviour;
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z = true;
        } else {
            z = false;
        }
        if (measure.verticalBehavior == dimensionBehaviour2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && constraintWidget.mDimensionRatio > RecyclerView.f7068F0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && constraintWidget.mDimensionRatio > RecyclerView.f7068F0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.measureStrategy = Measure.SELF_DIMENSIONS;
        return measure.measuredNeedsSolverPass;
    }

    /* renamed from: b */
    public final void m503b(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        long j;
        if (constraintWidgetContainer.mMetrics != null) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setHeight(i3);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        ConstraintWidgetContainer constraintWidgetContainer2 = this.f2563c;
        constraintWidgetContainer2.setPass(i);
        constraintWidgetContainer2.layout();
        if (constraintWidgetContainer.mMetrics != null) {
            long nanoTime = System.nanoTime();
            Metrics metrics = constraintWidgetContainer.mMetrics;
            metrics.mSolverPasses++;
            metrics.measuresLayoutDuration = (nanoTime - j) + metrics.measuresLayoutDuration;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        int i10;
        boolean z2;
        long j;
        int i11;
        long j2;
        boolean z3;
        Measurer measurer;
        ArrayList arrayList;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z4;
        int i16;
        boolean z5;
        boolean z6;
        HorizontalWidgetRun horizontalWidgetRun;
        VerticalWidgetRun verticalWidgetRun;
        boolean z7;
        Metrics metrics;
        BasicMeasure basicMeasure = this;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        Measurer measurer2 = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer2.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = Optimizer.enabled(i, 128);
        boolean z8 = enabled || Optimizer.enabled(i, 64);
        boolean z9 = false;
        if (z8) {
            for (int i17 = 0; i17 < size; i17++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i17);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z10 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > RecyclerView.f7068F0;
                if ((constraintWidget.isInHorizontalChain() && z10) || ((constraintWidget.isInVerticalChain() && z10) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z8 = false;
                    break;
                }
            }
        }
        if (z8 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        boolean z11 = z8 & ((i4 == 1073741824 && i6 == 1073741824) || enabled);
        if (z11) {
            int min = Math.min(constraintWidgetContainer.getMaxWidth(), i5);
            int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i7);
            if (i4 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer2.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i6 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer2.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                z = constraintWidgetContainer2.directMeasure(enabled);
                i10 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer2.directMeasureSetup(enabled);
                if (i4 == 1073741824) {
                    z7 = directMeasureSetup & constraintWidgetContainer2.directMeasureWithOrientation(enabled, 0);
                    i10 = 1;
                } else {
                    z7 = directMeasureSetup;
                    i10 = 0;
                }
                if (i6 == 1073741824) {
                    z = constraintWidgetContainer2.directMeasureWithOrientation(enabled, 1) & z7;
                    i10++;
                } else {
                    z = z7;
                }
            }
            if (z) {
                constraintWidgetContainer2.updateFromRuns(i4 == 1073741824, i6 == 1073741824);
            }
        } else {
            z = false;
            i10 = 0;
        }
        if (z && i10 == 2) {
            j2 = 0;
        } else {
            int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
            if (size > 0) {
                int size2 = constraintWidgetContainer2.mChildren.size();
                boolean optimizeFor = constraintWidgetContainer2.optimizeFor(64);
                Measurer measurer3 = constraintWidgetContainer.getMeasurer();
                int i18 = 0;
                while (i18 < size2) {
                    ConstraintWidget constraintWidget2 = constraintWidgetContainer2.mChildren.get(i18);
                    if ((constraintWidget2 instanceof Guideline) || (constraintWidget2 instanceof Barrier) || constraintWidget2.isInVirtualLayout() || (optimizeFor && (horizontalWidgetRun = constraintWidget2.mHorizontalRun) != null && (verticalWidgetRun = constraintWidget2.mVerticalRun) != null && horizontalWidgetRun.f2593c.resolved && verticalWidgetRun.f2593c.resolved)) {
                        i15 = size2;
                        z4 = optimizeFor;
                        z6 = z9;
                    } else {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(0);
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidget2.getDimensionBehaviour(1);
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        i15 = size2;
                        if (dimensionBehaviour2 == dimensionBehaviour4) {
                            z4 = optimizeFor;
                            i16 = 1;
                            if (constraintWidget2.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour3 == dimensionBehaviour4 && constraintWidget2.mMatchConstraintDefaultHeight != 1) {
                                z5 = true;
                                if (!z5 && constraintWidgetContainer2.optimizeFor(i16) && !(constraintWidget2 instanceof VirtualLayout)) {
                                    if (dimensionBehaviour2 == dimensionBehaviour4 && constraintWidget2.mMatchConstraintDefaultWidth == 0 && dimensionBehaviour3 != dimensionBehaviour4 && !constraintWidget2.isInHorizontalChain()) {
                                        z5 = true;
                                    }
                                    if (dimensionBehaviour3 == dimensionBehaviour4 && constraintWidget2.mMatchConstraintDefaultHeight == 0 && dimensionBehaviour2 != dimensionBehaviour4 && !constraintWidget2.isInHorizontalChain()) {
                                        z5 = true;
                                    }
                                    if (dimensionBehaviour2 != dimensionBehaviour4 || dimensionBehaviour3 == dimensionBehaviour4) {
                                        z6 = false;
                                        if (constraintWidget2.mDimensionRatio > RecyclerView.f7068F0) {
                                            z5 = true;
                                        }
                                        if (z5) {
                                            basicMeasure.m502a(Measure.SELF_DIMENSIONS, constraintWidget2, measurer3);
                                            Metrics metrics2 = constraintWidgetContainer2.mMetrics;
                                            if (metrics2 != null) {
                                                metrics2.measuredWidgets++;
                                            }
                                        }
                                    }
                                }
                                z6 = false;
                                if (z5) {
                                }
                            }
                        } else {
                            z4 = optimizeFor;
                            i16 = 1;
                        }
                        z5 = false;
                        if (!z5) {
                            if (dimensionBehaviour2 == dimensionBehaviour4) {
                                z5 = true;
                            }
                            if (dimensionBehaviour3 == dimensionBehaviour4) {
                                z5 = true;
                            }
                            if (dimensionBehaviour2 != dimensionBehaviour4) {
                            }
                            z6 = false;
                            if (constraintWidget2.mDimensionRatio > RecyclerView.f7068F0) {
                            }
                            if (z5) {
                            }
                        }
                        z6 = false;
                        if (z5) {
                        }
                    }
                    i18++;
                    size2 = i15;
                    z9 = z6;
                    optimizeFor = z4;
                }
                measurer3.didMeasures();
            }
            long nanoTime = constraintWidgetContainer2.mMetrics != null ? System.nanoTime() : 0L;
            updateHierarchy(constraintWidgetContainer);
            ArrayList arrayList2 = basicMeasure.f2561a;
            int size3 = arrayList2.size();
            if (size > 0) {
                z2 = false;
                basicMeasure.m503b(constraintWidgetContainer2, 0, width, height);
            } else {
                z2 = false;
            }
            if (size3 > 0) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z12 = horizontalDimensionBehaviour2 == dimensionBehaviour5 ? true : z2;
                boolean z13 = constraintWidgetContainer.getVerticalDimensionBehaviour() == dimensionBehaviour5 ? true : z2;
                int width2 = constraintWidgetContainer.getWidth();
                ConstraintWidgetContainer constraintWidgetContainer3 = basicMeasure.f2563c;
                int max = Math.max(width2, constraintWidgetContainer3.getMinWidth());
                j = nanoTime;
                int max2 = Math.max(constraintWidgetContainer.getHeight(), constraintWidgetContainer3.getMinHeight());
                int i19 = 0;
                boolean z14 = false;
                while (i19 < size3) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) arrayList2.get(i19);
                    int i20 = optimizationLevel;
                    if (constraintWidget3 instanceof VirtualLayout) {
                        int width3 = constraintWidget3.getWidth();
                        i13 = width;
                        int height2 = constraintWidget3.getHeight();
                        i14 = height;
                        boolean m502a = z14 | basicMeasure.m502a(Measure.TRY_GIVEN_DIMENSIONS, constraintWidget3, measurer2);
                        Metrics metrics3 = constraintWidgetContainer2.mMetrics;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets++;
                        }
                        int width4 = constraintWidget3.getWidth();
                        int height3 = constraintWidget3.getHeight();
                        if (width4 != width3) {
                            constraintWidget3.setWidth(width4);
                            if (z12 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget3.getRight());
                            }
                            m502a = true;
                        }
                        if (height3 != height2) {
                            constraintWidget3.setHeight(height3);
                            if (z13 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget3.getBottom());
                            }
                            m502a = true;
                        }
                        z14 = ((VirtualLayout) constraintWidget3).needSolverPass() | m502a;
                    } else {
                        i13 = width;
                        i14 = height;
                    }
                    i19++;
                    basicMeasure = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    optimizationLevel = i20;
                    width = i13;
                    height = i14;
                }
                int i21 = width;
                int i22 = height;
                int i23 = optimizationLevel;
                int i24 = 0;
                int i25 = 2;
                while (true) {
                    if (i24 >= i25) {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        break;
                    }
                    int i26 = 0;
                    while (i26 < size3) {
                        ConstraintWidget constraintWidget4 = (ConstraintWidget) arrayList2.get(i26);
                        if (((constraintWidget4 instanceof Helper) && !(constraintWidget4 instanceof VirtualLayout)) || (constraintWidget4 instanceof Guideline) || constraintWidget4.getVisibility() == 8 || ((z11 && constraintWidget4.mHorizontalRun.f2593c.resolved && constraintWidget4.mVerticalRun.f2593c.resolved) || (constraintWidget4 instanceof VirtualLayout))) {
                            z3 = z11;
                            measurer = measurer2;
                            arrayList = arrayList2;
                            i12 = size3;
                        } else {
                            int width5 = constraintWidget4.getWidth();
                            int height4 = constraintWidget4.getHeight();
                            int baselineDistance = constraintWidget4.getBaselineDistance();
                            int i27 = Measure.TRY_GIVEN_DIMENSIONS;
                            if (i24 == 1) {
                                i27 = Measure.USE_GIVEN_DIMENSIONS;
                            }
                            int i28 = i27;
                            z3 = z11;
                            z14 |= m502a(i28, constraintWidget4, measurer2);
                            measurer = measurer2;
                            Metrics metrics4 = constraintWidgetContainer.mMetrics;
                            arrayList = arrayList2;
                            i12 = size3;
                            if (metrics4 != null) {
                                metrics4.measuredMatchWidgets++;
                            }
                            int width6 = constraintWidget4.getWidth();
                            int height5 = constraintWidget4.getHeight();
                            if (width6 != width5) {
                                constraintWidget4.setWidth(width6);
                                if (z12 && constraintWidget4.getRight() > max) {
                                    max = Math.max(max, constraintWidget4.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget4.getRight());
                                }
                                z14 = true;
                            }
                            if (height5 != height4) {
                                constraintWidget4.setHeight(height5);
                                if (z13 && constraintWidget4.getBottom() > max2) {
                                    max2 = Math.max(max2, constraintWidget4.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget4.getBottom());
                                }
                                z14 = true;
                            }
                            if (constraintWidget4.hasBaseline() && baselineDistance != constraintWidget4.getBaselineDistance()) {
                                z14 = true;
                            }
                        }
                        i26++;
                        arrayList2 = arrayList;
                        size3 = i12;
                        z11 = z3;
                        measurer2 = measurer;
                    }
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    boolean z15 = z11;
                    Measurer measurer4 = measurer2;
                    ArrayList arrayList3 = arrayList2;
                    int i29 = size3;
                    if (!z14) {
                        break;
                    }
                    i24++;
                    m503b(constraintWidgetContainer2, i24, i21, i22);
                    arrayList2 = arrayList3;
                    size3 = i29;
                    z11 = z15;
                    measurer2 = measurer4;
                    i25 = 2;
                    z14 = false;
                }
                i11 = i23;
            } else {
                j = nanoTime;
                i11 = optimizationLevel;
            }
            constraintWidgetContainer2.setOptimizationLevel(i11);
            j2 = j;
        }
        return constraintWidgetContainer2.mMetrics != null ? System.nanoTime() - j2 : j2;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        ArrayList arrayList = this.f2561a;
        arrayList.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                arrayList.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
