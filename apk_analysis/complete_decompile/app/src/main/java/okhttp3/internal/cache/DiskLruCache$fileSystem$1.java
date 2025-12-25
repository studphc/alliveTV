package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ForwardingFileSystem;
import okio.Path;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m5569d2 = {"okhttp3/internal/cache/DiskLruCache$fileSystem$1", "Lokio/ForwardingFileSystem;", "sink", "Lokio/Sink;", "file", "Lokio/Path;", "mustCreate", "", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DiskLruCache$fileSystem$1 extends ForwardingFileSystem {
    @Override // okio.ForwardingFileSystem, okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(file, "file");
        Path parent = file.parent();
        if (parent != null) {
            createDirectories(parent);
        }
        return super.sink(file, mustCreate);
    }
}
