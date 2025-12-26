package p000;

import android.media.MediaParser;
import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;

/* loaded from: classes.dex */
public final class s12 implements SeekMap {

    /* renamed from: a */
    public final MediaParser.SeekMap f26204a;

    public s12(MediaParser.SeekMap seekMap) {
        this.f26204a = seekMap;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        long durationMicros;
        durationMicros = this.f26204a.getDurationMicros();
        if (durationMicros == -2147483648L) {
            return C0643C.TIME_UNSET;
        }
        return durationMicros;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        Pair seekPoints;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        seekPoints = this.f26204a.getSeekPoints(j);
        Object obj = seekPoints.first;
        if (obj == seekPoints.second) {
            MediaParser.SeekPoint m7087e = ql1.m7087e(obj);
            j6 = m7087e.timeMicros;
            j7 = m7087e.position;
            return new SeekMap.SeekPoints(new SeekPoint(j6, j7));
        }
        MediaParser.SeekPoint m7087e2 = ql1.m7087e(obj);
        j2 = m7087e2.timeMicros;
        j3 = m7087e2.position;
        SeekPoint seekPoint = new SeekPoint(j2, j3);
        MediaParser.SeekPoint m7087e3 = ql1.m7087e(seekPoints.second);
        j4 = m7087e3.timeMicros;
        j5 = m7087e3.position;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j4, j5));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        boolean isSeekable;
        isSeekable = this.f26204a.isSeekable();
        return isSeekable;
    }
}
