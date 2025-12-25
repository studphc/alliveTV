package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioSink;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ForwardingAudioSink implements AudioSink {

    /* renamed from: a */
    public final AudioSink f9755a;

    public ForwardingAudioSink(AudioSink audioSink) {
        this.f9755a = audioSink;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void configure(Format format, int i, @Nullable int[] iArr) {
        this.f9755a.configure(format, i, iArr);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        this.f9755a.disableTunneling();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21() {
        this.f9755a.enableTunnelingV21();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void experimentalFlushWithoutAudioTrackRelease() {
        this.f9755a.experimentalFlushWithoutAudioTrackRelease();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        this.f9755a.flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.f9755a.getAudioAttributes();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        return this.f9755a.getCurrentPositionUs(z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int getFormatSupport(Format format) {
        return this.f9755a.getFormatSupport(format);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        return this.f9755a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean getSkipSilenceEnabled() {
        return this.f9755a.getSkipSilenceEnabled();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) {
        return this.f9755a.handleBuffer(byteBuffer, j, i);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.f9755a.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return this.f9755a.hasPendingData();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return this.f9755a.isEnded();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.f9755a.pause();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.f9755a.play();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() {
        this.f9755a.playToEndOfStream();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        this.f9755a.reset();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        this.f9755a.setAudioAttributes(audioAttributes);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i) {
        this.f9755a.setAudioSessionId(i);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        this.f9755a.setAuxEffectInfo(auxEffectInfo);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.f9755a.setListener(listener);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.f9755a.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setPlayerId(@Nullable PlayerId playerId) {
        this.f9755a.setPlayerId(playerId);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z) {
        this.f9755a.setSkipSilenceEnabled(z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        this.f9755a.setVolume(f);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsFormat(Format format) {
        return this.f9755a.supportsFormat(format);
    }
}
