package p000;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes2.dex */
public final /* synthetic */ class o71 extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final o71 f23651h = new FunctionReferenceImpl(3, p71.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        p71.m6885n((p71) obj, (SelectInstance) obj2, obj3);
        return Unit.INSTANCE;
    }
}
