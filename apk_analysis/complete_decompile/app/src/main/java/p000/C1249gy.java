package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* renamed from: gy */
/* loaded from: classes.dex */
public final class C1249gy extends Timeline {

    /* renamed from: a */
    public final long f17867a;

    /* renamed from: b */
    public final long f17868b;

    /* renamed from: c */
    public final long f17869c;

    /* renamed from: d */
    public final int f17870d;

    /* renamed from: e */
    public final long f17871e;

    /* renamed from: f */
    public final long f17872f;

    /* renamed from: g */
    public final long f17873g;

    /* renamed from: h */
    public final DashManifest f17874h;

    /* renamed from: i */
    public final MediaItem f17875i;

    /* renamed from: j */
    public final MediaItem.LiveConfiguration f17876j;

    public C1249gy(long j, long j2, long j3, int i, long j4, long j5, long j6, DashManifest dashManifest, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
        boolean z;
        boolean z2 = dashManifest.dynamic;
        if (liveConfiguration != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z2 == z);
        this.f17867a = j;
        this.f17868b = j2;
        this.f17869c = j3;
        this.f17870d = i;
        this.f17871e = j4;
        this.f17872f = j5;
        this.f17873g = j6;
        this.f17874h = dashManifest;
        this.f17875i = mediaItem;
        this.f17876j = liveConfiguration;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        int intValue;
        if (!(obj instanceof Integer) || (intValue = ((Integer) obj).intValue() - this.f17870d) < 0 || intValue >= this.f17874h.getPeriodCount()) {
            return -1;
        }
        return intValue;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        String str;
        DashManifest dashManifest = this.f17874h;
        Assertions.checkIndex(i, 0, dashManifest.getPeriodCount());
        Integer num = null;
        if (z) {
            str = dashManifest.getPeriod(i).f11325id;
        } else {
            str = null;
        }
        if (z) {
            num = Integer.valueOf(this.f17870d + i);
        }
        return period.set(str, num, 0, dashManifest.getPeriodDurationUs(i), Util.msToUs(dashManifest.getPeriod(i).startMs - dashManifest.getPeriod(0).startMs) - this.f17871e);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getPeriodCount() {
        return this.f17874h.getPeriodCount();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Object getUidOfPeriod(int i) {
        Assertions.checkIndex(i, 0, this.f17874h.getPeriodCount());
        return Integer.valueOf(this.f17870d + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    @Override // com.google.android.exoplayer2.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        boolean z;
        DashSegmentIndex index;
        long timeUs;
        boolean z2;
        Assertions.checkIndex(i, 0, 1);
        DashManifest dashManifest = this.f17874h;
        if (dashManifest.dynamic && dashManifest.minUpdatePeriodMs != C0643C.TIME_UNSET && dashManifest.durationMs == C0643C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        long j2 = this.f17873g;
        if (z) {
            if (j > 0) {
                j2 += j;
                if (j2 > this.f17872f) {
                    timeUs = -9223372036854775807L;
                    Object obj = Timeline.Window.SINGLE_WINDOW_UID;
                    if (!dashManifest.dynamic && dashManifest.minUpdatePeriodMs != C0643C.TIME_UNSET && dashManifest.durationMs == C0643C.TIME_UNSET) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    return window.set(obj, this.f17875i, dashManifest, this.f17867a, this.f17868b, this.f17869c, true, z2, this.f17876j, timeUs, this.f17872f, 0, dashManifest.getPeriodCount() - 1, this.f17871e);
                }
            }
            long j3 = this.f17871e + j2;
            long periodDurationUs = dashManifest.getPeriodDurationUs(0);
            int i2 = 0;
            while (i2 < dashManifest.getPeriodCount() - 1 && j3 >= periodDurationUs) {
                j3 -= periodDurationUs;
                i2++;
                periodDurationUs = dashManifest.getPeriodDurationUs(i2);
            }
            Period period = dashManifest.getPeriod(i2);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            if (adaptationSetIndex != -1 && (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) != null && index.getSegmentCount(periodDurationUs) != 0) {
                timeUs = (index.getTimeUs(index.getSegmentNum(j3, periodDurationUs)) + j2) - j3;
                Object obj2 = Timeline.Window.SINGLE_WINDOW_UID;
                if (!dashManifest.dynamic) {
                }
                z2 = false;
                return window.set(obj2, this.f17875i, dashManifest, this.f17867a, this.f17868b, this.f17869c, true, z2, this.f17876j, timeUs, this.f17872f, 0, dashManifest.getPeriodCount() - 1, this.f17871e);
            }
        }
        timeUs = j2;
        Object obj22 = Timeline.Window.SINGLE_WINDOW_UID;
        if (!dashManifest.dynamic) {
        }
        z2 = false;
        return window.set(obj22, this.f17875i, dashManifest, this.f17867a, this.f17868b, this.f17869c, true, z2, this.f17876j, timeUs, this.f17872f, 0, dashManifest.getPeriodCount() - 1, this.f17871e);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getWindowCount() {
        return 1;
    }
}
