package androidx.loader.content;

import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ModernAsyncTask$Status {
    public static final ModernAsyncTask$Status FINISHED;
    public static final ModernAsyncTask$Status PENDING;
    public static final ModernAsyncTask$Status RUNNING;

    /* renamed from: a */
    public static final /* synthetic */ ModernAsyncTask$Status[] f6636a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, androidx.loader.content.ModernAsyncTask$Status] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, androidx.loader.content.ModernAsyncTask$Status] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.loader.content.ModernAsyncTask$Status] */
    static {
        ?? r3 = new Enum("PENDING", 0);
        PENDING = r3;
        ?? r4 = new Enum(DebugCoroutineInfoImplKt.RUNNING, 1);
        RUNNING = r4;
        ?? r5 = new Enum("FINISHED", 2);
        FINISHED = r5;
        f6636a = new ModernAsyncTask$Status[]{r3, r4, r5};
    }

    public static ModernAsyncTask$Status valueOf(String str) {
        return (ModernAsyncTask$Status) Enum.valueOf(ModernAsyncTask$Status.class, str);
    }

    public static ModernAsyncTask$Status[] values() {
        return (ModernAsyncTask$Status[]) f6636a.clone();
    }
}
