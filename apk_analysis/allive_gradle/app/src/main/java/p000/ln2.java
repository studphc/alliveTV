package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharingCommand;

/* loaded from: classes2.dex */
public final class ln2 extends SuspendLambda implements Function3 {

    /* renamed from: e */
    public int f22588e;

    /* renamed from: f */
    public /* synthetic */ FlowCollector f22589f;

    /* renamed from: g */
    public /* synthetic */ int f22590g;

    /* renamed from: h */
    public final /* synthetic */ nn2 f22591h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ln2(nn2 nn2Var, Continuation continuation) {
        super(3, continuation);
        this.f22591h = nn2Var;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int intValue = ((Number) obj2).intValue();
        ln2 ln2Var = new ln2(this.f22591h, (Continuation) obj3);
        ln2Var.f22589f = (FlowCollector) obj;
        ln2Var.f22590g = intValue;
        return ln2Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        long j;
        SharingCommand sharingCommand;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f22588e;
        nn2 nn2Var = this.f22591h;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            flowCollector = this.f22589f;
                            ResultKt.throwOnFailure(obj);
                            sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                            this.f22589f = null;
                            this.f22588e = 5;
                            if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        flowCollector = this.f22589f;
                        ResultKt.throwOnFailure(obj);
                        j = nn2Var.f23427b;
                        this.f22589f = flowCollector;
                        this.f22588e = 4;
                        if (DelayKt.delay(j, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                        this.f22589f = null;
                        this.f22588e = 5;
                        if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    flowCollector = this.f22589f;
                    ResultKt.throwOnFailure(obj);
                    if (nn2Var.f23427b > 0) {
                        SharingCommand sharingCommand2 = SharingCommand.STOP;
                        this.f22589f = flowCollector;
                        this.f22588e = 3;
                        if (flowCollector.emit(sharingCommand2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j = nn2Var.f23427b;
                        this.f22589f = flowCollector;
                        this.f22588e = 4;
                        if (DelayKt.delay(j, this) == coroutine_suspended) {
                        }
                    }
                    sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.f22589f = null;
                    this.f22588e = 5;
                    if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        flowCollector = this.f22589f;
        if (this.f22590g > 0) {
            SharingCommand sharingCommand3 = SharingCommand.START;
            this.f22588e = 1;
            if (flowCollector.emit(sharingCommand3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        long j2 = nn2Var.f23426a;
        this.f22589f = flowCollector;
        this.f22588e = 2;
        if (DelayKt.delay(j2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (nn2Var.f23427b > 0) {
        }
        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
        this.f22589f = null;
        this.f22588e = 5;
        if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
