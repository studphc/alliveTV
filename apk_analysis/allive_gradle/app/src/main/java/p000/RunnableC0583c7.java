package p000;

import android.graphics.Typeface;
import android.location.Location;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.C0253h;
import androidx.fragment.app.C0254i;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.DispatchQueue;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.C0658d;
import com.google.android.exoplayer2.C0672f;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.C0662d;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.offline.C0682c;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.source.C0707m;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.C0687a;
import com.google.android.exoplayer2.source.ads.C0688b;
import com.google.android.exoplayer2.source.hls.playlist.C0702b;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AbstractC1022u;
import com.google.common.util.concurrent.Callables;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: c7 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0583c7 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f8278a;

    /* renamed from: b */
    public final /* synthetic */ Object f8279b;

    /* renamed from: c */
    public final /* synthetic */ Object f8280c;

    public /* synthetic */ RunnableC0583c7(int i, Object obj, Object obj2) {
        this.f8278a = i;
        this.f8279b = obj;
        this.f8280c = obj2;
    }

    /* renamed from: a */
    private final void m2205a() {
        v71 v71Var = (v71) this.f8279b;
        Provider provider = (Provider) this.f8280c;
        synchronized (v71Var) {
            try {
                if (v71Var.f27664b == null) {
                    v71Var.f27663a.add(provider);
                } else {
                    v71Var.f27664b.add(provider.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Deferred.DeferredHandler deferredHandler;
        long j;
        boolean z;
        boolean z2;
        SeekMap unseekable;
        long j2 = C0643C.TIME_UNSET;
        boolean z3 = true;
        int i = 1;
        r2 = true;
        boolean z4 = true;
        boolean z5 = false;
        switch (this.f8278a) {
            case 0:
                AdsMediaSource adsMediaSource = ((C0687a) this.f8279b).f11122b;
                AdsLoader adsLoader = adsMediaSource.f11101m;
                MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) this.f8280c;
                adsLoader.handlePrepareComplete(adsMediaSource, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
                return;
            case 1:
                C0688b c0688b = (C0688b) this.f8279b;
                AdPlaybackState adPlaybackState = (AdPlaybackState) this.f8280c;
                if (!c0688b.f11124b) {
                    AdsMediaSource adsMediaSource2 = c0688b.f11125c;
                    AdPlaybackState adPlaybackState2 = adsMediaSource2.f11109u;
                    if (adPlaybackState2 == null) {
                        C0008a7[][] c0008a7Arr = new C0008a7[adPlaybackState.adGroupCount];
                        adsMediaSource2.f11110v = c0008a7Arr;
                        Arrays.fill(c0008a7Arr, new C0008a7[0]);
                    } else {
                        if (adPlaybackState.adGroupCount != adPlaybackState2.adGroupCount) {
                            z3 = false;
                        }
                        Assertions.checkState(z3);
                    }
                    adsMediaSource2.f11109u = adPlaybackState;
                    adsMediaSource2.m2756a();
                    adsMediaSource2.m2757b();
                    return;
                }
                return;
            case 2:
                ((AbstractC1022u) this.f8279b).m4358k((ImmutableCollection) this.f8280c);
                return;
            case 3:
                Runnable runnable = (Runnable) this.f8280c;
                ExecutorC1752r8 executorC1752r8 = (ExecutorC1752r8) this.f8279b;
                executorC1752r8.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    executorC1752r8.m7229a();
                }
            case 4:
                ((AudioRendererEventListener) Util.castNonNull(((AudioRendererEventListener.EventDispatcher) this.f8279b).f9655b)).onAudioDecoderReleased((String) this.f8280c);
                return;
            case 5:
                Runnable runnable2 = (Runnable) this.f8280c;
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                boolean m4319b = Callables.m4319b((String) ((Supplier) this.f8279b).get(), currentThread);
                try {
                    runnable2.run();
                    if (m4319b) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (m4319b) {
                        Callables.m4319b(name, currentThread);
                    }
                }
            case 6:
                j12 j12Var = (j12) this.f8279b;
                Provider provider = (Provider) this.f8280c;
                if (j12Var.f20346b == j12.f20344d) {
                    synchronized (j12Var) {
                        deferredHandler = j12Var.f20345a;
                        j12Var.f20345a = null;
                        j12Var.f20346b = provider;
                    }
                    deferredHandler.handle(provider);
                    return;
                }
                throw new IllegalStateException("provide() can be called only once.");
            case 7:
                m2205a();
                return;
            case 8:
                ThreadFactoryC1490kx threadFactoryC1490kx = (ThreadFactoryC1490kx) this.f8279b;
                Process.setThreadPriority(threadFactoryC1490kx.f22237c);
                StrictMode.ThreadPolicy threadPolicy = threadFactoryC1490kx.f22238d;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                ((Runnable) this.f8280c).run();
                return;
            case 9:
                C0662d c0662d = (C0662d) this.f8279b;
                DefaultDrmSessionManager defaultDrmSessionManager = c0662d.f10031d;
                if (defaultDrmSessionManager.f9952o != 0 && !c0662d.f10030c) {
                    c0662d.f10029b = defaultDrmSessionManager.m2512a((Looper) Assertions.checkNotNull(defaultDrmSessionManager.f9956s), c0662d.f10028a, (Format) this.f8280c, false);
                    defaultDrmSessionManager.f9950m.add(c0662d);
                    return;
                }
                return;
            case 10:
                C0702b c0702b = (C0702b) this.f8279b;
                c0702b.f11529i = false;
                c0702b.m2812b((Uri) this.f8280c);
                return;
            case 11:
                int i2 = DefaultSpecialEffectsController.f4390g;
                DefaultSpecialEffectsController this$0 = (DefaultSpecialEffectsController) this.f8279b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) this.f8280c;
                Intrinsics.checkNotNullParameter(operation, "$operation");
                this$0.applyContainerChangesToOperation$fragment_release(operation);
                return;
            case 12:
                C0253h this$02 = (C0253h) this.f8279b;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                ViewGroup container = (ViewGroup) this.f8280c;
                Intrinsics.checkNotNullParameter(container, "$container");
                Iterator it = this$02.f4663c.iterator();
                while (it.hasNext()) {
                    SpecialEffectsController.Operation operation2 = ((C0254i) it.next()).getOperation();
                    View view = operation2.getFragment().getView();
                    if (view != null) {
                        operation2.getFinalState().applyState(view, container);
                    }
                }
                return;
            case 13:
                Callable callable = (Callable) this.f8279b;
                b20 b20Var = (b20) ((b01) this.f8280c).f7833b;
                try {
                    b20Var.set(callable.call());
                    return;
                } catch (Exception e) {
                    b20Var.setException(e);
                    return;
                }
            case 14:
                DispatchQueue this$03 = (DispatchQueue) this.f8279b;
                Intrinsics.checkNotNullParameter(this$03, "this$0");
                Runnable runnable3 = (Runnable) this.f8280c;
                Intrinsics.checkNotNullParameter(runnable3, "$runnable");
                if (this$03.f6480d.offer(runnable3)) {
                    this$03.drainQueue();
                    return;
                }
                throw new IllegalStateException("cannot enqueue any more runnables");
            case 15:
                DefaultTrackSelector.Parameters parameters = DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
                DownloadHelper downloadHelper = (DownloadHelper) this.f8279b;
                downloadHelper.getClass();
                ((DownloadHelper.Callback) this.f8280c).onPrepared(downloadHelper);
                return;
            case 16:
                DownloadHelper downloadHelper2 = (DownloadHelper) this.f8279b;
                ((DownloadHelper.Callback) Assertions.checkNotNull(downloadHelper2.f10789i)).onPrepareError(downloadHelper2, (IOException) this.f8280c);
                return;
            case 17:
                DownloadService.m2711a((DownloadService) this.f8280c, ((C0682c) this.f8279b).f10870b.getCurrentDownloads());
                return;
            case 18:
                ((EventHandler) ((Map.Entry) this.f8279b).getKey()).handle((Event) this.f8280c);
                return;
            case 19:
                C0658d c0658d = (C0658d) this.f8279b;
                ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate = (ExoPlayerImplInternal$PlaybackInfoUpdate) this.f8280c;
                int i3 = c0658d.f9846G - exoPlayerImplInternal$PlaybackInfoUpdate.operationAcks;
                c0658d.f9846G = i3;
                if (exoPlayerImplInternal$PlaybackInfoUpdate.positionDiscontinuity) {
                    c0658d.f9847H = exoPlayerImplInternal$PlaybackInfoUpdate.discontinuityReason;
                    c0658d.f9848I = true;
                }
                if (exoPlayerImplInternal$PlaybackInfoUpdate.hasPlayWhenReadyChangeReason) {
                    c0658d.f9849J = exoPlayerImplInternal$PlaybackInfoUpdate.playWhenReadyChangeReason;
                }
                if (i3 == 0) {
                    Timeline timeline = exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo.f22332a;
                    if (!c0658d.f9909v0.f22332a.isEmpty() && timeline.isEmpty()) {
                        c0658d.f9911w0 = -1;
                        c0658d.f9913x0 = 0L;
                    }
                    if (!timeline.isEmpty()) {
                        List asList = Arrays.asList(((l62) timeline).f22361h);
                        if (asList.size() == c0658d.f9892n.size()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Assertions.checkState(z2);
                        for (int i4 = 0; i4 < asList.size(); i4++) {
                            ((nb0) c0658d.f9892n.get(i4)).f23318b = (Timeline) asList.get(i4);
                        }
                    }
                    if (c0658d.f9848I) {
                        if (exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo.f22333b.equals(c0658d.f9909v0.f22333b) && exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo.f22335d == c0658d.f9909v0.f22349r) {
                            z4 = false;
                        }
                        if (z4) {
                            if (!timeline.isEmpty() && !exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo.f22333b.isAd()) {
                                l52 l52Var = exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo;
                                MediaSource.MediaPeriodId mediaPeriodId2 = l52Var.f22333b;
                                long j3 = l52Var.f22335d;
                                Object obj = mediaPeriodId2.periodUid;
                                Timeline.Period period = c0658d.f9890m;
                                timeline.getPeriodByUid(obj, period);
                                j2 = period.getPositionInWindowUs() + j3;
                            } else {
                                j2 = exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo.f22335d;
                            }
                        }
                        j = j2;
                        z = z4;
                    } else {
                        j = -9223372036854775807L;
                        z = false;
                    }
                    c0658d.f9848I = false;
                    c0658d.m2504w(exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo, 1, c0658d.f9849J, false, z, c0658d.f9847H, j, -1);
                    return;
                }
                return;
            case 20:
                PlayerMessage playerMessage = (PlayerMessage) this.f8280c;
                ((C0672f) this.f8279b).getClass();
                try {
                    C0672f.m2574b(playerMessage);
                    return;
                } catch (ExoPlaybackException e2) {
                    Log.m3024e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
                    throw new RuntimeException(e2);
                }
            case 21:
                FragmentStrictMode fragmentStrictMode = FragmentStrictMode.INSTANCE;
                FragmentStrictMode.Policy policy = (FragmentStrictMode.Policy) this.f8279b;
                Intrinsics.checkNotNullParameter(policy, "$policy");
                Violation violation = (Violation) this.f8280c;
                Intrinsics.checkNotNullParameter(violation, "$violation");
                policy.getListener().onViolation(violation);
                return;
            case 22:
                FragmentStrictMode fragmentStrictMode2 = FragmentStrictMode.INSTANCE;
                Violation violation2 = (Violation) this.f8280c;
                Intrinsics.checkNotNullParameter(violation2, "$violation");
                android.util.Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + ((String) this.f8279b), violation2);
                throw violation2;
            case 23:
                Runnable runnable4 = (Runnable) this.f8280c;
                d81 d81Var = (d81) this.f8279b;
                Semaphore semaphore = d81Var.f16288b;
                try {
                    runnable4.run();
                    return;
                } finally {
                    semaphore.release();
                    d81Var.m4552a();
                }
            case 24:
                md1 md1Var = (md1) this.f8279b;
                List<Location> list = (List) this.f8280c;
                jd1 jd1Var = md1Var.f22897a;
                if (jd1Var != null) {
                    jd1Var.f20469b.onLocationChanged(list);
                    return;
                }
                return;
            case 25:
                md1 md1Var2 = (md1) this.f8279b;
                Location location = (Location) this.f8280c;
                jd1 jd1Var2 = md1Var2.f22897a;
                if (jd1Var2 != null) {
                    jd1Var2.f20469b.onLocationChanged(location);
                    return;
                }
                return;
            case 26:
                ((NetworkTypeObserver.Listener) this.f8280c).onNetworkTypeChanged(((NetworkTypeObserver) this.f8279b).getNetworkType());
                return;
            case 27:
                C0707m c0707m = (C0707m) this.f8279b;
                IcyHeaders icyHeaders = c0707m.f11577r;
                SeekMap seekMap = (SeekMap) this.f8280c;
                if (icyHeaders == null) {
                    unseekable = seekMap;
                } else {
                    unseekable = new SeekMap.Unseekable(C0643C.TIME_UNSET);
                }
                c0707m.f11584y = unseekable;
                c0707m.f11585z = seekMap.getDurationUs();
                if (!c0707m.f11553F && seekMap.getDurationUs() == C0643C.TIME_UNSET) {
                    z5 = true;
                }
                c0707m.f11548A = z5;
                if (z5) {
                    i = 7;
                }
                c0707m.f11549B = i;
                c0707m.f11566g.onSourceInfoRefreshed(c0707m.f11585z, seekMap.isSeekable(), c0707m.f11548A);
                if (!c0707m.f11581v) {
                    c0707m.m2819e();
                    return;
                }
                return;
            case 28:
                ((RemovalListener) this.f8279b).onRemoval((RemovalNotification) this.f8280c);
                return;
            default:
                ((ResourcesCompat.FontCallback) this.f8279b).onFontRetrieved((Typeface) this.f8280c);
                return;
        }
    }
}
