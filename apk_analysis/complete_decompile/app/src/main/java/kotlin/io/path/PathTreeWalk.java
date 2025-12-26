package kotlin.io.path;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import org.jetbrains.annotations.NotNull;
import p000.n32;
import p000.o32;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m5569d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "", "Lkotlin/io/path/PathWalkOption;", "options", "<init>", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib-jdk7"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalPathApi
/* loaded from: classes2.dex */
public final class PathTreeWalk implements Sequence<Path> {

    /* renamed from: a */
    public final Path f21150a;

    /* renamed from: b */
    public final PathWalkOption[] f21151b;

    public PathTreeWalk(@NotNull Path start, @NotNull PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        this.f21150a = start;
        this.f21151b = options;
    }

    public static final LinkOption[] access$getLinkOptions(PathTreeWalk pathTreeWalk) {
        pathTreeWalk.getClass();
        return LinkFollowing.INSTANCE.toLinkOptions(ArraysKt___ArraysKt.contains(pathTreeWalk.f21151b, PathWalkOption.FOLLOW_LINKS));
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<Path> iterator() {
        if (ArraysKt___ArraysKt.contains(this.f21151b, PathWalkOption.BREADTH_FIRST)) {
            return SequencesKt__SequenceBuilderKt.iterator(new n32(this, null));
        }
        return SequencesKt__SequenceBuilderKt.iterator(new o32(this, null));
    }
}
