package p000;

import android.media.MediaParser$InputReader;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class r12 implements DataReader {

    /* renamed from: a */
    public MediaParser$InputReader f25834a;

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        int read;
        read = p12.m6784l(Util.castNonNull(this.f25834a)).read(bArr, i, i2);
        return read;
    }
}
