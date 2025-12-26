package p000;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.webvtt.WebvttCueInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d53 implements Subtitle {

    /* renamed from: a */
    public final List f16252a;

    /* renamed from: b */
    public final long[] f16253b;

    /* renamed from: c */
    public final long[] f16254c;

    public d53(ArrayList arrayList) {
        this.f16252a = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f16253b = new long[arrayList.size() * 2];
        for (int i = 0; i < arrayList.size(); i++) {
            WebvttCueInfo webvttCueInfo = (WebvttCueInfo) arrayList.get(i);
            int i2 = i * 2;
            long[] jArr = this.f16253b;
            jArr[i2] = webvttCueInfo.startTimeUs;
            jArr[i2 + 1] = webvttCueInfo.endTimeUs;
        }
        long[] jArr2 = this.f16253b;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f16254c = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final List getCues(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            List list = this.f16252a;
            if (i >= list.size()) {
                break;
            }
            int i2 = i * 2;
            long[] jArr = this.f16253b;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                WebvttCueInfo webvttCueInfo = (WebvttCueInfo) list.get(i);
                Cue cue = webvttCueInfo.cue;
                if (cue.line == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
            i++;
        }
        Collections.sort(arrayList2, new C0556bg(21));
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((WebvttCueInfo) arrayList2.get(i3)).cue.buildUpon().setLine((-1) - i3, 1).build());
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final long getEventTime(int i) {
        boolean z;
        boolean z2 = false;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        long[] jArr = this.f16254c;
        if (i < jArr.length) {
            z2 = true;
        }
        Assertions.checkArgument(z2);
        return jArr[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getEventTimeCount() {
        return this.f16254c.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public final int getNextEventTimeIndex(long j) {
        long[] jArr = this.f16254c;
        int binarySearchCeil = Util.binarySearchCeil(jArr, j, false, false);
        if (binarySearchCeil >= jArr.length) {
            return -1;
        }
        return binarySearchCeil;
    }
}
