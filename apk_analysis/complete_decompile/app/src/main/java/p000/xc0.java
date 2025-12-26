package p000;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class xc0 extends SimpleFileVisitor {

    /* renamed from: a */
    public final Function2 f28506a;

    /* renamed from: b */
    public final Function2 f28507b;

    /* renamed from: c */
    public final Function2 f28508c;

    /* renamed from: d */
    public final Function2 f28509d;

    public xc0(Function2 function2, Function2 function22, Function2 function23, Function2 function24) {
        this.f28506a = function2;
        this.f28507b = function22;
        this.f28508c = function23;
        this.f28509d = function24;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
        FileVisitResult fileVisitResult;
        Path dir = (Path) obj;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Function2 function2 = this.f28509d;
        if (function2 == null || (fileVisitResult = (FileVisitResult) function2.invoke(dir, iOException)) == null) {
            FileVisitResult postVisitDirectory = super.postVisitDirectory(dir, iOException);
            Intrinsics.checkNotNullExpressionValue(postVisitDirectory, "super.postVisitDirectory(dir, exc)");
            return postVisitDirectory;
        }
        return fileVisitResult;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes attrs) {
        FileVisitResult fileVisitResult;
        Path dir = (Path) obj;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Function2 function2 = this.f28506a;
        if (function2 == null || (fileVisitResult = (FileVisitResult) function2.invoke(dir, attrs)) == null) {
            FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
            Intrinsics.checkNotNullExpressionValue(preVisitDirectory, "super.preVisitDirectory(dir, attrs)");
            return preVisitDirectory;
        }
        return fileVisitResult;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult visitFile(Object obj, BasicFileAttributes attrs) {
        FileVisitResult fileVisitResult;
        Path file = (Path) obj;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Function2 function2 = this.f28507b;
        if (function2 == null || (fileVisitResult = (FileVisitResult) function2.invoke(file, attrs)) == null) {
            FileVisitResult visitFile = super.visitFile(file, attrs);
            Intrinsics.checkNotNullExpressionValue(visitFile, "super.visitFile(file, attrs)");
            return visitFile;
        }
        return fileVisitResult;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public final FileVisitResult visitFileFailed(Object obj, IOException exc) {
        FileVisitResult fileVisitResult;
        Path file = (Path) obj;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(exc, "exc");
        Function2 function2 = this.f28508c;
        if (function2 == null || (fileVisitResult = (FileVisitResult) function2.invoke(file, exc)) == null) {
            FileVisitResult visitFileFailed = super.visitFileFailed(file, exc);
            Intrinsics.checkNotNullExpressionValue(visitFileFailed, "super.visitFileFailed(file, exc)");
            return visitFileFailed;
        }
        return fileVisitResult;
    }
}
