package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/* renamed from: com.google.common.collect.r0 */
/* loaded from: classes.dex */
public final class C0926r0 implements Maps.EntryTransformer {

    /* renamed from: a */
    public final /* synthetic */ Function f14945a;

    public C0926r0(Function function) {
        this.f14945a = function;
    }

    @Override // com.google.common.collect.Maps.EntryTransformer
    public final Object transformEntry(Object obj, Object obj2) {
        return this.f14945a.apply(obj2);
    }
}
