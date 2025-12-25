package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes2.dex */
public final class fr1 extends ContinuationImpl {

    /* renamed from: d */
    public Mutex f17374d;

    /* renamed from: e */
    public Object f17375e;

    /* renamed from: f */
    public Function0 f17376f;

    /* renamed from: g */
    public /* synthetic */ Object f17377g;

    /* renamed from: h */
    public int f17378h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17377g = obj;
        this.f17378h |= Integer.MIN_VALUE;
        return MutexKt.withLock(null, null, null, this);
    }
}
