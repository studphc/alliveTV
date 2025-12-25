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
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;
import com.google.android.exoplayer2.p003ui.StyledPlayerView;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;
import p000.b62;

/* renamed from: com.google.android.exoplayer2.ui.n */
/* loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC0732n implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, StyledPlayerControlView.VisibilityListener, StyledPlayerControlView.OnFullScreenModeChangedListener {

    /* renamed from: a */
    public final Timeline.Period f12382a = new Timeline.Period();

    /* renamed from: b */
    public Object f12383b;

    /* renamed from: c */
    public final /* synthetic */ StyledPlayerView f12384c;

    public ViewOnLayoutChangeListenerC0732n(StyledPlayerView styledPlayerView) {
        this.f12384c = styledPlayerView;
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
        int i = StyledPlayerView.SHOW_BUFFERING_NEVER;
        this.f12384c.m2946f();
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

    @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.OnFullScreenModeChangedListener
    public final void onFullScreenModeChanged(boolean z) {
        StyledPlayerView.FullscreenButtonClickListener fullscreenButtonClickListener = this.f12384c.f12270q;
        if (fullscreenButtonClickListener != null) {
            fullscreenButtonClickListener.onFullscreenButtonClick(z);
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

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        StyledPlayerView.m2941a((TextureView) view, this.f12384c.f12253B);
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
        int i2 = StyledPlayerView.SHOW_BUFFERING_NEVER;
        StyledPlayerView styledPlayerView = this.f12384c;
        styledPlayerView.m2948h();
        if (styledPlayerView.m2942b() && styledPlayerView.f12279z) {
            styledPlayerView.hideController();
        } else {
            styledPlayerView.m2943c(false);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        b62.m2052q(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        int i2 = StyledPlayerView.SHOW_BUFFERING_NEVER;
        StyledPlayerView styledPlayerView = this.f12384c;
        styledPlayerView.m2948h();
        styledPlayerView.m2950j();
        if (styledPlayerView.m2942b() && styledPlayerView.f12279z) {
            styledPlayerView.hideController();
        } else {
            styledPlayerView.m2943c(false);
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
        View view = this.f12384c.f12256c;
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
        StyledPlayerView styledPlayerView = this.f12384c;
        Player player = (Player) Assertions.checkNotNull(styledPlayerView.f12266m);
        Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            this.f12383b = null;
        } else {
            boolean isEmpty = player.getCurrentTracks().isEmpty();
            Timeline.Period period = this.f12382a;
            if (!isEmpty) {
                this.f12383b = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), period, true).uid;
            } else {
                Object obj = this.f12383b;
                if (obj != null) {
                    int indexOfPeriod = currentTimeline.getIndexOfPeriod(obj);
                    if (indexOfPeriod != -1) {
                        if (player.getCurrentMediaItemIndex() == currentTimeline.getPeriod(indexOfPeriod, period).windowIndex) {
                            return;
                        }
                    }
                    this.f12383b = null;
                }
            }
        }
        styledPlayerView.m2951k(false);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        int i = StyledPlayerView.SHOW_BUFFERING_NEVER;
        this.f12384c.m2947g();
    }

    @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener
    public final void onVisibilityChange(int i) {
        int i2 = StyledPlayerView.SHOW_BUFFERING_NEVER;
        StyledPlayerView styledPlayerView = this.f12384c;
        styledPlayerView.m2949i();
        StyledPlayerView.ControllerVisibilityListener controllerVisibilityListener = styledPlayerView.f12268o;
        if (controllerVisibilityListener != null) {
            controllerVisibilityListener.onVisibilityChanged(i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVolumeChanged(float f) {
        b62.m2035L(this, f);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onCues(CueGroup cueGroup) {
        SubtitleView subtitleView = this.f12384c.f12260g;
        if (subtitleView != null) {
            subtitleView.setCues(cueGroup.cues);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        int i2 = StyledPlayerView.SHOW_BUFFERING_NEVER;
        StyledPlayerView styledPlayerView = this.f12384c;
        if (styledPlayerView.m2942b() && styledPlayerView.f12279z) {
            styledPlayerView.hideController();
        }
    }
}
