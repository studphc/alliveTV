package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* loaded from: classes.dex */
public final class j33 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public int f20363c;

    /* renamed from: d */
    public /* synthetic */ Object f20364d;

    /* renamed from: e */
    public final /* synthetic */ View f20365e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j33(View view, Continuation continuation) {
        super(2, continuation);
        this.f20365e = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        j33 j33Var = new j33(this.f20365e, continuation);
        j33Var.f20364d = obj;
        return j33Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((j33) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f20363c;
        View view = this.f20365e;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sequenceScope = (SequenceScope) this.f20364d;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f20364d;
            this.f20364d = sequenceScope;
            this.f20363c = 1;
            if (sequenceScope.yield(view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (view instanceof ViewGroup) {
            Sequence<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view);
            this.f20364d = null;
            this.f20363c = 2;
            if (sequenceScope.yieldAll(descendants, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
