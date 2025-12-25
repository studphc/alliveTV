package p000;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes2.dex */
public final /* synthetic */ class dr1 extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final dr1 f16510h = new FunctionReferenceImpl(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ((MutexImpl) obj).onLockRegFunction((SelectInstance) obj2, obj3);
        return Unit.INSTANCE;
    }
}
