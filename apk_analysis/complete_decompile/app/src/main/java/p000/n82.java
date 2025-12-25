package p000;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Range;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class n82 implements Function {

    /* renamed from: b */
    public static final n82 f23285b = new n82(0);

    /* renamed from: c */
    public static final n82 f23286c = new n82(1);

    /* renamed from: a */
    public final /* synthetic */ int f23287a;

    public /* synthetic */ n82(int i) {
        this.f23287a = i;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f23287a) {
            case 0:
                return ((Range) obj).f14747a;
            case 1:
                return ((Range) obj).f14748b;
            case 2:
                return Long.valueOf(((AtomicLong) obj).get());
            case 3:
                return Boolean.valueOf(Arrays.asList(((Constructor) obj).getParameterTypes()).contains(String.class));
            case 4:
                return ((Iterable) obj).iterator();
            case 5:
                return Multimaps.m4059a((Collection) obj);
            case 6:
                return (Long) ((Map.Entry) obj).getValue();
            default:
                return Collections.unmodifiableMap((Map) obj);
        }
    }
}
