package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class s43 implements r43 {

    /* renamed from: a */
    public final ExtractorOutput f26235a;

    /* renamed from: b */
    public final TrackOutput f26236b;

    /* renamed from: c */
    public final C1682pc f26237c;

    /* renamed from: d */
    public final Format f26238d;

    /* renamed from: e */
    public final int f26239e;

    /* renamed from: f */
    public long f26240f;

    /* renamed from: g */
    public int f26241g;

    /* renamed from: h */
    public long f26242h;

    public s43(ExtractorOutput extractorOutput, TrackOutput trackOutput, C1682pc c1682pc, String str, int i) {
        this.f26235a = extractorOutput;
        this.f26236b = trackOutput;
        this.f26237c = c1682pc;
        int i2 = c1682pc.f25115d;
        int i3 = c1682pc.f25112a;
        int i4 = (i2 * i3) / 8;
        int i5 = c1682pc.f25114c;
        if (i5 == i4) {
            int i6 = c1682pc.f25113b;
            int i7 = i6 * i4;
            int i8 = i7 * 8;
            int max = Math.max(i4, i7 / 10);
            this.f26239e = max;
            this.f26238d = new Format.Builder().setSampleMimeType(str).setAverageBitrate(i8).setPeakBitrate(i8).setMaxInputSize(max).setChannelCount(i3).setSampleRate(i6).setPcmEncoding(i).build();
            return;
        }
        throw ParserException.createForMalformedContainer("Expected block size: " + i4 + "; got: " + i5, null);
    }

    @Override // p000.r43
    /* renamed from: a */
    public final void mo6996a(long j) {
        this.f26240f = j;
        this.f26241g = 0;
        this.f26242h = 0L;
    }

    @Override // p000.r43
    /* renamed from: b */
    public final void mo6997b(int i, long j) {
        this.f26235a.seekMap(new u43(this.f26237c, 1, i, j));
        this.f26236b.format(this.f26238d);
    }

    @Override // p000.r43
    /* renamed from: c */
    public final boolean mo6998c(ExtractorInput extractorInput, long j) {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.f26241g) < (i2 = this.f26239e)) {
            int sampleData = this.f26236b.sampleData((DataReader) extractorInput, (int) Math.min(i2 - i, j2), true);
            if (sampleData == -1) {
                j2 = 0;
            } else {
                this.f26241g += sampleData;
                j2 -= sampleData;
            }
        }
        int i3 = this.f26237c.f25114c;
        int i4 = this.f26241g / i3;
        if (i4 > 0) {
            long scaleLargeTimestamp = this.f26240f + Util.scaleLargeTimestamp(this.f26242h, 1000000L, r1.f25113b);
            int i5 = i4 * i3;
            int i6 = this.f26241g - i5;
            this.f26236b.sampleMetadata(scaleLargeTimestamp, 1, i5, i6, null);
            this.f26242h += i4;
            this.f26241g = i6;
        }
        if (j2 <= 0) {
            return true;
        }
        return false;
    }
}
