package com.google.firebase.logger;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\b&\u0018\u0000 )2\u00020\u0001:\u0004*)+,J;\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\fJ;\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\r\u0010\nJ#\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\r\u0010\fJ;\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\nJ#\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\fJ;\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\nJ#\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\fJ;\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\nJ#\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\fJ;\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006-"}, m5569d2 = {"Lcom/google/firebase/logger/Logger;", "", "", "format", "", "args", "", "throwable", "", "verbose", "(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)I", NotificationCompat.CATEGORY_MESSAGE, "(Ljava/lang/String;Ljava/lang/Throwable;)I", "debug", "info", "warn", "error", "Lcom/google/firebase/logger/Logger$Level;", FirebaseAnalytics.Param.LEVEL, "log", "(Lcom/google/firebase/logger/Logger$Level;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)I", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "", "b", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "enabled", "c", "Lcom/google/firebase/logger/Logger$Level;", "getMinLevel", "()Lcom/google/firebase/logger/Logger$Level;", "setMinLevel", "(Lcom/google/firebase/logger/Logger$Level;)V", "minLevel", "Companion", "com/google/firebase/logger/a", "FakeLogger", "Level", "com.google.firebase-firebase-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,196:1\n26#2:197\n*S KotlinDebug\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger\n*L\n78#1:197\n*E\n"})
/* loaded from: classes2.dex */
public abstract class Logger {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d */
    public static final ConcurrentHashMap f15645d = new ConcurrentHashMap();

    /* renamed from: a, reason: from kotlin metadata */
    public final String tag;

    /* renamed from: b, reason: from kotlin metadata */
    public boolean enabled;

    /* renamed from: c, reason: from kotlin metadata */
    public Level minLevel;

