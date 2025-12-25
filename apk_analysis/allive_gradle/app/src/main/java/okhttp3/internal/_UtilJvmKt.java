package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1204fq;
import p000.AbstractC1726qj;
import p000.C1294i5;
import p000.r82;

@Metadata(m5568d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000\u001a'\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0004\b\u0000\u0010\u001a2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001a0\u0015\"\u0002H\u001aH\u0007¢\u0006\u0002\u0010\u001c\u001a3\u0010\u001d\u001a\u0004\u0018\u0001H\u001a\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001e\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001a0 2\u0006\u0010!\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\"\u001a\u0016\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t\u001a\"\u0010&\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)H\u0080\bø\u0001\u0000\u001a\f\u0010*\u001a\u00020+*\u00020,H\u0000\u001a\r\u0010-\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\r\u0010.\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\u0014\u0010/\u001a\u00020\t*\u0002002\u0006\u00101\u001a\u000200H\u0000\u001a\n\u00102\u001a\u00020'*\u000203\u001a\f\u00102\u001a\u00020'*\u000204H\u0000\u001a\u001c\u00105\u001a\u00020\t*\u0002062\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0012H\u0000\u001a\f\u00109\u001a\u00020\u0010*\u00020:H\u0000\u001a\u0014\u0010;\u001a\u00020\t*\u0002042\u0006\u0010<\u001a\u00020=H\u0000\u001a\r\u0010>\u001a\u00020\u000b*\u00020\u000bH\u0086\b\u001a\u0012\u0010>\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020@\u001a\r\u0010A\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\r\u0010B\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\n\u0010C\u001a\u00020\u000b*\u000204\u001a\u0014\u0010D\u001a\u00020E*\u00020=2\u0006\u0010F\u001a\u00020EH\u0000\u001a\u001c\u0010G\u001a\u00020\t*\u0002062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0012H\u0000\u001a\u0012\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u0019*\u00020\u0001H\u0000\u001a\u0012\u0010J\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020I0\u0019H\u0000\u001a\f\u0010K\u001a\u00020\u000b*\u00020\rH\u0000\u001a\f\u0010K\u001a\u00020\u000b*\u00020\u0010H\u0000\u001a\u0016\u0010L\u001a\u00020\u000b*\u0002002\b\b\u0002\u0010M\u001a\u00020\tH\u0000\u001a\u001c\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u0019\u001a\r\u0010O\u001a\u00020\u000b*\u00020\u000bH\u0086\b\u001a\u0012\u0010O\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020@\u001a\r\u0010P\u001a\u00020'*\u00020\u0016H\u0080\b\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000*\n\u0010Q\"\u0002002\u000200\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006R"}, m5569d2 = {"EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UTC", "Ljava/util/TimeZone;", "assertionsEnabled", "", "okHttpName", "", "checkDuration", "", AppMeasurementSdk.ConditionalUserProperty.NAME, TypedValues.TransitionType.S_DURATION, "", "unit", "Ljava/util/concurrent/TimeUnit;", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "immutableListOf", "", ExifInterface.GPS_DIRECTION_TRUE, "elements", "([Ljava/lang/Object;)Ljava/util/List;", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "", "block", "Lkotlin/Function0;", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "discard", "Lokio/Source;", "timeout", "timeUnit", "headersContentLength", "Lokhttp3/Response;", "isHealthy", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSource;", "lowercase", "locale", "Ljava/util/Locale;", "notify", "notifyAll", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "skipAll", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "uppercase", "wait", "HttpUrlRepresentation", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _UtilJvmKt {

    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = _UtilCommonKt.getCommonEmptyHeaders();

    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST = _UtilCommonKt.getCommonEmptyRequestBody();

    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE = _UtilCommonKt.getCommonEmptyResponse();

    @JvmField
    @NotNull
    public static final TimeZone UTC;

    @JvmField
    public static final boolean assertionsEnabled;

    @JvmField
    @NotNull
    public static final String okHttpName;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removePrefix(name, (CharSequence) "okhttp3."), (CharSequence) "Client");
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "<this>");
        return new C1294i5(24, eventListener);
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (assertionsEnabled && !Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
        }
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl httpUrl, @NotNull HttpUrl other) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(httpUrl.host(), other.host()) && httpUrl.port() == other.port() && Intrinsics.areEqual(httpUrl.scheme(), other.scheme())) {
            return true;
        }
        return false;
    }

    public static final int checkDuration(@NotNull String name, long j, @Nullable TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (j >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis <= 2147483647L) {
                    if (millis == 0 && j > 0) {
                        throw new IllegalArgumentException(AbstractC1726qj.m7057m(name, " too small.").toString());
                    }
                    return (int) millis;
                }
                throw new IllegalArgumentException(AbstractC1726qj.m7057m(name, " too large.").toString());
            }
            throw new IllegalStateException("unit == null");
        }
        throw new IllegalStateException(AbstractC1726qj.m7057m(name, " < 0").toString());
    }

    public static final void closeQuietly(@NotNull Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!Intrinsics.areEqual(e2.getMessage(), "bio == null")) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean discard(@NotNull Source source, int i, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final String format(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final long headersContentLength(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str == null) {
            return -1L;
        }
        return _UtilCommonKt.toLongOrDefault(str, -1L);
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final boolean isHealthy(@NotNull Socket socket, @NotNull BufferedSource source) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z = !source.exhausted();
                socket.setSoTimeout(soTimeout);
                return z;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    @NotNull
    public static final String lowercase(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static final void notify(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        obj.notifyAll();
    }

    @NotNull
    public static final String peerName(@NotNull Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            Intrinsics.checkNotNullExpressionValue(hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource bufferedSource, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        int select = bufferedSource.select(_UtilCommonKt.getUNICODE_BOMS());
        if (select != -1) {
            if (select != 0) {
                if (select != 1) {
                    if (select != 2) {
                        if (select != 3) {
                            if (select == 4) {
                                return Charsets.INSTANCE.UTF32_LE();
                            }
                            throw new AssertionError();
                        }
                        return Charsets.INSTANCE.UTF32_BE();
                    }
                    return Charsets.UTF_16LE;
                }
                return Charsets.UTF_16BE;
            }
            return Charsets.UTF_8;
        }
        return charset;
    }

    @Nullable
    public static final <T> T readFieldOrNull(@NotNull Object instance, @NotNull Class<T> fieldType, @NotNull String fieldName) {
        T t;
        Object readFieldOrNull;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Class<?> cls = instance.getClass();
        while (true) {
            t = null;
            if (!Intrinsics.areEqual(cls, Object.class)) {
                try {
                    Field declaredField = cls.getDeclaredField(fieldName);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(instance);
                    if (!fieldType.isInstance(obj)) {
                        break;
                    }
                    t = fieldType.cast(obj);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                    Intrinsics.checkNotNullExpressionValue(cls, "c.superclass");
                }
            } else {
                if (Intrinsics.areEqual(fieldName, "delegate") || (readFieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(readFieldOrNull, fieldType, fieldName);
            }
        }
        return t;
    }

    public static final boolean skipAll(@NotNull Source source, int i, @NotNull TimeUnit timeUnit) {
        long j;
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        if (source.getF24675a().getF24765a()) {
            j = source.getF24675a().deadlineNanoTime() - nanoTime;
        } else {
            j = Long.MAX_VALUE;
        }
        source.getF24675a().deadlineNanoTime(Math.min(j, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                buffer.clear();
            }
            if (j == Long.MAX_VALUE) {
                source.getF24675a().clearDeadline();
            } else {
                source.getF24675a().deadlineNanoTime(nanoTime + j);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (j == Long.MAX_VALUE) {
                source.getF24675a().clearDeadline();
            } else {
                source.getF24675a().deadlineNanoTime(nanoTime + j);
            }
            return false;
        } catch (Throwable th) {
            if (j == Long.MAX_VALUE) {
                source.getF24675a().clearDeadline();
            } else {
                source.getF24675a().deadlineNanoTime(nanoTime + j);
            }
            throw th;
        }
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull final String name, final boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() { // from class: t63
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Headers headers = _UtilJvmKt.EMPTY_HEADERS;
                String name2 = name;
                Intrinsics.checkNotNullParameter(name2, "$name");
                Thread thread = new Thread(runnable, name2);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static final void threadName(@NotNull String name, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            currentThread.setName(name2);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        IntRange until = r82.until(0, headers.size());
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.getName().utf8(), header.getValue().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl httpUrl, boolean z) {
        String host;
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        if (StringsKt__StringsKt.contains$default((CharSequence) httpUrl.host(), (CharSequence) ":", false, 2, (Object) null)) {
            host = "[" + httpUrl.host() + ']';
        } else {
            host = httpUrl.host();
        }
        if (z || httpUrl.port() != HttpUrl.INSTANCE.defaultPort(httpUrl.scheme())) {
            return host + ':' + httpUrl.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    @NotNull
    public static final String uppercase(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = str.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static final void wait(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        obj.wait();
    }

    @NotNull
    public static final String lowercase(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @NotNull
    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    @NotNull
    public static final String uppercase(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static final void closeQuietly(@NotNull ServerSocket serverSocket) {
        Intrinsics.checkNotNullParameter(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }
}
