package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.common.collect.ComparisonChain;

/* loaded from: classes.dex */
public final class n10 implements Comparable {

    /* renamed from: a */
    public final boolean f23192a;

    /* renamed from: b */
    public final boolean f23193b;

    public n10(int i, Format format) {
        this.f23192a = (format.selectionFlags & 1) != 0;
        this.f23193b = DefaultTrackSelector.isSupported(i, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        n10 n10Var = (n10) obj;
        return ComparisonChain.start().compareFalseFirst(this.f23193b, n10Var.f23193b).compareFalseFirst(this.f23192a, n10Var.f23192a).result();
    }
}
