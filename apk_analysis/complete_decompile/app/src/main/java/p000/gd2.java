package p000;

import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.Dependency;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class gd2 {

    /* renamed from: a */
    public WidgetRun f17653a;

    /* renamed from: b */
    public ArrayList f17654b;

    /* renamed from: a */
    public static void m4937a(WidgetRun widgetRun, int i) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.f2591a.isTerminalWidget[i]) {
            return;
        }
        Iterator it = widgetRun.start.f2579f.iterator();
        while (it.hasNext()) {
            Dependency dependency = (Dependency) it.next();
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).f2574a) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator it2 = ((ChainRun) widgetRun).f2564e.iterator();
                    while (it2.hasNext()) {
                        m4937a((WidgetRun) it2.next(), i);
                    }
                } else if (!(widgetRun instanceof k01)) {
                    widgetRun.f2591a.isTerminalWidget[i] = false;
                }
                m4937a(dependencyNode2.f2574a, i);
            }
        }
        Iterator it3 = widgetRun.end.f2579f.iterator();
        while (it3.hasNext()) {
            Dependency dependency2 = (Dependency) it3.next();
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).f2574a) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator it4 = ((ChainRun) widgetRun).f2564e.iterator();
                    while (it4.hasNext()) {
                        m4937a((WidgetRun) it4.next(), i);
                    }
                } else if (!(widgetRun instanceof k01)) {
                    widgetRun.f2591a.isTerminalWidget[i] = false;
                }
                m4937a(dependencyNode.f2574a, i);
            }
        }
    }

    /* renamed from: b */
    public static long m4938b(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.f2574a;
        if (widgetRun instanceof k01) {
            return j;
        }
        ArrayList arrayList = dependencyNode.f2579f;
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) arrayList.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f2574a != widgetRun) {
                    j2 = Math.min(j2, m4938b(dependencyNode2, dependencyNode2.f2576c + j));
                }
            }
        }
        if (dependencyNode == widgetRun.end) {
            long wrapDimension = j - widgetRun.getWrapDimension();
            return Math.min(Math.min(j2, m4938b(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.f2576c);
        }
        return j2;
    }

    /* renamed from: c */
    public static long m4939c(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.f2574a;
        if (widgetRun instanceof k01) {
            return j;
        }
        ArrayList arrayList = dependencyNode.f2579f;
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) arrayList.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f2574a != widgetRun) {
                    j2 = Math.max(j2, m4939c(dependencyNode2, dependencyNode2.f2576c + j));
                }
            }
        }
        if (dependencyNode == widgetRun.start) {
            long wrapDimension = j + widgetRun.getWrapDimension();
            return Math.max(Math.max(j2, m4939c(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.f2576c);
        }
        return j2;
    }
}
