package com.google.android.exoplayer2.p003ui;

import android.view.TextureView;
import android.view.View;
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
import com.google.android.exoplayer2.p003ui.PlayerControlView;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;
import p000.b62;

/* renamed from: com.google.android.exoplayer2.ui.d */
/* loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC0722d implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.VisibilityListener {

    /* renamed from: a */
    public final Timeline.Period f12331a = new Timeline.Period();

    /* renamed from: b */
    public Object f12332b;

    /* renamed from: c */
    public final /* synthetic */ PlayerView f12333c;

    public ViewOnLayoutChangeListenerC0722d(PlayerView playerView) {
        this.f12333c = playerView;
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
        int i = PlayerView.SHOW_BUFFERING_NEVER;
        this.f12333c.m2919f();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(List list) {
        b62.m2040e(this, list);
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
    public final /* synthetic */ void onEvents(Player player, Player.Events events) {
        b62.m2043h(this, player, events);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onIsLoadingChanged(boolean z) {
        b62.m2044i(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onIsPlayingChanged(boolean z) {
        b62.m2045j(this, z);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PlayerView.m2914a((TextureView) view, this.f12333c.f12177z);
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
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        int i2 = PlayerView.SHOW_BUFFERING_NEVER;
        PlayerView playerView = this.f12333c;
        playerView.m2921h();
        if (playerView.m2915b() && playerView.f12175x) {
            playerView.hideController();
        } else {
            playerView.m2916c(false);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        b62.m2052q(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        int i2 = PlayerView.SHOW_BUFFERING_NEVER;
        PlayerView playerView = this.f12333c;
        playerView.m2921h();
        playerView.m2923j();
        if (playerView.m2915b() && playerView.f12175x) {
            playerView.hideController();
        } else {
            playerView.m2916c(false);
        }
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
    public final void onRenderedFirstFrame() {
        View view = this.f12333c.f12154c;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onRepeatModeChanged(int i) {
        b62.m2024A(this, i);
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
    public final void onTracksChanged(Tracks tracks) {
        PlayerView playerView = this.f12333c;
        Player player = (Player) Assertions.checkNotNull(playerView.f12164m);
        Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            this.f12332b = null;
        } else {
            boolean isEmpty = player.getCurrentTracks().isEmpty();
            Timeline.Period period = this.f12331a;
            if (!isEmpty) {
                this.f12332b = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), period, true).uid;
            } else {
                Object obj = this.f12332b;
                if (obj != null) {
                    int indexOfPeriod = currentTimeline.getIndexOfPeriod(obj);
                    if (indexOfPeriod != -1) {
                        if (player.getCurrentMediaItemIndex() == currentTimeline.getPeriod(indexOfPeriod, period).windowIndex) {
                            return;
                        }
                    }
                    this.f12332b = null;
                }
            }
        }
        playerView.m2924k(false);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        int i = PlayerView.SHOW_BUFFERING_NEVER;
        this.f12333c.m2920g();
    }

    @Override // com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener
    public final void onVisibilityChange(int i) {
        int i2 = PlayerView.SHOW_BUFFERING_NEVER;
        this.f12333c.m2922i();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVolumeChanged(float f) {
        b62.m2035L(this, f);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onCues(CueGroup cueGroup) {
        SubtitleView subtitleView = this.f12333c.f12158g;
        if (subtitleView != null) {
            subtitleView.setCues(cueGroup.cues);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        int i2 = PlayerView.SHOW_BUFFERING_NEVER;
        PlayerView playerView = this.f12333c;
        if (playerView.m2915b() && playerView.f12175x) {
            playerView.hideController();
        }
    }
}
