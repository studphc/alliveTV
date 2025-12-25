package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ha0;

@Metadata(m5568d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b&\u0010%J\u001f\u0010(\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020'2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020'2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b-\u0010)J\u001f\u0010.\u001a\u00020'2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010,¨\u0006/"}, m5569d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "zipPath", "fileSystem", "", "Lokio/internal/ZipEntry;", "entries", "", "comment", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "path", "canonicalize", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "dir", "", "list", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "Lokio/Source;", FirebaseAnalytics.Param.SOURCE, "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", "", "createDirectory", "(Lokio/Path;Z)V", TypedValues.AttributesType.S_TARGET, "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "createSymlink", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ZipFileSystem extends FileSystem {

    /* renamed from: d */
    public static final Path f24768d = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null);

    /* renamed from: a */
    public final Path f24769a;

    /* renamed from: b */
    public final FileSystem f24770b;

    /* renamed from: c */
    public final Map f24771c;

    public ZipFileSystem(@NotNull Path zipPath, @NotNull FileSystem fileSystem, @NotNull Map<Path, ZipEntry> entries, @Nullable String str) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.f24769a = zipPath;
        this.f24770b = fileSystem;
        this.f24771c = entries;
    }

    /* renamed from: a */
    public final List m6672a(Path path, boolean z) {
        ZipEntry zipEntry = (ZipEntry) this.f24771c.get(f24768d.resolve(path, true));
        if (zipEntry == null) {
            if (!z) {
                return null;
            }
            throw new IOException("not a directory: " + path);
        }
        return CollectionsKt___CollectionsKt.toList(zipEntry.getChildren());
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path resolve = f24768d.resolve(path, true);
        if (this.f24771c.containsKey(resolve)) {
            return resolve;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<Path> m6672a = m6672a(dir, true);
        Intrinsics.checkNotNull(m6672a);
        return m6672a;
    }

    @Override // okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return m6672a(dir, false);
    }

    @Override // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Long valueOf;
        BufferedSource bufferedSource;
        Intrinsics.checkNotNullParameter(path, "path");
        ZipEntry zipEntry = (ZipEntry) this.f24771c.get(f24768d.resolve(path, true));
        Throwable th = null;
        if (zipEntry == null) {
            return null;
        }
        boolean z = !zipEntry.getIsDirectory();
        boolean isDirectory = zipEntry.getIsDirectory();
        if (zipEntry.getIsDirectory()) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(zipEntry.getSize());
        }
        FileMetadata fileMetadata = new FileMetadata(z, isDirectory, null, valueOf, null, zipEntry.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry.getAndroidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String() == -1) {
            return fileMetadata;
        }
        FileHandle openReadOnly = this.f24770b.openReadOnly(this.f24769a);
        try {
            bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getAndroidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String()));
        } catch (Throwable th2) {
            bufferedSource = null;
            th = th2;
        }
        if (openReadOnly != null) {
            try {
                openReadOnly.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ha0.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(bufferedSource);
            return ZipKt.readLocalHeader(bufferedSource, fileMetadata);
        }
        throw th;
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) {
        BufferedSource bufferedSource;
        Intrinsics.checkNotNullParameter(file, "file");
        ZipEntry zipEntry = (ZipEntry) this.f24771c.get(f24768d.resolve(file, true));
        if (zipEntry != null) {
            FileHandle openReadOnly = this.f24770b.openReadOnly(this.f24769a);
            Throwable th = null;
            try {
                bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getAndroidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String()));
            } catch (Throwable th2) {
                bufferedSource = null;
                th = th2;
            }
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ha0.addSuppressed(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(bufferedSource);
                ZipKt.skipLocalHeader(bufferedSource);
                if (zipEntry.getCompressionMethod() == 0) {
                    return new FixedLengthSource(bufferedSource, zipEntry.getSize(), true);
                }
                return new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSource, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
            }
            throw th;
        }
        throw new FileNotFoundException("no such file: " + file);
    }
}
