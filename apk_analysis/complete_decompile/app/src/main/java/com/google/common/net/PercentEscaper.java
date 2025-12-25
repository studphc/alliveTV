package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;
import javax.annotation.CheckForNull;
import p000.ye0;

@GwtCompatible
/* loaded from: classes2.dex */
public final class PercentEscaper extends UnicodeEscaper {

    /* renamed from: d */
    public static final char[] f15189d = {'+'};

    /* renamed from: e */
    public static final char[] f15190e = "0123456789ABCDEF".toCharArray();

    /* renamed from: b */
    public final boolean f15191b;

    /* renamed from: c */
    public final boolean[] f15192c;

    public PercentEscaper(String str, boolean z) {
        Preconditions.checkNotNull(str);
        if (!str.matches(".*[0-9A-Za-z].*")) {
            String concat = str.concat("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
            if (z && concat.contains(" ")) {
                throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
            }
            this.f15191b = z;
            char[] charArray = concat.toCharArray();
            int i = -1;
            for (char c : charArray) {
                i = Math.max((int) c, i);
            }
            boolean[] zArr = new boolean[i + 1];
            for (char c2 : charArray) {
                zArr[c2] = true;
            }
            this.f15192c = zArr;
            return;
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            boolean[] zArr = this.f15192c;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        Preconditions.checkNotNull(charSequence);
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            boolean[] zArr = this.f15192c;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    @CheckForNull
    public char[] escape(int i) {
        boolean[] zArr = this.f15192c;
        if (i < zArr.length && zArr[i]) {
            return null;
        }
        if (i == 32 && this.f15191b) {
            return f15189d;
        }
        char[] cArr = f15190e;
        if (i <= 127) {
            return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
        }
        if (i <= 2047) {
            return new char[]{'%', cArr[(i >>> 10) | 12], cArr[(i >>> 6) & 15], '%', cArr[((i >>> 4) & 3) | 8], cArr[i & 15]};
        }
        if (i <= 65535) {
            return new char[]{'%', 'E', cArr[i >>> 12], '%', cArr[((i >>> 10) & 3) | 8], cArr[(i >>> 6) & 15], '%', cArr[((i >>> 4) & 3) | 8], cArr[i & 15]};
        }
        if (i <= 1114111) {
            return new char[]{'%', 'F', cArr[(i >>> 18) & 7], '%', cArr[((i >>> 16) & 3) | 8], cArr[(i >>> 12) & 15], '%', cArr[((i >>> 10) & 3) | 8], cArr[(i >>> 6) & 15], '%', cArr[((i >>> 4) & 3) | 8], cArr[i & 15]};
        }
        throw new IllegalArgumentException(ye0.m8290j(43, i, "Invalid unicode character value "));
    }
}
