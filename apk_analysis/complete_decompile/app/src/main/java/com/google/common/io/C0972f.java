package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import p000.C2054ze;
import p000.ye0;

/* renamed from: com.google.common.io.f */
/* loaded from: classes2.dex */
public class C0972f extends BaseEncoding {

    /* renamed from: f */
    public final C0967a f15110f;

    /* renamed from: g */
    public final Character f15111g;

    /* renamed from: h */
    public transient BaseEncoding f15112h;

    /* renamed from: i */
    public transient BaseEncoding f15113i;

    public C0972f(C0967a c0967a, Character ch) {
        boolean z;
        this.f15110f = (C0967a) Preconditions.checkNotNull(c0967a);
        if (ch != null) {
            char charValue = ch.charValue();
            byte[] bArr = c0967a.f15098g;
            if (charValue < bArr.length && bArr[charValue] != -1) {
                z = false;
                Preconditions.checkArgument(z, "Padding character %s was already in alphabet", ch);
                this.f15111g = ch;
            }
        }
        z = true;
        Preconditions.checkArgument(z, "Padding character %s was already in alphabet", ch);
        this.f15111g = ch;
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: a */
    public int mo4193a(byte[] bArr, CharSequence charSequence) {
        int i;
        int i2;
        Preconditions.checkNotNull(bArr);
        CharSequence mo4197e = mo4197e(charSequence);
        int length = mo4197e.length();
        C0967a c0967a = this.f15110f;
        if (c0967a.f15099h[length % c0967a.f15096e]) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < mo4197e.length()) {
                long j = 0;
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    i = c0967a.f15095d;
                    i2 = c0967a.f15096e;
                    if (i5 >= i2) {
                        break;
                    }
                    j <<= i;
                    if (i3 + i5 < mo4197e.length()) {
                        j |= c0967a.m4206a(mo4197e.charAt(i6 + i3));
                        i6++;
                    }
                    i5++;
                }
                int i7 = c0967a.f15097f;
                int i8 = (i7 * 8) - (i6 * i);
                int i9 = (i7 - 1) * 8;
                while (i9 >= i8) {
                    bArr[i4] = (byte) ((j >>> i9) & 255);
                    i9 -= 8;
                    i4++;
                }
                i3 += i2;
            }
            return i4;
        }
        throw new IOException(ye0.m8290j(32, mo4197e.length(), "Invalid input length "));
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: b */
    public void mo4194b(byte[] bArr, Appendable appendable, int i, int i2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        int i3 = 0;
        while (i3 < i2) {
            C0967a c0967a = this.f15110f;
            m4208f(bArr, appendable, i + i3, Math.min(c0967a.f15097f, i2 - i3));
            i3 += c0967a.f15097f;
        }
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: c */
    public final int mo4195c(int i) {
        return (int) (((this.f15110f.f15095d * i) + 7) / 8);
    }

    @Override // com.google.common.io.BaseEncoding
    public final boolean canDecode(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        CharSequence mo4197e = mo4197e(charSequence);
        int length = mo4197e.length();
        C0967a c0967a = this.f15110f;
        if (!c0967a.f15099h[length % c0967a.f15096e]) {
            return false;
        }
        for (int i = 0; i < mo4197e.length(); i++) {
            char charAt = mo4197e.charAt(i);
            if (charAt > 127 || c0967a.f15098g[charAt] == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: d */
    public final int mo4196d(int i) {
        C0967a c0967a = this.f15110f;
        return IntMath.divide(i, c0967a.f15097f, RoundingMode.CEILING) * c0967a.f15096e;
    }

    @Override // com.google.common.io.BaseEncoding
    public final InputStream decodingStream(Reader reader) {
        Preconditions.checkNotNull(reader);
        return new C0971e(this, reader);
    }

    @Override // com.google.common.io.BaseEncoding
    /* renamed from: e */
    public final CharSequence mo4197e(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Character ch = this.f15111g;
        if (ch == null) {
            return charSequence;
        }
        char charValue = ch.charValue();
        int length = charSequence.length() - 1;
        while (length >= 0 && charSequence.charAt(length) == charValue) {
            length--;
        }
        return charSequence.subSequence(0, length + 1);
    }

    @Override // com.google.common.io.BaseEncoding
    public final OutputStream encodingStream(Writer writer) {
        Preconditions.checkNotNull(writer);
        return new C2054ze(this, writer);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0972f)) {
            return false;
        }
        C0972f c0972f = (C0972f) obj;
        if (!this.f15110f.equals(c0972f.f15110f) || !Objects.equal(this.f15111g, c0972f.f15111g)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final void m4208f(byte[] bArr, Appendable appendable, int i, int i2) {
        boolean z;
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        C0967a c0967a = this.f15110f;
        int i3 = 0;
        if (i2 <= c0967a.f15097f) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | (bArr[i + i4] & 255)) << 8;
        }
        int i5 = c0967a.f15095d;
        int i6 = ((i2 + 1) * 8) - i5;
        while (i3 < i2 * 8) {
            appendable.append(c0967a.f15093b[((int) (j >>> (i6 - i3))) & c0967a.f15094c]);
            i3 += i5;
        }
        Character ch = this.f15111g;
        if (ch != null) {
            while (i3 < c0967a.f15097f * 8) {
                appendable.append(ch.charValue());
                i3 += i5;
            }
        }
    }

    /* renamed from: g */
    public BaseEncoding mo4207g(C0967a c0967a, Character ch) {
        return new C0972f(c0967a, ch);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f15110f.f15093b) ^ Objects.hashCode(this.f15111g);
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding lowerCase() {
        C0967a c0967a;
        boolean z;
        BaseEncoding baseEncoding = this.f15113i;
        if (baseEncoding == null) {
            C0967a c0967a2 = this.f15110f;
            char[] cArr = c0967a2.f15093b;
            int length = cArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (Ascii.isUpperCase(cArr[i])) {
                        char[] cArr2 = c0967a2.f15093b;
                        int length2 = cArr2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length2) {
                                if (Ascii.isLowerCase(cArr2[i2])) {
                                    z = true;
                                    break;
                                }
                                i2++;
                            } else {
                                z = false;
                                break;
                            }
                        }
                        Preconditions.checkState(!z, "Cannot call lowerCase() on a mixed-case alphabet");
                        char[] cArr3 = new char[cArr2.length];
                        for (int i3 = 0; i3 < cArr2.length; i3++) {
                            cArr3[i3] = Ascii.toLowerCase(cArr2[i3]);
                        }
                        c0967a = new C0967a(String.valueOf(c0967a2.f15092a).concat(".lowerCase()"), cArr3);
                    } else {
                        i++;
                    }
                } else {
                    c0967a = c0967a2;
                    break;
                }
            }
            if (c0967a == c0967a2) {
                baseEncoding = this;
            } else {
                baseEncoding = mo4207g(c0967a, this.f15111g);
            }
            this.f15113i = baseEncoding;
        }
        return baseEncoding;
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding omitPadding() {
        if (this.f15111g == null) {
            return this;
        }
        return mo4207g(this.f15110f, null);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        C0967a c0967a = this.f15110f;
        sb.append(c0967a.f15092a);
        if (8 % c0967a.f15095d != 0) {
            Character ch = this.f15111g;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding upperCase() {
        C0967a c0967a;
        boolean z;
        BaseEncoding baseEncoding = this.f15112h;
        if (baseEncoding == null) {
            C0967a c0967a2 = this.f15110f;
            char[] cArr = c0967a2.f15093b;
            int length = cArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (Ascii.isLowerCase(cArr[i])) {
                        char[] cArr2 = c0967a2.f15093b;
                        int length2 = cArr2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length2) {
                                if (Ascii.isUpperCase(cArr2[i2])) {
                                    z = true;
                                    break;
                                }
                                i2++;
                            } else {
                                z = false;
                                break;
                            }
                        }
                        Preconditions.checkState(!z, "Cannot call upperCase() on a mixed-case alphabet");
                        char[] cArr3 = new char[cArr2.length];
                        for (int i3 = 0; i3 < cArr2.length; i3++) {
                            cArr3[i3] = Ascii.toUpperCase(cArr2[i3]);
                        }
                        c0967a = new C0967a(String.valueOf(c0967a2.f15092a).concat(".upperCase()"), cArr3);
                    } else {
                        i++;
                    }
                } else {
                    c0967a = c0967a2;
                    break;
                }
            }
            if (c0967a == c0967a2) {
                baseEncoding = this;
            } else {
                baseEncoding = mo4207g(c0967a, this.f15111g);
            }
            this.f15112h = baseEncoding;
        }
        return baseEncoding;
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding withPadChar(char c) {
        Character ch;
        C0967a c0967a = this.f15110f;
        if (8 % c0967a.f15095d != 0 && ((ch = this.f15111g) == null || ch.charValue() != c)) {
            return mo4207g(c0967a, Character.valueOf(c));
        }
        return this;
    }

    @Override // com.google.common.io.BaseEncoding
    public final BaseEncoding withSeparator(String str, int i) {
        boolean z;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            byte[] bArr = this.f15110f.f15098g;
            if (charAt < bArr.length && bArr[charAt] != -1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(!z, "Separator (%s) cannot contain alphabet characters", str);
        }
        Character ch = this.f15111g;
        if (ch != null) {
            if (str.indexOf(ch.charValue()) < 0) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "Separator (%s) cannot contain padding character", str);
        }
        return new C0970d(this, str, i);
    }

    public C0972f(String str, String str2) {
        this(new C0967a(str, str2.toCharArray()), (Character) '=');
    }
}
