package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.hisona.allive.HttpRequest;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000.ye0;

/* loaded from: classes.dex */
public final class DataSpec {
    public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 4;
    public static final int FLAG_ALLOW_GZIP = 1;
    public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 2;
    public static final int FLAG_MIGHT_NOT_USE_FULL_NETWORK_SPEED = 8;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_HEAD = 3;
    public static final int HTTP_METHOD_POST = 2;

    @Deprecated
    public final long absoluteStreamPosition;

    @Nullable
    public final Object customData;
    public final int flags;

    @Nullable
    public final byte[] httpBody;
    public final int httpMethod;
    public final Map<String, String> httpRequestHeaders;

    @Nullable
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;
    public final long uriPositionOffset;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public Uri f12422a;

        /* renamed from: b */
        public long f12423b;

        /* renamed from: d */
        public byte[] f12425d;

        /* renamed from: f */
        public long f12427f;

        /* renamed from: h */
        public String f12429h;

        /* renamed from: i */
        public int f12430i;

        /* renamed from: j */
        public Object f12431j;

        /* renamed from: c */
        public int f12424c = 1;

        /* renamed from: e */
        public Map f12426e = Collections.emptyMap();

        /* renamed from: g */
        public long f12428g = -1;

        public DataSpec build() {
            Assertions.checkStateNotNull(this.f12422a, "The uri must be set.");
            return new DataSpec(this.f12422a, this.f12423b, this.f12424c, this.f12425d, this.f12426e, this.f12427f, this.f12428g, this.f12429h, this.f12430i, this.f12431j);
        }

        public Builder setCustomData(@Nullable Object obj) {
            this.f12431j = obj;
            return this;
        }

        public Builder setFlags(int i) {
            this.f12430i = i;
            return this;
        }

        public Builder setHttpBody(@Nullable byte[] bArr) {
            this.f12425d = bArr;
            return this;
        }

        public Builder setHttpMethod(int i) {
            this.f12424c = i;
            return this;
        }

        public Builder setHttpRequestHeaders(Map<String, String> map) {
            this.f12426e = map;
            return this;
        }

        public Builder setKey(@Nullable String str) {
            this.f12429h = str;
            return this;
        }

        public Builder setLength(long j) {
            this.f12428g = j;
            return this;
        }

        public Builder setPosition(long j) {
            this.f12427f = j;
            return this;
        }

        public Builder setUri(String str) {
            this.f12422a = Uri.parse(str);
            return this;
        }

        public Builder setUriPositionOffset(long j) {
            this.f12423b = j;
            return this;
        }

        public Builder setUri(Uri uri) {
            this.f12422a = uri;
            return this;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface HttpMethod {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.datasource");
    }

    public DataSpec(Uri uri) {
        this(uri, 0L, -1L);
    }

    public static String getStringForHttpMethod(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return HttpRequest.METHOD_HEAD;
                }
                throw new IllegalStateException();
            }
            return HttpRequest.METHOD_POST;
        }
        return HttpRequest.METHOD_GET;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.upstream.DataSpec$Builder, java.lang.Object] */
    public Builder buildUpon() {
        ?? obj = new Object();
        obj.f12422a = this.uri;
        obj.f12423b = this.uriPositionOffset;
        obj.f12424c = this.httpMethod;
        obj.f12425d = this.httpBody;
        obj.f12426e = this.httpRequestHeaders;
        obj.f12427f = this.position;
        obj.f12428g = this.length;
        obj.f12429h = this.key;
        obj.f12430i = this.flags;
        obj.f12431j = this.customData;
        return obj;
    }

    public final String getHttpMethodString() {
        return getStringForHttpMethod(this.httpMethod);
    }

    public boolean isFlagSet(int i) {
        if ((this.flags & i) == i) {
            return true;
        }
        return false;
    }

    public DataSpec subrange(long j) {
        long j2 = this.length;
        return subrange(j, j2 != -1 ? j2 - j : -1L);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSpec[");
        sb.append(getHttpMethodString());
        sb.append(" ");
        sb.append(this.uri);
        sb.append(", ");
        sb.append(this.position);
        sb.append(", ");
        sb.append(this.length);
        sb.append(", ");
        sb.append(this.key);
        sb.append(", ");
        return ye0.m8298r(sb, "]", this.flags);
    }

    public DataSpec withAdditionalHeaders(Map<String, String> map) {
        HashMap hashMap = new HashMap(this.httpRequestHeaders);
        hashMap.putAll(map);
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, hashMap, this.position, this.length, this.key, this.flags, this.customData);
    }

    public DataSpec withRequestHeaders(Map<String, String> map) {
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, map, this.position, this.length, this.key, this.flags, this.customData);
    }

    public DataSpec withUri(Uri uri) {
        return new DataSpec(uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags, this.customData);
    }

    public DataSpec(Uri uri, long j, long j2) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j, j2, null, 0, null);
    }

    public DataSpec subrange(long j, long j2) {
        return (j == 0 && this.length == j2) ? this : new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position + j, j2, this.key, this.flags, this.customData);
    }

    @Deprecated
    public DataSpec(Uri uri, int i) {
        this(uri, 0L, -1L, null, i);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, @Nullable String str) {
        this(uri, j, j, j2, str, 0);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, @Nullable String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, @Nullable String str, int i, Map<String, String> map) {
        this(uri, 1, null, j, j, j2, str, i, map);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, long j3, @Nullable String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    @Deprecated
    public DataSpec(Uri uri, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i) {
        this(uri, bArr != null ? 2 : 1, bArr, j, j2, j3, str, i);
    }

    @Deprecated
    public DataSpec(Uri uri, int i, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i2) {
        this(uri, i, bArr, j, j2, j3, str, i2, Collections.emptyMap());
    }

    @Deprecated
    public DataSpec(Uri uri, int i, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i2, Map<String, String> map) {
        this(uri, j - j2, i, bArr, map, j2, j3, str, i2, null);
    }

    public DataSpec(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        byte[] bArr2 = bArr;
        long j4 = j + j2;
        Assertions.checkArgument(j4 >= 0);
        Assertions.checkArgument(j2 >= 0);
        Assertions.checkArgument(j3 > 0 || j3 == -1);
        this.uri = uri;
        this.uriPositionOffset = j;
        this.httpMethod = i;
        this.httpBody = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.httpRequestHeaders = Collections.unmodifiableMap(new HashMap(map));
        this.position = j2;
        this.absoluteStreamPosition = j4;
        this.length = j3;
        this.key = str;
        this.flags = i2;
        this.customData = obj;
    }
}
