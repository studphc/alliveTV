package p000;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.BufferedChannel;

/* renamed from: ji */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1355ji extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final C1355ji f20507h = new FunctionReferenceImpl(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return BufferedChannel.access$processResultSelectReceive((BufferedChannel) obj, obj2, obj3);
    }
}
