package p000;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;

/* renamed from: jy */
/* loaded from: classes.dex */
public final class C1371jy implements Loader.Callback {

    /* renamed from: a */
    public final /* synthetic */ DashMediaSource f20679a;

    public C1371jy(DashMediaSource dashMediaSource) {
        this.f20679a = dashMediaSource;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        this.f20679a.m2775b((ParsingLoadable) loadable, j, j2);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        DashMediaSource dashMediaSource = this.f20679a;
        dashMediaSource.getClass();
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        dashMediaSource.f11233n.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        dashMediaSource.f11236q.loadCompleted(loadEventInfo, parsingLoadable.type);
        dashMediaSource.f11223L = ((Long) parsingLoadable.getResult()).longValue() - j;
        dashMediaSource.m2776c(true);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public final Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        DashMediaSource dashMediaSource = this.f20679a;
        dashMediaSource.getClass();
        dashMediaSource.f11236q.loadError(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded()), parsingLoadable.type, iOException, true);
        dashMediaSource.f11233n.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        Log.m3024e(DashMediaSource.DEFAULT_MEDIA_ID, "Failed to resolve time offset.", iOException);
        dashMediaSource.m2776c(true);
        return Loader.DONT_RETRY;
    }
}
