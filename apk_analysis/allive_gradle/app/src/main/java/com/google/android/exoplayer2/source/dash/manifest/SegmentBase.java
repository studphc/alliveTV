package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SegmentBase {

    /* renamed from: a */
    public final RangedUri f11333a;

    /* renamed from: b */
    public final long f11334b;

    /* renamed from: c */
    public final long f11335c;

    /* loaded from: classes.dex */
    public static abstract class MultiSegmentBase extends SegmentBase {

        /* renamed from: d */
        public final long f11336d;

        /* renamed from: e */
        public final long f11337e;

        /* renamed from: f */
        public final List f11338f;

        /* renamed from: g */
        public final long f11339g;

        /* renamed from: h */
        public final long f11340h;

        /* renamed from: i */
        public final long f11341i;

        public MultiSegmentBase(@Nullable RangedUri rangedUri, long j, long j2, long j3, long j4, @Nullable List<SegmentTimelineElement> list, long j5, long j6, long j7) {
            super(rangedUri, j, j2);
            this.f11336d = j3;
            this.f11337e = j4;
            this.f11338f = list;
            this.f11341i = j5;
            this.f11339g = j6;
            this.f11340h = j7;
        }

        public long getAvailableSegmentCount(long j, long j2) {
            long segmentCount = getSegmentCount(j);
            if (segmentCount != -1) {
                return segmentCount;
            }
            return (int) (getSegmentNum((j2 - this.f11340h) + this.f11341i, j) - getFirstAvailableSegmentNum(j, j2));
        }

        public long getFirstAvailableSegmentNum(long j, long j2) {
            if (getSegmentCount(j) == -1) {
                long j3 = this.f11339g;
                if (j3 != C0643C.TIME_UNSET) {
                    return Math.max(getFirstSegmentNum(), getSegmentNum((j2 - this.f11340h) - j3, j));
                }
            }
            return getFirstSegmentNum();
        }

        public long getFirstSegmentNum() {
            return this.f11336d;
        }

        public long getNextSegmentAvailableTimeUs(long j, long j2) {
            if (this.f11338f != null) {
                return C0643C.TIME_UNSET;
            }
            long availableSegmentCount = getAvailableSegmentCount(j, j2) + getFirstAvailableSegmentNum(j, j2);
            return (getSegmentDurationUs(availableSegmentCount, j) + getSegmentTimeUs(availableSegmentCount)) - this.f11341i;
        }

        public abstract long getSegmentCount(long j);

        public final long getSegmentDurationUs(long j, long j2) {
            long j3 = this.f11334b;
            List list = this.f11338f;
            if (list != null) {
                return (((SegmentTimelineElement) list.get((int) (j - this.f11336d))).f11347b * 1000000) / j3;
            }
            long segmentCount = getSegmentCount(j2);
            if (segmentCount != -1 && j == (getFirstSegmentNum() + segmentCount) - 1) {
                return j2 - getSegmentTimeUs(j);
            }
            return (this.f11337e * 1000000) / j3;
        }

        public long getSegmentNum(long j, long j2) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.f11338f == null) {
                long j3 = (j / ((this.f11337e * 1000000) / this.f11334b)) + this.f11336d;
                if (j3 >= firstSegmentNum) {
                    if (segmentCount == -1) {
                        return j3;
                    }
                    return Math.min(j3, (firstSegmentNum + segmentCount) - 1);
                }
                return firstSegmentNum;
            }
            long j4 = (segmentCount + firstSegmentNum) - 1;
            long j5 = firstSegmentNum;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long segmentTimeUs = getSegmentTimeUs(j6);
                if (segmentTimeUs < j) {
                    j5 = j6 + 1;
                } else if (segmentTimeUs > j) {
                    j4 = j6 - 1;
                } else {
                    return j6;
                }
            }
            if (j5 == firstSegmentNum) {
                return j5;
            }
            return j4;
        }

        public final long getSegmentTimeUs(long j) {
            long j2;
            long j3 = this.f11336d;
            List list = this.f11338f;
            if (list != null) {
                j2 = ((SegmentTimelineElement) list.get((int) (j - j3))).f11346a - this.f11335c;
            } else {
                j2 = (j - j3) * this.f11337e;
            }
            return Util.scaleLargeTimestamp(j2, 1000000L, this.f11334b);
        }

        public abstract RangedUri getSegmentUrl(Representation representation, long j);

        public boolean isExplicit() {
            if (this.f11338f != null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class SegmentList extends MultiSegmentBase {

        /* renamed from: j */
        public final List f11342j;

        public SegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, @Nullable List<SegmentTimelineElement> list, long j5, @Nullable List<RangedUri> list2, long j6, long j7) {
            super(rangedUri, j, j2, j3, j4, list, j5, j6, j7);
            this.f11342j = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public long getSegmentCount(long j) {
            return this.f11342j.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long j) {
            return (RangedUri) this.f11342j.get((int) (j - this.f11336d));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class SegmentTemplate extends MultiSegmentBase {

        /* renamed from: j */
        public final UrlTemplate f11343j;

        /* renamed from: k */
        public final UrlTemplate f11344k;

        /* renamed from: l */
        public final long f11345l;

        public SegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, @Nullable List<SegmentTimelineElement> list, long j6, @Nullable UrlTemplate urlTemplate, @Nullable UrlTemplate urlTemplate2, long j7, long j8) {
            super(rangedUri, j, j2, j3, j5, list, j6, j7, j8);
            this.f11343j = urlTemplate;
            this.f11344k = urlTemplate2;
            this.f11345l = j4;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        @Nullable
        public RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.f11343j;
            if (urlTemplate != null) {
                Format format = representation.format;
                return new RangedUri(urlTemplate.buildUri(format.f9354id, 0L, format.bitrate, 0L), 0L, -1L);
            }
            return super.getInitialization(representation);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public long getSegmentCount(long j) {
            if (this.f11338f != null) {
                return r0.size();
            }
            long j2 = this.f11345l;
            if (j2 != -1) {
                return (j2 - this.f11336d) + 1;
            }
            if (j == C0643C.TIME_UNSET) {
                return -1L;
            }
            return BigIntegerMath.divide(BigInteger.valueOf(j).multiply(BigInteger.valueOf(this.f11334b)), BigInteger.valueOf(this.f11337e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long j) {
            long j2;
            long j3 = this.f11336d;
            List list = this.f11338f;
            if (list != null) {
                j2 = ((SegmentTimelineElement) list.get((int) (j - j3))).f11346a;
            } else {
                j2 = (j - j3) * this.f11337e;
            }
            long j4 = j2;
            Format format = representation.format;
            return new RangedUri(this.f11344k.buildUri(format.f9354id, j, format.bitrate, j4), 0L, -1L);
        }
    }

    /* loaded from: classes.dex */
    public static final class SegmentTimelineElement {

        /* renamed from: a */
        public final long f11346a;

        /* renamed from: b */
        public final long f11347b;

        public SegmentTimelineElement(long j, long j2) {
            this.f11346a = j;
            this.f11347b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SegmentTimelineElement.class != obj.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
            if (this.f11346a == segmentTimelineElement.f11346a && this.f11347b == segmentTimelineElement.f11347b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.f11346a) * 31) + ((int) this.f11347b);
        }
    }

    public SegmentBase(@Nullable RangedUri rangedUri, long j, long j2) {
        this.f11333a = rangedUri;
        this.f11334b = j;
        this.f11335c = j2;
    }

    @Nullable
    public RangedUri getInitialization(Representation representation) {
        return this.f11333a;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.f11335c, 1000000L, this.f11334b);
    }

    /* loaded from: classes.dex */
    public static class SingleSegmentBase extends SegmentBase {

        /* renamed from: d */
        public final long f11348d;

        /* renamed from: e */
        public final long f11349e;

        public SingleSegmentBase(@Nullable RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.f11348d = j3;
            this.f11349e = j4;
        }

        @Nullable
        public RangedUri getIndex() {
            long j = this.f11349e;
            if (j <= 0) {
                return null;
            }
            return new RangedUri(null, this.f11348d, j);
        }

        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
