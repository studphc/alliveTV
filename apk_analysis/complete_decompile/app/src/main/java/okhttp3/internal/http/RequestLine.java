package okhttp3.internal.http;

import com.google.android.gms.common.internal.ImagesContract;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"Lokhttp3/internal/http/RequestLine;", "", "Lokhttp3/Request;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", "get", "(Lokhttp3/Request;Ljava/net/Proxy$Type;)Ljava/lang/String;", "Lokhttp3/HttpUrl;", ImagesContract.URL, "requestPath", "(Lokhttp3/HttpUrl;)Ljava/lang/String;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RequestLine {

    @NotNull
    public static final RequestLine INSTANCE = new Object();

    @NotNull
    public final String get(@NotNull Request request, @NotNull Proxy.Type proxyType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        RequestLine requestLine = INSTANCE;
        requestLine.getClass();
        if (!request.isHttps() && proxyType == Proxy.Type.HTTP) {
            sb.append(request.url());
        } else {
            sb.append(requestLine.requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String requestPath(@NotNull HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String encodedPath = url.encodedPath();
        String encodedQuery = url.encodedQuery();
        if (encodedQuery != null) {
            return encodedPath + '?' + encodedQuery;
        }
        return encodedPath;
    }
}
