package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b */
/* loaded from: classes.dex */
public final class C0247b implements Parcelable.Creator {

    /* renamed from: a */
    public final /* synthetic */ int f4649a;

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.fragment.app.FragmentManagerState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f4649a) {
            case 0:
                return new BackStackRecordState(parcel);
            case 1:
                return new BackStackState(parcel);
            case 2:
                ?? obj = new Object();
                obj.f4554e = null;
                obj.f4555f = new ArrayList();
                obj.f4556g = new ArrayList();
                obj.f4550a = parcel.createStringArrayList();
                obj.f4551b = parcel.createStringArrayList();
                obj.f4552c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
                obj.f4553d = parcel.readInt();
                obj.f4554e = parcel.readString();
                obj.f4555f = parcel.createStringArrayList();
                obj.f4556g = parcel.createTypedArrayList(BackStackState.CREATOR);
                obj.f4557h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
                return obj;
            default:
                return new FragmentState(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f4649a) {
            case 0:
                return new BackStackRecordState[i];
            case 1:
                return new BackStackState[i];
            case 2:
                return new FragmentManagerState[i];
            default:
                return new FragmentState[i];
        }
    }
}
