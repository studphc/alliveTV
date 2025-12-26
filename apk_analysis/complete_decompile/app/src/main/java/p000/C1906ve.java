package p000;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: ve */
/* loaded from: classes2.dex */
public final class C1906ve extends ByteSource {

    /* renamed from: a */
    public final /* synthetic */ int f27749a = 0;

    /* renamed from: b */
    public final /* synthetic */ CharSource f27750b;

    /* renamed from: c */
    public final Object f27751c;

    public C1906ve(BaseEncoding baseEncoding, CharSource charSource) {
        this.f27751c = baseEncoding;
        this.f27750b = charSource;
    }

    @Override // com.google.common.io.ByteSource
    public CharSource asCharSource(Charset charset) {
        switch (this.f27749a) {
            case 1:
                if (charset.equals((Charset) this.f27751c)) {
                    return this.f27750b;
                }
                return super.asCharSource(charset);
            default:
                return super.asCharSource(charset);
        }
    }

    @Override // com.google.common.io.ByteSource
    public final InputStream openStream() {
        switch (this.f27749a) {
            case 0:
                return ((BaseEncoding) this.f27751c).decodingStream(this.f27750b.openStream());
            default:
                return new z82(this.f27750b.openStream(), (Charset) this.f27751c);
        }
    }

    public String toString() {
        switch (this.f27749a) {
            case 1:
                String obj = this.f27750b.toString();
                String valueOf = String.valueOf((Charset) this.f27751c);
                return AbstractC1726qj.m7055k(valueOf.length() + AbstractC1726qj.m7052h(15, obj), obj, ".asByteSource(", valueOf, ")");
            default:
                return super.toString();
        }
    }

    public C1906ve(CharSource charSource, Charset charset) {
        this.f27750b = charSource;
        this.f27751c = (Charset) Preconditions.checkNotNull(charset);
    }
}
