package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.time.Instant;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1919vr;
import p000.ye0;
import p000.yt2;
import p000.zt2;

@Metadata(m5568d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001-B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bB\u0011\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u001f\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u001b¨\u0006."}, m5569d2 = {"Lcom/google/firebase/Timestamp;", "", "Landroid/os/Parcelable;", "", "seconds", "", "nanoseconds", "<init>", "(JI)V", "Ljava/util/Date;", "date", "(Ljava/util/Date;)V", "Ljava/time/Instant;", "time", "(Ljava/time/Instant;)V", "toDate", "()Ljava/util/Date;", "toInstant", "()Ljava/time/Instant;", "other", "compareTo", "(Lcom/google/firebase/Timestamp;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "a", "J", "getSeconds", "()J", "b", "I", "getNanoseconds", "Companion", "com.google.firebase-firebase-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {

    /* renamed from: a, reason: from kotlin metadata */
    public final long seconds;

    /* renamed from: b, reason: from kotlin metadata */
    public final int nanoseconds;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Timestamp> CREATOR = new Object();

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5569d2 = {"Lcom/google/firebase/Timestamp$Companion;", "", "Lcom/google/firebase/Timestamp;", "now", "()Lcom/google/firebase/Timestamp;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "com.google.firebase-firebase-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final Pair access$toPreciseTime(Companion companion, Date date) {
            companion.getClass();
            long j = 1000;
            long time = date.getTime() / j;
            int time2 = (int) ((date.getTime() % j) * 1000000);
            if (time2 < 0) {
                return TuplesKt.m5575to(Long.valueOf(time - 1), Integer.valueOf(time2 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
            }
            return TuplesKt.m5575to(Long.valueOf(time), Integer.valueOf(time2));
        }

        public static final void access$validateRange(Companion companion, long j, int i) {
            companion.getClass();
            if (i >= 0 && i < 1000000000) {
                if (-62135596800L <= j && j < 253402300800L) {
                    return;
                } else {
                    throw new IllegalArgumentException(ye0.m8294n(j, "Timestamp seconds out of range: ").toString());
                }
            }
            throw new IllegalArgumentException(ye0.m8291k(i, "Timestamp nanoseconds out of range: ").toString());
        }

        @JvmStatic
        @NotNull
        public final Timestamp now() {
            return new Timestamp(new Date());
        }
    }

    public Timestamp(long j, int i) {
        Companion.access$validateRange(INSTANCE, j, i);
        this.seconds = j;
        this.nanoseconds = i;
    }

    @JvmStatic
    @NotNull
    public static final Timestamp now() {
        return INSTANCE.now();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (other != this && (!(other instanceof Timestamp) || compareTo((Timestamp) other) != 0)) {
            return false;
        }
        return true;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j = this.seconds;
        return (((((int) j) * 1369) + ((int) (j >> 32))) * 37) + this.nanoseconds;
    }

    @NotNull
    public final Date toDate() {
        return new Date((this.seconds * 1000) + (this.nanoseconds / 1000000));
    }

    @RequiresApi(26)
    @NotNull
    public final Instant toInstant() {
        Instant ofEpochSecond;
        ofEpochSecond = Instant.ofEpochSecond(this.seconds, this.nanoseconds);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(seconds, nanoseconds.toLong())");
        return ofEpochSecond;
    }

    @NotNull
    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Timestamp other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return AbstractC1919vr.compareValuesBy(this, other, yt2.f29132g, zt2.f29521g);
    }

    public Timestamp(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        Companion companion = INSTANCE;
        Pair access$toPreciseTime = Companion.access$toPreciseTime(companion, date);
        long longValue = ((Number) access$toPreciseTime.component1()).longValue();
        int intValue = ((Number) access$toPreciseTime.component2()).intValue();
        Companion.access$validateRange(companion, longValue, intValue);
        this.seconds = longValue;
        this.nanoseconds = intValue;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Timestamp(@NotNull Instant time) {
        this(r0, r3);
        long epochSecond;
        int nano;
        Intrinsics.checkNotNullParameter(time, "time");
        epochSecond = time.getEpochSecond();
        nano = time.getNano();
    }
}
