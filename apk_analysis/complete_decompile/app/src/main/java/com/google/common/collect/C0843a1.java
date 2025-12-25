package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.google.common.collect.a1 */
/* loaded from: classes.dex */
public final class C0843a1 extends MultimapBuilder.MultimapBuilderWithKeys {

    /* renamed from: a */
    public final /* synthetic */ Comparator f14767a;

    public C0843a1(Comparator comparator) {
        this.f14767a = comparator;
    }

    @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
    /* renamed from: a */
    public final Map mo4058a() {
        return new TreeMap(this.f14767a);
    }
}
