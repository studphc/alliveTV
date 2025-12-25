package com.google.android.exoplayer2.analytics;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p000.C1255h3;
import p000.C1335iz;
import p000.C1492kz;
import p000.C1529lz;
import p000.C1566mz;
import p000.C1603nz;
import p000.C1668oz;
import p000.C1702pw;
import p000.C1705pz;
import p000.C1742qz;
import p000.C1779rz;
import p000.C1816sz;
import p000.C1853tz;
import p000.C1890uz;
import p000.C2001xz;
import p000.C2038yz;
import p000.C2075zz;
import p000.RunnableC0006a5;
import p000.a00;
import p000.b00;
import p000.e00;
import p000.t60;

/* loaded from: classes.dex */
public class DefaultAnalyticsCollector implements AnalyticsCollector {

    /* renamed from: a */
    public final Clock f9512a;

    /* renamed from: b */
    public final Timeline.Period f9513b;

    /* renamed from: c */
    public final Timeline.Window f9514c;

    /* renamed from: d */
    public final e00 f9515d;

    /* renamed from: e */
    public final SparseArray f9516e;

    /* renamed from: f */
    public ListenerSet f9517f;

    /* renamed from: g */
    public Player f9518g;

    /* renamed from: h */
    public HandlerWrapper f9519h;

    /* renamed from: i */
    public boolean f9520i;

    public DefaultAnalyticsCollector(Clock clock) {
        this.f9512a = (Clock) Assertions.checkNotNull(clock);
        this.f9517f = new ListenerSet(Util.getCurrentOrMainLooper(), clock, new C1255h3(13));
        Timeline.Period period = new Timeline.Period();
        this.f9513b = period;
        this.f9514c = new Timeline.Window();
        this.f9515d = new e00(period);
        this.f9516e = new SparseArray();
    }

