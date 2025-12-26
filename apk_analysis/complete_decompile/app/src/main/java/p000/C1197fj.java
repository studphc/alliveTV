package p000;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* renamed from: fj */
/* loaded from: classes2.dex */
public class C1197fj extends ByteSource {

    /* renamed from: a */
    public final byte[] f17282a;

    /* renamed from: b */
    public final int f17283b;

    /* renamed from: c */
    public final int f17284c;

    public C1197fj(byte[] bArr, int i, int i2) {
        this.f17282a = bArr;
        this.f17283b = i;
        this.f17284c = i2;
    }

    @Override // com.google.common.io.ByteSource
    public final long copyTo(OutputStream outputStream) {
        byte[] bArr = this.f17282a;
        int i = this.f17283b;
        int i2 = this.f17284c;
        outputStream.write(bArr, i, i2);
        return i2;
    }

    @Override // com.google.common.io.ByteSource
    public final HashCode hash(HashFunction hashFunction) {
        return hashFunction.hashBytes(this.f17282a, this.f17283b, this.f17284c);
    }

    @Override // com.google.common.io.ByteSource
    public final boolean isEmpty() {
        if (this.f17284c == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.io.ByteSource
    public final InputStream openBufferedStream() {
        return openStream();
    }

    @Override // com.google.common.io.ByteSource
    public final InputStream openStream() {
        return new ByteArrayInputStream(this.f17282a, this.f17283b, this.f17284c);
    }

    @Override // com.google.common.io.ByteSource
    public byte[] read() {
        int i = this.f17284c;
        int i2 = this.f17283b;
        return Arrays.copyOfRange(this.f17282a, i2, i + i2);
    }

    @Override // com.google.common.io.ByteSource
    public final long size() {
        return this.f17284c;
    }

    @Override // com.google.common.io.ByteSource
    public final Optional sizeIfKnown() {
        return Optional.m3770of(Long.valueOf(this.f17284c));
    }

    @Override // com.google.common.io.ByteSource
    public final ByteSource slice(long j, long j2) {
        boolean z;
        boolean z2 = false;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "offset (%s) may not be negative", j);
        if (j2 >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "length (%s) may not be negative", j2);
        int i = this.f17284c;
        long min = Math.min(j, i);
        return new C1197fj(this.f17282a, this.f17283b + ((int) min), (int) Math.min(j2, i - min));
    }

    public String toString() {
        String truncate = Ascii.truncate(BaseEncoding.base16().encode(this.f17282a, this.f17283b, this.f17284c), 30, "...");
        return AbstractC1726qj.m7059o("ByteSource.wrap(", truncate, ")", AbstractC1726qj.m7052h(17, truncate));
    }

    @Override // com.google.common.io.ByteSource
    public final Object read(ByteProcessor byteProcessor) {
        byteProcessor.processBytes(this.f17282a, this.f17283b, this.f17284c);
        return byteProcessor.getResult();
    }
}
