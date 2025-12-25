package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Collection;

/* renamed from: com.google.common.collect.m1 */
/* loaded from: classes.dex */
public final class C0903m1 implements Maps.EntryTransformer {

    /* renamed from: a */
    public final /* synthetic */ C0908n1 f14889a;

    public C0903m1(C0908n1 c0908n1) {
        this.f14889a = c0908n1;
    }

    @Override // com.google.common.collect.Maps.EntryTransformer
    public final Object transformEntry(Object obj, Object obj2) {
        return this.f14889a.mo4133i((Collection) obj2, obj);
    }
}
