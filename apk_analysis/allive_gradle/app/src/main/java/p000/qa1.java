package p000;

import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public enum qa1 extends ta1 {
    public qa1() {
        super("UNSAFE_LITTLE_ENDIAN", 0);
    }

    @Override // p000.pa1
    /* renamed from: a */
    public final long mo6329a(int i, byte[] bArr) {
        Unsafe unsafe;
        int i2;
        unsafe = ta1.f26747c;
        long j = i;
        i2 = ta1.f26748d;
        return unsafe.getLong(bArr, j + i2);
    }
}
