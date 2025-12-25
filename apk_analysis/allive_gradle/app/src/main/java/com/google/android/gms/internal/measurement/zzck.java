package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
/* loaded from: classes.dex */
public final class zzck {

    /* renamed from: a */
    public static final Method f13804a;

    /* renamed from: b */
    public static final Method f13805b;

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Method declaredMethod;
        Method method = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
            }
            f13804a = declaredMethod;
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    method = UserHandle.class.getDeclaredMethod("myUserId", null);
                } catch (NoSuchMethodException unused2) {
                    if (Log.isLoggable("JobSchedulerCompat", 6)) {
                        Log.e("JobSchedulerCompat", "No myUserId method available");
                    }
                }
            }
            f13805b = method;
        }
        declaredMethod = null;
        f13804a = declaredMethod;
        if (Build.VERSION.SDK_INT >= 24) {
        }
        f13805b = method;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        Integer num;
        int intValue;
        JobScheduler jobScheduler = (JobScheduler) Preconditions.checkNotNull((JobScheduler) context.getSystemService("jobscheduler"));
        Method method = f13804a;
        if (method != null && context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0) {
            Method method2 = f13805b;
            if (method2 != null) {
                try {
                    num = (Integer) method2.invoke(UserHandle.class, null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    if (Log.isLoggable("JobSchedulerCompat", 6)) {
                        Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                    }
                }
                if (num != null) {
                    intValue = num.intValue();
                    if (method != null) {
                        try {
                            Integer num2 = (Integer) method.invoke(jobScheduler, jobInfo, "com.google.android.gms", Integer.valueOf(intValue), "UploadAlarm");
                            if (num2 == null) {
                                return 0;
                            }
                            return num2.intValue();
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            Log.e("UploadAlarm", "error calling scheduleAsPackage", e2);
                        }
                    }
                    return jobScheduler.schedule(jobInfo);
                }
            }
            intValue = 0;
            if (method != null) {
            }
            return jobScheduler.schedule(jobInfo);
        }
        return jobScheduler.schedule(jobInfo);
    }
}
