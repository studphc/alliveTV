package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

/* renamed from: ko */
/* loaded from: classes.dex */
public final class C1398ko extends AbstractC1361jo {

    /* renamed from: a */
    public final /* synthetic */ int f20917a;

    /* renamed from: b */
    public final char f20918b;

    /* renamed from: c */
    public final char f20919c;

    public C1398ko(char c, char c2, int i) {
        boolean z;
        this.f20917a = i;
        switch (i) {
            case 1:
                this.f20918b = c;
                this.f20919c = c2;
                return;
            default:
                if (c2 >= c) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                this.f20918b = c;
                this.f20919c = c2;
                return;
        }
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: d */
    public final void mo2122d(BitSet bitSet) {
        switch (this.f20917a) {
            case 0:
                bitSet.set(this.f20918b, this.f20919c + 1);
                return;
            default:
                bitSet.set(this.f20918b);
                bitSet.set(this.f20919c);
                return;
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        switch (this.f20917a) {
            case 0:
                if (this.f20918b <= c && c <= this.f20919c) {
                    return true;
                }
                return false;
            default:
                if (c != this.f20918b && c != this.f20919c) {
                    return false;
                }
                return true;
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final String toString() {
        switch (this.f20917a) {
            case 0:
                String m3757a = CharMatcher.m3757a(this.f20918b);
                String m3757a2 = CharMatcher.m3757a(this.f20919c);
                StringBuilder m7062r = AbstractC1726qj.m7062r(AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(27, m3757a), m3757a2), "CharMatcher.inRange('", m3757a, "', '", m3757a2);
                m7062r.append("')");
                return m7062r.toString();
            default:
                String m3757a3 = CharMatcher.m3757a(this.f20918b);
                String m3757a4 = CharMatcher.m3757a(this.f20919c);
                return AbstractC1726qj.m7055k(AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(21, m3757a3), m3757a4), "CharMatcher.anyOf(\"", m3757a3, m3757a4, "\")");
        }
    }
}
