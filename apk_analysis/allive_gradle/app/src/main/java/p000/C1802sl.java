package p000;

import com.google.android.exoplayer2.text.SubtitleInputBuffer;

/* renamed from: sl */
/* loaded from: classes.dex */
public final class C1802sl extends SubtitleInputBuffer implements Comparable {

    /* renamed from: d */
    public long f26469d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C1802sl c1802sl = (C1802sl) obj;
        if (isEndOfStream() != c1802sl.isEndOfStream()) {
            if (!isEndOfStream()) {
                return -1;
            }
        } else {
            long j = this.timeUs - c1802sl.timeUs;
            if (j == 0) {
                j = this.f26469d - c1802sl.f26469d;
                if (j == 0) {
                    return 0;
                }
            }
            if (j <= 0) {
                return -1;
            }
        }
        return 1;
    }
}
