package p000;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.JobSupport;

/* loaded from: classes2.dex */
public final /* synthetic */ class w61 extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final w61 f28083h = new FunctionReferenceImpl(3, JobSupport.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return JobSupport.access$onAwaitInternalProcessResFunc((JobSupport) obj, obj2, obj3);
    }
}
