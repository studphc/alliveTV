package com.google.android.exoplayer2.source;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class MaskingMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: k */
    public final MediaSource f10969k;

    /* renamed from: l */
    public final boolean f10970l;

    /* renamed from: m */
    public final Timeline.Window f10971m;

    /* renamed from: n */
    public final Timeline.Period f10972n;

    /* renamed from: o */
    public C0699h f10973o;

    /* renamed from: p */
    public MaskingMediaPeriod f10974p;

    /* renamed from: q */
    public boolean f10975q;

    /* renamed from: r */
    public boolean f10976r;

    /* renamed from: s */
    public boolean f10977s;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class PlaceholderTimeline extends Timeline {

        /* renamed from: a */
        public final MediaItem f10978a;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.f10978a = mediaItem;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            if (obj == C0699h.f11372c) {
                return 0;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Integer num;
            Object obj = null;
            if (z) {
                num = 0;
            } else {
                num = null;
            }
            if (z) {
                obj = C0699h.f11372c;
            }
            period.set(num, obj, 0, C0643C.TIME_UNSET, 0L, AdPlaybackState.NONE, true);
            return period;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int i) {
            return C0699h.f11372c;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.f10978a, null, C0643C.TIME_UNSET, C0643C.TIME_UNSET, C0643C.TIME_UNSET, false, true, null, 0L, C0643C.TIME_UNSET, 0, 0, 0L);
            window.isPlaceholder = true;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z) {
        boolean z2;
        this.f10969k = mediaSource;
        if (z && mediaSource.isSingleWindow()) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f10970l = z2;
        this.f10971m = new Timeline.Window();
        this.f10972n = new Timeline.Period();
        Timeline initialTimeline = mediaSource.getInitialTimeline();
        if (initialTimeline != null) {
            this.f10973o = new C0699h(initialTimeline, null, null);
            this.f10977s = true;
        } else {
            this.f10973o = new C0699h(new PlaceholderTimeline(mediaSource.getMediaItem()), Timeline.Window.SINGLE_WINDOW_UID, C0699h.f11372c);
        }
    }

    /* renamed from: a */
    public final void m2740a(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.f10974p;
        int indexOfPeriod = this.f10973o.getIndexOfPeriod(maskingMediaPeriod.f10968id.periodUid);
        if (indexOfPeriod == -1) {
            return;
        }
        long j2 = this.f10973o.getPeriod(indexOfPeriod, this.f10972n).durationUs;
        if (j2 != C0643C.TIME_UNSET && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.overridePreparePositionUs(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f10969k.getMediaItem();
    }

    public Timeline getTimeline() {
        return this.f10973o;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        if (!this.f10970l) {
            this.f10975q = true;
            prepareChildSource(null, this.f10969k);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.f10974p) {
            this.f10974p = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.f10976r = false;
        this.f10975q = false;
        super.releaseSourceInternal();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
        MediaSource mediaSource = this.f10969k;
        maskingMediaPeriod.setMediaSource(mediaSource);
        if (this.f10976r) {
            Object obj = mediaPeriodId.periodUid;
            if (this.f10973o.f11374b != null && obj.equals(C0699h.f11372c)) {
                obj = this.f10973o.f11374b;
            }
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(obj));
        } else {
            this.f10974p = maskingMediaPeriod;
            if (!this.f10975q) {
                this.f10975q = true;
                prepareChildSource(null, mediaSource);
            }
        }
        return maskingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void r2, MediaSource.MediaPeriodId mediaPeriodId) {
        Object obj = mediaPeriodId.periodUid;
        Object obj2 = this.f10973o.f11374b;
        if (obj2 != null && obj2.equals(obj)) {
            obj = C0699h.f11372c;
        }
        return mediaPeriodId.copyWithPeriodUid(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00d4  */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onChildSourceInfoRefreshed(Void r11, MediaSource mediaSource, Timeline timeline) {
        long j;
        C0699h c0699h;
        MaskingMediaPeriod maskingMediaPeriod;
        MediaSource.MediaPeriodId copyWithPeriodUid;
        C0699h c0699h2;
        if (this.f10976r) {
            C0699h c0699h3 = this.f10973o;
            this.f10973o = new C0699h(timeline, c0699h3.f11373a, c0699h3.f11374b);
            MaskingMediaPeriod maskingMediaPeriod2 = this.f10974p;
            if (maskingMediaPeriod2 != null) {
                m2740a(maskingMediaPeriod2.getPreparePositionOverrideUs());
            }
        } else if (timeline.isEmpty()) {
            if (this.f10977s) {
                C0699h c0699h4 = this.f10973o;
                c0699h2 = new C0699h(timeline, c0699h4.f11373a, c0699h4.f11374b);
            } else {
                c0699h2 = new C0699h(timeline, Timeline.Window.SINGLE_WINDOW_UID, C0699h.f11372c);
            }
            this.f10973o = c0699h2;
        } else {
            Timeline.Window window = this.f10971m;
            timeline.getWindow(0, window);
            long defaultPositionUs = window.getDefaultPositionUs();
            Object obj = window.uid;
            MaskingMediaPeriod maskingMediaPeriod3 = this.f10974p;
            if (maskingMediaPeriod3 != null) {
                long preparePositionUs = maskingMediaPeriod3.getPreparePositionUs();
                C0699h c0699h5 = this.f10973o;
                Object obj2 = this.f10974p.f10968id.periodUid;
                Timeline.Period period = this.f10972n;
                c0699h5.getPeriodByUid(obj2, period);
                long positionInWindowUs = period.getPositionInWindowUs() + preparePositionUs;
                if (positionInWindowUs != this.f10973o.getWindow(0, window).getDefaultPositionUs()) {
                    j = positionInWindowUs;
                    Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.f10971m, this.f10972n, 0, j);
                    Object obj3 = periodPositionUs.first;
                    long longValue = ((Long) periodPositionUs.second).longValue();
                    if (!this.f10977s) {
                        C0699h c0699h6 = this.f10973o;
                        c0699h = new C0699h(timeline, c0699h6.f11373a, c0699h6.f11374b);
                    } else {
                        c0699h = new C0699h(timeline, obj, obj3);
                    }
                    this.f10973o = c0699h;
                    maskingMediaPeriod = this.f10974p;
                    if (maskingMediaPeriod != null) {
                        m2740a(longValue);
                        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.f10968id;
                        Object obj4 = mediaPeriodId.periodUid;
                        if (this.f10973o.f11374b != null && obj4.equals(C0699h.f11372c)) {
                            obj4 = this.f10973o.f11374b;
                        }
                        copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(obj4);
                        this.f10977s = true;
                        this.f10976r = true;
                        refreshSourceInfo(this.f10973o);
                        if (copyWithPeriodUid == null) {
                            ((MaskingMediaPeriod) Assertions.checkNotNull(this.f10974p)).createPeriod(copyWithPeriodUid);
                            return;
                        }
                        return;
                    }
                }
            }
            j = defaultPositionUs;
            Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(this.f10971m, this.f10972n, 0, j);
            Object obj32 = periodPositionUs2.first;
            long longValue2 = ((Long) periodPositionUs2.second).longValue();
            if (!this.f10977s) {
            }
            this.f10973o = c0699h;
            maskingMediaPeriod = this.f10974p;
            if (maskingMediaPeriod != null) {
            }
        }
        copyWithPeriodUid = null;
        this.f10977s = true;
        this.f10976r = true;
        refreshSourceInfo(this.f10973o);
        if (copyWithPeriodUid == null) {
        }
    }
}
