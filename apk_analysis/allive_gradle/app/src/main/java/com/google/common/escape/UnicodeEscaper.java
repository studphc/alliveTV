package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;
import p000.s42;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class UnicodeEscaper extends Escaper {
    public static int codePointAt(CharSequence charSequence, int i, int i2) {
        Preconditions.checkNotNull(charSequence);
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt >= 55296 && charAt <= 57343) {
                if (charAt <= 56319) {
                    if (i3 == i2) {
                        return -charAt;
                    }
                    char charAt2 = charSequence.charAt(i3);
                    if (Character.isLowSurrogate(charAt2)) {
                        return Character.toCodePoint(charAt, charAt2);
                    }
                    String valueOf = String.valueOf(charSequence);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 89);
                    sb.append("Expected low surrogate but got char '");
                    sb.append(charAt2);
                    sb.append("' with value ");
                    sb.append((int) charAt2);
                    sb.append(" at index ");
                    sb.append(i3);
                    sb.append(" in '");
                    sb.append(valueOf);
                    sb.append("'");
                    throw new IllegalArgumentException(sb.toString());
                }
                String valueOf2 = String.valueOf(charSequence);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 88);
                sb2.append("Unexpected low surrogate character '");
                sb2.append(charAt);
                sb2.append("' with value ");
                sb2.append((int) charAt);
                sb2.append(" at index ");
                sb2.append(i);
                sb2.append(" in '");
                sb2.append(valueOf2);
                sb2.append("'");
                throw new IllegalArgumentException(sb2.toString());
            }
            return charAt;
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    @CheckForNull
    public abstract char[] escape(int i);

    public final String escapeSlow(String str, int i) {
        int i2;
        int length = str.length();
        char[] cArr = (char[]) s42.f26234a.get();
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            int codePointAt = codePointAt(str, i, length);
            if (codePointAt >= 0) {
                char[] escape = escape(codePointAt);
                if (Character.isSupplementaryCodePoint(codePointAt)) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                int i5 = i2 + i;
                if (escape != null) {
                    int i6 = i - i3;
                    int i7 = i4 + i6;
                    int length2 = escape.length + i7;
                    if (cArr.length < length2) {
                        int i8 = (length - i) + length2 + 32;
                        if (i8 >= 0) {
                            char[] cArr2 = new char[i8];
                            if (i4 > 0) {
                                System.arraycopy(cArr, 0, cArr2, 0, i4);
                            }
                            cArr = cArr2;
                        } else {
                            throw new AssertionError("Cannot increase internal buffer any further");
                        }
                    }
                    if (i6 > 0) {
                        str.getChars(i3, i, cArr, i4);
                        i4 = i7;
                    }
                    if (escape.length > 0) {
                        System.arraycopy(escape, 0, cArr, i4, escape.length);
                        i4 += escape.length;
                    }
                    i3 = i5;
                }
                i = nextEscapeIndex(str, i5, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i9 = length - i3;
        if (i9 > 0) {
            int i10 = i9 + i4;
            if (cArr.length < i10) {
                if (i10 >= 0) {
                    char[] cArr3 = new char[i10];
                    if (i4 > 0) {
                        System.arraycopy(cArr, 0, cArr3, 0, i4);
                    }
                    cArr = cArr3;
                } else {
                    throw new AssertionError("Cannot increase internal buffer any further");
                }
            }
            str.getChars(i3, length, cArr, i4);
            i4 = i10;
        }
        return new String(cArr, 0, i4);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        int i3;
        while (i < i2) {
            int codePointAt = codePointAt(charSequence, i, i2);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            if (Character.isSupplementaryCodePoint(codePointAt)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            i += i3;
        }
        return i;
    }
}
