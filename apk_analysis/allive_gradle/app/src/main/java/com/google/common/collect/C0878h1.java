package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import p000.up1;

/* renamed from: com.google.common.collect.h1 */
/* loaded from: classes.dex */
public final class C0878h1 extends MultimapBuilder.SetMultimapBuilder {

    /* renamed from: a */
    public final /* synthetic */ Class f14838a;

    /* renamed from: b */
    public final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f14839b;

    public C0878h1(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys, Class cls) {
        this.f14839b = multimapBuilderWithKeys;
        this.f14838a = cls;
    }

    @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
    public final SetMultimap build() {
        return Multimaps.newSetMultimap(this.f14839b.mo4058a(), new up1(this.f14838a));
    }
}
