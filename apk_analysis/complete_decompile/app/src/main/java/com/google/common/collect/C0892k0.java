package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: com.google.common.collect.k0 */
/* loaded from: classes.dex */
public final class C0892k0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Comparator f14863a;

    /* renamed from: b */
    public final Object[] f14864b;

    public C0892k0(Comparator comparator, Object[] objArr) {
        this.f14863a = comparator;
        this.f14864b = objArr;
    }

    public Object readResolve() {
        return new ImmutableSortedSet.Builder(this.f14863a).add(this.f14864b).build();
    }
}
