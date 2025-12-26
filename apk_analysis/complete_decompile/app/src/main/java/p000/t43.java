package p000;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class t43 {

    /* renamed from: a */
    public final int f26693a;

    /* renamed from: b */
    public final long f26694b;

    public t43(int i, long j) {
        this.f26693a = i;
        this.f26694b = j;
    }

    /* renamed from: a */
    public static t43 m7449a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) {
        extractorInput.peekFully(parsableByteArray.getData(), 0, 8);
        parsableByteArray.setPosition(0);
        return new t43(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
    }
}
