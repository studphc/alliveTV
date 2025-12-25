package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;

/* loaded from: classes.dex */
public final class bo2 implements s02 {
    @Override // p000.s02
    /* renamed from: a */
    public final SeekMap mo2124a() {
        return new SeekMap.Unseekable(C0643C.TIME_UNSET);
    }

    @Override // p000.s02
    public final long read(ExtractorInput extractorInput) {
        return -1L;
    }

    @Override // p000.s02
    /* renamed from: b */
    public final void mo2125b(long j) {
    }
}
