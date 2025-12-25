package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.CodePackage;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IidStore {

    /* renamed from: c */
    public static final String[] f15595c = {"*", "FCM", CodePackage.GCM, ""};

    /* renamed from: a */
    public final SharedPreferences f15596a;

    /* renamed from: b */
    public final String f15597b;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r0.isEmpty() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IidStore(@NonNull FirebaseApp firebaseApp) {
        this.f15596a = firebaseApp.getApplicationContext().getSharedPreferences("com.google.android.gms.appid", 0);
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId == null) {
            gcmSenderId = firebaseApp.getOptions().getApplicationId();
            if (gcmSenderId.startsWith("1:") || gcmSenderId.startsWith("2:")) {
                String[] split = gcmSenderId.split(":");
                if (split.length == 4) {
                    gcmSenderId = split[1];
                }
                gcmSenderId = null;
            }
        }
        this.f15597b = gcmSenderId;
    }

    /* renamed from: a */
    public final String m4392a() {
        String string;
        synchronized (this.f15596a) {
            string = this.f15596a.getString("|S|id", null);
        }
        return string;
    }

    /* renamed from: b */
    public final String m4393b() {
        PublicKey publicKey;
        synchronized (this.f15596a) {
            String str = null;
            String string = this.f15596a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            try {
                publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                Log.w("ContentValues", "Invalid key stored " + e);
                publicKey = null;
            }
            if (publicKey == null) {
                return null;
            }
            try {
                byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
                digest[0] = (byte) (((digest[0] & Ascii.f14464SI) + 112) & 255);
                str = Base64.encodeToString(digest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
                Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            }
            return str;
        }
    }

    @Nullable
    public String readIid() {
        synchronized (this.f15596a) {
            try {
                String m4392a = m4392a();
                if (m4392a != null) {
                    return m4392a;
                }
                return m4393b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public String readToken() {
        synchronized (this.f15596a) {
            try {
                String[] strArr = f15595c;
                int i = 0;
                while (true) {
                    String str = null;
                    if (i >= 4) {
                        return null;
                    }
                    String str2 = strArr[i];
                    String string = this.f15596a.getString("|T|" + this.f15597b + "|" + str2, null);
                    if (string != null && !string.isEmpty()) {
                        if (string.startsWith("{")) {
                            try {
                                str = new JSONObject(string).getString("token");
                            } catch (JSONException unused) {
                            }
                            string = str;
                        }
                        return string;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public IidStore(@NonNull SharedPreferences sharedPreferences, @Nullable String str) {
        this.f15596a = sharedPreferences;
        this.f15597b = str;
    }
}
