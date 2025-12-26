package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class y92 extends ImmutableSet {

    /* renamed from: c */
    public final transient ImmutableMap f28872c;

    /* renamed from: d */
    public final transient Object[] f28873d;

    /* renamed from: e */
    public final transient int f28874e;

    /* renamed from: f */
    public final transient int f28875f;

    public y92(ImmutableMap immutableMap, Object[] objArr, int i, int i2) {
        this.f28872c = immutableMap;
        this.f28873d = objArr;
        this.f28874e = i;
        this.f28875f = i2;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        return asList().mo3896a(objArr, i);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (value == null || !value.equals(this.f28872c.get(key))) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSet
    /* renamed from: h */
    public final ImmutableList mo3978h() {
        return new x92(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f28875f;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return asList().iterator();
    }
}
