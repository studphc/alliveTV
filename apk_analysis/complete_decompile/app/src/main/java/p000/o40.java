package p000;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.collections.ArrayDeque;
import kotlin.io.path.LinkFollowing;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class o40 extends SimpleFileVisitor {

    /* renamed from: a */
    public final boolean f23597a;

    /* renamed from: b */
    public l32 f23598b;

    /* renamed from: c */
    public ArrayDeque f23599c = new ArrayDeque();

    public o40(boolean z) {
        this.f23597a = z;
    }

    /* renamed from: a */
    public final ArrayDeque m6439a(l32 directoryNode) {
        Intrinsics.checkNotNullParameter(directoryNode, "directoryNode");
        this.f23598b = directoryNode;
        Files.walkFileTree(directoryNode.f22314a, LinkFollowing.INSTANCE.toVisitOptions(this.f23597a), 1, this);
        this.f23599c.removeFirst();
        ArrayDeque arrayDeque = this.f23599c;
        this.f23599c = new ArrayDeque();
        return arrayDeque;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes attrs) {
        Path dir = (Path) obj;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f23599c.add(new l32(dir, attrs.fileKey(), this.f23598b));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(preVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return preVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult visitFile(Object obj, BasicFileAttributes attrs) {
        Path file = (Path) obj;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f23599c.add(new l32(file, null, this.f23598b));
        FileVisitResult visitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(visitFile, "super.visitFile(file, attrs)");
        return visitFile;
    }
}
