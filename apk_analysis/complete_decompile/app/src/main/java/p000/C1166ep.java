package p000;

import com.google.common.base.Preconditions;
import com.google.common.io.CharSink;
import com.google.common.io.Closer;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

/* renamed from: ep */
/* loaded from: classes2.dex */
public class C1166ep extends C0565bp {
    @Override // com.google.common.io.CharSource
    public final long copyTo(Appendable appendable) {
        appendable.append(this.f8119a);
        return r0.length();
    }

    @Override // p000.C0565bp, com.google.common.io.CharSource
    public final Reader openStream() {
        return new StringReader((String) this.f8119a);
    }

    @Override // com.google.common.io.CharSource
    public final long copyTo(CharSink charSink) {
        CharSequence charSequence = this.f8119a;
        Preconditions.checkNotNull(charSink);
        try {
            ((Writer) Closer.create().register(charSink.openStream())).write((String) charSequence);
            return charSequence.length();
        } finally {
        }
    }
}
