package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import p000.AbstractC1726qj;
import p000.C1943we;
import p000.C1980xe;
import p000.C2017ye;
import p000.ye0;

/* renamed from: com.google.common.io.d */
/* loaded from: classes2.dex */
public final class C0970d extends BaseEncoding {

    /* renamed from: f */
    public final BaseEncoding f15101f;

    /* renamed from: g */
    public final String f15102g;

    /* renamed from: h */
    public final int f15103h;

    public C0970d(C0972f c0972f, String str, int i) {
        boolean z;
        this.f15101f = (BaseEncoding) Preconditions.checkNotNull(c0972f);
        this.f15102g = (String) Preconditions.checkNotNull(str);
        this.f15103h = i;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Cannot add a separator after every %s chars", i);
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: a */
    public final int mo4193a(byte[] bArr, CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (this.f15102g.indexOf(charAt) < 0) {
                sb.append(charAt);
            }
        }
        return this.f15101f.mo4193a(bArr, sb);
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: b */
    public final void mo4194b(byte[] bArr, Appendable appendable, int i, int i2) {
        boolean z;
        Preconditions.checkNotNull(appendable);
        String str = this.f15102g;
        Preconditions.checkNotNull(str);
        int i3 = this.f15103h;
        if (i3 > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f15101f.mo4194b(bArr, new C1980xe(i3, appendable, str), i, i2);
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: c */
    public final int mo4195c(int i) {
        return this.f15101f.mo4195c(i);
    }

    @Override // com.google.common.io.BaseEncoding
    public final boolean canDecode(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (this.f15102g.indexOf(charAt) < 0) {
                sb.append(charAt);
            }
        }
        return this.f15101f.canDecode(sb);
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: d */
    public final int mo4196d(int i) {
        int mo4196d = this.f15101f.mo4196d(i);
        return (IntMath.divide(Math.max(0, mo4196d - 1), this.f15103h, RoundingMode.FLOOR) * this.f15102g.length()) + mo4196d;
    }

    @Override // com.google.common.io.BaseEncoding
    public final InputStream decodingStream(Reader reader) {
        Preconditions.checkNotNull(reader);
        String str = this.f15102g;
        Preconditions.checkNotNull(str);
        return this.f15101f.decodingStream(new C1943we(reader, str));
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: e */
    public final CharSequence mo4197e(CharSequence charSequence) {
        return this.f15101f.mo4197e(charSequence);
    }

    @Override // com.google.common.io.BaseEncoding
    public final OutputStream encodingStream(Writer writer) {
        boolean z;
        Preconditions.checkNotNull(writer);
        String str = this.f15102g;
        Preconditions.checkNotNull(str);
        int i = this.f15103h;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return this.f15101f.encodingStream(new C2017ye(new C1980xe(i, writer, str), writer));
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding lowerCase() {
        return this.f15101f.lowerCase().withSeparator(this.f15102g, this.f15103h);
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding omitPadding() {
        return this.f15101f.omitPadding().withSeparator(this.f15102g, this.f15103h);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f15101f);
        int length = valueOf.length() + 31;
        String str = this.f15102g;
        return ye0.m8298r(AbstractC1726qj.m7062r(AbstractC1726qj.m7052h(length, str), valueOf, ".withSeparator(\"", str, "\", "), ")", this.f15103h);
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding upperCase() {
        return this.f15101f.upperCase().withSeparator(this.f15102g, this.f15103h);
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding withPadChar(char c) {
        return this.f15101f.withPadChar(c).withSeparator(this.f15102g, this.f15103h);
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding withSeparator(String str, int i) {
        throw new UnsupportedOperationException("Already have a separator");
    }
}
