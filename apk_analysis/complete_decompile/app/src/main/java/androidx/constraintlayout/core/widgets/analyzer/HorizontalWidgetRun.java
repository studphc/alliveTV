package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import java.util.ArrayList;
import p000.c40;
import p000.k53;

/* loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {

    /* renamed from: e */
    public static final int[] f2582e = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.f2575b = 4;
        this.end.f2575b = 5;
        this.orientation = 0;
    }

    /* renamed from: d */
    public static void m522d(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 != 0) {
                if (i5 == 1) {
                    iArr[0] = i6;
                    iArr[1] = (int) ((i6 * f) + 0.5f);
                    return;
                }
                return;
            }
            iArr[0] = (int) ((i7 * f) + 0.5f);
            iArr[1] = i7;
            return;
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: a */
    public final void mo504a() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.f2591a;
        boolean z = constraintWidget.measured;
        c40 c40Var = this.f2593c;
        if (z) {
            c40Var.resolve(constraintWidget.getWidth());
        }
        if (!c40Var.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.f2591a.getHorizontalDimensionBehaviour();
            this.mDimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && (parent2 = this.f2591a.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour)) {
                    int width = (parent2.getWidth() - this.f2591a.mLeft.getMargin()) - this.f2591a.mRight.getMargin();
                    addTarget(this.start, parent2.mHorizontalRun.start, this.f2591a.mLeft.getMargin());
                    addTarget(this.end, parent2.mHorizontalRun.end, -this.f2591a.mRight.getMargin());
                    c40Var.resolve(width);
                    return;
                }
                if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    c40Var.resolve(this.f2591a.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mDimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (parent = this.f2591a.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                addTarget(this.start, parent.mHorizontalRun.start, this.f2591a.mLeft.getMargin());
                addTarget(this.end, parent.mHorizontalRun.end, -this.f2591a.mRight.getMargin());
                return;
            }
        }
        if (c40Var.resolved) {
            ConstraintWidget constraintWidget2 = this.f2591a;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[1].mTarget != null) {
                    if (constraintWidget2.isInHorizontalChain()) {
                        this.start.f2576c = this.f2591a.mListAnchors[0].getMargin();
                        this.end.f2576c = -this.f2591a.mListAnchors[1].getMargin();
                        return;
                    }
                    DependencyNode target = getTarget(this.f2591a.mListAnchors[0]);
                    if (target != null) {
                        addTarget(this.start, target, this.f2591a.mListAnchors[0].getMargin());
                    }
                    DependencyNode target2 = getTarget(this.f2591a.mListAnchors[1]);
                    if (target2 != null) {
                        addTarget(this.end, target2, -this.f2591a.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.f2591a.mListAnchors[0].getMargin());
                        addTarget(this.end, this.start, c40Var.value);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.f2591a.mListAnchors[1].getMargin());
                        addTarget(this.start, this.end, -c40Var.value);
                        return;
                    }
                    return;
                }
                if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.f2591a.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                    addTarget(this.start, this.f2591a.getParent().mHorizontalRun.start, this.f2591a.getX());
                    addTarget(this.end, this.start, c40Var.value);
                    return;
                }
                return;
            }
        }
        if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f2591a;
            int i = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i != 2) {
                if (i == 3) {
                    if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                        this.start.updateDelegate = this;
                        this.end.updateDelegate = this;
                        VerticalWidgetRun verticalWidgetRun = constraintWidget3.mVerticalRun;
                        verticalWidgetRun.start.updateDelegate = this;
                        verticalWidgetRun.end.updateDelegate = this;
                        c40Var.updateDelegate = this;
                        if (constraintWidget3.isInVerticalChain()) {
                            c40Var.f2580g.add(this.f2591a.mVerticalRun.f2593c);
                            this.f2591a.mVerticalRun.f2593c.f2579f.add(c40Var);
                            VerticalWidgetRun verticalWidgetRun2 = this.f2591a.mVerticalRun;
                            verticalWidgetRun2.f2593c.updateDelegate = this;
                            c40Var.f2580g.add(verticalWidgetRun2.start);
                            c40Var.f2580g.add(this.f2591a.mVerticalRun.end);
                            this.f2591a.mVerticalRun.start.f2579f.add(c40Var);
                            this.f2591a.mVerticalRun.end.f2579f.add(c40Var);
                        } else if (this.f2591a.isInHorizontalChain()) {
                            this.f2591a.mVerticalRun.f2593c.f2580g.add(c40Var);
                            c40Var.f2579f.add(this.f2591a.mVerticalRun.f2593c);
                        } else {
                            this.f2591a.mVerticalRun.f2593c.f2580g.add(c40Var);
                        }
                    } else {
                        c40 c40Var2 = constraintWidget3.mVerticalRun.f2593c;
                        c40Var.f2580g.add(c40Var2);
                        c40Var2.f2579f.add(c40Var);
                        this.f2591a.mVerticalRun.start.f2579f.add(c40Var);
                        this.f2591a.mVerticalRun.end.f2579f.add(c40Var);
                        c40Var.delegateToWidgetRun = true;
                        c40Var.f2579f.add(this.start);
                        c40Var.f2579f.add(this.end);
                        this.start.f2580g.add(c40Var);
                        this.end.f2580g.add(c40Var);
                    }
                }
            } else {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    c40 c40Var3 = parent3.mVerticalRun.f2593c;
                    c40Var.f2580g.add(c40Var3);
                    c40Var3.f2579f.add(c40Var);
                    c40Var.delegateToWidgetRun = true;
                    c40Var.f2579f.add(this.start);
                    c40Var.f2579f.add(this.end);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f2591a;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].mTarget != null) {
            if (constraintWidget4.isInHorizontalChain()) {
                this.start.f2576c = this.f2591a.mListAnchors[0].getMargin();
                this.end.f2576c = -this.f2591a.mListAnchors[1].getMargin();
                return;
            }
            DependencyNode target5 = getTarget(this.f2591a.mListAnchors[0]);
            DependencyNode target6 = getTarget(this.f2591a.mListAnchors[1]);
            if (target5 != null) {
                target5.addDependency(this);
            }
            if (target6 != null) {
                target6.addDependency(this);
            }
            this.mRunType = k53.f20754b;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode target7 = getTarget(constraintAnchor4);
            if (target7 != null) {
                addTarget(this.start, target7, this.f2591a.mListAnchors[0].getMargin());
                addTarget(this.end, this.start, 1, c40Var);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.mTarget != null) {
            DependencyNode target8 = getTarget(constraintAnchor6);
            if (target8 != null) {
                addTarget(this.end, target8, -this.f2591a.mListAnchors[1].getMargin());
                addTarget(this.start, this.end, -1, c40Var);
                return;
            }
            return;
        }
        if (!(constraintWidget4 instanceof Helper) && constraintWidget4.getParent() != null) {
            addTarget(this.start, this.f2591a.getParent().mHorizontalRun.start, this.f2591a.getX());
            addTarget(this.end, this.start, 1, c40Var);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.f2591a.setX(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: b */
    public final void mo505b() {
        this.f2592b = null;
        this.start.clear();
        this.end.clear();
        this.f2593c.clear();
        this.f2594d = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: c */
    public final boolean mo506c() {
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f2591a.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final void m523e() {
        this.f2594d = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.f2593c.resolved = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f2591a.getDebugName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x029d, code lost:
    
        if (r6 != 1) goto L134;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        float f;
        float dimensionRatio;
        int i;
        int ordinal = this.mRunType.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    ConstraintWidget constraintWidget = this.f2591a;
                    updateRunCenter(dependency, constraintWidget.mLeft, constraintWidget.mRight, 0);
                    return;
                }
            } else {
                updateRunEnd(dependency);
            }
        } else {
            updateRunStart(dependency);
        }
        c40 c40Var = this.f2593c;
        if (!c40Var.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f2591a;
            int i2 = constraintWidget2.mMatchConstraintDefaultWidth;
            if (i2 != 2) {
                if (i2 == 3) {
                    int i3 = constraintWidget2.mMatchConstraintDefaultHeight;
                    if (i3 != 0 && i3 != 3) {
                        int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                        if (dimensionRatioSide != -1) {
                            if (dimensionRatioSide != 0) {
                                if (dimensionRatioSide != 1) {
                                    i = 0;
                                } else {
                                    ConstraintWidget constraintWidget3 = this.f2591a;
                                    f = constraintWidget3.mVerticalRun.f2593c.value;
                                    dimensionRatio = constraintWidget3.getDimensionRatio();
                                }
                            } else {
                                i = (int) ((r2.mVerticalRun.f2593c.value / this.f2591a.getDimensionRatio()) + 0.5f);
                            }
                            c40Var.resolve(i);
                        } else {
                            ConstraintWidget constraintWidget4 = this.f2591a;
                            f = constraintWidget4.mVerticalRun.f2593c.value;
                            dimensionRatio = constraintWidget4.getDimensionRatio();
                        }
                        i = (int) ((dimensionRatio * f) + 0.5f);
                        c40Var.resolve(i);
                    } else {
                        VerticalWidgetRun verticalWidgetRun = constraintWidget2.mVerticalRun;
                        DependencyNode dependencyNode = verticalWidgetRun.start;
                        DependencyNode dependencyNode2 = verticalWidgetRun.end;
                        if (constraintWidget2.mLeft.mTarget != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (constraintWidget2.mTop.mTarget != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (constraintWidget2.mRight.mTarget != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (constraintWidget2.mBottom.mTarget != null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        int dimensionRatioSide2 = constraintWidget2.getDimensionRatioSide();
                        if (z && z2 && z3 && z4) {
                            float dimensionRatio2 = this.f2591a.getDimensionRatio();
                            boolean z5 = dependencyNode.resolved;
                            int[] iArr = f2582e;
                            if (z5 && dependencyNode2.resolved) {
                                DependencyNode dependencyNode3 = this.start;
                                if (dependencyNode3.readyToSolve && this.end.readyToSolve) {
                                    m522d(iArr, ((DependencyNode) dependencyNode3.f2580g.get(0)).value + this.start.f2576c, ((DependencyNode) this.end.f2580g.get(0)).value - this.end.f2576c, dependencyNode.value + dependencyNode.f2576c, dependencyNode2.value - dependencyNode2.f2576c, dimensionRatio2, dimensionRatioSide2);
                                    c40Var.resolve(iArr[0]);
                                    this.f2591a.mVerticalRun.f2593c.resolve(iArr[1]);
                                    return;
                                }
                                return;
                            }
                            DependencyNode dependencyNode4 = this.start;
                            boolean z6 = dependencyNode4.resolved;
                            ArrayList arrayList = dependencyNode.f2580g;
                            if (z6) {
                                DependencyNode dependencyNode5 = this.end;
                                if (dependencyNode5.resolved) {
                                    if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                        m522d(iArr, dependencyNode4.value + dependencyNode4.f2576c, dependencyNode5.value - dependencyNode5.f2576c, ((DependencyNode) arrayList.get(0)).value + dependencyNode.f2576c, ((DependencyNode) dependencyNode2.f2580g.get(0)).value - dependencyNode2.f2576c, dimensionRatio2, dimensionRatioSide2);
                                        c40Var.resolve(iArr[0]);
                                        this.f2591a.mVerticalRun.f2593c.resolve(iArr[1]);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            DependencyNode dependencyNode6 = this.start;
                            if (dependencyNode6.readyToSolve && this.end.readyToSolve && dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                m522d(iArr, ((DependencyNode) dependencyNode6.f2580g.get(0)).value + this.start.f2576c, ((DependencyNode) this.end.f2580g.get(0)).value - this.end.f2576c, ((DependencyNode) arrayList.get(0)).value + dependencyNode.f2576c, ((DependencyNode) dependencyNode2.f2580g.get(0)).value - dependencyNode2.f2576c, dimensionRatio2, dimensionRatioSide2);
                                c40Var.resolve(iArr[0]);
                                this.f2591a.mVerticalRun.f2593c.resolve(iArr[1]);
                            } else {
                                return;
                            }
                        } else if (z && z3) {
                            if (this.start.readyToSolve && this.end.readyToSolve) {
                                float dimensionRatio3 = this.f2591a.getDimensionRatio();
                                int i4 = ((DependencyNode) this.start.f2580g.get(0)).value + this.start.f2576c;
                                int i5 = ((DependencyNode) this.end.f2580g.get(0)).value - this.end.f2576c;
                                if (dimensionRatioSide2 != -1 && dimensionRatioSide2 != 0) {
                                    if (dimensionRatioSide2 == 1) {
                                        int limitedDimension = getLimitedDimension(i5 - i4, 0);
                                        int i6 = (int) ((limitedDimension / dimensionRatio3) + 0.5f);
                                        int limitedDimension2 = getLimitedDimension(i6, 1);
                                        if (i6 != limitedDimension2) {
                                            limitedDimension = (int) ((limitedDimension2 * dimensionRatio3) + 0.5f);
                                        }
                                        c40Var.resolve(limitedDimension);
                                        this.f2591a.mVerticalRun.f2593c.resolve(limitedDimension2);
                                    }
                                } else {
                                    int limitedDimension3 = getLimitedDimension(i5 - i4, 0);
                                    int i7 = (int) ((limitedDimension3 * dimensionRatio3) + 0.5f);
                                    int limitedDimension4 = getLimitedDimension(i7, 1);
                                    if (i7 != limitedDimension4) {
                                        limitedDimension3 = (int) ((limitedDimension4 / dimensionRatio3) + 0.5f);
                                    }
                                    c40Var.resolve(limitedDimension3);
                                    this.f2591a.mVerticalRun.f2593c.resolve(limitedDimension4);
                                }
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                float dimensionRatio4 = this.f2591a.getDimensionRatio();
                                int i8 = ((DependencyNode) dependencyNode.f2580g.get(0)).value + dependencyNode.f2576c;
                                int i9 = ((DependencyNode) dependencyNode2.f2580g.get(0)).value - dependencyNode2.f2576c;
                                if (dimensionRatioSide2 != -1) {
                                    if (dimensionRatioSide2 == 0) {
                                        int limitedDimension5 = getLimitedDimension(i9 - i8, 1);
                                        int i10 = (int) ((limitedDimension5 * dimensionRatio4) + 0.5f);
                                        int limitedDimension6 = getLimitedDimension(i10, 0);
                                        if (i10 != limitedDimension6) {
                                            limitedDimension5 = (int) ((limitedDimension6 / dimensionRatio4) + 0.5f);
                                        }
                                        c40Var.resolve(limitedDimension6);
                                        this.f2591a.mVerticalRun.f2593c.resolve(limitedDimension5);
                                    }
                                }
                                int limitedDimension7 = getLimitedDimension(i9 - i8, 1);
                                int i11 = (int) ((limitedDimension7 / dimensionRatio4) + 0.5f);
                                int limitedDimension8 = getLimitedDimension(i11, 0);
                                if (i11 != limitedDimension8) {
                                    limitedDimension7 = (int) ((limitedDimension8 * dimensionRatio4) + 0.5f);
                                }
                                c40Var.resolve(limitedDimension8);
                                this.f2591a.mVerticalRun.f2593c.resolve(limitedDimension7);
                            } else {
                                return;
                            }
                        }
                    }
                }
            } else {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    if (parent.mHorizontalRun.f2593c.resolved) {
                        c40Var.resolve((int) ((r2.value * this.f2591a.mMatchConstraintPercentWidth) + 0.5f));
                    }
                }
            }
        }
        DependencyNode dependencyNode7 = this.start;
        if (dependencyNode7.readyToSolve) {
            DependencyNode dependencyNode8 = this.end;
            if (dependencyNode8.readyToSolve) {
                if (dependencyNode7.resolved && dependencyNode8.resolved && c40Var.resolved) {
                    return;
                }
                if (!c40Var.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.f2591a;
                    if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInHorizontalChain()) {
                        DependencyNode dependencyNode9 = (DependencyNode) this.start.f2580g.get(0);
                        DependencyNode dependencyNode10 = (DependencyNode) this.end.f2580g.get(0);
                        int i12 = dependencyNode9.value;
                        DependencyNode dependencyNode11 = this.start;
                        int i13 = i12 + dependencyNode11.f2576c;
                        int i14 = dependencyNode10.value + this.end.f2576c;
                        dependencyNode11.resolve(i13);
                        this.end.resolve(i14);
                        c40Var.resolve(i14 - i13);
                        return;
                    }
                }
                if (!c40Var.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.f2580g.size() > 0 && this.end.f2580g.size() > 0) {
                    DependencyNode dependencyNode12 = (DependencyNode) this.start.f2580g.get(0);
                    int min = Math.min((((DependencyNode) this.end.f2580g.get(0)).value + this.end.f2576c) - (dependencyNode12.value + this.start.f2576c), c40Var.f8247h);
                    ConstraintWidget constraintWidget6 = this.f2591a;
                    int i15 = constraintWidget6.mMatchConstraintMaxWidth;
                    int max = Math.max(constraintWidget6.mMatchConstraintMinWidth, min);
                    if (i15 > 0) {
                        max = Math.min(i15, max);
                    }
                    c40Var.resolve(max);
                }
                if (!c40Var.resolved) {
                    return;
                }
                DependencyNode dependencyNode13 = (DependencyNode) this.start.f2580g.get(0);
                DependencyNode dependencyNode14 = (DependencyNode) this.end.f2580g.get(0);
                int i16 = dependencyNode13.value + this.start.f2576c;
                int i17 = dependencyNode14.value + this.end.f2576c;
                float horizontalBiasPercent = this.f2591a.getHorizontalBiasPercent();
                if (dependencyNode13 == dependencyNode14) {
                    i16 = dependencyNode13.value;
                    i17 = dependencyNode14.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) ((((i17 - i16) - c40Var.value) * horizontalBiasPercent) + i16 + 0.5f));
                this.end.resolve(this.start.value + c40Var.value);
            }
        }
    }
}
