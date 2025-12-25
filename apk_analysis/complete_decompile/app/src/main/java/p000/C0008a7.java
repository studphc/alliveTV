package p000;

import android.net.Uri;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import java.util.ArrayList;

/* renamed from: a7 */
/* loaded from: classes.dex */
public final class C0008a7 {

    /* renamed from: a */
    public final MediaSource.MediaPeriodId f62a;

    /* renamed from: b */
    public final ArrayList f63b = new ArrayList();

    /* renamed from: c */
    public Uri f64c;

    /* renamed from: d */
    public MediaSource f65d;

    /* renamed from: e */
    public Timeline f66e;

    /* renamed from: f */
    public final /* synthetic */ AdsMediaSource f67f;

    public C0008a7(AdsMediaSource adsMediaSource, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f67f = adsMediaSource;
        this.f62a = mediaPeriodId;
    }
}
