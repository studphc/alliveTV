package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.Hasher;
import java.io.Serializable;
import java.util.zip.Checksum;

/* renamed from: lp */
/* loaded from: classes2.dex */
public final class C1519lp extends AbstractC1966x0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final c41 f22602a;

    /* renamed from: b */
    public final int f22603b;

    /* renamed from: c */
    public final String f22604c;

    public C1519lp(rz0 rz0Var, String str) {
        this.f22602a = (c41) Preconditions.checkNotNull(rz0Var);
        Preconditions.checkArgument(true, "bits (%s) must be either 32 or 64", 32);
        this.f22603b = 32;
        this.f22604c = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return this.f22603b;
    }

    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        return new C1482kp(this, (Checksum) this.f22602a.get());
    }

    public final String toString() {
        return this.f22604c;
    }
}
