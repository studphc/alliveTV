package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p000.rh2;
import p000.sh2;

@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m5569d2 = {"Lkotlin/io/path/LinkFollowing;", "", "", "followLinks", "", "Ljava/nio/file/LinkOption;", "toLinkOptions", "(Z)[Ljava/nio/file/LinkOption;", "", "Ljava/nio/file/FileVisitOption;", "toVisitOptions", "(Z)Ljava/util/Set;", "kotlin-stdlib-jdk7"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,177:1\n26#2:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n*L\n142#1:178\n*E\n"})
/* loaded from: classes2.dex */
public final class LinkFollowing {

    @NotNull
    public static final LinkFollowing INSTANCE = new Object();

    /* renamed from: a */
    public static final LinkOption[] f21145a;

    /* renamed from: b */
    public static final LinkOption[] f21146b;

    /* renamed from: c */
    public static final Set f21147c;

    /* renamed from: d */
    public static final Set f21148d;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.io.path.LinkFollowing, java.lang.Object] */
    static {
        LinkOption linkOption;
        FileVisitOption fileVisitOption;
        linkOption = LinkOption.NOFOLLOW_LINKS;
        f21145a = new LinkOption[]{linkOption};
        f21146b = new LinkOption[0];
        f21147c = sh2.emptySet();
        fileVisitOption = FileVisitOption.FOLLOW_LINKS;
        f21148d = rh2.setOf(fileVisitOption);
    }

    @NotNull
    public final LinkOption[] toLinkOptions(boolean followLinks) {
        if (followLinks) {
            return f21146b;
        }
        return f21145a;
    }

    @NotNull
    public final Set<FileVisitOption> toVisitOptions(boolean followLinks) {
        if (followLinks) {
            return f21148d;
        }
        return f21147c;
    }
}
