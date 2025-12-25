package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Map;
import p000.AbstractC2041z1;

/* renamed from: com.google.common.collect.p0 */
/* loaded from: classes.dex */
public final class C0917p0 extends AbstractC2041z1 {

    /* renamed from: a */
    public final /* synthetic */ Map.Entry f14935a;

    /* renamed from: b */
    public final /* synthetic */ Maps.EntryTransformer f14936b;

    public C0917p0(Map.Entry entry, Maps.EntryTransformer entryTransformer) {
        this.f14935a = entry;
        this.f14936b = entryTransformer;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f14935a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Map.Entry entry = this.f14935a;
        return this.f14936b.transformEntry(entry.getKey(), entry.getValue());
    }
}
