package p000;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: classes2.dex */
public abstract class m32 {

    /* renamed from: a */
    public static final Path f22784a;

    /* renamed from: b */
    public static final Path f22785b;

    static {
        Path path;
        Path path2;
        path = Paths.get("", new String[0]);
        f22784a = path;
        path2 = Paths.get("..", new String[0]);
        f22785b = path2;
    }

    /* renamed from: a */
    public static Path m6045a(Path path, Path base) {
        Path normalize;
        Path r;
        Path relativize;
        int nameCount;
        int nameCount2;
        FileSystem fileSystem;
        String separator;
        FileSystem fileSystem2;
        FileSystem fileSystem3;
        String separator2;
        Path name;
        Path name2;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        normalize = base.normalize();
        r = path.normalize();
        relativize = normalize.relativize(r);
        nameCount = normalize.getNameCount();
        nameCount2 = r.getNameCount();
        int min = Math.min(nameCount, nameCount2);
        for (int i = 0; i < min; i++) {
            name = normalize.getName(i);
            Path path2 = f22785b;
            if (!Intrinsics.areEqual(name, path2)) {
                break;
            }
            name2 = r.getName(i);
            if (!Intrinsics.areEqual(name2, path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (Intrinsics.areEqual(r, normalize) || !Intrinsics.areEqual(normalize, f22784a)) {
            String obj = relativize.toString();
            fileSystem = relativize.getFileSystem();
            separator = fileSystem.getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            if (ro2.endsWith$default(obj, separator, false, 2, null)) {
                fileSystem2 = relativize.getFileSystem();
                fileSystem3 = relativize.getFileSystem();
                separator2 = fileSystem3.getSeparator();
                r = fileSystem2.getPath(StringsKt___StringsKt.dropLast(obj, separator2.length()), new String[0]);
            } else {
                r = relativize;
            }
        }
        Intrinsics.checkNotNullExpressionValue(r, "r");
        return r;
    }
}
