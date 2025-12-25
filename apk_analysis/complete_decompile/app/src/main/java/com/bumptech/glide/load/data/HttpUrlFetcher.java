package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    /* renamed from: a */
    public final GlideUrl f8647a;

    /* renamed from: b */
    public final int f8648b;

    /* renamed from: c */
    public HttpURLConnection f8649c;

    /* renamed from: d */
    public InputStream f8650d;

    /* renamed from: e */
    public volatile boolean f8651e;

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this.f8647a = glideUrl;
        this.f8648b = i;
    }

    /* renamed from: a */
    public static int m2309a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e);
                return -1;
            }
            return -1;
        }
    }

    /* renamed from: b */
    public final InputStream m2310b(URL url, int i, URL url2, Map map) {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                for (Map.Entry entry : map.entrySet()) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                int i2 = this.f8648b;
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                this.f8649c = httpURLConnection;
                try {
                    httpURLConnection.connect();
                    this.f8650d = this.f8649c.getInputStream();
                    if (this.f8651e) {
                        return null;
                    }
                    int m2309a = m2309a(this.f8649c);
                    int i3 = m2309a / 100;
                    if (i3 == 2) {
                        HttpURLConnection httpURLConnection2 = this.f8649c;
                        try {
                            if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                                this.f8650d = ContentLengthInputStream.obtain(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                            } else {
                                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                                }
                                this.f8650d = httpURLConnection2.getInputStream();
                            }
                            return this.f8650d;
                        } catch (IOException e) {
                            throw new HttpException("Failed to obtain InputStream", m2309a(httpURLConnection2), e);
                        }
                    }
                    if (i3 == 3) {
                        String headerField = this.f8649c.getHeaderField("Location");
                        if (!TextUtils.isEmpty(headerField)) {
                            try {
                                URL url3 = new URL(url, headerField);
                                cleanup();
                                return m2310b(url3, i + 1, url, map);
                            } catch (MalformedURLException e2) {
                                throw new HttpException(AbstractC1726qj.m7038C("Bad redirect url: ", headerField), m2309a, e2);
                            }
                        }
                        throw new HttpException("Received empty or null redirect url", m2309a);
                    }
                    if (m2309a == -1) {
                        throw new HttpException(m2309a);
                    }
                    try {
                        throw new HttpException(this.f8649c.getResponseMessage(), m2309a);
                    } catch (IOException e3) {
                        throw new HttpException("Failed to get a response message", m2309a, e3);
                    }
                } catch (IOException e4) {
                    throw new HttpException("Failed to connect or obtain data", m2309a(this.f8649c), e4);
                }
            } catch (IOException e5) {
                throw new HttpException("URL.openConnection threw", 0, e5);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.f8651e = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.f8650d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f8649c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f8649c = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        GlideUrl glideUrl = this.f8647a;
        long logTime = LogTime.getLogTime();
        try {
            try {
                dataCallback.onDataReady(m2310b(glideUrl.toURL(), 0, null, glideUrl.getHeaders()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                dataCallback.onLoadFailed(e);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder("Finished http url fetcher fetch in ");
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder("Finished http url fetcher fetch in ");
                sb.append(LogTime.getElapsedMillis(logTime));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }
}
