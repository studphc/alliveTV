package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B9\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m5569d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "x", "y", "z", "w", "v", "addend", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "nextInt", "()I", "bitCount", "nextBits", "(I)I", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nXorWowRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XorWowRandom.kt\nkotlin/random/XorWowRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
/* loaded from: classes2.dex */
public final class XorWowRandom extends Random implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public int f21205b;

    /* renamed from: c */
    public int f21206c;

    /* renamed from: d */
    public int f21207d;

    /* renamed from: e */
    public int f21208e;

    /* renamed from: f */
    public int f21209f;

    /* renamed from: g */
    public int f21210g;

    public XorWowRandom(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f21205b = i;
        this.f21206c = i2;
        this.f21207d = i3;
        this.f21208e = i4;
        this.f21209f = i5;
        this.f21210g = i6;
        if ((i | i2 | i3 | i4 | i5) == 0) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
        }
        for (int i7 = 0; i7 < 64; i7++) {
            nextInt();
        }
    }

    @Override // kotlin.random.Random
    public int nextBits(int bitCount) {
        return RandomKt.takeUpperBits(nextInt(), bitCount);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i = this.f21205b;
        int i2 = i ^ (i >>> 2);
        this.f21205b = this.f21206c;
        this.f21206c = this.f21207d;
        this.f21207d = this.f21208e;
        int i3 = this.f21209f;
        this.f21208e = i3;
        int i4 = ((i2 ^ (i2 << 1)) ^ i3) ^ (i3 << 4);
        this.f21209f = i4;
        int i5 = this.f21210g + 362437;
        this.f21210g = i5;
        return i4 + i5;
    }

    public XorWowRandom(int i, int i2) {
        this(i, i2, 0, 0, ~i, (i << 10) ^ (i2 >>> 4));
    }
}
