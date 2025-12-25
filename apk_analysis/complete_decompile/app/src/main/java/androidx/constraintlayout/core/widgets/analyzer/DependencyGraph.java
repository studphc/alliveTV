package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.C0592cg;
import p000.c40;
import p000.gd2;
import p000.qy0;

/* loaded from: classes.dex */
public class DependencyGraph {

    /* renamed from: a */
    public final ConstraintWidgetContainer f2566a;

    /* renamed from: d */
    public final ConstraintWidgetContainer f2569d;

    /* renamed from: f */
    public BasicMeasure.Measurer f2571f;

    /* renamed from: g */
    public final BasicMeasure.Measure f2572g;

    /* renamed from: h */
    public final ArrayList f2573h;

    /* renamed from: b */
    public boolean f2567b = true;

    /* renamed from: c */
    public boolean f2568c = true;

    /* renamed from: e */
    public final ArrayList f2570e = new ArrayList();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        new ArrayList();
        this.f2571f = null;
        this.f2572g = new BasicMeasure.Measure();
        this.f2573h = new ArrayList();
        this.f2566a = constraintWidgetContainer;
        this.f2569d = constraintWidgetContainer;
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [gd2, java.lang.Object] */
    /* renamed from: a */
    public final void m509a(DependencyNode dependencyNode, int i, ArrayList arrayList, gd2 gd2Var) {
        WidgetRun widgetRun = dependencyNode.f2574a;
        if (widgetRun.f2592b == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f2566a;
            if (widgetRun != constraintWidgetContainer.mHorizontalRun) {
                gd2 gd2Var2 = gd2Var;
                if (widgetRun != constraintWidgetContainer.mVerticalRun) {
                    if (gd2Var == null) {
                        ?? obj = new Object();
                        obj.f17653a = null;
                        obj.f17654b = new ArrayList();
                        obj.f17653a = widgetRun;
                        arrayList.add(obj);
                        gd2Var2 = obj;
                    }
                    widgetRun.f2592b = gd2Var2;
                    gd2Var2.f17654b.add(widgetRun);
                    Iterator it = widgetRun.start.f2579f.iterator();
                    while (it.hasNext()) {
                        Dependency dependency = (Dependency) it.next();
                        if (dependency instanceof DependencyNode) {
                            m509a((DependencyNode) dependency, i, arrayList, gd2Var2);
                        }
                    }
                    Iterator it2 = widgetRun.end.f2579f.iterator();
                    while (it2.hasNext()) {
                        Dependency dependency2 = (Dependency) it2.next();
                        if (dependency2 instanceof DependencyNode) {
                            m509a((DependencyNode) dependency2, i, arrayList, gd2Var2);
                        }
                    }
                    if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                        Iterator it3 = ((VerticalWidgetRun) widgetRun).baseline.f2579f.iterator();
                        while (it3.hasNext()) {
                            Dependency dependency3 = (Dependency) it3.next();
                            if (dependency3 instanceof DependencyNode) {
                                m509a((DependencyNode) dependency3, i, arrayList, gd2Var2);
                            }
                        }
                    }
                    Iterator it4 = widgetRun.start.f2580g.iterator();
                    while (it4.hasNext()) {
                        m509a((DependencyNode) it4.next(), i, arrayList, gd2Var2);
                    }
                    Iterator it5 = widgetRun.end.f2580g.iterator();
                    while (it5.hasNext()) {
                        m509a((DependencyNode) it5.next(), i, arrayList, gd2Var2);
                    }
                    if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                        Iterator it6 = ((VerticalWidgetRun) widgetRun).baseline.f2580g.iterator();
                        while (it6.hasNext()) {
                            m509a((DependencyNode) it6.next(), i, arrayList, gd2Var2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final void m510b(ConstraintWidgetContainer constraintWidgetContainer) {
        int i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[1];
            if (next.getVisibility() == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > RecyclerView.f7068F0) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour6 && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour5 == dimensionBehaviour6 && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour4 == dimensionBehaviour6 && dimensionBehaviour5 == dimensionBehaviour6) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour4 == dimensionBehaviour7 && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                if (dimensionBehaviour5 == dimensionBehaviour7 && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = dimensionBehaviour5;
                HorizontalWidgetRun horizontalWidgetRun = next.mHorizontalRun;
                horizontalWidgetRun.mDimensionBehavior = dimensionBehaviour4;
                int i2 = next.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = i2;
                VerticalWidgetRun verticalWidgetRun = next.mVerticalRun;
                verticalWidgetRun.mDimensionBehavior = dimensionBehaviour8;
                int i3 = next.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = i3;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour4 != dimensionBehaviour9 && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour8 != dimensionBehaviour9 && dimensionBehaviour8 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    if (dimensionBehaviour4 == dimensionBehaviour7 && (dimensionBehaviour8 == (dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i2 == 3) {
                            if (dimensionBehaviour8 == dimensionBehaviour3) {
                                m513e(next, dimensionBehaviour3, 0, dimensionBehaviour3, 0);
                            }
                            int height = next.getHeight();
                            int i4 = (int) ((height * next.mDimensionRatio) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.FIXED;
                            m513e(next, dimensionBehaviour10, i4, dimensionBehaviour10, height);
                            next.mHorizontalRun.f2593c.resolve(next.getWidth());
                            next.mVerticalRun.f2593c.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i2 == 1) {
                            m513e(next, dimensionBehaviour3, 0, dimensionBehaviour8, 0);
                            next.mHorizontalRun.f2593c.f8247h = next.getWidth();
                        } else if (i2 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = constraintWidgetContainer.mListDimensionBehaviors[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour11 == dimensionBehaviour12 || dimensionBehaviour11 == dimensionBehaviour9) {
                                m513e(next, dimensionBehaviour12, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour8, next.getHeight());
                                next.mHorizontalRun.f2593c.resolve(next.getWidth());
                                next.mVerticalRun.f2593c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                m513e(next, dimensionBehaviour3, 0, dimensionBehaviour8, 0);
                                next.mHorizontalRun.f2593c.resolve(next.getWidth());
                                next.mVerticalRun.f2593c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour8 == dimensionBehaviour7 && (dimensionBehaviour4 == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i3 == 3) {
                            if (dimensionBehaviour4 == dimensionBehaviour2) {
                                m513e(next, dimensionBehaviour2, 0, dimensionBehaviour2, 0);
                            }
                            int width = next.getWidth();
                            float f = next.mDimensionRatio;
                            if (next.getDimensionRatioSide() == -1) {
                                f = 1.0f / f;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.FIXED;
                            m513e(next, dimensionBehaviour13, width, dimensionBehaviour13, (int) ((width * f) + 0.5f));
                            next.mHorizontalRun.f2593c.resolve(next.getWidth());
                            next.mVerticalRun.f2593c.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i3 == 1) {
                            m513e(next, dimensionBehaviour4, 0, dimensionBehaviour2, 0);
                            next.mVerticalRun.f2593c.f8247h = next.getHeight();
                        } else if (i3 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = constraintWidgetContainer.mListDimensionBehaviors[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour14 == dimensionBehaviour15 || dimensionBehaviour14 == dimensionBehaviour9) {
                                m513e(next, dimensionBehaviour4, next.getWidth(), dimensionBehaviour15, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                next.mHorizontalRun.f2593c.resolve(next.getWidth());
                                next.mVerticalRun.f2593c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                m513e(next, dimensionBehaviour2, 0, dimensionBehaviour8, 0);
                                next.mHorizontalRun.f2593c.resolve(next.getWidth());
                                next.mVerticalRun.f2593c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour4 == dimensionBehaviour7 && dimensionBehaviour8 == dimensionBehaviour7) {
                        if (i2 != 1 && i3 != 1) {
                            if (i3 == 2 && i2 == 2) {
                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = dimensionBehaviourArr2[0];
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour16 == dimensionBehaviour17 && dimensionBehaviourArr2[1] == dimensionBehaviour17) {
                                    m513e(next, dimensionBehaviour17, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour17, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                    next.mHorizontalRun.f2593c.resolve(next.getWidth());
                                    next.mVerticalRun.f2593c.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            }
                        } else {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            m513e(next, dimensionBehaviour18, 0, dimensionBehaviour18, 0);
                            next.mHorizontalRun.f2593c.f8247h = next.getWidth();
                            next.mVerticalRun.f2593c.f8247h = next.getHeight();
                        }
                    }
                } else {
                    int width2 = next.getWidth();
                    if (dimensionBehaviour4 == dimensionBehaviour9) {
                        width2 = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    int i5 = width2;
                    int height2 = next.getHeight();
                    if (dimensionBehaviour8 == dimensionBehaviour9) {
                        i = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i = height2;
                        dimensionBehaviour = dimensionBehaviour8;
                    }
                    m513e(next, dimensionBehaviour4, i5, dimensionBehaviour, i);
                    next.mHorizontalRun.f2593c.resolve(next.getWidth());
                    next.mVerticalRun.f2593c.resolve(next.getHeight());
                    next.measured = true;
                }
            }
        }
    }

    public void buildGraph() {
        buildGraph(this.f2570e);
        ArrayList arrayList = this.f2573h;
        arrayList.clear();
        ConstraintWidgetContainer constraintWidgetContainer = this.f2566a;
        m512d(constraintWidgetContainer.mHorizontalRun, 0, arrayList);
        m512d(constraintWidgetContainer.mVerticalRun, 1, arrayList);
        this.f2567b = false;
    }

    /* renamed from: c */
    public final int m511c(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        long wrapDimension;
        long j;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        ArrayList arrayList = this.f2573h;
        int size = arrayList.size();
        long j2 = 0;
        int i2 = 0;
        long j3 = 0;
        while (i2 < size) {
            WidgetRun widgetRun3 = ((gd2) arrayList.get(i2)).f17653a;
            if (!(widgetRun3 instanceof ChainRun) ? !(i != 0 ? (widgetRun3 instanceof VerticalWidgetRun) : (widgetRun3 instanceof HorizontalWidgetRun)) : ((ChainRun) widgetRun3).orientation != i) {
                wrapDimension = j2;
            } else {
                if (i == 0) {
                    widgetRun = constraintWidgetContainer2.mHorizontalRun;
                } else {
                    widgetRun = constraintWidgetContainer2.mVerticalRun;
                }
                DependencyNode dependencyNode = widgetRun.start;
                if (i == 0) {
                    widgetRun2 = constraintWidgetContainer2.mHorizontalRun;
                } else {
                    widgetRun2 = constraintWidgetContainer2.mVerticalRun;
                }
                DependencyNode dependencyNode2 = widgetRun2.end;
                boolean contains = widgetRun3.start.f2580g.contains(dependencyNode);
                boolean contains2 = widgetRun3.end.f2580g.contains(dependencyNode2);
                long wrapDimension2 = widgetRun3.getWrapDimension();
                if (contains && contains2) {
                    long m4939c = gd2.m4939c(widgetRun3.start, j2);
                    long m4938b = gd2.m4938b(widgetRun3.end, j2);
                    long j4 = m4939c - wrapDimension2;
                    int i3 = widgetRun3.end.f2576c;
                    if (j4 >= (-i3)) {
                        j4 += i3;
                    }
                    long j5 = widgetRun3.start.f2576c;
                    long j6 = ((-m4938b) - wrapDimension2) - j5;
                    if (j6 >= j5) {
                        j6 -= j5;
                    }
                    float biasPercent = widgetRun3.f2591a.getBiasPercent(i);
                    if (biasPercent > RecyclerView.f7068F0) {
                        j = (((float) j4) / (1.0f - biasPercent)) + (((float) j6) / biasPercent);
                    } else {
                        j = 0;
                    }
                    float f = (float) j;
                    wrapDimension = (widgetRun3.start.f2576c + ((((f * biasPercent) + 0.5f) + wrapDimension2) + AbstractC1726qj.m7051g(1.0f, biasPercent, f, 0.5f))) - widgetRun3.end.f2576c;
                } else if (contains) {
                    wrapDimension = Math.max(gd2.m4939c(widgetRun3.start, r0.f2576c), widgetRun3.start.f2576c + wrapDimension2);
                } else if (contains2) {
                    wrapDimension = Math.max(-gd2.m4938b(widgetRun3.end, r0.f2576c), (-widgetRun3.end.f2576c) + wrapDimension2);
                } else {
                    wrapDimension = (widgetRun3.getWrapDimension() + widgetRun3.start.f2576c) - widgetRun3.end.f2576c;
                }
            }
            j3 = Math.max(j3, wrapDimension);
            i2++;
            constraintWidgetContainer2 = constraintWidgetContainer;
            j2 = 0;
        }
        return (int) j3;
    }

    /* renamed from: d */
    public final void m512d(WidgetRun widgetRun, int i, ArrayList arrayList) {
        Iterator it = widgetRun.start.f2579f.iterator();
        while (it.hasNext()) {
            Dependency dependency = (Dependency) it.next();
            if (dependency instanceof DependencyNode) {
                m509a((DependencyNode) dependency, i, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                m509a(((WidgetRun) dependency).start, i, arrayList, null);
            }
        }
        Iterator it2 = widgetRun.end.f2579f.iterator();
        while (it2.hasNext()) {
            Dependency dependency2 = (Dependency) it2.next();
            if (dependency2 instanceof DependencyNode) {
                m509a((DependencyNode) dependency2, i, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                m509a(((WidgetRun) dependency2).end, i, arrayList, null);
            }
        }
        if (i == 1) {
            Iterator it3 = ((VerticalWidgetRun) widgetRun).baseline.f2579f.iterator();
            while (it3.hasNext()) {
                Dependency dependency3 = (Dependency) it3.next();
                if (dependency3 instanceof DependencyNode) {
                    m509a((DependencyNode) dependency3, i, arrayList, null);
                }
            }
        }
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        boolean z;
        boolean z2;
        if (this.f2567b) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.f2566a.mChildren.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z3 = true;
                }
            }
            if (!z3) {
                Iterator it2 = this.f2573h.iterator();
                while (it2.hasNext()) {
                    gd2 gd2Var = (gd2) it2.next();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
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
                    WidgetRun widgetRun = gd2Var.f17653a;
                    if (z && (widgetRun instanceof HorizontalWidgetRun)) {
                        gd2.m4937a(widgetRun, 0);
                    }
                    if (z2 && (widgetRun instanceof VerticalWidgetRun)) {
                        gd2.m4937a(widgetRun, 1);
                    }
                }
            }
        }
    }

    public boolean directMeasure(boolean z) {
        boolean z2;
        boolean z3 = this.f2567b;
        ConstraintWidgetContainer constraintWidgetContainer = this.f2566a;
        boolean z4 = false;
        if (z3 || this.f2568c) {
            Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.mHorizontalRun.m523e();
                next.mVerticalRun.m524d();
            }
            constraintWidgetContainer.ensureWidgetRuns();
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.mHorizontalRun.m523e();
            constraintWidgetContainer.mVerticalRun.m524d();
            this.f2568c = false;
        }
        m510b(this.f2569d);
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer.getDimensionBehaviour(1);
        if (this.f2567b) {
            buildGraph();
        }
        int x = constraintWidgetContainer.getX();
        int y = constraintWidgetContainer.getY();
        constraintWidgetContainer.mHorizontalRun.start.resolve(x);
        constraintWidgetContainer.mVerticalRun.start.resolve(y);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ArrayList arrayList = this.f2570e;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((WidgetRun) it2.next()).mo506c()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setWidth(m511c(constraintWidgetContainer, 0));
                constraintWidgetContainer.mHorizontalRun.f2593c.resolve(constraintWidgetContainer.getWidth());
            }
            if (z && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setHeight(m511c(constraintWidgetContainer, 1));
                constraintWidgetContainer.mVerticalRun.f2593c.resolve(constraintWidgetContainer.getHeight());
            }
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour4 != dimensionBehaviour5 && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            z2 = false;
        } else {
            int width = constraintWidgetContainer.getWidth() + x;
            constraintWidgetContainer.mHorizontalRun.end.resolve(width);
            constraintWidgetContainer.mHorizontalRun.f2593c.resolve(width - x);
            measureWidgets();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = constraintWidgetContainer.mListDimensionBehaviors[1];
            if (dimensionBehaviour6 == dimensionBehaviour5 || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer.getHeight() + y;
                constraintWidgetContainer.mVerticalRun.end.resolve(height);
                constraintWidgetContainer.mVerticalRun.f2593c.resolve(height - y);
            }
            measureWidgets();
            z2 = true;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it3.next();
            if (widgetRun.f2591a != constraintWidgetContainer || widgetRun.f2594d) {
                widgetRun.applyToWidget();
            }
        }
        Iterator it4 = arrayList.iterator();
        while (true) {
            if (it4.hasNext()) {
                WidgetRun widgetRun2 = (WidgetRun) it4.next();
                if (z2 || widgetRun2.f2591a != constraintWidgetContainer) {
                    if (!widgetRun2.start.resolved) {
                        break;
                    }
                    if (!widgetRun2.end.resolved) {
                        if (!(widgetRun2 instanceof qy0)) {
                            break;
                        }
                    }
                    if (!widgetRun2.f2593c.resolved && !(widgetRun2 instanceof ChainRun) && !(widgetRun2 instanceof qy0)) {
                        break;
                    }
                }
            } else {
                z4 = true;
                break;
            }
        }
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z4;
    }

    public boolean directMeasureSetup(boolean z) {
        boolean z2 = this.f2567b;
        ConstraintWidgetContainer constraintWidgetContainer = this.f2566a;
        if (z2) {
            Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = next.mHorizontalRun;
                horizontalWidgetRun.f2593c.resolved = false;
                horizontalWidgetRun.f2594d = false;
                horizontalWidgetRun.m523e();
                VerticalWidgetRun verticalWidgetRun = next.mVerticalRun;
                verticalWidgetRun.f2593c.resolved = false;
                verticalWidgetRun.f2594d = false;
                verticalWidgetRun.m524d();
            }
            constraintWidgetContainer.ensureWidgetRuns();
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.mHorizontalRun;
            horizontalWidgetRun2.f2593c.resolved = false;
            horizontalWidgetRun2.f2594d = false;
            horizontalWidgetRun2.m523e();
            VerticalWidgetRun verticalWidgetRun2 = constraintWidgetContainer.mVerticalRun;
            verticalWidgetRun2.f2593c.resolved = false;
            verticalWidgetRun2.f2594d = false;
            verticalWidgetRun2.m524d();
            buildGraph();
        }
        m510b(this.f2569d);
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.mHorizontalRun.start.resolve(0);
        constraintWidgetContainer.mVerticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        boolean z2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidgetContainer constraintWidgetContainer = this.f2566a;
        boolean z3 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidgetContainer.getDimensionBehaviour(1);
        int x = constraintWidgetContainer.getX();
        int y = constraintWidgetContainer.getY();
        ArrayList arrayList = this.f2570e;
        if (z && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun widgetRun = (WidgetRun) it.next();
                if (widgetRun.orientation == i && !widgetRun.mo506c()) {
                    z = false;
                    break;
                }
            }
            if (i == 0) {
                if (z && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidgetContainer.setWidth(m511c(constraintWidgetContainer, 0));
                    constraintWidgetContainer.mHorizontalRun.f2593c.resolve(constraintWidgetContainer.getWidth());
                }
            } else if (z && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setHeight(m511c(constraintWidgetContainer, 1));
                constraintWidgetContainer.mVerticalRun.f2593c.resolve(constraintWidgetContainer.getHeight());
            }
        }
        if (i == 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer.mListDimensionBehaviors[0];
            if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = constraintWidgetContainer.getWidth() + x;
                constraintWidgetContainer.mHorizontalRun.end.resolve(width);
                constraintWidgetContainer.mHorizontalRun.f2593c.resolve(width - x);
                z2 = true;
            }
            z2 = false;
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidgetContainer.mListDimensionBehaviors[1];
            if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer.getHeight() + y;
                constraintWidgetContainer.mVerticalRun.end.resolve(height);
                constraintWidgetContainer.mVerticalRun.f2593c.resolve(height - y);
                z2 = true;
            }
            z2 = false;
        }
        measureWidgets();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            WidgetRun widgetRun2 = (WidgetRun) it2.next();
            if (widgetRun2.orientation == i && (widgetRun2.f2591a != constraintWidgetContainer || widgetRun2.f2594d)) {
                widgetRun2.applyToWidget();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (it3.hasNext()) {
                WidgetRun widgetRun3 = (WidgetRun) it3.next();
                if (widgetRun3.orientation == i && (z2 || widgetRun3.f2591a != constraintWidgetContainer)) {
                    if (!widgetRun3.start.resolved) {
                        break;
                    }
                    if (!widgetRun3.end.resolved) {
                        break;
                    }
                    if (!(widgetRun3 instanceof ChainRun) && !widgetRun3.f2593c.resolved) {
                        break;
                    }
                }
            } else {
                z3 = true;
                break;
            }
        }
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z3;
    }

    /* renamed from: e */
    public final void m513e(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        BasicMeasure.Measure measure = this.f2572g;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.f2571f.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
    }

    public void invalidateGraph() {
        this.f2567b = true;
    }

    public void invalidateMeasures() {
        this.f2568c = true;
    }

    public void measureWidgets() {
        boolean z;
        C0592cg c0592cg;
        Iterator<ConstraintWidget> it = this.f2566a.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z2 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i = next.mMatchConstraintDefaultWidth;
                int i2 = next.mMatchConstraintDefaultHeight;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour != dimensionBehaviour3 && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || i != 1)) {
                    z = false;
                } else {
                    z = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z2 = true;
                }
                c40 c40Var = next.mHorizontalRun.f2593c;
                boolean z3 = c40Var.resolved;
                c40 c40Var2 = next.mVerticalRun.f2593c;
                boolean z4 = c40Var2.resolved;
                if (z3 && z4) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    m513e(next, dimensionBehaviour4, c40Var.value, dimensionBehaviour4, c40Var2.value);
                    next.measured = true;
                } else if (z3 && z2) {
                    m513e(next, ConstraintWidget.DimensionBehaviour.FIXED, c40Var.value, dimensionBehaviour3, c40Var2.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.mVerticalRun.f2593c.f8247h = next.getHeight();
                    } else {
                        next.mVerticalRun.f2593c.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z4 && z) {
                    m513e(next, dimensionBehaviour3, c40Var.value, ConstraintWidget.DimensionBehaviour.FIXED, c40Var2.value);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.mHorizontalRun.f2593c.f8247h = next.getWidth();
                    } else {
                        next.mHorizontalRun.f2593c.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (c0592cg = next.mVerticalRun.f2583e) != null) {
                    c0592cg.resolve(next.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.f2571f = measurer;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        ConstraintWidgetContainer constraintWidgetContainer = this.f2569d;
        constraintWidgetContainer.mHorizontalRun.mo505b();
        constraintWidgetContainer.mVerticalRun.mo505b();
        arrayList.add(constraintWidgetContainer.mHorizontalRun);
        arrayList.add(constraintWidgetContainer.mVerticalRun);
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                Guideline guideline = (Guideline) next;
                WidgetRun widgetRun = new WidgetRun(guideline);
                guideline.mHorizontalRun.mo505b();
                guideline.mVerticalRun.mo505b();
                widgetRun.orientation = guideline.getOrientation();
                arrayList.add(widgetRun);
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.mHorizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.mVerticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new WidgetRun(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().mo505b();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f2591a != constraintWidgetContainer) {
                next2.mo504a();
            }
        }
    }
}
