package p000;

import java.util.BitSet;

/* renamed from: yo */
/* loaded from: classes.dex */
public final class C2027yo extends AbstractC1842to {

    /* renamed from: b */
    public static final int f29047b = Integer.numberOfLeadingZeros(31);

    /* renamed from: c */
    public static final C2027yo f29048c = new AbstractC1842to("CharMatcher.whitespace()");

    @Override // com.google.common.base.CharMatcher
    /* renamed from: d */
    public final void mo2122d(BitSet bitSet) {
        for (int i = 0; i < 32; i++) {
            bitSet.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt(i));
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        if ("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c) >>> f29047b) == c) {
            return true;
        }
        return false;
    }
}
