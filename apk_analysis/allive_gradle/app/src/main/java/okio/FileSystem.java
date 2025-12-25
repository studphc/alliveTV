package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ha0;

@Metadata(m5568d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J:\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u0006H&JD\u0010/\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\u0087\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, m5569d2 = {"Lokio/FileSystem;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", FirebaseAnalytics.Param.SOURCE, TypedValues.AttributesType.S_TARGET, "canonicalize", "path", "copy", "createDirectories", "dir", "mustCreate", "createDirectory", "createSymlink", "delete", "deleteRecursively", "fileOrDirectory", "exists", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "read", ExifInterface.GPS_DIRECTION_TRUE, "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Source;", "write", "writerAction", "Lokio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public abstract class FileSystem {

    @JvmField
    @NotNull
    public static final FileSystem RESOURCES;

    @JvmField
    @NotNull
    public static final FileSystem SYSTEM;

    @JvmField
    @NotNull
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m9068write$default(FileSystem fileSystem, Path file, boolean z, Function1 writerAction, int i, Object obj) {
        Object obj2;
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(writerAction, "writerAction");
            BufferedSink buffer = Okio.buffer(fileSystem.sink(file, z));
            Throwable th = null;
            try {
                obj2 = writerAction.invoke(buffer);
            } catch (Throwable th2) {
                obj2 = null;
                th = th2;
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ha0.addSuppressed(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(obj2);
                return obj2;
            }
            throw th;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.INSTANCE;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "ResourceFileSystem::class.java.classLoader");
        RESOURCES = new ResourceFileSystem(classLoader, false);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.appendingSink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.createDirectories(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.createDirectory(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.delete(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.deleteRecursively(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    public static /* synthetic */ Sequence listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.listRecursively(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return fileSystem.openReadWrite(path, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.sink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    @JvmName(name = "-read")
    /* renamed from: -read, reason: not valid java name */
    public final <T> T m9069read(@NotNull Path file, @NotNull Function1<? super BufferedSource, ? extends T> readerAction) {
        T t;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(readerAction, "readerAction");
        BufferedSource buffer = Okio.buffer(source(file));
        Throwable th = null;
        try {
            t = readerAction.invoke(buffer);
        } catch (Throwable th2) {
            th = th2;
            t = null;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ha0.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(t);
            return t;
        }
        throw th;
    }

    @JvmName(name = "-write")
    /* renamed from: -write, reason: not valid java name */
    public final <T> T m9070write(@NotNull Path file, boolean mustCreate, @NotNull Function1<? super BufferedSink, ? extends T> writerAction) {
        T t;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(writerAction, "writerAction");
        BufferedSink buffer = Okio.buffer(sink(file, mustCreate));
        Throwable th = null;
        try {
            t = writerAction.invoke(buffer);
        } catch (Throwable th2) {
            t = null;
            th = th2;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ha0.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(t);
            return t;
        }
        throw th;
    }

    @NotNull
    public final Sink appendingSink(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return appendingSink(file, false);
    }

    @NotNull
    public abstract Sink appendingSink(@NotNull Path file, boolean mustExist);

    public abstract void atomicMove(@NotNull Path source, @NotNull Path target);

    @NotNull
    public abstract Path canonicalize(@NotNull Path path);

    public void copy(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        _FileSystemKt.commonCopy(this, source, target);
    }

    public final void createDirectories(@NotNull Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        _FileSystemKt.commonCreateDirectories(this, dir, mustCreate);
    }

    public final void createDirectory(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(@NotNull Path dir, boolean mustCreate);

    public abstract void createSymlink(@NotNull Path source, @NotNull Path target);

    public final void delete(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        delete(path, false);
    }

    public abstract void delete(@NotNull Path path, boolean mustExist);

    public void deleteRecursively(@NotNull Path fileOrDirectory, boolean mustExist) {
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        _FileSystemKt.commonDeleteRecursively(this, fileOrDirectory, mustExist);
    }

    public final boolean exists(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return _FileSystemKt.commonExists(this, path);
    }

    @NotNull
    public abstract List<Path> list(@NotNull Path dir);

    @Nullable
    public abstract List<Path> listOrNull(@NotNull Path dir);

    @NotNull
    public Sequence<Path> listRecursively(@NotNull Path dir, boolean followSymlinks) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return _FileSystemKt.commonListRecursively(this, dir, followSymlinks);
    }

    @NotNull
    public final FileMetadata metadata(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return _FileSystemKt.commonMetadata(this, path);
    }

    @Nullable
    public abstract FileMetadata metadataOrNull(@NotNull Path path);

    @NotNull
    public abstract FileHandle openReadOnly(@NotNull Path file);

    @NotNull
    public final FileHandle openReadWrite(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return openReadWrite(file, false, false);
    }

    @NotNull
    public abstract FileHandle openReadWrite(@NotNull Path file, boolean mustCreate, boolean mustExist);

    @NotNull
    public final Sink sink(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return sink(file, false);
    }

    @NotNull
    public abstract Sink sink(@NotNull Path file, boolean mustCreate);

    @NotNull
    public abstract Source source(@NotNull Path file);

    public final void createDirectories(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectories(dir, false);
    }

    public final void deleteRecursively(@NotNull Path fileOrDirectory) {
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    @NotNull
    public final Sequence<Path> listRecursively(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return listRecursively(dir, false);
    }
}
