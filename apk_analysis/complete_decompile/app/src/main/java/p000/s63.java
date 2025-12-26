package p000;

import java.util.Iterator;
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
public final class s63 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public ArrayDeque f26256c;

    /* renamed from: d */
    public Iterator f26257d;

    /* renamed from: e */
    public int f26258e;

    /* renamed from: f */
    public /* synthetic */ Object f26259f;

    /* renamed from: g */
    public final /* synthetic */ Path f26260g;

    /* renamed from: h */
    public final /* synthetic */ FileSystem f26261h;

    /* renamed from: i */
    public final /* synthetic */ boolean f26262i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s63(Path path, FileSystem fileSystem, boolean z, Continuation continuation) {
        super(2, continuation);
        this.f26260g = path;
        this.f26261h = fileSystem;
        this.f26262i = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        s63 s63Var = new s63(this.f26260g, this.f26261h, this.f26262i, continuation);
        s63Var.f26259f = obj;
        return s63Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((s63) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        ArrayDeque arrayDeque;
        Iterator<Path> it;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f26258e;
        if (i != 0) {
            if (i == 1) {
                it = this.f26257d;
                ArrayDeque arrayDeque2 = this.f26256c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f26259f;
                ResultKt.throwOnFailure(obj);
                arrayDeque = arrayDeque2;
                sequenceScope = sequenceScope2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope3 = (SequenceScope) this.f26259f;
            ArrayDeque arrayDeque3 = new ArrayDeque();
            Path path = this.f26260g;
            arrayDeque3.addLast(path);
            sequenceScope = sequenceScope3;
            arrayDeque = arrayDeque3;
            it = this.f26261h.list(path).iterator();
        }
        while (it.hasNext()) {
            Path next = it.next();
            this.f26259f = sequenceScope;
            this.f26256c = arrayDeque;
            this.f26257d = it;
            this.f26258e = 1;
            if (_FileSystemKt.collectRecursively(sequenceScope, this.f26261h, arrayDeque, next, this.f26262i, false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
