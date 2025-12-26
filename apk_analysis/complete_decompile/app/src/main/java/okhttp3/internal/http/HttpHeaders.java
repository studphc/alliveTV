package okhttp3.internal.http;

import com.google.android.gms.common.internal.ImagesContract;
import com.hisona.allive.HttpRequest;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1726qj;
import p000.lh1;
import p000.ro2;

@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, m5569d2 = {"Lokhttp3/Headers;", "", "headerName", "", "Lokhttp3/Challenge;", "parseChallenges", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", ImagesContract.URL, "headers", "", "receiveHeaders", "(Lokhttp3/CookieJar;Lokhttp3/HttpUrl;Lokhttp3/Headers;)V", "Lokhttp3/Response;", "", "promisesBody", "(Lokhttp3/Response;)Z", "response", "hasBody", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
@JvmName(name = "HttpHeaders")
/* loaded from: classes2.dex */
public final class HttpHeaders {

    /* renamed from: a */
    public static final ByteString f24389a;

    /* renamed from: b */
    public static final ByteString f24390b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f24389a = companion.encodeUtf8("\"\\");
        f24390b = companion.encodeUtf8("\t ,=");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x010a, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b8, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x010a, code lost:
    
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m6620a(Buffer buffer, ArrayList arrayList) {
        String m6621b;
        int skipAll;
        String m6621b2;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    m6622c(buffer);
                    str = m6621b(buffer);
                    if (str == null) {
                        return;
                    }
                }
                boolean m6622c = m6622c(buffer);
                m6621b = m6621b(buffer);
                if (m6621b == null) {
                    if (!buffer.exhausted()) {
                        return;
                    }
                    arrayList.add(new Challenge(str, (Map<String, String>) lh1.emptyMap()));
                    return;
                }
                byte b = (byte) 61;
                skipAll = _UtilCommonKt.skipAll(buffer, b);
                boolean m6622c2 = m6622c(buffer);
                if (m6622c || (!m6622c2 && !buffer.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int skipAll2 = _UtilCommonKt.skipAll(buffer, b) + skipAll;
                    while (true) {
                        if (m6621b == null) {
                            m6621b = m6621b(buffer);
                            if (!m6622c(buffer)) {
                                skipAll2 = _UtilCommonKt.skipAll(buffer, b);
                            }
                        }
                        if (skipAll2 != 0) {
                            if (skipAll2 > 1 || m6622c(buffer)) {
                                return;
                            }
                            byte b2 = (byte) 34;
                            if (!buffer.exhausted() && buffer.getByte(0L) == b2) {
                                if (buffer.readByte() == b2) {
                                    Buffer buffer2 = new Buffer();
                                    while (true) {
                                        long indexOfElement = buffer.indexOfElement(f24389a);
                                        if (indexOfElement == -1) {
                                            break;
                                        }
                                        if (buffer.getByte(indexOfElement) == b2) {
                                            buffer2.write(buffer, indexOfElement);
                                            buffer.readByte();
                                            m6621b2 = buffer2.readUtf8();
                                            break;
                                        } else {
                                            if (buffer.size() == indexOfElement + 1) {
                                                break;
                                            }
                                            buffer2.write(buffer, indexOfElement);
                                            buffer.readByte();
                                            buffer2.write(buffer, 1L);
                                        }
                                    }
                                } else {
                                    throw new IllegalArgumentException("Failed requirement.");
                                }
                            } else {
                                m6621b2 = m6621b(buffer);
                            }
                            if (m6621b2 == null || ((String) linkedHashMap.put(m6621b, m6621b2)) != null) {
                                return;
                            }
                            if (!m6622c(buffer) && !buffer.exhausted()) {
                                return;
                            } else {
                                m6621b = null;
                            }
                        }
                    }
                    arrayList.add(new Challenge(str, linkedHashMap));
                    str = m6621b;
                }
            }
            StringBuilder m7064t = AbstractC1726qj.m7064t(m6621b);
            m7064t.append(ro2.repeat("=", skipAll));
            Map singletonMap = Collections.singletonMap(null, m7064t.toString());
            Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
            arrayList.add(new Challenge(str, (Map<String, String>) singletonMap));
        }
    }

    /* renamed from: b */
    public static final String m6621b(Buffer buffer) {
        long indexOfElement = buffer.indexOfElement(f24390b);
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        if (indexOfElement != 0) {
            return buffer.readUtf8(indexOfElement);
        }
        return null;
    }

    /* renamed from: c */
    public static final boolean m6622c(Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            if (b == ((byte) 44)) {
                buffer.readByte();
                z = true;
            } else {
                if (b != ((byte) 32) && b != ((byte) 9)) {
                    break;
                }
                buffer.readByte();
            }
        }
        return z;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return promisesBody(response);
    }

    @NotNull
    public static final List<Challenge> parseChallenges(@NotNull Headers headers, @NotNull String headerName) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (ro2.equals(headerName, headers.name(i), true)) {
                try {
                    m6620a(new Buffer().writeUtf8(headers.value(i)), arrayList);
                } catch (EOFException e) {
                    Platform.INSTANCE.get().log("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        if (Intrinsics.areEqual(response.request().method(), HttpRequest.METHOD_HEAD)) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && _UtilJvmKt.headersContentLength(response) == -1 && !ro2.equals("chunked", Response.header$default(response, com.google.common.net.HttpHeaders.TRANSFER_ENCODING, null, 2, null), true)) {
            return false;
        }
        return true;
    }

    public static final void receiveHeaders(@NotNull CookieJar cookieJar, @NotNull HttpUrl url, @NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(cookieJar, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.INSTANCE.parseAll(url, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(url, parseAll);
    }
}
