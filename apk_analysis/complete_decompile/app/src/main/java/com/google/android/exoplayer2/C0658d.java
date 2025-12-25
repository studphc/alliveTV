package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0658d;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C0014ad;
import p000.C1150e9;
import p000.C1255h3;
import p000.C1294i5;
import p000.C1904vc;
import p000.C2038yz;
import p000.RunnableC1867uc;
import p000.a10;
import p000.db0;
import p000.eo2;
import p000.fb0;
import p000.gb0;
import p000.hb0;
import p000.l52;
import p000.l62;
import p000.lb0;
import p000.nb0;
import p000.ob0;
import p000.p43;
import p000.pb0;
import p000.sb0;
import p000.tm1;

/* renamed from: com.google.android.exoplayer2.d */
/* loaded from: classes.dex */
public final class C0658d extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {

    /* renamed from: A */
    public final eo2 f9840A;

    /* renamed from: B */
    public final p43 f9841B;

    /* renamed from: C */
    public final p43 f9842C;

    /* renamed from: D */
    public final long f9843D;

    /* renamed from: E */
    public int f9844E;

    /* renamed from: F */
    public boolean f9845F;

    /* renamed from: G */
    public int f9846G;

    /* renamed from: H */
    public int f9847H;

    /* renamed from: I */
    public boolean f9848I;

    /* renamed from: J */
    public int f9849J;

    /* renamed from: K */
    public boolean f9850K;

    /* renamed from: L */
    public SeekParameters f9851L;

    /* renamed from: M */
    public ShuffleOrder f9852M;

    /* renamed from: N */
    public boolean f9853N;

    /* renamed from: O */
    public Player.Commands f9854O;

    /* renamed from: P */
    public MediaMetadata f9855P;

    /* renamed from: Q */
    public MediaMetadata f9856Q;

    /* renamed from: R */
    public Format f9857R;

    /* renamed from: S */
    public Format f9858S;

    /* renamed from: T */
    public AudioTrack f9859T;

    /* renamed from: U */
    public Object f9860U;

    /* renamed from: V */
    public Surface f9861V;

    /* renamed from: W */
    public SurfaceHolder f9862W;

    /* renamed from: X */
    public SphericalGLSurfaceView f9863X;

    /* renamed from: Y */
    public boolean f9864Y;

    /* renamed from: Z */
    public TextureView f9865Z;

    /* renamed from: a */
    public final TrackSelectorResult f9866a;

    /* renamed from: a0 */
    public int f9867a0;

    /* renamed from: b */
    public final Player.Commands f9868b;

    /* renamed from: b0 */
    public int f9869b0;

    /* renamed from: c */
    public final ConditionVariable f9870c;

    /* renamed from: c0 */
    public int f9871c0;

    /* renamed from: d */
    public final Context f9872d;

    /* renamed from: d0 */
    public int f9873d0;

    /* renamed from: e */
    public final Player f9874e;

    /* renamed from: e0 */
    public DecoderCounters f9875e0;

    /* renamed from: f */
    public final Renderer[] f9876f;

    /* renamed from: f0 */
    public DecoderCounters f9877f0;

    /* renamed from: g */
    public final TrackSelector f9878g;

    /* renamed from: g0 */
    public int f9879g0;

    /* renamed from: h */
    public final HandlerWrapper f9880h;

    /* renamed from: h0 */
    public AudioAttributes f9881h0;

    /* renamed from: i */
    public final gb0 f9882i;

    /* renamed from: i0 */
    public float f9883i0;

    /* renamed from: j */
    public final C0672f f9884j;

    /* renamed from: j0 */
    public boolean f9885j0;

    /* renamed from: k */
    public final ListenerSet f9886k;

    /* renamed from: k0 */
    public CueGroup f9887k0;

    /* renamed from: l */
    public final CopyOnWriteArraySet f9888l;

    /* renamed from: l0 */
    public VideoFrameMetadataListener f9889l0;

    /* renamed from: m */
    public final Timeline.Period f9890m;

    /* renamed from: m0 */
    public CameraMotionListener f9891m0;

    /* renamed from: n */
    public final ArrayList f9892n;

    /* renamed from: n0 */
    public final boolean f9893n0;

    /* renamed from: o */
    public final boolean f9894o;

    /* renamed from: o0 */
    public boolean f9895o0;

    /* renamed from: p */
    public final MediaSource.Factory f9896p;

    /* renamed from: p0 */
    public PriorityTaskManager f9897p0;

    /* renamed from: q */
    public final AnalyticsCollector f9898q;

    /* renamed from: q0 */
    public boolean f9899q0;

    /* renamed from: r */
    public final Looper f9900r;

    /* renamed from: r0 */
    public boolean f9901r0;

    /* renamed from: s */
    public final BandwidthMeter f9902s;

    /* renamed from: s0 */
    public DeviceInfo f9903s0;

    /* renamed from: t */
    public final long f9904t;

    /* renamed from: t0 */
    public VideoSize f9905t0;

    /* renamed from: u */
    public final long f9906u;

    /* renamed from: u0 */
    public MediaMetadata f9907u0;

    /* renamed from: v */
    public final Clock f9908v;

    /* renamed from: v0 */
    public l52 f9909v0;

    /* renamed from: w */
    public final SurfaceHolderCallbackC0644a f9910w;

    /* renamed from: w0 */
    public int f9911w0;

    /* renamed from: x */
    public final C0657b f9912x;

    /* renamed from: x0 */
    public long f9913x0;

    /* renamed from: y */
    public final C1904vc f9914y;

