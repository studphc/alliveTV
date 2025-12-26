package p000;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes.dex */
public final class vb0 implements Subtitle {

    /* renamed from: a */
    public final long f27726a;

    /* renamed from: b */
    public final ImmutableList f27727b;

    public vb0(long j, ImmutableList immutableList) {
        this.f27726a = j;
        this.f27727b = immutableList;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final List getCues(long j) {
        if (j >= this.f27726a) {
            return this.f27727b;
        }
        return ImmutableList.m3902of();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final long getEventTime(int i) {
        boolean z;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        return this.f27726a;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getNextEventTimeIndex(long j) {
        if (this.f27726a > j) {
            return 0;
        }
        return -1;
    }
}
