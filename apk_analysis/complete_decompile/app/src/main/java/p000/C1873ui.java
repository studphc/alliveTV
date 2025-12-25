package p000;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelSegment;

/* renamed from: ui */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1873ui extends FunctionReferenceImpl implements Function2 {

    /* renamed from: h */
    public static final C1873ui f27275h = new FunctionReferenceImpl(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return BufferedChannelKt.access$createSegment(((Number) obj).longValue(), (ChannelSegment) obj2);
    }
}
