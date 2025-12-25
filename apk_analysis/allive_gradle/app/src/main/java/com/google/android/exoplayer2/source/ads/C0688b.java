package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import p000.AbstractC2009y6;
import p000.RunnableC0583c7;

/* renamed from: com.google.android.exoplayer2.source.ads.b */
/* loaded from: classes.dex */
public final class C0688b implements AdsLoader.EventListener {

    /* renamed from: a */
    public final Handler f11123a = Util.createHandlerForCurrentLooper();

    /* renamed from: b */
    public volatile boolean f11124b;

    /* renamed from: c */
    public final /* synthetic */ AdsMediaSource f11125c;

    public C0688b(AdsMediaSource adsMediaSource) {
        this.f11125c = adsMediaSource;
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
    public final /* synthetic */ void onAdClicked() {
        AbstractC2009y6.m8220a(this);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
    public final void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
        if (this.f11124b) {
            return;
        }
        AdsMediaSource adsMediaSource = this.f11125c;
        MediaSource.MediaPeriodId mediaPeriodId = AdsMediaSource.f11098w;
        adsMediaSource.createEventDispatcher(null).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), dataSpec, SystemClock.elapsedRealtime()), 6, (IOException) adLoadException, true);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
    public final void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        if (this.f11124b) {
            return;
        }
        this.f11123a.post(new RunnableC0583c7(1, this, adPlaybackState));
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
    public final /* synthetic */ void onAdTapped() {
        AbstractC2009y6.m8223d(this);
    }
}
