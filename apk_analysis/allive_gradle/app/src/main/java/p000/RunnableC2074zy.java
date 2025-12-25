package p000;

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
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.DebugTextViewHelper;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

/* renamed from: zy */
/* loaded from: classes.dex */
public final class RunnableC2074zy implements Player.Listener, Runnable {

    /* renamed from: a */
    public final /* synthetic */ DebugTextViewHelper f29560a;

    public RunnableC2074zy(DebugTextViewHelper debugTextViewHelper) {
        this.f29560a = debugTextViewHelper;
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
        this.f29560a.updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        b62.m2052q(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        this.f29560a.updateAndPost();
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

    @Override // java.lang.Runnable
    public final void run() {
        this.f29560a.updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(List list) {
        b62.m2040e(this, list);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        this.f29560a.updateAndPost();
    }
}
