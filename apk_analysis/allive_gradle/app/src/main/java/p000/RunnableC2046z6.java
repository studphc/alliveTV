package p000;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.C0688b;

/* renamed from: z6 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC2046z6 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f29253a;

    /* renamed from: b */
    public final /* synthetic */ AdsMediaSource f29254b;

    /* renamed from: c */
    public final /* synthetic */ C0688b f29255c;

    public /* synthetic */ RunnableC2046z6(AdsMediaSource adsMediaSource, C0688b c0688b, int i) {
        this.f29253a = i;
        this.f29254b = adsMediaSource;
        this.f29255c = c0688b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f29253a) {
            case 0:
                AdsMediaSource adsMediaSource = this.f29254b;
                Object obj = adsMediaSource.f11104p;
                adsMediaSource.f11101m.start(adsMediaSource, adsMediaSource.f11103o, obj, adsMediaSource.f11102n, this.f29255c);
                return;
            default:
                AdsMediaSource adsMediaSource2 = this.f29254b;
                adsMediaSource2.f11101m.stop(adsMediaSource2, this.f29255c);
                return;
        }
    }
}
