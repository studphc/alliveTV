package p000;

import com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* loaded from: classes.dex */
public final class g82 {

    /* renamed from: a */
    public final ElementaryStreamReader f17602a;

    /* renamed from: b */
    public final TimestampAdjuster f17603b;

    /* renamed from: c */
    public final ParsableBitArray f17604c = new ParsableBitArray(new byte[64]);

    /* renamed from: d */
    public boolean f17605d;

    /* renamed from: e */
    public boolean f17606e;

    /* renamed from: f */
    public boolean f17607f;

    /* renamed from: g */
    public long f17608g;

    public g82(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
        this.f17602a = elementaryStreamReader;
        this.f17603b = timestampAdjuster;
    }
}
