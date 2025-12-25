package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {

    /* renamed from: a */
    public final Call.Factory f8612a;

    /* renamed from: b */
    public final GlideUrl f8613b;

    /* renamed from: c */
    public InputStream f8614c;

    /* renamed from: d */
    public ResponseBody f8615d;

    /* renamed from: e */
    public DataFetcher.DataCallback f8616e;

    /* renamed from: f */
    public volatile Call f8617f;

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        this.f8612a = factory;
        this.f8613b = glideUrl;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Call call = this.f8617f;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            InputStream inputStream = this.f8614c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f8615d;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f8616e = null;
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
        Request.Builder url = new Request.Builder().url(this.f8613b.toStringUrl());
        for (Map.Entry<String, String> entry : this.f8613b.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        Request build = url.build();
        this.f8616e = dataCallback;
        this.f8617f = this.f8612a.newCall(build);
        this.f8617f.enqueue(this);
    }

    @Override // okhttp3.Callback
    public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f8616e.onLoadFailed(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        this.f8615d = response.body();
        if (response.getIsSuccessful()) {
            InputStream obtain = ContentLengthInputStream.obtain(this.f8615d.byteStream(), ((ResponseBody) Preconditions.checkNotNull(this.f8615d)).getF24401c());
            this.f8614c = obtain;
            this.f8616e.onDataReady(obtain);
            return;
        }
        this.f8616e.onLoadFailed(new HttpException(response.message(), response.code()));
    }
}
