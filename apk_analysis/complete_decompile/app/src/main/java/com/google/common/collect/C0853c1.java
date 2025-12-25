package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import p000.tp1;

/* renamed from: com.google.common.collect.c1 */
/* loaded from: classes.dex */
public final class C0853c1 extends MultimapBuilder.ListMultimapBuilder {

    /* renamed from: a */
    public final /* synthetic */ int f14784a;

    /* renamed from: b */
    public final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f14785b;

    public C0853c1(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys, int i) {
        this.f14785b = multimapBuilderWithKeys;
        this.f14784a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
    public final ListMultimap build() {
        return Multimaps.newListMultimap(this.f14785b.mo4058a(), new tp1(this.f14784a, 0));
    }
}
