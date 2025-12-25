package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
public final class wm1 {

    /* renamed from: a */
    public final String f28242a;

    /* renamed from: b */
    public int f28243b;

    public wm1(String str, int i) {
        this.f28242a = str;
        this.f28243b = i;
    }

    /* renamed from: d */
    public static wm1 m8062d(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i = 16;
            if (!str.startsWith("0x") && !str.startsWith("0X")) {
                if (charAt == '#') {
                    str = str.substring(1);
                } else if (charAt == '0' && str.length() > 1) {
                    str = str.substring(1);
                    i = 8;
                } else {
                    i = 10;
                }
            } else {
                str = str.substring(2);
            }
            return new wm1(str, i);
        }
        throw new NumberFormatException("empty string");
    }

    /* renamed from: a */
    public void m8063a(char c) {
        boolean z;
        Preconditions.checkState(m8066e());
        if (m8067f() == c) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.f28243b++;
    }

    /* renamed from: b */
    public String m8064b(CharMatcher charMatcher) {
        boolean z;
        int i = this.f28243b;
        String m8065c = m8065c(charMatcher);
        if (this.f28243b != i) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return m8065c;
    }

    /* renamed from: c */
    public String m8065c(CharMatcher charMatcher) {
        Preconditions.checkState(m8066e());
        int i = this.f28243b;
        CharMatcher negate = charMatcher.negate();
        String str = this.f28242a;
        this.f28243b = negate.indexIn(str, i);
        if (m8066e()) {
            return str.substring(i, this.f28243b);
        }
        return str.substring(i);
    }

    /* renamed from: e */
    public boolean m8066e() {
        int i = this.f28243b;
        if (i >= 0 && i < this.f28242a.length()) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public char m8067f() {
        Preconditions.checkState(m8066e());
        return this.f28242a.charAt(this.f28243b);
    }

    public wm1(String str) {
        this.f28243b = 0;
        this.f28242a = str;
    }
}
