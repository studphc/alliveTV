package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;
import p000.s42;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class CharEscaper extends Escaper {
    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (escape(str.charAt(i)) != null) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @CheckForNull
    public abstract char[] escape(char c);

    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArr = (char[]) s42.f26234a.get();
        int length2 = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            char[] escape = escape(str.charAt(i));
            if (escape != null) {
                int length3 = escape.length;
                int i4 = i - i2;
                int i5 = i3 + i4;
                int i6 = i5 + length3;
                if (length2 < i6) {
                    length2 = ((length - i) * 2) + i6;
                    if (length2 >= 0) {
                        char[] cArr2 = new char[length2];
                        if (i3 > 0) {
                            System.arraycopy(cArr, 0, cArr2, 0, i3);
                        }
                        cArr = cArr2;
                    } else {
                        throw new AssertionError("Cannot increase internal buffer any further");
                    }
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArr, i3);
                    i3 = i5;
                }
                if (length3 > 0) {
                    System.arraycopy(escape, 0, cArr, i3, length3);
                    i3 += length3;
                }
                i2 = i + 1;
            }
            i++;
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i7 + i3;
            if (length2 < i8) {
                if (i8 >= 0) {
                    char[] cArr3 = new char[i8];
                    if (i3 > 0) {
                        System.arraycopy(cArr, 0, cArr3, 0, i3);
                    }
                    cArr = cArr3;
                } else {
                    throw new AssertionError("Cannot increase internal buffer any further");
                }
            }
            str.getChars(i2, length, cArr, i3);
            i3 = i8;
        }
        return new String(cArr, 0, i3);
    }
}
