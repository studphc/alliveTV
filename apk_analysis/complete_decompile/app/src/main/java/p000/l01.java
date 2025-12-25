package p000;

import com.google.android.exoplayer2.source.chunk.DataChunk;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class l01 extends DataChunk {

    /* renamed from: c */
    public byte[] f22270c;

    @Override // com.google.android.exoplayer2.source.chunk.DataChunk
    public final void consume(byte[] bArr, int i) {
        this.f22270c = Arrays.copyOf(bArr, i);
    }
}
