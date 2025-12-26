package p000;

import android.net.Uri;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.dash.DashManifestStaleException;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* renamed from: iy */
/* loaded from: classes.dex */
public final class C1334iy implements Loader.Callback {

    /* renamed from: a */
    public final /* synthetic */ DashMediaSource f20306a;

    public C1334iy(DashMediaSource dashMediaSource) {
        this.f20306a = dashMediaSource;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        this.f20306a.m2775b((ParsingLoadable) loadable, j, j2);
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.exoplayer2.upstream.ParsingLoadable$Parser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.google.android.exoplayer2.upstream.ParsingLoadable$Parser, java.lang.Object] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        int periodCount;
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        DashMediaSource dashMediaSource = this.f20306a;
        dashMediaSource.getClass();
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        dashMediaSource.f11233n.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        dashMediaSource.f11236q.loadCompleted(loadEventInfo, parsingLoadable.type);
        DashManifest dashManifest = (DashManifest) parsingLoadable.getResult();
        DashManifest dashManifest2 = dashMediaSource.f11219H;
        if (dashManifest2 == null) {
            periodCount = 0;
        } else {
            periodCount = dashManifest2.getPeriodCount();
        }
        long j3 = dashManifest.getPeriod(0).startMs;
        int i = 0;
        while (i < periodCount && dashMediaSource.f11219H.getPeriod(i).startMs < j3) {
            i++;
        }
        if (dashManifest.dynamic) {
            if (periodCount - i > dashManifest.getPeriodCount()) {
                Log.m3027w(DashMediaSource.DEFAULT_MEDIA_ID, "Loaded out of sync manifest");
            } else {
                long j4 = dashMediaSource.f11225N;
                if (j4 != C0643C.TIME_UNSET && dashManifest.publishTimeMs * 1000 <= j4) {
                    Log.m3027w(DashMediaSource.DEFAULT_MEDIA_ID, "Loaded stale dynamic manifest: " + dashManifest.publishTimeMs + ", " + dashMediaSource.f11225N);
                } else {
                    dashMediaSource.f11224M = 0;
                }
            }
            int i2 = dashMediaSource.f11224M;
            dashMediaSource.f11224M = i2 + 1;
            if (i2 < dashMediaSource.f11233n.getMinimumLoadableRetryCount(parsingLoadable.type)) {
                dashMediaSource.f11215D.postDelayed(dashMediaSource.f11241v, Math.min((dashMediaSource.f11224M - 1) * 1000, 5000));
                return;
            } else {
                dashMediaSource.f11214C = new DashManifestStaleException();
                return;
            }
        }
        dashMediaSource.f11219H = dashManifest;
        dashMediaSource.f11220I = dashManifest.dynamic & dashMediaSource.f11220I;
        dashMediaSource.f11221J = j - j2;
        dashMediaSource.f11222K = j;
        synchronized (dashMediaSource.f11239t) {
            try {
                if (parsingLoadable.dataSpec.uri == dashMediaSource.f11217F) {
                    Uri uri = dashMediaSource.f11219H.location;
                    if (uri == null) {
                        uri = parsingLoadable.getUri();
                    }
                    dashMediaSource.f11217F = uri;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (periodCount == 0) {
            DashManifest dashManifest3 = dashMediaSource.f11219H;
            if (dashManifest3.dynamic) {
                UtcTimingElement utcTimingElement = dashManifest3.utcTiming;
                if (utcTimingElement != null) {
                    String str = utcTimingElement.schemeIdUri;
                    if (!Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") && !Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
                        if (!Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") && !Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                            if (!Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                                if (!Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2014") && !Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2012")) {
                                    Log.m3024e(DashMediaSource.DEFAULT_MEDIA_ID, "Failed to resolve time offset.", new IOException("Unsupported UTC timing scheme"));
                                    dashMediaSource.m2776c(true);
                                    return;
                                } else {
                                    SntpClient.initialize(dashMediaSource.f11212A, new C1212fy(dashMediaSource));
                                    return;
                                }
                            }
                            ParsingLoadable parsingLoadable2 = new ParsingLoadable(dashMediaSource.f11245z, Uri.parse(utcTimingElement.value), 5, (ParsingLoadable.Parser) new Object());
                            dashMediaSource.f11236q.loadStarted(new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, dashMediaSource.f11212A.startLoading(parsingLoadable2, new C1371jy(dashMediaSource), 1)), parsingLoadable2.type);
                            return;
                        }
                        ParsingLoadable parsingLoadable3 = new ParsingLoadable(dashMediaSource.f11245z, Uri.parse(utcTimingElement.value), 5, (ParsingLoadable.Parser) new Object());
                        dashMediaSource.f11236q.loadStarted(new LoadEventInfo(parsingLoadable3.loadTaskId, parsingLoadable3.dataSpec, dashMediaSource.f11212A.startLoading(parsingLoadable3, new C1371jy(dashMediaSource), 1)), parsingLoadable3.type);
                        return;
                    }
                    try {
                        dashMediaSource.f11223L = Util.parseXsDateTime(utcTimingElement.value) - dashMediaSource.f11222K;
                        dashMediaSource.m2776c(true);
                        return;
                    } catch (ParserException e) {
                        Log.m3024e(DashMediaSource.DEFAULT_MEDIA_ID, "Failed to resolve time offset.", e);
                        dashMediaSource.m2776c(true);
                        return;
                    }
                }
                SntpClient.initialize(dashMediaSource.f11212A, new C1212fy(dashMediaSource));
                return;
            }
            dashMediaSource.m2776c(true);
            return;
        }
        dashMediaSource.f11226O += i;
        dashMediaSource.m2776c(true);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction createRetryAction;
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        DashMediaSource dashMediaSource = this.f20306a;
        dashMediaSource.getClass();
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.type), iOException, i);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = dashMediaSource.f11233n;
        long retryDelayMsFor = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
        if (retryDelayMsFor == C0643C.TIME_UNSET) {
            createRetryAction = Loader.DONT_RETRY_FATAL;
        } else {
            createRetryAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        boolean isRetry = createRetryAction.isRetry();
        dashMediaSource.f11236q.loadError(loadEventInfo, parsingLoadable.type, iOException, !isRetry);
        if (!isRetry) {
            loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        }
        return createRetryAction;
    }
}