    /* renamed from: z */
    public final C0014ad f9915z;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object, com.google.android.exoplayer2.b] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, vc] */
    public C0658d(ExoPlayer.Builder builder, SimpleExoPlayer simpleExoPlayer) {
        boolean z;
        SimpleExoPlayer simpleExoPlayer2;
        PlayerId m5913a;
        AudioAttributes audioAttributes;
        boolean z2;
        boolean z3;
        int i = 1;
        ConditionVariable conditionVariable = new ConditionVariable();
        this.f9870c = conditionVariable;
        try {
            Log.m3025i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + Util.DEVICE_DEBUG_INFO + "]");
            Context context = builder.f9323a;
            Context applicationContext = context.getApplicationContext();
            this.f9872d = applicationContext;
            AnalyticsCollector analyticsCollector = (AnalyticsCollector) builder.f9331i.apply(builder.f9324b);
            this.f9898q = analyticsCollector;
            this.f9897p0 = builder.f9333k;
            this.f9881h0 = builder.f9334l;
            this.f9867a0 = builder.f9339q;
            this.f9869b0 = builder.f9340r;
            this.f9885j0 = builder.f9338p;
            this.f9843D = builder.f9347y;
            SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a = new SurfaceHolderCallbackC0644a(this);
            this.f9910w = surfaceHolderCallbackC0644a;
            ?? obj = new Object();
            this.f9912x = obj;
            Handler handler = new Handler(builder.f9332j);
            Renderer[] createRenderers = ((RenderersFactory) builder.f9326d.get()).createRenderers(handler, surfaceHolderCallbackC0644a, surfaceHolderCallbackC0644a, surfaceHolderCallbackC0644a, surfaceHolderCallbackC0644a);
            this.f9876f = createRenderers;
            if (createRenderers.length > 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            TrackSelector trackSelector = (TrackSelector) builder.f9328f.get();
            this.f9878g = trackSelector;
            this.f9896p = (MediaSource.Factory) builder.f9327e.get();
            BandwidthMeter bandwidthMeter = (BandwidthMeter) builder.f9330h.get();
            this.f9902s = bandwidthMeter;
            this.f9894o = builder.f9341s;
            this.f9851L = builder.f9342t;
            this.f9904t = builder.f9343u;
            this.f9906u = builder.f9344v;
            this.f9853N = builder.f9348z;
            Looper looper = builder.f9332j;
            this.f9900r = looper;
            Clock clock = builder.f9324b;
            this.f9908v = clock;
            if (simpleExoPlayer == null) {
                simpleExoPlayer2 = this;
            } else {
                simpleExoPlayer2 = simpleExoPlayer;
            }
            this.f9874e = simpleExoPlayer2;
            this.f9886k = new ListenerSet(looper, clock, new gb0(this, i));
            this.f9888l = new CopyOnWriteArraySet();
            this.f9892n = new ArrayList();
            this.f9852M = new ShuffleOrder.DefaultShuffleOrder(0);
            TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[createRenderers.length], new ExoTrackSelection[createRenderers.length], Tracks.EMPTY, null);
            this.f9866a = trackSelectorResult;
            this.f9890m = new Timeline.Period();
            Player.Commands build = new Player.Commands.Builder().addAll(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).addIf(29, trackSelector.isSetParametersSupported()).build();
            this.f9868b = build;
            this.f9854O = new Player.Commands.Builder().addAll(build).add(4).add(10).build();
            this.f9880h = clock.createHandler(looper, null);
            gb0 gb0Var = new gb0(this, 2);
            this.f9882i = gb0Var;
            this.f9909v0 = l52.m5855h(trackSelectorResult);
            analyticsCollector.setPlayer(simpleExoPlayer2, looper);
            int i2 = Util.SDK_INT;
            if (i2 < 31) {
                m5913a = new PlayerId();
            } else {
                m5913a = lb0.m5913a(applicationContext, this, builder.f9321A);
            }
            C0672f c0672f = new C0672f(createRenderers, trackSelector, trackSelectorResult, (LoadControl) builder.f9329g.get(), bandwidthMeter, this.f9844E, this.f9845F, analyticsCollector, this.f9851L, builder.f9345w, builder.f9346x, this.f9853N, looper, clock, gb0Var, m5913a);
            this.f9884j = c0672f;
            this.f9883i0 = 1.0f;
            this.f9844E = 0;
            MediaMetadata mediaMetadata = MediaMetadata.EMPTY;
            this.f9855P = mediaMetadata;
            this.f9856Q = mediaMetadata;
            this.f9907u0 = mediaMetadata;
            this.f9911w0 = -1;
            if (i2 < 21) {
                this.f9879g0 = m2491i(0);
            } else {
                this.f9879g0 = Util.generateAudioSessionIdV21(applicationContext);
            }
            this.f9887k0 = CueGroup.EMPTY;
            this.f9893n0 = true;
            addListener(analyticsCollector);
            bandwidthMeter.addEventListener(new Handler(looper), analyticsCollector);
            addAudioOffloadListener(surfaceHolderCallbackC0644a);
            long j = builder.f9325c;
            if (j > 0) {
                c0672f.f10604P = j;
            }
            ?? obj2 = new Object();
            obj2.f27735b = context.getApplicationContext();
            obj2.f27736c = new RunnableC1867uc(obj2, handler, surfaceHolderCallbackC0644a);
            this.f9914y = obj2;
            obj2.m7900b(builder.f9337o);
            C0014ad c0014ad = new C0014ad(context, handler, surfaceHolderCallbackC0644a);
            this.f9915z = c0014ad;
            if (builder.f9335m) {
                audioAttributes = this.f9881h0;
            } else {
                audioAttributes = null;
            }
            c0014ad.m64b(audioAttributes);
            eo2 eo2Var = new eo2(context, handler, surfaceHolderCallbackC0644a);
            this.f9840A = eo2Var;
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(this.f9881h0.usage);
            if (eo2Var.f16935f != streamTypeForAudioUsage) {
                eo2Var.f16935f = streamTypeForAudioUsage;
                eo2Var.m4739c();
                eo2Var.f16932c.onStreamTypeChanged(streamTypeForAudioUsage);
            }
            p43 p43Var = new p43(context, 0);
            this.f9841B = p43Var;
            if (builder.f9336n != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            p43Var.m6835a(z2);
            p43 p43Var2 = new p43(context, 1);
            this.f9842C = p43Var2;
            if (builder.f9336n == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            p43Var2.m6835a(z3);
            this.f9903s0 = new DeviceInfo(0, eo2Var.m4738a(), eo2Var.f16933d.getStreamMaxVolume(eo2Var.f16935f));
            this.f9905t0 = VideoSize.UNKNOWN;
            trackSelector.setAudioAttributes(this.f9881h0);
            m2497p(1, 10, Integer.valueOf(this.f9879g0));
            m2497p(2, 10, Integer.valueOf(this.f9879g0));
            m2497p(1, 3, this.f9881h0);
            m2497p(2, 4, Integer.valueOf(this.f9867a0));
            m2497p(2, 5, Integer.valueOf(this.f9869b0));
            m2497p(1, 9, Boolean.valueOf(this.f9885j0));
            m2497p(2, 7, obj);
            m2497p(6, 8, obj);
            conditionVariable.open();
        } catch (Throwable th) {
            this.f9870c.open();
            throw th;
        }
    }

    /* renamed from: h */
    public static long m2482h(l52 l52Var) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        l52Var.f22332a.getPeriodByUid(l52Var.f22333b.periodUid, period);
        long j = l52Var.f22334c;
        if (j == C0643C.TIME_UNSET) {
            return l52Var.f22332a.getWindow(period.windowIndex, window).getDefaultPositionUs();
        }
        return period.getPositionInWindowUs() + j;
    }

    /* renamed from: j */
    public static boolean m2483j(l52 l52Var) {
        if (l52Var.f22336e == 3 && l52Var.f22343l && l52Var.f22344m == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final ArrayList m2484a(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            tm1 tm1Var = new tm1((MediaSource) list.get(i2), this.f9894o);
            arrayList.add(tm1Var);
            this.f9892n.add(i2 + i, new nb0(tm1Var.f26877b, tm1Var.f26876a.getTimeline()));
        }
        this.f9852M = this.f9852M.cloneAndInsert(i, arrayList.size());
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void addAnalyticsListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.f9898q.addListener(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.f9888l.add(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void addListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        this.f9886k.add(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void addMediaItems(int i, List list) {
        m2506y();
        addMediaSources(Math.min(i, this.f9892n.size()), m2486c(list));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void addMediaSource(MediaSource mediaSource) {
        m2506y();
        addMediaSources(Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void addMediaSources(List list) {
        m2506y();
        addMediaSources(this.f9892n.size(), list);
    }

    /* renamed from: b */
    public final MediaMetadata m2485b() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return this.f9907u0;
        }
        return this.f9907u0.buildUpon().populate(currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem.mediaMetadata).build();
    }

    /* renamed from: c */
    public final ArrayList m2486c(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.f9896p.createMediaSource((MediaItem) list.get(i)));
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final void clearAuxEffectInfo() {
        m2506y();
        setAuxEffectInfo(new AuxEffectInfo(0, RecyclerView.f7068F0));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        m2506y();
        if (this.f9891m0 != cameraMotionListener) {
            return;
        }
        m2487d(this.f9912x).setType(8).setPayload(null).send();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        m2506y();
        if (this.f9889l0 != videoFrameMetadataListener) {
            return;
        }
        m2487d(this.f9912x).setType(7).setPayload(null).send();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void clearVideoSurface() {
        m2506y();
        m2496o();
        m2500s(null);
        m2494m(0, 0);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        m2506y();
        if (surfaceHolder != null && surfaceHolder == this.f9862W) {
            clearVideoSurface();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void clearVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        m2506y();
        if (surfaceView == null) {
            holder = null;
        } else {
            holder = surfaceView.getHolder();
        }
        clearVideoSurfaceHolder(holder);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void clearVideoTextureView(TextureView textureView) {
        m2506y();
        if (textureView != null && textureView == this.f9865Z) {
            clearVideoSurface();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final PlayerMessage createMessage(PlayerMessage.Target target) {
        m2506y();
        return m2487d(target);
    }

    /* renamed from: d */
    public final PlayerMessage m2487d(PlayerMessage.Target target) {
        int m2489f = m2489f();
        Timeline timeline = this.f9909v0.f22332a;
        if (m2489f == -1) {
            m2489f = 0;
        }
        C0672f c0672f = this.f9884j;
        return new PlayerMessage(c0672f, target, timeline, m2489f, this.f9908v, c0672f.f10615j);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void decreaseDeviceVolume() {
        m2506y();
        eo2 eo2Var = this.f9840A;
        if (eo2Var.f16936g > eo2Var.m4738a()) {
            eo2Var.f16933d.adjustStreamVolume(eo2Var.f16935f, -1, 1);
            eo2Var.m4739c();
        }
    }

    /* renamed from: e */
    public final long m2488e(l52 l52Var) {
        if (l52Var.f22332a.isEmpty()) {
            return Util.msToUs(this.f9913x0);
        }
        if (l52Var.f22333b.isAd()) {
            return l52Var.f22349r;
        }
        Timeline timeline = l52Var.f22332a;
        MediaSource.MediaPeriodId mediaPeriodId = l52Var.f22333b;
        long j = l52Var.f22349r;
        Object obj = mediaPeriodId.periodUid;
        Timeline.Period period = this.f9890m;
        timeline.getPeriodByUid(obj, period);
        return period.getPositionInWindowUs() + j;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final boolean experimentalIsSleepingForOffload() {
        m2506y();
        return this.f9909v0.f22346o;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void experimentalSetOffloadSchedulingEnabled(boolean z) {
        m2506y();
        this.f9884j.f10613h.obtainMessage(24, z ? 1 : 0, 0).sendToTarget();
        Iterator it = this.f9888l.iterator();
        while (it.hasNext()) {
            ((ExoPlayer.AudioOffloadListener) it.next()).onExperimentalOffloadSchedulingEnabledChanged(z);
        }
    }

    /* renamed from: f */
    public final int m2489f() {
        if (this.f9909v0.f22332a.isEmpty()) {
            return this.f9911w0;
        }
        l52 l52Var = this.f9909v0;
        return l52Var.f22332a.getPeriodByUid(l52Var.f22333b.periodUid, this.f9890m).windowIndex;
    }

    /* renamed from: g */
    public final Pair m2490g(Timeline timeline, l62 l62Var) {
        boolean z;
        long contentPosition = getContentPosition();
        int i = -1;
        if (!timeline.isEmpty() && !l62Var.isEmpty()) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.f9890m, getCurrentMediaItemIndex(), Util.msToUs(contentPosition));
            Object obj = ((Pair) Util.castNonNull(periodPositionUs)).first;
            if (l62Var.getIndexOfPeriod(obj) != -1) {
                return periodPositionUs;
            }
            Object m2573H = C0672f.m2573H(this.window, this.f9890m, this.f9844E, this.f9845F, obj, timeline, l62Var);
            if (m2573H != null) {
                Timeline.Period period = this.f9890m;
                l62Var.getPeriodByUid(m2573H, period);
                int i2 = period.windowIndex;
                return m2493l(l62Var, i2, l62Var.getWindow(i2, this.window).getDefaultPositionMs());
            }
            return m2493l(l62Var, -1, C0643C.TIME_UNSET);
        }
        if (!timeline.isEmpty() && l62Var.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            i = m2489f();
        }
        if (z) {
            contentPosition = -9223372036854775807L;
        }
        return m2493l(l62Var, i, contentPosition);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final AnalyticsCollector getAnalyticsCollector() {
        m2506y();
        return this.f9898q;
    }

    @Override // com.google.android.exoplayer2.Player
    public final Looper getApplicationLooper() {
        return this.f9900r;
    }

    @Override // com.google.android.exoplayer2.Player
    public final AudioAttributes getAudioAttributes() {
        m2506y();
        return this.f9881h0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final ExoPlayer.AudioComponent getAudioComponent() {
        m2506y();
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final DecoderCounters getAudioDecoderCounters() {
        m2506y();
        return this.f9877f0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final Format getAudioFormat() {
        m2506y();
        return this.f9858S;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final int getAudioSessionId() {
        m2506y();
        return this.f9879g0;
    }

    @Override // com.google.android.exoplayer2.Player
    public final Player.Commands getAvailableCommands() {
        m2506y();
        return this.f9854O;
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getBufferedPosition() {
        m2506y();
        if (isPlayingAd()) {
            l52 l52Var = this.f9909v0;
            if (l52Var.f22342k.equals(l52Var.f22333b)) {
                return Util.usToMs(this.f9909v0.f22347p);
            }
            return getDuration();
        }
        return getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final Clock getClock() {
        return this.f9908v;
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentBufferedPosition() {
        m2506y();
        if (this.f9909v0.f22332a.isEmpty()) {
            return this.f9913x0;
        }
        l52 l52Var = this.f9909v0;
        if (l52Var.f22342k.windowSequenceNumber != l52Var.f22333b.windowSequenceNumber) {
            return l52Var.f22332a.getWindow(getCurrentMediaItemIndex(), this.window).getDurationMs();
        }
        long j = l52Var.f22347p;
        if (this.f9909v0.f22342k.isAd()) {
            l52 l52Var2 = this.f9909v0;
            Timeline.Period periodByUid = l52Var2.f22332a.getPeriodByUid(l52Var2.f22342k.periodUid, this.f9890m);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.f9909v0.f22342k.adGroupIndex);
            if (adGroupTimeUs == Long.MIN_VALUE) {
                j = periodByUid.durationUs;
            } else {
                j = adGroupTimeUs;
            }
        }
        l52 l52Var3 = this.f9909v0;
        Timeline timeline = l52Var3.f22332a;
        Object obj = l52Var3.f22342k.periodUid;
        Timeline.Period period = this.f9890m;
        timeline.getPeriodByUid(obj, period);
        return Util.usToMs(period.getPositionInWindowUs() + j);
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentPosition() {
        m2506y();
        if (isPlayingAd()) {
            l52 l52Var = this.f9909v0;
            Timeline timeline = l52Var.f22332a;
            Object obj = l52Var.f22333b.periodUid;
            Timeline.Period period = this.f9890m;
            timeline.getPeriodByUid(obj, period);
            l52 l52Var2 = this.f9909v0;
            if (l52Var2.f22334c == C0643C.TIME_UNSET) {
                return l52Var2.f22332a.getWindow(getCurrentMediaItemIndex(), this.window).getDefaultPositionMs();
            }
            return period.getPositionInWindowMs() + Util.usToMs(this.f9909v0.f22334c);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentAdGroupIndex() {
        m2506y();
        if (isPlayingAd()) {
            return this.f9909v0.f22333b.adGroupIndex;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentAdIndexInAdGroup() {
        m2506y();
        if (isPlayingAd()) {
            return this.f9909v0.f22333b.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public final CueGroup getCurrentCues() {
        m2506y();
        return this.f9887k0;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentMediaItemIndex() {
        m2506y();
        int m2489f = m2489f();
        if (m2489f == -1) {
            return 0;
        }
        return m2489f;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentPeriodIndex() {
        m2506y();
        if (this.f9909v0.f22332a.isEmpty()) {
            return 0;
        }
        l52 l52Var = this.f9909v0;
        return l52Var.f22332a.getIndexOfPeriod(l52Var.f22333b.periodUid);
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getCurrentPosition() {
        m2506y();
        return Util.usToMs(m2488e(this.f9909v0));
    }

    @Override // com.google.android.exoplayer2.Player
    public final Timeline getCurrentTimeline() {
        m2506y();
        return this.f9909v0.f22332a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final TrackGroupArray getCurrentTrackGroups() {
        m2506y();
        return this.f9909v0.f22339h;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final TrackSelectionArray getCurrentTrackSelections() {
        m2506y();
        return new TrackSelectionArray(this.f9909v0.f22340i.selections);
    }

    @Override // com.google.android.exoplayer2.Player
    public final Tracks getCurrentTracks() {
        m2506y();
        return this.f9909v0.f22340i.tracks;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final ExoPlayer.DeviceComponent getDeviceComponent() {
        m2506y();
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public final DeviceInfo getDeviceInfo() {
        m2506y();
        return this.f9903s0;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getDeviceVolume() {
        m2506y();
        return this.f9840A.f16936g;
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getDuration() {
        m2506y();
        if (isPlayingAd()) {
            l52 l52Var = this.f9909v0;
            MediaSource.MediaPeriodId mediaPeriodId = l52Var.f22333b;
            Timeline timeline = l52Var.f22332a;
            Object obj = mediaPeriodId.periodUid;
            Timeline.Period period = this.f9890m;
            timeline.getPeriodByUid(obj, period);
            return Util.usToMs(period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
        }
        return getContentDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getMaxSeekToPreviousPosition() {
        m2506y();
        return C0643C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    @Override // com.google.android.exoplayer2.Player
    public final MediaMetadata getMediaMetadata() {
        m2506y();
        return this.f9855P;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final boolean getPauseAtEndOfMediaItems() {
        m2506y();
        return this.f9853N;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean getPlayWhenReady() {
        m2506y();
        return this.f9909v0.f22343l;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final Looper getPlaybackLooper() {
        return this.f9884j.f10615j;
    }

    @Override // com.google.android.exoplayer2.Player
    public final PlaybackParameters getPlaybackParameters() {
        m2506y();
        return this.f9909v0.f22345n;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPlaybackState() {
        m2506y();
        return this.f9909v0.f22336e;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPlaybackSuppressionReason() {
        m2506y();
        return this.f9909v0.f22344m;
    }

    @Override // com.google.android.exoplayer2.Player
    public final MediaMetadata getPlaylistMetadata() {
        m2506y();
        return this.f9856Q;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final Renderer getRenderer(int i) {
        m2506y();
        return this.f9876f[i];
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final int getRendererCount() {
        m2506y();
        return this.f9876f.length;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final int getRendererType(int i) {
        m2506y();
        return this.f9876f[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getRepeatMode() {
        m2506y();
        return this.f9844E;
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getSeekBackIncrement() {
        m2506y();
        return this.f9904t;
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getSeekForwardIncrement() {
        m2506y();
        return this.f9906u;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final SeekParameters getSeekParameters() {
        m2506y();
        return this.f9851L;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean getShuffleModeEnabled() {
        m2506y();
        return this.f9845F;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final boolean getSkipSilenceEnabled() {
        m2506y();
        return this.f9885j0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final ExoPlayer.TextComponent getTextComponent() {
        m2506y();
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getTotalBufferedDuration() {
        m2506y();
        return Util.usToMs(this.f9909v0.f22348q);
    }

    @Override // com.google.android.exoplayer2.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        m2506y();
        return this.f9878g.getParameters();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final TrackSelector getTrackSelector() {
        m2506y();
        return this.f9878g;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final int getVideoChangeFrameRateStrategy() {
        m2506y();
        return this.f9869b0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final ExoPlayer.VideoComponent getVideoComponent() {
        m2506y();
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final DecoderCounters getVideoDecoderCounters() {
        m2506y();
        return this.f9875e0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final Format getVideoFormat() {
        m2506y();
        return this.f9857R;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final int getVideoScalingMode() {
        m2506y();
        return this.f9867a0;
    }

    @Override // com.google.android.exoplayer2.Player
    public final VideoSize getVideoSize() {
        m2506y();
        return this.f9905t0;
    }

    @Override // com.google.android.exoplayer2.Player
    public final float getVolume() {
        m2506y();
        return this.f9883i0;
    }

    /* renamed from: i */
    public final int m2491i(int i) {
        AudioTrack audioTrack = this.f9859T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.f9859T.release();
            this.f9859T = null;
        }
        if (this.f9859T == null) {
            this.f9859T = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.f9859T.getAudioSessionId();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void increaseDeviceVolume() {
        m2506y();
        eo2 eo2Var = this.f9840A;
        int i = eo2Var.f16936g;
        int i2 = eo2Var.f16935f;
        AudioManager audioManager = eo2Var.f16933d;
        if (i < audioManager.getStreamMaxVolume(i2)) {
            audioManager.adjustStreamVolume(eo2Var.f16935f, 1, 1);
            eo2Var.m4739c();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isDeviceMuted() {
        m2506y();
        return this.f9840A.f16937h;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isLoading() {
        m2506y();
        return this.f9909v0.f22338g;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isPlayingAd() {
        m2506y();
        return this.f9909v0.f22333b.isAd();
    }

    /* renamed from: k */
    public final l52 m2492k(l52 l52Var, Timeline timeline, Pair pair) {
        boolean z;
        MediaSource.MediaPeriodId mediaPeriodId;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        long j;
        if (!timeline.isEmpty() && pair == null) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkArgument(z);
        Timeline timeline2 = l52Var.f22332a;
        l52 m5862g = l52Var.m5862g(timeline);
        if (timeline.isEmpty()) {
            MediaSource.MediaPeriodId mediaPeriodId2 = l52.f22331s;
            long msToUs = Util.msToUs(this.f9913x0);
            l52 m5856a = m5862g.m5857b(mediaPeriodId2, msToUs, msToUs, msToUs, 0L, TrackGroupArray.EMPTY, this.f9866a, ImmutableList.m3902of()).m5856a(mediaPeriodId2);
            m5856a.f22347p = m5856a.f22349r;
            return m5856a;
        }
        Object obj = m5862g.f22333b.periodUid;
        boolean equals = obj.equals(((Pair) Util.castNonNull(pair)).first);
        if (!equals) {
            mediaPeriodId = new MediaSource.MediaPeriodId(pair.first);
        } else {
            mediaPeriodId = m5862g.f22333b;
        }
        MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId;
        long longValue = ((Long) pair.second).longValue();
        long msToUs2 = Util.msToUs(getContentPosition());
        if (!timeline2.isEmpty()) {
            msToUs2 -= timeline2.getPeriodByUid(obj, this.f9890m).getPositionInWindowUs();
        }
        if (equals && longValue >= msToUs2) {
            if (longValue == msToUs2) {
                int indexOfPeriod = timeline.getIndexOfPeriod(m5862g.f22342k.periodUid);
                if (indexOfPeriod == -1 || timeline.getPeriod(indexOfPeriod, this.f9890m).windowIndex != timeline.getPeriodByUid(mediaPeriodId3.periodUid, this.f9890m).windowIndex) {
                    timeline.getPeriodByUid(mediaPeriodId3.periodUid, this.f9890m);
                    if (mediaPeriodId3.isAd()) {
                        j = this.f9890m.getAdDurationUs(mediaPeriodId3.adGroupIndex, mediaPeriodId3.adIndexInAdGroup);
                    } else {
                        j = this.f9890m.durationUs;
                    }
                    m5862g = m5862g.m5857b(mediaPeriodId3, m5862g.f22349r, m5862g.f22349r, m5862g.f22335d, j - m5862g.f22349r, m5862g.f22339h, m5862g.f22340i, m5862g.f22341j).m5856a(mediaPeriodId3);
                    m5862g.f22347p = j;
                }
            } else {
                Assertions.checkState(!mediaPeriodId3.isAd());
                long max = Math.max(0L, m5862g.f22348q - (longValue - msToUs2));
                long j2 = m5862g.f22347p;
                if (m5862g.f22342k.equals(m5862g.f22333b)) {
                    j2 = longValue + max;
                }
                m5862g = m5862g.m5857b(mediaPeriodId3, longValue, longValue, longValue, max, m5862g.f22339h, m5862g.f22340i, m5862g.f22341j);
                m5862g.f22347p = j2;
            }
            return m5862g;
        }
        Assertions.checkState(!mediaPeriodId3.isAd());
        if (!equals) {
            trackGroupArray = TrackGroupArray.EMPTY;
        } else {
            trackGroupArray = m5862g.f22339h;
        }
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        if (!equals) {
            trackSelectorResult = this.f9866a;
        } else {
            trackSelectorResult = m5862g.f22340i;
        }
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        if (!equals) {
            list = ImmutableList.m3902of();
        } else {
            list = m5862g.f22341j;
        }
        l52 m5856a2 = m5862g.m5857b(mediaPeriodId3, longValue, longValue, longValue, 0L, trackGroupArray2, trackSelectorResult2, list).m5856a(mediaPeriodId3);
        m5856a2.f22347p = longValue;
        return m5856a2;
    }

    /* renamed from: l */
    public final Pair m2493l(Timeline timeline, int i, long j) {
        if (timeline.isEmpty()) {
            this.f9911w0 = i;
            if (j == C0643C.TIME_UNSET) {
                j = 0;
            }
            this.f9913x0 = j;
            return null;
        }
        if (i == -1 || i >= timeline.getWindowCount()) {
            i = timeline.getFirstWindowIndex(this.f9845F);
            j = timeline.getWindow(i, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPositionUs(this.window, this.f9890m, i, Util.msToUs(j));
    }

    /* renamed from: m */
    public final void m2494m(final int i, final int i2) {
        if (i != this.f9871c0 || i2 != this.f9873d0) {
            this.f9871c0 = i;
            this.f9873d0 = i2;
            this.f9886k.sendEvent(24, new ListenerSet.Event() { // from class: ib0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onSurfaceSizeChanged(i, i2);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void moveMediaItems(int i, int i2, int i3) {
        boolean z;
        m2506y();
        ArrayList arrayList = this.f9892n;
        if (i >= 0 && i <= i2 && i2 <= arrayList.size() && i3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        Timeline currentTimeline = getCurrentTimeline();
        this.f9846G++;
        int min = Math.min(i3, arrayList.size() - (i2 - i));
        Util.moveItems(arrayList, i, i2, min);
        l62 l62Var = new l62(arrayList, this.f9852M);
        l52 m2492k = m2492k(this.f9909v0, l62Var, m2490g(currentTimeline, l62Var));
        ShuffleOrder shuffleOrder = this.f9852M;
        C0672f c0672f = this.f9884j;
        c0672f.getClass();
        c0672f.f10613h.obtainMessage(19, new pb0(i, i2, min, shuffleOrder)).sendToTarget();
        m2504w(m2492k, 0, 1, false, false, 5, C0643C.TIME_UNSET, -1);
    }

    /* renamed from: n */
    public final l52 m2495n(int i, int i2) {
        boolean z;
        ArrayList arrayList = this.f9892n;
        if (i >= 0 && i2 >= i && i2 <= arrayList.size()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        Timeline currentTimeline = getCurrentTimeline();
        int size = arrayList.size();
        this.f9846G++;
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            arrayList.remove(i3);
        }
        this.f9852M = this.f9852M.cloneAndRemove(i, i2);
        l62 l62Var = new l62(arrayList, this.f9852M);
        l52 m2492k = m2492k(this.f9909v0, l62Var, m2490g(currentTimeline, l62Var));
        int i4 = m2492k.f22336e;
        if (i4 != 1 && i4 != 4 && i < i2 && i2 == size && currentMediaItemIndex >= m2492k.f22332a.getWindowCount()) {
            m2492k = m2492k.m5861f(4);
        }
        this.f9884j.f10613h.obtainMessage(20, i, i2, this.f9852M).sendToTarget();
        return m2492k;
    }

    /* renamed from: o */
    public final void m2496o() {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.f9863X;
        SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a = this.f9910w;
        if (sphericalGLSurfaceView != null) {
            m2487d(this.f9912x).setType(10000).setPayload(null).send();
            this.f9863X.removeVideoSurfaceListener(surfaceHolderCallbackC0644a);
            this.f9863X = null;
        }
        TextureView textureView = this.f9865Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != surfaceHolderCallbackC0644a) {
                Log.m3027w("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f9865Z.setSurfaceTextureListener(null);
            }
            this.f9865Z = null;
        }
        SurfaceHolder surfaceHolder = this.f9862W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(surfaceHolderCallbackC0644a);
            this.f9862W = null;
        }
    }

    /* renamed from: p */
    public final void m2497p(int i, int i2, Object obj) {
        for (Renderer renderer : this.f9876f) {
            if (renderer.getTrackType() == i) {
                m2487d(renderer).setType(i2).setPayload(obj).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void prepare() {
        m2506y();
        boolean playWhenReady = getPlayWhenReady();
        int m66d = this.f9915z.m66d(2, playWhenReady);
        m2503v(m66d, (!playWhenReady || m66d == 1) ? 1 : 2, playWhenReady);
        l52 l52Var = this.f9909v0;
        if (l52Var.f22336e != 1) {
            return;
        }
        l52 m5859d = l52Var.m5859d(null);
        l52 m5861f = m5859d.m5861f(m5859d.f22332a.isEmpty() ? 4 : 2);
        this.f9846G++;
        this.f9884j.f10613h.obtainMessage(0).sendToTarget();
        m2504w(m5861f, 1, 1, false, false, 5, C0643C.TIME_UNSET, -1);
    }

    /* renamed from: q */
    public final void m2498q(List list, int i, long j, boolean z) {
        int i2 = i;
        int m2489f = m2489f();
        long currentPosition = getCurrentPosition();
        boolean z2 = true;
        this.f9846G++;
        ArrayList arrayList = this.f9892n;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i3 = size - 1; i3 >= 0; i3--) {
                arrayList.remove(i3);
            }
            this.f9852M = this.f9852M.cloneAndRemove(0, size);
        }
        ArrayList m2484a = m2484a(0, list);
        l62 l62Var = new l62(arrayList, this.f9852M);
        boolean isEmpty = l62Var.isEmpty();
        int i4 = l62Var.f22357d;
        if (isEmpty || i2 < i4) {
            long j2 = j;
            if (z) {
                i2 = l62Var.getFirstWindowIndex(this.f9845F);
                j2 = -9223372036854775807L;
            } else if (i2 == -1) {
                i2 = m2489f;
                j2 = currentPosition;
            }
            l52 m2492k = m2492k(this.f9909v0, l62Var, m2493l(l62Var, i2, j2));
            int i5 = m2492k.f22336e;
            if (i2 != -1 && i5 != 1) {
                i5 = (l62Var.isEmpty() || i2 >= i4) ? 4 : 2;
            }
            l52 m5861f = m2492k.m5861f(i5);
            long msToUs = Util.msToUs(j2);
            ShuffleOrder shuffleOrder = this.f9852M;
            C0672f c0672f = this.f9884j;
            c0672f.getClass();
            c0672f.f10613h.obtainMessage(17, new ob0(m2484a, shuffleOrder, i2, msToUs)).sendToTarget();
            if (this.f9909v0.f22333b.periodUid.equals(m5861f.f22333b.periodUid) || this.f9909v0.f22332a.isEmpty()) {
                z2 = false;
            }
            m2504w(m5861f, 0, 1, false, z2, 4, m2488e(m5861f), -1);
            return;
        }
        throw new IllegalSeekPositionException(l62Var, i2, j);
    }

    /* renamed from: r */
    public final void m2499r(SurfaceHolder surfaceHolder) {
        this.f9864Y = false;
        this.f9862W = surfaceHolder;
        surfaceHolder.addCallback(this.f9910w);
        Surface surface = this.f9862W.getSurface();
        if (surface != null && surface.isValid()) {
            Rect surfaceFrame = this.f9862W.getSurfaceFrame();
            m2494m(surfaceFrame.width(), surfaceFrame.height());
        } else {
            m2494m(0, 0);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void release() {
        boolean z;
        AudioTrack audioTrack;
        Log.m3025i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        m2506y();
        if (Util.SDK_INT < 21 && (audioTrack = this.f9859T) != null) {
            audioTrack.release();
            this.f9859T = null;
        }
        this.f9914y.m7900b(false);
        eo2 eo2Var = this.f9840A;
        C1150e9 c1150e9 = eo2Var.f16934e;
        if (c1150e9 != null) {
            try {
                eo2Var.f16930a.unregisterReceiver(c1150e9);
            } catch (RuntimeException e) {
                Log.m3028w("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            eo2Var.f16934e = null;
        }
        p43 p43Var = this.f9841B;
        p43Var.f25032c = false;
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) p43Var.f25034e;
        if (wakeLock != null) {
            wakeLock.release();
        }
        p43 p43Var2 = this.f9842C;
        p43Var2.f25032c = false;
        WifiManager.WifiLock wifiLock = (WifiManager.WifiLock) p43Var2.f25034e;
        if (wifiLock != null) {
            wifiLock.release();
        }
        C0014ad c0014ad = this.f9915z;
        c0014ad.f128c = null;
        c0014ad.m63a();
        C0672f c0672f = this.f9884j;
        synchronized (c0672f) {
            if (!c0672f.f10631z && c0672f.f10614i.isAlive()) {
                c0672f.f10613h.sendEmptyMessage(7);
                c0672f.m2610g0(new a10(7, c0672f), c0672f.f10627v);
                z = c0672f.f10631z;
            }
            z = true;
        }
        if (!z) {
            this.f9886k.sendEvent(10, new C1255h3(25));
        }
        this.f9886k.release();
        this.f9880h.removeCallbacksAndMessages(null);
        this.f9902s.removeEventListener(this.f9898q);
        l52 m5861f = this.f9909v0.m5861f(1);
        this.f9909v0 = m5861f;
        l52 m5856a = m5861f.m5856a(m5861f.f22333b);
        this.f9909v0 = m5856a;
        m5856a.f22347p = m5856a.f22349r;
        this.f9909v0.f22348q = 0L;
        this.f9898q.release();
        this.f9878g.release();
        m2496o();
        Surface surface = this.f9861V;
        if (surface != null) {
            surface.release();
            this.f9861V = null;
        }
        if (this.f9899q0) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.f9897p0)).remove(0);
            this.f9899q0 = false;
        }
        this.f9887k0 = CueGroup.EMPTY;
        this.f9901r0 = true;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.f9898q.removeListener(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.f9888l.remove(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void removeListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        this.f9886k.remove(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void removeMediaItems(int i, int i2) {
        m2506y();
        l52 m2495n = m2495n(i, Math.min(i2, this.f9892n.size()));
        m2504w(m2495n, 0, 1, false, !m2495n.f22333b.periodUid.equals(this.f9909v0.f22333b.periodUid), 4, m2488e(m2495n), -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void retry() {
        m2506y();
        prepare();
    }

    /* renamed from: s */
    public final void m2500s(Object obj) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Renderer[] rendererArr = this.f9876f;
        int length = rendererArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            Renderer renderer = rendererArr[i];
            if (renderer.getTrackType() == 2) {
                arrayList.add(m2487d(renderer).setType(1).setPayload(obj).send());
            }
            i++;
        }
        Object obj2 = this.f9860U;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).blockUntilDelivered(this.f9843D);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z = false;
            Object obj3 = this.f9860U;
            Surface surface = this.f9861V;
            if (obj3 == surface) {
                surface.release();
                this.f9861V = null;
            }
        } else {
            z = false;
        }
        this.f9860U = obj;
        if (z) {
            m2501t(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekTo(int i, long j) {
        m2506y();
        this.f9898q.notifySeekStarted();
        Timeline timeline = this.f9909v0.f22332a;
        if (i >= 0 && (timeline.isEmpty() || i < timeline.getWindowCount())) {
            int i2 = 1;
            this.f9846G++;
            if (isPlayingAd()) {
                Log.m3027w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate = new ExoPlayerImplInternal$PlaybackInfoUpdate(this.f9909v0);
                exoPlayerImplInternal$PlaybackInfoUpdate.incrementPendingOperationAcks(1);
                this.f9882i.onPlaybackInfoUpdate(exoPlayerImplInternal$PlaybackInfoUpdate);
                return;
            }
            if (getPlaybackState() != 1) {
                i2 = 2;
            }
            int currentMediaItemIndex = getCurrentMediaItemIndex();
            l52 m2492k = m2492k(this.f9909v0.m5861f(i2), timeline, m2493l(timeline, i, j));
            long msToUs = Util.msToUs(j);
            C0672f c0672f = this.f9884j;
            c0672f.getClass();
            c0672f.f10613h.obtainMessage(3, new sb0(timeline, i, msToUs)).sendToTarget();
            m2504w(m2492k, 0, 1, true, true, 1, m2488e(m2492k), currentMediaItemIndex);
            return;
        }
        throw new IllegalSeekPositionException(timeline, i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        AudioAttributes audioAttributes2;
        m2506y();
        if (this.f9901r0) {
            return;
        }
        boolean areEqual = Util.areEqual(this.f9881h0, audioAttributes);
        int i = 1;
        ListenerSet listenerSet = this.f9886k;
        if (!areEqual) {
            this.f9881h0 = audioAttributes;
            m2497p(1, 3, audioAttributes);
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
            eo2 eo2Var = this.f9840A;
            if (eo2Var.f16935f != streamTypeForAudioUsage) {
                eo2Var.f16935f = streamTypeForAudioUsage;
                eo2Var.m4739c();
                eo2Var.f16932c.onStreamTypeChanged(streamTypeForAudioUsage);
            }
            listenerSet.queueEvent(20, new C1294i5(6, audioAttributes));
        }
        if (z) {
            audioAttributes2 = audioAttributes;
        } else {
            audioAttributes2 = null;
        }
        C0014ad c0014ad = this.f9915z;
        c0014ad.m64b(audioAttributes2);
        this.f9878g.setAudioAttributes(audioAttributes);
        boolean playWhenReady = getPlayWhenReady();
        int m66d = c0014ad.m66d(getPlaybackState(), playWhenReady);
        if (playWhenReady && m66d != 1) {
            i = 2;
        }
        m2503v(m66d, i, playWhenReady);
        listenerSet.flushEvents();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final void setAudioSessionId(int i) {
        m2506y();
        if (this.f9879g0 == i) {
            return;
        }
        if (i == 0) {
            if (Util.SDK_INT < 21) {
                i = m2491i(0);
            } else {
                i = Util.generateAudioSessionIdV21(this.f9872d);
            }
        } else if (Util.SDK_INT < 21) {
            m2491i(i);
        }
        this.f9879g0 = i;
        m2497p(1, 10, Integer.valueOf(i));
        m2497p(2, 10, Integer.valueOf(i));
        this.f9886k.sendEvent(21, new hb0(i, 1));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        m2506y();
        m2497p(1, 6, auxEffectInfo);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        m2506y();
        this.f9891m0 = cameraMotionListener;
        m2487d(this.f9912x).setType(8).setPayload(cameraMotionListener).send();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setDeviceMuted(boolean z) {
        int i;
        m2506y();
        eo2 eo2Var = this.f9840A;
        eo2Var.getClass();
        int i2 = Util.SDK_INT;
        AudioManager audioManager = eo2Var.f16933d;
        if (i2 >= 23) {
            int i3 = eo2Var.f16935f;
            if (z) {
                i = -100;
            } else {
                i = 100;
            }
            audioManager.adjustStreamVolume(i3, i, 1);
        } else {
            audioManager.setStreamMute(eo2Var.f16935f, z);
        }
        eo2Var.m4739c();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setDeviceVolume(int i) {
        m2506y();
        eo2 eo2Var = this.f9840A;
        if (i >= eo2Var.m4738a()) {
            int i2 = eo2Var.f16935f;
            AudioManager audioManager = eo2Var.f16933d;
            if (i <= audioManager.getStreamMaxVolume(i2)) {
                audioManager.setStreamVolume(eo2Var.f16935f, i, 1);
                eo2Var.m4739c();
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setForegroundMode(boolean z) {
        boolean z2;
        m2506y();
        if (this.f9850K != z) {
            this.f9850K = z;
            C0672f c0672f = this.f9884j;
            synchronized (c0672f) {
                z2 = true;
                if (!c0672f.f10631z && c0672f.f10614i.isAlive()) {
                    if (z) {
                        c0672f.f10613h.obtainMessage(13, 1, 0).sendToTarget();
                    } else {
                        AtomicBoolean atomicBoolean = new AtomicBoolean();
                        c0672f.f10613h.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
                        c0672f.m2610g0(new a10(6, atomicBoolean), c0672f.f10604P);
                        z2 = atomicBoolean.get();
                    }
                }
            }
            if (!z2) {
                m2501t(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(2), 1003));
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setHandleAudioBecomingNoisy(boolean z) {
        m2506y();
        if (this.f9901r0) {
            return;
        }
        this.f9914y.m7900b(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setHandleWakeLock(boolean z) {
        m2506y();
        setWakeMode(z ? 1 : 0);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItems(List list, boolean z) {
        m2506y();
        setMediaSources(m2486c(list), z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setMediaSource(MediaSource mediaSource) {
        m2506y();
        setMediaSources(Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setMediaSources(List list) {
        m2506y();
        setMediaSources(list, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setPauseAtEndOfMediaItems(boolean z) {
        m2506y();
        if (this.f9853N == z) {
            return;
        }
        this.f9853N = z;
        this.f9884j.f10613h.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlayWhenReady(boolean z) {
        m2506y();
        int m66d = this.f9915z.m66d(getPlaybackState(), z);
        int i = 1;
        if (z && m66d != 1) {
            i = 2;
        }
        m2503v(m66d, i, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        m2506y();
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (this.f9909v0.f22345n.equals(playbackParameters)) {
            return;
        }
        l52 m5860e = this.f9909v0.m5860e(playbackParameters);
        this.f9846G++;
        this.f9884j.f10613h.obtainMessage(4, playbackParameters).sendToTarget();
        m2504w(m5860e, 0, 1, false, false, 5, C0643C.TIME_UNSET, -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        m2506y();
        Assertions.checkNotNull(mediaMetadata);
        if (mediaMetadata.equals(this.f9856Q)) {
            return;
        }
        this.f9856Q = mediaMetadata;
        this.f9886k.sendEvent(15, new gb0(this, 0));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
        m2506y();
        if (Util.areEqual(this.f9897p0, priorityTaskManager)) {
            return;
        }
        if (this.f9899q0) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.f9897p0)).remove(0);
        }
        if (priorityTaskManager != null && isLoading()) {
            priorityTaskManager.add(0);
            this.f9899q0 = true;
        } else {
            this.f9899q0 = false;
        }
        this.f9897p0 = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setRepeatMode(int i) {
        m2506y();
        if (this.f9844E != i) {
            this.f9844E = i;
            this.f9884j.f10613h.obtainMessage(11, i, 0).sendToTarget();
            hb0 hb0Var = new hb0(i, 0);
            ListenerSet listenerSet = this.f9886k;
            listenerSet.queueEvent(8, hb0Var);
            m2502u();
            listenerSet.flushEvents();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setSeekParameters(SeekParameters seekParameters) {
        m2506y();
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        if (!this.f9851L.equals(seekParameters)) {
            this.f9851L = seekParameters;
            this.f9884j.f10613h.obtainMessage(5, seekParameters).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setShuffleModeEnabled(boolean z) {
        m2506y();
        if (this.f9845F != z) {
            this.f9845F = z;
            this.f9884j.f10613h.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
            db0 db0Var = new db0(z, 0);
            ListenerSet listenerSet = this.f9886k;
            listenerSet.queueEvent(9, db0Var);
            m2502u();
            listenerSet.flushEvents();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setShuffleOrder(ShuffleOrder shuffleOrder) {
        m2506y();
        this.f9852M = shuffleOrder;
        l62 l62Var = new l62(this.f9892n, this.f9852M);
        l52 m2492k = m2492k(this.f9909v0, l62Var, m2493l(l62Var, getCurrentMediaItemIndex(), getCurrentPosition()));
        this.f9846G++;
        this.f9884j.f10613h.obtainMessage(21, shuffleOrder).sendToTarget();
        m2504w(m2492k, 0, 1, false, false, 5, C0643C.TIME_UNSET, -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final void setSkipSilenceEnabled(boolean z) {
        m2506y();
        if (this.f9885j0 == z) {
            return;
        }
        this.f9885j0 = z;
        m2497p(1, 9, Boolean.valueOf(z));
        this.f9886k.sendEvent(23, new db0(z, 1));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        m2506y();
        TrackSelector trackSelector = this.f9878g;
        if (trackSelector.isSetParametersSupported() && !trackSelectionParameters.equals(trackSelector.getParameters())) {
            trackSelector.setParameters(trackSelectionParameters);
            this.f9886k.sendEvent(19, new C1294i5(7, trackSelectionParameters));
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setVideoChangeFrameRateStrategy(int i) {
        m2506y();
        if (this.f9869b0 == i) {
            return;
        }
        this.f9869b0 = i;
        m2497p(2, 5, Integer.valueOf(i));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        m2506y();
        this.f9889l0 = videoFrameMetadataListener;
        m2487d(this.f9912x).setType(7).setPayload(videoFrameMetadataListener).send();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setVideoScalingMode(int i) {
        m2506y();
        this.f9867a0 = i;
        m2497p(2, 4, Integer.valueOf(i));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setVideoSurface(Surface surface) {
        int i;
        m2506y();
        m2496o();
        m2500s(surface);
        if (surface == null) {
            i = 0;
        } else {
            i = -1;
        }
        m2494m(i, i);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        m2506y();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        m2496o();
        this.f9864Y = true;
        this.f9862W = surfaceHolder;
        surfaceHolder.addCallback(this.f9910w);
        Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            m2500s(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            m2494m(surfaceFrame.width(), surfaceFrame.height());
        } else {
            m2500s(null);
            m2494m(0, 0);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        m2506y();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            m2496o();
            m2500s(surfaceView);
            m2499r(surfaceView.getHolder());
        } else {
            if (surfaceView instanceof SphericalGLSurfaceView) {
                m2496o();
                this.f9863X = (SphericalGLSurfaceView) surfaceView;
                m2487d(this.f9912x).setType(10000).setPayload(this.f9863X).send();
                this.f9863X.addVideoSurfaceListener(this.f9910w);
                m2500s(this.f9863X.getVideoSurface());
                m2499r(surfaceView.getHolder());
                return;
            }
            if (surfaceView == null) {
                holder = null;
            } else {
                holder = surfaceView.getHolder();
            }
            setVideoSurfaceHolder(holder);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setVideoTextureView(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        m2506y();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        m2496o();
        this.f9865Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.m3027w("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f9910w);
        if (textureView.isAvailable()) {
            surfaceTexture = textureView.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture == null) {
            m2500s(null);
            m2494m(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            m2500s(surface);
            this.f9861V = surface;
            m2494m(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setVolume(float f) {
        m2506y();
        final float constrainValue = Util.constrainValue(f, RecyclerView.f7068F0, 1.0f);
        if (this.f9883i0 == constrainValue) {
            return;
        }
        this.f9883i0 = constrainValue;
        m2497p(1, 2, Float.valueOf(this.f9915z.f132g * constrainValue));
        this.f9886k.sendEvent(22, new ListenerSet.Event() { // from class: jb0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).onVolumeChanged(constrainValue);
            }
        });
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setWakeMode(int i) {
        m2506y();
        p43 p43Var = this.f9842C;
        p43 p43Var2 = this.f9841B;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    p43Var2.m6835a(true);
                    p43Var.m6835a(true);
                    return;
                }
                return;
            }
            p43Var2.m6835a(true);
            p43Var.m6835a(false);
            return;
        }
        p43Var2.m6835a(false);
        p43Var.m6835a(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void stop() {
        m2506y();
        stop(false);
    }

    /* renamed from: t */
    public final void m2501t(boolean z, ExoPlaybackException exoPlaybackException) {
        l52 m5856a;
        boolean z2;
        if (z) {
            m5856a = m2495n(0, this.f9892n.size()).m5859d(null);
        } else {
            l52 l52Var = this.f9909v0;
            m5856a = l52Var.m5856a(l52Var.f22333b);
            m5856a.f22347p = m5856a.f22349r;
            m5856a.f22348q = 0L;
        }
        l52 m5861f = m5856a.m5861f(1);
        if (exoPlaybackException != null) {
            m5861f = m5861f.m5859d(exoPlaybackException);
        }
        l52 l52Var2 = m5861f;
        this.f9846G++;
        this.f9884j.f10613h.obtainMessage(6).sendToTarget();
        if (l52Var2.f22332a.isEmpty() && !this.f9909v0.f22332a.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        m2504w(l52Var2, 0, 1, false, z2, 4, m2488e(l52Var2), -1);
    }

    /* renamed from: u */
    public final void m2502u() {
        Player.Commands commands = this.f9854O;
        Player.Commands availableCommands = Util.getAvailableCommands(this.f9874e, this.f9868b);
        this.f9854O = availableCommands;
        if (!availableCommands.equals(commands)) {
            this.f9886k.queueEvent(13, new gb0(this, 3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* renamed from: v */
    public final void m2503v(int i, int i2, boolean z) {
        ?? r3;
        int i3 = 0;
        if (z && i != -1) {
            r3 = 1;
        } else {
            r3 = 0;
        }
        if (r3 != 0 && i != 1) {
            i3 = 1;
        }
        l52 l52Var = this.f9909v0;
        if (l52Var.f22343l == r3 && l52Var.f22344m == i3) {
            return;
        }
        this.f9846G++;
        l52 m5858c = l52Var.m5858c(i3, r3);
        this.f9884j.f10613h.obtainMessage(1, r3, i3).sendToTarget();
        m2504w(m5858c, 0, i2, false, false, 5, C0643C.TIME_UNSET, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0252  */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2504w(final l52 l52Var, final int i, final int i2, boolean z, boolean z2, int i3, long j, int i4) {
        Pair pair;
        int i5;
        MediaItem mediaItem;
        boolean z3;
        boolean z4;
        boolean z5;
        int i6;
        Object obj;
        MediaItem mediaItem2;
        Object obj2;
        int i7;
        long j2;
        long m2482h;
        Object obj3;
        MediaItem mediaItem3;
        Object obj4;
        int i8;
        long j3;
        PriorityTaskManager priorityTaskManager;
        l52 l52Var2 = this.f9909v0;
        this.f9909v0 = l52Var;
        boolean equals = l52Var2.f22332a.equals(l52Var.f22332a);
        Timeline timeline = l52Var2.f22332a;
        Timeline timeline2 = l52Var.f22332a;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (timeline2.isEmpty() != timeline.isEmpty()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else {
            MediaSource.MediaPeriodId mediaPeriodId = l52Var2.f22333b;
            Object obj5 = mediaPeriodId.periodUid;
            Timeline.Period period = this.f9890m;
            Object obj6 = timeline.getWindow(timeline.getPeriodByUid(obj5, period).windowIndex, this.window).uid;
            MediaSource.MediaPeriodId mediaPeriodId2 = l52Var.f22333b;
            if (!obj6.equals(timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, period).windowIndex, this.window).uid)) {
                if (z2 && i3 == 0) {
                    i5 = 1;
                } else if (z2 && i3 == 1) {
                    i5 = 2;
                } else if (!equals) {
                    i5 = 3;
                } else {
                    throw new IllegalStateException();
                }
                pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
            } else if (z2 && i3 == 0 && mediaPeriodId.windowSequenceNumber < mediaPeriodId2.windowSequenceNumber) {
                pair = new Pair(Boolean.TRUE, 0);
            } else {
                pair = new Pair(Boolean.FALSE, -1);
            }
        }
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        int intValue = ((Integer) pair.second).intValue();
        MediaMetadata mediaMetadata = this.f9855P;
        if (booleanValue) {
            if (!l52Var.f22332a.isEmpty()) {
                mediaItem = l52Var.f22332a.getWindow(l52Var.f22332a.getPeriodByUid(l52Var.f22333b.periodUid, this.f9890m).windowIndex, this.window).mediaItem;
            } else {
                mediaItem = null;
            }
            this.f9907u0 = MediaMetadata.EMPTY;
        } else {
            mediaItem = null;
        }
        if (booleanValue || !l52Var2.f22341j.equals(l52Var.f22341j)) {
            this.f9907u0 = this.f9907u0.buildUpon().populateFromMetadata(l52Var.f22341j).build();
            mediaMetadata = m2485b();
        }
        boolean equals2 = mediaMetadata.equals(this.f9855P);
        this.f9855P = mediaMetadata;
        if (l52Var2.f22343l != l52Var.f22343l) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (l52Var2.f22336e != l52Var.f22336e) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 || z3) {
            m2505x();
        }
        boolean z6 = l52Var2.f22338g;
        boolean z7 = l52Var.f22338g;
        if (z6 != z7) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 && (priorityTaskManager = this.f9897p0) != null) {
            if (z7 && !this.f9899q0) {
                priorityTaskManager.add(0);
                this.f9899q0 = true;
            } else if (!z7 && this.f9899q0) {
                priorityTaskManager.remove(0);
                this.f9899q0 = false;
            }
        }
        if (!l52Var2.f22332a.equals(l52Var.f22332a)) {
            final int i9 = 0;
            this.f9886k.queueEvent(0, new ListenerSet.Event() { // from class: kb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj7) {
                    Player.Listener listener = (Player.Listener) obj7;
                    switch (i9) {
                        case 0:
                            listener.onTimelineChanged(l52Var.f22332a, i);
                            return;
                        default:
                            listener.onPlayWhenReadyChanged(l52Var.f22343l, i);
                            return;
                    }
                }
            });
        }
        if (z2) {
            Timeline.Period period2 = new Timeline.Period();
            if (!l52Var2.f22332a.isEmpty()) {
                Object obj7 = l52Var2.f22333b.periodUid;
                l52Var2.f22332a.getPeriodByUid(obj7, period2);
                int i10 = period2.windowIndex;
                int indexOfPeriod = l52Var2.f22332a.getIndexOfPeriod(obj7);
                obj2 = obj7;
                obj = l52Var2.f22332a.getWindow(i10, this.window).uid;
                i6 = i10;
                i7 = indexOfPeriod;
                mediaItem2 = this.window.mediaItem;
            } else {
                i6 = i4;
                obj = null;
                mediaItem2 = null;
                obj2 = null;
                i7 = -1;
            }
            if (i3 == 0) {
                if (l52Var2.f22333b.isAd()) {
                    MediaSource.MediaPeriodId mediaPeriodId3 = l52Var2.f22333b;
                    j2 = period2.getAdDurationUs(mediaPeriodId3.adGroupIndex, mediaPeriodId3.adIndexInAdGroup);
                    m2482h = m2482h(l52Var2);
                    long usToMs = Util.usToMs(j2);
                    long usToMs2 = Util.usToMs(m2482h);
                    MediaSource.MediaPeriodId mediaPeriodId4 = l52Var2.f22333b;
                    Player.PositionInfo positionInfo = new Player.PositionInfo(obj, i6, mediaItem2, obj2, i7, usToMs, usToMs2, mediaPeriodId4.adGroupIndex, mediaPeriodId4.adIndexInAdGroup);
                    int currentMediaItemIndex = getCurrentMediaItemIndex();
                    if (this.f9909v0.f22332a.isEmpty()) {
                        l52 l52Var3 = this.f9909v0;
                        Object obj8 = l52Var3.f22333b.periodUid;
                        l52Var3.f22332a.getPeriodByUid(obj8, this.f9890m);
                        i8 = this.f9909v0.f22332a.getIndexOfPeriod(obj8);
                        obj3 = this.f9909v0.f22332a.getWindow(currentMediaItemIndex, this.window).uid;
                        obj4 = obj8;
                        mediaItem3 = this.window.mediaItem;
                    } else {
                        obj3 = null;
                        mediaItem3 = null;
                        obj4 = null;
                        i8 = -1;
                    }
                    long usToMs3 = Util.usToMs(j);
                    if (!this.f9909v0.f22333b.isAd()) {
                        j3 = Util.usToMs(m2482h(this.f9909v0));
                    } else {
                        j3 = usToMs3;
                    }
                    MediaSource.MediaPeriodId mediaPeriodId5 = this.f9909v0.f22333b;
                    this.f9886k.queueEvent(11, new C2038yz(positionInfo, new Player.PositionInfo(obj3, currentMediaItemIndex, mediaItem3, obj4, i8, usToMs3, j3, mediaPeriodId5.adGroupIndex, mediaPeriodId5.adIndexInAdGroup), i3));
                } else {
                    if (l52Var2.f22333b.nextAdGroupIndex != -1) {
                        j2 = m2482h(this.f9909v0);
                    } else {
                        j2 = period2.durationUs + period2.positionInWindowUs;
                    }
                    m2482h = j2;
                    long usToMs4 = Util.usToMs(j2);
                    long usToMs22 = Util.usToMs(m2482h);
                    MediaSource.MediaPeriodId mediaPeriodId42 = l52Var2.f22333b;
                    Player.PositionInfo positionInfo2 = new Player.PositionInfo(obj, i6, mediaItem2, obj2, i7, usToMs4, usToMs22, mediaPeriodId42.adGroupIndex, mediaPeriodId42.adIndexInAdGroup);
                    int currentMediaItemIndex2 = getCurrentMediaItemIndex();
                    if (this.f9909v0.f22332a.isEmpty()) {
                    }
                    long usToMs32 = Util.usToMs(j);
                    if (!this.f9909v0.f22333b.isAd()) {
                    }
                    MediaSource.MediaPeriodId mediaPeriodId52 = this.f9909v0.f22333b;
                    this.f9886k.queueEvent(11, new C2038yz(positionInfo2, new Player.PositionInfo(obj3, currentMediaItemIndex2, mediaItem3, obj4, i8, usToMs32, j3, mediaPeriodId52.adGroupIndex, mediaPeriodId52.adIndexInAdGroup), i3));
                }
            } else if (l52Var2.f22333b.isAd()) {
                j2 = l52Var2.f22349r;
                m2482h = m2482h(l52Var2);
                long usToMs42 = Util.usToMs(j2);
                long usToMs222 = Util.usToMs(m2482h);
                MediaSource.MediaPeriodId mediaPeriodId422 = l52Var2.f22333b;
                Player.PositionInfo positionInfo22 = new Player.PositionInfo(obj, i6, mediaItem2, obj2, i7, usToMs42, usToMs222, mediaPeriodId422.adGroupIndex, mediaPeriodId422.adIndexInAdGroup);
                int currentMediaItemIndex22 = getCurrentMediaItemIndex();
                if (this.f9909v0.f22332a.isEmpty()) {
                }
                long usToMs322 = Util.usToMs(j);
                if (!this.f9909v0.f22333b.isAd()) {
                }
                MediaSource.MediaPeriodId mediaPeriodId522 = this.f9909v0.f22333b;
                this.f9886k.queueEvent(11, new C2038yz(positionInfo22, new Player.PositionInfo(obj3, currentMediaItemIndex22, mediaItem3, obj4, i8, usToMs322, j3, mediaPeriodId522.adGroupIndex, mediaPeriodId522.adIndexInAdGroup), i3));
            } else {
                j2 = period2.positionInWindowUs + l52Var2.f22349r;
                m2482h = j2;
                long usToMs422 = Util.usToMs(j2);
                long usToMs2222 = Util.usToMs(m2482h);
                MediaSource.MediaPeriodId mediaPeriodId4222 = l52Var2.f22333b;
                Player.PositionInfo positionInfo222 = new Player.PositionInfo(obj, i6, mediaItem2, obj2, i7, usToMs422, usToMs2222, mediaPeriodId4222.adGroupIndex, mediaPeriodId4222.adIndexInAdGroup);
                int currentMediaItemIndex222 = getCurrentMediaItemIndex();
                if (this.f9909v0.f22332a.isEmpty()) {
                }
                long usToMs3222 = Util.usToMs(j);
                if (!this.f9909v0.f22333b.isAd()) {
                }
                MediaSource.MediaPeriodId mediaPeriodId5222 = this.f9909v0.f22333b;
                this.f9886k.queueEvent(11, new C2038yz(positionInfo222, new Player.PositionInfo(obj3, currentMediaItemIndex222, mediaItem3, obj4, i8, usToMs3222, j3, mediaPeriodId5222.adGroupIndex, mediaPeriodId5222.adIndexInAdGroup), i3));
            }
        }
        if (booleanValue) {
            this.f9886k.queueEvent(1, new fb0(intValue, mediaItem));
        }
        if (l52Var2.f22337f != l52Var.f22337f) {
            final int i11 = 1;
            this.f9886k.queueEvent(10, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i11) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
            if (l52Var.f22337f != null) {
                final int i12 = 2;
                this.f9886k.queueEvent(10, new ListenerSet.Event() { // from class: eb0
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj9) {
                        Player.Listener listener = (Player.Listener) obj9;
                        switch (i12) {
                            case 0:
                                listener.onPlaybackParametersChanged(l52Var.f22345n);
                                return;
                            case 1:
                                listener.onPlayerErrorChanged(l52Var.f22337f);
                                return;
                            case 2:
                                listener.onPlayerError(l52Var.f22337f);
                                return;
                            case 3:
                                listener.onTracksChanged(l52Var.f22340i.tracks);
                                return;
                            case 4:
                                l52 l52Var4 = l52Var;
                                listener.onLoadingChanged(l52Var4.f22338g);
                                listener.onIsLoadingChanged(l52Var4.f22338g);
                                return;
                            case 5:
                                l52 l52Var5 = l52Var;
                                listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                                return;
                            case 6:
                                listener.onPlaybackStateChanged(l52Var.f22336e);
                                return;
                            case 7:
                                listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                                return;
                            default:
                                listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                                return;
                        }
                    }
                });
            }
        }
        TrackSelectorResult trackSelectorResult = l52Var2.f22340i;
        TrackSelectorResult trackSelectorResult2 = l52Var.f22340i;
        if (trackSelectorResult != trackSelectorResult2) {
            this.f9878g.onSelectionActivated(trackSelectorResult2.info);
            final int i13 = 3;
            this.f9886k.queueEvent(2, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i13) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
        }
        if (!equals2) {
            this.f9886k.queueEvent(14, new C1294i5(5, this.f9855P));
        }
        if (z5) {
            final int i14 = 4;
            this.f9886k.queueEvent(3, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i14) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
        }
        if (z4 || z3) {
            final int i15 = 5;
            this.f9886k.queueEvent(-1, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i15) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
        }
        if (z4) {
            final int i16 = 6;
            this.f9886k.queueEvent(4, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i16) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
        }
        if (z3) {
            final int i17 = 1;
            this.f9886k.queueEvent(5, new ListenerSet.Event() { // from class: kb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj72) {
                    Player.Listener listener = (Player.Listener) obj72;
                    switch (i17) {
                        case 0:
                            listener.onTimelineChanged(l52Var.f22332a, i2);
                            return;
                        default:
                            listener.onPlayWhenReadyChanged(l52Var.f22343l, i2);
                            return;
                    }
                }
            });
        }
        if (l52Var2.f22344m != l52Var.f22344m) {
            final int i18 = 7;
            this.f9886k.queueEvent(6, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i18) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
        }
        if (m2483j(l52Var2) != m2483j(l52Var)) {
            final int i19 = 8;
            this.f9886k.queueEvent(7, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i19) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
        }
        if (!l52Var2.f22345n.equals(l52Var.f22345n)) {
            final int i20 = 0;
            this.f9886k.queueEvent(12, new ListenerSet.Event() { // from class: eb0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (i20) {
                        case 0:
                            listener.onPlaybackParametersChanged(l52Var.f22345n);
                            return;
                        case 1:
                            listener.onPlayerErrorChanged(l52Var.f22337f);
                            return;
                        case 2:
                            listener.onPlayerError(l52Var.f22337f);
                            return;
                        case 3:
                            listener.onTracksChanged(l52Var.f22340i.tracks);
                            return;
                        case 4:
                            l52 l52Var4 = l52Var;
                            listener.onLoadingChanged(l52Var4.f22338g);
                            listener.onIsLoadingChanged(l52Var4.f22338g);
                            return;
                        case 5:
                            l52 l52Var5 = l52Var;
                            listener.onPlayerStateChanged(l52Var5.f22343l, l52Var5.f22336e);
                            return;
                        case 6:
                            listener.onPlaybackStateChanged(l52Var.f22336e);
                            return;
                        case 7:
                            listener.onPlaybackSuppressionReasonChanged(l52Var.f22344m);
                            return;
                        default:
                            listener.onIsPlayingChanged(C0658d.m2483j(l52Var));
                            return;
                    }
                }
            });
        }
        if (z) {
            this.f9886k.queueEvent(-1, new C1255h3(24));
        }
        m2502u();
        this.f9886k.flushEvents();
        if (l52Var2.f22346o != l52Var.f22346o) {
            Iterator it = this.f9888l.iterator();
            while (it.hasNext()) {
                ((ExoPlayer.AudioOffloadListener) it.next()).onExperimentalSleepingForOffloadChanged(l52Var.f22346o);
            }
        }
    }

    /* renamed from: x */
    public final void m2505x() {
        int playbackState = getPlaybackState();
        p43 p43Var = this.f9842C;
        p43 p43Var2 = this.f9841B;
        boolean z = true;
        if (playbackState != 1) {
            if (playbackState != 2 && playbackState != 3) {
                if (playbackState != 4) {
                    throw new IllegalStateException();
                }
            } else {
                boolean experimentalIsSleepingForOffload = experimentalIsSleepingForOffload();
                if (!getPlayWhenReady() || experimentalIsSleepingForOffload) {
                    z = false;
                }
                p43Var2.f25032c = z;
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) p43Var2.f25034e;
                if (wakeLock != null) {
                    if (p43Var2.f25031b && z) {
                        wakeLock.acquire();
                    } else {
                        wakeLock.release();
                    }
                }
                boolean playWhenReady = getPlayWhenReady();
                p43Var.f25032c = playWhenReady;
                WifiManager.WifiLock wifiLock = (WifiManager.WifiLock) p43Var.f25034e;
                if (wifiLock != null) {
                    if (p43Var.f25031b && playWhenReady) {
                        wifiLock.acquire();
                        return;
                    } else {
                        wifiLock.release();
                        return;
                    }
                }
                return;
            }
        }
        p43Var2.f25032c = false;
        PowerManager.WakeLock wakeLock2 = (PowerManager.WakeLock) p43Var2.f25034e;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        p43Var.f25032c = false;
        WifiManager.WifiLock wifiLock2 = (WifiManager.WifiLock) p43Var.f25034e;
        if (wifiLock2 != null) {
            wifiLock2.release();
        }
    }

    /* renamed from: y */
    public final void m2506y() {
        IllegalStateException illegalStateException;
        this.f9870c.blockUninterruptible();
        Thread currentThread = Thread.currentThread();
        Looper looper = this.f9900r;
        if (currentThread != looper.getThread()) {
            String formatInvariant = Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), looper.getThread().getName());
            if (!this.f9893n0) {
                if (this.f9895o0) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                Log.m3028w("ExoPlayerImpl", formatInvariant, illegalStateException);
                this.f9895o0 = true;
                return;
            }
            throw new IllegalStateException(formatInvariant);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final ExoPlaybackException getPlayerError() {
        m2506y();
        return this.f9909v0.f22337f;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void addMediaSource(int i, MediaSource mediaSource) {
        m2506y();
        addMediaSources(i, Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void addMediaSources(int i, List list) {
        m2506y();
        Assertions.checkArgument(i >= 0);
        Timeline currentTimeline = getCurrentTimeline();
        this.f9846G++;
        ArrayList m2484a = m2484a(i, list);
        l62 l62Var = new l62(this.f9892n, this.f9852M);
        l52 m2492k = m2492k(this.f9909v0, l62Var, m2490g(currentTimeline, l62Var));
        ShuffleOrder shuffleOrder = this.f9852M;
        C0672f c0672f = this.f9884j;
        c0672f.getClass();
        c0672f.f10613h.obtainMessage(18, i, 0, new ob0(m2484a, shuffleOrder, -1, C0643C.TIME_UNSET)).sendToTarget();
        m2504w(m2492k, 0, 1, false, false, 5, C0643C.TIME_UNSET, -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItems(List list, int i, long j) {
        m2506y();
        setMediaSources(m2486c(list), i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setMediaSource(MediaSource mediaSource, long j) {
        m2506y();
        setMediaSources(Collections.singletonList(mediaSource), 0, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setMediaSources(List list, boolean z) {
        m2506y();
        m2498q(list, -1, C0643C.TIME_UNSET, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void stop(boolean z) {
        m2506y();
        this.f9915z.m66d(1, getPlayWhenReady());
        m2501t(z, null);
        this.f9887k0 = CueGroup.EMPTY;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void clearVideoSurface(Surface surface) {
        m2506y();
        if (surface == null || surface != this.f9860U) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setMediaSources(List list, int i, long j) {
        m2506y();
        m2498q(list, i, j, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void setMediaSource(MediaSource mediaSource, boolean z) {
        m2506y();
        setMediaSources(Collections.singletonList(mediaSource), z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void prepare(MediaSource mediaSource) {
        m2506y();
        setMediaSource(mediaSource);
        prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public final void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        m2506y();
        setMediaSource(mediaSource, z);
        prepare();
    }
}
