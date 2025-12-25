package okhttp3.internal.concurrent;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\u001a5\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0080\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, m5569d2 = {"Ljava/util/logging/Logger;", "Lokhttp3/internal/concurrent/Task;", "task", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "Lkotlin/Function0;", "", "messageBlock", "", "taskLog", "(Ljava/util/logging/Logger;Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)V", ExifInterface.GPS_DIRECTION_TRUE, "block", "logElapsed", "(Ljava/util/logging/Logger;Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "ns", "formatDuration", "(J)Ljava/lang/String;", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TaskLoggerKt {
    public static final void access$log(Logger logger, Task task, TaskQueue taskQueue, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getCom.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String());
        sb.append(' ');
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getCom.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String());
        logger.fine(sb.toString());
    }

    @NotNull
    public static final String formatDuration(long j) {
        String m8297q;
        if (j <= -999500000) {
            m8297q = ye0.m8297q(new StringBuilder(), (j - 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS, " s ");
        } else if (j <= -999500) {
            m8297q = ye0.m8297q(new StringBuilder(), (j - 500000) / 1000000, " ms");
        } else if (j <= 0) {
            m8297q = ye0.m8297q(new StringBuilder(), (j - HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR) / 1000, " µs");
        } else if (j < 999500) {
            m8297q = ye0.m8297q(new StringBuilder(), (j + HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR) / 1000, " µs");
        } else if (j < 999500000) {
            m8297q = ye0.m8297q(new StringBuilder(), (j + 500000) / 1000000, " ms");
        } else {
            m8297q = ye0.m8297q(new StringBuilder(), (j + 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS, " s ");
        }
        String format = String.format("%6s", Arrays.copyOf(new Object[]{m8297q}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public static final <T> T logElapsed(@NotNull Logger logger, @NotNull Task task, @NotNull TaskQueue queue, @NotNull Function0<? extends T> block) {
        long j;
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(block, "block");
        boolean isLoggable = logger.isLoggable(Level.FINE);
        if (isLoggable) {
            j = queue.getTaskRunner().getBackend().nanoTime();
            access$log(logger, task, queue, "starting");
        } else {
            j = -1;
        }
        try {
            T invoke = block.invoke();
            InlineMarker.finallyStart(1);
            if (isLoggable) {
                access$log(logger, task, queue, "finished run in " + formatDuration(queue.getTaskRunner().getBackend().nanoTime() - j));
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (isLoggable) {
                access$log(logger, task, queue, "failed a run in " + formatDuration(queue.getTaskRunner().getBackend().nanoTime() - j));
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final void taskLog(@NotNull Logger logger, @NotNull Task task, @NotNull TaskQueue queue, @NotNull Function0<String> messageBlock) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(messageBlock, "messageBlock");
        if (logger.isLoggable(Level.FINE)) {
            access$log(logger, task, queue, messageBlock.invoke());
        }
    }
}
