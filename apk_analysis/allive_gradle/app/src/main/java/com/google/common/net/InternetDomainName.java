package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;

@Immutable
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class InternetDomainName {

    /* renamed from: e */
    public static final CharMatcher f15167e = CharMatcher.anyOf(".。．｡");

    /* renamed from: f */
    public static final Splitter f15168f = Splitter.m3782on('.');

    /* renamed from: g */
    public static final Joiner f15169g = Joiner.m3765on('.');

    /* renamed from: h */
    public static final CharMatcher f15170h;

    /* renamed from: i */
    public static final CharMatcher f15171i;

    /* renamed from: j */
    public static final CharMatcher f15172j;

    /* renamed from: a */
    public final String f15173a;

    /* renamed from: b */
    public final ImmutableList f15174b;

    /* renamed from: c */
    public final int f15175c;

    /* renamed from: d */
    public final int f15176d;

    static {
        CharMatcher anyOf = CharMatcher.anyOf("-_");
        f15170h = anyOf;
        CharMatcher inRange = CharMatcher.inRange('0', '9');
        f15171i = inRange;
        f15172j = inRange.mo2264or(CharMatcher.inRange('a', 'z').mo2264or(CharMatcher.inRange('A', 'Z'))).mo2264or(anyOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InternetDomainName(String str) {
        boolean z;
        boolean z2;
        String lowerCase = Ascii.toLowerCase(f15167e.replaceFrom((CharSequence) str, '.'));
        boolean z3 = false;
        lowerCase = lowerCase.endsWith(".") ? lowerCase.substring(0, lowerCase.length() - 1) : lowerCase;
        if (lowerCase.length() <= 253) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Domain name too long: '%s':", lowerCase);
        this.f15173a = lowerCase;
        ImmutableList copyOf = ImmutableList.copyOf(f15168f.split(lowerCase));
        this.f15174b = copyOf;
        if (copyOf.size() <= 127) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Domain has too many parts: '%s'", lowerCase);
        int size = copyOf.size() - 1;
        if (m4232c((String) copyOf.get(size), true)) {
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!m4232c((String) copyOf.get(i), false)) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    z3 = true;
                    break;
                }
            }
        }
        Preconditions.checkArgument(z3, "Not a valid domain name: '%s'", lowerCase);
        this.f15175c = m4234b(Optional.absent());
        this.f15176d = m4234b(Optional.m3770of(PublicSuffixType.REGISTRY));
    }

    /* renamed from: c */
    public static boolean m4232c(String str, boolean z) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!f15172j.matchesAllOf(CharMatcher.ascii().retainFrom(str))) {
                return false;
            }
            char charAt = str.charAt(0);
            CharMatcher charMatcher = f15170h;
            if (!charMatcher.matches(charAt) && !charMatcher.matches(str.charAt(str.length() - 1))) {
                if (z && f15171i.matches(str.charAt(0))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @CanIgnoreReturnValue
    public static InternetDomainName from(String str) {
        return new InternetDomainName((String) Preconditions.checkNotNull(str));
    }

    public static boolean isValid(String str) {
        try {
            from(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final InternetDomainName m4233a(int i) {
        ImmutableList immutableList = this.f15174b;
        return from(f15169g.join(immutableList.subList(i, immutableList.size())));
    }

    /* renamed from: b */
    public final int m4234b(Optional optional) {
        boolean isPresent;
        boolean isPresent2;
        ImmutableList immutableList = this.f15174b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String join = f15169g.join(immutableList.subList(i, size));
            Optional fromNullable = Optional.fromNullable(PublicSuffixPatterns.EXACT.get(join));
            if (optional.isPresent()) {
                isPresent = optional.equals(fromNullable);
            } else {
                isPresent = fromNullable.isPresent();
            }
            if (isPresent) {
                return i;
            }
            if (PublicSuffixPatterns.EXCLUDED.containsKey(join)) {
                return i + 1;
            }
            List<String> splitToList = f15168f.limit(2).splitToList(join);
            if (splitToList.size() == 2) {
                Optional fromNullable2 = Optional.fromNullable(PublicSuffixPatterns.UNDER.get(splitToList.get(1)));
                if (optional.isPresent()) {
                    isPresent2 = optional.equals(fromNullable2);
                } else {
                    isPresent2 = fromNullable2.isPresent();
                }
                if (isPresent2) {
                    return i;
                }
            }
        }
        return -1;
    }

    public InternetDomainName child(String str) {
        String str2 = (String) Preconditions.checkNotNull(str);
        int m7052h = AbstractC1726qj.m7052h(1, str2);
        String str3 = this.f15173a;
        StringBuilder sb = new StringBuilder(AbstractC1726qj.m7052h(m7052h, str3));
        sb.append(str2);
        sb.append(".");
        sb.append(str3);
        return from(sb.toString());
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.f15173a.equals(((InternetDomainName) obj).f15173a);
        }
        return false;
    }

    public boolean hasParent() {
        if (this.f15174b.size() > 1) {
            return true;
        }
        return false;
    }

    public boolean hasPublicSuffix() {
        if (this.f15175c != -1) {
            return true;
        }
        return false;
    }

    public boolean hasRegistrySuffix() {
        if (this.f15176d != -1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f15173a.hashCode();
    }

    public boolean isPublicSuffix() {
        if (this.f15175c == 0) {
            return true;
        }
        return false;
    }

    public boolean isRegistrySuffix() {
        if (this.f15176d == 0) {
            return true;
        }
        return false;
    }

    public boolean isTopDomainUnderRegistrySuffix() {
        if (this.f15176d == 1) {
            return true;
        }
        return false;
    }

    public boolean isTopPrivateDomain() {
        if (this.f15175c == 1) {
            return true;
        }
        return false;
    }

    public boolean isUnderPublicSuffix() {
        if (this.f15175c > 0) {
            return true;
        }
        return false;
    }

    public boolean isUnderRegistrySuffix() {
        if (this.f15176d > 0) {
            return true;
        }
        return false;
    }

    public InternetDomainName parent() {
        Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.f15173a);
        return m4233a(1);
    }

    public ImmutableList<String> parts() {
        return this.f15174b;
    }

    @CheckForNull
    public InternetDomainName publicSuffix() {
        if (hasPublicSuffix()) {
            return m4233a(this.f15175c);
        }
        return null;
    }

    @CheckForNull
    public InternetDomainName registrySuffix() {
        if (hasRegistrySuffix()) {
            return m4233a(this.f15176d);
        }
        return null;
    }

    public String toString() {
        return this.f15173a;
    }

    public InternetDomainName topDomainUnderRegistrySuffix() {
        if (isTopDomainUnderRegistrySuffix()) {
            return this;
        }
        Preconditions.checkState(isUnderRegistrySuffix(), "Not under a registry suffix: %s", this.f15173a);
        return m4233a(this.f15176d - 1);
    }

    public InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain()) {
            return this;
        }
        Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.f15173a);
        return m4233a(this.f15175c - 1);
    }
}
