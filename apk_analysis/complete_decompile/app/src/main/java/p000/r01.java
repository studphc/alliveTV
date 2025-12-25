package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.hls.SampleQueueMappingException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r01 implements SampleStream {

    /* renamed from: a */
    public final int f25819a;

    /* renamed from: b */
    public final v01 f25820b;

    /* renamed from: c */
    public int f25821c = -1;

    public r01(v01 v01Var, int i) {
        this.f25820b = v01Var;
        this.f25819a = i;
    }

    /* renamed from: a */
    public final void m7158a() {
        boolean z;
        if (this.f25821c == -1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        v01 v01Var = this.f25820b;
        v01Var.m7795a();
        Assertions.checkNotNull(v01Var.f27573K);
        int[] iArr = v01Var.f27573K;
        int i = this.f25819a;
        int i2 = iArr[i];
        if (i2 == -1) {
            if (v01Var.f27572J.contains(v01Var.f27571I.get(i))) {
                i2 = -3;
            }
            i2 = -2;
        } else {
            boolean[] zArr = v01Var.f27576N;
            if (!zArr[i2]) {
                zArr[i2] = true;
            }
            i2 = -2;
        }
        this.f25821c = i2;
    }

    /* renamed from: b */
    public final boolean m7159b() {
        int i = this.f25821c;
        if (i != -1 && i != -3 && i != -2) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        if (this.f25821c != -3) {
            if (m7159b()) {
                int i = this.f25821c;
                v01 v01Var = this.f25820b;
                if (v01Var.m7799h() || !v01Var.f27608v[i].isReady(v01Var.f27582T)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
        int i = this.f25821c;
        v01 v01Var = this.f25820b;
        if (i != -2) {
            if (i == -1) {
                v01Var.m7801j();
                return;
            } else {
                if (i != -3) {
                    v01Var.m7801j();
                    v01Var.f27608v[i].maybeThrowError();
                    return;
                }
                return;
            }
        }
        v01Var.m7795a();
        throw new SampleQueueMappingException(v01Var.f27571I.get(this.f25819a).getFormat(0).sampleMimeType);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        Format format;
        Format format2;
        int i2 = -3;
        if (this.f25821c == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (m7159b()) {
            int i3 = this.f25821c;
            v01 v01Var = this.f25820b;
            if (!v01Var.m7799h()) {
                ArrayList arrayList = v01Var.f27600n;
                int i4 = 0;
                if (!arrayList.isEmpty()) {
                    int i5 = 0;
                    loop0: while (i5 < arrayList.size() - 1) {
                        int i6 = ((q01) arrayList.get(i5)).f25367a;
                        int length = v01Var.f27608v.length;
                        for (int i7 = 0; i7 < length; i7++) {
                            if (v01Var.f27576N[i7] && v01Var.f27608v[i7].peekSourceId() == i6) {
                                break loop0;
                            }
                        }
                        i5++;
                    }
                    Util.removeRange(arrayList, 0, i5);
                    q01 q01Var = (q01) arrayList.get(0);
                    Format format3 = q01Var.trackFormat;
                    if (!format3.equals(v01Var.f27569G)) {
                        int i8 = q01Var.trackSelectionReason;
                        Object obj = q01Var.trackSelectionData;
                        long j = q01Var.startTimeUs;
                        format2 = format3;
                        v01Var.f27597k.downstreamFormatChanged(v01Var.f27588b, format3, i8, obj, j);
                    } else {
                        format2 = format3;
                    }
                    v01Var.f27569G = format2;
                }
                if ((arrayList.isEmpty() || ((q01) arrayList.get(0)).f25366B) && (i2 = v01Var.f27608v[i3].read(formatHolder, decoderInputBuffer, i, v01Var.f27582T)) == -5) {
                    Format format4 = (Format) Assertions.checkNotNull(formatHolder.format);
                    if (i3 == v01Var.f27564B) {
                        int peekSourceId = v01Var.f27608v[i3].peekSourceId();
                        while (i4 < arrayList.size() && ((q01) arrayList.get(i4)).f25367a != peekSourceId) {
                            i4++;
                        }
                        if (i4 < arrayList.size()) {
                            format = ((q01) arrayList.get(i4)).trackFormat;
                        } else {
                            format = (Format) Assertions.checkNotNull(v01Var.f27568F);
                        }
                        format4 = format4.withManifestFormatInfo(format);
                    }
                    formatHolder.format = format4;
                }
            }
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        if (!m7159b()) {
            return 0;
        }
        int i = this.f25821c;
        v01 v01Var = this.f25820b;
        if (v01Var.m7799h()) {
            return 0;
        }
        u01 u01Var = v01Var.f27608v[i];
        int skipCount = u01Var.getSkipCount(j, v01Var.f27582T);
        q01 q01Var = (q01) Iterables.getLast(v01Var.f27600n, null);
        if (q01Var != null && !q01Var.f25366B) {
            skipCount = Math.min(skipCount, q01Var.getFirstSampleIndex(i) - u01Var.getReadIndex());
        }
        u01Var.skip(skipCount);
        return skipCount;
    }
}
