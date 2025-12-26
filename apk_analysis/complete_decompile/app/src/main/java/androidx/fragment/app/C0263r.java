package androidx.fragment.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.hu0;
import p000.zt0;

/* renamed from: androidx.fragment.app.r */
/* loaded from: classes.dex */
public final class C0263r implements zt0 {

    /* renamed from: a */
    public final String f4688a;

    /* renamed from: b */
    public final /* synthetic */ FragmentManager f4689b;

    public C0263r(FragmentManager fragmentManager, String str) {
        this.f4689b = fragmentManager;
        this.f4688a = str;
    }

    @Override // p000.zt0
    /* renamed from: a */
    public final boolean mo1218a(ArrayList arrayList, ArrayList arrayList2) {
        String str;
        String str2;
        int i;
        FragmentManager fragmentManager = this.f4689b;
        String str3 = this.f4688a;
        int m1155B = fragmentManager.m1155B(str3, -1, true);
        if (m1155B < 0) {
            return false;
        }
        for (int i2 = m1155B; i2 < fragmentManager.f4518d.size(); i2++) {
            C0246a c0246a = (C0246a) fragmentManager.f4518d.get(i2);
            if (!c0246a.f4611r) {
                fragmentManager.m1176a0(new IllegalArgumentException("saveBackStack(\"" + str3 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + c0246a + " that did not use setReorderingAllowed(true)."));
                throw null;
            }
        }
        HashSet hashSet = new HashSet();
        for (int i3 = m1155B; i3 < fragmentManager.f4518d.size(); i3++) {
            C0246a c0246a2 = (C0246a) fragmentManager.f4518d.get(i3);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Iterator it = c0246a2.f4596c.iterator();
            while (it.hasNext()) {
                hu0 hu0Var = (hu0) it.next();
                Fragment fragment = hu0Var.f18175b;
                if (fragment != null) {
                    if (!hu0Var.f18176c || (i = hu0Var.f18174a) == 1 || i == 2 || i == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i4 = hu0Var.f18174a;
                    if (i4 == 1 || i4 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder m7065u = AbstractC1726qj.m7065u("saveBackStack(\"", str3, "\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                if (hashSet2.size() == 1) {
                    str2 = " " + hashSet2.iterator().next();
                } else {
                    str2 = "s " + hashSet2;
                }
                m7065u.append(str2);
                m7065u.append(" in ");
                m7065u.append(c0246a2);
                m7065u.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                fragmentManager.m1176a0(new IllegalArgumentException(m7065u.toString()));
                throw null;
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.f4422E) {
                StringBuilder m7065u2 = AbstractC1726qj.m7065u("saveBackStack(\"", str3, "\") must not contain retained fragments. Found ");
                if (hashSet.contains(fragment2)) {
                    str = "direct reference to retained ";
                } else {
                    str = "retained child ";
                }
                m7065u2.append(str);
                m7065u2.append("fragment ");
                m7065u2.append(fragment2);
                fragmentManager.m1176a0(new IllegalArgumentException(m7065u2.toString()));
                throw null;
            }
            Iterator it2 = fragment2.f4470x.f4517c.m6253e().iterator();
            while (it2.hasNext()) {
                Fragment fragment3 = (Fragment) it2.next();
                if (fragment3 != null) {
                    arrayDeque.addLast(fragment3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Fragment) it3.next()).f4452f);
        }
        ArrayList arrayList4 = new ArrayList(fragmentManager.f4518d.size() - m1155B);
        for (int i5 = m1155B; i5 < fragmentManager.f4518d.size(); i5++) {
            arrayList4.add(null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = fragmentManager.f4518d.size() - 1; size >= m1155B; size--) {
            C0246a c0246a3 = (C0246a) fragmentManager.f4518d.remove(size);
            C0246a c0246a4 = new C0246a(c0246a3);
            c0246a4.m1220f();
            arrayList4.set(size - m1155B, new BackStackRecordState(c0246a4));
            c0246a3.f4648w = true;
            arrayList.add(c0246a3);
            arrayList2.add(Boolean.TRUE);
        }
        fragmentManager.f4526l.put(str3, backStackState);
        return true;
    }
}
