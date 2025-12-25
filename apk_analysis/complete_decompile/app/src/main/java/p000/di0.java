package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class di0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f16376e;

    /* renamed from: f */
    public /* synthetic */ Object f16377f;

    /* renamed from: g */
    public final /* synthetic */ Flow f16378g;

    /* renamed from: h */
    public final /* synthetic */ CompletableDeferred f16379h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di0(Flow flow, CompletableDeferred completableDeferred, Continuation continuation) {
        super(2, continuation);
        this.f16378g = flow;
        this.f16379h = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        di0 di0Var = new di0(this.f16378g, this.f16379h, continuation);
        di0Var.f16377f = obj;
        return di0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((di0) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16376e;
        CompletableDeferred completableDeferred = this.f16379h;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f16377f;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Flow flow = this.f16378g;
                ci0 ci0Var = new ci0(objectRef, coroutineScope, completableDeferred);
                this.f16376e = 1;
                if (flow.collect(ci0Var, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            completableDeferred.completeExceptionally(th);
            throw th;
        }
    }
}
