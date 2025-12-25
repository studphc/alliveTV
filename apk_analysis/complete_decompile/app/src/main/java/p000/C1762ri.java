package p000;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.MutexImpl;

/* renamed from: ri */
/* loaded from: classes2.dex */
public final class C1762ri extends Lambda implements Function3 {

    /* renamed from: b */
    public final /* synthetic */ int f25972b;

    /* renamed from: c */
    public final /* synthetic */ Object f25973c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1762ri(int i, Object obj) {
        super(3);
        this.f25972b = i;
        this.f25973c = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f25972b) {
            case 0:
                return new C1725qi(obj3, (BufferedChannel) this.f25973c, (SelectInstance) obj, 0);
            default:
                return new C1807sq(4, (MutexImpl) this.f25973c, obj2);
        }
    }
}
