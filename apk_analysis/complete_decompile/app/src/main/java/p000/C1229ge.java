package p000;

import java.util.Collection;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;

/* renamed from: ge */
/* loaded from: classes2.dex */
public final class C1229ge extends ContinuationImpl {

    /* renamed from: d */
    public Iterator f17655d;

    /* renamed from: e */
    public /* synthetic */ Object f17656e;

    /* renamed from: f */
    public int f17657f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17656e = obj;
        this.f17657f |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Collection<? extends Job>) null, this);
    }
}
