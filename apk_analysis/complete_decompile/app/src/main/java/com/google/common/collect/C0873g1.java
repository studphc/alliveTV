package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import java.util.Comparator;
import p000.up1;

/* renamed from: com.google.common.collect.g1 */
/* loaded from: classes.dex */
public final class C0873g1 extends MultimapBuilder.SortedSetMultimapBuilder {

    /* renamed from: a */
    public final /* synthetic */ Comparator f14828a;

    /* renamed from: b */
    public final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f14829b;

    public C0873g1(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys, Comparator comparator) {
        this.f14829b = multimapBuilderWithKeys;
        this.f14828a = comparator;
    }

    @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
    public final SortedSetMultimap build() {
        return Multimaps.newSortedSetMultimap(this.f14829b.mo4058a(), new up1(this.f14828a));
    }
}
