package p000;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionMediaSource;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionUtil;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ah2 implements MediaPeriod.Callback {

    /* renamed from: a */
    public final MediaPeriod f191a;

    /* renamed from: d */
    public final Object f194d;

    /* renamed from: e */
    public AdPlaybackState f195e;

    /* renamed from: f */
    public xg2 f196f;

    /* renamed from: g */
    public boolean f197g;

    /* renamed from: h */
    public boolean f198h;

    /* renamed from: b */
    public final ArrayList f192b = new ArrayList();

    /* renamed from: c */
    public final HashMap f193c = new HashMap();

    /* renamed from: i */
    public ExoTrackSelection[] f199i = new ExoTrackSelection[0];

    /* renamed from: j */
    public SampleStream[] f200j = new SampleStream[0];

    /* renamed from: k */
    public MediaLoadData[] f201k = new MediaLoadData[0];

    public ah2(MediaPeriod mediaPeriod, Object obj, AdPlaybackState adPlaybackState) {
        this.f191a = mediaPeriod;
        this.f194d = obj;
        this.f195e = adPlaybackState;
    }

    /* renamed from: a */
    public final long m88a(xg2 xg2Var) {
        return m89b(xg2Var, this.f191a.getBufferedPositionUs());
    }

    /* renamed from: b */
    public final long m89b(xg2 xg2Var, long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        long mediaPeriodPositionUs = ServerSideAdInsertionUtil.getMediaPeriodPositionUs(j, xg2Var.f28551b, this.f195e);
        if (mediaPeriodPositionUs >= ServerSideAdInsertionMediaSource.m2758a(xg2Var, this.f195e)) {
            return Long.MIN_VALUE;
        }
        return mediaPeriodPositionUs;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        xg2 xg2Var = this.f196f;
        if (xg2Var != null) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(xg2Var.f28554e)).onContinueLoadingRequested(this.f196f);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.f198h = true;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f192b;
            if (i < arrayList.size()) {
                xg2 xg2Var = (xg2) arrayList.get(i);
                MediaPeriod.Callback callback = xg2Var.f28554e;
                if (callback != null) {
                    callback.onPrepared(xg2Var);
                }
                i++;
            } else {
                return;
            }
        }
    }
}
