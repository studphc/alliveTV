package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g */
/* loaded from: classes.dex */
public final class C0673g implements Player.Listener {

    /* renamed from: a */
    public final ForwardingPlayer f10632a;

    /* renamed from: b */
    public final Player.Listener f10633b;

    public C0673g(ForwardingPlayer forwardingPlayer, Player.Listener listener) {
        this.f10632a = forwardingPlayer;
        this.f10633b = listener;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0673g)) {
            return false;
        }
        C0673g c0673g = (C0673g) obj;
        if (!this.f10632a.equals(c0673g.f10632a)) {
            return false;
        }
        return this.f10633b.equals(c0673g.f10633b);
    }

    public final int hashCode() {
        return this.f10633b.hashCode() + (this.f10632a.hashCode() * 31);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        this.f10633b.onAudioAttributesChanged(audioAttributes);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onAudioSessionIdChanged(int i) {
        this.f10633b.onAudioSessionIdChanged(i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onAvailableCommandsChanged(Player.Commands commands) {
        this.f10633b.onAvailableCommandsChanged(commands);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onCues(List list) {
        this.f10633b.onCues((List<Cue>) list);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        this.f10633b.onDeviceInfoChanged(deviceInfo);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onDeviceVolumeChanged(int i, boolean z) {
        this.f10633b.onDeviceVolumeChanged(i, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onEvents(Player player, Player.Events events) {
        this.f10633b.onEvents(this.f10632a, events);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onIsLoadingChanged(boolean z) {
        this.f10633b.onIsLoadingChanged(z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onIsPlayingChanged(boolean z) {
        this.f10633b.onIsPlayingChanged(z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onLoadingChanged(boolean z) {
        this.f10633b.onIsLoadingChanged(z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onMaxSeekToPreviousPositionChanged(long j) {
        this.f10633b.onMaxSeekToPreviousPositionChanged(j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onMediaItemTransition(MediaItem mediaItem, int i) {
        this.f10633b.onMediaItemTransition(mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        this.f10633b.onMediaMetadataChanged(mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onMetadata(Metadata metadata) {
        this.f10633b.onMetadata(metadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        this.f10633b.onPlayWhenReadyChanged(z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.f10633b.onPlaybackParametersChanged(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        this.f10633b.onPlaybackStateChanged(i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackSuppressionReasonChanged(int i) {
        this.f10633b.onPlaybackSuppressionReasonChanged(i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerError(PlaybackException playbackException) {
        this.f10633b.onPlayerError(playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerErrorChanged(PlaybackException playbackException) {
        this.f10633b.onPlayerErrorChanged(playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlayerStateChanged(boolean z, int i) {
        this.f10633b.onPlayerStateChanged(z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        this.f10633b.onPlaylistMetadataChanged(mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(int i) {
        this.f10633b.onPositionDiscontinuity(i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onRenderedFirstFrame() {
        this.f10633b.onRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onRepeatModeChanged(int i) {
        this.f10633b.onRepeatModeChanged(i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSeekBackIncrementChanged(long j) {
        this.f10633b.onSeekBackIncrementChanged(j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSeekForwardIncrementChanged(long j) {
        this.f10633b.onSeekForwardIncrementChanged(j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSeekProcessed() {
        this.f10633b.onSeekProcessed();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onShuffleModeEnabledChanged(boolean z) {
        this.f10633b.onShuffleModeEnabledChanged(z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSkipSilenceEnabledChanged(boolean z) {
        this.f10633b.onSkipSilenceEnabledChanged(z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onSurfaceSizeChanged(int i, int i2) {
        this.f10633b.onSurfaceSizeChanged(i, i2);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onTimelineChanged(Timeline timeline, int i) {
        this.f10633b.onTimelineChanged(timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        this.f10633b.onTrackSelectionParametersChanged(trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onTracksChanged(Tracks tracks) {
        this.f10633b.onTracksChanged(tracks);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        this.f10633b.onVideoSizeChanged(videoSize);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onVolumeChanged(float f) {
        this.f10633b.onVolumeChanged(f);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onCues(CueGroup cueGroup) {
        this.f10633b.onCues(cueGroup);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        this.f10633b.onPositionDiscontinuity(positionInfo, positionInfo2, i);
    }
}
