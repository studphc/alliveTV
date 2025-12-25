package okhttp3.internal.ws;

import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0014B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m5569d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "", "isClient", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "frameCallback", "perMessageDeflate", "noContextTakeover", "<init>", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "", "processNextFrame", "()V", "close", "b", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "FrameCallback", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class WebSocketReader implements Closeable {

    /* renamed from: a */
    public final boolean f24629a;

    /* renamed from: b, reason: from kotlin metadata */
    public final BufferedSource source;

    /* renamed from: c */
    public final FrameCallback f24631c;

    /* renamed from: d */
    public final boolean f24632d;

    /* renamed from: e */
    public final boolean f24633e;

    /* renamed from: f */
    public boolean f24634f;

    /* renamed from: g */
    public int f24635g;

    /* renamed from: h */
    public long f24636h;

    /* renamed from: i */
    public boolean f24637i;

    /* renamed from: j */
    public boolean f24638j;

    /* renamed from: k */
    public boolean f24639k;

    /* renamed from: l */
    public final Buffer f24640l;

    /* renamed from: m */
    public final Buffer f24641m;

    /* renamed from: n */
    public MessageInflater f24642n;

    /* renamed from: o */
    public final byte[] f24643o;

    /* renamed from: p */
    public final Buffer.UnsafeCursor f24644p;

    @Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, m5569d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "onReadClose", "", "code", "", "reason", "", "onReadMessage", MimeTypes.BASE_TYPE_TEXT, "bytes", "Lokio/ByteString;", "onReadPing", "payload", "onReadPong", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public interface FrameCallback {
        void onReadClose(int code, @NotNull String reason);

        void onReadMessage(@NotNull String text);

        void onReadMessage(@NotNull ByteString bytes);

        void onReadPing(@NotNull ByteString payload);

        void onReadPong(@NotNull ByteString payload);
    }

    public WebSocketReader(boolean z, @NotNull BufferedSource source, @NotNull FrameCallback frameCallback, boolean z2, boolean z3) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(frameCallback, "frameCallback");
        this.f24629a = z;
        this.source = source;
        this.f24631c = frameCallback;
        this.f24632d = z2;
        this.f24633e = z3;
        this.f24640l = new Buffer();
        this.f24641m = new Buffer();
        if (z) {
            bArr = null;
        } else {
            bArr = new byte[4];
        }
        this.f24643o = bArr;
        this.f24644p = z ? null : new Buffer.UnsafeCursor();
    }

    /* renamed from: a */
    public final void m6646a() {
        short s;
        String str;
        long j = this.f24636h;
        Buffer buffer = this.f24640l;
        if (j > 0) {
            this.source.readFully(buffer, j);
            if (!this.f24629a) {
                Buffer.UnsafeCursor unsafeCursor = this.f24644p;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                unsafeCursor.seek(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                byte[] bArr = this.f24643o;
                Intrinsics.checkNotNull(bArr);
                webSocketProtocol.toggleMask(unsafeCursor, bArr);
                unsafeCursor.close();
            }
        }
        int i = this.f24635g;
        FrameCallback frameCallback = this.f24631c;
        switch (i) {
            case 8:
                long size = buffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s = buffer.readShort();
                        str = buffer.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        s = 1005;
                        str = "";
                    }
                    frameCallback.onReadClose(s, str);
                    this.f24634f = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                frameCallback.onReadPing(buffer.readByteString());
                return;
            case 10:
                frameCallback.onReadPong(buffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + _UtilJvmKt.toHexString(this.f24635g));
        }
    }

    /* renamed from: b */
    public final void m6647b() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        if (!this.f24634f) {
            BufferedSource bufferedSource = this.source;
            long f24767c = bufferedSource.getF24243a().getF24767c();
            bufferedSource.getF24243a().clearTimeout();
            try {
                int and = _UtilCommonKt.and(bufferedSource.readByte(), 255);
                bufferedSource.getF24243a().timeout(f24767c, TimeUnit.NANOSECONDS);
                int i = and & 15;
                this.f24635g = i;
                boolean z5 = false;
                if ((and & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f24637i = z;
                if ((and & 8) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f24638j = z2;
                if (z2 && !z) {
                    throw new ProtocolException("Control frames must be final.");
                }
                if ((and & 64) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (i != 1 && i != 2) {
                    if (z3) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                } else {
                    if (z3) {
                        if (this.f24632d) {
                            z4 = true;
                        } else {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                    } else {
                        z4 = false;
                    }
                    this.f24639k = z4;
                }
                if ((and & 32) == 0) {
                    if ((and & 16) == 0) {
                        int and2 = _UtilCommonKt.and(bufferedSource.readByte(), 255);
                        if ((and2 & 128) != 0) {
                            z5 = true;
                        }
                        boolean z6 = this.f24629a;
                        if (z5 == z6) {
                            if (z6) {
                                str = "Server-sent frames must not be masked.";
                            } else {
                                str = "Client-sent frames must be masked.";
                            }
                            throw new ProtocolException(str);
                        }
                        long j = and2 & 127;
                        this.f24636h = j;
                        if (j == 126) {
                            this.f24636h = _UtilCommonKt.and(bufferedSource.readShort(), 65535);
                        } else if (j == 127) {
                            long readLong = bufferedSource.readLong();
                            this.f24636h = readLong;
                            if (readLong < 0) {
                                throw new ProtocolException("Frame length 0x" + _UtilJvmKt.toHexString(this.f24636h) + " > 0x7FFFFFFFFFFFFFFF");
                            }
                        }
                        if (this.f24638j && this.f24636h > 125) {
                            throw new ProtocolException("Control frame must be less than 125B.");
                        }
                        if (z5) {
                            byte[] bArr = this.f24643o;
                            Intrinsics.checkNotNull(bArr);
                            bufferedSource.readFully(bArr);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("Unexpected rsv3 flag");
                }
                throw new ProtocolException("Unexpected rsv2 flag");
            } catch (Throwable th) {
                bufferedSource.getF24243a().timeout(f24767c, TimeUnit.NANOSECONDS);
                throw th;
            }
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageInflater messageInflater = this.f24642n;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() {
        m6647b();
        if (this.f24638j) {
            m6646a();
            return;
        }
        int i = this.f24635g;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + _UtilJvmKt.toHexString(i));
        }
        while (!this.f24634f) {
            long j = this.f24636h;
            Buffer buffer = this.f24641m;
            if (j > 0) {
                this.source.readFully(buffer, j);
                if (!this.f24629a) {
                    Buffer.UnsafeCursor unsafeCursor = this.f24644p;
                    Intrinsics.checkNotNull(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    unsafeCursor.seek(buffer.size() - this.f24636h);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    byte[] bArr = this.f24643o;
                    Intrinsics.checkNotNull(bArr);
                    webSocketProtocol.toggleMask(unsafeCursor, bArr);
                    unsafeCursor.close();
                }
            }
            if (!this.f24637i) {
                while (!this.f24634f) {
                    m6647b();
                    if (!this.f24638j) {
                        break;
                    } else {
                        m6646a();
                    }
                }
                if (this.f24635g != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + _UtilJvmKt.toHexString(this.f24635g));
                }
            } else {
                if (this.f24639k) {
                    MessageInflater messageInflater = this.f24642n;
                    if (messageInflater == null) {
                        messageInflater = new MessageInflater(this.f24633e);
                        this.f24642n = messageInflater;
                    }
                    messageInflater.inflate(buffer);
                }
                FrameCallback frameCallback = this.f24631c;
                if (i == 1) {
                    frameCallback.onReadMessage(buffer.readUtf8());
                    return;
                } else {
                    frameCallback.onReadMessage(buffer.readByteString());
                    return;
                }
            }
        }
        throw new IOException("closed");
    }
}
