package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.hisona.allive.HttpRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import p000.AbstractC1726qj;
import p000.mb2;

/* loaded from: classes2.dex */
public class FirebaseInstallationServiceClient {

    /* renamed from: d */
    public static final Pattern f15615d = Pattern.compile("[0-9]+s");

    /* renamed from: e */
    public static final Charset f15616e = Charset.forName("UTF-8");

    /* renamed from: a */
    public final Context f15617a;

    /* renamed from: b */
    public final Provider f15618b;

    /* renamed from: c */
    public final mb2 f15619c = new mb2();

    public FirebaseInstallationServiceClient(@NonNull Context context, @NonNull Provider<HeartBeatController> provider) {
        this.f15617a = context;
        this.f15618b = provider;
    }

    /* renamed from: a */
    public static URL m4395a(String str) {
        try {
            return new URL("https://firebaseinstallations.googleapis.com/v1/".concat(str));
        } catch (MalformedURLException e) {
            throw new FirebaseInstallationsException(e.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    /* renamed from: b */
    public static void m4396b(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        String m7038C;
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f15616e));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            Log.w("Firebase-Installations", str4);
            if (TextUtils.isEmpty(str)) {
                m7038C = "";
            } else {
                m7038C = AbstractC1726qj.m7038C(", ", str);
            }
            Log.w("Firebase-Installations", "Firebase options used while communicating with Firebase server APIs: " + str2 + ", " + str3 + m7038C);
        }
    }

    /* renamed from: d */
    public static long m4397d(String str) {
        Preconditions.checkArgument(f15615d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str != null && str.length() != 0) {
            return Long.parseLong(str.substring(0, str.length() - 1));
        }
        return 0L;
    }

