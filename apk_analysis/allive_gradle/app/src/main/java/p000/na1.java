package p000;

import com.google.common.primitives.Longs;

/* loaded from: classes2.dex */
public enum na1 extends oa1 {
    public na1() {
        super("INSTANCE", 0);
    }

    @Override // p000.pa1
    /* renamed from: a */
    public final long mo6329a(int i, byte[] bArr) {
        return Longs.fromBytes(bArr[i + 7], bArr[i + 6], bArr[i + 5], bArr[i + 4], bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
    }
}
