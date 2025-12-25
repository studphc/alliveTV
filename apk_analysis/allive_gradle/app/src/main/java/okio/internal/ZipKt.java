package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1326ip;
import p000.AbstractC1919vr;
import p000.C1223g8;
import p000.lh1;
import p000.m63;
import p000.n63;
import p000.ro2;
import p000.v90;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a5\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\u0005*\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0013\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00158\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0018\u001a\u00020\u00158\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, m5569d2 = {"Lokio/Path;", "zipPath", "Lokio/FileSystem;", "fileSystem", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", "", "predicate", "Lokio/ZipFileSystem;", "openZip", "(Lokio/Path;Lokio/FileSystem;Lkotlin/jvm/functions/Function1;)Lokio/ZipFileSystem;", "Lokio/BufferedSource;", "readEntry", "(Lokio/BufferedSource;)Lokio/internal/ZipEntry;", "", "skipLocalHeader", "(Lokio/BufferedSource;)V", "Lokio/FileMetadata;", "basicMetadata", "readLocalHeader", "(Lokio/BufferedSource;Lokio/FileMetadata;)Lokio/FileMetadata;", "", "COMPRESSION_METHOD_DEFLATED", "I", "COMPRESSION_METHOD_STORED", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ZipKt {
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;

    /* renamed from: a */
    public static final Map m6675a(ArrayList arrayList) {
        Path path = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null);
        Map mutableMapOf = lh1.mutableMapOf(TuplesKt.m5575to(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (ZipEntry zipEntry : CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: okio.internal.ZipKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return AbstractC1919vr.compareValues(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            if (((ZipEntry) mutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry)) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry2 = (ZipEntry) mutableMapOf.get(parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        mutableMapOf.put(parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return mutableMapOf;
    }

    /* renamed from: b */
    public static final String m6676b(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String num = Integer.toString(i, AbstractC1326ip.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    /* renamed from: c */
    public static final void m6677c(BufferedSource bufferedSource, int i, Function2 function2) {
        long j = i;
        while (j != 0) {
            if (j >= 4) {
                int readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j2 = j - 4;
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    if (size2 >= 0) {
                        if (size2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException(ye0.m8291k(readShortLe, "unsupported zip: too many bytes processed for "));
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static final FileMetadata m6678d(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        T t;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (fileMetadata != null) {
            t = fileMetadata.getLastModifiedAtMillis();
        } else {
            t = 0;
        }
        objectRef.element = t;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == 67324752) {
            bufferedSource.skip(2L);
            short readShortLe = bufferedSource.readShortLe();
            int i = readShortLe & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                bufferedSource.skip(18L);
                long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                int readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource.skip(readShortLe3);
                    return null;
                }
                m6677c(bufferedSource, readShortLe3, new n63(bufferedSource, objectRef, objectRef2, objectRef3));
                return new FileMetadata(fileMetadata.getIsRegularFile(), fileMetadata.getIsDirectory(), null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, null, 128, null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + m6676b(i));
        }
        throw new IOException("bad zip: expected " + m6676b(67324752) + " but was " + m6676b(readIntLe));
    }

    /* JADX WARN: Finally extract failed */
    @NotNull
    public static final ZipFileSystem openZip(@NotNull Path zipPath, @NotNull FileSystem fileSystem, @NotNull Function1<? super ZipEntry, Boolean> predicate) {
        BufferedSource buffer;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle openReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            long size = openReadOnly.size() - 22;
            if (size >= 0) {
                long max = Math.max(size - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0L);
                do {
                    BufferedSource buffer2 = Okio.buffer(openReadOnly.source(size));
                    try {
                        if (buffer2.readIntLe() == 101010256) {
                            int readShortLe = buffer2.readShortLe() & UShort.MAX_VALUE;
                            int readShortLe2 = buffer2.readShortLe() & UShort.MAX_VALUE;
                            long readShortLe3 = buffer2.readShortLe() & UShort.MAX_VALUE;
                            if (readShortLe3 == (buffer2.readShortLe() & UShort.MAX_VALUE) && readShortLe == 0 && readShortLe2 == 0) {
                                buffer2.skip(4L);
                                int readShortLe4 = buffer2.readShortLe() & UShort.MAX_VALUE;
                                v90 v90Var = new v90(readShortLe3, buffer2.readIntLe() & 4294967295L, readShortLe4);
                                String readUtf8 = buffer2.readUtf8(readShortLe4);
                                buffer2.close();
                                long j = size - 20;
                                if (j > 0) {
                                    BufferedSource buffer3 = Okio.buffer(openReadOnly.source(j));
                                    try {
                                        if (buffer3.readIntLe() == 117853008) {
                                            int readIntLe = buffer3.readIntLe();
                                            long readLongLe = buffer3.readLongLe();
                                            if (buffer3.readIntLe() == 1 && readIntLe == 0) {
                                                buffer = Okio.buffer(openReadOnly.source(readLongLe));
                                                try {
                                                    int readIntLe2 = buffer.readIntLe();
                                                    if (readIntLe2 == 101075792) {
                                                        buffer.skip(12L);
                                                        int readIntLe3 = buffer.readIntLe();
                                                        int readIntLe4 = buffer.readIntLe();
                                                        long readLongLe2 = buffer.readLongLe();
                                                        if (readLongLe2 == buffer.readLongLe() && readIntLe3 == 0 && readIntLe4 == 0) {
                                                            buffer.skip(8L);
                                                            v90Var = new v90(readLongLe2, buffer.readLongLe(), readShortLe4);
                                                            CloseableKt.closeFinally(buffer, null);
                                                        } else {
                                                            throw new IOException("unsupported zip: spanned");
                                                        }
                                                    } else {
                                                        throw new IOException("bad zip: expected " + m6676b(101075792) + " but was " + m6676b(readIntLe2));
                                                    }
                                                } finally {
                                                }
                                            } else {
                                                throw new IOException("unsupported zip: spanned");
                                            }
                                        }
                                        CloseableKt.closeFinally(buffer3, null);
                                    } finally {
                                    }
                                }
                                long j2 = v90Var.f27677b;
                                ArrayList arrayList = new ArrayList();
                                buffer = Okio.buffer(openReadOnly.source(j2));
                                try {
                                    long j3 = v90Var.f27676a;
                                    for (long j4 = 0; j4 < j3; j4++) {
                                        ZipEntry readEntry = readEntry(buffer);
                                        if (readEntry.getAndroidx.constraintlayout.core.motion.utils.TypedValues.CycleType.S_WAVE_OFFSET java.lang.String() < j2) {
                                            if (predicate.invoke(readEntry).booleanValue()) {
                                                arrayList.add(readEntry);
                                            }
                                        } else {
                                            throw new IOException("bad zip: local file header offset >= central directory offset");
                                        }
                                    }
                                    CloseableKt.closeFinally(buffer, null);
                                    ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, m6675a(arrayList), readUtf8);
                                    CloseableKt.closeFinally(openReadOnly, null);
                                    return zipFileSystem;
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } finally {
                                        CloseableKt.closeFinally(buffer, th);
                                    }
                                }
                            }
                            throw new IOException("unsupported zip: spanned");
                        }
                        buffer2.close();
                        size--;
                    } catch (Throwable th2) {
                        buffer2.close();
                        throw th2;
                    }
                } while (size >= max);
                throw new IOException("not a zip: end of central directory signature not found");
            }
            throw new IOException("not a zip: size=" + openReadOnly.size());
        } finally {
        }
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = C1223g8.f17597z;
        }
        return openZip(path, fileSystem, function1);
    }

    @NotNull
    public static final ZipEntry readEntry(@NotNull BufferedSource bufferedSource) {
        Long valueOf;
        Ref.LongRef longRef;
        long j;
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == 33639248) {
            bufferedSource.skip(4L);
            short readShortLe = bufferedSource.readShortLe();
            int i = readShortLe & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                int readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe3 = bufferedSource.readShortLe();
                int i2 = readShortLe3 & UShort.MAX_VALUE;
                short readShortLe4 = bufferedSource.readShortLe();
                int i3 = readShortLe4 & UShort.MAX_VALUE;
                if (i2 == -1) {
                    valueOf = null;
                } else {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.set(14, 0);
                    gregorianCalendar.set(((i3 >> 9) & 127) + 1980, ((i3 >> 5) & 15) - 1, readShortLe4 & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (readShortLe3 & 31) << 1);
                    valueOf = Long.valueOf(gregorianCalendar.getTime().getTime());
                }
                long readIntLe2 = bufferedSource.readIntLe() & 4294967295L;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = bufferedSource.readIntLe() & 4294967295L;
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = bufferedSource.readIntLe() & 4294967295L;
                int readShortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                int readShortLe6 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                int readShortLe7 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource.skip(8L);
                Ref.LongRef longRef4 = new Ref.LongRef();
                longRef4.element = bufferedSource.readIntLe() & 4294967295L;
                String readUtf8 = bufferedSource.readUtf8(readShortLe5);
                if (!StringsKt__StringsKt.contains$default((CharSequence) readUtf8, (char) 0, false, 2, (Object) null)) {
                    if (longRef3.element == 4294967295L) {
                        j = 8;
                        longRef = longRef4;
                    } else {
                        longRef = longRef4;
                        j = 0;
                    }
                    if (longRef2.element == 4294967295L) {
                        j += 8;
                    }
                    if (longRef.element == 4294967295L) {
                        j += 8;
                    }
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Ref.LongRef longRef5 = longRef;
                    m6677c(bufferedSource, readShortLe6, new m63(booleanRef, j, longRef3, bufferedSource, longRef2, longRef5));
                    if (j > 0 && !booleanRef.element) {
                        throw new IOException("bad zip: zip64 extra required but absent");
                    }
                    return new ZipEntry(Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null).resolve(readUtf8), ro2.endsWith$default(readUtf8, "/", false, 2, null), bufferedSource.readUtf8(readShortLe7), readIntLe2, longRef2.element, longRef3.element, readShortLe2, valueOf, longRef5.element);
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + m6676b(i));
        }
        throw new IOException("bad zip: expected " + m6676b(33639248) + " but was " + m6676b(readIntLe));
    }

    @NotNull
    public static final FileMetadata readLocalHeader(@NotNull BufferedSource bufferedSource, @NotNull FileMetadata basicMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(basicMetadata, "basicMetadata");
        FileMetadata m6678d = m6678d(bufferedSource, basicMetadata);
        Intrinsics.checkNotNull(m6678d);
        return m6678d;
    }

    public static final void skipLocalHeader(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        m6678d(bufferedSource, null);
    }
}
