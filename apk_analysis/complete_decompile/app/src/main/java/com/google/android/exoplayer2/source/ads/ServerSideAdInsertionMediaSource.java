package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000.ah2;
import p000.t60;
import p000.wg2;
import p000.xg2;
import p000.zg2;

/* loaded from: classes.dex */
public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener {

    /* renamed from: h */
    public final MediaSource f11111h;

    /* renamed from: l */
    public final AdPlaybackStateUpdater f11115l;

    /* renamed from: m */
    public Handler f11116m;

    /* renamed from: n */
    public ah2 f11117n;

    /* renamed from: o */
    public Timeline f11118o;

    /* renamed from: i */
    public final ArrayListMultimap f11112i = ArrayListMultimap.create();

    /* renamed from: p */
    public ImmutableMap f11119p = ImmutableMap.m3923of();

    /* renamed from: j */
    public final MediaSourceEventListener.EventDispatcher f11113j = createEventDispatcher(null);

    /* renamed from: k */
    public final DrmSessionEventListener.EventDispatcher f11114k = createDrmEventDispatcher(null);

    /* loaded from: classes.dex */
    public interface AdPlaybackStateUpdater {
        boolean onAdPlaybackStateUpdateRequested(Timeline timeline);
    }

    public ServerSideAdInsertionMediaSource(MediaSource mediaSource, @Nullable AdPlaybackStateUpdater adPlaybackStateUpdater) {
        this.f11111h = mediaSource;
        this.f11115l = adPlaybackStateUpdater;
    }

    /* renamed from: a */
    public static long m2758a(xg2 xg2Var, AdPlaybackState adPlaybackState) {
        MediaSource.MediaPeriodId mediaPeriodId = xg2Var.f28551b;
        if (mediaPeriodId.isAd()) {
            AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(mediaPeriodId.adGroupIndex);
            if (adGroup.count == -1) {
                return 0L;
            }
            return adGroup.durationsUs[mediaPeriodId.adIndexInAdGroup];
        }
        int i = mediaPeriodId.nextAdGroupIndex;
        if (i != -1) {
            long j = adPlaybackState.getAdGroup(i).timeUs;
            if (j != Long.MIN_VALUE) {
                return j;
            }
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: b */
    public static MediaLoadData m2759b(xg2 xg2Var, MediaLoadData mediaLoadData, AdPlaybackState adPlaybackState) {
        return new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, m2760c(mediaLoadData.mediaStartTimeMs, xg2Var, adPlaybackState), m2760c(mediaLoadData.mediaEndTimeMs, xg2Var, adPlaybackState));
    }

    /* renamed from: c */
    public static long m2760c(long j, xg2 xg2Var, AdPlaybackState adPlaybackState) {
        long mediaPeriodPositionUsForContent;
        if (j == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        long msToUs = Util.msToUs(j);
        MediaSource.MediaPeriodId mediaPeriodId = xg2Var.f28551b;
        if (mediaPeriodId.isAd()) {
            mediaPeriodPositionUsForContent = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForAd(msToUs, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, adPlaybackState);
        } else {
            mediaPeriodPositionUsForContent = ServerSideAdInsertionUtil.getMediaPeriodPositionUsForContent(msToUs, -1, adPlaybackState);
        }
        return Util.usToMs(mediaPeriodPositionUsForContent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        if (com.google.android.exoplayer2.source.ads.ServerSideAdInsertionUtil.getStreamPositionUs(r19, r17, r5.f195e) == com.google.android.exoplayer2.source.ads.ServerSideAdInsertionUtil.getStreamPositionUs(m2758a(r8, r5.f195e), r8.f28551b, r5.f195e)) goto L17;
     */
    @Override // com.google.android.exoplayer2.source.MediaSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        ah2 ah2Var;
        Pair pair = new Pair(Long.valueOf(mediaPeriodId.windowSequenceNumber), mediaPeriodId.periodUid);
        ah2 ah2Var2 = this.f11117n;
        MediaSource mediaSource = this.f11111h;
        ArrayListMultimap arrayListMultimap = this.f11112i;
        boolean z = false;
        if (ah2Var2 != null) {
            if (ah2Var2.f194d.equals(mediaPeriodId.periodUid)) {
                ah2Var = this.f11117n;
                arrayListMultimap.put(pair, ah2Var);
                z = true;
            } else {
                mediaSource.releasePeriod(this.f11117n.f191a);
                ah2Var = null;
            }
            this.f11117n = null;
        } else {
            ah2Var = null;
        }
        if (ah2Var == null) {
            ah2Var = (ah2) Iterables.getLast(arrayListMultimap.get((ArrayListMultimap) pair), null);
            if (ah2Var != null) {
                xg2 xg2Var = (xg2) Iterables.getLast(ah2Var.f192b);
            }
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(mediaPeriodId.periodUid));
            ah2 ah2Var3 = new ah2(mediaSource.createPeriod(new MediaSource.MediaPeriodId(mediaPeriodId.periodUid, mediaPeriodId.windowSequenceNumber), allocator, ServerSideAdInsertionUtil.getStreamPositionUs(j, mediaPeriodId, adPlaybackState)), mediaPeriodId.periodUid, adPlaybackState);
            arrayListMultimap.put(pair, ah2Var3);
            ah2Var = ah2Var3;
        }
        xg2 xg2Var2 = new xg2(ah2Var, mediaPeriodId, createEventDispatcher(mediaPeriodId), createDrmEventDispatcher(mediaPeriodId));
        ah2Var.f192b.add(xg2Var2);
        if (z && ah2Var.f199i.length > 0) {
            xg2Var2.seekToUs(j);
        }
        return xg2Var2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[LOOP:0: B:15:0x0037->B:30:0x0088, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087 A[SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final xg2 m2761d(MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData, boolean z) {
        xg2 xg2Var;
        if (mediaPeriodId == null) {
            return null;
        }
        List list = this.f11112i.get((ArrayListMultimap) new Pair(Long.valueOf(mediaPeriodId.windowSequenceNumber), mediaPeriodId.periodUid));
        if (list.isEmpty()) {
            return null;
        }
        if (z) {
            ah2 ah2Var = (ah2) Iterables.getLast(list);
            xg2 xg2Var2 = ah2Var.f196f;
            if (xg2Var2 == null) {
                return (xg2) Iterables.getLast(ah2Var.f192b);
            }
            return xg2Var2;
        }
        for (int i = 0; i < list.size(); i++) {
            ah2 ah2Var2 = (ah2) list.get(i);
            ah2Var2.getClass();
            if (mediaLoadData != null && mediaLoadData.mediaStartTimeMs != C0643C.TIME_UNSET) {
                int i2 = 0;
                while (true) {
                    ArrayList arrayList = ah2Var2.f192b;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    xg2Var = (xg2) arrayList.get(i2);
                    long mediaPeriodPositionUs = ServerSideAdInsertionUtil.getMediaPeriodPositionUs(Util.msToUs(mediaLoadData.mediaStartTimeMs), xg2Var.f28551b, ah2Var2.f195e);
                    long m2758a = m2758a(xg2Var, ah2Var2.f195e);
                    if (mediaPeriodPositionUs >= 0 && mediaPeriodPositionUs < m2758a) {
                        break;
                    }
                    i2++;
                }
                if (xg2Var == null) {
                    return xg2Var;
                }
            }
            xg2Var = null;
            if (xg2Var == null) {
            }
        }
        return (xg2) ((ah2) list.get(0)).f192b.get(0);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void disableInternal() {
        ah2 ah2Var = this.f11117n;
        MediaSource mediaSource = this.f11111h;
        if (ah2Var != null) {
            mediaSource.releasePeriod(ah2Var.f191a);
            this.f11117n = null;
        }
        mediaSource.disable(this);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void enableInternal() {
        this.f11111h.enable(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f11111h.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        this.f11111h.maybeThrowSourceInfoRefreshError();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006a  */
    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDownstreamFormatChanged(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        int i2;
        boolean z;
        String str;
        xg2 m2761d = m2761d(mediaPeriodId, mediaLoadData, false);
        if (m2761d == null) {
            this.f11113j.downstreamFormatChanged(mediaLoadData);
            return;
        }
        ah2 ah2Var = m2761d.f28550a;
        ah2Var.getClass();
        if (mediaLoadData.trackFormat != null) {
            i2 = 0;
            loop0: while (true) {
                ExoTrackSelection[] exoTrackSelectionArr = ah2Var.f199i;
                if (i2 >= exoTrackSelectionArr.length) {
                    break;
                }
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
                if (exoTrackSelection != null) {
                    TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
                    if (mediaLoadData.trackType == 0 && trackGroup.equals(ah2Var.f191a.getTrackGroups().get(0))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    for (int i3 = 0; i3 < trackGroup.length; i3++) {
                        Format format = trackGroup.getFormat(i3);
                        if (format.equals(mediaLoadData.trackFormat) || (z && (str = format.f9354id) != null && str.equals(mediaLoadData.trackFormat.f9354id))) {
                            break loop0;
                        }
                    }
                }
                i2++;
            }
            if (i2 != -1) {
                ah2Var.f201k[i2] = mediaLoadData;
                m2761d.f28556g[i2] = true;
            }
            m2761d.f28552c.downstreamFormatChanged(m2759b(m2761d, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(m2761d.f28551b.periodUid))));
        }
        i2 = -1;
        if (i2 != -1) {
        }
        m2761d.f28552c.downstreamFormatChanged(m2759b(m2761d, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(m2761d.f28551b.periodUid))));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        xg2 m2761d = m2761d(mediaPeriodId, null, false);
        if (m2761d == null) {
            this.f11114k.drmKeysLoaded();
        } else {
            m2761d.f28553d.drmKeysLoaded();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        xg2 m2761d = m2761d(mediaPeriodId, null, false);
        if (m2761d == null) {
            this.f11114k.drmKeysRemoved();
        } else {
            m2761d.f28553d.drmKeysRemoved();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        xg2 m2761d = m2761d(mediaPeriodId, null, false);
        if (m2761d == null) {
            this.f11114k.drmKeysRestored();
        } else {
            m2761d.f28553d.drmKeysRestored();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        t60.m7462d(this, i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        xg2 m2761d = m2761d(mediaPeriodId, null, false);
        if (m2761d == null) {
            this.f11114k.drmSessionManagerError(exc);
        } else {
            m2761d.f28553d.drmSessionManagerError(exc);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void onDrmSessionReleased(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        xg2 m2761d = m2761d(mediaPeriodId, null, false);
        if (m2761d == null) {
            this.f11114k.drmSessionReleased();
        } else {
            m2761d.f28553d.drmSessionReleased();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCanceled(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        xg2 m2761d = m2761d(mediaPeriodId, mediaLoadData, true);
        if (m2761d == null) {
            this.f11113j.loadCanceled(loadEventInfo, mediaLoadData);
            return;
        }
        m2761d.f28550a.f193c.remove(Long.valueOf(loadEventInfo.loadTaskId));
        m2761d.f28552c.loadCanceled(loadEventInfo, m2759b(m2761d, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(m2761d.f28551b.periodUid))));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCompleted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        xg2 m2761d = m2761d(mediaPeriodId, mediaLoadData, true);
        if (m2761d == null) {
            this.f11113j.loadCompleted(loadEventInfo, mediaLoadData);
            return;
        }
        m2761d.f28550a.f193c.remove(Long.valueOf(loadEventInfo.loadTaskId));
        m2761d.f28552c.loadCompleted(loadEventInfo, m2759b(m2761d, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(m2761d.f28551b.periodUid))));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        xg2 m2761d = m2761d(mediaPeriodId, mediaLoadData, true);
        if (m2761d == null) {
            this.f11113j.loadError(loadEventInfo, mediaLoadData, iOException, z);
            return;
        }
        if (z) {
            m2761d.f28550a.f193c.remove(Long.valueOf(loadEventInfo.loadTaskId));
        }
        m2761d.f28552c.loadError(loadEventInfo, m2759b(m2761d, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(m2761d.f28551b.periodUid))), iOException, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadStarted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        xg2 m2761d = m2761d(mediaPeriodId, mediaLoadData, true);
        if (m2761d == null) {
            this.f11113j.loadStarted(loadEventInfo, mediaLoadData);
            return;
        }
        m2761d.f28550a.f193c.put(Long.valueOf(loadEventInfo.loadTaskId), Pair.create(loadEventInfo, mediaLoadData));
        m2761d.f28552c.loadStarted(loadEventInfo, m2759b(m2761d, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(m2761d.f28551b.periodUid))));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        this.f11118o = timeline;
        AdPlaybackStateUpdater adPlaybackStateUpdater = this.f11115l;
        if ((adPlaybackStateUpdater == null || !adPlaybackStateUpdater.onAdPlaybackStateUpdateRequested(timeline)) && !this.f11119p.isEmpty()) {
            refreshSourceInfo(new zg2(timeline, this.f11119p));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        xg2 m2761d = m2761d(mediaPeriodId, mediaLoadData, false);
        if (m2761d == null) {
            this.f11113j.upstreamDiscarded(mediaLoadData);
        } else {
            m2761d.f28552c.upstreamDiscarded(m2759b(m2761d, mediaLoadData, (AdPlaybackState) Assertions.checkNotNull((AdPlaybackState) this.f11119p.get(m2761d.f28551b.periodUid))));
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper();
        synchronized (this) {
            this.f11116m = createHandlerForCurrentLooper;
        }
        this.f11111h.addEventListener(createHandlerForCurrentLooper, this);
        this.f11111h.addDrmEventListener(createHandlerForCurrentLooper, this);
        this.f11111h.prepareSource(this, transferListener, getPlayerId());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        xg2 xg2Var = (xg2) mediaPeriod;
        ah2 ah2Var = xg2Var.f28550a;
        if (xg2Var.equals(ah2Var.f196f)) {
            ah2Var.f196f = null;
            ah2Var.f193c.clear();
        }
        ah2Var.f192b.remove(xg2Var);
        ah2 ah2Var2 = xg2Var.f28550a;
        if (ah2Var2.f192b.isEmpty()) {
            MediaSource.MediaPeriodId mediaPeriodId = xg2Var.f28551b;
            Pair pair = new Pair(Long.valueOf(mediaPeriodId.windowSequenceNumber), mediaPeriodId.periodUid);
            ArrayListMultimap arrayListMultimap = this.f11112i;
            arrayListMultimap.remove(pair, ah2Var2);
            if (arrayListMultimap.isEmpty()) {
                this.f11117n = ah2Var2;
            } else {
                this.f11111h.releasePeriod(ah2Var2.f191a);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        ah2 ah2Var = this.f11117n;
        if (ah2Var != null) {
            this.f11111h.releasePeriod(ah2Var.f191a);
            this.f11117n = null;
        }
        this.f11118o = null;
        synchronized (this) {
            this.f11116m = null;
        }
        this.f11111h.releaseSource(this);
        this.f11111h.removeEventListener(this);
        this.f11111h.removeDrmEventListener(this);
    }

    public void setAdPlaybackStates(ImmutableMap<Object, AdPlaybackState> immutableMap) {
        boolean z;
        boolean z2;
        Assertions.checkArgument(!immutableMap.isEmpty());
        Object checkNotNull = Assertions.checkNotNull(immutableMap.values().asList().get(0).adsId);
        UnmodifiableIterator<Map.Entry<Object, AdPlaybackState>> it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, AdPlaybackState> next = it.next();
            Object key = next.getKey();
            AdPlaybackState value = next.getValue();
            Assertions.checkArgument(Util.areEqual(checkNotNull, value.adsId));
            AdPlaybackState adPlaybackState = (AdPlaybackState) this.f11119p.get(key);
            if (adPlaybackState != null) {
                for (int i = value.removedAdGroupCount; i < value.adGroupCount; i++) {
                    AdPlaybackState.AdGroup adGroup = value.getAdGroup(i);
                    Assertions.checkArgument(adGroup.isServerSideInserted);
                    if (i < adPlaybackState.adGroupCount) {
                        if (ServerSideAdInsertionUtil.getAdCountInGroup(value, i) >= ServerSideAdInsertionUtil.getAdCountInGroup(adPlaybackState, i)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Assertions.checkArgument(z2);
                    }
                    if (adGroup.timeUs == Long.MIN_VALUE) {
                        if (ServerSideAdInsertionUtil.getAdCountInGroup(value, i) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Assertions.checkArgument(z);
                    }
                }
            }
        }
        synchronized (this) {
            try {
                Handler handler = this.f11116m;
                if (handler == null) {
                    this.f11119p = immutableMap;
                } else {
                    handler.post(new wg2(0, this, immutableMap));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        xg2 m2761d = m2761d(mediaPeriodId, null, true);
        if (m2761d == null) {
            this.f11114k.drmSessionAcquired(i2);
        } else {
            m2761d.f28553d.drmSessionAcquired(i2);
        }
    }
}
