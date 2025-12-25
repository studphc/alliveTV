package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;

/* renamed from: com.google.common.collect.o0 */
/* loaded from: classes.dex */
public final class C0912o0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ Maps.EntryTransformer f14912a;

    public C0912o0(Maps.EntryTransformer entryTransformer) {
        this.f14912a = entryTransformer;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.f14912a.transformEntry(entry.getKey(), entry.getValue());
    }
}
