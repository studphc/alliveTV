package p000;

import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharDirectionality;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* renamed from: yn */
/* loaded from: classes2.dex */
public final class C2026yn extends Lambda implements Function0 {

    /* renamed from: c */
    public static final C2026yn f29026c = new C2026yn(0, 0);

    /* renamed from: d */
    public static final C2026yn f29027d = new C2026yn(0, 1);

    /* renamed from: e */
    public static final C2026yn f29028e = new C2026yn(0, 2);

    /* renamed from: f */
    public static final C2026yn f29029f = new C2026yn(0, 3);

    /* renamed from: g */
    public static final C2026yn f29030g = new C2026yn(0, 4);

    /* renamed from: b */
    public final /* synthetic */ int f29031b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2026yn(int i, int i2) {
        super(i);
        this.f29031b = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ConcurrentWeakMap concurrentWeakMap;
        switch (this.f29031b) {
            case 0:
                CharDirectionality[] values = CharDirectionality.values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(values.length), 16));
                for (CharDirectionality charDirectionality : values) {
                    linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
                }
                return linkedHashMap;
            case 1:
                concurrentWeakMap = DebugProbesImpl.f21531i;
                concurrentWeakMap.runWeakRefQueueCleaningLoopUntilInterrupted();
                return Unit.INSTANCE;
            case 2:
                return null;
            case 3:
                throw new IllegalStateException("trailers not available");
            default:
                return Unit.INSTANCE;
        }
    }
}
