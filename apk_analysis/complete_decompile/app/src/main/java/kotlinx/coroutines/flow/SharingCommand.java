package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SharingCommand {
    public static final SharingCommand START;
    public static final SharingCommand STOP;
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE;

    /* renamed from: a */
    public static final /* synthetic */ SharingCommand[] f21964a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlinx.coroutines.flow.SharingCommand] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlinx.coroutines.flow.SharingCommand] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlinx.coroutines.flow.SharingCommand] */
    static {
        ?? r3 = new Enum("START", 0);
        START = r3;
        ?? r4 = new Enum("STOP", 1);
        STOP = r4;
        ?? r5 = new Enum("STOP_AND_RESET_REPLAY_CACHE", 2);
        STOP_AND_RESET_REPLAY_CACHE = r5;
        f21964a = new SharingCommand[]{r3, r4, r5};
    }

    public static SharingCommand valueOf(String str) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, str);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) f21964a.clone();
    }
}
