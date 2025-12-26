package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MotionScene {

    /* renamed from: a */
    public final ArrayList f2009a = new ArrayList();

    /* renamed from: b */
    public final ArrayList f2010b = new ArrayList();

    public void addConstraintSet(ConstraintSet constraintSet) {
        this.f2010b.add(constraintSet);
    }

    public void addTransition(Transition transition) {
        this.f2009a.add(transition);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        ArrayList arrayList = this.f2009a;
        if (!arrayList.isEmpty()) {
            sb.append("Transitions:{\n");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(((Transition) it.next()).toString());
            }
            sb.append("},\n");
        }
        ArrayList arrayList2 = this.f2010b;
        if (!arrayList2.isEmpty()) {
            sb.append("ConstraintSets:{\n");
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                sb.append(((ConstraintSet) it2.next()).toString());
            }
            sb.append("},\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
