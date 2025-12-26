package p000;

import android.media.MediaParser$SeekableInputReader;
import com.google.android.exoplayer2.extractor.ExtractorInput;

/* loaded from: classes.dex */
public final class rl1 implements MediaParser$SeekableInputReader {

    /* renamed from: a */
    public final ExtractorInput f26017a;

    /* renamed from: b */
    public int f26018b;

    public rl1(ExtractorInput extractorInput) {
        this.f26017a = extractorInput;
    }

    public final long getLength() {
        return this.f26017a.getLength();
    }

    public final long getPosition() {
        return this.f26017a.getPeekPosition();
    }

    public final int read(byte[] bArr, int i, int i2) {
        int peek = this.f26017a.peek(bArr, i, i2);
        this.f26018b += peek;
        return peek;
    }

    public final void seekToPosition(long j) {
        throw new UnsupportedOperationException();
    }
}
