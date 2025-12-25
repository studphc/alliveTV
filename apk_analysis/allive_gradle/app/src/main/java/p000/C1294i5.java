package p000;

import android.app.SharedElementCallback;
import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SurfaceHolderCallbackC0644a;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.ProgressiveDownloader;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.source.BundledExtractorsAdapter;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper$DisplayHelper$Listener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.hisona.allive.BackgroundTask;
import com.hisona.allive.RxJobIntentService;
import com.hisona.allive.TvBaseRowsSupportFragment;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;
import okhttp3.AsyncDns;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;

/* renamed from: i5 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1294i5 implements SharedElementCallback.OnSharedElementsReadyListener, Dns, ObservableOnSubscribe, DecoderOutputBuffer.Owner, RequirementsWatcher.Listener, ListenerSet.Event, BinarySearchSeeker.SeekTimestampConverter, InputConnectionCompat.OnCommitContentListener, CacheWriter.ProgressListener, ProgressiveMediaExtractor.Factory, TrackSelectionUtil.AdaptiveTrackSelectionFactory, OnCompleteListener, Interpolator, ActivityResultCallback, VideoFrameReleaseHelper$DisplayHelper$Listener, EventListener.Factory {

    /* renamed from: a */
    public final /* synthetic */ int f18296a;

    /* renamed from: b */
    public final /* synthetic */ Object f18297b;

    public /* synthetic */ C1294i5(int i, Object obj) {
        this.f18296a = i;
        this.f18297b = obj;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call it) {
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        EventListener this_asFactory = (EventListener) this.f18297b;
        Intrinsics.checkNotNullParameter(this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return this_asFactory;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
    public ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition) {
        RandomTrackSelection.Factory factory = (RandomTrackSelection.Factory) this.f18297b;
        factory.getClass();
        return new RandomTrackSelection(definition.group, definition.tracks, definition.type, factory.f11926a);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor.Factory
    public ProgressiveMediaExtractor createProgressiveMediaExtractor(PlayerId playerId) {
        return new BundledExtractorsAdapter((ExtractorsFactory) this.f18297b);
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        return (float) Easing.getInterpolator((String) this.f18297b).get(f);
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f18296a) {
            case 5:
                listener.onMediaMetadataChanged((MediaMetadata) this.f18297b);
                return;
            case 6:
                listener.onAudioAttributesChanged((AudioAttributes) this.f18297b);
                return;
            case 7:
                listener.onTrackSelectionParametersChanged((TrackSelectionParameters) this.f18297b);
                return;
            case 8:
                listener.onCues((List<Cue>) this.f18297b);
                return;
            case 9:
                listener.onCues((CueGroup) this.f18297b);
                return;
            case 10:
                listener.onMediaMetadataChanged(((SurfaceHolderCallbackC0644a) this.f18297b).f9509a.f9855P);
                return;
            case 11:
                listener.onMetadata((Metadata) this.f18297b);
                return;
            case 12:
                listener.onDeviceInfoChanged((DeviceInfo) this.f18297b);
                return;
            default:
                listener.onVideoSizeChanged((VideoSize) this.f18297b);
                return;
        }
    }

    @Override // okhttp3.Dns
    public List lookup(String hostname) {
        AsyncDns[] asyncDns = (AsyncDns[]) this.f18297b;
        Intrinsics.checkNotNullParameter(asyncDns, "$asyncDns");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final CountDownLatch countDownLatch = new CountDownLatch(asyncDns.length);
        for (AsyncDns asyncDns2 : asyncDns) {
            asyncDns2.query(hostname, new AsyncDns.Callback() { // from class: okhttp3.AsyncDns$Companion$toDns$1$1$1
                @Override // okhttp3.AsyncDns.Callback
                public void onFailure(@NotNull String hostname2, @NotNull IOException e) {
                    Intrinsics.checkNotNullParameter(hostname2, "hostname");
                    Intrinsics.checkNotNullParameter(e, "e");
                    ArrayList arrayList3 = arrayList2;
                    synchronized (arrayList3) {
                        arrayList3.add(e);
                    }
                    countDownLatch.countDown();
                }

                @Override // okhttp3.AsyncDns.Callback
                public void onResponse(@NotNull String hostname2, @NotNull List<? extends InetAddress> addresses) {
                    Intrinsics.checkNotNullParameter(hostname2, "hostname");
                    Intrinsics.checkNotNullParameter(addresses, "addresses");
                    ArrayList arrayList3 = arrayList;
                    synchronized (arrayList3) {
                        arrayList3.addAll(addresses);
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        if (arrayList.isEmpty()) {
            Throwable th = (IOException) CollectionsKt___CollectionsKt.firstOrNull((List) arrayList2);
            if (th == null) {
                th = new UnknownHostException(AbstractC1726qj.m7038C("No results for ", hostname));
            }
            Iterator it = CollectionsKt___CollectionsKt.drop(arrayList2, 1).iterator();
            while (it.hasNext()) {
                ha0.addSuppressed(th, (IOException) it.next());
            }
            throw th;
        }
        return arrayList;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        boolean z = TvBaseRowsSupportFragment.mLongPress;
        ((TvBaseRowsSupportFragment) this.f18297b).onActivityResult((ActivityResult) obj);
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                inputContentInfoCompat.requestPermission();
                Parcelable parcelable = (Parcelable) inputContentInfoCompat.unwrap();
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        if (ViewCompat.performReceiveContent((View) this.f18297b, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.getDescription(), new ClipData.Item(inputContentInfoCompat.getContentUri())), 2).setLinkUri(inputContentInfoCompat.getLinkUri()).setExtras(bundle).build()) != null) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        Exception exception = task.getException();
        CompletableDeferred completableDeferred = (CompletableDeferred) this.f18297b;
        if (exception == null) {
            if (task.isCanceled()) {
                Job.DefaultImpls.cancel$default((Job) completableDeferred, (CancellationException) null, 1, (Object) null);
                return;
            } else {
                completableDeferred.complete(task.getResult());
                return;
            }
        }
        completableDeferred.completeExceptionally(exception);
    }

    @Override // com.google.android.exoplayer2.video.VideoFrameReleaseHelper$DisplayHelper$Listener
    public void onDefaultDisplayChanged(Display display) {
        VideoFrameReleaseHelper videoFrameReleaseHelper = (VideoFrameReleaseHelper) this.f18297b;
        videoFrameReleaseHelper.getClass();
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            videoFrameReleaseHelper.f12882k = refreshRate;
            videoFrameReleaseHelper.f12883l = (refreshRate * 80) / 100;
        } else {
            com.google.android.exoplayer2.util.Log.m3027w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            videoFrameReleaseHelper.f12882k = C0643C.TIME_UNSET;
            videoFrameReleaseHelper.f12883l = C0643C.TIME_UNSET;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
    public void onProgress(long j, long j2, long j3) {
        float f;
        Downloader.ProgressListener progressListener = ((ProgressiveDownloader) this.f18297b).f10837f;
        if (progressListener != null) {
            if (j != -1 && j != 0) {
                f = (((float) j2) * 100.0f) / ((float) j);
            } else {
                f = -1.0f;
            }
            progressListener.onProgress(j, j2, f);
        }
    }

    @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
    public void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i) {
        int i2 = DownloadManager.DEFAULT_MAX_PARALLEL_DOWNLOADS;
        ((DownloadManager) this.f18297b).m2708b(requirementsWatcher, i);
    }

    @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
    public void onSharedElementsReady() {
        AbstractC1110d5.m4522a((SharedElementCallback.OnSharedElementsReadyListener) this.f18297b);
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer.Owner
    public void releaseOutputBuffer(DecoderOutputBuffer decoderOutputBuffer) {
        ((AbstractC1876ul) this.f18297b).releaseOutputBuffer((C1839tl) decoderOutputBuffer);
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public void subscribe(ObservableEmitter observableEmitter) {
        ld2 ld2Var;
        switch (this.f18296a) {
            case 2:
                ((BackgroundTask) this.f18297b).doInBackground(observableEmitter);
                return;
            default:
                C1540m9 c1540m9 = (C1540m9) this.f18297b;
                while (true) {
                    RxJobIntentService rxJobIntentService = (RxJobIntentService) c1540m9.f22855c;
                    m61 m61Var = rxJobIntentService.f15921a;
                    if (m61Var != null) {
                        ld2Var = m61Var.m6085b();
                    } else {
                        synchronized (rxJobIntentService.f15927g) {
                            try {
                                if (rxJobIntentService.f15927g.size() > 0) {
                                    ld2Var = (ld2) rxJobIntentService.f15927g.remove(0);
                                } else {
                                    ld2Var = null;
                                }
                            } finally {
                            }
                        }
                    }
                    if (ld2Var != null) {
                        ((RxJobIntentService) c1540m9.f22855c).onHandleWork(ld2Var.getIntent());
                        ld2Var.complete();
                    } else {
                        return;
                    }
                }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
    public long timeUsToTargetTime(long j) {
        return ((FlacStreamMetadata) this.f18297b).getSampleNumber(j);
    }
}
