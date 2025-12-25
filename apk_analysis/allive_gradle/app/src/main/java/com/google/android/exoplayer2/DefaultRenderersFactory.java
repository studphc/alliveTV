package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.mediacodec.DefaultMediaCodecAdapterFactory;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;

    /* renamed from: a */
    public final Context f9311a;

    /* renamed from: e */
    public boolean f9315e;

    /* renamed from: g */
    public boolean f9317g;

    /* renamed from: h */
    public boolean f9318h;

    /* renamed from: i */
    public boolean f9319i;

    /* renamed from: b */
    public final DefaultMediaCodecAdapterFactory f9312b = new DefaultMediaCodecAdapterFactory();

    /* renamed from: c */
    public int f9313c = 0;

    /* renamed from: d */
    public long f9314d = 5000;

    /* renamed from: f */
    public MediaCodecSelector f9316f = MediaCodecSelector.DEFAULT;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this.f9311a = context;
    }

    public void buildAudioRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, AudioSink audioSink, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList<Renderer> arrayList) {
        int i2;
        int i3;
        int i4;
        arrayList.add(new MediaCodecAudioRenderer(context, getCodecAdapterFactory(), mediaCodecSelector, z, handler, audioRendererEventListener, audioSink));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(null).newInstance(null));
                    Log.m3025i("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                    try {
                        i3 = i2 + 1;
                        arrayList.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                        Log.m3025i("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    } catch (ClassNotFoundException unused2) {
                    }
                    try {
                        i4 = i3 + 1;
                        try {
                            arrayList.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                            Log.m3025i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused3) {
                            i3 = i4;
                            i4 = i3;
                            arrayList.add(i4, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                            Log.m3025i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        }
                    } catch (ClassNotFoundException unused4) {
                    }
                    arrayList.add(i4, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    Log.m3025i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating MIDI extension", e);
            }
        } catch (ClassNotFoundException unused5) {
        }
        try {
            i3 = i2 + 1;
            try {
                try {
                    arrayList.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    Log.m3025i("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused6) {
                    i2 = i3;
                    i3 = i2;
                    i4 = i3 + 1;
                    arrayList.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    Log.m3025i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    arrayList.add(i4, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    Log.m3025i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
                i4 = i3 + 1;
                arrayList.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                Log.m3025i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                try {
                    arrayList.add(i4, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    Log.m3025i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException unused7) {
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e2);
                }
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FLAC extension", e3);
            }
        } catch (Exception e4) {
            throw new RuntimeException("Error instantiating Opus extension", e4);
        }
    }

    @Nullable
    public AudioSink buildAudioSink(Context context, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink.Builder().setAudioCapabilities(AudioCapabilities.getCapabilities(context)).setEnableFloatOutput(z).setEnableAudioTrackPlaybackParams(z2).setOffloadMode(z3 ? 1 : 0).build();
    }

    public void buildCameraMotionRenderers(Context context, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    public void buildMetadataRenderers(Context context, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    public void buildMiscellaneousRenderers(Context context, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public void buildTextRenderers(Context context, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    public void buildVideoRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        String str;
        int i2;
        arrayList.add(new MediaCodecVideoRenderer(context, getCodecAdapterFactory(), mediaCodecSelector, j, z, handler, videoRendererEventListener, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                    str = "DefaultRenderersFactory";
                    try {
                        Log.m3025i(str, "Loaded LibvpxVideoRenderer.");
                    } catch (ClassNotFoundException unused) {
                        size = i2;
                        i2 = size;
                        arrayList.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                        Log.m3025i(str, "Loaded Libgav1VideoRenderer.");
                    }
                } catch (ClassNotFoundException unused2) {
                    str = "DefaultRenderersFactory";
                }
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating VP9 extension", e);
            }
        } catch (ClassNotFoundException unused3) {
            str = "DefaultRenderersFactory";
        }
        try {
            arrayList.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
            Log.m3025i(str, "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused4) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating AV1 extension", e2);
        }
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.f9311a, this.f9313c, this.f9316f, this.f9315e, handler, videoRendererEventListener, this.f9314d, arrayList);
        boolean z = this.f9317g;
        boolean z2 = this.f9318h;
        boolean z3 = this.f9319i;
        Context context = this.f9311a;
        AudioSink buildAudioSink = buildAudioSink(context, z, z2, z3);
        if (buildAudioSink != null) {
            buildAudioRenderers(this.f9311a, this.f9313c, this.f9316f, this.f9315e, buildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        buildTextRenderers(this.f9311a, textOutput, handler.getLooper(), this.f9313c, arrayList);
        buildMetadataRenderers(this.f9311a, metadataOutput, handler.getLooper(), this.f9313c, arrayList);
        buildCameraMotionRenderers(context, this.f9313c, arrayList);
        buildMiscellaneousRenderers(context, handler, this.f9313c, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    public DefaultRenderersFactory experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean z) {
        this.f9312b.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(z);
        return this;
    }

    public DefaultRenderersFactory forceDisableMediaCodecAsynchronousQueueing() {
        this.f9312b.forceDisableAsynchronous();
        return this;
    }

    public DefaultRenderersFactory forceEnableMediaCodecAsynchronousQueueing() {
        this.f9312b.forceEnableAsynchronous();
        return this;
    }

    public MediaCodecAdapter.Factory getCodecAdapterFactory() {
        return this.f9312b;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.f9314d = j;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioFloatOutput(boolean z) {
        this.f9317g = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioOffload(boolean z) {
        this.f9319i = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z) {
        this.f9318h = z;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.f9315e = z;
        return this;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.f9313c = i;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
        this.f9316f = mediaCodecSelector;
        return this;
    }
}
