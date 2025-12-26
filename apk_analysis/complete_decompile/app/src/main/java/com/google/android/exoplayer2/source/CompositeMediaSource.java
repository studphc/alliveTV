package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UnknownNull;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {

    /* renamed from: h */
    public final HashMap f10927h = new HashMap();

    /* renamed from: i */
    public Handler f10928i;

    /* renamed from: j */
    public TransferListener f10929j;

    public final void disableChildSource(@UnknownNull T t) {
        C0690c c0690c = (C0690c) Assertions.checkNotNull((C0690c) this.f10927h.get(t));
        c0690c.f11130a.disable(c0690c.f11131b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void disableInternal() {
        for (C0690c c0690c : this.f10927h.values()) {
            c0690c.f11130a.disable(c0690c.f11131b);
        }
    }

    public final void enableChildSource(@UnknownNull T t) {
        C0690c c0690c = (C0690c) Assertions.checkNotNull((C0690c) this.f10927h.get(t));
        c0690c.f11130a.enable(c0690c.f11131b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void enableInternal() {
        for (C0690c c0690c : this.f10927h.values()) {
            c0690c.f11130a.enable(c0690c.f11131b);
        }
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(@UnknownNull T t, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    public long getMediaTimeForChildMediaTime(@UnknownNull T t, long j) {
        return j;
    }

    public int getWindowIndexForChildWindowIndex(@UnknownNull T t, int i) {
        return i;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() {
        Iterator it = this.f10927h.values().iterator();
        while (it.hasNext()) {
            ((C0690c) it.next()).f11130a.maybeThrowSourceInfoRefreshError();
        }
    }

    public abstract void onChildSourceInfoRefreshed(@UnknownNull T t, MediaSource mediaSource, Timeline timeline);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller, du] */
    public final void prepareChildSource(@UnknownNull final T t, MediaSource mediaSource) {
        HashMap hashMap = this.f10927h;
        Assertions.checkArgument(!hashMap.containsKey(t));
        ?? r1 = new MediaSource.MediaSourceCaller() { // from class: du
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline) {
                CompositeMediaSource.this.onChildSourceInfoRefreshed(t, mediaSource2, timeline);
            }
        };
        C0689b c0689b = new C0689b(this, t);
        hashMap.put(t, new C0690c(mediaSource, r1, c0689b));
        mediaSource.addEventListener((Handler) Assertions.checkNotNull(this.f10928i), c0689b);
        mediaSource.addDrmEventListener((Handler) Assertions.checkNotNull(this.f10928i), c0689b);
        mediaSource.prepareSource(r1, this.f10929j, getPlayerId());
        if (!isEnabled()) {
            mediaSource.disable(r1);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f10929j = transferListener;
        this.f10928i = Util.createHandlerForCurrentLooper();
    }

    public final void releaseChildSource(@UnknownNull T t) {
        C0690c c0690c = (C0690c) Assertions.checkNotNull((C0690c) this.f10927h.remove(t));
        c0690c.f11130a.releaseSource(c0690c.f11131b);
        C0689b c0689b = c0690c.f11132c;
        MediaSource mediaSource = c0690c.f11130a;
        mediaSource.removeEventListener(c0689b);
        mediaSource.removeDrmEventListener(c0689b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void releaseSourceInternal() {
        HashMap hashMap = this.f10927h;
        for (C0690c c0690c : hashMap.values()) {
            c0690c.f11130a.releaseSource(c0690c.f11131b);
            C0689b c0689b = c0690c.f11132c;
            MediaSource mediaSource = c0690c.f11130a;
            mediaSource.removeEventListener(c0689b);
            mediaSource.removeDrmEventListener(c0689b);
        }
        hashMap.clear();
    }
}
