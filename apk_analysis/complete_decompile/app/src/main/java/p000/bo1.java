package p000;

import com.google.android.exoplayer2.source.MediaPeriod;

/* loaded from: classes.dex */
public final class bo1 implements MediaPeriod.Callback {

    /* renamed from: a */
    public final /* synthetic */ co1 f8117a;

    public bo1(co1 co1Var) {
        this.f8117a = co1Var;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.f8117a.f8435d.f16460d.f16928c.obtainMessage(2).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        co1 co1Var = this.f8117a;
        co1Var.f8435d.f16460d.f16929d.set(mediaPeriod.getTrackGroups());
        co1Var.f8435d.f16460d.f16928c.obtainMessage(3).sendToTarget();
    }
}
