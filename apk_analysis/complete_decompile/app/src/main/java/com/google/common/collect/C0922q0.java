package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;

/* renamed from: com.google.common.collect.q0 */
/* loaded from: classes.dex */
public final class C0922q0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ Maps.EntryTransformer f14941a;

    public C0922q0(Maps.EntryTransformer entryTransformer) {
        this.f14941a = entryTransformer;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Maps.EntryTransformer entryTransformer = this.f14941a;
        Preconditions.checkNotNull(entryTransformer);
        Preconditions.checkNotNull(entry);
        return new C0917p0(entry, entryTransformer);
    }
}
