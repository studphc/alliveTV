package p000;

import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.RunnableFutureTask;

/* loaded from: classes.dex */
public final class wf2 extends RunnableFutureTask {

    /* renamed from: h */
    public final /* synthetic */ DataSource f28171h;

    /* renamed from: i */
    public final /* synthetic */ DataSpec f28172i;

    /* renamed from: j */
    public final /* synthetic */ SegmentDownloader f28173j;

    public wf2(SegmentDownloader segmentDownloader, DataSource dataSource, DataSpec dataSpec) {
        this.f28173j = segmentDownloader;
        this.f28171h = dataSource;
        this.f28172i = dataSpec;
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public final Object doWork() {
        return (FilterableManifest) ParsingLoadable.load(this.f28171h, this.f28173j.f10841b, this.f28172i, 4);
    }
}
