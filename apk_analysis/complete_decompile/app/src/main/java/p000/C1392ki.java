package p000;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectInstance;

/* renamed from: ki */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1392ki extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final C1392ki f20858h = new FunctionReferenceImpl(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        BufferedChannel.access$registerSelectForReceive((BufferedChannel) obj, (SelectInstance) obj2, obj3);
        return Unit.INSTANCE;
    }
}
