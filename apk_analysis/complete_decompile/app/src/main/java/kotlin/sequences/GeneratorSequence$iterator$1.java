package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.qw0;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0003\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m5569d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "a", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "nextItem", "", "b", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class GeneratorSequence$iterator$1 implements Iterator<Object>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public Object nextItem;

    /* renamed from: b, reason: from kotlin metadata */
    public int nextState = -2;

    /* renamed from: c */
    public final /* synthetic */ qw0 f21278c;

    public GeneratorSequence$iterator$1(qw0 qw0Var) {
        this.f21278c = qw0Var;
    }

    /* renamed from: a */
    public final void m5633a() {
        Object invoke;
        int i;
        int i2 = this.nextState;
        qw0 qw0Var = this.f21278c;
        if (i2 == -2) {
            invoke = qw0Var.f25781a.invoke();
        } else {
            Function1 function1 = qw0Var.f25782b;
            Object obj = this.nextItem;
            Intrinsics.checkNotNull(obj);
            invoke = function1.invoke(obj);
        }
        this.nextItem = invoke;
        if (invoke == null) {
            i = 0;
        } else {
            i = 1;
        }
        this.nextState = i;
    }

    @Nullable
    public final Object getNextItem() {
        return this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState < 0) {
            m5633a();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    @NotNull
    public Object next() {
        if (this.nextState < 0) {
            m5633a();
        }
        if (this.nextState != 0) {
            Object obj = this.nextItem;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.nextState = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(@Nullable Object obj) {
        this.nextItem = obj;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }
}
