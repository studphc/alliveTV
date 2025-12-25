package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m5569d2 = {"com/google/firebase/Timestamp$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/google/firebase/Timestamp;", "createFromParcel", FirebaseAnalytics.Param.SOURCE, "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/google/firebase/Timestamp;", "com.google.firebase-firebase-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Timestamp$Companion$CREATOR$1 implements Parcelable.Creator<Timestamp> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    @NotNull
    public Timestamp createFromParcel(@NotNull Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Timestamp(source.readLong(), source.readInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    @NotNull
    public Timestamp[] newArray(int size) {
        return new Timestamp[size];
    }
}
