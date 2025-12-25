package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.ChildHandleNode;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.NodeList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* loaded from: classes2.dex */
public final class u61 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public LockFreeLinkedListHead f27122c;

    /* renamed from: d */
    public ChildHandleNode f27123d;

    /* renamed from: e */
    public int f27124e;

    /* renamed from: f */
    public /* synthetic */ Object f27125f;

    /* renamed from: g */
    public final /* synthetic */ JobSupport f27126g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u61(JobSupport jobSupport, Continuation continuation) {
        super(2, continuation);
        this.f27126g = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        u61 u61Var = new u61(this.f27126g, continuation);
        u61Var.f27125f = obj;
        return u61Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((u61) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0065  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0067 -> B:6:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007d -> B:6:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NodeList list;
        SequenceScope sequenceScope;
        LockFreeLinkedListHead lockFreeLinkedListHead;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f27124e;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    lockFreeLinkedListNode = this.f27123d;
                    lockFreeLinkedListHead = this.f27122c;
                    sequenceScope = (SequenceScope) this.f27125f;
                    ResultKt.throwOnFailure(obj);
                    lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                    if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                        if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                            ChildJob childJob = ((ChildHandleNode) lockFreeLinkedListNode).childJob;
                            this.f27125f = sequenceScope;
                            this.f27122c = lockFreeLinkedListHead;
                            this.f27123d = (ChildHandleNode) lockFreeLinkedListNode;
                            this.f27124e = 2;
                            if (sequenceScope.yield(childJob, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                        if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f27125f;
            Object state$kotlinx_coroutines_core = this.f27126g.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                ChildJob childJob2 = ((ChildHandleNode) state$kotlinx_coroutines_core).childJob;
                this.f27124e = 1;
                if (sequenceScope2.yield(childJob2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                Object next = list.getNext();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) next;
                sequenceScope = sequenceScope2;
                lockFreeLinkedListHead = list;
                lockFreeLinkedListNode = lockFreeLinkedListNode2;
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                }
            }
        }
        return Unit.INSTANCE;
    }
}
