package p000;

import com.google.common.hash.Hasher;

/* renamed from: vw */
/* loaded from: classes2.dex */
public final class C1924vw extends AbstractC1966x0 {

    /* renamed from: a */
    public static final C1924vw f27979a = new AbstractC1966x0();

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return 32;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [c3, uw, com.google.common.hash.Hasher] */
    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        ?? abstractC0579c3 = new AbstractC0579c3(16);
        abstractC0579c3.f27496d = false;
        abstractC0579c3.f27497e = -287056435;
        abstractC0579c3.f27498f = 0;
        abstractC0579c3.f27499g = 0;
        abstractC0579c3.f27500h = 0;
        return abstractC0579c3;
    }

    public final String toString() {
        return "Hashing.crc32c()";
    }
}
