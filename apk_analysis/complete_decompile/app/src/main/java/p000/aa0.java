package p000;

import com.google.common.base.Preconditions;
import com.google.common.escape.CharEscaper;

/* loaded from: classes.dex */
public final class aa0 extends CharEscaper {
    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        return (String) Preconditions.checkNotNull(str);
    }

    @Override // com.google.common.escape.CharEscaper
    public final char[] escape(char c) {
        return null;
    }
}
