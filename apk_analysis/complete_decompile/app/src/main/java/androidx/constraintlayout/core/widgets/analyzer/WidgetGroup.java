package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.i53;
import p000.ye0;

/* loaded from: classes.dex */
public class WidgetGroup {

    /* renamed from: g */
    public static int f2584g;

    /* renamed from: b */
    public final int f2586b;

    /* renamed from: d */
    public int f2588d;

    /* renamed from: a */
    public final ArrayList f2585a = new ArrayList();

    /* renamed from: c */
    public boolean f2587c = false;

    /* renamed from: e */
    public ArrayList f2589e = null;

    /* renamed from: f */
    public int f2590f = -1;

    public WidgetGroup(int i) {
        int i2 = f2584g;
        f2584g = i2 + 1;
        this.f2586b = i2;
        this.f2588d = i;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        ArrayList arrayList = this.f2585a;
        if (arrayList.contains(constraintWidget)) {
            return false;
        }
        arrayList.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.f2589e == null || !this.f2587c) {
            return;
        }
        for (int i = 0; i < this.f2589e.size(); i++) {
            i53 i53Var = (i53) this.f2589e.get(i);
            ConstraintWidget constraintWidget = (ConstraintWidget) i53Var.f18306a.get();
            if (constraintWidget != null) {
                constraintWidget.setFinalFrame(i53Var.f18307b, i53Var.f18308c, i53Var.f18309d, i53Var.f18310e, i53Var.f18311f, i53Var.f18312g);
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.f2585a.size();
        if (this.f2590f != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                WidgetGroup widgetGroup = arrayList.get(i);
                if (this.f2590f == widgetGroup.f2586b) {
                    moveTo(this.f2588d, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.f2585a.clear();
    }

    public int getId() {
        return this.f2586b;
    }

    public int getOrientation() {
        return this.f2588d;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2585a;
            if (i >= arrayList.size()) {
                return false;
            }
            if (widgetGroup.f2585a.contains((ConstraintWidget) arrayList.get(i))) {
                return true;
            }
            i++;
        }
    }

    public boolean isAuthoritative() {
        return this.f2587c;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [i53, java.lang.Object] */
    public int measureWrap(LinearSystem linearSystem, int i) {
        int objectVariableValue;
        int objectVariableValue2;
        ArrayList arrayList = this.f2585a;
        if (arrayList.size() == 0) {
            return 0;
        }
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) ((ConstraintWidget) arrayList.get(0)).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((ConstraintWidget) arrayList.get(i2)).addToSolver(linearSystem, false);
        }
        if (i == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.f2589e = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(i3);
            ?? obj = new Object();
            obj.f18306a = new WeakReference(constraintWidget);
            obj.f18307b = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            obj.f18308c = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            obj.f18309d = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            obj.f18310e = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            obj.f18311f = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            obj.f18312g = i;
            this.f2589e.add(obj);
        }
        if (i == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public void moveTo(int i, WidgetGroup widgetGroup) {
        Iterator it = this.f2585a.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            widgetGroup.add(constraintWidget);
            if (i == 0) {
                constraintWidget.horizontalGroup = widgetGroup.getId();
            } else {
                constraintWidget.verticalGroup = widgetGroup.getId();
            }
        }
        this.f2590f = widgetGroup.f2586b;
    }

    public void setAuthoritative(boolean z) {
        this.f2587c = z;
    }

    public void setOrientation(int i) {
        this.f2588d = i;
    }

    public int size() {
        return this.f2585a.size();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        int i = this.f2588d;
        if (i == 0) {
            str = "Horizontal";
        } else if (i == 1) {
            str = "Vertical";
        } else if (i == 2) {
            str = "Both";
        } else {
            str = "Unknown";
        }
        sb.append(str);
        sb.append(" [");
        String m8298r = ye0.m8298r(sb, "] <", this.f2586b);
        Iterator it = this.f2585a.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            StringBuilder m8303w = ye0.m8303w(m8298r, " ");
            m8303w.append(constraintWidget.getDebugName());
            m8298r = m8303w.toString();
        }
        return AbstractC1726qj.m7057m(m8298r, " >");
    }
}
