package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* loaded from: classes2.dex */
public final class bg2 extends ContinuationImpl {

    /* renamed from: d */
    public Semaphore f8005d;

    /* renamed from: e */
    public Function0 f8006e;

    /* renamed from: f */
    public /* synthetic */ Object f8007f;

    /* renamed from: g */
    public int f8008g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f8007f = obj;
        this.f8008g |= Integer.MIN_VALUE;
        return SemaphoreKt.withPermit(null, null, this);
    }
}
