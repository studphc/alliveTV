package com.google.android.exoplayer2.util;

import android.text.TextUtils;
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
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import p000.AbstractC1726qj;
import p000.AbstractC1862u7;
import p000.ye0;

/* loaded from: classes.dex */
public class EventLogger implements AnalyticsListener {

    /* renamed from: e */
    public static final NumberFormat f12693e;

    /* renamed from: a */
    public final String f12694a;

    /* renamed from: b */
    public final Timeline.Window f12695b;

    /* renamed from: c */
    public final Timeline.Period f12696c;

    /* renamed from: d */
    public final long f12697d;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f12693e = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger() {
        this("EventLogger");
    }

    /* renamed from: c */
    public static String m3011c(long j) {
        if (j == C0643C.TIME_UNSET) {
            return "?";
        }
        return f12693e.format(((float) j) / 1000.0f);
    }

    /* renamed from: a */
    public final String m3012a(AnalyticsListener.EventTime eventTime, String str, String str2, Exception exc) {
        StringBuilder m8303w = ye0.m8303w(str, " [");
        m8303w.append(m3013b(eventTime));
        String sb = m8303w.toString();
        if (exc instanceof PlaybackException) {
            StringBuilder m8303w2 = ye0.m8303w(sb, ", errorCode=");
            m8303w2.append(((PlaybackException) exc).getErrorCodeName());
            sb = m8303w2.toString();
        }
        if (str2 != null) {
            sb = AbstractC1726qj.m7058n(sb, ", ", str2);
        }
        String throwableString = Log.getThrowableString(exc);
        if (!TextUtils.isEmpty(throwableString)) {
            StringBuilder m8303w3 = ye0.m8303w(sb, "\n  ");
            m8303w3.append(throwableString.replace("\n", "\n  "));
            m8303w3.append('\n');
            sb = m8303w3.toString();
        }
        return AbstractC1726qj.m7057m(sb, "]");
    }

