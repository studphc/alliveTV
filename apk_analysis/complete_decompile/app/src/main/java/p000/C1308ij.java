package p000;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: ij */
/* loaded from: classes2.dex */
public final class C1308ij extends ByteSource {

    /* renamed from: a */
    public final long f18427a;

    /* renamed from: b */
    public final long f18428b;

    /* renamed from: c */
    public final /* synthetic */ ByteSource f18429c;

    public C1308ij(ByteSource byteSource, long j, long j2) {
        boolean z;
        this.f18429c = byteSource;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "offset (%s) may not be negative", j);
        Preconditions.checkArgument(j2 >= 0, "length (%s) may not be negative", j2);
        this.f18427a = j;
        this.f18428b = j2;
    }

    /* renamed from: a */
    public final InputStream m5247a(InputStream inputStream) {
        long j = this.f18427a;
        if (j > 0) {
            try {
                if (ByteStreams.m4199b(inputStream, j) < j) {
                    inputStream.close();
                    return new ByteArrayInputStream(new byte[0]);
                }
            } finally {
            }
        }
        return ByteStreams.limit(inputStream, this.f18428b);
    }

    @Override // com.google.common.io.ByteSource
    public final boolean isEmpty() {
        if (this.f18428b != 0 && !super.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.io.ByteSource
    public final InputStream openBufferedStream() {
        return m5247a(this.f18429c.openBufferedStream());
    }

    @Override // com.google.common.io.ByteSource
    public final InputStream openStream() {
        return m5247a(this.f18429c.openStream());
    }

    @Override // com.google.common.io.ByteSource
    public final Optional sizeIfKnown() {
        Optional<Long> sizeIfKnown = this.f18429c.sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            long longValue = sizeIfKnown.get().longValue();
            return Optional.m3770of(Long.valueOf(Math.min(this.f18428b, longValue - Math.min(this.f18427a, longValue))));
        }
        return Optional.absent();
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
        long j3 = this.f18428b - j;
        if (j3 <= 0) {
            return ByteSource.empty();
        }
        return this.f18429c.slice(this.f18427a + j, Math.min(j2, j3));
    }

    public final String toString() {
        String obj = this.f18429c.toString();
        StringBuilder sb = new StringBuilder(AbstractC1726qj.m7052h(50, obj));
        sb.append(obj);
        sb.append(".slice(");
        sb.append(this.f18427a);
        sb.append(", ");
        return ye0.m8297q(sb, this.f18428b, ")");
    }
}
