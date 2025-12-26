package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;

/* renamed from: com.google.android.exoplayer2.source.dash.b */
/* loaded from: classes.dex */
public final class C0695b implements PlayerEmsgHandler.PlayerEmsgCallback {

    /* renamed from: a */
    public final /* synthetic */ DashMediaSource f11316a;

    public C0695b(DashMediaSource dashMediaSource) {
        this.f11316a = dashMediaSource;
    }

    @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
    public final void onDashManifestPublishTimeExpired(long j) {
        DashMediaSource dashMediaSource = this.f11316a;
        long j2 = dashMediaSource.f11225N;
        if (j2 == C0643C.TIME_UNSET || j2 < j) {
            dashMediaSource.f11225N = j;
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
    public final void onDashManifestRefreshRequested() {
        DashMediaSource dashMediaSource = this.f11316a;
        dashMediaSource.f11215D.removeCallbacks(dashMediaSource.f11242w);
        dashMediaSource.m2777d();
    }
}
