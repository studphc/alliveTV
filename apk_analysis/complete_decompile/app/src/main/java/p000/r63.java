package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import okio.internal._FileSystemKt;

/* loaded from: classes2.dex */
public final class r63 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public int f25885c;

    /* renamed from: d */
    public /* synthetic */ Object f25886d;

    /* renamed from: e */
    public final /* synthetic */ FileSystem f25887e;

    /* renamed from: f */
    public final /* synthetic */ Path f25888f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r63(FileSystem fileSystem, Path path, Continuation continuation) {
        super(2, continuation);
        this.f25887e = fileSystem;
        this.f25888f = path;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        r63 r63Var = new r63(this.f25887e, this.f25888f, continuation);
        r63Var.f25886d = obj;
        return r63Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((r63) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25885c;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope = (SequenceScope) this.f25886d;
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f25885c = 1;
            if (_FileSystemKt.collectRecursively(sequenceScope, this.f25887e, arrayDeque, this.f25888f, false, true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
