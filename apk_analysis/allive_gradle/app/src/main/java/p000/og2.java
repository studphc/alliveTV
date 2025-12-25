package p000;

import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class og2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Iterator f23799c;

    /* renamed from: d */
    public Object f23800d;

    /* renamed from: e */
    public int f23801e;

    /* renamed from: f */
    public /* synthetic */ Object f23802f;

    /* renamed from: g */
    public final /* synthetic */ Sequence f23803g;

    /* renamed from: h */
    public final /* synthetic */ Function2 f23804h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og2(Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f23803g = sequence;
        this.f23804h = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        og2 og2Var = new og2(this.f23803g, this.f23804h, continuation);
        og2Var.f23802f = obj;
        return og2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((og2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object next;
        Iterator it;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f23801e;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            next = this.f23800d;
            it = this.f23799c;
            sequenceScope = (SequenceScope) this.f23802f;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f23802f;
            Iterator it2 = this.f23803g.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.f23802f = sequenceScope;
                this.f23799c = it2;
                this.f23800d = next;
                this.f23801e = 1;
                if (sequenceScope.yield(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = it2;
            }
            return Unit.INSTANCE;
        }
        while (it.hasNext()) {
            next = this.f23804h.invoke(next, it.next());
            this.f23802f = sequenceScope;
            this.f23799c = it;
            this.f23800d = next;
            this.f23801e = 2;
            if (sequenceScope.yield(next, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