    /* renamed from: e */
    public static InstallationResponse m4398e(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f15616e));
        TokenResult.Builder builder = TokenResult.builder();
        InstallationResponse.Builder builder2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                builder2.setUri(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                builder2.setFid(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                builder2.setRefreshToken(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        builder.setToken(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        builder.setTokenExpirationTimestamp(m4397d(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                builder2.setAuthToken(builder.build());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builder2.setResponseCode(InstallationResponse.ResponseCode.f15620OK).build();
    }

    /* renamed from: f */
    public static TokenResult m4399f(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f15616e));
        TokenResult.Builder builder = TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                builder.setToken(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                builder.setTokenExpirationTimestamp(m4397d(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builder.setResponseCode(TokenResult.ResponseCode.f15622OK).build();
    }

    /* renamed from: g */
    public static void m4400g(HttpURLConnection httpURLConnection, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:17.0.1");
            m4402i(httpURLConnection, jSONObject.toString().getBytes("UTF-8"));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: h */
    public static void m4401h(HttpURLConnection httpURLConnection) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:17.0.1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            m4402i(httpURLConnection, jSONObject2.toString().getBytes("UTF-8"));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: i */
    public static void m4402i(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
                try {
                    return;
                } catch (IOException unused) {
                    return;
                }
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
    }

    /* renamed from: c */
    public final HttpURLConnection m4403c(URL url, String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", HttpRequest.CONTENT_TYPE_JSON);
            httpURLConnection.addRequestProperty("Accept", HttpRequest.CONTENT_TYPE_JSON);
            httpURLConnection.addRequestProperty("Content-Encoding", HttpRequest.ENCODING_GZIP);
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            Context context = this.f15617a;
            httpURLConnection.addRequestProperty("X-Android-Package", context.getPackageName());
            HeartBeatController heartBeatController = (HeartBeatController) this.f15618b.get();
            if (heartBeatController != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) Tasks.await(heartBeatController.getHeartBeatsHeader()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e);
                } catch (ExecutionException e2) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e2);
                }
            }
            String str2 = null;
            try {
                byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
                if (packageCertificateHashBytes == null) {
                    Log.e("ContentValues", "Could not get fingerprint hash for package: " + context.getPackageName());
                } else {
                    str2 = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
                }
            } catch (PackageManager.NameNotFoundException e3) {
                Log.e("ContentValues", "No such package: " + context.getPackageName(), e3);
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", str2);
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
    
        android.util.Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
        r10 = com.google.firebase.installations.remote.InstallationResponse.builder().setResponseCode(com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG).build();
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InstallationResponse createFirebaseInstallation(@NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5) {
        HttpURLConnection m4403c;
        int responseCode;
        InstallationResponse m4398e;
        mb2 mb2Var = this.f15619c;
        if (mb2Var.m6125b()) {
            URL m4395a = m4395a("projects/" + str3 + "/installations");
            int i = 0;
            while (true) {
                boolean z = true;
                if (i <= 1) {
                    TrafficStats.setThreadStatsTag(32769);
                    m4403c = m4403c(m4395a, str);
                    try {
                        try {
                            m4403c.setRequestMethod(HttpRequest.METHOD_POST);
                            m4403c.setDoOutput(true);
                            if (str5 != null) {
                                m4403c.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                            }
                            m4400g(m4403c, str2, str4);
                            responseCode = m4403c.getResponseCode();
                            mb2Var.m6127d(responseCode);
                            if (responseCode < 200 || responseCode >= 300) {
                                z = false;
                            }
                        } catch (Throwable th) {
                            m4403c.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            throw th;
                        }
                    } catch (IOException | AssertionError unused) {
                    }
                    if (z) {
                        m4398e = m4398e(m4403c);
                        break;
                    }
                    m4396b(m4403c, str4, str, str3);
                    if (responseCode != 429) {
                        if (responseCode < 500 || responseCode >= 600) {
                            break;
                        }
                        m4403c.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        i++;
                    } else {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                } else {
                    throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
                }
            }
            m4403c.disconnect();
            TrafficStats.clearThreadStatsTag();
            return m4398e;
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    @NonNull
    public void deleteFirebaseInstallation(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        int responseCode;
        URL m4395a = m4395a("projects/" + str3 + "/installations/" + str2);
        int i = 0;
        while (i <= 1) {
            TrafficStats.setThreadStatsTag(32770);
            HttpURLConnection m4403c = m4403c(m4395a, str);
            try {
                m4403c.setRequestMethod(HttpRequest.METHOD_DELETE);
                m4403c.addRequestProperty("Authorization", "FIS_v2 " + str4);
                responseCode = m4403c.getResponseCode();
            } catch (IOException unused) {
            } catch (Throwable th) {
                m4403c.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th;
            }
            if (responseCode != 200 && responseCode != 401 && responseCode != 404) {
                m4396b(m4403c, null, str, str3);
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    throw new FirebaseInstallationsException("Bad config while trying to delete FID", FirebaseInstallationsException.Status.BAD_CONFIG);
                    break;
                }
                i++;
                m4403c.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
            m4403c.disconnect();
            TrafficStats.clearThreadStatsTag();
            return;
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0099, code lost:
    
        android.util.Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
        r10 = com.google.firebase.installations.remote.TokenResult.builder().setResponseCode(com.google.firebase.installations.remote.TokenResult.ResponseCode.BAD_CONFIG).build();
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TokenResult generateAuthToken(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        int responseCode;
        TokenResult m4399f;
        mb2 mb2Var = this.f15619c;
        if (mb2Var.m6125b()) {
            URL m4395a = m4395a("projects/" + str3 + "/installations/" + str2 + "/authTokens:generate");
            int i = 0;
            while (true) {
                boolean z = true;
                if (i <= 1) {
                    TrafficStats.setThreadStatsTag(32771);
                    HttpURLConnection m4403c = m4403c(m4395a, str);
                    try {
                        try {
                            m4403c.setRequestMethod(HttpRequest.METHOD_POST);
                            m4403c.addRequestProperty("Authorization", "FIS_v2 " + str4);
                            m4403c.setDoOutput(true);
                            m4401h(m4403c);
                            responseCode = m4403c.getResponseCode();
                            mb2Var.m6127d(responseCode);
                            if (responseCode < 200 || responseCode >= 300) {
                                z = false;
                            }
                        } finally {
                            m4403c.disconnect();
                            TrafficStats.clearThreadStatsTag();
                        }
                    } catch (IOException | AssertionError unused) {
                    }
                    if (z) {
                        m4399f = m4399f(m4403c);
                        break;
                    }
                    m4396b(m4403c, null, str, str3);
                    if (responseCode == 401 || responseCode == 404) {
                        break;
                    }
                    if (responseCode != 429) {
                        if (responseCode < 500 || responseCode >= 600) {
                            break;
                        }
                        i++;
                    } else {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                } else {
                    throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
                }
            }
            m4399f = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.AUTH_ERROR).build();
            return m4399f;
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }
}
