package okhttp3.internal.ws;

import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, m5569d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "", "isClient", "Lokio/BufferedSink;", "sink", "Ljava/util/Random;", "random", "perMessageDeflate", "noContextTakeover", "", "minimumDeflateSize", "<init>", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "Lokio/ByteString;", "payload", "", "writePing", "(Lokio/ByteString;)V", "writePong", "", "code", "reason", "writeClose", "(ILokio/ByteString;)V", "formatOpcode", DataSchemeDataSource.SCHEME_DATA, "writeMessageFrame", "close", "()V", "b", "Lokio/BufferedSink;", "getSink", "()Lokio/BufferedSink;", "c", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class WebSocketWriter implements Closeable {

    /* renamed from: a */
    public final boolean f24645a;

    /* renamed from: b, reason: from kotlin metadata */
    public final BufferedSink sink;

    /* renamed from: c, reason: from kotlin metadata */
    public final Random random;

    /* renamed from: d */
    public final boolean f24648d;

    /* renamed from: e */
    public final boolean f24649e;

    /* renamed from: f */
    public final long f24650f;

    /* renamed from: g */
    public final Buffer f24651g;

    /* renamed from: h */
    public final Buffer f24652h;

    /* renamed from: i */
    public boolean f24653i;

    /* renamed from: j */
    public MessageDeflater f24654j;

    /* renamed from: k */
    public final byte[] f24655k;

    /* renamed from: l */
    public final Buffer.UnsafeCursor f24656l;

    public WebSocketWriter(boolean z, @NotNull BufferedSink sink, @NotNull Random random, boolean z2, boolean z3, long j) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.f24645a = z;
        this.sink = sink;
        this.random = random;
        this.f24648d = z2;
        this.f24649e = z3;
        this.f24650f = j;
        this.f24651g = new Buffer();
        this.f24652h = sink.getBuffer();
        if (z) {
            bArr = new byte[4];
        } else {
            bArr = null;
        }
        this.f24655k = bArr;
        this.f24656l = z ? new Buffer.UnsafeCursor() : null;
    }

    /* renamed from: a */
    public final void m6648a(int i, ByteString byteString) {
        if (!this.f24653i) {
            int size = byteString.size();
            if (size <= 125) {
                Buffer buffer = this.f24652h;
                buffer.writeByte(i | 128);
                if (this.f24645a) {
                    buffer.writeByte(size | 128);
                    byte[] bArr = this.f24655k;
                    Intrinsics.checkNotNull(bArr);
                    this.random.nextBytes(bArr);
                    buffer.write(bArr);
                    if (size > 0) {
                        long size2 = buffer.size();
                        buffer.write(byteString);
                        Buffer.UnsafeCursor unsafeCursor = this.f24656l;
                        Intrinsics.checkNotNull(unsafeCursor);
                        buffer.readAndWriteUnsafe(unsafeCursor);
                        unsafeCursor.seek(size2);
                        WebSocketProtocol.INSTANCE.toggleMask(unsafeCursor, bArr);
                        unsafeCursor.close();
                    }
                } else {
                    buffer.writeByte(size);
                    buffer.write(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.f24654j;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    @NotNull
    public final Random getRandom() {
        return this.random;
    }

    @NotNull
    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int code, @Nullable ByteString reason) {
        ByteString byteString = ByteString.EMPTY;
        if (code != 0 || reason != null) {
            if (code != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(code);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(code);
            if (reason != null) {
                buffer.write(reason);
            }
            byteString = buffer.readByteString();
        }
        try {
            m6648a(8, byteString);
        } finally {
            this.f24653i = true;
        }
    }

    public final void writeMessageFrame(int formatOpcode, @NotNull ByteString data) {
        int i;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.f24653i) {
            Buffer buffer = this.f24651g;
            buffer.write(data);
            int i2 = formatOpcode | 128;
            if (this.f24648d && data.size() >= this.f24650f) {
                MessageDeflater messageDeflater = this.f24654j;
                if (messageDeflater == null) {
                    messageDeflater = new MessageDeflater(this.f24649e);
                    this.f24654j = messageDeflater;
                }
                messageDeflater.deflate(buffer);
                i2 = formatOpcode | PsExtractor.AUDIO_STREAM;
            }
            long size = buffer.size();
            Buffer buffer2 = this.f24652h;
            buffer2.writeByte(i2);
            boolean z = this.f24645a;
            if (z) {
                i = 128;
            } else {
                i = 0;
            }
            if (size <= 125) {
                buffer2.writeByte(i | ((int) size));
            } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                buffer2.writeByte(i | 126);
                buffer2.writeShort((int) size);
            } else {
                buffer2.writeByte(i | 127);
                buffer2.writeLong(size);
            }
            if (z) {
                byte[] bArr = this.f24655k;
                Intrinsics.checkNotNull(bArr);
                this.random.nextBytes(bArr);
                buffer2.write(bArr);
                if (size > 0) {
                    Buffer.UnsafeCursor unsafeCursor = this.f24656l;
                    Intrinsics.checkNotNull(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    unsafeCursor.seek(0L);
                    WebSocketProtocol.INSTANCE.toggleMask(unsafeCursor, bArr);
                    unsafeCursor.close();
                }
            }
            buffer2.write(buffer, size);
            this.sink.emit();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        m6648a(9, payload);
    }

    public final void writePong(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        m6648a(10, payload);
    }
}
