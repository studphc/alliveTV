package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;
import p000.ye0;

/* loaded from: classes.dex */
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;

    /* renamed from: b */
    public static int f12723b = 0;

    /* renamed from: c */
    public static boolean f12724c = true;

    /* renamed from: a */
    public static final Object f12722a = new Object();

    /* renamed from: d */
    public static Logger f12725d = Logger.DEFAULT;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface LogLevel {
    }

    /* loaded from: classes.dex */
    public interface Logger {
        public static final Logger DEFAULT = new Object();

        /* renamed from: d */
        void mo3029d(String str, String str2);

        /* renamed from: e */
        void mo3030e(String str, String str2);

        /* renamed from: i */
        void mo3031i(String str, String str2);

        /* renamed from: w */
        void mo3032w(String str, String str2);
    }

    /* renamed from: a */
    public static String m3020a(String str, Throwable th) {
        String throwableString = getThrowableString(th);
        if (!TextUtils.isEmpty(throwableString)) {
            StringBuilder m8303w = ye0.m8303w(str, "\n  ");
            m8303w.append(throwableString.replace("\n", "\n  "));
            m8303w.append('\n');
            return m8303w.toString();
        }
        return str;
    }

    @Pure
    /* renamed from: d */
    public static void m3021d(@Size(max = 23) String str, String str2) {
        synchronized (f12722a) {
            try {
                if (f12723b == 0) {
                    f12725d.mo3029d(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    /* renamed from: e */
    public static void m3023e(@Size(max = 23) String str, String str2) {
        synchronized (f12722a) {
            try {
                if (f12723b <= 3) {
                    f12725d.mo3030e(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    public static int getLogLevel() {
        int i;
        synchronized (f12722a) {
            i = f12723b;
        }
        return i;
    }

    @Nullable
    @Pure
    public static String getThrowableString(@Nullable Throwable th) {
        boolean z;
        synchronized (f12722a) {
            try {
                if (th == null) {
                    return null;
                }
                Throwable th2 = th;
                while (true) {
                    if (th2 != null) {
                        if (th2 instanceof UnknownHostException) {
                            z = true;
                            break;
                        }
                        th2 = th2.getCause();
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    return "UnknownHostException (no network)";
                }
                if (!f12724c) {
                    return th.getMessage();
                }
                return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
            } finally {
            }
        }
    }

    @Pure
    /* renamed from: i */
    public static void m3025i(@Size(max = 23) String str, String str2) {
        synchronized (f12722a) {
            try {
                if (f12723b <= 1) {
                    f12725d.mo3031i(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setLogLevel(int i) {
        synchronized (f12722a) {
            f12723b = i;
        }
    }

    public static void setLogStackTraces(boolean z) {
        synchronized (f12722a) {
            f12724c = z;
        }
    }

    public static void setLogger(Logger logger) {
        synchronized (f12722a) {
            f12725d = logger;
        }
    }

    @Pure
    /* renamed from: w */
    public static void m3027w(@Size(max = 23) String str, String str2) {
        synchronized (f12722a) {
            try {
                if (f12723b <= 2) {
                    f12725d.mo3032w(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    /* renamed from: d */
    public static void m3022d(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        m3021d(str, m3020a(str2, th));
    }

    @Pure
    /* renamed from: e */
    public static void m3024e(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        m3023e(str, m3020a(str2, th));
    }

    @Pure
    /* renamed from: i */
    public static void m3026i(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        m3025i(str, m3020a(str2, th));
    }

    @Pure
    /* renamed from: w */
    public static void m3028w(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        m3027w(str, m3020a(str2, th));
    }
}
