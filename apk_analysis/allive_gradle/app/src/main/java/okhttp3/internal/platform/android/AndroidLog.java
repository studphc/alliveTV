package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.lh1;

@SuppressSignatureCheck
@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001J1\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", "", "", "loggerName", "", "logLevel", "message", "", "t", "", "androidLog$okhttp", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "androidLog", "enable", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class AndroidLog {

    @NotNull
    public static final AndroidLog INSTANCE = new Object();

    /* renamed from: a */
    public static final CopyOnWriteArraySet f24560a = new CopyOnWriteArraySet();

    /* renamed from: b */
    public static final Map f24561b;

    /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.platform.android.AndroidLog, java.lang.Object] */
    static {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        if (r2 != null) {
            str = r2.getName();
        } else {
            str = null;
        }
        if (str != null) {
            linkedHashMap.put(str, "OkHttp");
        }
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        linkedHashMap.put(name, "okhttp.OkHttpClient");
        String name2 = Http2.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "Http2::class.java.name");
        linkedHashMap.put(name2, "okhttp.Http2");
        String name3 = TaskRunner.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "TaskRunner::class.java.name");
        linkedHashMap.put(name3, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f24561b = lh1.toMap(linkedHashMap);
    }

    public final void androidLog$okhttp(@NotNull String loggerName, int logLevel, @NotNull String message, @Nullable Throwable t) {
        int min;
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(message, "message");
        String str = (String) f24561b.get(loggerName);
        if (str == null) {
            str = StringsKt___StringsKt.take(loggerName, 23);
        }
        if (Log.isLoggable(str, logLevel)) {
            if (t != null) {
                message = message + '\n' + Log.getStackTraceString(t);
            }
            int length = message.length();
            int i = 0;
            while (i < length) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) message, '\n', i, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = length;
                }
                while (true) {
                    min = Math.min(indexOf$default, i + 4000);
                    String substring = message.substring(i, min);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(logLevel, str, substring);
                    if (min >= indexOf$default) {
                        break;
                    } else {
                        i = min;
                    }
                }
                i = min + 1;
            }
        }
    }

    public final void enable() {
        Level level;
        for (Map.Entry entry : f24561b.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            Logger logger = Logger.getLogger(str);
            if (f24560a.add(logger)) {
                logger.setUseParentHandlers(false);
                if (Log.isLoggable(str2, 3)) {
                    level = Level.FINE;
                } else if (Log.isLoggable(str2, 4)) {
                    level = Level.INFO;
                } else {
                    level = Level.WARNING;
                }
                logger.setLevel(level);
                logger.addHandler(AndroidLogHandler.INSTANCE);
            }
        }
    }
}
