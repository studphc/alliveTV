package p000;

import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import java.nio.charset.Charset;

/* renamed from: hj */
/* loaded from: classes2.dex */
public final class C1271hj extends C1197fj {

    /* renamed from: d */
    public static final C1271hj f18071d = new C1197fj(new byte[0], 0, 0);

    @Override // com.google.common.io.ByteSource
    public final CharSource asCharSource(Charset charset) {
        Preconditions.checkNotNull(charset);
        return CharSource.empty();
    }

    @Override // p000.C1197fj, com.google.common.io.ByteSource
    public final byte[] read() {
        return this.f17282a;
    }

    @Override // p000.C1197fj
    public final String toString() {
        return "ByteSource.empty()";
    }
}
