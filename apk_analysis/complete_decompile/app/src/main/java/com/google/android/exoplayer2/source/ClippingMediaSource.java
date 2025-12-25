package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ClippingMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: k */
    public final MediaSource f10915k;

    /* renamed from: l */
    public final long f10916l;

    /* renamed from: m */
    public final long f10917m;

    /* renamed from: n */
    public final boolean f10918n;

    /* renamed from: o */
    public final boolean f10919o;

    /* renamed from: p */
    public final boolean f10920p;

    /* renamed from: q */
    public final ArrayList f10921q;

    /* renamed from: r */
    public final Timeline.Window f10922r;

    /* renamed from: s */
    public C0686a f10923s;

    /* renamed from: t */
    public IllegalClippingException f10924t;

    /* renamed from: u */
    public long f10925u;

    /* renamed from: v */
    public long f10926v;

    /* loaded from: classes.dex */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface Reason {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public IllegalClippingException(int i) {
            super("Illegal clipping: ".concat(r0));
            String str;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        str = EnvironmentCompat.MEDIA_UNKNOWN;
                    } else {
                        str = "start exceeds end";
                    }
                } else {
                    str = "not seekable to start";
                }
            } else {
                str = "invalid period count";
            }
            this.reason = i;
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2) {
        this(mediaSource, j, j2, true, false, false);
    }

    /* renamed from: a */
    public final void m2727a(Timeline timeline) {
        long j;
        long j2;
        long j3;
        Timeline.Window window = this.f10922r;
        timeline.getWindow(0, window);
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs();
        C0686a c0686a = this.f10923s;
        ArrayList arrayList = this.f10921q;
        long j4 = this.f10917m;
        long j5 = Long.MIN_VALUE;
        if (c0686a != null && !arrayList.isEmpty() && !this.f10919o) {
            long j6 = this.f10925u - positionInFirstPeriodUs;
            if (j4 != Long.MIN_VALUE) {
                j5 = this.f10926v - positionInFirstPeriodUs;
            }
            j3 = j5;
            j2 = j6;
        } else {
            boolean z = this.f10920p;
            long j7 = this.f10916l;
            if (z) {
                long defaultPositionUs = window.getDefaultPositionUs();
                j7 += defaultPositionUs;
                j = defaultPositionUs + j4;
            } else {
                j = j4;
            }
            this.f10925u = positionInFirstPeriodUs + j7;
            if (j4 != Long.MIN_VALUE) {
                j5 = positionInFirstPeriodUs + j;
            }
            this.f10926v = j5;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ClippingMediaPeriod) arrayList.get(i)).updateClipping(this.f10925u, this.f10926v);
            }
            j2 = j7;
            j3 = j;
        }
        try {
            C0686a c0686a2 = new C0686a(timeline, j2, j3);
            this.f10923s = c0686a2;
            refreshSourceInfo(c0686a2);
        } catch (IllegalClippingException e) {
            this.f10924t = e;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((ClippingMediaPeriod) arrayList.get(i2)).setClippingError(this.f10924t);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.f10915k.createPeriod(mediaPeriodId, allocator, j), this.f10918n, this.f10925u, this.f10926v);
        this.f10921q.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f10915k.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        IllegalClippingException illegalClippingException = this.f10924t;
        if (illegalClippingException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalClippingException;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.f10915k);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ArrayList arrayList = this.f10921q;
        Assertions.checkState(arrayList.remove(mediaPeriod));
        this.f10915k.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (arrayList.isEmpty() && !this.f10919o) {
            m2727a(((C0686a) Assertions.checkNotNull(this.f10923s)).timeline);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.f10924t = null;
        this.f10923s = null;
    }

    public ClippingMediaSource(MediaSource mediaSource, long j) {
        this(mediaSource, 0L, j, true, false, true);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Void r1, MediaSource mediaSource, Timeline timeline) {
        if (this.f10924t != null) {
            return;
        }
        m2727a(timeline);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2, boolean z, boolean z2, boolean z3) {
        Assertions.checkArgument(j >= 0);
        this.f10915k = (MediaSource) Assertions.checkNotNull(mediaSource);
        this.f10916l = j;
        this.f10917m = j2;
        this.f10918n = z;
        this.f10919o = z2;
        this.f10920p = z3;
        this.f10921q = new ArrayList();
        this.f10922r = new Timeline.Window();
    }
}
