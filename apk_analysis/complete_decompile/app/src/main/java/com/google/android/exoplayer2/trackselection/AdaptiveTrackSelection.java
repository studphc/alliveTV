package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_HEIGHT_TO_DISCARD = 719;
    public static final int DEFAULT_MAX_WIDTH_TO_DISCARD = 1279;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;

    /* renamed from: e */
    public final BandwidthMeter f11861e;

    /* renamed from: f */
    public final long f11862f;

    /* renamed from: g */
    public final long f11863g;

    /* renamed from: h */
    public final long f11864h;

    /* renamed from: i */
    public final int f11865i;

    /* renamed from: j */
    public final int f11866j;

    /* renamed from: k */
    public final float f11867k;

    /* renamed from: l */
    public final float f11868l;

    /* renamed from: m */
    public final ImmutableList f11869m;

    /* renamed from: n */
    public final Clock f11870n;

    /* renamed from: o */
    public float f11871o;

    /* renamed from: p */
    public int f11872p;

    /* renamed from: q */
    public int f11873q;

    /* renamed from: r */
    public long f11874r;

    /* renamed from: s */
    public MediaChunk f11875s;

    /* loaded from: classes.dex */
    public static final class AdaptationCheckpoint {
        public final long allocatedBandwidth;
        public final long totalBandwidth;

        public AdaptationCheckpoint(long j, long j2) {
            this.totalBandwidth = j;
            this.allocatedBandwidth = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            if (this.totalBandwidth == adaptationCheckpoint.totalBandwidth && this.allocatedBandwidth == adaptationCheckpoint.allocatedBandwidth) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.totalBandwidth) * 31) + ((int) this.allocatedBandwidth);
        }
    }

    /* loaded from: classes.dex */
    public static class Factory implements ExoTrackSelection.Factory {

        /* renamed from: a */
        public final int f11876a;

        /* renamed from: b */
        public final int f11877b;

        /* renamed from: c */
        public final int f11878c;

        /* renamed from: d */
        public final int f11879d;

        /* renamed from: e */
        public final int f11880e;

        /* renamed from: f */
        public final float f11881f;

        /* renamed from: g */
        public final float f11882g;

        /* renamed from: h */
        public final Clock f11883h;

        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }

        public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter, ImmutableList<AdaptationCheckpoint> immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i, bandwidthMeter, this.f11876a, this.f11877b, this.f11878c, this.f11879d, this.f11880e, this.f11881f, this.f11882g, immutableList, this.f11883h);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.Factory
        public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            int i;
            ExoTrackSelection createAdaptiveTrackSelection;
            ImmutableList build;
            Multimap multimap;
            double d;
            long j;
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = 1;
                if (i3 >= definitionArr.length) {
                    break;
                }
                ExoTrackSelection.Definition definition = definitionArr[i3];
                if (definition != null && definition.tracks.length > 1) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    builder.add((ImmutableList.Builder) new AdaptationCheckpoint(0L, 0L));
                    arrayList.add(builder);
                } else {
                    arrayList.add(null);
                }
                i3++;
            }
            int length = definitionArr.length;
            long[][] jArr = new long[length];
            for (int i4 = 0; i4 < definitionArr.length; i4++) {
                ExoTrackSelection.Definition definition2 = definitionArr[i4];
                if (definition2 == null) {
                    jArr[i4] = new long[0];
                } else {
                    jArr[i4] = new long[definition2.tracks.length];
                    int i5 = 0;
                    while (true) {
                        if (i5 >= definition2.tracks.length) {
                            break;
                        }
                        jArr[i4][i5] = definition2.group.getFormat(r11[i5]).bitrate;
                        i5++;
                    }
                    Arrays.sort(jArr[i4]);
                }
            }
            int[] iArr = new int[length];
            long[] jArr2 = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                long[] jArr3 = jArr[i6];
                if (jArr3.length == 0) {
                    j = 0;
                } else {
                    j = jArr3[0];
                }
                jArr2[i6] = j;
            }
            AdaptiveTrackSelection.m2875a(arrayList, jArr2);
            Multimap build2 = MultimapBuilder.treeKeys().arrayListValues().build();
            int i7 = 0;
            while (i7 < length) {
                long[] jArr4 = jArr[i7];
                if (jArr4.length <= i) {
                    multimap = build2;
                } else {
                    int length2 = jArr4.length;
                    double[] dArr = new double[length2];
                    int i8 = i2;
                    while (true) {
                        long[] jArr5 = jArr[i7];
                        double d2 = 0.0d;
                        if (i8 >= jArr5.length) {
                            break;
                        }
                        Multimap multimap2 = build2;
                        long j2 = jArr5[i8];
                        if (j2 != -1) {
                            d2 = Math.log(j2);
                        }
                        dArr[i8] = d2;
                        i8++;
                        build2 = multimap2;
                    }
                    Multimap multimap3 = build2;
                    int i9 = length2 - 1;
                    double d3 = dArr[i9] - dArr[i2];
                    int i10 = i2;
                    while (i10 < i9) {
                        double d4 = dArr[i10];
                        i10++;
                        double d5 = (d4 + dArr[i10]) * 0.5d;
                        if (d3 == 0.0d) {
                            d = 1.0d;
                        } else {
                            d = (d5 - dArr[i2]) / d3;
                        }
                        multimap3.put(Double.valueOf(d), Integer.valueOf(i7));
                        i2 = 0;
                    }
                    multimap = multimap3;
                }
                i7++;
                build2 = multimap;
                i2 = 0;
                i = 1;
            }
            ImmutableList copyOf = ImmutableList.copyOf(build2.values());
            for (int i11 = 0; i11 < copyOf.size(); i11++) {
                int intValue = ((Integer) copyOf.get(i11)).intValue();
                int i12 = iArr[intValue] + 1;
                iArr[intValue] = i12;
                jArr2[intValue] = jArr[intValue][i12];
                AdaptiveTrackSelection.m2875a(arrayList, jArr2);
            }
            for (int i13 = 0; i13 < definitionArr.length; i13++) {
                if (arrayList.get(i13) != null) {
                    jArr2[i13] = jArr2[i13] * 2;
                }
            }
            AdaptiveTrackSelection.m2875a(arrayList, jArr2);
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i14 = 0; i14 < arrayList.size(); i14++) {
                ImmutableList.Builder builder3 = (ImmutableList.Builder) arrayList.get(i14);
                if (builder3 == null) {
                    build = ImmutableList.m3902of();
                } else {
                    build = builder3.build();
                }
                builder2.add((ImmutableList.Builder) build);
            }
            ImmutableList build3 = builder2.build();
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
            for (int i15 = 0; i15 < definitionArr.length; i15++) {
                ExoTrackSelection.Definition definition3 = definitionArr[i15];
                if (definition3 != null) {
                    int[] iArr2 = definition3.tracks;
                    if (iArr2.length != 0) {
                        if (iArr2.length == 1) {
                            createAdaptiveTrackSelection = new FixedTrackSelection(definition3.group, iArr2[0], definition3.type);
                        } else {
                            createAdaptiveTrackSelection = createAdaptiveTrackSelection(definition3.group, iArr2, definition3.type, bandwidthMeter, (ImmutableList) build3.get(i15));
                        }
                        exoTrackSelectionArr[i15] = createAdaptiveTrackSelection;
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        public Factory(int i, int i2, int i3, float f) {
            this(i, i2, i3, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, int i4, int i5, float f) {
            this(i, i2, i3, i4, i5, f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f, float f2, Clock clock) {
            this(i, i2, i3, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, f2, clock);
        }

        public Factory(int i, int i2, int i3, int i4, int i5, float f, float f2, Clock clock) {
            this.f11876a = i;
            this.f11877b = i2;
            this.f11878c = i3;
            this.f11879d = i4;
            this.f11880e = i5;
            this.f11881f = f;
            this.f11882g = f2;
            this.f11883h = clock;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, 0, bandwidthMeter, 10000L, 25000L, 25000L, DEFAULT_MAX_WIDTH_TO_DISCARD, DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, ImmutableList.m3902of(), Clock.DEFAULT);
    }

    /* renamed from: a */
    public static void m2875a(ArrayList arrayList, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ImmutableList.Builder builder = (ImmutableList.Builder) arrayList.get(i);
            if (builder != null) {
                builder.add((ImmutableList.Builder) new AdaptationCheckpoint(j, jArr[i]));
            }
        }
    }

    /* renamed from: c */
    public static long m2876c(List list) {
        if (list.isEmpty()) {
            return C0643C.TIME_UNSET;
        }
        MediaChunk mediaChunk = (MediaChunk) Iterables.getLast(list);
        long j = mediaChunk.startTimeUs;
        if (j == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        long j2 = mediaChunk.endTimeUs;
        if (j2 == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        return j2 - j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final int m2877b(long j, long j2) {
        long j3;
        BandwidthMeter bandwidthMeter = this.f11861e;
        long bitrateEstimate = ((float) bandwidthMeter.getBitrateEstimate()) * this.f11867k;
        long timeToFirstByteEstimateUs = bandwidthMeter.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs != C0643C.TIME_UNSET && j2 != C0643C.TIME_UNSET) {
            float f = (float) j2;
            j3 = (((float) bitrateEstimate) * Math.max((f / this.f11871o) - ((float) timeToFirstByteEstimateUs), RecyclerView.f7068F0)) / f;
        } else {
            j3 = ((float) bitrateEstimate) / this.f11871o;
        }
        ImmutableList immutableList = this.f11869m;
        if (!immutableList.isEmpty()) {
            int i = 1;
            while (i < immutableList.size() - 1 && ((AdaptationCheckpoint) immutableList.get(i)).totalBandwidth < j3) {
                i++;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) immutableList.get(i - 1);
            AdaptationCheckpoint adaptationCheckpoint2 = (AdaptationCheckpoint) immutableList.get(i);
            long j4 = adaptationCheckpoint.totalBandwidth;
            float f2 = ((float) (j3 - j4)) / ((float) (adaptationCheckpoint2.totalBandwidth - j4));
            j3 = (f2 * ((float) (adaptationCheckpoint2.allocatedBandwidth - r1))) + adaptationCheckpoint.allocatedBandwidth;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.length; i3++) {
            if (j == Long.MIN_VALUE || !isBlacklisted(i3, j)) {
                Format format = getFormat(i3);
                if (canSelectFormat(format, format.bitrate, j3)) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public boolean canSelectFormat(Format format, int i, long j) {
        return ((long) i) <= j;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @CallSuper
    public void disable() {
        this.f11875s = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @CallSuper
    public void enable() {
        this.f11874r = C0643C.TIME_UNSET;
        this.f11875s = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        MediaChunk mediaChunk;
        int i;
        int i2;
        long elapsedRealtime = this.f11870n.elapsedRealtime();
        if (!shouldEvaluateQueueSize(elapsedRealtime, list)) {
            return list.size();
        }
        this.f11874r = elapsedRealtime;
        if (list.isEmpty()) {
            mediaChunk = null;
        } else {
            mediaChunk = (MediaChunk) Iterables.getLast(list);
        }
        this.f11875s = mediaChunk;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(list.get(size - 1).startTimeUs - j, this.f11871o);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(m2877b(elapsedRealtime, m2876c(list)));
        for (int i3 = 0; i3 < size; i3++) {
            MediaChunk mediaChunk2 = list.get(i3);
            Format format2 = mediaChunk2.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk2.startTimeUs - j, this.f11871o) >= minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i = format2.height) != -1 && i <= this.f11866j && (i2 = format2.width) != -1 && i2 <= this.f11865i && i < format.height) {
                return i3;
            }
        }
        return size;
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.f11864h;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return this.f11872p;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return this.f11873q;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f) {
        this.f11871o = f;
    }

    public boolean shouldEvaluateQueueSize(long j, List<? extends MediaChunk> list) {
        long j2 = this.f11874r;
        if (j2 != C0643C.TIME_UNSET && j - j2 < 1000 && (list.isEmpty() || ((MediaChunk) Iterables.getLast(list)).equals(this.f11875s))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long m2876c;
        long chunkEndTimeUs;
        long chunkStartTimeUs;
        int i;
        int indexOf;
        long j4;
        long elapsedRealtime = this.f11870n.elapsedRealtime();
        int i2 = this.f11872p;
        if (i2 < mediaChunkIteratorArr.length && mediaChunkIteratorArr[i2].next()) {
            MediaChunkIterator mediaChunkIterator = mediaChunkIteratorArr[this.f11872p];
            chunkEndTimeUs = mediaChunkIterator.getChunkEndTimeUs();
            chunkStartTimeUs = mediaChunkIterator.getChunkStartTimeUs();
        } else {
            for (MediaChunkIterator mediaChunkIterator2 : mediaChunkIteratorArr) {
                if (mediaChunkIterator2.next()) {
                    chunkEndTimeUs = mediaChunkIterator2.getChunkEndTimeUs();
                    chunkStartTimeUs = mediaChunkIterator2.getChunkStartTimeUs();
                }
            }
            m2876c = m2876c(list);
            i = this.f11873q;
            if (i != 0) {
                this.f11873q = 1;
                this.f11872p = m2877b(elapsedRealtime, m2876c);
                return;
            }
            int i3 = this.f11872p;
            if (list.isEmpty()) {
                indexOf = -1;
            } else {
                indexOf = indexOf(((MediaChunk) Iterables.getLast(list)).trackFormat);
            }
            if (indexOf != -1) {
                i = ((MediaChunk) Iterables.getLast(list)).trackSelectionReason;
                i3 = indexOf;
            }
            int m2877b = m2877b(elapsedRealtime, m2876c);
            if (!isBlacklisted(i3, elapsedRealtime)) {
                Format format = getFormat(i3);
                Format format2 = getFormat(m2877b);
                long j5 = this.f11862f;
                if (j3 != C0643C.TIME_UNSET) {
                    if (m2876c != C0643C.TIME_UNSET) {
                        j4 = j3 - m2876c;
                    } else {
                        j4 = j3;
                    }
                    j5 = Math.min(((float) j4) * this.f11868l, j5);
                }
                int i4 = format2.bitrate;
                int i5 = format.bitrate;
                if ((i4 > i5 && j2 < j5) || (i4 < i5 && j2 >= this.f11863g)) {
                    m2877b = i3;
                }
            }
            if (m2877b != i3) {
                i = 3;
            }
            this.f11873q = i;
            this.f11872p = m2877b;
            return;
        }
        m2876c = chunkEndTimeUs - chunkStartTimeUs;
        i = this.f11873q;
        if (i != 0) {
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter, long j, long j2, long j3, int i2, int i3, float f, float f2, List<AdaptationCheckpoint> list, Clock clock) {
        super(trackGroup, iArr, i);
        BandwidthMeter bandwidthMeter2;
        long j4;
        if (j3 < j) {
            Log.m3027w("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            bandwidthMeter2 = bandwidthMeter;
            j4 = j;
        } else {
            bandwidthMeter2 = bandwidthMeter;
            j4 = j3;
        }
        this.f11861e = bandwidthMeter2;
        this.f11862f = j * 1000;
        this.f11863g = j2 * 1000;
        this.f11864h = j4 * 1000;
        this.f11865i = i2;
        this.f11866j = i3;
        this.f11867k = f;
        this.f11868l = f2;
        this.f11869m = ImmutableList.copyOf((Collection) list);
        this.f11870n = clock;
        this.f11871o = 1.0f;
        this.f11873q = 0;
        this.f11874r = C0643C.TIME_UNSET;
    }
}
