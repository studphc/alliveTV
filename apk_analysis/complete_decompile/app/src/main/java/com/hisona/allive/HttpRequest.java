package com.hisona.allive;

import com.google.android.exoplayer2.C0643C;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import kotlin.text.Typography;
import p000.m11;
import p000.n11;
import p000.o11;
import p000.ye0;

/* loaded from: classes2.dex */
public class HttpRequest {
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_DATE = "Date";
    public static final String HEADER_ETAG = "ETag";
    public static final String HEADER_EXPIRES = "Expires";
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";
    public static final String HEADER_REFERER = "Referer";
    public static final String HEADER_SERVER = "Server";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";
    public static final String PARAM_CHARSET = "charset";

    /* renamed from: p */
    public static SSLSocketFactory f15835p;

    /* renamed from: q */
    public static m11 f15836q;

    /* renamed from: b */
    public final URL f15839b;

    /* renamed from: c */
    public final String f15840c;

    /* renamed from: d */
    public RequestOutputStream f15841d;

    /* renamed from: e */
    public boolean f15842e;

    /* renamed from: f */
    public boolean f15843f;

    /* renamed from: l */
    public String f15849l;

    /* renamed from: m */
    public int f15850m;

    /* renamed from: o */
    public static final String[] f15834o = new String[0];

    /* renamed from: r */
    public static ConnectionFactory f15837r = ConnectionFactory.DEFAULT;

    /* renamed from: a */
    public HttpURLConnection f15838a = null;

    /* renamed from: g */
    public boolean f15844g = true;

    /* renamed from: h */
    public boolean f15845h = false;

    /* renamed from: i */
    public int f15846i = 8192;

    /* renamed from: j */
    public long f15847j = -1;

    /* renamed from: k */
    public long f15848k = 0;

    /* renamed from: n */
    public UploadProgress f15851n = UploadProgress.DEFAULT;

    /* loaded from: classes2.dex */
    public static class Base64 {

