package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.SeekMap;

/* loaded from: classes.dex */
public class ConstantBitrateSeekMap implements SeekMap {

    /* renamed from: a */
    public final long f10057a;

    /* renamed from: b */
    public final long f10058b;

    /* renamed from: c */
    public final int f10059c;

    /* renamed from: d */
    public final long f10060d;

    /* renamed from: e */
    public final int f10061e;

    /* renamed from: f */
    public final long f10062f;

    /* renamed from: g */
    public final boolean f10063g;

    public ConstantBitrateSeekMap(long j, long j2, int i, int i2) {
        this(j, j2, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f10062f;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long j2 = this.f10060d;
        long j3 = this.f10058b;
        if (j2 == -1 && !this.f10063g) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, j3));
        }
        int i = this.f10059c;
        long j4 = i;
        long j5 = (((this.f10061e * j) / 8000000) / j4) * j4;
        if (j2 != -1) {
            j5 = Math.min(j5, j2 - j4);
        }
        long max = j3 + Math.max(j5, 0L);
        long timeUsAtPosition = getTimeUsAtPosition(max);
        SeekPoint seekPoint = new SeekPoint(timeUsAtPosition, max);
        if (j2 != -1 && timeUsAtPosition < j && i + max < this.f10057a) {
            long j6 = max + i;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUsAtPosition(j6), j6));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUs(long j) {
        return getTimeUsAtPosition(j);
    }

    public long getTimeUsAtPosition(long j) {
        return (Math.max(0L, j - this.f10058b) * 8000000) / this.f10061e;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        if (this.f10060d == -1 && !this.f10063g) {
            return false;
        }
        return true;
    }

    public ConstantBitrateSeekMap(long j, long j2, int i, int i2, boolean z) {
        this.f10057a = j;
        this.f10058b = j2;
        this.f10059c = i2 == -1 ? 1 : i2;
        this.f10061e = i;
        this.f10063g = z;
        if (j == -1) {
            this.f10060d = -1L;
            this.f10062f = C0643C.TIME_UNSET;
        } else {
            long j3 = j - j2;
            this.f10060d = j3;
            this.f10062f = (Math.max(0L, j3) * 8000000) / i;
        }
    }
}
