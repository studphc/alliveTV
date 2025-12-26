package p000;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.Dependency;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k01 extends WidgetRun {
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: a */
    public final void mo504a() {
        ConstraintWidget constraintWidget = this.f2591a;
        if (constraintWidget instanceof Barrier) {
            this.start.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) constraintWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
            int i = 0;
            if (barrierType != 0) {
                if (barrierType != 1) {
                    if (barrierType != 2) {
                        if (barrierType == 3) {
                            this.start.f2575b = 7;
                            while (i < barrier.mWidgetsCount) {
                                ConstraintWidget constraintWidget2 = barrier.mWidgets[i];
                                if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                                    DependencyNode dependencyNode = constraintWidget2.mVerticalRun.end;
                                    dependencyNode.f2579f.add(this.start);
                                    this.start.f2580g.add(dependencyNode);
                                }
                                i++;
                            }
                            m5474d(this.f2591a.mVerticalRun.start);
                            m5474d(this.f2591a.mVerticalRun.end);
                            return;
                        }
                        return;
                    }
                    this.start.f2575b = 6;
                    while (i < barrier.mWidgetsCount) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[i];
                        if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                            DependencyNode dependencyNode2 = constraintWidget3.mVerticalRun.start;
                            dependencyNode2.f2579f.add(this.start);
                            this.start.f2580g.add(dependencyNode2);
                        }
                        i++;
                    }
                    m5474d(this.f2591a.mVerticalRun.start);
                    m5474d(this.f2591a.mVerticalRun.end);
                    return;
                }
                this.start.f2575b = 5;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.mHorizontalRun.end;
                        dependencyNode3.f2579f.add(this.start);
                        this.start.f2580g.add(dependencyNode3);
                    }
                    i++;
                }
                m5474d(this.f2591a.mHorizontalRun.start);
                m5474d(this.f2591a.mHorizontalRun.end);
                return;
            }
            this.start.f2575b = 4;
            while (i < barrier.mWidgetsCount) {
                ConstraintWidget constraintWidget5 = barrier.mWidgets[i];
                if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.mHorizontalRun.start;
                    dependencyNode4.f2579f.add(this.start);
                    this.start.f2580g.add(dependencyNode4);
                }
                i++;
            }
            m5474d(this.f2591a.mHorizontalRun.start);
            m5474d(this.f2591a.mHorizontalRun.end);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        ConstraintWidget constraintWidget = this.f2591a;
        if (constraintWidget instanceof Barrier) {
            int barrierType = ((Barrier) constraintWidget).getBarrierType();
            if (barrierType != 0 && barrierType != 1) {
                this.f2591a.setY(this.start.value);
            } else {
                this.f2591a.setX(this.start.value);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: b */
    public final void mo505b() {
        this.f2592b = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: c */
    public final boolean mo506c() {
        return false;
    }

    /* renamed from: d */
    public final void m5474d(DependencyNode dependencyNode) {
        this.start.f2579f.add(dependencyNode);
        dependencyNode.f2580g.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.f2591a;
        int barrierType = barrier.getBarrierType();
        Iterator it = this.start.f2580g.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = ((DependencyNode) it.next()).value;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (barrierType != 0 && barrierType != 2) {
            this.start.resolve(barrier.getMargin() + i);
        } else {
            this.start.resolve(barrier.getMargin() + i2);
        }
    }
}
