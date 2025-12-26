package p000;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* renamed from: ej */
/* loaded from: classes2.dex */
public final class C1160ej extends CharSource {

    /* renamed from: a */
    public final Charset f16840a;

    /* renamed from: b */
    public final /* synthetic */ ByteSource f16841b;

    public C1160ej(ByteSource byteSource, Charset charset) {
        this.f16841b = byteSource;
        this.f16840a = (Charset) Preconditions.checkNotNull(charset);
    }

    @Override // com.google.common.io.CharSource
    public final ByteSource asByteSource(Charset charset) {
        if (charset.equals(this.f16840a)) {
            return this.f16841b;
        }
        return super.asByteSource(charset);
    }

    @Override // com.google.common.io.CharSource
    public final Reader openStream() {
        return new InputStreamReader(this.f16841b.openStream(), this.f16840a);
    }

    @Override // com.google.common.io.CharSource
    public final String read() {
        return new String(this.f16841b.read(), this.f16840a);
    }

    public final String toString() {
        String obj = this.f16841b.toString();
        String valueOf = String.valueOf(this.f16840a);
        return AbstractC1726qj.m7055k(valueOf.length() + AbstractC1726qj.m7052h(15, obj), obj, ".asCharSource(", valueOf, ")");
    }
}
