package com.google.android.exoplayer2.p003ui;

import android.view.View;
import android.widget.TextView;
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

/* renamed from: com.google.android.exoplayer2.ui.b */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0720b implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ PlayerControlView f12329a;

    public ViewOnClickListenerC0720b(PlayerControlView playerControlView) {
        this.f12329a = playerControlView;
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
        PlayerControlView playerControlView = this.f12329a;
        Player player = playerControlView.f12061G;
        if (player == null) {
            return;
        }
        if (playerControlView.f12084d == view) {
            player.seekToNext();
            return;
        }
        if (playerControlView.f12082c == view) {
            player.seekToPrevious();
            return;
        }
        if (playerControlView.f12089g == view) {
            if (player.getPlaybackState() != 4) {
                player.seekForward();
                return;
            }
            return;
        }
        if (playerControlView.f12090h == view) {
            player.seekBack();
            return;
        }
        if (playerControlView.f12086e == view) {
            PlayerControlView.m2901a(player);
            return;
        }
        if (playerControlView.f12088f == view) {
            player.pause();
        } else if (playerControlView.f12091i == view) {
            player.setRepeatMode(RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), playerControlView.f12069O));
        } else if (playerControlView.f12092j == view) {
            player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
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

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onEvents(Player player, Player.Events events) {
        boolean containsAny = events.containsAny(4, 5);
        PlayerControlView playerControlView = this.f12329a;
        if (containsAny) {
            int i = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.m2906f();
        }
        if (events.containsAny(4, 5, 7)) {
            int i2 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.m2907g();
        }
        if (events.contains(8)) {
            int i3 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.m2908h();
        }
        if (events.contains(9)) {
            int i4 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.m2909i();
        }
        if (events.containsAny(8, 9, 11, 0, 13)) {
            int i5 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.m2905e();
        }
        if (events.containsAny(11, 0)) {
            int i6 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
            playerControlView.m2910j();
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
        PlayerControlView playerControlView = this.f12329a;
        TextView textView = playerControlView.f12095m;
        if (textView != null) {
            textView.setText(Util.getStringForTime(playerControlView.f12097o, playerControlView.f12098p, j));
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
    public final void onScrubStart(TimeBar timeBar, long j) {
        PlayerControlView playerControlView = this.f12329a;
        playerControlView.f12066L = true;
        TextView textView = playerControlView.f12095m;
        if (textView != null) {
            textView.setText(Util.getStringForTime(playerControlView.f12097o, playerControlView.f12098p, j));
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
    public final void onScrubStop(TimeBar timeBar, long j, boolean z) {
        Player player;
        PlayerControlView playerControlView = this.f12329a;
        int i = 0;
        playerControlView.f12066L = false;
        if (!z && (player = playerControlView.f12061G) != null) {
            playerControlView.getClass();
            Timeline currentTimeline = player.getCurrentTimeline();
            if (playerControlView.f12065K && !currentTimeline.isEmpty()) {
                int windowCount = currentTimeline.getWindowCount();
                while (true) {
                    long durationMs = currentTimeline.getWindow(i, playerControlView.f12100r).getDurationMs();
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
            playerControlView.m2907g();
        }
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
