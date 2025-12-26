package okio;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1204fq;

@Metadata(m5568d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\b\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001<B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002H\u0087\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001fH\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0013\u0010+\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b*\u0010\u0015R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0011\u00102\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b4\u00103R\u0013\u00106\u001a\u0004\u0018\u0001058G¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b8\u0010)R\u0011\u00109\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b9\u0010%R\u0013\u0010:\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b:\u0010\u0015R\u0011\u0010;\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b;\u00103¨\u0006="}, m5569d2 = {"Lokio/Path;", "", "Lokio/ByteString;", "bytes", "<init>", "(Lokio/ByteString;)V", "", "child", "resolve", "(Ljava/lang/String;)Lokio/Path;", "div", "(Lokio/ByteString;)Lokio/Path;", "(Lokio/Path;)Lokio/Path;", "", "normalize", "(Ljava/lang/String;Z)Lokio/Path;", "(Lokio/ByteString;Z)Lokio/Path;", "(Lokio/Path;Z)Lokio/Path;", "other", "relativeTo", "normalized", "()Lokio/Path;", "Ljava/io/File;", "toFile", "()Ljava/io/File;", "Ljava/nio/file/Path;", "toNioPath", "()Ljava/nio/file/Path;", "", "compareTo", "(Lokio/Path;)I", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Lokio/ByteString;", "getBytes$okio", "()Lokio/ByteString;", "getRoot", "root", "", "getSegments", "()Ljava/util/List;", "segments", "getSegmentsBytes", "segmentsBytes", "isAbsolute", "()Z", "isRelative", "", "volumeLetter", "()Ljava/lang/Character;", "nameBytes", AppMeasurementSdk.ConditionalUserProperty.NAME, "parent", "isRoot", "Companion", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Path implements Comparable<Path> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final String DIRECTORY_SEPARATOR;

    /* renamed from: a, reason: from kotlin metadata */
    public final ByteString bytes;

    @Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001d\u0010\b\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u0005*\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u0005*\u00020\f2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Lokio/Path$Companion;", "", "", "", "normalize", "Lokio/Path;", "get", "(Ljava/lang/String;Z)Lokio/Path;", "toPath", "Ljava/io/File;", "(Ljava/io/File;Z)Lokio/Path;", "toOkioPath", "Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Z)Lokio/Path;", "DIRECTORY_SEPARATOR", "Ljava/lang/String;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(str, z);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(file, z);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(path, z);
        }

        @JvmStatic
        @JvmName(name = "get")
        @IgnoreJRERequirement
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return _PathKt.commonToPath(str, z);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File file, boolean z) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String file2 = file.toString();
            Intrinsics.checkNotNullExpressionValue(file2, "toString()");
            return get(file2, z);
        }

        @JvmStatic
        @JvmName(name = "get")
        @IgnoreJRERequirement
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path path, boolean z) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get(path.toString(), z);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File file) {
        return INSTANCE.get(file);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(str, z);
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof Path) && Intrinsics.areEqual(((Path) other).getBytes(), getBytes())) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: getBytes$okio, reason: from getter */
    public final ByteString getBytes() {
        return this.bytes;
    }

    @Nullable
    public final Path getRoot() {
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(getBytes().substring(0, access$rootLength));
    }

    @NotNull
    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes().size() && getBytes().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes().getByte(access$rootLength) == ((byte) 47) || getBytes().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(getBytes().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < getBytes().size()) {
            arrayList.add(getBytes().substring(i, getBytes().size()));
        }
        ArrayList arrayList2 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @NotNull
    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes().size() && getBytes().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (getBytes().getByte(access$rootLength) == ((byte) 47) || getBytes().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(getBytes().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < getBytes().size()) {
            arrayList.add(getBytes().substring(i, getBytes().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes().hashCode();
    }

    public final boolean isAbsolute() {
        if (_PathKt.access$rootLength(this) != -1) {
            return true;
        }
        return false;
    }

    public final boolean isRelative() {
        if (_PathKt.access$rootLength(this) == -1) {
            return true;
        }
        return false;
    }

    public final boolean isRoot() {
        if (_PathKt.access$rootLength(this) == getBytes().size()) {
            return true;
        }
        return false;
    }

    @JvmName(name = AppMeasurementSdk.ConditionalUserProperty.NAME)
    @NotNull
    public final String name() {
        return nameBytes().utf8();
    }

    @JvmName(name = "nameBytes")
    @NotNull
    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes(), access$getIndexOfLastSlash + 1, 0, 2, null);
        }
        if (volumeLetter() != null && getBytes().size() == 2) {
            return ByteString.EMPTY;
        }
        return getBytes();
    }

    @NotNull
    public final Path normalized() {
        return INSTANCE.get(toString(), true);
    }

    @JvmName(name = "parent")
    @Nullable
    public final Path parent() {
        Path path;
        if (Intrinsics.areEqual(getBytes(), _PathKt.f24797d) || Intrinsics.areEqual(getBytes(), _PathKt.f24794a) || Intrinsics.areEqual(getBytes(), _PathKt.f24795b) || _PathKt.access$lastSegmentIsDotDot(this)) {
            return null;
        }
        int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash == 2 && volumeLetter() != null) {
            if (getBytes().size() == 3) {
                return null;
            }
            path = new Path(ByteString.substring$default(getBytes(), 0, 3, 1, null));
        } else {
            if (access$getIndexOfLastSlash == 1 && getBytes().startsWith(_PathKt.f24795b)) {
                return null;
            }
            if (access$getIndexOfLastSlash == -1 && volumeLetter() != null) {
                if (getBytes().size() == 2) {
                    return null;
                }
                path = new Path(ByteString.substring$default(getBytes(), 0, 2, 1, null));
            } else {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(_PathKt.f24797d);
                }
                if (access$getIndexOfLastSlash == 0) {
                    path = new Path(ByteString.substring$default(getBytes(), 0, 1, 1, null));
                } else {
                    return new Path(ByteString.substring$default(getBytes(), 0, access$getIndexOfLastSlash, 1, null));
                }
            }
        }
        return path;
    }

    @NotNull
    public final Path relativeTo(@NotNull Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(getRoot(), other.getRoot())) {
            List<ByteString> segmentsBytes = getSegmentsBytes();
            List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i = 0;
            while (i < min && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
                i++;
            }
            if (i == min && getBytes().size() == other.getBytes().size()) {
                return Companion.get$default(INSTANCE, ".", false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(_PathKt.f24798e) == -1) {
                Buffer buffer = new Buffer();
                ByteString m6679a = _PathKt.m6679a(other);
                if (m6679a == null && (m6679a = _PathKt.m6679a(this)) == null) {
                    m6679a = _PathKt.m6681c(DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i2 = i; i2 < size; i2++) {
                    buffer.write(_PathKt.f24798e);
                    buffer.write(m6679a);
                }
                int size2 = segmentsBytes.size();
                while (i < size2) {
                    buffer.write(segmentsBytes.get(i));
                    buffer.write(m6679a);
                    i++;
                }
                return _PathKt.toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, false);
    }

    @NotNull
    public final File toFile() {
        return new File(toString());
    }

    @IgnoreJRERequirement
    @NotNull
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path;
        path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(toString())");
        return path;
    }

    @NotNull
    public String toString() {
        return getBytes().utf8();
    }

    @JvmName(name = "volumeLetter")
    @Nullable
    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes(), _PathKt.f24794a, 0, 2, (Object) null) != -1 || getBytes().size() < 2 || getBytes().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c = (char) getBytes().getByte(0);
        if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
            return null;
        }
        return Character.valueOf(c);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File file, boolean z) {
        return INSTANCE.get(file, z);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(byteString, z);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBytes().compareTo(other.getBytes());
    }

    @NotNull
    public final Path resolve(@NotNull Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, normalize);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(path2, z);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), false);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String str, boolean z) {
        return INSTANCE.get(str, z);
    }

    @JvmStatic
    @JvmName(name = "get")
    @IgnoreJRERequirement
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path path) {
        return INSTANCE.get(path);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull ByteString child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), false);
    }

    @JvmStatic
    @JvmName(name = "get")
    @IgnoreJRERequirement
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path path, boolean z) {
        return INSTANCE.get(path, z);
    }

    @NotNull
    public final Path resolve(@NotNull String child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), normalize);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), normalize);
    }
}
