package p000;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class q00 {

    /* renamed from: a */
    public final byte[] f25357a = new byte[8];

    /* renamed from: b */
    public final ArrayDeque f25358b = new ArrayDeque();

    /* renamed from: c */
    public final d13 f25359c = new d13();

    /* renamed from: d */
    public b01 f25360d;

    /* renamed from: e */
    public int f25361e;

    /* renamed from: f */
    public int f25362f;

    /* renamed from: g */
    public long f25363g;

    /* renamed from: a */
    public final long m6941a(ExtractorInput extractorInput, int i) {
        extractorInput.readFully(this.f25357a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (r0[i2] & 255);
        }
        return j;
    }
}
