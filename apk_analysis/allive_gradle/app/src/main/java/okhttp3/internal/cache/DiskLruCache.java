package okhttp3.internal.cache;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.ForwardingSource;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.C1891v;
import p000.ha0;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0004VWXYB7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u001e\u0010\u0018\u001a\b\u0018\u00010\u0017R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001c\u001a\b\u0018\u00010\u001bR\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010%\u001a\u00020\u00102\n\u0010 \u001a\u00060\u001bR\u00020\u00002\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'J\u001b\u0010,\u001a\u00020!2\n\u0010)\u001a\u00060(R\u00020\u0000H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0010H\u0016¢\u0006\u0004\b-\u0010\u0012J\r\u0010.\u001a\u00020!¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u0010\u0012J\r\u00101\u001a\u00020\u0010¢\u0006\u0004\b1\u0010\u0012J\r\u00102\u001a\u00020\u0010¢\u0006\u0004\b2\u0010\u0012J\r\u00103\u001a\u00020\u0010¢\u0006\u0004\b3\u0010\u0012J\u0017\u00105\u001a\f\u0012\b\u0012\u00060\u0017R\u00020\u000004¢\u0006\u0004\b5\u00106R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010\t\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR*\u0010\u000b\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010HR>\u0010O\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u00060(R\u00020\u00000Ij\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u00060(R\u00020\u0000`J8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\"\u0010U\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010/\"\u0004\bS\u0010T¨\u0006Z"}, m5569d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokio/FileSystem;", "fileSystem", "Lokio/Path;", "directory", "", "appVersion", "valueCount", "", "maxSize", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokio/FileSystem;Lokio/Path;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "", "initialize", "()V", "rebuildJournal$okhttp", "rebuildJournal", "", "key", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "edit", "(Ljava/lang/String;J)Lokhttp3/internal/cache/DiskLruCache$Editor;", "size", "()J", "editor", "", FirebaseAnalytics.Param.SUCCESS, "completeEdit$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "completeEdit", "remove", "(Ljava/lang/String;)Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "entry", "removeEntry$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z", "removeEntry", "flush", "isClosed", "()Z", "close", "trimToSize", "delete", "evictAll", "", "snapshots", "()Ljava/util/Iterator;", "a", "Lokio/Path;", "getDirectory", "()Lokio/Path;", "c", "I", "getValueCount$okhttp", "()I", "d", "Lokio/FileSystem;", "getFileSystem$okhttp", "()Lokio/FileSystem;", "value", "e", "J", "getMaxSize", "setMaxSize", "(J)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "k", "Ljava/util/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "lruEntries", "p", "Z", "getClosed$okhttp", "setClosed$okhttp", "(Z)V", "closed", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: a, reason: from kotlin metadata */
    public final Path directory;

    /* renamed from: b */
    public final int f24181b;

    /* renamed from: c, reason: from kotlin metadata */
    public final int valueCount;

    /* renamed from: d */
    public final DiskLruCache$fileSystem$1 f24183d;

    /* renamed from: e, reason: from kotlin metadata */
    public long maxSize;

    /* renamed from: f */
    public final Path f24185f;

    /* renamed from: g */
    public final Path f24186g;

    /* renamed from: h */
    public final Path f24187h;

    /* renamed from: i */
    public long f24188i;

    /* renamed from: j */
    public BufferedSink f24189j;

    /* renamed from: k, reason: from kotlin metadata */
    public final LinkedHashMap lruEntries;

    /* renamed from: l */
    public int f24191l;

    /* renamed from: m */
    public boolean f24192m;

    /* renamed from: n */
    public boolean f24193n;

    /* renamed from: o */
    public boolean f24194o;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean closed;

    /* renamed from: q */
    public boolean f24196q;

    /* renamed from: r */
    public boolean f24197r;

    /* renamed from: s */
    public long f24198s;

    /* renamed from: t */
    public final TaskQueue f24199t;

    /* renamed from: u */
    public final DiskLruCache$cleanupTask$1 f24200u;

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE = "journal";

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";

    @JvmField
    @NotNull
    public static final String MAGIC = "libcore.io.DiskLruCache";

    @JvmField
    @NotNull
    public static final String VERSION_1 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;

    @JvmField
    public static final long ANY_SEQUENCE_NUMBER = -1;

    @JvmField
    @NotNull
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");

    @JvmField
    @NotNull
    public static final String CLEAN = "CLEAN";

    @JvmField
    @NotNull
    public static final String DIRTY = "DIRTY";

    @JvmField
    @NotNull
    public static final String REMOVE = "REMOVE";

    @JvmField
    @NotNull
    public static final String READ = "READ";

    @Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0018\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\tJ\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\tR\u001e\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, m5569d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "entry", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "", "detach$okhttp", "()V", "detach", "", FirebaseAnalytics.Param.INDEX, "Lokio/Source;", "newSource", "(I)Lokio/Source;", "Lokio/Sink;", "newSink", "(I)Lokio/Sink;", "commit", "abort", "a", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "b", "[Z", "getWritten$okhttp", "()[Z", "written", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class Editor {

        /* renamed from: a, reason: from kotlin metadata */
        public final Entry entry;

        /* renamed from: b, reason: from kotlin metadata */
        public final boolean[] written;

        /* renamed from: c */
        public boolean f24203c;

        /* renamed from: d */
        public final /* synthetic */ DiskLruCache f24204d;

        public Editor(@NotNull DiskLruCache diskLruCache, Entry entry) {
            boolean[] zArr;
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.f24204d = diskLruCache;
            this.entry = entry;
            if (entry.getReadable()) {
                zArr = null;
            } else {
                zArr = new boolean[diskLruCache.getValueCount()];
            }
            this.written = zArr;
        }

        public final void abort() {
            DiskLruCache diskLruCache = this.f24204d;
            synchronized (diskLruCache) {
                try {
                    if (!this.f24203c) {
                        if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                            diskLruCache.completeEdit$okhttp(this, false);
                        }
                        this.f24203c = true;
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void commit() {
            DiskLruCache diskLruCache = this.f24204d;
            synchronized (diskLruCache) {
                try {
                    if (!this.f24203c) {
                        if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                            diskLruCache.completeEdit$okhttp(this, true);
                        }
                        this.f24203c = true;
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void detach$okhttp() {
            Entry entry = this.entry;
            if (Intrinsics.areEqual(entry.getCurrentEditor(), this)) {
                DiskLruCache diskLruCache = this.f24204d;
                if (diskLruCache.f24193n) {
                    diskLruCache.completeEdit$okhttp(this, false);
                } else {
                    entry.setZombie$okhttp(true);
                }
            }
        }

        @NotNull
        /* renamed from: getEntry$okhttp, reason: from getter */
        public final Entry getEntry() {
            return this.entry;
        }

        @Nullable
        /* renamed from: getWritten$okhttp, reason: from getter */
        public final boolean[] getWritten() {
            return this.written;
        }

        @NotNull
        public final Sink newSink(int r4) {
            DiskLruCache diskLruCache = this.f24204d;
            synchronized (diskLruCache) {
                if (!this.f24203c) {
                    if (!Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                        return Okio.blackhole();
                    }
                    if (!this.entry.getReadable()) {
                        boolean[] zArr = this.written;
                        Intrinsics.checkNotNull(zArr);
                        zArr[r4] = true;
                    }
                    try {
                        return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(r4)), new C1633a(diskLruCache, this));
                    } catch (FileNotFoundException unused) {
                        return Okio.blackhole();
                    }
                }
                throw new IllegalStateException("Check failed.");
            }
        }

        @Nullable
        public final Source newSource(int r5) {
            DiskLruCache diskLruCache = this.f24204d;
            synchronized (diskLruCache) {
                if (!this.f24203c) {
                    Source source = null;
                    if (!this.entry.getReadable() || !Intrinsics.areEqual(this.entry.getCurrentEditor(), this) || this.entry.getZombie()) {
                        return null;
                    }
                    try {
                        source = diskLruCache.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(r5));
                    } catch (FileNotFoundException unused) {
                    }
                    return source;
                }
                throw new IllegalStateException("Check failed.");
            }
        }
    }

    @Metadata(m5568d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0015\u001a\b\u0018\u00010\u0011R\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\u00020\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010)\u001a\b\u0012\u0004\u0012\u00020!0 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\"\u00101\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R(\u0010=\u001a\b\u0018\u000106R\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010E\u001a\u00020>8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010M\u001a\u00020F8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006N"}, m5569d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "", "key", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "", "strings", "", "setLengths$okhttp", "(Ljava/util/List;)V", "setLengths", "Lokio/BufferedSink;", "writer", "writeLengths$okhttp", "(Lokio/BufferedSink;)V", "writeLengths", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "a", "Ljava/lang/String;", "getKey$okhttp", "()Ljava/lang/String;", "", "b", "[J", "getLengths$okhttp", "()[J", "lengths", "", "Lokio/Path;", "c", "Ljava/util/List;", "getCleanFiles$okhttp", "()Ljava/util/List;", "cleanFiles", "d", "getDirtyFiles$okhttp", "dirtyFiles", "", "e", "Z", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "readable", "f", "getZombie$okhttp", "setZombie$okhttp", "zombie", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "g", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "currentEditor", "", "h", "I", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "lockingSourceCount", "", "i", "J", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "sequenceNumber", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class Entry {

        /* renamed from: a, reason: from kotlin metadata */
        public final String key;

        /* renamed from: b, reason: from kotlin metadata */
        public final long[] lengths;

        /* renamed from: c */
        public final ArrayList f24207c;

        /* renamed from: d */
        public final ArrayList f24208d;

        /* renamed from: e, reason: from kotlin metadata */
        public boolean readable;

        /* renamed from: f, reason: from kotlin metadata */
        public boolean zombie;

        /* renamed from: g, reason: from kotlin metadata */
        public Editor currentEditor;

        /* renamed from: h, reason: from kotlin metadata */
        public int lockingSourceCount;

        /* renamed from: i, reason: from kotlin metadata */
        public long sequenceNumber;

        /* renamed from: j */
        public final /* synthetic */ DiskLruCache f24214j;

        public Entry(@NotNull DiskLruCache diskLruCache, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f24214j = diskLruCache;
            this.key = key;
            this.lengths = new long[diskLruCache.getValueCount()];
            this.f24207c = new ArrayList();
            this.f24208d = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int valueCount = diskLruCache.getValueCount();
            for (int i = 0; i < valueCount; i++) {
                sb.append(i);
                ArrayList arrayList = this.f24207c;
                Path directory = this.f24214j.getDirectory();
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "fileBuilder.toString()");
                arrayList.add(directory.resolve(sb2));
                sb.append(".tmp");
                ArrayList arrayList2 = this.f24208d;
                Path directory2 = this.f24214j.getDirectory();
                String sb3 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "fileBuilder.toString()");
                arrayList2.add(directory2.resolve(sb3));
                sb.setLength(length);
            }
        }

        @NotNull
        public final List<Path> getCleanFiles$okhttp() {
            return this.f24207c;
        }

        @Nullable
        /* renamed from: getCurrentEditor$okhttp, reason: from getter */
        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        @NotNull
        public final List<Path> getDirtyFiles$okhttp() {
            return this.f24208d;
        }

        @NotNull
        /* renamed from: getKey$okhttp, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        /* renamed from: getLengths$okhttp, reason: from getter */
        public final long[] getLengths() {
            return this.lengths;
        }

        /* renamed from: getLockingSourceCount$okhttp, reason: from getter */
        public final int getLockingSourceCount() {
            return this.lockingSourceCount;
        }

        /* renamed from: getReadable$okhttp, reason: from getter */
        public final boolean getReadable() {
            return this.readable;
        }

        /* renamed from: getSequenceNumber$okhttp, reason: from getter */
        public final long getSequenceNumber() {
            return this.sequenceNumber;
        }

        /* renamed from: getZombie$okhttp, reason: from getter */
        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(@Nullable Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(@NotNull List<String> strings) {
            Intrinsics.checkNotNullParameter(strings, "strings");
            if (strings.size() == this.f24214j.getValueCount()) {
                try {
                    int size = strings.size();
                    for (int i = 0; i < size; i++) {
                        this.lengths[i] = Long.parseLong(strings.get(i));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    throw new IOException("unexpected journal line: " + strings);
                }
            }
            throw new IOException("unexpected journal line: " + strings);
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        @Nullable
        public final Snapshot snapshot$okhttp() {
            boolean z = _UtilJvmKt.assertionsEnabled;
            final DiskLruCache diskLruCache = this.f24214j;
            if (z && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            }
            if (!this.readable) {
                return null;
            }
            if (!diskLruCache.f24193n && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            try {
                int valueCount = diskLruCache.getValueCount();
                for (int i = 0; i < valueCount; i++) {
                    Source source = diskLruCache.getFileSystem$okhttp().source((Path) this.f24207c.get(i));
                    if (!diskLruCache.f24193n) {
                        this.lockingSourceCount++;
                        source = new ForwardingSource(source) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1

                            /* renamed from: b */
                            public boolean f24215b;

                            @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                            public void close() {
                                super.close();
                                if (!this.f24215b) {
                                    this.f24215b = true;
                                    DiskLruCache diskLruCache2 = diskLruCache;
                                    DiskLruCache.Entry entry = this;
                                    synchronized (diskLruCache2) {
                                        entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount() - 1);
                                        if (entry.getLockingSourceCount() == 0 && entry.getZombie()) {
                                            diskLruCache2.removeEntry$okhttp(entry);
                                        }
                                    }
                                }
                            }
                        };
                    }
                    arrayList.add(source);
                }
                return new Snapshot(this.f24214j, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    _UtilCommonKt.closeQuietly((Source) it.next());
                }
                try {
                    diskLruCache.removeEntry$okhttp(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(@NotNull BufferedSink writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            for (long j : this.lengths) {
                writer.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    @Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\rJ\u0013\u0010\u0010\u001a\b\u0018\u00010\u000eR\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, m5569d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "", "key", "", "sequenceNumber", "", "Lokio/Source;", "sources", "", "lengths", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "edit", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "", FirebaseAnalytics.Param.INDEX, "getSource", "(I)Lokio/Source;", "getLength", "(I)J", "", "close", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class Snapshot implements Closeable {

        /* renamed from: a */
        public final String f24218a;

        /* renamed from: b */
        public final long f24219b;

        /* renamed from: c */
        public final List f24220c;

        /* renamed from: d */
        public final long[] f24221d;

        /* renamed from: e */
        public final /* synthetic */ DiskLruCache f24222e;

        public Snapshot(@NotNull DiskLruCache diskLruCache, String key, @NotNull long j, @NotNull List<? extends Source> sources, long[] lengths) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(lengths, "lengths");
            this.f24222e = diskLruCache;
            this.f24218a = key;
            this.f24219b = j;
            this.f24220c = sources;
            this.f24221d = lengths;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator it = this.f24220c.iterator();
            while (it.hasNext()) {
                _UtilCommonKt.closeQuietly((Source) it.next());
            }
        }

        @Nullable
        public final Editor edit() {
            return this.f24222e.edit(this.f24218a, this.f24219b);
        }

        public final long getLength(int r4) {
            return this.f24221d[r4];
        }

        @NotNull
        public final Source getSource(int r2) {
            return (Source) this.f24220c.get(r2);
        }

        @NotNull
        /* renamed from: key, reason: from getter */
        public final String getF24218a() {
            return this.f24218a;
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [okio.ForwardingFileSystem, okhttp3.internal.cache.DiskLruCache$fileSystem$1] */
    /* JADX WARN: Type inference failed for: r5v4, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(@NotNull FileSystem fileSystem, @NotNull Path directory, int i, int i2, long j, @NotNull TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.directory = directory;
        this.f24181b = i;
        this.valueCount = i2;
        this.f24183d = new ForwardingFileSystem(fileSystem);
        this.maxSize = j;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.f24199t = taskRunner.newQueue();
        this.f24200u = new Task(AbstractC1726qj.m7061q(new StringBuilder(), _UtilJvmKt.okHttpName, " Cache")) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z;
                boolean m6606b;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    z = diskLruCache.f24194o;
                    if (!z || diskLruCache.getClosed()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.f24196q = true;
                    }
                    try {
                        m6606b = diskLruCache.m6606b();
                        if (m6606b) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.f24191l = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.f24197r = true;
                        diskLruCache.f24189j = Okio.buffer(Okio.blackhole());
                    }
                    return -1L;
                }
            }
        };
        if (j > 0) {
            if (i2 > 0) {
                this.f24185f = directory.resolve(JOURNAL_FILE);
                this.f24186g = directory.resolve(JOURNAL_FILE_TEMP);
                this.f24187h = directory.resolve(JOURNAL_FILE_BACKUP);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static final /* synthetic */ void access$setHasJournalErrors$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.f24192m = z;
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    /* renamed from: f */
    public static void m6604f(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + Typography.quote).toString());
    }

    /* renamed from: a */
    public final synchronized void m6605a() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: b */
    public final boolean m6606b() {
        int i = this.f24191l;
        if (i >= 2000 && i >= this.lruEntries.size()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final void m6607c() {
        Path path = this.f24186g;
        DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.f24183d;
        _UtilCommonKt.deleteIfExists(diskLruCache$fileSystem$1, path);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "i.next()");
            Entry entry = (Entry) next;
            Editor currentEditor = entry.getCurrentEditor();
            int i = this.valueCount;
            int i2 = 0;
            if (currentEditor == null) {
                while (i2 < i) {
                    this.f24188i += entry.getLengths()[i2];
                    i2++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                while (i2 < i) {
                    _UtilCommonKt.deleteIfExists(diskLruCache$fileSystem$1, entry.getCleanFiles$okhttp().get(i2));
                    _UtilCommonKt.deleteIfExists(diskLruCache$fileSystem$1, entry.getDirtyFiles$okhttp().get(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Editor currentEditor;
        try {
            if (this.f24194o && !this.closed) {
                Collection values = this.lruEntries.values();
                Intrinsics.checkNotNullExpressionValue(values, "lruEntries.values");
                Object[] array = values.toArray(new Entry[0]);
                if (array != null) {
                    for (Entry entry : (Entry[]) array) {
                        if (entry.getCurrentEditor() != null && (currentEditor = entry.getCurrentEditor()) != null) {
                            currentEditor.detach$okhttp();
                        }
                    }
                    trimToSize();
                    BufferedSink bufferedSink = this.f24189j;
                    Intrinsics.checkNotNull(bufferedSink);
                    bufferedSink.close();
                    this.f24189j = null;
                    this.closed = true;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void completeEdit$okhttp(@NotNull Editor editor, boolean r10) {
        long j;
        Intrinsics.checkNotNullParameter(editor, "editor");
        Entry entry = editor.getEntry();
        if (Intrinsics.areEqual(entry.getCurrentEditor(), editor)) {
            if (r10 && !entry.getReadable()) {
                int i = this.valueCount;
                for (int i2 = 0; i2 < i; i2++) {
                    boolean[] written = editor.getWritten();
                    Intrinsics.checkNotNull(written);
                    if (written[i2]) {
                        if (!this.f24183d.exists(entry.getDirtyFiles$okhttp().get(i2))) {
                            editor.abort();
                            return;
                        }
                    } else {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            int i3 = this.valueCount;
            for (int i4 = 0; i4 < i3; i4++) {
                Path path = entry.getDirtyFiles$okhttp().get(i4);
                if (r10 && !entry.getZombie()) {
                    if (this.f24183d.exists(path)) {
                        Path path2 = entry.getCleanFiles$okhttp().get(i4);
                        this.f24183d.atomicMove(path, path2);
                        long j2 = entry.getLengths()[i4];
                        Long size = this.f24183d.metadata(path2).getSize();
                        if (size != null) {
                            j = size.longValue();
                        } else {
                            j = 0;
                        }
                        entry.getLengths()[i4] = j;
                        this.f24188i = (this.f24188i - j2) + j;
                    }
                } else {
                    _UtilCommonKt.deleteIfExists(this.f24183d, path);
                }
            }
            entry.setCurrentEditor$okhttp(null);
            if (entry.getZombie()) {
                removeEntry$okhttp(entry);
                return;
            }
            this.f24191l++;
            BufferedSink bufferedSink = this.f24189j;
            Intrinsics.checkNotNull(bufferedSink);
            if (!entry.getReadable() && !r10) {
                this.lruEntries.remove(entry.getKey());
                bufferedSink.writeUtf8(REMOVE).writeByte(32);
                bufferedSink.writeUtf8(entry.getKey());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
                if (this.f24188i <= this.maxSize || m6606b()) {
                    TaskQueue.schedule$default(this.f24199t, this.f24200u, 0L, 2, null);
                }
                return;
            }
            entry.setReadable$okhttp(true);
            bufferedSink.writeUtf8(CLEAN).writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            entry.writeLengths$okhttp(bufferedSink);
            bufferedSink.writeByte(10);
            if (r10) {
                long j3 = this.f24198s;
                this.f24198s = 1 + j3;
                entry.setSequenceNumber$okhttp(j3);
            }
            bufferedSink.flush();
            if (this.f24188i <= this.maxSize) {
            }
            TaskQueue.schedule$default(this.f24199t, this.f24200u, 0L, 2, null);
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6608d() {
        Unit unit;
        DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.f24183d;
        Path path = this.f24185f;
        BufferedSource buffer = Okio.buffer(diskLruCache$fileSystem$1.source(path));
        Throwable th = null;
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (Intrinsics.areEqual(MAGIC, readUtf8LineStrict) && Intrinsics.areEqual(VERSION_1, readUtf8LineStrict2) && Intrinsics.areEqual(String.valueOf(this.f24181b), readUtf8LineStrict3) && Intrinsics.areEqual(String.valueOf(this.valueCount), readUtf8LineStrict4) && readUtf8LineStrict5.length() <= 0) {
                int i = 0;
                while (true) {
                    try {
                        m6609e(buffer.readUtf8LineStrict());
                        i++;
                    } catch (EOFException unused) {
                        this.f24191l = i - this.lruEntries.size();
                        if (!buffer.exhausted()) {
                            rebuildJournal$okhttp();
                        } else {
                            this.f24189j = Okio.buffer(new FaultHidingSink(diskLruCache$fileSystem$1.appendingSink(path), new C1891v(3, this)));
                        }
                        unit = Unit.INSTANCE;
                        if (buffer != null) {
                            try {
                                buffer.close();
                            } catch (Throwable th2) {
                                if (th == null) {
                                    th = th2;
                                } else {
                                    ha0.addSuppressed(th, th2);
                                }
                            }
                        }
                        if (th != null) {
                            Intrinsics.checkNotNull(unit);
                            return;
                        }
                        throw th;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + ']');
            }
        } catch (Throwable th3) {
            th = th3;
            unit = null;
            if (buffer != null) {
            }
            if (th != null) {
            }
        }
    }

    public final void delete() {
        close();
        _UtilCommonKt.deleteContents(this.f24183d, this.directory);
    }

    /* renamed from: e */
    public final void m6609e(String str) {
        String substring;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, ' ', i, false, 4, (Object) null);
            LinkedHashMap linkedHashMap = this.lruEntries;
            if (indexOf$default2 == -1) {
                substring = str.substring(i);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                String str2 = REMOVE;
                if (indexOf$default == str2.length() && ro2.startsWith$default(str, str2, false, 2, null)) {
                    linkedHashMap.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Entry entry = (Entry) linkedHashMap.get(substring);
            if (entry == null) {
                entry = new Entry(this, substring);
                linkedHashMap.put(substring, entry);
            }
            if (indexOf$default2 != -1) {
                String str3 = CLEAN;
                if (indexOf$default == str3.length() && ro2.startsWith$default(str, str3, false, 2, null)) {
                    String substring2 = str.substring(indexOf$default2 + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) substring2, new char[]{' '}, false, 0, 6, (Object) null);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp(null);
                    entry.setLengths$okhttp(split$default);
                    return;
                }
            }
            if (indexOf$default2 == -1) {
                String str4 = DIRTY;
                if (indexOf$default == str4.length() && ro2.startsWith$default(str, str4, false, 2, null)) {
                    entry.setCurrentEditor$okhttp(new Editor(this, entry));
                    return;
                }
            }
            if (indexOf$default2 == -1) {
                String str5 = READ;
                if (indexOf$default == str5.length() && ro2.startsWith$default(str, str5, false, 2, null)) {
                    return;
                }
            }
            throw new IOException(AbstractC1726qj.m7038C("unexpected journal line: ", str));
        }
        throw new IOException(AbstractC1726qj.m7038C("unexpected journal line: ", str));
    }

    @JvmOverloads
    @Nullable
    public final Editor edit(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return edit$default(this, key, 0L, 2, null);
    }

    public final synchronized void evictAll() {
        try {
            initialize();
            Collection values = this.lruEntries.values();
            Intrinsics.checkNotNullExpressionValue(values, "lruEntries.values");
            Object[] array = values.toArray(new Entry[0]);
            if (array != null) {
                for (Entry entry : (Entry[]) array) {
                    Intrinsics.checkNotNullExpressionValue(entry, "entry");
                    removeEntry$okhttp(entry);
                }
                this.f24196q = false;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (!this.f24194o) {
            return;
        }
        m6605a();
        trimToSize();
        BufferedSink bufferedSink = this.f24189j;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.flush();
    }

    @Nullable
    public final synchronized Snapshot get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        m6605a();
        m6604f(key);
        Entry entry = (Entry) this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.f24191l++;
        BufferedSink bufferedSink = this.f24189j;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(key).writeByte(10);
        if (m6606b()) {
            TaskQueue.schedule$default(this.f24199t, this.f24200u, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    /* renamed from: getClosed$okhttp, reason: from getter */
    public final boolean getClosed() {
        return this.closed;
    }

    @NotNull
    public final Path getDirectory() {
        return this.directory;
    }

    @NotNull
    public final FileSystem getFileSystem$okhttp() {
        return this.f24183d;
    }

    @NotNull
    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    /* renamed from: getValueCount$okhttp, reason: from getter */
    public final int getValueCount() {
        return this.valueCount;
    }

    public final synchronized void initialize() {
        try {
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
            }
            if (this.f24194o) {
                return;
            }
            if (this.f24183d.exists(this.f24187h)) {
                if (this.f24183d.exists(this.f24185f)) {
                    this.f24183d.delete(this.f24187h);
                } else {
                    this.f24183d.atomicMove(this.f24187h, this.f24185f);
                }
            }
            this.f24193n = _UtilCommonKt.isCivilized(this.f24183d, this.f24187h);
            if (this.f24183d.exists(this.f24185f)) {
                try {
                    m6608d();
                    m6607c();
                    this.f24194o = true;
                    return;
                } catch (IOException e) {
                    Platform.INSTANCE.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            rebuildJournal$okhttp();
            this.f24194o = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() {
        Unit unit;
        try {
            BufferedSink bufferedSink = this.f24189j;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink buffer = Okio.buffer(this.f24183d.sink(this.f24186g, false));
            Throwable th = null;
            try {
                buffer.writeUtf8(MAGIC).writeByte(10);
                buffer.writeUtf8(VERSION_1).writeByte(10);
                buffer.writeDecimalLong(this.f24181b).writeByte(10);
                buffer.writeDecimalLong(this.valueCount).writeByte(10);
                buffer.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.getCurrentEditor() != null) {
                        buffer.writeUtf8(DIRTY).writeByte(32);
                        buffer.writeUtf8(entry.getKey());
                        buffer.writeByte(10);
                    } else {
                        buffer.writeUtf8(CLEAN).writeByte(32);
                        buffer.writeUtf8(entry.getKey());
                        entry.writeLengths$okhttp(buffer);
                        buffer.writeByte(10);
                    }
                }
                unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                unit = null;
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
                Intrinsics.checkNotNull(unit);
                if (this.f24183d.exists(this.f24185f)) {
                    this.f24183d.atomicMove(this.f24185f, this.f24187h);
                    this.f24183d.atomicMove(this.f24186g, this.f24185f);
                    _UtilCommonKt.deleteIfExists(this.f24183d, this.f24187h);
                } else {
                    this.f24183d.atomicMove(this.f24186g, this.f24185f);
                }
                this.f24189j = Okio.buffer(new FaultHidingSink(this.f24183d.appendingSink(this.f24185f), new C1891v(3, this)));
                this.f24192m = false;
                this.f24197r = false;
            } else {
                throw th;
            }
        } finally {
        }
    }

    public final synchronized boolean remove(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        m6605a();
        m6604f(key);
        Entry entry = (Entry) this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.f24188i <= this.maxSize) {
            this.f24196q = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(@NotNull Entry entry) {
        BufferedSink bufferedSink;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.f24193n) {
            if (entry.getLockingSourceCount() > 0 && (bufferedSink = this.f24189j) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount() > 0 || entry.getCurrentEditor() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor = entry.getCurrentEditor();
        if (currentEditor != null) {
            currentEditor.detach$okhttp();
        }
        for (int i = 0; i < this.valueCount; i++) {
            _UtilCommonKt.deleteIfExists(this.f24183d, entry.getCleanFiles$okhttp().get(i));
            this.f24188i -= entry.getLengths()[i];
            entry.getLengths()[i] = 0;
        }
        this.f24191l++;
        BufferedSink bufferedSink2 = this.f24189j;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey());
        if (m6606b()) {
            TaskQueue.schedule$default(this.f24199t, this.f24200u, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.f24194o) {
            TaskQueue.schedule$default(this.f24199t, this.f24200u, 0L, 2, null);
        }
    }

    public final synchronized long size() {
        initialize();
        return this.f24188i;
    }

    @NotNull
    public final synchronized Iterator<Snapshot> snapshots() {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "toEvict");
        removeEntry$okhttp(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void trimToSize() {
        while (this.f24188i > this.maxSize) {
            for (Entry toEvict : this.lruEntries.values()) {
                if (!toEvict.getZombie()) {
                    break;
                }
            }
            return;
        }
        this.f24196q = false;
    }

    @JvmOverloads
    @Nullable
    public final synchronized Editor edit(@NotNull String key, long expectedSequenceNumber) {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        m6605a();
        m6604f(key);
        Entry entry = (Entry) this.lruEntries.get(key);
        if (expectedSequenceNumber != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber() != expectedSequenceNumber)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount() != 0) {
            return null;
        }
        if (!this.f24196q && !this.f24197r) {
            BufferedSink bufferedSink = this.f24189j;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.writeUtf8(DIRTY).writeByte(32).writeUtf8(key).writeByte(10);
            bufferedSink.flush();
            if (this.f24192m) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.f24199t, this.f24200u, 0L, 2, null);
        return null;
    }
}
