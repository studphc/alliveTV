package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.text.webvtt.WebvttCueInfo;
import com.google.android.exoplayer2.trackselection.C0716a;
import com.google.android.exoplayer2.trackselection.C0717b;
import com.google.android.exoplayer2.trackselection.C0718c;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: bg */
/* loaded from: classes.dex */
public final /* synthetic */ class C0556bg implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ int f7998a;

    public /* synthetic */ C0556bg(int i) {
        this.f7998a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Ordering reverse;
        Ordering ordering;
        int i = 9;
        int i2 = 8;
        int i3 = -1;
        switch (this.f7998a) {
            case 0:
                return ((Format) obj2).bitrate - ((Format) obj).bitrate;
            case 1:
                BaseUrl baseUrl = (BaseUrl) obj;
                BaseUrl baseUrl2 = (BaseUrl) obj2;
                int compare = Integer.compare(baseUrl.priority, baseUrl2.priority);
                if (compare == 0) {
                    return baseUrl.serviceLocation.compareTo(baseUrl2.serviceLocation);
                }
                return compare;
            case 2:
                return Integer.compare(((C1691pl) obj2).f25208b, ((C1691pl) obj).f25208b);
            case 3:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                Ordering ordering2 = DefaultTrackSelector.f11888j;
                if (num.intValue() == -1) {
                    if (num2.intValue() != -1) {
                        return -1;
                    }
                    return 0;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case 4:
                Ordering ordering3 = DefaultTrackSelector.f11888j;
                return 0;
            case 5:
                List list = (List) obj;
                List list2 = (List) obj2;
                return ComparisonChain.start().compare((C0718c) Collections.max(list, new C0556bg(i2)), (C0718c) Collections.max(list2, new C0556bg(i2)), new C0556bg(i2)).compare(list.size(), list2.size()).compare((C0718c) Collections.max(list, new C0556bg(i)), (C0718c) Collections.max(list2, new C0556bg(i)), new C0556bg(i)).result();
            case 6:
                return ((C0716a) Collections.max((List) obj)).compareTo((C0716a) Collections.max((List) obj2));
            case 7:
                return ((C0717b) ((List) obj).get(0)).compareTo((C0717b) ((List) obj2).get(0));
            case 8:
                C0718c c0718c = (C0718c) obj;
                C0718c c0718c2 = (C0718c) obj2;
                ComparisonChain compare2 = ComparisonChain.start().compareFalseFirst(c0718c.f11987h, c0718c2.f11987h).compare(c0718c.f11991l, c0718c2.f11991l).compareFalseFirst(c0718c.f11992m, c0718c2.f11992m).compareFalseFirst(c0718c.f11984e, c0718c2.f11984e).compareFalseFirst(c0718c.f11986g, c0718c2.f11986g).compare(Integer.valueOf(c0718c.f11990k), Integer.valueOf(c0718c2.f11990k), Ordering.natural().reverse());
                boolean z = c0718c2.f11995p;
                boolean z2 = c0718c.f11995p;
                ComparisonChain compareFalseFirst = compare2.compareFalseFirst(z2, z);
                boolean z3 = c0718c2.f11996q;
                boolean z4 = c0718c.f11996q;
                ComparisonChain compareFalseFirst2 = compareFalseFirst.compareFalseFirst(z4, z3);
                if (z2 && z4) {
                    compareFalseFirst2 = compareFalseFirst2.compare(c0718c.f11997r, c0718c2.f11997r);
                }
                return compareFalseFirst2.result();
            case 9:
                C0718c c0718c3 = (C0718c) obj;
                C0718c c0718c4 = (C0718c) obj2;
                if (c0718c3.f11984e && c0718c3.f11987h) {
                    reverse = DefaultTrackSelector.f11888j;
                } else {
                    reverse = DefaultTrackSelector.f11888j.reverse();
                }
                ComparisonChain start = ComparisonChain.start();
                int i4 = c0718c3.f11988i;
                Integer valueOf = Integer.valueOf(i4);
                Integer valueOf2 = Integer.valueOf(c0718c4.f11988i);
                if (c0718c3.f11985f.forceLowestBitrate) {
                    ordering = DefaultTrackSelector.f11888j.reverse();
                } else {
                    ordering = DefaultTrackSelector.f11889k;
                }
                return start.compare(valueOf, valueOf2, ordering).compare(Integer.valueOf(c0718c3.f11989j), Integer.valueOf(c0718c4.f11989j), reverse).compare(Integer.valueOf(i4), Integer.valueOf(c0718c4.f11988i), reverse).result();
            case 10:
                return Util.compareLong(((Download) obj).startTimeMs, ((Download) obj2).startTimeMs);
            case 11:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i5 = 0; i5 < bArr.length; i5++) {
                    byte b = bArr[i5];
                    byte b2 = bArr2[i5];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            case 12:
                return Integer.parseInt(((String) obj).split(":")[0]) - Integer.parseInt(((String) obj2).split(":")[0]);
            case 13:
                CacheSpan cacheSpan = (CacheSpan) obj;
                CacheSpan cacheSpan2 = (CacheSpan) obj2;
                long j = cacheSpan.lastTouchTimestamp;
                long j2 = cacheSpan2.lastTouchTimestamp;
                if (j - j2 == 0) {
                    return cacheSpan.compareTo(cacheSpan2);
                }
                if (j >= j2) {
                    i3 = 1;
                }
                return i3;
            case 14:
                g91 g91Var = (g91) obj;
                g91 g91Var2 = (g91) obj2;
                int i6 = g91Var.f17618c;
                int i7 = g91Var2.f17618c;
                if (i6 < i7) {
                    return -1;
                }
                if (i6 > i7) {
                    return 1;
                }
                return Integer.compare(g91Var2.f17619d, g91Var.f17619d);
            case 15:
                return ((sk2) obj).f26466a - ((sk2) obj2).f26466a;
            case 16:
                return Float.compare(((sk2) obj).f26468c, ((sk2) obj2).f26468c);
            case 17:
                SlowMotionData.Segment segment = (SlowMotionData.Segment) obj;
                SlowMotionData.Segment segment2 = (SlowMotionData.Segment) obj2;
                return ComparisonChain.start().compare(segment.startTimeMs, segment2.startTimeMs).compare(segment.endTimeMs, segment2.endTimeMs).compare(segment.speedDivisor, segment2.speedDivisor).result();
            case 18:
                wl2 wl2Var = (wl2) obj;
                wl2 wl2Var2 = (wl2) obj2;
                int compare3 = Integer.compare(wl2Var2.f28229b, wl2Var.f28229b);
                if (compare3 == 0) {
                    int compareTo = wl2Var.f28230c.compareTo(wl2Var2.f28230c);
                    if (compareTo == 0) {
                        return wl2Var.f28231d.compareTo(wl2Var2.f28231d);
                    }
                    return compareTo;
                }
                return compare3;
            case 19:
                wl2 wl2Var3 = (wl2) obj;
                wl2 wl2Var4 = (wl2) obj2;
                int compare4 = Integer.compare(wl2Var4.f28228a, wl2Var3.f28228a);
                if (compare4 == 0) {
                    int compareTo2 = wl2Var4.f28230c.compareTo(wl2Var3.f28230c);
                    if (compareTo2 == 0) {
                        return wl2Var4.f28231d.compareTo(wl2Var3.f28231d);
                    }
                    return compareTo2;
                }
                return compare4;
            case 20:
                return Integer.compare(((z43) obj).f29247a.f47b, ((z43) obj2).f29247a.f47b);
            default:
                return Long.compare(((WebvttCueInfo) obj).startTimeUs, ((WebvttCueInfo) obj2).startTimeUs);
        }
    }
}
