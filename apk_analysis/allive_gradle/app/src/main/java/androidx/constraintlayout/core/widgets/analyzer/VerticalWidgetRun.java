package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.recyclerview.widget.RecyclerView;
import p000.C0592cg;
import p000.c40;
import p000.k53;

/* loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;

    /* renamed from: e */
    public C0592cg f2583e;

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.f2583e = null;
        this.start.f2575b = 6;
        this.end.f2575b = 7;
        dependencyNode.f2575b = 8;
        this.orientation = 1;
    }

    /* JADX WARN: Type inference failed for: r0v133, types: [cg, c40] */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: a */
    public final void mo504a() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.f2591a;
        boolean z = constraintWidget.measured;
        c40 c40Var = this.f2593c;
        if (z) {
            c40Var.resolve(constraintWidget.getHeight());
        }
        if (!c40Var.resolved) {
            this.mDimensionBehavior = this.f2591a.getVerticalDimensionBehaviour();
            if (this.f2591a.hasBaseline()) {
                this.f2583e = new c40(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mDimensionBehavior;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.f2591a.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.f2591a.mTop.getMargin()) - this.f2591a.mBottom.getMargin();
                    addTarget(this.start, parent2.mVerticalRun.start, this.f2591a.mTop.getMargin());
                    addTarget(this.end, parent2.mVerticalRun.end, -this.f2591a.mBottom.getMargin());
                    c40Var.resolve(height);
                    return;
                }
                if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    c40Var.resolve(this.f2591a.getHeight());
                }
            }
        } else if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.f2591a.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            addTarget(this.start, parent.mVerticalRun.start, this.f2591a.mTop.getMargin());
            addTarget(this.end, parent.mVerticalRun.end, -this.f2591a.mBottom.getMargin());
            return;
        }
        boolean z2 = c40Var.resolved;
        if (z2) {
            ConstraintWidget constraintWidget2 = this.f2591a;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget2.isInVerticalChain()) {
                        this.start.f2576c = this.f2591a.mListAnchors[2].getMargin();
                        this.end.f2576c = -this.f2591a.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target = getTarget(this.f2591a.mListAnchors[2]);
                        if (target != null) {
                            addTarget(this.start, target, this.f2591a.mListAnchors[2].getMargin());
                        }
                        DependencyNode target2 = getTarget(this.f2591a.mListAnchors[3]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.f2591a.mListAnchors[3].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    if (this.f2591a.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.f2591a.getBaselineDistance());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.f2591a.mListAnchors[2].getMargin());
                        addTarget(this.end, this.start, c40Var.value);
                        if (this.f2591a.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.f2591a.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.f2591a.mListAnchors[3].getMargin());
                        addTarget(this.start, this.end, -c40Var.value);
                    }
                    if (this.f2591a.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.f2591a.getBaselineDistance());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.mTarget != null) {
                    DependencyNode target5 = getTarget(constraintAnchor4);
                    if (target5 != null) {
                        addTarget(this.baseline, target5, 0);
                        addTarget(this.start, this.baseline, -this.f2591a.getBaselineDistance());
                        addTarget(this.end, this.start, c40Var.value);
                        return;
                    }
                    return;
                }
                if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.f2591a.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                    addTarget(this.start, this.f2591a.getParent().mVerticalRun.start, this.f2591a.getY());
                    addTarget(this.end, this.start, c40Var.value);
                    if (this.f2591a.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.f2591a.getBaselineDistance());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (!z2 && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f2591a;
            int i = constraintWidget3.mMatchConstraintDefaultHeight;
            if (i != 2) {
                if (i == 3 && !constraintWidget3.isInVerticalChain()) {
                    ConstraintWidget constraintWidget4 = this.f2591a;
                    if (constraintWidget4.mMatchConstraintDefaultWidth != 3) {
                        c40 c40Var2 = constraintWidget4.mHorizontalRun.f2593c;
                        c40Var.f2580g.add(c40Var2);
                        c40Var2.f2579f.add(c40Var);
                        c40Var.delegateToWidgetRun = true;
                        c40Var.f2579f.add(this.start);
                        c40Var.f2579f.add(this.end);
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
        } else {
            c40Var.addDependency(this);
        }
        ConstraintWidget constraintWidget5 = this.f2591a;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.mListAnchors;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget5.isInVerticalChain()) {
                this.start.f2576c = this.f2591a.mListAnchors[2].getMargin();
                this.end.f2576c = -this.f2591a.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = getTarget(this.f2591a.mListAnchors[2]);
                DependencyNode target7 = getTarget(this.f2591a.mListAnchors[3]);
                if (target6 != null) {
                    target6.addDependency(this);
                }
                if (target7 != null) {
                    target7.addDependency(this);
                }
                this.mRunType = k53.f20754b;
            }
            if (this.f2591a.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.f2583e);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode target8 = getTarget(constraintAnchor5);
            if (target8 != null) {
                addTarget(this.start, target8, this.f2591a.mListAnchors[2].getMargin());
                addTarget(this.end, this.start, 1, c40Var);
                if (this.f2591a.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.f2583e);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mDimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f2591a.getDimensionRatio() > RecyclerView.f7068F0) {
                    HorizontalWidgetRun horizontalWidgetRun = this.f2591a.mHorizontalRun;
                    if (horizontalWidgetRun.mDimensionBehavior == dimensionBehaviour3) {
                        horizontalWidgetRun.f2593c.f2579f.add(c40Var);
                        c40Var.f2580g.add(this.f2591a.mHorizontalRun.f2593c);
                        c40Var.updateDelegate = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                DependencyNode target9 = getTarget(constraintAnchor7);
                if (target9 != null) {
                    addTarget(this.end, target9, -this.f2591a.mListAnchors[3].getMargin());
                    addTarget(this.start, this.end, -1, c40Var);
                    if (this.f2591a.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.f2583e);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    DependencyNode target10 = getTarget(constraintAnchor8);
                    if (target10 != null) {
                        addTarget(this.baseline, target10, 0);
                        addTarget(this.start, this.baseline, -1, this.f2583e);
                        addTarget(this.end, this.start, 1, c40Var);
                    }
                } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.getParent() != null) {
                    addTarget(this.start, this.f2591a.getParent().mVerticalRun.start, this.f2591a.getY());
                    addTarget(this.end, this.start, 1, c40Var);
                    if (this.f2591a.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.f2583e);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.mDimensionBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f2591a.getDimensionRatio() > RecyclerView.f7068F0) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.f2591a.mHorizontalRun;
                        if (horizontalWidgetRun2.mDimensionBehavior == dimensionBehaviour5) {
                            horizontalWidgetRun2.f2593c.f2579f.add(c40Var);
                            c40Var.f2580g.add(this.f2591a.mHorizontalRun.f2593c);
                            c40Var.updateDelegate = this;
                        }
                    }
                }
            }
        }
        if (c40Var.f2580g.size() == 0) {
            c40Var.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.f2591a.setY(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: b */
    public final void mo505b() {
        this.f2592b = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.f2593c.clear();
        this.f2594d = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: c */
    public final boolean mo506c() {
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f2591a.mMatchConstraintDefaultHeight == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public final void m524d() {
        this.f2594d = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.f2593c.resolved = false;
    }

    public String toString() {
        return "VerticalRun " + this.f2591a.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        float f;
        float dimensionRatio;
        int i;
        int ordinal = this.mRunType.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    ConstraintWidget constraintWidget = this.f2591a;
                    updateRunCenter(dependency, constraintWidget.mTop, constraintWidget.mBottom, 1);
                    return;
                }
            } else {
                updateRunEnd(dependency);
            }
        } else {
            updateRunStart(dependency);
        }
        c40 c40Var = this.f2593c;
        if (c40Var.readyToSolve && !c40Var.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f2591a;
            int i2 = constraintWidget2.mMatchConstraintDefaultHeight;
            if (i2 != 2) {
                if (i2 == 3 && constraintWidget2.mHorizontalRun.f2593c.resolved) {
                    int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                    if (dimensionRatioSide != -1) {
                        if (dimensionRatioSide != 0) {
                            if (dimensionRatioSide != 1) {
                                i = 0;
                            } else {
                                ConstraintWidget constraintWidget3 = this.f2591a;
                                f = constraintWidget3.mHorizontalRun.f2593c.value;
                                dimensionRatio = constraintWidget3.getDimensionRatio();
                            }
                        } else {
                            i = (int) ((this.f2591a.getDimensionRatio() * r0.mHorizontalRun.f2593c.value) + 0.5f);
                        }
                        c40Var.resolve(i);
                    } else {
                        ConstraintWidget constraintWidget4 = this.f2591a;
                        f = constraintWidget4.mHorizontalRun.f2593c.value;
                        dimensionRatio = constraintWidget4.getDimensionRatio();
                    }
                    i = (int) ((f / dimensionRatio) + 0.5f);
                    c40Var.resolve(i);
                }
            } else {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    if (parent.mVerticalRun.f2593c.resolved) {
                        c40Var.resolve((int) ((r0.value * this.f2591a.mMatchConstraintPercentHeight) + 0.5f));
                    }
                }
            }
        }
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve) {
            DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.readyToSolve) {
                if (dependencyNode.resolved && dependencyNode2.resolved && c40Var.resolved) {
                    return;
                }
                if (!c40Var.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.f2591a;
                    if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInVerticalChain()) {
                        DependencyNode dependencyNode3 = (DependencyNode) this.start.f2580g.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) this.end.f2580g.get(0);
                        int i3 = dependencyNode3.value;
                        DependencyNode dependencyNode5 = this.start;
                        int i4 = i3 + dependencyNode5.f2576c;
                        int i5 = dependencyNode4.value + this.end.f2576c;
                        dependencyNode5.resolve(i4);
                        this.end.resolve(i5);
                        c40Var.resolve(i5 - i4);
                        return;
                    }
                }
                if (!c40Var.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.f2580g.size() > 0 && this.end.f2580g.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) this.start.f2580g.get(0);
                    int i6 = (((DependencyNode) this.end.f2580g.get(0)).value + this.end.f2576c) - (dependencyNode6.value + this.start.f2576c);
                    int i7 = c40Var.f8247h;
                    if (i6 < i7) {
                        c40Var.resolve(i6);
                    } else {
                        c40Var.resolve(i7);
                    }
                }
                if (c40Var.resolved && this.start.f2580g.size() > 0 && this.end.f2580g.size() > 0) {
                    DependencyNode dependencyNode7 = (DependencyNode) this.start.f2580g.get(0);
                    DependencyNode dependencyNode8 = (DependencyNode) this.end.f2580g.get(0);
                    int i8 = dependencyNode7.value + this.start.f2576c;
                    int i9 = dependencyNode8.value + this.end.f2576c;
                    float verticalBiasPercent = this.f2591a.getVerticalBiasPercent();
                    if (dependencyNode7 == dependencyNode8) {
                        i8 = dependencyNode7.value;
                        i9 = dependencyNode8.value;
                        verticalBiasPercent = 0.5f;
                    }
                    this.start.resolve((int) ((((i9 - i8) - c40Var.value) * verticalBiasPercent) + i8 + 0.5f));
                    this.end.resolve(this.start.value + c40Var.value);
                }
            }
        }
    }
}
