package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import p000.c40;
import p000.gd2;
import p000.j53;
import p000.k53;

/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {

    /* renamed from: a */
    public ConstraintWidget f2591a;

    /* renamed from: b */
    public gd2 f2592b;
    protected ConstraintWidget.DimensionBehaviour mDimensionBehavior;
    public int matchConstraintsType;

    /* renamed from: c */
    public final c40 f2593c = new c40(this);
    public int orientation = 0;

    /* renamed from: d */
    public boolean f2594d = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    protected k53 mRunType = k53.f20753a;

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f2591a = constraintWidget;
    }

    /* renamed from: a */
    public abstract void mo504a();

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.f2580g.add(dependencyNode2);
        dependencyNode.f2576c = i;
        dependencyNode2.f2579f.add(dependencyNode);
    }

    public abstract void applyToWidget();

    /* renamed from: b */
    public abstract void mo505b();

    /* renamed from: c */
    public abstract boolean mo506c();

    public final int getLimitedDimension(int i, int i2) {
        int max;
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.f2591a;
            int i3 = constraintWidget.mMatchConstraintMaxWidth;
            max = Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f2591a;
            int i4 = constraintWidget2.mMatchConstraintMaxHeight;
            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i = j53.f20382a[constraintAnchor2.mType.ordinal()];
        if (i == 1) {
            return constraintWidget.mHorizontalRun.start;
        }
        if (i == 2) {
            return constraintWidget.mHorizontalRun.end;
        }
        if (i == 3) {
            return constraintWidget.mVerticalRun.start;
        }
        if (i == 4) {
            return constraintWidget.mVerticalRun.baseline;
        }
        if (i != 5) {
            return null;
        }
        return constraintWidget.mVerticalRun.end;
    }

    public long getWrapDimension() {
        if (this.f2593c.resolved) {
            return r0.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.f2580g.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (((DependencyNode) this.start.f2580g.get(i2)).f2574a != this) {
                i++;
            }
        }
        int size2 = this.end.f2580g.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (((DependencyNode) this.end.f2580g.get(i3)).f2574a != this) {
                i++;
            }
        }
        if (i < 2) {
            return false;
        }
        return true;
    }

    public boolean isDimensionResolved() {
        return this.f2593c.resolved;
    }

    public boolean isResolved() {
        return this.f2594d;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r9.matchConstraintsType == 3) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        float verticalBiasPercent;
        WidgetRun widgetRun;
        float f;
        int i2;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = constraintAnchor.getMargin() + target.value;
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i3 = margin2 - margin;
            c40 c40Var = this.f2593c;
            if (!c40Var.resolved) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mDimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour2) {
                    int i4 = this.matchConstraintsType;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                if (i4 == 3) {
                                    ConstraintWidget constraintWidget = this.f2591a;
                                    WidgetRun widgetRun2 = constraintWidget.mHorizontalRun;
                                    if (widgetRun2.mDimensionBehavior == dimensionBehaviour2 && widgetRun2.matchConstraintsType == 3) {
                                        VerticalWidgetRun verticalWidgetRun = constraintWidget.mVerticalRun;
                                        if (verticalWidgetRun.mDimensionBehavior == dimensionBehaviour2) {
                                        }
                                    }
                                    if (i == 0) {
                                        widgetRun2 = constraintWidget.mVerticalRun;
                                    }
                                    if (widgetRun2.f2593c.resolved) {
                                        float dimensionRatio = constraintWidget.getDimensionRatio();
                                        c40 c40Var2 = widgetRun2.f2593c;
                                        if (i == 1) {
                                            i2 = (int) ((c40Var2.value / dimensionRatio) + 0.5f);
                                        } else {
                                            i2 = (int) ((dimensionRatio * c40Var2.value) + 0.5f);
                                        }
                                        c40Var.resolve(i2);
                                    }
                                }
                            } else {
                                ConstraintWidget parent = this.f2591a.getParent();
                                if (parent != null) {
                                    if (i == 0) {
                                        widgetRun = parent.mHorizontalRun;
                                    } else {
                                        widgetRun = parent.mVerticalRun;
                                    }
                                    if (widgetRun.f2593c.resolved) {
                                        if (i == 0) {
                                            f = this.f2591a.mMatchConstraintPercentWidth;
                                        } else {
                                            f = this.f2591a.mMatchConstraintPercentHeight;
                                        }
                                        c40Var.resolve(getLimitedDimension((int) ((r3.value * f) + 0.5f), i));
                                    }
                                }
                            }
                        } else {
                            c40Var.resolve(Math.min(getLimitedDimension(c40Var.f8247h, i), i3));
                        }
                    } else {
                        c40Var.resolve(getLimitedDimension(i3, i));
                    }
                }
            }
            if (!c40Var.resolved) {
                return;
            }
            if (c40Var.value == i3) {
                this.start.resolve(margin);
                this.end.resolve(margin2);
                return;
            }
            if (i == 0) {
                verticalBiasPercent = this.f2591a.getHorizontalBiasPercent();
            } else {
                verticalBiasPercent = this.f2591a.getVerticalBiasPercent();
            }
            if (target == target2) {
                margin = target.value;
                margin2 = target2.value;
                verticalBiasPercent = 0.5f;
            }
            this.start.resolve((int) ((((margin2 - margin) - c40Var.value) * verticalBiasPercent) + margin + 0.5f));
            this.end.resolve(this.start.value + c40Var.value);
        }
    }

    public void updateRunEnd(Dependency dependency) {
    }

    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i) {
        int i2;
        c40 c40Var = this.f2593c;
        if (c40Var.resolved) {
            long j = c40Var.value;
            if (isCenterConnection()) {
                i2 = this.start.f2576c - this.end.f2576c;
            } else if (i == 0) {
                i2 = this.start.f2576c;
            } else {
                return j - this.end.f2576c;
            }
            return j + i2;
        }
        return 0L;
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, c40 c40Var) {
        dependencyNode.f2580g.add(dependencyNode2);
        dependencyNode.f2580g.add(this.f2593c);
        dependencyNode.f2577d = i;
        dependencyNode.f2578e = c40Var;
        dependencyNode2.f2579f.add(dependencyNode);
        c40Var.f2579f.add(dependencyNode);
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.mHorizontalRun : constraintWidget.mVerticalRun;
        int i2 = j53.f20382a[constraintAnchor2.mType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }
}
