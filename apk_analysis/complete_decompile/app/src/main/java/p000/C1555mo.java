package p000;

import com.google.common.base.CharMatcher;
import java.util.BitSet;

/* renamed from: mo */
/* loaded from: classes.dex */
public final class C1555mo extends AbstractC1361jo {

    /* renamed from: a */
    public final /* synthetic */ int f23009a;

    /* renamed from: b */
    public final char f23010b;

    public /* synthetic */ C1555mo(char c, int i) {
        this.f23009a = i;
        this.f23010b = c;
    }

    @Override // com.google.common.base.CharMatcher
    public final CharMatcher and(CharMatcher charMatcher) {
        switch (this.f23009a) {
            case 0:
                if (charMatcher.matches(this.f23010b)) {
                    return this;
                }
                return CharMatcher.none();
            default:
                if (charMatcher.matches(this.f23010b)) {
                    return super.and(charMatcher);
                }
                return charMatcher;
        }
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: d */
    public final void mo2122d(BitSet bitSet) {
        switch (this.f23009a) {
            case 0:
                bitSet.set(this.f23010b);
                return;
            default:
                char c = this.f23010b;
                bitSet.set(0, c);
                bitSet.set(c + 1, 65536);
                return;
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        switch (this.f23009a) {
            case 0:
                if (c == this.f23010b) {
                    return true;
                }
                return false;
            default:
                if (c != this.f23010b) {
                    return true;
                }
                return false;
        }
    }

    @Override // p000.AbstractC1361jo, com.google.common.base.CharMatcher
    public final CharMatcher negate() {
        switch (this.f23009a) {
            case 0:
                return CharMatcher.isNot(this.f23010b);
            default:
                return CharMatcher.m3759is(this.f23010b);
        }
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: or */
    public final CharMatcher mo2264or(CharMatcher charMatcher) {
        switch (this.f23009a) {
            case 0:
                if (!charMatcher.matches(this.f23010b)) {
                    return super.mo2264or(charMatcher);
                }
                return charMatcher;
            default:
                if (charMatcher.matches(this.f23010b)) {
                    return CharMatcher.any();
                }
                return this;
        }
    }

    @Override // com.google.common.base.CharMatcher
    public String replaceFrom(CharSequence charSequence, char c) {
        switch (this.f23009a) {
            case 0:
                return charSequence.toString().replace(this.f23010b, c);
            default:
                return super.replaceFrom(charSequence, c);
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final String toString() {
        switch (this.f23009a) {
            case 0:
                String m3757a = CharMatcher.m3757a(this.f23010b);
                return AbstractC1726qj.m7059o("CharMatcher.is('", m3757a, "')", AbstractC1726qj.m7052h(18, m3757a));
            default:
                String m3757a2 = CharMatcher.m3757a(this.f23010b);
                return AbstractC1726qj.m7059o("CharMatcher.isNot('", m3757a2, "')", AbstractC1726qj.m7052h(21, m3757a2));
        }
    }
}
