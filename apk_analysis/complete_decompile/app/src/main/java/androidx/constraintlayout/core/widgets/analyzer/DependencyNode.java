package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.c40;
import p000.ye0;

/* loaded from: classes.dex */
public class DependencyNode implements Dependency {

    /* renamed from: a */
    public final WidgetRun f2574a;

    /* renamed from: c */
    public int f2576c;
    public int value;
    public Dependency updateDelegate = null;
    public boolean delegateToWidgetRun = false;
    public boolean readyToSolve = false;

    /* renamed from: b */
    public int f2575b = 1;

    /* renamed from: d */
    public int f2577d = 1;

    /* renamed from: e */
    public c40 f2578e = null;
    public boolean resolved = false;

    /* renamed from: f */
    public final ArrayList f2579f = new ArrayList();

    /* renamed from: g */
    public final ArrayList f2580g = new ArrayList();

    public DependencyNode(WidgetRun widgetRun) {
        this.f2574a = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.f2579f.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.f2580g.clear();
        this.f2579f.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String m7057m;
        String debugName = this.f2574a.f2591a.getDebugName();
        int i = this.f2575b;
        if (i != 4 && i != 5) {
            m7057m = AbstractC1726qj.m7057m(debugName, "_VERTICAL");
        } else {
            m7057m = AbstractC1726qj.m7057m(debugName, "_HORIZONTAL");
        }
        StringBuilder m8303w = ye0.m8303w(m7057m, ":");
        m8303w.append(AbstractC1726qj.m7040E(this.f2575b));
        return m8303w.toString();
    }

    public void resolve(int i) {
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

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2574a.f2591a.getDebugName());
        sb.append(":");
        sb.append(AbstractC1726qj.m7043H(this.f2575b));
        sb.append("(");
        if (this.resolved) {
            obj = Integer.valueOf(this.value);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.f2580g.size());
        sb.append(":d=");
        sb.append(this.f2579f.size());
        sb.append(">");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        ArrayList arrayList = this.f2580g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((DependencyNode) it.next()).resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        Dependency dependency2 = this.updateDelegate;
        if (dependency2 != null) {
            dependency2.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.f2574a.update(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        DependencyNode dependencyNode = null;
        int i = 0;
        while (it2.hasNext()) {
            DependencyNode dependencyNode2 = (DependencyNode) it2.next();
            if (!(dependencyNode2 instanceof c40)) {
                i++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i == 1 && dependencyNode.resolved) {
            c40 c40Var = this.f2578e;
            if (c40Var != null) {
                if (c40Var.resolved) {
                    this.f2576c = this.f2577d * c40Var.value;
                } else {
                    return;
                }
            }
            resolve(dependencyNode.value + this.f2576c);
        }
        Dependency dependency3 = this.updateDelegate;
        if (dependency3 != null) {
            dependency3.update(this);
        }
    }
}
