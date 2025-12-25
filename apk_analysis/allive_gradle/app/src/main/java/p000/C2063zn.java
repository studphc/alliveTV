package p000;

import com.google.common.escape.CharEscaper;

/* renamed from: zn */
/* loaded from: classes.dex */
public final class C2063zn extends CharEscaper {

    /* renamed from: b */
    public final char[][] f29444b;

    /* renamed from: c */
    public final int f29445c;

    public C2063zn(char[][] cArr) {
        this.f29444b = cArr;
        this.f29445c = cArr.length;
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            char[][] cArr = this.f29444b;
            if (charAt < cArr.length && cArr[charAt] != null) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.CharEscaper
    public final char[] escape(char c) {
        if (c < this.f29445c) {
            return this.f29444b[c];
        }
        return null;
    }
}
