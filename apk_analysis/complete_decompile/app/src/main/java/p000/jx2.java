package p000;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class jx2 implements Subtitle {

    /* renamed from: b */
    public static final jx2 f20677b = new jx2();

    /* renamed from: a */
    public final List f20678a;

    public jx2(Cue cue) {
        this.f20678a = Collections.singletonList(cue);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final List getCues(long j) {
        if (j >= 0) {
            return this.f20678a;
        }
        return Collections.emptyList();
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
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getNextEventTimeIndex(long j) {
        if (j < 0) {
            return 0;
        }
        return -1;
    }

    public jx2() {
        this.f20678a = Collections.emptyList();
    }
}
