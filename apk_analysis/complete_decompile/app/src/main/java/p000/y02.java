package p000;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes2.dex */
public final /* synthetic */ class y02 extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final y02 f28783h = new FunctionReferenceImpl(3, z02.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        final z02 z02Var = (z02) obj;
        final SelectInstance selectInstance = (SelectInstance) obj2;
        long j = z02Var.f29214a;
        if (j <= 0) {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.selects.OnTimeout$register$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    SelectInstance.this.trySelect(z02Var, Unit.INSTANCE);
                }
            };
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            CoroutineContext context = selectInstance.getContext();
            selectInstance.disposeOnCompletion(DelayKt.getDelay(context).invokeOnTimeout(j, runnable, context));
        }
        return Unit.INSTANCE;
    }
}
