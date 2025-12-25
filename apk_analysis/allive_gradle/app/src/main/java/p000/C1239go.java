package p000;

import java.util.BitSet;

/* renamed from: go */
/* loaded from: classes.dex */
public final class C1239go extends AbstractC1842to {

    /* renamed from: b */
    public final BitSet f17777b;

    public C1239go(BitSet bitSet, String str) {
        super(str);
        this.f17777b = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: d */
    public final void mo2122d(BitSet bitSet) {
        bitSet.or(this.f17777b);
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        return this.f17777b.get(c);
    }
}
