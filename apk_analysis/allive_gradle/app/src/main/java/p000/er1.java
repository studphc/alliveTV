package p000;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes2.dex */
public final /* synthetic */ class er1 extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final er1 f16957h = new FunctionReferenceImpl(3, MutexImpl.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((MutexImpl) obj).onLockProcessResult(obj2, obj3);
    }
}