    /* renamed from: b */
    public final String m3013b(AnalyticsListener.EventTime eventTime) {
        String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            StringBuilder m8303w = ye0.m8303w(str, ", period=");
            m8303w.append(eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid));
            str = m8303w.toString();
            if (eventTime.mediaPeriodId.isAd()) {
                StringBuilder m8303w2 = ye0.m8303w(str, ", adGroup=");
                m8303w2.append(eventTime.mediaPeriodId.adGroupIndex);
                StringBuilder m8303w3 = ye0.m8303w(m8303w2.toString(), ", ad=");
                m8303w3.append(eventTime.mediaPeriodId.adIndexInAdGroup);
                str = m8303w3.toString();
            }
        }
        return "eventTime=" + m3011c(eventTime.realtimeMs - this.f12697d) + ", mediaPos=" + m3011c(eventTime.eventPlaybackPositionMs) + ", " + str;
    }

    /* renamed from: d */
    public final void m3014d(AnalyticsListener.EventTime eventTime, String str) {
        logd(m3012a(eventTime, str, null, null));
    }

    /* renamed from: e */
    public final void m3015e(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(m3012a(eventTime, str, str2, null));
    }

    /* renamed from: f */
    public final void m3016f(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            StringBuilder m7064t = AbstractC1726qj.m7064t(str);
            m7064t.append(metadata.get(i));
            logd(m7064t.toString());
        }
    }

    public void logd(String str) {
        Log.m3021d(this.f12694a, str);
    }

    public void loge(String str) {
        Log.m3023e(this.f12694a, str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        m3015e(eventTime, "audioAttributes", audioAttributes.contentType + "," + audioAttributes.flags + "," + audioAttributes.usage + "," + audioAttributes.allowedCapturePolicy);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC1862u7.m7631b(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
        AbstractC1862u7.m7635d(this, eventTime, str, j, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        m3015e(eventTime, "audioDecoderReleased", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        m3014d(eventTime, "audioDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        m3014d(eventTime, "audioEnabled");
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
    public void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i) {
        m3015e(eventTime, "audioSessionId", Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC1862u7.m7651l(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        loge(m3012a(eventTime, "audioTrackUnderrun", i + ", " + j + ", " + j2, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        AbstractC1862u7.m7655n(this, eventTime, commands);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
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
        m3015e(eventTime, "downstreamFormat", Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        m3014d(eventTime, "drmKeysLoaded");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        m3014d(eventTime, "drmKeysRemoved");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        m3014d(eventTime, "drmKeysRestored");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        AbstractC1862u7.m7603B(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        loge(m3012a(eventTime, "internalError", "drmSessionManagerError", exc));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        m3014d(eventTime, "drmSessionReleased");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        m3015e(eventTime, "droppedFrames", Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onEvents(Player player, AnalyticsListener.Events events) {
        AbstractC1862u7.m7609G(this, player, events);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        m3015e(eventTime, "loading", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        m3015e(eventTime, "isPlaying", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        loge(m3012a(eventTime, "internalError", "loadError", iOException));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
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
    public void onMediaItemTransition(AnalyticsListener.EventTime eventTime, @Nullable MediaItem mediaItem, int i) {
        String str;
        StringBuilder sb = new StringBuilder("mediaItem [");
        sb.append(m3013b(eventTime));
        sb.append(", reason=");
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        str = "?";
                    } else {
                        str = "PLAYLIST_CHANGED";
                    }
                } else {
                    str = "SEEK";
                }
            } else {
                str = "AUTO";
            }
        } else {
            str = "REPEAT";
        }
        sb.append(str);
        sb.append("]");
        logd(sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        AbstractC1862u7.m7619Q(this, eventTime, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        logd("metadata [" + m3013b(eventTime));
        m3016f(metadata, "  ");
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        sb.append(", ");
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            str = "?";
                        } else {
                            str = "END_OF_MEDIA_ITEM";
                        }
                    } else {
                        str = "REMOTE";
                    }
                } else {
                    str = "AUDIO_BECOMING_NOISY";
                }
            } else {
                str = "AUDIO_FOCUS_LOSS";
            }
        } else {
            str = "USER_REQUEST";
        }
        sb.append(str);
        m3015e(eventTime, "playWhenReady", sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        m3015e(eventTime, "playbackParameters", playbackParameters.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        String str;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        str = "?";
                    } else {
                        str = "ENDED";
                    }
                } else {
                    str = "READY";
                }
            } else {
                str = "BUFFERING";
            }
        } else {
            str = "IDLE";
        }
        m3015e(eventTime, "state", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        String str;
        if (i != 0) {
            if (i != 1) {
                str = "?";
            } else {
                str = "TRANSIENT_AUDIO_FOCUS_LOSS";
            }
        } else {
            str = "NONE";
        }
        m3015e(eventTime, "playbackSuppressionReason", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        loge(m3012a(eventTime, "playerFailed", null, playbackException));
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
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j) {
        m3015e(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        String str;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    str = "?";
                } else {
                    str = "ALL";
                }
            } else {
                str = "ONE";
            }
        } else {
            str = "OFF";
        }
        m3015e(eventTime, "repeatMode", str);
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

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        m3015e(eventTime, "shuffleModeEnabled", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        m3015e(eventTime, "skipSilenceEnabled", Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        m3015e(eventTime, "surfaceSize", i + ", " + i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        String str;
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        StringBuilder sb = new StringBuilder("timeline [");
        sb.append(m3013b(eventTime));
        sb.append(", periodCount=");
        sb.append(periodCount);
        sb.append(", windowCount=");
        sb.append(windowCount);
        sb.append(", reason=");
        if (i != 0) {
            if (i != 1) {
                str = "?";
            } else {
                str = "SOURCE_UPDATE";
            }
        } else {
            str = "PLAYLIST_CHANGED";
        }
        sb.append(str);
        logd(sb.toString());
        for (int i2 = 0; i2 < Math.min(periodCount, 3); i2++) {
            Timeline timeline = eventTime.timeline;
            Timeline.Period period = this.f12696c;
            timeline.getPeriod(i2, period);
            logd("  period [" + m3011c(period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i3 = 0; i3 < Math.min(windowCount, 3); i3++) {
            Timeline timeline2 = eventTime.timeline;
            Timeline.Window window = this.f12695b;
            timeline2.getWindow(i3, window);
            logd("  window [" + m3011c(window.getDurationMs()) + ", seekable=" + window.isSeekable + ", dynamic=" + window.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onTrackSelectionParametersChanged(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        AbstractC1862u7.m7656n0(this, eventTime, trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        Metadata metadata;
        String str;
        logd("tracks [" + m3013b(eventTime));
        ImmutableList<Tracks.Group> groups = tracks.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            Tracks.Group group = groups.get(i);
            logd("  group [");
            for (int i2 = 0; i2 < group.length; i2++) {
                if (group.isTrackSelected(i2)) {
                    str = "[X]";
                } else {
                    str = "[ ]";
                }
                logd("    " + str + " Track:" + i2 + ", " + Format.toLogString(group.getTrackFormat(i2)) + ", supported=" + Util.getFormatSupportString(group.getTrackSupport(i2)));
            }
            logd("  ]");
        }
        boolean z = false;
        for (int i3 = 0; !z && i3 < groups.size(); i3++) {
            Tracks.Group group2 = groups.get(i3);
            for (int i4 = 0; !z && i4 < group2.length; i4++) {
                if (group2.isTrackSelected(i4) && (metadata = group2.getTrackFormat(i4).metadata) != null && metadata.length() > 0) {
                    logd("  Metadata [");
                    m3016f(metadata, "    ");
                    logd("  ]");
                    z = true;
                }
            }
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        m3015e(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AbstractC1862u7.m7662q0(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
        AbstractC1862u7.m7666s0(this, eventTime, str, j, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        m3015e(eventTime, "videoDecoderReleased", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        m3014d(eventTime, "videoDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        m3014d(eventTime, "videoEnabled");
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
    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        m3015e(eventTime, "volume", Float.toString(f));
    }

    public EventLogger(String str) {
        this.f12694a = str;
        this.f12695b = new Timeline.Window();
        this.f12696c = new Timeline.Period();
        this.f12697d = android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        m3015e(eventTime, "audioDecoderInitialized", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        m3015e(eventTime, "audioInputFormat", Format.toLogString(format));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public final /* synthetic */ void onCues(AnalyticsListener.EventTime eventTime, List list) {
        AbstractC1862u7.m7661q(this, eventTime, list);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i) {
        m3015e(eventTime, "drmSessionAcquired", "state=" + i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        String str;
        StringBuilder sb = new StringBuilder("reason=");
        if (i == 0) {
            str = "AUTO_TRANSITION";
        } else if (i == 1) {
            str = "SEEK";
        } else if (i == 2) {
            str = "SEEK_ADJUSTMENT";
        } else if (i == 3) {
            str = "SKIP";
        } else if (i == 4) {
            str = "REMOVE";
        } else if (i != 5) {
            str = "?";
        } else {
            str = "INTERNAL";
        }
        sb.append(str);
        sb.append(", PositionInfo:old [mediaItem=");
        sb.append(positionInfo.mediaItemIndex);
        sb.append(", period=");
        sb.append(positionInfo.periodIndex);
        sb.append(", pos=");
        sb.append(positionInfo.positionMs);
        if (positionInfo.adGroupIndex != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo.contentPositionMs);
            sb.append(", adGroup=");
            sb.append(positionInfo.adGroupIndex);
            sb.append(", ad=");
            sb.append(positionInfo.adIndexInAdGroup);
        }
        sb.append("], PositionInfo:new [mediaItem=");
        sb.append(positionInfo2.mediaItemIndex);
        sb.append(", period=");
        sb.append(positionInfo2.periodIndex);
        sb.append(", pos=");
        sb.append(positionInfo2.positionMs);
        if (positionInfo2.adGroupIndex != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo2.contentPositionMs);
            sb.append(", adGroup=");
            sb.append(positionInfo2.adGroupIndex);
            sb.append(", ad=");
            sb.append(positionInfo2.adIndexInAdGroup);
        }
        sb.append("]");
        m3015e(eventTime, "positionDiscontinuity", sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        m3015e(eventTime, "videoDecoderInitialized", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        m3015e(eventTime, "videoInputFormat", Format.toLogString(format));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        m3015e(eventTime, "videoSize", videoSize.width + ", " + videoSize.height);
    }

    @Deprecated
    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector) {
        this("EventLogger");
    }

    @Deprecated
    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector, String str) {
        this(str);
    }
}
