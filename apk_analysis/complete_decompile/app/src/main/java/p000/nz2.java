package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final /* synthetic */ class nz2 extends FunctionReferenceImpl implements Function1 {

    /* renamed from: h */
    public static final nz2 f23548h = new FunctionReferenceImpl(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Class p0 = (Class) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.getComponentType();
    }
}
