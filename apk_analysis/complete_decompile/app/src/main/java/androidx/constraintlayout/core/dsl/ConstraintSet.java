package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class ConstraintSet {

    /* renamed from: a */
    public final String f1931a;

    /* renamed from: b */
    public final ArrayList f1932b = new ArrayList();

    /* renamed from: c */
    public final ArrayList f1933c = new ArrayList();

    public ConstraintSet(String str) {
        this.f1931a = str;
    }

    public void add(Constraint constraint) {
        this.f1932b.add(constraint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(AbstractC1726qj.m7061q(new StringBuilder(), this.f1931a, ":{\n"));
        ArrayList arrayList = this.f1932b;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(((Constraint) it.next()).toString());
            }
        }
        ArrayList arrayList2 = this.f1933c;
        if (!arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                sb.append(((Helper) it2.next()).toString());
            }
        }
        sb.append("},\n");
        return sb.toString();
    }

    public void add(Helper helper) {
        this.f1933c.add(helper);
    }
}
