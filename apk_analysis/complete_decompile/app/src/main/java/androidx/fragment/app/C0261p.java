package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;

/* renamed from: androidx.fragment.app.p */
/* loaded from: classes.dex */
public final class C0261p implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.FragmentManager$LaunchedFragmentInfo, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f4545a = parcel.readString();
        obj.f4546b = parcel.readInt();
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new FragmentManager.LaunchedFragmentInfo[i];
    }
}
