package p000;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class c10 implements SeekMap {

    /* renamed from: a */
    public final /* synthetic */ d10 f8225a;

    public c10(d10 d10Var) {
        this.f8225a = d10Var;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return (this.f8225a.f16202f * 1000000) / r0.f16200d.f8444i;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        d10 d10Var = this.f8225a;
        long j2 = (d10Var.f16200d.f8444i * j) / 1000000;
        long j3 = d10Var.f16199c;
        long j4 = d10Var.f16198b;
        return new SeekMap.SeekPoints(new SeekPoint(j, Util.constrainValue(((((j3 - j4) * j2) / d10Var.f16202f) + j4) - 30000, j4, j3 - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
