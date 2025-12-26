package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import com.hisona.allive.HttpRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a */
    public final DataSource.Factory f9991a;

    /* renamed from: b */
    public final String f9992b;

    /* renamed from: c */
    public final boolean f9993c;

    /* renamed from: d */
    public final HashMap f9994d;

    public HttpMediaDrmCallback(@Nullable String str, DataSource.Factory factory) {
        this(str, false, factory);
    }

    /* renamed from: a */
    public static byte[] m2518a(DataSource.Factory factory, String str, byte[] bArr, Map map) {
        Map<String, List<String>> map2;
        List<String> list;
        StatsDataSource statsDataSource = new StatsDataSource(factory.createDataSource());
        DataSpec build = new DataSpec.Builder().setUri(str).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build();
        int i = 0;
        int i2 = 0;
        DataSpec dataSpec = build;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpec);
                try {
                    try {
                        return Util.toByteArray(dataSourceInputStream);
                    } catch (HttpDataSource.InvalidResponseCodeException e) {
                        int i3 = e.responseCode;
                        String str2 = null;
                        if ((i3 == 307 || i3 == 308) && i2 < 5 && (map2 = e.headerFields) != null && (list = map2.get("Location")) != null && !list.isEmpty()) {
                            str2 = list.get(i);
                        }
                        if (str2 != null) {
                            i2++;
                            dataSpec = dataSpec.buildUpon().setUri(str2).build();
                        } else {
                            throw e;
                        }
                    }
                } finally {
                    Util.closeQuietly(dataSourceInputStream);
                }
            } catch (Exception e2) {
                throw new MediaDrmCallbackException(build, (Uri) Assertions.checkNotNull(statsDataSource.getLastOpenedUri()), statsDataSource.getResponseHeaders(), statsDataSource.getBytesRead(), e2);
            }
        }
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.f9994d) {
            this.f9994d.clear();
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.f9994d) {
            this.f9994d.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
        String str;
        String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.f9993c || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.f9992b;
        }
        if (!TextUtils.isEmpty(licenseServerUrl)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = C0643C.PLAYREADY_UUID;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else if (C0643C.CLEARKEY_UUID.equals(uuid)) {
                str = HttpRequest.CONTENT_TYPE_JSON;
            } else {
                str = "application/octet-stream";
            }
            hashMap.put("Content-Type", str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.f9994d) {
                hashMap.putAll(this.f9994d);
            }
            return m2518a(this.f9991a, licenseServerUrl, keyRequest.getData(), hashMap);
        }
        DataSpec.Builder builder = new DataSpec.Builder();
        Uri uri = Uri.EMPTY;
        throw new MediaDrmCallbackException(builder.setUri(uri).build(), uri, ImmutableMap.m3923of(), 0L, new IllegalStateException("No license URL"));
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) {
        return m2518a(this.f9991a, provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData()), null, Collections.emptyMap());
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.f9994d) {
            this.f9994d.put(str, str2);
        }
    }

    public HttpMediaDrmCallback(@Nullable String str, boolean z, DataSource.Factory factory) {
        Assertions.checkArgument((z && TextUtils.isEmpty(str)) ? false : true);
        this.f9991a = factory;
        this.f9992b = str;
        this.f9993c = z;
        this.f9994d = new HashMap();
    }
}
