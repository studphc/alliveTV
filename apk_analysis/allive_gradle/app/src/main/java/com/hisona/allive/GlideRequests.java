package com.hisona.allive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* loaded from: classes2.dex */
public class GlideRequests extends RequestManager {
    public GlideRequests(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public /* bridge */ /* synthetic */ RequestManager addDefaultRequestListener(RequestListener requestListener) {
        return addDefaultRequestListener((RequestListener<Object>) requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    public void setRequestOptions(@NonNull RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new GlideOptions().apply2((BaseRequestOptions<?>) requestOptions));
        }
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public GlideRequests addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (GlideRequests) super.addDefaultRequestListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public synchronized GlideRequests applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (GlideRequests) super.applyDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: as */
    public <ResourceType> GlideRequest<ResourceType> mo2284as(@NonNull Class<ResourceType> cls) {
        return (GlideRequest<ResourceType>) new RequestBuilder(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest) super.asDrawable();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<File> asFile() {
        return (GlideRequest) super.asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<GifDrawable> asGif() {
        return (GlideRequest) super.asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<File> download(@Nullable Object obj) {
        return (GlideRequest) super.download(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<File> downloadOnly() {
        return (GlideRequest) super.downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public synchronized GlideRequests setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (GlideRequests) super.setDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8495load(@Nullable Bitmap bitmap) {
        return (GlideRequest) super.mo8495load(bitmap);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8496load(@Nullable Drawable drawable) {
        return (GlideRequest) super.mo8496load(drawable);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8501load(@Nullable String str) {
        return (GlideRequest) super.mo8501load(str);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8497load(@Nullable Uri uri) {
        return (GlideRequest) super.mo8497load(uri);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8498load(@Nullable File file) {
        return (GlideRequest) super.mo8498load(file);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8499load(@Nullable @DrawableRes @RawRes Integer num) {
        return (GlideRequest) super.mo8499load(num);
    }

    @Override // com.bumptech.glide.RequestManager
    @CheckResult
    @Deprecated
    /* renamed from: load */
    public GlideRequest<Drawable> mo8502load(@Nullable URL url) {
        return (GlideRequest) super.mo8502load(url);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8503load(@Nullable byte[] bArr) {
        return (GlideRequest) super.mo8503load(bArr);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: load */
    public GlideRequest<Drawable> mo8500load(@Nullable Object obj) {
        return (GlideRequest) super.mo8500load(obj);
    }
}
