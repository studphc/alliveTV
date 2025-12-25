package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes2.dex */
public final /* synthetic */ class lg2 extends FunctionReferenceImpl implements Function1 {

    /* renamed from: h */
    public static final lg2 f22498h = new FunctionReferenceImpl(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Sequence p0 = (Sequence) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.iterator();
    }
}
