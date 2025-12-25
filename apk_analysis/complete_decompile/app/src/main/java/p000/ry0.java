package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class ry0 {

    /* renamed from: e */
    public static final byte[] f26180e = {0, 0, 1};

    /* renamed from: a */
    public boolean f26181a;

    /* renamed from: b */
    public int f26182b;

    /* renamed from: c */
    public int f26183c;

    /* renamed from: d */
    public byte[] f26184d;

    /* renamed from: a */
    public final void m7310a(byte[] bArr, int i, int i2) {
        if (!this.f26181a) {
            return;
        }
        int i3 = i2 - i;
        byte[] bArr2 = this.f26184d;
        int length = bArr2.length;
        int i4 = this.f26182b + i3;
        if (length < i4) {
            this.f26184d = Arrays.copyOf(bArr2, i4 * 2);
        }
        System.arraycopy(bArr, i, this.f26184d, this.f26182b, i3);
        this.f26182b += i3;
    }
}
