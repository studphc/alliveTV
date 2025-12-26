package p000;

import com.google.common.base.CharMatcher;

/* renamed from: so */
/* loaded from: classes.dex */
public final class C1805so extends CharMatcher {

    /* renamed from: a */
    public static final C1805so f26504a = new CharMatcher();

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public final /* bridge */ /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        return Character.isUpperCase(c);
    }

    @Override // com.google.common.base.CharMatcher
    public final String toString() {
        return "CharMatcher.javaUpperCase()";
    }
}
