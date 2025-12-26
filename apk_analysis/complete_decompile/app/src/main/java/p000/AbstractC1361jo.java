package p000;

import com.google.common.base.CharMatcher;

/* renamed from: jo */
/* loaded from: classes.dex */
public abstract class AbstractC1361jo extends CharMatcher {
    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public final /* bridge */ /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher negate() {
        return new C1165eo((CharMatcher) this);
    }

    @Override // com.google.common.base.CharMatcher
    public final CharMatcher precomputed() {
        return this;
    }
}
