package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import java.util.List;
import p000.C1831td;

@AutoValue
/* loaded from: classes2.dex */
public abstract class HeartBeatResult {
    public static HeartBeatResult create(String str, List<String> list) {
        return new C1831td(str, list);
    }

    public abstract List<String> getUsedDates();

    public abstract String getUserAgent();
}
