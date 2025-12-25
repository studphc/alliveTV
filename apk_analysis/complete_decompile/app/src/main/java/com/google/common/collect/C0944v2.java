package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.common.collect.v2 */
/* loaded from: classes.dex */
public final class C0944v2 extends ForwardingCollection implements Set {

    /* renamed from: a */
    public final transient ImmutableList f14978a;

    /* renamed from: b */
    public final transient C0896l f14979b;

    public C0944v2(ImmutableList immutableList, C0896l c0896l) {
        this.f14978a = immutableList;
        this.f14979b = c0896l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = list.size();
        ImmutableList immutableList = this.f14978a;
        if (size != immutableList.size()) {
            return false;
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!((ImmutableSet) immutableList.get(i)).contains(it.next())) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f14979b;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj instanceof C0944v2) {
            return this.f14978a.equals(((C0944v2) obj).f14978a);
        }
        return super.equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        ImmutableList immutableList;
        int i = 1;
        int size = size() - 1;
        int i2 = 0;
        while (true) {
            immutableList = this.f14978a;
            if (i2 >= immutableList.size()) {
                break;
            }
            size = ~(~(size * 31));
            i2++;
        }
        UnmodifiableIterator it = immutableList.iterator();
        while (it.hasNext()) {
            Set set = (Set) it.next();
            i = ~(~((set.hashCode() * (size() / set.size())) + (i * 31)));
        }
        return ~(~(i + size));
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        return this.f14979b;
    }
}
