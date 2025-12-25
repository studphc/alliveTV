package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;
import p000.oh1;

@Metadata(m5568d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, m5569d2 = {"kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ConcurrentWeakMapKt {

    /* renamed from: a */
    public static final Symbol f21509a = new Symbol("REHASH");

    /* renamed from: b */
    public static final oh1 f21510b = new oh1(null);

    /* renamed from: c */
    public static final oh1 f21511c = new oh1(Boolean.TRUE);

    public static final oh1 access$mark(Object obj) {
        if (obj == null) {
            return f21510b;
        }
        if (Intrinsics.areEqual(obj, Boolean.TRUE)) {
            return f21511c;
        }
        return new oh1(obj);
    }

    public static final Void access$noImpl() {
        throw new UnsupportedOperationException("not implemented");
    }
}
