package com.google.android.exoplayer2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import java.util.List;
import p000.AbstractC1191fd;
import p000.C1255h3;
import p000.C1294i5;
import p000.ab0;
import p000.db0;
import p000.eo2;
import p000.k23;

/* renamed from: com.google.android.exoplayer2.a */
/* loaded from: classes.dex */
public final class SurfaceHolderCallbackC0644a implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager$PlayerControl, AudioBecomingNoisyManager$EventListener, StreamVolumeManager$Listener, ExoPlayer.AudioOffloadListener {

    /* renamed from: a */
    public final /* synthetic */ C0658d f9509a;

    public SurfaceHolderCallbackC0644a(C0658d c0658d) {
        this.f9509a = c0658d;
    }

    @Override // com.google.android.exoplayer2.AudioFocusManager$PlayerControl
    public final void executePlayerCommand(int i) {
        C0658d c0658d = this.f9509a;
        boolean playWhenReady = c0658d.getPlayWhenReady();
        int i2 = 1;
        if (playWhenReady && i != 1) {
            i2 = 2;
        }
        c0658d.m2503v(i, i2, playWhenReady);
    }

    @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager$EventListener
    public final void onAudioBecomingNoisy() {
        this.f9509a.m2503v(-1, 3, false);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioCodecError(Exception exc) {
        this.f9509a.f9898q.onAudioCodecError(exc);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(String str, long j, long j2) {
        this.f9509a.f9898q.onAudioDecoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderReleased(String str) {
        this.f9509a.f9898q.onAudioDecoderReleased(str);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        C0658d c0658d = this.f9509a;
        c0658d.f9898q.onAudioDisabled(decoderCounters);
        c0658d.f9858S = null;
        c0658d.f9877f0 = null;
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        C0658d c0658d = this.f9509a;
        c0658d.f9877f0 = decoderCounters;
        c0658d.f9898q.onAudioEnabled(decoderCounters);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioInputFormatChanged(Format format) {
        AbstractC1191fd.m4799f(this, format);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioPositionAdvancing(long j) {
        this.f9509a.f9898q.onAudioPositionAdvancing(j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSinkError(Exception exc) {
        this.f9509a.f9898q.onAudioSinkError(exc);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioUnderrun(int i, long j, long j2) {
        this.f9509a.f9898q.onAudioUnderrun(i, j, j2);
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public final void onCues(CueGroup cueGroup) {
        C0658d c0658d = this.f9509a;
        c0658d.f9887k0 = cueGroup;
        c0658d.f9886k.sendEvent(27, new C1294i5(9, cueGroup));
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int i, long j) {
        this.f9509a.f9898q.onDroppedFrames(i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioOffloadListener
    public final /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        ab0.m44a(this, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.AudioOffloadListener
    public final void onExperimentalSleepingForOffloadChanged(boolean z) {
        this.f9509a.m2505x();
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(Metadata metadata) {
        C0658d c0658d = this.f9509a;
        c0658d.f9907u0 = c0658d.f9907u0.buildUpon().populateFromMetadata(metadata).build();
        MediaMetadata m2485b = c0658d.m2485b();
        boolean equals = m2485b.equals(c0658d.f9855P);
        ListenerSet listenerSet = c0658d.f9886k;
        if (!equals) {
            c0658d.f9855P = m2485b;
            listenerSet.queueEvent(14, new C1294i5(10, this));
        }
        listenerSet.queueEvent(28, new C1294i5(11, metadata));
        listenerSet.flushEvents();
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(Object obj, long j) {
        C0658d c0658d = this.f9509a;
        c0658d.f9898q.onRenderedFirstFrame(obj, j);
        if (c0658d.f9860U == obj) {
            c0658d.f9886k.sendEvent(26, new C1255h3(26));
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onSkipSilenceEnabledChanged(boolean z) {
        C0658d c0658d = this.f9509a;
        if (c0658d.f9885j0 == z) {
            return;
        }
        c0658d.f9885j0 = z;
        c0658d.f9886k.sendEvent(23, new db0(z, 2));
    }

    @Override // com.google.android.exoplayer2.StreamVolumeManager$Listener
    public final void onStreamTypeChanged(int i) {
        C0658d c0658d = this.f9509a;
        eo2 eo2Var = c0658d.f9840A;
        DeviceInfo deviceInfo = new DeviceInfo(0, eo2Var.m4738a(), eo2Var.f16933d.getStreamMaxVolume(eo2Var.f16935f));
        if (!deviceInfo.equals(c0658d.f9903s0)) {
            c0658d.f9903s0 = deviceInfo;
            c0658d.f9886k.sendEvent(29, new C1294i5(12, deviceInfo));
        }
    }

    @Override // com.google.android.exoplayer2.StreamVolumeManager$Listener
    public final void onStreamVolumeChanged(final int i, final boolean z) {
        this.f9509a.f9886k.sendEvent(30, new ListenerSet.Event() { // from class: mb0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).onDeviceVolumeChanged(i, z);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        C0658d c0658d = this.f9509a;
        c0658d.getClass();
        Surface surface = new Surface(surfaceTexture);
        c0658d.m2500s(surface);
        c0658d.f9861V = surface;
        c0658d.m2494m(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        C0658d c0658d = this.f9509a;
        c0658d.m2500s(null);
        c0658d.m2494m(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f9509a.m2494m(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoCodecError(Exception exc) {
        this.f9509a.f9898q.onVideoCodecError(exc);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(String str, long j, long j2) {
        this.f9509a.f9898q.onVideoDecoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderReleased(String str) {
        this.f9509a.f9898q.onVideoDecoderReleased(str);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        C0658d c0658d = this.f9509a;
        c0658d.f9898q.onVideoDisabled(decoderCounters);
        c0658d.f9857R = null;
        c0658d.f9875e0 = null;
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        C0658d c0658d = this.f9509a;
        c0658d.f9875e0 = decoderCounters;
        c0658d.f9898q.onVideoEnabled(decoderCounters);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoFrameProcessingOffset(long j, int i) {
        this.f9509a.f9898q.onVideoFrameProcessingOffset(j, i);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoInputFormatChanged(Format format) {
        k23.m5492i(this, format);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        C0658d c0658d = this.f9509a;
        c0658d.f9905t0 = videoSize;
        c0658d.f9886k.sendEvent(25, new C1294i5(13, videoSize));
    }

    @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
    public final void onVideoSurfaceCreated(Surface surface) {
        this.f9509a.m2500s(surface);
    }

    @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
    public final void onVideoSurfaceDestroyed(Surface surface) {
        this.f9509a.m2500s(null);
    }

    @Override // com.google.android.exoplayer2.AudioFocusManager$PlayerControl
    public final void setVolumeMultiplier(float f) {
        C0658d c0658d = this.f9509a;
        c0658d.m2497p(1, 2, Float.valueOf(c0658d.f9883i0 * c0658d.f9915z.f132g));
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f9509a.m2494m(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        C0658d c0658d = this.f9509a;
        if (c0658d.f9864Y) {
            c0658d.m2500s(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C0658d c0658d = this.f9509a;
        if (c0658d.f9864Y) {
            c0658d.m2500s(null);
        }
        c0658d.m2494m(0, 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        C0658d c0658d = this.f9509a;
        c0658d.f9858S = format;
        c0658d.f9898q.onAudioInputFormatChanged(format, decoderReuseEvaluation);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        C0658d c0658d = this.f9509a;
        c0658d.f9857R = format;
        c0658d.f9898q.onVideoInputFormatChanged(format, decoderReuseEvaluation);
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public final void onCues(List list) {
        this.f9509a.f9886k.sendEvent(27, new C1294i5(8, list));
    }
}
