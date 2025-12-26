package p000;

import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class fg2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public int f17259c;

    /* renamed from: d */
    public /* synthetic */ Object f17260d;

    /* renamed from: e */
    public final /* synthetic */ Sequence f17261e;

    /* renamed from: f */
    public final /* synthetic */ Function0 f17262f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fg2(Sequence sequence, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f17261e = sequence;
        this.f17262f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        fg2 fg2Var = new fg2(this.f17261e, this.f17262f, continuation);
        fg2Var.f17260d = obj;
        return fg2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((fg2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17259c;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope = (SequenceScope) this.f17260d;
            Iterator it = this.f17261e.iterator();
            if (it.hasNext()) {
                this.f17259c = 1;
                if (sequenceScope.yieldAll(it, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Sequence sequence = (Sequence) this.f17262f.invoke();
                this.f17259c = 2;
                if (sequenceScope.yieldAll(sequence, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
