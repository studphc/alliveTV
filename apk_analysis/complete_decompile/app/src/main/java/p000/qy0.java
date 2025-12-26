package p000;

import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.Dependency;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes.dex */
public final class qy0 extends WidgetRun {
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: a */
    public final void mo504a() {
        Guideline guideline = (Guideline) this.f2591a;
        int relativeBegin = guideline.getRelativeBegin();
        int relativeEnd = guideline.getRelativeEnd();
        guideline.getRelativePercent();
        if (guideline.getOrientation() == 1) {
            if (relativeBegin != -1) {
                this.start.f2580g.add(this.f2591a.mParent.mHorizontalRun.start);
                this.f2591a.mParent.mHorizontalRun.start.f2579f.add(this.start);
                this.start.f2576c = relativeBegin;
            } else if (relativeEnd != -1) {
                this.start.f2580g.add(this.f2591a.mParent.mHorizontalRun.end);
                this.f2591a.mParent.mHorizontalRun.end.f2579f.add(this.start);
                this.start.f2576c = -relativeEnd;
            } else {
                DependencyNode dependencyNode = this.start;
                dependencyNode.delegateToWidgetRun = true;
                dependencyNode.f2580g.add(this.f2591a.mParent.mHorizontalRun.end);
                this.f2591a.mParent.mHorizontalRun.end.f2579f.add(this.start);
            }
            m7151d(this.f2591a.mHorizontalRun.start);
            m7151d(this.f2591a.mHorizontalRun.end);
            return;
        }
        if (relativeBegin != -1) {
            this.start.f2580g.add(this.f2591a.mParent.mVerticalRun.start);
            this.f2591a.mParent.mVerticalRun.start.f2579f.add(this.start);
            this.start.f2576c = relativeBegin;
        } else if (relativeEnd != -1) {
            this.start.f2580g.add(this.f2591a.mParent.mVerticalRun.end);
            this.f2591a.mParent.mVerticalRun.end.f2579f.add(this.start);
            this.start.f2576c = -relativeEnd;
        } else {
            DependencyNode dependencyNode2 = this.start;
            dependencyNode2.delegateToWidgetRun = true;
            dependencyNode2.f2580g.add(this.f2591a.mParent.mVerticalRun.end);
            this.f2591a.mParent.mVerticalRun.end.f2579f.add(this.start);
        }
        m7151d(this.f2591a.mVerticalRun.start);
        m7151d(this.f2591a.mVerticalRun.end);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        if (((Guideline) this.f2591a).getOrientation() == 1) {
            this.f2591a.setX(this.start.value);
        } else {
            this.f2591a.setY(this.start.value);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: b */
    public final void mo505b() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    /* renamed from: c */
    public final boolean mo506c() {
        return false;
    }

    /* renamed from: d */
    public final void m7151d(DependencyNode dependencyNode) {
        this.start.f2579f.add(dependencyNode);
        dependencyNode.f2580g.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        DependencyNode dependencyNode = this.start;
        if (!dependencyNode.readyToSolve || dependencyNode.resolved) {
            return;
        }
        DependencyNode dependencyNode2 = (DependencyNode) dependencyNode.f2580g.get(0);
        this.start.resolve((int) ((((Guideline) this.f2591a).getRelativePercent() * dependencyNode2.value) + 0.5f));
    }
}
