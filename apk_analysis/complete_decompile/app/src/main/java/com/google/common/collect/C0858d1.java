package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import p000.vp1;

/* renamed from: com.google.common.collect.d1 */
/* loaded from: classes.dex */
public final class C0858d1 extends MultimapBuilder.ListMultimapBuilder {

    /* renamed from: a */
    public final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f14798a;

    public C0858d1(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys) {
        this.f14798a = multimapBuilderWithKeys;
    }

    @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
    public final ListMultimap build() {
        return Multimaps.newListMultimap(this.f14798a.mo4058a(), vp1.f27911a);
    }
}
