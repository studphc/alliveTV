package com.orhanobut.hawk;

import android.content.Context;
import com.facebook.crypto.Crypto;
import com.google.gson.Gson;
import p000.C1704py;
import p000.InterfaceC1665ow;
import p000.ai2;
import p000.b01;
import p000.p63;
import p000.wd0;
import p000.z80;

/* loaded from: classes2.dex */
public class DefaultHawkFacade implements HawkFacade {

    /* renamed from: a */
    public final Storage f16027a;

    /* renamed from: b */
    public final InterfaceC1665ow f16028b;

    /* renamed from: c */
    public final z80 f16029c;

    /* renamed from: d */
    public final Serializer f16030d;

    /* renamed from: e */
    public final LogInterceptor f16031e;

    public DefaultHawkFacade(HawkBuilder hawkBuilder) {
        z80 z80Var = hawkBuilder.f16038e;
        Context context = hawkBuilder.f16034a;
        if (z80Var == null) {
            b01 b01Var = new b01(context);
            hawkBuilder.f16038e = b01Var;
            if (!((Crypto) b01Var.f7833b).isAvailable()) {
                hawkBuilder.f16038e = new NoEncryption();
            }
        }
        z80 z80Var2 = hawkBuilder.f16038e;
        this.f16029c = z80Var2;
        if (hawkBuilder.f16035b == null) {
            hawkBuilder.f16035b = new ai2(context);
        }
        this.f16027a = hawkBuilder.f16035b;
        if (hawkBuilder.f16036c == null) {
            if (hawkBuilder.f16037d == null) {
                hawkBuilder.f16037d = new GsonParser(new Gson());
            }
            hawkBuilder.f16036c = new b01(hawkBuilder.f16037d);
        }
        this.f16028b = hawkBuilder.f16036c;
        if (hawkBuilder.f16039f == null) {
            if (hawkBuilder.f16040g == null) {
                hawkBuilder.f16040g = new wd0(18);
            }
            hawkBuilder.f16039f = new b01(20, hawkBuilder.f16040g);
        }
        this.f16030d = hawkBuilder.f16039f;
        if (hawkBuilder.f16040g == null) {
            hawkBuilder.f16040g = new wd0(18);
        }
        LogInterceptor logInterceptor = hawkBuilder.f16040g;
        this.f16031e = logInterceptor;
        logInterceptor.onLog("Hawk.init -> Encryption : ".concat(z80Var2.getClass().getSimpleName()));
    }

    /* renamed from: a */
    public final void m4480a(String str) {
        this.f16031e.onLog(str);
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean contains(String str) {
        return this.f16027a.contains(str);
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public long count() {
        return this.f16027a.count();
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean delete(String str) {
        return this.f16027a.delete(str);
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean deleteAll() {
        return this.f16027a.deleteAll();
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public void destroy() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.orhanobut.hawk.HawkFacade
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T get(String str) {
        String str2;
        m4480a("Hawk.get -> key: " + str);
        T t = null;
        if (str == null) {
            m4480a("Hawk.get -> null key, returning null value ");
            return null;
        }
        String str3 = (String) this.f16027a.get(str);
        m4480a("Hawk.get -> Fetched from storage : " + str3);
        if (str3 == null) {
            m4480a("Hawk.get -> Fetching from storage failed");
            return null;
        }
        C1704py deserialize = this.f16030d.deserialize(str3);
        m4480a("Hawk.get -> Deserialized");
        if (deserialize == null) {
            m4480a("Hawk.get -> Deserialization failed");
            return null;
        }
        try {
            str2 = this.f16029c.decrypt(str, deserialize.f25333b);
        } catch (Exception e) {
            e = e;
            str2 = null;
        }
        try {
            m4480a("Hawk.get -> Decrypted to : " + str2);
        } catch (Exception e2) {
            e = e2;
            m4480a("Hawk.get -> Decrypt failed: " + e.getMessage());
            if (str2 != null) {
            }
        }
        if (str2 != null) {
            m4480a("Hawk.get -> Decrypt failed");
            return null;
        }
        try {
            t = (T) ((b01) this.f16028b).m1997n(str2, deserialize);
            m4480a("Hawk.get -> Converted to : " + t);
            return t;
        } catch (Exception unused) {
            m4480a("Hawk.get -> Converter failed");
            return t;
        }
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean isBuilt() {
        return true;
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public <T> boolean put(String str, T t) {
        p63.m6871o(str, "Key");
        m4480a("Hawk.put -> key: " + str + ", value: " + t);
        if (t == null) {
            m4480a("Hawk.put -> Value is null. Any existing value will be deleted with the given key");
            return delete(str);
        }
        String json = ((Parser) ((b01) this.f16028b).f7833b).toJson(t);
        m4480a("Hawk.put -> Converted to " + json);
        if (json == null) {
            m4480a("Hawk.put -> Converter failed");
            return false;
        }
        String str2 = null;
        try {
            str2 = this.f16029c.encrypt(str, json);
            m4480a("Hawk.put -> Encrypted to  " + str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str2 == null) {
            m4480a("Hawk.put -> Encryption failed");
            return false;
        }
        String serialize = this.f16030d.serialize(str2, t);
        m4480a("Hawk.put -> Serialized to" + serialize);
        if (serialize == null) {
            m4480a("Hawk.put -> Serialization failed");
            return false;
        }
        if (this.f16027a.put(str, serialize)) {
            m4480a("Hawk.put -> Stored successfully");
            return true;
        }
        m4480a("Hawk.put -> Store operation failed");
        return false;
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public <T> T get(String str, T t) {
        T t2 = (T) get(str);
        return t2 == null ? t : t2;
    }
}
