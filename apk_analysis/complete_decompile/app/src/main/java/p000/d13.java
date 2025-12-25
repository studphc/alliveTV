package p000;

import com.google.android.exoplayer2.extractor.ExtractorInput;

/* loaded from: classes.dex */
public final class d13 {

    /* renamed from: d */
    public static final long[] f16213d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a */
    public int f16214a;

    /* renamed from: b */
    public int f16215b;

    /* renamed from: c */
    public final byte[] f16216c;

    public d13() {
        this.f16216c = new byte[8];
    }

    /* renamed from: a */
    public static long m4507a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= ~f16213d[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    /* renamed from: b */
    public static int m4508b(int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            if ((f16213d[i2] & i) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public long m4509c(ExtractorInput extractorInput, boolean z, boolean z2, int i) {
        int i2 = this.f16214a;
        byte[] bArr = this.f16216c;
        if (i2 == 0) {
            if (!extractorInput.readFully(bArr, 0, 1, z)) {
                return -1L;
            }
            int m4508b = m4508b(bArr[0] & 255);
            this.f16215b = m4508b;
            if (m4508b != -1) {
                this.f16214a = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.f16215b;
        if (i3 > i) {
            this.f16214a = 0;
            return -2L;
        }
        if (i3 != 1) {
            extractorInput.readFully(bArr, 1, i3 - 1);
        }
        this.f16214a = 0;
        return m4507a(bArr, this.f16215b, z2);
    }

    public d13(byte[] bArr, int i, int i2) {
        this.f16216c = bArr;
        this.f16214a = i;
        this.f16215b = i2;
    }
}
