package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class bx2 {

    /* renamed from: a */
    public final int f8179a;

    /* renamed from: d */
    public boolean f8182d;

    /* renamed from: e */
    public boolean f8183e;

    /* renamed from: f */
    public boolean f8184f;

    /* renamed from: b */
    public final TimestampAdjuster f8180b = new TimestampAdjuster(0);

    /* renamed from: g */
    public long f8185g = C0643C.TIME_UNSET;

    /* renamed from: h */
    public long f8186h = C0643C.TIME_UNSET;

    /* renamed from: i */
    public long f8187i = C0643C.TIME_UNSET;

    /* renamed from: c */
    public final ParsableByteArray f8181c = new ParsableByteArray();

    public bx2(int i) {
        this.f8179a = i;
    }

    /* renamed from: a */
    public final void m2174a(ExtractorInput extractorInput) {
        this.f8181c.reset(Util.EMPTY_BYTE_ARRAY);
        this.f8182d = true;
        extractorInput.resetPeekPosition();
    }
}
