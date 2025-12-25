package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import java.util.List;
import p000.a10;
import p000.cb0;
import p000.e10;
import p000.z90;

/* loaded from: classes.dex */
public interface ExoPlayer extends Player {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    public static final long DEFAULT_RELEASE_TIMEOUT_MS = 500;

    @Deprecated
    /* loaded from: classes.dex */
    public interface AudioComponent {
        @Deprecated
        void clearAuxEffectInfo();

        @Deprecated
        AudioAttributes getAudioAttributes();

        @Deprecated
        int getAudioSessionId();

        @Deprecated
        boolean getSkipSilenceEnabled();

        @Deprecated
        float getVolume();

        @Deprecated
        void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

        @Deprecated
        void setAudioSessionId(int i);

        @Deprecated
        void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

        @Deprecated
        void setSkipSilenceEnabled(boolean z);

        @Deprecated
        void setVolume(float f);
    }

    /* loaded from: classes.dex */
    public interface AudioOffloadListener {
        void onExperimentalOffloadSchedulingEnabledChanged(boolean z);

        void onExperimentalSleepingForOffloadChanged(boolean z);
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: A */
        public boolean f9321A;

        /* renamed from: B */
        public boolean f9322B;

        /* renamed from: a */
        public final Context f9323a;

        /* renamed from: b */
        public Clock f9324b;

        /* renamed from: c */
        public long f9325c;

        /* renamed from: d */
        public Supplier f9326d;

        /* renamed from: e */
        public Supplier f9327e;

        /* renamed from: f */
        public Supplier f9328f;

        /* renamed from: g */
        public Supplier f9329g;

        /* renamed from: h */
        public Supplier f9330h;

        /* renamed from: i */
        public Function f9331i;

        /* renamed from: j */
        public Looper f9332j;

        /* renamed from: k */
        public PriorityTaskManager f9333k;

        /* renamed from: l */
        public AudioAttributes f9334l;

        /* renamed from: m */
        public boolean f9335m;

        /* renamed from: n */
        public int f9336n;

        /* renamed from: o */
        public boolean f9337o;

        /* renamed from: p */
        public boolean f9338p;

        /* renamed from: q */
        public int f9339q;

        /* renamed from: r */
        public int f9340r;

        /* renamed from: s */
        public boolean f9341s;

        /* renamed from: t */
        public SeekParameters f9342t;

        /* renamed from: u */
        public long f9343u;

        /* renamed from: v */
        public long f9344v;

        /* renamed from: w */
        public LivePlaybackSpeedControl f9345w;

        /* renamed from: x */
        public long f9346x;

        /* renamed from: y */
        public long f9347y;

