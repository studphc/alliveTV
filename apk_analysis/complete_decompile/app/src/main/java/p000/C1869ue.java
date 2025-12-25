package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSink;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* renamed from: ue */
/* loaded from: classes2.dex */
public final class C1869ue extends ByteSink {

    /* renamed from: a */
    public final /* synthetic */ int f27233a = 0;

    /* renamed from: b */
    public final Object f27234b;

    /* renamed from: c */
    public final Object f27235c;

    public C1869ue(BaseEncoding baseEncoding, CharSink charSink) {
        this.f27235c = baseEncoding;
        this.f27234b = charSink;
    }

    @Override // com.google.common.io.ByteSink
    public final OutputStream openStream() {
        switch (this.f27233a) {
            case 0:
                return ((BaseEncoding) this.f27235c).encodingStream(((CharSink) this.f27234b).openStream());
            default:
                return new FileOutputStream((File) this.f27234b, ((ImmutableSet) this.f27235c).contains(FileWriteMode.APPEND));
        }
    }

    public String toString() {
        switch (this.f27233a) {
            case 1:
                String valueOf = String.valueOf((File) this.f27234b);
                String valueOf2 = String.valueOf((ImmutableSet) this.f27235c);
                StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 20, "Files.asByteSink(", valueOf, ", ", valueOf2);
                m7062r.append(")");
                return m7062r.toString();
            default:
                return super.toString();
        }
    }

    public C1869ue(File file, FileWriteMode[] fileWriteModeArr) {
        this.f27234b = (File) Preconditions.checkNotNull(file);
        this.f27235c = ImmutableSet.copyOf(fileWriteModeArr);
    }
}
