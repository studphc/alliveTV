package p000;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

/* renamed from: tx */
/* loaded from: classes2.dex */
public final class C1851tx extends ThreadLocal {

    /* renamed from: a */
    public final /* synthetic */ int f27010a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f27010a) {
            case 0:
                return Lists.newArrayListWithCapacity(3);
            case 1:
                return Queues.newArrayDeque();
            case 2:
                return Boolean.FALSE;
            case 3:
                return new char[1024];
            case 4:
                return Boolean.FALSE;
            case 5:
                return Boolean.TRUE;
            default:
                return 0L;
        }
    }
}
