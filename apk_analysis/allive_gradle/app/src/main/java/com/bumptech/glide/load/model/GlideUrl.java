package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public class GlideUrl implements Key {

    /* renamed from: a */
    public final Headers f8784a;

    /* renamed from: b */
    public final URL f8785b;

    /* renamed from: c */
    public final String f8786c;

    /* renamed from: d */
    public String f8787d;

    /* renamed from: e */
    public URL f8788e;

    /* renamed from: f */
    public volatile byte[] f8789f;

    /* renamed from: g */
    public int f8790g;

    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
    }

    /* renamed from: a */
    public final String m2334a() {
        if (TextUtils.isEmpty(this.f8787d)) {
            String str = this.f8786c;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.checkNotNull(this.f8785b)).toString();
            }
            this.f8787d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f8787d;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!getCacheKey().equals(glideUrl.getCacheKey()) || !this.f8784a.equals(glideUrl.f8784a)) {
            return false;
        }
        return true;
    }

    public String getCacheKey() {
        String str = this.f8786c;
        if (str == null) {
            return ((URL) Preconditions.checkNotNull(this.f8785b)).toString();
        }
        return str;
    }

    public Map<String, String> getHeaders() {
        return this.f8784a.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f8790g == 0) {
            int hashCode = getCacheKey().hashCode();
            this.f8790g = hashCode;
            this.f8790g = this.f8784a.hashCode() + (hashCode * 31);
        }
        return this.f8790g;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return m2334a();
    }

    public URL toURL() {
        if (this.f8788e == null) {
            this.f8788e = new URL(m2334a());
        }
        return this.f8788e;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        if (this.f8789f == null) {
            this.f8789f = getCacheKey().getBytes(Key.CHARSET);
        }
        messageDigest.update(this.f8789f);
    }

    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f8785b = (URL) Preconditions.checkNotNull(url);
        this.f8786c = null;
        this.f8784a = (Headers) Preconditions.checkNotNull(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f8785b = null;
        this.f8786c = Preconditions.checkNotEmpty(str);
        this.f8784a = (Headers) Preconditions.checkNotNull(headers);
    }
}
