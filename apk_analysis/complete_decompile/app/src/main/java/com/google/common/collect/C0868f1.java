package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import p000.tp1;

/* renamed from: com.google.common.collect.f1 */
/* loaded from: classes.dex */
public final class C0868f1 extends MultimapBuilder.SetMultimapBuilder {

    /* renamed from: a */
    public final /* synthetic */ int f14817a;

    /* renamed from: b */
    public final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f14818b;

    public C0868f1(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys, int i) {
        this.f14818b = multimapBuilderWithKeys;
        this.f14817a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
    public final SetMultimap build() {
        return Multimaps.newSetMultimap(this.f14818b.mo4058a(), new tp1(this.f14817a, 2));
    }
}
