package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;

/* renamed from: gm */
/* loaded from: classes2.dex */
public final class C1237gm extends ContinuationImpl {

    /* renamed from: d */
    public C1274hm f17753d;

    /* renamed from: e */
    public Object f17754e;

    /* renamed from: f */
    public Job f17755f;

    /* renamed from: g */
    public /* synthetic */ Object f17756g;

    /* renamed from: h */
    public final /* synthetic */ C1274hm f17757h;

    /* renamed from: i */
    public int f17758i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1237gm(C1274hm c1274hm, Continuation continuation) {
        super(continuation);
        this.f17757h = c1274hm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17756g = obj;
        this.f17758i |= Integer.MIN_VALUE;
        return this.f17757h.emit(null, this);
    }
}
