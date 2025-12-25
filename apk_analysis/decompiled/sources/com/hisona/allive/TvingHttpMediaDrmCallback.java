package com.hisona.allive;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@TargetApi(18)
/* loaded from: classes2.dex */
public final class TvingHttpMediaDrmCallback implements MediaDrmCallback {
    public final HttpDataSource.Factory a;
    public String b;
    public final boolean c;
    public final HashMap d;

    public TvingHttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c A[LOOP:1: B:9:0x002c->B:34:0x009c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(com.google.android.exoplayer2.upstream.HttpDataSource.Factory r5, java.lang.String r6, byte[] r7, java.util.HashMap r8) {
        /*
            com.google.android.exoplayer2.upstream.HttpDataSource r5 = r5.createDataSource()
            if (r8 == 0) goto L2a
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        Le:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r8.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r5.setRequestProperty(r1, r0)
            goto Le
        L2a:
            r8 = 0
            r0 = r8
        L2c:
            com.google.android.exoplayer2.upstream.DataSpec$Builder r1 = new com.google.android.exoplayer2.upstream.DataSpec$Builder
            r1.<init>()
            android.net.Uri r6 = android.net.Uri.parse(r6)
            com.google.android.exoplayer2.upstream.DataSpec$Builder r6 = r1.setUri(r6)
            com.google.android.exoplayer2.upstream.DataSpec$Builder r6 = r6.setHttpBody(r7)
            r1 = 0
            com.google.android.exoplayer2.upstream.DataSpec$Builder r6 = r6.setPosition(r1)
            r1 = -1
            com.google.android.exoplayer2.upstream.DataSpec$Builder r6 = r6.setLength(r1)
            r1 = 2
            com.google.android.exoplayer2.upstream.DataSpec$Builder r6 = r6.setHttpMethod(r1)
            r1 = 1
            com.google.android.exoplayer2.upstream.DataSpec$Builder r6 = r6.setFlags(r1)
            com.google.android.exoplayer2.upstream.DataSpec r6 = r6.build()
            com.google.android.exoplayer2.upstream.DataSourceInputStream r2 = new com.google.android.exoplayer2.upstream.DataSourceInputStream
            r2.<init>(r5, r6)
            byte[] r5 = com.google.android.exoplayer2.util.Util.toByteArray(r2)     // Catch: java.lang.Throwable -> L64 com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException -> L66
            com.google.android.exoplayer2.util.Util.closeQuietly(r2)
            return r5
        L64:
            r5 = move-exception
            goto La2
        L66:
            r6 = move-exception
            int r3 = r6.responseCode     // Catch: java.lang.Throwable -> L64
            r4 = 307(0x133, float:4.3E-43)
            if (r3 == r4) goto L73
            int r3 = r6.responseCode     // Catch: java.lang.Throwable -> L64
            r4 = 308(0x134, float:4.32E-43)
            if (r3 != r4) goto L7b
        L73:
            int r3 = r0 + 1
            r4 = 5
            if (r0 >= r4) goto L7a
            r0 = r3
            goto L7c
        L7a:
            r0 = r3
        L7b:
            r1 = r8
        L7c:
            r3 = 0
            if (r1 == 0) goto L9a
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1 = r6.headerFields     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L9a
            java.lang.String r4 = "Location"
            java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.Throwable -> L64
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L9a
            boolean r4 = r1.isEmpty()     // Catch: java.lang.Throwable -> L64
            if (r4 != 0) goto L9a
            java.lang.Object r1 = r1.get(r8)     // Catch: java.lang.Throwable -> L64
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L64
        L9a:
            if (r3 == 0) goto La1
            com.google.android.exoplayer2.util.Util.closeQuietly(r2)
            r6 = r3
            goto L2c
        La1:
            throw r6     // Catch: java.lang.Throwable -> L64
        La2:
            com.google.android.exoplayer2.util.Util.closeQuietly(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisona.allive.TvingHttpMediaDrmCallback.a(com.google.android.exoplayer2.upstream.HttpDataSource$Factory, java.lang.String, byte[], java.util.HashMap):byte[]");
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.d) {
            this.d.clear();
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.d) {
            this.d.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
        String str;
        String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.c || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.b;
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = C.PLAYREADY_UUID;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else if (C.CLEARKEY_UUID.equals(uuid)) {
            str = HttpRequest.CONTENT_TYPE_JSON;
        } else {
            str = "application/octet-stream";
        }
        hashMap.put("Content-Type", str);
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.d) {
            hashMap.putAll(this.d);
        }
        try {
            return a(this.a, licenseServerUrl, keyRequest.getData(), hashMap);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) {
        try {
            return a(this.a, provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData()), Util.EMPTY_BYTE_ARRAY, null);
        } catch (IOException unused) {
            return null;
        }
    }

    public void setDefaultLicenseUrl(String str) {
        this.b = str;
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.d) {
            this.d.put(str, str2);
        }
    }

    public TvingHttpMediaDrmCallback(String str, boolean z, HttpDataSource.Factory factory) {
        this.a = factory;
        this.b = str;
        this.c = z;
        this.d = new HashMap();
    }
}
