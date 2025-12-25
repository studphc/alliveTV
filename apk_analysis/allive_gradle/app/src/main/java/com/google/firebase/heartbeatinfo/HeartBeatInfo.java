package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface HeartBeatInfo {

    /* loaded from: classes2.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* renamed from: a */
        public final int f15565a;

        HeartBeat(int i) {
            this.f15565a = i;
        }

        public int getCode() {
            return this.f15565a;
        }
    }

    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);
}
