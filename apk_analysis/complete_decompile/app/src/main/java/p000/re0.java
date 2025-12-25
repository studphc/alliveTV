package p000;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class re0 implements s02 {

    /* renamed from: a */
    public FlacStreamMetadata f25942a;

    /* renamed from: b */
    public FlacStreamMetadata.SeekTable f25943b;

    /* renamed from: c */
    public long f25944c;

    /* renamed from: d */
    public long f25945d;

    @Override // p000.s02
    /* renamed from: a */
    public final SeekMap mo2124a() {
        boolean z;
        if (this.f25944c != -1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        return new FlacSeekTableSeekMap(this.f25942a, this.f25944c);
    }

    @Override // p000.s02
    /* renamed from: b */
    public final void mo2125b(long j) {
        long[] jArr = this.f25943b.pointSampleNumbers;
        this.f25945d = jArr[Util.binarySearchFloor(jArr, j, true, true)];
    }

    @Override // p000.s02
    public final long read(ExtractorInput extractorInput) {
        long j = this.f25945d;
        if (j < 0) {
            return -1L;
        }
        long j2 = -(j + 2);
        this.f25945d = -1L;
        return j2;
    }
}
