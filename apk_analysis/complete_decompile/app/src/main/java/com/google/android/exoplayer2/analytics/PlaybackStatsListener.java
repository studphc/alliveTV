package com.google.android.exoplayer2.analytics;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p000.AbstractC1862u7;

/* loaded from: classes.dex */
public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {

    /* renamed from: a */
    public final DefaultPlaybackSessionManager f9557a;

    /* renamed from: b */
    public final HashMap f9558b;

    /* renamed from: c */
    public final HashMap f9559c;

    /* renamed from: d */
    public final Callback f9560d;

    /* renamed from: e */
    public final boolean f9561e;

    /* renamed from: f */
    public final Timeline.Period f9562f;

    /* renamed from: g */
    public PlaybackStats f9563g;

    /* renamed from: h */
    public String f9564h;

    /* renamed from: i */
    public long f9565i;

    /* renamed from: j */
    public int f9566j;

    /* renamed from: k */
    public int f9567k;

    /* renamed from: l */
    public Exception f9568l;

    /* renamed from: m */
    public long f9569m;

    /* renamed from: n */
    public long f9570n;

    /* renamed from: o */
    public Format f9571o;

    /* renamed from: p */
    public Format f9572p;

    /* renamed from: q */
    public VideoSize f9573q;

    /* loaded from: classes.dex */
    public interface Callback {
        void onPlaybackStatsReady(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    public PlaybackStatsListener(boolean z, @Nullable Callback callback) {
        this.f9560d = callback;
        this.f9561e = z;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.f9557a = defaultPlaybackSessionManager;
        this.f9558b = new HashMap();
        this.f9559c = new HashMap();
        this.f9563g = PlaybackStats.EMPTY;
        this.f9562f = new Timeline.Period();
        this.f9573q = VideoSize.UNKNOWN;
        defaultPlaybackSessionManager.setListener(this);
    }

    /* renamed from: a */
    public final boolean m2429a(AnalyticsListener.Events events, String str, int i) {
        if (events.contains(i) && this.f9557a.belongsToSession(events.getEventTime(i), str)) {
            return true;
        }
        return false;
    }

    public PlaybackStats getCombinedPlaybackStats() {
        HashMap hashMap = this.f9558b;
        int i = 1;
        PlaybackStats[] playbackStatsArr = new PlaybackStats[hashMap.size() + 1];
        playbackStatsArr[0] = this.f9563g;
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            playbackStatsArr[i] = ((C0646b) it.next()).m2434a(false);
            i++;
        }
        return PlaybackStats.merge(playbackStatsArr);
    }

    @Nullable
    public PlaybackStats getPlaybackStats() {
        C0646b c0646b;
        String activeSessionId = this.f9557a.getActiveSessionId();
        if (activeSessionId == null) {
            c0646b = null;
        } else {
            c0646b = (C0646b) this.f9558b.get(activeSessionId);
        }
        if (c0646b == null) {
            return null;
        }
        return c0646b.m2434a(false);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
        C0646b c0646b = (C0646b) Assertions.checkNotNull((C0646b) this.f9558b.get(str));
        c0646b.f9593L = true;
        c0646b.f9591J = false;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        AbstractC1862u7.m7629a(this, eventTime, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC1862u7.m7631b(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        AbstractC1862u7.m7633c(this, eventTime, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        AbstractC1862u7.m7637e(this, eventTime, str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AbstractC1862u7.m7639f(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AbstractC1862u7.m7641g(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        AbstractC1862u7.m7643h(this, eventTime, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
        AbstractC1862u7.m7647j(this, eventTime, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i) {
        AbstractC1862u7.m7649k(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC1862u7.m7651l(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        AbstractC1862u7.m7653m(this, eventTime, i, j, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        AbstractC1862u7.m7655n(this, eventTime, commands);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        this.f9569m = i;
        this.f9570n = j;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onCues(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        AbstractC1862u7.m7659p(this, eventTime, cueGroup);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AbstractC1862u7.m7663r(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AbstractC1862u7.m7665s(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        AbstractC1862u7.m7667t(this, eventTime, i, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        AbstractC1862u7.m7669u(this, eventTime, i, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDeviceInfoChanged(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        AbstractC1862u7.m7671v(this, eventTime, deviceInfo);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDeviceVolumeChanged(AnalyticsListener.EventTime eventTime, int i, boolean z) {
        AbstractC1862u7.m7673w(this, eventTime, i, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        int i = mediaLoadData.trackType;
        if (i != 2 && i != 0) {
            if (i == 1) {
                this.f9572p = mediaLoadData.trackFormat;
                return;
            }
            return;
        }
        this.f9571o = mediaLoadData.trackFormat;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7677y(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7679z(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7601A(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7603B(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f9568l = exc;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7607E(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        this.f9567k = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x031e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020b  */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [boolean, int] */
    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onEvents(Player player, AnalyticsListener.Events events) {
        DefaultPlaybackSessionManager defaultPlaybackSessionManager;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager2;
        boolean z;
        long j;
        int i;
        PlaybackException playbackException;
        Exception exc;
        long j2;
        Format format;
        Format format2;
        VideoSize videoSize;
        ?? r7;
        Format format3;
        char c;
        long j3;
        Tracks currentTracks;
        Format format4;
        MediaSource.MediaPeriodId mediaPeriodId;
        HashMap hashMap;
        PlaybackStatsListener playbackStatsListener = this;
        AnalyticsListener.Events events2 = events;
        if (events.size() == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int size = events.size();
            defaultPlaybackSessionManager = playbackStatsListener.f9557a;
            if (i2 >= size) {
                break;
            }
            int i3 = events2.get(i2);
            AnalyticsListener.EventTime eventTime = events2.getEventTime(i3);
            if (i3 == 0) {
                defaultPlaybackSessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i3 == 11) {
                defaultPlaybackSessionManager.updateSessionsWithDiscontinuity(eventTime, playbackStatsListener.f9566j);
            } else {
                defaultPlaybackSessionManager.updateSessions(eventTime);
            }
            i2++;
        }
        HashMap hashMap2 = playbackStatsListener.f9558b;
        Iterator it = hashMap2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            int i4 = 0;
            AnalyticsListener.EventTime eventTime2 = null;
            boolean z2 = false;
            while (i4 < events.size()) {
                AnalyticsListener.EventTime eventTime3 = events2.getEventTime(events2.get(i4));
                boolean belongsToSession = defaultPlaybackSessionManager.belongsToSession(eventTime3, str);
                if (eventTime2 == null || (belongsToSession && !z2)) {
                    hashMap = hashMap2;
                } else {
                    if (belongsToSession == z2) {
                        hashMap = hashMap2;
                        if (eventTime3.realtimeMs <= eventTime2.realtimeMs) {
                        }
                    } else {
                        hashMap = hashMap2;
                    }
                    i4++;
                    hashMap2 = hashMap;
                }
                eventTime2 = eventTime3;
                z2 = belongsToSession;
                i4++;
                hashMap2 = hashMap;
            }
            HashMap hashMap3 = hashMap2;
            Assertions.checkNotNull(eventTime2);
            if (!z2 && (mediaPeriodId = eventTime2.mediaPeriodId) != null && mediaPeriodId.isAd()) {
                Timeline timeline = eventTime2.timeline;
                Object obj = eventTime2.mediaPeriodId.periodUid;
                Timeline.Period period = playbackStatsListener.f9562f;
                long adGroupTimeUs = timeline.getPeriodByUid(obj, period).getAdGroupTimeUs(eventTime2.mediaPeriodId.adGroupIndex);
                if (adGroupTimeUs == Long.MIN_VALUE) {
                    adGroupTimeUs = period.durationUs;
                }
                long positionInWindowUs = period.getPositionInWindowUs() + adGroupTimeUs;
                long j4 = eventTime2.realtimeMs;
                Timeline timeline2 = eventTime2.timeline;
                int i5 = eventTime2.windowIndex;
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime2.mediaPeriodId;
                defaultPlaybackSessionManager2 = defaultPlaybackSessionManager;
                AnalyticsListener.EventTime eventTime4 = new AnalyticsListener.EventTime(j4, timeline2, i5, new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber, mediaPeriodId2.adGroupIndex), Util.usToMs(positionInWindowUs), eventTime2.timeline, eventTime2.currentWindowIndex, eventTime2.currentMediaPeriodId, eventTime2.currentPlaybackPositionMs, eventTime2.totalBufferedDurationMs);
                str = str;
                z2 = defaultPlaybackSessionManager2.belongsToSession(eventTime4, str);
                eventTime2 = eventTime4;
            } else {
                defaultPlaybackSessionManager2 = defaultPlaybackSessionManager;
            }
            Pair create = Pair.create(eventTime2, Boolean.valueOf(z2));
            C0646b c0646b = (C0646b) hashMap3.get(str);
            boolean m2429a = m2429a(events, str, 11);
            boolean m2429a2 = m2429a(events, str, 1018);
            boolean m2429a3 = m2429a(events, str, 1011);
            boolean m2429a4 = m2429a(events, str, 1000);
            boolean m2429a5 = m2429a(events, str, 10);
            if (!m2429a(events, str, 1003) && !m2429a(events, str, 1024)) {
                z = false;
            } else {
                z = true;
            }
            boolean m2429a6 = m2429a(events, str, 1006);
            boolean m2429a7 = m2429a(events, str, 1004);
            boolean m2429a8 = m2429a(events, str, 25);
            Iterator it2 = it;
            AnalyticsListener.EventTime eventTime5 = (AnalyticsListener.EventTime) create.first;
            boolean booleanValue = ((Boolean) create.second).booleanValue();
            DefaultPlaybackSessionManager defaultPlaybackSessionManager3 = defaultPlaybackSessionManager2;
            if (str.equals(this.f9564h)) {
                j = this.f9565i;
            } else {
                j = -9223372036854775807L;
            }
            if (m2429a2) {
                i = this.f9567k;
            } else {
                i = 0;
            }
            if (m2429a5) {
                playbackException = player.getPlayerError();
            } else {
                playbackException = null;
            }
            if (z) {
                exc = this.f9568l;
            } else {
                exc = null;
            }
            long j5 = 0;
            int i6 = i;
            if (m2429a6) {
                j2 = this.f9569m;
            } else {
                j2 = 0;
            }
            long j6 = j2;
            if (m2429a6) {
                j5 = this.f9570n;
            }
            if (m2429a7) {
                format = this.f9571o;
            } else {
                format = null;
            }
            if (m2429a7) {
                format2 = this.f9572p;
            } else {
                format2 = null;
            }
            if (m2429a8) {
                videoSize = this.f9573q;
            } else {
                videoSize = null;
            }
            c0646b.getClass();
            if (j != C0643C.TIME_UNSET) {
                c0646b.m2440h(eventTime5.realtimeMs, j);
                r7 = 1;
                c0646b.f9591J = true;
            } else {
                r7 = 1;
            }
            int i7 = 2;
            i7 = 2;
            i7 = 2;
            i7 = 2;
            if (player.getPlaybackState() != 2) {
                c0646b.f9591J = false;
            }
            int playbackState = player.getPlaybackState();
            if (playbackState == r7 || playbackState == 4 || m2429a) {
                c0646b.f9593L = false;
            }
            boolean z3 = c0646b.f9602a;
            if (playbackException != null) {
                c0646b.f9594M = r7;
                c0646b.f9587F += r7;
                if (z3) {
                    c0646b.f9608g.add(new PlaybackStats.EventTimeAndException(eventTime5, playbackException));
                }
            } else if (player.getPlayerError() == null) {
                c0646b.f9594M = false;
                if (c0646b.f9592K && !c0646b.f9593L) {
                    currentTracks = player.getCurrentTracks();
                    if (currentTracks.isTypeSelected(2)) {
                        format4 = null;
                        c0646b.m2441i(eventTime5, null);
                    } else {
                        format4 = null;
                    }
                    if (!currentTracks.isTypeSelected(1)) {
                        c0646b.m2438f(eventTime5, format4);
                    }
                }
                if (format != null) {
                    c0646b.m2441i(eventTime5, format);
                }
                if (format2 != null) {
                    c0646b.m2438f(eventTime5, format2);
                }
                format3 = c0646b.f9597P;
                if (format3 != null && format3.height == -1 && videoSize != null) {
                    c0646b.m2441i(eventTime5, format3.buildUpon().setWidth(videoSize.width).setHeight(videoSize.height).build());
                }
                if (m2429a4) {
                    c0646b.f9595N = true;
                }
                if (m2429a3) {
                    c0646b.f9586E++;
                }
                c0646b.f9585D += i6;
                c0646b.f9583B += j6;
                c0646b.f9584C += j5;
                if (exc != null) {
                    c0646b.f9588G++;
                    if (z3) {
                        c0646b.f9609h.add(new PlaybackStats.EventTimeAndException(eventTime5, exc));
                    }
                }
                int playbackState2 = player.getPlaybackState();
                if (!c0646b.f9591J && c0646b.f9592K) {
                    i7 = 5;
                } else if (!c0646b.f9594M) {
                    i7 = 13;
                } else if (!c0646b.f9592K) {
                    i7 = c0646b.f9595N;
                } else if (c0646b.f9593L) {
                    i7 = 14;
                } else if (playbackState2 == 4) {
                    i7 = 11;
                } else if (playbackState2 == 2) {
                    int i8 = c0646b.f9589H;
                    if (i8 != 0 && i8 != 1 && i8 != 2 && i8 != 14) {
                        if (!player.getPlayWhenReady()) {
                            i7 = 7;
                        } else {
                            if (player.getPlaybackSuppressionReason() != 0) {
                                c = '\n';
                            } else {
                                c = 6;
                            }
                            i7 = c;
                        }
                    }
                } else {
                    i7 = playbackState2 == 3 ? !player.getPlayWhenReady() ? 4 : player.getPlaybackSuppressionReason() != 0 ? 9 : 3 : (playbackState2 != 1 || c0646b.f9589H == 0) ? c0646b.f9589H : 12;
                }
                float f = player.getPlaybackParameters().speed;
                if (c0646b.f9589H == i7 || c0646b.f9601T != f) {
                    long j7 = eventTime5.realtimeMs;
                    if (!booleanValue) {
                        j3 = eventTime5.eventPlaybackPositionMs;
                    } else {
                        j3 = -9223372036854775807L;
                    }
                    c0646b.m2440h(j7, j3);
                    c0646b.m2437e(eventTime5.realtimeMs);
                    c0646b.m2436d(eventTime5.realtimeMs);
                }
                c0646b.f9601T = f;
                if (c0646b.f9589H == i7) {
                    c0646b.m2442j(eventTime5, i7);
                }
                playbackStatsListener = this;
                events2 = events;
                hashMap2 = hashMap3;
                it = it2;
                defaultPlaybackSessionManager = defaultPlaybackSessionManager3;
            }
            if (c0646b.f9592K) {
                currentTracks = player.getCurrentTracks();
                if (currentTracks.isTypeSelected(2)) {
                }
                if (!currentTracks.isTypeSelected(1)) {
                }
            }
            if (format != null) {
            }
            if (format2 != null) {
            }
            format3 = c0646b.f9597P;
            if (format3 != null) {
                c0646b.m2441i(eventTime5, format3.buildUpon().setWidth(videoSize.width).setHeight(videoSize.height).build());
            }
            if (m2429a4) {
            }
            if (m2429a3) {
            }
            c0646b.f9585D += i6;
            c0646b.f9583B += j6;
            c0646b.f9584C += j5;
            if (exc != null) {
            }
            int playbackState22 = player.getPlaybackState();
            if (!c0646b.f9591J) {
            }
            if (!c0646b.f9594M) {
            }
            float f2 = player.getPlaybackParameters().speed;
            if (c0646b.f9589H == i7) {
            }
            long j72 = eventTime5.realtimeMs;
            if (!booleanValue) {
            }
            c0646b.m2440h(j72, j3);
            c0646b.m2437e(eventTime5.realtimeMs);
            c0646b.m2436d(eventTime5.realtimeMs);
            c0646b.f9601T = f2;
            if (c0646b.f9589H == i7) {
            }
            playbackStatsListener = this;
            events2 = events;
            hashMap2 = hashMap3;
            it = it2;
            defaultPlaybackSessionManager = defaultPlaybackSessionManager3;
        }
        PlaybackStatsListener playbackStatsListener2 = playbackStatsListener;
        AnalyticsListener.Events events3 = events2;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager4 = defaultPlaybackSessionManager;
        playbackStatsListener2.f9571o = null;
        playbackStatsListener2.f9572p = null;
        playbackStatsListener2.f9564h = null;
        if (events3.contains(AnalyticsListener.EVENT_PLAYER_RELEASED)) {
            defaultPlaybackSessionManager4.finishAllSessions(events3.getEventTime(AnalyticsListener.EVENT_PLAYER_RELEASED));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AbstractC1862u7.m7610H(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AbstractC1862u7.m7611I(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AbstractC1862u7.m7612J(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AbstractC1862u7.m7613K(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.f9568l = iOException;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AbstractC1862u7.m7615M(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AbstractC1862u7.m7616N(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onMaxSeekToPreviousPositionChanged(AnalyticsListener.EventTime eventTime, long j) {
        AbstractC1862u7.m7617O(this, eventTime, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
        AbstractC1862u7.m7618P(this, eventTime, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        AbstractC1862u7.m7619Q(this, eventTime, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        AbstractC1862u7.m7620R(this, eventTime, metadata);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        AbstractC1862u7.m7621S(this, eventTime, z, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        AbstractC1862u7.m7622T(this, eventTime, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        AbstractC1862u7.m7623U(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        AbstractC1862u7.m7624V(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        AbstractC1862u7.m7625W(this, eventTime, playbackException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlayerErrorChanged(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        AbstractC1862u7.m7626X(this, eventTime, playbackException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7627Y(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        AbstractC1862u7.m7628Z(this, eventTime, z, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPlaylistMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        AbstractC1862u7.m7630a0(this, eventTime, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        AbstractC1862u7.m7632b0(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j) {
        AbstractC1862u7.m7636d0(this, eventTime, obj, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        AbstractC1862u7.m7638e0(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onSeekBackIncrementChanged(AnalyticsListener.EventTime eventTime, long j) {
        AbstractC1862u7.m7640f0(this, eventTime, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onSeekForwardIncrementChanged(AnalyticsListener.EventTime eventTime, long j) {
        AbstractC1862u7.m7642g0(this, eventTime, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7644h0(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7646i0(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        ((C0646b) Assertions.checkNotNull((C0646b) this.f9558b.get(str))).f9592K = true;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
        this.f9558b.put(str, new C0646b(eventTime, this.f9561e));
        this.f9559c.put(str, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        long j;
        C0646b c0646b = (C0646b) Assertions.checkNotNull((C0646b) this.f9558b.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.checkNotNull((AnalyticsListener.EventTime) this.f9559c.remove(str));
        if (str.equals(this.f9564h)) {
            j = this.f9565i;
        } else {
            j = C0643C.TIME_UNSET;
        }
        int i = 11;
        if (c0646b.f9589H != 11 && !z) {
            i = 15;
        }
        c0646b.m2440h(eventTime.realtimeMs, j);
        c0646b.m2437e(eventTime.realtimeMs);
        c0646b.m2436d(eventTime.realtimeMs);
        c0646b.m2442j(eventTime, i);
        PlaybackStats m2434a = c0646b.m2434a(true);
        this.f9563g = PlaybackStats.merge(this.f9563g, m2434a);
        Callback callback = this.f9560d;
        if (callback != null) {
            callback.onPlaybackStatsReady(eventTime2, m2434a);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AbstractC1862u7.m7648j0(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AbstractC1862u7.m7650k0(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        AbstractC1862u7.m7652l0(this, eventTime, i, i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        AbstractC1862u7.m7654m0(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onTrackSelectionParametersChanged(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        AbstractC1862u7.m7656n0(this, eventTime, trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onTracksChanged(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        AbstractC1862u7.m7658o0(this, eventTime, tracks);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        AbstractC1862u7.m7660p0(this, eventTime, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC1862u7.m7662q0(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        AbstractC1862u7.m7664r0(this, eventTime, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        AbstractC1862u7.m7668t0(this, eventTime, str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AbstractC1862u7.m7670u0(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AbstractC1862u7.m7672v0(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
        AbstractC1862u7.m7674w0(this, eventTime, j, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        AbstractC1862u7.m7676x0(this, eventTime, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        AbstractC1862u7.m7680z0(this, eventTime, i, i2, i3, f);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        AbstractC1862u7.m7604B0(this, eventTime, f);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
        AbstractC1862u7.m7635d(this, eventTime, str, j, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AbstractC1862u7.m7645i(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onCues(AnalyticsListener.EventTime eventTime, List list) {
        AbstractC1862u7.m7661q(this, eventTime, list);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i) {
        AbstractC1862u7.m7605C(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        if (this.f9564h == null) {
            this.f9564h = this.f9557a.getActiveSessionId();
            this.f9565i = positionInfo.positionMs;
        }
        this.f9566j = i;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
        AbstractC1862u7.m7666s0(this, eventTime, str, j, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AbstractC1862u7.m7678y0(this, eventTime, format, decoderReuseEvaluation);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f9573q = videoSize;
    }
}
