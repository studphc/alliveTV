package p000;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class m71 extends Random {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final kotlin.random.Random f22837a;

    /* renamed from: b */
    public boolean f22838b;

    public m71(kotlin.random.Random impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.f22837a = impl;
    }

    @Override // java.util.Random
    public final int next(int i) {
        return this.f22837a.nextBits(i);
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return this.f22837a.nextBoolean();
    }

    @Override // java.util.Random
    public final void nextBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f22837a.nextBytes(bytes);
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return this.f22837a.nextDouble();
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return this.f22837a.nextFloat();
    }

    @Override // java.util.Random
    public final int nextInt() {
        return this.f22837a.nextInt();
    }

    @Override // java.util.Random
    public final long nextLong() {
        return this.f22837a.nextLong();
    }

    @Override // java.util.Random
    public final void setSeed(long j) {
        if (!this.f22838b) {
            this.f22838b = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public final int nextInt(int i) {
        return this.f22837a.nextInt(i);
    }
}
