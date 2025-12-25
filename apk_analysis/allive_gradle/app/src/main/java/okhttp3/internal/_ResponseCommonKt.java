package okhttp3.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpStatusCodesKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\t\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u001a\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001e\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010\"\u001a\u00020\u0010*\u00020\u00102\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#\u001a\u0019\u0010%\u001a\u00020\u0010*\u00020\u00102\u0006\u0010$\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&\u001a!\u0010\t\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010(\u001a!\u0010)\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b)\u0010(\u001a\u0019\u0010*\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b*\u0010&\u001a\u0019\u0010\u0006\u001a\u00020\u0010*\u00020\u00102\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b\u0006\u0010-\u001a\u001f\u00100\u001a\u00020\u0010*\u00020\u00102\f\u0010/\u001a\b\u0012\u0004\u0012\u00020+0.¢\u0006\u0004\b0\u00101\u001a\u0019\u00103\u001a\u00020\u0010*\u00020\u00102\u0006\u00102\u001a\u00020\r¢\u0006\u0004\b3\u00104\u001a\u001b\u00106\u001a\u00020\u0010*\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b6\u00107\u001a\u001b\u00109\u001a\u00020\u0010*\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b9\u00107\u001a\u001b\u0010;\u001a\u00020\u0010*\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b;\u00107\"\u0015\u0010?\u001a\u00020<*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0015\u0010A\u001a\u00020<*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b@\u0010>\"\u0015\u0010E\u001a\u00020B*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, m5569d2 = {"Lokhttp3/Response;", "stripBody", "(Lokhttp3/Response;)Lokhttp3/Response;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "commonHeaders", "(Lokhttp3/Response;Ljava/lang/String;)Ljava/util/List;", "defaultValue", "commonHeader", "(Lokhttp3/Response;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "byteCount", "Lokhttp3/ResponseBody;", "commonPeekBody", "(Lokhttp3/Response;J)Lokhttp3/ResponseBody;", "Lokhttp3/Response$Builder;", "commonNewBuilder", "(Lokhttp3/Response;)Lokhttp3/Response$Builder;", "", "commonClose", "(Lokhttp3/Response;)V", "commonToString", "(Lokhttp3/Response;)Ljava/lang/String;", "Lokhttp3/Request;", "request", "commonRequest", "(Lokhttp3/Response$Builder;Lokhttp3/Request;)Lokhttp3/Response$Builder;", "Lokhttp3/Protocol;", "protocol", "commonProtocol", "(Lokhttp3/Response$Builder;Lokhttp3/Protocol;)Lokhttp3/Response$Builder;", "", "code", "commonCode", "(Lokhttp3/Response$Builder;I)Lokhttp3/Response$Builder;", "message", "commonMessage", "(Lokhttp3/Response$Builder;Ljava/lang/String;)Lokhttp3/Response$Builder;", "value", "(Lokhttp3/Response$Builder;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;", "commonAddHeader", "commonRemoveHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Response$Builder;Lokhttp3/Headers;)Lokhttp3/Response$Builder;", "Lkotlin/Function0;", "trailersFn", "commonTrailers", "(Lokhttp3/Response$Builder;Lkotlin/jvm/functions/Function0;)Lokhttp3/Response$Builder;", "body", "commonBody", "(Lokhttp3/Response$Builder;Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;", "networkResponse", "commonNetworkResponse", "(Lokhttp3/Response$Builder;Lokhttp3/Response;)Lokhttp3/Response$Builder;", "cacheResponse", "commonCacheResponse", "priorResponse", "commonPriorResponse", "", "getCommonIsSuccessful", "(Lokhttp3/Response;)Z", "commonIsSuccessful", "getCommonIsRedirect", "commonIsRedirect", "Lokhttp3/CacheControl;", "getCommonCacheControl", "(Lokhttp3/Response;)Lokhttp3/CacheControl;", "commonCacheControl", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _ResponseCommonKt {
    /* renamed from: a */
    public static final void m6601a(Response response, String str) {
        if (response != null) {
            if (response.networkResponse() == null) {
                if (response.cacheResponse() == null) {
                    if (response.priorResponse() != null) {
                        throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
                    }
                    return;
                }
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
        }
    }

    @NotNull
    public static final Response.Builder commonAddHeader(@NotNull Response.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders().add(name, value);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonBody(@NotNull Response.Builder builder, @NotNull ResponseBody body) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        builder.setBody$okhttp(body);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonCacheResponse(@NotNull Response.Builder builder, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        m6601a(response, "cacheResponse");
        builder.setCacheResponse$okhttp(response);
        return builder;
    }

    public static final void commonClose(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        response.body().close();
    }

    @NotNull
    public static final Response.Builder commonCode(@NotNull Response.Builder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setCode$okhttp(i);
        return builder;
    }

    @JvmOverloads
    @Nullable
    public static final String commonHeader(@NotNull Response response, @NotNull String name, @Nullable String str) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        String str2 = response.headers().get(name);
        return str2 == null ? str : str2;
    }

    @NotNull
    public static final List<String> commonHeaders(@NotNull Response response, @NotNull String name) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return response.headers().values(name);
    }

    @NotNull
    public static final Response.Builder commonMessage(@NotNull Response.Builder builder, @NotNull String message) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        builder.setMessage$okhttp(message);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonNetworkResponse(@NotNull Response.Builder builder, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        m6601a(response, "networkResponse");
        builder.setNetworkResponse$okhttp(response);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonNewBuilder(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return new Response.Builder(response);
    }

    @NotNull
    public static final ResponseBody commonPeekBody(@NotNull Response response, long j) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        BufferedSource peek = response.body().getF24155d().peek();
        Buffer buffer = new Buffer();
        peek.request(j);
        buffer.write((Source) peek, Math.min(j, peek.getBuffer().size()));
        return ResponseBody.INSTANCE.create(buffer, response.body().getF24142b(), buffer.size());
    }

    @NotNull
    public static final Response.Builder commonPriorResponse(@NotNull Response.Builder builder, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setPriorResponse$okhttp(response);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonProtocol(@NotNull Response.Builder builder, @NotNull Protocol protocol) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        builder.setProtocol$okhttp(protocol);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonRemoveHeader(@NotNull Response.Builder builder, @NotNull String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        builder.getHeaders().removeAll(name);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonRequest(@NotNull Response.Builder builder, @NotNull Request request) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        builder.setRequest$okhttp(request);
        return builder;
    }

    @NotNull
    public static final String commonToString(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return "Response{protocol=" + response.protocol() + ", code=" + response.code() + ", message=" + response.message() + ", url=" + response.request().url() + '}';
    }

    @NotNull
    public static final Response.Builder commonTrailers(@NotNull Response.Builder builder, @NotNull Function0<Headers> trailersFn) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(trailersFn, "trailersFn");
        builder.setTrailersFn$okhttp(trailersFn);
        return builder;
    }

    @NotNull
    public static final CacheControl getCommonCacheControl(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        CacheControl lazyCacheControl = response.getLazyCacheControl();
        if (lazyCacheControl == null) {
            CacheControl parse = CacheControl.INSTANCE.parse(response.headers());
            response.setLazyCacheControl$okhttp(parse);
            return parse;
        }
        return lazyCacheControl;
    }

    public static final boolean getCommonIsRedirect(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        int code = response.code();
        if (code != 307 && code != 308) {
            switch (code) {
                case HttpStatusCodesKt.HTTP_MULT_CHOICE /* 300 */:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static final boolean getCommonIsSuccessful(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        int code = response.code();
        if (200 > code || code >= 300) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final Response stripBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return response.newBuilder().body(new UnreadableResponseBody(response.body().getF24142b(), response.body().getF24143c())).build();
    }

    @NotNull
    public static final Response.Builder commonHeader(@NotNull Response.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders().set(name, value);
        return builder;
    }

    @NotNull
    public static final Response.Builder commonHeaders(@NotNull Response.Builder builder, @NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }
}
