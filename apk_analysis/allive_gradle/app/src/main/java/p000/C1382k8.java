package p000;

import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.HashSet;
import java.util.function.IntFunction;

/* renamed from: k8 */
/* loaded from: classes.dex */
public final class C1382k8 implements IntFunction {

    /* renamed from: a */
    public final /* synthetic */ int f20774a;

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.f20774a) {
            case 0:
                if (i != 0) {
                    if (i != 1) {
                        return String.valueOf(i);
                    }
                    return "uniform";
                }
                return SchedulerSupport.NONE;
            case 1:
                if (i != 0) {
                    if (i != 1) {
                        return String.valueOf(i);
                    }
                    return "uniform";
                }
                return SchedulerSupport.NONE;
            case 2:
                if (i != 0) {
                    if (i != 1) {
                        return String.valueOf(i);
                    }
                    return "vertical";
                }
                return "horizontal";
            default:
                HashSet hashSet = new HashSet();
                if (i == 0) {
                    hashSet.add(SchedulerSupport.NONE);
                }
                if (i == 1) {
                    hashSet.add("beginning");
                }
                if (i == 2) {
                    hashSet.add("middle");
                }
                if (i == 4) {
                    hashSet.add("end");
                }
                return hashSet;
        }
    }
}