    @Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Lcom/google/firebase/logger/Logger$Companion;", "", "", "tag", "", "enabled", "Lcom/google/firebase/logger/Logger$Level;", "minLevel", "Lcom/google/firebase/logger/Logger;", "getLogger", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)Lcom/google/firebase/logger/Logger;", "Lcom/google/firebase/logger/Logger$FakeLogger;", "setupFakeLogger", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)Lcom/google/firebase/logger/Logger$FakeLogger;", "Ljava/util/concurrent/ConcurrentHashMap;", "loggers", "Ljava/util/concurrent/ConcurrentHashMap;", "com.google.firebase-firebase-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$Companion\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n73#2,2:197\n1#3:199\n*S KotlinDebug\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$Companion\n*L\n180#1:197,2\n180#1:199\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ Logger getLogger$default(Companion companion, String str, boolean z, Level level, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                level = Level.INFO;
            }
            return companion.getLogger(str, z, level);
        }

        public static /* synthetic */ FakeLogger setupFakeLogger$default(Companion companion, String str, boolean z, Level level, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                level = Level.DEBUG;
            }
            return companion.setupFakeLogger(str, z, level);
        }

        @JvmStatic
        @NotNull
        public final Logger getLogger(@NotNull String tag, boolean enabled, @NotNull Level minLevel) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(minLevel, "minLevel");
            ConcurrentHashMap concurrentHashMap = Logger.f15645d;
            Object obj = concurrentHashMap.get(tag);
            if (obj == null) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(minLevel, "minLevel");
                obj = new Logger(tag, enabled, minLevel, null);
                Object putIfAbsent = concurrentHashMap.putIfAbsent(tag, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            }
            Intrinsics.checkNotNullExpressionValue(obj, "loggers.getOrPut(tag) { …tag, enabled, minLevel) }");
            return (Logger) obj;
        }

        @JvmStatic
        @VisibleForTesting
        @NotNull
        public final FakeLogger setupFakeLogger(@NotNull String tag, boolean enabled, @NotNull Level minLevel) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(minLevel, "minLevel");
            FakeLogger fakeLogger = new FakeLogger(tag, enabled, minLevel);
            Logger.f15645d.put(tag, fakeLogger);
            return fakeLogger;
        }
    }

    @Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0010\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m5569d2 = {"Lcom/google/firebase/logger/Logger$FakeLogger;", "Lcom/google/firebase/logger/Logger;", "", "tag", "", "enabled", "Lcom/google/firebase/logger/Logger$Level;", "minLevel", "<init>", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)V", FirebaseAnalytics.Param.LEVEL, "format", "", "", "args", "", "throwable", "", "log", "(Lcom/google/firebase/logger/Logger$Level;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)I", "", "clearLogMessages", "()V", "message", "hasLogMessage", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "predicate", "hasLogMessageThat", "(Lkotlin/jvm/functions/Function1;)Z", "com.google.firebase-firebase-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @VisibleForTesting
    @SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$FakeLogger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1747#2,3:197\n1747#2,3:200\n1#3:203\n*S KotlinDebug\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$FakeLogger\n*L\n144#1:197,3\n148#1:200,3\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class FakeLogger extends Logger {

        /* renamed from: e */
        public final ArrayList f15649e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FakeLogger(@NotNull String tag, boolean z, @NotNull Level minLevel) {
            super(tag, z, minLevel, null);
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(minLevel, "minLevel");
            this.f15649e = new ArrayList();
        }

        @VisibleForTesting
        public final void clearLogMessages() {
            this.f15649e.clear();
        }

        @VisibleForTesting
        public final boolean hasLogMessage(@NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            ArrayList arrayList = this.f15649e;
            if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
                return false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (StringsKt__StringsKt.contains$default((CharSequence) it.next(), (CharSequence) message, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        @VisibleForTesting
        public final boolean hasLogMessageThat(@NotNull Function1<? super String, Boolean> predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            ArrayList arrayList = this.f15649e;
            if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
                return false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (predicate.invoke(it.next()).booleanValue()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0046, code lost:
        
            if (r5 == null) goto L10;
         */
        @Override // com.google.firebase.logger.Logger
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int log(@NotNull Level level, @NotNull String format, @NotNull Object[] args, @Nullable Throwable throwable) {
            String str;
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (args.length != 0) {
                Object[] copyOf = Arrays.copyOf(args, args.length);
                format = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            if (throwable != null) {
                str = level + ' ' + format + ' ' + Log.getStackTraceString(throwable);
            }
            str = level + ' ' + format;
            System.out.println((Object) AbstractC1726qj.m7038C("Log: ", str));
            this.f15649e.add(str);
            return str.length();
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m5569d2 = {"Lcom/google/firebase/logger/Logger$Level;", "", "", "a", "I", "getPriority$com_google_firebase_firebase_common", "()I", "priority", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "com.google.firebase-firebase-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public enum Level {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);


        /* renamed from: a, reason: from kotlin metadata */
        public final int priority;

        Level(int i) {
            this.priority = i;
        }

        /* renamed from: getPriority$com_google_firebase_firebase_common, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }
    }

    public Logger(String str, boolean z, Level level, DefaultConstructorMarker defaultConstructorMarker) {
        this.tag = str;
        this.enabled = z;
        this.minLevel = level;
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.debug(str, objArr, th);
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.error(str, objArr, th);
    }

    @JvmStatic
    @NotNull
    public static final Logger getLogger(@NotNull String str, boolean z, @NotNull Level level) {
        return INSTANCE.getLogger(str, z, level);
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.info(str, objArr, th);
    }

    @JvmStatic
    @VisibleForTesting
    @NotNull
    public static final FakeLogger setupFakeLogger(@NotNull String str, boolean z, @NotNull Level level) {
        return INSTANCE.setupFakeLogger(str, z, level);
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.verbose(str, objArr, th);
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.warn(str, objArr, th);
    }

    /* renamed from: a */
    public final int m4406a(Level level, String str, Object[] objArr, Throwable th) {
        if (this.enabled && (this.minLevel.getPriority() <= level.getPriority() || Log.isLoggable(this.tag, level.getPriority()))) {
            return log(level, str, objArr, th);
        }
        return 0;
    }

    @JvmOverloads
    public final int debug(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return debug$default(this, msg, null, 2, null);
    }

    @JvmOverloads
    public final int error(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return error$default(this, msg, null, 2, null);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final Level getMinLevel() {
        return this.minLevel;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @JvmOverloads
    public final int info(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return info$default(this, msg, null, 2, null);
    }

    public abstract int log(@NotNull Level level, @NotNull String format, @NotNull Object[] args, @Nullable Throwable throwable);

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setMinLevel(@NotNull Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.minLevel = level;
    }

    @JvmOverloads
    public final int verbose(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return verbose$default(this, msg, null, 2, null);
    }

    @JvmOverloads
    public final int warn(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return warn$default(this, msg, null, 2, null);
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.debug(str, th);
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.error(str, th);
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.info(str, th);
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.verbose(str, th);
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.warn(str, th);
    }

    @JvmOverloads
    public final int debug(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return debug$default(this, format, args, null, 4, null);
    }

    @JvmOverloads
    public final int error(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return error$default(this, format, args, null, 4, null);
    }

    @JvmOverloads
    public final int info(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return info$default(this, format, args, null, 4, null);
    }

    @JvmOverloads
    public final int verbose(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return verbose$default(this, format, args, null, 4, null);
    }

    @JvmOverloads
    public final int warn(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return warn$default(this, format, args, null, 4, null);
    }

    @JvmOverloads
    public final int debug(@NotNull String format, @NotNull Object[] args, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return m4406a(Level.DEBUG, format, args, throwable);
    }

    @JvmOverloads
    public final int error(@NotNull String format, @NotNull Object[] args, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return m4406a(Level.ERROR, format, args, throwable);
    }

    @JvmOverloads
    public final int info(@NotNull String format, @NotNull Object[] args, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return m4406a(Level.INFO, format, args, throwable);
    }

    @JvmOverloads
    public final int verbose(@NotNull String format, @NotNull Object[] args, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return m4406a(Level.VERBOSE, format, args, throwable);
    }

    @JvmOverloads
    public final int warn(@NotNull String format, @NotNull Object[] args, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        return m4406a(Level.WARN, format, args, throwable);
    }

    @JvmOverloads
    public final int debug(@NotNull String msg, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return m4406a(Level.DEBUG, msg, new Object[0], throwable);
    }

    @JvmOverloads
    public final int error(@NotNull String msg, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return m4406a(Level.ERROR, msg, new Object[0], throwable);
    }

    @JvmOverloads
    public final int info(@NotNull String msg, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return m4406a(Level.INFO, msg, new Object[0], throwable);
    }

    @JvmOverloads
    public final int verbose(@NotNull String msg, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return m4406a(Level.VERBOSE, msg, new Object[0], throwable);
    }

    @JvmOverloads
    public final int warn(@NotNull String msg, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return m4406a(Level.WARN, msg, new Object[0], throwable);
    }
}
