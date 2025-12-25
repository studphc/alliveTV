package p000;

import com.google.android.exoplayer2.p003ui.TrackSelectionView;
import com.google.common.collect.PeekingIterator;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: sr */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1808sr implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ int f26538a;

    /* renamed from: b */
    public final /* synthetic */ Comparator f26539b;

    public /* synthetic */ C1808sr(Comparator comparator, int i) {
        this.f26538a = i;
        this.f26539b = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Comparator comparator = this.f26539b;
        switch (this.f26538a) {
            case 0:
                Intrinsics.checkNotNullParameter(comparator, "$comparator");
                if (obj == obj2) {
                    return 0;
                }
                if (obj == null) {
                    return 1;
                }
                if (obj2 == null) {
                    return -1;
                }
                return comparator.compare(obj, obj2);
            case 1:
                Intrinsics.checkNotNullParameter(comparator, "$comparator");
                if (obj == obj2) {
                    return 0;
                }
                if (obj == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                return comparator.compare(obj, obj2);
            case 2:
                return comparator.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
            default:
                gv2 gv2Var = (gv2) obj;
                gv2 gv2Var2 = (gv2) obj2;
                int i = TrackSelectionView.f12302o;
                return comparator.compare(gv2Var.f17850a.getTrackFormat(gv2Var.f17851b), gv2Var2.f17850a.getTrackFormat(gv2Var2.f17851b));
        }
    }
}
