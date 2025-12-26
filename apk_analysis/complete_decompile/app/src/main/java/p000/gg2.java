package p000;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes2.dex */
public final class gg2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public List f17689c;

    /* renamed from: d */
    public int f17690d;

    /* renamed from: e */
    public /* synthetic */ Object f17691e;

    /* renamed from: f */
    public final /* synthetic */ Sequence f17692f;

    /* renamed from: g */
    public final /* synthetic */ Random f17693g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg2(Sequence sequence, Random random, Continuation continuation) {
        super(2, continuation);
        this.f17692f = sequence;
        this.f17693g = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        gg2 gg2Var = new gg2(this.f17692f, this.f17693g, continuation);
        gg2Var.f17691e = obj;
        return gg2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((gg2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List mutableList;
        SequenceScope sequenceScope;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f17690d;
        if (i != 0) {
            if (i == 1) {
                mutableList = this.f17689c;
                sequenceScope = (SequenceScope) this.f17691e;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f17691e;
            mutableList = SequencesKt___SequencesKt.toMutableList(this.f17692f);
            sequenceScope = sequenceScope2;
        }
        while (!mutableList.isEmpty()) {
            int nextInt = this.f17693g.nextInt(mutableList.size());
            Object removeLast = AbstractC1327iq.removeLast(mutableList);
            if (nextInt < mutableList.size()) {
                removeLast = mutableList.set(nextInt, removeLast);
            }
            this.f17691e = sequenceScope;
            this.f17689c = mutableList;
            this.f17690d = 1;
            if (sequenceScope.yield(removeLast, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
