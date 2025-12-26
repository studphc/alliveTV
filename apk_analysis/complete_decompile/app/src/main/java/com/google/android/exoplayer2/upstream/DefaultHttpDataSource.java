package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import com.hisona.allive.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import p000.AbstractC1726qj;
import p000.t00;
import p000.ye0;

/* loaded from: classes.dex */
public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;

    /* renamed from: e */
    public final boolean f12477e;

    /* renamed from: f */
    public final int f12478f;

    /* renamed from: g */
    public final int f12479g;

    /* renamed from: h */
    public final String f12480h;

    /* renamed from: i */
    public final HttpDataSource.RequestProperties f12481i;

    /* renamed from: j */
    public final HttpDataSource.RequestProperties f12482j;

    /* renamed from: k */
    public final boolean f12483k;

    /* renamed from: l */
    public Predicate f12484l;

    /* renamed from: m */
    public DataSpec f12485m;

    /* renamed from: n */
    public HttpURLConnection f12486n;

    /* renamed from: o */
    public InputStream f12487o;

    /* renamed from: p */
    public boolean f12488p;

    /* renamed from: q */
    public int f12489q;

    /* renamed from: r */
    public long f12490r;

    /* renamed from: s */
    public long f12491s;

    /* loaded from: classes.dex */
    public static final class Factory implements HttpDataSource.Factory {

        /* renamed from: b */
        public TransferListener f12493b;

        /* renamed from: c */
        public Predicate f12494c;

        /* renamed from: d */
        public String f12495d;

        /* renamed from: g */
        public boolean f12498g;

        /* renamed from: h */
        public boolean f12499h;

        /* renamed from: a */
        public final HttpDataSource.RequestProperties f12492a = new HttpDataSource.RequestProperties();

        /* renamed from: e */
        public int f12496e = 8000;

        /* renamed from: f */
        public int f12497f = 8000;

        public Factory setAllowCrossProtocolRedirects(boolean z) {
            this.f12498g = z;
            return this;
        }

        public Factory setConnectTimeoutMs(int i) {
            this.f12496e = i;
            return this;
        }

        public Factory setContentTypePredicate(@Nullable Predicate<String> predicate) {
            this.f12494c = predicate;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public /* bridge */ /* synthetic */ HttpDataSource.Factory setDefaultRequestProperties(Map map) {
            return setDefaultRequestProperties((Map<String, String>) map);
        }

        public Factory setKeepPostFor302Redirects(boolean z) {
            this.f12499h = z;
            return this;
        }

        public Factory setReadTimeoutMs(int i) {
            this.f12497f = i;
            return this;
        }

        public Factory setTransferListener(@Nullable TransferListener transferListener) {
            this.f12493b = transferListener;
            return this;
        }

        public Factory setUserAgent(@Nullable String str) {
            this.f12495d = str;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.f12492a.clearAndSet(map);
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory, com.google.android.exoplayer2.upstream.DataSource.Factory
        public DefaultHttpDataSource createDataSource() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.f12495d, this.f12496e, this.f12497f, this.f12498g, this.f12492a, this.f12494c, this.f12499h);
            TransferListener transferListener = this.f12493b;
            if (transferListener != null) {
                defaultHttpDataSource.addTransferListener(transferListener);
            }
            return defaultHttpDataSource;
        }
    }

    @Deprecated
    public DefaultHttpDataSource() {
        this(null, 8000, 8000);
    }

    /* renamed from: e */
    public static void m2982e(HttpURLConnection httpURLConnection, long j) {
        int i;
        if (httpURLConnection != null && (i = Util.SDK_INT) >= 19 && i <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = ((Class) Assertions.checkNotNull(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, null);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public final void m2983a() {
        HttpURLConnection httpURLConnection = this.f12486n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.m3024e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f12486n = null;
        }
    }

    /* renamed from: b */
    public final URL m2984b(URL url, String str, DataSpec dataSpec) {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    throw new HttpDataSource.HttpDataSourceException(AbstractC1726qj.m7038C("Unsupported protocol redirect: ", protocol), dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
                }
                if (!this.f12477e && !protocol.equals(url.getProtocol())) {
                    throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
                }
                return url2;
            } catch (MalformedURLException e) {
                throw new HttpDataSource.HttpDataSourceException(e, dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
        }
        throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a6, code lost:
    
        return r0;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HttpURLConnection m2985c(DataSpec dataSpec) {
        URL url = new URL(dataSpec.uri.toString());
        int i = dataSpec.httpMethod;
        byte[] bArr = dataSpec.httpBody;
        long j = dataSpec.position;
        long j2 = dataSpec.length;
        boolean isFlagSet = dataSpec.isFlagSet(1);
        boolean z = this.f12477e;
        boolean z2 = this.f12483k;
        if (!z && !z2) {
            return m2986d(url, i, bArr, j, j2, isFlagSet, true, dataSpec.httpRequestHeaders);
        }
        int i2 = 0;
        URL url2 = url;
        int i3 = i;
        byte[] bArr2 = bArr;
        while (true) {
            int i4 = i2 + 1;
            if (i2 <= 20) {
                long j3 = j;
                long j4 = j;
                URL url3 = url2;
                int i5 = i3;
                boolean z3 = z2;
                long j5 = j2;
                HttpURLConnection m2986d = m2986d(url2, i3, bArr2, j3, j2, isFlagSet, false, dataSpec.httpRequestHeaders);
                int responseCode = m2986d.getResponseCode();
                String headerField = m2986d.getHeaderField("Location");
                if ((i5 != 1 && i5 != 3) || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308)) {
                    if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                        break;
                    }
                    m2986d.disconnect();
                    if (z3 && responseCode == 302) {
                        i3 = i5;
                    } else {
                        bArr2 = null;
                        i3 = 1;
                    }
                    url2 = m2984b(url3, headerField, dataSpec);
                } else {
                    m2986d.disconnect();
                    url2 = m2984b(url3, headerField, dataSpec);
                    i3 = i5;
                }
                i2 = i4;
                j = j4;
                z2 = z3;
                j2 = j5;
            } else {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException(ye0.m8291k(i4, "Too many redirects: ")), dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.f12482j.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.f12482j.remove(str);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            InputStream inputStream = this.f12487o;
            if (inputStream != null) {
                long j = this.f12490r;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.f12491s;
                }
                m2982e(this.f12486n, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, (DataSpec) Util.castNonNull(this.f12485m), 2000, 3);
                }
            }
        } finally {
            this.f12487o = null;
            m2983a();
            if (this.f12488p) {
                this.f12488p = false;
                transferEnded();
            }
        }
    }

    /* renamed from: d */
    public final HttpURLConnection m2986d(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) {
        String str;
        boolean z3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f12478f);
        httpURLConnection.setReadTimeout(this.f12479g);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.f12481i;
        if (requestProperties != null) {
            hashMap.putAll(requestProperties.getSnapshot());
        }
        hashMap.putAll(this.f12482j.getSnapshot());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String buildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j, j2);
        if (buildRangeRequestHeader != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, buildRangeRequestHeader);
        }
        String str2 = this.f12480h;
        if (str2 != null) {
            httpURLConnection.setRequestProperty("User-Agent", str2);
        }
        if (z) {
            str = HttpRequest.ENCODING_GZIP;
        } else {
            str = "identity";
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", str);
        httpURLConnection.setInstanceFollowRedirects(z2);
        if (bArr != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        httpURLConnection.setDoOutput(z3);
        httpURLConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    /* renamed from: f */
    public final void m2987f(long j, DataSpec dataSpec) {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int read = ((InputStream) Util.castNonNull(this.f12487o)).read(bArr, 0, (int) Math.min(j, 4096));
            if (!Thread.currentThread().isInterrupted()) {
                if (read != -1) {
                    j -= read;
                    bytesTransferred(read);
                } else {
                    throw new HttpDataSource.HttpDataSourceException(dataSpec, 2008, 1);
                }
            } else {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), dataSpec, 2000, 1);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public int getResponseCode() {
        int i;
        if (this.f12486n == null || (i = this.f12489q) <= 0) {
            return -1;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.upstream.BaseDataSource, com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f12486n;
        if (httpURLConnection == null) {
            return ImmutableMap.m3923of();
        }
        return new t00(httpURLConnection.getHeaderFields());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f12486n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        byte[] bArr;
        DataSourceException dataSourceException;
        this.f12485m = dataSpec;
        long j = 0;
        this.f12491s = 0L;
        this.f12490r = 0L;
        transferInitializing(dataSpec);
        try {
            HttpURLConnection m2985c = m2985c(dataSpec);
            this.f12486n = m2985c;
            this.f12489q = m2985c.getResponseCode();
            String responseMessage = m2985c.getResponseMessage();
            int i = this.f12489q;
            long j2 = -1;
            if (i >= 200 && i <= 299) {
                String contentType = m2985c.getContentType();
                Predicate predicate = this.f12484l;
                if (predicate != null && !predicate.apply(contentType)) {
                    m2983a();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
                }
                if (this.f12489q == 200) {
                    long j3 = dataSpec.position;
                    if (j3 != 0) {
                        j = j3;
                    }
                }
                boolean equalsIgnoreCase = HttpRequest.ENCODING_GZIP.equalsIgnoreCase(m2985c.getHeaderField("Content-Encoding"));
                if (!equalsIgnoreCase) {
                    long j4 = dataSpec.length;
                    if (j4 != -1) {
                        this.f12490r = j4;
                    } else {
                        long contentLength = HttpUtil.getContentLength(m2985c.getHeaderField("Content-Length"), m2985c.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        if (contentLength != -1) {
                            j2 = contentLength - j;
                        }
                        this.f12490r = j2;
                    }
                } else {
                    this.f12490r = dataSpec.length;
                }
                try {
                    this.f12487o = m2985c.getInputStream();
                    if (equalsIgnoreCase) {
                        this.f12487o = new GZIPInputStream(this.f12487o);
                    }
                    this.f12488p = true;
                    transferStarted(dataSpec);
                    try {
                        m2987f(j, dataSpec);
                        return this.f12490r;
                    } catch (IOException e) {
                        m2983a();
                        if (e instanceof HttpDataSource.HttpDataSourceException) {
                            throw ((HttpDataSource.HttpDataSourceException) e);
                        }
                        throw new HttpDataSource.HttpDataSourceException(e, dataSpec, 2000, 1);
                    }
                } catch (IOException e2) {
                    m2983a();
                    throw new HttpDataSource.HttpDataSourceException(e2, dataSpec, 2000, 1);
                }
            }
            Map<String, List<String>> headerFields = m2985c.getHeaderFields();
            if (this.f12489q == 416) {
                if (dataSpec.position == HttpUtil.getDocumentSize(m2985c.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                    this.f12488p = true;
                    transferStarted(dataSpec);
                    long j5 = dataSpec.length;
                    if (j5 == -1) {
                        return 0L;
                    }
                    return j5;
                }
            }
            InputStream errorStream = m2985c.getErrorStream();
            try {
                if (errorStream != null) {
                    bArr = Util.toByteArray(errorStream);
                } else {
                    bArr = Util.EMPTY_BYTE_ARRAY;
                }
            } catch (IOException unused) {
                bArr = Util.EMPTY_BYTE_ARRAY;
            }
            byte[] bArr2 = bArr;
            m2983a();
            if (this.f12489q == 416) {
                dataSourceException = new DataSourceException(2008);
            } else {
                dataSourceException = null;
            }
            throw new HttpDataSource.InvalidResponseCodeException(this.f12489q, responseMessage, dataSourceException, headerFields, dataSpec, bArr2);
        } catch (IOException e3) {
            m2983a();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e3, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.f12490r;
            if (j != -1) {
                long j2 = j - this.f12491s;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                }
                return -1;
            }
            int read = ((InputStream) Util.castNonNull(this.f12487o)).read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.f12491s += read;
            bytesTransferred(read);
            return read;
        } catch (IOException e) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e, (DataSpec) Util.castNonNull(this.f12485m), 2);
        }
    }

    @Deprecated
    public void setContentTypePredicate(@Nullable Predicate<String> predicate) {
        this.f12484l = predicate;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.f12482j.set(str, str2);
    }

    @Deprecated
    public DefaultHttpDataSource(@Nullable String str) {
        this(str, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(@Nullable String str, int i, int i2) {
        this(str, i, i2, false, null);
    }

    @Deprecated
    public DefaultHttpDataSource(@Nullable String str, int i, int i2, boolean z, @Nullable HttpDataSource.RequestProperties requestProperties) {
        this(str, i, i2, z, requestProperties, null, false);
    }

    public DefaultHttpDataSource(String str, int i, int i2, boolean z, HttpDataSource.RequestProperties requestProperties, Predicate predicate, boolean z2) {
        super(true);
        this.f12480h = str;
        this.f12478f = i;
        this.f12479g = i2;
        this.f12477e = z;
        this.f12481i = requestProperties;
        this.f12484l = predicate;
        this.f12482j = new HttpDataSource.RequestProperties();
        this.f12483k = z2;
    }
}
