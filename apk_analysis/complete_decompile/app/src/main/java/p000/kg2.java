package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final /* synthetic */ class kg2 extends FunctionReferenceImpl implements Function1 {

    /* renamed from: h */
    public static final kg2 f20849h = new FunctionReferenceImpl(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Iterable p0 = (Iterable) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.iterator();
    }
}
