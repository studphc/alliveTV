package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* loaded from: classes.dex */
public final class TimestampAdjusterProvider {

    /* renamed from: a */
    public final SparseArray f11440a = new SparseArray();

    public TimestampAdjuster getAdjuster(int i) {
        SparseArray sparseArray = this.f11440a;
        TimestampAdjuster timestampAdjuster = (TimestampAdjuster) sparseArray.get(i);
        if (timestampAdjuster == null) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(TimestampAdjuster.MODE_SHARED);
            sparseArray.put(i, timestampAdjuster2);
            return timestampAdjuster2;
        }
        return timestampAdjuster;
    }

    public void reset() {
        this.f11440a.clear();
    }
}
