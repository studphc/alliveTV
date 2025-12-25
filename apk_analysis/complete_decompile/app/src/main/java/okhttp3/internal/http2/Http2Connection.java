package okhttp3.internal.http2;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.C1829tb;
import p000.e11;
import p000.f11;
import p000.g11;
import p000.h11;
import p000.i11;
import p000.j11;

@Metadata(m5568d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 °\u00012\u00020\u0001:\b±\u0001°\u0001²\u0001³\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010$\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0004\b\"\u0010#J/\u0010(\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0010¢\u0006\u0004\b(\u0010)J\u001f\u0010.\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u001f\u00101\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010/\u001a\u00020*H\u0000¢\u0006\u0004\b0\u0010-J\u001f\u00105\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0010H\u0000¢\u0006\u0004\b3\u00104J%\u00109\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0012¢\u0006\u0004\b;\u0010<J\r\u00109\u001a\u00020\u0012¢\u0006\u0004\b9\u0010<J\r\u0010=\u001a\u00020\u0012¢\u0006\u0004\b=\u0010<J\r\u0010>\u001a\u00020\u0012¢\u0006\u0004\b>\u0010<J\u0015\u0010?\u001a\u00020\u00122\u0006\u0010/\u001a\u00020*¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0012H\u0016¢\u0006\u0004\bA\u0010<J)\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0004\bF\u0010GJ\u0019\u0010I\u001a\u00020\u00122\b\b\u0002\u0010H\u001a\u00020\u001aH\u0007¢\u0006\u0004\bI\u0010JJ\u0015\u0010M\u001a\u00020\u00122\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ\u0015\u0010P\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u0010¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020\u0012H\u0000¢\u0006\u0004\bR\u0010<J\u0017\u0010V\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0004\bT\u0010UJ%\u0010Y\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0004\bW\u0010XJ-\u0010]\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010Z\u001a\u00020\u001aH\u0000¢\u0006\u0004\b[\u0010\\J/\u0010b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u001aH\u0000¢\u0006\u0004\b`\u0010aJ\u001f\u0010d\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\bc\u0010-R\u001a\u0010i\u001a\u00020\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001a\u0010o\u001a\u00020j8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR&\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0p8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001a\u0010{\u001a\u00020v8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR$\u0010\u0081\u0001\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0013\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\b\"\u0005\b\u007f\u0010\u0080\u0001R'\u0010\u0085\u0001\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b\u0082\u0001\u0010}\u001a\u0005\b\u0083\u0001\u0010\b\"\u0006\b\u0084\u0001\u0010\u0080\u0001R\u001c\u0010\u008a\u0001\u001a\u00020K8\u0006¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R(\u0010\u008e\u0001\u001a\u00020K8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008b\u0001\u0010\u0087\u0001\u001a\u0006\b\u008c\u0001\u0010\u0089\u0001\"\u0005\b\u008d\u0001\u0010NR*\u0010\u0094\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R*\u0010\u0097\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0091\u0001\u001a\u0006\b\u0096\u0001\u0010\u0093\u0001R*\u0010\u009a\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0091\u0001\u001a\u0006\b\u0099\u0001\u0010\u0093\u0001R*\u0010\u009d\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u0091\u0001\u001a\u0006\b\u009c\u0001\u0010\u0093\u0001R \u0010£\u0001\u001a\u00030\u009e\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u001d\u0010©\u0001\u001a\u00030¤\u00018\u0006¢\u0006\u0010\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R!\u0010¯\u0001\u001a\u00070ª\u0001R\u00020\u00008\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001¨\u0006´\u0001"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "Lokhttp3/internal/http2/Http2Connection$Builder;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "", "openStreamCount", "()I", "id", "Lokhttp3/internal/http2/Http2Stream;", "getStream", "(I)Lokhttp3/internal/http2/Http2Stream;", "streamId", "removeStream$okhttp", "removeStream", "", "read", "", "updateConnectionFlowControl$okhttp", "(J)V", "updateConnectionFlowControl", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "out", "pushStream", "(ILjava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "newStream", "(Ljava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "outFinished", "alternating", "writeHeaders$okhttp", "(IZLjava/util/List;)V", "writeHeaders", "Lokio/Buffer;", "buffer", "byteCount", "writeData", "(IZLokio/Buffer;J)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "writeSynResetLater$okhttp", "(ILokhttp3/internal/http2/ErrorCode;)V", "writeSynResetLater", "statusCode", "writeSynReset$okhttp", "writeSynReset", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "(IJ)V", "writeWindowUpdateLater", "reply", "payload1", "payload2", "writePing", "(ZII)V", "writePingAndAwaitPong", "()V", "awaitPong", "flush", "shutdown", "(Lokhttp3/internal/http2/ErrorCode;)V", "close", "connectionCode", "streamCode", "Ljava/io/IOException;", "cause", "close$okhttp", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "start", "(Z)V", "Lokhttp3/internal/http2/Settings;", "settings", "setSettings", "(Lokhttp3/internal/http2/Settings;)V", "nowNs", "isHealthy", "(J)Z", "sendDegradedPingLater$okhttp", "sendDegradedPingLater", "pushedStream$okhttp", "(I)Z", "pushedStream", "pushRequestLater$okhttp", "(ILjava/util/List;)V", "pushRequestLater", "inFinished", "pushHeadersLater$okhttp", "(ILjava/util/List;Z)V", "pushHeadersLater", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "pushDataLater$okhttp", "(ILokio/BufferedSource;IZ)V", "pushDataLater", "pushResetLater$okhttp", "pushResetLater", "a", "Z", "getClient$okhttp", "()Z", "client", "Lokhttp3/internal/http2/Http2Connection$Listener;", "b", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "c", "Ljava/util/Map;", "getStreams$okhttp", "()Ljava/util/Map;", "streams", "", "d", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "connectionName", "e", "I", "getLastGoodStreamId$okhttp", "setLastGoodStreamId$okhttp", "(I)V", "lastGoodStreamId", "f", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "nextStreamId", "t", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "okHttpSettings", "u", "getPeerSettings", "setPeerSettings", "peerSettings", "<set-?>", "v", "J", "getReadBytesTotal", "()J", "readBytesTotal", "w", "getReadBytesAcknowledged", "readBytesAcknowledged", "x", "getWriteBytesTotal", "writeBytesTotal", "y", "getWriteBytesMaximum", "writeBytesMaximum", "Ljava/net/Socket;", "z", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "socket", "Lokhttp3/internal/http2/Http2Writer;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writer", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "B", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "Companion", "Builder", "Listener", "ReaderRunnable", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D */
    public static final Settings f24430D;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;

    /* renamed from: A */
    public final Http2Writer writer;

    /* renamed from: B, reason: from kotlin metadata */
    public final ReaderRunnable readerRunnable;

    /* renamed from: C */
    public final LinkedHashSet f24433C;

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean client;

    /* renamed from: b, reason: from kotlin metadata */
    public final Listener com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;

    /* renamed from: c */
    public final LinkedHashMap f24436c;

    /* renamed from: d, reason: from kotlin metadata */
    public final String connectionName;

    /* renamed from: e, reason: from kotlin metadata */
    public int lastGoodStreamId;

    /* renamed from: f, reason: from kotlin metadata */
    public int nextStreamId;

    /* renamed from: g */
    public boolean f24440g;

    /* renamed from: h */
    public final TaskRunner f24441h;

    /* renamed from: i */
    public final TaskQueue f24442i;

    /* renamed from: j */
    public final TaskQueue f24443j;

    /* renamed from: k */
    public final TaskQueue f24444k;

    /* renamed from: l */
    public final PushObserver f24445l;

    /* renamed from: m */
    public long f24446m;

    /* renamed from: n */
    public long f24447n;

    /* renamed from: o */
    public long f24448o;

    /* renamed from: p */
    public long f24449p;

    /* renamed from: q */
    public long f24450q;

    /* renamed from: r */
    public long f24451r;

    /* renamed from: s */
    public long f24452s;

    /* renamed from: t, reason: from kotlin metadata */
    public final Settings okHttpSettings;

    /* renamed from: u, reason: from kotlin metadata */
    public Settings peerSettings;

    /* renamed from: v, reason: from kotlin metadata */
    public long readBytesTotal;

    /* renamed from: w, reason: from kotlin metadata */
    public long readBytesAcknowledged;

    /* renamed from: x, reason: from kotlin metadata */
    public long writeBytesTotal;

    /* renamed from: y, reason: from kotlin metadata */
    public long writeBytesMaximum;

    /* renamed from: z, reason: from kotlin metadata */
    public final Socket socket;

    @Metadata(m5568d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b4\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\t\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\n8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\r\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u000f\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006N"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "", "client", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Ljava/net/Socket;", "socket", "", "peerName", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSink;", "sink", "(Ljava/net/Socket;Ljava/lang/String;Lokio/BufferedSource;Lokio/BufferedSink;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lokhttp3/internal/http2/Http2Connection$Listener;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "(Lokhttp3/internal/http2/PushObserver;)Lokhttp3/internal/http2/Http2Connection$Builder;", "", "pingIntervalMillis", "(I)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection;", "build", "()Lokhttp3/internal/http2/Http2Connection;", "a", "Z", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "b", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "c", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "d", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "e", "I", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: from kotlin metadata */
        public boolean client;

        /* renamed from: b, reason: from kotlin metadata */
        public final TaskRunner taskRunner;

        /* renamed from: c, reason: from kotlin metadata */
        public Listener com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
        public String connectionName;

        /* renamed from: d, reason: from kotlin metadata */
        public PushObserver pushObserver;

        /* renamed from: e, reason: from kotlin metadata */
        public int pingIntervalMillis;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;

        public Builder(boolean z, @NotNull TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = z;
            this.taskRunner = taskRunner;
            this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i, Object obj) {
            if ((i & 2) != 0) {
                str = _UtilJvmKt.peerName(socket);
            }
            if ((i & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((i & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, str, bufferedSource, bufferedSink);
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        /* renamed from: getClient$okhttp, reason: from getter */
        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        @NotNull
        /* renamed from: getListener$okhttp, reason: from getter */
        public final Listener getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String() {
            return this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
        }

        /* renamed from: getPingIntervalMillis$okhttp, reason: from getter */
        public final int getPingIntervalMillis() {
            return this.pingIntervalMillis;
        }

        @NotNull
        /* renamed from: getPushObserver$okhttp, reason: from getter */
        public final PushObserver getPushObserver() {
            return this.pushObserver;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            Intrinsics.throwUninitializedPropertyAccessException(FirebaseAnalytics.Param.SOURCE);
            return null;
        }

        @NotNull
        /* renamed from: getTaskRunner$okhttp, reason: from getter */
        public final TaskRunner getTaskRunner() {
            return this.taskRunner;
        }

        @NotNull
        public final Builder listener(@NotNull Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String = listener;
            return this;
        }

        @NotNull
        public final Builder pingIntervalMillis(int pingIntervalMillis) {
            this.pingIntervalMillis = pingIntervalMillis;
            return this;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final void setConnectionName$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(@NotNull Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "<set-?>");
            this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(@NotNull BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final void setSocket$okhttp(@NotNull Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(@NotNull BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            return socket$default(this, socket, null, null, null, 14, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            return socket$default(this, socket, peerName, null, null, 12, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName, @NotNull BufferedSource source) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            return socket$default(this, socket, peerName, source, null, 8, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName, @NotNull BufferedSource r4, @NotNull BufferedSink sink) {
            String m7038C;
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(r4, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            setSocket$okhttp(socket);
            if (this.client) {
                m7038C = _UtilJvmKt.okHttpName + ' ' + peerName;
            } else {
                m7038C = AbstractC1726qj.m7038C("MockWebServer ", peerName);
            }
            setConnectionName$okhttp(m7038C);
            setSource$okhttp(r4);
            setSink$okhttp(sink);
            return this;
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u000e"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "Lokhttp3/internal/http2/Settings;", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "", "AWAIT_PING", "I", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.f24430D;
        }
    }

    @Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Listener {

        @JvmField
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener();

        public void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void onStream(@NotNull Http2Stream stream);
    }

    @Metadata(m5568d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\tJ'\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010'J'\u0010+\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J/\u00104\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u00105J-\u00108\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b8\u00109J?\u0010@\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020-H\u0016¢\u0006\u0004\b@\u0010AR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006F"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "Lokhttp3/internal/http2/Http2Reader;", "reader", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "invoke", "()V", "", "inFinished", "", "streamId", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "length", DataSchemeDataSource.SCHEME_DATA, "(ZILokio/BufferedSource;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "applyAndAckSettings", "ackSettings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "a", "Lokhttp3/internal/http2/Http2Reader;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {

        /* renamed from: a, reason: from kotlin metadata */
        public final Http2Reader reader;

        /* renamed from: b */
        public final /* synthetic */ Http2Connection f24466b;

        public ReaderRunnable(@NotNull Http2Connection http2Connection, Http2Reader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.f24466b = http2Connection;
            this.reader = reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int streamId, @NotNull String origin, @NotNull ByteString protocol, @NotNull String host, int port, long maxAge) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Intrinsics.checkNotNullParameter(host, "host");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, okhttp3.internal.http2.Settings] */
        public final void applyAndAckSettings(boolean clearPrevious, @NotNull Settings settings) {
            ?? r0;
            long initialWindowSize;
            int i;
            Http2Stream[] http2StreamArr;
            Http2Stream[] http2StreamArr2;
            Settings settings2 = settings;
            Intrinsics.checkNotNullParameter(settings2, "settings");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Http2Writer writer = this.f24466b.getWriter();
            Http2Connection http2Connection = this.f24466b;
            synchronized (writer) {
                synchronized (http2Connection) {
                    try {
                        Settings peerSettings = http2Connection.getPeerSettings();
                        if (clearPrevious) {
                            r0 = settings2;
                        } else {
                            Settings settings3 = new Settings();
                            settings3.merge(peerSettings);
                            settings3.merge(settings2);
                            r0 = settings3;
                        }
                        objectRef.element = r0;
                        initialWindowSize = r0.getInitialWindowSize() - peerSettings.getInitialWindowSize();
                        if (initialWindowSize != 0 && !http2Connection.getStreams$okhttp().isEmpty()) {
                            Object[] array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                            if (array != null) {
                                http2StreamArr = (Http2Stream[]) array;
                                http2StreamArr2 = http2StreamArr;
                                http2Connection.setPeerSettings((Settings) objectRef.element);
                                TaskQueue.execute$default(http2Connection.f24444k, http2Connection.getConnectionName() + " onSettings", 0L, false, new C1634a(http2Connection, objectRef), 6, null);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            }
                        }
                        http2StreamArr = null;
                        http2StreamArr2 = http2StreamArr;
                        http2Connection.setPeerSettings((Settings) objectRef.element);
                        TaskQueue.execute$default(http2Connection.f24444k, http2Connection.getConnectionName() + " onSettings", 0L, false, new C1634a(http2Connection, objectRef), 6, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) objectRef.element);
                } catch (IOException e) {
                    Http2Connection.access$failConnection(http2Connection, e);
                }
            }
            if (http2StreamArr2 != null) {
                for (Http2Stream http2Stream : http2StreamArr2) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, @NotNull BufferedSource source, int i2) {
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Connection http2Connection = this.f24466b;
            if (http2Connection.pushedStream$okhttp(i)) {
                http2Connection.pushDataLater$okhttp(i, source, i2, z);
                return;
            }
            Http2Stream stream = http2Connection.getStream(i);
            if (stream == null) {
                http2Connection.writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                http2Connection.updateConnectionFlowControl$okhttp(j);
                source.skip(j);
                return;
            }
            stream.receiveData(source, i2);
            if (z) {
                stream.receiveHeaders(_UtilJvmKt.EMPTY_HEADERS, true);
            }
        }

        @NotNull
        /* renamed from: getReader$okhttp, reason: from getter */
        public final Http2Reader getReader() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int lastGoodStreamId, @NotNull ErrorCode errorCode, @NotNull ByteString debugData) {
            int i;
            Object[] array;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.size();
            Http2Connection http2Connection = this.f24466b;
            synchronized (http2Connection) {
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array != null) {
                    http2Connection.f24440g = true;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                if (http2Stream.getId() > lastGoodStreamId && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.f24466b.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean inFinished, int streamId, int associatedStreamId, @NotNull List<Header> headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.f24466b.pushedStream$okhttp(streamId)) {
                this.f24466b.pushHeadersLater$okhttp(streamId, headerBlock, inFinished);
                return;
            }
            Http2Connection http2Connection = this.f24466b;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(streamId);
                if (stream == null) {
                    if (http2Connection.f24440g) {
                        return;
                    }
                    if (streamId <= http2Connection.getLastGoodStreamId()) {
                        return;
                    }
                    if (streamId % 2 == http2Connection.getNextStreamId() % 2) {
                        return;
                    }
                    Http2Stream http2Stream = new Http2Stream(streamId, http2Connection, false, inFinished, _UtilJvmKt.toHeaders(headerBlock));
                    http2Connection.setLastGoodStreamId$okhttp(streamId);
                    http2Connection.getStreams$okhttp().put(Integer.valueOf(streamId), http2Stream);
                    TaskQueue.execute$default(http2Connection.f24441h.newQueue(), http2Connection.getConnectionName() + '[' + streamId + "] onStream", 0L, false, new C1635b(http2Connection, http2Stream), 6, null);
                    return;
                }
                stream.receiveHeaders(_UtilJvmKt.toHeaders(headerBlock), inFinished);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean ack, int payload1, int payload2) {
            if (!ack) {
                TaskQueue.execute$default(this.f24466b.f24442i, this.f24466b.getConnectionName() + " ping", 0L, false, new C1636c(this.f24466b, payload1, payload2), 6, null);
                return;
            }
            Http2Connection http2Connection = this.f24466b;
            synchronized (http2Connection) {
                try {
                    if (payload1 == 1) {
                        http2Connection.f24447n++;
                    } else if (payload1 == 2) {
                        http2Connection.f24449p++;
                    } else if (payload1 == 3) {
                        http2Connection.f24451r++;
                        http2Connection.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int streamId, int promisedStreamId, @NotNull List<Header> requestHeaders) {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.f24466b.pushRequestLater$okhttp(promisedStreamId, requestHeaders);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int streamId, @NotNull ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Http2Connection http2Connection = this.f24466b;
            if (http2Connection.pushedStream$okhttp(streamId)) {
                http2Connection.pushResetLater$okhttp(streamId, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = http2Connection.removeStream$okhttp(streamId);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean clearPrevious, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            Http2Connection http2Connection = this.f24466b;
            TaskQueue.execute$default(http2Connection.f24442i, http2Connection.getConnectionName() + " applyAndAckSettings", 0L, false, new C1637d(this, clearPrevious, settings), 6, null);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                Http2Connection http2Connection = this.f24466b;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + windowSizeIncrement;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream stream = this.f24466b.getStream(streamId);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(windowSizeIncrement);
                }
            }
        }

        /* renamed from: invoke */
        public void invoke2() {
            ErrorCode errorCode;
            Http2Connection http2Connection = this.f24466b;
            Http2Reader http2Reader = this.reader;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    http2Reader.readConnectionPreface(this);
                    do {
                    } while (http2Reader.nextFrame(false, this));
                    errorCode = ErrorCode.NO_ERROR;
                    try {
                        errorCode2 = ErrorCode.CANCEL;
                        http2Connection.close$okhttp(errorCode, errorCode2, null);
                    } catch (IOException e2) {
                        e = e2;
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        http2Connection.close$okhttp(errorCode2, errorCode2, e);
                        _UtilCommonKt.closeQuietly(http2Reader);
                    }
                } catch (Throwable th) {
                    th = th;
                    http2Connection.close$okhttp(errorCode, errorCode2, e);
                    _UtilCommonKt.closeQuietly(http2Reader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                errorCode = errorCode2;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                http2Connection.close$okhttp(errorCode, errorCode2, e);
                _UtilCommonKt.closeQuietly(http2Reader);
                throw th;
            }
            _UtilCommonKt.closeQuietly(http2Reader);
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        f24430D = settings;
    }

    public Http2Connection(@NotNull Builder builder) {
        int i;
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean client = builder.getClient();
        this.client = client;
        this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String = builder.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String();
        this.f24436c = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        if (builder.getClient()) {
            i = 3;
        } else {
            i = 2;
        }
        this.nextStreamId = i;
        TaskRunner taskRunner = builder.getTaskRunner();
        this.f24441h = taskRunner;
        TaskQueue newQueue = taskRunner.newQueue();
        this.f24442i = newQueue;
        this.f24443j = taskRunner.newQueue();
        this.f24444k = taskRunner.newQueue();
        this.f24445l = builder.getPushObserver();
        Settings settings = new Settings();
        if (builder.getClient()) {
            settings.set(7, 16777216);
        }
        this.okHttpSettings = settings;
        this.peerSettings = f24430D;
        this.writeBytesMaximum = r2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client));
        this.f24433C = new LinkedHashSet();
        if (builder.getPingIntervalMillis() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis());
            newQueue.schedule(AbstractC1726qj.m7057m(connectionName$okhttp, " ping"), nanos, new e11(this, nanos, 0));
        }
    }

    public static final void access$failConnection(Http2Connection http2Connection, IOException iOException) {
        http2Connection.getClass();
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        http2Connection.close$okhttp(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        http2Connection.start(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004b A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #0 {all -> 0x0013, blocks: (B:6:0x0006, B:8:0x000d, B:9:0x0016, B:11:0x001a, B:13:0x002d, B:15:0x0035, B:19:0x0045, B:21:0x004b, B:36:0x0079, B:37:0x007e), top: B:5:0x0006, outer: #1 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Http2Stream m6631a(int i, List list, boolean z) {
        int i2;
        Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.writer) {
            try {
                synchronized (this) {
                    try {
                        if (this.nextStreamId > 1073741823) {
                            shutdown(ErrorCode.REFUSED_STREAM);
                        }
                        if (!this.f24440g) {
                            i2 = this.nextStreamId;
                            this.nextStreamId = i2 + 2;
                            http2Stream = new Http2Stream(i2, this, z3, false, null);
                            if (z && this.writeBytesTotal < this.writeBytesMaximum && http2Stream.getWriteBytesTotal() < http2Stream.getWriteBytesMaximum()) {
                                z2 = false;
                                if (http2Stream.isOpen()) {
                                    this.f24436c.put(Integer.valueOf(i2), http2Stream);
                                }
                            }
                            z2 = true;
                            if (http2Stream.isOpen()) {
                            }
                        } else {
                            throw new ConnectionShutdownException();
                        }
                    } finally {
                    }
                }
                if (i == 0) {
                    this.writer.headers(z3, i2, list);
                } else if (!this.client) {
                    this.writer.pushPromise(i, i2, list);
                } else {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public final synchronized void awaitPong() {
        while (this.f24451r < this.f24450q) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(@NotNull ErrorCode connectionCode, @NotNull ErrorCode streamCode, @Nullable IOException cause) {
        int i;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            shutdown(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (!this.f24436c.isEmpty()) {
                    objArr = this.f24436c.values().toArray(new Http2Stream[0]);
                    if (objArr != null) {
                        this.f24436c.clear();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                } else {
                    objArr = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) objArr;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(streamCode, cause);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.f24442i.shutdown();
        this.f24443j.shutdown();
        this.f24444k.shutdown();
    }

    public final void flush() {
        this.writer.flush();
    }

    /* renamed from: getClient$okhttp, reason: from getter */
    public final boolean getClient() {
        return this.client;
    }

    @NotNull
    /* renamed from: getConnectionName$okhttp, reason: from getter */
    public final String getConnectionName() {
        return this.connectionName;
    }

    /* renamed from: getLastGoodStreamId$okhttp, reason: from getter */
    public final int getLastGoodStreamId() {
        return this.lastGoodStreamId;
    }

    @NotNull
    /* renamed from: getListener$okhttp, reason: from getter */
    public final Listener getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String() {
        return this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
    }

    /* renamed from: getNextStreamId$okhttp, reason: from getter */
    public final int getNextStreamId() {
        return this.nextStreamId;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @NotNull
    /* renamed from: getSocket$okhttp, reason: from getter */
    public final Socket getSocket() {
        return this.socket;
    }

    @Nullable
    public final synchronized Http2Stream getStream(int id) {
        return (Http2Stream) this.f24436c.get(Integer.valueOf(id));
    }

    @NotNull
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.f24436c;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long nowNs) {
        if (this.f24440g) {
            return false;
        }
        if (this.f24449p < this.f24448o) {
            if (nowNs >= this.f24452s) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List<Header> requestHeaders, boolean out) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return m6631a(0, requestHeaders, out);
    }

    public final synchronized int openStreamCount() {
        return this.f24436c.size();
    }

    public final void pushDataLater$okhttp(int streamId, @NotNull BufferedSource r17, int byteCount, boolean inFinished) {
        Intrinsics.checkNotNullParameter(r17, "source");
        Buffer buffer = new Buffer();
        long j = byteCount;
        r17.require(j);
        r17.read(buffer, j);
        TaskQueue.execute$default(this.f24443j, this.connectionName + '[' + streamId + "] onData", 0L, false, new f11(this, streamId, buffer, byteCount, inFinished), 6, null);
    }

    public final void pushHeadersLater$okhttp(int streamId, @NotNull List<Header> requestHeaders, boolean inFinished) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        TaskQueue.execute$default(this.f24443j, this.connectionName + '[' + streamId + "] onHeaders", 0L, false, new g11(this, streamId, requestHeaders, inFinished), 6, null);
    }

    public final void pushRequestLater$okhttp(int streamId, @NotNull List<Header> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.f24433C.contains(Integer.valueOf(streamId))) {
                writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f24433C.add(Integer.valueOf(streamId));
            TaskQueue.execute$default(this.f24443j, this.connectionName + '[' + streamId + "] onRequest", 0L, false, new h11(this, streamId, requestHeaders), 6, null);
        }
    }

    public final void pushResetLater$okhttp(int streamId, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue.execute$default(this.f24443j, this.connectionName + '[' + streamId + "] onReset", 0L, false, new i11(this, streamId, errorCode, 0), 6, null);
    }

    @NotNull
    public final Http2Stream pushStream(int associatedStreamId, @NotNull List<Header> requestHeaders, boolean out) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (!this.client) {
            return m6631a(associatedStreamId, requestHeaders, out);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public final boolean pushedStream$okhttp(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    @Nullable
    public final synchronized Http2Stream removeStream$okhttp(int streamId) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.f24436c.remove(Integer.valueOf(streamId));
        notifyAll();
        return http2Stream;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j = this.f24449p;
            long j2 = this.f24448o;
            if (j < j2) {
                return;
            }
            this.f24448o = j2 + 1;
            this.f24452s = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
            TaskQueue.execute$default(this.f24442i, AbstractC1726qj.m7061q(new StringBuilder(), this.connectionName, " ping"), 0L, false, new C1829tb(9, this), 6, null);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    public final void setPeerSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.f24440g) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(@NotNull ErrorCode statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.writer) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.f24440g) {
                    return;
                }
                this.f24440g = true;
                int i = this.lastGoodStreamId;
                intRef.element = i;
                this.writer.goAway(i, statusCode, _UtilCommonKt.EMPTY_BYTE_ARRAY);
            }
        }
    }

    @JvmOverloads
    public final void start() {
        start$default(this, false, 1, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long read) {
        long j = this.readBytesTotal + read;
        this.readBytesTotal = j;
        long j2 = j - this.readBytesAcknowledged;
        if (j2 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j2);
            this.readBytesAcknowledged += j2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.writer.getF24517d());
        r6 = r2;
        r8.writeBytesTotal += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void writeData(int streamId, boolean outFinished, @Nullable Buffer buffer, long byteCount) {
        int min;
        long j;
        boolean z;
        if (byteCount == 0) {
            this.writer.data(outFinished, streamId, buffer, 0);
            return;
        }
        loop0: while (byteCount > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            long j2 = this.writeBytesTotal;
                            long j3 = this.writeBytesMaximum;
                            if (j2 < j3) {
                                break;
                            } else if (!this.f24436c.containsKey(Integer.valueOf(streamId))) {
                                break loop0;
                            } else {
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            byteCount -= j;
            Http2Writer http2Writer = this.writer;
            if (outFinished && byteCount == 0) {
                z = true;
            } else {
                z = false;
            }
            http2Writer.data(z, streamId, buffer, min);
        }
    }

    public final void writeHeaders$okhttp(int streamId, boolean outFinished, @NotNull List<Header> alternating) {
        Intrinsics.checkNotNullParameter(alternating, "alternating");
        this.writer.headers(outFinished, streamId, alternating);
    }

    public final void writePing(boolean reply, int payload1, int payload2) {
        try {
            this.writer.ping(reply, payload1, payload2);
        } catch (IOException e) {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            close$okhttp(errorCode, errorCode, e);
        }
    }

    public final void writePingAndAwaitPong() {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int streamId, @NotNull ErrorCode statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.writer.rstStream(streamId, statusCode);
    }

    public final void writeSynResetLater$okhttp(int streamId, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue.execute$default(this.f24442i, this.connectionName + '[' + streamId + "] writeSynReset", 0L, false, new i11(this, streamId, errorCode, 1), 6, null);
    }

    public final void writeWindowUpdateLater$okhttp(int streamId, long unacknowledgedBytesRead) {
        TaskQueue.execute$default(this.f24442i, this.connectionName + '[' + streamId + "] windowUpdate", 0L, false, new j11(this, streamId, unacknowledgedBytesRead), 6, null);
    }

    @JvmOverloads
    public final void start(boolean sendConnectionPreface) {
        if (sendConnectionPreface) {
            Http2Writer http2Writer = this.writer;
            http2Writer.connectionPreface();
            Settings settings = this.okHttpSettings;
            http2Writer.settings(settings);
            if (settings.getInitialWindowSize() != 65535) {
                http2Writer.windowUpdate(0, r0 - 65535);
            }
        }
        TaskQueue.execute$default(this.f24441h.newQueue(), this.connectionName, 0L, false, this.readerRunnable, 6, null);
    }

    public final void writePing() {
        synchronized (this) {
            this.f24450q++;
        }
        writePing(false, 3, 1330343787);
    }
}
