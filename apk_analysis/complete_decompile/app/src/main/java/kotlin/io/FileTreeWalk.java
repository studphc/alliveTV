package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import p000.vc0;

@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u001b\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0011\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00002\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, m5569d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "Lkotlin/io/FileWalkDirection;", "direction", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function1;", "", "function", "onEnter", "(Lkotlin/jvm/functions/Function1;)Lkotlin/io/FileTreeWalk;", "", "onLeave", "Lkotlin/Function2;", "Ljava/io/IOException;", "onFail", "(Lkotlin/jvm/functions/Function2;)Lkotlin/io/FileTreeWalk;", "", "depth", "maxDepth", "(I)Lkotlin/io/FileTreeWalk;", "rc0", "vc0", "wc0", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FileTreeWalk implements Sequence<File> {

    /* renamed from: a */
    public final File f21112a;

    /* renamed from: b */
    public final FileWalkDirection f21113b;

    /* renamed from: c */
    public final Function1 f21114c;

    /* renamed from: d */
    public final Function1 f21115d;

    /* renamed from: e */
    public final Function2 f21116e;

    /* renamed from: f */
    public final int f21117f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(@NotNull File start, @NotNull FileWalkDirection direction) {
        this(start, direction, null, null, null, Integer.MAX_VALUE);
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(direction, "direction");
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<File> iterator() {
        return new vc0(this);
    }

    @NotNull
    public final FileTreeWalk maxDepth(int depth) {
        if (depth > 0) {
            return new FileTreeWalk(this.f21112a, this.f21113b, this.f21114c, this.f21115d, this.f21116e, depth);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + depth + '.');
    }

    @NotNull
    public final FileTreeWalk onEnter(@NotNull Function1<? super File, Boolean> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.f21112a, this.f21113b, function, this.f21115d, this.f21116e, this.f21117f);
    }

    @NotNull
    public final FileTreeWalk onFail(@NotNull Function2<? super File, ? super IOException, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.f21112a, this.f21113b, this.f21114c, this.f21115d, function, this.f21117f);
    }

    @NotNull
    public final FileTreeWalk onLeave(@NotNull Function1<? super File, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.f21112a, this.f21113b, this.f21114c, function, this.f21116e, this.f21117f);
    }

    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i) {
        this.f21112a = file;
        this.f21113b = fileWalkDirection;
        this.f21114c = function1;
        this.f21115d = function12;
        this.f21116e = function2;
        this.f21117f = i;
    }

    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}
