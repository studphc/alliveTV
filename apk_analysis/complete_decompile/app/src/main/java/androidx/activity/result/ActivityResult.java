package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.C1749r5;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new C1749r5(0);

    /* renamed from: a */
    public final int f535a;

    /* renamed from: b */
    public final Intent f536b;

    public ActivityResult(int i, @Nullable Intent intent) {
        this.f535a = i;
        this.f536b = intent;
    }

    @NonNull
    public static String resultCodeToString(int i) {
        if (i != -1) {
            if (i != 0) {
                return String.valueOf(i);
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getData() {
        return this.f536b;
    }

    public int getResultCode() {
        return this.f535a;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.f535a) + ", data=" + this.f536b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.f535a);
        Intent intent = this.f536b;
        if (intent == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.f535a = parcel.readInt();
        this.f536b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
