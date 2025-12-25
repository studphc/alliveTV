package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.Hasher;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class jk2 extends AbstractC1966x0 implements Serializable {

    /* renamed from: e */
    public static final jk2 f20533e = new jk2(506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final int f20534a;

    /* renamed from: b */
    public final int f20535b;

    /* renamed from: c */
    public final long f20536c;

    /* renamed from: d */
    public final long f20537d;

    public jk2(long j, long j2) {
        Preconditions.checkArgument(true, "The number of SipRound iterations (c=%s) during Compression must be positive.", 2);
        Preconditions.checkArgument(true, "The number of SipRound iterations (d=%s) during Finalization must be positive.", 4);
        this.f20534a = 2;
        this.f20535b = 4;
        this.f20536c = j;
        this.f20537d = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return 64;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jk2)) {
            return false;
        }
        jk2 jk2Var = (jk2) obj;
        if (this.f20534a != jk2Var.f20534a || this.f20535b != jk2Var.f20535b || this.f20536c != jk2Var.f20536c || this.f20537d != jk2Var.f20537d) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (int) ((((jk2.class.hashCode() ^ this.f20534a) ^ this.f20535b) ^ this.f20536c) ^ this.f20537d);
    }

    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        return new ik2(this.f20534a, this.f20536c, this.f20535b, this.f20537d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(81);
        sb.append("Hashing.sipHash");
        sb.append(this.f20534a);
        sb.append(this.f20535b);
        sb.append("(");
        sb.append(this.f20536c);
        sb.append(", ");
        return ye0.m8297q(sb, this.f20537d, ")");
    }
}
