package kotlin.io;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, m5569d2 = {"Lkotlin/io/FileWalkDirection;", "", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FileWalkDirection {
    public static final FileWalkDirection BOTTOM_UP;
    public static final FileWalkDirection TOP_DOWN;

    /* renamed from: a */
    public static final /* synthetic */ FileWalkDirection[] f21118a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, kotlin.io.FileWalkDirection] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, kotlin.io.FileWalkDirection] */
    static {
        ?? r2 = new Enum("TOP_DOWN", 0);
        TOP_DOWN = r2;
        ?? r3 = new Enum("BOTTOM_UP", 1);
        BOTTOM_UP = r3;
        f21118a = new FileWalkDirection[]{r2, r3};
    }

    public static FileWalkDirection valueOf(String str) {
        return (FileWalkDirection) Enum.valueOf(FileWalkDirection.class, str);
    }

    public static FileWalkDirection[] values() {
        return (FileWalkDirection[]) f21118a.clone();
    }
}
