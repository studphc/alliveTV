package okhttp3;

import com.hisona.allive.HttpRequest;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal._ChallengeCommonKt;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.lh1;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0003\u0010\u000fR%\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u00048G¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0005\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0014¨\u0006!"}, m5569d2 = {"Lokhttp3/Challenge;", "", "", "scheme", "", "authParams", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "realm", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "withCharset", "(Ljava/nio/charset/Charset;)Lokhttp3/Challenge;", "-deprecated_scheme", "()Ljava/lang/String;", "-deprecated_authParams", "()Ljava/util/Map;", "-deprecated_realm", "-deprecated_charset", "()Ljava/nio/charset/Charset;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "a", "Ljava/lang/String;", "b", "Ljava/util/Map;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Challenge {

    /* renamed from: a, reason: from kotlin metadata */
    public final String scheme;

    /* renamed from: b, reason: from kotlin metadata */
    public final Map authParams;

    public Challenge(@NotNull String scheme, @NotNull Map<String, String> authParams) {
        String str;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                str = _UtilJvmKt.lowercase(key, US);
            } else {
                str = null;
            }
            linkedHashMap.put(str, value);
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authParams", imports = {}))
    @JvmName(name = "-deprecated_authParams")
    @NotNull
    /* renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m8937deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = HttpRequest.PARAM_CHARSET, imports = {}))
    @JvmName(name = "-deprecated_charset")
    @NotNull
    /* renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m8938deprecated_charset() {
        return charset();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "realm", imports = {}))
    @JvmName(name = "-deprecated_realm")
    @Nullable
    /* renamed from: -deprecated_realm, reason: not valid java name */
    public final String m8939deprecated_realm() {
        return realm();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* renamed from: -deprecated_scheme, reason: not valid java name and from getter */
    public final String getScheme() {
        return this.scheme;
    }

    @JvmName(name = "authParams")
    @NotNull
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @JvmName(name = HttpRequest.PARAM_CHARSET)
    @NotNull
    public final Charset charset() {
        String str = (String) this.authParams.get(HttpRequest.PARAM_CHARSET);
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                Intrinsics.checkNotNullExpressionValue(forName, "forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        return Charsets.ISO_8859_1;
    }

    public boolean equals(@Nullable Object other) {
        return _ChallengeCommonKt.commonEquals(this, other);
    }

    public int hashCode() {
        return _ChallengeCommonKt.commonHashCode(this);
    }

    @JvmName(name = "realm")
    @Nullable
    public final String realm() {
        return (String) this.authParams.get("realm");
    }

    @JvmName(name = "scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return _ChallengeCommonKt.commonToString(this);
    }

    @NotNull
    public final Challenge withCharset(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Map mutableMap = lh1.toMutableMap(this.authParams);
        String name = charset.name();
        Intrinsics.checkNotNullExpressionValue(name, "charset.name()");
        mutableMap.put(HttpRequest.PARAM_CHARSET, name);
        return new Challenge(this.scheme, (Map<String, String>) mutableMap);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Challenge(@NotNull String scheme, @NotNull String realm) {
        this(scheme, (Map<String, String>) r3);
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(realm, "realm");
        Map singletonMap = Collections.singletonMap("realm", realm);
        Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap(\"realm\", realm)");
    }
}
