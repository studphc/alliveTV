package okhttp3.logging;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.logging.internal.Utf8Kt;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1327iq;
import p000.AbstractC1726qj;
import p000.ro2;
import p000.sh2;
import p000.ye0;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\f\u0010\u001a¨\u0006\u001d"}, m5569d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "redactHeader", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", FirebaseAnalytics.Param.LEVEL, "setLevel", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "-deprecated_level", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "<set-?>", "c", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "Level", "Logger", "logging-interceptor"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: a */
    public final Logger f24657a;

    /* renamed from: b */
    public volatile Set f24658b;

    /* renamed from: c, reason: from kotlin metadata */
    public volatile Level level;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5569d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "NONE", "BASIC", "HEADERS", "BODY", "logging-interceptor"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Level {
        public static final Level BASIC;
        public static final Level BODY;
        public static final Level HEADERS;
        public static final Level NONE;

        /* renamed from: a */
        public static final /* synthetic */ Level[] f24660a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, okhttp3.logging.HttpLoggingInterceptor$Level] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, okhttp3.logging.HttpLoggingInterceptor$Level] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, okhttp3.logging.HttpLoggingInterceptor$Level] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, okhttp3.logging.HttpLoggingInterceptor$Level] */
        static {
            ?? r4 = new Enum("NONE", 0);
            NONE = r4;
            ?? r5 = new Enum("BASIC", 1);
            BASIC = r5;
            ?? r6 = new Enum("HEADERS", 2);
            HEADERS = r6;
            ?? r7 = new Enum("BODY", 3);
            BODY = r7;
            f24660a = new Level[]{r4, r5, r6, r7};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f24660a.clone();
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m5569d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "logging-interceptor"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public interface Logger {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f24661a;

        @JvmField
        @NotNull
        public static final Logger DEFAULT = new Object();

        @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\u0006"}, m5569d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "okhttp3/logging/a", "logging-interceptor"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {

            /* renamed from: a */
            public static final /* synthetic */ Companion f24661a = new Object();
        }

        void log(@NotNull String message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.LEVEL, imports = {}))
    @JvmName(name = "-deprecated_level")
    @NotNull
    /* renamed from: -deprecated_level, reason: not valid java name and from getter */
    public final Level getLevel() {
        return this.level;
    }

    /* renamed from: a */
    public final void m6649a(Headers headers, int i) {
        String value;
        if (this.f24658b.contains(headers.name(i))) {
            value = "██";
        } else {
            value = headers.value(i);
        }
        this.f24657a.log(headers.name(i) + ": " + value);
    }

    @NotNull
    public final Level getLevel() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104 A[LOOP:0: B:35:0x0102->B:36:0x0104, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x033b  */
    @Override // okhttp3.Interceptor
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(@NotNull Interceptor.Chain chain) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Response proceed;
        long f24401c;
        String str7;
        String str8;
        String str9;
        long j;
        String m7038C;
        String str10;
        String str11;
        Long l;
        GzipSource gzipSource;
        String str12;
        String str13;
        int size;
        int i;
        Long l2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        if (level == Level.BODY) {
            z = true;
        } else {
            z = false;
        }
        if (!z && level != Level.HEADERS) {
            z2 = false;
        } else {
            z2 = true;
        }
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        if (connection == null) {
            str = "";
        } else {
            str = " " + connection.protocol();
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (!z2 && body != null) {
            StringBuilder m8303w = ye0.m8303w(sb2, " (");
            m8303w.append(body.contentLength());
            m8303w.append("-byte body)");
            sb2 = m8303w.toString();
        }
        this.f24657a.log(sb2);
        try {
            if (z2) {
                Headers headers = request.headers();
                z3 = z2;
                if (body == null) {
                    str12 = "-gzipped-byte body)";
                    str13 = "-byte body)";
                } else {
                    MediaType contentType = body.contentType();
                    if (contentType != null && headers.get("Content-Type") == null) {
                        str13 = "-byte body)";
                        str12 = "-gzipped-byte body)";
                        this.f24657a.log("Content-Type: " + contentType);
                    } else {
                        str12 = "-gzipped-byte body)";
                        str13 = "-byte body)";
                    }
                    if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                        Logger logger = this.f24657a;
                        StringBuilder sb3 = new StringBuilder("Content-Length: ");
                        str5 = "-byte, ";
                        sb3.append(body.contentLength());
                        logger.log(sb3.toString());
                        size = headers.size();
                        for (i = 0; i < size; i++) {
                            m6649a(headers, i);
                        }
                        if (z || body == null) {
                            str3 = HttpRequest.ENCODING_GZIP;
                            str2 = str13;
                            str4 = str12;
                            str6 = "";
                            this.f24657a.log("--> END " + request.method());
                        } else {
                            String str14 = request.headers().get("Content-Encoding");
                            if (str14 != null && !ro2.equals(str14, "identity", true) && !ro2.equals(str14, HttpRequest.ENCODING_GZIP, true)) {
                                this.f24657a.log("--> END " + request.method() + " (encoded body omitted)");
                            } else if (body.isDuplex()) {
                                this.f24657a.log("--> END " + request.method() + " (duplex request body omitted)");
                            } else if (body.isOneShot()) {
                                this.f24657a.log("--> END " + request.method() + " (one-shot body omitted)");
                            } else {
                                Buffer buffer = new Buffer();
                                body.writeTo(buffer);
                                if (ro2.equals(HttpRequest.ENCODING_GZIP, headers.get("Content-Encoding"), true)) {
                                    l2 = Long.valueOf(buffer.size());
                                    gzipSource = new GzipSource(buffer);
                                    try {
                                        buffer = new Buffer();
                                        buffer.writeAll(gzipSource);
                                        CloseableKt.closeFinally(gzipSource, null);
                                    } finally {
                                    }
                                } else {
                                    l2 = null;
                                }
                                MediaType contentType2 = body.contentType();
                                str3 = HttpRequest.ENCODING_GZIP;
                                Charset charset$default = Internal.charset$default(contentType2, null, 1, null);
                                this.f24657a.log("");
                                if (!Utf8Kt.isProbablyUtf8(buffer)) {
                                    this.f24657a.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                                    str6 = "";
                                    str2 = str13;
                                    str4 = str12;
                                } else if (l2 == null) {
                                    str6 = "";
                                    str4 = str12;
                                    this.f24657a.log(buffer.readString(charset$default));
                                    Logger logger2 = this.f24657a;
                                    StringBuilder sb4 = new StringBuilder("--> END ");
                                    sb4.append(request.method());
                                    sb4.append(" (");
                                    sb4.append(body.contentLength());
                                    str2 = str13;
                                    sb4.append(str2);
                                    logger2.log(sb4.toString());
                                } else {
                                    Logger logger3 = this.f24657a;
                                    StringBuilder sb5 = new StringBuilder("--> END ");
                                    sb5.append(request.method());
                                    sb5.append(" (");
                                    str6 = "";
                                    sb5.append(buffer.size());
                                    sb5.append(str5);
                                    sb5.append(l2);
                                    str4 = str12;
                                    sb5.append(str4);
                                    logger3.log(sb5.toString());
                                    str2 = str13;
                                }
                            }
                            str3 = HttpRequest.ENCODING_GZIP;
                            str2 = str13;
                            str4 = str12;
                        }
                        long nanoTime = System.nanoTime();
                        proceed = chain.proceed(request);
                        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
                        ResponseBody body2 = proceed.body();
                        Intrinsics.checkNotNull(body2);
                        f24401c = body2.getF24401c();
                        if (f24401c != -1) {
                            str8 = str6;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(f24401c);
                            str7 = str2;
                            sb6.append("-byte");
                            str9 = sb6.toString();
                        } else {
                            str7 = str2;
                            str8 = str6;
                            str9 = "unknown-length";
                        }
                        Logger logger4 = this.f24657a;
                        String str15 = str4;
                        String str16 = str5;
                        StringBuilder sb7 = new StringBuilder("<-- ");
                        sb7.append(proceed.code());
                        if (proceed.message().length() == 0) {
                            j = f24401c;
                            m7038C = str8;
                        } else {
                            j = f24401c;
                            m7038C = AbstractC1726qj.m7038C(" ", proceed.message());
                        }
                        sb7.append(m7038C);
                        sb7.append(' ');
                        sb7.append(proceed.request().url());
                        sb7.append(" (");
                        sb7.append(millis);
                        sb7.append("ms");
                        if (!z3) {
                            str10 = ye0.m8296p(", ", str9, " body");
                        } else {
                            str10 = str8;
                        }
                        sb7.append(str10);
                        sb7.append(')');
                        logger4.log(sb7.toString());
                        if (z3) {
                            Headers headers2 = proceed.headers();
                            int size2 = headers2.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                m6649a(headers2, i2);
                            }
                            if (z && HttpHeaders.promisesBody(proceed)) {
                                String str17 = proceed.headers().get("Content-Encoding");
                                if (str17 == null || ro2.equals(str17, "identity", true)) {
                                    str11 = str3;
                                } else {
                                    str11 = str3;
                                    if (!ro2.equals(str17, str11, true)) {
                                        this.f24657a.log("<-- END HTTP (encoded body omitted)");
                                    }
                                }
                                BufferedSource f24402d = body2.getF24402d();
                                f24402d.request(Long.MAX_VALUE);
                                Buffer buffer2 = f24402d.getBuffer();
                                if (ro2.equals(str11, headers2.get("Content-Encoding"), true)) {
                                    l = Long.valueOf(buffer2.size());
                                    gzipSource = new GzipSource(buffer2.clone());
                                    try {
                                        buffer2 = new Buffer();
                                        buffer2.writeAll(gzipSource);
                                        CloseableKt.closeFinally(gzipSource, null);
                                    } finally {
                                        try {
                                            throw th;
                                        } finally {
                                        }
                                    }
                                } else {
                                    l = null;
                                }
                                Charset charset$default2 = Internal.charset$default(body2.contentType(), null, 1, null);
                                if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                                    this.f24657a.log(str8);
                                    this.f24657a.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                                    return proceed;
                                }
                                String str18 = str8;
                                if (j != 0) {
                                    this.f24657a.log(str18);
                                    this.f24657a.log(buffer2.clone().readString(charset$default2));
                                }
                                if (l != null) {
                                    this.f24657a.log("<-- END HTTP (" + buffer2.size() + str16 + l + str15);
                                } else {
                                    this.f24657a.log("<-- END HTTP (" + buffer2.size() + str7);
                                }
                            } else {
                                this.f24657a.log("<-- END HTTP");
                            }
                        }
                        return proceed;
                    }
                }
                str5 = "-byte, ";
                size = headers.size();
                while (i < size) {
                }
                if (z) {
                }
                str3 = HttpRequest.ENCODING_GZIP;
                str2 = str13;
                str4 = str12;
                str6 = "";
                this.f24657a.log("--> END " + request.method());
                long nanoTime2 = System.nanoTime();
                proceed = chain.proceed(request);
                long millis2 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime2);
                ResponseBody body22 = proceed.body();
                Intrinsics.checkNotNull(body22);
                f24401c = body22.getF24401c();
                if (f24401c != -1) {
                }
                Logger logger42 = this.f24657a;
                String str152 = str4;
                String str162 = str5;
                StringBuilder sb72 = new StringBuilder("<-- ");
                sb72.append(proceed.code());
                if (proceed.message().length() == 0) {
                }
                sb72.append(m7038C);
                sb72.append(' ');
                sb72.append(proceed.request().url());
                sb72.append(" (");
                sb72.append(millis2);
                sb72.append("ms");
                if (!z3) {
                }
                sb72.append(str10);
                sb72.append(')');
                logger42.log(sb72.toString());
                if (z3) {
                }
                return proceed;
            }
            z3 = z2;
            str2 = "-byte body)";
            str3 = HttpRequest.ENCODING_GZIP;
            str4 = "-gzipped-byte body)";
            str5 = "-byte, ";
            proceed = chain.proceed(request);
            long millis22 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime2);
            ResponseBody body222 = proceed.body();
            Intrinsics.checkNotNull(body222);
            f24401c = body222.getF24401c();
            if (f24401c != -1) {
            }
            Logger logger422 = this.f24657a;
            String str1522 = str4;
            String str1622 = str5;
            StringBuilder sb722 = new StringBuilder("<-- ");
            sb722.append(proceed.code());
            if (proceed.message().length() == 0) {
            }
            sb722.append(m7038C);
            sb722.append(' ');
            sb722.append(proceed.request().url());
            sb722.append(" (");
            sb722.append(millis22);
            sb722.append("ms");
            if (!z3) {
            }
            sb722.append(str10);
            sb722.append(')');
            logger422.log(sb722.toString());
            if (z3) {
            }
            return proceed;
        } catch (Exception e) {
            this.f24657a.log("<-- HTTP FAILED: " + e);
            throw e;
        }
        str6 = "";
        long nanoTime22 = System.nanoTime();
    }

    @JvmName(name = FirebaseAnalytics.Param.LEVEL)
    public final void level(@NotNull Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TreeSet treeSet = new TreeSet(ro2.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        AbstractC1327iq.addAll(treeSet, this.f24658b);
        treeSet.add(name);
        this.f24658b = treeSet;
    }

    @NotNull
    public final HttpLoggingInterceptor setLevel(@NotNull Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.level = level;
        return this;
    }

    @JvmOverloads
    public HttpLoggingInterceptor(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f24657a = logger;
        this.f24658b = sh2.emptySet();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
