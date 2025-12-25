package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ChainHead;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Direct {

    /* renamed from: a */
    public static final BasicMeasure.Measure f2581a = new BasicMeasure.Measure();

    /* renamed from: a */
    public static boolean m514a(ConstraintWidget constraintWidget) {
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z;
        boolean z2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        if (constraintWidget.getParent() != null) {
            constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        } else {
            constraintWidgetContainer = null;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getVerticalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (horizontalDimensionBehaviour != dimensionBehaviour5 && !constraintWidget.isResolvedHorizontally() && horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((horizontalDimensionBehaviour != (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || constraintWidget.mMatchConstraintDefaultWidth != 0 || constraintWidget.mDimensionRatio != RecyclerView.f7068F0 || !constraintWidget.hasDanglingDimension(0)) && (horizontalDimensionBehaviour != dimensionBehaviour2 || constraintWidget.mMatchConstraintDefaultWidth != 1 || !constraintWidget.hasResolvedTargets(0, constraintWidget.getWidth())))) {
            z = false;
        } else {
            z = true;
        }
        if (verticalDimensionBehaviour != dimensionBehaviour5 && !constraintWidget.isResolvedVertically() && verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((verticalDimensionBehaviour != (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.mDimensionRatio != RecyclerView.f7068F0 || !constraintWidget.hasDanglingDimension(1)) && (verticalDimensionBehaviour != dimensionBehaviour || constraintWidget.mMatchConstraintDefaultHeight != 1 || !constraintWidget.hasResolvedTargets(1, constraintWidget.getHeight())))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (constraintWidget.mDimensionRatio > RecyclerView.f7068F0 && (z || z2)) {
            return true;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static void m515b(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z) {
        boolean z2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z3;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isHorizontalSolvingPassDone()) {
            return;
        }
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
            int i2 = i + 1;
            if (m514a(constraintWidget)) {
                ConstraintWidgetContainer.measure(i2, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                int i3 = i + 1;
                boolean m514a = m514a(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && m514a) {
                    ConstraintWidgetContainer.measure(i3, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if ((next == constraintWidget2.mLeft && (constraintAnchor4 = constraintWidget2.mRight.mTarget) != null && constraintAnchor4.hasFinalValue()) || (next == constraintWidget2.mRight && (constraintAnchor3 = constraintWidget2.mLeft.mTarget) != null && constraintAnchor3.hasFinalValue())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget2.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && !m514a) {
                    if (constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxWidth >= 0 && constraintWidget2.mMatchConstraintMinWidth >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultWidth == 0 && constraintWidget2.getDimensionRatio() == RecyclerView.f7068F0))) {
                        if (!constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVirtualLayout() && z3 && !constraintWidget2.isInHorizontalChain()) {
                            m517d(i3, constraintWidget, measurer, constraintWidget2, z);
                        }
                    }
                } else if (!constraintWidget2.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor5 = constraintWidget2.mLeft;
                    if (next == constraintAnchor5 && constraintWidget2.mRight.mTarget == null) {
                        int margin = constraintAnchor5.getMargin() + finalValue;
                        constraintWidget2.setFinalHorizontal(margin, constraintWidget2.getWidth() + margin);
                        m515b(i3, constraintWidget2, measurer, z);
                    } else {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.mRight;
                        if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                            int margin2 = finalValue - constraintAnchor6.getMargin();
                            constraintWidget2.setFinalHorizontal(margin2 - constraintWidget2.getWidth(), margin2);
                            m515b(i3, constraintWidget2, measurer, z);
                        } else if (z3 && !constraintWidget2.isInHorizontalChain()) {
                            m516c(i3, constraintWidget2, measurer, z);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                int i4 = i + 1;
                boolean m514a2 = m514a(constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && m514a2) {
                    ConstraintWidgetContainer.measure(i4, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if ((next2 == constraintWidget3.mLeft && (constraintAnchor2 = constraintWidget3.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mRight && (constraintAnchor = constraintWidget3.mLeft.mTarget) != null && constraintAnchor.hasFinalValue())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget3.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour2 == dimensionBehaviour2 && !m514a2) {
                    if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == RecyclerView.f7068F0))) {
                        if (!constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z2 && !constraintWidget3.isInHorizontalChain()) {
                            m517d(i4, constraintWidget, measurer, constraintWidget3, z);
                        }
                    }
                } else if (!constraintWidget3.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor7 = constraintWidget3.mLeft;
                    if (next2 == constraintAnchor7 && constraintWidget3.mRight.mTarget == null) {
                        int margin3 = constraintAnchor7.getMargin() + finalValue2;
                        constraintWidget3.setFinalHorizontal(margin3, constraintWidget3.getWidth() + margin3);
                        m515b(i4, constraintWidget3, measurer, z);
                    } else {
                        ConstraintAnchor constraintAnchor8 = constraintWidget3.mRight;
                        if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                            int margin4 = finalValue2 - constraintAnchor8.getMargin();
                            constraintWidget3.setFinalHorizontal(margin4 - constraintWidget3.getWidth(), margin4);
                            m515b(i4, constraintWidget3, measurer, z);
                        } else if (z2 && !constraintWidget3.isInHorizontalChain()) {
                            m516c(i4, constraintWidget3, measurer, z);
                        }
                    }
                }
            }
        }
        constraintWidget.markHorizontalSolvingPassDone();
    }

    /* renamed from: c */
    public static void m516c(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z) {
        float f;
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i2 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i2 = (finalValue - finalValue2) - width;
        }
        if (i2 > 0) {
            f = (horizontalBiasPercent * i2) + 0.5f;
        } else {
            f = horizontalBiasPercent * i2;
        }
        int i3 = ((int) f) + finalValue;
        int i4 = i3 + width;
        if (finalValue > finalValue2) {
            i4 = i3 - width;
        }
        constraintWidget.setFinalHorizontal(i3, i4);
        m515b(i + 1, constraintWidget, measurer, z);
    }

    /* renamed from: d */
    public static void m517d(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        int width;
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        int margin = constraintWidget2.mLeft.getMargin() + constraintWidget2.mLeft.mTarget.getFinalValue();
        int finalValue = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue >= margin) {
            int width2 = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i2 = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i2 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        width = constraintWidget.getWidth();
                    } else {
                        width = constraintWidget.getParent().getWidth();
                    }
                    width2 = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * width);
                } else if (i2 == 0) {
                    width2 = finalValue - margin;
                }
                width2 = Math.max(constraintWidget2.mMatchConstraintMinWidth, width2);
                int i3 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i3 > 0) {
                    width2 = Math.min(i3, width2);
                }
            }
            int i4 = margin + ((int) ((horizontalBiasPercent * ((finalValue - margin) - width2)) + 0.5f));
            constraintWidget2.setFinalHorizontal(i4, width2 + i4);
            m515b(i + 1, constraintWidget2, measurer, z);
        }
    }

    /* renamed from: e */
    public static void m518e(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        float f;
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i2 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i2 = (finalValue - finalValue2) - height;
        }
        if (i2 > 0) {
            f = (verticalBiasPercent * i2) + 0.5f;
        } else {
            f = verticalBiasPercent * i2;
        }
        int i3 = (int) f;
        int i4 = finalValue + i3;
        int i5 = i4 + height;
        if (finalValue > finalValue2) {
            i4 = finalValue - i3;
            i5 = i4 - height;
        }
        constraintWidget.setFinalVertical(i4, i5);
        m520g(i + 1, constraintWidget, measurer);
    }

    /* renamed from: f */
    public static void m519f(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int height;
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        int margin = constraintWidget2.mTop.getMargin() + constraintWidget2.mTop.mTarget.getFinalValue();
        int finalValue = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue >= margin) {
            int height2 = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i2 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i2 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        height = constraintWidget.getHeight();
                    } else {
                        height = constraintWidget.getParent().getHeight();
                    }
                    height2 = (int) (verticalBiasPercent * 0.5f * height);
                } else if (i2 == 0) {
                    height2 = finalValue - margin;
                }
                height2 = Math.max(constraintWidget2.mMatchConstraintMinHeight, height2);
                int i3 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i3 > 0) {
                    height2 = Math.min(i3, height2);
                }
            }
            int i4 = margin + ((int) ((verticalBiasPercent * ((finalValue - margin) - height2)) + 0.5f));
            constraintWidget2.setFinalVertical(i4, height2 + i4);
            m520g(i + 1, constraintWidget2, measurer);
        }
    }

    /* renamed from: g */
    public static void m520g(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        boolean z;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isVerticalSolvingPassDone()) {
            return;
        }
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
            int i2 = i + 1;
            if (m514a(constraintWidget)) {
                ConstraintWidgetContainer.measure(i2, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                int i3 = i + 1;
                boolean m514a = m514a(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && m514a) {
                    ConstraintWidgetContainer.measure(i3, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if ((next == constraintWidget2.mTop && (constraintAnchor4 = constraintWidget2.mBottom.mTarget) != null && constraintAnchor4.hasFinalValue()) || (next == constraintWidget2.mBottom && (constraintAnchor3 = constraintWidget2.mTop.mTarget) != null && constraintAnchor3.hasFinalValue())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget2.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour == dimensionBehaviour && !m514a) {
                    if (constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxHeight >= 0 && constraintWidget2.mMatchConstraintMinHeight >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultHeight == 0 && constraintWidget2.getDimensionRatio() == RecyclerView.f7068F0))) {
                        if (!constraintWidget2.isInVerticalChain() && !constraintWidget2.isInVirtualLayout() && z2 && !constraintWidget2.isInVerticalChain()) {
                            m519f(i3, constraintWidget, measurer, constraintWidget2);
                        }
                    }
                } else if (!constraintWidget2.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor5 = constraintWidget2.mTop;
                    if (next == constraintAnchor5 && constraintWidget2.mBottom.mTarget == null) {
                        int margin = constraintAnchor5.getMargin() + finalValue;
                        constraintWidget2.setFinalVertical(margin, constraintWidget2.getHeight() + margin);
                        m520g(i3, constraintWidget2, measurer);
                    } else {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.mBottom;
                        if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                            int margin2 = finalValue - constraintAnchor6.getMargin();
                            constraintWidget2.setFinalVertical(margin2 - constraintWidget2.getHeight(), margin2);
                            m520g(i3, constraintWidget2, measurer);
                        } else if (z2 && !constraintWidget2.isInVerticalChain()) {
                            m518e(i3, constraintWidget2, measurer);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                int i4 = i + 1;
                boolean m514a2 = m514a(constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && m514a2) {
                    ConstraintWidgetContainer.measure(i4, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if ((next2 == constraintWidget3.mTop && (constraintAnchor2 = constraintWidget3.mBottom.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mBottom && (constraintAnchor = constraintWidget3.mTop.mTarget) != null && constraintAnchor.hasFinalValue())) {
                    z = true;
                } else {
                    z = false;
                }
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidget3.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour2 == dimensionBehaviour2 && !m514a2) {
                    if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == RecyclerView.f7068F0))) {
                        if (!constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z && !constraintWidget3.isInVerticalChain()) {
                            m519f(i4, constraintWidget, measurer, constraintWidget3);
                        }
                    }
                } else if (!constraintWidget3.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor7 = constraintWidget3.mTop;
                    if (next2 == constraintAnchor7 && constraintWidget3.mBottom.mTarget == null) {
                        int margin3 = constraintAnchor7.getMargin() + finalValue2;
                        constraintWidget3.setFinalVertical(margin3, constraintWidget3.getHeight() + margin3);
                        m520g(i4, constraintWidget3, measurer);
                    } else {
                        ConstraintAnchor constraintAnchor8 = constraintWidget3.mBottom;
                        if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                            int margin4 = finalValue2 - constraintAnchor8.getMargin();
                            constraintWidget3.setFinalVertical(margin4 - constraintWidget3.getHeight(), margin4);
                            m520g(i4, constraintWidget3, measurer);
                        } else if (z && !constraintWidget3.isInVerticalChain()) {
                            m518e(i4, constraintWidget3, measurer);
                        }
                    }
                }
            }
        }
        ConstraintAnchor anchor3 = constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
            int finalValue3 = anchor3.getFinalValue();
            Iterator<ConstraintAnchor> it3 = anchor3.getDependents().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.mOwner;
                int i5 = i + 1;
                boolean m514a3 = m514a(constraintWidget4);
                if (constraintWidget4.isMeasureRequested() && m514a3) {
                    ConstraintWidgetContainer.measure(i5, constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if (constraintWidget4.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || m514a3) {
                    if (!constraintWidget4.isMeasureRequested() && next3 == constraintWidget4.mBaseline) {
                        constraintWidget4.setFinalBaseline(next3.getMargin() + finalValue3);
                        m520g(i5, constraintWidget4, measurer);
                    }
                }
            }
        }
        constraintWidget.markVerticalSolvingPassDone();
    }

    /* renamed from: ls */
    public static String m521ls(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("+-(" + i + ") ");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d6, code lost:
    
        if (r6.mOwner == r0) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0150  */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean solveChain(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead, boolean z, boolean z2, boolean z3) {
        int i3;
        int height;
        boolean z4;
        LinearSystem linearSystem2;
        ConstraintWidget constraintWidget;
        float verticalBiasPercent;
        boolean z5;
        int height2;
        if (z3) {
            return false;
        }
        if (i == 0) {
            if (!constraintWidgetContainer.isResolvedHorizontally()) {
                return false;
            }
        } else if (!constraintWidgetContainer.isResolvedVertically()) {
            return false;
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        ConstraintWidget first = chainHead.getFirst();
        ConstraintWidget last = chainHead.getLast();
        ConstraintWidget firstVisibleWidget = chainHead.getFirstVisibleWidget();
        ConstraintWidget lastVisibleWidget = chainHead.getLastVisibleWidget();
        ConstraintWidget head = chainHead.getHead();
        ConstraintAnchor constraintAnchor = first.mListAnchors[i2];
        int i4 = i2 + 1;
        ConstraintAnchor constraintAnchor2 = last.mListAnchors[i4];
        ConstraintAnchor constraintAnchor3 = constraintAnchor.mTarget;
        if (constraintAnchor3 == null || constraintAnchor2.mTarget == null || !constraintAnchor3.hasFinalValue() || !constraintAnchor2.mTarget.hasFinalValue() || firstVisibleWidget == null || lastVisibleWidget == null) {
            return false;
        }
        int margin = firstVisibleWidget.mListAnchors[i2].getMargin() + constraintAnchor.mTarget.getFinalValue();
        int finalValue = constraintAnchor2.mTarget.getFinalValue() - lastVisibleWidget.mListAnchors[i4].getMargin();
        int i5 = finalValue - margin;
        if (i5 <= 0) {
            return false;
        }
        BasicMeasure.Measure measure = new BasicMeasure.Measure();
        boolean z6 = false;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        ConstraintWidget constraintWidget2 = first;
        while (true) {
            ConstraintWidget constraintWidget3 = null;
            if (!z6) {
                if (!m514a(constraintWidget2)) {
                    return false;
                }
                ConstraintWidget constraintWidget4 = first;
                if (constraintWidget2.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    return false;
                }
                if (constraintWidget2.isMeasureRequested()) {
                    z5 = z6;
                    ConstraintWidgetContainer.measure(1, constraintWidget2, constraintWidgetContainer.getMeasurer(), measure, BasicMeasure.Measure.SELF_DIMENSIONS);
                } else {
                    z5 = z6;
                }
                int margin2 = constraintWidget2.mListAnchors[i2].getMargin() + i8;
                if (i == 0) {
                    height2 = constraintWidget2.getWidth();
                } else {
                    height2 = constraintWidget2.getHeight();
                }
                i8 = constraintWidget2.mListAnchors[i4].getMargin() + height2 + margin2;
                i7++;
                if (constraintWidget2.getVisibility() != 8) {
                    i6++;
                }
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mListAnchors[i4].mTarget;
                if (constraintAnchor4 != null) {
                    ConstraintWidget constraintWidget5 = constraintAnchor4.mOwner;
                    ConstraintAnchor constraintAnchor5 = constraintWidget5.mListAnchors[i2].mTarget;
                    if (constraintAnchor5 != null && constraintAnchor5.mOwner == constraintWidget2) {
                        constraintWidget3 = constraintWidget5;
                    }
                }
                if (constraintWidget3 != null) {
                    constraintWidget2 = constraintWidget3;
                    z6 = z5;
                } else {
                    z6 = true;
                }
                first = constraintWidget4;
            } else {
                ConstraintWidget constraintWidget6 = first;
                if (i6 == 0 || i6 != i7 || i5 < i8) {
                    return false;
                }
                int i9 = i5 - i8;
                if (z) {
                    i9 /= i6 + 1;
                } else if (z2 && i6 > 2) {
                    i3 = 1;
                    i9 = (i9 / i6) - 1;
                    if (i6 != i3) {
                        if (i == 0) {
                            verticalBiasPercent = head.getHorizontalBiasPercent();
                        } else {
                            verticalBiasPercent = head.getVerticalBiasPercent();
                        }
                        int i10 = (int) ((i9 * verticalBiasPercent) + margin + 0.5f);
                        if (i == 0) {
                            firstVisibleWidget.setFinalHorizontal(i10, firstVisibleWidget.getWidth() + i10);
                        } else {
                            firstVisibleWidget.setFinalVertical(i10, firstVisibleWidget.getHeight() + i10);
                        }
                        m515b(1, firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                        return true;
                    }
                    if (z) {
                        int i11 = margin + i9;
                        ConstraintWidget constraintWidget7 = constraintWidget6;
                        boolean z7 = false;
                        ?? r2 = i3;
                        while (!z7) {
                            if (constraintWidget7.getVisibility() == 8) {
                                if (i == 0) {
                                    constraintWidget7.setFinalHorizontal(i11, i11);
                                    m515b(r2, constraintWidget7, constraintWidgetContainer.getMeasurer(), isRtl);
                                } else {
                                    constraintWidget7.setFinalVertical(i11, i11);
                                    m520g(r2, constraintWidget7, constraintWidgetContainer.getMeasurer());
                                }
                                linearSystem2 = linearSystem;
                                z4 = false;
                            } else {
                                int margin3 = constraintWidget7.mListAnchors[i2].getMargin() + i11;
                                if (i == 0) {
                                    constraintWidget7.setFinalHorizontal(margin3, constraintWidget7.getWidth() + margin3);
                                    m515b(1, constraintWidget7, constraintWidgetContainer.getMeasurer(), isRtl);
                                    height = constraintWidget7.getWidth();
                                } else {
                                    constraintWidget7.setFinalVertical(margin3, constraintWidget7.getHeight() + margin3);
                                    m520g(1, constraintWidget7, constraintWidgetContainer.getMeasurer());
                                    height = constraintWidget7.getHeight();
                                }
                                i11 = constraintWidget7.mListAnchors[i4].getMargin() + height + margin3 + i9;
                                z4 = false;
                                linearSystem2 = linearSystem;
                            }
                            constraintWidget7.addToSolver(linearSystem2, z4);
                            ConstraintAnchor constraintAnchor6 = constraintWidget7.mListAnchors[i4].mTarget;
                            if (constraintAnchor6 != null) {
                                constraintWidget = constraintAnchor6.mOwner;
                                ConstraintAnchor constraintAnchor7 = constraintWidget.mListAnchors[i2].mTarget;
                                if (constraintAnchor7 != null) {
                                }
                            }
                            constraintWidget = null;
                            if (constraintWidget != null) {
                                constraintWidget7 = constraintWidget;
                            } else {
                                z7 = true;
                            }
                            r2 = 1;
                        }
                        return r2;
                    }
                    if (z2) {
                        if (i6 == 2) {
                            if (i == 0) {
                                firstVisibleWidget.setFinalHorizontal(margin, firstVisibleWidget.getWidth() + margin);
                                lastVisibleWidget.setFinalHorizontal(finalValue - lastVisibleWidget.getWidth(), finalValue);
                                m515b(1, firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                                m515b(1, lastVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                                return true;
                            }
                            firstVisibleWidget.setFinalVertical(margin, firstVisibleWidget.getHeight() + margin);
                            lastVisibleWidget.setFinalVertical(finalValue - lastVisibleWidget.getHeight(), finalValue);
                            m520g(1, firstVisibleWidget, constraintWidgetContainer.getMeasurer());
                            m520g(1, lastVisibleWidget, constraintWidgetContainer.getMeasurer());
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                i3 = 1;
                if (i6 != i3) {
                }
            }
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
        constraintWidgetContainer.resetFinalResolution();
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            children.get(i).resetFinalResolution();
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = children.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    if (guideline.getRelativeBegin() != -1) {
                        guideline.setFinalValue(guideline.getRelativeBegin());
                    } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue((int) ((guideline.getRelativePercent() * constraintWidgetContainer.getWidth()) + 0.5f));
                    }
                    z = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = children.get(i3);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.getOrientation() == 1) {
                        m515b(0, guideline2, measurer, isRtl);
                    }
                }
            }
        }
        m515b(0, constraintWidgetContainer, measurer, isRtl);
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget3 = children.get(i4);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.getOrientation() == 0 && barrier.allSolved()) {
                        m515b(1, barrier, measurer, isRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget4 = children.get(i5);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.getOrientation() == 0) {
                    if (guideline3.getRelativeBegin() != -1) {
                        guideline3.setFinalValue(guideline3.getRelativeBegin());
                    } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * constraintWidgetContainer.getHeight()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget5 = children.get(i6);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.getOrientation() == 0) {
                        m520g(1, guideline4, measurer);
                    }
                }
            }
        }
        m520g(0, constraintWidgetContainer, measurer);
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget6 = children.get(i7);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.getOrientation() == 1 && barrier2.allSolved()) {
                        m520g(1, barrier2, measurer);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget7 = children.get(i8);
            if (constraintWidget7.isMeasureRequested() && m514a(constraintWidget7)) {
                ConstraintWidgetContainer.measure(0, constraintWidget7, measurer, f2581a, BasicMeasure.Measure.SELF_DIMENSIONS);
                if (constraintWidget7 instanceof Guideline) {
                    if (((Guideline) constraintWidget7).getOrientation() == 0) {
                        m520g(0, constraintWidget7, measurer);
                    } else {
                        m515b(0, constraintWidget7, measurer, isRtl);
                    }
                } else {
                    m515b(0, constraintWidget7, measurer, isRtl);
                    m520g(0, constraintWidget7, measurer);
                }
            }
        }
    }
}
