package okio.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1204fq;
import p000.AbstractC1327iq;
import p000.AbstractC1726qj;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u001a\u0016\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b\b\u0010\u0006\u001a\u0014\u0010\n\u001a\u00020\t*\u00020\u0000H\u0080\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u0000H\u0080\b¢\u0006\u0004\b\f\u0010\u000b\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0007*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0014\u0010\u0002\u001a\u0014\u0010\u0015\u001a\u00020\t*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0015\u0010\u000b\u001a$\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\u0018\u0010\u001a\u001a$\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\u0018\u0010\u001c\u001a#\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0018\u0010\u001d\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b!\u0010\u0002\u001a\u001c\u0010#\u001a\u00020\"*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010&\u001a\u00020\t*\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010%H\u0080\b¢\u0006\u0004\b&\u0010'\u001a\u0014\u0010(\u001a\u00020\"*\u00020\u0000H\u0080\b¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010*\u001a\u00020\u0004*\u00020\u0000H\u0080\b¢\u0006\u0004\b*\u0010\u0013\u001a\u001b\u0010+\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b+\u0010,\u001a\u001b\u0010-\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b-\u0010.¨\u0006/"}, m5569d2 = {"Lokio/Path;", "commonRoot", "(Lokio/Path;)Lokio/Path;", "", "", "commonSegments", "(Lokio/Path;)Ljava/util/List;", "Lokio/ByteString;", "commonSegmentsBytes", "", "commonIsAbsolute", "(Lokio/Path;)Z", "commonIsRelative", "", "commonVolumeLetter", "(Lokio/Path;)Ljava/lang/Character;", "commonNameBytes", "(Lokio/Path;)Lokio/ByteString;", "commonName", "(Lokio/Path;)Ljava/lang/String;", "commonParent", "commonIsRoot", "child", "normalize", "commonResolve", "(Lokio/Path;Ljava/lang/String;Z)Lokio/Path;", "(Lokio/Path;Lokio/ByteString;Z)Lokio/Path;", "Lokio/Buffer;", "(Lokio/Path;Lokio/Buffer;Z)Lokio/Path;", "(Lokio/Path;Lokio/Path;Z)Lokio/Path;", "other", "commonRelativeTo", "(Lokio/Path;Lokio/Path;)Lokio/Path;", "commonNormalized", "", "commonCompareTo", "(Lokio/Path;Lokio/Path;)I", "", "commonEquals", "(Lokio/Path;Ljava/lang/Object;)Z", "commonHashCode", "(Lokio/Path;)I", "commonToString", "commonToPath", "(Ljava/lang/String;Z)Lokio/Path;", "toPath", "(Lokio/Buffer;Z)Lokio/Path;", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _PathKt {

    /* renamed from: a */
    public static final ByteString f24794a;

    /* renamed from: b */
    public static final ByteString f24795b;

    /* renamed from: c */
    public static final ByteString f24796c;

    /* renamed from: d */
    public static final ByteString f24797d;

    /* renamed from: e */
    public static final ByteString f24798e;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f24794a = companion.encodeUtf8("/");
        f24795b = companion.encodeUtf8("\\");
        f24796c = companion.encodeUtf8("/\\");
        f24797d = companion.encodeUtf8(".");
        f24798e = companion.encodeUtf8("..");
    }

    /* renamed from: a */
    public static final ByteString m6679a(Path path) {
        ByteString bytes = path.getBytes();
        ByteString byteString = f24794a;
        if (ByteString.indexOf$default(bytes, byteString, 0, 2, (Object) null) == -1) {
            ByteString bytes2 = path.getBytes();
            ByteString byteString2 = f24795b;
            if (ByteString.indexOf$default(bytes2, byteString2, 0, 2, (Object) null) == -1) {
                return null;
            }
            return byteString2;
        }
        return byteString;
    }

    public static final int access$getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes(), f24794a, 0, 2, (Object) null);
        if (lastIndexOf$default == -1) {
            return ByteString.lastIndexOf$default(path.getBytes(), f24795b, 0, 2, (Object) null);
        }
        return lastIndexOf$default;
    }

    public static final boolean access$lastSegmentIsDotDot(Path path) {
        if (!path.getBytes().endsWith(f24798e)) {
            return false;
        }
        if (path.getBytes().size() != 2 && !path.getBytes().rangeEquals(path.getBytes().size() - 3, f24794a, 0, 1) && !path.getBytes().rangeEquals(path.getBytes().size() - 3, f24795b, 0, 1)) {
            return false;
        }
        return true;
    }

    public static final int access$rootLength(Path path) {
        if (path.getBytes().size() == 0) {
            return -1;
        }
        if (path.getBytes().getByte(0) != ((byte) 47)) {
            byte b = (byte) 92;
            if (path.getBytes().getByte(0) == b) {
                if (path.getBytes().size() > 2 && path.getBytes().getByte(1) == b) {
                    int indexOf = path.getBytes().indexOf(f24795b, 2);
                    if (indexOf == -1) {
                        return path.getBytes().size();
                    }
                    return indexOf;
                }
            } else {
                if (path.getBytes().size() <= 2 || path.getBytes().getByte(1) != ((byte) 58) || path.getBytes().getByte(2) != b) {
                    return -1;
                }
                char c = (char) path.getBytes().getByte(0);
                if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
                    return -1;
                }
                return 3;
            }
        }
        return 1;
    }

    /* renamed from: b */
    public static final ByteString m6680b(byte b) {
        if (b == 47) {
            return f24794a;
        }
        if (b == 92) {
            return f24795b;
        }
        throw new IllegalArgumentException(ye0.m8291k(b, "not a directory separator: "));
    }

    /* renamed from: c */
    public static final ByteString m6681c(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return f24794a;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return f24795b;
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("not a directory separator: ", str));
    }

    public static final int commonCompareTo(@NotNull Path path, @NotNull Path other) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return path.getBytes().compareTo(other.getBytes());
    }

    public static final boolean commonEquals(@NotNull Path path, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if ((obj instanceof Path) && Intrinsics.areEqual(((Path) obj).getBytes(), path.getBytes())) {
            return true;
        }
        return false;
    }

    public static final int commonHashCode(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes().hashCode();
    }

    public static final boolean commonIsAbsolute(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (access$rootLength(path) != -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRelative(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (access$rootLength(path) == -1) {
            return true;
        }
        return false;
    }

    public static final boolean commonIsRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (access$rootLength(path) == path.getBytes().size()) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String commonName(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.nameBytes().utf8();
    }

    @NotNull
    public static final ByteString commonNameBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int access$getIndexOfLastSlash = access$getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(path.getBytes(), access$getIndexOfLastSlash + 1, 0, 2, null);
        }
        if (path.volumeLetter() != null && path.getBytes().size() == 2) {
            return ByteString.EMPTY;
        }
        return path.getBytes();
    }

    @NotNull
    public static final Path commonNormalized(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Path.INSTANCE.get(path.toString(), true);
    }

    @Nullable
    public static final Path commonParent(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (Intrinsics.areEqual(path.getBytes(), f24797d) || Intrinsics.areEqual(path.getBytes(), f24794a) || Intrinsics.areEqual(path.getBytes(), f24795b) || access$lastSegmentIsDotDot(path)) {
            return null;
        }
        int access$getIndexOfLastSlash = access$getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash == 2 && path.volumeLetter() != null) {
            if (path.getBytes().size() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(path.getBytes(), 0, 3, 1, null));
        }
        if (access$getIndexOfLastSlash == 1 && path.getBytes().startsWith(f24795b)) {
            return null;
        }
        if (access$getIndexOfLastSlash == -1 && path.volumeLetter() != null) {
            if (path.getBytes().size() == 2) {
                return null;
            }
            return new Path(ByteString.substring$default(path.getBytes(), 0, 2, 1, null));
        }
        if (access$getIndexOfLastSlash == -1) {
            return new Path(f24797d);
        }
        if (access$getIndexOfLastSlash == 0) {
            return new Path(ByteString.substring$default(path.getBytes(), 0, 1, 1, null));
        }
        return new Path(ByteString.substring$default(path.getBytes(), 0, access$getIndexOfLastSlash, 1, null));
    }

    @NotNull
    public static final Path commonRelativeTo(@NotNull Path path, @NotNull Path other) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(path.getRoot(), other.getRoot())) {
            List<ByteString> segmentsBytes = path.getSegmentsBytes();
            List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i = 0;
            while (i < min && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
                i++;
            }
            if (i == min && path.getBytes().size() == other.getBytes().size()) {
                return Path.Companion.get$default(Path.INSTANCE, ".", false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(f24798e) == -1) {
                Buffer buffer = new Buffer();
                ByteString m6679a = m6679a(other);
                if (m6679a == null && (m6679a = m6679a(path)) == null) {
                    m6679a = m6681c(Path.DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i2 = i; i2 < size; i2++) {
                    buffer.write(f24798e);
                    buffer.write(m6679a);
                }
                int size2 = segmentsBytes.size();
                while (i < size2) {
                    buffer.write(segmentsBytes.get(i));
                    buffer.write(m6679a);
                    i++;
                }
                return toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + other).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + other).toString());
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull String child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(child), false), z);
    }

    @Nullable
    public static final Path commonRoot(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int access$rootLength = access$rootLength(path);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(path.getBytes().substring(0, access$rootLength));
    }

    @NotNull
    public static final List<String> commonSegments(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int access$rootLength = access$rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes().size() && path.getBytes().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = path.getBytes().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (path.getBytes().getByte(access$rootLength) == ((byte) 47) || path.getBytes().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(path.getBytes().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < path.getBytes().size()) {
            arrayList.add(path.getBytes().substring(i, path.getBytes().size()));
        }
        ArrayList arrayList2 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @NotNull
    public static final List<ByteString> commonSegmentsBytes(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int access$rootLength = access$rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes().size() && path.getBytes().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = path.getBytes().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (path.getBytes().getByte(access$rootLength) == ((byte) 47) || path.getBytes().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(path.getBytes().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < path.getBytes().size()) {
            arrayList.add(path.getBytes().substring(i, path.getBytes().size()));
        }
        return arrayList;
    }

    @NotNull
    public static final Path commonToPath(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z);
    }

    @NotNull
    public static final String commonToString(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes().utf8();
    }

    @Nullable
    public static final Character commonVolumeLetter(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (ByteString.indexOf$default(path.getBytes(), f24794a, 0, 2, (Object) null) != -1 || path.getBytes().size() < 2 || path.getBytes().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c = (char) path.getBytes().getByte(0);
        if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
            return null;
        }
        return Character.valueOf(c);
    }

    @NotNull
    public static final Path toPath(@NotNull Buffer buffer, boolean z) {
        ByteString byteString;
        boolean z2;
        char c;
        boolean z3;
        ByteString byteString2;
        ByteString readByteString;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteString3 = null;
        int i = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, f24794a)) {
                byteString = f24795b;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString3 == null) {
                byteString3 = m6680b(readByte);
            }
            i++;
        }
        if (i >= 2 && Intrinsics.areEqual(byteString3, byteString)) {
            z2 = true;
        } else {
            z2 = false;
        }
        ByteString byteString4 = f24796c;
        if (z2) {
            Intrinsics.checkNotNull(byteString3);
            buffer2.write(byteString3);
            buffer2.write(byteString3);
        } else if (i > 0) {
            Intrinsics.checkNotNull(byteString3);
            buffer2.write(byteString3);
        } else {
            long indexOfElement = buffer.indexOfElement(byteString4);
            if (byteString3 == null) {
                if (indexOfElement == -1) {
                    byteString3 = m6681c(Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString3 = m6680b(buffer.getByte(indexOfElement));
                }
            }
            if (Intrinsics.areEqual(byteString3, byteString) && buffer.size() >= 2 && buffer.getByte(1L) == ((byte) 58) && (('a' <= (c = (char) buffer.getByte(0L)) && c < '{') || ('A' <= c && c < '['))) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
        }
        if (buffer2.size() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            boolean exhausted = buffer.exhausted();
            byteString2 = f24797d;
            if (exhausted) {
                break;
            }
            long indexOfElement2 = buffer.indexOfElement(byteString4);
            if (indexOfElement2 == -1) {
                readByteString = buffer.readByteString();
            } else {
                readByteString = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString5 = f24798e;
            if (Intrinsics.areEqual(readByteString, byteString5)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (z && (z3 || (!arrayList.isEmpty() && !Intrinsics.areEqual(CollectionsKt___CollectionsKt.last((List) arrayList), byteString5)))) {
                        if (z2 && arrayList.size() == 1) {
                        }
                        AbstractC1327iq.removeLastOrNull(arrayList);
                    } else {
                        arrayList.add(readByteString);
                    }
                }
            } else if (!Intrinsics.areEqual(readByteString, byteString2) && !Intrinsics.areEqual(readByteString, ByteString.EMPTY)) {
                arrayList.add(readByteString);
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                buffer2.write(byteString3);
            }
            buffer2.write((ByteString) arrayList.get(i2));
        }
        if (buffer2.size() == 0) {
            buffer2.write(byteString2);
        }
        return new Path(buffer2.readByteString());
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull ByteString child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(new Buffer().write(child), false), z);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Buffer child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(child, false), z);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path, @NotNull Path child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString m6679a = m6679a(path);
        if (m6679a == null && (m6679a = m6679a(child)) == null) {
            m6679a = m6681c(Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes());
        if (buffer.size() > 0) {
            buffer.write(m6679a);
        }
        buffer.write(child.getBytes());
        return toPath(buffer, z);
    }
}
