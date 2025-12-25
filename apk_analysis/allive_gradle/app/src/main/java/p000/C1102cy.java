package p000;

import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.RunnableFutureTask;

/* renamed from: cy */
/* loaded from: classes.dex */
public final class C1102cy extends RunnableFutureTask {

    /* renamed from: h */
    public final /* synthetic */ DataSource f16176h;

    /* renamed from: i */
    public final /* synthetic */ int f16177i;

    /* renamed from: j */
    public final /* synthetic */ Representation f16178j;

    public C1102cy(DataSource dataSource, int i, Representation representation) {
        this.f16176h = dataSource;
        this.f16177i = i;
        this.f16178j = representation;
    }

    @Override // com.google.android.exoplayer2.util.RunnableFutureTask
    public final Object doWork() {
        return DashUtil.loadChunkIndex(this.f16176h, this.f16177i, this.f16178j);
    }
}
