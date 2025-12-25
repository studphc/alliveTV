package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/* renamed from: com.google.common.collect.n0 */
/* loaded from: classes.dex */
public final class C0907n0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ Maps.EntryTransformer f14902a;

    /* renamed from: b */
    public final /* synthetic */ Object f14903b;

    public C0907n0(Maps.EntryTransformer entryTransformer, Object obj) {
        this.f14902a = entryTransformer;
        this.f14903b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f14902a.transformEntry(this.f14903b, obj);
    }
}
