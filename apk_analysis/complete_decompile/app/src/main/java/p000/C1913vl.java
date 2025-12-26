package p000;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: vl */
/* loaded from: classes.dex */
public final class C1913vl implements Subtitle {

    /* renamed from: a */
    public final /* synthetic */ int f27833a;

    /* renamed from: b */
    public final List f27834b;

    public /* synthetic */ C1913vl(int i, List list) {
        this.f27833a = i;
        this.f27834b = list;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final List getCues(long j) {
        switch (this.f27833a) {
            case 0:
                if (j >= 0) {
                    return this.f27834b;
                }
                return Collections.emptyList();
            case 1:
                return this.f27834b;
            case 2:
                if (j >= 0) {
                    return this.f27834b;
                }
                return Collections.emptyList();
            default:
                return this.f27834b;
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final long getEventTime(int i) {
        boolean z;
        boolean z2;
        switch (this.f27833a) {
            case 0:
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z);
                return 0L;
            case 1:
                return 0L;
            case 2:
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkArgument(z2);
                return 0L;
            default:
                return 0L;
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getEventTimeCount() {
        switch (this.f27833a) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 1;
            default:
                return 1;
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getNextEventTimeIndex(long j) {
        switch (this.f27833a) {
            case 0:
                return j < 0 ? 0 : -1;
            case 1:
                return -1;
            case 2:
                return j < 0 ? 0 : -1;
            default:
                return -1;
        }
    }

    public C1913vl(ArrayList arrayList) {
        this.f27833a = 2;
        this.f27834b = Collections.unmodifiableList(arrayList);
    }
}
