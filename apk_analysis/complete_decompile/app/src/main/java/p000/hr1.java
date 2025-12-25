package p000;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class hr1 implements Comparator {

    /* renamed from: b */
    public static final hr1 f18151b = new hr1(0);

    /* renamed from: c */
    public static final hr1 f18152c = new hr1(1);

    /* renamed from: a */
    public final /* synthetic */ int f18153a;

    public /* synthetic */ hr1(int i) {
        this.f18153a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f18153a) {
            case 0:
                Comparable a = (Comparable) obj;
                Comparable b = (Comparable) obj2;
                Intrinsics.checkNotNullParameter(a, "a");
                Intrinsics.checkNotNullParameter(b, "b");
                return a.compareTo(b);
            default:
                Comparable a2 = (Comparable) obj;
                Comparable b2 = (Comparable) obj2;
                Intrinsics.checkNotNullParameter(a2, "a");
                Intrinsics.checkNotNullParameter(b2, "b");
                return b2.compareTo(a2);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f18153a) {
            case 0:
                return f18152c;
            default:
                return f18151b;
        }
    }
}
