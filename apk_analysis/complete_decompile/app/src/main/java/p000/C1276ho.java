package p000;

import com.google.common.base.CharMatcher;

/* renamed from: ho */
/* loaded from: classes.dex */
public final class C1276ho extends CharMatcher {

    /* renamed from: a */
    public static final C1276ho f18109a = new CharMatcher();

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public final /* bridge */ /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        if (c != ' ' && c != 133 && c != 5760) {
            if (c == 8199) {
                return false;
            }
            if (c != 8287 && c != 12288 && c != 8232 && c != 8233) {
                switch (c) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        if (c >= 8192 && c <= 8202) {
                            return true;
                        }
                        return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.common.base.CharMatcher
    public final String toString() {
        return "CharMatcher.breakingWhitespace()";
    }
}
