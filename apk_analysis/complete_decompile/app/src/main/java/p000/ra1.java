package p000;

import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public enum ra1 extends ta1 {
    public ra1() {
        super("UNSAFE_BIG_ENDIAN", 1);
    }

    @Override // p000.pa1
    /* renamed from: a */
    public final long mo6329a(int i, byte[] bArr) {
        Unsafe unsafe;
        int i2;
        unsafe = ta1.f26747c;
        long j = i;
        i2 = ta1.f26748d;
        return Long.reverseBytes(unsafe.getLong(bArr, j + i2));
    }
}
