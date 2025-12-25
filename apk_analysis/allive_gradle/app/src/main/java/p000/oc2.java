package p000;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class oc2 implements Comparator {

    /* renamed from: a */
    public final Comparator f23765a;

    public oc2(Comparator comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.f23765a = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f23765a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return this.f23765a;
    }
}
