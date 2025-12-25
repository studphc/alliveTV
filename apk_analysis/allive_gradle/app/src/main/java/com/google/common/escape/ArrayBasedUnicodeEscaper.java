package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {

    /* renamed from: b */
    public final char[][] f15004b;

    /* renamed from: c */
    public final int f15005c;

    /* renamed from: d */
    public final int f15006d;

    /* renamed from: e */
    public final int f15007e;

    /* renamed from: f */
    public final char f15008f;

    /* renamed from: g */
    public final char f15009g;

    public ArrayBasedUnicodeEscaper(Map<Character, String> map, int i, int i2, String str) {
        this(ArrayBasedEscaperMap.create(map), i, i2, str);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.f15005c && this.f15004b[charAt] != null) || charAt > this.f15009g || charAt < this.f15008f) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @CheckForNull
    public abstract char[] escapeUnsafe(int i);

    @Override // com.google.common.escape.UnicodeEscaper
    public final int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if ((charAt < this.f15005c && this.f15004b[charAt] != null) || charAt > this.f15009g || charAt < this.f15008f) {
                break;
            }
            i++;
        }
        return i;
    }

    public ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i, int i2, String str) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] cArr = arrayBasedEscaperMap.f15003a;
        this.f15004b = cArr;
        this.f15005c = cArr.length;
        if (i2 < i) {
            i2 = -1;
            i = Integer.MAX_VALUE;
        }
        this.f15006d = i;
        this.f15007e = i2;
        if (i >= 55296) {
            this.f15008f = CharCompanionObject.MAX_VALUE;
            this.f15009g = (char) 0;
        } else {
            this.f15008f = (char) i;
            this.f15009g = (char) Math.min(i2, 55295);
        }
    }

    @Override // com.google.common.escape.UnicodeEscaper
    @CheckForNull
    public final char[] escape(int i) {
        char[] cArr;
        if (i < this.f15005c && (cArr = this.f15004b[i]) != null) {
            return cArr;
        }
        if (i < this.f15006d || i > this.f15007e) {
            return escapeUnsafe(i);
        }
        return null;
    }
}
