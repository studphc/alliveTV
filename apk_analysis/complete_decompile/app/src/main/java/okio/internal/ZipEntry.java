package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0005\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u000f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010 R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, m5569d2 = {"Lokio/internal/ZipEntry;", "", "Lokio/Path;", "canonicalPath", "", "isDirectory", "", "comment", "", "crc", "compressedSize", "size", "", "compressionMethod", "lastModifiedAtMillis", TypedValues.CycleType.S_WAVE_OFFSET, "<init>", "(Lokio/Path;ZLjava/lang/String;JJJILjava/lang/Long;J)V", "a", "Lokio/Path;", "getCanonicalPath", "()Lokio/Path;", "b", "Z", "()Z", "c", "Ljava/lang/String;", "getComment", "()Ljava/lang/String;", "d", "J", "getCrc", "()J", "e", "getCompressedSize", "f", "getSize", "g", "I", "getCompressionMethod", "()I", "h", "Ljava/lang/Long;", "getLastModifiedAtMillis", "()Ljava/lang/Long;", "i", "getOffset", "", "j", "Ljava/util/List;", "getChildren", "()Ljava/util/List;", "children", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ZipEntry {

    /* renamed from: a, reason: from kotlin metadata */
    public final Path canonicalPath;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean isDirectory;

    /* renamed from: c, reason: from kotlin metadata */
    public final String comment;

    /* renamed from: d, reason: from kotlin metadata */
    public final long crc;

    /* renamed from: e, reason: from kotlin metadata */
    public final long compressedSize;

    /* renamed from: f, reason: from kotlin metadata */
    public final long size;

    /* renamed from: g, reason: from kotlin metadata */
    public final int compressionMethod;

    /* renamed from: h, reason: from kotlin metadata */
    public final Long lastModifiedAtMillis;

    /* renamed from: i, reason: from kotlin metadata */
    public final long offset;

    /* renamed from: j */
    public final ArrayList f24791j;

    public ZipEntry(@NotNull Path canonicalPath, boolean z, @NotNull String comment, long j, long j2, long j3, int i, @Nullable Long l, long j4) {
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.canonicalPath = canonicalPath;
        this.isDirectory = z;
        this.comment = comment;
        this.crc = j;
        this.compressedSize = j2;
        this.size = j3;
        this.compressionMethod = i;
        this.lastModifiedAtMillis = l;
        this.offset = j4;
        this.f24791j = new ArrayList();
    }

    @NotNull
    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    @NotNull
    public final List<Path> getChildren() {
        return this.f24791j;
    }

    @NotNull
    public final String getComment() {
        return this.comment;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getCrc() {
        return this.crc;
    }

    @Nullable
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    /* renamed from: isDirectory, reason: from getter */
    public final boolean getIsDirectory() {
        return this.isDirectory;
    }

    public /* synthetic */ ZipEntry(Path path, boolean z, String str, long j, long j2, long j3, int i, Long l, long j4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? -1L : j, (i2 & 16) != 0 ? -1L : j2, (i2 & 32) != 0 ? -1L : j3, (i2 & 64) != 0 ? -1 : i, (i2 & 128) != 0 ? null : l, (i2 & 256) == 0 ? j4 : -1L);
    }
}
