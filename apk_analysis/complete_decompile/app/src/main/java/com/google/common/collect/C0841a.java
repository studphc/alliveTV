package com.google.common.collect;

import com.google.common.base.Preconditions;
import p000.AbstractC2004y1;
import p000.gt1;

/* renamed from: com.google.common.collect.a */
/* loaded from: classes.dex */
public final class C0841a extends AbstractC2004y1 {

    /* renamed from: f */
    public final /* synthetic */ AbstractC0846b f14763f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0841a(AbstractC0846b abstractC0846b) {
        super(abstractC0846b);
        this.f14763f = abstractC0846b;
    }

    @Override // p000.AbstractC2004y1
    /* renamed from: b */
    public final Object mo4079b(int i) {
        C0869f2 c0869f2 = this.f14763f.f14773c;
        Preconditions.checkElementIndex(i, c0869f2.f14821c);
        return new gt1(c0869f2, i);
    }
}
