package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* renamed from: com.google.common.collect.i1 */
/* loaded from: classes.dex */
public final class C0883i1 extends AbstractC0955y1 {

    /* renamed from: a */
    public final /* synthetic */ Map.Entry f14850a;

    public C0883i1(Map.Entry entry) {
        this.f14850a = entry;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final int getCount() {
        return ((Collection) this.f14850a.getValue()).size();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final Object getElement() {
        return this.f14850a.getKey();
    }
}
