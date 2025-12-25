package p000;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.io.CloseableKt;
import kotlin.io.path.ExperimentalPathApi;
import kotlin.io.path.FileVisitorBuilder;
import kotlin.io.path.FileVisitorBuilderImpl;
import kotlin.io.path.PathTreeWalk;
import kotlin.io.path.PathWalkOption;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class b42 extends a42 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final Path createTempDirectory(@Nullable Path path, @Nullable String str, @NotNull FileAttribute<?>... attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (path != null) {
            Path createTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            Intrinsics.checkNotNullExpressionValue(createTempDirectory, "createTempDirectory(dire…ory, prefix, *attributes)");
            return createTempDirectory;
        }
        Path createTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory2, "createTempDirectory(prefix, *attributes)");
        return createTempDirectory2;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return createTempDirectory(path, str, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final Path createTempFile(@Nullable Path path, @Nullable String str, @Nullable String str2, @NotNull FileAttribute<?>... attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (path != null) {
            Path createTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(directory…fix, suffix, *attributes)");
            return createTempFile;
        }
        Path createTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile2, "createTempFile(prefix, suffix, *attributes)");
        return createTempFile2;
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return createTempFile(path, str, str2, fileAttributeArr);
    }

    @PublishedApi
    @NotNull
    public static final Void fileAttributeViewNotAvailable(@NotNull Path path, @NotNull Class<?> attributeViewClass) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    @NotNull
    public static final FileVisitor<Path> fileVisitor(@NotNull Function1<? super FileVisitorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        builderAction.invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.build();
    }

    @NotNull
    public static final String getExtension(@NotNull Path path) {
        Path fileName;
        String obj;
        String substringAfterLast;
        Intrinsics.checkNotNullParameter(path, "<this>");
        fileName = path.getFileName();
        if (fileName == null || (obj = fileName.toString()) == null || (substringAfterLast = StringsKt__StringsKt.substringAfterLast(obj, '.', "")) == null) {
            return "";
        }
        return substringAfterLast;
    }

    @NotNull
    public static final String getInvariantSeparatorsPathString(@NotNull Path path) {
        FileSystem fileSystem;
        String separator;
        Intrinsics.checkNotNullParameter(path, "<this>");
        fileSystem = path.getFileSystem();
        separator = fileSystem.getSeparator();
        if (!Intrinsics.areEqual(separator, "/")) {
            String obj = path.toString();
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            return ro2.replace$default(obj, separator, "/", false, 4, (Object) null);
        }
        return path.toString();
    }

    @NotNull
    public static final String getName(@NotNull Path path) {
        Path fileName;
        String str;
        Intrinsics.checkNotNullParameter(path, "<this>");
        fileName = path.getFileName();
        if (fileName != null) {
            str = fileName.toString();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String getNameWithoutExtension(@NotNull Path path) {
        Path fileName;
        String obj;
        String substringBeforeLast$default;
        Intrinsics.checkNotNullParameter(path, "<this>");
        fileName = path.getFileName();
        if (fileName == null || (obj = fileName.toString()) == null || (substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(obj, ".", (String) null, 2, (Object) null)) == null) {
            return "";
        }
        return substringBeforeLast$default;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final List<Path> listDirectoryEntries(@NotNull Path path, @NotNull String glob) {
        DirectoryStream newDirectoryStream;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream it = o81.m6504i(newDirectoryStream);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            List<Path> list = CollectionsKt___CollectionsKt.toList(it);
            CloseableKt.closeFinally(newDirectoryStream, null);
            return list;
        } finally {
        }
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "*";
        }
        return listDirectoryEntries(path, str);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final Path relativeTo(@NotNull Path path, @NotNull Path base) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return m32.m6045a(path, base);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @Nullable
    public static final Path relativeToOrNull(@NotNull Path path, @NotNull Path base) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return m32.m6045a(path, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @NotNull
    public static final Path relativeToOrSelf(@NotNull Path path, @NotNull Path base) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        Path relativeToOrNull = relativeToOrNull(path, base);
        if (relativeToOrNull != null) {
            return relativeToOrNull;
        }
        return path;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(@NotNull Path path, @NotNull FileVisitor<Path> visitor, int i, boolean z) {
        Set emptySet;
        FileVisitOption fileVisitOption;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (z) {
            fileVisitOption = FileVisitOption.FOLLOW_LINKS;
            emptySet = rh2.setOf(fileVisitOption);
        } else {
            emptySet = sh2.emptySet();
        }
        Files.walkFileTree(path, emptySet, i, visitor);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, FileVisitor fileVisitor, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        visitFileTree(path, (FileVisitor<Path>) fileVisitor, i, z);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    @NotNull
    public static final Sequence<Path> walk(@NotNull Path path, @NotNull PathWalkOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return new PathTreeWalk(path, options);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        visitFileTree(path, i, z, (Function1<? super FileVisitorBuilder, Unit>) function1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(@NotNull Path path, int i, boolean z, @NotNull Function1<? super FileVisitorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        visitFileTree(path, fileVisitor(builderAction), i, z);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getName$annotations(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    public static /* synthetic */ void getPathString$annotations(Path path) {
    }
}
