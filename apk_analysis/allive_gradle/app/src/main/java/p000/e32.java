package p000;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;

/* loaded from: classes2.dex */
public final /* synthetic */ class e32 extends FunctionReferenceImpl implements Function1 {

    /* renamed from: h */
    public static final e32 f16664h = new FunctionReferenceImpl(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Type p0 = (Type) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return TypesJVMKt.access$typeToString(p0);
    }
}
