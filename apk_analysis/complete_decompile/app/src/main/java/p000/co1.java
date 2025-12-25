package p000;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;

/* loaded from: classes.dex */
public final class co1 implements MediaSource.MediaSourceCaller {

    /* renamed from: a */
    public final bo1 f8432a = new bo1(this);

    /* renamed from: b */
    public final DefaultAllocator f8433b = new DefaultAllocator(true, 65536);

    /* renamed from: c */
    public boolean f8434c;

    /* renamed from: d */
    public final /* synthetic */ do1 f8435d;

    public co1(do1 do1Var) {
        this.f8435d = do1Var;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        if (this.f8434c) {
            return;
        }
        this.f8434c = true;
        MediaPeriod createPeriod = mediaSource.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0)), this.f8433b, 0L);
        this.f8435d.f16459c = createPeriod;
        createPeriod.prepare(this.f8432a, 0L);
    }
}
