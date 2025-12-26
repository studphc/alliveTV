package p000;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: rh */
/* loaded from: classes2.dex */
public final class C1761rh extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f25967b;

    /* renamed from: c */
    public final /* synthetic */ ReceiveChannel f25968c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1761rh(ReceiveChannel receiveChannel, int i) {
        super(1);
        this.f25967b = i;
        this.f25968c = receiveChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f25967b) {
            case 0:
                ChannelsKt.cancelConsumed(this.f25968c, (Throwable) obj);
                return Unit.INSTANCE;
            default:
                ChannelsKt.cancelConsumed(this.f25968c, (Throwable) obj);
                return Unit.INSTANCE;
        }
    }
}
