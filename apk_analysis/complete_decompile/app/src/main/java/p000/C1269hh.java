package p000;

import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;

/* renamed from: hh */
/* loaded from: classes2.dex */
public enum C1269hh extends EnumC1354jh {
    public C1269hh() {
        super("MURMUR128_MITZ_64", 1);
    }

    /* renamed from: c */
    public static long m5087c(byte[] bArr) {
        return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
    }

    /* renamed from: d */
    public static long m5088d(byte[] bArr) {
        return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
    }

    @Override // p000.EnumC1354jh
    /* renamed from: a */
    public final boolean mo4952a(Object obj, Funnel funnel, int i, C1306ih c1306ih) {
        long m5241a = c1306ih.m5241a();
        byte[] mo4190c = Hashing.murmur3_128().hashObject(obj, funnel).mo4190c();
        long m5087c = m5087c(mo4190c);
        long m5088d = m5088d(mo4190c);
        for (int i2 = 0; i2 < i; i2++) {
            if (!c1306ih.m5242b((Long.MAX_VALUE & m5087c) % m5241a)) {
                return false;
            }
            m5087c += m5088d;
        }
        return true;
    }

    @Override // p000.EnumC1354jh
    /* renamed from: b */
    public final boolean mo4953b(Object obj, Funnel funnel, int i, C1306ih c1306ih) {
        long m5241a = c1306ih.m5241a();
        byte[] mo4190c = Hashing.murmur3_128().hashObject(obj, funnel).mo4190c();
        long m5087c = m5087c(mo4190c);
        long m5088d = m5088d(mo4190c);
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            z |= c1306ih.m5244d((Long.MAX_VALUE & m5087c) % m5241a);
            m5087c += m5088d;
        }
        return z;
    }
}
