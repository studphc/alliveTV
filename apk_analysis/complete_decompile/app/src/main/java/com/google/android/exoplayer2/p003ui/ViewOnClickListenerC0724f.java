package com.google.android.exoplayer2.p003ui;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p003ui.TimeBar;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;
import p000.b62;

/* renamed from: com.google.android.exoplayer2.ui.f */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0724f implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    public final /* synthetic */ StyledPlayerControlView f12335a;

    public ViewOnClickListenerC0724f(StyledPlayerControlView styledPlayerControlView) {
        this.f12335a = styledPlayerControlView;
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        b62.m2036a(this, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAudioSessionIdChanged(int i) {
        b62.m2037b(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        b62.m2038c(this, commands);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StyledPlayerControlView styledPlayerControlView = this.f12335a;
        Player player = styledPlayerControlView.f12193O;
        if (player == null) {
            return;
        }
        styledPlayerControlView.f12217h0.m2971g();
        if (styledPlayerControlView.f12208d == view) {
            player.seekToNext();
            return;
        }
        if (styledPlayerControlView.f12206c == view) {
            player.seekToPrevious();
            return;
        }
        if (styledPlayerControlView.f12212f == view) {
            if (player.getPlaybackState() != 4) {
                player.seekForward();
                return;
            }
            return;
        }
        if (styledPlayerControlView.f12214g == view) {
            player.seekBack();
            return;
        }
        if (styledPlayerControlView.f12210e == view) {
            int playbackState = player.getPlaybackState();
            if (playbackState != 1 && playbackState != 4 && player.getPlayWhenReady()) {
                player.pause();
                return;
            }
            int playbackState2 = player.getPlaybackState();
            if (playbackState2 == 1) {
                player.prepare();
            } else if (playbackState2 == 4) {
                player.seekTo(player.getCurrentMediaItemIndex(), C0643C.TIME_UNSET);
            }
            player.play();
            return;
        }
        if (styledPlayerControlView.f12220j == view) {
            player.setRepeatMode(RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), styledPlayerControlView.f12205b0));
            return;
        }
        if (styledPlayerControlView.f12222k == view) {
            player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
            return;
        }
        if (styledPlayerControlView.f12245v0 == view) {
            styledPlayerControlView.f12217h0.m2970f();
            styledPlayerControlView.m2928c(styledPlayerControlView.f12223k0);
            return;
        }
        if (styledPlayerControlView.f12247w0 == view) {
            styledPlayerControlView.f12217h0.m2970f();
            styledPlayerControlView.m2928c(styledPlayerControlView.f12225l0);
        } else if (styledPlayerControlView.f12249x0 == view) {
            styledPlayerControlView.f12217h0.m2970f();
            styledPlayerControlView.m2928c(styledPlayerControlView.f12235q0);
        } else if (styledPlayerControlView.f12239s0 == view) {
            styledPlayerControlView.f12217h0.m2970f();
            styledPlayerControlView.m2928c(styledPlayerControlView.f12233p0);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(CueGroup cueGroup) {
        b62.m2039d(this, cueGroup);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        b62.m2041f(this, deviceInfo);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
        b62.m2042g(this, i, z);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        StyledPlayerControlView styledPlayerControlView = this.f12335a;
        if (styledPlayerControlView.f12229n0) {
            styledPlayerControlView.f12217h0.m2971g();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onEvents(Player player, Player.Events events) {
        boolean containsAny = events.containsAny(4, 5);
        StyledPlayerControlView styledPlayerControlView = this.f12335a;
        if (containsAny) {
            int i = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2933h();
        }
        if (events.containsAny(4, 5, 7)) {
            int i2 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2935j();
        }
        if (events.contains(8)) {
            int i3 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2936k();
        }
        if (events.contains(9)) {
            int i4 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2938m();
        }
        if (events.containsAny(8, 9, 11, 0, 16, 17, 13)) {
            int i5 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2932g();
        }
        if (events.containsAny(11, 0)) {
            int i6 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2939n();
        }
        if (events.contains(12)) {
            int i7 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2934i();
        }
        if (events.contains(2)) {
            int i8 = StyledPlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            styledPlayerControlView.m2940o();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onIsLoadingChanged(boolean z) {
        b62.m2044i(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onIsPlayingChanged(boolean z) {
        b62.m2045j(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onLoadingChanged(boolean z) {
        b62.m2046k(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
        b62.m2047l(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        b62.m2048m(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        b62.m2049n(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMetadata(Metadata metadata) {
        b62.m2050o(this, metadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        b62.m2051p(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        b62.m2052q(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackStateChanged(int i) {
        b62.m2053r(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        b62.m2054s(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayerError(PlaybackException playbackException) {
        b62.m2055t(this, playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        b62.m2056u(this, playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
        b62.m2057v(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        b62.m2058w(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPositionDiscontinuity(int i) {
        b62.m2059x(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onRenderedFirstFrame() {
        b62.m2061z(this);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onRepeatModeChanged(int i) {
        b62.m2024A(this, i);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
    public final void onScrubMove(TimeBar timeBar, long j) {
        StyledPlayerControlView styledPlayerControlView = this.f12335a;
        TextView textView = styledPlayerControlView.f12228n;
        if (textView != null) {
            textView.setText(Util.getStringForTime(styledPlayerControlView.f12232p, styledPlayerControlView.f12234q, j));
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
    public final void onScrubStart(TimeBar timeBar, long j) {
        StyledPlayerControlView styledPlayerControlView = this.f12335a;
        styledPlayerControlView.f12200V = true;
        TextView textView = styledPlayerControlView.f12228n;
        if (textView != null) {
            textView.setText(Util.getStringForTime(styledPlayerControlView.f12232p, styledPlayerControlView.f12234q, j));
        }
        styledPlayerControlView.f12217h0.m2970f();
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
    public final void onScrubStop(TimeBar timeBar, long j, boolean z) {
        Player player;
        StyledPlayerControlView styledPlayerControlView = this.f12335a;
        int i = 0;
        styledPlayerControlView.f12200V = false;
        if (!z && (player = styledPlayerControlView.f12193O) != null) {
            styledPlayerControlView.getClass();
            Timeline currentTimeline = player.getCurrentTimeline();
            if (styledPlayerControlView.f12199U && !currentTimeline.isEmpty()) {
                int windowCount = currentTimeline.getWindowCount();
                while (true) {
                    long durationMs = currentTimeline.getWindow(i, styledPlayerControlView.f12238s).getDurationMs();
                    if (j < durationMs) {
                        break;
                    }
                    if (i == windowCount - 1) {
                        j = durationMs;
                        break;
                    } else {
                        j -= durationMs;
                        i++;
                    }
                }
            } else {
                i = player.getCurrentMediaItemIndex();
            }
            player.seekTo(i, j);
            styledPlayerControlView.m2935j();
        }
        styledPlayerControlView.f12217h0.m2971g();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekBackIncrementChanged(long j) {
        b62.m2025B(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekForwardIncrementChanged(long j) {
        b62.m2026C(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekProcessed() {
        b62.m2027D(this);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        b62.m2028E(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
        b62.m2029F(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        b62.m2030G(this, i, i2);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        b62.m2031H(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        b62.m2032I(this, trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTracksChanged(Tracks tracks) {
        b62.m2033J(this, tracks);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        b62.m2034K(this, videoSize);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVolumeChanged(float f) {
        b62.m2035L(this, f);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(List list) {
        b62.m2040e(this, list);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        b62.m2060y(this, positionInfo, positionInfo2, i);
    }
}
