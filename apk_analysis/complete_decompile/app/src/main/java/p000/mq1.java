package p000;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class mq1 extends AbstractC1966x0 implements Serializable {

    /* renamed from: b */
    public static final mq1 f23058b = new mq1(0);

    /* renamed from: c */
    public static final mq1 f23059c = new mq1(Hashing.f15058a);
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final int f23060a;

    public mq1(int i) {
        this.f23060a = i;
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return 128;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof mq1) || this.f23060a != ((mq1) obj).f23060a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return mq1.class.hashCode() ^ this.f23060a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [c3, com.google.common.hash.Hasher, lq1] */
    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        ?? abstractC0579c3 = new AbstractC0579c3(16);
        long j = this.f23060a;
        abstractC0579c3.f22637d = j;
        abstractC0579c3.f22638e = j;
        abstractC0579c3.f22639f = 0;
        return abstractC0579c3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Hashing.murmur3_128(");
        sb.append(this.f23060a);
        sb.append(")");
        return sb.toString();
    }
}
