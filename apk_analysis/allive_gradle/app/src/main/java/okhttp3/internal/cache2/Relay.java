package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 F2\u00020\u0001:\u0002FGJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u0006R\u0017\u0010#\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0017\u00101\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0017\u0010<\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b:\u0010.\u001a\u0004\b;\u00100R\"\u0010D\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010E\u001a\u0002028F¢\u0006\u0006\u001a\u0004\bE\u00106¨\u0006H"}, m5569d2 = {"Lokhttp3/internal/cache2/Relay;", "", "", "upstreamSize", "", "commit", "(J)V", "Lokio/ByteString;", "metadata", "()Lokio/ByteString;", "Lokio/Source;", "newSource", "()Lokio/Source;", "Ljava/io/RandomAccessFile;", "a", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "file", "b", "Lokio/Source;", "getUpstream", "setUpstream", "(Lokio/Source;)V", "upstream", "c", "J", "getUpstreamPos", "()J", "setUpstreamPos", "upstreamPos", "e", "getBufferMaxSize", "bufferMaxSize", "Ljava/lang/Thread;", "f", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "upstreamReader", "Lokio/Buffer;", "g", "Lokio/Buffer;", "getUpstreamBuffer", "()Lokio/Buffer;", "upstreamBuffer", "", "h", "Z", "getComplete", "()Z", "setComplete", "(Z)V", "complete", "i", "getBuffer", "buffer", "", "j", "I", "getSourceCount", "()I", "setSourceCount", "(I)V", "sourceCount", "isClosed", "Companion", "RelaySource", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Relay {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ByteString PREFIX_CLEAN;

    @JvmField
    @NotNull
    public static final ByteString PREFIX_DIRTY;

    /* renamed from: a, reason: from kotlin metadata */
    public RandomAccessFile file;

    /* renamed from: b, reason: from kotlin metadata */
    public Source upstream;

    /* renamed from: c, reason: from kotlin metadata */
    public long upstreamPos;

    /* renamed from: d */
    public final ByteString f24236d;

    /* renamed from: e, reason: from kotlin metadata */
    public final long bufferMaxSize;

    /* renamed from: f, reason: from kotlin metadata */
    public Thread upstreamReader;

    /* renamed from: g, reason: from kotlin metadata */
    public final Buffer upstreamBuffer = new Buffer();

    /* renamed from: h, reason: from kotlin metadata */
    public boolean complete;

    /* renamed from: i, reason: from kotlin metadata */
    public final Buffer buffer;

    /* renamed from: j, reason: from kotlin metadata */
    public int sourceCount;

    @Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, m5569d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "Ljava/io/File;", "file", "Lokio/Source;", "upstream", "Lokio/ByteString;", "metadata", "", "bufferMaxSize", "Lokhttp3/internal/cache2/Relay;", "edit", "(Ljava/io/File;Lokio/Source;Lokio/ByteString;J)Lokhttp3/internal/cache2/Relay;", "read", "(Ljava/io/File;)Lokhttp3/internal/cache2/Relay;", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "", "SOURCE_FILE", "I", "SOURCE_UPSTREAM", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source upstream, @NotNull ByteString metadata, long bufferMaxSize) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(upstream, "upstream");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, bufferMaxSize, null);
            randomAccessFile.setLength(0L);
            relay.m6610a(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        @NotNull
        public final Relay read(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, 32L);
            if (Intrinsics.areEqual(buffer.readByteString(r1.size()), Relay.PREFIX_CLEAN)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + 32, buffer2, readLong2);
                return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L, null);
            }
            throw new IOException("unreadable cache file");
        }
    }

    @Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class RelaySource implements Source {

        /* renamed from: a */
        public final Timeout f24243a = new Timeout();

        /* renamed from: b */
        public FileOperator f24244b;

        /* renamed from: c */
        public long f24245c;

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            Intrinsics.checkNotNull(file);
            FileChannel channel = file.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            this.f24244b = new FileOperator(channel);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f24244b == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f24244b = null;
            Relay relay = Relay.this;
            synchronized (relay) {
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (relay.getSourceCount() == 0) {
                    RandomAccessFile file = relay.getFile();
                    relay.setFile(null);
                    randomAccessFile = file;
                }
            }
            if (randomAccessFile != null) {
                _UtilCommonKt.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        
            if (r0 != 2) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            r10 = java.lang.Math.min(r23, r21.f24246d.getUpstreamPos() - r21.f24245c);
            r2 = r21.f24244b;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
            r2.read(r21.f24245c + 32, r22, r10);
            r21.f24245c += r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
        
            return r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
        
            r0 = r21.f24246d.getUpstream();
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
            r11 = r0.read(r21.f24246d.getUpstreamBuffer(), r21.f24246d.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
        
            if (r11 != (-1)) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
        
            r0 = r21.f24246d;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00a0, code lost:
        
            r2 = r21.f24246d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00a2, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a9, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
        
            r19 = java.lang.Math.min(r11, r23);
            r21.f24246d.getUpstreamBuffer().copyTo(r22, 0, r19);
            r21.f24245c += r19;
            r13 = r21.f24244b;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
            r13.write(r21.f24246d.getUpstreamPos() + 32, r21.f24246d.getUpstreamBuffer().clone(), r11);
            r2 = r21.f24246d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e9, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ea, code lost:
        
            r2.getBuffer().write(r2.getUpstreamBuffer(), r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0103, code lost:
        
            if (r2.getBuffer().size() <= r2.getBufferMaxSize()) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0105, code lost:
        
            r2.getBuffer().skip(r2.getBuffer().size() - r2.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x011c, code lost:
        
            r2.setUpstreamPos(r2.getUpstreamPos() + r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0124, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0125, code lost:
        
            r2 = r21.f24246d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0127, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0128, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x012e, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x012f, code lost:
        
            return r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x011a, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0134, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00ae, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0135, code lost:
        
            r2 = r21.f24246d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0137, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0138, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x013f, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(@NotNull Buffer sink, long byteCount) {
            char c;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.f24244b != null) {
                Relay relay = Relay.this;
                synchronized (relay) {
                    while (true) {
                        try {
                            if (this.f24245c == relay.getUpstreamPos()) {
                                if (relay.getComplete()) {
                                    return -1L;
                                }
                                if (relay.getUpstreamReader() != null) {
                                    this.f24243a.waitUntilNotified(relay);
                                } else {
                                    relay.setUpstreamReader(Thread.currentThread());
                                    c = 1;
                                    break;
                                }
                            } else {
                                long upstreamPos = relay.getUpstreamPos() - relay.getBuffer().size();
                                if (this.f24245c < upstreamPos) {
                                    c = 2;
                                } else {
                                    long min = Math.min(byteCount, relay.getUpstreamPos() - this.f24245c);
                                    relay.getBuffer().copyTo(sink, this.f24245c - upstreamPos, min);
                                    this.f24245c += min;
                                    return min;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }

        @Override // okio.Source
        @NotNull
        /* renamed from: timeout, reason: from getter */
        public Timeout getF24243a() {
            return this.f24243a;
        }
    }

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    public Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z;
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j;
        this.f24236d = byteString;
        this.bufferMaxSize = j2;
        if (this.upstream == null) {
            z = true;
        } else {
            z = false;
        }
        this.complete = z;
        this.buffer = new Buffer();
    }

    /* renamed from: a */
    public final void m6610a(ByteString byteString, long j, long j2) {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() == 32) {
            RandomAccessFile randomAccessFile = this.file;
            Intrinsics.checkNotNull(randomAccessFile);
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            new FileOperator(channel).write(0L, buffer, 32L);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public final void commit(long upstreamSize) {
        Buffer buffer = new Buffer();
        buffer.write(this.f24236d);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).write(32 + upstreamSize, buffer, r0.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.checkNotNull(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        m6610a(PREFIX_CLEAN, upstreamSize, this.f24236d.size());
        RandomAccessFile randomAccessFile3 = this.file;
        Intrinsics.checkNotNull(randomAccessFile3);
        randomAccessFile3.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Source source = this.upstream;
        if (source != null) {
            _UtilCommonKt.closeQuietly(source);
        }
        this.upstream = null;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        if (this.file == null) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: metadata, reason: from getter */
    public final ByteString getF24236d() {
        return this.f24236d;
    }

    @Nullable
    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final void setUpstream(@Nullable Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }
}
