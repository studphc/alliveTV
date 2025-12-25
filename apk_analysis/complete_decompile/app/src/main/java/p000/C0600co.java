package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

/* renamed from: co */
/* loaded from: classes.dex */
public final class C0600co extends AbstractC1842to {

    /* renamed from: b */
    public static final C0600co f8430b = new AbstractC1842to("CharMatcher.any()");

    @Override // com.google.common.base.CharMatcher
    public final CharMatcher and(CharMatcher charMatcher) {
        return (CharMatcher) Preconditions.checkNotNull(charMatcher);
    }

    @Override // com.google.common.base.CharMatcher
    public final String collapseFrom(CharSequence charSequence, char c) {
        if (charSequence.length() == 0) {
            return "";
        }
        return String.valueOf(c);
    }

    @Override // com.google.common.base.CharMatcher
    public final int countIn(CharSequence charSequence) {
        return charSequence.length();
    }

    @Override // com.google.common.base.CharMatcher
    public final int indexIn(CharSequence charSequence) {
        return charSequence.length() == 0 ? -1 : 0;
    }

    @Override // com.google.common.base.CharMatcher
    public final int lastIndexIn(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        return true;
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matchesAllOf(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return true;
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matchesNoneOf(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1361jo, com.google.common.base.CharMatcher
    public final CharMatcher negate() {
        return CharMatcher.none();
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: or */
    public final CharMatcher mo2264or(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return this;
    }

    @Override // com.google.common.base.CharMatcher
    public final String removeFrom(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return "";
    }

    @Override // com.google.common.base.CharMatcher
    public final String replaceFrom(CharSequence charSequence, char c) {
        char[] cArr = new char[charSequence.length()];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    @Override // com.google.common.base.CharMatcher
    public final String trimFrom(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return "";
    }

    @Override // com.google.common.base.CharMatcher
    public final int indexIn(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i, length);
        if (i == length) {
            return -1;
        }
        return i;
    }

    @Override // com.google.common.base.CharMatcher
    public final String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        StringBuilder sb = new StringBuilder(charSequence2.length() * charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            sb.append(charSequence2);
        }
        return sb.toString();
    }
}
