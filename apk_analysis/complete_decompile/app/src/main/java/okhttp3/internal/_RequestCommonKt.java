package okhttp3.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\b\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0010\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u0017\u001a\u00020\u0004*\u00020\t\u001a\u0012\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0019\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a1\u0010\u001c\u001a\u00020\u0004\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001d0 2\b\u0010!\u001a\u0004\u0018\u0001H\u001d¢\u0006\u0002\u0010\"¨\u0006#"}, m5569d2 = {"canonicalUrl", "", ImagesContract.URL, "commonAddHeader", "Lokhttp3/Request$Builder;", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", "commonCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Request;", "cacheControl", "commonDelete", "body", "Lokhttp3/RequestBody;", "commonGet", "commonHead", "commonHeader", "commonHeaders", "", "headers", "Lokhttp3/Headers;", "commonMethod", FirebaseAnalytics.Param.METHOD, "commonNewBuilder", "commonPatch", "commonPost", "commonPut", "commonRemoveHeader", "commonTag", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "tag", "(Lokhttp3/Request$Builder;Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _RequestCommonKt {
    @NotNull
    public static final String canonicalUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (ro2.startsWith(url, "ws:", true)) {
            StringBuilder sb = new StringBuilder("http:");
            String substring = url.substring(3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }
        if (ro2.startsWith(url, "wss:", true)) {
            StringBuilder sb2 = new StringBuilder("https:");
            String substring2 = url.substring(4);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(substring2);
            return sb2.toString();
        }
        return url;
    }

    @NotNull
    public static final Request.Builder commonAddHeader(@NotNull Request.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders().add(name, value);
        return builder;
    }

    @NotNull
    public static final CacheControl commonCacheControl(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        CacheControl lazyCacheControl = request.getLazyCacheControl();
        if (lazyCacheControl != null) {
            return lazyCacheControl;
        }
        CacheControl parse = CacheControl.INSTANCE.parse(request.headers());
        request.setLazyCacheControl$okhttp(parse);
        return parse;
    }

    @NotNull
    public static final Request.Builder commonDelete(@NotNull Request.Builder builder, @Nullable RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method(HttpRequest.METHOD_DELETE, requestBody);
    }

    @NotNull
    public static final Request.Builder commonGet(@NotNull Request.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method(HttpRequest.METHOD_GET, null);
    }

    @NotNull
    public static final Request.Builder commonHead(@NotNull Request.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method(HttpRequest.METHOD_HEAD, null);
    }

    @Nullable
    public static final String commonHeader(@NotNull Request request, @NotNull String name) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return request.headers().get(name);
    }

    @NotNull
    public static final List<String> commonHeaders(@NotNull Request request, @NotNull String name) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return request.headers().values(name);
    }

    @NotNull
    public static final Request.Builder commonMethod(@NotNull Request.Builder builder, @NotNull String method, @Nullable RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(method, "method");
        if (method.length() > 0) {
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(method)) {
                    throw new IllegalArgumentException(ye0.m8296p("method ", method, " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(ye0.m8296p("method ", method, " must not have a request body.").toString());
            }
            builder.setMethod$okhttp(method);
            builder.setBody$okhttp(requestBody);
            return builder;
        }
        throw new IllegalArgumentException("method.isEmpty() == true");
    }

    @NotNull
    public static final Request.Builder commonNewBuilder(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        return new Request.Builder(request);
    }

    @NotNull
    public static final Request.Builder commonPatch(@NotNull Request.Builder builder, @NotNull RequestBody body) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return builder.method("PATCH", body);
    }

    @NotNull
    public static final Request.Builder commonPost(@NotNull Request.Builder builder, @NotNull RequestBody body) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return builder.method(HttpRequest.METHOD_POST, body);
    }

    @NotNull
    public static final Request.Builder commonPut(@NotNull Request.Builder builder, @NotNull RequestBody body) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return builder.method(HttpRequest.METHOD_PUT, body);
    }

    @NotNull
    public static final Request.Builder commonRemoveHeader(@NotNull Request.Builder builder, @NotNull String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        builder.getHeaders().removeAll(name);
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Request.Builder commonTag(@NotNull Request.Builder builder, @NotNull KClass<T> type, @Nullable T t) {
        Map<KClass<?>, ? extends Object> asMutableMap;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        if (t == 0) {
            if (!builder.getTags$okhttp().isEmpty()) {
                TypeIntrinsics.asMutableMap(builder.getTags$okhttp()).remove(type);
            }
        } else {
            if (builder.getTags$okhttp().isEmpty()) {
                asMutableMap = new LinkedHashMap<>();
                builder.setTags$okhttp(asMutableMap);
            } else {
                asMutableMap = TypeIntrinsics.asMutableMap(builder.getTags$okhttp());
            }
            asMutableMap.put(type, t);
        }
        return builder;
    }

    @NotNull
    public static final Request.Builder commonHeader(@NotNull Request.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders().set(name, value);
        return builder;
    }

    @NotNull
    public static final Request.Builder commonHeaders(@NotNull Request.Builder builder, @NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }

    @NotNull
    public static final Request.Builder commonCacheControl(@NotNull Request.Builder builder, @NotNull CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
        String cacheControl2 = cacheControl.toString();
        return cacheControl2.length() == 0 ? builder.removeHeader("Cache-Control") : builder.header("Cache-Control", cacheControl2);
    }
}
