package p000;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class q02 {

    /* renamed from: a */
    public final r02 f25393a = new r02();

    /* renamed from: b */
    public final ParsableByteArray f25394b = new ParsableByteArray(new byte[65025], 0);

    /* renamed from: c */
    public int f25395c = -1;

    /* renamed from: d */
    public int f25396d;

    /* renamed from: e */
    public boolean f25397e;

    /* renamed from: a */
    public final int m6945a(int i) {
        int i2;
        int i3 = 0;
        this.f25396d = 0;
        do {
            int i4 = this.f25396d;
            int i5 = i + i4;
            r02 r02Var = this.f25393a;
            if (i5 >= r02Var.f25824c) {
                break;
            }
            int[] iArr = r02Var.f25827f;
            this.f25396d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    /* renamed from: b */
    public final boolean m6946b(ExtractorInput extractorInput) {
        boolean z;
        boolean z2;
        int i;
        if (extractorInput != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        boolean z3 = this.f25397e;
        ParsableByteArray parsableByteArray = this.f25394b;
        if (z3) {
            this.f25397e = false;
            parsableByteArray.reset(0);
        }
        while (!this.f25397e) {
            int i2 = this.f25395c;
            r02 r02Var = this.f25393a;
            if (i2 < 0) {
                if (!r02Var.m7161b(extractorInput, -1L) || !r02Var.m7160a(extractorInput, true)) {
                    return false;
                }
                int i3 = r02Var.f25825d;
                if ((r02Var.f25822a & 1) == 1 && parsableByteArray.limit() == 0) {
                    i3 += m6945a(0);
                    i = this.f25396d;
                } else {
                    i = 0;
                }
                if (!ExtractorUtil.skipFullyQuietly(extractorInput, i3)) {
                    return false;
                }
                this.f25395c = i;
            }
            int m6945a = m6945a(this.f25395c);
            int i4 = this.f25395c + this.f25396d;
            if (m6945a > 0) {
                parsableByteArray.ensureCapacity(parsableByteArray.limit() + m6945a);
                if (!ExtractorUtil.readFullyQuietly(extractorInput, parsableByteArray.getData(), parsableByteArray.limit(), m6945a)) {
                    return false;
                }
                parsableByteArray.setLimit(parsableByteArray.limit() + m6945a);
                if (r02Var.f25827f[i4 - 1] != 255) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f25397e = z2;
            }
            if (i4 == r02Var.f25824c) {
                i4 = -1;
            }
            this.f25395c = i4;
        }
        return true;
    }
}
