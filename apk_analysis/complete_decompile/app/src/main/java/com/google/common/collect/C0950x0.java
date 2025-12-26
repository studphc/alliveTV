package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference;
import p000.AbstractC1726qj;

/* renamed from: com.google.common.collect.x0 */
/* loaded from: classes.dex */
public final class C0950x0 implements MapDifference.ValueDifference {

    /* renamed from: a */
    public final Object f14989a;

    /* renamed from: b */
    public final Object f14990b;

    public C0950x0(Object obj, Object obj2) {
        this.f14989a = obj;
        this.f14990b = obj2;
    }

    @Override // com.google.common.collect.MapDifference.ValueDifference
    public final boolean equals(Object obj) {
        if (!(obj instanceof MapDifference.ValueDifference)) {
            return false;
        }
        MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
        if (!Objects.equal(this.f14989a, valueDifference.leftValue()) || !Objects.equal(this.f14990b, valueDifference.rightValue())) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.MapDifference.ValueDifference
    public final int hashCode() {
        return Objects.hashCode(this.f14989a, this.f14990b);
    }

    @Override // com.google.common.collect.MapDifference.ValueDifference
    public final Object leftValue() {
        return this.f14989a;
    }

    @Override // com.google.common.collect.MapDifference.ValueDifference
    public final Object rightValue() {
        return this.f14990b;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f14989a);
        String valueOf2 = String.valueOf(this.f14990b);
        StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 4, "(", valueOf, ", ", valueOf2);
        m7062r.append(")");
        return m7062r.toString();
    }
}
