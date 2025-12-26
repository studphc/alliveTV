package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import p000.tp1;

/* renamed from: com.google.common.collect.e1 */
/* loaded from: classes.dex */
public final class C0863e1 extends MultimapBuilder.SetMultimapBuilder {

    /* renamed from: a */
    public final /* synthetic */ int f14809a;

    /* renamed from: b */
    public final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f14810b;

    public C0863e1(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys, int i) {
        this.f14810b = multimapBuilderWithKeys;
        this.f14809a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
    public final SetMultimap build() {
        return Multimaps.newSetMultimap(this.f14810b.mo4058a(), new tp1(this.f14809a, 1));
    }
}
