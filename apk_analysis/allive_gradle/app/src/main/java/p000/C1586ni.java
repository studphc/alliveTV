package p000;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.BufferedChannel;

/* renamed from: ni */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1586ni extends FunctionReferenceImpl implements Function3 {

    /* renamed from: h */
    public static final C1586ni f23369h = new FunctionReferenceImpl(3, BufferedChannel.class, "processResultSelectReceiveOrNull", "processResultSelectReceiveOrNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return BufferedChannel.access$processResultSelectReceiveOrNull((BufferedChannel) obj, obj2, obj3);
    }
}
