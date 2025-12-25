package p000;

import android.graphics.Rect;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.location.C0184d;
import androidx.core.location.C0185e;
import androidx.core.location.GnssStatusCompat;
import androidx.emoji2.text.C0239f;
import androidx.emoji2.text.C0240g;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.fragment.app.C0248c;
import androidx.fragment.app.C0253h;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.fragment.app.SpecialEffectsController;
import com.google.android.exoplayer2.C0674h;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.C0687a;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: b7 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0547b7 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f7908a;

    /* renamed from: b */
    public final /* synthetic */ Object f7909b;

    /* renamed from: c */
    public final /* synthetic */ Object f7910c;

    /* renamed from: d */
    public final /* synthetic */ Object f7911d;

    public /* synthetic */ RunnableC0547b7(C0674h c0674h, ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f7908a = 10;
        this.f7909b = c0674h;
        this.f7911d = builder;
        this.f7910c = mediaPeriodId;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7908a) {
            case 0:
                AdsMediaSource adsMediaSource = ((C0687a) this.f7909b).f11122b;
                AdsLoader adsLoader = adsMediaSource.f11101m;
                MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) this.f7910c;
                adsLoader.handlePrepareError(adsMediaSource, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, (IOException) this.f7911d);
                return;
            case 1:
                AudioRendererEventListener audioRendererEventListener = ((AudioRendererEventListener.EventDispatcher) this.f7909b).f9655b;
                AudioRendererEventListener audioRendererEventListener2 = (AudioRendererEventListener) Util.castNonNull(audioRendererEventListener);
                Format format = (Format) this.f7910c;
                audioRendererEventListener2.onAudioInputFormatChanged(format);
                ((AudioRendererEventListener) Util.castNonNull(audioRendererEventListener)).onAudioInputFormatChanged(format, (DecoderReuseEvaluation) this.f7911d);
                return;
            case 2:
                ViewGroup container = (ViewGroup) this.f7909b;
                Intrinsics.checkNotNullParameter(container, "$container");
                C0248c this$0 = (C0248c) this.f7911d;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                container.endViewTransition((View) this.f7910c);
                this$0.f4650c.getOperation().completeEffect(this$0);
                return;
            case 3:
                C0253h this$02 = (C0253h) this.f7911d;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                FragmentTransition.callSharedElementStartEnd(((SpecialEffectsController.Operation) this.f7909b).getFragment(), ((SpecialEffectsController.Operation) this.f7910c).getFragment(), this$02.f4675o, this$02.f4674n, false);
                return;
            case 4:
                FragmentTransitionImpl impl = (FragmentTransitionImpl) this.f7909b;
                Intrinsics.checkNotNullParameter(impl, "$impl");
                Rect lastInEpicenterRect = (Rect) this.f7911d;
                Intrinsics.checkNotNullParameter(lastInEpicenterRect, "$lastInEpicenterRect");
                impl.getBoundsOnScreen((View) this.f7910c, lastInEpicenterRect);
                return;
            case 5:
                DrmSessionEventListener.EventDispatcher eventDispatcher = (DrmSessionEventListener.EventDispatcher) this.f7909b;
                ((DrmSessionEventListener) this.f7910c).onDrmSessionManagerError(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, (Exception) this.f7911d);
                return;
            case 6:
                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = (EmojiCompat.MetadataRepoLoaderCallback) this.f7910c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f7911d;
                C0240g c0240g = (C0240g) this.f7909b;
                c0240g.getClass();
                try {
                    FontRequestEmojiCompatConfig create = DefaultEmojiCompatConfig.create(c0240g.f4289a);
                    if (create != null) {
                        create.setLoadingExecutor(threadPoolExecutor);
                        create.getMetadataRepoLoader().load(new C0239f(metadataRepoLoaderCallback, threadPoolExecutor));
                        return;
                    }
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                } catch (Throwable th) {
                    metadataRepoLoaderCallback.onFailed(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 7:
                hd1 hd1Var = (hd1) this.f7909b;
                Executor executor = (Executor) this.f7910c;
                GnssMeasurementsEvent gnssMeasurementsEvent = (GnssMeasurementsEvent) this.f7911d;
                if (hd1Var.f18030b == executor) {
                    hd1Var.f18029a.onGnssMeasurementsReceived(gnssMeasurementsEvent);
                    return;
                }
                return;
            case 8:
                C0184d c0184d = (C0184d) this.f7909b;
                Executor executor2 = (Executor) this.f7910c;
                GnssStatusCompat gnssStatusCompat = (GnssStatusCompat) this.f7911d;
                if (c0184d.f3700c == executor2) {
                    c0184d.f3699b.onSatelliteStatusChanged(gnssStatusCompat);
                    return;
                }
                return;
            case 9:
                C0185e c0185e = (C0185e) this.f7909b;
                Executor executor3 = (Executor) this.f7910c;
                GnssStatus gnssStatus = (GnssStatus) this.f7911d;
                if (c0185e.f3702b == executor3) {
                    c0185e.f3701a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
                    return;
                }
                return;
            case 10:
                ((C0674h) this.f7909b).f10636c.updateMediaPeriodQueueInfo(((ImmutableList.Builder) this.f7911d).build(), (MediaSource.MediaPeriodId) this.f7910c);
                return;
            case 11:
                MediaSourceEventListener.EventDispatcher eventDispatcher2 = (MediaSourceEventListener.EventDispatcher) this.f7909b;
                ((MediaSourceEventListener) this.f7910c).onDownstreamFormatChanged(eventDispatcher2.windowIndex, eventDispatcher2.mediaPeriodId, (MediaLoadData) this.f7911d);
                return;
            default:
                VideoRendererEventListener videoRendererEventListener = ((VideoRendererEventListener.EventDispatcher) this.f7909b).f12890b;
                VideoRendererEventListener videoRendererEventListener2 = (VideoRendererEventListener) Util.castNonNull(videoRendererEventListener);
                Format format2 = (Format) this.f7910c;
                videoRendererEventListener2.onVideoInputFormatChanged(format2);
                ((VideoRendererEventListener) Util.castNonNull(videoRendererEventListener)).onVideoInputFormatChanged(format2, (DecoderReuseEvaluation) this.f7911d);
                return;
        }
    }

    public /* synthetic */ RunnableC0547b7(Object obj, Object obj2, Object obj3, int i) {
        this.f7908a = i;
        this.f7909b = obj;
        this.f7910c = obj2;
        this.f7911d = obj3;
    }
}
