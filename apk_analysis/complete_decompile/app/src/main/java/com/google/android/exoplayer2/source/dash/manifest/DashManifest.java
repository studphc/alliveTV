package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class DashManifest implements FilterableManifest<DashManifest> {

    /* renamed from: a */
    public final List f11318a;
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;

    @Nullable
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;

    @Nullable
    public final ProgramInformation programInformation;
    public final long publishTimeMs;

    @Nullable
    public final ServiceDescriptionElement serviceDescription;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;

    @Nullable
    public final UtcTimingElement utcTiming;

    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable ProgramInformation programInformation, @Nullable UtcTimingElement utcTimingElement, @Nullable ServiceDescriptionElement serviceDescriptionElement, @Nullable Uri uri, List<Period> list) {
        List<Period> list2;
        this.availabilityStartTimeMs = j;
        this.durationMs = j2;
        this.minBufferTimeMs = j3;
        this.dynamic = z;
        this.minUpdatePeriodMs = j4;
        this.timeShiftBufferDepthMs = j5;
        this.suggestedPresentationDelayMs = j6;
        this.publishTimeMs = j7;
        this.programInformation = programInformation;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.serviceDescription = serviceDescriptionElement;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = list;
        }
        this.f11318a = list2;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ DashManifest copy(List list) {
        return copy((List<StreamKey>) list);
    }

    public final Period getPeriod(int i) {
        return (Period) this.f11318a.get(i);
    }

    public final int getPeriodCount() {
        return this.f11318a.size();
    }

    public final long getPeriodDurationMs(int i) {
        long j;
        long j2;
        List list = this.f11318a;
        if (i == list.size() - 1) {
            j = this.durationMs;
            if (j == C0643C.TIME_UNSET) {
                return C0643C.TIME_UNSET;
            }
            j2 = ((Period) list.get(i)).startMs;
        } else {
            j = ((Period) list.get(i + 1)).startMs;
            j2 = ((Period) list.get(i)).startMs;
        }
        return j - j2;
    }

    public final long getPeriodDurationUs(int i) {
        return Util.msToUs(getPeriodDurationMs(i));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final DashManifest copy(List<StreamKey> list) {
        long j;
        DashManifest dashManifest = this;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        int i = 0;
        while (true) {
            int periodCount = getPeriodCount();
            j = C0643C.TIME_UNSET;
            if (i >= periodCount) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i) {
                long periodDurationMs = dashManifest.getPeriodDurationMs(i);
                if (periodDurationMs != C0643C.TIME_UNSET) {
                    j2 += periodDurationMs;
                }
            } else {
                Period period = dashManifest.getPeriod(i);
                List<AdaptationSet> list2 = period.adaptationSets;
                StreamKey streamKey = (StreamKey) linkedList.poll();
                int i2 = streamKey.periodIndex;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i3 = streamKey.groupIndex;
                    AdaptationSet adaptationSet = list2.get(i3);
                    List<Representation> list3 = adaptationSet.representations;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add(list3.get(streamKey.streamIndex));
                        streamKey = (StreamKey) linkedList.poll();
                        if (streamKey.periodIndex != i2) {
                            break;
                        }
                    } while (streamKey.groupIndex == i3);
                    List<AdaptationSet> list4 = list2;
                    arrayList2.add(new AdaptationSet(adaptationSet.f11317id, adaptationSet.type, arrayList3, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
                    if (streamKey.periodIndex != i2) {
                        break;
                    }
                    list2 = list4;
                }
                linkedList.addFirst(streamKey);
                arrayList.add(new Period(period.f11325id, period.startMs - j2, arrayList2, period.eventStreams));
            }
            i++;
            dashManifest = this;
        }
        long j3 = dashManifest.durationMs;
        if (j3 != C0643C.TIME_UNSET) {
            j = j3 - j2;
        }
        return new DashManifest(dashManifest.availabilityStartTimeMs, j, dashManifest.minBufferTimeMs, dashManifest.dynamic, dashManifest.minUpdatePeriodMs, dashManifest.timeShiftBufferDepthMs, dashManifest.suggestedPresentationDelayMs, dashManifest.publishTimeMs, dashManifest.programInformation, dashManifest.utcTiming, dashManifest.serviceDescription, dashManifest.location, arrayList);
    }
}
