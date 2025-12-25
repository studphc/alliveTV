package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public interface SeekMap {

    /* loaded from: classes.dex */
    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            if (this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.second.hashCode() + (this.first.hashCode() * 31);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                str = ", " + this.second;
            }
            return AbstractC1726qj.m7061q(sb, str, "]");
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }
    }

    /* loaded from: classes.dex */
    public static class Unseekable implements SeekMap {

        /* renamed from: a */
        public final long f10097a;

        /* renamed from: b */
        public final SeekPoints f10098b;

        public Unseekable(long j) {
            this(j, 0L);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.f10097a;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long j) {
            return this.f10098b;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j, long j2) {
            this.f10097a = j;
            this.f10098b = new SeekPoints(j2 == 0 ? SeekPoint.START : new SeekPoint(0L, j2));
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long j);

    boolean isSeekable();
}
