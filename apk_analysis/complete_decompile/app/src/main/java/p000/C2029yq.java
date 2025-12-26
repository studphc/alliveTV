package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* renamed from: yq */
/* loaded from: classes2.dex */
public final class C2029yq implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ int f29061a;

    /* renamed from: b */
    public final /* synthetic */ ProducerScope f29062b;

    public /* synthetic */ C2029yq(ProducerScope producerScope, int i) {
        this.f29061a = i;
        this.f29062b = producerScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        C1992xq c1992xq;
        int i;
        yf0 yf0Var;
        int i2;
        eg0 eg0Var;
        int i3;
        switch (this.f29061a) {
            case 0:
                if (continuation instanceof C1992xq) {
                    c1992xq = (C1992xq) continuation;
                    int i4 = c1992xq.f28684f;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        c1992xq.f28684f = i4 - Integer.MIN_VALUE;
                        Object obj2 = c1992xq.f28682d;
                        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                        i = c1992xq.f28684f;
                        if (i == 0) {
                            if (i == 1) {
                                ResultKt.throwOnFailure(obj2);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj2);
                            SendChannel channel = this.f29062b.getChannel();
                            if (obj == null) {
                                obj = NullSurrogateKt.NULL;
                            }
                            c1992xq.f28684f = 1;
                            if (channel.send(obj, c1992xq) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                c1992xq = new C1992xq(this, continuation);
                Object obj22 = c1992xq.f28682d;
                Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
                i = c1992xq.f28684f;
                if (i == 0) {
                }
                return Unit.INSTANCE;
            case 1:
                if (continuation instanceof yf0) {
                    yf0Var = (yf0) continuation;
                    int i5 = yf0Var.f28935f;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        yf0Var.f28935f = i5 - Integer.MIN_VALUE;
                        Object obj3 = yf0Var.f28933d;
                        Object coroutine_suspended3 = b51.getCOROUTINE_SUSPENDED();
                        i2 = yf0Var.f28935f;
                        if (i2 == 0) {
                            if (i2 == 1) {
                                ResultKt.throwOnFailure(obj3);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj3);
                            if (obj == null) {
                                obj = NullSurrogateKt.NULL;
                            }
                            yf0Var.f28935f = 1;
                            if (this.f29062b.send(obj, yf0Var) == coroutine_suspended3) {
                                return coroutine_suspended3;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                yf0Var = new yf0(this, continuation);
                Object obj32 = yf0Var.f28933d;
                Object coroutine_suspended32 = b51.getCOROUTINE_SUSPENDED();
                i2 = yf0Var.f28935f;
                if (i2 == 0) {
                }
                return Unit.INSTANCE;
            default:
                if (continuation instanceof eg0) {
                    eg0Var = (eg0) continuation;
                    int i6 = eg0Var.f16810f;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        eg0Var.f16810f = i6 - Integer.MIN_VALUE;
                        Object obj4 = eg0Var.f16808d;
                        Object coroutine_suspended4 = b51.getCOROUTINE_SUSPENDED();
                        i3 = eg0Var.f16810f;
                        if (i3 == 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj4);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj4);
                            if (obj == null) {
                                obj = NullSurrogateKt.NULL;
                            }
                            eg0Var.f16810f = 1;
                            if (this.f29062b.send(obj, eg0Var) == coroutine_suspended4) {
                                return coroutine_suspended4;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                eg0Var = new eg0(this, continuation);
                Object obj42 = eg0Var.f16808d;
                Object coroutine_suspended42 = b51.getCOROUTINE_SUSPENDED();
                i3 = eg0Var.f16810f;
                if (i3 == 0) {
                }
                return Unit.INSTANCE;
        }
    }
}