        /* renamed from: z */
        public boolean f9348z;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder(final Context context) {
            this(context, new Supplier() { // from class: bb0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    switch (r2) {
                        case 0:
                            return new DefaultTrackSelector(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        case 2:
                            return new DefaultRenderersFactory(context);
                        case 3:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        case 4:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        default:
                            return new DefaultRenderersFactory(context);
                    }
                }
            }, new Supplier() { // from class: bb0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    switch (r2) {
                        case 0:
                            return new DefaultTrackSelector(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        case 2:
                            return new DefaultRenderersFactory(context);
                        case 3:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        case 4:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        default:
                            return new DefaultRenderersFactory(context);
                    }
                }
            });
            final int i = 2;
            final int i2 = 3;
        }

        public ExoPlayer build() {
            Assertions.checkState(!this.f9322B);
            this.f9322B = true;
            return new C0658d(this, null);
        }

        public Builder experimentalSetForegroundModeTimeoutMs(long j) {
            Assertions.checkState(!this.f9322B);
            this.f9325c = j;
            return this;
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.f9322B);
            this.f9331i = new z90(1, analyticsCollector);
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            Assertions.checkState(!this.f9322B);
            this.f9334l = audioAttributes;
            this.f9335m = z;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.f9322B);
            this.f9330h = new a10(4, bandwidthMeter);
            return this;
        }

        @VisibleForTesting
        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.f9322B);
            this.f9324b = clock;
            return this;
        }

        public Builder setDetachSurfaceTimeoutMs(long j) {
            Assertions.checkState(!this.f9322B);
            this.f9347y = j;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z) {
            Assertions.checkState(!this.f9322B);
            this.f9337o = z;
            return this;
        }

        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            Assertions.checkState(!this.f9322B);
            this.f9345w = livePlaybackSpeedControl;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl) {
            Assertions.checkState(!this.f9322B);
            this.f9329g = new a10(1, loadControl);
            return this;
        }

        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.f9322B);
            this.f9332j = looper;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            Assertions.checkState(!this.f9322B);
            this.f9327e = new a10(3, factory);
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z) {
            Assertions.checkState(!this.f9322B);
            this.f9348z = z;
            return this;
        }

        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            Assertions.checkState(!this.f9322B);
            this.f9333k = priorityTaskManager;
            return this;
        }

        public Builder setReleaseTimeoutMs(long j) {
            Assertions.checkState(!this.f9322B);
            this.f9346x = j;
            return this;
        }

        public Builder setRenderersFactory(RenderersFactory renderersFactory) {
            Assertions.checkState(!this.f9322B);
            this.f9326d = new a10(2, renderersFactory);
            return this;
        }

        public Builder setSeekBackIncrementMs(@IntRange(from = 1) long j) {
            boolean z;
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            Assertions.checkState(!this.f9322B);
            this.f9343u = j;
            return this;
        }

        public Builder setSeekForwardIncrementMs(@IntRange(from = 1) long j) {
            boolean z;
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            Assertions.checkState(!this.f9322B);
            this.f9344v = j;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.f9322B);
            this.f9342t = seekParameters;
            return this;
        }

        public Builder setSkipSilenceEnabled(boolean z) {
            Assertions.checkState(!this.f9322B);
            this.f9338p = z;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector) {
            Assertions.checkState(!this.f9322B);
            this.f9328f = new a10(5, trackSelector);
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.f9322B);
            this.f9341s = z;
            return this;
        }

        public Builder setUsePlatformDiagnostics(boolean z) {
            Assertions.checkState(!this.f9322B);
            this.f9321A = z;
            return this;
        }

        public Builder setVideoChangeFrameRateStrategy(int i) {
            Assertions.checkState(!this.f9322B);
            this.f9340r = i;
            return this;
        }

        public Builder setVideoScalingMode(int i) {
            Assertions.checkState(!this.f9322B);
            this.f9339q = i;
            return this;
        }

        public Builder setWakeMode(int i) {
            Assertions.checkState(!this.f9322B);
            this.f9336n = i;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder(final Context context, RenderersFactory renderersFactory) {
            this(context, new a10(2, renderersFactory), new Supplier() { // from class: bb0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    switch (r2) {
                        case 0:
                            return new DefaultTrackSelector(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        case 2:
                            return new DefaultRenderersFactory(context);
                        case 3:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        case 4:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        default:
                            return new DefaultRenderersFactory(context);
                    }
                }
            });
            final int i = 4;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder(final Context context, MediaSource.Factory factory) {
            this(context, new Supplier() { // from class: bb0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    switch (r2) {
                        case 0:
                            return new DefaultTrackSelector(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        case 2:
                            return new DefaultRenderersFactory(context);
                        case 3:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        case 4:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        default:
                            return new DefaultRenderersFactory(context);
                    }
                }
            }, new a10(3, factory));
            final int i = 5;
        }

        public Builder(Context context, RenderersFactory renderersFactory, MediaSource.Factory factory) {
            this(context, new a10(2, renderersFactory), new a10(3, factory));
        }

        public Builder(Context context, RenderersFactory renderersFactory, MediaSource.Factory factory, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this(context, new a10(2, renderersFactory), new a10(3, factory), new a10(5, trackSelector), new a10(1, loadControl), new a10(4, bandwidthMeter), new z90(1, analyticsCollector));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder(final Context context, Supplier supplier, Supplier supplier2) {
            this(context, supplier, supplier2, new Supplier() { // from class: bb0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    switch (r2) {
                        case 0:
                            return new DefaultTrackSelector(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        case 2:
                            return new DefaultRenderersFactory(context);
                        case 3:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        case 4:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        default:
                            return new DefaultRenderersFactory(context);
                    }
                }
            }, new e10(1), new Supplier() { // from class: bb0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    switch (r2) {
                        case 0:
                            return new DefaultTrackSelector(context);
                        case 1:
                            return DefaultBandwidthMeter.getSingletonInstance(context);
                        case 2:
                            return new DefaultRenderersFactory(context);
                        case 3:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        case 4:
                            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                        default:
                            return new DefaultRenderersFactory(context);
                    }
                }
            }, new cb0(0));
            final int i = 0;
            final int i2 = 1;
        }

        public Builder(Context context, Supplier supplier, Supplier supplier2, Supplier supplier3, Supplier supplier4, Supplier supplier5, Function function) {
            this.f9323a = context;
            this.f9326d = supplier;
            this.f9327e = supplier2;
            this.f9328f = supplier3;
            this.f9329g = supplier4;
            this.f9330h = supplier5;
            this.f9331i = function;
            this.f9332j = Util.getCurrentOrMainLooper();
            this.f9334l = AudioAttributes.DEFAULT;
            this.f9336n = 0;
            this.f9339q = 1;
            this.f9340r = 0;
            this.f9341s = true;
            this.f9342t = SeekParameters.DEFAULT;
            this.f9343u = 5000L;
            this.f9344v = C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
            this.f9345w = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.f9324b = Clock.DEFAULT;
            this.f9346x = 500L;
            this.f9347y = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            this.f9321A = true;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface DeviceComponent {
        @Deprecated
        void decreaseDeviceVolume();

        @Deprecated
        DeviceInfo getDeviceInfo();

        @Deprecated
        int getDeviceVolume();

        @Deprecated
        void increaseDeviceVolume();

        @Deprecated
        boolean isDeviceMuted();

        @Deprecated
        void setDeviceMuted(boolean z);

        @Deprecated
        void setDeviceVolume(int i);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface TextComponent {
        @Deprecated
        CueGroup getCurrentCues();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface VideoComponent {
        @Deprecated
        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void clearVideoSurface();

        @Deprecated
        void clearVideoSurface(@Nullable Surface surface);

        @Deprecated
        void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void clearVideoTextureView(@Nullable TextureView textureView);

        @Deprecated
        int getVideoChangeFrameRateStrategy();

        @Deprecated
        int getVideoScalingMode();

        @Deprecated
        VideoSize getVideoSize();

        @Deprecated
        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void setVideoChangeFrameRateStrategy(int i);

        @Deprecated
        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void setVideoScalingMode(int i);

        @Deprecated
        void setVideoSurface(@Nullable Surface surface);

        @Deprecated
        void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void setVideoTextureView(@Nullable TextureView textureView);
    }

    void addAnalyticsListener(AnalyticsListener analyticsListener);

    void addAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    void addMediaSource(int i, MediaSource mediaSource);

    void addMediaSource(MediaSource mediaSource);

    void addMediaSources(int i, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    void clearAuxEffectInfo();

    void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

    void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    PlayerMessage createMessage(PlayerMessage.Target target);

    boolean experimentalIsSleepingForOffload();

    void experimentalSetOffloadSchedulingEnabled(boolean z);

    AnalyticsCollector getAnalyticsCollector();

    @Nullable
    @Deprecated
    AudioComponent getAudioComponent();

    @Nullable
    DecoderCounters getAudioDecoderCounters();

    @Nullable
    Format getAudioFormat();

    int getAudioSessionId();

    Clock getClock();

    @Deprecated
    TrackGroupArray getCurrentTrackGroups();

    @Deprecated
    TrackSelectionArray getCurrentTrackSelections();

    @Nullable
    @Deprecated
    DeviceComponent getDeviceComponent();

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    ExoPlaybackException getPlayerError();

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    /* bridge */ /* synthetic */ PlaybackException getPlayerError();

    Renderer getRenderer(int i);

    int getRendererCount();

    int getRendererType(int i);

    SeekParameters getSeekParameters();

    boolean getSkipSilenceEnabled();

    @Nullable
    @Deprecated
    TextComponent getTextComponent();

    @Nullable
    TrackSelector getTrackSelector();

    int getVideoChangeFrameRateStrategy();

    @Nullable
    @Deprecated
    VideoComponent getVideoComponent();

    @Nullable
    DecoderCounters getVideoDecoderCounters();

    @Nullable
    Format getVideoFormat();

    int getVideoScalingMode();

    @Deprecated
    void prepare(MediaSource mediaSource);

    @Deprecated
    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    void removeAnalyticsListener(AnalyticsListener analyticsListener);

    void removeAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Deprecated
    void retry();

    void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

    void setAudioSessionId(int i);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setCameraMotionListener(CameraMotionListener cameraMotionListener);

    void setForegroundMode(boolean z);

    void setHandleAudioBecomingNoisy(boolean z);

    @Deprecated
    void setHandleWakeLock(boolean z);

    void setMediaSource(MediaSource mediaSource);

    void setMediaSource(MediaSource mediaSource, long j);

    void setMediaSource(MediaSource mediaSource, boolean z);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i, long j);

    void setMediaSources(List<MediaSource> list, boolean z);

    void setPauseAtEndOfMediaItems(boolean z);

    void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager);

    void setSeekParameters(@Nullable SeekParameters seekParameters);

    void setShuffleOrder(ShuffleOrder shuffleOrder);

    void setSkipSilenceEnabled(boolean z);

    void setVideoChangeFrameRateStrategy(int i);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    void setVideoScalingMode(int i);

    void setWakeMode(int i);
}
