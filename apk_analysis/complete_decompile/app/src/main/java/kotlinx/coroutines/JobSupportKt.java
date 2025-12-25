package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.e41;
import p000.p80;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"", "boxIncomplete", "(Ljava/lang/Object;)Ljava/lang/Object;", "unboxState", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_WAITING_CHILDREN", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class JobSupportKt {

    /* renamed from: a */
    public static final Symbol f21425a = new Symbol("COMPLETING_ALREADY");

    @JvmField
    @NotNull
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");

    /* renamed from: b */
    public static final Symbol f21426b = new Symbol("COMPLETING_RETRY");

    /* renamed from: c */
    public static final Symbol f21427c = new Symbol("TOO_LATE_TO_CANCEL");

    /* renamed from: d */
    public static final Symbol f21428d = new Symbol("SEALED");

    /* renamed from: e */
    public static final p80 f21429e = new p80(false);

    /* renamed from: f */
    public static final p80 f21430f = new p80(true);

    @Nullable
    public static final Object boxIncomplete(@Nullable Object obj) {
        if (obj instanceof Incomplete) {
            return new e41((Incomplete) obj);
        }
        return obj;
    }

    @Nullable
    public static final Object unboxState(@Nullable Object obj) {
        e41 e41Var;
        Incomplete incomplete;
        if (obj instanceof e41) {
            e41Var = (e41) obj;
        } else {
            e41Var = null;
        }
        if (e41Var != null && (incomplete = e41Var.f16670a) != null) {
            return incomplete;
        }
        return obj;
    }
}
