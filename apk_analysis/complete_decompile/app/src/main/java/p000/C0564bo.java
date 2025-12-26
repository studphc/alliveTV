package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

/* renamed from: bo */
/* loaded from: classes.dex */
public final class C0564bo extends CharMatcher {

    /* renamed from: a */
    public final /* synthetic */ int f8104a;

    /* renamed from: b */
    public final CharMatcher f8105b;

    /* renamed from: c */
    public final CharMatcher f8106c;

    public C0564bo(CharMatcher charMatcher, CharMatcher charMatcher2, int i) {
        this.f8104a = i;
        switch (i) {
            case 1:
                this.f8105b = (CharMatcher) Preconditions.checkNotNull(charMatcher);
                this.f8106c = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
                return;
            default:
                this.f8105b = (CharMatcher) Preconditions.checkNotNull(charMatcher);
                this.f8106c = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
                return;
        }
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public final /* bridge */ /* synthetic */ boolean apply(Character ch) {
        switch (this.f8104a) {
            case 0:
                return super.apply(ch);
            default:
                return super.apply(ch);
        }
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: d */
    public final void mo2122d(BitSet bitSet) {
        switch (this.f8104a) {
            case 0:
                BitSet bitSet2 = new BitSet();
                this.f8105b.mo2122d(bitSet2);
                BitSet bitSet3 = new BitSet();
                this.f8106c.mo2122d(bitSet3);
                bitSet2.and(bitSet3);
                bitSet.or(bitSet2);
                return;
            default:
                this.f8105b.mo2122d(bitSet);
                this.f8106c.mo2122d(bitSet);
                return;
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        switch (this.f8104a) {
            case 0:
                if (this.f8105b.matches(c) && this.f8106c.matches(c)) {
                    return true;
                }
                return false;
            default:
                if (!this.f8105b.matches(c) && !this.f8106c.matches(c)) {
                    return false;
                }
                return true;
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final String toString() {
        switch (this.f8104a) {
            case 0:
                String valueOf = String.valueOf(this.f8105b);
                String valueOf2 = String.valueOf(this.f8106c);
                StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 19, "CharMatcher.and(", valueOf, ", ", valueOf2);
                m7062r.append(")");
                return m7062r.toString();
            default:
                String valueOf3 = String.valueOf(this.f8105b);
                String valueOf4 = String.valueOf(this.f8106c);
                StringBuilder m7062r2 = AbstractC1726qj.m7062r(valueOf4.length() + valueOf3.length() + 18, "CharMatcher.or(", valueOf3, ", ", valueOf4);
                m7062r2.append(")");
                return m7062r2.toString();
        }
    }
}
