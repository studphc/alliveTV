package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0010R\u0011\u0010#\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015R\u0011\u0010$\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010'\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b&\u0010\u0017¨\u0006("}, m5569d2 = {"Lkotlin/io/FilePathComponents;", "", "Ljava/io/File;", "root", "", "segments", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "", "beginIndex", "endIndex", "subPath", "(II)Ljava/io/File;", "component1", "()Ljava/io/File;", "component2", "()Ljava/util/List;", "copy", "(Ljava/io/File;Ljava/util/List;)Lkotlin/io/FilePathComponents;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/io/File;", "getRoot", "b", "Ljava/util/List;", "getSegments", "getRootName", "rootName", "isRooted", "()Z", "getSize", "size", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FilePathComponents {

    /* renamed from: a, reason: from kotlin metadata */
    public final File root;

    /* renamed from: b, reason: from kotlin metadata */
    public final List segments;

    public FilePathComponents(@NotNull File root, @NotNull List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        this.root = root;
        this.segments = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents filePathComponents, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = filePathComponents.root;
        }
        if ((i & 2) != 0) {
            list = filePathComponents.segments;
        }
        return filePathComponents.copy(file, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final File getRoot() {
        return this.root;
    }

    @NotNull
    public final List<File> component2() {
        return this.segments;
    }

    @NotNull
    public final FilePathComponents copy(@NotNull File root, @NotNull List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        return new FilePathComponents(root, segments);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) other;
        return Intrinsics.areEqual(this.root, filePathComponents.root) && Intrinsics.areEqual(this.segments, filePathComponents.segments);
    }

    @NotNull
    public final File getRoot() {
        return this.root;
    }

    @NotNull
    public final String getRootName() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path;
    }

    @NotNull
    public final List<File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        return this.segments.hashCode() + (this.root.hashCode() * 31);
    }

    public final boolean isRooted() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        if (path.length() > 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final File subPath(int beginIndex, int endIndex) {
        if (beginIndex >= 0 && beginIndex <= endIndex && endIndex <= getSize()) {
            List subList = this.segments.subList(beginIndex, endIndex);
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            return new File(CollectionsKt___CollectionsKt.joinToString$default(subList, separator, null, null, 0, null, null, 62, null));
        }
        throw new IllegalArgumentException();
    }

    @NotNull
    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
