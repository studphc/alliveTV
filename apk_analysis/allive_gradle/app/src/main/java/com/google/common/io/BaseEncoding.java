package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import p000.C1869ue;
import p000.C1906ve;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class BaseEncoding {

    /* renamed from: a */
    public static final C0969c f15062a = new C0969c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /* renamed from: b */
    public static final C0969c f15063b = new C0969c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");

    /* renamed from: c */
    public static final C0972f f15064c = new C0972f("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");

    /* renamed from: d */
    public static final C0972f f15065d = new C0972f("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");

    /* renamed from: e */
    public static final C0968b f15066e = new C0968b(new C0967a("base16()", "0123456789ABCDEF".toCharArray()));

    /* loaded from: classes2.dex */
    public static final class DecodingException extends IOException {
    }

    public static BaseEncoding base16() {
        return f15066e;
    }

    public static BaseEncoding base32() {
        return f15064c;
    }

    public static BaseEncoding base32Hex() {
        return f15065d;
    }

    public static BaseEncoding base64() {
        return f15062a;
    }

    public static BaseEncoding base64Url() {
        return f15063b;
    }

    /* renamed from: a */
    public abstract int mo4193a(byte[] bArr, CharSequence charSequence);

    /* renamed from: b */
    public abstract void mo4194b(byte[] bArr, Appendable appendable, int i, int i2);

    /* renamed from: c */
    public abstract int mo4195c(int i);

    public abstract boolean canDecode(CharSequence charSequence);

    /* renamed from: d */
    public abstract int mo4196d(int i);

    public final byte[] decode(CharSequence charSequence) {
        try {
            CharSequence mo4197e = mo4197e(charSequence);
            int mo4195c = mo4195c(mo4197e.length());
            byte[] bArr = new byte[mo4195c];
            int mo4193a = mo4193a(bArr, mo4197e);
            if (mo4193a != mo4195c) {
                byte[] bArr2 = new byte[mo4193a];
                System.arraycopy(bArr, 0, bArr2, 0, mo4193a);
                return bArr2;
            }
            return bArr;
        } catch (DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GwtIncompatible
    public final ByteSource decodingSource(CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new C1906ve(this, charSource);
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    /* renamed from: e */
    public CharSequence mo4197e(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    @GwtIncompatible
    public final ByteSink encodingSink(CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new C1869ue(this, charSink);
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c);

    public abstract BaseEncoding withSeparator(String str, int i);

    public final String encode(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(mo4196d(i2));
        try {
            mo4194b(bArr, sb, i, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
