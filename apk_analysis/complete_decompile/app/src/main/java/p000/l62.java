package p000;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l62 extends AbstractConcatenatedTimeline {

    /* renamed from: d */
    public final int f22357d;

    /* renamed from: e */
    public final int f22358e;

    /* renamed from: f */
    public final int[] f22359f;

    /* renamed from: g */
    public final int[] f22360g;

    /* renamed from: h */
    public final Timeline[] f22361h;

    /* renamed from: i */
    public final Object[] f22362i;

    /* renamed from: j */
    public final HashMap f22363j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l62(ArrayList arrayList, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i = 0;
        int size = arrayList.size();
        this.f22359f = new int[size];
        this.f22360g = new int[size];
        this.f22361h = new Timeline[size];
        this.f22362i = new Object[size];
        this.f22363j = new HashMap();
        Iterator it = arrayList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            pm1 pm1Var = (pm1) it.next();
            this.f22361h[i3] = pm1Var.mo6333a();
            this.f22360g[i3] = i;
            this.f22359f[i3] = i2;
            i += this.f22361h[i3].getWindowCount();
            i2 += this.f22361h[i3].getPeriodCount();
            this.f22362i[i3] = pm1Var.getUid();
            this.f22363j.put(this.f22362i[i3], Integer.valueOf(i3));
            i3++;
        }
        this.f22357d = i;
        this.f22358e = i2;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByChildUid(Object obj) {
        Integer num = (Integer) this.f22363j.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByPeriodIndex(int i) {
        return Util.binarySearchFloor(this.f22359f, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByWindowIndex(int i) {
        return Util.binarySearchFloor(this.f22360g, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final Object getChildUidByChildIndex(int i) {
        return this.f22362i[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getFirstPeriodIndexByChildIndex(int i) {
        return this.f22359f[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getFirstWindowIndexByChildIndex(int i) {
        return this.f22360g[i];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getPeriodCount() {
        return this.f22358e;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final Timeline getTimelineByChildIndex(int i) {
        return this.f22361h[i];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getWindowCount() {
        return this.f22357d;
    }
}
