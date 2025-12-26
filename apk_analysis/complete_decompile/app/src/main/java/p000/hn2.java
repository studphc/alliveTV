package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.jpeg.StartOffsetExtractorOutput;

/* loaded from: classes.dex */
public final class hn2 implements SeekMap {

    /* renamed from: a */
    public final /* synthetic */ SeekMap f18107a;

    /* renamed from: b */
    public final /* synthetic */ StartOffsetExtractorOutput f18108b;

    public hn2(StartOffsetExtractorOutput startOffsetExtractorOutput, SeekMap seekMap) {
        this.f18108b = startOffsetExtractorOutput;
        this.f18107a = seekMap;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.f18107a.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        SeekMap.SeekPoints seekPoints = this.f18107a.getSeekPoints(j);
        SeekPoint seekPoint = seekPoints.first;
        long j2 = seekPoint.timeUs;
        long j3 = seekPoint.position;
        StartOffsetExtractorOutput startOffsetExtractorOutput = this.f18108b;
        SeekPoint seekPoint2 = new SeekPoint(j2, j3 + startOffsetExtractorOutput.f10184a);
        SeekPoint seekPoint3 = seekPoints.second;
        return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.timeUs, seekPoint3.position + startOffsetExtractorOutput.f10184a));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return this.f18107a.isSeekable();
    }
}
