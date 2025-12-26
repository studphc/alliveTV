package com.hisona.allive;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@GlideModule
/* loaded from: classes2.dex */
public class TrustAllGlideModule extends AppGlideModule {

    /* loaded from: classes2.dex */
    public static class TrustAllCertsManager implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public void applyOptions(@NotNull Context context, @NotNull GlideBuilder glideBuilder) {
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, javax.net.ssl.HostnameVerifier] */
    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TrustManager[] trustManagerArr = {new TrustAllCertsManager()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            OkHttpClient.Builder sslSocketFactory = builder.sslSocketFactory(sSLContext.getSocketFactory(), new TrustAllCertsManager());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            sslSocketFactory.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).hostnameVerifier(new Object());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        glide.getRegistry().replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(builder.build()));
    }
}
