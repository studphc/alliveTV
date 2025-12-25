package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.av0;

@RequiresApi(18)
/* loaded from: classes.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm {
    public static final ExoMediaDrm.Provider DEFAULT_PROVIDER = new Object();

    /* renamed from: a */
    public final UUID f9988a;

    /* renamed from: b */
    public final MediaDrm f9989b;

    /* renamed from: c */
    public int f9990c;

    public FrameworkMediaDrm(UUID uuid) {
        Assertions.checkNotNull(uuid);
        Assertions.checkArgument(!C0643C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f9988a = uuid;
        MediaDrm mediaDrm = new MediaDrm(m2517a(uuid));
        this.f9989b = mediaDrm;
        this.f9990c = 1;
        if (C0643C.WIDEVINE_UUID.equals(uuid) && "ASUS_Z00AD".equals(Util.MODEL)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    /* renamed from: a */
    public static UUID m2517a(UUID uuid) {
        if (Util.SDK_INT < 27 && C0643C.CLEARKEY_UUID.equals(uuid)) {
            return C0643C.COMMON_PSSH_UUID;
        }
        return uuid;
    }

    public static boolean isCryptoSchemeSupported(UUID uuid) {
        return MediaDrm.isCryptoSchemeSupported(m2517a(uuid));
    }

    public static FrameworkMediaDrm newInstance(UUID uuid) {
        try {
            return new FrameworkMediaDrm(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void acquire() {
        boolean z;
        if (this.f9990c > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f9990c++;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
        this.f9989b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public int getCryptoType() {
        return 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
    
        if ("AFTT".equals(r6) == false) goto L76;
     */
    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap) {
        DrmInitData.SchemeData schemeData;
        byte[] bArr2;
        String str;
        int i2;
        String str2;
        UUID uuid = this.f9988a;
        if (list != null) {
            if (!C0643C.WIDEVINE_UUID.equals(uuid)) {
                schemeData = list.get(0);
            } else {
                if (Util.SDK_INT >= 28 && list.size() > 1) {
                    DrmInitData.SchemeData schemeData2 = list.get(0);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        DrmInitData.SchemeData schemeData3 = list.get(i4);
                        byte[] bArr3 = (byte[]) Assertions.checkNotNull(schemeData3.data);
                        if (Util.areEqual(schemeData3.mimeType, schemeData2.mimeType) && Util.areEqual(schemeData3.licenseServerUrl, schemeData2.licenseServerUrl) && PsshAtomUtil.isPsshAtom(bArr3)) {
                            i3 += bArr3.length;
                        }
                    }
                    byte[] bArr4 = new byte[i3];
                    int i5 = 0;
                    for (int i6 = 0; i6 < list.size(); i6++) {
                        byte[] bArr5 = (byte[]) Assertions.checkNotNull(list.get(i6).data);
                        int length = bArr5.length;
                        System.arraycopy(bArr5, 0, bArr4, i5, length);
                        i5 += length;
                    }
                    schemeData = schemeData2.copyWithData(bArr4);
                }
                for (int i7 = 0; i7 < list.size(); i7++) {
                    DrmInitData.SchemeData schemeData4 = list.get(i7);
                    int parseVersion = PsshAtomUtil.parseVersion((byte[]) Assertions.checkNotNull(schemeData4.data));
                    int i8 = Util.SDK_INT;
                    if ((i8 < 23 && parseVersion == 0) || (i8 >= 23 && parseVersion == 1)) {
                        schemeData = schemeData4;
                        break;
                    }
                }
                schemeData = list.get(0);
            }
            byte[] bArr6 = (byte[]) Assertions.checkNotNull(schemeData.data);
            UUID uuid2 = C0643C.PLAYREADY_UUID;
            if (uuid2.equals(uuid)) {
                byte[] parseSchemeSpecificData = PsshAtomUtil.parseSchemeSpecificData(bArr6, uuid);
                if (parseSchemeSpecificData != null) {
                    bArr6 = parseSchemeSpecificData;
                }
                ParsableByteArray parsableByteArray = new ParsableByteArray(bArr6);
                int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
                short readLittleEndianShort = parsableByteArray.readLittleEndianShort();
                short readLittleEndianShort2 = parsableByteArray.readLittleEndianShort();
                if (readLittleEndianShort == 1 && readLittleEndianShort2 == 1) {
                    short readLittleEndianShort3 = parsableByteArray.readLittleEndianShort();
                    Charset charset = Charsets.UTF_16LE;
                    String readString = parsableByteArray.readString(readLittleEndianShort3, charset);
                    if (!readString.contains("<LA_URL>")) {
                        int indexOf = readString.indexOf("</DATA>");
                        if (indexOf == -1) {
                            Log.m3027w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                        }
                        String str3 = readString.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + readString.substring(indexOf);
                        int i9 = readLittleEndianInt + 52;
                        ByteBuffer allocate = ByteBuffer.allocate(i9);
                        allocate.order(ByteOrder.LITTLE_ENDIAN);
                        allocate.putInt(i9);
                        allocate.putShort(readLittleEndianShort);
                        allocate.putShort(readLittleEndianShort2);
                        allocate.putShort((short) (str3.length() * 2));
                        allocate.put(str3.getBytes(charset));
                        bArr6 = allocate.array();
                    }
                } else {
                    Log.m3025i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                }
                bArr6 = PsshAtomUtil.buildPsshAtom(uuid2, bArr6);
            }
            int i10 = Util.SDK_INT;
            if (i10 >= 23 || !C0643C.WIDEVINE_UUID.equals(uuid)) {
                if (uuid2.equals(uuid) && "Amazon".equals(Util.MANUFACTURER)) {
                    String str4 = Util.MODEL;
                    if (!"AFTB".equals(str4)) {
                        if (!"AFTS".equals(str4)) {
                            if (!"AFTM".equals(str4)) {
                            }
                        }
                    }
                }
                str2 = schemeData.mimeType;
                if (i10 < 26 && C0643C.CLEARKEY_UUID.equals(uuid) && (MimeTypes.VIDEO_MP4.equals(str2) || MimeTypes.AUDIO_MP4.equals(str2))) {
                    str2 = C0643C.CENC_TYPE_cenc;
                }
                str = str2;
                bArr2 = bArr6;
            }
            byte[] parseSchemeSpecificData2 = PsshAtomUtil.parseSchemeSpecificData(bArr6, uuid);
            if (parseSchemeSpecificData2 != null) {
                bArr6 = parseSchemeSpecificData2;
            }
            str2 = schemeData.mimeType;
            if (i10 < 26) {
                str2 = C0643C.CENC_TYPE_cenc;
            }
            str = str2;
            bArr2 = bArr6;
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f9989b.getKeyRequest(bArr, bArr2, str, i, hashMap);
        byte[] data = keyRequest.getData();
        if (C0643C.CLEARKEY_UUID.equals(uuid) && Util.SDK_INT < 27) {
            data = Util.getUtf8Bytes(Util.fromUtf8Bytes(data).replace('+', '-').replace('/', '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData != null && !TextUtils.isEmpty(schemeData.licenseServerUrl)) {
            defaultUrl = schemeData.licenseServerUrl;
        }
        if (Util.SDK_INT >= 23) {
            i2 = keyRequest.getRequestType();
        } else {
            i2 = Integer.MIN_VALUE;
        }
        return new ExoMediaDrm.KeyRequest(data, defaultUrl, i2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public PersistableBundle getMetrics() {
        PersistableBundle metrics;
        if (Util.SDK_INT >= 28) {
            metrics = this.f9989b.getMetrics();
            return metrics;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String str) {
        return this.f9989b.getPropertyByteArray(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String str) {
        return this.f9989b.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.f9989b.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() {
        return this.f9989b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        if (C0643C.CLEARKEY_UUID.equals(this.f9988a) && Util.SDK_INT < 27) {
            try {
                JSONObject jSONObject = new JSONObject(Util.fromUtf8Bytes(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = Util.getUtf8Bytes(sb.toString());
            } catch (JSONException e) {
                Log.m3024e("ClearKeyUtil", "Failed to adjust response data: " + Util.fromUtf8Bytes(bArr2), e);
            }
        }
        return this.f9989b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) {
        this.f9989b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.f9989b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void release() {
        int i = this.f9990c - 1;
        this.f9990c = i;
        if (i == 0) {
            this.f9989b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public boolean requiresSecureDecoder(byte[] bArr, String str) {
        if (Util.SDK_INT >= 31) {
            return av0.m1967a(this.f9989b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f9988a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f9989b.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(@Nullable final ExoMediaDrm.OnEventListener onEventListener) {
        MediaDrm.OnEventListener onEventListener2;
        if (onEventListener == null) {
            onEventListener2 = null;
        } else {
            onEventListener2 = new MediaDrm.OnEventListener() { // from class: zu0
                @Override // android.media.MediaDrm.OnEventListener
                public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                    FrameworkMediaDrm frameworkMediaDrm = FrameworkMediaDrm.this;
                    frameworkMediaDrm.getClass();
                    onEventListener.onEvent(frameworkMediaDrm, bArr, i, i2, bArr2);
                }
            };
        }
        this.f9989b.setOnEventListener(onEventListener2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @RequiresApi(23)
    public void setOnExpirationUpdateListener(@Nullable final ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        MediaDrm.OnExpirationUpdateListener onExpirationUpdateListener2;
        if (Util.SDK_INT >= 23) {
            if (onExpirationUpdateListener == null) {
                onExpirationUpdateListener2 = null;
            } else {
                onExpirationUpdateListener2 = new MediaDrm.OnExpirationUpdateListener() { // from class: yu0
                    @Override // android.media.MediaDrm.OnExpirationUpdateListener
                    public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j) {
                        FrameworkMediaDrm frameworkMediaDrm = FrameworkMediaDrm.this;
                        frameworkMediaDrm.getClass();
                        onExpirationUpdateListener.onExpirationUpdate(frameworkMediaDrm, bArr, j);
                    }
                };
            }
            this.f9989b.setOnExpirationUpdateListener(onExpirationUpdateListener2, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @RequiresApi(23)
    public void setOnKeyStatusChangeListener(@Nullable final ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        MediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener2;
        if (Util.SDK_INT >= 23) {
            if (onKeyStatusChangeListener == null) {
                onKeyStatusChangeListener2 = null;
            } else {
                onKeyStatusChangeListener2 = new MediaDrm.OnKeyStatusChangeListener() { // from class: wu0
                    @Override // android.media.MediaDrm.OnKeyStatusChangeListener
                    public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
                        FrameworkMediaDrm frameworkMediaDrm = FrameworkMediaDrm.this;
                        frameworkMediaDrm.getClass();
                        ArrayList arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            MediaDrm.KeyStatus keyStatus = (MediaDrm.KeyStatus) it.next();
                            arrayList.add(new ExoMediaDrm.KeyStatus(keyStatus.getStatusCode(), keyStatus.getKeyId()));
                        }
                        onKeyStatusChangeListener.onKeyStatusChange(frameworkMediaDrm, bArr, arrayList, z);
                    }
                };
            }
            this.f9989b.setOnKeyStatusChangeListener(onKeyStatusChangeListener2, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPlayerIdForSession(byte[] bArr, PlayerId playerId) {
        if (Util.SDK_INT >= 31) {
            try {
                av0.m1968b(this.f9989b, bArr, playerId);
            } catch (UnsupportedOperationException unused) {
                Log.m3027w("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String str, byte[] bArr) {
        this.f9989b.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String str, String str2) {
        this.f9989b.setPropertyString(str, str2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public FrameworkCryptoConfig createCryptoConfig(byte[] bArr) {
        int i = Util.SDK_INT;
        UUID uuid = this.f9988a;
        return new FrameworkCryptoConfig(m2517a(uuid), bArr, i < 21 && C0643C.WIDEVINE_UUID.equals(uuid) && "L3".equals(getPropertyString("securityLevel")));
    }
}
