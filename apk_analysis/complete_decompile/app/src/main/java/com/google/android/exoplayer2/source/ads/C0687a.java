package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import p000.RunnableC0547b7;
import p000.RunnableC0583c7;

/* renamed from: com.google.android.exoplayer2.source.ads.a */
/* loaded from: classes.dex */
public final class C0687a implements MaskingMediaPeriod.PrepareListener {

    /* renamed from: a */
    public final Uri f11121a;

    /* renamed from: b */
    public final /* synthetic */ AdsMediaSource f11122b;

    public C0687a(AdsMediaSource adsMediaSource, Uri uri) {
        this.f11122b = adsMediaSource;
        this.f11121a = uri;
    }

    @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
    public final void onPrepareComplete(MediaSource.MediaPeriodId mediaPeriodId) {
        this.f11122b.f11105q.post(new RunnableC0583c7(0, this, mediaPeriodId));
    }

    @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
    public final void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
        MediaSource.MediaPeriodId mediaPeriodId2 = AdsMediaSource.f11098w;
        AdsMediaSource adsMediaSource = this.f11122b;
        adsMediaSource.createEventDispatcher(mediaPeriodId).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), new DataSpec(this.f11121a), SystemClock.elapsedRealtime()), 6, (IOException) AdsMediaSource.AdLoadException.createForAd(iOException), true);
        adsMediaSource.f11105q.post(new RunnableC0547b7(this, mediaPeriodId, iOException, 0));
    }
}
