package p000;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public abstract class co2 {

    /* renamed from: b */
    public TrackOutput f8437b;

    /* renamed from: c */
    public ExtractorOutput f8438c;

    /* renamed from: d */
    public s02 f8439d;

    /* renamed from: e */
    public long f8440e;

    /* renamed from: f */
    public long f8441f;

    /* renamed from: g */
    public long f8442g;

    /* renamed from: h */
    public int f8443h;

    /* renamed from: i */
    public int f8444i;

    /* renamed from: k */
    public long f8446k;

    /* renamed from: l */
    public boolean f8447l;

    /* renamed from: m */
    public boolean f8448m;

    /* renamed from: a */
    public final q02 f8436a = new q02();

    /* renamed from: j */
    public C1540m9 f8445j = new C1540m9(23, false);

    /* renamed from: a */
    public void mo2265a(long j) {
        this.f8442g = j;
    }

    /* renamed from: b */
    public abstract long mo2266b(ParsableByteArray parsableByteArray);

    /* renamed from: c */
    public abstract boolean mo2267c(ParsableByteArray parsableByteArray, long j, C1540m9 c1540m9);

    /* renamed from: d */
    public void mo2268d(boolean z) {
        if (z) {
            this.f8445j = new C1540m9(23, false);
            this.f8441f = 0L;
            this.f8443h = 0;
        } else {
            this.f8443h = 1;
        }
        this.f8440e = -1L;
        this.f8442g = 0L;
    }
}