        /* renamed from: a */
        public static final byte[] f15852a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: a */
        public static void m4455a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            int i4;
            int i5;
            byte[] bArr3 = f15852a;
            int i6 = 0;
            if (i2 > 0) {
                i4 = (bArr[i] << Ascii.CAN) >>> 8;
            } else {
                i4 = 0;
            }
            if (i2 > 1) {
                i5 = (bArr[i + 1] << Ascii.CAN) >>> 16;
            } else {
                i5 = 0;
            }
            int i7 = i4 | i5;
            if (i2 > 2) {
                i6 = (bArr[i + 2] << Ascii.CAN) >>> 24;
            }
            int i8 = i7 | i6;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    bArr2[i3] = bArr3[i8 >>> 18];
                    bArr2[i3 + 1] = bArr3[(i8 >>> 12) & 63];
                    bArr2[i3 + 2] = bArr3[(i8 >>> 6) & 63];
                    bArr2[i3 + 3] = bArr3[i8 & 63];
                    return;
                }
                bArr2[i3] = bArr3[i8 >>> 18];
                bArr2[i3 + 1] = bArr3[(i8 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i8 >>> 6) & 63];
                bArr2[i3 + 3] = kotlin.io.encoding.Base64.padSymbol;
                return;
            }
            bArr2[i3] = bArr3[i8 >>> 18];
            bArr2[i3 + 1] = bArr3[(i8 >>> 12) & 63];
            bArr2[i3 + 2] = kotlin.io.encoding.Base64.padSymbol;
            bArr2[i3 + 3] = kotlin.io.encoding.Base64.padSymbol;
        }

        public static String encode(String str) {
            byte[] bytes;
            try {
                bytes = str.getBytes(C0643C.ASCII_NAME);
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            return encodeBytes(bytes);
        }

        public static String encodeBytes(byte[] bArr) {
            return encodeBytes(bArr, 0, bArr.length);
        }

        public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2) {
            int i3;
            if (bArr != null) {
                if (i >= 0) {
                    if (i2 >= 0) {
                        if (i + i2 <= bArr.length) {
                            int i4 = (i2 / 3) * 4;
                            if (i2 % 3 > 0) {
                                i3 = 4;
                            } else {
                                i3 = 0;
                            }
                            int i5 = i4 + i3;
                            byte[] bArr2 = new byte[i5];
                            int i6 = i2 - 2;
                            int i7 = 0;
                            int i8 = 0;
                            while (i7 < i6) {
                                m4455a(bArr, i7 + i, 3, bArr2, i8);
                                i7 += 3;
                                i8 += 4;
                            }
                            if (i7 < i2) {
                                m4455a(bArr, i + i7, i2 - i7, bArr2, i8);
                                i8 += 4;
                            }
                            if (i8 <= i5 - 1) {
                                byte[] bArr3 = new byte[i8];
                                System.arraycopy(bArr2, 0, bArr3, 0, i8);
                                return bArr3;
                            }
                            return bArr2;
                        }
                        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
                    }
                    throw new IllegalArgumentException(ye0.m8291k(i2, "Cannot have length offset: "));
                }
                throw new IllegalArgumentException(ye0.m8291k(i, "Cannot have negative offset: "));
            }
            throw new NullPointerException("Cannot serialize a null array.");
        }

        public static String encodeBytes(byte[] bArr, int i, int i2) {
            byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2);
            try {
                return new String(encodeBytesToBytes, C0643C.ASCII_NAME);
            } catch (UnsupportedEncodingException unused) {
                return new String(encodeBytesToBytes);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class CloseOperation<V> extends Operation<V> {

        /* renamed from: a */
        public final Closeable f15853a;

        /* renamed from: b */
        public final boolean f15854b;

        public CloseOperation(Closeable closeable, boolean z) {
            this.f15853a = closeable;
            this.f15854b = z;
        }

        @Override // com.hisona.allive.HttpRequest.Operation
        public void done() {
            Closeable closeable = this.f15853a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f15854b) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            } else {
                closeable.close();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ConnectionFactory {
        public static final ConnectionFactory DEFAULT = new Object();

        HttpURLConnection create(URL url);

        HttpURLConnection create(URL url, Proxy proxy);
    }

    /* loaded from: classes2.dex */
    public static abstract class FlushOperation<V> extends Operation<V> {

        /* renamed from: a */
        public final Flushable f15855a;

        public FlushOperation(Flushable flushable) {
            this.f15855a = flushable;
        }

        @Override // com.hisona.allive.HttpRequest.Operation
        public void done() {
            this.f15855a.flush();
        }
    }

    /* loaded from: classes2.dex */
    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        public HttpRequestException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Operation<V> implements Callable<V> {
        @Override // java.util.concurrent.Callable
        public V call() {
            boolean z;
            try {
                try {
                    V run = run();
                    try {
                        done();
                        return run;
                    } catch (IOException e) {
                        throw new HttpRequestException(e);
                    }
                } catch (Throwable th) {
                    z = true;
                    th = th;
                    try {
                        done();
                    } catch (IOException e2) {
                        if (!z) {
                            throw new HttpRequestException(e2);
                        }
                    }
                    throw th;
                }
            } catch (HttpRequestException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new HttpRequestException(e4);
            } catch (Throwable th2) {
                th = th2;
                z = false;
                done();
                throw th;
            }
        }

        public abstract void done();

        public abstract V run();
    }

    /* loaded from: classes2.dex */
    public static class RequestOutputStream extends BufferedOutputStream {

        /* renamed from: a */
        public final CharsetEncoder f15856a;

        public RequestOutputStream(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            String str2 = HttpRequest.CHARSET_UTF8;
            this.f15856a = Charset.forName((str == null || str.length() <= 0) ? "UTF-8" : str).newEncoder();
        }

        public RequestOutputStream write(String str) {
            ByteBuffer encode = this.f15856a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public interface UploadProgress {
        public static final UploadProgress DEFAULT = new Object();

        void onUpload(long j, long j2);
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.f15839b = new URL(charSequence.toString());
            this.f15840c = str;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public static void m4450a(Object obj, Object obj2, StringBuilder sb) {
        if (obj2 != null && obj2.getClass().isArray()) {
            if (obj2 instanceof Object[]) {
                obj2 = Arrays.asList((Object[]) obj2);
            } else {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                if (obj2 instanceof int[]) {
                    int[] iArr = (int[]) obj2;
                    int length = iArr.length;
                    while (i < length) {
                        arrayList.add(Integer.valueOf(iArr[i]));
                        i++;
                    }
                } else if (obj2 instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj2;
                    int length2 = zArr.length;
                    while (i < length2) {
                        arrayList.add(Boolean.valueOf(zArr[i]));
                        i++;
                    }
                } else if (obj2 instanceof long[]) {
                    long[] jArr = (long[]) obj2;
                    int length3 = jArr.length;
                    while (i < length3) {
                        arrayList.add(Long.valueOf(jArr[i]));
                        i++;
                    }
                } else if (obj2 instanceof float[]) {
                    float[] fArr = (float[]) obj2;
                    int length4 = fArr.length;
                    while (i < length4) {
                        arrayList.add(Float.valueOf(fArr[i]));
                        i++;
                    }
                } else if (obj2 instanceof double[]) {
                    double[] dArr = (double[]) obj2;
                    int length5 = dArr.length;
                    while (i < length5) {
                        arrayList.add(Double.valueOf(dArr[i]));
                        i++;
                    }
                } else if (obj2 instanceof short[]) {
                    short[] sArr = (short[]) obj2;
                    int length6 = sArr.length;
                    while (i < length6) {
                        arrayList.add(Short.valueOf(sArr[i]));
                        i++;
                    }
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj2;
                    int length7 = bArr.length;
                    while (i < length7) {
                        arrayList.add(Byte.valueOf(bArr[i]));
                        i++;
                    }
                } else if (obj2 instanceof char[]) {
                    char[] cArr = (char[]) obj2;
                    int length8 = cArr.length;
                    while (i < length8) {
                        arrayList.add(Character.valueOf(cArr[i]));
                        i++;
                    }
                }
                obj2 = arrayList;
            }
        }
        if (obj2 instanceof Iterable) {
            Iterator it = ((Iterable) obj2).iterator();
            while (it.hasNext()) {
                sb.append(obj);
                sb.append("[]=");
                Object next = it.next();
                if (next != null) {
                    sb.append(next);
                }
                if (it.hasNext()) {
                    sb.append("&");
                }
            }
            return;
        }
        sb.append(obj);
        sb.append("=");
        if (obj2 != null) {
            sb.append(obj2);
        }
    }

    public static String append(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        if (charSequence2.indexOf(58) + 2 == charSequence2.lastIndexOf(47)) {
            sb.append('/');
        }
        m4451b(sb, charSequence2);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry<?, ?> next = it.next();
        m4450a(next.getKey().toString(), next.getValue(), sb);
        while (it.hasNext()) {
            sb.append(Typography.amp);
            Map.Entry<?, ?> next2 = it.next();
            m4450a(next2.getKey().toString(), next2.getValue(), sb);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static void m4451b(StringBuilder sb, String str) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append(Typography.amp);
        }
    }

    /* renamed from: d */
    public static void m4452d(String str, String str2) {
        PrivilegedAction o11Var;
        if (str2 != null) {
            o11Var = new n11(str, str2);
        } else {
            o11Var = new o11(str, 0);
        }
    }

    public static HttpRequest delete(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_DELETE);
    }

    public static String encode(CharSequence charSequence) {
        int i;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf > 0 && (i = indexOf + 1) < aSCIIString.length()) {
                    return aSCIIString.substring(0, i) + aSCIIString.substring(i).replace("+", "%2B");
                }
                return aSCIIString;
            } catch (URISyntaxException e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static HttpRequest get(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_GET);
    }

    public static HttpRequest head(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_HEAD);
    }

    public static void keepAlive(boolean z) {
        m4452d("http.keepAlive", Boolean.toString(z));
    }

    public static void maxConnections(int i) {
        m4452d("http.maxConnections", Integer.toString(i));
    }

    public static void nonProxyHosts(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int length = strArr.length - 1;
            for (int i = 0; i < length; i++) {
                sb.append(strArr[i]);
                sb.append('|');
            }
            sb.append(strArr[length]);
            m4452d("http.nonProxyHosts", sb.toString());
            return;
        }
        m4452d("http.nonProxyHosts", null);
    }

    public static HttpRequest options(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_OPTIONS);
    }

    public static HttpRequest post(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_POST);
    }

    public static void proxyHost(String str) {
        m4452d("http.proxyHost", str);
        m4452d("https.proxyHost", str);
    }

    public static void proxyPort(int i) {
        String num = Integer.toString(i);
        m4452d("http.proxyPort", num);
        m4452d("https.proxyPort", num);
    }

    public static HttpRequest put(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_PUT);
    }

    public static void setConnectionFactory(ConnectionFactory connectionFactory) {
        if (connectionFactory == null) {
            f15837r = ConnectionFactory.DEFAULT;
        } else {
            f15837r = connectionFactory;
        }
    }

    public static HttpRequest trace(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_TRACE);
    }

    public HttpRequest accept(String str) {
        return header("Accept", str);
    }

    public HttpRequest acceptCharset(String str) {
        return header("Accept-Charset", str);
    }

    public HttpRequest acceptEncoding(String str) {
        return header("Accept-Encoding", str);
    }

    public HttpRequest acceptGzipEncoding() {
        return acceptEncoding(ENCODING_GZIP);
    }

    public HttpRequest acceptJson() {
        return accept(CONTENT_TYPE_JSON);
    }

    public HttpRequest authorization(String str) {
        return header("Authorization", str);
    }

    public boolean badRequest() {
        if (400 == code()) {
            return true;
        }
        return false;
    }

    public HttpRequest basic(String str, String str2) {
        return authorization("Basic " + Base64.encode(str + ':' + str2));
    }

    public String body(String str) {
        ByteArrayOutputStream byteStream = byteStream();
        try {
            copy(buffer(), byteStream);
            if (str == null || str.length() <= 0) {
                str = "UTF-8";
            }
            return byteStream.toString(str);
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public BufferedInputStream buffer() {
        return new BufferedInputStream(stream(), this.f15846i);
    }

    public HttpRequest bufferSize(int i) {
        if (i >= 1) {
            this.f15846i = i;
            return this;
        }
        throw new IllegalArgumentException("Size must be greater than zero");
    }

    public BufferedReader bufferedReader(String str) {
        return new BufferedReader(reader(str), this.f15846i);
    }

    public ByteArrayOutputStream byteStream() {
        int contentLength = contentLength();
        if (contentLength > 0) {
            return new ByteArrayOutputStream(contentLength);
        }
        return new ByteArrayOutputStream();
    }

    public byte[] bytes() {
        ByteArrayOutputStream byteStream = byteStream();
        try {
            copy(buffer(), byteStream);
            return byteStream.toByteArray();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: c */
    public final void m4453c(long j) {
        if (this.f15847j == -1) {
            this.f15847j = 0L;
        }
        this.f15847j += j;
    }

    public String cacheControl() {
        return header("Cache-Control");
    }

    public String charset() {
        return parameter("Content-Type", PARAM_CHARSET);
    }

    public HttpRequest chunk(int i) {
        getConnection().setChunkedStreamingMode(i);
        return this;
    }

    public HttpRequest closeOutput() {
        progress(null);
        RequestOutputStream requestOutputStream = this.f15841d;
        if (requestOutputStream == null) {
            return this;
        }
        if (this.f15842e) {
            requestOutputStream.write("\r\n--00content0boundary00--\r\n");
        }
        if (this.f15844g) {
            try {
                this.f15841d.close();
            } catch (IOException unused) {
            }
        } else {
            this.f15841d.close();
        }
        this.f15841d = null;
        return this;
    }

    public HttpRequest closeOutputQuietly() {
        try {
            return closeOutput();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public int code() {
        try {
            closeOutput();
            return getConnection().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest connectTimeout(int i) {
        getConnection().setConnectTimeout(i);
        return this;
    }

    public String contentEncoding() {
        return header("Content-Encoding");
    }

    public int contentLength() {
        return intHeader("Content-Length");
    }

    public HttpRequest contentType(String str) {
        return contentType(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest copy(InputStream inputStream, OutputStream outputStream) {
        return (HttpRequest) new C1074g(this, inputStream, this.f15844g, inputStream, outputStream).call();
    }

    public boolean created() {
        if (201 == code()) {
            return true;
        }
        return false;
    }

    public long date() {
        return dateHeader("Date");
    }

    public long dateHeader(String str) {
        return dateHeader(str, -1L);
    }

    public HttpRequest disconnect() {
        getConnection().disconnect();
        return this;
    }

    public String eTag() {
        return header("ETag");
    }

    public long expires() {
        return dateHeader("Expires");
    }

    public HttpRequest followRedirects(boolean z) {
        getConnection().setInstanceFollowRedirects(z);
        return this;
    }

    public HttpRequest form(Map<?, ?> map) {
        return form(map, "UTF-8");
    }

    public HttpURLConnection getConnection() {
        HttpURLConnection create;
        if (this.f15838a == null) {
            try {
                String str = this.f15849l;
                URL url = this.f15839b;
                if (str != null) {
                    create = f15837r.create(url, new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f15849l, this.f15850m)));
                } else {
                    create = f15837r.create(url);
                }
                create.setRequestMethod(this.f15840c);
                this.f15838a = create;
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        return this.f15838a;
    }

    public String getParam(String str, String str2) {
        String trim;
        int length;
        if (str != null && str.length() != 0) {
            int length2 = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf != 0 && indexOf != length2) {
                int indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length2;
                }
                while (indexOf < indexOf2) {
                    int indexOf3 = str.indexOf(61, indexOf);
                    if (indexOf3 != -1 && indexOf3 < indexOf2 && str2.equals(str.substring(indexOf, indexOf3).trim()) && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                        if (length > 2 && '\"' == trim.charAt(0)) {
                            int i = length - 1;
                            if ('\"' == trim.charAt(i)) {
                                return trim.substring(1, i);
                            }
                        }
                        return trim;
                    }
                    indexOf = indexOf2 + 1;
                    indexOf2 = str.indexOf(59, indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = length2;
                    }
                }
            }
        }
        return null;
    }

    public Map<String, String> getParams(String str) {
        String trim;
        int length;
        if (str != null && str.length() != 0) {
            int length2 = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf != 0 && indexOf != length2) {
                int indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length2;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (indexOf < indexOf2) {
                    int indexOf3 = str.indexOf(61, indexOf);
                    if (indexOf3 != -1 && indexOf3 < indexOf2) {
                        String trim2 = str.substring(indexOf, indexOf3).trim();
                        if (trim2.length() > 0 && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                            if (length > 2 && '\"' == trim.charAt(0)) {
                                int i = length - 1;
                                if ('\"' == trim.charAt(i)) {
                                    linkedHashMap.put(trim2, trim.substring(1, i));
                                }
                            }
                            linkedHashMap.put(trim2, trim);
                        }
                    }
                    indexOf = indexOf2 + 1;
                    indexOf2 = str.indexOf(59, indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = length2;
                    }
                }
                return linkedHashMap;
            }
            return Collections.emptyMap();
        }
        return Collections.emptyMap();
    }

    public HttpRequest header(String str, String str2) {
        getConnection().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest headers(Map<String, String> map) {
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                header(it.next());
            }
        }
        return this;
    }

    public HttpRequest ifModifiedSince(long j) {
        getConnection().setIfModifiedSince(j);
        return this;
    }

    public HttpRequest ifNoneMatch(String str) {
        return header("If-None-Match", str);
    }

    public HttpRequest ignoreCloseExceptions(boolean z) {
        this.f15844g = z;
        return this;
    }

    public int intHeader(String str) {
        return intHeader(str, -1);
    }

    public boolean isBodyEmpty() {
        if (contentLength() == 0) {
            return true;
        }
        return false;
    }

    public long lastModified() {
        return dateHeader("Last-Modified");
    }

    public String location() {
        return header("Location");
    }

    public String message() {
        try {
            closeOutput();
            return getConnection().getResponseMessage();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String method() {
        return getConnection().getRequestMethod();
    }

    public boolean noContent() {
        if (204 == code()) {
            return true;
        }
        return false;
    }

    public boolean notFound() {
        if (404 == code()) {
            return true;
        }
        return false;
    }

    public boolean notModified() {
        if (304 == code()) {
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    public boolean m4454ok() {
        if (200 == code()) {
            return true;
        }
        return false;
    }

    public HttpRequest openOutput() {
        if (this.f15841d != null) {
            return this;
        }
        getConnection().setDoOutput(true);
        this.f15841d = new RequestOutputStream(getConnection().getOutputStream(), getParam(getConnection().getRequestProperty("Content-Type"), PARAM_CHARSET), this.f15846i);
        return this;
    }

    public String parameter(String str, String str2) {
        return getParam(header(str), str2);
    }

    public Map<String, String> parameters(String str) {
        return getParams(header(str));
    }

    public HttpRequest part(String str, String str2) {
        return part(str, (String) null, str2);
    }

    public HttpRequest partHeader(String str, String str2) {
        return send(str).send(": ").send(str2).send("\r\n");
    }

    public HttpRequest progress(UploadProgress uploadProgress) {
        if (uploadProgress == null) {
            this.f15851n = UploadProgress.DEFAULT;
        } else {
            this.f15851n = uploadProgress;
        }
        return this;
    }

    public HttpRequest proxyAuthorization(String str) {
        return header("Proxy-Authorization", str);
    }

    public HttpRequest proxyBasic(String str, String str2) {
        return proxyAuthorization("Basic " + Base64.encode(str + ':' + str2));
    }

    public HttpRequest readTimeout(int i) {
        getConnection().setReadTimeout(i);
        return this;
    }

    public InputStreamReader reader(String str) {
        try {
            InputStream stream = stream();
            if (str == null || str.length() <= 0) {
                str = "UTF-8";
            }
            return new InputStreamReader(stream, str);
        } catch (UnsupportedEncodingException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest receive(File file) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f15846i);
            return (HttpRequest) new C1070d(this, bufferedOutputStream, this.f15844g, bufferedOutputStream).call();
        } catch (FileNotFoundException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest referer(String str) {
        return header("Referer", str);
    }

    public HttpRequest send(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            m4453c(file.length());
            return send(bufferedInputStream);
        } catch (FileNotFoundException e) {
            throw new HttpRequestException(e);
        }
    }

    public String server() {
        return header("Server");
    }

    public boolean serverError() {
        if (500 == code()) {
            return true;
        }
        return false;
    }

    public HttpRequest startPart() {
        if (!this.f15842e) {
            this.f15842e = true;
            contentType("multipart/form-data; boundary=00content0boundary00").openOutput();
            this.f15841d.write("--00content0boundary00\r\n");
        } else {
            this.f15841d.write("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    public InputStream stream() {
        InputStream inputStream;
        if (code() < 400) {
            try {
                inputStream = getConnection().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        } else {
            inputStream = getConnection().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = getConnection().getInputStream();
                } catch (IOException e2) {
                    if (contentLength() <= 0) {
                        inputStream = new ByteArrayInputStream(new byte[0]);
                    } else {
                        throw new HttpRequestException(e2);
                    }
                }
            }
        }
        if (this.f15845h && ENCODING_GZIP.equals(contentEncoding())) {
            try {
                return new GZIPInputStream(inputStream);
            } catch (IOException e3) {
                throw new HttpRequestException(e3);
            }
        }
        return inputStream;
    }

    public String toString() {
        return method() + ' ' + url();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest trustAllCerts() {
        HttpURLConnection connection = getConnection();
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
            if (f15835p == null) {
                TrustManager[] trustManagerArr = {new Object()};
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, trustManagerArr, new SecureRandom());
                    f15835p = sSLContext.getSocketFactory();
                } catch (GeneralSecurityException e) {
                    IOException iOException = new IOException("Security exception configuring SSL context");
                    iOException.initCause(e);
                    throw new HttpRequestException(iOException);
                }
            }
            httpsURLConnection.setSSLSocketFactory(f15835p);
        }
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, m11] */
    public HttpRequest trustAllHosts() {
        HttpURLConnection connection = getConnection();
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
            if (f15836q == null) {
                f15836q = new Object();
            }
            httpsURLConnection.setHostnameVerifier(f15836q);
        }
        return this;
    }

    public HttpRequest uncompress(boolean z) {
        this.f15845h = z;
        return this;
    }

    public URL url() {
        return getConnection().getURL();
    }

    public HttpRequest useCaches(boolean z) {
        getConnection().setUseCaches(z);
        return this;
    }

    public HttpRequest useProxy(String str, int i) {
        if (this.f15838a == null) {
            this.f15849l = str;
            this.f15850m = i;
            return this;
        }
        throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
    }

    public HttpRequest userAgent(String str) {
        return header("User-Agent", str);
    }

    public HttpRequest writePartHeader(String str, String str2) {
        return writePartHeader(str, str2, null);
    }

    public OutputStreamWriter writer() {
        try {
            openOutput();
            RequestOutputStream requestOutputStream = this.f15841d;
            return new OutputStreamWriter(requestOutputStream, requestOutputStream.f15856a.charset());
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public static HttpRequest delete(URL url) {
        return new HttpRequest(url, METHOD_DELETE);
    }

    public static HttpRequest get(URL url) {
        return new HttpRequest(url, METHOD_GET);
    }

    public static HttpRequest head(URL url) {
        return new HttpRequest(url, METHOD_HEAD);
    }

    public static HttpRequest options(URL url) {
        return new HttpRequest(url, METHOD_OPTIONS);
    }

    public static HttpRequest post(URL url) {
        return new HttpRequest(url, METHOD_POST);
    }

    public static HttpRequest put(URL url) {
        return new HttpRequest(url, METHOD_PUT);
    }

    public static HttpRequest trace(URL url) {
        return new HttpRequest(url, METHOD_TRACE);
    }

    public BufferedReader bufferedReader() {
        return bufferedReader(charset());
    }

    public HttpRequest contentLength(String str) {
        return contentLength(Integer.parseInt(str));
    }

    public HttpRequest contentType(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return header("Content-Type", str + "; charset=" + str2);
        }
        return header("Content-Type", str);
    }

    public long dateHeader(String str, long j) {
        closeOutputQuietly();
        return getConnection().getHeaderFieldDate(str, j);
    }

    public HttpRequest form(Map.Entry<?, ?> entry) {
        return form(entry, "UTF-8");
    }

    public HttpRequest header(String str, Number number) {
        return header(str, number != null ? number.toString() : null);
    }

    public boolean ignoreCloseExceptions() {
        return this.f15844g;
    }

    public int intHeader(String str, int i) {
        closeOutputQuietly();
        return getConnection().getHeaderFieldInt(str, i);
    }

    public HttpRequest part(String str, String str2, String str3) {
        return part(str, str2, (String) null, str3);
    }

    public HttpRequest writePartHeader(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append(Typography.quote);
        partHeader(HttpHeaders.CONTENT_DISPOSITION, sb.toString());
        if (str3 != null) {
            partHeader("Content-Type", str3);
        }
        return send("\r\n");
    }

    public static HttpRequest delete(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return delete(append);
    }

    public static HttpRequest get(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return get(append);
    }

    public static HttpRequest head(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return head(append);
    }

    public static HttpRequest post(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return post(append);
    }

    public static HttpRequest put(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return put(append);
    }

    public int bufferSize() {
        return this.f15846i;
    }

    public HttpRequest contentLength(int i) {
        getConnection().setFixedLengthStreamingMode(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest copy(Reader reader, Writer writer) {
        return (HttpRequest) new C1075h(this, reader, this.f15844g, reader, writer).call();
    }

    public HttpRequest form(Map.Entry<?, ?> entry, String str) {
        return form(entry.getKey(), entry.getValue(), str);
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public HttpRequest part(String str, String str2, String str3, String str4) {
        try {
            startPart();
            writePartHeader(str, str2, str3);
            this.f15841d.write(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest code(AtomicInteger atomicInteger) {
        atomicInteger.set(code());
        return this;
    }

    public HttpRequest form(Object obj, Object obj2) {
        return form(obj, obj2, "UTF-8");
    }

    public String header(String str) {
        closeOutputQuietly();
        return getConnection().getHeaderField(str);
    }

    public Map<String, List<String>> headers() {
        closeOutputQuietly();
        return getConnection().getHeaderFields();
    }

    public static HttpRequest delete(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return delete(append);
    }

    public static HttpRequest get(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return get(append);
    }

    public static HttpRequest head(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return head(append);
    }

    public static HttpRequest post(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return post(append);
    }

    public static HttpRequest put(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return put(append);
    }

    public String contentType() {
        return header("Content-Type");
    }

    public HttpRequest form(Object obj, Object obj2, String str) {
        boolean z = this.f15843f;
        if (!z) {
            contentType(CONTENT_TYPE_FORM, str);
            this.f15843f = true;
        }
        if (str == null || str.length() <= 0) {
            str = "UTF-8";
        }
        try {
            openOutput();
            if (z) {
                this.f15841d.write(38);
            }
            this.f15841d.write(URLEncoder.encode(obj.toString(), str));
            this.f15841d.write(61);
            if (obj2 != null) {
                this.f15841d.write(URLEncoder.encode(obj2.toString(), str));
            }
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest receive(OutputStream outputStream) {
        try {
            return copy(buffer(), outputStream);
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(byte[] bArr) {
        if (bArr != null) {
            m4453c(bArr.length);
        }
        return send(new ByteArrayInputStream(bArr));
    }

    public String[] headers(String str) {
        List<String> list;
        Map<String, List<String>> headers = headers();
        return (headers == null || headers.isEmpty() || (list = headers.get(str)) == null || list.isEmpty()) ? f15834o : (String[]) list.toArray(new String[list.size()]);
    }

    public InputStreamReader reader() {
        return reader(charset());
    }

    public String body() {
        return body(charset());
    }

    public HttpRequest part(String str, Number number) {
        return part(str, (String) null, number);
    }

    public HttpRequest receive(PrintStream printStream) {
        return receive((OutputStream) printStream);
    }

    public HttpRequest send(InputStream inputStream) {
        try {
            openOutput();
            copy(inputStream, this.f15841d);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest body(AtomicReference<String> atomicReference) {
        atomicReference.set(body());
        return this;
    }

    public HttpRequest part(String str, String str2, Number number) {
        return part(str, str2, number != null ? number.toString() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest receive(Appendable appendable) {
        BufferedReader bufferedReader = bufferedReader();
        return (HttpRequest) new C1072e(this, bufferedReader, this.f15844g, bufferedReader, appendable).call();
    }

    public HttpRequest body(AtomicReference<String> atomicReference, String str) {
        atomicReference.set(body(str));
        return this;
    }

    public HttpRequest part(String str, File file) {
        return part(str, (String) null, file);
    }

    public HttpRequest part(String str, String str2, File file) {
        return part(str, str2, (String) null, file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest send(Reader reader) {
        try {
            openOutput();
            RequestOutputStream requestOutputStream = this.f15841d;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(requestOutputStream, requestOutputStream.f15856a.charset());
            return (HttpRequest) new C1068c(this, outputStreamWriter, reader, outputStreamWriter).call();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest part(String str, String str2, String str3, File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            m4453c(file.length());
            return part(str, str2, str3, bufferedInputStream);
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest receive(Writer writer) {
        BufferedReader bufferedReader = bufferedReader();
        return (HttpRequest) new C1073f(this, bufferedReader, this.f15844g, bufferedReader, writer).call();
    }

    public HttpRequest(URL url, String str) {
        this.f15839b = url;
        this.f15840c = str;
    }

    public static String append(CharSequence charSequence, Object... objArr) {
        String charSequence2 = charSequence.toString();
        if (objArr == null || objArr.length == 0) {
            return charSequence2;
        }
        if (objArr.length % 2 == 0) {
            StringBuilder sb = new StringBuilder(charSequence2);
            if (charSequence2.indexOf(58) + 2 == charSequence2.lastIndexOf(47)) {
                sb.append('/');
            }
            m4451b(sb, charSequence2);
            m4450a(objArr[0], objArr[1], sb);
            for (int i = 2; i < objArr.length; i += 2) {
                sb.append(Typography.amp);
                m4450a(objArr[i], objArr[i + 1], sb);
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Must specify an even number of parameter names/values");
    }

    public HttpRequest part(String str, InputStream inputStream) {
        return part(str, (String) null, (String) null, inputStream);
    }

    public HttpRequest form(Map<?, ?> map, String str) {
        if (!map.isEmpty()) {
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                form(it.next(), str);
            }
        }
        return this;
    }

    public HttpRequest part(String str, String str2, String str3, InputStream inputStream) {
        try {
            startPart();
            writePartHeader(str, str2, str3);
            copy(inputStream, this.f15841d);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(CharSequence charSequence) {
        try {
            openOutput();
            this.f15841d.write(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }
}
