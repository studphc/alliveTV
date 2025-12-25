package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class sy0 {

    /* renamed from: f */
    public static final byte[] f26613f = {0, 0, 1};

    /* renamed from: a */
    public boolean f26614a;

    /* renamed from: b */
    public int f26615b;

    /* renamed from: c */
    public int f26616c;

    /* renamed from: d */
    public int f26617d;

    /* renamed from: e */
    public byte[] f26618e;

    /* renamed from: a */
    public final void m7424a(byte[] bArr, int i, int i2) {
        if (!this.f26614a) {
            return;
        }
        int i3 = i2 - i;
        byte[] bArr2 = this.f26618e;
        int length = bArr2.length;
        int i4 = this.f26616c + i3;
        if (length < i4) {
            this.f26618e = Arrays.copyOf(bArr2, i4 * 2);
        }
        System.arraycopy(bArr, i, this.f26618e, this.f26616c, i3);
        this.f26616c += i3;
    }
}
