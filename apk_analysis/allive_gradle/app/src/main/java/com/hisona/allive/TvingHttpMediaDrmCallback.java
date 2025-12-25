package com.hisona.allive;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
/* loaded from: classes2.dex */
public final class TvingHttpMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a */
    public final HttpDataSource.Factory f15953a;

    /* renamed from: b */
    public String f15954b;

    /* renamed from: c */
    public final boolean f15955c;

    /* renamed from: d */
    public final HashMap f15956d;

    public TvingHttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c A[LOOP:1: B:9:0x002c->B:34:0x009c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m4476a(HttpDataSource.Factory factory, String str, byte[] bArr, HashMap hashMap) {
        String str2;
        Map<String, List<String>> map;
        List<String> list;
        HttpDataSource createDataSource = factory.createDataSource();
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                createDataSource.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        int i = 0;
        while (true) {
            boolean z = true;
            DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(createDataSource, new DataSpec.Builder().setUri(Uri.parse(str)).setHttpBody(bArr).setPosition(0L).setLength(-1L).setHttpMethod(2).setFlags(1).build());
            try {
                return Util.toByteArray(dataSourceInputStream);
            } catch (HttpDataSource.InvalidResponseCodeException e) {
                try {
                    if (e.responseCode == 307 || e.responseCode == 308) {
                        int i2 = i + 1;
                        if (i < 5) {
                            i = i2;
                            str2 = null;
                            if (z && (map = e.headerFields) != null && (list = map.get("Location")) != null && !list.isEmpty()) {
                                str2 = list.get(0);
                            }
                            if (str2 == null) {
                                Util.closeQuietly(dataSourceInputStream);
                                str = str2;
                            } else {
                                throw e;
                            }
                        } else {
                            i = i2;
                        }
                    }
                    z = false;
                    str2 = null;
                    if (z) {
                        str2 = list.get(0);
                    }
                    if (str2 == null) {
                    }
                } finally {
                    Util.closeQuietly(dataSourceInputStream);
                }
            }
        }
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.f15956d) {
            this.f15956d.clear();
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.f15956d) {
            this.f15956d.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
        String str;
        String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.f15955c || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.f15954b;
        }
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
        synchronized (this.f15956d) {
            hashMap.putAll(this.f15956d);
        }
        try {
            return m4476a(this.f15953a, licenseServerUrl, keyRequest.getData(), hashMap);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) {
        try {
            return m4476a(this.f15953a, provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData()), Util.EMPTY_BYTE_ARRAY, null);
        } catch (IOException unused) {
            return null;
        }
    }

    public void setDefaultLicenseUrl(String str) {
        this.f15954b = str;
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.f15956d) {
            this.f15956d.put(str, str2);
        }
    }

    public TvingHttpMediaDrmCallback(String str, boolean z, HttpDataSource.Factory factory) {
        this.f15953a = factory;
        this.f15954b = str;
        this.f15955c = z;
        this.f15956d = new HashMap();
    }
}
