package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* renamed from: yd */
/* loaded from: classes.dex */
public final class C2016yd implements SeekMap {

    /* renamed from: a */
    public final long f28904a;

    /* renamed from: b */
    public final /* synthetic */ AviExtractor f28905b;

    public C2016yd(AviExtractor aviExtractor, long j) {
        this.f28905b = aviExtractor;
        this.f28904a = j;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.f28904a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        AviExtractor aviExtractor = this.f28905b;
        SeekMap.SeekPoints m6205b = aviExtractor.f10136g[0].m6205b(j);
        int i = 1;
        while (true) {
            C1556mp[] c1556mpArr = aviExtractor.f10136g;
            if (i < c1556mpArr.length) {
                SeekMap.SeekPoints m6205b2 = c1556mpArr[i].m6205b(j);
                if (m6205b2.first.position < m6205b.first.position) {
                    m6205b = m6205b2;
                }
                i++;
            } else {
                return m6205b;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
