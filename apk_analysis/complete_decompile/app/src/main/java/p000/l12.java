package p000;

import com.google.common.collect.MapMaker;
import com.google.common.collect.Ordering;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class l12 extends Ordering {

    /* renamed from: a */
    public final /* synthetic */ int f22280a;

    /* renamed from: b */
    public final Object f22281b;

    /* renamed from: c */
    public final Map f22282c;

    public l12() {
        this.f22280a = 0;
        this.f22281b = new AtomicInteger(0);
        this.f22282c = new MapMaker().weakKeys().makeMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r2 < r3) goto L10;
     */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compare(Object obj, Object obj2) {
        switch (this.f22280a) {
            case 0:
                if (obj == obj2) {
                    return 0;
                }
                if (obj != null) {
                    if (obj2 != null) {
                        int identityHashCode = System.identityHashCode(obj);
                        int identityHashCode2 = System.identityHashCode(obj2);
                        if (identityHashCode == identityHashCode2) {
                            ConcurrentMap concurrentMap = (ConcurrentMap) this.f22282c;
                            Integer num = (Integer) concurrentMap.get(obj);
                            AtomicInteger atomicInteger = (AtomicInteger) this.f22281b;
                            if (num == null) {
                                num = Integer.valueOf(atomicInteger.getAndIncrement());
                                Integer num2 = (Integer) concurrentMap.putIfAbsent(obj, num);
                                if (num2 != null) {
                                    num = num2;
                                }
                            }
                            Integer num3 = (Integer) concurrentMap.get(obj2);
                            if (num3 == null) {
                                num3 = Integer.valueOf(atomicInteger.getAndIncrement());
                                Integer num4 = (Integer) concurrentMap.putIfAbsent(obj2, num3);
                                if (num4 != null) {
                                    num3 = num4;
                                }
                            }
                            int compareTo = num.compareTo(num3);
                            if (compareTo != 0) {
                                return compareTo;
                            }
                            throw new AssertionError();
                        }
                    }
                    return 1;
                }
                return -1;
            default:
                HashMap hashMap = (HashMap) this.f22282c;
                Object obj3 = hashMap.get(obj);
                Objects.requireNonNull(obj3);
                Object obj4 = hashMap.get(obj2);
                Objects.requireNonNull(obj4);
                return ((Ordering) this.f22281b).compare(obj3, obj4);
        }
    }

    public String toString() {
        switch (this.f22280a) {
            case 0:
                return "Ordering.arbitrary()";
            default:
                return super.toString();
        }
    }

    public l12(Ordering ordering, HashMap hashMap) {
        this.f22280a = 1;
        this.f22281b = ordering;
        this.f22282c = hashMap;
    }
}
