package p000;

import androidx.constraintlayout.core.widgets.analyzer.Dependency;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c40 extends DependencyNode {

    /* renamed from: h */
    public int f8247h;

    public c40(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.f2575b = 2;
        } else {
            this.f2575b = 3;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public final void resolve(int i) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = i;
        Iterator it = this.f2579f.iterator();
        while (it.hasNext()) {
            Dependency dependency = (Dependency) it.next();
            dependency.update(dependency);
        }
    }
}
