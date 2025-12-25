package p000;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.io.CloseableKt;
import kotlin.io.path.CopyActionContext;
import kotlin.io.path.CopyActionResult;
import kotlin.io.path.ExperimentalPathApi;
import kotlin.io.path.LinkFollowing;
import kotlin.io.path.OnErrorResult;
import kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$WhenMappings;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class a42 extends q32 {
    /* renamed from: a */
    public static final FileVisitResult m15a(Function3 function3, Path path, Path path2, Path path3, Exception exc) {
        Path resolve;
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        resolve = path2.resolve(b42.relativeTo(path3, path).toString());
        Intrinsics.checkNotNullExpressionValue(resolve, "target.resolve(relativePath.pathString)");
        int i = PathsKt__PathRecursiveFunctionsKt$WhenMappings.$EnumSwitchMapping$1[((OnErrorResult) function3.invoke(path3, resolve, exc)).ordinal()];
        if (i == 1) {
            fileVisitResult = FileVisitResult.TERMINATE;
            return fileVisitResult;
        }
        if (i == 2) {
            fileVisitResult2 = FileVisitResult.SKIP_SUBTREE;
            return fileVisitResult2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final FileVisitResult access$copyToRecursively$copy(Function3 function3, Path path, Path path2, Function3 function32, Path path3, BasicFileAttributes basicFileAttributes) {
        Path resolve;
        FileVisitResult fileVisitResult;
        FileVisitResult fileVisitResult2;
        FileVisitResult fileVisitResult3;
        try {
            k00 k00Var = k00.f20705a;
            resolve = path2.resolve(b42.relativeTo(path3, path).toString());
            Intrinsics.checkNotNullExpressionValue(resolve, "target.resolve(relativePath.pathString)");
            int i = PathsKt__PathRecursiveFunctionsKt$WhenMappings.$EnumSwitchMapping$0[((CopyActionResult) function3.invoke(k00Var, path3, resolve)).ordinal()];
            if (i == 1) {
                fileVisitResult = FileVisitResult.CONTINUE;
                return fileVisitResult;
            }
            if (i == 2) {
                fileVisitResult2 = FileVisitResult.TERMINATE;
                return fileVisitResult2;
            }
            if (i == 3) {
                fileVisitResult3 = FileVisitResult.SKIP_SUBTREE;
                return fileVisitResult3;
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            return m15a(function32, path, path2, path3, e);
        }
    }

    /* renamed from: b */
    public static final void m16b(SecureDirectoryStream secureDirectoryStream, Path path, fa0 fa0Var) {
        SecureDirectoryStream secureDirectoryStream2;
        try {
            try {
                secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception e) {
                fa0Var.m4789a(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            secureDirectoryStream2 = null;
        }
        if (secureDirectoryStream2 != null) {
            try {
                Iterator it = secureDirectoryStream2.iterator();
                while (it.hasNext()) {
                    Path fileName = ((Path) it.next()).getFileName();
                    Intrinsics.checkNotNullExpressionValue(fileName, "entry.fileName");
                    m17c(secureDirectoryStream2, fileName, fa0Var);
                }
                CloseableKt.closeFinally(secureDirectoryStream2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(secureDirectoryStream2, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17c(SecureDirectoryStream secureDirectoryStream, Path name, fa0 fa0Var) {
        Path path;
        Path path2;
        Path path3;
        boolean z;
        Boolean bool;
        Intrinsics.checkNotNullParameter(name, "name");
        Path path4 = (Path) fa0Var.f17190d;
        Path path5 = null;
        if (path4 != null) {
            path = path4.resolve(name);
        } else {
            path = null;
        }
        fa0Var.f17190d = path;
        try {
            z = false;
            try {
                bool = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(name, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))).readAttributes().isDirectory());
            } catch (NoSuchFileException unused) {
                bool = null;
            }
            if (bool != null) {
                z = bool.booleanValue();
            }
        } catch (Exception e) {
            fa0Var.m4789a(e);
        }
        if (z) {
            int i = fa0Var.f17189c;
            m16b(secureDirectoryStream, name, fa0Var);
            if (i == fa0Var.f17189c) {
                secureDirectoryStream.deleteDirectory(name);
            }
            Intrinsics.checkNotNullParameter(name, "name");
            path2 = (Path) fa0Var.f17190d;
            if (path2 == null) {
                path3 = path2.getFileName();
            } else {
                path3 = null;
            }
            if (!Intrinsics.areEqual(name, path3)) {
                Path path6 = (Path) fa0Var.f17190d;
                if (path6 != null) {
                    path5 = path6.getParent();
                }
                fa0Var.f17190d = path5;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }
        secureDirectoryStream.deleteFile(name);
        Intrinsics.checkNotNullParameter(name, "name");
        path2 = (Path) fa0Var.f17190d;
        if (path2 == null) {
        }
        if (!Intrinsics.areEqual(name, path3)) {
        }
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    @NotNull
    public static final Path copyToRecursively(@NotNull Path path, @NotNull Path target, @NotNull Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (z2) {
            return copyToRecursively(path, target, onError, z, new t32(z));
        }
        return copyToRecursively$default(path, target, onError, z, (Function3) null, 8, (Object) null);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = s32.f26228c;
        }
        return copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, z2);
    }

    /* renamed from: d */
    public static final void m18d(Path path, fa0 fa0Var) {
        DirectoryStream<Path> directoryStream;
        try {
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                int i = fa0Var.f17189c;
                try {
                    try {
                        directoryStream = Files.newDirectoryStream(path);
                    } catch (Exception e) {
                        fa0Var.m4789a(e);
                    }
                } catch (NoSuchFileException unused) {
                    directoryStream = null;
                }
                if (directoryStream != null) {
                    try {
                        for (Path entry : directoryStream) {
                            Intrinsics.checkNotNullExpressionValue(entry, "entry");
                            m18d(entry, fa0Var);
                        }
                        CloseableKt.closeFinally(directoryStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(directoryStream, th);
                            throw th2;
                        }
                    }
                }
                if (i == fa0Var.f17189c) {
                    Files.deleteIfExists(path);
                    return;
                }
                return;
            }
            Files.deleteIfExists(path);
        } catch (Exception e2) {
            fa0Var.m4789a(e2);
        }
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final void deleteRecursively(@NotNull Path path) {
        Path parent;
        DirectoryStream directoryStream;
        Path fileName;
        Intrinsics.checkNotNullParameter(path, "<this>");
        fa0 fa0Var = new fa0();
        parent = path.getParent();
        boolean z = true;
        if (parent != null) {
            try {
                directoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStream = null;
            }
            if (directoryStream != null) {
                try {
                    DirectoryStream m6504i = o81.m6504i(directoryStream);
                    if (o81.m6492A(m6504i)) {
                        fa0Var.f17190d = parent;
                        SecureDirectoryStream m7205q = r32.m7205q(m6504i);
                        fileName = path.getFileName();
                        Intrinsics.checkNotNullExpressionValue(fileName, "this.fileName");
                        m17c(m7205q, fileName, fa0Var);
                        z = false;
                    }
                    CloseableKt.closeFinally(directoryStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(directoryStream, th);
                        throw th2;
                    }
                }
            }
        }
        if (z) {
            m18d(path, fa0Var);
        }
        ArrayList arrayList = (ArrayList) fa0Var.f17187a;
        if (!arrayList.isEmpty()) {
            FileSystemException m6507l = o81.m6507l();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ha0.addSuppressed(m6507l, (Exception) it.next());
            }
            throw m6507l;
        }
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    @NotNull
    public static final Path copyToRecursively(@NotNull Path path, @NotNull Path target, @NotNull Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, boolean z, @NotNull Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> copyAction) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(copyAction, "copyAction");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(z);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            throw new NoSuchFileException(path.toString(), target.toString(), "The source file doesn't exist.");
        }
        boolean z2 = false;
        if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (z || !Files.isSymbolicLink(path))) {
            boolean z3 = Files.exists(target, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(target);
            if (!z3 || !Files.isSameFile(path, target)) {
                if (Intrinsics.areEqual(path.getFileSystem(), target.getFileSystem())) {
                    if (z3) {
                        z2 = target.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]));
                    } else {
                        Path parent = target.getParent();
                        if (parent != null && Files.exists(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && parent.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]))) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    throw new FileSystemException(path.toString(), target.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                }
            }
        }
        b42.visitFileTree$default(path, 0, z, new z32(copyAction, path, target, onError), 1, (Object) null);
        return target;
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, Function3 function32, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = s32.f26229d;
        }
        if ((i & 8) != 0) {
            function32 = new u32(z);
        }
        return copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) function32);
    }
}
