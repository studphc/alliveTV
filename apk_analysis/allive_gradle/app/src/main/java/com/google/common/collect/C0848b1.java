package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: com.google.common.collect.b1 */
/* loaded from: classes.dex */
public final class C0848b1 extends MultimapBuilder.MultimapBuilderWithKeys {

    /* renamed from: a */
    public final /* synthetic */ Class f14777a;

    public C0848b1(Class cls) {
        this.f14777a = cls;
    }

    @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
    /* renamed from: a */
    public final Map mo4058a() {
        return new EnumMap(this.f14777a);
    }
}
