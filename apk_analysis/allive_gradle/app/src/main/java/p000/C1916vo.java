package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/* renamed from: vo */
/* loaded from: classes.dex */
public final class C1916vo extends AbstractC1842to {

    /* renamed from: b */
    public static final C1916vo f27895b = new AbstractC1842to("CharMatcher.none()");

    @Override // com.google.common.base.CharMatcher
    public final CharMatcher and(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return this;
    }

    @Override // com.google.common.base.CharMatcher
    public final String collapseFrom(CharSequence charSequence, char c) {
        return charSequence.toString();
    }

    @Override // com.google.common.base.CharMatcher
    public final int countIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return 0;
    }

    @Override // com.google.common.base.CharMatcher
    public final int indexIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return -1;
    }

    @Override // com.google.common.base.CharMatcher
    public final int lastIndexIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return -1;
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matchesAllOf(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matchesNoneOf(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return true;
    }

    @Override // p000.AbstractC1361jo, com.google.common.base.CharMatcher
    public final CharMatcher negate() {
        return CharMatcher.any();
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: or */
    public final CharMatcher mo2264or(CharMatcher charMatcher) {
        return (CharMatcher) Preconditions.checkNotNull(charMatcher);
    }

    @Override // com.google.common.base.CharMatcher
    public final String removeFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override // com.google.common.base.CharMatcher
    public final String replaceFrom(CharSequence charSequence, char c) {
        return charSequence.toString();
    }

    @Override // com.google.common.base.CharMatcher
    public final String trimFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override // com.google.common.base.CharMatcher
    public final String trimLeadingFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override // com.google.common.base.CharMatcher
    public final String trimTrailingFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override // com.google.common.base.CharMatcher
    public final int indexIn(CharSequence charSequence, int i) {
        Preconditions.checkPositionIndex(i, charSequence.length());
        return -1;
    }

    @Override // com.google.common.base.CharMatcher
    public final String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence2);
        return charSequence.toString();
    }
}
