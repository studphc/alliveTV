package com.hisona.allive;

import android.os.Bundle;

/* loaded from: classes2.dex */
public interface ResultListener {
    public static final int RESULT_CANCEL = -3;
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_PROGRESS = 3;
    public static final int RESULT_RETRY = 2;
    public static final int RESULT_START = 0;
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_TIMEOUT = -2;

    void onTaskTerminate(int i, int i2, Bundle bundle);
}
