package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.AbstractC1726qj;
import p000.C1593np;
import p000.ye0;

/* loaded from: classes.dex */
public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = new C1593np(3);

    /* loaded from: classes.dex */
    public static abstract class BaseFactory implements Factory {

        /* renamed from: a */
        public final RequestProperties f12506a = new RequestProperties();

        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.f12506a.clearAndSet(map);
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory, com.google.android.exoplayer2.upstream.DataSource.Factory
        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.f12506a);
        }
    }

    /* loaded from: classes.dex */
    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, dataSpec, PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, 1);
        }
    }

    /* loaded from: classes.dex */
    public interface Factory extends DataSource.Factory {
        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        /* bridge */ /* synthetic */ DataSource createDataSource();

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        HttpDataSource createDataSource();

        Factory setDefaultRequestProperties(Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface Type {
        }

        @Deprecated
        public HttpDataSourceException(DataSpec dataSpec, int i) {
            this(dataSpec, 2000, i);
        }

        /* renamed from: a */
        public static int m2988a(int i, int i2) {
            return (i == 2000 && i2 == 1) ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED : i;
        }

        public static HttpDataSourceException createForIOException(IOException iOException, DataSpec dataSpec, int i) {
            int i2;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i2 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
            } else if (iOException instanceof InterruptedIOException) {
                i2 = 1004;
            } else if (message != null && Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) {
                i2 = 2007;
            } else {
                i2 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED;
            }
            if (i2 == 2007) {
                return new CleartextNotPermittedException(iOException, dataSpec);
            }
            return new HttpDataSourceException(iOException, dataSpec, i2, i);
        }

        public HttpDataSourceException(DataSpec dataSpec, int i, int i2) {
            super(m2988a(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, DataSpec dataSpec, int i) {
            this(str, dataSpec, 2000, i);
        }

        public HttpDataSourceException(String str, DataSpec dataSpec, int i, int i2) {
            super(str, m2988a(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i) {
            this(iOException, dataSpec, 2000, i);
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i, int i2) {
            super(iOException, m2988a(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i) {
            this(str, iOException, dataSpec, 2000, i);
        }

        public HttpDataSourceException(String str, @Nullable IOException iOException, DataSpec dataSpec, int i, int i2) {
            super(str, iOException, m2988a(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }
    }

    /* loaded from: classes.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super(AbstractC1726qj.m7038C("Invalid content type: ", str), dataSpec, PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE, 1);
            this.contentType = str;
        }
    }

    /* loaded from: classes.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;

        @Nullable
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i, null, null, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        @Deprecated
        public InvalidResponseCodeException(int i, @Nullable String str, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i, str, null, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        public InvalidResponseCodeException(int i, @Nullable String str, @Nullable IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
            super(ye0.m8291k(i, "Response code: "), iOException, dataSpec, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, 1);
            this.responseCode = i;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    @Override // com.google.android.exoplayer2.upstream.DataSource
    void close();

    int getResponseCode();

    @Override // com.google.android.exoplayer2.upstream.DataSource
    Map<String, List<String>> getResponseHeaders();

    @Override // com.google.android.exoplayer2.upstream.DataSource
    long open(DataSpec dataSpec);

    @Override // com.google.android.exoplayer2.upstream.DataReader
    int read(byte[] bArr, int i, int i2);

    void setRequestProperty(String str, String str2);

    /* loaded from: classes.dex */
    public static final class RequestProperties {

        /* renamed from: a */
        public final HashMap f12507a = new HashMap();

        /* renamed from: b */
        public Map f12508b;

        public synchronized void clear() {
            this.f12508b = null;
            this.f12507a.clear();
        }

        public synchronized void clearAndSet(Map<String, String> map) {
            this.f12508b = null;
            this.f12507a.clear();
            this.f12507a.putAll(map);
        }

        public synchronized Map<String, String> getSnapshot() {
            try {
                if (this.f12508b == null) {
                    this.f12508b = Collections.unmodifiableMap(new HashMap(this.f12507a));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f12508b;
        }

        public synchronized void remove(String str) {
            this.f12508b = null;
            this.f12507a.remove(str);
        }

        public synchronized void set(String str, String str2) {
            this.f12508b = null;
            this.f12507a.put(str, str2);
        }

        public synchronized void set(Map<String, String> map) {
            this.f12508b = null;
            this.f12507a.putAll(map);
        }
    }
}
