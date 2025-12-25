package p000;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class tm1 implements pm1 {

    /* renamed from: a */
    public final MaskingMediaSource f26876a;

    /* renamed from: d */
    public int f26879d;

    /* renamed from: e */
    public boolean f26880e;

    /* renamed from: c */
    public final ArrayList f26878c = new ArrayList();

    /* renamed from: b */
    public final Object f26877b = new Object();

    public tm1(MediaSource mediaSource, boolean z) {
        this.f26876a = new MaskingMediaSource(mediaSource, z);
    }

    @Override // p000.pm1
    /* renamed from: a */
    public final Timeline mo6333a() {
        return this.f26876a.getTimeline();
    }

    @Override // p000.pm1
    public final Object getUid() {
        return this.f26877b;
    }
}
