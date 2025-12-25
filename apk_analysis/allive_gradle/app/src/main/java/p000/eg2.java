package p000;

import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class eg2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Iterator f16813c;

    /* renamed from: d */
    public int f16814d;

    /* renamed from: e */
    public int f16815e;

    /* renamed from: f */
    public /* synthetic */ Object f16816f;

    /* renamed from: g */
    public final /* synthetic */ Sequence f16817g;

    /* renamed from: h */
    public final /* synthetic */ Function2 f16818h;

    /* renamed from: i */
    public final /* synthetic */ Function1 f16819i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eg2(Sequence sequence, Function2 function2, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f16817g = sequence;
        this.f16818h = function2;
        this.f16819i = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        eg2 eg2Var = new eg2(this.f16817g, this.f16818h, this.f16819i, continuation);
        eg2Var.f16816f = obj;
        return eg2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((eg2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        int i;
        Iterator it;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f16815e;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = this.f16814d;
                it = this.f16813c;
                sequenceScope = (SequenceScope) this.f16816f;
                ResultKt.throwOnFailure(obj);
                i = i3;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f16816f;
            i = 0;
            it = this.f16817g.iterator();
        }
        while (it.hasNext()) {
            Object next = it.next();
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Iterator it2 = (Iterator) this.f16819i.invoke(this.f16818h.invoke(Boxing.boxInt(i), next));
            this.f16816f = sequenceScope;
            this.f16813c = it;
            this.f16814d = i4;
            this.f16815e = 1;
            if (sequenceScope.yieldAll(it2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i4;
        }
        return Unit.INSTANCE;
    }
}
