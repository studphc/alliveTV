package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import p000.ye0;

/* renamed from: com.google.common.io.c */
/* loaded from: classes2.dex */
public final class C0969c extends C0972f {
    public C0969c(String str, String str2) {
        this(new C0967a(str, str2.toCharArray()), (Character) '=');
    }

    @Override // com.google.common.io.C0972f, com.google.common.io.BaseEncoding
    /* renamed from: a */
    public final int mo4193a(byte[] bArr, CharSequence charSequence) {
        Preconditions.checkNotNull(bArr);
        CharSequence mo4197e = mo4197e(charSequence);
        int length = mo4197e.length();
        C0967a c0967a = this.f15110f;
        if (c0967a.f15099h[length % c0967a.f15096e]) {
            int i = 0;
            int i2 = 0;
            while (i < mo4197e.length()) {
                int i3 = i + 2;
                int m4206a = (c0967a.m4206a(mo4197e.charAt(i + 1)) << 12) | (c0967a.m4206a(mo4197e.charAt(i)) << 18);
                int i4 = i2 + 1;
                bArr[i2] = (byte) (m4206a >>> 16);
                if (i3 < mo4197e.length()) {
                    int i5 = i + 3;
                    int m4206a2 = m4206a | (c0967a.m4206a(mo4197e.charAt(i3)) << 6);
                    int i6 = i2 + 2;
                    bArr[i4] = (byte) ((m4206a2 >>> 8) & 255);
                    if (i5 < mo4197e.length()) {
                        i += 4;
                        i2 += 3;
                        bArr[i6] = (byte) ((m4206a2 | c0967a.m4206a(mo4197e.charAt(i5))) & 255);
                    } else {
                        i2 = i6;
                        i = i5;
                    }
                } else {
                    i2 = i4;
                    i = i3;
                }
            }
            return i2;
        }
        throw new IOException(ye0.m8290j(32, mo4197e.length(), "Invalid input length "));
    }

    @Override // com.google.common.io.C0972f, com.google.common.io.BaseEncoding
    /* renamed from: b */
    public final void mo4194b(byte[] bArr, Appendable appendable, int i, int i2) {
        Preconditions.checkNotNull(appendable);
        int i3 = i + i2;
        Preconditions.checkPositionIndexes(i, i3, bArr.length);
        while (i2 >= 3) {
            int i4 = i + 2;
            int i5 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
            i += 3;
            int i6 = i5 | (bArr[i4] & 255);
            C0967a c0967a = this.f15110f;
            appendable.append(c0967a.f15093b[i6 >>> 18]);
            char[] cArr = c0967a.f15093b;
            appendable.append(cArr[(i6 >>> 12) & 63]);
            appendable.append(cArr[(i6 >>> 6) & 63]);
            appendable.append(cArr[i6 & 63]);
            i2 -= 3;
        }
        if (i < i3) {
            m4208f(bArr, appendable, i, i3 - i);
        }
    }

    @Override // com.google.common.io.C0972f
    /* renamed from: g */
    public final BaseEncoding mo4207g(C0967a c0967a, Character ch) {
        return new C0969c(c0967a, ch);
    }

    public C0969c(C0967a c0967a, Character ch) {
        super(c0967a, ch);
        Preconditions.checkArgument(c0967a.f15093b.length == 64);
    }
}
