package com.google.android.exoplayer2.analytics;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.UnmodifiableIterator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import p000.AbstractC1862u7;
import p000.h71;
import p000.ol1;
import p000.pl1;

@RequiresApi(31)
/* loaded from: classes.dex */
public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager.Listener {

    /* renamed from: A */
    public boolean f9529A;

    /* renamed from: a */
    public final Context f9530a;

    /* renamed from: b */
    public final DefaultPlaybackSessionManager f9531b;

    /* renamed from: c */
    public final PlaybackSession f9532c;

    /* renamed from: i */
    public String f9538i;

    /* renamed from: j */
    public PlaybackMetrics.Builder f9539j;

    /* renamed from: k */
    public int f9540k;

    /* renamed from: n */
    public PlaybackException f9543n;

    /* renamed from: o */
    public h71 f9544o;

    /* renamed from: p */
    public h71 f9545p;

    /* renamed from: q */
    public h71 f9546q;

    /* renamed from: r */
    public Format f9547r;

    /* renamed from: s */
    public Format f9548s;

    /* renamed from: t */
    public Format f9549t;

    /* renamed from: u */
    public boolean f9550u;

    /* renamed from: v */
    public int f9551v;

    /* renamed from: w */
    public boolean f9552w;

    /* renamed from: x */
    public int f9553x;

    /* renamed from: y */
    public int f9554y;

    /* renamed from: z */
    public int f9555z;

    /* renamed from: e */
    public final Timeline.Window f9534e = new Timeline.Window();

    /* renamed from: f */
    public final Timeline.Period f9535f = new Timeline.Period();

    /* renamed from: h */
    public final HashMap f9537h = new HashMap();

    /* renamed from: g */
    public final HashMap f9536g = new HashMap();

    /* renamed from: d */
    public final long f9533d = SystemClock.elapsedRealtime();

    /* renamed from: l */
    public int f9541l = 0;

    /* renamed from: m */
    public int f9542m = 0;

    public MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.f9530a = context.getApplicationContext();
        this.f9532c = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.f9531b = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    @Nullable
    public static MediaMetricsListener create(Context context) {
        PlaybackSession createPlaybackSession;
        MediaMetricsManager m6688b = ol1.m6688b(context.getSystemService("media_metrics"));
        if (m6688b != null) {
            createPlaybackSession = m6688b.createPlaybackSession();
            return new MediaMetricsListener(context, createPlaybackSession);
        }
        return null;
    }

    /* renamed from: a */
    public final boolean m2425a(h71 h71Var) {
        if (h71Var != null) {
            if (((String) h71Var.f17966c).equals(this.f9531b.getActiveSessionId())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m2426b() {
        long longValue;
        long longValue2;
        int i;
        PlaybackMetrics build;
        PlaybackMetrics.Builder builder = this.f9539j;
        if (builder != null && this.f9529A) {
            builder.setAudioUnderrunCount(this.f9555z);
            this.f9539j.setVideoFramesDropped(this.f9553x);
            this.f9539j.setVideoFramesPlayed(this.f9554y);
            Long l = (Long) this.f9536g.get(this.f9538i);
            PlaybackMetrics.Builder builder2 = this.f9539j;
            if (l == null) {
                longValue = 0;
            } else {
                longValue = l.longValue();
            }
            builder2.setNetworkTransferDurationMillis(longValue);
            Long l2 = (Long) this.f9537h.get(this.f9538i);
            PlaybackMetrics.Builder builder3 = this.f9539j;
            if (l2 == null) {
                longValue2 = 0;
            } else {
                longValue2 = l2.longValue();
            }
            builder3.setNetworkBytesRead(longValue2);
            PlaybackMetrics.Builder builder4 = this.f9539j;
            if (l2 != null && l2.longValue() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            builder4.setStreamSource(i);
            PlaybackSession playbackSession = this.f9532c;
            build = this.f9539j.build();
            playbackSession.reportPlaybackMetrics(build);
        }
        this.f9539j = null;
        this.f9538i = null;
        this.f9555z = 0;
        this.f9553x = 0;
        this.f9554y = 0;
        this.f9547r = null;
        this.f9548s = null;
        this.f9549t = null;
        this.f9529A = false;
    }

    /* renamed from: c */
    public final void m2427c(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        int indexOfPeriod;
        int i;
        PlaybackMetrics.Builder builder = this.f9539j;
        if (mediaPeriodId == null || (indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) == -1) {
            return;
        }
        Timeline.Period period = this.f9535f;
        timeline.getPeriod(indexOfPeriod, period);
        int i2 = period.windowIndex;
        Timeline.Window window = this.f9534e;
        timeline.getWindow(i2, window);
        MediaItem.LocalConfiguration localConfiguration = window.mediaItem.localConfiguration;
        int i3 = 2;
        if (localConfiguration == null) {
            i = 0;
        } else {
            int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(localConfiguration.uri, localConfiguration.mimeType);
            if (inferContentTypeForUriAndMimeType != 0) {
                if (inferContentTypeForUriAndMimeType != 1) {
                    if (inferContentTypeForUriAndMimeType != 2) {
                        i = 1;
                    } else {
                        i = 4;
                    }
                } else {
                    i = 5;
                }
            } else {
                i = 3;
            }
        }
        builder.setStreamType(i);
        if (window.durationUs != C0643C.TIME_UNSET && !window.isPlaceholder && !window.isDynamic && !window.isLive()) {
            builder.setMediaDurationMillis(window.getDurationMs());
        }
        if (!window.isLive()) {
            i3 = 1;
        }
        builder.setPlaybackType(i3);
        this.f9529A = true;
    }

    /* renamed from: d */
    public final void m2428d(int i, long j, Format format, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis;
        TrackChangeEvent build;
        int i3;
        String str;
        timeSinceCreatedMillis = ol1.m6696j(i).setTimeSinceCreatedMillis(j - this.f9533d);
        if (format != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i2 != 1) {
                i3 = 3;
                if (i2 != 2) {
                    if (i2 != 3) {
                        i3 = 1;
                    } else {
                        i3 = 4;
                    }
                }
            } else {
                i3 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i3);
            String str2 = format.containerMimeType;
            if (str2 != null) {
                timeSinceCreatedMillis.setContainerMimeType(str2);
            }
            String str3 = format.sampleMimeType;
            if (str3 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str3);
            }
            String str4 = format.codecs;
            if (str4 != null) {
                timeSinceCreatedMillis.setCodecName(str4);
            }
            int i4 = format.bitrate;
            if (i4 != -1) {
                timeSinceCreatedMillis.setBitrate(i4);
            }
            int i5 = format.width;
            if (i5 != -1) {
                timeSinceCreatedMillis.setWidth(i5);
            }
            int i6 = format.height;
            if (i6 != -1) {
                timeSinceCreatedMillis.setHeight(i6);
            }
            int i7 = format.channelCount;
            if (i7 != -1) {
                timeSinceCreatedMillis.setChannelCount(i7);
            }
            int i8 = format.sampleRate;
            if (i8 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i8);
            }
            String str5 = format.language;
            if (str5 != null) {
                String[] split = Util.split(str5, "-");
                String str6 = split[0];
                if (split.length >= 2) {
                    str = split[1];
                } else {
                    str = null;
                }
                Pair create = Pair.create(str6, str);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = format.frameRate;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.f9529A = true;
        PlaybackSession playbackSession = this.f9532c;
        build = timeSinceCreatedMillis.build();
        playbackSession.reportTrackChangeEvent(build);
    }

    public LogSessionId getLogSessionId() {
        LogSessionId sessionId;
        sessionId = this.f9532c.getSessionId();
        return sessionId;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
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
        long longValue;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null) {
            String sessionForMediaPeriodId = this.f9531b.getSessionForMediaPeriodId(eventTime.timeline, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
            HashMap hashMap = this.f9537h;
            Long l = (Long) hashMap.get(sessionForMediaPeriodId);
            HashMap hashMap2 = this.f9536g;
            Long l2 = (Long) hashMap2.get(sessionForMediaPeriodId);
            long j3 = 0;
            if (l == null) {
                longValue = 0;
            } else {
                longValue = l.longValue();
            }
            hashMap.put(sessionForMediaPeriodId, Long.valueOf(longValue + j));
            if (l2 != null) {
                j3 = l2.longValue();
            }
            hashMap2.put(sessionForMediaPeriodId, Long.valueOf(j3 + i));
        }
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
        if (eventTime.mediaPeriodId == null) {
            return;
        }
        h71 h71Var = new h71((Format) Assertions.checkNotNull(mediaLoadData.trackFormat), mediaLoadData.trackSelectionReason, this.f9531b.getSessionForMediaPeriodId(eventTime.timeline, (MediaSource.MediaPeriodId) Assertions.checkNotNull(eventTime.mediaPeriodId)));
        int i = mediaLoadData.trackType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f9546q = h71Var;
                        return;
                    }
                    return;
                }
            } else {
                this.f9545p = h71Var;
                return;
            }
        }
        this.f9544o = h71Var;
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
    public final /* synthetic */ void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC1862u7.m7606D(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7607E(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        AbstractC1862u7.m7608F(this, eventTime, i, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x042f  */
    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onEvents(Player player, AnalyticsListener.Events events) {
        DefaultPlaybackSessionManager defaultPlaybackSessionManager;
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        char c;
        pl1 pl1Var;
        pl1 pl1Var2;
        int i5;
        int i6;
        char c2;
        pl1 pl1Var3;
        PlaybackErrorEvent.Builder timeSinceCreatedMillis;
        PlaybackErrorEvent.Builder errorCode;
        PlaybackErrorEvent.Builder subErrorCode;
        PlaybackErrorEvent.Builder exception;
        PlaybackErrorEvent build;
        int i7;
        int i8;
        Context context;
        int i9;
        int i10;
        int i11;
        int i12;
        PlaybackStateEvent.Builder state;
        PlaybackStateEvent.Builder timeSinceCreatedMillis2;
        PlaybackStateEvent build2;
        NetworkEvent.Builder networkType;
        NetworkEvent.Builder timeSinceCreatedMillis3;
        NetworkEvent build3;
        int i13;
        int i14;
        int i15;
        Format format;
        int i16;
        int i17;
        int i18;
        DrmInitData drmInitData;
        int i19;
        if (events.size() == 0) {
            return;
        }
        int i20 = 0;
        while (true) {
            int size = events.size();
            defaultPlaybackSessionManager = this.f9531b;
            if (i20 >= size) {
                break;
            }
            int i21 = events.get(i20);
            AnalyticsListener.EventTime eventTime = events.getEventTime(i21);
            if (i21 == 0) {
                defaultPlaybackSessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i21 == 11) {
                defaultPlaybackSessionManager.updateSessionsWithDiscontinuity(eventTime, this.f9540k);
            } else {
                defaultPlaybackSessionManager.updateSessions(eventTime);
            }
            i20++;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (events.contains(0)) {
            AnalyticsListener.EventTime eventTime2 = events.getEventTime(0);
            if (this.f9539j != null) {
                m2427c(eventTime2.timeline, eventTime2.mediaPeriodId);
            }
        }
        if (events.contains(2) && this.f9539j != null) {
            UnmodifiableIterator<Tracks.Group> it = player.getCurrentTracks().getGroups().iterator();
            loop1: while (true) {
                if (it.hasNext()) {
                    Tracks.Group next = it.next();
                    for (int i22 = 0; i22 < next.length; i22++) {
                        if (next.isTrackSelected(i22) && (drmInitData = next.getTrackFormat(i22).drmInitData) != null) {
                            break loop1;
                        }
                    }
                } else {
                    drmInitData = null;
                    break;
                }
            }
            if (drmInitData != null) {
                PlaybackMetrics.Builder m6693g = ol1.m6693g(Util.castNonNull(this.f9539j));
                int i23 = 0;
                while (true) {
                    if (i23 < drmInitData.schemeDataCount) {
                        UUID uuid = drmInitData.get(i23).uuid;
                        if (uuid.equals(C0643C.WIDEVINE_UUID)) {
                            i19 = 3;
                            break;
                        } else if (uuid.equals(C0643C.PLAYREADY_UUID)) {
                            i19 = 2;
                            break;
                        } else {
                            if (uuid.equals(C0643C.CLEARKEY_UUID)) {
                                i19 = 6;
                                break;
                            }
                            i23++;
                        }
                    } else {
                        i19 = 1;
                        break;
                    }
                }
                m6693g.setDrmType(i19);
            }
        }
        if (events.contains(1011)) {
            this.f9555z++;
        }
        PlaybackException playbackException = this.f9543n;
        Context context2 = this.f9530a;
        long j = this.f9533d;
        if (playbackException == null) {
            c = 4;
            i7 = 1;
            i8 = 2;
            i2 = 6;
            i3 = 7;
            i4 = 9;
        } else {
            if (this.f9551v == 4) {
                z = true;
            } else {
                z = false;
            }
            if (playbackException.errorCode == 1001) {
                pl1Var = new pl1(20, 0);
            } else {
                if (playbackException instanceof ExoPlaybackException) {
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
                    if (exoPlaybackException.type == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    i = exoPlaybackException.rendererFormatSupport;
                } else {
                    i = 0;
                    z2 = false;
                }
                Throwable th = (Throwable) Assertions.checkNotNull(playbackException.getCause());
                int i24 = 27;
                if (th instanceof IOException) {
                    if (th instanceof HttpDataSource.InvalidResponseCodeException) {
                        pl1Var3 = new pl1(5, ((HttpDataSource.InvalidResponseCodeException) th).responseCode);
                    } else if (!(th instanceof HttpDataSource.InvalidContentTypeException) && !(th instanceof ParserException)) {
                        boolean z3 = th instanceof HttpDataSource.HttpDataSourceException;
                        if (z3 || (th instanceof UdpDataSource.UdpDataSourceException)) {
                            i6 = 9;
                            if (NetworkTypeObserver.getInstance(context2).getNetworkType() == 1) {
                                pl1Var = new pl1(3, 0);
                            } else {
                                Throwable cause = th.getCause();
                                if (cause instanceof UnknownHostException) {
                                    pl1Var = new pl1(6, 0);
                                    i4 = 9;
                                    i2 = 6;
                                    i3 = 7;
                                    c = 4;
                                    PlaybackSession playbackSession = this.f9532c;
                                    timeSinceCreatedMillis = ol1.m6690d().setTimeSinceCreatedMillis(elapsedRealtime - j);
                                    errorCode = timeSinceCreatedMillis.setErrorCode(pl1Var.f25214a);
                                    subErrorCode = errorCode.setSubErrorCode(pl1Var.f25215b);
                                    exception = subErrorCode.setException(playbackException);
                                    build = exception.build();
                                    playbackSession.reportPlaybackErrorEvent(build);
                                    i7 = 1;
                                    this.f9529A = true;
                                    this.f9543n = null;
                                    i8 = 2;
                                } else if (cause instanceof SocketTimeoutException) {
                                    pl1Var = new pl1(7, 0);
                                    i4 = 9;
                                    i3 = 7;
                                    i2 = 6;
                                    c = 4;
                                    PlaybackSession playbackSession2 = this.f9532c;
                                    timeSinceCreatedMillis = ol1.m6690d().setTimeSinceCreatedMillis(elapsedRealtime - j);
                                    errorCode = timeSinceCreatedMillis.setErrorCode(pl1Var.f25214a);
                                    subErrorCode = errorCode.setSubErrorCode(pl1Var.f25215b);
                                    exception = subErrorCode.setException(playbackException);
                                    build = exception.build();
                                    playbackSession2.reportPlaybackErrorEvent(build);
                                    i7 = 1;
                                    this.f9529A = true;
                                    this.f9543n = null;
                                    i8 = 2;
                                } else {
                                    if (z3 && ((HttpDataSource.HttpDataSourceException) th).type == 1) {
                                        c2 = 4;
                                        pl1Var = new pl1(4, 0);
                                    } else {
                                        c2 = 4;
                                        pl1Var = new pl1(8, 0);
                                    }
                                    i4 = 9;
                                    i3 = 7;
                                    c = c2;
                                    i2 = 6;
                                }
                            }
                        } else if (playbackException.errorCode == 1002) {
                            pl1Var = new pl1(21, 0);
                        } else if (th instanceof DrmSession.DrmSessionException) {
                            Throwable th2 = (Throwable) Assertions.checkNotNull(th.getCause());
                            int i25 = Util.SDK_INT;
                            if (i25 >= 21 && (th2 instanceof MediaDrm.MediaDrmStateException)) {
                                int errorCodeFromPlatformDiagnosticsInfo = Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
                                switch (Util.getErrorCodeForMediaDrmErrorCode(errorCodeFromPlatformDiagnosticsInfo)) {
                                    case PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED /* 6002 */:
                                        i24 = 24;
                                        break;
                                    case PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR /* 6003 */:
                                        i24 = 28;
                                        break;
                                    case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED /* 6004 */:
                                        i24 = 25;
                                        break;
                                    case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION /* 6005 */:
                                        i24 = 26;
                                        break;
                                }
                                pl1Var3 = new pl1(i24, errorCodeFromPlatformDiagnosticsInfo);
                            } else if (i25 >= 23 && (th2 instanceof MediaDrmResetException)) {
                                pl1Var = new pl1(27, 0);
                            } else if (i25 >= 18 && (th2 instanceof NotProvisionedException)) {
                                pl1Var = new pl1(24, 0);
                            } else if (i25 >= 18 && (th2 instanceof DeniedByServerException)) {
                                pl1Var = new pl1(29, 0);
                            } else if (th2 instanceof UnsupportedDrmException) {
                                pl1Var = new pl1(23, 0);
                            } else if (th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
                                pl1Var = new pl1(28, 0);
                            } else {
                                pl1Var = new pl1(30, 0);
                            }
                        } else if ((th instanceof FileDataSource.FileDataSourceException) && (th.getCause() instanceof FileNotFoundException)) {
                            Throwable cause2 = ((Throwable) Assertions.checkNotNull(th.getCause())).getCause();
                            if (Util.SDK_INT >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) {
                                pl1Var = new pl1(32, 0);
                            } else {
                                pl1Var = new pl1(31, 0);
                            }
                        } else {
                            i6 = 9;
                            pl1Var = new pl1(9, 0);
                        }
                        i4 = i6;
                        i2 = 6;
                        i3 = 7;
                        c = 4;
                        PlaybackSession playbackSession22 = this.f9532c;
                        timeSinceCreatedMillis = ol1.m6690d().setTimeSinceCreatedMillis(elapsedRealtime - j);
                        errorCode = timeSinceCreatedMillis.setErrorCode(pl1Var.f25214a);
                        subErrorCode = errorCode.setSubErrorCode(pl1Var.f25215b);
                        exception = subErrorCode.setException(playbackException);
                        build = exception.build();
                        playbackSession22.reportPlaybackErrorEvent(build);
                        i7 = 1;
                        this.f9529A = true;
                        this.f9543n = null;
                        i8 = 2;
                    } else {
                        if (z) {
                            i5 = 10;
                        } else {
                            i5 = 11;
                        }
                        i4 = 9;
                        i3 = 7;
                        c = 4;
                        i2 = 6;
                        pl1Var = new pl1(i5, 0);
                    }
                    pl1Var = pl1Var3;
                } else {
                    i2 = 6;
                    i3 = 7;
                    i4 = 9;
                    c = 4;
                    if (z2 && (i == 0 || i == 1)) {
                        pl1Var = new pl1(35, 0);
                    } else if (z2 && i == 3) {
                        pl1Var = new pl1(15, 0);
                    } else if (z2 && i == 2) {
                        pl1Var = new pl1(23, 0);
                    } else {
                        if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                            pl1Var2 = new pl1(13, Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaCodecRenderer.DecoderInitializationException) th).diagnosticInfo));
                        } else {
                            if (th instanceof MediaCodecDecoderException) {
                                pl1Var = new pl1(14, Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaCodecDecoderException) th).diagnosticInfo));
                            } else if (th instanceof OutOfMemoryError) {
                                pl1Var = new pl1(14, 0);
                            } else if (th instanceof AudioSink.InitializationException) {
                                pl1Var2 = new pl1(17, ((AudioSink.InitializationException) th).audioTrackState);
                            } else if (th instanceof AudioSink.WriteException) {
                                pl1Var2 = new pl1(18, ((AudioSink.WriteException) th).errorCode);
                            } else if (Util.SDK_INT >= 16 && (th instanceof MediaCodec.CryptoException)) {
                                int errorCode2 = ((MediaCodec.CryptoException) th).getErrorCode();
                                switch (Util.getErrorCodeForMediaDrmErrorCode(errorCode2)) {
                                    case PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED /* 6002 */:
                                        i24 = 24;
                                        break;
                                    case PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR /* 6003 */:
                                        i24 = 28;
                                        break;
                                    case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED /* 6004 */:
                                        i24 = 25;
                                        break;
                                    case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION /* 6005 */:
                                        i24 = 26;
                                        break;
                                }
                                pl1Var2 = new pl1(i24, errorCode2);
                            } else {
                                pl1Var = new pl1(22, 0);
                            }
                            PlaybackSession playbackSession222 = this.f9532c;
                            timeSinceCreatedMillis = ol1.m6690d().setTimeSinceCreatedMillis(elapsedRealtime - j);
                            errorCode = timeSinceCreatedMillis.setErrorCode(pl1Var.f25214a);
                            subErrorCode = errorCode.setSubErrorCode(pl1Var.f25215b);
                            exception = subErrorCode.setException(playbackException);
                            build = exception.build();
                            playbackSession222.reportPlaybackErrorEvent(build);
                            i7 = 1;
                            this.f9529A = true;
                            this.f9543n = null;
                            i8 = 2;
                        }
                        pl1Var = pl1Var2;
                        PlaybackSession playbackSession2222 = this.f9532c;
                        timeSinceCreatedMillis = ol1.m6690d().setTimeSinceCreatedMillis(elapsedRealtime - j);
                        errorCode = timeSinceCreatedMillis.setErrorCode(pl1Var.f25214a);
                        subErrorCode = errorCode.setSubErrorCode(pl1Var.f25215b);
                        exception = subErrorCode.setException(playbackException);
                        build = exception.build();
                        playbackSession2222.reportPlaybackErrorEvent(build);
                        i7 = 1;
                        this.f9529A = true;
                        this.f9543n = null;
                        i8 = 2;
                    }
                }
                PlaybackSession playbackSession22222 = this.f9532c;
                timeSinceCreatedMillis = ol1.m6690d().setTimeSinceCreatedMillis(elapsedRealtime - j);
                errorCode = timeSinceCreatedMillis.setErrorCode(pl1Var.f25214a);
                subErrorCode = errorCode.setSubErrorCode(pl1Var.f25215b);
                exception = subErrorCode.setException(playbackException);
                build = exception.build();
                playbackSession22222.reportPlaybackErrorEvent(build);
                i7 = 1;
                this.f9529A = true;
                this.f9543n = null;
                i8 = 2;
            }
            i2 = 6;
            i3 = 7;
            i4 = 9;
            c = 4;
            PlaybackSession playbackSession222222 = this.f9532c;
            timeSinceCreatedMillis = ol1.m6690d().setTimeSinceCreatedMillis(elapsedRealtime - j);
            errorCode = timeSinceCreatedMillis.setErrorCode(pl1Var.f25214a);
            subErrorCode = errorCode.setSubErrorCode(pl1Var.f25215b);
            exception = subErrorCode.setException(playbackException);
            build = exception.build();
            playbackSession222222.reportPlaybackErrorEvent(build);
            i7 = 1;
            this.f9529A = true;
            this.f9543n = null;
            i8 = 2;
        }
        if (events.contains(i8)) {
            Tracks currentTracks = player.getCurrentTracks();
            boolean isTypeSelected = currentTracks.isTypeSelected(i8);
            boolean isTypeSelected2 = currentTracks.isTypeSelected(i7);
            boolean isTypeSelected3 = currentTracks.isTypeSelected(3);
            if (isTypeSelected || isTypeSelected2 || isTypeSelected3) {
                if (!isTypeSelected) {
                    if (Util.areEqual(this.f9547r, null)) {
                        context = context2;
                        format = null;
                        i9 = 10;
                    } else {
                        if (this.f9547r == null) {
                            i18 = 1;
                        } else {
                            i18 = 0;
                        }
                        this.f9547r = null;
                        context = context2;
                        i9 = 10;
                        i10 = 8;
                        format = null;
                        m2428d(1, elapsedRealtime, null, i18);
                        if (!isTypeSelected2 && !Util.areEqual(this.f9548s, format)) {
                            if (this.f9548s != null) {
                                i17 = 1;
                            } else {
                                i17 = 0;
                            }
                            this.f9548s = format;
                            m2428d(0, elapsedRealtime, format, i17);
                        }
                        if (!isTypeSelected3 && !Util.areEqual(this.f9549t, format)) {
                            if (this.f9549t != null) {
                                i16 = 1;
                            } else {
                                i16 = 0;
                            }
                            this.f9549t = format;
                            m2428d(2, elapsedRealtime, format, i16);
                        }
                        if (m2425a(this.f9544o)) {
                            h71 h71Var = this.f9544o;
                            Format format2 = (Format) h71Var.f17965b;
                            if (format2.height != -1) {
                                if (!Util.areEqual(this.f9547r, format2)) {
                                    Format format3 = this.f9547r;
                                    int i26 = h71Var.f17964a;
                                    if (format3 == null && i26 == 0) {
                                        i15 = 1;
                                    } else {
                                        i15 = i26;
                                    }
                                    this.f9547r = format2;
                                    m2428d(1, elapsedRealtime, format2, i15);
                                }
                                this.f9544o = null;
                            }
                        }
                        if (m2425a(this.f9545p)) {
                            h71 h71Var2 = this.f9545p;
                            Format format4 = (Format) h71Var2.f17965b;
                            if (!Util.areEqual(this.f9548s, format4)) {
                                Format format5 = this.f9548s;
                                int i27 = h71Var2.f17964a;
                                if (format5 == null && i27 == 0) {
                                    i14 = 1;
                                } else {
                                    i14 = i27;
                                }
                                this.f9548s = format4;
                                m2428d(0, elapsedRealtime, format4, i14);
                            }
                            this.f9545p = null;
                        }
                        if (m2425a(this.f9546q)) {
                            h71 h71Var3 = this.f9546q;
                            Format format6 = (Format) h71Var3.f17965b;
                            if (!Util.areEqual(this.f9549t, format6)) {
                                Format format7 = this.f9549t;
                                int i28 = h71Var3.f17964a;
                                if (format7 == null && i28 == 0) {
                                    i13 = 1;
                                } else {
                                    i13 = i28;
                                }
                                this.f9549t = format6;
                                m2428d(2, elapsedRealtime, format6, i13);
                            }
                            this.f9546q = null;
                        }
                        switch (NetworkTypeObserver.getInstance(context).getNetworkType()) {
                            case 0:
                                i11 = 0;
                                break;
                            case 1:
                                i11 = i4;
                                break;
                            case 2:
                                i11 = 2;
                                break;
                            case 3:
                                i11 = 4;
                                break;
                            case 4:
                                i11 = 5;
                                break;
                            case 5:
                                i11 = i2;
                                break;
                            case 6:
                            case 8:
                            default:
                                i11 = 1;
                                break;
                            case 7:
                                i11 = 3;
                                break;
                            case 9:
                                i11 = i10;
                                break;
                            case 10:
                                i11 = i3;
                                break;
                        }
                        if (i11 != this.f9542m) {
                            this.f9542m = i11;
                            PlaybackSession playbackSession3 = this.f9532c;
                            networkType = ol1.m6689c().setNetworkType(i11);
                            timeSinceCreatedMillis3 = networkType.setTimeSinceCreatedMillis(elapsedRealtime - j);
                            build3 = timeSinceCreatedMillis3.build();
                            playbackSession3.reportNetworkEvent(build3);
                        }
                        if (player.getPlaybackState() != 2) {
                            this.f9550u = false;
                        }
                        if (player.getPlayerError() == null) {
                            this.f9552w = false;
                        } else if (events.contains(i9)) {
                            this.f9552w = true;
                        }
                        int playbackState = player.getPlaybackState();
                        if (this.f9550u) {
                            i12 = 5;
                        } else if (this.f9552w) {
                            i12 = 13;
                        } else if (playbackState == 4) {
                            i12 = 11;
                        } else {
                            int i29 = 2;
                            if (playbackState == 2) {
                                int i30 = this.f9541l;
                                if (i30 != 0 && i30 != 2) {
                                    if (!player.getPlayWhenReady()) {
                                        i12 = i3;
                                    } else {
                                        if (player.getPlaybackSuppressionReason() != 0) {
                                            i2 = i9;
                                        }
                                        i12 = i2;
                                    }
                                }
                                i12 = i29;
                            } else {
                                i29 = 3;
                                if (playbackState == 3) {
                                    if (!player.getPlayWhenReady()) {
                                        i12 = 4;
                                    } else {
                                        if (player.getPlaybackSuppressionReason() != 0) {
                                            i29 = i4;
                                        }
                                        i12 = i29;
                                    }
                                } else if (playbackState == 1 && this.f9541l != 0) {
                                    i12 = 12;
                                } else {
                                    i12 = this.f9541l;
                                }
                            }
                        }
                        if (this.f9541l != i12) {
                            this.f9541l = i12;
                            this.f9529A = true;
                            PlaybackSession playbackSession4 = this.f9532c;
                            state = ol1.m6695i().setState(this.f9541l);
                            timeSinceCreatedMillis2 = state.setTimeSinceCreatedMillis(elapsedRealtime - j);
                            build2 = timeSinceCreatedMillis2.build();
                            playbackSession4.reportPlaybackStateEvent(build2);
                        }
                        if (events.contains(AnalyticsListener.EVENT_PLAYER_RELEASED)) {
                            defaultPlaybackSessionManager.finishAllSessions(events.getEventTime(AnalyticsListener.EVENT_PLAYER_RELEASED));
                            return;
                        }
                        return;
                    }
                } else {
                    context = context2;
                    i9 = 10;
                    format = null;
                }
                i10 = 8;
                if (!isTypeSelected2) {
                    if (this.f9548s != null) {
                    }
                    this.f9548s = format;
                    m2428d(0, elapsedRealtime, format, i17);
                }
                if (!isTypeSelected3) {
                    if (this.f9549t != null) {
                    }
                    this.f9549t = format;
                    m2428d(2, elapsedRealtime, format, i16);
                }
                if (m2425a(this.f9544o)) {
                }
                if (m2425a(this.f9545p)) {
                }
                if (m2425a(this.f9546q)) {
                }
                switch (NetworkTypeObserver.getInstance(context).getNetworkType()) {
                }
                if (i11 != this.f9542m) {
                }
                if (player.getPlaybackState() != 2) {
                }
                if (player.getPlayerError() == null) {
                }
                int playbackState2 = player.getPlaybackState();
                if (this.f9550u) {
                }
                if (this.f9541l != i12) {
                }
                if (events.contains(AnalyticsListener.EVENT_PLAYER_RELEASED)) {
                }
            }
        }
        context = context2;
        i9 = 10;
        i10 = 8;
        if (m2425a(this.f9544o)) {
        }
        if (m2425a(this.f9545p)) {
        }
        if (m2425a(this.f9546q)) {
        }
        switch (NetworkTypeObserver.getInstance(context).getNetworkType()) {
        }
        if (i11 != this.f9542m) {
        }
        if (player.getPlaybackState() != 2) {
        }
        if (player.getPlayerError() == null) {
        }
        int playbackState22 = player.getPlaybackState();
        if (this.f9550u) {
        }
        if (this.f9541l != i12) {
        }
        if (events.contains(AnalyticsListener.EVENT_PLAYER_RELEASED)) {
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
        this.f9551v = mediaLoadData.dataType;
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
    public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f9543n = playbackException;
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
        PlaybackMetrics.Builder playerName;
        PlaybackMetrics.Builder playerVersion;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null && mediaPeriodId.isAd()) {
            return;
        }
        m2426b();
        this.f9538i = str;
        playerName = ol1.m6691e().setPlayerName(ExoPlayerLibraryInfo.TAG);
        playerVersion = playerName.setPlayerVersion(ExoPlayerLibraryInfo.VERSION);
        this.f9539j = playerVersion;
        m2427c(eventTime.timeline, eventTime.mediaPeriodId);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if ((mediaPeriodId == null || !mediaPeriodId.isAd()) && str.equals(this.f9538i)) {
            m2426b();
        }
        this.f9536g.remove(str);
        this.f9537h.remove(str);
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
    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f9553x += decoderCounters.droppedBufferCount;
        this.f9554y += decoderCounters.renderedOutputBufferCount;
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
        if (i == 1) {
            this.f9550u = true;
        }
        this.f9540k = i;
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
        h71 h71Var = this.f9544o;
        if (h71Var != null) {
            Format format = (Format) h71Var.f17965b;
            if (format.height == -1) {
                this.f9544o = new h71(format.buildUpon().setWidth(videoSize.width).setHeight(videoSize.height).build(), h71Var.f17964a, (String) h71Var.f17966c);
            }
        }
    }
}
