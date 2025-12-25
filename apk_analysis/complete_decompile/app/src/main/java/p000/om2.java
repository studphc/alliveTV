package p000;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class om2 implements Subtitle {

    /* renamed from: a */
    public final /* synthetic */ int f24824a;

    /* renamed from: b */
    public final Object f24825b;

    /* renamed from: c */
    public final Object f24826c;

    public /* synthetic */ om2(int i, Object obj, Object obj2) {
        this.f24824a = i;
        this.f24825b = obj;
        this.f24826c = obj2;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final List getCues(long j) {
        Cue cue;
        switch (this.f24824a) {
            case 0:
                int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) this.f24826c, Long.valueOf(j), true, false);
                if (binarySearchFloor == -1) {
                    return Collections.emptyList();
                }
                return (List) ((ArrayList) this.f24825b).get(binarySearchFloor);
            default:
                int binarySearchFloor2 = Util.binarySearchFloor((long[]) this.f24826c, j, true, false);
                if (binarySearchFloor2 != -1 && (cue = ((Cue[]) this.f24825b)[binarySearchFloor2]) != Cue.EMPTY) {
                    return Collections.singletonList(cue);
                }
                return Collections.emptyList();
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final long getEventTime(int i) {
        boolean z;
        boolean z2;
        switch (this.f24824a) {
            case 0:
                boolean z3 = false;
                if (i >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z);
                ArrayList arrayList = (ArrayList) this.f24826c;
                if (i < arrayList.size()) {
                    z3 = true;
                }
                Assertions.checkArgument(z3);
                return ((Long) arrayList.get(i)).longValue();
            default:
                boolean z4 = false;
                if (i >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkArgument(z2);
                long[] jArr = (long[]) this.f24826c;
                if (i < jArr.length) {
                    z4 = true;
                }
                Assertions.checkArgument(z4);
                return jArr[i];
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getEventTimeCount() {
        switch (this.f24824a) {
            case 0:
                return ((ArrayList) this.f24826c).size();
            default:
                return ((long[]) this.f24826c).length;
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getNextEventTimeIndex(long j) {
        switch (this.f24824a) {
            case 0:
                Long valueOf = Long.valueOf(j);
                ArrayList arrayList = (ArrayList) this.f24826c;
                int binarySearchCeil = Util.binarySearchCeil((List<? extends Comparable<? super Long>>) arrayList, valueOf, false, false);
                if (binarySearchCeil >= arrayList.size()) {
                    return -1;
                }
                return binarySearchCeil;
            default:
                long[] jArr = (long[]) this.f24826c;
                int binarySearchCeil2 = Util.binarySearchCeil(jArr, j, false, false);
                if (binarySearchCeil2 >= jArr.length) {
                    return -1;
                }
                return binarySearchCeil2;
        }
    }
}
