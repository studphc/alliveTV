package p000;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSource;
import com.google.common.io.LineProcessor;
import java.io.Reader;

/* renamed from: bp */
/* loaded from: classes2.dex */
public class C0565bp extends CharSource {

    /* renamed from: b */
    public static final Splitter f8118b = Splitter.onPattern("\r\n|\n|\r");

    /* renamed from: a */
    public final CharSequence f8119a;

    public C0565bp(CharSequence charSequence) {
        this.f8119a = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    @Override // com.google.common.io.CharSource
    public final boolean isEmpty() {
        if (this.f8119a.length() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.io.CharSource
    public final long length() {
        return this.f8119a.length();
    }

    @Override // com.google.common.io.CharSource
    public final Optional lengthIfKnown() {
        return Optional.m3770of(Long.valueOf(this.f8119a.length()));
    }

    @Override // com.google.common.io.CharSource
    public Reader openStream() {
        return new C2064zo(this.f8119a);
    }

    @Override // com.google.common.io.CharSource
    public final String read() {
        return this.f8119a.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.io.CharSource
    public final String readFirstLine() {
        C0528ap c0528ap = new C0528ap(this);
        if (c0528ap.hasNext()) {
            return (String) c0528ap.next();
        }
        return null;
    }

    @Override // com.google.common.io.CharSource
    public final ImmutableList readLines() {
        return ImmutableList.copyOf(new C0528ap(this));
    }

    public String toString() {
        String truncate = Ascii.truncate(this.f8119a, 30, "...");
        return AbstractC1726qj.m7059o("CharSource.wrap(", truncate, ")", AbstractC1726qj.m7052h(17, truncate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.io.CharSource
    public final Object readLines(LineProcessor lineProcessor) {
        C0528ap c0528ap = new C0528ap(this);
        while (c0528ap.hasNext() && lineProcessor.processLine((String) c0528ap.next())) {
        }
        return lineProcessor.getResult();
    }
}
