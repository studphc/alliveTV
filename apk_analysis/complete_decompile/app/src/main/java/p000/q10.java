package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;

/* loaded from: classes.dex */
public abstract class q10 {

    /* renamed from: a */
    public final int f25405a;

    /* renamed from: b */
    public final TrackGroup f25406b;

    /* renamed from: c */
    public final int f25407c;

    /* renamed from: d */
    public final Format f25408d;

    public q10(TrackGroup trackGroup, int i, int i2) {
        this.f25405a = i;
        this.f25406b = trackGroup;
        this.f25407c = i2;
        this.f25408d = trackGroup.getFormat(i2);
    }

    /* renamed from: a */
    public abstract int mo2886a();

    /* renamed from: b */
    public abstract boolean mo2887b(q10 q10Var);
}
