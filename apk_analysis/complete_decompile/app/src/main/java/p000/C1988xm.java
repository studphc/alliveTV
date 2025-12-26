package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: xm */
/* loaded from: classes2.dex */
public final class C1988xm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f28622e;

    /* renamed from: f */
    public /* synthetic */ Object f28623f;

    /* renamed from: g */
    public final /* synthetic */ Function2 f28624g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1988xm(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f28624g = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1988xm c1988xm = new C1988xm(this.f28624g, continuation);
        c1988xm.f28623f = obj;
        return c1988xm;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1988xm) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f28622e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.f28623f;
            this.f28622e = 1;
            obj = this.f28624g.invoke(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Boxing.boxBoolean(!((Boolean) obj).booleanValue());
    }
}
