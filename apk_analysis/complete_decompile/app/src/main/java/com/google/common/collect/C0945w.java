package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p000.md0;
import p000.p63;

/* renamed from: com.google.common.collect.w */
/* loaded from: classes.dex */
public final class C0945w extends C0893k1 {

    /* renamed from: d */
    public final /* synthetic */ md0 f14980d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0945w(md0 md0Var) {
        super(md0Var);
        this.f14980d = md0Var;
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public final Set entrySet() {
        return new C0941v(this);
    }

    @Override // com.google.common.collect.C0893k1, com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public final int remove(Object obj, int i) {
        p63.m6869m(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        md0 md0Var = this.f14980d;
        Collection collection = (Collection) md0Var.f22895f.asMap().get(obj);
        int i2 = 0;
        if (collection == null) {
            return 0;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (md0Var.f22896g.apply(Maps.immutableEntry(obj, it.next())) && (i2 = i2 + 1) <= i) {
                it.remove();
            }
        }
        return i2;
    }
}
