package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.BitSet;

/* renamed from: eo */
/* loaded from: classes.dex */
public class C1165eo extends CharMatcher {

    /* renamed from: a */
    public final /* synthetic */ int f16920a = 2;

    /* renamed from: b */
    public final Object f16921b;

    public C1165eo(CharMatcher charMatcher) {
        this.f16921b = (CharMatcher) Preconditions.checkNotNull(charMatcher);
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public final /* bridge */ /* synthetic */ boolean apply(Character ch) {
        switch (this.f16920a) {
            case 0:
                return super.apply(ch);
            case 1:
                return apply(ch);
            default:
                return super.apply(ch);
        }
    }

    @Override // com.google.common.base.CharMatcher
    public int countIn(CharSequence charSequence) {
        switch (this.f16920a) {
            case 2:
                return charSequence.length() - ((CharMatcher) this.f16921b).countIn(charSequence);
            default:
                return super.countIn(charSequence);
        }
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: d */
    public void mo2122d(BitSet bitSet) {
        switch (this.f16920a) {
            case 0:
                for (char c : (char[]) this.f16921b) {
                    bitSet.set(c);
                }
                return;
            case 1:
            default:
                super.mo2122d(bitSet);
                return;
            case 2:
                BitSet bitSet2 = new BitSet();
                ((CharMatcher) this.f16921b).mo2122d(bitSet2);
                bitSet2.flip(0, 65536);
                bitSet.or(bitSet2);
                return;
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        switch (this.f16920a) {
            case 0:
                if (Arrays.binarySearch((char[]) this.f16921b, c) >= 0) {
                    return true;
                }
                return false;
            case 1:
                return ((Predicate) this.f16921b).apply(Character.valueOf(c));
            default:
                return !((CharMatcher) this.f16921b).matches(c);
        }
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matchesAllOf(CharSequence charSequence) {
        switch (this.f16920a) {
            case 2:
                return ((CharMatcher) this.f16921b).matchesNoneOf(charSequence);
            default:
                return super.matchesAllOf(charSequence);
        }
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matchesNoneOf(CharSequence charSequence) {
        switch (this.f16920a) {
            case 2:
                return ((CharMatcher) this.f16921b).matchesAllOf(charSequence);
            default:
                return super.matchesNoneOf(charSequence);
        }
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher negate() {
        switch (this.f16920a) {
            case 2:
                return (CharMatcher) this.f16921b;
            default:
                return super.negate();
        }
    }

    @Override // com.google.common.base.CharMatcher
    public String toString() {
        switch (this.f16920a) {
            case 0:
                StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
                for (char c : (char[]) this.f16921b) {
                    sb.append(CharMatcher.m3757a(c));
                }
                sb.append("\")");
                return sb.toString();
            case 1:
                String valueOf = String.valueOf((Predicate) this.f16921b);
                return AbstractC1726qj.m7059o("CharMatcher.forPredicate(", valueOf, ")", valueOf.length() + 26);
            default:
                String valueOf2 = String.valueOf((CharMatcher) this.f16921b);
                return AbstractC1726qj.m7054j(valueOf2.length() + 9, valueOf2, ".negate()");
        }
    }

    public C1165eo(CharSequence charSequence) {
        char[] charArray = charSequence.toString().toCharArray();
        this.f16921b = charArray;
        Arrays.sort(charArray);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.common.base.CharMatcher
    public boolean apply(Character ch) {
        switch (this.f16920a) {
            case 1:
                return ((Predicate) this.f16921b).apply(Preconditions.checkNotNull(ch));
            default:
                return super.apply(ch);
        }
    }

    public C1165eo(Predicate predicate) {
        this.f16921b = (Predicate) Preconditions.checkNotNull(predicate);
    }
}
