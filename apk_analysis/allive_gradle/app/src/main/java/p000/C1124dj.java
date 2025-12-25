package p000;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink;
import com.google.common.io.CharSink;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* renamed from: dj */
/* loaded from: classes2.dex */
public final class C1124dj extends CharSink {

    /* renamed from: a */
    public final Charset f16381a;

    /* renamed from: b */
    public final /* synthetic */ ByteSink f16382b;

    public C1124dj(ByteSink byteSink, Charset charset) {
        this.f16382b = byteSink;
        this.f16381a = (Charset) Preconditions.checkNotNull(charset);
    }

    @Override // com.google.common.io.CharSink
    public final Writer openStream() {
        return new OutputStreamWriter(this.f16382b.openStream(), this.f16381a);
    }

    public final String toString() {
        String obj = this.f16382b.toString();
        String valueOf = String.valueOf(this.f16381a);
        return AbstractC1726qj.m7055k(valueOf.length() + AbstractC1726qj.m7052h(13, obj), obj, ".asCharSink(", valueOf, ")");
    }
}
