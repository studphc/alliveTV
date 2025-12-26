package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class SilenceMediaSource extends BaseMediaSource {
    public static final String MEDIA_ID = "SilenceMediaSource";

    /* renamed from: j */
    public static final Format f11051j;

    /* renamed from: k */
    public static final MediaItem f11052k;

    /* renamed from: l */
    public static final byte[] f11053l;

    /* renamed from: h */
    public final long f11054h;

    /* renamed from: i */
    public final MediaItem f11055i;

    /* loaded from: classes.dex */
    public static final class Factory {

        /* renamed from: a */
        public long f11056a;

        /* renamed from: b */
        public Object f11057b;

        public SilenceMediaSource createMediaSource() {
            boolean z;
            if (this.f11056a > 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            return new SilenceMediaSource(SilenceMediaSource.f11052k.buildUpon().setTag(this.f11057b).build(), this.f11056a);
        }

        public Factory setDurationUs(@IntRange(from = 1) long j) {
            this.f11056a = j;
            return this;
        }

        public Factory setTag(@Nullable Object obj) {
            this.f11057b = obj;
            return this;
        }
    }

    static {
        Format build = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setChannelCount(2).setSampleRate(44100).setPcmEncoding(2).build();
        f11051j = build;
        f11052k = new MediaItem.Builder().setMediaId(MEDIA_ID).setUri(Uri.EMPTY).setMimeType(build.sampleMimeType).build();
        f11053l = new byte[Util.getPcmFrameSize(2, 2) * 1024];
    }

    public SilenceMediaSource(long j) {
        this(f11052k, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new C0708n(this.f11054h);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f11055i;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        refreshSourceInfo(new SinglePeriodTimeline(this.f11054h, true, false, false, (Object) null, this.f11055i));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    public SilenceMediaSource(MediaItem mediaItem, long j) {
        Assertions.checkArgument(j >= 0);
        this.f11054h = j;
        this.f11055i = mediaItem;
    }
}
