package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* loaded from: classes2.dex */
public final class tg0 extends SuspendLambda implements Function4 {

    /* renamed from: e */
    public int f26803e;

    /* renamed from: f */
    public /* synthetic */ Throwable f26804f;

    /* renamed from: g */
    public /* synthetic */ long f26805g;

    /* renamed from: h */
    public final /* synthetic */ long f26806h;

    /* renamed from: i */
    public final /* synthetic */ Function2 f26807i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg0(long j, Function2 function2, Continuation continuation) {
        super(4, continuation);
        this.f26806h = j;
        this.f26807i = function2;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        long longValue = ((Number) obj3).longValue();
        tg0 tg0Var = new tg0(this.f26806h, this.f26807i, (Continuation) obj4);
        tg0Var.f26804f = (Throwable) obj2;
        tg0Var.f26805g = longValue;
        return tg0Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0035, code lost:
    
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f26803e;
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Throwable th = this.f26804f;
            if (this.f26805g < this.f26806h) {
                this.f26803e = 1;
                obj = this.f26807i.invoke(th, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            z = false;
            return Boxing.boxBoolean(z);
        }
    }
}
