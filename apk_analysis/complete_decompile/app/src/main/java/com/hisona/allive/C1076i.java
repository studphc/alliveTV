package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* renamed from: com.hisona.allive.i */
/* loaded from: classes2.dex */
public final class C1076i implements HttpRequest.ConnectionFactory {
    @Override // com.hisona.allive.HttpRequest.ConnectionFactory
    public final HttpURLConnection create(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // com.hisona.allive.HttpRequest.ConnectionFactory
    public final HttpURLConnection create(URL url, Proxy proxy) {
        return (HttpURLConnection) url.openConnection(proxy);
    }
}
