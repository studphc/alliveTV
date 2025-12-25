package com.google.firebase.logger;

import android.util.Log;
import com.google.firebase.logger.Logger;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.google.firebase.logger.a */
/* loaded from: classes2.dex */
public final class C1052a extends Logger {
    @Override // com.google.firebase.logger.Logger
    public final int log(Logger.Level level, String format, Object[] args, Throwable th) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length != 0) {
            Object[] copyOf = Arrays.copyOf(args, args.length);
            format = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        int i = Logger$AndroidLogger$WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            String tag = getTag();
                            if (th != null) {
                                return Log.e(tag, format, th);
                            }
                            return Log.e(tag, format);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    String tag2 = getTag();
                    if (th != null) {
                        return Log.w(tag2, format, th);
                    }
                    return Log.w(tag2, format);
                }
                String tag3 = getTag();
                if (th != null) {
                    return Log.i(tag3, format, th);
                }
                return Log.i(tag3, format);
            }
            String tag4 = getTag();
            if (th != null) {
                return Log.d(tag4, format, th);
            }
            return Log.d(tag4, format);
        }
        String tag5 = getTag();
        if (th != null) {
            return Log.v(tag5, format, th);
        }
        return Log.v(tag5, format);
    }
}
