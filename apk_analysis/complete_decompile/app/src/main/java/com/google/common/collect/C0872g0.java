package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import java.util.Comparator;

/* renamed from: com.google.common.collect.g0 */
/* loaded from: classes.dex */
public final class C0872g0 extends C0847b0 {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public final Comparator f14827c;

    public C0872g0(ImmutableSortedMap immutableSortedMap) {
        super(immutableSortedMap);
        this.f14827c = immutableSortedMap.comparator();
    }

    @Override // com.google.common.collect.C0847b0
    /* renamed from: a */
    public final ImmutableMap.Builder mo4084a(int i) {
        return new ImmutableSortedMap.Builder(this.f14827c);
    }
}
