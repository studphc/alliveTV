package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.7")
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/io/path/PathWalkOption;", "", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "kotlin-stdlib-jdk7"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalPathApi
/* loaded from: classes2.dex */
public final class PathWalkOption {
    public static final PathWalkOption BREADTH_FIRST;
    public static final PathWalkOption FOLLOW_LINKS;
    public static final PathWalkOption INCLUDE_DIRECTORIES;

    /* renamed from: a */
    public static final /* synthetic */ PathWalkOption[] f21152a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlin.io.path.PathWalkOption] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlin.io.path.PathWalkOption] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.io.path.PathWalkOption] */
    static {
        ?? r3 = new Enum("INCLUDE_DIRECTORIES", 0);
        INCLUDE_DIRECTORIES = r3;
        ?? r4 = new Enum("BREADTH_FIRST", 1);
        BREADTH_FIRST = r4;
        ?? r5 = new Enum("FOLLOW_LINKS", 2);
        FOLLOW_LINKS = r5;
        f21152a = new PathWalkOption[]{r3, r4, r5};
    }

    public static PathWalkOption valueOf(String str) {
        return (PathWalkOption) Enum.valueOf(PathWalkOption.class, str);
    }

    public static PathWalkOption[] values() {
        return (PathWalkOption[]) f21152a.clone();
    }
}
