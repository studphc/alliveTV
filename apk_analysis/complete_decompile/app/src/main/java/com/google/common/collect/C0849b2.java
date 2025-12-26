package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Multiset;

/* renamed from: com.google.common.collect.b2 */
/* loaded from: classes.dex */
public final class C0849b2 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ C0854c2 f14778a;

    public C0849b2(C0854c2 c0854c2) {
        this.f14778a = c0854c2;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f14778a.f14787d.apply(((Multiset.Entry) obj).getElement());
    }
}
