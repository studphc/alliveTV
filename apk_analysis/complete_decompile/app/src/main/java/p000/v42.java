package p000;

import java.io.Serializable;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

/* loaded from: classes2.dex */
public final class v42 extends AbstractPlatformRandom implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final Random f27648b;

    public v42(Random impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.f27648b = impl;
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public final Random getImpl() {
        return this.f27648b;
    }
}
