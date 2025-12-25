package com.orhanobut.hawk;

import android.content.Context;
import p000.InterfaceC1665ow;
import p000.p63;
import p000.z80;

/* loaded from: classes2.dex */
public class HawkBuilder {

    /* renamed from: a */
    public final Context f16034a;

    /* renamed from: b */
    public Storage f16035b;

    /* renamed from: c */
    public InterfaceC1665ow f16036c;

    /* renamed from: d */
    public Parser f16037d;

    /* renamed from: e */
    public z80 f16038e;

    /* renamed from: f */
    public Serializer f16039f;

    /* renamed from: g */
    public LogInterceptor f16040g;

    public HawkBuilder(Context context) {
        p63.m6871o(context, "Context");
        this.f16034a = context.getApplicationContext();
    }

    public void build() {
        HawkFacade hawkFacade = Hawk.f16033a;
        Hawk.f16033a = new DefaultHawkFacade(this);
    }

    public HawkBuilder setConverter(InterfaceC1665ow interfaceC1665ow) {
        this.f16036c = interfaceC1665ow;
        return this;
    }

    public HawkBuilder setEncryption(z80 z80Var) {
        this.f16038e = z80Var;
        return this;
    }

    public HawkBuilder setLogInterceptor(LogInterceptor logInterceptor) {
        this.f16040g = logInterceptor;
        return this;
    }

    public HawkBuilder setParser(Parser parser) {
        this.f16037d = parser;
        return this;
    }

    public HawkBuilder setSerializer(Serializer serializer) {
        this.f16039f = serializer;
        return this;
    }

    public HawkBuilder setStorage(Storage storage) {
        this.f16035b = storage;
        return this;
    }
}
