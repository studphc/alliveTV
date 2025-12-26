package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class BufferOverflow {
    public static final BufferOverflow DROP_LATEST;
    public static final BufferOverflow DROP_OLDEST;
    public static final BufferOverflow SUSPEND;

    /* renamed from: a */
    public static final /* synthetic */ BufferOverflow[] f21451a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlinx.coroutines.channels.BufferOverflow] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlinx.coroutines.channels.BufferOverflow] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlinx.coroutines.channels.BufferOverflow] */
    static {
        ?? r3 = new Enum("SUSPEND", 0);
        SUSPEND = r3;
        ?? r4 = new Enum("DROP_OLDEST", 1);
        DROP_OLDEST = r4;
        ?? r5 = new Enum("DROP_LATEST", 2);
        DROP_LATEST = r5;
        f21451a = new BufferOverflow[]{r3, r4, r5};
    }

    public static BufferOverflow valueOf(String str) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, str);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) f21451a.clone();
    }
}
