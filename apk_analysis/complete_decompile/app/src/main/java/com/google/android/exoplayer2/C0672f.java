package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.RunnableC0583c7;
import p000.gb0;
import p000.l52;
import p000.l62;
import p000.ob0;
import p000.pb0;
import p000.qb0;
import p000.rm1;
import p000.sb0;
import p000.sm1;
import p000.tm1;
import p000.ul1;
import p000.um1;
import p000.vl1;
import p000.x00;

/* renamed from: com.google.android.exoplayer2.f */
/* loaded from: classes.dex */
public final class C0672f implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList$MediaSourceListInfoRefreshListener, DefaultMediaClock$PlaybackParametersListener, PlayerMessage.Sender {

    /* renamed from: A */
    public boolean f10589A;

    /* renamed from: B */
    public boolean f10590B;

    /* renamed from: C */
    public boolean f10591C;

    /* renamed from: D */
    public boolean f10592D;

    /* renamed from: E */
    public int f10593E;

    /* renamed from: F */
    public boolean f10594F;

    /* renamed from: G */
    public boolean f10595G;

    /* renamed from: H */
    public boolean f10596H;

    /* renamed from: I */
    public boolean f10597I;

    /* renamed from: J */
    public int f10598J;

    /* renamed from: K */
    public sb0 f10599K;

    /* renamed from: L */
    public long f10600L;

    /* renamed from: M */
    public int f10601M;

    /* renamed from: N */
    public boolean f10602N;

    /* renamed from: O */
    public ExoPlaybackException f10603O;

    /* renamed from: P */
    public long f10604P;

    /* renamed from: Q */
    public long f10605Q = C0643C.TIME_UNSET;

    /* renamed from: a */
    public final Renderer[] f10606a;

    /* renamed from: b */
    public final Set f10607b;

    /* renamed from: c */
    public final RendererCapabilities[] f10608c;

    /* renamed from: d */
    public final TrackSelector f10609d;

    /* renamed from: e */
    public final TrackSelectorResult f10610e;

    /* renamed from: f */
    public final LoadControl f10611f;

    /* renamed from: g */
    public final BandwidthMeter f10612g;

    /* renamed from: h */
    public final HandlerWrapper f10613h;

    /* renamed from: i */
    public final HandlerThread f10614i;

    /* renamed from: j */
    public final Looper f10615j;

    /* renamed from: k */
    public final Timeline.Window f10616k;

    /* renamed from: l */
    public final Timeline.Period f10617l;

    /* renamed from: m */
    public final long f10618m;

    /* renamed from: n */
    public final boolean f10619n;

    /* renamed from: o */
    public final x00 f10620o;

    /* renamed from: p */
    public final ArrayList f10621p;

    /* renamed from: q */
    public final Clock f10622q;

    /* renamed from: r */
    public final gb0 f10623r;

    /* renamed from: s */
    public final C0674h f10624s;

    /* renamed from: t */
    public final um1 f10625t;

    /* renamed from: u */
    public final LivePlaybackSpeedControl f10626u;

    /* renamed from: v */
    public final long f10627v;

    /* renamed from: w */
    public SeekParameters f10628w;

    /* renamed from: x */
    public l52 f10629x;

    /* renamed from: y */
    public ExoPlayerImplInternal$PlaybackInfoUpdate f10630y;

    /* renamed from: z */
    public boolean f10631z;

