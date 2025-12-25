package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public final class LoopingMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: k */
    public final MaskingMediaSource f10956k;

    /* renamed from: l */
    public final int f10957l;

    /* renamed from: m */
    public final HashMap f10958m;

    /* renamed from: n */
    public final HashMap f10959n;

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        int i = this.f10957l;
        MaskingMediaSource maskingMediaSource = this.f10956k;
        if (i == Integer.MAX_VALUE) {
            return maskingMediaSource.createPeriod(mediaPeriodId, allocator, j);
        }
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.f10958m.put(copyWithPeriodUid, mediaPeriodId);
        MaskingMediaPeriod createPeriod = maskingMediaSource.createPeriod(copyWithPeriodUid, allocator, j);
        this.f10959n.put(createPeriod, copyWithPeriodUid);
        return createPeriod;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    public Timeline getInitialTimeline() {
        MaskingMediaSource maskingMediaSource = this.f10956k;
        int i = this.f10957l;
        if (i != Integer.MAX_VALUE) {
            return new C0698g(maskingMediaSource.getTimeline(), i);
        }
        return new ForwardingTimeline(maskingMediaSource.getTimeline());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f10956k.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.f10956k);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.f10956k.releasePeriod(mediaPeriod);
        MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) this.f10959n.remove(mediaPeriod);
        if (mediaPeriodId != null) {
            this.f10958m.remove(mediaPeriodId);
        }
    }

    public LoopingMediaSource(MediaSource mediaSource, int i) {
        Assertions.checkArgument(i > 0);
        this.f10956k = new MaskingMediaSource(mediaSource, false);
        this.f10957l = i;
        this.f10958m = new HashMap();
        this.f10959n = new HashMap();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void r2, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f10957l != Integer.MAX_VALUE ? (MediaSource.MediaPeriodId) this.f10958m.get(mediaPeriodId) : mediaPeriodId;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Void r1, MediaSource mediaSource, Timeline timeline) {
        Timeline forwardingTimeline;
        int i = this.f10957l;
        if (i != Integer.MAX_VALUE) {
            forwardingTimeline = new C0698g(timeline, i);
        } else {
            forwardingTimeline = new ForwardingTimeline(timeline);
        }
        refreshSourceInfo(forwardingTimeline);
    }
}
