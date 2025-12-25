package p000;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes2.dex */
public final /* synthetic */ class v61 extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final v61 f27661h = new FunctionReferenceImpl(3, JobSupport.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JobSupport.access$onAwaitInternalRegFunc((JobSupport) obj, (SelectInstance) obj2, obj3);
        return Unit.INSTANCE;
    }
}
