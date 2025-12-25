package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p000.lm1;

/* loaded from: classes.dex */
public abstract class BaseMediaSource implements MediaSource {

    /* renamed from: a */
    public final ArrayList f10899a = new ArrayList(1);

    /* renamed from: b */
    public final HashSet f10900b = new HashSet(1);

    /* renamed from: c */
    public final MediaSourceEventListener.EventDispatcher f10901c = new MediaSourceEventListener.EventDispatcher();

    /* renamed from: d */
    public final DrmSessionEventListener.EventDispatcher f10902d = new DrmSessionEventListener.EventDispatcher();

    /* renamed from: e */
    public Looper f10903e;

    /* renamed from: f */
    public Timeline f10904f;

    /* renamed from: g */
    public PlayerId f10905g;

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void addDrmEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(drmSessionEventListener);
        this.f10902d.addEventListener(handler, drmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(mediaSourceEventListener);
        this.f10901c.addEventListener(handler, mediaSourceEventListener);
    }

    public final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f10902d.withParameters(0, mediaPeriodId);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f10901c.withParameters(0, mediaPeriodId, 0L);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void disable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        HashSet hashSet = this.f10900b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.remove(mediaSourceCaller);
        if (!isEmpty && hashSet.isEmpty()) {
            disableInternal();
        }
    }

    public void disableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void enable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.checkNotNull(this.f10903e);
        HashSet hashSet = this.f10900b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(mediaSourceCaller);
        if (isEmpty) {
            enableInternal();
        }
    }

    public void enableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ Timeline getInitialTimeline() {
        return lm1.m5958a(this);
    }

    public final PlayerId getPlayerId() {
        return (PlayerId) Assertions.checkStateNotNull(this.f10905g);
    }

    public final boolean isEnabled() {
        return !this.f10900b.isEmpty();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ boolean isSingleWindow() {
        return lm1.m5959b(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final /* synthetic */ void prepareSource(MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener) {
        lm1.m5960c(this, mediaSourceCaller, transferListener);
    }

    public abstract void prepareSourceInternal(@Nullable TransferListener transferListener);

    public final void refreshSourceInfo(Timeline timeline) {
        this.f10904f = timeline;
        Iterator it = this.f10899a.iterator();
        while (it.hasNext()) {
            ((MediaSource.MediaSourceCaller) it.next()).onSourceInfoRefreshed(this, timeline);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void releaseSource(MediaSource.MediaSourceCaller mediaSourceCaller) {
        ArrayList arrayList = this.f10899a;
        arrayList.remove(mediaSourceCaller);
        if (arrayList.isEmpty()) {
            this.f10903e = null;
            this.f10904f = null;
            this.f10905g = null;
            this.f10900b.clear();
            releaseSourceInternal();
            return;
        }
        disable(mediaSourceCaller);
    }

    public abstract void releaseSourceInternal();

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener) {
        this.f10902d.removeEventListener(drmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.f10901c.removeEventListener(mediaSourceEventListener);
    }

    public final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f10902d.withParameters(i, mediaPeriodId);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        Assertions.checkNotNull(mediaPeriodId);
        return this.f10901c.withParameters(0, mediaPeriodId, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void prepareSource(MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener, PlayerId playerId) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f10903e;
        Assertions.checkArgument(looper == null || looper == myLooper);
        this.f10905g = playerId;
        Timeline timeline = this.f10904f;
        this.f10899a.add(mediaSourceCaller);
        if (this.f10903e == null) {
            this.f10903e = myLooper;
            this.f10900b.add(mediaSourceCaller);
            prepareSourceInternal(transferListener);
        } else if (timeline != null) {
            enable(mediaSourceCaller);
            mediaSourceCaller.onSourceInfoRefreshed(this, timeline);
        }
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j) {
        return this.f10901c.withParameters(i, mediaPeriodId, j);
    }
}
