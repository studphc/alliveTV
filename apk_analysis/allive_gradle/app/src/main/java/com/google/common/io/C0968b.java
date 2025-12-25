package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import p000.ye0;

/* renamed from: com.google.common.io.b */
/* loaded from: classes2.dex */
public final class C0968b extends C0972f {

    /* renamed from: j */
    public final char[] f15100j;

    public C0968b(C0967a c0967a) {
        super(c0967a, (Character) null);
        boolean z;
        this.f15100j = new char[512];
        if (c0967a.f15093b.length == 16) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (int i = 0; i < 256; i++) {
            char[] cArr = this.f15100j;
            char[] cArr2 = c0967a.f15093b;
            cArr[i] = cArr2[i >>> 4];
            cArr[i | 256] = cArr2[i & 15];
        }
    }

    @Override // com.google.common.io.C0972f, com.google.common.io.BaseEncoding
    /* renamed from: a */
    public final int mo4193a(byte[] bArr, CharSequence charSequence) {
        Preconditions.checkNotNull(bArr);
        if (charSequence.length() % 2 != 1) {
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                char charAt = charSequence.charAt(i);
                C0967a c0967a = this.f15110f;
                bArr[i2] = (byte) ((c0967a.m4206a(charAt) << 4) | c0967a.m4206a(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }
        throw new IOException(ye0.m8290j(32, charSequence.length(), "Invalid input length "));
    }

    @Override // com.google.common.io.C0972f, com.google.common.io.BaseEncoding
    /* renamed from: b */
    public final void mo4194b(byte[] bArr, Appendable appendable, int i, int i2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & 255;
            char[] cArr = this.f15100j;
            appendable.append(cArr[i4]);
            appendable.append(cArr[i4 | 256]);
        }
    }

    @Override // com.google.common.io.C0972f
    /* renamed from: g */
    public final BaseEncoding mo4207g(C0967a c0967a, Character ch) {
        return new C0968b(c0967a);
    }
}
