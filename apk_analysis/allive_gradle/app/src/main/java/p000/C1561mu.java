package p000;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.C0696e;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: mu */
/* loaded from: classes.dex */
public final class C1561mu extends AbstractConcatenatedTimeline {

    /* renamed from: d */
    public final int f23111d;

    /* renamed from: e */
    public final int f23112e;

    /* renamed from: f */
    public final int[] f23113f;

    /* renamed from: g */
    public final int[] f23114g;

    /* renamed from: h */
    public final Timeline[] f23115h;

    /* renamed from: i */
    public final Object[] f23116i;

    /* renamed from: j */
    public final HashMap f23117j;

    public C1561mu(ArrayList arrayList, ShuffleOrder shuffleOrder, boolean z) {
        super(z, shuffleOrder);
        int size = arrayList.size();
        this.f23113f = new int[size];
        this.f23114g = new int[size];
        this.f23115h = new Timeline[size];
        this.f23116i = new Object[size];
        this.f23117j = new HashMap();
        Iterator it = arrayList.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            C0696e c0696e = (C0696e) it.next();
            this.f23115h[i3] = c0696e.f11355a.getTimeline();
            this.f23114g[i3] = i;
            this.f23113f[i3] = i2;
            i += this.f23115h[i3].getWindowCount();
            i2 += this.f23115h[i3].getPeriodCount();
            Object[] objArr = this.f23116i;
            Object obj = c0696e.f11356b;
            objArr[i3] = obj;
            this.f23117j.put(obj, Integer.valueOf(i3));
            i3++;
        }
        this.f23111d = i;
        this.f23112e = i2;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByChildUid(Object obj) {
        Integer num = (Integer) this.f23117j.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByPeriodIndex(int i) {
        return Util.binarySearchFloor(this.f23113f, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getChildIndexByWindowIndex(int i) {
        return Util.binarySearchFloor(this.f23114g, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final Object getChildUidByChildIndex(int i) {
        return this.f23116i[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getFirstPeriodIndexByChildIndex(int i) {
        return this.f23113f[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final int getFirstWindowIndexByChildIndex(int i) {
        return this.f23114g[i];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getPeriodCount() {
        return this.f23112e;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public final Timeline getTimelineByChildIndex(int i) {
        return this.f23115h[i];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int getWindowCount() {
        return this.f23111d;
    }
}
