package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ArrayBasedCharEscaper extends CharEscaper {

    /* renamed from: b */
    public final char[][] f14998b;

    /* renamed from: c */
    public final int f14999c;

    /* renamed from: d */
    public final char f15000d;

    /* renamed from: e */
    public final char f15001e;

    public ArrayBasedCharEscaper(Map<Character, String> map, char c, char c2) {
        this(ArrayBasedEscaperMap.create(map), c, c2);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.f14999c && this.f14998b[charAt] != null) || charAt > this.f15001e || charAt < this.f15000d) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @CheckForNull
    public abstract char[] escapeUnsafe(char c);

    public ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c, char c2) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] cArr = arrayBasedEscaperMap.f15003a;
        this.f14998b = cArr;
        this.f14999c = cArr.length;
        if (c2 < c) {
            c2 = 0;
            c = CharCompanionObject.MAX_VALUE;
        }
        this.f15000d = c;
        this.f15001e = c2;
    }

    @Override // com.google.common.escape.CharEscaper
    @CheckForNull
    public final char[] escape(char c) {
        char[] cArr;
        if (c < this.f14999c && (cArr = this.f14998b[c]) != null) {
            return cArr;
        }
        if (c < this.f15000d || c > this.f15001e) {
            return escapeUnsafe(c);
        }
        return null;
    }
}
