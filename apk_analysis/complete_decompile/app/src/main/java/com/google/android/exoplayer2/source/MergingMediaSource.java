package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000.nn1;

/* loaded from: classes.dex */
public final class MergingMediaSource extends CompositeMediaSource<Integer> {

    /* renamed from: v */
    public static final MediaItem f10985v = new MediaItem.Builder().setMediaId("MergingMediaSource").build();

    /* renamed from: k */
    public final boolean f10986k;

    /* renamed from: l */
    public final boolean f10987l;

    /* renamed from: m */
    public final MediaSource[] f10988m;

    /* renamed from: n */
    public final Timeline[] f10989n;

    /* renamed from: o */
    public final ArrayList f10990o;

    /* renamed from: p */
    public final CompositeSequenceableLoaderFactory f10991p;

    /* renamed from: q */
    public final HashMap f10992q;

    /* renamed from: r */
    public final ListMultimap f10993r;

    /* renamed from: s */
    public int f10994s;

    /* renamed from: t */
    public long[][] f10995t;

    /* renamed from: u */
    public IllegalMergeException f10996u;

    /* loaded from: classes.dex */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MediaSource[] mediaSourceArr = this.f10988m;
        int length = mediaSourceArr.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        Timeline[] timelineArr = this.f10989n;
        int indexOfPeriod = timelineArr[0].getIndexOfPeriod(mediaPeriodId.periodUid);
        for (int i = 0; i < length; i++) {
            mediaPeriodArr[i] = mediaSourceArr[i].createPeriod(mediaPeriodId.copyWithPeriodUid(timelineArr[i].getUidOfPeriod(indexOfPeriod)), allocator, j - this.f10995t[indexOfPeriod][i]);
        }
        C0706l c0706l = new C0706l(this.f10991p, this.f10995t[indexOfPeriod], mediaPeriodArr);
        if (this.f10987l) {
            ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(c0706l, true, 0L, ((Long) Assertions.checkNotNull((Long) this.f10992q.get(mediaPeriodId.periodUid))).longValue());
            this.f10993r.put(mediaPeriodId.periodUid, clippingMediaPeriod);
            return clippingMediaPeriod;
        }
        return c0706l;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        MediaSource[] mediaSourceArr = this.f10988m;
        if (mediaSourceArr.length > 0) {
            return mediaSourceArr[0].getMediaItem();
        }
        return f10985v;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        IllegalMergeException illegalMergeException = this.f10996u;
        if (illegalMergeException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalMergeException;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f10988m;
            if (i < mediaSourceArr.length) {
                prepareChildSource(Integer.valueOf(i), mediaSourceArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        if (this.f10987l) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            ListMultimap listMultimap = this.f10993r;
            Iterator it = listMultimap.entries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((ClippingMediaPeriod) entry.getValue()).equals(clippingMediaPeriod)) {
                    listMultimap.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.mediaPeriod;
        }
        C0706l c0706l = (C0706l) mediaPeriod;
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f10988m;
            if (i < mediaSourceArr.length) {
                MediaSource mediaSource = mediaSourceArr[i];
                MediaPeriod mediaPeriod2 = c0706l.f11537a[i];
                if (mediaPeriod2 instanceof C0705k) {
                    mediaPeriod2 = ((C0705k) mediaPeriod2).f11534a;
                }
                mediaSource.releasePeriod(mediaPeriod2);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.f10989n, (Object) null);
        this.f10994s = -1;
        this.f10996u = null;
        ArrayList arrayList = this.f10990o;
        arrayList.clear();
        Collections.addAll(arrayList, this.f10988m);
    }

    public MergingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, false, mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Integer num, MediaSource mediaSource, Timeline timeline) {
        HashMap hashMap;
        if (this.f10996u != null) {
            return;
        }
        if (this.f10994s == -1) {
            this.f10994s = timeline.getPeriodCount();
        } else if (timeline.getPeriodCount() != this.f10994s) {
            this.f10996u = new IllegalMergeException(0);
            return;
        }
        int length = this.f10995t.length;
        Timeline[] timelineArr = this.f10989n;
        if (length == 0) {
            this.f10995t = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f10994s, timelineArr.length);
        }
        ArrayList arrayList = this.f10990o;
        arrayList.remove(mediaSource);
        timelineArr[num.intValue()] = timeline;
        if (arrayList.isEmpty()) {
            if (this.f10986k) {
                Timeline.Period period = new Timeline.Period();
                for (int i = 0; i < this.f10994s; i++) {
                    long j = -timelineArr[0].getPeriod(i, period).getPositionInWindowUs();
                    for (int i2 = 1; i2 < timelineArr.length; i2++) {
                        this.f10995t[i][i2] = j - (-timelineArr[i2].getPeriod(i, period).getPositionInWindowUs());
                    }
                }
            }
            Timeline timeline2 = timelineArr[0];
            if (this.f10987l) {
                Timeline.Period period2 = new Timeline.Period();
                int i3 = 0;
                while (true) {
                    int i4 = this.f10994s;
                    hashMap = this.f10992q;
                    if (i3 >= i4) {
                        break;
                    }
                    long j2 = Long.MIN_VALUE;
                    for (int i5 = 0; i5 < timelineArr.length; i5++) {
                        long durationUs = timelineArr[i5].getPeriod(i3, period2).getDurationUs();
                        if (durationUs != C0643C.TIME_UNSET) {
                            long j3 = durationUs + this.f10995t[i3][i5];
                            if (j2 == Long.MIN_VALUE || j3 < j2) {
                                j2 = j3;
                            }
                        }
                    }
                    Object uidOfPeriod = timelineArr[0].getUidOfPeriod(i3);
                    hashMap.put(uidOfPeriod, Long.valueOf(j2));
                    Iterator it = this.f10993r.get((ListMultimap) uidOfPeriod).iterator();
                    while (it.hasNext()) {
                        ((ClippingMediaPeriod) it.next()).updateClipping(0L, j2);
                    }
                    i3++;
                }
                timeline2 = new nn1(timeline2, hashMap);
            }
            refreshSourceInfo(timeline2);
        }
    }

    public MergingMediaSource(boolean z, boolean z2, MediaSource... mediaSourceArr) {
        this(z, z2, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z, boolean z2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.f10986k = z;
        this.f10987l = z2;
        this.f10988m = mediaSourceArr;
        this.f10991p = compositeSequenceableLoaderFactory;
        this.f10990o = new ArrayList(Arrays.asList(mediaSourceArr));
        this.f10994s = -1;
        this.f10989n = new Timeline[mediaSourceArr.length];
        this.f10995t = new long[0];
        this.f10992q = new HashMap();
        this.f10993r = MultimapBuilder.hashKeys().arrayListValues().build();
    }
}