    public C0672f(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z2, Looper looper, Clock clock, gb0 gb0Var, PlayerId playerId) {
        this.f10623r = gb0Var;
        this.f10606a = rendererArr;
        this.f10609d = trackSelector;
        this.f10610e = trackSelectorResult;
        this.f10611f = loadControl;
        this.f10612g = bandwidthMeter;
        this.f10593E = i;
        this.f10594F = z;
        this.f10628w = seekParameters;
        this.f10626u = livePlaybackSpeedControl;
        this.f10627v = j;
        this.f10604P = j;
        this.f10589A = z2;
        this.f10622q = clock;
        this.f10618m = loadControl.getBackBufferDurationUs();
        this.f10619n = loadControl.retainBackBufferFromKeyframe();
        l52 m5855h = l52.m5855h(trackSelectorResult);
        this.f10629x = m5855h;
        this.f10630y = new ExoPlayerImplInternal$PlaybackInfoUpdate(m5855h);
        this.f10608c = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].init(i2, playerId);
            this.f10608c[i2] = rendererArr[i2].getCapabilities();
        }
        this.f10620o = new x00(this, clock);
        this.f10621p = new ArrayList();
        this.f10607b = Sets.newIdentityHashSet();
        this.f10616k = new Timeline.Window();
        this.f10617l = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.f10602N = true;
        Handler handler = new Handler(looper);
        this.f10624s = new C0674h(analyticsCollector, handler);
        this.f10625t = new um1(this, analyticsCollector, handler, playerId);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f10614i = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f10615j = looper2;
        this.f10613h = clock.createHandler(looper2, this);
    }

    /* renamed from: D */
    public static void m2570D(Timeline timeline, qb0 qb0Var, Timeline.Window window, Timeline.Period period) {
        long j;
        int i = timeline.getWindow(timeline.getPeriodByUid(qb0Var.f25505d, period).windowIndex, window).lastPeriodIndex;
        Object obj = timeline.getPeriod(i, period, true).uid;
        long j2 = period.durationUs;
        if (j2 != C0643C.TIME_UNSET) {
            j = j2 - 1;
        } else {
            j = Long.MAX_VALUE;
        }
        qb0Var.f25503b = i;
        qb0Var.f25504c = j;
        qb0Var.f25505d = obj;
    }

    /* renamed from: E */
    public static boolean m2571E(qb0 qb0Var, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        long msToUs;
        Object obj = qb0Var.f25505d;
        PlayerMessage playerMessage = qb0Var.f25502a;
        if (obj == null) {
            if (playerMessage.getPositionMs() == Long.MIN_VALUE) {
                msToUs = C0643C.TIME_UNSET;
            } else {
                msToUs = Util.msToUs(playerMessage.getPositionMs());
            }
            Pair m2572G = m2572G(timeline, new sb0(playerMessage.getTimeline(), playerMessage.getMediaItemIndex(), msToUs), false, i, z, window, period);
            if (m2572G == null) {
                return false;
            }
            int indexOfPeriod = timeline.getIndexOfPeriod(m2572G.first);
            long longValue = ((Long) m2572G.second).longValue();
            Object obj2 = m2572G.first;
            qb0Var.f25503b = indexOfPeriod;
            qb0Var.f25504c = longValue;
            qb0Var.f25505d = obj2;
            if (playerMessage.getPositionMs() == Long.MIN_VALUE) {
                m2570D(timeline, qb0Var, window, period);
            }
            return true;
        }
        int indexOfPeriod2 = timeline.getIndexOfPeriod(obj);
        if (indexOfPeriod2 == -1) {
            return false;
        }
        if (playerMessage.getPositionMs() == Long.MIN_VALUE) {
            m2570D(timeline, qb0Var, window, period);
            return true;
        }
        qb0Var.f25503b = indexOfPeriod2;
        timeline2.getPeriodByUid(qb0Var.f25505d, period);
        if (period.isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(qb0Var.f25505d)) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(qb0Var.f25505d, period).windowIndex, period.getPositionInWindowUs() + qb0Var.f25504c);
            int indexOfPeriod3 = timeline.getIndexOfPeriod(periodPositionUs.first);
            long longValue2 = ((Long) periodPositionUs.second).longValue();
            Object obj3 = periodPositionUs.first;
            qb0Var.f25503b = indexOfPeriod3;
            qb0Var.f25504c = longValue2;
            qb0Var.f25505d = obj3;
        }
        return true;
    }

    /* renamed from: G */
    public static Pair m2572G(Timeline timeline, sb0 sb0Var, boolean z, int i, boolean z2, Timeline.Window window, Timeline.Period period) {
        Timeline timeline2;
        Pair<Object, Long> periodPositionUs;
        Object m2573H;
        Timeline timeline3 = sb0Var.f26347a;
        if (timeline.isEmpty()) {
            return null;
        }
        if (timeline3.isEmpty()) {
            timeline2 = timeline;
        } else {
            timeline2 = timeline3;
        }
        try {
            periodPositionUs = timeline2.getPeriodPositionUs(window, period, sb0Var.f26348b, sb0Var.f26349c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (timeline.equals(timeline2)) {
            return periodPositionUs;
        }
        if (timeline.getIndexOfPeriod(periodPositionUs.first) != -1) {
            if (timeline2.getPeriodByUid(periodPositionUs.first, period).isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(periodPositionUs.first)) {
                return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(periodPositionUs.first, period).windowIndex, sb0Var.f26349c);
            }
            return periodPositionUs;
        }
        if (z && (m2573H = m2573H(window, period, i, z2, periodPositionUs.first, timeline2, timeline)) != null) {
            return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(m2573H, period).windowIndex, C0643C.TIME_UNSET);
        }
        return null;
    }

    /* renamed from: H */
    public static Object m2573H(Timeline.Window window, Timeline.Period period, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i2 = indexOfPeriod;
        int i3 = -1;
        for (int i4 = 0; i4 < periodCount && i3 == -1; i4++) {
            i2 = timeline.getNextPeriodIndex(i2, period, window, i, z);
            if (i2 == -1) {
                break;
            }
            i3 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i3);
    }

    /* renamed from: b */
    public static void m2574b(PlayerMessage playerMessage) {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    /* renamed from: q */
    public static boolean m2575q(Renderer renderer) {
        if (renderer.getState() != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2576A(boolean z, boolean z2, boolean z3, boolean z4) {
        long j;
        boolean z5;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        this.f10613h.removeMessages(2);
        ExoPlaybackException exoPlaybackException = null;
        this.f10603O = null;
        this.f10591C = false;
        x00 x00Var = this.f10620o;
        x00Var.f28415f = false;
        x00Var.f28410a.stop();
        this.f10600L = 1000000000000L;
        for (Renderer renderer : this.f10606a) {
            try {
                m2601c(renderer);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.m3024e("ExoPlayerImplInternal", "Disable failed.", e);
            }
        }
        if (z) {
            for (Renderer renderer2 : this.f10606a) {
                if (this.f10607b.remove(renderer2)) {
                    try {
                        renderer2.reset();
                    } catch (RuntimeException e2) {
                        Log.m3024e("ExoPlayerImplInternal", "Reset failed.", e2);
                    }
                }
            }
        }
        this.f10598J = 0;
        l52 l52Var = this.f10629x;
        MediaSource.MediaPeriodId mediaPeriodId = l52Var.f22333b;
        long j2 = l52Var.f22349r;
        if (!this.f10629x.f22333b.isAd()) {
            l52 l52Var2 = this.f10629x;
            Timeline.Period period = this.f10617l;
            MediaSource.MediaPeriodId mediaPeriodId2 = l52Var2.f22333b;
            Timeline timeline = l52Var2.f22332a;
            if (!timeline.isEmpty() && !timeline.getPeriodByUid(mediaPeriodId2.periodUid, period).isPlaceholder) {
                j = this.f10629x.f22349r;
                if (z2) {
                    this.f10599K = null;
                    Pair m2611h = m2611h(this.f10629x.f22332a);
                    mediaPeriodId = (MediaSource.MediaPeriodId) m2611h.first;
                    j2 = ((Long) m2611h.second).longValue();
                    boolean equals = mediaPeriodId.equals(this.f10629x.f22333b);
                    j = C0643C.TIME_UNSET;
                    if (!equals) {
                        z5 = true;
                        MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId;
                        long j3 = j2;
                        this.f10624s.m2631b();
                        this.f10592D = false;
                        l52 l52Var3 = this.f10629x;
                        Timeline timeline2 = l52Var3.f22332a;
                        int i = l52Var3.f22336e;
                        if (!z4) {
                            exoPlaybackException = l52Var3.f22337f;
                        }
                        ExoPlaybackException exoPlaybackException2 = exoPlaybackException;
                        if (z5) {
                            trackGroupArray = TrackGroupArray.EMPTY;
                        } else {
                            trackGroupArray = l52Var3.f22339h;
                        }
                        TrackGroupArray trackGroupArray2 = trackGroupArray;
                        if (z5) {
                            trackSelectorResult = this.f10610e;
                        } else {
                            trackSelectorResult = l52Var3.f22340i;
                        }
                        if (z5) {
                            list = ImmutableList.m3902of();
                        } else {
                            list = l52Var3.f22341j;
                        }
                        List list2 = list;
                        l52 l52Var4 = this.f10629x;
                        this.f10629x = new l52(timeline2, mediaPeriodId3, j, j3, i, exoPlaybackException2, false, trackGroupArray2, trackSelectorResult, list2, mediaPeriodId3, l52Var4.f22343l, l52Var4.f22344m, l52Var4.f22345n, j3, 0L, j3, false);
                        if (z3) {
                            um1 um1Var = this.f10625t;
                            HashMap hashMap = um1Var.f27370h;
                            for (sm1 sm1Var : hashMap.values()) {
                                try {
                                    sm1Var.f26489a.releaseSource(sm1Var.f26490b);
                                } catch (RuntimeException e3) {
                                    Log.m3024e("MediaSourceList", "Failed to release child source.", e3);
                                }
                                MediaSource mediaSource = sm1Var.f26489a;
                                rm1 rm1Var = sm1Var.f26491c;
                                mediaSource.removeEventListener(rm1Var);
                                sm1Var.f26489a.removeDrmEventListener(rm1Var);
                            }
                            hashMap.clear();
                            um1Var.f27371i.clear();
                            um1Var.f27373k = false;
                            return;
                        }
                        return;
                    }
                }
                z5 = false;
                MediaSource.MediaPeriodId mediaPeriodId32 = mediaPeriodId;
                long j32 = j2;
                this.f10624s.m2631b();
                this.f10592D = false;
                l52 l52Var32 = this.f10629x;
                Timeline timeline22 = l52Var32.f22332a;
                int i2 = l52Var32.f22336e;
                if (!z4) {
                }
                ExoPlaybackException exoPlaybackException22 = exoPlaybackException;
                if (z5) {
                }
                TrackGroupArray trackGroupArray22 = trackGroupArray;
                if (z5) {
                }
                if (z5) {
                }
                List list22 = list;
                l52 l52Var42 = this.f10629x;
                this.f10629x = new l52(timeline22, mediaPeriodId32, j, j32, i2, exoPlaybackException22, false, trackGroupArray22, trackSelectorResult, list22, mediaPeriodId32, l52Var42.f22343l, l52Var42.f22344m, l52Var42.f22345n, j32, 0L, j32, false);
                if (z3) {
                }
            }
        }
        j = this.f10629x.f22334c;
        if (z2) {
        }
        z5 = false;
        MediaSource.MediaPeriodId mediaPeriodId322 = mediaPeriodId;
        long j322 = j2;
        this.f10624s.m2631b();
        this.f10592D = false;
        l52 l52Var322 = this.f10629x;
        Timeline timeline222 = l52Var322.f22332a;
        int i22 = l52Var322.f22336e;
        if (!z4) {
        }
        ExoPlaybackException exoPlaybackException222 = exoPlaybackException;
        if (z5) {
        }
        TrackGroupArray trackGroupArray222 = trackGroupArray;
        if (z5) {
        }
        if (z5) {
        }
        List list222 = list;
        l52 l52Var422 = this.f10629x;
        this.f10629x = new l52(timeline222, mediaPeriodId322, j, j322, i22, exoPlaybackException222, false, trackGroupArray222, trackSelectorResult, list222, mediaPeriodId322, l52Var422.f22343l, l52Var422.f22344m, l52Var422.f22345n, j322, 0L, j322, false);
        if (z3) {
        }
    }

    /* renamed from: B */
    public final void m2577B() {
        boolean z;
        ul1 ul1Var = this.f10624s.f10641h;
        if (ul1Var != null && ul1Var.f27326f.f27861h && this.f10589A) {
            z = true;
        } else {
            z = false;
        }
        this.f10590B = z;
    }

    /* renamed from: C */
    public final void m2578C(long j) {
        long j2;
        ul1 ul1Var = this.f10624s.f10641h;
        if (ul1Var == null) {
            j2 = 1000000000000L;
        } else {
            j2 = ul1Var.f27335o;
        }
        long j3 = j + j2;
        this.f10600L = j3;
        this.f10620o.f28410a.resetPosition(j3);
        for (Renderer renderer : this.f10606a) {
            if (m2575q(renderer)) {
                renderer.resetPosition(this.f10600L);
            }
        }
        for (ul1 ul1Var2 = r0.f10641h; ul1Var2 != null; ul1Var2 = ul1Var2.f27332l) {
            for (ExoTrackSelection exoTrackSelection : ul1Var2.f27334n.selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    /* renamed from: F */
    public final void m2579F(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.f10621p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!m2571E((qb0) arrayList.get(size), timeline, timeline2, this.f10593E, this.f10594F, this.f10616k, this.f10617l)) {
                ((qb0) arrayList.get(size)).f25502a.markAsProcessed(false);
                arrayList.remove(size);
            }
        }
        Collections.sort(arrayList);
    }

    /* renamed from: I */
    public final void m2580I(boolean z) {
        MediaSource.MediaPeriodId mediaPeriodId = this.f10624s.f10641h.f27326f.f27854a;
        long m2582K = m2582K(mediaPeriodId, this.f10629x.f22349r, true, false);
        if (m2582K != this.f10629x.f22349r) {
            l52 l52Var = this.f10629x;
            this.f10629x = m2618o(mediaPeriodId, m2582K, l52Var.f22334c, l52Var.f22335d, z, 5);
        }
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: J */
    public final void m2581J(sb0 sb0Var) {
        long j;
        boolean z;
        long j2;
        long j3;
        boolean z2;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j4;
        long j5;
        long j6;
        boolean z3;
        boolean z4;
        long j7;
        long j8;
        l52 l52Var;
        int i;
        boolean z5 = true;
        this.f10630y.incrementPendingOperationAcks(1);
        Pair m2572G = m2572G(this.f10629x.f22332a, sb0Var, true, this.f10593E, this.f10594F, this.f10616k, this.f10617l);
        if (m2572G == null) {
            Pair m2611h = m2611h(this.f10629x.f22332a);
            mediaPeriodId = (MediaSource.MediaPeriodId) m2611h.first;
            long longValue = ((Long) m2611h.second).longValue();
            z2 = !this.f10629x.f22332a.isEmpty();
            j2 = longValue;
            j3 = -9223372036854775807L;
        } else {
            Object obj = m2572G.first;
            long longValue2 = ((Long) m2572G.second).longValue();
            if (sb0Var.f26349c == C0643C.TIME_UNSET) {
                j = -9223372036854775807L;
            } else {
                j = longValue2;
            }
            MediaSource.MediaPeriodId m2641m = this.f10624s.m2641m(this.f10629x.f22332a, obj, longValue2);
            if (m2641m.isAd()) {
                this.f10629x.f22332a.getPeriodByUid(m2641m.periodUid, this.f10617l);
                if (this.f10617l.getFirstAdIndexToPlay(m2641m.adGroupIndex) == m2641m.adIndexInAdGroup) {
                    j4 = this.f10617l.getAdResumePositionUs();
                } else {
                    j4 = 0;
                }
                j2 = j4;
                j3 = j;
                mediaPeriodId = m2641m;
                z2 = true;
            } else {
                if (sb0Var.f26349c == C0643C.TIME_UNSET) {
                    z = true;
                } else {
                    z = false;
                }
                j2 = longValue2;
                j3 = j;
                z2 = z;
                mediaPeriodId = m2641m;
            }
        }
        try {
            if (this.f10629x.f22332a.isEmpty()) {
                this.f10599K = sb0Var;
            } else if (m2572G == null) {
                if (this.f10629x.f22336e != 1) {
                    m2595X(4);
                }
                m2576A(false, true, false, true);
            } else {
                if (mediaPeriodId.equals(this.f10629x.f22333b)) {
                    ul1 ul1Var = this.f10624s.f10641h;
                    if (ul1Var != null && ul1Var.f27324d && j2 != 0) {
                        j8 = ul1Var.f27321a.getAdjustedSeekPositionUs(j2, this.f10628w);
                    } else {
                        j8 = j2;
                    }
                    if (Util.usToMs(j8) == Util.usToMs(this.f10629x.f22349r) && ((i = (l52Var = this.f10629x).f22336e) == 2 || i == 3)) {
                        long j9 = l52Var.f22349r;
                        this.f10629x = m2618o(mediaPeriodId, j9, j3, j9, z2, 2);
                        return;
                    }
                    j6 = j8;
                } else {
                    j6 = j2;
                }
                if (this.f10629x.f22336e == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                C0674h c0674h = this.f10624s;
                if (c0674h.f10641h != c0674h.f10642i) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                long m2582K = m2582K(mediaPeriodId, j6, z4, z3);
                if (j2 == m2582K) {
                    z5 = false;
                }
                boolean z6 = z5 | z2;
                try {
                    l52 l52Var2 = this.f10629x;
                    Timeline timeline = l52Var2.f22332a;
                    m2608f0(timeline, mediaPeriodId, timeline, l52Var2.f22333b, j3);
                    z2 = z6;
                    j7 = m2582K;
                    this.f10629x = m2618o(mediaPeriodId, j7, j3, j7, z2, 2);
                } catch (Throwable th) {
                    th = th;
                    z2 = z6;
                    j5 = m2582K;
                    this.f10629x = m2618o(mediaPeriodId, j5, j3, j5, z2, 2);
                    throw th;
                }
            }
            j7 = j2;
            this.f10629x = m2618o(mediaPeriodId, j7, j3, j7, z2, 2);
        } catch (Throwable th2) {
            th = th2;
            j5 = j2;
        }
    }

    /* JADX WARN: Type inference failed for: r9v7, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: K */
    public final long m2582K(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) {
        m2602c0();
        this.f10591C = false;
        if (z2 || this.f10629x.f22336e == 3) {
            m2595X(2);
        }
        C0674h c0674h = this.f10624s;
        ul1 ul1Var = c0674h.f10641h;
        ul1 ul1Var2 = ul1Var;
        while (ul1Var2 != null && !mediaPeriodId.equals(ul1Var2.f27326f.f27854a)) {
            ul1Var2 = ul1Var2.f27332l;
        }
        if (z || ul1Var != ul1Var2 || (ul1Var2 != null && ul1Var2.f27335o + j < 0)) {
            Renderer[] rendererArr = this.f10606a;
            for (Renderer renderer : rendererArr) {
                m2601c(renderer);
            }
            if (ul1Var2 != null) {
                while (c0674h.f10641h != ul1Var2) {
                    c0674h.m2630a();
                }
                c0674h.m2640k(ul1Var2);
                ul1Var2.f27335o = 1000000000000L;
                m2605e(new boolean[rendererArr.length]);
            }
        }
        if (ul1Var2 != null) {
            c0674h.m2640k(ul1Var2);
            if (!ul1Var2.f27324d) {
                ul1Var2.f27326f = ul1Var2.f27326f.m7924b(j);
            } else if (ul1Var2.f27325e) {
                ?? r9 = ul1Var2.f27321a;
                j = r9.seekToUs(j);
                r9.discardBuffer(j - this.f10618m, this.f10619n);
            }
            m2578C(j);
            m2621s();
        } else {
            c0674h.m2631b();
            m2578C(j);
        }
        m2614k(false);
        this.f10613h.sendEmptyMessage(2);
        return j;
    }

    /* renamed from: L */
    public final void m2583L(PlayerMessage playerMessage) {
        if (playerMessage.getPositionMs() == C0643C.TIME_UNSET) {
            m2584M(playerMessage);
            return;
        }
        boolean isEmpty = this.f10629x.f22332a.isEmpty();
        ArrayList arrayList = this.f10621p;
        if (isEmpty) {
            arrayList.add(new qb0(playerMessage));
            return;
        }
        qb0 qb0Var = new qb0(playerMessage);
        Timeline timeline = this.f10629x.f22332a;
        if (m2571E(qb0Var, timeline, timeline, this.f10593E, this.f10594F, this.f10616k, this.f10617l)) {
            arrayList.add(qb0Var);
            Collections.sort(arrayList);
        } else {
            playerMessage.markAsProcessed(false);
        }
    }

    /* renamed from: M */
    public final void m2584M(PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        Looper looper2 = this.f10615j;
        HandlerWrapper handlerWrapper = this.f10613h;
        if (looper == looper2) {
            m2574b(playerMessage);
            int i = this.f10629x.f22336e;
            if (i == 3 || i == 2) {
                handlerWrapper.sendEmptyMessage(2);
                return;
            }
            return;
        }
        handlerWrapper.obtainMessage(15, playerMessage).sendToTarget();
    }

    /* renamed from: N */
    public final void m2585N(PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (!looper.getThread().isAlive()) {
            Log.m3027w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        } else {
            this.f10622q.createHandler(looper, null).post(new RunnableC0583c7(20, this, playerMessage));
        }
    }

    /* renamed from: O */
    public final void m2586O(boolean z, AtomicBoolean atomicBoolean) {
        if (this.f10595G != z) {
            this.f10595G = z;
            if (!z) {
                for (Renderer renderer : this.f10606a) {
                    if (!m2575q(renderer) && this.f10607b.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* renamed from: P */
    public final void m2587P(ob0 ob0Var) {
        this.f10630y.incrementPendingOperationAcks(1);
        int i = ob0Var.f23696c;
        ArrayList arrayList = ob0Var.f23694a;
        ShuffleOrder shuffleOrder = ob0Var.f23695b;
        if (i != -1) {
            this.f10599K = new sb0(new l62(arrayList, shuffleOrder), ob0Var.f23696c, ob0Var.f23697d);
        }
        um1 um1Var = this.f10625t;
        ArrayList arrayList2 = um1Var.f27364b;
        um1Var.m7755g(0, arrayList2.size());
        m2615l(um1Var.m7749a(arrayList2.size(), arrayList, shuffleOrder), false);
    }

    /* renamed from: Q */
    public final void m2588Q(boolean z) {
        if (z == this.f10597I) {
            return;
        }
        this.f10597I = z;
        if (!z && this.f10629x.f22346o) {
            this.f10613h.sendEmptyMessage(2);
        }
    }

    /* renamed from: R */
    public final void m2589R(boolean z) {
        this.f10589A = z;
        m2577B();
        if (this.f10590B) {
            C0674h c0674h = this.f10624s;
            if (c0674h.f10642i != c0674h.f10641h) {
                m2580I(true);
                m2614k(false);
            }
        }
    }

    /* renamed from: S */
    public final void m2590S(int i, int i2, boolean z, boolean z2) {
        this.f10630y.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.f10630y.setPlayWhenReadyChangeReason(i2);
        this.f10629x = this.f10629x.m5858c(i, z);
        this.f10591C = false;
        for (ul1 ul1Var = this.f10624s.f10641h; ul1Var != null; ul1Var = ul1Var.f27332l) {
            for (ExoTrackSelection exoTrackSelection : ul1Var.f27334n.selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z);
                }
            }
        }
        if (!m2596Y()) {
            m2602c0();
            m2606e0();
            return;
        }
        int i3 = this.f10629x.f22336e;
        HandlerWrapper handlerWrapper = this.f10613h;
        if (i3 == 3) {
            m2599a0();
            handlerWrapper.sendEmptyMessage(2);
        } else if (i3 == 2) {
            handlerWrapper.sendEmptyMessage(2);
        }
    }

    /* renamed from: T */
    public final void m2591T(PlaybackParameters playbackParameters) {
        x00 x00Var = this.f10620o;
        x00Var.setPlaybackParameters(playbackParameters);
        PlaybackParameters playbackParameters2 = x00Var.getPlaybackParameters();
        m2617n(playbackParameters2, playbackParameters2.speed, true, true);
    }

    /* renamed from: U */
    public final void m2592U(int i) {
        this.f10593E = i;
        Timeline timeline = this.f10629x.f22332a;
        C0674h c0674h = this.f10624s;
        c0674h.f10639f = i;
        if (!c0674h.m2642n(timeline)) {
            m2580I(true);
        }
        m2614k(false);
    }

    /* renamed from: V */
    public final void m2593V(boolean z) {
        this.f10594F = z;
        Timeline timeline = this.f10629x.f22332a;
        C0674h c0674h = this.f10624s;
        c0674h.f10640g = z;
        if (!c0674h.m2642n(timeline)) {
            m2580I(true);
        }
        m2614k(false);
    }

    /* renamed from: W */
    public final void m2594W(ShuffleOrder shuffleOrder) {
        this.f10630y.incrementPendingOperationAcks(1);
        um1 um1Var = this.f10625t;
        int size = um1Var.f27364b.size();
        if (shuffleOrder.getLength() != size) {
            shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, size);
        }
        um1Var.f27372j = shuffleOrder;
        m2615l(um1Var.m7750b(), false);
    }

    /* renamed from: X */
    public final void m2595X(int i) {
        l52 l52Var = this.f10629x;
        if (l52Var.f22336e != i) {
            if (i != 2) {
                this.f10605Q = C0643C.TIME_UNSET;
            }
            this.f10629x = l52Var.m5861f(i);
        }
    }

    /* renamed from: Y */
    public final boolean m2596Y() {
        l52 l52Var = this.f10629x;
        if (l52Var.f22343l && l52Var.f22344m == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: Z */
    public final boolean m2597Z(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        int i = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.f10617l).windowIndex;
        Timeline.Window window = this.f10616k;
        timeline.getWindow(i, window);
        if (!window.isLive() || !window.isDynamic || window.windowStartTimeMs == C0643C.TIME_UNSET) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final void m2598a(ob0 ob0Var, int i) {
        this.f10630y.incrementPendingOperationAcks(1);
        um1 um1Var = this.f10625t;
        if (i == -1) {
            i = um1Var.f27364b.size();
        }
        m2615l(um1Var.m7749a(i, ob0Var.f23694a, ob0Var.f23695b), false);
    }

    /* renamed from: a0 */
    public final void m2599a0() {
        this.f10591C = false;
        x00 x00Var = this.f10620o;
        x00Var.f28415f = true;
        x00Var.f28410a.start();
        for (Renderer renderer : this.f10606a) {
            if (m2575q(renderer)) {
                renderer.start();
            }
        }
    }

    /* renamed from: b0 */
    public final void m2600b0(boolean z, boolean z2) {
        boolean z3;
        if (!z && this.f10595G) {
            z3 = false;
        } else {
            z3 = true;
        }
        m2576A(z3, false, true, false);
        this.f10630y.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.f10611f.onStopped();
        m2595X(1);
    }

    /* renamed from: c */
    public final void m2601c(Renderer renderer) {
        if (!m2575q(renderer)) {
            return;
        }
        x00 x00Var = this.f10620o;
        if (renderer == x00Var.f28412c) {
            x00Var.f28413d = null;
            x00Var.f28412c = null;
            x00Var.f28414e = true;
        }
        if (renderer.getState() == 2) {
            renderer.stop();
        }
        renderer.disable();
        this.f10598J--;
    }

    /* renamed from: c0 */
    public final void m2602c0() {
        x00 x00Var = this.f10620o;
        x00Var.f28415f = false;
        x00Var.f28410a.stop();
        for (Renderer renderer : this.f10606a) {
            if (m2575q(renderer) && renderer.getState() == 2) {
                renderer.stop();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:230:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0310 A[EDGE_INSN: B:74:0x0310->B:75:0x0310 BREAK  A[LOOP:0: B:42:0x02ab->B:53:0x030c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0362  */
    /* JADX WARN: Type inference failed for: r0v57, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v43, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v84, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v34, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v15, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27, types: [int] */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2603d() {
        C0672f c0672f;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        boolean z5;
        l52 l52Var;
        long j2;
        boolean z6;
        boolean z7;
        boolean z8;
        long max;
        boolean z9;
        boolean z10;
        boolean z11;
        l52 l52Var2;
        int i;
        boolean z12;
        boolean z13;
        boolean z14;
        vl1 m2632c;
        long j3;
        int i2;
        ul1 ul1Var;
        C0672f c0672f2;
        long j4;
        ?? r3;
        boolean z15;
        ul1 ul1Var2;
        boolean z16;
        C0674h c0674h;
        ul1 ul1Var3;
        ul1 ul1Var4;
        ul1 ul1Var5;
        boolean z17;
        int i3;
        boolean z18;
        Renderer[] rendererArr;
        boolean z19;
        int i4;
        boolean z20;
        long uptimeMillis = this.f10622q.uptimeMillis();
        this.f10613h.removeMessages(2);
        if (this.f10629x.f22332a.isEmpty() || !this.f10625t.f27373k) {
            c0672f = this;
            z = true;
            z2 = false;
        } else {
            C0674h c0674h2 = this.f10624s;
            long j5 = this.f10600L;
            ul1 ul1Var6 = c0674h2.f10643j;
            if (ul1Var6 != null) {
                if (ul1Var6.f27332l == null) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                Assertions.checkState(z20);
                if (ul1Var6.f27324d) {
                    ul1Var6.f27321a.reevaluateBuffer(j5 - ul1Var6.f27335o);
                }
            }
            C0674h c0674h3 = this.f10624s;
            ul1 ul1Var7 = c0674h3.f10643j;
            if (ul1Var7 == null || (!ul1Var7.f27326f.f27862i && ul1Var7.f27324d && ((!ul1Var7.f27325e || ul1Var7.f27321a.getBufferedPositionUs() == Long.MIN_VALUE) && c0674h3.f10643j.f27326f.f27858e != C0643C.TIME_UNSET && c0674h3.f10644k < 100))) {
                C0674h c0674h4 = this.f10624s;
                long j6 = this.f10600L;
                l52 l52Var3 = this.f10629x;
                ul1 ul1Var8 = c0674h4.f10643j;
                if (ul1Var8 == null) {
                    m2632c = c0674h4.m2633d(l52Var3.f22332a, l52Var3.f22333b, l52Var3.f22334c, l52Var3.f22349r);
                } else {
                    m2632c = c0674h4.m2632c(l52Var3.f22332a, ul1Var8, j6);
                }
                if (m2632c != null) {
                    C0674h c0674h5 = this.f10624s;
                    RendererCapabilities[] rendererCapabilitiesArr = this.f10608c;
                    TrackSelector trackSelector = this.f10609d;
                    Allocator allocator = this.f10611f.getAllocator();
                    um1 um1Var = this.f10625t;
                    TrackSelectorResult trackSelectorResult = this.f10610e;
                    ul1 ul1Var9 = c0674h5.f10643j;
                    if (ul1Var9 == null) {
                        j3 = 1000000000000L;
                    } else {
                        j3 = (ul1Var9.f27335o + ul1Var9.f27326f.f27858e) - m2632c.f27855b;
                    }
                    ul1 ul1Var10 = new ul1(rendererCapabilitiesArr, j3, trackSelector, allocator, um1Var, m2632c, trackSelectorResult);
                    ul1 ul1Var11 = c0674h5.f10643j;
                    if (ul1Var11 != null) {
                        if (ul1Var10 != ul1Var11.f27332l) {
                            ul1Var11.m7739b();
                            ul1Var11.f27332l = ul1Var10;
                            ul1Var11.m7740c();
                        }
                    } else {
                        c0674h5.f10641h = ul1Var10;
                        c0674h5.f10642i = ul1Var10;
                    }
                    c0674h5.f10645l = null;
                    c0674h5.f10643j = ul1Var10;
                    c0674h5.f10644k++;
                    c0674h5.m2639j();
                    ul1Var10.f27321a.prepare(this, m2632c.f27855b);
                    if (this.f10624s.f10641h == ul1Var10) {
                        m2578C(m2632c.f27855b);
                    }
                    i2 = 0;
                    m2614k(false);
                    if (!this.f10592D) {
                        this.f10592D = m2619p();
                        m2604d0();
                    } else {
                        m2621s();
                    }
                    C0674h c0674h6 = this.f10624s;
                    ul1Var = c0674h6.f10642i;
                    if (ul1Var != null) {
                        ul1 ul1Var12 = ul1Var.f27332l;
                        Renderer[] rendererArr2 = this.f10606a;
                        if (ul1Var12 == null || this.f10590B) {
                            c0672f2 = this;
                            if (ul1Var.f27326f.f27862i || c0672f2.f10590B) {
                                for (int i5 = 0; i5 < rendererArr2.length; i5++) {
                                    Renderer renderer = rendererArr2[i5];
                                    SampleStream sampleStream = ul1Var.f27323c[i5];
                                    if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                                        long j7 = ul1Var.f27326f.f27858e;
                                        if (j7 != C0643C.TIME_UNSET && j7 != Long.MIN_VALUE) {
                                            j4 = j7 + ul1Var.f27335o;
                                        } else {
                                            j4 = -9223372036854775807L;
                                        }
                                        renderer.setCurrentStreamFinal();
                                        if (renderer instanceof TextRenderer) {
                                            ((TextRenderer) renderer).setFinalStreamEndPositionUs(j4);
                                        }
                                    }
                                }
                            }
                        } else if (ul1Var.f27324d) {
                            int i6 = i2;
                            while (true) {
                                if (i6 < rendererArr2.length) {
                                    Renderer renderer2 = rendererArr2[i6];
                                    SampleStream sampleStream2 = ul1Var.f27323c[i6];
                                    if (renderer2.getStream() != sampleStream2) {
                                        break;
                                    }
                                    if (sampleStream2 != null && !renderer2.hasReadStreamToEnd()) {
                                        ul1 ul1Var13 = ul1Var.f27332l;
                                        if (!ul1Var.f27326f.f27859f) {
                                            break;
                                        }
                                        if (!ul1Var13.f27324d) {
                                            break;
                                        }
                                        if (!(renderer2 instanceof TextRenderer) && !(renderer2 instanceof MetadataRenderer) && renderer2.getReadingPositionUs() < ul1Var13.m7742e()) {
                                            break;
                                        }
                                    }
                                    i6++;
                                } else {
                                    ul1 ul1Var14 = ul1Var.f27332l;
                                    if (ul1Var14.f27324d || this.f10600L >= ul1Var14.m7742e()) {
                                        TrackSelectorResult trackSelectorResult2 = ul1Var.f27334n;
                                        ul1 ul1Var15 = c0674h6.f10642i;
                                        if (ul1Var15 != null && ul1Var15.f27332l != null) {
                                            r3 = 1;
                                        } else {
                                            r3 = i2;
                                        }
                                        Assertions.checkState(r3);
                                        c0674h6.f10642i = c0674h6.f10642i.f27332l;
                                        c0674h6.m2639j();
                                        ul1 ul1Var16 = c0674h6.f10642i;
                                        TrackSelectorResult trackSelectorResult3 = ul1Var16.f27334n;
                                        Timeline timeline = this.f10629x.f22332a;
                                        m2608f0(timeline, ul1Var16.f27326f.f27854a, timeline, ul1Var.f27326f.f27854a, C0643C.TIME_UNSET);
                                        if (ul1Var16.f27324d && ul1Var16.f27321a.readDiscontinuity() != C0643C.TIME_UNSET) {
                                            long m7742e = ul1Var16.m7742e();
                                            for (Renderer renderer3 : rendererArr2) {
                                                if (renderer3.getStream() != null) {
                                                    renderer3.setCurrentStreamFinal();
                                                    if (renderer3 instanceof TextRenderer) {
                                                        ((TextRenderer) renderer3).setFinalStreamEndPositionUs(m7742e);
                                                    }
                                                }
                                            }
                                        } else {
                                            for (int i7 = 0; i7 < rendererArr2.length; i7++) {
                                                boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i7);
                                                boolean isRendererEnabled2 = trackSelectorResult3.isRendererEnabled(i7);
                                                if (isRendererEnabled && !rendererArr2[i7].isCurrentStreamFinal()) {
                                                    if (this.f10608c[i7].getTrackType() == -2) {
                                                        z15 = true;
                                                    } else {
                                                        z15 = false;
                                                    }
                                                    RendererConfiguration rendererConfiguration = trackSelectorResult2.rendererConfigurations[i7];
                                                    RendererConfiguration rendererConfiguration2 = trackSelectorResult3.rendererConfigurations[i7];
                                                    if (!isRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z15) {
                                                        Renderer renderer4 = rendererArr2[i7];
                                                        long m7742e2 = ul1Var16.m7742e();
                                                        renderer4.setCurrentStreamFinal();
                                                        if (renderer4 instanceof TextRenderer) {
                                                            ((TextRenderer) renderer4).setFinalStreamEndPositionUs(m7742e2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        c0672f2 = this;
                                    }
                                }
                            }
                        }
                        C0674h c0674h7 = c0672f2.f10624s;
                        ul1Var2 = c0674h7.f10642i;
                        if (ul1Var2 != null && c0674h7.f10641h != ul1Var2 && !ul1Var2.f27327g) {
                            TrackSelectorResult trackSelectorResult4 = ul1Var2.f27334n;
                            i3 = 0;
                            z18 = false;
                            while (true) {
                                rendererArr = c0672f2.f10606a;
                                if (i3 < rendererArr.length) {
                                    break;
                                }
                                Renderer renderer5 = rendererArr[i3];
                                if (m2575q(renderer5)) {
                                    SampleStream stream = renderer5.getStream();
                                    SampleStream[] sampleStreamArr = ul1Var2.f27323c;
                                    if (stream != sampleStreamArr[i3]) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (!trackSelectorResult4.isRendererEnabled(i3) || z19) {
                                        if (!renderer5.isCurrentStreamFinal()) {
                                            ExoTrackSelection exoTrackSelection = trackSelectorResult4.selections[i3];
                                            if (exoTrackSelection != null) {
                                                i4 = exoTrackSelection.length();
                                            } else {
                                                i4 = 0;
                                            }
                                            Format[] formatArr = new Format[i4];
                                            for (int i8 = 0; i8 < i4; i8++) {
                                                formatArr[i8] = exoTrackSelection.getFormat(i8);
                                            }
                                            renderer5.replaceStream(formatArr, sampleStreamArr[i3], ul1Var2.m7742e(), ul1Var2.f27335o);
                                        } else if (renderer5.isEnded()) {
                                            c0672f2.m2601c(renderer5);
                                        } else {
                                            z18 = true;
                                        }
                                    }
                                }
                                i3++;
                            }
                            if (!z18) {
                                c0672f2.m2605e(new boolean[rendererArr.length]);
                            }
                        }
                        z16 = false;
                        while (m2596Y() && !c0672f2.f10590B && (ul1Var3 = (c0674h = c0672f2.f10624s).f10641h) != null && (ul1Var4 = ul1Var3.f27332l) != null && c0672f2.f10600L >= ul1Var4.m7742e() && ul1Var4.f27327g) {
                            if (z16) {
                                m2622t();
                            }
                            ul1Var5 = (ul1) Assertions.checkNotNull(c0674h.m2630a());
                            if (c0672f2.f10629x.f22333b.periodUid.equals(ul1Var5.f27326f.f27854a.periodUid)) {
                                MediaSource.MediaPeriodId mediaPeriodId = c0672f2.f10629x.f22333b;
                                if (mediaPeriodId.adGroupIndex == -1) {
                                    MediaSource.MediaPeriodId mediaPeriodId2 = ul1Var5.f27326f.f27854a;
                                    if (mediaPeriodId2.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex != mediaPeriodId2.nextAdGroupIndex) {
                                        z17 = true;
                                        vl1 vl1Var = ul1Var5.f27326f;
                                        MediaSource.MediaPeriodId mediaPeriodId3 = vl1Var.f27854a;
                                        long j8 = vl1Var.f27855b;
                                        C0672f c0672f3 = c0672f2;
                                        c0672f3.f10629x = m2618o(mediaPeriodId3, j8, vl1Var.f27856c, j8, !z17, 0);
                                        m2577B();
                                        m2606e0();
                                        c0672f2 = c0672f3;
                                        z16 = true;
                                    }
                                }
                            }
                            z17 = false;
                            vl1 vl1Var2 = ul1Var5.f27326f;
                            MediaSource.MediaPeriodId mediaPeriodId32 = vl1Var2.f27854a;
                            long j82 = vl1Var2.f27855b;
                            C0672f c0672f32 = c0672f2;
                            c0672f32.f10629x = m2618o(mediaPeriodId32, j82, vl1Var2.f27856c, j82, !z17, 0);
                            m2577B();
                            m2606e0();
                            c0672f2 = c0672f32;
                            z16 = true;
                        }
                        c0672f = c0672f2;
                        z = true;
                        z2 = false;
                    }
                    c0672f2 = this;
                    C0674h c0674h72 = c0672f2.f10624s;
                    ul1Var2 = c0674h72.f10642i;
                    if (ul1Var2 != null) {
                        TrackSelectorResult trackSelectorResult42 = ul1Var2.f27334n;
                        i3 = 0;
                        z18 = false;
                        while (true) {
                            rendererArr = c0672f2.f10606a;
                            if (i3 < rendererArr.length) {
                            }
                            i3++;
                        }
                        if (!z18) {
                        }
                    }
                    z16 = false;
                    while (m2596Y()) {
                        if (z16) {
                        }
                        ul1Var5 = (ul1) Assertions.checkNotNull(c0674h.m2630a());
                        if (c0672f2.f10629x.f22333b.periodUid.equals(ul1Var5.f27326f.f27854a.periodUid)) {
                        }
                        z17 = false;
                        vl1 vl1Var22 = ul1Var5.f27326f;
                        MediaSource.MediaPeriodId mediaPeriodId322 = vl1Var22.f27854a;
                        long j822 = vl1Var22.f27855b;
                        C0672f c0672f322 = c0672f2;
                        c0672f322.f10629x = m2618o(mediaPeriodId322, j822, vl1Var22.f27856c, j822, !z17, 0);
                        m2577B();
                        m2606e0();
                        c0672f2 = c0672f322;
                        z16 = true;
                    }
                    c0672f = c0672f2;
                    z = true;
                    z2 = false;
                }
            }
            i2 = 0;
            if (!this.f10592D) {
            }
            C0674h c0674h62 = this.f10624s;
            ul1Var = c0674h62.f10642i;
            if (ul1Var != null) {
            }
            c0672f2 = this;
            C0674h c0674h722 = c0672f2.f10624s;
            ul1Var2 = c0674h722.f10642i;
            if (ul1Var2 != null) {
            }
            z16 = false;
            while (m2596Y()) {
            }
            c0672f = c0672f2;
            z = true;
            z2 = false;
        }
        int i9 = c0672f.f10629x.f22336e;
        if (i9 != z && i9 != 4) {
            ul1 ul1Var17 = c0672f.f10624s.f10641h;
            if (ul1Var17 == null) {
                c0672f.f10613h.sendEmptyMessageAtTime(2, uptimeMillis + 10);
                return;
            }
            TraceUtil.beginSection("doSomeWork");
            m2606e0();
            if (ul1Var17.f27324d) {
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                ul1Var17.f27321a.discardBuffer(c0672f.f10629x.f22349r - c0672f.f10618m, c0672f.f10619n);
                boolean z21 = z;
                z3 = z21;
                ?? r9 = z2;
                while (true) {
                    Renderer[] rendererArr3 = c0672f.f10606a;
                    if (r9 >= rendererArr3.length) {
                        break;
                    }
                    Renderer renderer6 = rendererArr3[r9];
                    if (m2575q(renderer6)) {
                        renderer6.render(c0672f.f10600L, elapsedRealtime);
                        if (z21 && renderer6.isEnded()) {
                            z21 = z;
                        } else {
                            z21 = z2;
                        }
                        if (ul1Var17.f27323c[r9] != renderer6.getStream()) {
                            z12 = z;
                        } else {
                            z12 = z2;
                        }
                        if (!z12 && renderer6.hasReadStreamToEnd()) {
                            z13 = z;
                        } else {
                            z13 = z2;
                        }
                        if (!z12 && !z13 && !renderer6.isReady() && !renderer6.isEnded()) {
                            z14 = z2;
                        } else {
                            z14 = z;
                        }
                        if (z3 && z14) {
                            z3 = z;
                        } else {
                            z3 = z2;
                        }
                        if (!z14) {
                            renderer6.maybeThrowStreamError();
                        }
                    }
                    r9++;
                }
                z4 = z21;
            } else {
                ul1Var17.f27321a.maybeThrowPrepareError();
                z3 = z;
                z4 = z3;
            }
            long j9 = ul1Var17.f27326f.f27858e;
            if (z4 && ul1Var17.f27324d) {
                j = C0643C.TIME_UNSET;
                if (j9 == C0643C.TIME_UNSET || j9 <= c0672f.f10629x.f22349r) {
                    z5 = z;
                    if (z5 && c0672f.f10590B) {
                        c0672f.f10590B = z2;
                        c0672f.m2590S(c0672f.f10629x.f22344m, 5, z2, z2);
                    }
                    if (!z5 && ul1Var17.f27326f.f27862i) {
                        c0672f.m2595X(4);
                        m2602c0();
                    } else {
                        l52Var = c0672f.f10629x;
                        if (l52Var.f22336e == 2) {
                            if (c0672f.f10598J == 0) {
                                z8 = m2620r();
                            } else if (!z3) {
                                z8 = z2;
                            } else if (!l52Var.f22338g) {
                                z8 = z;
                            } else {
                                Timeline timeline2 = l52Var.f22332a;
                                C0674h c0674h8 = c0672f.f10624s;
                                if (c0672f.m2597Z(timeline2, c0674h8.f10641h.f27326f.f27854a)) {
                                    j2 = c0672f.f10626u.getTargetLiveOffsetUs();
                                } else {
                                    j2 = j;
                                }
                                ul1 ul1Var18 = c0674h8.f10643j;
                                if (ul1Var18.f27324d && ((!ul1Var18.f27325e || ul1Var18.f27321a.getBufferedPositionUs() == Long.MIN_VALUE) && ul1Var18.f27326f.f27862i)) {
                                    z6 = z;
                                } else {
                                    z6 = z2;
                                }
                                if (ul1Var18.f27326f.f27854a.isAd() && !ul1Var18.f27324d) {
                                    z7 = z;
                                } else {
                                    z7 = z2;
                                }
                                if (!z6 && !z7) {
                                    long j10 = c0672f.f10629x.f22347p;
                                    ul1 ul1Var19 = c0672f.f10624s.f10643j;
                                    if (ul1Var19 == null) {
                                        max = 0;
                                    } else {
                                        max = Math.max(0L, j10 - (c0672f.f10600L - ul1Var19.f27335o));
                                    }
                                    if (!c0672f.f10611f.shouldStartPlayback(max, c0672f.f10620o.getPlaybackParameters().speed, c0672f.f10591C, j2)) {
                                        z8 = false;
                                    }
                                }
                                z8 = true;
                            }
                            if (z8) {
                                c0672f.m2595X(3);
                                c0672f.f10603O = null;
                                if (m2596Y()) {
                                    m2599a0();
                                }
                            }
                        }
                        if (c0672f.f10629x.f22336e == 3 && (c0672f.f10598J != 0 ? !z3 : !m2620r())) {
                            c0672f.f10591C = m2596Y();
                            c0672f.m2595X(2);
                            if (c0672f.f10591C) {
                                for (ul1 ul1Var20 = c0672f.f10624s.f10641h; ul1Var20 != null; ul1Var20 = ul1Var20.f27332l) {
                                    for (ExoTrackSelection exoTrackSelection2 : ul1Var20.f27334n.selections) {
                                        if (exoTrackSelection2 != null) {
                                            exoTrackSelection2.onRebuffer();
                                        }
                                    }
                                }
                                c0672f.f10626u.notifyRebuffer();
                            }
                            m2602c0();
                        }
                    }
                    if (c0672f.f10629x.f22336e == 2) {
                        int i10 = 0;
                        while (true) {
                            Renderer[] rendererArr4 = c0672f.f10606a;
                            if (i10 >= rendererArr4.length) {
                                break;
                            }
                            if (m2575q(rendererArr4[i10]) && c0672f.f10606a[i10].getStream() == ul1Var17.f27323c[i10]) {
                                c0672f.f10606a[i10].maybeThrowStreamError();
                            }
                            i10++;
                        }
                        l52 l52Var4 = c0672f.f10629x;
                        if (!l52Var4.f22338g && l52Var4.f22348q < 500000 && m2619p()) {
                            z9 = true;
                            if (!z9) {
                                c0672f.f10605Q = C0643C.TIME_UNSET;
                            } else if (c0672f.f10605Q == C0643C.TIME_UNSET) {
                                c0672f.f10605Q = c0672f.f10622q.elapsedRealtime();
                            } else if (c0672f.f10622q.elapsedRealtime() - c0672f.f10605Q >= 4000) {
                                throw new IllegalStateException("Playback stuck buffering and not loading");
                            }
                            if (!m2596Y() && c0672f.f10629x.f22336e == 3) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (!c0672f.f10597I && c0672f.f10596H && z10) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            l52Var2 = c0672f.f10629x;
                            if (l52Var2.f22346o != z11) {
                                c0672f.f10629x = new l52(l52Var2.f22332a, l52Var2.f22333b, l52Var2.f22334c, l52Var2.f22335d, l52Var2.f22336e, l52Var2.f22337f, l52Var2.f22338g, l52Var2.f22339h, l52Var2.f22340i, l52Var2.f22341j, l52Var2.f22342k, l52Var2.f22343l, l52Var2.f22344m, l52Var2.f22345n, l52Var2.f22347p, l52Var2.f22348q, l52Var2.f22349r, z11);
                            }
                            c0672f.f10596H = false;
                            if (!z11 && (i = c0672f.f10629x.f22336e) != 4) {
                                if (!z10 && i != 2) {
                                    if (i == 3 && c0672f.f10598J != 0) {
                                        c0672f.f10613h.sendEmptyMessageAtTime(2, uptimeMillis + 1000);
                                    }
                                } else {
                                    c0672f.f10613h.sendEmptyMessageAtTime(2, uptimeMillis + 10);
                                }
                                TraceUtil.endSection();
                                return;
                            }
                            return;
                        }
                    }
                    z9 = false;
                    if (!z9) {
                    }
                    if (!m2596Y()) {
                    }
                    z10 = false;
                    if (!c0672f.f10597I) {
                    }
                    z11 = false;
                    l52Var2 = c0672f.f10629x;
                    if (l52Var2.f22346o != z11) {
                    }
                    c0672f.f10596H = false;
                    if (!z11) {
                        return;
                    } else {
                        return;
                    }
                }
            } else {
                j = C0643C.TIME_UNSET;
            }
            z5 = z2;
            if (z5) {
                c0672f.f10590B = z2;
                c0672f.m2590S(c0672f.f10629x.f22344m, 5, z2, z2);
            }
            if (!z5) {
            }
            l52Var = c0672f.f10629x;
            if (l52Var.f22336e == 2) {
            }
            if (c0672f.f10629x.f22336e == 3) {
                c0672f.f10591C = m2596Y();
                c0672f.m2595X(2);
                if (c0672f.f10591C) {
                }
                m2602c0();
            }
            if (c0672f.f10629x.f22336e == 2) {
            }
            z9 = false;
            if (!z9) {
            }
            if (!m2596Y()) {
            }
            z10 = false;
            if (!c0672f.f10597I) {
            }
            z11 = false;
            l52Var2 = c0672f.f10629x;
            if (l52Var2.f22346o != z11) {
            }
            c0672f.f10596H = false;
            if (!z11) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: d0 */
    public final void m2604d0() {
        boolean z;
        ul1 ul1Var = this.f10624s.f10643j;
        if (!this.f10592D && (ul1Var == null || !ul1Var.f27321a.isLoading())) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        l52 l52Var = this.f10629x;
        if (z2 != l52Var.f22338g) {
            this.f10629x = new l52(l52Var.f22332a, l52Var.f22333b, l52Var.f22334c, l52Var.f22335d, l52Var.f22336e, l52Var.f22337f, z2, l52Var.f22339h, l52Var.f22340i, l52Var.f22341j, l52Var.f22342k, l52Var.f22343l, l52Var.f22344m, l52Var.f22345n, l52Var.f22347p, l52Var.f22348q, l52Var.f22349r, l52Var.f22346o);
        }
    }

    /* renamed from: e */
    public final void m2605e(boolean[] zArr) {
        Renderer[] rendererArr;
        Set set;
        Renderer[] rendererArr2;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        MediaClock mediaClock;
        C0674h c0674h = this.f10624s;
        ul1 ul1Var = c0674h.f10642i;
        TrackSelectorResult trackSelectorResult = ul1Var.f27334n;
        int i2 = 0;
        while (true) {
            rendererArr = this.f10606a;
            int length = rendererArr.length;
            set = this.f10607b;
            if (i2 >= length) {
                break;
            }
            if (!trackSelectorResult.isRendererEnabled(i2) && set.remove(rendererArr[i2])) {
                rendererArr[i2].reset();
            }
            i2++;
        }
        int i3 = 0;
        while (i3 < rendererArr.length) {
            if (trackSelectorResult.isRendererEnabled(i3)) {
                boolean z4 = zArr[i3];
                Renderer renderer = rendererArr[i3];
                if (!m2575q(renderer)) {
                    ul1 ul1Var2 = c0674h.f10642i;
                    if (ul1Var2 == c0674h.f10641h) {
                        z = true;
                    } else {
                        z = false;
                    }
                    TrackSelectorResult trackSelectorResult2 = ul1Var2.f27334n;
                    RendererConfiguration rendererConfiguration = trackSelectorResult2.rendererConfigurations[i3];
                    ExoTrackSelection exoTrackSelection = trackSelectorResult2.selections[i3];
                    if (exoTrackSelection != null) {
                        i = exoTrackSelection.length();
                    } else {
                        i = 0;
                    }
                    Format[] formatArr = new Format[i];
                    for (int i4 = 0; i4 < i; i4++) {
                        formatArr[i4] = exoTrackSelection.getFormat(i4);
                    }
                    if (m2596Y() && this.f10629x.f22336e == 3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z4 && z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f10598J++;
                    set.add(renderer);
                    rendererArr2 = rendererArr;
                    renderer.enable(rendererConfiguration, formatArr, ul1Var2.f27323c[i3], this.f10600L, z3, z, ul1Var2.m7742e(), ul1Var2.f27335o);
                    renderer.handleMessage(11, new C0668e(this));
                    x00 x00Var = this.f10620o;
                    x00Var.getClass();
                    MediaClock mediaClock2 = renderer.getMediaClock();
                    if (mediaClock2 != null && mediaClock2 != (mediaClock = x00Var.f28413d)) {
                        if (mediaClock == null) {
                            x00Var.f28413d = mediaClock2;
                            x00Var.f28412c = renderer;
                            mediaClock2.setPlaybackParameters(x00Var.f28410a.getPlaybackParameters());
                        } else {
                            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z2) {
                        renderer.start();
                    }
                    i3++;
                    rendererArr = rendererArr2;
                }
            }
            rendererArr2 = rendererArr;
            i3++;
            rendererArr = rendererArr2;
        }
        ul1Var.f27327g = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x012c, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Type inference failed for: r1v28, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: e0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2606e0() {
        long j;
        boolean z;
        qb0 qb0Var;
        qb0 qb0Var2;
        qb0 qb0Var3;
        long max;
        ul1 ul1Var = this.f10624s.f10641h;
        if (ul1Var == null) {
            return;
        }
        if (ul1Var.f27324d) {
            j = ul1Var.f27321a.readDiscontinuity();
        } else {
            j = -9223372036854775807L;
        }
        if (j != C0643C.TIME_UNSET) {
            m2578C(j);
            if (j != this.f10629x.f22349r) {
                l52 l52Var = this.f10629x;
                this.f10629x = m2618o(l52Var.f22333b, j, l52Var.f22334c, j, true, 5);
            }
        } else {
            x00 x00Var = this.f10620o;
            if (ul1Var != this.f10624s.f10642i) {
                z = true;
            } else {
                z = false;
            }
            Renderer renderer = x00Var.f28412c;
            StandaloneMediaClock standaloneMediaClock = x00Var.f28410a;
            if (renderer != null && !renderer.isEnded() && (x00Var.f28412c.isReady() || (!z && !x00Var.f28412c.hasReadStreamToEnd()))) {
                MediaClock mediaClock = (MediaClock) Assertions.checkNotNull(x00Var.f28413d);
                long positionUs = mediaClock.getPositionUs();
                if (x00Var.f28414e) {
                    if (positionUs < standaloneMediaClock.getPositionUs()) {
                        standaloneMediaClock.stop();
                    } else {
                        x00Var.f28414e = false;
                        if (x00Var.f28415f) {
                            standaloneMediaClock.start();
                        }
                    }
                }
                standaloneMediaClock.resetPosition(positionUs);
                PlaybackParameters playbackParameters = mediaClock.getPlaybackParameters();
                if (!playbackParameters.equals(standaloneMediaClock.getPlaybackParameters())) {
                    standaloneMediaClock.setPlaybackParameters(playbackParameters);
                    x00Var.f28411b.onPlaybackParametersChanged(playbackParameters);
                }
            } else {
                x00Var.f28414e = true;
                if (x00Var.f28415f) {
                    standaloneMediaClock.start();
                }
            }
            long positionUs2 = x00Var.getPositionUs();
            this.f10600L = positionUs2;
            long j2 = positionUs2 - ul1Var.f27335o;
            long j3 = this.f10629x.f22349r;
            ArrayList arrayList = this.f10621p;
            if (!arrayList.isEmpty() && !this.f10629x.f22333b.isAd()) {
                if (this.f10602N) {
                    j3--;
                    this.f10602N = false;
                }
                l52 l52Var2 = this.f10629x;
                int indexOfPeriod = l52Var2.f22332a.getIndexOfPeriod(l52Var2.f22333b.periodUid);
                int min = Math.min(this.f10601M, arrayList.size());
                if (min > 0) {
                    qb0Var = (qb0) arrayList.get(min - 1);
                } else {
                    qb0Var = null;
                }
                while (qb0Var != null) {
                    int i = qb0Var.f25503b;
                    if (i <= indexOfPeriod && (i != indexOfPeriod || qb0Var.f25504c <= j3)) {
                        break;
                    }
                    int i2 = min - 1;
                    if (i2 > 0) {
                        qb0Var3 = (qb0) arrayList.get(min - 2);
                    } else {
                        qb0Var3 = null;
                    }
                    qb0Var = qb0Var3;
                    min = i2;
                }
                if (min < arrayList.size()) {
                    qb0Var2 = (qb0) arrayList.get(min);
                    while (qb0Var2 != null && qb0Var2.f25505d != null) {
                        int i3 = qb0Var2.f25503b;
                        if (i3 >= indexOfPeriod && (i3 != indexOfPeriod || qb0Var2.f25504c > j3)) {
                            break;
                        }
                        min++;
                        if (min < arrayList.size()) {
                            qb0Var2 = (qb0) arrayList.get(min);
                        }
                    }
                    while (qb0Var2 != null) {
                        PlayerMessage playerMessage = qb0Var2.f25502a;
                        if (qb0Var2.f25505d == null || qb0Var2.f25503b != indexOfPeriod) {
                            break;
                        }
                        long j4 = qb0Var2.f25504c;
                        if (j4 <= j3 || j4 > j2) {
                            break;
                        }
                        try {
                            m2584M(playerMessage);
                            if (!playerMessage.getDeleteAfterDelivery() && !playerMessage.isCanceled()) {
                                min++;
                            } else {
                                arrayList.remove(min);
                            }
                            if (min < arrayList.size()) {
                                qb0Var2 = (qb0) arrayList.get(min);
                            } else {
                                qb0Var2 = null;
                            }
                        } finally {
                        }
                    }
                    this.f10601M = min;
                }
                qb0Var2 = null;
            }
            this.f10629x.f22349r = j2;
        }
        this.f10629x.f22347p = this.f10624s.f10643j.m7741d();
        l52 l52Var3 = this.f10629x;
        long j5 = l52Var3.f22347p;
        ul1 ul1Var2 = this.f10624s.f10643j;
        long j6 = 0;
        if (ul1Var2 == null) {
            max = 0;
        } else {
            max = Math.max(0L, j5 - (this.f10600L - ul1Var2.f27335o));
        }
        l52Var3.f22348q = max;
        l52 l52Var4 = this.f10629x;
        if (l52Var4.f22343l && l52Var4.f22336e == 3 && m2597Z(l52Var4.f22332a, l52Var4.f22333b)) {
            l52 l52Var5 = this.f10629x;
            if (l52Var5.f22345n.speed == 1.0f) {
                LivePlaybackSpeedControl livePlaybackSpeedControl = this.f10626u;
                long m2607f = m2607f(l52Var5.f22332a, l52Var5.f22333b.periodUid, l52Var5.f22349r);
                long j7 = this.f10629x.f22347p;
                ul1 ul1Var3 = this.f10624s.f10643j;
                if (ul1Var3 != null) {
                    j6 = Math.max(0L, j7 - (this.f10600L - ul1Var3.f27335o));
                }
                float adjustedPlaybackSpeed = livePlaybackSpeedControl.getAdjustedPlaybackSpeed(m2607f, j6);
                if (this.f10620o.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                    this.f10620o.setPlaybackParameters(this.f10629x.f22345n.withSpeed(adjustedPlaybackSpeed));
                    m2617n(this.f10629x.f22345n, this.f10620o.getPlaybackParameters().speed, false, false);
                }
            }
        }
    }

    /* renamed from: f */
    public final long m2607f(Timeline timeline, Object obj, long j) {
        Timeline.Period period = this.f10617l;
        int i = timeline.getPeriodByUid(obj, period).windowIndex;
        Timeline.Window window = this.f10616k;
        timeline.getWindow(i, window);
        if (window.windowStartTimeMs == C0643C.TIME_UNSET || !window.isLive() || !window.isDynamic) {
            return C0643C.TIME_UNSET;
        }
        return Util.msToUs(window.getCurrentUnixTimeMs() - window.windowStartTimeMs) - (period.getPositionInWindowUs() + j);
    }

    /* renamed from: f0 */
    public final void m2608f0(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j) {
        Object obj;
        PlaybackParameters playbackParameters;
        if (!m2597Z(timeline, mediaPeriodId)) {
            if (mediaPeriodId.isAd()) {
                playbackParameters = PlaybackParameters.DEFAULT;
            } else {
                playbackParameters = this.f10629x.f22345n;
            }
            x00 x00Var = this.f10620o;
            if (!x00Var.getPlaybackParameters().equals(playbackParameters)) {
                x00Var.setPlaybackParameters(playbackParameters);
                return;
            }
            return;
        }
        Object obj2 = mediaPeriodId.periodUid;
        Timeline.Period period = this.f10617l;
        int i = timeline.getPeriodByUid(obj2, period).windowIndex;
        Timeline.Window window = this.f10616k;
        timeline.getWindow(i, window);
        MediaItem.LiveConfiguration liveConfiguration = (MediaItem.LiveConfiguration) Util.castNonNull(window.liveConfiguration);
        LivePlaybackSpeedControl livePlaybackSpeedControl = this.f10626u;
        livePlaybackSpeedControl.setLiveConfiguration(liveConfiguration);
        if (j != C0643C.TIME_UNSET) {
            livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(m2607f(timeline, mediaPeriodId.periodUid, j));
            return;
        }
        Object obj3 = window.uid;
        if (!timeline2.isEmpty()) {
            obj = timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, period).windowIndex, window).uid;
        } else {
            obj = null;
        }
        if (!Util.areEqual(obj, obj3)) {
            livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(C0643C.TIME_UNSET);
        }
    }

    /* renamed from: g */
    public final long m2609g() {
        ul1 ul1Var = this.f10624s.f10642i;
        if (ul1Var == null) {
            return 0L;
        }
        long j = ul1Var.f27335o;
        if (!ul1Var.f27324d) {
            return j;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.f10606a;
            if (i < rendererArr.length) {
                if (m2575q(rendererArr[i]) && rendererArr[i].getStream() == ul1Var.f27323c[i]) {
                    long readingPositionUs = rendererArr[i].getReadingPositionUs();
                    if (readingPositionUs == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j = Math.max(readingPositionUs, j);
                }
                i++;
            } else {
                return j;
            }
        }
    }

    /* renamed from: g0 */
    public final synchronized void m2610g0(Supplier supplier, long j) {
        long elapsedRealtime = this.f10622q.elapsedRealtime() + j;
        boolean z = false;
        while (!((Boolean) supplier.get()).booleanValue() && j > 0) {
            try {
                this.f10622q.onThreadBlocked();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - this.f10622q.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: h */
    public final Pair m2611h(Timeline timeline) {
        long j = 0;
        if (timeline.isEmpty()) {
            return Pair.create(l52.f22331s, 0L);
        }
        int firstWindowIndex = timeline.getFirstWindowIndex(this.f10594F);
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.f10616k, this.f10617l, firstWindowIndex, C0643C.TIME_UNSET);
        MediaSource.MediaPeriodId m2641m = this.f10624s.m2641m(timeline, periodPositionUs.first, 0L);
        long longValue = ((Long) periodPositionUs.second).longValue();
        if (m2641m.isAd()) {
            Object obj = m2641m.periodUid;
            Timeline.Period period = this.f10617l;
            timeline.getPeriodByUid(obj, period);
            if (m2641m.adIndexInAdGroup == period.getFirstAdIndexToPlay(m2641m.adGroupIndex)) {
                j = period.getAdResumePositionUs();
            }
            longValue = j;
        }
        return Pair.create(m2641m, Long.valueOf(longValue));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i;
        ul1 ul1Var;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2 = 1000;
        try {
            switch (message.what) {
                case 0:
                    m2625w();
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m2590S(message.arg2, 1, z, true);
                    break;
                case 2:
                    m2603d();
                    break;
                case 3:
                    m2581J((sb0) message.obj);
                    break;
                case 4:
                    m2591T((PlaybackParameters) message.obj);
                    break;
                case 5:
                    this.f10628w = (SeekParameters) message.obj;
                    break;
                case 6:
                    m2600b0(false, true);
                    break;
                case 7:
                    m2626x();
                    return true;
                case 8:
                    m2616m((MediaPeriod) message.obj);
                    break;
                case 9:
                    m2612i((MediaPeriod) message.obj);
                    break;
                case 10:
                    m2628z();
                    break;
                case 11:
                    m2592U(message.arg1);
                    break;
                case 12:
                    if (message.arg1 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    m2593V(z2);
                    break;
                case 13:
                    if (message.arg1 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    m2586O(z3, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    m2583L((PlayerMessage) message.obj);
                    break;
                case 15:
                    m2585N((PlayerMessage) message.obj);
                    break;
                case 16:
                    PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                    m2617n(playbackParameters, playbackParameters.speed, true, false);
                    break;
                case 17:
                    m2587P((ob0) message.obj);
                    break;
                case 18:
                    m2598a((ob0) message.obj, message.arg1);
                    break;
                case 19:
                    m2624v((pb0) message.obj);
                    break;
                case 20:
                    m2627y(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    m2594W((ShuffleOrder) message.obj);
                    break;
                case 22:
                    m2623u();
                    break;
                case 23:
                    if (message.arg1 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    m2589R(z4);
                    break;
                case 24:
                    if (message.arg1 == 1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    m2588Q(z5);
                    break;
                case 25:
                    m2580I(true);
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e) {
            e = e;
            if (e.type == 1 && (ul1Var = this.f10624s.f10642i) != null) {
                e = e.m2415a(ul1Var.f27326f.f27854a);
            }
            if (e.f9320a && this.f10603O == null) {
                Log.m3028w("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.f10603O = e;
                HandlerWrapper handlerWrapper = this.f10613h;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.f10603O;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.f10603O;
                }
                Log.m3024e("ExoPlayerImplInternal", "Playback error", e);
                m2600b0(true, false);
                this.f10629x = this.f10629x.m5859d(e);
            }
        } catch (ParserException e2) {
            int i3 = e2.dataType;
            if (i3 == 1) {
                if (e2.contentIsMalformed) {
                    i = PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED;
                } else {
                    i = PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED;
                }
            } else {
                if (i3 == 4) {
                    if (e2.contentIsMalformed) {
                        i = PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED;
                    } else {
                        i = PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED;
                    }
                }
                m2613j(e2, i2);
            }
            i2 = i;
            m2613j(e2, i2);
        } catch (DrmSession.DrmSessionException e3) {
            m2613j(e3, e3.errorCode);
        } catch (BehindLiveWindowException e4) {
            m2613j(e4, 1002);
        } catch (DataSourceException e5) {
            m2613j(e5, e5.reason);
        } catch (IOException e6) {
            m2613j(e6, 2000);
        } catch (RuntimeException e7) {
            if ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) {
                i2 = 1004;
            }
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e7, i2);
            Log.m3024e("ExoPlayerImplInternal", "Playback error", createForUnexpected);
            m2600b0(true, false);
            this.f10629x = this.f10629x.m5859d(createForUnexpected);
        }
        m2622t();
        return true;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: i */
    public final void m2612i(MediaPeriod mediaPeriod) {
        boolean z;
        ul1 ul1Var = this.f10624s.f10643j;
        if (ul1Var != null && ul1Var.f27321a == mediaPeriod) {
            long j = this.f10600L;
            if (ul1Var != null) {
                if (ul1Var.f27332l == null) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkState(z);
                if (ul1Var.f27324d) {
                    ul1Var.f27321a.reevaluateBuffer(j - ul1Var.f27335o);
                }
            }
            m2621s();
        }
    }

    /* renamed from: j */
    public final void m2613j(IOException iOException, int i) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i);
        ul1 ul1Var = this.f10624s.f10641h;
        if (ul1Var != null) {
            createForSource = createForSource.m2415a(ul1Var.f27326f.f27854a);
        }
        Log.m3024e("ExoPlayerImplInternal", "Playback error", createForSource);
        m2600b0(false, false);
        this.f10629x = this.f10629x.m5859d(createForSource);
    }

    /* renamed from: k */
    public final void m2614k(boolean z) {
        MediaSource.MediaPeriodId mediaPeriodId;
        long m7741d;
        ul1 ul1Var = this.f10624s.f10643j;
        if (ul1Var == null) {
            mediaPeriodId = this.f10629x.f22333b;
        } else {
            mediaPeriodId = ul1Var.f27326f.f27854a;
        }
        boolean equals = this.f10629x.f22342k.equals(mediaPeriodId);
        if (!equals) {
            this.f10629x = this.f10629x.m5856a(mediaPeriodId);
        }
        l52 l52Var = this.f10629x;
        if (ul1Var == null) {
            m7741d = l52Var.f22349r;
        } else {
            m7741d = ul1Var.m7741d();
        }
        l52Var.f22347p = m7741d;
        l52 l52Var2 = this.f10629x;
        long j = l52Var2.f22347p;
        ul1 ul1Var2 = this.f10624s.f10643j;
        long j2 = 0;
        if (ul1Var2 != null) {
            j2 = Math.max(0L, j - (this.f10600L - ul1Var2.f27335o));
        }
        l52Var2.f22348q = j2;
        if ((!equals || z) && ul1Var != null && ul1Var.f27324d) {
            TrackGroupArray trackGroupArray = ul1Var.f27333m;
            TrackSelectorResult trackSelectorResult = ul1Var.f27334n;
            this.f10611f.onTracksSelected(this.f10606a, trackGroupArray, trackSelectorResult.selections);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v48 ??, still in use, count: 1, list:
          (r0v48 ?? I:??[OBJECT, ARRAY]) from 0x0033: MOVE (r7v26 ?? I:??[OBJECT, ARRAY]) = (r0v48 ?? I:??[OBJECT, ARRAY]) (LINE:52)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    /* renamed from: l */
    public final void m2615l(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v48 ??, still in use, count: 1, list:
          (r0v48 ?? I:??[OBJECT, ARRAY]) from 0x0033: MOVE (r7v26 ?? I:??[OBJECT, ARRAY]) = (r0v48 ?? I:??[OBJECT, ARRAY]) (LINE:52)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r39v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: m */
    public final void m2616m(MediaPeriod mediaPeriod) {
        long j;
        C0674h c0674h = this.f10624s;
        ul1 ul1Var = c0674h.f10643j;
        if (ul1Var != null && ul1Var.f27321a == mediaPeriod) {
            float f = this.f10620o.getPlaybackParameters().speed;
            Timeline timeline = this.f10629x.f22332a;
            ul1Var.f27324d = true;
            ul1Var.f27333m = ul1Var.f27321a.getTrackGroups();
            TrackSelectorResult m7744g = ul1Var.m7744g(f, timeline);
            vl1 vl1Var = ul1Var.f27326f;
            long j2 = vl1Var.f27858e;
            long j3 = vl1Var.f27855b;
            if (j2 != C0643C.TIME_UNSET && j3 >= j2) {
                j = Math.max(0L, j2 - 1);
            } else {
                j = j3;
            }
            long m7738a = ul1Var.m7738a(m7744g, j, false, new boolean[ul1Var.f27329i.length]);
            long j4 = ul1Var.f27335o;
            vl1 vl1Var2 = ul1Var.f27326f;
            ul1Var.f27335o = (vl1Var2.f27855b - m7738a) + j4;
            ul1Var.f27326f = vl1Var2.m7924b(m7738a);
            TrackGroupArray trackGroupArray = ul1Var.f27333m;
            ExoTrackSelection[] exoTrackSelectionArr = ul1Var.f27334n.selections;
            LoadControl loadControl = this.f10611f;
            Renderer[] rendererArr = this.f10606a;
            loadControl.onTracksSelected(rendererArr, trackGroupArray, exoTrackSelectionArr);
            if (ul1Var == c0674h.f10641h) {
                m2578C(ul1Var.f27326f.f27855b);
                m2605e(new boolean[rendererArr.length]);
                l52 l52Var = this.f10629x;
                MediaSource.MediaPeriodId mediaPeriodId = l52Var.f22333b;
                long j5 = ul1Var.f27326f.f27855b;
                this.f10629x = m2618o(mediaPeriodId, j5, l52Var.f22334c, j5, false, 5);
            }
            m2621s();
        }
    }

    /* renamed from: n */
    public final void m2617n(PlaybackParameters playbackParameters, float f, boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                this.f10630y.incrementPendingOperationAcks(1);
            }
            this.f10629x = this.f10629x.m5860e(playbackParameters);
        }
        float f2 = playbackParameters.speed;
        ul1 ul1Var = this.f10624s.f10641h;
        while (true) {
            i = 0;
            if (ul1Var == null) {
                break;
            }
            ExoTrackSelection[] exoTrackSelectionArr = ul1Var.f27334n.selections;
            int length = exoTrackSelectionArr.length;
            while (i < length) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f2);
                }
                i++;
            }
            ul1Var = ul1Var.f27332l;
        }
        Renderer[] rendererArr = this.f10606a;
        int length2 = rendererArr.length;
        while (i < length2) {
            Renderer renderer = rendererArr[i];
            if (renderer != null) {
                renderer.setPlaybackSpeed(f, playbackParameters.speed);
            }
            i++;
        }
    }

    /* renamed from: o */
    public final l52 m2618o(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, boolean z, int i) {
        boolean z2;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        long max;
        TrackGroupArray trackGroupArray2;
        TrackSelectorResult trackSelectorResult2;
        ImmutableList m3902of;
        if (!this.f10602N && j == this.f10629x.f22349r && mediaPeriodId.equals(this.f10629x.f22333b)) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f10602N = z2;
        m2577B();
        l52 l52Var = this.f10629x;
        TrackGroupArray trackGroupArray3 = l52Var.f22339h;
        TrackSelectorResult trackSelectorResult3 = l52Var.f22340i;
        List list2 = l52Var.f22341j;
        if (this.f10625t.f27373k) {
            ul1 ul1Var = this.f10624s.f10641h;
            if (ul1Var == null) {
                trackGroupArray2 = TrackGroupArray.EMPTY;
            } else {
                trackGroupArray2 = ul1Var.f27333m;
            }
            if (ul1Var == null) {
                trackSelectorResult2 = this.f10610e;
            } else {
                trackSelectorResult2 = ul1Var.f27334n;
            }
            ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult2.selections;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            boolean z3 = false;
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Metadata metadata = exoTrackSelection.getFormat(0).metadata;
                    if (metadata == null) {
                        builder.add((ImmutableList.Builder) new Metadata(new Metadata.Entry[0]));
                    } else {
                        builder.add((ImmutableList.Builder) metadata);
                        z3 = true;
                    }
                }
            }
            if (z3) {
                m3902of = builder.build();
            } else {
                m3902of = ImmutableList.m3902of();
            }
            if (ul1Var != null) {
                vl1 vl1Var = ul1Var.f27326f;
                if (vl1Var.f27856c != j2) {
                    ul1Var.f27326f = vl1Var.m7923a(j2);
                }
            }
            list = m3902of;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        } else if (!mediaPeriodId.equals(l52Var.f22333b)) {
            trackGroupArray = TrackGroupArray.EMPTY;
            trackSelectorResult = this.f10610e;
            list = ImmutableList.m3902of();
        } else {
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult3;
            list = list2;
        }
        if (z) {
            this.f10630y.setPositionDiscontinuity(i);
        }
        l52 l52Var2 = this.f10629x;
        long j4 = l52Var2.f22347p;
        ul1 ul1Var2 = this.f10624s.f10643j;
        if (ul1Var2 == null) {
            max = 0;
        } else {
            max = Math.max(0L, j4 - (this.f10600L - ul1Var2.f27335o));
        }
        return l52Var2.m5857b(mediaPeriodId, j, j2, j3, max, trackGroupArray, trackSelectorResult, list);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.f10613h.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock$PlaybackParametersListener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.f10613h.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.MediaSourceList$MediaSourceListInfoRefreshListener
    public final void onPlaylistUpdateRequested() {
        this.f10613h.sendEmptyMessage(22);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.f10613h.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public final void onTrackSelectionsInvalidated() {
        this.f10613h.sendEmptyMessage(10);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: p */
    public final boolean m2619p() {
        long nextLoadPositionUs;
        ul1 ul1Var = this.f10624s.f10643j;
        if (ul1Var == null) {
            return false;
        }
        if (!ul1Var.f27324d) {
            nextLoadPositionUs = 0;
        } else {
            nextLoadPositionUs = ul1Var.f27321a.getNextLoadPositionUs();
        }
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    /* renamed from: r */
    public final boolean m2620r() {
        ul1 ul1Var = this.f10624s.f10641h;
        long j = ul1Var.f27326f.f27858e;
        if (ul1Var.f27324d && (j == C0643C.TIME_UNSET || this.f10629x.f22349r < j || !m2596Y())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.exoplayer2.source.MediaPeriod, java.lang.Object] */
    /* renamed from: s */
    public final void m2621s() {
        long nextLoadPositionUs;
        long j;
        long j2;
        boolean shouldContinueLoading;
        boolean m2619p = m2619p();
        boolean z = false;
        C0674h c0674h = this.f10624s;
        if (!m2619p) {
            shouldContinueLoading = false;
        } else {
            ul1 ul1Var = c0674h.f10643j;
            long j3 = 0;
            if (!ul1Var.f27324d) {
                nextLoadPositionUs = 0;
            } else {
                nextLoadPositionUs = ul1Var.f27321a.getNextLoadPositionUs();
            }
            ul1 ul1Var2 = c0674h.f10643j;
            if (ul1Var2 != null) {
                j3 = Math.max(0L, nextLoadPositionUs - (this.f10600L - ul1Var2.f27335o));
            }
            long j4 = j3;
            if (ul1Var == c0674h.f10641h) {
                j = this.f10600L;
                j2 = ul1Var.f27335o;
            } else {
                j = this.f10600L - ul1Var.f27335o;
                j2 = ul1Var.f27326f.f27855b;
            }
            shouldContinueLoading = this.f10611f.shouldContinueLoading(j - j2, j4, this.f10620o.getPlaybackParameters().speed);
        }
        this.f10592D = shouldContinueLoading;
        if (shouldContinueLoading) {
            ul1 ul1Var3 = c0674h.f10643j;
            long j5 = this.f10600L;
            if (ul1Var3.f27332l == null) {
                z = true;
            }
            Assertions.checkState(z);
            ul1Var3.f27321a.continueLoading(j5 - ul1Var3.f27335o);
        }
        m2604d0();
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public final synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.f10631z && this.f10614i.isAlive()) {
            this.f10613h.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        Log.m3027w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    /* renamed from: t */
    public final void m2622t() {
        this.f10630y.setPlaybackInfo(this.f10629x);
        ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate = this.f10630y;
        if (exoPlayerImplInternal$PlaybackInfoUpdate.f9349a) {
            this.f10623r.onPlaybackInfoUpdate(exoPlayerImplInternal$PlaybackInfoUpdate);
            this.f10630y = new ExoPlayerImplInternal$PlaybackInfoUpdate(this.f10629x);
        }
    }

    /* renamed from: u */
    public final void m2623u() {
        m2615l(this.f10625t.m7750b(), true);
    }

    /* renamed from: v */
    public final void m2624v(pb0 pb0Var) {
        boolean z;
        Timeline m7750b;
        this.f10630y.incrementPendingOperationAcks(1);
        int i = pb0Var.f25100a;
        um1 um1Var = this.f10625t;
        um1Var.getClass();
        ArrayList arrayList = um1Var.f27364b;
        int i2 = pb0Var.f25101b;
        int i3 = pb0Var.f25102c;
        if (i >= 0 && i <= i2 && i2 <= arrayList.size() && i3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        um1Var.f27372j = pb0Var.f25103d;
        if (i != i2 && i != i3) {
            int min = Math.min(i, i3);
            int max = Math.max(((i2 - i) + i3) - 1, i2 - 1);
            int i4 = ((tm1) arrayList.get(min)).f26879d;
            Util.moveItems(arrayList, i, i2, i3);
            while (min <= max) {
                tm1 tm1Var = (tm1) arrayList.get(min);
                tm1Var.f26879d = i4;
                i4 += tm1Var.f26876a.getTimeline().getWindowCount();
                min++;
            }
            m7750b = um1Var.m7750b();
        } else {
            m7750b = um1Var.m7750b();
        }
        m2615l(m7750b, false);
    }

    /* renamed from: w */
    public final void m2625w() {
        int i;
        this.f10630y.incrementPendingOperationAcks(1);
        int i2 = 0;
        m2576A(false, false, false, true);
        this.f10611f.onPrepared();
        if (this.f10629x.f22332a.isEmpty()) {
            i = 4;
        } else {
            i = 2;
        }
        m2595X(i);
        TransferListener transferListener = this.f10612g.getTransferListener();
        um1 um1Var = this.f10625t;
        Assertions.checkState(!um1Var.f27373k);
        um1Var.f27374l = transferListener;
        while (true) {
            ArrayList arrayList = um1Var.f27364b;
            if (i2 < arrayList.size()) {
                tm1 tm1Var = (tm1) arrayList.get(i2);
                um1Var.m7753e(tm1Var);
                um1Var.f27371i.add(tm1Var);
                i2++;
            } else {
                um1Var.f27373k = true;
                this.f10613h.sendEmptyMessage(2);
                return;
            }
        }
    }

    /* renamed from: x */
    public final void m2626x() {
        m2576A(true, false, true, false);
        this.f10611f.onReleased();
        m2595X(1);
        this.f10614i.quit();
        synchronized (this) {
            this.f10631z = true;
            notifyAll();
        }
    }

    /* renamed from: y */
    public final void m2627y(int i, int i2, ShuffleOrder shuffleOrder) {
        boolean z = true;
        this.f10630y.incrementPendingOperationAcks(1);
        um1 um1Var = this.f10625t;
        um1Var.getClass();
        if (i < 0 || i > i2 || i2 > um1Var.f27364b.size()) {
            z = false;
        }
        Assertions.checkArgument(z);
        um1Var.f27372j = shuffleOrder;
        um1Var.m7755g(i, i2);
        m2615l(um1Var.m7750b(), false);
    }

    /* renamed from: z */
    public final void m2628z() {
        boolean z;
        float f = this.f10620o.getPlaybackParameters().speed;
        C0674h c0674h = this.f10624s;
        ul1 ul1Var = c0674h.f10641h;
        ul1 ul1Var2 = c0674h.f10642i;
        boolean z2 = true;
        for (ul1 ul1Var3 = ul1Var; ul1Var3 != null && ul1Var3.f27324d; ul1Var3 = ul1Var3.f27332l) {
            TrackSelectorResult m7744g = ul1Var3.m7744g(f, this.f10629x.f22332a);
            if (!m7744g.isEquivalent(ul1Var3.f27334n)) {
                if (z2) {
                    C0674h c0674h2 = this.f10624s;
                    ul1 ul1Var4 = c0674h2.f10641h;
                    boolean m2640k = c0674h2.m2640k(ul1Var4);
                    boolean[] zArr = new boolean[this.f10606a.length];
                    long m7738a = ul1Var4.m7738a(m7744g, this.f10629x.f22349r, m2640k, zArr);
                    l52 l52Var = this.f10629x;
                    if (l52Var.f22336e != 4 && m7738a != l52Var.f22349r) {
                        z = true;
                    } else {
                        z = false;
                    }
                    l52 l52Var2 = this.f10629x;
                    this.f10629x = m2618o(l52Var2.f22333b, m7738a, l52Var2.f22334c, l52Var2.f22335d, z, 5);
                    if (z) {
                        m2578C(m7738a);
                    }
                    boolean[] zArr2 = new boolean[this.f10606a.length];
                    int i = 0;
                    while (true) {
                        Renderer[] rendererArr = this.f10606a;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        boolean m2575q = m2575q(renderer);
                        zArr2[i] = m2575q;
                        SampleStream sampleStream = ul1Var4.f27323c[i];
                        if (m2575q) {
                            if (sampleStream != renderer.getStream()) {
                                m2601c(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.f10600L);
                            }
                        }
                        i++;
                    }
                    m2605e(zArr2);
                } else {
                    this.f10624s.m2640k(ul1Var3);
                    if (ul1Var3.f27324d) {
                        ul1Var3.m7738a(m7744g, Math.max(ul1Var3.f27326f.f27855b, this.f10600L - ul1Var3.f27335o), false, new boolean[ul1Var3.f27329i.length]);
                    }
                }
                m2614k(true);
                if (this.f10629x.f22336e != 4) {
                    m2621s();
                    m2606e0();
                    this.f10613h.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (ul1Var3 == ul1Var2) {
                z2 = false;
            }
        }
    }
}