    /* renamed from: a */
    public final AnalyticsListener.EventTime m2420a(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        Assertions.checkNotNull(this.f9518g);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = (Timeline) this.f9515d.f16632c.get(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return generateEventTime(timeline, timeline.getPeriodByUid(mediaPeriodId.periodUid, this.f9513b).windowIndex, mediaPeriodId);
        }
        int currentMediaItemIndex = this.f9518g.getCurrentMediaItemIndex();
        Timeline currentTimeline = this.f9518g.getCurrentTimeline();
        if (currentMediaItemIndex >= currentTimeline.getWindowCount()) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentMediaItemIndex, null);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.f9517f.add(analyticsListener);
    }

    /* renamed from: b */
    public final AnalyticsListener.EventTime m2421b(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.f9518g);
        if (mediaPeriodId != null) {
            if (((Timeline) this.f9515d.f16632c.get(mediaPeriodId)) != null) {
                return m2420a(mediaPeriodId);
            }
            return generateEventTime(Timeline.EMPTY, i, mediaPeriodId);
        }
        Timeline currentTimeline = this.f9518g.getCurrentTimeline();
        if (i >= currentTimeline.getWindowCount()) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, null);
    }

    /* renamed from: c */
    public final AnalyticsListener.EventTime m2422c() {
        return m2420a(this.f9515d.f16635f);
    }

    public final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return m2420a(this.f9515d.f16633d);
    }

    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2;
        boolean z;
        if (timeline.isEmpty()) {
            mediaPeriodId2 = null;
        } else {
            mediaPeriodId2 = mediaPeriodId;
        }
        long elapsedRealtime = this.f9512a.elapsedRealtime();
        if (timeline.equals(this.f9518g.getCurrentTimeline()) && i == this.f9518g.getCurrentMediaItemIndex()) {
            z = true;
        } else {
            z = false;
        }
        long j = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (z && this.f9518g.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.f9518g.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup) {
                j = this.f9518g.getCurrentPosition();
            }
        } else if (z) {
            j = this.f9518g.getContentPosition();
        } else if (!timeline.isEmpty()) {
            j = timeline.getWindow(i, this.f9514c).getDefaultPositionMs();
        }
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.f9518g.getCurrentTimeline(), this.f9518g.getCurrentMediaItemIndex(), this.f9515d.f16633d, this.f9518g.getCurrentPosition(), this.f9518g.getTotalBufferedDuration());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void notifySeekStarted() {
        if (!this.f9520i) {
            AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
            this.f9520i = true;
            sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new C1816sz(generateCurrentPlayerMediaPeriodEventTime, 0));
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 20, new C1702pw(1, m2422c, audioAttributes));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioCodecError(Exception exc) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, new C1529lz(m2422c, exc, 1));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1008, new C1668oz(m2422c, str, j2, j, 0));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioDecoderReleased(String str) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1012, new a00(m2422c, str, 0));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime m2420a = m2420a(this.f9515d.f16634e);
        sendEvent(m2420a, 1013, new C2075zz(m2420a, 1, decoderCounters));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1007, new C2075zz(m2422c, 3, decoderCounters));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1009, new C1566mz(m2422c, format, decoderReuseEvaluation, 0));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioPositionAdvancing(long j) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1010, new C1335iz(m2422c, j, 2));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onAudioSessionIdChanged(int i) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 21, new C1853tz(m2422c, i, 0));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioSinkError(Exception exc) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1014, new C1529lz(m2422c, exc, 2));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onAudioUnderrun(int i, long j, long j2) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1011, new C1603nz(m2422c, i, j, j2, 0));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onAvailableCommandsChanged(Player.Commands commands) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 13, new C1702pw(5, generateCurrentPlayerMediaPeriodEventTime, commands));
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener
    public final void onBandwidthSample(int i, long j, long j2) {
        MediaSource.MediaPeriodId mediaPeriodId;
        e00 e00Var = this.f9515d;
        if (e00Var.f16631b.isEmpty()) {
            mediaPeriodId = null;
        } else {
            mediaPeriodId = (MediaSource.MediaPeriodId) Iterables.getLast(e00Var.f16631b);
        }
        AnalyticsListener.EventTime m2420a = m2420a(mediaPeriodId);
        sendEvent(m2420a, 1006, new C1603nz(m2420a, i, j, j2, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onCues(List<Cue> list) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 27, new C1702pw(7, generateCurrentPlayerMediaPeriodEventTime, list));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 29, new C1702pw(9, generateCurrentPlayerMediaPeriodEventTime, deviceInfo));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onDeviceVolumeChanged(int i, boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 30, new C1779rz(generateCurrentPlayerMediaPeriodEventTime, i, z));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1004, new C1890uz(m2421b, mediaLoadData, 0));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, AnalyticsListener.EVENT_DRM_KEYS_LOADED, new C1816sz(m2421b, 2));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, AnalyticsListener.EVENT_DRM_KEYS_REMOVED, new C1816sz(m2421b, 6));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1025, new C1816sz(m2421b, 4));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        t60.m7462d(this, i, mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1024, new C1529lz(m2421b, exc, 3));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionReleased(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, AnalyticsListener.EVENT_DRM_SESSION_RELEASED, new C1816sz(m2421b, 3));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onDroppedFrames(int i, long j) {
        AnalyticsListener.EventTime m2420a = m2420a(this.f9515d.f16634e);
        sendEvent(m2420a, 1018, new b00(m2420a, i, j));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onEvents(Player player, Player.Events events) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onIsLoadingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 3, new C1492kz(generateCurrentPlayerMediaPeriodEventTime, 3, z));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsPlayingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 7, new C1492kz(generateCurrentPlayerMediaPeriodEventTime, 1, z));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1002, new C1742qz(m2421b, loadEventInfo, mediaLoadData, 2));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1001, new C1742qz(m2421b, loadEventInfo, mediaLoadData, 0));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
        final AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1003, new ListenerSet.Event() { // from class: wz
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onLoadError(AnalyticsListener.EventTime.this, loadEventInfo, mediaLoadData, iOException, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1000, new C1742qz(m2421b, loadEventInfo, mediaLoadData, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onMaxSeekToPreviousPositionChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 18, new C1335iz(generateCurrentPlayerMediaPeriodEventTime, j, 3));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onMediaItemTransition(@Nullable MediaItem mediaItem, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1, new C2038yz(generateCurrentPlayerMediaPeriodEventTime, mediaItem, i));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 14, new C1705pz(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata, 0));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 28, new C1702pw(10, generateCurrentPlayerMediaPeriodEventTime, metadata));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 5, new C1779rz(generateCurrentPlayerMediaPeriodEventTime, z, i, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 12, new C1702pw(2, generateCurrentPlayerMediaPeriodEventTime, playbackParameters));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 4, new C1853tz(generateCurrentPlayerMediaPeriodEventTime, i, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackSuppressionReasonChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 6, new C1853tz(generateCurrentPlayerMediaPeriodEventTime, i, 3));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerError(PlaybackException playbackException) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime;
        MediaPeriodId mediaPeriodId;
        if ((playbackException instanceof ExoPlaybackException) && (mediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) != null) {
            generateCurrentPlayerMediaPeriodEventTime = m2420a(new MediaSource.MediaPeriodId(mediaPeriodId));
        } else {
            generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        }
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 10, new C2001xz(generateCurrentPlayerMediaPeriodEventTime, playbackException, 0));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime;
        MediaPeriodId mediaPeriodId;
        if ((playbackException instanceof ExoPlaybackException) && (mediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) != null) {
            generateCurrentPlayerMediaPeriodEventTime = m2420a(new MediaSource.MediaPeriodId(mediaPeriodId));
        } else {
            generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        }
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 10, new C2001xz(generateCurrentPlayerMediaPeriodEventTime, playbackException, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerStateChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new C1779rz(generateCurrentPlayerMediaPeriodEventTime, z, i, 0));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 15, new C1705pz(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPositionDiscontinuity(int i) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onRepeatModeChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 8, new C1853tz(generateCurrentPlayerMediaPeriodEventTime, i, 2));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekBackIncrementChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 16, new C1335iz(generateCurrentPlayerMediaPeriodEventTime, j, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onSeekForwardIncrementChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 17, new C1335iz(generateCurrentPlayerMediaPeriodEventTime, j, 0));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSeekProcessed() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new C1816sz(generateCurrentPlayerMediaPeriodEventTime, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onShuffleModeEnabledChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 9, new C1492kz(generateCurrentPlayerMediaPeriodEventTime, 2, z));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSkipSilenceEnabledChanged(boolean z) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 23, new C1492kz(m2422c, 0, z));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSurfaceSizeChanged(final int i, final int i2) {
        final AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 24, new ListenerSet.Event() { // from class: vz
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onSurfaceSizeChanged(AnalyticsListener.EventTime.this, i, i2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onTimelineChanged(Timeline timeline, int i) {
        Player player = (Player) Assertions.checkNotNull(this.f9518g);
        e00 e00Var = this.f9515d;
        e00Var.f16633d = e00.m4651b(player, e00Var.f16631b, e00Var.f16634e, e00Var.f16630a);
        e00Var.m4654d(player.getCurrentTimeline());
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 0, new C1853tz(generateCurrentPlayerMediaPeriodEventTime, i, 4));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 19, new C1702pw(6, generateCurrentPlayerMediaPeriodEventTime, trackSelectionParameters));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onTracksChanged(Tracks tracks) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 2, new C1702pw(8, generateCurrentPlayerMediaPeriodEventTime, tracks));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, 1005, new C1890uz(m2421b, mediaLoadData, 1));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoCodecError(Exception exc) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, new C1529lz(m2422c, exc, 0));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1016, new C1668oz(m2422c, str, j2, j, 1));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoDecoderReleased(String str) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1019, new a00(m2422c, str, 1));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime m2420a = m2420a(this.f9515d.f16634e);
        sendEvent(m2420a, 1020, new C2075zz(m2420a, 2, decoderCounters));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1015, new C2075zz(m2422c, 0, decoderCounters));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoFrameProcessingOffset(long j, int i) {
        AnalyticsListener.EventTime m2420a = m2420a(this.f9515d.f16634e);
        sendEvent(m2420a, 1021, new b00(m2420a, j, i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onVideoInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 1017, new C1566mz(m2422c, format, decoderReuseEvaluation, 1));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 25, new C1702pw(11, m2422c, videoSize));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVolumeChanged(final float f) {
        final AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 22, new ListenerSet.Event() { // from class: d00
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).onVolumeChanged(AnalyticsListener.EventTime.this, f);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void release() {
        ((HandlerWrapper) Assertions.checkStateNotNull(this.f9519h)).post(new RunnableC0006a5(7, this));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void removeListener(AnalyticsListener analyticsListener) {
        this.f9517f.remove(analyticsListener);
    }

    public final void sendEvent(AnalyticsListener.EventTime eventTime, int i, ListenerSet.Event<AnalyticsListener> event) {
        this.f9516e.put(i, eventTime);
        this.f9517f.sendEvent(i, event);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    @CallSuper
    public void setPlayer(Player player, Looper looper) {
        boolean z;
        if (this.f9518g != null && !this.f9515d.f16631b.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkState(z);
        this.f9518g = (Player) Assertions.checkNotNull(player);
        this.f9519h = this.f9512a.createHandler(looper, null);
        this.f9517f = this.f9517f.copy(looper, new C1702pw(3, this, player));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Player player = (Player) Assertions.checkNotNull(this.f9518g);
        e00 e00Var = this.f9515d;
        e00Var.getClass();
        e00Var.f16631b = ImmutableList.copyOf((Collection) list);
        if (!list.isEmpty()) {
            e00Var.f16634e = list.get(0);
            e00Var.f16635f = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
        }
        if (e00Var.f16633d == null) {
            e00Var.f16633d = e00.m4651b(player, e00Var.f16631b, e00Var.f16634e, e00Var.f16630a);
        }
        e00Var.m4654d(player.getCurrentTimeline());
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        AnalyticsListener.EventTime m2421b = m2421b(i, mediaPeriodId);
        sendEvent(m2421b, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, new C1853tz(m2421b, i2, 5));
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int i) {
        if (i == 1) {
            this.f9520i = false;
        }
        Player player = (Player) Assertions.checkNotNull(this.f9518g);
        e00 e00Var = this.f9515d;
        e00Var.f16633d = e00.m4651b(player, e00Var.f16631b, e00Var.f16634e, e00Var.f16630a);
        final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 11, new ListenerSet.Event() { // from class: c00
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                AnalyticsListener.EventTime eventTime = AnalyticsListener.EventTime.this;
                int i2 = i;
                analyticsListener.onPositionDiscontinuity(eventTime, i2);
                analyticsListener.onPositionDiscontinuity(eventTime, positionInfo, positionInfo2, i2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsCollector
    public final void onRenderedFirstFrame(final Object obj, final long j) {
        final AnalyticsListener.EventTime m2422c = m2422c();
        sendEvent(m2422c, 26, new ListenerSet.Event() { // from class: jz
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj2) {
                ((AnalyticsListener) obj2).onRenderedFirstFrame(AnalyticsListener.EventTime.this, obj, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onCues(CueGroup cueGroup) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 27, new C1702pw(4, generateCurrentPlayerMediaPeriodEventTime, cueGroup));
    }
}
