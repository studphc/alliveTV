package com.orhanobut.hawk;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class GsonParser implements Parser {

    /* renamed from: a */
    public final Gson f16032a;

    public GsonParser(Gson gson) {
        this.f16032a = gson;
    }

    @Override // com.orhanobut.hawk.Parser
    public <T> T fromJson(String str, Type type) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) this.f16032a.fromJson(str, type);
    }

    @Override // com.orhanobut.hawk.Parser
    public String toJson(Object obj) {
        return this.f16032a.toJson(obj);
    }
}
