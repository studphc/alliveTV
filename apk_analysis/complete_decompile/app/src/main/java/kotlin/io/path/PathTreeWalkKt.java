package kotlin.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.l32;

@Metadata(m5568d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, m5569d2 = {"kotlin-stdlib-jdk7"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class PathTreeWalkKt {
    public static final boolean access$createsCycle(l32 l32Var) {
        boolean isSameFile;
        Object obj;
        for (l32 l32Var2 = l32Var.f22316c; l32Var2 != null; l32Var2 = l32Var2.f22316c) {
            Object obj2 = l32Var2.f22315b;
            if (obj2 == null || (obj = l32Var.f22315b) == null) {
                try {
                    isSameFile = Files.isSameFile(l32Var2.f22314a, l32Var.f22314a);
                    if (isSameFile) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (Intrinsics.areEqual(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static final Object access$keyOf(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            BasicFileAttributes readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            Intrinsics.checkNotNullExpressionValue(readAttributes, "readAttributes(this, A::class.java, *options)");
            return readAttributes.fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }
}
